/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.archivos.data;

import cr.ac.ucr.paraiso.progra2.archivos.domain.Empleado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alvaro Mena
 */
public class EmpleadoDataTest {
   
    @Test
    public void crear_archivo() {
        //Arrange
        String rutaArchivo = "C:\\SW_DEV\\progra2-2025\\empleados.data";
        File file = new File(rutaArchivo);
        if (file.exists())
            file.delete();
        // Act
        try{
            EmpleadoData empleadoData = new EmpleadoData(file);
        }catch(FileNotFoundException fnf){
            
        }
        //Assert
        assertTrue(file.exists());
        
    }
    @Test
    public void insert_al_final_archivo(){
        //Arrange
        String rutaArchivo = "C:\\SW_DEV\\progra2-2025\\empleados.data";
        File file = new File(rutaArchivo);
        if (file.exists())
            file.delete();
        Empleado empleado1 = new Empleado(100, "José Aurelio", "Quesada Alfaro");
        Empleado empleado2 = new Empleado(101, "Daniel", "Olivares");
        // Act
        try{
            EmpleadoData empleadoData = new EmpleadoData(file);
            empleadoData.insert(empleado1);
            empleadoData.insert(empleado2);
        }catch(FileNotFoundException fnf){
            
        }catch (IOException ex) {
        }
         //Assert   
    }
}
