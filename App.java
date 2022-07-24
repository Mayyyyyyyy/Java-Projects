import java.awt.image.BufferedImage;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JPanel{
    static BufferedImage img;
    static float ff;

    public static void main(String[] args) {
        // 画框
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Album");
        frame.setLocationRelativeTo(null);
        frame.setSize(800,500);
        //初始化数据
        initImages();
        // 画板
        App app = new App();
        frame.add(app);
        // 重绘
        // app.repaint();

        app.begin();

        frame.setVisible(true);
    }

    static int num = 0;

    private void begin() {
        new Thread(new Runnable() {
            public void run(){
                while(true){
                    img = images[num];
                    num++;
                    if(num == 5){
                        num = 0;
                    }
                    repaint();
                    // while(true){
                    //     if (ff < 100f) {
                    //         ff += 2f;
                    //         repaint();
                    //     } else {
                    //         ff = 0f;
                    //         break;
                    //     }
                    // }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void paint(Graphics g){
      super.paint(g);
      Graphics2D graphics2D = (Graphics2D) g;
      if(img != null){
        // graphics2D.setComposite(AlphaComposite.SrcOver.derive(ff/100f));
        graphics2D.drawImage(img, 0, 0, img.getWidth(),img.getHeight(), null);
      }
    }

    static BufferedImage [] images = new BufferedImage[5];

    private static void initImages() {
        try {
            for (int i = 1; i <= 5; i++) {
                BufferedImage image = ImageIO.read(App.class.getResource("/images/bg" + i + ".jpg"));
                images[i-1]=image;
                img = images[0];
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
    
}
