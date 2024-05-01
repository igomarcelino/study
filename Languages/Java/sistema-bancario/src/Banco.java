public class Banco {



    void depositar( Conta conta , double valor){
       conta.saldo += valor;
        conta.imprimirSaldo();

    }

    void sacar(Conta conta, double valor){
        if (valor < conta.saldo && valor - conta.saldo != 0){
            conta.saldo -= valor;
            conta.imprimirSaldo();
        }else {
            System.out.println("Saldo infuficiente");
        }
    }

    void transferir(Conta origem, Conta destino, double valor){
        if (valor < origem.saldo && valor - origem.saldo != 0) {
            origem.saldo -= valor;
            destino.saldo += valor;
            System.out.println("Transferencia realizada com sucesso");
        }else{
            System.out.println("Saldo insuficiente para transferencia.");
        }
    }
}
