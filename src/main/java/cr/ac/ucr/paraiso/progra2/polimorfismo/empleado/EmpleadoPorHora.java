package cr.ac.ucr.paraiso.progra2.polimorfismo.empleado;

public final class EmpleadoPorHora extends Empleado {
	private float horasTrabajadas;
	private float salarioPorHora;
	
	public EmpleadoPorHora(String nombre, String apellidos,
			String numeroSeguroSocial, float horasTrabajadas,
			float salarioPorHora) {
		super(nombre, apellidos, numeroSeguroSocial);
		this.setSalarioPorHora(salarioPorHora);
		this.setHorasTrabajadas(horasTrabajadas);
	}

	@Override
	public float ganancias() {
		if (this.horasTrabajadas <= 40)
			return this.horasTrabajadas*this.salarioPorHora;
		else
			return (40 * this.salarioPorHora) +
				   ((this.horasTrabajadas-40)*
				   (this.salarioPorHora*(float)1.5));
	}

	public float getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(float horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public float getSalarioPorHora() {
		return salarioPorHora;
	}

	public void setSalarioPorHora(float salarioPorHora) {
		this.salarioPorHora = salarioPorHora;
	}
	
}
