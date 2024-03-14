package org.example;

import javax.swing.*;
import java.awt.*;

public class NameInputHandler {
    public static String getInput() {
        JFrame frame = new JFrame("Input Dialog Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JTextField nameField = new JTextField(10);

        panel.add(new JLabel("Name: "));
        panel.add(nameField);

        int result = JOptionPane.showConfirmDialog(
                frame,
                panel,
                "Enter Your Name",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            System.out.println("Name: " + name);
            return name;
        } else {
            System.out.println("User canceled the input.");
            return null;
        }
    }
}
