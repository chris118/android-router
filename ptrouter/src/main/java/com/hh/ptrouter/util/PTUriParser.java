package com.hh.ptrouter.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chrisw on 2018/3/30.
 */

public class PTUriParser {
    private static String TAG = PTUriParser.class.getSimpleName();

    public static String getRouter(Uri uri){
        return uri.getScheme() + "://" + uri.getHost() + uri.getPath();
    }

    public static Map<String, String> getParams(Uri uri){
        String query = uri.getEncodedQuery();
        if (!TextUtils.isEmpty(query)) {
            Map<String,String> params = new HashMap<>();
            String[] split = query.split("&");
            for (String param : split) {
                if (!param.contains("=")) {
                    continue;
                }
                int index = param.indexOf("=");
                String key = param.substring(0, index);
                String value = param.substring(index + 1, param.length());
                Log.d(TAG, "key = " + key);
                Log.d(TAG, "value = " + value);
                params.put(key, value);
            }
            return params;
        }
        return new HashMap<>();
    }
}
