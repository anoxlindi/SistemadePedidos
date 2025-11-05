
package sistemadepedidosfactural.logica;

public class CalculadoraImpuestos {
        public double calcularSubtotal(String producto, int cantidad) {
        // Simulación: cada producto cuesta 10.0
        return 10.0 * cantidad;
    }

    public double calcularIGV(double subtotal) {
        return subtotal * 0.18;
    }

    public double calcularTotal(double subtotal, double igv) {
        return subtotal + igv;
    }
}
