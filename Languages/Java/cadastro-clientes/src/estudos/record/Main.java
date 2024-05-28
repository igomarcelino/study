package estudos.record;

public class Main {
    public static void main(String[] args) {
        var pessoa = new PessoaRecord("igo","12333212312");

        System.out.println(pessoa.name()+" "+ pessoa.cpf());



    }
}
