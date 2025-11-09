package sistemadepedidosfactural.logica;

public class ExoneradoStrategy implements ImpuestoStrategy {
    @Override
    public double calcularImpuesto(double subtotal) {
        return 0.0;
    }
}
