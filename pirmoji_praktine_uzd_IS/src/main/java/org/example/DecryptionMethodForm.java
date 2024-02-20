package org.example;

import javax.swing.*;

public class DecryptionMethodForm {

    public DecryptionMethodForm() {
        JFrame frame = new JFrame("Choose Decryption Method");
        JPanel panel = new JPanel();

        ImageIcon imageIcon = new ImageIcon("Logo.png");

        JLabel imageLabel = new JLabel(imageIcon);

        JButton btnArrayMethod = new JButton("Use Array Method");
        JButton btnASCIIMethod = new JButton("Use ASCII Method");

        btnArrayMethod.addActionListener(e -> {
            new EncryptionDecryptionForm("array");
        });

        btnASCIIMethod.addActionListener(e -> {
            new EncryptionDecryptionForm("ASCII");
        });

        panel.add(imageLabel);
        panel.add(btnArrayMethod);
        panel.add(btnASCIIMethod);
        frame.add(panel);
        frame.setSize(300, 310);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DecryptionMethodForm();
    }
}
