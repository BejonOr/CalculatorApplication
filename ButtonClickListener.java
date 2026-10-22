/* ButtonClickListener.java
Class that implements the ActionListener to handle button clicks in the calculator

display - a WatermarkTextField with a background image containing current input or result of a calculation
result - a double representing the result of the previous calculation
operator - a char representing the current operator (+, -, *, /)
currentValue - a String representing the current value in the display

*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ButtonClickListener implements ActionListener{
    private final WatermarkTextField display;
    private double result;
    private char operator;
    private String currentValue;

    public ButtonClickListener(WatermarkTextField display){
        this.display = display;
    }

    //Checks if the display is showing "Undefined" and clears the display if it is
    public void isUndefined() {
        if (display.getText().equals("Undefined")) {
            display.setText("");
        }
    }

    //If the input is a whole number, display it without a decimal point
    public void doubleToInt(double value) {
        if (value % 1 == 0) {
            value = (int) value;
            display.setText(String.valueOf((int) value));
        }
        else {
            display.setText(String.valueOf(value));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")){
            //Ensures user cannot add multiple decimal points to a number
            if (command.equals(".") && display.getText().contains(".")) {
                return; 
            }
            isUndefined();
            display.setText(display.getText()  + command);
        }

        else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            //Prevents operator button from being pressed before a number
            if (display.getText().isEmpty()) {
                return; 
            }
            isUndefined();
            result = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            display.setText("");
        }

        //Displays current value as a percentage of 100
        else if (command.equals("%")) {
            isUndefined();
            result = Double.parseDouble(display.getText());
            result = result / 100;
            doubleToInt(result);
        }


        //Clears display and resets variables
        else if (command.equals("AC")) {
            display.setText("");
            result = 0;
            operator = '\0';
        }

        /*Empty or 0 = display "-", 
        Positive number = display negative number,
        Negative number = display positive number*/
        else if (command.equals("-/+")) { //empty string exception when typing - with no digit
            isUndefined();

            currentValue = display.getText();
            
            if (currentValue.isEmpty() || currentValue.equals("0")) {
                display.setText("-");
            }

            double val = Double.parseDouble(currentValue);

            if (val > 0) {
                val = -val;
                doubleToInt(val);
            }

            else if (val < 0) {
                val = val + (-2 * val);
                doubleToInt(val);
            }
        }

        //When the display is not empty, deletes last digit/symbol
        else if (command.equals("CE")) {
            isUndefined();
            currentValue = display.getText();
            if (!currentValue.isEmpty()) {
                display.setText(currentValue.substring(0, currentValue.length() - 1)); //deletes one digit from the display
            }
        }

        //Calculates and displays result
        else if (command.equals("=")) {

            isUndefined();

            //Prevents the equals sign from being pressed before a number
            if (display.getText().isEmpty()) {
                return; 
            }

            //Prevents change to text field if no operator is pressed
            if (operator == '\0') {
                return; 
            }

            double secondOperand = Double.parseDouble(display.getText());
            double answer = 0;

            switch(operator) {
                case '+':
                    answer = result + secondOperand;
                    break;
                case '-':
                    answer = result - secondOperand;
                    break;
                case '*':
                    answer = result * secondOperand;
                    break;
                case '/':
                    if (secondOperand == 0) {
                        display.setText("Undefined");
                        return;
                    }
                    answer = result / secondOperand;
                    break;
            }    
            display.setText("");

            doubleToInt(answer);
        }
    }
}