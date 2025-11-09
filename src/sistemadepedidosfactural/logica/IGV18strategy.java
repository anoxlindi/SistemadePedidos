package sistemadepedidosfactural.logica;

public class IGV18strategy implements ImpuestoStrategy {
    
   @Override
    public double calcularImpuesto(double subtotal) {
        return subtotal * 0.18;
    }
}
