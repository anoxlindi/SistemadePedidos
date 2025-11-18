
package sistemapedidosfactura.hilos;

import sistemapedidosfactura.observador.SubjectFactura;

public class HiloFactura extends Thread {
    private PedidoCompartido pedido;
    private SubjectFactura subject;

    public HiloFactura(PedidoCompartido pedido, SubjectFactura subject) {
        this.pedido = pedido;
        this.subject = subject;
    }

    @Override
    public void run() {
        try {
            while (!pedido.listo) {
                System.out.println("[Factura] Esperando pedido...");
                Thread.sleep(1000);
            }

            double subtotal = pedido.precioUnitario * pedido.cantidad;
            double igv = subtotal * 0.18;
            double total = subtotal + igv;

            System.out.println("[Factura] Factura generada para " + pedido.nombre);
            System.out.println("Subtotal: " + subtotal);
            System.out.println("IGV: " + igv);
            System.out.println("Total: " + total);

            subject.notificar("Factura generada");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}