/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.domain;

import java.util.Objects;

/**
 *
 * @author Alvaro Mena
 */
public class Departamento {
    private int codDepto;
    private String nombre;

    public Departamento() {
        
    }

    public Departamento(int codDepto, String nombre) {
        this.codDepto = codDepto;
        this.nombre = nombre;
    }

    public int getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(int codDepto) {
        this.codDepto = codDepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codDepto=" + codDepto + ", nombre=" + nombre + '}';
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
        final Departamento other = (Departamento) obj;
        if (this.codDepto != other.codDepto) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
          
    
}
