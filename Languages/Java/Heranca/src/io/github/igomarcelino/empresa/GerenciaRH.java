package io.github.igomarcelino.empresa;

public class GerenciaRH {

    private ConexaoBancaria conexao;

    public GerenciaRH(ConexaoBancaria pagamentoGerente) {
    }


    public void calcularPagamento( Funcionario funcionario, ConexaoBancaria conexaoBancaria){
        conexaoBancaria.enviarPagamento(funcionario);
    }

    public void calcularBonificacaoAnual(Funcionario funcionario,ConexaoBancaria conexaoBancaria){
        conexaoBancaria.enviarBonificacaoAnual(funcionario);
    }


    public ConexaoBancaria getConexao() {
        return conexao;
    }

    public void setConexao(ConexaoBancaria conexao) {
        this.conexao = conexao;
    }
}
