package com.company;

import java.awt.*;

/**
 * Created by clara on 4/16/16.
 * To use: create a Rainbow object. Optionally call one of the resetRed, resetMagenta... methods
 * to set start color, then call nextRainbowColor() as often as needed.
 */

public class Rainbow {

    // Sequence of color changes to produce a rainbow.

    // R 255->0 G 0      B 255        // Magenta to blue
    // R 0      G 0->255 B 255        // Blue to cyan
    // R 0      G 255    B 255->0     // Cyan to green
    // R 0->255 G 255    B 0          // Green to yellow
    // R 255    G 255->0 B 0          // Yellow to red
    // R 255    G 0      B 0->255     // Red to magenta... and back to the start

    // Some defaults - starts with Magenta turning into blue.
    private int r = 255;
    private int g = 0;
    private int b = 255;
    private int diff = -1;            // Change by 1

    private int numberOfDiffs = 0;    // Count how many times have modified a color by +/- 1. After 255 modifications, reset counter for modifying the next color in the cycle.
    private int rgbCycle = 0;         // 0 = modify red ; 1 = modify green ; 2 = modify blue

    Rainbow() {
        reset();
    }

    private void reset() {
        numberOfDiffs = 0;
    }

    public void resetRed() {
        reset();
        r = 255;
        g = 0;
        b = 0;
        diff = 1;
        rgbCycle = 2;
    }

    public void resetBlue() {
        reset();
        r = 0;
        g = 0;
        b = 255;
        diff = 1;
        rgbCycle = 1;
    }

    public void resetGreen() {
        reset();
        r = 0;
        g = 255;
        b = 0;
        diff = 1;
        rgbCycle = 0;
    }

    public void resetYellow() {
        reset();
        r = 255;
        g = 255;
        b = 0;
        diff = -1;
        rgbCycle = 1;
    }

    public void resetMagenta() {
        reset();
        r = 255;
        g = 0;
        b = 255;
        diff = -1;
        rgbCycle = 0;
    }

    public void resetCyan() {
        reset();
        r = 0;
        g = 255;
        b = 255;
        diff = -1;
        rgbCycle = 2;
    }


    public Color nextRainbowColor() {

        //Store RGB in array
        int[] c = {r, g, b};

        // to make use of array indexes to select color to modify
        c[rgbCycle % 3] += diff;

        //System.out.println(String.format("diff %d no_diffs %d cycle %d \t r %d g %d b %d", diff, numberOfDiffs, rgbCycle, r, g, b ));

        Color color = new java.awt.Color(c[0], c[1], c[2]);

        //Write out to global color variables
        r = c[0];
        g = c[1];
        b = c[2];

        //Track number of times the color has been modified
        numberOfDiffs++;

        //If have made 255 changes, then reset to 0 and start modifying the next color in the opposite way.
        //Example: if have been increasing red, then need to decrease green next.

        if (numberOfDiffs == 255) {
            numberOfDiffs = 0;
            rgbCycle = ( rgbCycle + 1 ) % 3;
            diff = (diff == 1) ? -1 : 1;   // If diff is -1, set it to 1; if -1 set it to 1.
        }

        return color;
    }

}

