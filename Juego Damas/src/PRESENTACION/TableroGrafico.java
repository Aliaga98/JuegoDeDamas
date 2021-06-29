package PRESENTACION;

import java.awt.*;

import javax.swing.JPanel;

import NEGOCIO.Reglas;
import NEGOCIO.Tablero;

public class TableroGrafico extends JPanel {

	
	public Image imgTablero;
	
	public Tablero tb;
	
	/**
	 * Create the panel.
	 */
	public TableroGrafico(Tablero tb) 
	{
		this.tb= tb;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		
		//PINTA EL TABLERO
		imgTablero= Toolkit.getDefaultToolkit().getImage("Tablero.jpeg");
		g2.drawImage(imgTablero, 0, 0, 600, 600, this);
		
	
		//PINTA LA FICHAS
		int py=9;
		for (int f = 0; f < tb.mtz.Filas; f++) 
		{
			int px=9;
			for (int c = 0; c < tb.mtz.Columnas; c++) 
			{
				if(tb.mtz.obtenerEle(f,c)==Reglas.FICHA_NEGRA)
				{
					Image imgFichaNegra= Toolkit.getDefaultToolkit().getImage("FichaNegra.gif");
					g2.drawImage(imgFichaNegra, px, py, 60, 60, this);
				}
				if(tb.mtz.obtenerEle(f,c)==Reglas.FICHA_BLANCA)
				{
					Image imgFichaBlanca= Toolkit.getDefaultToolkit().getImage("FichaBlanca.gif");
					g2.drawImage(imgFichaBlanca, px, py, 60, 60, this);					
				}
				px= px + 75;
			}
			py= py + 75;
		}
		
		
	}

}
