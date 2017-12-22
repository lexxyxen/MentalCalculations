package com.example.allyx.gridlab.baseclasses;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by allyx on 5/12/2016.
 */
public class ManageNumberAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Numbers> listOfNumbers;

    public ManageNumberAdapter(Context context,
                               ArrayList<Numbers> listOfNumbers) {
        this.context = context;
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public int getCount() {
        return listOfNumbers.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfNumbers.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {

            TextView textViewNumber = new TextView(context);

            int backgroundColor = Color.DKGRAY;
            int textColor = Color.RED;
            Numbers oneNumber = listOfNumbers.get(position);
            oneNumber.setNumberBackgroundColor(backgroundColor);
            oneNumber.setNumberTextColor(textColor);
            textViewNumber.setBackgroundColor
                    (oneNumber.getNumberBackgroundColor());
            textViewNumber.setTextColor(oneNumber.getNumberTextColor());
            textViewNumber.setText(oneNumber.toString());
            textViewNumber.setTextSize(37);
            textViewNumber.setGravity(Gravity.CENTER);
            return textViewNumber;


    }
}
