package practicaobjetos;

public class ejerObjetos 
{
	private String marca;
	private String modelo;
	private String color;
	private int puertas;
	private int ruedas;
	private double precio;

	public ejerObjetos(String m,String mod,String col,int p,int r,double pr)
	{
	marca=m;
	modelo=mod;
	color=col;
	puertas=p;
	ruedas=r;
	precio=pr;
	}




	public String getMarca()
	{
	return marca;
	}

	public String getModelo()
	{
	return modelo;
	}

	public String getColor()
	{
	return color;
	}

	public int getPuertas()
	{
	return puertas;
	}

	public int getRuedas()
	{
	return ruedas;
	}

	public double getPrecio()
	{
	return precio;
	}




	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}//fin metodo HashCode




	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
		return true;
		if (obj == null)
		return false;
		if (getClass() != obj.getClass())
		return false;
		ejerObjetos other = (ejerObjetos) obj;
		if (marca == null) 
		{
		if (other.marca != null)
		return false;
		} 
		else if (!marca.equals(other.marca))
		return false;
		if (modelo == null) 
		{
		if (other.modelo != null)
		return false;
		} 
		else if (!modelo.equals(other.modelo))
		return false;
		
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
		return false;
		return true;
	}




	@Override
	public String toString() 
	{
		return "ejerObjetos [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", puertas=" + puertas
				+ ", ruedas=" + ruedas + ", precio=" + precio + "]";
	}
	
	



	}//fin clase vehiculo
