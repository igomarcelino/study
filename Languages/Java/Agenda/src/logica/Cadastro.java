package logica;

import dominio.Exceptions.CampoObrigatorioException;
import dominio.Pessoa;

import java.util.List;
import java.util.Optional;

public interface Cadastro<TIPO> {
    void salvar(TIPO tipo) throws Exception;
    Optional<TIPO> buscar(Pessoa pessoa);
    void atualizar();
    void deletar();
    List<TIPO> imprimir();

}
