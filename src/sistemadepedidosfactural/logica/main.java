package sistemadepedidosfactural.logica;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PedidoFacade fachada = new PedidoFacade();

        System.out.println("=== REGISTRO DE PEDIDO ===");

        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese producto: ");
        String producto = scanner.nextLine();

        System.out.print("Ingrese cantidad: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese precio unitario: ");
        double precioUnitario = scanner.nextDouble();

        fachada.registrarPedido(nombre, producto, cantidad, precioUnitario);
    }
}
