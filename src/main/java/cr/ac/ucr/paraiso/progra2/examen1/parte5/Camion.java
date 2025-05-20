package cr.ac.ucr.paraiso.progra2.examen1.parte5;

public class Camion extends Vehiculo {
    // Atributos propios de Camion
    private double capacidadCarga;
    private int numeroEjes;


    public Camion(String marca, String modelo, int anno) {
        super(marca, modelo, anno, new Propietario());
        this.capacidadCarga = 0.0;
        this.numeroEjes = 0;
    }
    public Camion(String marca, String modelo, int anno, double capacidadCarga, int numeroEjes) {
        super(marca, modelo, anno, new Propietario());
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    @Override
    public String toString() {
        return "Camion{" + super.toString() +
                ", capacidadCarga=" + capacidadCarga + '\'' +
                ", numeroEjes=" + numeroEjes +
                '}';
    }
}
