package cr.ac.ucr.paraiso.progra2.examen1.parte6;

public class Producto {
    private int productoId;
    private String nombre;
    private float precio;
    private int cantidadExistente;

    public Producto(int productoId, String nombre, float precio, int cantidadExistente) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadExistente = cantidadExistente;
    }

    public Producto() {
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(int cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }
}
