import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    public MainFrame(int width, int height) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
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
        //other
        panel1 = new GameCanvas(m);
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== this ========
        // setMinimumSize(new Dimension(750, 675));
        setResizable(false);
        setBackground(new Color(38, 50, 56));
        this.setLayout(null);

        //======== panel1 ========
        {
            panel1.setMinimumSize(new Dimension(495, 675));
            panel1.setPreferredSize(new Dimension(495, 675));
            panel1.setMaximumSize(new Dimension(495, 675));
            // panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            // javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax
            // . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            // .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            // . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            // PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .
            // equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            // panel1.setLayout(null);

            // {
            //     // compute preferred size
            //     Dimension preferredSize = new Dimension();
            //     for(int i = 0; i < panel1.getComponentCount(); i++) {
            //         Rectangle bounds = panel1.getComponent(i).getBounds();
            //         preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            //         preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            //     }
            //     Insets insets = panel1.getInsets();
            //     preferredSize.width += insets.right;
            //     preferredSize.height += insets.bottom;
            //     panel1.setMinimumSize(preferredSize);
            //     panel1.setPreferredSize(preferredSize);
            // }
        }
        this.add(panel1);
        panel1.setBounds(0, 0, 480, 675);

        //======== panel2 ========
        {
            panel2.setBackground(new Color(38, 50, 56));
            panel2.setLayout(null);

            //---- button1 ----
            button1.setText("Load Game");
            button1.setBackground(new Color(38, 50, 56));
            button1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button1.setDisplayedMnemonicIndex(1);
            button1.setEnabled(false);
            panel2.add(button1);
            button1.setBounds(0, 65, 220, button1.getPreferredSize().height);

            //---- button2 ----
            button2.setText("Save Game");
            button2.setBackground(new Color(38, 50, 56));
            button2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button2.setDisplayedMnemonicIndex(1);
            button2.setEnabled(false);
            panel2.add(button2);
            button2.setBounds(0, 100, 220, 30);

            //---- button3 ----
            button3.setText("Show active engimon");
            button3.setBackground(new Color(38, 50, 56));
            button3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button3.setDisplayedMnemonicIndex(1);
            button3.setEnabled(false);
            panel2.add(button3);
            button3.setBounds(0, 135, 220, 30);

            //---- button4 ----
            button4.setText("Change active engimon");
            button4.setBackground(new Color(38, 50, 56));
            button4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button4.setDisplayedMnemonicIndex(1);
            button4.setEnabled(false);
            panel2.add(button4);
            button4.setBounds(0, 170, 220, 30);

            //---- button5 ----
            button5.setText("breed engimon");
            button5.setBackground(new Color(38, 50, 56));
            button5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button5.setDisplayedMnemonicIndex(1);
            button5.setEnabled(false);
            panel2.add(button5);
            button5.setBounds(0, 205, 220, 30);

            //---- button6 ----
            button6.setText("use skill item");
            button6.setBackground(new Color(38, 50, 56));
            button6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button6.setDisplayedMnemonicIndex(1);
            button6.setEnabled(false);
            panel2.add(button6);
            button6.setBounds(0, 240, 220, 30);

            //---- button7 ----
            button7.setText("battle");
            button7.setBackground(new Color(38, 50, 56));
            button7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button7.setDisplayedMnemonicIndex(1);
            button7.setEnabled(false);
            panel2.add(button7);
            button7.setBounds(0, 275, 220, 30);

            //---- button8 ----
            button8.setText("show my engimon");
            button8.setBackground(new Color(38, 50, 56));
            button8.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button8.setDisplayedMnemonicIndex(1);
            button8.setEnabled(false);
            panel2.add(button8);
            button8.setBounds(0, 310, 220, 30);

            //---- button9 ----
            button9.setText("show my item");
            button9.setBackground(new Color(38, 50, 56));
            button9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button9.setDisplayedMnemonicIndex(1);
            button9.setEnabled(false);
            panel2.add(button9);
            button9.setBounds(0, 345, 220, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        this.add(panel2);
        panel2.setBounds(480, 0, 220, 675);

        //======== scrollPane1 ========
        {

            //---- textPane1 ----
            textPane1.setText("Output :");
            textPane1.setEditable(false);
            textPane1.setFocusable(false);
            scrollPane1.setViewportView(textPane1);
        }
        this.add(scrollPane1);
        scrollPane1.setBounds(700, 0, 335, 675);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < this.getComponentCount(); i++) {
                Rectangle bounds = this.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = this.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            this.setMinimumSize(preferredSize);
            this.setPreferredSize(preferredSize);
        }
        setSize(width, height);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setTitle("Engimon: Java Edition");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainFrame sc = new MainFrame(1035,675); // default gamecanvas : 495,675 ; 670,675
            sc.setVisible(true);
        });
        
    }
}
