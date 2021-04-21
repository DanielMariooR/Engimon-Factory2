import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class Screen extends JFrame {
    private static final long serialVersionUID = 1L;

    public Screen(int width, int height){
        Map m = new Map("map.txt");
        Player P = new Player(1,0);
        Engimon E = new Engimon();
        Engimon E1 = new Engimon();
        Engimon E2 = new Engimon();
        Engimon E3 = new Engimon();
        ArrayList<String> elem1 = new ArrayList<>();
        ArrayList<String> elem2 = new ArrayList<>();
        ArrayList<String> elem3 = new ArrayList<>();

        elem1.add("Ground");
        elem1.add("Fire");
        elem2.add("Ice");
        elem3.add("Water");
        
        E1.setPos(new Point(3,5));
        E1.setElem(elem1);
        E2.setPos(new Point(12,8));
        E2.setElem(elem2);
        E3.setPos(new Point(10,1));
        E3.setElem(elem3);

        m.addEngimon(E1);
        m.addEngimon(E2);
        m.addEngimon(E3);

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
            Screen sc = new Screen(670,675); // default gamecanvas : 495,675 ; 670,675
            sc.setVisible(true);
        });
        
    }


}
