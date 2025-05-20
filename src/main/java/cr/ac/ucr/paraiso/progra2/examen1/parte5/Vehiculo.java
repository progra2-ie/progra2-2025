package cr.ac.ucr.paraiso.progra2.examen1.parte5;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int anno;
    protected Propietario propietario;

    public Vehiculo(String marca, String modelo, int anno, Propietario propietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.anno = anno;
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return  "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anno=" + anno + '\'' +
                ", propietario=" + propietario ;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}