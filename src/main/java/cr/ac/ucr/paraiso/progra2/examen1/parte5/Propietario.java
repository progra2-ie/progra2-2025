package cr.ac.ucr.paraiso.progra2.examen1.parte5;

import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private String nombre;
    private String apellidos;
    private List<Vehiculo> vehiculosEnPropiedad;

    public Propietario() {
        this.vehiculosEnPropiedad = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Vehiculo> getVehiculosEnPropiedad() {
        return vehiculosEnPropiedad;
    }

    public void setVehiculosEnPropiedad(List<Vehiculo> vehiculosEnPropiedad) {
        this.vehiculosEnPropiedad = vehiculosEnPropiedad;
    }
}
