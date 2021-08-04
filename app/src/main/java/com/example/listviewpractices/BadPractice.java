package com.example.listviewpractices;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class BadPractice extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_practice);

        ArrayList<Item> items = new ArrayList<>(Arrays.asList(
                new Item("one","واحد",R.drawable.one),
                new Item("two","اثنان",R.drawable.two),
                new Item("three","ثلاثة",R.drawable.three),
                new Item("four","أربعة",R.drawable.four),
                new Item("five","خمسة",R.drawable.five),
                new Item("six","ستة",R.drawable.six),
                new Item("seven","سبعة",R.drawable.seven)));
        ListView lstView = findViewById(R.id.bad_list);
        lstView.setAdapter(new BadAdapter (this, items, android.R.color.holo_red_dark));
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

class BadAdapter extends ArrayAdapter<Item>
{
    private int backgroundColor;
    private  ArrayList<Item> items;

    BadAdapter(Activity context, ArrayList<Item> items, int backgroundColor) {
        super(context, 0, items);
        this.backgroundColor = backgroundColor;
        this.items = items;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItemView;
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.best_list_item, parent, false);

        int color = ContextCompat.getColor(getContext(), backgroundColor);
        parent.setBackgroundColor(color);

        ImageView img = listItemView.findViewById(R.id.list_item_imageView);
        img.setImageResource(items.get(position).getImageID());

        TextView txtDay = listItemView.findViewById(R.id.list_item_textView1);
        txtDay.setText(items.get(position).getDay());

        TextView txtDescription = listItemView.findViewById(R.id.list_item_textView2);
        txtDescription.setText(items.get(position).getDescription());

        return listItemView;
    }

}