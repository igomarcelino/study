package one.digitalinnovation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


import javax.crypto.Mac;
import java.time.LocalDate;

public class PessoaTest {
    @Test
    void validarMaiorIdade(){
        /**
         * Teste espera que o resultado seja true, caso for false ira falhar o teste
         * */
        Pessoa pessoa = new Pessoa("igo", LocalDate.of(1988,02,17));
        Assertions.assertTrue(pessoa.ehMariorDeIdade());
    }

    /** Teste espera que a pessoa inserida possua 30 anos de idade, caso a pessoa nao apresentar essa idade,
     o teste ira falhar
     */
    @Test
    void idadeCorreta(){
        Pessoa pessoa = new Pessoa("igo", LocalDate.of(1988,02,17));
        Assertions.assertEquals(30,pessoa.getIdade());
    }

    /**
     * Esse metodo verifica item a item do array para saber se sao correspondente,
     * Esse metodo pode lancar uma exception caso o tamanho dos 2 arrays sejam divergentes.
     * */
    @Test
    void compararArray(){
        int[] arrayA = {10,29,18,20};
        int[] arrayB = {10,29,18,20};
        Assertions.assertArrayEquals(arrayA,arrayB);
    }

    /**
     * Esse metodo verifica se o valor verificado nao e nulo
     * */
    @Test
    void verificarNotNull(){
        Pessoa pessoa = new Pessoa("Fulano",LocalDate.now());
        Assertions.assertThrows();
    }

    @Test
    public  void testarUser(){
        Assumptions.assumeTrue(OS.LINUX.isCurrentOs());
        Assertions.assertTrue(true);
    }
}
