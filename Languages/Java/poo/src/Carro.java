public class Carro {

    String nome ;
    int cavalos ;
    String cor ;
    String transmissao ;
    String fabricante;
    int capacidadeTanque;
    int quantidadeCombustivel ;
    int kmPorLitro ;


    void abastecer(int litros){

        if ((capacidadeTanque - quantidadeCombustivel) < litros  ){
            litros = capacidadeTanque - quantidadeCombustivel;
            quantidadeCombustivel = litros;
            System.out.println("Foi abastecido: " + litros);
        }else {
            quantidadeCombustivel += litros;
            System.out.println("Foi abastecido: " + litros);
        }

    }

    int autonomia(){
        return  kmPorLitro * quantidadeCombustivel;
    }

}
