package cmp.GUI;

import java.awt.*;
import javax.swing.*;

public class ToDoList {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        
        JPanel mainPanel = new JPanel(new GridLayout(6, 3, 10, 10));
        
        for (int i = 0; i < 5; i++) {
            JButton upButton = new JButton("▲");
            JButton downButton = new JButton("▼");
            JTextField taskField = new JTextField("Task " + (i + 1));
            JButton deleteButton = new JButton(new ImageIcon("delete_icon.png")); // 여기에 삭제 아이콘을 삽입 가능
            
            mainPanel.add(upButton);
            mainPanel.add(downButton);
            mainPanel.add(taskField);
            mainPanel.add(deleteButton);
            
        }
        
        JButton addButton = new JButton("+");
        mainPanel.add(addButton);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
