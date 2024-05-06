package pooClasses;

public class Main {
    public static void main(String[] args) {
        Cliente igo = new Cliente("11233244321","Igo"); // seguindo o construtor crdiado
        Cliente joao = new Cliente(); // seguindo o contrutor padrao
        joao.nome = "Joao";
        joao.cpf = "34694839210";
        Cliente luiz = new Cliente("448399827838","Luiz");

        Conta c001 = new Conta(igo,13324,10);

        Conta c002 = new Conta();
        c002.setTitular(igo);
        c002.setNumero(12232);
        c002.setSaldo(40);


        Conta c003 = new Conta(luiz,122,39);

        Banco sistemaBancario = new Banco();

        System.out.println("Saldo da conta "+ c001.getTitular().nome + " :R$ " + c001.getSaldo());
        sistemaBancario.depositar(c001,50);

        System.out.println("Saldo da conta "+ c001.getTitular().nome + " :R$ " + c001.getSaldo());
        sistemaBancario.sacar(c001,30);

        sistemaBancario.transferir(c001,c002,29);

        System.out.println("Saldo da conta "+ c002.getNumero() + " R$: "+ c002.getSaldo());

        c001.imprimirSaldo();
        c002.imprimirSaldo();


        System.out.println("Quantidade de clientes: " + Conta.quantidadeCliente);
    }
}
