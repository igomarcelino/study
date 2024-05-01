public class MainCarro {
    public static void main(String[] args) {
        Carro uno = new Carro();

        uno.nome = "uno";
        uno.cavalos = 80;
        uno.cor = "branco";
        uno.transmissao = "manual";
        uno.fabricante = "Fiat";
        uno.capacidadeTanque = 45;
        uno.quantidadeCombustivel = 10;
        uno.kmPorLitro = 16 ;

        System.out.println("Nome do carro: "+uno.nome);
        System.out.println("Quantidade de combustivel: "+ uno.quantidadeCombustivel);

        uno.abastecer(45);

        System.out.println("Quantidade de combustivel apos abastecer: "+ uno.quantidadeCombustivel);
        System.out.println("Autonomia do combustivel: "+ uno.autonomia());

    }
}
