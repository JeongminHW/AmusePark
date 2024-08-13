package cmp.GUI;

import javax.swing.*;
import java.awt.*;

public class EmSignUp {
	
	public EmSignUp() {
		JFrame frame = new JFrame("Staff Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1, 5, 5));
        
        JTextField idField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JPasswordField confirmPasswordField = new JPasswordField(20);
        JTextField nameField = new JTextField(20);
        JTextField birthDateField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        
        String[] parts = {"어트랙션 A", "어트랙션 B", "어트랙션 C", "어트랙션 D", "사파리", "티켓/그리팅", "퍼레이드"};
        JComboBox<String> partComboBox = new JComboBox<>(parts);
        
        String[] ranks = {"사원", "대리", "과장", "차장", "부장"};
        JComboBox<String> rankComboBox = new JComboBox<>(ranks);
        
        JButton submitButton = new JButton("확인");
        
        panel.add(createLabeledPanel("아이디", idField));
        panel.add(createLabeledPanel("비밀번호", passwordField));
        panel.add(createLabeledPanel("비밀번호 확인", confirmPasswordField));
        panel.add(createLabeledPanel("이름", nameField));
        panel.add(createLabeledPanel("생년월일", birthDateField));
        panel.add(createLabeledPanel("전화번호", phoneNumberField));
        panel.add(createLabeledPanel("부서", partComboBox));
        panel.add(createLabeledPanel("직급", rankComboBox));
        panel.add(submitButton);
        
        frame.add(panel);
        frame.setVisible(true);
	}
    
    private static JPanel createLabeledPanel(String label, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel jLabel = new JLabel(label);
        panel.add(jLabel, BorderLayout.WEST);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }
    
    public static void main(String[] args) {
		new EmSignUp();
	}
}
