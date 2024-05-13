package estudos.exceptions;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.exceptions.CpfInvalidoException;
import io.github.igomarcelino.clientes.logicanegocio.ValidarCliente;

public class Main {
    public static void main(String[] args) throws CpfInvalidoException {


        Cliente cliente = new Cliente();

        cliente.setCpf("12332123212");

        try {
            ValidarCliente.validarCliente(cliente);

        } catch (CpfInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }
}