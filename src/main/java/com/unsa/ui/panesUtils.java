package com.unsa.ui;

import com.unsa.logic.Utils;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class panesUtils {
    public static void setImage(ImageSelector original , ImageSelector copia){

        copia.image = original.image;
        copia.repaint();
    }
    public static void setImage(JPanel original , JPanel copia){

            setImage((ImageSelector)original,(ImageSelector)copia);
    }


    public static void setImageMediana(JPanel image31, JPanel image32 , int filtro) {
        ImageSelector img31 = (ImageSelector) image31;
        ImageSelector img32 = (ImageSelector) image32;
        BufferedImage imgtemp = Utils.mediana(img31.image,filtro);
        img32.image=imgtemp;
        img32.repaint();

    }

    public static void setZoom(JPanel image31, JPanel image32 , int valor) {
        ImageSelector img31 = (ImageSelector) image31;
        ImageSelector img32 = (ImageSelector) image32;
        BufferedImage imgtemp = Utils.zoom(img31.image,valor);
        img32.image=imgtemp;
        img32.repaint();

    }


}
