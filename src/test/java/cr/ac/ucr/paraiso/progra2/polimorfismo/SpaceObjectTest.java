/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.polimorfismo;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alvaro Mena
 */
public class SpaceObjectTest {
    
  
    /**
     * Test of pintarse method, of class SpaceObject.
     */
    @Test
    public void testPintarse() {
        // Arrange
        List<SpaceObject> spaceObjects = new ArrayList<>();
        spaceObjects.add(new Marciano());
        spaceObjects.add(new NaveEspacial());
        spaceObjects.add(new PistolaLaser());
        spaceObjects.add(new Venuciano());
        
        // Act
        for (SpaceObject spaceObject : spaceObjects) {
            spaceObject.pintarse();
        }
        
    }

  
    
}
