# CalculatorApplication

## Description
This application will serve a 4-function calculator that can add, subtract, multiply and divide using Arabic numerals. 

## Usage/Application Flow
When the user opens the application, they are greeted with a TextField and many different buttons.  User should type out numbers and perform mathematical operations with them.  

1. The user types out a number. 
2. Then, the user will choose which mathematical operation they want to use by selecting a button with a symbol (such as +, -, etc.)  
3. Once an operation is selected,  the user will begin to type out a new number.
4. Now that the user has completed typing out their equation, the user must submit by clicking the equals ( = ) button to execute the operation.
5. Once the application generates the result, the user may repeat the process with a new equation.

At any point throughout the application flow, the user should be able to clear the calculator to try again.  We can use a "Clear" button for this.

## Components/Classes
1. ButtonClickListener - Model
This ActionListener will hold the logic for completing mathematical operations in our application.
Whenever the user clicks an operator button (such as +, -, etc.), the ButtonClickListener will read the JTextField and perform a necessary action.  For example, if the user pressed the + symbol, we can store the number in the JTextField into memory and clear the text.  If the user pressed the = symbol, the application will attempt to execute the mathematical operation (assuming the model of the application has all of the data it needs).
2. CalculatorApp - View
The CalculatorApp will contain the actual graphical user interface that the user interacts with.  Essentially, this class contains a JTextField above a GridLayout of JButtons.
3. Main - Controller
The driver class of the application.  Ties the other two classes together.

# Issues/Edge Cases and Solutions

1. Division by 0: Displays "Undefined" when user tries to divide a value by 0, and clears the text area.

2. Integer conversion: If the user peforms an operation with two whole numbers, and/or the result of an operation is a whole number, the output will be displayed as an int to remove the unnecessary decimal.

3. Check if undefined: A method called isUndefined was created to check if a division by 0 previously occured, and clear the text field if the error message is still there. This way, when a button is clicked that adds something to the text field, users won't have to manually delete the previous error message.

3. CE Functionality: When CE button is clicked, retrieves the text in the JTextField and uses the substring method of the string to display that string with the last number/symbol removed

4. % Functionality: When % is clicked, it displays the value in the text field in decimal form

5. Multiple Decimals: In the action listener, when the "." button is pressed, the program checks if the text in the field contains a decimal point already, and does nothing when the button is pressed if it does

6. Sign Change Functionality: When the sign change button is pressed, if the value within the text field is negative, it converts to a positive number by multiplying the value by -2 and adding that value to the original. If it is positive, the value is simply negated

## Self Evaluation

1. Requirements Met - I identified and fixed as many issues as I could, and added functionality to the buttons we did not finish in class. I found that the sequence of inputs: 
(Nonzero Number) -> / button -> % button -> = button 
results in 1 or another unexpected value, which I was not able to resolve. I did not use any AI applications for pieces of code, but used outside sources for the clear entry button and editing the borders of each element
https://www.w3schools.com/JAVA/ref_string_substring.asp 
https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/BorderFactory.html - 35 pts

2. Correct Architecture - Code is separated into a driver, user interface, and back-end logic for each of the buttons in respective classes. I also made additional methods for operations I used more than once like isUndefined. - 20

3. Documented Code - All edge cases I found throughout my programming were laid out with my fixes explained, and I wrote multiple comments for each method and blocks of code within the method - 20 pts

4. Custom Look and Feel - I tried to make a dark-mode calculator with black numbers and gray operators, with a white border between the buttons/around the text field, and a wavy background for the background of the text field - 10

5. Swing Hacks - I used Swing Hack #5 to add a tiled, repeating image in the text field that resizes proportionally when you expand the tab - 10

- late points

## How to Run 
In terminal:
    javac *.java
    java Main