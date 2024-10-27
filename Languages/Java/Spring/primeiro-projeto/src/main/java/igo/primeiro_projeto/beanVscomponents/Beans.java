package igo.primeiro_projeto.beanVscomponents;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class Beans {

    @Bean
    public Gson gsonBean(){
        return new Gson();
    }
    @Bean
    public URL urlBean() throws MalformedURLException {
        return new URL("https://viacep.com.br/ws/11940000/json");
    }

}
