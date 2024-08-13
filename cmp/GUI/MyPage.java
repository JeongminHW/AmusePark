package cmp.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import cmp.DB.*;

public class MyPage implements ActionListener{
	static String id = null;
	
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	DBMgr db = new DBMgr();

	JPanel mainPanel = new JPanel(new GridLayout(10, 2, 10, 10));
    JLabel idLabel = new JLabel("ID");
    JLabel nameLabel = new JLabel("이름");
    JLabel currentPasswordLabel = new JLabel("현재 비밀번호");
    JLabel newPasswordLabel = new JLabel("새 비밀번호");
    JLabel confirmPasswordLabel = new JLabel("비밀번호 확인");
    JLabel phoneLabel = new JLabel("전화번호");
    JLabel positionLabel = new JLabel("직급");
    JLabel adminLabel = new JLabel("관리자 여부");
    
    JTextField idField = new JTextField(getId());
    JTextField nameField = new JTextField("");
    JPasswordField currentPasswordField = new JPasswordField("");
    JPasswordField newPasswordField = new JPasswordField("");
    JPasswordField confirmPasswordField = new JPasswordField("");
    JTextField phoneField = new JTextField("");
    JTextField positionField = new JTextField("");
    JCheckBox adminCheckBox = new JCheckBox("YES");
    JButton saveButton = new RoundedButton("저장", 20);
    JButton cancelButton = new RoundedButton("취소", 20);
	
	public MyPage() {
		JFrame frame = new JFrame("마이페이지");
		frame.setTitle("마이페이지 - " + getId());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        System.out.println(getId());
        
        idField.setEnabled(false);
        idField.setForeground(Color.black);
        positionField.setEnabled(false);
        
        boolean checkboxSelect = adminCheckBox.isSelected();
		/*
		 * adminCheckBox.addItemListener(new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) { if(checkboxSelect) {
		 * db.ManagerEmployee(getId()); } } });
		 */
        
        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);

        mainPanel.setBackground(Color.white);
        
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
	
    public static void main(String[] args) {
        new MyPage();
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(adminCheckBox.isSelected());
	}
}
