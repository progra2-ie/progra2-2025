package cr.ac.ucr.paraiso.progra2.polimorfismo.empleado;

public class EmpleadoPorComision extends Empleado {
	private float montoVentas;
	private float porcentajeComision;
	
	public EmpleadoPorComision(String nombre, String apellidos,
			String numeroSeguroSocial, float montoVentas,
			float porcentajeComision) {
		super(nombre, apellidos, numeroSeguroSocial);
		this.setMontoVentas(montoVentas);
		this.setPorcentajeComision(porcentajeComision);
	}

	@Override
	public float ganancias() {
		return this.montoVentas * (this.porcentajeComision/100); 
	}

	public float getMontoVentas() {
		return montoVentas;
	}

	public void setMontoVentas(float montoVentas) {
		this.montoVentas = montoVentas;
	}

	public float getPorcentajeComision() {
		return porcentajeComision;
	}

	public void setPorcentajeComision(float porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}

}
