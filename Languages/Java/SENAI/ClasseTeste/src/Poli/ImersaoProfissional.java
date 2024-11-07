package Poli;

import java.util.ArrayList;
import java.util.List;

public class ImersaoProfissional {

    private List<Produtos> produtosList ;
    public ImersaoProfissional(){
        this.produtosList = new ArrayList<>();
    }

    public void adicionarProdutos(Produtos produtos){
        produtosList.add(produtos);
    }

    public double calcularTotal(){
        double total = 0;

        for (Produtos produtos : produtosList){
            total += produtos.valorUnitario * produtos.quantidade;
        }
        System.out.println("Valor total: " + total);
        if (total >= 500 && total < 1000){
            total = total * (1- 0.05);
        }else if(total >= 1000 && total < 2000){
            total = total * ( 1 - 0.10);
        }else if(total > 2000){
            total = total * (1- 0.15);
        }

        return total;
    }

}

class Produtos{
    String nome;
    double valorUnitario;
    int quantidade;

    Produtos(String nome, double valorUnitario, int quantidade){
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public static void main(String[] args) {
        ImersaoProfissional imersaoProfissional = new ImersaoProfissional();
        Produtos produtos1 = new Produtos("Gamepad",150.0,2);
        Produtos produtos2 = new Produtos("Mouse gamer", 400.0, 3);
        Produtos produtos3 = new Produtos("Mouse wifi", 200.0, 3);
        imersaoProfissional.adicionarProdutos(produtos1);
        imersaoProfissional.adicionarProdutos(produtos2);
        imersaoProfissional.adicionarProdutos(produtos3);

        double precoFinal = imersaoProfissional.calcularTotal();
        System.out.println("Preco final com desconto R$: " + precoFinal);
    }
}
