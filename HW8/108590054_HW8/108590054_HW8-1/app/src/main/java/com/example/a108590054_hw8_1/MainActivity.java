package com.example.a108590054_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ImageView battery;
    public final List<Integer> batterylvl = new ArrayList<>();
    public int currentlvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batterylvl.add(0);
        batterylvl.add(20);
        batterylvl.add(30);
        batterylvl.add(50);
        batterylvl.add(60);
        batterylvl.add(80);
        batterylvl.add(100);

        currentlvl = 2;

        battery = (ImageView) findViewById(R.id.imageView);
        battery.setImageLevel(batterylvl.get(currentlvl));

    }

    public void Battery_UP(View view) {
        if(currentlvl > 0) currentlvl--;
        battery.setImageLevel(batterylvl.get(currentlvl));
    }

    public void Battery_DOWN(View view) {
        if(currentlvl < 6) currentlvl++;
        battery.setImageLevel(batterylvl.get(currentlvl));
    }
}