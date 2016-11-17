package com.example.aanchalsingh.roposo_stories_task.Utils;

import android.app.Activity;
import android.app.Fragment;
import com.example.aanchalsingh.roposo_stories_task.DatabaseModels.User;
import com.example.aanchalsingh.roposo_stories_task.NetworkModels.Users;
import java.util.List;
import io.realm.Realm;

/**
 *  All database operations here
 */
public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {

        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController((Application) fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController((Application) activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    public void addUsersToDB(final List<Users> userList)
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                for(int i=0;i<userList.size();i++)
                {
                    final User user = realm.where(User.class).equalTo("id", userList.get(i).getId()).findFirst();
                    if (user == null) {
                        User newUser = realm.createObject(User.class);
                        newUser.setId(userList.get(i).getId());
                        newUser.setAbout(userList.get(i).getAbout());
                        newUser.setIsFollowing(userList.get(i).isIsFollowing());
                        newUser.setFollowers(userList.get(i).getFollowers());
                        newUser.setFollowing(userList.get(i).getFollowing());
                        newUser.setHandle(userList.get(i).getHandle());
                        newUser.setImage(userList.get(i).getImage());
                        newUser.setUrl(userList.get(i).getUrl());
                        newUser.setUsername(userList.get(i).getUsername());
                    }
                }
            }
        });
    }

    //check if following this user
    public boolean isFollowing(String id) {

        User user = realm.where(User.class).equalTo("id", id).findFirst();
        if(user!=null)
        {
            return (user.getIsFollowing());
        }
        return  false;
    }

    //set is following to true/false
    public void updateIsFollowing(final String id, final boolean status) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                final User user = realm.where(User.class).equalTo("id", id).findFirst();
                if (user != null) {
                    user.setIsFollowing(status);
                }
            }
        });
    }

    public User getUserDetails(String id)
    {
        return realm.where(User.class).equalTo("id", id).findFirst();
    }
}

