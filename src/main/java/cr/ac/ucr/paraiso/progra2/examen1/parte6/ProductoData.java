package cr.ac.ucr.paraiso.progra2.examen1.parte6;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class ProductoData {
    private RandomAccessFile raf;
    private final int TAMANO_REGISTRO = 62;
    private final int TAMANO_NOMBRE = 50;
    private final int TAMANO_CODIGO_PRODUCTO = 4;
    private final int TAMANO_PRECIO = 4;
    private final int TAMANO_CANTIDAD_EXISTENTE = 4;

    public ProductoData(File file) throws FileNotFoundException {
        raf = new RandomAccessFile(file, "rw");
    }
    public Producto buscar(int productoId)
            throws IOException{
        boolean encontrado = false;
        int totalRegistros = (int)(raf.length()/TAMANO_REGISTRO);
        int numReg=0;
        Producto producto = null;
        while(numReg<totalRegistros && !encontrado){
            raf.seek(numReg * TAMANO_REGISTRO);
            String nombreProducto = this.readString(TAMANO_NOMBRE, raf.getFilePointer());
            int productoIdActual = raf.readInt();
            if(productoId == productoIdActual){
                encontrado = true;
                producto = new Producto();
                producto.setProductoId(productoIdActual);
                producto.setNombre(nombreProducto);
                producto.setPrecio(raf.readFloat());
                producto.setCantidadExistente(raf.readInt());
            }
            else numReg++;
        }
        return producto;
    }//buscar
 /*
     * Lee un String en el archivo
     * @param tamanoString
     * @param posicion
     */
   private String readString(int tamanoString, long posicion) throws IOException{
        raf.seek(posicion);
        byte[] datos = new byte[tamanoString];
        raf.readFully(datos);
        String dato = new String(datos).trim();
        return dato;

    }//readString
   
    private byte[] toBytes(String dato, int tamanoString){
        byte[] datos = new byte[tamanoString];
            byte[] temp = dato.getBytes();
            for (int i = 0; i < tamanoString; i++) {
                if (i<temp.length)
                datos[i] =temp[i];
            }
        return datos;
    }

    public ArrayList<Producto> findAll() throws IOException {
        int totalRegistros = (int)(raf.length()/TAMANO_REGISTRO);
        ArrayList<Producto> productos = new ArrayList<Producto>();
        for(int i=0; i<totalRegistros; i++){
            raf.seek(i*TAMANO_REGISTRO);
            String nombre = this.readString(TAMANO_NOMBRE,
                    raf.getFilePointer());
            int idProducto = raf.readInt();
            float precio = raf.readFloat();
            int cantidad = raf.readInt();
            productos.add(new Producto(idProducto,nombre,precio,cantidad));
        }//for
        return productos;
    }

    /* inserta el final del archivo */
    public void insert(Producto producto) throws IOException {
        //aumentar el tamaño del archivo en 64 bytes (TAMAÑO_REGISTRO)
        raf.setLength(raf.length() + TAMANO_REGISTRO);
        raf.seek(raf.length() - TAMANO_REGISTRO);

        // Se debe transformar el string en un arreglo de bytes para
        // poder escribirlo en el archivo
        byte nombre[] = toBytes(producto.getNombre(),TAMANO_NOMBRE);
        raf.write(nombre);
        raf.writeInt(producto.getProductoId());
        raf.writeFloat(producto.getPrecio());
        raf.writeInt(producto.getCantidadExistente());
    }
    

   
}