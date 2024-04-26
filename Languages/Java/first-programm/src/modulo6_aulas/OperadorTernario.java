package modulo6_aulas;

public class OperadorTernario {
    public static void main(String[] args) {
        int idade = 20;
        int idadeMinina = 18;
        int anoNascimento = 2000;

        boolean resultado = idade > idadeMinina && anoNascimento >= 2000;

       /* if (resultado){
            System.out.println("A variavel tem o valor verdadeiro");
        }else {
//            System.out.println("A variavel tem um valor falso");
        }*/

        String deMaior = idade >= 18 ? "Sim e de maior" : "Nao e de menor"; // operador ternario

        System.out.println(deMaior);
    }
}
