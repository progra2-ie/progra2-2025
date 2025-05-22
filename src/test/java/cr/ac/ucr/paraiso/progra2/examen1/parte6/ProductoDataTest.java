package cr.ac.ucr.paraiso.progra2.examen1.parte6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoDataTest {

    private static final String TEST_FILE_NAME = "c:/MyStuff/productos_test.dat";
    private File testFile;
    private ProductoData productoData;

    @BeforeEach
    void setUp() throws IOException {
        testFile = new File(TEST_FILE_NAME);
        // Asegurarse de que el archivo no exista antes de cada prueba
        Files.deleteIfExists(testFile.toPath());
        productoData = new ProductoData(testFile);
    }

    @Test
    void testInsert() throws IOException {
        System.out.println("Running testInsert...");
        Producto p1 = new Producto(1, "Laptop XYZ", 1200.50f, 10);
        productoData.insert(p1);

        // Verificar el tamaño del archivo
        assertEquals(62, testFile.length(), "El tamaño del archivo debe ser 62 después de una inserción.");

        // Intentar leer el producto insertado para verificar su contenido
        // Esto depende de que buscar() funcione correctamente, pero es una buena primera verificación.
        Producto foundProduct = productoData.buscar(1);
        assertNotNull(foundProduct, "El producto insertado no debería ser nulo al buscarlo.");
        assertEquals(p1.getProductoId(), foundProduct.getProductoId());
        assertEquals(p1.getNombre().trim(), foundProduct.getNombre().trim()); // .trim() para quitar espacios finales
        assertEquals(p1.getPrecio(), foundProduct.getPrecio(), 0.001f); // Usar delta para float
        assertEquals(p1.getCantidadExistente(), foundProduct.getCantidadExistente());

        // Insertar otro producto
        Producto p2 = new Producto(2, "Mouse Inalambrico", 25.99f, 50);
        productoData.insert(p2);
        assertEquals(62 * 2, testFile.length(), "El tamaño del archivo debe ser 124 después de dos inserciones.");
    }

    @Test
    void testFindAll() throws IOException {
        System.out.println("Running testFindAll...");
        // Insertar algunos productos de prueba
        Producto p1 = new Producto(1, "Teclado Mecanico", 80.00f, 15);
        Producto p2 = new Producto(2, "Monitor Curvo 27", 350.75f, 5);
        Producto p3 = new Producto(3, "Webcam HD", 45.00f, 30);

        productoData.insert(p1);
        productoData.insert(p2);
        productoData.insert(p3);

        List<Producto> productos = productoData.findAll();

        assertNotNull(productos, "La lista de productos no debe ser nula.");
        assertEquals(3, productos.size(), "Debería haber 3 productos en la lista.");

        // Verificar un caso con archivo vacío
        Files.deleteIfExists(testFile.toPath()); // Eliminar el archivo
        productoData = new ProductoData(testFile); // Recrear ProductoData con archivo vacío
        List<Producto> emptyProducts = productoData.findAll();
        assertNotNull(emptyProducts, "La lista de productos no debe ser nula si el archivo está vacío.");
        assertTrue(emptyProducts.isEmpty(), "La lista de productos debe estar vacía si el archivo está vacío.");
    }

    @Test
    void testBuscar() throws IOException {
        System.out.println("Running testBuscar...");
        Producto p1 = new Producto(101, "Auriculares Bluetooth", 99.99f, 20);
        Producto p2 = new Producto(102, "Disco Duro Externo", 75.50f, 12);
        Producto p3 = new Producto(103, "Impresora Laser", 250.00f, 8);

        productoData.insert(p1);
        productoData.insert(p2);
        productoData.insert(p3);

        // Buscar un producto existente
        Producto foundP2 = productoData.buscar(102);
        assertNotNull(foundP2, "El producto con ID 102 debería ser encontrado.");
        assertEquals(p2.getProductoId(), foundP2.getProductoId());
        assertEquals(p2.getNombre().trim(), foundP2.getNombre().trim());
        assertEquals(p2.getPrecio(), foundP2.getPrecio(), 0.001f);
        assertEquals(p2.getCantidadExistente(), foundP2.getCantidadExistente());

        // Buscar el primer producto
        Producto foundP1 = productoData.buscar(101);
        assertNotNull(foundP1, "El producto con ID 101 debería ser encontrado.");
        assertEquals(p1.getProductoId(), foundP1.getProductoId());
        assertEquals(p1.getNombre().trim(), foundP1.getNombre().trim());
        assertEquals(p1.getPrecio(), foundP1.getPrecio(), 0.001f);
        assertEquals(p1.getCantidadExistente(), foundP1.getCantidadExistente());

        // Buscar el último producto
        Producto foundP3 = productoData.buscar(103);
        assertNotNull(foundP3, "El producto con ID 103 debería ser encontrado.");
        assertEquals(p3.getProductoId(), foundP3.getProductoId());
        assertEquals(p3.getNombre().trim(), foundP3.getNombre().trim());
        assertEquals(p3.getPrecio(), foundP3.getPrecio(), 0.001f);
        assertEquals(p3.getCantidadExistente(), foundP3.getCantidadExistente());

        // Buscar un producto que no existe
        Producto notFoundProduct = productoData.buscar(999);
        assertNull(notFoundProduct, "Un producto con ID 999 no debería ser encontrado.");

        // Buscar en un archivo vacío
        Files.deleteIfExists(testFile.toPath()); // Eliminar el archivo
        productoData = new ProductoData(testFile); // Recrear ProductoData con archivo vacío
        Producto foundInEmpty = productoData.buscar(1);
        assertNull(foundInEmpty, "No se debería encontrar un producto en un archivo vacío.");
    }
}
