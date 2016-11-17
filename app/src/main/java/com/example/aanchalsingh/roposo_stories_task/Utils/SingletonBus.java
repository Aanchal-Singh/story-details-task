package com.example.aanchalsingh.roposo_stories_task.Utils;

import com.squareup.otto.Bus;

/**
 * Created by AANCHAL SINGH on 11/17/2016.
 */

/**
 * returns a single bus for the application
 */
public class SingletonBus {

    public static Bus bus=null;

    public static Bus getBus()
    {
        if(bus==null)
        {
            bus = new Bus();

        }
        return bus;
    }

}
