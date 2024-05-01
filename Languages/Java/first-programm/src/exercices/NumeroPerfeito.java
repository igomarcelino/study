package exercices;

public class NumeroPerfeito {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que verifique se um número é um número perfeito. Um
         *      número perfeito é aquele que é igual à soma de seus divisores próprios (excluindo
         *      ele esmo). Por exemplo, o número 28 é, pois: 28 = 1+2+4+7+14
         * */
        int numero = 27;
        int numeroPerfeito = 0;
        for ( int  i = numero - 1; i > 0; i--){
            if ( numero % i == 0 ){
                numeroPerfeito += i;
            }
        }
        if ( numero == numeroPerfeito){
            System.out.println("O numero informado e um numero perfeito");
        }else{
            System.out.println("O numero informado nao e um numero perfeito");
        }
    }
}
// Numero perfeito e aquele numero que e a soma dos seus divisores exeto ele mesmo ex: 6 = 3 + 2 + 1 .
