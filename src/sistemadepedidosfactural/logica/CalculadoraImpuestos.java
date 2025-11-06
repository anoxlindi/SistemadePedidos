
package sistemadepedidosfactural.logica;

public class CalculadoraImpuestos {
        public double calcularSubtotal(double precioUnitario , int cantidad) {
        return precioUnitario * cantidad;
    }

    public double calcularIGV(double subtotal) {
        return subtotal * 0.18;
    }

    public double calcularTotal(double subtotal, double igv) {
        return subtotal + igv;
    }
}
