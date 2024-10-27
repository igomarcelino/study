package igo.primeiro_projeto.beanVscomponents;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Component
public class CadastrarEndereco {

    @Autowired
    Gson gson;
    @Autowired(required = false)
    CEP cep;
    @Autowired
    URL url;
     private BufferedReader bufferedReader;

    public void obterCep(){
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            Type type = new TypeToken<CEP>(){}.getType();
            cep = gson.fromJson (bufferedReader, type);
            System.out.println(cep);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<CEP> verificarEstado(){
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            Type type = new TypeToken<CEP>(){}.getType();
            cep = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(cep);
    }

 }
