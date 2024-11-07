package Poli;

public class Atividades extends Pessoa{
    public static void main(String[] args) {
        int x = 0;
        for (int i = 0; i < 10 ; i++){
            if (i == 8) break;
            x = i;
        }
        System.out.println(x);

        Produto produto = new Tomato();
        produto.quantidade = 1;
    }

    public static int gbParaMb(double gb) {
        // TODO: Faça o calculo de conversão GB para MB, sabendo que 1 GB = 1024 MB
        int mB = Double.valueOf(gb).intValue();
        return  mB * 1024 ;

    }



}

