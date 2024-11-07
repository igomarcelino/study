package igo.primeiro_projeto.singletonOUprototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeansConf {

    @Bean
    @Scope("prototype")
    public Remetente remetenteBean(){
        System.out.println("Criando um Objeto Remetente");
        Remetente remetente = new Remetente();
        remetente.setEmail("noreply@email.com");
        remetente.setNome("usuario");
        return remetente;
    }
}
