/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.HW7_1_108590054;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Tag for the intent extra.
    public static final String EXTRA_MESSAGE = "com.example.android.HW7_1_108590054.extra.MESSAGE";
    // The order message, displayed in the Toast and sent to the new Activity.
    private static String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void showDonutOrder(View view) {
        Intent intent1 = new Intent(MainActivity.this,
                        OrderActivity1.class);
        intent1.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent1);
    }

    public void showIceCreamOrder(View view) {
        Intent intent2 = new Intent(MainActivity.this,
                OrderActivity2.class);
        intent2.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent2);
    }

    public void showFroyoOrder(View view) {
        Intent intent3 = new Intent(MainActivity.this,
                OrderActivity3.class);
        intent3.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent3);
    }

}
