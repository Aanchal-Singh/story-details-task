package com.example.aanchalsingh.roposo_stories_task.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AANCHAL SINGH on 11/17/2016.
 */

public class AppPreferences {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private int PRIVATE_MODE=0;
    private String PREF="MyPrefs";
    private static final String FOLLOWING = "following";
    private static AppPreferences instance;


    private AppPreferences(Context context)
    {
        this.context=context;
        sharedPreferences = context.getSharedPreferences(PREF, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public static AppPreferences getInstance(Context context)
    {
        if(instance==null)
        {
            return new AppPreferences(context);
        }

        return instance;
    }

    public void addToFollowingSet(String id) {
        Set<String> followSet = sharedPreferences.getStringSet(FOLLOWING, new HashSet<String>());
        followSet.add(id);
        editor.putStringSet(FOLLOWING,followSet);
        editor.commit();
    }

    public boolean ifFollowSetContains(String id) {
        if (sharedPreferences.getStringSet(FOLLOWING, new HashSet<String>()).contains(id)) {
            return true;
        }
        return false;
    }

    public void removeFromFollowSet(String id) {
        Set<String> followSet = sharedPreferences.getStringSet(FOLLOWING, new HashSet<String>());
        followSet.remove(id);
        editor.putStringSet(FOLLOWING,followSet);
        editor.commit();
    }


}
