package dio.demo_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping
    public String bemVindo(){
        return "Bem vindo ao Spring bot";
    }
}
