import java.awt.*;

import javax.swing.JFrame;


public class Screen extends JFrame {
    private static final long serialVersionUID = 1L;

    public Screen(int width, int height){
        Map m = new Map("map.txt");
        Player P = new Player(0,0);
        m.setPlayer(P);
        add(new GameCanvas(m));

        setSize(width, height);
        setResizable(false);

        setLocationRelativeTo(null);
        setTitle("Engimon: Java Edition");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Screen sc = new Screen(640,640);
            sc.setVisible(true);
        });
        
    }


}
