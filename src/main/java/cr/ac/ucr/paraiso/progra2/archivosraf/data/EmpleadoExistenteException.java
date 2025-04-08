package cr.ac.ucr.paraiso.progra2.archivosraf.data;

public class EmpleadoExistenteException extends Exception {

    public EmpleadoExistenteException() {
        super("Un empleado con esta identificación ya existe");
    }

    public EmpleadoExistenteException(String mensaje) {
        super(mensaje);

    }

}
