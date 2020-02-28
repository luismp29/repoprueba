package ejerComparaciones;

public class Comparaciones 
{

	public static void main(String[] args) 
	{
		Integer a1,a2;
		a1=34; a2=20;
		
		String c1,c2;
		c1="Martes"; c2="Martes";
		
		if(a1>a2) System.out.println("a1 es igual o mayor que a2");
		else System.out.println("a2 es mayor que a1");
		
		if(c1.equals(c2)) System.out.println("la cadena c1 es igual a c2");
		else System.out.println("la cadena c1 es distinta a c2");
		
		if(c1==c2) System.out.println("Verdadero");
		else System.out.println("Falso");

	}

}
