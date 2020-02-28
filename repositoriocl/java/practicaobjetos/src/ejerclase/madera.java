package ejerclase;

public class madera implements Comparable<madera> //para usar el sort en la main y poder ordelaors
{
	private String nombre;
	private String color;
	private String arbol;
	private int densidad;
	private double preciom3;
	private String dureza;
	
	public madera(String nombre, String color, String arbol, int densidad, double preciom3, String dureza)
	{
		this.nombre = nombre;
		this.color = color;
		this.arbol = arbol;
		this.densidad = densidad;
		this.preciom3 = preciom3;
		this.dureza = dureza;
		
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getColor() 
	{
		return color;
	}

	public void setColor(String color) 
	{
		this.color = color;
	}

	public String getArbol() 
	{
		return arbol;
	}

	public void setArbol(String arbol) 
	{
		this.arbol = arbol;
	}

	public int getDensidad() 
	{
		return densidad;
	}

	public void setDensidad(int densidad) 
	{
		this.densidad = densidad;
	}

	public double getpreciom3() 
	{
		return preciom3;
	}

	public void setpreciom3(double preciom3) 
	{
		this.preciom3 = preciom3;
	}

	public String getDureza() 
	{
		return dureza;
	}

	public void setDureza(String dureza) 
	{
		this.dureza = dureza;
	}

	/*public int compareTo(madera a) //comparar nombres y ordenar el array list por nombre.
	{
		return this.getNombre().compareTo(a.getNombre());
	}*/
	
	public int compareTo(madera a) //comparar nombres y luego si los nombres son iguales te los compara por densidad
	{
		
		if(this.nombre.compareTo(a.nombre) == 0)
		{
			if(this.densidad >= a.densidad) return 1;
			else return -1;
		}
		else return this.getNombre().compareTo(a.getNombre());
	}
	
	
	@Override
	public String toString() 
	{
		return nombre + "*" + color + "*" + arbol + "*" + densidad
				+ "*" + preciom3 + "*" + dureza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + densidad;
		result = prime * result + ((dureza == null) ? 0 : dureza.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preciom3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		madera other = (madera) obj;
		if (densidad != other.densidad)
			return false;
		if (dureza == null) {
			if (other.dureza != null)
				return false;
		} else if (!dureza.equals(other.dureza))
			return false;
		if (Double.doubleToLongBits(preciom3) != Double.doubleToLongBits(other.preciom3))
			return false;
		return true;
	}



	
	
	
	

	
	


	
	
	
	
	
}
