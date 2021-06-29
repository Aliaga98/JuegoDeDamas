package NEGOCIO;

import java.io.Serializable;

public class Reglas implements Serializable
{
	
	public static int COLOR_NEGRO=1;
	public static int COLOR_BLANCO=2;
	
	public static int VACIO=0;
	public static int FICHA_NEGRA=1;
	public static int FICHA_BLANCA=2;
	public static int REINA_NEGRA=3;
	public static int REINA_BLANCA=4;
	
	public Reglas() {
		
	}
	
	public static boolean movPermitido(int fp, int cp, int fl, int cl, Matriz mtz)
	{
		if(mtz.obtenerEle(fp, cp)!=Reglas.VACIO && mtz.obtenerEle(fl, cl)==Reglas.VACIO && fp-1==fl && (cp-1==cl || cp+1==cl))
		{
			return true;
		}
		if(mtz.obtenerEle(fp, cp)!=Reglas.VACIO && mtz.obtenerEle(fl, cl)==Reglas.VACIO && fp+1==fl && (cp-1==cl || cp+1==cl))
		{
			return true;
		}
		return false;
	}
	
	public static boolean comidaPermitida(int fp, int cp, int fl, int cl, Matriz mtz)
	{
		return true;
	}

}
