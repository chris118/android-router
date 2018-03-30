package com.hh.ptapp;

import android.app.Application;

import com.hh.ptrouter.PTRouterProcessor_modlue_a;

/**
 * Created by chrisw on 2018/3/30.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        PTRouterProcessor_modlue_a.init();
    }
}
