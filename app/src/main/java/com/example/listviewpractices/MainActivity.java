package com.example.listviewpractices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBad = findViewById(R.id.btn_bad);
        Button btnBetter = findViewById(R.id.btn_better);
        Button btnBest = findViewById(R.id.btn_best);

        btnBad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, BadPractice.class);
                startActivity(intent);
            }
        });

        btnBetter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, BetterPractice.class);
                startActivity(intent);
            }
        });

        btnBest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, BestPractice.class);
                startActivity(intent);
            }
        });
    }
}