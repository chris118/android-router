package com.hh.ptrouter.model;

import android.app.Activity;
import android.net.Uri;

/**
 * Created by chrisw on 2018/3/27.
 */

public class PTRoutEntity {
    public PTRoutEntity(Uri uri, Class<? extends Activity> activity) {
        this.uri = uri;
        this.activity = activity;
    }

    private final Uri uri;
    private final Class<? extends Activity> activity;

    public Uri getUri() {
        return uri;
    }

    public Class<? extends Activity> getActivity() {
        return activity;
    }
}
