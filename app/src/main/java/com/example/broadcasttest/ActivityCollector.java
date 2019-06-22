package com.example.broadcasttest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * class description:
 * author ywk
 * since 2019-06-18
 */
public  class ActivityCollector {

    private static List<Activity> mActivityList = new ArrayList<>();

    public static void addActivity(Activity activity){
        mActivityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        mActivityList.remove(activity);
    }

    public static void finishAllActivity(){
        for (Activity mActivity:mActivityList) {
            if(!mActivity.isFinishing()){
                mActivity.finish();
            }
        }
        mActivityList.clear();
    }

}