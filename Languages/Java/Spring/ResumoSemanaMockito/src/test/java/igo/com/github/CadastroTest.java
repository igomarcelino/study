package igo.com.github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CadastroTest {
    @InjectMocks
    private Cadastro cadastro;
    @Mock
    Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cadastro = new Cadastro();
    }

    @Test
    public void cadastrar(){
        // Mock do nome retornado da pessoa
        when(pessoa.getNome()).thenReturn("fulano");

        // utiliza o mock de pessoa para popular uma lista
        cadastro.adicioarPessoas(pessoa);

        // adiciona uma lista de Pessoa a partir do metodo listPesso
        // Essa lista pode verificar se o metodo adcionar pessoas esta funcionando corretamente
        List<Pessoa> pessoas = cadastro.listaPessoa();

        // verifica se cadastro.listaPessoa() realmente retornou uma lista
        Assertions.assertEquals(1,pessoas.size());
        // verifica se o mock de pessoa realmente tem o nome fulano
        Assertions.assertEquals("fulano",pessoa.getNome());

    }

}