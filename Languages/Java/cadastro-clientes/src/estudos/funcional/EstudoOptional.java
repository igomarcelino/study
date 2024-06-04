package estudos.funcional;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;
import io.github.igomarcelino.clientes.dominio.exceptions.CpfInvalidoException;
import io.github.igomarcelino.clientes.logicanegocio.LogicaCadastroMemoria;

import java.lang.reflect.Type;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class EstudoOptional  {
    public static void main(String[] args) throws CpfInvalidoException {

        streamApiComFilter();


    }

    private static void streamApiComFilter() {
        List<String> nomes = List.of("Igo","Luiz","Joao", "Carlos","Iago","Mateus","Iler");

        System.out.println("Nomes com referencia de metodo");
        nomes.stream().forEach(System.out::println); // Referencia de metodo de um consumer
        System.out.println("Nomes com expressao lambda de um consumer");
        nomes.forEach(nome -> System.out.println(nome)); // Expressao lambda de um consumer

        System.out.println("Nomes que comecam com a letra : m");
        nomes.stream().filter(n -> n.toLowerCase().charAt(0) == 'm').forEach(System.out::println);
        System.out.println("Nomes com map");
        List<String> novoNomes = nomes.stream().map(nomess -> nomess.toLowerCase()).collect(Collectors.toList());

        novoNomes.forEach(System.out::println);

    }

    private static void metodoMap() {
        var cliente = clientePopulado();

        var sexoCliente = Optional.of(cliente)
                .map(cliente1 -> cliente1.get())
                .map(cliente1 -> cliente1.getSexo()
                        .getTipoSexo()).orElse("Nao encontrado");

        System.out.println(sexoCliente);
    }

    private static void metodoIfPresentOrElse() throws CpfInvalidoException {
        LogicaCadastroMemoria logicaCadastroMemoria = new LogicaCadastroMemoria();
        Optional<Cliente> cliente = clientePopulado();

        logicaCadastroMemoria.salvar(cliente.get());

        //var clienteBusca = logicaCadastroMemoria.buscar(UUID.randomUUID());
        var clienteBusca = logicaCadastroMemoria.buscar(cliente.get().getCodigo());

        if (clienteBusca.isEmpty()){
            System.out.println("Cliente nao encontrado");
        }else if (!clienteBusca.isEmpty()){
            System.out.println(clienteBusca.get());
        }
    }

    static void recuperarCliente(){
        var cliente = new Cliente("Igo","12332112311", TipoSexo.M,null);

        Optional<Cliente> possivelCliente = Optional.ofNullable(cliente);


        if (possivelCliente.isPresent()){
            cliente = possivelCliente.get();
            System.out.println("nome: " + cliente.getNome());
        }

    }

    public static Optional<Cliente> clienteVazio(){
        return Optional.empty();
    }

    public static Optional<Cliente> clientePopulado(){
        var cliente = new Cliente("Igo","12332112311", TipoSexo.M,new byte[]{});
        return Optional.of(cliente);
    }

}
