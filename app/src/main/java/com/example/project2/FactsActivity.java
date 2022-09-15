package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactsActivity extends Activity {
    int animalIndex;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_facts);

        /* Load up all UI elements. */
        TextView animalFactsName = (TextView) findViewById(R.id.animalFactsName);
        ImageView animalFactsPic = (ImageView) findViewById(R.id.factsPic);
        TextView subtitleText = (TextView) findViewById(R.id.subtitleText);
        TextView synopsis = (TextView) findViewById(R.id.synopsis);
        TextView lifespan = (TextView) findViewById(R.id.lifespan);
        TextView size = (TextView) findViewById(R.id.size);
        TextView weight = (TextView) findViewById(R.id.weight);
        TextView habitat = (TextView) findViewById(R.id.habitat);
        TextView diet = (TextView) findViewById(R.id.diet);
        TextView national = (TextView) findViewById(R.id.national);
        TextView conservation = (TextView) findViewById(R.id.conservation);

        /* Load up all string arrays in Resources. */
        String[] subtitleArray = getResources().getStringArray(R.array.subtitles);
        List<CharSequence> synopsisArray = Arrays.asList(getResources().getTextArray(R.array.synopsis)); //Conversion to keep bold/formatted text!
        List<CharSequence> lifespanArray = Arrays.asList(getResources().getTextArray(R.array.lifespan)); //Conversion to keep bold/formatted text!
        List<CharSequence> sizeArray = Arrays.asList(getResources().getTextArray(R.array.size)); //Conversion to keep bold/formatted text!
        List<CharSequence> weightArray = Arrays.asList(getResources().getTextArray(R.array.weight)); //Conversion to keep bold/formatted text!
        List<CharSequence> habitatArray = Arrays.asList(getResources().getTextArray(R.array.habitat)); //Conversion to keep bold/formatted text!
        List<CharSequence> dietArray = Arrays.asList(getResources().getTextArray(R.array.diet)); //Conversion to keep bold/formatted text!
        List<CharSequence> nationalArray = Arrays.asList(getResources().getTextArray(R.array.national)); //Conversion to keep bold/formatted text!
        List<CharSequence> conservationArray = Arrays.asList(getResources().getTextArray(R.array.conservation)); //Conversion to keep bold/formatted text!


        /* Get the Intent used to start this activity and use the Extra as an index. */
        Intent i2 = getIntent();
        animalIndex = i2.getIntExtra("INDEX", 0);

        /* Error handling if for some reason the index isn't valid. */
        if((animalIndex < 0) || (animalIndex > GridLayoutActivity.animalNames.size()-1)) {
            Toast.makeText(
                    getApplicationContext(),
                    String.format("ERR: Could not find data for animal at index: %s.", animalIndex),
                    Toast.LENGTH_SHORT
            ).show();
        }

        /* Display some facts within the UI elements for the selected animal. */
        else {
            String displayName = GridLayoutActivity.animalNames.get(animalIndex) + " facts";
            animalFactsName.setText(displayName);
            animalFactsPic.setImageResource(GridLayoutActivity.animalArray.get(animalIndex));
            subtitleText.setText(subtitleArray[animalIndex]);
            synopsis.setText(synopsisArray.get(animalIndex));
            lifespan.setText(lifespanArray.get(animalIndex));
            size.setText(sizeArray.get(animalIndex));
            weight.setText(weightArray.get(animalIndex));
            habitat.setText(habitatArray.get(animalIndex));
            diet.setText(dietArray.get(animalIndex));
            national.setText(nationalArray.get(animalIndex));
            conservation.setText(conservationArray.get(animalIndex));
        }


    }

}
