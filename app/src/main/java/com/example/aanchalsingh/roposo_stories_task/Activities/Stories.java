package com.example.aanchalsingh.roposo_stories_task.Activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aanchalsingh.roposo_stories_task.Manager.JSONReader;
import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Story;
import com.example.aanchalsingh.roposo_stories_task.R;

import java.util.List;

public class Stories extends AppCompatActivity {

    private List<Story> storyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        new fetchStoriesFromJSON().execute();
    }

    public class fetchStoriesFromJSON extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {
            storyList = JSONReader.getInstance(Stories.this).loadJSONFromAsset();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.wtf("story list",""+storyList);
            super.onPostExecute(aVoid);
        }
    }
}
