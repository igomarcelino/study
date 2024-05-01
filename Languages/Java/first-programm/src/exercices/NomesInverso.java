package exercices;

public class NomesInverso {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Crie um programa Java que declare um array de strings com nomes de pessoas e
         *      imprima todos os nomes em ordem inversa.
         * */

        String[] nomes = {"Igo","Luiz", "joao", "julio"};

        for (int i = nomes.length -1 ; i >= 0;i--){
            System.out.println(nomes[i]);
        }
    }
}
