package cr.ac.ucr.paraiso.progra2.polimorfismo.empleado;

public abstract class Empleado {
	protected String nombre;
	protected String apellidos;
	protected String numeroSeguroSocial;
	
	public Empleado(String nombre, String apellidos, 
			String numeroSeguroSocial) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numeroSeguroSocial = numeroSeguroSocial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNumeroSeguroSocial() {
		return numeroSeguroSocial;
	}

	public void setNumeroSeguroSocial(String numeroSeguroSocial) {
		this.numeroSeguroSocial = numeroSeguroSocial;
	}
	public abstract float ganancias();

}













