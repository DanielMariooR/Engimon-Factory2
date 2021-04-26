import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainFrame sc = new MainFrame(1035, 675); // default gamecanvas : 495,675 ; 670,675
            sc.setVisible(true);
        });


}
}
