package sistemadepedidosfactural.logica;

public class PedidoFacade {
    private ValidadorStock validadorStock;
    private RepositoryPedido repositorioPedido;
    private GeneradorComprobante generadorComprobante;
    private ServicioFactura servicioFactura;
    private ImpuestoStrategy estrategiaImpuesto;

    public PedidoFacade() {
        this.validadorStock = new ValidadorStock();
        this.repositorioPedido = new RepositoryPedido();
        this.generadorComprobante = new GeneradorComprobante();
        this.servicioFactura = new FacturaAdapter(); // Usa el adaptador
    }

    public void setEstrategiaImpuesto(ImpuestoStrategy estrategia) {
        this.estrategiaImpuesto = estrategia;
    }

    public void registrarPedido(String nombre, String producto, int cantidad, double precioUnitario) {
        if (cantidad <= 0 || precioUnitario <= 0 || !validadorStock.validarStock(producto, cantidad)) {
            System.out.println("Error: cantidad o precio inválido, o sin stock.");
            return;
        }

        double subtotal = cantidad * precioUnitario;
        double igv = estrategiaImpuesto.calcularImpuesto(subtotal);
        double total = subtotal + igv;

        RepositoryPedido.registrar(nombre, producto, cantidad);
        generadorComprobante.generar(nombre, producto, cantidad, subtotal, igv, total);
        servicioFactura.generarFactura(nombre, producto, cantidad, subtotal, igv, total);
    }
}
