package com.company;

import javax.swing.*;
import java.awt.*;


public class ColorGUI extends JFrame{

    int len = 1536;
    private JPanel colorPanel;

    ColorGUI() {
        ColorPanel panel = new ColorPanel();
        setContentPane(panel);
        setPreferredSize(new Dimension(len, 320));
        pack();
        setVisible(true);
    }


    class ColorPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);

            int maxColor = 16777216;

            int ratio = maxColor / len;

            //scale maxColor into len and draw a rect that color.
            for (int x = 0 ; x < len ; x ++ ){
                java.awt.Color c = new java.awt.Color(x * ratio);  //try not to name things after Java library classes
                g.setColor(c);
                g.drawRect(x, 1, 1, 100);
            }

            //Black through red

            for (int x = 0 ; x < len ; x++ ) {
                Color col = new Color((x%255), 0, 0);
                g.setColor(col);
                g.drawRect(x, 100, 1, 100);
            }


            //  Rainbow.

            // R 255->0 G 0      B 255
            // R 0      G 0->255 B 255
            // R 0      G 255    B 255->0
            // R 0->255 G 255    B 0
            // R 255,   G 255->0 B 0
            // R 255    G 0      B 0->255

            int re = 255; int gr = 0; int bl = 255;

            int[] c  = {re, gr, bl};

            int diff = -1;

            int xcord = 0;


            for (int x = 0 ; x < 6 ; x++){

                for (int d = 0 ; d < 255 ; d++){
                    c[x % 3] += diff;
                    System.out.println("x" + xcord + " " + c[0] + " " +  c[1] + " " + c[2]);
                    java.awt.Color cl = new java.awt.Color(c[0], c[1], c[2]);
                    g.setColor(cl);
                    g.drawRect(xcord, 200, 1, 100);
                    xcord++;
                    if (xcord > len) { break; }
                }

                if (diff == 1) { diff = -1; }
                else { diff = 1; }

                if (xcord > len) { break; }
            }



        }


    }

}
