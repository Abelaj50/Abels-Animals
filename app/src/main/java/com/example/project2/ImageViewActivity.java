package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
    Intent oldIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Get the Intent used to start this Activity. */
        oldIntent = getIntent();
        ImageView imageView = new ImageView(getApplicationContext());

        /* Get the filename of the image to display and set it as the image for this ImageView. */
        imageView.setImageResource(oldIntent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0));

        /* Set an onClickListener to provide for a transition to the third activity.*/
        imageView.setOnClickListener((View v)->{
            Intent newIntent = new Intent(ImageViewActivity.this, FactsActivity.class);

            /* Pass along the clicked position extra in new intent for third activity. */
            newIntent.putExtra("INDEX", oldIntent.getIntExtra("ClickedAnimal", 0));
            startActivity(newIntent);
        });

        setContentView(imageView);
    }

}