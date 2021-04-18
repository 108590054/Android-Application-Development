package com.example.android.HW7_2_108590054;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_content);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String item_name = null;
        if (extras != null) {
           item_name = extras.getString(RecipeListAdapter.EXTRA_NAME);
        }
        TextView heading = findViewById(R.id.food_name);
        ImageView imageView = findViewById(R.id.food_image);
        heading.setText(item_name);
        if (item_name != null) {
            switch (item_name){
                case "Chicken Satay":
                    imageView.setImageResource(R.drawable.chicken_satay);
                    break;
                case "Onde-onde":
                    imageView.setImageResource(R.drawable.onde_onde);
                    break;
                case "Chicken Curry":
                    imageView.setImageResource(R.drawable.chicken_curry);
                    break;
                case "Char Hor Fun":
                    imageView.setImageResource(R.drawable.char_ho_fun);
                    break;
                case "Soto Ayam":
                    imageView.setImageResource(R.drawable.soto_ayam);
                    break;
                case "Mee Goreng":
                    imageView.setImageResource(R.drawable.mee_goreng);
                    break;
                case "Spicy Grilled Fish":
                    imageView.setImageResource(R.drawable.spicy_grilled_fish);
                    break;
                case "Nasi Lemak":
                    imageView.setImageResource(R.drawable.nasi_lemak);
                    break;
                case "Beef Rendang":
                    imageView.setImageResource(R.drawable.beef_rendang);
                    break;
                case "Laksa":
                    imageView.setImageResource(R.drawable.laksa);
                    break;
                case "Kaya Toast":
                    imageView.setImageResource(R.drawable.kaya_toast);
                    break;
                case "Bak Kut Teh":
                    imageView.setImageResource(R.drawable.bak_kut_teh);
                    break;
                default: break;
            }
        }
    }
}
