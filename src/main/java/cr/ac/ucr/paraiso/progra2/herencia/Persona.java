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
public abstract class Persona {
    protected int idPersona;
    protected String nombre;
    protected String apellidos;

    public Persona(int idPersona, String nombre, String apellidos) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    @Override
    public String toString() {
        return "idPersona=" + idPersona + ", nombre=" + nombre + ", apellidos=" + apellidos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Persona other = (Persona) obj;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        return Objects.equals(this.getNombre(), other.nombre) && Objects.equals(this.apellidos, other.apellidos);
    }
    
}
