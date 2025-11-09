package sistemadepedidosfactural.logica;

import java.util.ArrayList;
import java.util.List;

public class RepositoryPedido {
    private List<Cliente> clientes = new ArrayList<>();

    public void registrar(String nombre, String producto, int cantidad) {
        Cliente cliente = new Cliente(nombre, producto, cantidad);
        clientes.add(cliente);
        System.out.println("Pedido registrado: " + cliente);
    }

    public List<Cliente> obtenerTodos() {
        return clientes;
    }
}
