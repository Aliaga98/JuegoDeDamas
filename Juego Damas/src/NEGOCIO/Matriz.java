package NEGOCIO;

import java.io.Serializable;

public class Matriz implements Serializable 
{

	public int[][] M; 
	public int Filas;
	public int Columnas;
	
	public Matriz(int filas, int columnas) 
	{
		M= new int [filas][columnas];
		this.Filas= filas;
		this.Columnas= columnas;
	}

	public int obtenerEle(int f, int c) 
	{
		return M[f][c];
	}
	
	public void asignarEle(int ele, int f, int c)
	{
		M[f][c]= ele;
	}

}
