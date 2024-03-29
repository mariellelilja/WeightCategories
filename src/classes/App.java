package classes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calc");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(40,30,40,30));

        JPanel instructionPanel = new JPanel();
        instructionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel instructionLabel = new JLabel("Enter your height and weight");
        JTextField heightField = new JTextField(5);
        JTextField weightField = new JTextField(5);
        JButton calcButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel(" ");

        instructionPanel.add(instructionLabel);

        inputPanel.add(new JLabel("Height (cm): "));
        inputPanel.add(heightField);
        inputPanel.add(new JLabel("Weight (kg): "));
        inputPanel.add(weightField);

        buttonPanel.add(calcButton);
        resultPanel.add(resultLabel);

        mainPanel.add(instructionPanel);
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);
        
        frame.add(mainPanel);
        frame.pack();

        SwingUtilities.invokeLater(() -> heightField.requestFocusInWindow());
        frame.getRootPane().setDefaultButton(calcButton);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);    

        calcButton.addActionListener(e -> {
            try{
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());
                String category = WeightHelper.getCategory(height, weight);
                resultLabel.setText("Your BMI category is " + category.toUpperCase());
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        });
    }
}
