package io.github.igomarcelino.sistema_cadastro_teste.logica;

public interface Cadastro<TIPO> {

    void salvarCliente(TIPO tipo);
    void pesquisarCliente(TIPO tipo);
    void deletarCliente(TIPO tipo);
    void imprimirCliente(TIPO tipo);

}
