/*Main.java
Driver class for the calulator. Contains the main method, which constructs a calulator 
object and makes it visible.
*/
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp app = new CalculatorApp();
            app.setVisible(true);
        });
    }
}