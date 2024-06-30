package classes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class App {

    private static JTextField heightField = new JTextField(5);
    private static JTextField weightField = new JTextField(5);
    private static JLabel resultLabel = new JLabel(" ");

    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calc");
        frame.setSize(450, 350);
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
        JButton calcButton = new JButton("Calculate");

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
            resetErrors();
            try{
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());
                String category = WeightHelper.getCategory(height, weight);
                resultLabel.setText("Your BMI category is " + category.toUpperCase());
            } catch (NumberFormatException ex) { //checking only nbr formats, not the set boundaries.
                setErrorMsg("Please enter valid numbers.");
            } catch (IllegalArgumentException ex) { //set boundaries, checked and thrown from backend due to project requirements.
                setErrorMsg(ex.getMessage());
            }
        });
    }

    public static void setErrorMsg (String errorMsg){
        resultLabel.setForeground(new Color(186, 2, 39));
        heightField.setBorder(BorderFactory.createLineBorder(new Color(255, 100, 100), 2));
        weightField.setBorder(BorderFactory.createLineBorder(new Color(255, 100, 100), 2));
        resultLabel.setText("<html><body style='width: 200px;'>"+ errorMsg + "</body></html>");
    }

    public static void resetErrors () {
        resultLabel.setForeground(Color.BLACK);
        heightField.setBorder(null);
        weightField.setBorder(null);    
    }
}
