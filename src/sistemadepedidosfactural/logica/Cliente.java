package sistemadepedidosfactural.logica;

public class Cliente {
    public String nombre;
    public String producto;
    public int cantidad;

    public Cliente(String nombre, String producto, int cantidad) {
        this.nombre = nombre;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Producto: " + producto + " | Cantidad: " + cantidad;
    }
}
