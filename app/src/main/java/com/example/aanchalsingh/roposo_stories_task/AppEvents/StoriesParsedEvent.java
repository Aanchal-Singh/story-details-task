package com.example.aanchalsingh.roposo_stories_task.AppEvents;

import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Story;

import java.util.List;

/**
 * Created by AANCHAL SINGH on 11/17/2016.
 */

public class StoriesParsedEvent {

    List<Story> storyList;

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    public StoriesParsedEvent(List<Story> storyList) {
        this.storyList = storyList;
    }
}
