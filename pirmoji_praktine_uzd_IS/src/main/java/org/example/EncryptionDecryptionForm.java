package org.example;

import javax.swing.*;

public class EncryptionDecryptionForm {
    private final JFrame frame;
    private final JTextField inputTextField;
    private final JTextField shiftTextField;

    public EncryptionDecryptionForm(String method) {

        frame = new JFrame("Encryption/Decryption");
        JPanel panel = new JPanel();
        inputTextField = new JTextField(20);
        shiftTextField = new JTextField(5);
        JButton btnEncrypt = new JButton("Encrypt");
        JButton btnDecrypt = new JButton("Decrypt");

        btnEncrypt.addActionListener(e -> {
            String text = inputTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText());
            String encryptedText;
            if (method.equals("array")) {
                encryptedText = encryptUsingArray(text, shift);
            } else {
                encryptedText = encryptUsingCaesar(text, shift);
            }
            JOptionPane.showMessageDialog(frame, "Encrypted text: " + encryptedText);
        });

        btnDecrypt.addActionListener(e -> {
            String text = inputTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText());
            String decryptedText;
            if (method.equals("array")) {
                decryptedText = decryptUsingArray(text, shift);
            } else {
                decryptedText = decryptUsingCaesar(text, shift);
            }
            JOptionPane.showMessageDialog(frame, "Decrypted text: " + decryptedText);
        });

        panel.add(new JLabel("Text:"));
        panel.add(inputTextField);
        panel.add(new JLabel("Shift:"));
        panel.add(shiftTextField);
        panel.add(btnEncrypt);
        panel.add(btnDecrypt);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private String encryptUsingArray(String text, int shift) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
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
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private String decryptUsingArray(String text, int shift) {
        // For decryption, invert the shift direction
        return encryptUsingArray(text, -shift);
    }


    private String encryptUsingCaesar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char encryptedChar = (char) ('A' + (ch - 'A' + shift) % 26);
                result.append(encryptedChar);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private String decryptUsingCaesar(String text, int shift) {
        return encryptUsingCaesar(text, 26 - shift);
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
