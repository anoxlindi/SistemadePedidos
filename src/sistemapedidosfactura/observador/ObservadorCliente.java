package sistemapedidosfactura.observador;

public class ObservadorCliente implements Observador {
     @Override
    public void actualizar(String evento) {
        System.out.println("[Cliente] Notificado: " + evento);
    }
}
