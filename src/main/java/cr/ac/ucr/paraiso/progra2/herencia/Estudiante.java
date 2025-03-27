/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.herencia;

import java.util.Objects;

/**
 *
 * @author Alvaro Mena
 */
public final class Estudiante extends Persona{
    private float notaAdmision;
    private String carrera;

    public Estudiante(float notaAdmision, String carrera, int idPersona, String nombre, String apellidos) {
        
        super(idPersona, nombre, apellidos);
        this.notaAdmision = notaAdmision;
        this.carrera = carrera;
    }

    public float getNotaAdmision() {
        return notaAdmision;
    }

    public void setNotaAdmision(float notaAdmision) {
        this.notaAdmision = notaAdmision;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        // TODO REESCRIBIR
        return  "Estudiante{" + super.toString() + ", notaAdmision=" + notaAdmision + ", carrera=" + carrera + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (this.notaAdmision != other.notaAdmision) {
            return false;
        }
        return Objects.equals(this.carrera, other.carrera) && super.equals(obj);
    }

   
    
    
    
}
