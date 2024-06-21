import java.util.List;

public class RegressaoLinear {
    // Criar o metodo para construir uma equacao por regressao linear
    public static double[] RegressaoLinear(List<double[]> dados){
        // declarando variavel para armazenar o tamanho dos dados
        int n = dados.size();
        // definindo variaveis para armazenar nossas somas
        double somaX = 0,somaY = 0, somaXY = 0, somaX2 = 0;
        for(double[] ponto : dados){
            double x = ponto[0];
            double y = ponto[1];
            somaX += x;
            somaY += y;
            somaXY += x * y;
            somaX2 += x * x;
        }
        // pegando a inclinacao
        double inclinacao = ( n * somaXY - somaX * somaY) / ( n * somaX2 - somaX * somaX);
        double intercepto = ( somaY - inclinacao * somaX) / n;
        // Calcular o Rx2
        double yMedio = somaY / n ;
        double SQT = 0;
        double SQR = 0;
        for (double[] ponto : dados){
            double x = ponto[0];
            double y = ponto[1];
            double yPredito = intercepto + inclinacao * x;
            SQT += Math.pow(y - yMedio,2);
            SQR += Math.pow(y - yPredito,2);
        }
        double rQuadrado = 1 - ( SQR / SQT);
        return new double[]{intercepto,inclinacao,rQuadrado};
    }

    public RegressaoLinear() {
    }
}
