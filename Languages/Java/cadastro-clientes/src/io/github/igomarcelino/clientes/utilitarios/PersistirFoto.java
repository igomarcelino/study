package io.github.igomarcelino.clientes.utilitarios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersistirFoto {

    private static final String caminho = "/home/igo/Dev/";
    public static void salvarFotos(String nome, byte[] bytes){

        try {
            Path path = Paths.get(caminho+nome);
            Files.write(path,bytes);
        }catch (IOException e){
            System.out.println("Falha ao salvar a imagem");
        }
    }
}
