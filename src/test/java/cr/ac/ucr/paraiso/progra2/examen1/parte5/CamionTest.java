package cr.ac.ucr.paraiso.progra2.examen1.parte5;

import static org.junit.jupiter.api.Assertions.*;

public class CamionTest {


        public void crear_camion() {
            Propietario propietarioCamion = new Propietario();
            propietarioCamion.setNombre("Danny");
            propietarioCamion.setNombre("Zamora Zamora");

            String marcaCamion = "Freightliner";
            String modeloCamion = "Cascadia";
            int annoCamion = 2024;
            double capacidadCargaCamion = 35000.0; // en kg
            int numeroEjesCamion = 4;

            Camion camion = new Camion(
                    marcaCamion,
                    modeloCamion,
                    annoCamion,
                    capacidadCargaCamion,
                    numeroEjesCamion
            );
            camion.setPropietario(propietarioCamion);
            camion.getCapacidadCarga();
            camion.getNumeroEjes();

    }

}