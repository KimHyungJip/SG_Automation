package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserInputProcessor processor = new UserInputProcessor();
            String[] credentials = processor.createAndShowGUI();
            if (credentials != null && credentials.length == 2) {
                // GUI 객체 생성
                GUI gui = new GUI();
                // SG_AutomationHandler 인스턴스 생성 시 GUI 객체 전달
                SG_AutomationHandler handler = new SG_AutomationHandler(gui);
                handler.processWebAutomation(credentials);
            } else {
                System.out.println("User canceled the input or an error occurred.");
            }
        });
    }
}
