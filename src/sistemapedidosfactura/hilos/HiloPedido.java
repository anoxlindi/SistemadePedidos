
package sistemapedidosfactura.hilos;

import sistemapedidosfactura.observador.SubjectFactura;

public class HiloPedido extends Thread {
    private PedidoCompartido pedido;
    private SubjectFactura subject;

    public HiloPedido(PedidoCompartido pedido, SubjectFactura subject) {
        this.pedido = pedido;
        this.subject = subject;
    }

    @Override
    public void run() {
        try {
            System.out.println("[Pedido] Procesando pedido de " + pedido.nombre);
            Thread.sleep(2000); // Simula tiempo de procesamiento
            pedido.listo = true;
            System.out.println("[Pedido] Pedido listo");
            subject.notificar("Pedido procesado");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
