package com.example.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> animalArray;
    private ArrayList<String> animalNames;
    private LayoutInflater layoutinflater;

    /* Constructor. */
    public ImageAdapter(Context c, List<Integer> ids, ArrayList<String> animalNames) {
        mContext = c;
        this.animalArray = ids;
        this.animalNames = animalNames;
        this.layoutinflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /* Return the number of items in the Adapter. */
    @Override
    public int getCount() {
        return animalArray.size();
    }

    /* Return the data item at position. */
    @Override
    public Object getItem(int position) {
        return animalArray.get(position);
    }

    /* Return the item ID. */
    @Override
    public long getItemId(int position) {
        return animalArray.get(position);
    }

    /* Return an ImageView for each item referenced by the Adapter. */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = layoutinflater.inflate(R.layout.items_layout, parent, false);
        }

        TextView anName = convertView.findViewById(R.id.animalName);
        ImageView anPhoto = convertView.findViewById(R.id.imageView1);

        anName.setText(animalNames.get(position));
        anPhoto.setImageResource(animalArray.get(position));

        return convertView;
    }
}
