package estudos.funcional;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;
import io.github.igomarcelino.clientes.dominio.exceptions.CpfInvalidoException;
import io.github.igomarcelino.clientes.logicanegocio.LogicaCadastroMemoria;

import java.lang.reflect.Type;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class EstudoOptional  {
    public static void main(String[] args) throws CpfInvalidoException {


    clienteComStrem();

    }

    private static void clienteComStrem(){


        Cliente cliente1 = new Cliente("João Silva", "12345678901", TipoSexo.M, null);
        Cliente cliente2 = new Cliente("Maria Souza", "23456789012", TipoSexo.F, null);
        Cliente cliente3 = new Cliente("Pedro Oliveira", "34567890123", TipoSexo.M, null);
        Cliente cliente4 = new Cliente("Ana Pereira", "45678901234", TipoSexo.F, null);
        Cliente cliente5 = new Cliente("Lucas Almeida", "56789012345", TipoSexo.M, null);

        var lista = List.of(cliente1,cliente2,cliente3,cliente4,cliente5);

        String nomesClientes = lista.stream().map(cliente -> cliente.getNome()).collect(Collectors.toList()).toString();
        String cfpClientes = lista.stream().map(cliente -> cliente.getCpf()).collect(Collectors.toList()).toString();

        System.out.print("Nome de clientes: " + nomesClientes + "\n");
        System.out.println("Cpf de clientes: " + cfpClientes + "\n");
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
