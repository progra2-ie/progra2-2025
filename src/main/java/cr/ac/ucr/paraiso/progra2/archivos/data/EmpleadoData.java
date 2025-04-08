package cr.ac.ucr.paraiso.progra2.archivos.data;


import cr.ac.ucr.paraiso.progra2.archivos.domain.Empleado;
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

   /* public boolean delete(int idEmpleadoBuscado)
            throws IOException{
        boolean encontrado = false;
        int totalRegistros = (int)(this.length()/TAMANO_REGISTRO);
        int numReg=0;
        int regPorBorrar = -1;
        while(numReg<totalRegistros && !encontrado){
            this.seek(numReg * TAMANO_REGISTRO);
            int idEmpleadoActual = this.readInt();
            if(idEmpleadoBuscado == idEmpleadoActual) {
                encontrado = !encontrado;
                regPorBorrar = numReg;
            }else numReg++;
        }
        if ((numReg<totalRegistros-1) && encontrado){ //estoy ubicado en el penúltimo registro

            //SACAR LOS DATOS DEL REGISTRO?
            int indice = regPorBorrar+1;
            this.seek((indice)*TAMANO_REGISTRO);
            while (indice<totalRegistros) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(this.readInt());
                empleado.setNombre(this.readString(TAMANO_NOMBRE, this.getFilePointer()));
                empleado.setApellidos(this.readString(TAMANO_APELLIDOS, this.getFilePointer()));
                this.seek(indice-1 * TAMANO_REGISTRO);
                this.writeInt(empleado.getIdEmpleado());
                this.write(toBytes(empleado.getNombre(), TAMANO_NOMBRE));
                this.write(toBytes(empleado.getApellidos(), TAMANO_APELLIDOS));
                indice++;
            }
            this.setLength(this.length() - TAMANO_REGISTRO);

        }else { //el registro por borrar es el último
            this.setLength(this.length() - TAMANO_REGISTRO);
        }
        return encontrado;
    }//buscar*/
    /*
     * Inserta un empleado en el archivo. El nuevo empleado no puede
     * tener una identificacion igual a uno que ya exista. Los registros
     * estan ordenados alfabeticamente por nombre
     */
   /* public void insertarEmpleado(Empleado empInsertar)
            throws IOException, EmpleadoExistenteException  {
        boolean encontrado = this.buscar(empInsertar.getIdEmpleado());
        if (encontrado)
            throw new EmpleadoExistenteException();
        else{
            boolean insertado = false;
            int totalRegistros = (int)(this.length()/TAMANO_REGISTRO);
            int numReg=0;
            while(numReg<totalRegistros && !insertado){
                this.seek(numReg * TAMANO_REGISTRO);
                this.skipBytes(TAMANO_ID_EMPLEADO);
                String nombreActual =
                        readString(TAMANO_NOMBRE, this.getFilePointer());
                if(empInsertar.getNombre().compareTo(nombreActual)<=0){
                    this.setLength(this.length()+ TAMANO_REGISTRO);
                    // mover los registros hacia el final
                    for (int i= totalRegistros-1; i>=numReg; i--){
                        this.seek(i*TAMANO_REGISTRO);
                        byte[] registroX = new byte[TAMANO_REGISTRO];
                        this.readFully(registroX);
                        // USUARIOS CONCURRENTES.. HAY QUE TENER MAS CUIDADO
                        this.write(registroX);
                    }// for
                    // Guardar el nuevo registro
                    this.seek(numReg * TAMANO_REGISTRO);
                    this.writeInt(empInsertar.getIdEmpleado());
                    this.write(
                            toBytes(empInsertar.getNombre(),
                                    TAMANO_NOMBRE));
                    this.write(
                            toBytes(empInsertar.getApellidos(),
                                    TAMANO_APELLIDOS));
                    insertado = true;
                }else ++numReg;
            }//while
            if(!insertado){
                this.setLength(this.length()+ TAMANO_REGISTRO);
                this.seek(this.length()-TAMANO_REGISTRO);
                this.writeInt(empInsertar.getIdEmpleado());
                this.write(
                        toBytes(empInsertar.getNombre(),
                                TAMANO_NOMBRE));
                this.write(
                        toBytes(empInsertar.getApellidos(),
                                TAMANO_APELLIDOS));
            }
        }//else

    }//insertarEmpleado*/

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
}