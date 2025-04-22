package cr.ac.ucr.paraiso.progra2.archivosraf.data;


import cr.ac.ucr.paraiso.progra2.archivosraf.domain.Empleado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class EmpleadoData  {
    private RandomAccessFile raf;
    private final int TAMANO_REGISTRO = 64;
    private final int TAMANO_ID_EMPLEADO = 4;
    private final int TAMANO_NOMBRE = 30;
    private final int TAMANO_APELLIDOS = 30;

    /* Empleado = {{idEmpleado, int, 4},
     * 			   {nombre, String, 30},
     * 			   {apellidos, String, 30}
     */

    public EmpleadoData(File file) throws FileNotFoundException {
        raf = new RandomAccessFile(file, "rw");
    }

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

    public ArrayList<Empleado> findAll() throws IOException {
        int totalRegistros = (int)(raf.length()/TAMANO_REGISTRO);
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        for(int i=0; i<totalRegistros; i++){
            raf.seek(i*TAMANO_REGISTRO);
            int idEmp = raf.readInt();
            String nombre = this.readString(TAMANO_NOMBRE,
                    raf.getFilePointer());
            String apellidos = this.readString(TAMANO_APELLIDOS,
                    raf.getFilePointer());
            empleados.add(new Empleado(idEmp,nombre, apellidos));
        }//for
        return empleados;
    }

    /* inserta el final del archivo */
    public void insert(Empleado empleado) throws IOException {
        //aumentar el tamaño del archivo en 64 bytes (TAMAÑO_REGISTRO)
        raf.setLength(raf.length() + TAMANO_REGISTRO);
        raf.seek(raf.length() - TAMANO_REGISTRO);
        raf.writeInt(empleado.getIdEmpleado());
        // Se debe transformar el string en un arreglo de bytes para
        // poder escribirlo en el archivo
        byte nombre[] = toBytes(empleado.getNombre(),TAMANO_NOMBRE);
        raf.write(nombre);
        byte apellidos[]= toBytes(empleado.getApellidos(),TAMANO_APELLIDOS);
        raf.write(apellidos);
    }
    public void insertInOrder(Empleado empleado) throws IOException{
        // crear un ciclo while que me permita recorrer el archivo, registro por registro
        // + bandera para salirme del ciclo cuando se haya insertado el empleado
        int i = 0;
        int totalRegistros = (int)raf.length()/TAMANO_REGISTRO;
        boolean insertado = false;
        while(i<totalRegistros && insertado == false){
            raf.seek(i*TAMANO_REGISTRO);
            raf.skipBytes(TAMANO_ID_EMPLEADO);
            String nombreActual = this.readString(TAMANO_NOMBRE, raf.getFilePointer());
            if (empleado.getNombre().compareToIgnoreCase(nombreActual)<0){
                //TODO insertar antes de i
                raf.setLength(raf.length()+TAMANO_REGISTRO);
                for (int j = totalRegistros-1; j >= i; j--) {
                    raf.seek(j*TAMANO_REGISTRO);
                    byte[] registroActual = new byte[TAMANO_REGISTRO];
                    raf.readFully(registroActual);
                    raf.write(registroActual);
                }
                raf.seek(i*TAMANO_REGISTRO);
                raf.writeInt(empleado.getIdEmpleado());
                byte[] nombre = toBytes(empleado.getNombre(), TAMANO_NOMBRE);
                raf.write(nombre);
                byte[] apellidos = toBytes(empleado.getApellidos(), TAMANO_APELLIDOS);
                raf.write(apellidos);
                insertado = true;
            }//if
            else i++;
        }//while
        if (!insertado){
            raf.setLength(raf.length()+TAMANO_REGISTRO);
            //raf.seek(raf.length()-TAMANO_REGISTRO);
            raf.seek(i*TAMANO_REGISTRO);
            raf.writeInt(empleado.getIdEmpleado());
            byte[] nombre = toBytes(empleado.getNombre(), TAMANO_NOMBRE);
            raf.write(nombre);
            byte[] apellidos = toBytes(empleado.getApellidos(), TAMANO_APELLIDOS);
            raf.write(apellidos);
        }
    }
    
    
    
  /*  public boolean buscar(int idEmpleadoBuscado)
            throws IOException{
        boolean encontrado = false;
        super.length();
        int totalRegistros = (int)(this.length()/TAMANO_REGISTRO);
        int numReg=0;
        while(numReg<totalRegistros && !encontrado){
            this.seek(numReg * TAMANO_REGISTRO);
            int idEmpleadoActual = this.readInt();
            if(idEmpleadoBuscado == idEmpleadoActual)
                encontrado = !encontrado;
            else numReg++;

        }
        return encontrado;
    }//buscar*/
   
}