/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.herencia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alvaro Mena
 */
public class EstudianteTest {
    
  
    @Test
    public void testToString() {
        // Arrange
        Persona estudiante = 
        new Estudiante(600F, "Bachillerato en Informática Empresarial", 100, "Xinia", "Rosales Calderón");
        //Act
        String result = estudiante.toString();
        //Assert
        String expResult = "Estudiante{idPersona=100, nombre=Xinia, apellidos=Rosales Calderón, notaAdmision=600.0, carrera=Bachillerato en Informática Empresarial}";
        assertEquals(expResult, result);
    }
    
}
