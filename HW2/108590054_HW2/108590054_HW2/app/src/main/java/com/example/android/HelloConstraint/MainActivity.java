
package com.example.android.HelloConstraint;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button CountButton;
    private Button ResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        CountButton = findViewById(R.id.button_count);
        ResetButton = findViewById(R.id.button_zero);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        ResetButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        if ((mCount % 2) == 0){
            view.setBackgroundColor(Color.YELLOW);
        }
        else{
            view.setBackgroundColor(Color.BLUE);
        }
    }
    public void becomeZero(View view) {
        mCount = 0;
        view.setBackgroundColor(Color.GRAY);
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            CountButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
