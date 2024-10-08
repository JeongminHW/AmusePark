package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

import DB.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;

public class Alba_Substitute extends JFrame {

	static String id;

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		Alba_Substitute.id = id;
	}

	private static DBConnectionMgr dbConnectionMgr = DBConnectionMgr.getInstance();

	static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JPanel upperPanel;
	JPanel calenderPanel;
	JPanel dateTitlePanel;
	JPanel dateContent1;
	JPanel dateContent2;
	JPanel dateContent3;
	JPanel dateContent4;
	JPanel downerTitlePanel;
	JPanel dateSPanel;
	JPanel dateSYearPanel = new JPanel();
	JPanel dateSMonthPanel = new JPanel();
	JPanel dateSDayPanel = new JPanel();
	JPanel dateEPanel = new JPanel();
	JPanel dateEYearPanel = new JPanel();
	JPanel dateEMonthPanel = new JPanel();
	JPanel dateEDayPanel = new JPanel();
	JPanel whoPanel = new JPanel();
	JPanel dateReasonPanel = new JPanel();
	JPanel dateReasonContentPanel = new JPanel();
	JPanel dateReasonContentContainer = new JPanel();
	JPanel linePanel1 = new DrawLine();
	JPanel linePanel2 = new DrawLine();
	JPanel linePanel3 = new DrawLine();
	JPanel linePanel4 = new DrawLine();
	JPanel linePanel5 = new DrawLine();
	JPanel linePanel6 = new DrawLine();
	JPanel linePanel7 = new DrawLine();
	JPanel longlinePanel = new DrawLine();
	FlowLayout flowLayout;
	FlowLayout fl_dateContent1;
	FlowLayout flowLayout_2;
	FlowLayout flowLayout_3;
	FlowLayout flowLayout_4;
	FlowLayout fl_downerTitlePanel;
	FlowLayout fl_dateSPanel;
	FlowLayout fl_dateEPanel = new FlowLayout();
	JTextField dateReasonTextField;
	JPanel dateContentPanelContainer;
	CentralDropShadowPanel upperLeftPanel = new CentralDropShadowPanel(6, Color.LIGHT_GRAY);
	CentralDropShadowPanel upperRightPanel = new CentralDropShadowPanel(6, Color.LIGHT_GRAY);
	CentralDropShadowPanel downerPanel = new CentralDropShadowPanel(6, Color.LIGHT_GRAY);
	JLabel dateTitleLabel;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel downerTitleLabel;
	JLabel dateSYearLabel = new JLabel("년");
	JLabel dateSMonthLabel = new JLabel("월");
	JLabel dateSDayLabel = new JLabel("일 부터");
	JLabel dateEYearLabel = new JLabel("년");
	JLabel dateEMonthLabel = new JLabel("월");
	JLabel dateEDayLabel = new JLabel("일 까지");
	JLabel whoLabel = new JLabel("대상");
	JLabel dateReasonLabel = new JLabel("사유");
	JButton closeButton;

	JComboBox dateSYearComboBox = new JComboBox<>();
	JComboBox dateSMonthComboBox = new JComboBox<>();
	JComboBox dateSDayComboBox = new JComboBox<>();
	JComboBox dateEYearComboBox = new JComboBox<>();
	JComboBox dateEMonthComboBox = new JComboBox<>();
	JComboBox dateEDayComboBox = new JComboBox<>();
	JComboBox whoComboBox = new JComboBox<>();
	JButton confirmButton = new RoundedButton("확인", 25);

	/**
	 * Create the frame.
	 * 
	 */
	public Alba_Substitute() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 500);
		setVisible(true);
		setTitle("알바 대타 신청 - " + id);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setBackground(Color.WHITE);

		setContentPane(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		upperPanel = new JPanel();
		mainPanel.add(upperPanel);
		upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));
		upperPanel.setOpaque(false);

		upperLeftPanel.setMaximumSize(new Dimension(300, 300));
		upperLeftPanel.setBackground(Color.WHITE);
		upperPanel.add(upperLeftPanel);
		upperLeftPanel.setLayout(new BoxLayout(upperLeftPanel, BoxLayout.Y_AXIS));

		calenderPanel = new CalendarPanel();
		calenderPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		calenderPanel.setOpaque(false);
		calenderPanel.setBorder(new EmptyBorder(15, 5, 15, 5));
		upperLeftPanel.add(calenderPanel);

		upperRightPanel.setMaximumSize(new Dimension(32767, 300));
		upperRightPanel.setPreferredSize(new Dimension(34, 300));
		upperRightPanel.setBackground(Color.WHITE);
		upperPanel.add(upperRightPanel);
		upperRightPanel.setLayout(new BoxLayout(upperRightPanel, BoxLayout.Y_AXIS));

		dateTitlePanel = new JPanel();
		dateTitlePanel.setOpaque(false);
		dateTitlePanel.setMaximumSize(new Dimension(32767, 40));
		flowLayout = (FlowLayout) dateTitlePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		upperRightPanel.add(dateTitlePanel);

		dateTitleLabel = new JLabel("일정");
		dateTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		dateTitlePanel.add(dateTitleLabel);

		dateContentPanelContainer = new JPanel();
		dateContentPanelContainer.setBorder(new EmptyBorder(0, 10, 0, 10));
		dateContentPanelContainer.setOpaque(false);
		upperRightPanel.add(dateContentPanelContainer);
		dateContentPanelContainer.setLayout(new BoxLayout(dateContentPanelContainer, BoxLayout.Y_AXIS));

		downerPanel.setBackground(Color.WHITE);
		mainPanel.add(downerPanel);
		downerPanel.setLayout(new BoxLayout(downerPanel, BoxLayout.Y_AXIS));

		downerTitlePanel = new JPanel();
		downerTitlePanel.setBorder(new EmptyBorder(0, 5, 0, 5));
		downerTitlePanel.setOpaque(false);
		fl_downerTitlePanel = (FlowLayout) downerTitlePanel.getLayout();
		fl_downerTitlePanel.setAlignment(FlowLayout.LEFT);
		downerPanel.add(downerTitlePanel);

		downerTitleLabel = new JLabel("대타 신청");
		downerTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		downerTitlePanel.add(downerTitleLabel);

		dateSPanel = new JPanel();
		dateSPanel.setOpaque(false);
		dateSPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		downerPanel.add(dateSPanel);
		fl_dateSPanel = new FlowLayout();
		fl_dateSPanel.setAlignment(FlowLayout.LEFT);
		dateSPanel.setLayout(fl_dateSPanel);

		dateSYearPanel.setOpaque(false);
		dateSYearPanel.setLayout(new BoxLayout(dateSYearPanel, BoxLayout.Y_AXIS));
		dateSPanel.add(dateSYearPanel);

		dateSYearComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateSYearComboBox.setFocusable(false);
		dateSYearPanel.add(dateSYearComboBox);
		dateSYearComboBox.setBackground(Color.WHITE);
		dateSYearComboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton button = new JButton("▼");
				button.setOpaque(false);
				// button.setBackground(Color.BLUE);
				button.setMaximumSize(new Dimension(10, 10));
				button.setPreferredSize(new Dimension(10, 10));

				button.setBorder(BorderFactory.createEmptyBorder()); // 버튼 경계선 제거
				button.setBorderPainted(false); // 경계선 페인팅 비활성화
				button.setContentAreaFilled(false); // 버튼 내부 채우기 비활성화
				button.setFocusPainted(false); // 포커스 경계선 비활성화
				button.setFocusable(false);
				button.setName("ComboBox.arrowButton"); // Mandatory, as per BasicComboBoxUI#createArrowButton().
				return button;
			}

			@Override
			protected void installDefaults() {
				super.installDefaults();
				LookAndFeel.uninstallBorder(dateSYearComboBox);
			}

		});

		linePanel1.setOpaque(false);
		dateSYearPanel.add(linePanel1);

		dateSYearLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		dateSPanel.add(dateSYearLabel);

		dateSMonthPanel.setOpaque(false);
		dateSMonthPanel.setLayout(new BoxLayout(dateSMonthPanel, BoxLayout.Y_AXIS));
		dateSPanel.add(dateSMonthPanel);

		dateSMonthComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateSMonthComboBox.setFocusable(false);
		dateSMonthPanel.add(dateSMonthComboBox);
		dateSMonthComboBox.setBackground(Color.WHITE);

		dateSMonthComboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton button = new JButton("▼");
				button.setOpaque(false);
				// button.setBackground(Color.BLUE);
				button.setMaximumSize(new Dimension(10, 10));
				button.setPreferredSize(new Dimension(10, 10));

				button.setBorder(BorderFactory.createEmptyBorder()); // 버튼 경계선 제거
				button.setBorderPainted(false); // 경계선 페인팅 비활성화
				button.setContentAreaFilled(false); // 버튼 내부 채우기 비활성화
				button.setFocusPainted(false); // 포커스 경계선 비활성화
				button.setFocusable(false);
				button.setName("ComboBox.arrowButton"); // Mandatory, as per BasicComboBoxUI#createArrowButton().
				return button;
			}

			@Override
			protected void installDefaults() {
				super.installDefaults();
				LookAndFeel.uninstallBorder(dateSMonthComboBox);
			}

		});

		linePanel2.setOpaque(false);
		dateSMonthPanel.add(linePanel2);

		dateSMonthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		dateSPanel.add(dateSMonthLabel);

		dateSDayPanel.setOpaque(false);
		dateSDayPanel.setLayout(new BoxLayout(dateSDayPanel, BoxLayout.Y_AXIS));
		dateSPanel.add(dateSDayPanel);

		dateSDayComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateSDayComboBox.setFocusable(false);
		dateSDayPanel.add(dateSDayComboBox);
		dateSDayComboBox.setBackground(Color.WHITE);

		dateSDayComboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton button = new JButton("▼");
				button.setOpaque(false);
				// button.setBackground(Color.BLUE);
				button.setMaximumSize(new Dimension(10, 10));
				button.setPreferredSize(new Dimension(10, 10));

				button.setBorder(BorderFactory.createEmptyBorder()); // 버튼 경계선 제거
				button.setBorderPainted(false); // 경계선 페인팅 비활성화
				button.setContentAreaFilled(false); // 버튼 내부 채우기 비활성화
				button.setFocusPainted(false); // 포커스 경계선 비활성화
				button.setFocusable(false);
				button.setName("ComboBox.arrowButton"); // Mandatory, as per BasicComboBoxUI#createArrowButton().
				return button;
			}

			@Override
			protected void installDefaults() {
				super.installDefaults();
				LookAndFeel.uninstallBorder(dateSDayComboBox);
			}

		});

		linePanel3.setOpaque(false);
		dateSDayPanel.add(linePanel3);

		dateSDayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		dateSPanel.add(dateSDayLabel);

		dateEPanel.setOpaque(false);
		dateEPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		downerPanel.add(dateEPanel);
		// dateEPanel.setLayout(new BoxLayout(dateEPanel, BoxLayout.X_AXIS));
		fl_dateEPanel.setAlignment(FlowLayout.LEFT);
		dateEPanel.setLayout(fl_dateEPanel);

		dateEYearPanel.setOpaque(false);
		dateEYearPanel.setLayout(new BoxLayout(dateEYearPanel, BoxLayout.Y_AXIS));

		dateEPanel.add(dateEYearPanel);

		dateEYearComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateEYearComboBox.setFocusable(false);
		dateEYearPanel.add(dateEYearComboBox);
		dateEYearComboBox.setBackground(Color.WHITE);

		dateEYearComboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton button = new JButton("▼");
				button.setOpaque(false);
				// button.setBackground(Color.BLUE);
				button.setMaximumSize(new Dimension(10, 10));
				button.setPreferredSize(new Dimension(10, 10));

				button.setBorder(BorderFactory.createEmptyBorder()); // 버튼 경계선 제거
				button.setBorderPainted(false); // 경계선 페인팅 비활성화
				button.setContentAreaFilled(false); // 버튼 내부 채우기 비활성화
				button.setFocusPainted(false); // 포커스 경계선 비활성화
				button.setFocusable(false);
				button.setName("ComboBox.arrowButton"); // Mandatory, as per BasicComboBoxUI#createArrowButton().
				return button;
			}

			@Override
			protected void installDefaults() {
				super.installDefaults();
				LookAndFeel.uninstallBorder(dateEYearComboBox);
			}

		});

		linePanel4.setOpaque(false);
		dateEYearPanel.add(linePanel4);

		dateEYearLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		dateEPanel.add(dateEYearLabel);

		dateEMonthPanel.setOpaque(false);
		dateEMonthPanel.setLayout(new BoxLayout(dateEMonthPanel, BoxLayout.Y_AXIS));

		dateEPanel.add(dateEMonthPanel);

		dateEMonthComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateEMonthComboBox.setFocusable(false);
		dateEMonthPanel.add(dateEMonthComboBox);
		dateEMonthComboBox.setBackground(Color.WHITE);

		dateEMonthComboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton button = new JButton("▼");
				button.setOpaque(false);
				// button.setBackground(Color.BLUE);
				button.setMaximumSize(new Dimension(10, 10));
				button.setPreferredSize(new Dimension(10, 10));

				button.setBorder(BorderFactory.createEmptyBorder()); // 버튼 경계선 제거
				button.setBorderPainted(false); // 경계선 페인팅 비활성화
				button.setContentAreaFilled(false); // 버튼 내부 채우기 비활성화
				button.setFocusPainted(false); // 포커스 경계선 비활성화
				button.setFocusable(false);
				button.setName("ComboBox.arrowButton"); // Mandatory, as per BasicComboBoxUI#createArrowButton().
				return button;
			}

			@Override
			protected void installDefaults() {
				super.installDefaults();
				LookAndFeel.uninstallBorder(dateEMonthComboBox);
			}

		});

		linePanel5.setOpaque(false);
		dateEMonthPanel.add(linePanel5);

		dateEMonthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		dateEPanel.add(dateEMonthLabel);

		dateEDayPanel.setOpaque(false);
		dateEDayPanel.setLayout(new BoxLayout(dateEDayPanel, BoxLayout.Y_AXIS));

		dateEPanel.add(dateEDayPanel);

		dateEDayComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateEDayComboBox.setFocusable(false);
		dateEDayPanel.add(dateEDayComboBox);
		dateEDayComboBox.setBackground(Color.WHITE);

		dateEDayComboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton button = new JButton("▼");
				button.setOpaque(false);
				// button.setBackground(Color.BLUE);
				button.setMaximumSize(new Dimension(10, 10));
				button.setPreferredSize(new Dimension(10, 10));

				button.setBorder(BorderFactory.createEmptyBorder()); // 버튼 경계선 제거
				button.setBorderPainted(false); // 경계선 페인팅 비활성화
				button.setContentAreaFilled(false); // 버튼 내부 채우기 비활성화
				button.setFocusPainted(false); // 포커스 경계선 비활성화
				button.setFocusable(false);
				button.setName("ComboBox.arrowButton"); // Mandatory, as per BasicComboBoxUI#createArrowButton().
				return button;
			}

			@Override
			protected void installDefaults() {
				super.installDefaults();
				LookAndFeel.uninstallBorder(dateEDayComboBox);
			}

		});

		// 콤보박스 설정
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DATE);

		dateSYearComboBox.addItem("선택");
		dateSMonthComboBox.addItem("선택");
		dateSDayComboBox.addItem("선택");
		dateEYearComboBox.addItem("선택");
		dateEMonthComboBox.addItem("선택");
		dateEDayComboBox.addItem("선택");
		for (int i = year; i < year + 5; i++) {
			dateSYearComboBox.addItem(Integer.toString(i));
			dateEYearComboBox.addItem(Integer.toString(i));
		}

		for (int i = 1; i < 13; i++) {
			if (i < 10) {
				dateSMonthComboBox.addItem("0" + Integer.toString(i));
				dateEMonthComboBox.addItem("0" + Integer.toString(i));
			} else {
				dateSMonthComboBox.addItem(Integer.toString(i));
				dateEMonthComboBox.addItem(Integer.toString(i));
			}
		}

		for (int i = 1; i < now.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; i++) {
			if (i < 10) {
				dateSDayComboBox.addItem("0" + Integer.toString(i));
				dateEDayComboBox.addItem("0" + Integer.toString(i));
			} else {
				dateSDayComboBox.addItem(Integer.toString(i));
				dateEDayComboBox.addItem(Integer.toString(i));
			}
		}

		linePanel6.setOpaque(false);
		dateEDayPanel.add(linePanel6);

		dateEDayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		dateEPanel.add(dateEDayLabel);

		whoPanel.setOpaque(false);
		whoPanel.setLayout(new BoxLayout(whoPanel, BoxLayout.Y_AXIS));

		loadSubstituteNames(whoComboBox); // 콤보박스에 알바 이름 로드
		whoComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		whoComboBox.setFocusable(false);
		whoPanel.add(whoComboBox);
		whoComboBox.setBackground(Color.WHITE);

		whoComboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton button = new JButton("▼");
				button.setOpaque(false);
				// button.setBackground(Color.BLUE);
				button.setMaximumSize(new Dimension(10, 10));
				button.setPreferredSize(new Dimension(10, 10));

				button.setBorder(BorderFactory.createEmptyBorder()); // 버튼 경계선 제거
				button.setBorderPainted(false); // 경계선 페인팅 비활성화
				button.setContentAreaFilled(false); // 버튼 내부 채우기 비활성화
				button.setFocusPainted(false); // 포커스 경계선 비활성화
				button.setFocusable(false);
				button.setName("ComboBox.arrowButton"); // Mandatory, as per BasicComboBoxUI#createArrowButton().
				return button;
			}

			@Override
			protected void installDefaults() {
				super.installDefaults();
				LookAndFeel.uninstallBorder(whoComboBox);
			}

		});

		linePanel7.setOpaque(false);
		whoPanel.add(linePanel7);

		dateEPanel.add(whoPanel);

		whoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		dateEPanel.add(whoLabel);

		dateReasonPanel.setBorder(new EmptyBorder(0, 5, 0, 5));
		dateReasonPanel.setOpaque(false);
		FlowLayout flowLayout_5 = (FlowLayout) dateReasonPanel.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		downerPanel.add(dateReasonPanel);

		dateReasonLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		dateReasonPanel.add(dateReasonLabel);

		dateReasonContentPanel.setOpaque(false);
		dateReasonContentPanel.setBorder(new EmptyBorder(0, 5, 5, 5));
		downerPanel.add(dateReasonContentPanel);
		dateReasonContentPanel.setLayout(new BorderLayout(0, 0));

		dateReasonContentContainer.setBorder(new EmptyBorder(0, 10, 0, 40));
		dateReasonContentContainer.setOpaque(false);
		dateReasonContentPanel.add(dateReasonContentContainer, BorderLayout.CENTER);
		dateReasonContentContainer.setLayout(new BoxLayout(dateReasonContentContainer, BoxLayout.Y_AXIS));

		dateReasonTextField = new JTextField();
		dateReasonTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateReasonTextField.setBorder(new EmptyBorder(0, 10, 0, 10));
		dateReasonContentContainer.add(dateReasonTextField);
		dateReasonTextField.setColumns(10);

		longlinePanel.setBorder(new EmptyBorder(0, 20, 0, 20));
		longlinePanel.setOpaque(false);
		dateReasonContentContainer.add(longlinePanel);

		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(Color.white);

		closeButton = new RoundedButton("닫기", 25);
		btnPanel.add(closeButton);

		confirmButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		confirmButton.setBackground(new Color(0, 148, 255));
		confirmButton.setForeground(Color.WHITE);
		btnPanel.add(confirmButton, BorderLayout.EAST);

		dateReasonContentPanel.add(btnPanel, BorderLayout.EAST);
		System.out.println(upperLeftPanel.getHeight());

		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String yearFromStr = (String) dateSYearComboBox.getSelectedItem();
				String monthFromStr = (String) dateSMonthComboBox.getSelectedItem();
				String dayFromStr = (String) dateSDayComboBox.getSelectedItem();
				String yearToStr = (String) dateEYearComboBox.getSelectedItem();
				String monthToStr = (String) dateEMonthComboBox.getSelectedItem();
				String dayToStr = (String) dateEDayComboBox.getSelectedItem();
				String substituteName = (String) whoComboBox.getSelectedItem();
				String reason = dateReasonTextField.getText();

				String startDate = String.format("%s-%s-%s 00:00:00", yearFromStr, monthFromStr, dayFromStr);
				String endDate = String.format("%s-%s-%s 23:59:59", yearToStr, monthToStr, dayToStr);

				Connection connection = null;
				PreparedStatement statement = null;
				ResultSet resultSet = null;

				try {
					connection = dbConnectionMgr.getConnection();

					// 알바 이름으로 아이디 찾기
					String getIdSql = "SELECT alba_id FROM alba WHERE alba_name = ?";
					statement = connection.prepareStatement(getIdSql);
					statement.setString(1, substituteName);
					resultSet = statement.executeQuery();

					String substituteId = null;
					if (resultSet.next()) {
						substituteId = resultSet.getString("alba_id");
					}

					if (substituteId != null) {
						// 대타 신청 저장
						String insertSql = "INSERT INTO alba_substitute (req_alba_id, sub_alba_id, sub_start, sub_end) VALUES (?, ?, ?, ?)";
						statement.close(); // 기존의 PreparedStatement를 닫습니다.
						statement = connection.prepareStatement(insertSql);
						statement.setString(1, id); // 신청자 id(임시)
						statement.setString(2, substituteId);
						statement.setString(3, startDate);
						statement.setString(4, endDate);
						statement.executeUpdate();
						JOptionPane.showMessageDialog(null, "대타 신청이 완료되었습니다.", "대타 신청", JOptionPane.PLAIN_MESSAGE);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "입력한 이름의 알바가 존재하지 않습니다.", "대타 신청",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "다시 시도해주세요", "대타 신청", JOptionPane.ERROR_MESSAGE);
				} finally {
					if (resultSet != null) {
						try {
							resultSet.close();
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
					if (statement != null) {
						try {
							statement.close();
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
					if (connection != null) {
						dbConnectionMgr.freeConnection(connection, statement);
					}
				}
			}
		});

		// 일정 데이터를 가져와서 표시하는 메서드 호출
		loadScheduleData(dateContentPanelContainer);

		if (getTitle().equals("알바 대타 신청 - null")) {
			dispose();
		}

	}

	private static void loadSubstituteNames(JComboBox<String> comboBox) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = dbConnectionMgr.getConnection();

			// 알바 이름 목록을 가져오는 SQL 쿼리
			String sql = "SELECT alba_name FROM alba";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			List<String> names = new ArrayList<>();
			while (resultSet.next()) {
				names.add(resultSet.getString("alba_name"));
			}

			// JComboBox에 알바 이름을 추가
			for (String name : names) {
				comboBox.addItem(name);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (connection != null) {
				dbConnectionMgr.freeConnection(connection, statement);
			}
		}
	}

	private void loadScheduleData(JPanel datePanel) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = dbConnectionMgr.getConnection();
			String query = "SELECT schedule_contents, DATE_FORMAT(schedule_start, '%m-%d') AS schedule_start, DATE_FORMAT(schedule_end, '%m-%d') AS schedule_end FROM SCHEDULE"; // 전체
																																													// 데이터를
																																													// 가져옴
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String content = resultSet.getString("schedule_contents");
				String startDate = resultSet.getString("schedule_start");
				String endDate = resultSet.getString("schedule_end");

				// 일정 정보를 화면에 추가
				JLabel scheduleLabel = new JLabel("● " + startDate + " ~ " + endDate + " " + content);
				scheduleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				datePanel.add(scheduleLabel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (connection != null)
				dbConnectionMgr.freeConnection(connection);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Alba_Substitute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
