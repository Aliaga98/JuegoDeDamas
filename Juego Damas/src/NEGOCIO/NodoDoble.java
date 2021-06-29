package NEGOCIO;

import java.io.Serializable;

public class NodoDoble implements Serializable
{
	public Object Ele;
	public NodoDoble RefSgte;
	public NodoDoble RefAnt;
	
	public NodoDoble(Object ele) 
	{
		this.Ele= ele;
		this.RefSgte= null;
		this.RefAnt= null;
	}

}
