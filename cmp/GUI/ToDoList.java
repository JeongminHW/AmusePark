package GUI;

import java.awt.*;
import javax.swing.*;

public class ToDoList {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 

        ImageIcon icon = new ImageIcon("src/image/plus.png");

        CentralDropShadowPanel topPanel = new CentralDropShadowPanel(6,Color.LIGHT_GRAY);
        JTextField newTodo = new JTextField();
        JButton plusButton = new RoundedButton(icon, 25);
        
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        newTodo.setBorder(null);
        newTodo.setBackground(Color.WHITE);
        topPanel.setPreferredSize(new Dimension(50,50));
        topPanel.setMaximumSize(new Dimension(590,40));
        newTodo.setMaximumSize(new Dimension(500,30));
        plusButton.setMaximumSize(new Dimension(40,40));
        plusButton.setBackground(Color.black);
        mainPanel.setBackground(Color.WHITE);

        topPanel.add(newTodo);
        topPanel.add(Box.createHorizontalStrut(10));
        topPanel.add(plusButton);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mainPanel.add(topPanel);

        for (int i = 0; i < 5; i++) {
            JPanel toDoPanel = new JPanel();
            toDoPanel.setLayout(new BoxLayout(toDoPanel, BoxLayout.X_AXIS));
            JButton upButton = new RoundedButton("▲", 15);
            JButton downButton = new RoundedButton("▼", 15);

            upButton.setBackground(Color.GRAY);
            downButton.setBackground(Color.GRAY);

            upButton.setForeground(Color.WHITE);
            downButton.setForeground(Color.WHITE);

            upButton.setPreferredSize(new Dimension(30,30));
            downButton.setPreferredSize(new Dimension(30,30));
            CentralDropShadowArea taskField = new CentralDropShadowArea(6, Color.LIGHT_GRAY);
            JButton deleteButton = new RoundedButton(new ImageIcon("src/image/plus.png"),20); // 여기에 삭제 아이콘을 삽입 가능
            taskField.setFocusable(false);
            deleteButton.setBackground(Color.BLACK);
            deleteButton.setMaximumSize(new Dimension(35,35));
            deleteButton.setPreferredSize(new Dimension(35,35));
            toDoPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
            toDoPanel.setBackground(Color.WHITE);
            toDoPanel.add(upButton);
            toDoPanel.add(Box.createHorizontalStrut(5));
            toDoPanel.add(downButton);
            toDoPanel.add(taskField);
            toDoPanel.add(deleteButton);
            mainPanel.add(toDoPanel);
        }
        JButton addButton = new RoundedButton(icon, 20);
        addButton.setPreferredSize(new Dimension(50,30));
        addButton.setMaximumSize(new Dimension(50,30));
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(addButton);
        
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
