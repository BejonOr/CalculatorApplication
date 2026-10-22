/*WatermarkTextField.java
Class that extends JTextField to allow for a tiled background image.
From Swing Hack #5
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JTextField;

public class WatermarkTextField extends JTextField {
    BufferedImage image;
    TexturePaint texture;
    //Constructor taking in an image file
    public WatermarkTextField(File file) throws IOException {
        super();
        image = ImageIO.read(file);
        Rectangle rectangle = new Rectangle(0,0,600,600);
        texture = new TexturePaint(image, rectangle);
        setOpaque(false);
    }
    
    //Overrides the paintComponent method to draw the background using the tile image
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(texture);
        g.fillRect(0, 0, getWidth(), getHeight( ));
        super.paintComponent(g);
    }
}

