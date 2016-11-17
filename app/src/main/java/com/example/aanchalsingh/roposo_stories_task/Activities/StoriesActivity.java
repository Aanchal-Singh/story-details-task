package com.example.aanchalsingh.roposo_stories_task.Activities;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.example.aanchalsingh.roposo_stories_task.Adapters.StoryAdapter;
import com.example.aanchalsingh.roposo_stories_task.AppEvents.JsonParsedEvent;
import com.example.aanchalsingh.roposo_stories_task.Manager.JSONReader;
import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Story;
import com.example.aanchalsingh.roposo_stories_task.R;
import com.example.aanchalsingh.roposo_stories_task.Utils.RealmController;
import com.example.aanchalsingh.roposo_stories_task.Utils.SingletonBus;
import com.squareup.otto.Subscribe;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class StoriesActivity extends Activity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<Story> storyList;
    StoryAdapter storyAdapter;
    RecyclerView.LayoutManager LayoutManager;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

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
        ButterKnife.bind(this);
        SingletonBus.getBus().register(this);
        storyList= new ArrayList<>();
        storyAdapter =new StoryAdapter(storyList,this);
        LayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(storyAdapter);
        recyclerView.getItemAnimator().setChangeDuration(0);
        JSONReader.getInstance(StoriesActivity.this).parseJSONFromAsset();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SingletonBus.getBus().unregister(this);
    }


    @Subscribe
    public void receivedParsedData(JsonParsedEvent jsonParsedEvent)
    {
        if(jsonParsedEvent!=null) {
            RealmController.with(this).addUsersToDB(jsonParsedEvent.getUsersList());
            storyAdapter.refreshView(jsonParsedEvent.getStoryList());
        } else {
            Toast.makeText(this,"Failed to parse data",Toast.LENGTH_LONG).show();
        }
    }
}
