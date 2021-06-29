package PRESENTACION;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.beans.finder.PersistenceDelegateFinder;
import com.sun.javafx.geom.Rectangle;

import DATOS.Persistencia;
import NEGOCIO.JuegoDamas;
import NEGOCIO.Reglas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class FormJuegoDamas extends JFrame {

	private JPanel contentPane;
	
	public JuegoDamas jgDamas= new JuegoDamas();
	public Persistencia persiste= new Persistencia();

	private TableroGrafico tableroGraf;
	
	public int fp;
	public int cp;

	private JButton btnRecuperar;

	private JButton btnGuardar;
	private JButton btnNuevo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormJuegoDamas frame = new FormJuegoDamas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormJuegoDamas() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) 
			{
				int xe=me.getX();
				int ye=me.getY();
				
				System.out.println("PRESIONADO:"+xe+"---"+ye);
				
				int px=180;
				int py=30;
				
				for (int f = 0; f < jgDamas.tb.mtz.Filas; f++) 
				{
					px=180;
					for (int c = 0; c < jgDamas.tb.mtz.Columnas; c++) 
					{
						Rectangle rec= new Rectangle(px, py, 75, 75);
						if(rec.contains(xe, ye))
						{
							fp= f;
							cp= c;
						}
						px+=75;
					}
					py+=75;
				}
				
			}
			@Override
			public void mouseReleased(MouseEvent me) 
			{
				int xe=me.getX();
				int ye=me.getY();
				
				System.out.println("LEVANTADO:"+xe+"---"+ye);
				
				int px=180;
				int py=30;
				for (int f = 0; f < jgDamas.tb.mtz.Filas; f++) 
				{
					px=180;
					for (int c = 0; c < jgDamas.tb.mtz.Columnas; c++) 
					{
						Rectangle rec= new Rectangle(px, py, 75, 75);
						if(rec.contains(xe, ye))
						{
							if(Reglas.movPermitido(fp, cp, f, c, jgDamas.tb.mtz))
							{
								jgDamas.tb.mtz.asignarEle(Reglas.VACIO, fp, cp);
								
								jgDamas.tb.mtz.asignarEle(jgDamas.turno, f, c);
								jgDamas.cambiarTurno();
								tableroGraf.repaint();
							}
							if(Reglas.comidaPermitida(fp, cp, f, c, jgDamas.tb.mtz))
							{
								 
							}
						}
						px+=75;
					}
					py+=75;
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("ARCHIVO");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmGuardar = new JMenuItem("GUARDAR");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				persiste.guardarObjeto(jgDamas);
			}
		});
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmRecuperar = new JMenuItem("RECUPERAR");
		mntmRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				jgDamas= (JuegoDamas)persiste.recuperarObjeto();
				tableroGraf.repaint();
			}
		});
		mnArchivo.add(mntmRecuperar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableroGraf = new TableroGrafico(jgDamas.tb);
		tableroGraf.setBackground(Color.GREEN);
		tableroGraf.setBounds(170, 0, 600, 600);
		contentPane.add(tableroGraf);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				persiste.guardarObjeto(jgDamas);
			}
		});
		btnGuardar.setBounds(27, 22, 89, 23);
		contentPane.add(btnGuardar);
		
		btnRecuperar = new JButton("RECUPERAR");
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				jgDamas= (JuegoDamas)persiste.recuperarObjeto();
				tableroGraf.tb= jgDamas.tb;
				tableroGraf.repaint();
			}
		});
		btnRecuperar.setBounds(27, 56, 89, 23);
		contentPane.add(btnRecuperar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				jgDamas= new JuegoDamas();
				tableroGraf.tb= jgDamas.tb;
				tableroGraf.repaint();
			}
		});
		btnNuevo.setBounds(27, 90, 89, 23);
		contentPane.add(btnNuevo);
		
		tableroGraf.repaint();
		
		this.setExtendedState(MAXIMIZED_BOTH);
	}
}
