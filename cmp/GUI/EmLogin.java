package cmp.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cmp.DB.DBMgr;
import cmp.DB.EmployeeBean;
import cmp.GUI.*;

public class EmLogin {
	DBMgr db = new DBMgr();
	EmployeeBean bean = new EmployeeBean();

    public EmLogin() {
        JFrame frame = new JFrame("직원 로그인/회원가입");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
        
        JTextField idField = new JTextField();
        JPasswordField PwField = new JPasswordField();
        
        // RoundedButton 클래스 사용
        JButton loginBtn = new RoundedButton("로그인", 32);
        JButton signupBtn = new RoundedButton("회원가입", 32);

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
        
        signupBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupBtn.setAlignmentY(Component.CENTER_ALIGNMENT);
        signupBtn.setFont(new Font("돋움", Font.PLAIN,20));
        signupBtn.setForeground(Color.WHITE);
        signupBtn.setBackground(Color.BLACK);
        signupBtn.setOpaque(true);
        signupBtn.setContentAreaFilled(false);
        signupBtn.setBorderPainted(false);
        signupBtn.setFocusPainted(false);
        
        
        // 이벤트
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	String id = idField.getText();
            	String pw = new String(PwField.getPassword());
            	if(db.EmployeeLoginCheck(id, pw)) {
            		System.out.println("로그인 성공");
            		MainUI mainUI = new MainUI();
					mainUI.setId(id);
					new MainUI();
                    frame.dispose();
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "아이디/비밀번호를 다시 입력해주세요.", null, JOptionPane.ERROR_MESSAGE);
            		System.out.println("로그인 실패");
            	}
            }
        });

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

        
        mainPanel.add(Box.createVerticalStrut(100)); // 상단 여백
        mainPanel.add(idField);
        mainPanel.add(Box.createVerticalStrut(10)); // ID와 PW 사이의 간격
        mainPanel.add(PwField);
        mainPanel.add(Box.createVerticalStrut(200)); // 이미지와 버튼 사이의 간격
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
