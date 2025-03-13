/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2;

import java.time.LocalDate;

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
    
    
}
