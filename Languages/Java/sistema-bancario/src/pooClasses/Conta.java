package pooClasses;

public class Conta {
    private Cliente titular ;
    private int numero;
    private double saldo;

    public static  int quantidadeCliente ;

    public Conta() {

    }

    public Cliente getTitular(){
        return titular;
    }
    public  void  setTitular(Cliente titular){
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public Conta(Cliente titular, int numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
        if ( saldo < 0 ){ // construtor ja cria objeto realizando verificacoes
            this.saldo = saldo;
        }
        incrementaQuantidadeClientes();
    }

    void imprimirSaldo(){
        System.out.println("Saldo atual: " + this.saldo); // O this.saldo , retorna o atributo saldo do objeto atual
    }

    private static void incrementaQuantidadeClientes(){
        quantidadeCliente++;
    }
}
