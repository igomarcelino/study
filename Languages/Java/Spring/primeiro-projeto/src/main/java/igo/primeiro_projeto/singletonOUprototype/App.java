package igo.primeiro_projeto.singletonOUprototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class App implements CommandLineRunner {

    @Autowired
    private SistemaDeMensagem sistemaDeMensagem;

    @Override
    public void run(String... args) throws Exception {
        sistemaDeMensagem.enviarMensagemBoasVindas();
        sistemaDeMensagem.enviarConfiguracaoCadastro();
    }
}
