package com.coder.zzq.apparchiteturelib.manager;

import android.support.annotation.NonNull;


import com.coder.zzq.apparchiteturelib.mvp.view.activity.SimpleBaseActivity;

import java.util.ArrayDeque;
import java.util.Deque;




/**
 * Created by 朱志强 on 2017/5/1.
 */

public class ActivityManager {

    private static Deque<SimpleBaseActivity> sActivityStack = new ArrayDeque<>();

    public static SimpleBaseActivity push(@NonNull SimpleBaseActivity activity){
        sActivityStack.push(activity);
        return activity;
    }

    public static void pop(){
        sActivityStack.pop();
    }

    public static void clearStack(){
        int size = sActivityStack.size();
        for (int index = 0;index < size;index++){
            sActivityStack.pop().finish();
        }
    }

    public static boolean isStackEmpty(){
        return sActivityStack.isEmpty();
    }


    public static <T extends SimpleBaseActivity> T topActivity(Class<T> activityClass){
        return activityClass.cast(sActivityStack.peekFirst());
    }
}
