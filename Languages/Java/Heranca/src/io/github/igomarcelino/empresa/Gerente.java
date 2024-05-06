package io.github.igomarcelino.empresa;

public class Gerente extends  Funcionario {

    private String especialidade;


    @Override
    public double calcularBonificacao() {
        return (getSalaraio() / 10) + 500;
    }

    @Override
    public double imprimirSalario() {
        double salario = getSalaraio() + calcularBonificacao();
        return salario;
    }


    public Gerente() {
        }

    public Gerente(String nome, String cpf, double salaraio, String especialidade){
            super(nome, cpf, salaraio);
            this.especialidade = especialidade;
        }

        public String getEspecialidade () {
            return especialidade;
        }

        public void setEspecialidade (String especialidade){
            this.especialidade = especialidade;
        }
    }
