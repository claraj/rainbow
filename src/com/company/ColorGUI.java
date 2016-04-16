package com.company;

import javax.swing.*;
import java.awt.*;

// Testing the Rainbow class.


public class ColorGUI extends JFrame {

    int len = 1536;               //One pixel for each of the colors in the rainbow... actually just the ones a computer monitor can show (256 * 6)
    private JPanel colorPanel;

    ColorGUI() {
        ColorPanel panel = new ColorPanel();
        setContentPane(panel);
        setPreferredSize(new Dimension(len, 120));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class ColorPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);

            Rainbow rainbow = new Rainbow();

            //Select starting color

            rainbow.resetBlue();

            // Some alternatives....

            //rainbow.resetRed();
            //rainbow.resetCyan();
            //rainbow.resetGreen();
            //rainbow.resetMagenta();
            //rainbow.resetYellow();

            for (int x = 0; x < len; x++) {
                g.setColor(rainbow.nextRainbowColor());

                //Draw a rectangle 1 pixel wide and 100 pixels tall, which will look like a stripe of this color.
                g.drawRect(x, 0, 1, 100);
            }
        }
    }
}
