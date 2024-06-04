package io.github.igomarcelino.clientes.logicanegocio;

import java.util.Optional;
import java.util.UUID;

public interface Cadastro<TIPO> {

        void salvar(TIPO cliente) throws Exception;
        Optional<TIPO> buscar(UUID codigo);
        void deletar(UUID codigo);
        void atualizar(TIPO cliente);

}
