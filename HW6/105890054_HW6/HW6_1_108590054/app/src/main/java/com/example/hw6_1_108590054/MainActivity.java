
package com.example.hw6_1_108590054;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox syrup;
    private CheckBox sprinkles;
    private CheckBox nuts;
    private CheckBox cherries;
    private CheckBox crumbles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        syrup = (CheckBox) findViewById(R.id.check_syrup);
        sprinkles = (CheckBox) findViewById(R.id.check_sprinkles);
        nuts = (CheckBox) findViewById(R.id.check_nuts);
        cherries = (CheckBox) findViewById(R.id.check_cherries);
        crumbles = (CheckBox) findViewById(R.id.check_crumbles);
    }

    public void onClicked(View view)
    {
        String s = "Topping: ";
        if(syrup.isChecked()) {
            s += syrup.getText().toString() + " ";
        }
        if(sprinkles.isChecked()) {
            s += sprinkles.getText().toString() + " ";
        }
        if(nuts.isChecked()) {
            s += nuts.getText().toString() + " ";
        }
        if(cherries.isChecked()) {
            s += cherries.getText().toString() + " ";
        }
        if(crumbles.isChecked()) {
            s += crumbles.getText().toString() + " ";
        }

        Toast toast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        toast.show();

    }
}