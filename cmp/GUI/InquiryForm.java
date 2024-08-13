package cmp.GUI;

import javax.swing.*;
import java.awt.*;

public class InquiryForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("문의사항 작성");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        
        JTextField titleField = new JTextField();
        titleField.setText("제목을 입력하세요");
        
        JTextArea contentArea = new JTextArea("내용을 입력하세요");
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton cancelButton = new JButton("취소");
        JButton submitButton = new JButton("작성");
        
        buttonPanel.add(cancelButton);
        buttonPanel.add(submitButton);
        
        mainPanel.add(new JLabel("제목"), BorderLayout.NORTH);
        mainPanel.add(titleField, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(contentArea), BorderLayout.SOUTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
