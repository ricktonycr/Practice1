package com.unsa.logic;

import com.unsa.data.ComboValues;

import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

import static com.unsa.data.ComboValues.SUMAR;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static java.lang.Math.*;

public class Utils {
    private static BufferedImage image1;
    private static BufferedImage image2;
    private static BufferedImage image3;
    private static JComboBox comboOperaciones;
    private static JTextField a;

    public static void loadImage(BufferedImage image, int id){
        switch (id){
            case 1:
                image1 = image;
            case 2:
                image2 = image;
        }
    }

    public static void setComboOperaciones(JComboBox combo){
        comboOperaciones = combo;
    }

    public static void setFactor(JTextField txt){
        a = txt;
    }

    public static BufferedImage execute(){
        if(image1 != null && image2 != null) {
            System.out.println(comboOperaciones.getSelectedItem());
            image3 = new BufferedImage(max(image1.getWidth(), image2.getWidth()), max(image1.getHeight(), image2.getHeight()),TYPE_INT_RGB);
            Color colorAux1;
            Color colorAux2;
            double f;
            switch ((ComboValues) Objects.requireNonNull(comboOperaciones.getSelectedItem())){
                case SUMAR:
                    for ( int i = 0; i < image3.getWidth(); i++){
                        for (int j = 0; j < image3.getHeight(); j++){

                            if(i < image1.getWidth() && j < image1.getHeight())
                                colorAux1 = new Color(image1.getRGB(i, j));
                            else
                                colorAux1 = new Color(0,0,0);

                            if(i < image2.getWidth() && j < image2.getHeight())
                                colorAux2 = new Color(image2.getRGB(i, j));
                            else
                                colorAux2 = new Color(0,0,0);

                            int r = Math.min(colorAux1.getRed() + colorAux2.getRed(), 255);
                            int g = Math.min(colorAux1.getGreen() + colorAux2.getGreen(),255);
                            int b = Math.min(colorAux1.getBlue() + colorAux2.getBlue(),255);
                            image3.setRGB(i,j,(r << 16) | (g << 8) | b);
                        }
                    }
                    break;

                case RESTAR:
                    for ( int i = 0; i < image3.getWidth(); i++){
                        for (int j = 0; j < image3.getHeight(); j++){

                            if(i < image1.getWidth() && j < image1.getHeight())
                                colorAux1 = new Color(image1.getRGB(i, j));
                            else
                                colorAux1 = new Color(0,0,0);

                            if(i < image2.getWidth() && j < image2.getHeight())
                                colorAux2 = new Color(image2.getRGB(i, j));
                            else
                                colorAux2 = new Color(0,0,0);

                            int r = Math.max(colorAux1.getRed() - colorAux2.getRed(), 0);
                            int g = Math.max(colorAux1.getGreen() - colorAux2.getGreen(), 0);
                            int b = Math.max(colorAux1.getBlue() - colorAux2.getBlue(), 0);
                            image3.setRGB(i,j,(r << 16) | (g << 8) | b);
                        }
                    }
                    break;
                case PROMEDIAR:
                    for ( int i = 0; i < image3.getWidth(); i++){
                        for (int j = 0; j < image3.getHeight(); j++){

                            if(i < image1.getWidth() && j < image1.getHeight())
                                colorAux1 = new Color(image1.getRGB(i, j));
                            else
                                colorAux1 = new Color(0,0,0);

                            if(i < image2.getWidth() && j < image2.getHeight())
                                colorAux2 = new Color(image2.getRGB(i, j));
                            else
                                colorAux2 = new Color(0,0,0);

                            int r = Math.min((colorAux1.getRed() + colorAux2.getRed())/2, 255);
                            int g = Math.min((colorAux1.getGreen() + colorAux2.getGreen())/2, 255);
                            int b = Math.min((colorAux1.getBlue() + colorAux2.getBlue())/2, 255);
                            image3.setRGB(i,j,(r << 16) | (g << 8) | b);
                        }
                    }
                    break;
                case FACTOR:
                    if(a.getText().isBlank()){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un factor entre 0 y 1.");
                        return null;
                    }
                    f = Double.valueOf(a.getText());
                    if(f < 0 || f > 1){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un factor entre 0 y 1.");
                        return null;
                    }
                    for ( int i = 0; i < image3.getWidth(); i++){
                        for (int j = 0; j < image3.getHeight(); j++){

                            if(i < image1.getWidth() && j < image1.getHeight())
                                colorAux1 = new Color(image1.getRGB(i, j));
                            else
                                colorAux1 = new Color(0,0,0);

                            if(i < image2.getWidth() && j < image2.getHeight())
                                colorAux2 = new Color(image2.getRGB(i, j));
                            else
                                colorAux2 = new Color(0,0,0);

                            int r = (int) Math.min((colorAux1.getRed() * f + colorAux2.getRed() * (1 - f)), 255);
                            int g = (int) Math.min((colorAux1.getGreen() * f + colorAux2.getGreen() * (1 - f)), 255);
                            int b = (int) Math.min((colorAux1.getBlue() * f + colorAux2.getBlue() * (1 - f)), 255);
                            image3.setRGB(i,j,(r << 16) | (g << 8) | b);
                        }
                    }
                    break;
                case MULTIPLICAR:
                    if(a.getText().isBlank()){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un factor entre 0 y 1.");
                        return null;
                    }
                    f = Double.valueOf(a.getText());
                    if(f < 0 || f > 1){
                        JOptionPane.showMessageDialog(null, "Debe ingresar un factor entre 0 y 1.");
                        return null;
                    }
                    for ( int i = 0; i < image3.getWidth(); i++){
                        for (int j = 0; j < image3.getHeight(); j++){

                            if(i < image1.getWidth() && j < image1.getHeight())
                                colorAux1 = new Color(image1.getRGB(i, j));
                            else
                                colorAux1 = new Color(0,0,0);

                            if(i < image2.getWidth() && j < image2.getHeight())
                                colorAux2 = new Color(image2.getRGB(i, j));
                            else
                                colorAux2 = new Color(0,0,0);

                            int r = (int) Math.min(colorAux1.getRed() * colorAux2.getRed() * f, 255);
                            int g = (int) Math.min(colorAux1.getGreen() * colorAux2.getGreen() * f, 255);
                            int b = (int) Math.min(colorAux1.getBlue() * colorAux2.getBlue() * f, 255);
                            image3.setRGB(i,j,(r << 16) | (g << 8) | b);
                        }
                    }
                    break;
            }
            return image3;
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar las dos imágenes de entrada.");
            return null;
        }
    }
}
