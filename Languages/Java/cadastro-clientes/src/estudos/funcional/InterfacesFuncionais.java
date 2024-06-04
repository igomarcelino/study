package estudos.funcional;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfacesFuncionais {
    public static void main(String[] args) {

        var interfaces = new InterfacesFuncionais();
        interfaces.supplier();
        interfaces.consumer();
        interfaces.predicate();
        interfaces.function();
    }

    public void supplier(){
       Supplier<Cliente> proverCliente = () -> new Cliente("João Silva", "12345678901", TipoSexo.M, null);
        System.out.println("Supplier: " + proverCliente.get());



    }

    public void consumer(){
        Consumer<Cliente> clienteConsumer = (cliente) -> System.out.println("Consumer: " + cliente.getNome());

            Cliente cliente1 = new Cliente("João Silva", "12345678901", TipoSexo.M, null);
            Cliente cliente2 = new Cliente("Maria Souza", "23456789012", TipoSexo.F, null);
            Cliente cliente3 = new Cliente("Pedro Oliveira", "34567890123", TipoSexo.M, null);
            Cliente cliente4 = new Cliente("Ana Pereira", "45678901234", TipoSexo.F, null);
            Cliente cliente5 = new Cliente("Lucas Almeida", "56789012345", TipoSexo.M, null);


        clienteConsumer.accept(cliente1);

    }

    public void predicate(){
        Predicate<Cliente> verificarEMulher = (cliente) -> TipoSexo.F.equals(cliente.getSexo());
        Cliente cliente1 = new Cliente("João Silva", "12345678901", TipoSexo.M, null);
        System.out.println(verificarEMulher.test(cliente1));
    }

    public void function(){
        Function<Cliente, String> mapearNome = (cliente) -> cliente.getNome();
        Cliente cliente2 = new Cliente("Maria Souza", "23456789012", TipoSexo.F, null);
        String nome = mapearNome.apply(cliente2);
        System.out.println("Nome do cliente: " + nome);
    }
}
