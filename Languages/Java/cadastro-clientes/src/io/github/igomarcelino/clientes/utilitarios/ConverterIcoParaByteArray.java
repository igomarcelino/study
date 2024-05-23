package io.github.igomarcelino.clientes.utilitarios;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ConverterIcoParaByteArray {
     public static byte[] conversor(Icon icon){
        if (icon == null){
            return null;
        }

        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        icon.paintIcon(null,graphics2D,0,0);
        graphics2D.dispose();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);


        }catch (IOException e){
            System.out.println("Erro no tratamento de IMAGEIO");
        }

        return byteArrayOutputStream.toByteArray();

    }
}
