package igo_dio.properties.App;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem implements CommandLineRunner {

    // Ao usar o @Value estamos informando que estamos retirando do application.properties as configuracoes
    // Ao Spring verificar em application.properties vemos que temos de ter essas variaveis previamente declaradas
    // Dessa maneira o Spring consegue injeta-las automaticamente.
    @Value("${nome}")
    private String nome;
    @Value("${email}")
    private String email;
    @Value("${telefone}")
    private Long telefone;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por: " + nome + "\n" +
                "e-mail: " + email + "\n" +
                "telefone: " + telefone);
    }
}
