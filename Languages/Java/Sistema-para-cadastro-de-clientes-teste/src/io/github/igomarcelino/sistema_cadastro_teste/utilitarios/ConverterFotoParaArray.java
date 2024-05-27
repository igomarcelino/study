package io.github.igomarcelino.sistema_cadastro_teste.utilitarios;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.Buffer;

public class ConverterFotoParaArray {
    public static byte[] conversorFotoArray(Icon icon){
        if(icon == null){
            return null;
        }

        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        icon.paintIcon(null,g2d,0,0);
        g2d.dispose();
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        try {
            ImageIO.write(bufferedImage,"jpg",byteArray);
        } catch (IOException e) {
            System.out.println("Erro na conversao de imagem para array");
        }
        return byteArray.toByteArray();
    }
}
