package com.example.aanchalsingh.roposo_stories_task.Manager;

import android.content.Context;
import android.util.Log;

import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Story;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AANCHAL SINGH on 11/17/2016.
 */

public class JSONReader {

    List<Story> storyList= new ArrayList<>();
    String storiesData;
    Context context;

    private static JSONReader _instance;

    private JSONReader(Context context) {
        this.context = context;
    }

    public static JSONReader getInstance(Context context) {
        if (null == _instance) {
            _instance = new JSONReader(context);
        }

        return _instance;
    }

    public List<Story> loadJSONFromAsset() {
        try {
            InputStream is = context.getAssets().open("stories.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            storiesData = new String(buffer, "UTF-8");
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            storyList= Arrays.asList(gson.fromJson(storiesData, Story[].class));
            return storyList;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
