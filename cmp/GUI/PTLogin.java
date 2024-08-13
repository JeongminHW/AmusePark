package cmp.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PTLogin {

    public PTLogin() {
        JFrame frame = new JFrame("알바 로그인/회원가입");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);

        // RoundedButton 클래스 사용
        JButton employButton = new RoundedButton("로그인", 32);
        JButton partTimeButton = new RoundedButton("회원가입", 32);
        
        JTextField idField = new JTextField("ID");
        JPasswordField PwField = new JPasswordField();
        
        employButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        employButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        employButton.setHorizontalAlignment(JButton.CENTER);
        employButton.setVerticalAlignment(JButton.CENTER);
        employButton.setFont(new Font("돋움", Font.PLAIN, 20));
        employButton.setForeground(Color.WHITE);
        employButton.setBackground(Color.BLACK);
        employButton.setOpaque(true);
        employButton.setContentAreaFilled(false);
        employButton.setBorderPainted(false);
        employButton.setFocusPainted(false);
        employButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	
            }
        });
        partTimeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        partTimeButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        partTimeButton.setFont(new Font("돋움", Font.PLAIN,20));
        partTimeButton.setForeground(Color.WHITE);
        partTimeButton.setBackground(Color.BLACK);
        partTimeButton.setOpaque(true);
        partTimeButton.setContentAreaFilled(false);
        partTimeButton.setBorderPainted(false);
        partTimeButton.setFocusPainted(false);
       

        employButton.setFocusPainted(false);
        partTimeButton.setFocusPainted(false);

        employButton.setMaximumSize(new Dimension(200,40));
        partTimeButton.setMaximumSize(new Dimension(200,40));
        idField.setMaximumSize(new Dimension(200,40));
        PwField.setMaximumSize(new Dimension(200,40));

        mainPanel.add(Box.createVerticalStrut(50)); // 상단 여백
        mainPanel.add(Box.createVerticalStrut(40)); // 이미지와 ID 사이의 간격
        mainPanel.add(idField);
        mainPanel.add(Box.createVerticalStrut(10)); // ID와 PW 사이의 간격
        mainPanel.add(PwField);
        mainPanel.add(Box.createVerticalStrut(100)); // 이미지와 버튼 사이의 간격
        mainPanel.add(employButton);
        mainPanel.add(Box.createVerticalStrut(20)); // 버튼 간의 간격
        mainPanel.add(partTimeButton);
        mainPanel.add(Box.createVerticalStrut(50)); // 하단 여백

        // 프레임에 메인 패널 추가
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
		new PTLogin();
	}
}