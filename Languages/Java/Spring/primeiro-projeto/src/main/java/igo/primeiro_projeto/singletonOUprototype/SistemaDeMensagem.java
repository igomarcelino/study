package igo.primeiro_projeto.singletonOUprototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SistemaDeMensagem {

    @Autowired
    Remetente remetente ;

    @Autowired
    Remetente techElite;
    public void enviarConfiguracaoCadastro(){
        System.out.println(remetente);
        System.out.println("Bem vindo a DIO");
    }

    public void enviarMensagemBoasVindas(){
        remetente.setEmail("tech@dio.com.br");
        System.out.println(remetente);
        System.out.println("Bem vindo a tech Elite");
    }

    public static void main(String[] args) {

    }
}
