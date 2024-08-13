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

import cmp.DB.DBMgr;

public class EmLogin {
	DBMgr db = new DBMgr();

    public EmLogin() {
        JFrame frame = new JFrame("직원 로그인/회원가입");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));

        ImageIcon icon = new ImageIcon("src/image/TestImage.jpg"); // 이미지 경로를 입력
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // RoundedButton 클래스 사용
        JButton loginBtn = new RoundedButton("로그인", 32);
        JButton signupBtn = new RoundedButton("회원가입", 32);
        
        JTextField idField = new JTextField("ID");
        JPasswordField PwField = new JPasswordField();

        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.setAlignmentY(Component.CENTER_ALIGNMENT);
        loginBtn.setHorizontalAlignment(JButton.CENTER);
        loginBtn.setVerticalAlignment(JButton.CENTER);
        loginBtn.setFont(new Font("돋움", Font.PLAIN, 20));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setOpaque(true);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setBorderPainted(false);
        loginBtn.setFocusPainted(false);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	String id = idField.getText();
            	String pw = new String(PwField.getPassword());
            	if(db.EmployeeLoginCheck(id, pw)) {
            		System.out.println(pw);
            		System.out.println("로그인 성공");
            		new MainUI();
                    frame.dispose();
            	}
            	else {
            		System.out.println("로그인 실패");
            	}
            }
        });
        signupBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupBtn.setAlignmentY(Component.CENTER_ALIGNMENT);
        signupBtn.setFont(new Font("돋움", Font.PLAIN,20));
        signupBtn.setForeground(Color.WHITE);
        signupBtn.setBackground(Color.BLACK);
        signupBtn.setOpaque(true);
        signupBtn.setContentAreaFilled(false);
        signupBtn.setBorderPainted(false);
        signupBtn.setFocusPainted(false);
        signupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new EmSignUp();
                //System.out.println("PartTime");
                frame.dispose();
            }
        });
       


        loginBtn.setMaximumSize(new Dimension(200,40));
        signupBtn.setMaximumSize(new Dimension(200,40));
        idField.setMaximumSize(new Dimension(200,40));
        PwField.setMaximumSize(new Dimension(200,40));

        
        mainPanel.add(Box.createVerticalStrut(50)); // 상단 여백
        mainPanel.add(imageLabel);
        mainPanel.add(Box.createVerticalStrut(40)); // 이미지와 ID 사이의 간격
        mainPanel.add(idField);
        mainPanel.add(Box.createVerticalStrut(10)); // ID와 PW 사이의 간격
        mainPanel.add(PwField);
        mainPanel.add(Box.createVerticalStrut(100)); // 이미지와 버튼 사이의 간격
        mainPanel.add(loginBtn);
        mainPanel.add(Box.createVerticalStrut(20)); // 버튼 간의 간격
        mainPanel.add(signupBtn);
        mainPanel.add(btnPanel);
        mainPanel.add(Box.createVerticalStrut(50)); // 하단 여백

        // 프레임에 메인 패널 추가
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
		new EmLogin();
	}
    
}
