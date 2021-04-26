import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.ActionMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

import java.awt.event.*;

public class EngimonStatus extends JPanel {
    private Image ice;

    private Image water;
    private Image fire;
    private Image electric;
    private Image ground;
    private Image icy;
    private Image felec;
    private Image gwat;
    private Image icewat;
    private Image skillinven;
    private Image EngimonElectric;
    private Image EngimonFire;
    private Image EngimonWater;
    private Image EngimonIce;
    private Image EngimonGround;
    private Image EngimonFireElectric;
    private Image EngimonWaterIce;
    private Image EngimonWaterGround;
    private Rectangle selectedCell = null;
    private Image mountain;
    // private Inventory<Item> player.skillItems;
    // private Inventory<Engimon> engimons;
    private Image engimon;
    private Timer timer;
    public Skill[] slotSkill;
    private Engimon engi;
    private Player Pa;
    private Resource loader = new Resource();

    public EngimonStatus(Player P) {
        
        EngimonElectric = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonElectricSmall.png");
        EngimonFire = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonFireSmall.png");
        EngimonWater = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterSmall.png");
        EngimonIce = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonIceSmall.png");
        EngimonGround = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/engimonGroundSmall.png");
        EngimonFireElectric = Toolkit.getDefaultToolkit()
                .getImage("resource/tiles/Engimon/EngimonFireElectricSmall.png");
        EngimonWaterIce = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterIceSmall.png");
        EngimonWaterGround = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterGroundSmall.png");
        ice = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/ice.png");
        engimon = Toolkit.getDefaultToolkit().getImage("resource/tiles/pokemon.png");
        mountain = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/mountain.png");
        fire = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/fire.png");
        water = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/waterelement.png");
        electric = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/electric.png");
        ground = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/ground.png");
        icy = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/icy.png");
        felec = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/felec.png");
        gwat = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/gwat.png");
        icewat = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/icewat.png");
        skillinven = Toolkit.getDefaultToolkit().getImage("resource/tiles/skillinven.png");
        slotSkill = new Skill[5];
        engi = P.Active;
        Pa = P;
        // Masih Buggy
        // addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //         engi = Pa.getActive();
        //         int w = getWidth();
        //         int h = getHeight();
        //         selectedCell = null;
        //         for (int row = 0; row < 5 && selectedCell == null; row++) {
        //             int x = (w / 1) * 0;
        //             int y = (h / 5) * row;
        //             Rectangle cell = new Rectangle(x, y, w / 1, h / 5);
        //             if (cell.contains(e.getPoint())) {
        //                 System.out.println();
        //                 if(row==0) JOptionPane.showMessageDialog(null, engi);
        //                 else JOptionPane.showMessageDialog(null,slotSkill[row]);
        //                 selectedCell = cell;
        //                 repaint();
        //                 break;
        //             }
        //         }
        //     }
        // });
        timer = new Timer(10, new TimerListener());
        timer.start();

    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        engi = Pa.getActive();
        g.setColor(new Color(56, 38, 49));
        g.fillRect(0, 0, getWidth(), getHeight());
        int[] filled = new int[5];
        for (int k = 0; k < 5; k++) {
            filled[k] = 0;
        }
        if (engi != null) {
            if (engi.getElem().size() == 1) {
                if (engi.getElem().get(0) == "Fire")
                    g.drawImage(EngimonFire, 1 * 32, 0 * 32, this);
                else if (engi.getElem().get(0) == "Water")
                    g.drawImage(EngimonWater, 1 * 32, 0 * 32, this);
                else if (engi.getElem().get(0) == "Ice")
                    g.drawImage(EngimonIce, 1 * 32, 0 * 32, this);
                else if (engi.getElem().get(0) == "Ground")
                    g.drawImage(EngimonGround, 1 * 32, 0 * 32, this);
                else if (engi.getElem().get(0) == "Electric")
                    g.drawImage(EngimonElectric, 1 * 32, 0 * 32, this);
                else
                    g.drawImage(engimon, 1 * 32, 0 * 32, this);
                filled[0] = 1;
            } else {
                if ((engi.getElem().get(0) == "Fire" && engi.getElem().get(1) == "Electric")
                        || (engi.getElem().get(0) == "Electric" && engi.getElem().get(1) == "Fire"))
                    g.drawImage(EngimonFireElectric, 1 * 32, 0 * 32, this);
                else if ((engi.getElem().get(0) == "Water" && engi.getElem().get(1) == "Ice")
                        || (engi.getElem().get(0) == "Ice" && engi.getElem().get(1) == "Water"))
                    g.drawImage(EngimonWaterIce, 1 * 32, 0 * 32, this);
                else if ((engi.getElem().get(0) == "Water" && engi.getElem().get(1) == "Ground")
                        || (engi.getElem().get(0) == "Ground" && engi.getElem().get(1) == "Water"))
                    g.drawImage(EngimonWaterGround, 1 * 32, 0 * 32, this);
                filled[0] = 1;

            }
        }

        for (int i = 0; i < engi.getSkills().size(); i++) {
            String args = engi.getSkills().get(i).getName().replaceAll("\\s+","").toLowerCase()+engi.getSkills().get(i).getMasteryLevel();
            g.drawImage(loader.skillIcon.get(args), (i + 2) * 32, 0 * 32, this);
            slotSkill[i+1] = engi.getSkills().get(i);
            filled[i + 1] = 1;
        }
        for (int i = 0; i < filled.length; i++) {
            if (filled[i] == 0)
                g.drawImage(ice, (i + 1) * 32, 0 * 32, this);
        }

        Toolkit.getDefaultToolkit().sync();
    }

}