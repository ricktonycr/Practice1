package com.unsa.ui;

import com.unsa.data.ComboValues;
import com.unsa.logic.Utils;
import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.*;

public class Panel {
    private static final int DEFAULT_WITH = 1000;
    private static final int DEFAULT_HEIGHT = 800;
    private JTabbedPane tabbedPane1;
    public JPanel panel1;
    private JComboBox comboBox1;
    private JPanel image1;
    private JPanel image2;
    private JPanel image3;
    private JTextField textField1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        image1 = new ImageSelector(true,1);
        image1.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        image2 = new ImageSelector(true,2);
        image2.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        image3 = new ImageSelector(false,3);
        image3.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        comboBox1 = new JComboBox(ComboValues.values());
        Utils.setComboOperaciones(comboBox1);
        textField1 = new JTextField();
        Utils.setFactor(textField1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel");
        //frame.setIconImage();
        frame.setContentPane(new Panel().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(DEFAULT_WITH, DEFAULT_HEIGHT));
    }
}
