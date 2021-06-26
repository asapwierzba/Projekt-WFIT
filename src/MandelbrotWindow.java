import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MandelbrotWindow extends JFrame {
    public void okno_pokaz(){
        JFrame f = new JFrame("Wygenerowany Fraktal");
        try{
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mandelbrot.png")))));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
