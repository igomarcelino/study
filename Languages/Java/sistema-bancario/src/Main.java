public class Main {
    public static void main(String[] args) {
        Cliente igo = new Cliente();
        igo.cpf = "11233432321";
        igo.nome = "Igo";

        Cliente joao = new Cliente();
        joao.nome = "Joao";
        joao.cpf = "34694839210";

        Conta c001 = new Conta();
        c001.saldo = 10;
        c001.titular = igo;
        c001.numero = 1;

        Conta c002 = new Conta();
        c002.titular = joao;
        c002.numero = 2;
        c002.saldo = 20;

        Banco sistemaBancario = new Banco();

        System.out.println("Saldo da conta "+ c001.titular.nome + " :R$ " + c001.saldo);
        sistemaBancario.depositar(c001,50);

        System.out.println("Saldo da conta "+ c001.titular.nome + " :R$ " + c001.saldo);
        sistemaBancario.sacar(c001,30);

        sistemaBancario.transferir(c001,c002,29);

        System.out.println("Saldo da conta "+ c002.numero + " R$: "+ c002.saldo);

        c001.imprimirSaldo();
        c002.imprimirSaldo();
    }
}
