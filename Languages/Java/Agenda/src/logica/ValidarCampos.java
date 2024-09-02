package logica;

import dominio.Exceptions.CampoObrigatorioException;
import dominio.Pessoa;

public class ValidarCampos  {

    public static void validarCampos(Pessoa pessoa) throws CampoObrigatorioException{
        if (pessoa.getNome().equals(null) || pessoa.getNome().isBlank()){
            throw new CampoObrigatorioException("Obrigatorio informar nome");
        } else if (pessoa.getSobrenome().equals(null) || pessoa.getSobrenome().isBlank()) {
            throw new CampoObrigatorioException("Campo sobrenome obrigatorio");
        }else {
            tipoContato(pessoa);
            valorContato(pessoa);
        }
    }

    private static void tipoContato(Pessoa pessoa) throws CampoObrigatorioException {
        if (pessoa.getTipo().equals(null) || pessoa.getTipo().isBlank()){
            throw new CampoObrigatorioException("Tipo de contato obrigatorio");
        }
    }

    private static void valorContato(Pessoa pessoa) throws CampoObrigatorioException{
        if (pessoa.getValor().equals(null) || pessoa.getValor().isBlank()){
            throw new CampoObrigatorioException("Informar o valor do contato");
        }
    }
}
