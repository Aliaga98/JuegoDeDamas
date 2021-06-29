package NEGOCIO;

import java.io.Serializable;

public class MatrizBitwase implements Serializable
{
	public int[] VecFilas; 
	public int Filas;
	public int Columnas;
	
	public MatrizBitwase(int filas, int columnas) 
	{
		VecFilas= new int [filas];
		this.Filas= filas;
		this.Columnas= columnas;
	}

	public int obtenerEle(int f, int c) 
	{
		int eleFila= VecFilas[f];
		
		eleFila= eleFila << 29-(c*3);
		eleFila= eleFila >>> 29;
		return eleFila;
	}
	
	public void asignarEle(int ele, int f, int c)
	{
		// LIMPIAR LOS BITS
		int mk=7;
		mk= mk<<(c*3);
		mk= ~mk;
		
		int eleFila= VecFilas[f];
		eleFila= eleFila & mk;
		
		ele= ele << (c*3);
		eleFila= eleFila | ele;
		
		VecFilas[f]= eleFila;
	}
}
