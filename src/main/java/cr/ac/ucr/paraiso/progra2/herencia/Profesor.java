/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.herencia;

/**
 *
 * @author Alvaro Mena
 */
public class Profesor extends Persona{
    private float salario;
    private float tiempoDedicacion;

    public Profesor(float salario, float tiempoDedicacion, int idPersona, String nombre, String apellidos) {
        super(idPersona, nombre, apellidos);
        this.salario = salario;
        this.tiempoDedicacion = tiempoDedicacion;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getTiempoDedicacion() {
        return tiempoDedicacion;
    }

    public void setTiempoDedicacion(float tiempoDedicacion) {
        this.tiempoDedicacion = tiempoDedicacion;
    }

    @Override
    public String toString() {
        // TODO REESCRIBIR
        return "Profesor{" + "salario=" + salario + ", tiempoDedicacion=" + tiempoDedicacion + '}';
    }

    
    
    
}
