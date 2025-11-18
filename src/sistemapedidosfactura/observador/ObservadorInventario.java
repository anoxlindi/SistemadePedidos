
package sistemapedidosfactura.observador;

public class ObservadorInventario implements Observador{
    @Override
    public void actualizar(String evento) {
        System.out.println("[Inventario] Stock actualizado por: " + evento);
    }
}
