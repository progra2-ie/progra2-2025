/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Alvaro Mena
 */
public class Empleado {

    private int idEmpleado;
    private String nombre;
    private float salario;
    private Departamento departamento;
    private LocalDate fechaNacimiento;

    public Empleado() {
        this.departamento = new Departamento();
        this.fechaNacimiento = LocalDate.now();
    }

    public Empleado(int idEmpleado, String nombre, float salario, 
            Departamento departamento, LocalDate fechaNacimiento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
        this.fechaNacimiento=fechaNacimiento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + 
                ", nombre=" + nombre + 
                ", salario=" + salario + 
                ", departamento=" + departamento +
                ", fechaNacimiento=" + fechaNacimiento + '}';
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
        final Empleado other = (Empleado) obj;
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        if (Float.floatToIntBits(this.salario) != Float.floatToIntBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }
    
    
}
