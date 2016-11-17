package com.example.aanchalsingh.roposo_stories_task.Utils;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by AANCHAL SINGH on 11/17/2016.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }
}
