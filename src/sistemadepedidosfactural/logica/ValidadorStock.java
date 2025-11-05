
package sistemadepedidosfactural.logica;


public class ValidadorStock {
     public boolean validarStock(String producto, int cantidad) {
        // Simulación: siempre hay stock si la cantidad es positiva
        return cantidad > 0;
    }
}

