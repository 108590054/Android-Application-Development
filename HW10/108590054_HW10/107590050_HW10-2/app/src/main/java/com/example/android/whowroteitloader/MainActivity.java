/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.whowroteitloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The WhoWroteIt app queries the Book Search API for books based
 * on a user's search.  It uses an AsyncTask to run the search task in
 * the background.
 */
public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<String> {

    private EditText mUrlInput;
    private TextView mSourceCode;
    private String urlType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUrlInput = findViewById(R.id.urlInput);
        mSourceCode = findViewById(R.id.sourceCode);

        Spinner notify = (Spinner)findViewById(R.id.spinner);
        final ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(
                this, R.array.httpArray, android.R.layout.simple_spinner_item );
        nAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        notify.setAdapter(nAdapter);
        urlType = notify.getSelectedItem().toString();
        notify.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                urlType = (String) nAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    /**
     * onClick handler for the "Search Books" button.
     *
     * @param view The view (Button) that was clicked.
     */
    public void getSourceCode(View view) {
        // Get the search string from the input field.
        String queryString = mUrlInput.getText().toString();

        // Hide the keyboard when the button is pushed.
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        // Check the status of the network connection.
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        // If the network is available, connected, and the search field
        // is not empty, start a BookLoader AsyncTask.
        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {

            Bundle queryBundle = new Bundle();
            queryString = urlType + queryString;
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);

            mSourceCode.setText(R.string.loading);
        }
        // Otherwise update the TextView to tell the user there is no
        // connection, or no search term.
        else {
            if (queryString.length() == 0) {
                mSourceCode.setText(R.string.no_search_term);
            } else {
                mSourceCode.setText(R.string.no_network);
            }
        }
    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";

        if (args != null) {
            queryString = args.getString("queryString");
        }

        return new BookLoader(this, queryString);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (data == null)
        {
            mSourceCode.setText(R.string.no_results);
        }
        else
        {
            mSourceCode.setText(data);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        // Do nothing.  Required by interface.
    }
}
