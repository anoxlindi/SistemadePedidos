
package sistemadepedidosfactural.logica;


public class GeneradorComprobante {
        public void generar(String nombre, String producto, int cantidad, double subtotal, double igv, double total) {
        System.out.println("----- COMPROBANTE -----");
        System.out.println("Cliente: " + nombre);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Subtotal: S/ " + subtotal);
        System.out.println("IGV (18%): S/ " + igv);
        System.out.println("Total: S/ " + total);
        System.out.println("------------------------");
    }
}
