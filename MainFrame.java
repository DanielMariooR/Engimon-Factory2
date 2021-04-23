import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// TODO : Sort Inventory, Add Element + Skill Icons, merge size inventory (size inventory kumulatif engimon + skill), Clickable Inventory (kalo bisa)
public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    public MainFrame(int width, int height) {
        Map m = new Map("map.txt");
        Player P = new Player(1,0);
        Engimon E = new Engimon();
        Engimon E1 = new Engimon();
        Engimon E2 = new Engimon();
        Engimon E3 = new Engimon();
        Engimon E4 = new Engimon();
        ArrayList<String> elem1 = new ArrayList<>();
        ArrayList<String> elem2 = new ArrayList<>();
        ArrayList<String> elem3 = new ArrayList<>();
        Inventory<Item> items = new Inventory<Item>();

        // Inventory<Engimon> engi = P.getEngi();
        // engi.masuk(E);
        // engi.masuk(E);
        elem1.add("Ground");
        // elem1.add("Fire");
        elem2.add("Ice");
        elem3.add("Water");
        // items.masuk(null);
        Skill S = new Skill("Water Spurt",elem3,100,1);
        Item It = new Item(S);
        items.masuk(It);
        E1.setPos(new Point(3,5));
        E1.setElem(elem1);
        E2.setPos(new Point(12,8));
        E2.setElem(elem2);
        E3.setPos(new Point(10,1));
        E3.setElem(elem3);
        E.setElem(elem3);
        E4.setElem(elem1);
        
        m.addEngimon(E1);
        m.addEngimon(E2);
        m.addEngimon(E3);
        P.addEngimon(E);
        P.addEngimon(E4);
        P.setActive(E);
        m.setPlayer(P);
        //child container with menu
        //other
        panel1 = new GameCanvas(m);
        invPanel = new InvenPanel(items,P.ownedEngimon);
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
        button10 = new JButton();
        button11 = new JButton();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        scrollPane2 = new JScrollPane();
        textPane2 = new JTextPane();
        scrollPane3 = new JScrollPane();
        textPane3 = new JTextPane();

        //======== this ========
        // setMinimumSize(new Dimension(750, 675));
        setResizable(false);
        setBackground(new Color(38, 50, 56));
        this.setLayout(null);

        //======== InvPanel ========
        {
            // invPanel.setMinimumSize(new Dimension(495, 675));
            // invPanel.setPreferredSize(new Dimension(495, 675));
            // invPanel.setMaximumSize(new Dimension(495, 675));
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
        this.add(invPanel);
        invPanel.setBounds(700, 350, 335, 325);

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
            button1.setForeground(new Color(255,255,255));
            button1.setEnabled(true);                    
            button1.setBorderPainted(false);
            button1.setContentAreaFilled(false);
            button1.setFocusPainted(false);
            button1.setOpaque(true);
            button1.setMargin(new Insets(10, 10, 10, 10));
            button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Yes bisa");
                }
            });
            button1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button1.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button1.setForeground(new Color(255,255,255));
                }
            });
            panel2.add(button1);
            button1.setBounds(0, 65, 220, button1.getPreferredSize().height);

            //---- button2 ----
            button2.setText("Save Game");
            button2.setBackground(new Color(38, 50, 56));
            button2.setForeground(new Color(255,255,255));
            button2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button2.setBorderPainted(false);
            button2.setContentAreaFilled(false);
            button2.setFocusPainted(false);
            button2.setOpaque(true);
            button2.setMargin(new Insets(10, 10, 10, 10));
            button2.setEnabled(true);
            button2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Yes bisa\nAAAA");
                }
            });
            button2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button2.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button2.setForeground(new Color(255,255,255));
                }
            });
            panel2.add(button2);
            button2.setBounds(0, 100, 220, 30);

            //---- button3 ----
            button3.setText("Show Active Engimon");
            button3.setBackground(new Color(38, 50, 56));
            button3.setForeground(new Color(255,255,255));
            button3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button3.setBorderPainted(false);
            button3.setContentAreaFilled(false);
            button3.setFocusPainted(false);
            button3.setOpaque(true);
            button3.setMargin(new Insets(10, 10, 10, 10));
            button3.setEnabled(true);
            button3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Yes bisa");
                }
            });
            button3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button3.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button3.setForeground(new Color(255,255,255));
                }
            });
            panel2.add(button3);
            button3.setBounds(0, 135, 220, 30);

            //---- button4 ----
            button4.setText("Change Active Engimon");
            button4.setBackground(new Color(38, 50, 56));
            button4.setForeground(new Color(255,255,255));
            button4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button4.setEnabled(true);
            button4.setBorderPainted(false);
            button4.setContentAreaFilled(false);
            button4.setFocusPainted(false);
            button4.setOpaque(true);
            button4.setMargin(new Insets(10, 10, 10, 10));
            button4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Yes bisa");
                }
            });
            button4.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button4.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button4.setForeground(new Color(255,255,255));
                }
            });
            panel2.add(button4);
            button4.setBounds(0, 170, 220, 30);

            //---- button5 ----
            button5.setText("Breed Engimon");
            button5.setBackground(new Color(38, 50, 56));
            button5.setForeground(new Color(255,255,255));
            button5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button5.setEnabled(true);
            button5.setBorderPainted(false);
            button5.setContentAreaFilled(false);
            button5.setFocusPainted(false);
            button5.setOpaque(true);
            button5.setMargin(new Insets(10, 10, 10, 10));
            button5.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Yes bisa");
                }
            });
            button5.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button5.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button5.setForeground(new Color(255,255,255));
                }
            });
            panel2.add(button5);
            button5.setBounds(0, 205, 220, 30);

            //---- button6 ----
            button6.setText("Use Skill Item");
            button6.setBackground(new Color(38, 50, 56));
            button6.setForeground(new Color(255,255,255));
            button6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button6.setEnabled(true);
            button6.setBorderPainted(false);
            button6.setContentAreaFilled(false);
            button6.setFocusPainted(false);
            button6.setOpaque(true);
            button6.setMargin(new Insets(10, 10, 10, 10));
            button6.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Yes bisa");
                }
            });
            button6.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button6.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button6.setForeground(new Color(255,255,255));
                }
            });
            panel2.add(button6);
            button6.setBounds(0, 240, 220, 30);

            //---- button7 ----
            button7.setText("Battle");
            button7.setBackground(new Color(38, 50, 56));
            button7.setForeground(new Color(255,255,255));
            button7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button7.setEnabled(true);
            button7.setBorderPainted(false);
            button7.setContentAreaFilled(false);
            button7.setFocusPainted(false);
            button7.setOpaque(true);
            button7.setMargin(new Insets(10, 10, 10, 10));
            button7.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Yes bisa");
                }
            });
            button7.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button7.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button7.setForeground(new Color(255,255,255));
                }
            });
            panel2.add(button7);
            button7.setBounds(0, 275, 220, 30);

            //---- button8 ----
            button8.setText("Show My Engimon");
            button8.setBackground(new Color(38, 50, 56));
            button8.setForeground(new Color(255,255,255));
            button8.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button8.setEnabled(true);
            button8.setBorderPainted(false);
            button8.setContentAreaFilled(false);
            button8.setFocusPainted(false);
            button8.setOpaque(true);
            button8.setMargin(new Insets(10, 10, 10, 10));
            button8.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Yes bisa");
                }
            });
            button8.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button8.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button8.setForeground(new Color(255,255,255));
                }
            });
            panel2.add(button8);
            button8.setBounds(0, 310, 220, 30);

            //---- button9 ----
            button9.setText("Show My Item");
            button9.setBackground(new Color(38, 50, 56));
            button9.setForeground(new Color(255,255,255));
            button9.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button9.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button9.setForeground(new Color(255,255,255));
                }
            });
            button9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button9.setEnabled(true);
            button9.setBorderPainted(false);
            button9.setContentAreaFilled(false);
            button9.setFocusPainted(false);
            button9.setOpaque(true);
            button9.setMargin(new Insets(10, 10, 10, 10));
            button9.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Yes bisa");
                }
            });
            panel2.add(button9);
            button9.setBounds(0, 345, 220, 30);

            //---- button10 ----
            button10.setText("Walking Mode");
            button10.setBackground(new Color(38, 50, 56));
            button10.setForeground(new Color(255,255,255));
            button10.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button10.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button10.setForeground(new Color(255,255,255));
                }
            });
            button10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button10.setEnabled(true);
            button10.setBorderPainted(false);
            button10.setContentAreaFilled(false);
            button10.setFocusPainted(false);
            button10.setOpaque(true);
            button10.setMargin(new Insets(10, 10, 10, 10));
            button10.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    textPane1.setText("Switched to walking mode");
                }
            });
            panel2.add(button10);
            button10.setBounds(0, 380, 220, 30);
            panel2.setBorder(null);

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
            textPane1.setText("Output :\nAAAAAAAAAAA\nBBBBBBBBB");
            textPane1.setBackground(new Color(56, 38, 49));
            textPane1.setForeground(new Color(255, 255, 255));
            textPane1.setEditable(false);
            textPane1.setFocusable(false);
            scrollPane1.setViewportView(textPane1);
            scrollPane1.setBorder(null);
        }
        this.add(scrollPane1);
        scrollPane1.setBounds(700, 0, 335, 290);

        //======== scrollPane2 ========
        {

            //---- textPane2 ----
            textPane2.setText("");
            textPane2.setBackground(new Color(38, 50, 56));
            textPane2.setForeground(new Color(255,255,255));
            textPane2.setEditable(true);
            textPane2.setFocusable(true);
            textPane2.setCaretColor(new Color(255,255,255));
            scrollPane2.setViewportView(textPane2);
            scrollPane2.setBorder(null);
        }
        this.add(scrollPane2);
        scrollPane2.setBounds(700, 290, 250, 30);

            //---- button11 ----
            button11.setText("Input");
            button11.setBackground(new Color(255,255,255));
            button11.setForeground(new Color(56, 38, 49));
            button11.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button11.setForeground(new Color(44, 105, 141));
                }
            
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button11.setForeground(new Color(56, 38, 49));
                }
            });
            button11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            button11.setEnabled(true);
            button11.setBorderPainted(false);
            button11.setContentAreaFilled(false);
            button11.setFocusPainted(false);
            button11.setOpaque(true);
            button11.setMargin(new Insets(10, 10, 10, 10));
            button11.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String s = textPane2.getText();
                    if(s.equals("P")) textPane1.setText(String.valueOf(textPane1.getText().split("\n")[textPane1.getText().split("\n").length-1]));
                }
            });
            this.add(button11);
            button11.setBounds(950, 290, 85, 30);

        //======== scrollPane3 ========
        {

            //---- textPane3 ----
            textPane3.setText("----------------------------Inventory----------------------------");
            textPane3.setFont(new Font("Segoe UI", Font.BOLD, 12));
            textPane3.setBackground(new Color(255,255,255));
            textPane3.setForeground(new Color(38, 50, 56));
            textPane3.setEditable(false);
            textPane3.setFocusable(false);
            textPane3.setCaretColor(new Color(38, 50, 56));
            scrollPane3.setViewportView(textPane3);
            scrollPane3.setBorder(null);
            
        }
        this.add(scrollPane3);
        scrollPane3.setBounds(700, 320, 335, 30);

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
        setTitle("Engimon: Java Edition");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }


    private JPanel panel1;
    private JPanel invPanel;
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
    private JButton button10;
    private JButton button11;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JScrollPane scrollPane2;
    private JTextPane textPane2;
    private JScrollPane scrollPane3;
    private JTextPane textPane3;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainFrame sc = new MainFrame(1035,675); // default gamecanvas : 495,675 ; 670,675
            sc.setVisible(true);
        });
        
    }
}