package modulo4_aulas;

public class CalculadoraDeIdade {
    public static void main(String[] args) {
        /**
         * TODO
         *  1 - Pegar o ano atual
         *  2 - pegar o ano de nascimento
         *  3 - subtrai o ano atual pelo ano de nascimento
         * */

        int anoAtual = 2024;
        int anoNascimento = 1958;
        int idade = anoAtual - anoNascimento;

        System.out.println("A idade e : " + idade);

        if ( idade < 18 ){
            System.out.println("Menor de idade");
        }else if(idade < 60){
            System.out.println("Maior de idade");
        }else {
            System.out.println("Idoso");
        }
    }
}
