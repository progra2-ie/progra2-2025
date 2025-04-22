/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.ac.ucr.paraiso.progra2.archivos.data;

import cr.ac.ucr.paraiso.progra2.archivosraf.data.EmpleadoData;
import cr.ac.ucr.paraiso.progra2.archivosraf.domain.Empleado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
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
    @Test
    public void findAll_cuando_existen_registros(){
        //Arrange
        String rutaArchivo = "C:\\SW_DEV\\progra2-2025\\empleados.data";
        File file = new File(rutaArchivo);
        if (file.exists())
            file.delete();
        Empleado empleado1 = new Empleado(100, "José Aurelio", "Quesada Alfaro");
        Empleado empleado2 = new Empleado(101, "Daniel", "Olivares");
        // Act
        EmpleadoData empleadoData = null;
        try{
             empleadoData = new EmpleadoData(file);
            empleadoData.insert(empleado1);
            empleadoData.insert(empleado2);
        }catch(FileNotFoundException fnf){
            
        }catch (IOException ex) {
        }
        //Act
        List<Empleado> empleados = null;
        if (empleadoData != null){
            try {
                empleados = empleadoData.findAll();
            } catch (IOException ex) {
            }
        }
        //Assert
        assertNotNull(empleados);
        int cantidadRegistrosEsperados = 2;
        assertEquals(cantidadRegistrosEsperados, empleados.size());
        assertTrue(empleados.contains(empleado2));
        
    }
    @Test
    public void insertInOrder_cuando_nombre_es_menor(){
        //Arrange
        String rutaArchivo = "C:\\SW_DEV\\progra2-2025\\empleados.data";
        File file = new File(rutaArchivo);
        if (file.exists())
            file.delete();
        Empleado empleado1 = new Empleado(100, "José Aurelio", "Quesada Alfaro");
        Empleado empleado2 = new Empleado(101, "Daniel", "Olivares");
        Empleado empleado3 = new Empleado(99, "Carlos", "Vargas Alfaro");
        // Act
        EmpleadoData empleadoData = null;
        try{
            empleadoData = new EmpleadoData(file);
            empleadoData.insertInOrder(empleado1);
            empleadoData.insertInOrder(empleado2);
            empleadoData.insertInOrder(empleado3);
        }catch(FileNotFoundException fnf){
        }catch (IOException ex) {
        }
        //Act
        List<Empleado> empleados = null;
        if (empleadoData != null){
            try {
                empleados = empleadoData.findAll();
            } catch (IOException ex) {
            }
        }
        //Assert
        assertNotNull(empleados);
        int cantidadRegistrosEsperados = 3;
        assertEquals(cantidadRegistrosEsperados, empleados.size());
        assertTrue(empleados.get(0).equals(empleado3));
        assertTrue(empleados.get(1).equals(empleado2));
        assertTrue(empleados.get(2).equals(empleado1));
    }
    @Test
     public void insertInOrder_cuando_nombre_mayor_que_todos(){
        //Arrange
        String rutaArchivo = "C:\\SW_DEV\\progra2-2025\\empleados.data";
        File file = new File(rutaArchivo);
        if (file.exists())
            file.delete();
        Empleado empleado1 = new Empleado(101, "Daniel", "Olivares");
        Empleado empleado2 = new Empleado(100, "José Aurelio", "Quesada Alfaro");
        Empleado empleado3 = new Empleado(99, "Tatiana", "Vargas Alfaro");
        // Act
        EmpleadoData empleadoData = null;
        try{
            empleadoData = new EmpleadoData(file);
            empleadoData.insertInOrder(empleado1);
            empleadoData.insertInOrder(empleado2);
            empleadoData.insertInOrder(empleado3);
        }catch(FileNotFoundException fnf){
        }catch (IOException ex) {
        }
        //Act
        List<Empleado> empleados = null;
        if (empleadoData != null){
            try {
                empleados = empleadoData.findAll();
            } catch (IOException ex) {
            }
        }
        //Assert
        assertNotNull(empleados);
        int cantidadRegistrosEsperados = 3;
        assertEquals(cantidadRegistrosEsperados, empleados.size());
        assertTrue(empleados.get(0).equals(empleado1));
        assertTrue(empleados.get(1).equals(empleado2));
        assertTrue(empleados.get(2).equals(empleado3));
    }
}
