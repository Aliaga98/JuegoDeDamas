/**
 * 
 */
package NEGOCIO;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @author LABD-DOCENTE
 *
 */
public class Lista implements Serializable
{

	public NodoDoble Primero;
	public NodoDoble Vista;
	public NodoDoble Ultimo;
	/**
	 * 
	 */
	public Lista() 
	{
		this.Primero= null;
		this.Vista= null;
		this.Ultimo= null;
	}

	public boolean estaVacio()
	{
		return (Primero==null);
	}
	
	public boolean existeUnElemento()
	{
		return (Primero==Ultimo);
	}
	
	public void agregarPrimero(NodoDoble nd)
	{
		if(estaVacio())
		{
			Primero= nd;
			Vista=nd;
			Ultimo= nd;
		}
		else
		{
			nd.RefSgte= Primero;
			Primero.RefAnt= nd;
			Primero= nd;
			Vista= nd;
		}
	}
	
	public NodoDoble remover(int pos)
	{
		NodoDoble nd= null;
		if(existeUnElemento())
		{
			nd= Primero;
			Primero= Vista= Ultimo= null;
		}
		else
		{
			if(pos==1)
			{
				nd= Primero;
				Primero.RefSgte.RefAnt= null;
				Primero= Primero.RefSgte;
				Vista= Primero;
			}
			else
			{
				if(pos==cantElementos())
				{
					nd= Ultimo;
					Ultimo.RefAnt.RefSgte=null;
					Ultimo= Ultimo.RefAnt;
				}
				else
				{
					int cont=1;
					while(Vista!=null)
					{
						if(pos==cont)
						{
							nd= Vista;
							Vista.RefSgte.RefAnt= Vista.RefAnt;
							Vista.RefAnt.RefSgte= Vista.RefSgte;
						}
						cont++;
						Vista= Vista.RefSgte;
					}
					Vista= Primero;
				}
			}
		}
		return nd;
	}
	
	public int cantElementos()
	{
		int cont=0;
		while(Vista!=null)
		{
			Vista= Vista.RefSgte;
			cont++;
		}
		Vista= Primero;
		return cont;
	}
	

	public void agregarUltimo(NodoDoble nd) 
	{
		if(estaVacio())
		{
			Primero= nd;
			Vista=nd;
			Ultimo= nd;
		}
		else
		{
			nd.RefAnt= Ultimo;
			Ultimo.RefSgte= nd;
			Ultimo= nd;
		}
	}

}
