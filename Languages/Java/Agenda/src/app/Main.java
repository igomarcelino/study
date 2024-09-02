package app;

import dados.Conexao;
import dados.PessoaDAO;
import dominio.Exceptions.CampoObrigatorioException;
import dominio.Pessoa;
import logica.LogicaBanco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();
        System.out.print("Cadastro de pessoas!! \n");
        System.out.print("id: ");
        pessoa.setId_pessoa(scanner.nextInt());
        System.out.print("Nome: ");
        pessoa.setNome(scanner.next());
        System.out.print("Sobrenome: ");
        pessoa.setSobrenome(scanner.next());
        System.out.print("Tipo de contato: ");
        pessoa.setTipo(scanner.next());
        System.out.print(""+pessoa.getTipo()+": ");
        pessoa.setValor(scanner.next());
        pessoa.setPessoa_fk(pessoa.getId_pessoa());
        System.out.println("------------------------------");


        PessoaDAO pessoaDAO = new PessoaDAO(Conexao.conexao());
        LogicaBanco logicaBanco = new LogicaBanco(pessoaDAO);
        try {
            logicaBanco.salvar(pessoa);
        } catch (CampoObrigatorioException e) {
            throw new RuntimeException(e);
        }

    }

}
