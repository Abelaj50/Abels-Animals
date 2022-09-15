package com.example.project2;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
/* All images have been downloaded from Pexels.com and used under their free-to-use license. */

public class GridLayoutActivity extends Activity {

    protected static final String EXTRA_RES_ID = "POS";

    protected static ArrayList<Integer> animalArray = new ArrayList<Integer>(
            Arrays.asList(R.drawable.image1, R.drawable.image2,
                    R.drawable.image3, R.drawable.image4, R.drawable.image5,
                    R.drawable.image6, R.drawable.image7, R.drawable.image8));

    protected static ArrayList<String> animalNames = new ArrayList<String>(
            Arrays.asList("Giraffe", "Tiger", "Camel", "Chimpanzee",
                    "Eagle", "Lion", "Shark", "Lizard"));

    /* Behavior for context menu item selections. */
    public boolean onContextItemSelected(MenuItem item) {

        /*Retrieve the information about the GridView item selected. */
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = (int) info.id;
        int pos = info.position;

        if(item.getItemId() == R.id.viewImage) {
            Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);
            intent.putExtra(EXTRA_RES_ID, id);
            intent.putExtra("ClickedAnimal", pos);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.interestingFacts) {
            Intent newIntent = new Intent(GridLayoutActivity.this, FactsActivity.class);
            newIntent.putExtra(EXTRA_RES_ID, id);
            newIntent.putExtra("INDEX", pos);
            startActivity(newIntent);
        }
        else if (item.getItemId() == R.id.wikipedia) {
            String[] linkArray = getResources().getStringArray(R.array.links);
            Uri uri = Uri.parse(linkArray[pos]);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
        else {
            Toast.makeText(this, "Error with context menu", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Load up the main UI element in this activity. */
        GridView gridview = (GridView) findViewById(R.id.gridview);

        /* Create a new ImageAdapter and set it as the Adapter for this GridView. */
        gridview.setAdapter(new ImageAdapter(this, animalArray, animalNames));

        /* Set an OnItemClickListener for elements in the GridView. */
        gridview.setOnItemClickListener((AdapterView<?> parent, View v, int position, long id)->{
            Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);

            /* Add the id and position of the clicked image to be used as Intent Extras. */
            intent.putExtra(EXTRA_RES_ID, (int) id);
            intent.putExtra("ClickedAnimal", position);
            startActivity(intent);
        });

        /* Register the GridView for a context menu. */
        registerForContextMenu(gridview);

        /* Set an onCreateContextMenuListener for the GridView to bring up the context menu. */
        gridview.setOnCreateContextMenuListener((ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)->{
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            //menu.setHeaderTitle("Select Action");
        });
    }

}