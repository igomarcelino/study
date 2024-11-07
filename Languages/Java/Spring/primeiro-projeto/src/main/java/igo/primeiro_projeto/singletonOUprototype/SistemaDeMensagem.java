package igo.primeiro_projeto.singletonOUprototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaDeMensagem implements CommandLineRunner {

    @Autowired
    Remetente remetente ;

  public void enviarMensagem(){
      System.out.println("nome" + remetente.getNome()+"\nemail: "+remetente.getEmail());
  }


    @Override
    public void run(String... args) throws Exception {
        enviarMensagem();
    }
}
