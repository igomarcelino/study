package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        /***
         * Criar os cursos disponiveis na platafor
         */

        Curso linguagem = new Curso();
        linguagem.setTitulo("Linguagens de programacao");
        linguagem.setCargaHoraria(40);
        linguagem.setDescricao("Curso de linguagem de programcao");

        Curso bancoDeDados = new Curso();
        bancoDeDados.setTitulo("Curso de Banco de Dados");
        bancoDeDados.setDescricao("Curso de introducao a banco de dados");
        bancoDeDados.setCargaHoraria(40);

        Mentoria comoComecar = new Mentoria();
        comoComecar.setTitulo("Dando o start na carreira");
        comoComecar.setDescricao("Mentoria com profissionais da are de tecnologia");
        comoComecar.setData(LocalDate.of(2024,10,1));

        BootCamp boot01 = new BootCamp();
        boot01.setNome("BootCamp Java Developer");
        boot01.setDescricao("Descricao do bootcamp de java");
        boot01.getConteudos().add(linguagem);
        boot01.getConteudos().add(bancoDeDados);
        boot01.getConteudos().add(comoComecar);

        Dev dev01 = new Dev();
        dev01.setNome("Julio");
        dev01.inscreverBootCamp(boot01);

        System.out.println(dev01.getConteudosInscrito());
        dev01.progressao();
        System.out.println(dev01.getConteudosInscrito());
        System.out.println(dev01.getConteudosConcluidos());
        dev01.progressao();
        System.out.println(dev01.getConteudosInscrito());
        System.out.println("XP: " + dev01.calcularXP());


    }
}
