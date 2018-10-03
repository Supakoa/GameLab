package lab4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class panelAnimation extends JPanel implements ActionListener {

        int x1;
        int y1;
        int x2;
        int y2;
        boolean d1;
        boolean d2;

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.red);
            g.fillRect(x1, y1, 40, 60);
            g.setColor(Color.blue);
            g.fillRect(x2, y2, 50, 50);
        }

        panelAnimation() {
            x1 = 0;
            y1 = 100;
            x2 = 750;
            y2 = 100;
            d1 = true;
            d2 = false;
            new Timer(10, this).start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (d1 == true) {
                if (x1 + 40 >= x2) {
                    d1 = false;
                }
                x1++;
            } else {
                if (x1 < 0) {
                    d1 = true;
                }
                x1--;
            }
            if (d2 == true) {
                if (x2 > 750) {
                    d2 = false;
                }
                x2++;
            } else {
                if (x2 <= x1 + 40) {
                    d2 = true;
                }
                x2--;
            }
            repaint();
        }
    }

    class frameAnimation extends JFrame {

        frameAnimation() {
            this.add(new panelAnimation());
            this.setTitle("Ravikung");
        }

    }
public class Lab4 {
    public static void main(String[] args) {
        frameAnimation f = new frameAnimation();
        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
