import java.awt.*;
import javax.swing.*;
public class MainBar {
    public static Component createButtonMenu(){

        JButton load = new JButton("Load Game");
        JButton save = new JButton("Save Game");
        JButton b = new JButton("Show Active Engimon");
        JButton b1 = new JButton("Change Active Engimon");
        JButton b2 = new JButton("Breed Engimon");
        JButton b3 = new JButton("Use Skill Item");
        JButton b4 = new JButton("Battle");
        JButton b5 = new JButton("Show Engimon");
        JButton b6 = new JButton("Show Item");
        
        load.setAlignmentX(Component.CENTER_ALIGNMENT);
        save.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b5.setAlignmentX(Component.CENTER_ALIGNMENT);
        b6.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension psize = new Dimension(175,25);

        load.setMinimumSize(psize);
        save.setMinimumSize(psize);
        b.setMinimumSize(psize);
        b1.setMinimumSize(psize);
        b2.setMinimumSize(psize);
        b3.setMinimumSize(psize);
        b4.setMinimumSize(psize);
        b5.setMinimumSize(psize);
        b6.setMinimumSize(psize);

        load.setMaximumSize(psize);
        save.setMaximumSize(psize);
        b.setMaximumSize(psize);
        b1.setMaximumSize(psize);
        b2.setMaximumSize(psize);
        b3.setMaximumSize(psize);
        b4.setMaximumSize(psize);
        b5.setMaximumSize(psize);
        b6.setMaximumSize(psize);

        load.setPreferredSize(psize);
        save.setPreferredSize(psize);
        b.setPreferredSize(psize);
        b1.setPreferredSize(psize);
        b2.setPreferredSize(psize);
        b3.setPreferredSize(psize);
        b4.setPreferredSize(psize);
        b5.setPreferredSize(psize);
        b6.setPreferredSize(psize);


        // create a panel to add buttons and textfield and a layout
        JPanel p = new JPanel(new GridLayout(2, 1));
 
        // set Box Layout
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        JLabel space2 = new JLabel(" ");
        JLabel lul = new JLabel("Main Menu");
        JLabel space = new JLabel(" ");
        lul.setAlignmentX(Component.CENTER_ALIGNMENT);
        space.setAlignmentX(Component.CENTER_ALIGNMENT);
        space2.setAlignmentX(Component.CENTER_ALIGNMENT);
        // add buttons and textfield to panel
        p.add(space2);
        p.add(lul);
        p.add(space);
        p.add(load);
        p.add(save);
        p.add(b);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);

        
 
        // setbackground of panel
        p.setBackground(new Color(255,255,255));
        return p;
    }


  }