public class Conta {
    Cliente titular ;
    int numero;
    double saldo;

    void imprimirSaldo(){
        System.out.println("Saldo atual: " + this.saldo); // O this.saldo , retorna o atributo saldo do objeto atual
    }
}
