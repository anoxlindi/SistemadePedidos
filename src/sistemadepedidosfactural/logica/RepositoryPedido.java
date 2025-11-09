
package sistemadepedidosfactural.logica;

import java.util.ArrayList;
import java.util.List;

public class RepositoryPedido {

    static void registrar(String nombre, String producto, int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       private List<Cliente> pedidos = new ArrayList<>();

    public void guardar(Cliente cliente) {
        pedidos.add(cliente);
        System.out.println("Pedido guardado correctamente.");
    }

    public List<Cliente> obtenerTodos() {
        return pedidos;
    }}