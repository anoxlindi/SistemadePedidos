
package sistemadepedidosfactural.logica;

public class RepositorioPedido {
      public void registrar(String nombre, String producto, int cantidad) {
        System.out.println("Pedido registrado: " + nombre + " - " + producto + " x" + cantidad);
    }
}
