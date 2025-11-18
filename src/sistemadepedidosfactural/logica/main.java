package sistemadepedidosfactural.logica;

import java.util.Scanner;
import sistemapedidosfactura.hilos.*;
import sistemapedidosfactura.observador.*;

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

        scanner.nextLine(); // limpiar buffer

        System.out.print("¿El pedido esta exonerado de IGV? (s/n): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            fachada.setEstrategiaImpuesto(new ExoneradoStrategy());
        } else {
            fachada.setEstrategiaImpuesto(new IGV18strategy());
        }

        // Registrar pedido en la fachada
        fachada.registrarPedido(nombre, producto, cantidad, precioUnitario);

        // === INTEGRACIon de observador e hilos ===

        // 1. Crear SubjectFactura y registrar observadores
        SubjectFactura subject = new SubjectFactura();
        subject.registrar(new ObservadorCliente());
        subject.registrar(new ObservadorInventario());

        // 2. Crear recurso compartido
        PedidoCompartido pedido = new PedidoCompartido();
        pedido.nombre = nombre;
        pedido.producto = producto;
        pedido.cantidad = cantidad;
        pedido.precioUnitario = precioUnitario;

        // 3. Crear hilos
        HiloPedido hiloPedido = new HiloPedido(pedido, subject);
        HiloFactura hiloFactura = new HiloFactura(pedido, subject);

        // 4. Iniciar hilos
        hiloPedido.start();
        hiloFactura.start();
    }
}
