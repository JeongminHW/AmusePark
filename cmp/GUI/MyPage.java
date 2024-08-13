package cmp.GUI;

import java.awt.*;
import javax.swing.*;

public class MyPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("마이페이지");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        JPanel mainPanel = new JPanel(new GridLayout(10, 2, 10, 10));
        mainPanel.setBackground(Color.GRAY);
        
        JLabel idLabel = new JLabel("ID");
        JTextField idField = new JTextField("AAAAA");
        
        JLabel nameLabel = new JLabel("이름");
        JTextField nameField = new JTextField("AAAAA");
        
        JLabel currentPasswordLabel = new JLabel("현재 비밀번호");
        JPasswordField currentPasswordField = new JPasswordField("AAAAA");
        
        JLabel newPasswordLabel = new JLabel("새 비밀번호");
        JPasswordField newPasswordField = new JPasswordField("AAAAA");
        
        JLabel confirmPasswordLabel = new JLabel("비밀번호 확인");
        JPasswordField confirmPasswordField = new JPasswordField("AAAAA");
        
        JLabel phoneLabel = new JLabel("전화번호");
        JTextField phoneField = new JTextField("AAAAA");
        
        JLabel positionLabel = new JLabel("직급");
        JTextField positionField = new JTextField("AAAAA");
        
        JLabel adminLabel = new JLabel("관리자 여부");
        JCheckBox adminCheckBox = new JCheckBox("YES", true);
        
        JButton saveButton = new JButton("저장");
        JButton cancelButton = new JButton("취소");
        
        mainPanel.add(idLabel);
        mainPanel.add(idField);
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(currentPasswordLabel);
        mainPanel.add(currentPasswordField);
        mainPanel.add(newPasswordLabel);
        mainPanel.add(newPasswordField);
        mainPanel.add(confirmPasswordLabel);
        mainPanel.add(confirmPasswordField);
        mainPanel.add(phoneLabel);
        mainPanel.add(phoneField);
        mainPanel.add(positionLabel);
        mainPanel.add(positionField);
        mainPanel.add(adminLabel);
        mainPanel.add(adminCheckBox);
        
        mainPanel.add(cancelButton);
        mainPanel.add(saveButton);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
