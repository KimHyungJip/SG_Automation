package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // GUI 객체 생성
            GUI gui = new GUI();
            gui.setVisible(true); // GUI를 화면에 표시
        });
    }
}
