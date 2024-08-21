package cmp.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import cmp.DB.*;

public class EmployeeMain {
	static String id;
	CardLayout cardLayout;
	JPanel cardPanel;
	private DefaultListModel<String> friendListModel;
	private DefaultListModel<String> chatListModel;
	private Vector<EmployeeBean> emvlist;
	private Vector<EmployeeBean> em2vlist;
	private Vector<chatListBean> cvlist;
	private Vector<chatListBean> c2vlist;
	private Vector<chatContentsBean> ccvlist;
	private chatManager cm = new chatManager();

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		EmployeeMain.id = id;
	}

	public static final Color LIGHT_ONE = new Color(200, 200, 200);
	public static final Color REAL_LIGHT = new Color(228, 228, 228);
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel calendarPanel = new CalendarPanel();
	JPanel appPanel = new JPanel();
	JPanel upperLeft = new JPanel();
	JPanel downerLeft = new JPanel();
	JPanel left = new JPanel();
	JPanel right = new JPanel();
	JPanel todoPanel = new JPanel();
	JPanel TodoTitle = new JPanel();
	JPanel chatTitle = new JPanel();
	JPanel chatlistPanel = new JPanel();
	CentralDropShadowPanel calendarContainer = new CentralDropShadowPanel(6, Color.LIGHT_GRAY);
	CentralDropShadowPanel todoContainer = new CentralDropShadowPanel(6, Color.LIGHT_GRAY);
	CentralDropShadowPanel appContainer = new CentralDropShadowPanel(6, Color.LIGHT_GRAY);
	CentralDropShadowPanel chatBox = new CentralDropShadowPanel(6, Color.LIGHT_GRAY);
	ImageIcon vacation_icon = new ImageIcon("./cmp/IMG/vacation_img.png");
	ImageIcon date_icon = new ImageIcon("./cmp/IMG/schedule_img.png");
	ImageIcon mypage_icon = new ImageIcon("./cmp/IMG/user_img.png");
	ImageIcon todo_icon = new ImageIcon("./cmp/IMG/todo_img.png");
	ImageIcon ask_icon = new ImageIcon("./cmp/IMG/question_img.png");
	ImageIcon work_icon = new ImageIcon("./cmp/IMG/commute_img.png");
	ImageIcon userCheck_icon = new ImageIcon("./cmp/IMG/park_img.png");
	ImageIcon itemCheck_icon = new ImageIcon("./cmp/IMG/manage_img.png");
	ImageIcon chat_icon = new ImageIcon("./cmp/IMG/chat_img.png");
	JPanel vacation = new Appmake(25, "휴가", vacation_icon, "휴가");
	JPanel date = new Appmake(25, "일정", date_icon, "일정");
	JPanel myPage = new Appmake(25, "마이페이지", mypage_icon, "마이페이지");
	JPanel ask = new Appmake(25, "문의사항", todo_icon, "문의사항");
	JPanel todo = new Appmake(25, "할일", ask_icon, "할일");
	JPanel work = new Appmake(25, "출근/퇴근", work_icon, "출퇴근");
	JPanel userCheck = new Appmake(25, "사용자 집계", userCheck_icon, "집계");
	JPanel itemCheck = new Appmake(25, "물품 관리", itemCheck_icon, "관리");
	JLabel TodolistLabel = new JLabel("할일");
	JLabel chat = new JLabel("채팅");
	JTextArea stringContainer;
	JTextArea chatRoomName;
	JTextArea recentChat;

	DBMgr db = new DBMgr();

	public EmployeeMain() {
		Appmake.setId(id);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 600);
		frame.setVisible(true);
		frame.setTitle("직원 - " + id);

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.setBackground(Color.WHITE);

		upperLeft.setLayout(new BoxLayout(upperLeft, BoxLayout.X_AXIS));
		upperLeft.setBackground(Color.WHITE);

		calendarContainer.setLayout(new BoxLayout(calendarContainer, BoxLayout.Y_AXIS));
		calendarContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		appPanel.setLayout(new BoxLayout(appPanel, BoxLayout.X_AXIS));
		appPanel.setBackground(Color.WHITE);

		appContainer.setLayout(new BoxLayout(appContainer, BoxLayout.Y_AXIS));
		appContainer.setBackground(Color.WHITE);
		appContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.setOpaque(false);

		chatBox.setLayout(new BoxLayout(chatBox, BoxLayout.Y_AXIS));
		chatBox.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

		todoPanel.setLayout(new BoxLayout(todoPanel, BoxLayout.Y_AXIS));
		todoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setBackground(Color.WHITE);

		calendarContainer.setBackground(Color.WHITE);
		downerLeft.setBackground(Color.DARK_GRAY);
		// calendarPanel.setBackground(Color.GREEN);
		todoPanel.setBackground(Color.WHITE);

		chatBox.setBackground(Color.WHITE);
		left.setBackground(Color.WHITE);
		todoContainer.setBackground(Color.WHITE);

		// Todo Panel
		todoPanel.setPreferredSize(new Dimension(260, 200));

		TodoTitle.setLayout(new BoxLayout(TodoTitle, BoxLayout.X_AXIS));
		TodoTitle.setOpaque(false);
		TodolistLabel.setFont(new Font("돋움", Font.BOLD, 24));
		TodoTitle.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		TodoTitle.add(TodolistLabel);
		TodoTitle.add(Box.createHorizontalStrut(200));
		todoPanel.add(TodoTitle);

		for (int i = 0; i < 5; i++) {
			String str = "AAAAAA";
			stringContainer = new JTextArea();
			stringContainer.setEditable(false);
			stringContainer.setFocusable(false);
			stringContainer.setText(" ● " + str);
			todoPanel.add(stringContainer);
		}

		// chatbox
		chatBox.setBorder(BorderFactory.createEmptyBorder(5, 6, 20, 6));
		chatTitle.setOpaque(false);
		chatBox.add(chatTitle);
		chatTitle.setOpaque(false);
		chatBox.add(chatTitle, BorderLayout.NORTH);
		chatTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		chatTitle.add(buttonPanel, BorderLayout.NORTH);

		JButton friendButton = new RoundedButton("친구창", 20);
		friendListModel = new DefaultListModel<>();
		friendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		friendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		friendButton.setHorizontalTextPosition(SwingConstants.CENTER);
		friendButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		friendButton.setBackground(new Color(102, 204, 0));
		friendButton.setForeground(Color.WHITE);
		buttonPanel.add(friendButton);

		JButton chatButton = new RoundedButton("채팅창", 20);
		chatListModel = new DefaultListModel<>();
		chatButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chatButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		chatButton.setHorizontalTextPosition(SwingConstants.CENTER);
		chatButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		chatButton.setBackground(new Color(51, 153, 255));
		chatButton.setForeground(Color.WHITE);

		JPanel card1 = new JPanel();
		card1.setOpaque(false);
		card1.setBackground(Color.MAGENTA);
		card1.setLayout(new BoxLayout(card1, BoxLayout.Y_AXIS));

		JPanel card2 = new JPanel();
		card2.setOpaque(false);
		card2.setBackground(Color.BLUE);

		cardPanel.add(card1, "Card 1");
		cardPanel.add(card2, "Card 2");

		JPanel contentPanel1 = new JPanel();
		contentPanel1.setOpaque(false);
		card1.add(contentPanel1);
		card2.setLayout(new BorderLayout(0, 0));

		JPanel contentPanel2 = new JPanel();
		contentPanel2.setOpaque(false);
		card2.add(contentPanel2);
		contentPanel2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		cvlist = cm.selectChat(id);

		chatListModel.clear(); // 기존 데이터를 제거합니다

		for (int i = 0; i < cvlist.size(); i++) {
			if (cvlist.get(i) != null) {
				String str = cvlist.get(i).getChatroom_name();
				chatListModel.addElement(str); // 새로운 데이터 추가
			}
		}
		JList<String> chatList = new JList(chatListModel);
		chatList.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		contentPanel2.add(chatList);

		JPanel addChatPanel = new JPanel();
		addChatPanel.setOpaque(false);
		addChatPanel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		card2.add(addChatPanel, BorderLayout.SOUTH);
		addChatPanel.setLayout(new BorderLayout(0, 0));

		JButton addChatButton = new RoundedButton("채팅생성", 20);
		addChatButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addChatButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		addChatButton.setBackground(new Color(51, 153, 255));
		addChatButton.setForeground(Color.WHITE);
		addChatPanel.add(addChatButton);

		contentPanel1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		emvlist = cm.selectEmployee(id);

		for (int i = 0; i < emvlist.size(); i++) {
			if (emvlist.get(i) != null) {
				String str = emvlist.get(i).getName() + " " + emvlist.get(i).getPosition() + " ("
						+ emvlist.get(i).getDepartment() + ")";
				friendListModel.addElement(str);

				boolean flag = cm.chatCheck(id, emvlist.get(i).getId());

				if (flag) {
					// 기존 채팅방이 존재할 때
					System.out.println("true");

				} else {
					// 새로운 채팅방을 생성해야 할 때
					System.out.println("false");
					System.out.println(id + " : " + emvlist.get(i).getId());

					if (cm.createPrivateChat(id, emvlist.get(i).getId())) {
						System.out.println("성공");

						// 채팅방을 생성한 후 다시 c2vlist를 업데이트

					}
				}

			}
		}
		JList<String> FriendList = new JList(friendListModel);
		FriendList.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		contentPanel1.add(FriendList);

		// 친구 목록 만들기 끝 //
		chatBox.add(cardPanel);

		// Sizes
		left.setPreferredSize(new Dimension(720, 600));
		chatBox.setMaximumSize(new Dimension(450, 600));
		upperLeft.setMaximumSize(new Dimension(700, 350));
		downerLeft.setMaximumSize(new Dimension(700, 240));
		calendarContainer.setMaximumSize(new Dimension(350, 350));
		todoContainer.setMaximumSize(new Dimension(340, 350));
		// appContainer.setMaximumSize(new Dimension(700,240));
		appPanel.setMaximumSize(new Dimension(660, 200));

		right.setPreferredSize(new Dimension(450, 600));
		chatBox.setPreferredSize(new Dimension(430, 510));
		appPanel.add(vacation);
		appPanel.add(Box.createHorizontalStrut(20));
		appPanel.add(date);
		appPanel.add(Box.createHorizontalStrut(20));
		appPanel.add(myPage);
		appPanel.add(Box.createHorizontalStrut(20));
		appPanel.add(ask);
		appPanel.add(Box.createHorizontalStrut(20));
		appPanel.add(todo);
		appPanel.add(Box.createHorizontalStrut(20));
		appPanel.add(work);
		appPanel.add(Box.createHorizontalStrut(20));
		appPanel.add(userCheck);
		appPanel.add(Box.createHorizontalStrut(20));
		appPanel.add(itemCheck);

		calendarContainer.add(calendarPanel);
		todoContainer.add(todoPanel);
		appContainer.add(appPanel);

		upperLeft.add(calendarContainer);
		upperLeft.add(Box.createHorizontalStrut(10));
		upperLeft.add(todoContainer);

		// left.add(Box.createHorizontalStrut(10));
		left.add(upperLeft);
		left.add(appContainer);
		left.add(Box.createHorizontalStrut(20));
		left.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		right.setBorder(BorderFactory.createEmptyBorder(12, 0, 20, 20));
		right.add(chatBox);
		// left.add(Box.createHorizontalStrut(10));

		mainPanel.add(left);
		mainPanel.add(right);
		// mainPanel.add(Box.createHorizontalStrut(10));

		frame.add(mainPanel);
		frame.setResizable(false);
		frame.setVisible(true);

		// 이벤트
		friendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Card 1");
			}
		});

		buttonPanel.add(chatButton);
		chatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Card 2");
			}
		});

		addChatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							chatCreate frame = new chatCreate(id);
							frame.setVisible(true);
							frame.addWindowListener(new WindowAdapter() {
								@Override
								public void windowClosed(WindowEvent e) {
									// 창이 닫힐 때 업데이트할 작업 수행
									updateChatPanel();
								}
							});
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		chatList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int index = chatList.getSelectedIndex();
					if (index != -1) {
						String chatRoomName = chatList.getSelectedValue();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									chatRoom frame = new chatRoom(cvlist.get(index).getChat_no(), chatRoomName, id);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				}
			}
		});

		FriendList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int selectedIndex = FriendList.getSelectedIndex();
					if (selectedIndex == -1) {
						return; // 아무 항목도 선택되지 않았을 때
					}
					emvlist = cm.selectEmployee(id);
					System.out.println(emvlist.get(selectedIndex).getId());
					System.out.println("성공");
					String chatRoomName = FriendList.getSelectedValue();
					int chat_no = cm.selectPrivateChat(id, emvlist.get(selectedIndex).getId()).get(0).getChat_no();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								chatRoom frame = new chatRoom(chat_no, chatRoomName, id);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});

	}

	public void updateTodoPanel() {
		// 할일 목록 받아오기 (예시: DBMgr를 통해)
		Vector<TodoBean> todoList = db.selectTodo("asdf123"); // 이 부분은 실제 DB 호출로 수정 필요

		// 기존 할일 항목 제거
		todoPanel.removeAll();

		// 새로운 할일 항목 추가
		TodoTitle.setLayout(new BoxLayout(TodoTitle, BoxLayout.X_AXIS));
		TodolistLabel.setFont(new Font("돋움", Font.BOLD, 24));
		TodoTitle.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		TodoTitle.add(TodolistLabel);
		TodoTitle.add(Box.createHorizontalStrut(200));
		todoPanel.add(TodoTitle);

		for (TodoBean item : todoList) {
			stringContainer = new JTextArea();
			stringContainer.setEditable(false);
			stringContainer.setFocusable(false);
			stringContainer.setText(" ● " + item);
			todoPanel.add(stringContainer);
		}

		// 패널 업데이트
		todoPanel.revalidate();
		todoPanel.repaint();
	}

	private void updateChatPanel() {
		// 채팅 리스트 모델 및 JList 생성
		cvlist = cm.selectChat(id);

		// 채팅 리스트 모델 초기화
		chatListModel.clear(); // 기존 데이터를 제거합니다

		for (int i = 0; i < cvlist.size(); i++) {
			if (cvlist.get(i) != null) {
				String str = cvlist.get(i).getChatroom_name();
				chatListModel.addElement(str); // 새로운 데이터 추가
			}
		}

		// 변경 사항을 반영
		frame.revalidate();
		frame.repaint();
	}

	public static void main(String[] args) {
		new EmployeeMain();
	}

}
