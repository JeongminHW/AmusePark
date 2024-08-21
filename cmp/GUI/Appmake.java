package cmp.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Appmake extends JPanel implements ActionListener {
	JLabel appLabel;
	JButton appButton;
	String ButtonName;
	static String id;

	public static void setId(String id) {
		Appmake.id = id;
	}

	public Appmake(int radius, String label) {
		appButton = new RoundedButton("", 20);
		appLabel = new JLabel(label);

		// appButton.setMinimumSize(new Dimension(50,50)); // 최소 크기 설정
		// appButton.setMaximumSize(new Dimension(50,50)); // 최대 크기 설정
		appButton.setBorder(null);
		appButton.setFocusable(false);
		appButton.setBackground(Color.white);

		appLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		appLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(null);
		setBackground(Color.WHITE);

		add(appButton);
		add(Box.createVerticalStrut(10)); // 간격 조정
		add(appLabel);
	}

	public Appmake(int radius, String label, ImageIcon icon, String btnname) {
		appButton = new RoundedButton(icon, radius);
		appLabel = new JLabel(label);
		ButtonName = btnname;

		appButton.setMinimumSize(new Dimension(60, 60)); // 최소 크기 설정
		appButton.setMaximumSize(new Dimension(60, 60)); // 최대 크기 설정
		appButton.setBorder(null);
		appButton.setFocusable(false);
		appButton.setBackground(Color.white);
		appButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		appButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		appLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		appLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

		/*
		 * appButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("11"); } });
		 */
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(null);
		setBackground(Color.WHITE);

		add(appButton);
		add(Box.createVerticalStrut(10)); // 간격 조정
		add(appLabel);
		// 아이콘으로 초기화하는 생성자 구현 (필요 시)

		appButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == appButton) {
			try {
				handleButtonAction(ButtonName);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void handleButtonAction(String identifier) throws ParseException {
		if (identifier == null) {
			System.out.println("Unknown button clicked: identifier is null");
			return;
		}

		switch (ButtonName) {
		case "휴가":
			Vacation va = new Vacation();
			break;
		case "일정":
			NoticeCreate nc = new NoticeCreate();
			nc.setId(id);
			break;
		case "마이페이지":
			MyPage mypage = new MyPage();
			mypage.setAlba_id(id);
			new MyPage();
			break;
		case "문의사항":
			System.out.println("문의사항 button clicked");
			break;
		case "할일":
			ToDoList todolist = new ToDoList();
			todolist.setEm_id(id);
			System.out.println("할일 button clicked");
			break;
		case "출퇴근":
			System.out.println("출근/퇴근 button clicked");
			break;
		case "집계":
			System.out.println("사용자 집계 button clicked");
			break;
		case "관리":
			System.out.println("물품 관리 button clicked");
			break;
		default:
			System.out.println("Unknown button clicked: " + identifier);
			break;
		}
	}
}
