package com.example.listviewpractices;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class BetterPractice extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_better_practice);

        ArrayList<Item> items = new ArrayList<>(Arrays.asList(
                new Item("one","واحد",R.drawable.one),
                new Item("two","اثنان",R.drawable.two),
                new Item("three","ثلاثة",R.drawable.three),
                new Item("four","أربعة",R.drawable.four),
                new Item("five","خمسة",R.drawable.five),
                new Item("six","ستة",R.drawable.six),
                new Item("seven","سبعة",R.drawable.seven)));
        ListView lstView = findViewById(R.id.better_list);
        lstView.setAdapter(new BetterAdapter (this, items, android.R.color.holo_orange_dark));
    }
}

class BetterAdapter extends ArrayAdapter<Item>
{
    private int backgroundColor;
    private  ArrayList<Item> items;

    BetterAdapter(Activity context, ArrayList<Item> items, int backgroundColor) {
        super(context, 0, items);
        this.backgroundColor = backgroundColor;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItemView = null;
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.best_list_item, parent, false);

        int color = ContextCompat.getColor(getContext(), backgroundColor);
        parent.setBackgroundColor(color);

        ImageView img = listItemView.findViewById(R.id.list_item_imageView);
        img.setImageBitmap(decodeSampledBitmapFromResource(super.getContext().getResources(), items.get(position).getImageID(), 100, 100));


        TextView txtDay = listItemView.findViewById(R.id.list_item_textView1);
        txtDay.setText(items.get(position).getDay());

        TextView txtDescription = listItemView.findViewById(R.id.list_item_textView2);
        txtDescription.setText(items.get(position).getDescription());

        return listItemView;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight)
    {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if(height > reqHeight || width > reqWidth){
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth){
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

}