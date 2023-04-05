package com.unsa.ui;

import com.unsa.data.ComboValues;
import com.unsa.logic.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel {
    private static final int DEFAULT_WITH = 1000;
    private static final int DEFAULT_HEIGHT = 800;
    private JTabbedPane tabbedPane1;
    public JPanel panel1;
    private JComboBox comboBox1;
    private JPanel image11;
    private JPanel image12;
    private JPanel image13;
    private JTextField textField11;
    private JPanel image21;
    private JPanel image22;
    private JButton button21;
    private JTextPane textPane21;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        image11 = new ImageSelector(true,1);
        image11.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        image12 = new ImageSelector(true,2);
        image12.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        image13 = new ImageSelector(false,3);
        image13.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        comboBox1 = new JComboBox(ComboValues.values());
        Utils.setComboOperaciones(comboBox1);
        textField11 = new JTextField();
        Utils.setFactor(textField11);

        // Convolucional
        image21 = new ImageSelector(true,4);
        image21.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        image22 = new ImageSelector(false,5);
        image22.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        textPane21 = new JTextPane();
        textPane21.setText("0.1;0.1;0.1\n" +
                "0.1;0.1;0.1\n" +
                "0.1;0.1;0.1");
        Utils.setPane(textPane21);
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
