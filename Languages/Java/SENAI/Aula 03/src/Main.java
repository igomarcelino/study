import org.apache.commons.math3.stat.regression.SimpleRegression;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        // informar dados em um formato de lista
        double[] altura = {1.9, 1.75, 1.4, 1.6, 1.57, 1.66, 1.75, 1.9};
        double[] peso = {110, 85, 80, 94, 79, 40, 80, 120};

        // instanciando ferramenta para determinar os parametros da regressao
        SimpleRegression simpleRegression = new SimpleRegression();

        // adicionando os dados no modelo
        for (int i = 0;i < altura.length;i++){
            simpleRegression.addData(altura[i],peso[i] );
        }

        // obter os paramentros

        double inclinacao = simpleRegression.getSlope();
        double interciptacao = simpleRegression.getIntercept();
        double rQuadrado = simpleRegression.getRSquare();

        String title = "Recursividade com Java";

        // exibir resultados
        System.out.println("A inclinacao da reta e : " + inclinacao);
        System.out.println("O ponto de interceptacao e: " + interciptacao);
        System.out.println("O coeficiente R2 e: " + rQuadrado);

        JOptionPane.showMessageDialog(null,String.format("A Equacao e: %.3fx %.3f \nO Coeficiente R2 e: %.4f ",inclinacao,interciptacao,rQuadrado),"Resposta",JOptionPane.INFORMATION_MESSAGE);



    }
}
