/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.polimorfismo.farm;

import java.util.Collection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alvaro Mena
 */
public class FarmTest {
    /**
     * Test of callAllTheAnimals method, of class Farm.
     */
    @Test
    public void testCallAllTheAnimals() {
        //Arrange
        Farm farm = new Farm();
        farm.getFarmAnimals().add(new Cow());
        farm.getFarmAnimals().add(new Cow());
        farm.getFarmAnimals().add(new Cow());
        farm.getFarmAnimals().add(new Rooster());
        farm.getFarmAnimals().add(new Gato());
        farm.getFarmAnimals().add(new Gato());
        farm.getFarmAnimals().add(new Gato());
        // Act
        farm.callAllTheAnimals();
        
        
    }

   
    
}
