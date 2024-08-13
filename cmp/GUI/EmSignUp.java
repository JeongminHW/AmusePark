package cmp.GUI;

import javax.swing.*;
import javax.swing.border.Border;

import com.teamdev.jxbrowser.deps.org.checkerframework.checker.units.qual.s;

import cmp.DB.DBMgr;
import cmp.DB.EmployeeBean;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmSignUp implements ActionListener {
	String[] ranks = { "사원", "대리", "과장", "차장", "부장" };
	String[] parts = { "어트랙션 A", "어트랙션 B", "어트랙션 C", "어트랙션 D", "사파리", "티켓/그리팅", "퍼레이드" };
	JFrame frame = new JFrame("Staff Sign Up");
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JTextField idField = new JTextField(20);
	JPasswordField passwordField = new JPasswordField(20);
	JPasswordField confirmPasswordField = new JPasswordField(20);
	JTextField nameField = new JTextField(20);
	JTextField birthDateField = new JTextField(20);
	JTextField phoneNumberField = new JTextField(20);
	JComboBox<String> partComboBox = new JComboBox<>(parts);
	JComboBox<String> rankComboBox = new JComboBox<>(ranks);
	JButton submitButton = new RoundedButton("확인", 20);
	JButton cancelButton = new RoundedButton("취소", 20);
	
	DBMgr db = new DBMgr();

	public EmSignUp() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 500);

		panel.setLayout(new GridLayout(9, 2, 5, 5));

		partComboBox.setBackground(Color.white);
		partComboBox.addActionListener(this);

		rankComboBox.setBackground(Color.white);
		rankComboBox.addActionListener(this);

		submitButton.setBackground(new Color(209, 233, 246));
		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);

		// 마우스 커서 모양 변경
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		JButton idchkButton = new RoundedButton("중복확인", 20);
		idchkButton.setBounds(70, 10, 100, 30);
		idchkButton.setForeground(Color.white);
		idchkButton.setBackground(Color.black);
		panel.add(new JLabel("아이디"));
		panel.add(idField);
		panel.add(new JLabel("비밀번호"));
		panel.add(passwordField);
		panel.add(new JLabel("비밀번호 확인"));
		panel.add(confirmPasswordField);
		panel.add(new JLabel("이름"));
		panel.add(nameField);
		panel.add(new JLabel("생년월일"));
		panel.add(birthDateField);
		panel.add(new JLabel("전화번호"));
		panel.add(phoneNumberField);
		panel.add(new JLabel("부서"));
		panel.add(partComboBox);
		panel.add(new JLabel("직급"));
		panel.add(rankComboBox);
		panel.setBackground(Color.white);
		panel.add(cancelButton);
		panel.add(submitButton);

		frame.add(idchkButton);
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

	//회원가입 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = idField.getText();
		String pw = new String(passwordField.getPassword());
		String pwchk = new String(confirmPasswordField.getPassword());
		String name = nameField.getText();
		String birthday = birthDateField.getText();
		String phone = phoneNumberField.getText();
		String part = partComboBox.getSelectedItem().toString();
		String rank = rankComboBox.getSelectedItem().toString();
		EmployeeBean bean = new EmployeeBean();

		if (e.getSource() == submitButton) { // 확인버튼 클릭
			if (!id.equals("") && !pw.equals("") && !pwchk.equals("") && !name.equals("") && !birthday.equals("") && !phone.equals("")) {
				if (pw.equals(pwchk) && !pw.equals("") && !pwchk.equals("")) { // 비밀번호가 같을 경우
					bean.setId(id);
					bean.setPw(pw);
					bean.setName(name);
					bean.setBirthday(birthday);
					bean.setPhone(phone);
					bean.setPosition(rank);
					bean.setDepartment(part);
					db.signupEmployee(bean);
					db.VacationEmployee(bean);
					JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다.", "회원가입 성공", JOptionPane.PLAIN_MESSAGE);
					new EmLogin();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				if(id.equals("")) //아이디 공란
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", null, JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (e.getSource() == cancelButton) { // 취소 버튼 클릭
			System.out.println("1");
			new EmLogin();
			frame.dispose();
		}
	}


	public static void main(String[] args) {
		new EmSignUp();
	}
}
