package cmp.GUI;

import java.awt.*;
import javax.swing.*;

public class VacationRequest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Vacation Request");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        
        // 캘린더 패널
        JPanel calendarPanel = createCalendarPanel();
        
        // 일정 패널
        JPanel schedulePanel = createSchedulePanel();
        
        // 휴가 신청 패널
        JPanel vacationPanel = createVacationPanel();
        
        // 레이아웃 구성
        mainPanel.add(calendarPanel, BorderLayout.WEST);
        mainPanel.add(schedulePanel, BorderLayout.CENTER);
        mainPanel.add(vacationPanel, BorderLayout.EAST);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    private static JPanel createCalendarPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel monthLabel = new JLabel("8월", SwingConstants.CENTER);
        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(prevButton, BorderLayout.WEST);
        topPanel.add(monthLabel, BorderLayout.CENTER);
        topPanel.add(nextButton, BorderLayout.EAST);
        
        String[] days = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
        JPanel dayPanel = new JPanel(new GridLayout(7, 7, 5, 5));
        for (String day : days) {
            dayPanel.add(new JLabel(day, SwingConstants.CENTER));
        }
        
        for (int i = 1; i <= 31; i++) {
            JButton dayButton = new JButton(String.valueOf(i));
            dayButton.setBackground(i == 6 ? Color.CYAN : Color.YELLOW);
            dayPanel.add(dayButton);
        }
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(dayPanel, BorderLayout.CENTER);
        return panel;
    }
    
    private static JPanel createSchedulePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("일정");
        JTextArea scheduleArea = new JTextArea("08/09 ~ 08/13 - 퍼레이드\nAA\nBB\nCC");
        
        panel.add(label, BorderLayout.NORTH);
        panel.add(new JScrollPane(scheduleArea), BorderLayout.CENTER);
        return panel;
    }
    
    private static JPanel createVacationPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("휴가 신청"));
        
        JComboBox<String> yearFrom = new JComboBox<>(generateYears());
        JComboBox<String> monthFrom = new JComboBox<>(generateMonths());
        JComboBox<String> dayFrom = new JComboBox<>(generateDays());
        
        JComboBox<String> yearTo = new JComboBox<>(generateYears());
        JComboBox<String> monthTo = new JComboBox<>(generateMonths());
        JComboBox<String> dayTo = new JComboBox<>(generateDays());
        
        JTextField reasonField = new JTextField();
        JLabel daysLeftLabel = new JLabel("남은 휴가일수: 12일");
        
        JButton submitButton = new JButton("확인");
        
        panel.add(yearFrom);
        panel.add(new JLabel("년"));
        panel.add(monthFrom);
        panel.add(new JLabel("월"));
        panel.add(dayFrom);
        panel.add(new JLabel("일"));
        

        panel.add(yearTo);
        panel.add(new JLabel("년"));
        panel.add(monthTo);
        panel.add(new JLabel("월"));
        panel.add(dayTo);
        panel.add(new JLabel("일"));
        
        panel.add(reasonField);
        panel.add(new JLabel("사유"));
        
        panel.add(daysLeftLabel);
        panel.add(submitButton);
        
        return panel;
    }
    
    private static String[] generateYears() {
        String[] years = new String[5];
        int currentYear = 2024;
        for (int i = 0; i < 5; i++) {
            years[i] = String.valueOf(currentYear - i);
        }
        return years;
    }
    
    private static String[] generateMonths() {
        String[] months = new String[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = String.valueOf(i);
        }
        return months;
    }
    
    private static String[] generateDays() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }
        return days;
    }
}
