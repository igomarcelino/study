package Poli;

public class DesviosIncondicionais {
    public static void main(String[] args) {
        externo:
        for (int i =0 ; i <  5; i++){
            if ( i == 3){
                continue ;
            }
            System.out.println("externo");
            interno:
            for (int j = 0; j < i; j++){
                if (j == 3){
                    continue interno;
                }
                System.out.println("interno" );
            }
        }
    }
}
