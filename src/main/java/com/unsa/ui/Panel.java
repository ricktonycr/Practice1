
        package com.unsa.ui;

        import com.unsa.data.ComboValues;
        import com.unsa.logic.Utils;

        import java.awt.event.ActionListener;
        import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.*;

public class Panel {
    private static final int DEFAULT_WITH = 800;
    private static final int DEFAULT_HEIGHT = 600;
    private JTabbedPane zoom;
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
    private  JButton jButtonMedia;
    private  JPanel Mediana;
    private JPanel image31;
    private JPanel image32;
    private JTextField textFieldMediana;
    private JPanel image41;
    private JPanel image42;
    private JButton MOSTRARButton;
    private JTextField zoomTextValue;
    private JTextField zoomTextY;
    private JTextField zoomTextX;

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


        image31 = new ImageSelector(true,4);
        image31.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        image32 = new ImageSelector(false,5);
        image32.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));


        image41 = new ImageSelector(true,4);
        image41.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));
        image42 = new ImageSelector(false,5);
        image42.setMinimumSize(new Dimension(DEFAULT_WITH/2, DEFAULT_HEIGHT/2));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel");
        //frame.setIconImage();
        Panel mainPanel  = new Panel();
        mainPanel.updateButton();
        frame.setContentPane(mainPanel.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(DEFAULT_WITH, DEFAULT_HEIGHT));
    }

    private  void updateButton() {
        jButtonMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aras");
                int  filtro = Integer.parseInt(textFieldMediana.getText().toString());
                panesUtils.setImage(image31,image32);
                panesUtils.setImageMediana(image31,image32,filtro);

            }
        });
        MOSTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aras");
                int  filtro = Integer.parseInt(zoomTextValue.getText().toString());
                panesUtils.setImage(image41,image42);
                panesUtils.setZoom(image41,image42,filtro);

            }
        });

    }
}




