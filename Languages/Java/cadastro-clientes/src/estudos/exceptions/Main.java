package estudos.exceptions;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.exceptions.CpfInvalidoException;
import io.github.igomarcelino.clientes.logicanegocio.ValidarCliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CpfInvalidoException {

        Scanner teclado = new Scanner(System.in);



        try {
            Cliente cliente = new Cliente();
            System.out.println("Informe o CPF do cliente: ");
            String cpf = teclado.nextLine();
            cliente.setCpf(cpf);

            ValidarCliente.validarCliente(cliente);

        } catch (CpfInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Fechando o telcado");
            teclado.close();
            System.out.println("Teclado fechado");

        }


    }
}