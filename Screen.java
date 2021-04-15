import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Screen extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JButton newGame = new JButton("New Game");
    JButton load = new JButton("Load Game");
    JButton exit = new JButton("Exit");


    public Screen(int width, int height){
        addButtons();
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Engimon: Java Edition");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();
    }


}
