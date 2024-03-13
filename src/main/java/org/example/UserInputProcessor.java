package org.example;
import javax.swing.*;
import java.awt.*;
public class UserInputProcessor {
    public static String[] createAndShowGUI() {
        JFrame frame = new JFrame("Input Dialog Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JTextField idField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        panel.add(new JLabel("ID: "));
        panel.add(idField);
        panel.add(new JLabel("Password: "));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(
                frame,
                panel,
                "Enter ID and Password",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String id = idField.getText();
            String password = new String(passwordField.getPassword());
            String[] array = new String[2];
            array[0] = id;
            array[1] = password;
            System.out.println("ID: " + id);
            System.out.println("Password: " + password);

            return array;
        } else {
            System.out.println("User canceled the input.");
            return null;
        }
    }
}
