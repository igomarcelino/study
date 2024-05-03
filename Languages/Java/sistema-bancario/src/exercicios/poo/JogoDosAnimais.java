package exercicios.poo;

public class JogoDosAnimais {
    public static void main(String[] args) {

        Animal leao = new Animal("Leao","Carnivoro",100,60);
        Animal gazela = new Animal("Gazela","Herbivoro",80,50);

        gazela.setVelocidade(65);

        PredadorVsPresa caca = new PredadorVsPresa();



        System.out.println(caca.cacada(leao,gazela));

    }
}
