package com.example.aanchalsingh.roposo_stories_task.NetworkModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Story {

    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("followers")
    @Expose
    private int followers;
    @SerializedName("following")
    @Expose
    private int following;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("handle")
    @Expose
    private String handle;
    @SerializedName("is_following")
    @Expose
    private boolean isFollowing;
    @SerializedName("createdOn")
    @Expose
    private long createdOn;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("verb")
    @Expose
    private String verb;
    @SerializedName("db")
    @Expose
    private String db;
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
    private int likesCount;
    @SerializedName("comment_count")
    @Expose
    private int commentCount;

    /**
     *
     * @return
     * The about
     */
    public String getAbout() {
        return about;
    }

    /**
     *
     * @param about
     * The about
     */
    public void setAbout(String about) {
        this.about = about;
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
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The followers
     */
    public int getFollowers() {
        return followers;
    }

    /**
     *
     * @param followers
     * The followers
     */
    public void setFollowers(int followers) {
        this.followers = followers;
    }

    /**
     *
     * @return
     * The following
     */
    public int getFollowing() {
        return following;
    }

    /**
     *
     * @param following
     * The following
     */
    public void setFollowing(int following) {
        this.following = following;
    }

    /**
     *
     * @return
     * The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     * The image
     */
    public void setImage(String image) {
        this.image = image;
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
     * The handle
     */
    public String getHandle() {
        return handle;
    }

    /**
     *
     * @param handle
     * The handle
     */
    public void setHandle(String handle) {
        this.handle = handle;
    }

    /**
     *
     * @return
     * The isFollowing
     */
    public boolean isIsFollowing() {
        return isFollowing;
    }

    /**
     *
     * @param isFollowing
     * The is_following
     */
    public void setIsFollowing(boolean isFollowing) {
        this.isFollowing = isFollowing;
    }

    /**
     *
     * @return
     * The createdOn
     */
    public long getCreatedOn() {
        return createdOn;
    }

    /**
     *
     * @param createdOn
     * The createdOn
     */
    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

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
    public int getLikesCount() {
        return likesCount;
    }

    /**
     *
     * @param likesCount
     * The likes_count
     */
    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    /**
     *
     * @return
     * The commentCount
     */
    public int getCommentCount() {
        return commentCount;
    }

    /**
     *
     * @param commentCount
     * The comment_count
     */
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

}