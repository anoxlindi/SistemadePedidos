
package sistemadepedidosfactural.logica;
import java.util.HashMap; // implementación del map, acceder facilmente a los datos
import java.util.Map;// para agrupar datos de diferentes tipos es una sola estructura nombre:pepe, juana, tito, producto laptop, etc
public class FacturaAdapter implements ServicioFactura{
    
    private LegacyBillingSystem legacySystem = new LegacyBillingSystem();

    @Override
    public void generarFactura(String nombre, String producto, int cantidad, double subtotal, double igv, double total) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("nombre", nombre);
        datos.put("producto", producto);
        datos.put("cantidad", cantidad);
        datos.put("subtotal", subtotal);
        datos.put("igv", igv);
        datos.put("total", total);

        legacySystem.emitirFacturaLegacy(datos);
    }
}
