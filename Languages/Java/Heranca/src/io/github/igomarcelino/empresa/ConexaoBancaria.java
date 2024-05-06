package io.github.igomarcelino.empresa;

public class ConexaoBancaria {

    private Funcionario funcionario;


    // calcula o pagamento do funcionario
    public void enviarPagamento(Funcionario funcionario){
        double pagamento = funcionario.getSalaraio() + funcionario.calcularBonificacao();
        System.out.println("CPF: " + funcionario.getCpf() + " Salario: "+ pagamento);
    }

    // bonificacao anual
    public void enviarBonificacaoAnual(Funcionario funcionario){
        double bonificacao = funcionario.getSalaraio() *2;
        System.out.println("Cpf: " + funcionario.getCpf() + " bonificacao anual: " + bonificacao);
        System.out.println("Enviando e-mail para "+ funcionario.getNome());
    }

    // constructor



    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
