import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setSize(700,500);

        frame.add(new SecondForm().getSecondPanel());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
