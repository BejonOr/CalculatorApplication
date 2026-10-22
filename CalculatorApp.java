/*CalculatorApp.java
Class that creates user interface for calculator. 
Sets style and size of text field and buttons, and adds them to the frame
Uses the button click listener to wire the buttons to the logic of the calculator
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalculatorApp extends JFrame {
    private WatermarkTextField display;
    public CalculatorApp() {
        setTitle("Calculator");
        setSize(400, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            display = new WatermarkTextField(new File("background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ButtonClickListener buttonClickListener = new ButtonClickListener(display);
        display.setEditable(false);
        display.setPreferredSize(new java.awt.Dimension(400,100));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setFont(new Font("SansSerif", Font.BOLD, 50));
        display.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabel = {
            "%", "AC", "CE" ,"/", 
            "7", "8", "9", "*",
            "4", "5", "6", "+",
            "1", "2", "3", "-",
            "-/+", "0", ".", "=",
        };
        

        // Creates each button, sets style, and adds them to the panel
        for(String label : buttonLabel){
            JButton button = new JButton(label);
            button.setFont(new Font ("SansSerif", Font.BOLD, 28));
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            button.setFocusPainted(false); // Removes highlight around buttons when clicked
            buttonPanel.add(button);
            button.addActionListener(buttonClickListener);
        } 
        for (int i = 0; i <= 20; i++) {
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 7 || i == 11 || i == 15 || i == 19) {
                buttonPanel.getComponent(i).setBackground(Color.DARK_GRAY);
                buttonPanel.getComponent(i).setForeground(Color.WHITE);
            }
        } 
        add(buttonPanel, BorderLayout.CENTER);
        
    }
    
}