package cr.ac.ucr.paraiso.progra2.busquedaempleado;

import cr.ac.ucr.paraiso.progra2.domain.Empleado;

/**
 *
 * @author Alvaro Mena
 */
public class EmpleadoUtil {
    
    public static int buscarEmpleado(Empleado[] empleados, int idEmpleadoBuscado){
        
        int a;
        if (empleados == null)
            throw new NullPointerException("El arreglo es nulo");
        int posicionPorRetornar = -1;
        int i = 0;
        while (posicionPorRetornar == -1 && i < empleados.length){
            if (idEmpleadoBuscado == empleados[i].getIdEmpleado())
                posicionPorRetornar = i;
            else i++;
        }// while
        return posicionPorRetornar;
    }
            
    
}
