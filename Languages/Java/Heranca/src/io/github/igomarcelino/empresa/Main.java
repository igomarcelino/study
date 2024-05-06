package io.github.igomarcelino.empresa;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Tecnico tecnico = new Tecnico("Igo","33322233121",1599,"tecnico de dados");
        System.out.println("Remuneracao: ");
        tecnico.imprimirSalario();

        Gerente gerente = new Gerente("joao","44933922919",3000,"gerente");


        ConexaoBancaria bancoDoBrasil = new ConexaoBancaria();
        GerenciaRH rhEmpresa = new GerenciaRH(bancoDoBrasil);

        rhEmpresa.calcularBonificacaoAnual(gerente,bancoDoBrasil);
        rhEmpresa.calcularPagamento(gerente,bancoDoBrasil);



    }
}
