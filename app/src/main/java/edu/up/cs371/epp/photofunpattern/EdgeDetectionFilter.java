package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class BrightFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to increase an image brightness by value of 100.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class EdgeDetectionFilter extends PhotoFilter {

    private final int ADJUSTMENT = 100;

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It adds 100 to each RGB color component. The maxium value of each
    * component is limited to 255
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components has been increased
    */
    public int transformPixel(int p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
        int red = constrain(Color.red(p0) + Color.red(p1) - Color.red(p2) + Color.red(p3) - 2*Color.red(p4) - Color.red(p5) + Color.red(p6) + Color.red(p7) - Color.red(p8));
        int green = constrain(Color.green(p0) + Color.green(p1) - Color.green(p2) + Color.green(p3) - 2*Color.green(p4) - Color.green(p5) + Color.green(p6) + Color.green(p7) - Color.green(p8));
        int blue = constrain(Color.blue(p0) + Color.blue(p1) - Color.blue(p2) + Color.blue(p3) - 2*Color.blue(p4) - Color.blue(p5) + Color.blue(p6) + Color.blue(p7) - Color.blue(p8));
        int outPixel = Color.argb(Color.alpha(p4), red, green, blue);
        return outPixel;
    }

}
