package io.github.igomarcelino.clientes.logicanegocio;

import java.util.UUID;

public interface Cadastro<TIPO> {

        void salvar(TIPO cliente);
        TIPO buscar(UUID codigo);
        void deletar(UUID codigo);
        void atualizar(TIPO cliente);

}
