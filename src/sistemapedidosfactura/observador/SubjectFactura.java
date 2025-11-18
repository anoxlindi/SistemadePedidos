
package sistemapedidosfactura.observador;
import java.util.ArrayList;
import java.util.List;
public class SubjectFactura {
    private List<Observador> observadores = new ArrayList<>();

    public void registrar(Observador obs) {
        observadores.add(obs);
    }

    public void notificar(String evento) {
        for (Observador obs : observadores) {
            obs.actualizar(evento);
        }
    }
}
