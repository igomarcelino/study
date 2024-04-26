package modulo7_aulas;

public class AcessandoTodosIndicesDeUmArray {
    public static void main(String[] args) {
        int[] numeros = {1,2,3,4,5,6,7,8,9};

        for (int numero : numeros){
            if (numero % 2 == 0 ){
                System.out.println(numero);
            }

        }
    }
}
