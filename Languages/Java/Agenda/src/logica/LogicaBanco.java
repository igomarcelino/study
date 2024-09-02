package logica;

import dados.PessoaDAO;
import dominio.Exceptions.CampoObrigatorioException;
import dominio.Pessoa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class LogicaBanco implements Cadastro<Pessoa> {

    // atributo que ira guardar o cliente
    PessoaDAO pessoaDAO;
    private List<Pessoa> pessoaList;

    public LogicaBanco(PessoaDAO pessoaDAO) {

        this.pessoaDAO = pessoaDAO;
    }

    @Override
    public void salvar(Pessoa pessoa) throws CampoObrigatorioException {
        ValidarCampos.validarCampos(pessoa);
        pessoaDAO.inserirPessoa(pessoa);
        System.out.println(pessoa);
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    @Override
    public Optional<Pessoa> buscar(Pessoa pessoa) {
        Pessoa encontrada = null;
        if (!pessoaList.isEmpty()){
            for (Pessoa p : pessoaList)
                if (p.getNome().equals(pessoa.getNome())){
                    encontrada = p;
                }
        }return Optional.ofNullable(encontrada);
    }

    @Override
    public void atualizar() {

    }

    @Override
    public void deletar() {

    }

    @Override
    public List<Pessoa> imprimir() {
        return null;
    }
}
