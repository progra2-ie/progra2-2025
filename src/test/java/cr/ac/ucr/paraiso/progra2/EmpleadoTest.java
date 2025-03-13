/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2;

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
       // cómo creo una fecha 
       //empleado.setFechaNacimiento();
       Departamento departamento = new Departamento();
       departamento.setCodDepto(100);
       departamento.setNombre("Sistemas");
       empleado.setDepartamento(departamento);
       // Assert
       assertNotNull(empleado);
   }
}
