import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TesteInicialMockito {

    @Mock
    List<String> nomes ; // a lista nao foi iniciada
    @Test
    void testarLista(){
        // pega o indice 1 da lista e retorna o valor Runo
        Mockito.when(nomes.get(1)).thenReturn("Runo");
        // imprime o conteudo do indice 1
        System.out.println(nomes.get(1));

        // Aqui o Junit verifica o teste
        Assertions.assertEquals("B",nomes.get(1));
    }
}