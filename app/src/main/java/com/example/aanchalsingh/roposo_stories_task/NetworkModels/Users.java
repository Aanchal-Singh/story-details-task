package com.example.aanchalsingh.roposo_stories_task.NetworkModels;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Users {

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
    private long followers;
    @SerializedName("following")
    @Expose
    private long following;
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
    public long getFollowers() {
        return followers;
    }

    /**
     *
     * @param followers
     * The followers
     */
    public void setFollowers(long followers) {
        this.followers = followers;
    }

    /**
     *
     * @return
     * The following
     */
    public long getFollowing() {
        return following;
    }

    /**
     *
     * @param following
     * The following
     */
    public void setFollowing(long following) {
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

}