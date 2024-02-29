package org.example;

import javax.swing.*;

public class EncryptionDecryptionForm {
    private final JFrame frame;
    private final JTextField inputTextField;
    private final JTextField shiftTextField;

    public EncryptionDecryptionForm(String method) {
        String frameTitle = (method.equals("array")) ? "Encryption/Decryption (Array Method)" : "Encryption/Decryption (ASCII Method)";

        frame = new JFrame(frameTitle);
        JPanel panel = new JPanel();
        inputTextField = new JTextField(20);
        shiftTextField = new JTextField(5);
        JButton btnEncrypt = new JButton("Encrypt");
        JButton btnDecrypt = new JButton("Decrypt");

        btnEncrypt.addActionListener(e -> {
            String text = inputTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText());
            String resultText;
            if (method.equals("array")) {
                resultText = encryptUsingArray(text, shift);
            } else {
                resultText = encryptUsingCaesar(text, shift);
            }
            JOptionPane.showMessageDialog(frame, "Encrypted text: " + resultText);
        });

        btnDecrypt.addActionListener(e -> {
            String text = inputTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText());
            String resultText;
            if (method.equals("array")) {
                resultText = decryptUsingArray(text, shift);
            } else {
                resultText = decryptUsingCaesar(text, shift);
            }
            JOptionPane.showMessageDialog(frame, "Decrypted text: " + resultText);
        });

        JLabel methodLabel = new JLabel("Method: " + method.toUpperCase());
        panel.add(methodLabel);

        panel.add(new JLabel("Text:"));
        panel.add(inputTextField);
        panel.add(new JLabel("Shift:"));
        panel.add(shiftTextField);
        panel.add(btnEncrypt);
        panel.add(btnDecrypt);
        frame.add(panel);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private String encryptUsingArray(String text, int shift) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            int index = indexOf(alphabet, Character.toLowerCase(ch));
            if (index != -1) {
                int shiftedIndex = (index + shift) % alphabet.length;
                if (shiftedIndex < 0) {
                    shiftedIndex += alphabet.length;
                }
                char encryptedChar = alphabet[shiftedIndex];
                result.append(encryptedChar);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private String decryptUsingArray(String text, int shift) {
        return encryptUsingArray(text, -shift);
    }

    private String encryptUsingCaesar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            char encryptedChar = (char) (ch + shift);
            result.append(encryptedChar);
        }
        return result.toString();
    }

    private String decryptUsingCaesar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            char decryptedChar = (char) (ch - shift);
            result.append(decryptedChar);
        }
        return result.toString();
    }

    private int indexOf(char[] array, char target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new EncryptionDecryptionForm("array");
    }
}
