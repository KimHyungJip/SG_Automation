package org.example;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserInputProcessor processor = new UserInputProcessor();
            String[] credentials = processor.createAndShowGUI();
            if (credentials != null && credentials.length == 2) {
                SG_AutomationHandler handler = new SG_AutomationHandler();
                handler.processWebAutomation(credentials);
            } else {
                System.out.println("User canceled the input or an error occurred.");
            }
        });
    }
}
