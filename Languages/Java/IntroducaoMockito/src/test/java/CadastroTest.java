import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CadastroTest {

    /**
     * Informa a classe que tera a dependencia a ser inserida
     * */

    @InjectMocks
    Cadastro cadastro;

    /**
     * Cria um mock do objeto pessoa
     * */
    @Mock
    Pessoa pessoa;

    @Test
    void cadastrarPessoa() {

        cadastro.cadastrarPessoa(pessoa);

        Assertions.assertEquals(1 ,cadastro.listarPessoas().size());
        Assertions.assertTrue(cadastro.listarPessoas().contains(pessoa));
    }
}