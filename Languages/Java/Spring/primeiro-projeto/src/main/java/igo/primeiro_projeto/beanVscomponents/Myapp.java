package igo.primeiro_projeto.beanVscomponents;

import igo.primeiro_projeto.app.Hello;
import igo.primeiro_projeto.beanVscomponents.CadastrarEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Myapp implements CommandLineRunner {

    @Autowired
    private Hello hello;
    @Autowired
    private CadastrarEndereco cadastrarEndereco;
    @Override
    public void run(String... args) throws Exception {
        hello.hello();
        hello.user();
        cadastrarEndereco.obterCep();
    }
}
