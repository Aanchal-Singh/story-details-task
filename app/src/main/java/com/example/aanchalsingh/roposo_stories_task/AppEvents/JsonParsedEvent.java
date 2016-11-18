package com.example.aanchalsingh.roposo_stories_task.AppEvents;

import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Story;
import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Users;
import java.util.List;

/**
 * Created by AANCHAL SINGH on 11/17/2016.
 */

public class JsonParsedEvent {

    List<Story> storyList;
    List<Users> usersList;

    public JsonParsedEvent(List<Story> storyList, List<Users> usersList) {
        this.storyList = storyList;
        this.usersList = usersList;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    public JsonParsedEvent(List<Story> storyList) {
        this.storyList = storyList;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }
}