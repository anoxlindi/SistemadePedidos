package sistemadepedidosfactural.logica;

public class PedidoFacade {
    private ValidadorStock validadorStock;
    private CalculadoraImpuestos calculadoraImpuestos;
    private RepositorioPedido repositorioPedido;
    private GeneradorComprobante generadorComprobante;
    private ServicioFactura servicioFactura;

    public PedidoFacade() {
        this.validadorStock = new ValidadorStock();
        this.calculadoraImpuestos = new CalculadoraImpuestos();
        this.repositorioPedido = new RepositorioPedido();
        this.generadorComprobante = new GeneradorComprobante();
        this.servicioFactura = new FacturaAdapter(); // Usa el adaptador
    }

    public void registrarPedido(String nombre, String producto, int cantidad, double precioUnitario) {
        if (cantidad <= 0 || precioUnitario <= 0 || !validadorStock.validarStock(producto, cantidad)) {
            System.out.println("Error: cantidad o precio inválido, o sin stock.");
            return;
        }

        double subtotal = calculadoraImpuestos.calcularSubtotal(precioUnitario, cantidad);
        double igv = calculadoraImpuestos.calcularIGV(subtotal);
        double total = calculadoraImpuestos.calcularTotal(subtotal, igv);

        repositorioPedido.registrar(nombre, producto, cantidad);
        generadorComprobante.generar(nombre, producto, cantidad, subtotal, igv, total);
        servicioFactura.generarFactura(nombre, producto, cantidad, subtotal, igv, total);
    }
}
