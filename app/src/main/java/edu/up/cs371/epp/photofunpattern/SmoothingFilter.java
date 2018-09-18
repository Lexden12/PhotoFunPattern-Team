package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class SmoothingFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to convert the image to gray scale.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class SmoothingFilter extends PhotoFilter {

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It transforms a color pixel to gray by averaging its three RGB
    * components.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components is their averaged
    * value
    */
    public int transformPixel(int p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
        /*int intensity = (Color.red(inPixel) + Color.green(inPixel) +
                Color.blue(inPixel)) / 3;
        return Color.argb(Color.alpha(inPixel), intensity,intensity,intensity);*/
        int avgA = (Color.alpha(p0)/10) + (Color.alpha(p1)/10) + (Color.alpha(p2)/10) + (Color.alpha(p3)/10) +(Color.alpha(p4)/5) +(Color.alpha(p5)/10) +(Color.alpha(p6)/10) +(Color.alpha(p7)/10) +(Color.alpha(p8)/10);
        int avgR = (Color.red(p0)/10) + (Color.red(p1)/10) + (Color.red(p2)/10) + (Color.red(p3)/10) +(Color.red(p4)/5) +(Color.red(p5)/10) +(Color.red(p6)/10) +(Color.red(p7)/10) +(Color.red(p8)/10);
        int avgB = (Color.green(p0)/10) + (Color.green(p1)/10) + (Color.green(p2)/10) + (Color.green(p3)/10) +(Color.green(p4)/5) +(Color.green(p5)/10) +(Color.green(p6)/10) +(Color.green(p7)/10) +(Color.green(p8)/10);
        int avgG = (Color.blue(p0)/10) + (Color.blue(p1)/10) + (Color.blue(p2)/10) + (Color.blue(p3)/10) +(Color.blue(p4)/5) +(Color.blue(p5)/10) +(Color.blue(p6)/10) +(Color.blue(p7)/10) +(Color.blue(p8)/10);
        return Color.argb(avgA, avgR, avgB, avgG);
    }

}
