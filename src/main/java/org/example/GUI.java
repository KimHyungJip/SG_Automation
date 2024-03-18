package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JTextField idField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private SG_AutomationHandler automationHandler;
    private JPanel namePanel; // namePanel을 GUI 클래스의 필드로 이동

    public GUI() {
        super("Web Automation");

        automationHandler = new SG_AutomationHandler(this);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        // ID 및 Password 입력 패널
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());
        idField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 로그인 버튼 클릭 시 처리 로직 구현
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                // SG_AutomationHandler 클래스의 메서드 호출
                automationHandler.processWebAutomation(new String[]{id, password});
            }
        });
        loginPanel.add(new JLabel("ID: "));
        loginPanel.add(idField);
        loginPanel.add(new JLabel("Password: "));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        // 이름 입력 패널
        namePanel = new JPanel(); // namePanel을 GUI 클래스의 필드로 변경
        namePanel.setLayout(new FlowLayout());
        nameField = new JTextField(20);
        JButton nameButton = new JButton("이름 확인");
        nameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 이름 확인 버튼 클릭 시 처리 로직 구현
                String name = nameField.getText();
                // 어떤 처리를 할지 구현
                System.out.println("입력된 이름: " + name);
            }
        });
        namePanel.add(new JLabel("이름: "));
        namePanel.add(nameField);
        namePanel.add(nameButton);

        // 메인 패널에 추가
        mainPanel.add(loginPanel);
        mainPanel.add(namePanel); // 수정된 부분

        // 프레임에 메인 패널 추가
        getContentPane().add(mainPanel);

        // 프레임 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // 화면 중앙에 표시
        setVisible(true);
    }
    public void updateGUI() {
        System.out.println("업데이트하러옴?");
        idField.setText("");
        passwordField.setText("");
        nameField.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }

}
