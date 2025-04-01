/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.polimorfismo.empleado;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alvaro Mena
 */
public class EmpleadoTest {
    
       /**
     * Test of ganancias method, of class Empleado.
     */
    @Test
    public void testGanancias() {
        //Arrange 
        Empleado[] empleados = new Empleado[]{
				new EmpleadoPorComision("Juana", "Gonzalez",
						"1010",1000000, 15),
				new EmpleadoPorHora("Carlos", "Mora",
						"1011",41,(float)1000.0)
		};
       // empleados[0].set
        //Act
        for(Empleado empleadoActual : empleados)
			System.out.println(empleadoActual.getNombre() 
					+ " --> " +
					empleadoActual.ganancias());
    }
    
}
