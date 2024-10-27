package igo.primeiro_projeto.app;

import org.springframework.stereotype.Component;

@Component
public class Hello {

    public void hello(){
        System.out.println("Hello with Spring");
    }
    public void user(){
        System.out.println("User");
    }
}
