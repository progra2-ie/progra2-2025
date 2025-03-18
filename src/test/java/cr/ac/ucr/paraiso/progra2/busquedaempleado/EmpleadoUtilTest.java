/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.busquedaempleado;

import cr.ac.ucr.paraiso.progra2.domain.Departamento;
import cr.ac.ucr.paraiso.progra2.domain.Empleado;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alvaro Mena
 */
public class EmpleadoUtilTest {
    
    public EmpleadoUtilTest() {
    }

    /**
     * Test of buscarEmpleado method, of class EmpleadoUtil.
     */
    @Test
    public void buscar_empleado_existente() {
        // Arrange
        Empleado[] empleados = new Empleado[3];
        empleados[0] = new Empleado(100, "Julián Umaña", 1000000f, new Departamento(1, "Finanzas"), LocalDate.now());
        empleados[1] = new Empleado(150, "Daniela Rojas", 1000000f, new Departamento(2, "Recursos Humanos"), LocalDate.now());
        empleados[2] = new Empleado(175, "Uriel Ayales", 1000000f, new Departamento(5, "TI"), LocalDate.now());
        int idEmpleadoBuscado = 150;
        // Act
        int resultadoObtenido = EmpleadoUtil.buscarEmpleado(empleados, idEmpleadoBuscado);
        
        // Assert
        int resultadoEsperado = 1;
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
}
