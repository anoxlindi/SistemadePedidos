
package sistemadepedidosfactural.logica;


public interface ServicioFactura {
     void generarFactura(String nombre, String producto, int cantidad, double subtotal, double igv, double total);
}
