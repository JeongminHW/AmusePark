package cmp.GUI;

import java.awt.*;
import javax.swing.*;

public class PTSignUp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Part-Time Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 1, 5, 5));
        
        JTextField idField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JPasswordField confirmPasswordField = new JPasswordField(20);
        JTextField nameField = new JTextField(20);
        JTextField birthDateField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        
        String[] parts = {"Part A", "Part B", "Part C"};
        JComboBox<String> partComboBox = new JComboBox<>(parts);
        
        JComboBox<String> startTimeComboBox = new JComboBox<>(generateTimes());
        JComboBox<String> endTimeComboBox = new JComboBox<>(generateTimes());
        
        JButton submitButton = new JButton("확인");
        
        panel.add(createLabeledPanel("ID", idField));
        panel.add(createLabeledPanel("Password", passwordField));
        panel.add(createLabeledPanel("Password Confirm", confirmPasswordField));
        panel.add(createLabeledPanel("Name", nameField));
        panel.add(createLabeledPanel("Birth date", birthDateField));
        panel.add(createLabeledPanel("Phone Number", phoneNumberField));
        panel.add(createLabeledPanel("Part", partComboBox));
        panel.add(createLabeledPanel("Start Time", startTimeComboBox));
        panel.add(createLabeledPanel("End Time", endTimeComboBox));
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
    
    private static String[] generateTimes() {
        String[] times = new String[24];
        for (int i = 0; i < 24; i++) {
            times[i] = String.format("%02d:00", i);
        }
        return times;
    }
}
