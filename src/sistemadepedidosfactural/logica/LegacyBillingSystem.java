
package sistemadepedidosfactural.logica;

import java.util.Map;

public class LegacyBillingSystem {
    
    public void emitirFacturaLegacy(Map<String, Object> datos) {
        System.out.println("=== FACTURA LEGACY ===");
        System.out.println("Cliente: " + datos.get("nombre"));
        System.out.println("Producto: " + datos.get("producto"));
        System.out.println("Cantidad: " + datos.get("cantidad"));
        System.out.println("Subtotal: S/ " + datos.get("subtotal"));
        System.out.println("IGV: S/ " + datos.get("igv"));
        System.out.println("Total: S/ " + datos.get("total"));
        System.out.println("=======================");
    }
}
