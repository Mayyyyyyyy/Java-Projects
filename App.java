import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    static String[] strs = {"a","b","c","d","e","f","g","h","i","j","k","M","N","P","Q","R","S","T","U","V","W","X","Y","Z",
    "2","3","4","5","6","7","8","9"};
    private static void createImage(){
        int width = 150;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Helvetica",Font.BOLD,25));
        Random random = new Random();
        int x = 30;
        int y = 30;
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(strs.length);
            String s = strs[num];
            g.drawString(s, x, y);
            x+=25;
        }
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(25);
            int y1 = random.nextInt(45);
            int x2 = random.nextInt(25)+125;
            int y2 = random.nextInt(45);
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(x1, y1, x2, y2);
        }
        try {
          ImageIO.write(image, "jpg", new File("/Users/may/Downloads/code.jpg"));
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public static void main(String[] args) {
        createImage();
        System.out.print("over");
        return;
    }
}
