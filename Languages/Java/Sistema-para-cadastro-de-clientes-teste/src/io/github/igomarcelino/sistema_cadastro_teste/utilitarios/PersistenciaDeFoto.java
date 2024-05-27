package io.github.igomarcelino.sistema_cadastro_teste.utilitarios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersistenciaDeFoto {
    private static final  String caminho = "/home/igo/Dev/bancoFake/";

    public static void persistirFotos(String nome, byte[] bytes){

        try {
            Path path = Paths.get(caminho+nome);
            Files.write(path,bytes);
        }catch (IOException e ){
            System.out.println("Erro ao salvar a foto do cliente");
        }
    }
}
