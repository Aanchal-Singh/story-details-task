package com.example.aanchalsingh.roposo_stories_task.Utils;

import android.app.Activity;
import android.app.Fragment;
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

//    //check if flower already in db
//    public boolean ifDbContainsData(int id) {
//        if(realm.where(Flower.class).equalTo("id", id).findFirst()!=null) {
//            return true;
//        }
//        return false;
//    }
//
//    //add saved flower to db
//    public void addFlowerToDb(final int id, final String name)
//    {
//        Flower flowerResult = realm.where(Flower.class).equalTo("id",id).findFirst();
//        if(flowerResult==null)
//        {
//            realm.executeTransaction(new Realm.Transaction() {
//                @Override
//                public void execute(Realm realm) {
//                    Flower flower = realm.createObject(Flower.class);
//                    flower.setId(id);
//                    flower.setName(name);
//                }
//            });
//
//
//        }
//
//    }
//
//    // delete unsaved flower
//    public void deleteFlowerData(int id) {
//        final RealmResults<Flower> results = realm.where(Flower.class).equalTo("id", id).findAll();
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                results.deleteAllFromRealm();
//            }
//        });
//
//    }


}
