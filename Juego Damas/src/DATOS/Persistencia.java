package DATOS;

import java.io.*;

public class Persistencia implements Serializable
{
	public Persistencia() 
	{
	 	
	}
	
	public void guardarObjeto(Object objeto)
	{
		try 
		{
			//CREA FLUJO DE ARCHIVO EN MEMORIA QUE SE CONECTA CON DIRECCION DONDE SE CREARA EL ARCHIVO .txt o bin 
			FileOutputStream flujoArchivo= new FileOutputStream("D:\\JuegoDamas.bin");
			//CREA EL ADM. DE OBJETOS PARA TRABAJAR CON EL ARCHIVO
			ObjectOutputStream flujoObjeto= new ObjectOutputStream(flujoArchivo);
			//ESCRIBE EL OBJETO EN DISCO
			flujoObjeto.writeObject(objeto);
			//CIERRA EL FLUJO DE OBJETO
			flujoObjeto.close();
			//CIERRA EL FLUJO DE ARCHIVO
			flujoArchivo.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public Object recuperarObjeto()
	{
		try 
		{
			//CREA FLUJO DE ARCHIVO DE ENTRADA EN MEMORIA QUE SE CONECTA CON DIRECCION DEL ARCHIVO 
			FileInputStream flujoArchivo= new FileInputStream("D:\\JuegoDamas.bin");
			//CREA EL ADM. DE OBJETOS DE ENTRADA PARA LEER EL ARCHIVO EXISTENTE
			ObjectInputStream flujoObjeto= new ObjectInputStream(flujoArchivo);
			//LEE Y RECUPERA EL OBJETO DEL DISCO DURO
			Object objeto= flujoObjeto.readObject();
			//CIERRA EL FLUJO DE OBJETO
			flujoObjeto.close();
			//CIERRA EL FLUJO DE ARCHIVO
			flujoArchivo.close();
			
			return objeto;
		} 
		catch (Exception e) 
		{
			return null;
		}
	}

}
