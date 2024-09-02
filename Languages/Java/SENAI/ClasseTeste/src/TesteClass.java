import Poli.CalculadoraImposto;
import Poli.Computador;
import Poli.Produto;
import Poli.Tomato;

public class TesteClass {
    public static void main(String[] args) {

        Produto computador = new Computador("Nq1000", 1340.00);
        Produto tomate = new Tomato("Tomate liso", 40);

        CalculadoraImposto.impostoComputador((Computador) computador);
        CalculadoraImposto.impostoTomate((Tomato) tomate);
    }

    public static boolean validatePin(String pin) {
        // Your code here...

        return pin.matches("\\d{4}|\\d{6}");
    }
}
