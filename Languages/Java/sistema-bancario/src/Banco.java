public class Banco {



    void depositar( Conta conta , double valor){
       conta.setSaldo(conta.getSaldo()+valor); ;
        conta.imprimirSaldo();

    }

    void sacar(Conta conta, double valor){
        if (valor < conta.getSaldo() && valor - conta.getSaldo() != 0){
            conta.setSaldo(conta.getSaldo()-valor);
            conta.imprimirSaldo();
        }else {
            System.out.println("Saldo infuficiente");
        }
    }

    void transferir(Conta origem, Conta destino, double valor){
        if (valor < origem.getSaldo() && valor - origem.getSaldo() != 0) {
            origem.setSaldo(origem.getSaldo()-valor);
            destino.setSaldo(destino.getSaldo()+valor);
            System.out.println("Transferencia realizada com sucesso");
        }else{
            System.out.println("Saldo insuficiente para transferencia.");
        }
    }
}
