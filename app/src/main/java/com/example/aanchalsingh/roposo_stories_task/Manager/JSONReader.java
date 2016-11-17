package com.example.aanchalsingh.roposo_stories_task.Manager;

import android.app.Activity;
import android.content.Context;
import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Story;
import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Users;
import com.example.aanchalsingh.roposo_stories_task.Utils.RealmController;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AANCHAL SINGH on 11/17/2016.
 */

public class JSONReader {

    List<Story> storyList = new ArrayList<>();
    List<Users> userList = new ArrayList<>();
    String json;
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

    // gets stories and saves users
    public List<Story> parseJSONFromAsset() {
        try {
            InputStream is = context.getAssets().open("jsonFile.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JsonParser parser = new JsonParser();
            JsonArray array = parser.parse(json).getAsJsonArray();
            Gson gson = new Gson();
            for(int i=0;i<2;i++)
            {
                userList.add(gson.fromJson(array.get(i),Users.class));
            }
            for(int j=2;j<array.size();j++)
            {
                storyList.add(gson.fromJson(array.get(j),Story.class));
            }

            RealmController.with((Activity) context).addUsersToDB(userList);
            return storyList;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
