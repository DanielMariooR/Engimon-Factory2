import java.awt.*;

import javax.swing.*;


public class Screen extends JFrame {
    private static final long serialVersionUID = 1L;

    public Screen(int width, int height){
        Map m = new Map("map.txt");
        Player P = new Player(1,0);
        Engimon E = new Engimon();
        P.setActive(E);
        m.setPlayer(P);
        //child container with menu
        this.add(MainBar.createButtonMenu(), BorderLayout.EAST);
        //other
        add(new GameCanvas(m));
        setSize(width, height);
        
        setLocationRelativeTo(null);
        setTitle("Engimon: Java Edition");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Screen sc = new Screen(665,675);
            sc.setVisible(true);
        });
        
    }


}
