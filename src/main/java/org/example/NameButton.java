package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameButton {
    public NameButton() {
        System.out.println("NameButton들어오니");
        JFrame frame = new JFrame("Name Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton nameButton = new JButton("이름");
        nameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NameInputHandler.getInput();
            }
        });
        panel.add(nameButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NameButton::new);
    }
}
