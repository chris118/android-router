package com.hh.ptrouter;

import android.app.Activity;
import android.net.Uri;

import com.hh.ptrouter.model.PTRoutEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chrisw on 2018/3/30.
 */

public class PTRouterCache {
    private static List<PTRoutEntity> entity_list = new ArrayList<>();

    public static void Register(String url, Class<? extends Activity> activity){
        entity_list.add(new PTRoutEntity(Uri.parse(url), activity));
    }

    public static PTRoutEntity getRoutEntity(Uri uri){
        for (PTRoutEntity entity: entity_list) {
            if(entity.getUri().equals(uri)){
                return entity;
            }
        }
        return null;
    }
}
