package ejerclase2102;

public class clienteHotel implements Comparable<clienteHotel> 
{
	private String nombreHotel;
	private String codigoH;
	private String codigoC;
	private String nombre;
	private String apellido;
	



	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public String getCodigoH() {
		return codigoH;
	}

	public void setCodigoH(String codigoH) {
		this.codigoH = codigoH;
	}

	public String getCodigoC() {
		return codigoC;
	}

	public void setCodigoC(String codigoC) {
		this.codigoC = codigoC;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public int compareTo(clienteHotel a) 
	{
		if(this.nombreHotel.compareTo(a.nombreHotel) == 0)
		{
			if(this.nombre.equals(a.nombre)) return 1;
			else return -1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((codigoC == null) ? 0 : codigoC.hashCode());
		result = prime * result + ((codigoH == null) ? 0 : codigoH.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nombreHotel == null) ? 0 : nombreHotel.hashCode());
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
		clienteHotel other = (clienteHotel) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (codigoC == null) {
			if (other.codigoC != null)
				return false;
		} else if (!codigoC.equals(other.codigoC))
			return false;
		if (codigoH == null) {
			if (other.codigoH != null)
				return false;
		} else if (!codigoH.equals(other.codigoH))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombreHotel == null) {
			if (other.nombreHotel != null)
				return false;
		} else if (!nombreHotel.equals(other.nombreHotel))
			return false;
		return true;
	}

	
}
