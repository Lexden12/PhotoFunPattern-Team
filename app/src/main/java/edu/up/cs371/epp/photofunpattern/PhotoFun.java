package edu.up.cs371.epp.photofunpattern;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.graphics.Bitmap;
        import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
        import android.widget.Button;
        import android.view.View;
import android.widget.Spinner;

import java.util.logging.Logger;

/**
 *  class PhotoFun controls this photo manipulation app.
 *
 *  @author  Edward C. Epp
 *  @version November 2017
 *   https://github.com/edcepp/PhotoFunPattern
 *
 */

public class PhotoFun extends AppCompatActivity {

    // Image resources
    private ImageView originalImageView;
    private BitmapDrawable originalDrawableBmp;
    private Bitmap myOriginalBmp;
    private ImageView myNewImageView;
    private Spinner drawablePicker;

    /*
    * onCreate This constructor lays out the user interface, initializes the
    * original image and links buttons to their actions.
    *
    * @param savedInstanceState Required by parent object
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_fun);

        originalImageView =
                (ImageView) findViewById(R.id.originalImage);
        originalDrawableBmp =
               (BitmapDrawable) originalImageView.getDrawable();
        myOriginalBmp = originalDrawableBmp.getBitmap();

        myNewImageView = (ImageView) findViewById(R.id.newImage);

        Button grayFilterButton =
                (Button) findViewById(R.id.grayFilterButton);
        grayFilterButton.setOnClickListener(new grayFilterButtonListener());
        Button brightnessFilterButton =
                (Button) findViewById(R.id.brightnessFilterButton);
        brightnessFilterButton.setOnClickListener
                (new brightnessFilterButtonListener());

        drawablePicker = (Spinner) findViewById(R.id.drawableSpinner);
        ArrayAdapter<CharSequence> itemsAdapter = ArrayAdapter.createFromResource(this, R.array.drawables_array, android.R.layout.simple_spinner_item);
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drawablePicker.setAdapter(itemsAdapter);
        drawablePicker.setOnItemSelectedListener(new drawablePickerClicked());

    }

    private class drawablePickerClicked implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
           if (parent.getItemAtPosition(pos).toString() == "cheese"){
               //finish BitmapDrawable constructors
               originalDrawableBmp = new BitmapDrawable();
           }
           else if(parent.getItemAtPosition(pos).toString() == "edcepp"){

           }
           else if(parent.getItemAtPosition(pos).toString() == "two"){

           }
           else{

           }
           originalImageView.setImageBitmap(originalDrawableBmp.getBitmap());
        }

        public void onNothingSelected(AdapterView<?> parent){

        }

    }
    /*
    * class grayFilterButtonListener this inner class defines the action for
    * the gray filter button.
    */
    private class grayFilterButtonListener implements View.OnClickListener {
        public void onClick(View button) {
            SmoothingFilter filter = new SmoothingFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
        }
    }

    /*
    * class grayFilterButtonListener this inner class defines the action for the
    * brightness filter
    * button.
    */
    private class brightnessFilterButtonListener
            implements View.OnClickListener {
        public void onClick(View button) {
            EdgeDetectionFilter filter = new EdgeDetectionFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
        }
    }
}

