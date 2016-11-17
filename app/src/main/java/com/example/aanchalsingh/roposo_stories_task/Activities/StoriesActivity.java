package com.example.aanchalsingh.roposo_stories_task.Activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.example.aanchalsingh.roposo_stories_task.Adapters.StoryAdapter;
import com.example.aanchalsingh.roposo_stories_task.Manager.JSONReader;
import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Story;
import com.example.aanchalsingh.roposo_stories_task.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StoriesActivity extends Activity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<Story> storyList;
    StoryAdapter storyAdapter;
    RecyclerView.LayoutManager LayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.setStatusBarColor(ContextCompat.getColor(this, R.color.commonBackground));
            }
        }
        setContentView(R.layout.activity_stories);
        new fetchStoriesFromJSON().execute();
        ButterKnife.bind(this);
        storyList= new ArrayList<>();
        storyAdapter =new StoryAdapter(storyList,this);
        LayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(storyAdapter);
    }

    public class fetchStoriesFromJSON extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {
            storyList = JSONReader.getInstance(StoriesActivity.this).parseJSONFromAsset();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            storyAdapter.refreshView(storyList);
            Log.wtf("story list",""+storyList);
            super.onPostExecute(aVoid);
        }
    }
}
