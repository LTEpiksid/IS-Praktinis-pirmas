package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DecryptionMethodForm {

    public DecryptionMethodForm() {
        JFrame frame = new JFrame("Choose Decryption Method");
        JPanel panel = new JPanel(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Logo.png")));
        JLabel imageLabel = new JLabel(imageIcon);

        JButton btnArrayMethod = new JButton("Use Array Method");
        JButton btnASCIIMethod = new JButton("Use ASCII Method");

        btnArrayMethod.addActionListener(e -> new EncryptionDecryptionForm("array"));

        btnASCIIMethod.addActionListener(e -> new EncryptionDecryptionForm("ASCII"));

        imageLabel.setPreferredSize(new Dimension(200, 200));

        panel.add(imageLabel, BorderLayout.NORTH);
        panel.add(btnArrayMethod, BorderLayout.CENTER);
        panel.add(btnASCIIMethod, BorderLayout.SOUTH);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DecryptionMethodForm::new);
    }
}
