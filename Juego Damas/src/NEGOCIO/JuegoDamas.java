package NEGOCIO;

import java.io.Serializable;

public class JuegoDamas implements Serializable
{

	public Tablero tb;
	public Jugador jg1;
	public Jugador jg2;
	public int turno;
	
	public JuegoDamas() 
	{
		tb= new Tablero();
		jg1= new Jugador();
		jg2= new Jugador();
		turno= Reglas.COLOR_NEGRO;
	}
	
	public void cambiarTurno()
	{
		if(turno==Reglas.COLOR_NEGRO)
			turno= Reglas.COLOR_BLANCO;
		else
			turno= Reglas.COLOR_NEGRO;
	}
	
}
