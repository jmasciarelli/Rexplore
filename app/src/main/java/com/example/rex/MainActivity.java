package com.example.rex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    String queryType = "music"; //defaults
    int queryLimit = 20;
    int queryInfo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**selectMusic is triggered on music tab selection and sets the users
     * query type while adjusting the button styles and text area
     * */
    public void selectMusic(View view){
        //set query type
        queryType="music";

        //clear search area
        EditText textBox = (EditText) findViewById(R.id.searchBox);
        textBox.setText("");

        //set button styles
        findViewById(R.id.musicButton).setBackgroundColor(Color.parseColor("#70FFA5"));
        findViewById(R.id.moviesButton).setBackgroundColor(Color.parseColor("#9B9B9B"));
        findViewById(R.id.showsButton).setBackgroundColor(Color.parseColor("#9B9B9B"));
    }

    /**selectMovies is triggered on music tab selection and sets the users
     * query type while adjusting the button styles and text area
     * */
    public void selectMovies(View view){
        //set query type
        queryType="movie";

        //clear search area
        EditText textBox = (EditText) findViewById(R.id.searchBox);
        textBox.setText("");

        //set button styles
        findViewById(R.id.musicButton).setBackgroundColor(Color.parseColor("#9B9B9B"));
        findViewById(R.id.moviesButton).setBackgroundColor(Color.parseColor("#70FFA5"));
        findViewById(R.id.showsButton).setBackgroundColor(Color.parseColor("#9B9B9B"));
    }

    /**selectShows is triggered on music tab selection and sets the users
     * query type while adjusting the button styles and text area
     * */
    public void selectShows(View view){
        //set query type
        queryType="show";

        //clear search area
        EditText textBox = (EditText) findViewById(R.id.searchBox);
        textBox.setText("");

        //set button styles
        findViewById(R.id.musicButton).setBackgroundColor(Color.parseColor("#9B9B9B"));
        findViewById(R.id.moviesButton).setBackgroundColor(Color.parseColor("#9B9B9B"));
        findViewById(R.id.showsButton).setBackgroundColor(Color.parseColor("#70FFA5"));
    }

    /** doSearch executes when the search button is pressed. It takes the user input and uses
     * the global variables to make an api call, and then handles the return.
     * */
    public void doSearch(View view) {
        // Get the search query
        EditText textArea = (EditText)findViewById(R.id.searchBox);
        String input = textArea.getText().toString();

        // Start a thread to pull the API data
        APIThread thread = new APIThread(input,queryType,queryLimit,queryInfo);
        thread.start();
        while (!thread.isComplete()) {}

        // Save the API data into JSONArrays
        JSONArray infoArray = thread.getInfo();
        JSONArray resultsArray = thread.getResults();

        // Start new ExploreMMS activity with JSON data
//        Intent intent = new Intent(ExploreRandoms.this, ExploreMMS.class);
//        intent.putExtra("info", String.valueOf(infoArray));
//        intent.putExtra("results", String.valueOf(resultsArray));
//        startActivity(intent);
    }

}