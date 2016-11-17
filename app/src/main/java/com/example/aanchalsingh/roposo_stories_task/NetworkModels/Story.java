package com.example.aanchalsingh.roposo_stories_task.NetworkModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Story {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("verb")
    @Expose
    private String verb;
    @SerializedName("db")
    @Expose
    private String db;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("si")
    @Expose
    private String si;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("like_flag")
    @Expose
    private boolean likeFlag;
    @SerializedName("likes_count")
    @Expose
    private long likesCount;
    @SerializedName("comment_count")
    @Expose
    private long commentCount;

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The verb
     */
    public String getVerb() {
        return verb;
    }

    /**
     *
     * @param verb
     * The verb
     */
    public void setVerb(String verb) {
        this.verb = verb;
    }

    /**
     *
     * @return
     * The db
     */
    public String getDb() {
        return db;
    }

    /**
     *
     * @param db
     * The db
     */
    public void setDb(String db) {
        this.db = db;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The si
     */
    public String getSi() {
        return si;
    }

    /**
     *
     * @param si
     * The si
     */
    public void setSi(String si) {
        this.si = si;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The likeFlag
     */
    public boolean isLikeFlag() {
        return likeFlag;
    }

    /**
     *
     * @param likeFlag
     * The like_flag
     */
    public void setLikeFlag(boolean likeFlag) {
        this.likeFlag = likeFlag;
    }

    /**
     *
     * @return
     * The likesCount
     */
    public long getLikesCount() {
        return likesCount;
    }

    /**
     *
     * @param likesCount
     * The likes_count
     */
    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    /**
     *
     * @return
     * The commentCount
     */
    public long getCommentCount() {
        return commentCount;
    }

    /**
     *
     * @param commentCount
     * The comment_count
     */
    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

}