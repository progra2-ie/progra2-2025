/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alvaro Mena
 */
public class EmpleadoTest {
    
   @Test
   public void instanciar_empleado_funciona(){
       // Arrange
       Empleado empleado;
       // Act
       empleado = new Empleado();
       empleado.setIdEmpleado(100);
       empleado.setNombre("Pablo Arias Moya");
       empleado.setSalario(2000000.50f);
       empleado.setFechaNacimiento(LocalDate.of(1982, Month.APRIL, 1));
       
       Departamento departamento = new Departamento();
       departamento.setCodDepto(100);
       departamento.setNombre("Sistemas");
       // agregar el departamento del empleado1
       empleado.setDepartamento(departamento);
       // Assert
       assertNotNull(empleado);
   }
   @Test
   public void toString_funciona(){
       //Arrange
       Empleado empleado = new Empleado();
       Departamento departamento = new Departamento();
       departamento.setCodDepto(100);
       departamento.setNombre("Recursos Humanos");
       empleado.setDepartamento(departamento);
       empleado.setIdEmpleado(1000);
       empleado.setNombre("Julián Fonseca");
       empleado.setSalario(150000F);
       empleado.setFechaNacimiento(LocalDate.of(1978, Month.MARCH, 26));
       // ACT
      String resultadoObtenido = empleado.toString();
      // Assert
      String resultadoEsperado =
              "Empleado{idEmpleado=1000, nombre=Julián Fonseca, "
              + "salario=150000.0, "
              + "departamento=Departamento{codDepto=100, nombre=Recursos Humanos}, "
              + "fechaNacimiento=1978-03-26}";
       assertEquals(resultadoEsperado, resultadoObtenido);
      }
   @Test
   public void equals_dos_empleados_iguales(){
       //Arrange
       Empleado empleado1 = new Empleado();
       Departamento departamento = new Departamento();
       departamento.setCodDepto(100);
       departamento.setNombre("Recursos Humanos");
       empleado1.setDepartamento(departamento);
       empleado1.setIdEmpleado(1000);
       empleado1.setNombre("Julián Fonseca");
       empleado1.setSalario(150000F);
       empleado1.setFechaNacimiento(LocalDate.of(1978, Month.MARCH, 26));
       
       Empleado empleado2 = new Empleado();
       /*Departamento departamento = new Departamento();
       departamento.setCodDepto(100);
       departamento.setNombre("Recursos Humanos");*/
       empleado2.setDepartamento(departamento);
       empleado2.setIdEmpleado(1000);
       empleado2.setNombre("Julián Fonseca");
       empleado2.setSalario(150000F);
       empleado2.setFechaNacimiento(LocalDate.of(1978, Month.MARCH, 26));
       // Act
       boolean resultadoActual = empleado1.equals(empleado2);
       // Assert
       boolean resultadoEsperado = true;
       assertEquals(resultadoEsperado,resultadoActual);
   }
   @Test
   public void equals_dos_empleados_distintos(){
       // TODO
   }
   
}
