package com.hh.ptrouter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.hh.ptrouter.model.PTParamTypes;
import com.hh.ptrouter.model.PTRoutEntity;
import com.hh.ptrouter.util.PTUriParser;

import java.util.Map;

import static com.hh.ptrouter.model.PTParamTypes.STRING;
import static com.hh.ptrouter.model.PTParamTypes.INT;
import static com.hh.ptrouter.model.PTParamTypes.LONG;
import static com.hh.ptrouter.model.PTParamTypes.BOOL;
import static com.hh.ptrouter.model.PTParamTypes.SHORT;
import static com.hh.ptrouter.model.PTParamTypes.FLOAT;
import static com.hh.ptrouter.model.PTParamTypes.DOUBLE;
import static com.hh.ptrouter.model.PTParamTypes.BYTE;
import static com.hh.ptrouter.model.PTParamTypes.CHAR;

/**
 * Created by chrisw on 2018/3/27.
 */

public class PTRouter {
    private static final String TAG = PTRouter.class.getSimpleName();
    private Uri mUri;
    private PTRouter(Uri uri){
        mUri = uri;
    }

    public static PTRouter create(String url){
        return new PTRouter(Uri.parse(url));
    }

    public boolean open(Context context){
        PTRoutEntity entity = PTRouterCache.getRoutEntity(Uri.parse(PTUriParser.getRouter(mUri)));
        if(entity == null){
            Log.e(TAG, "can't find the rout entity");
            return false;
        }
        Class<? extends Activity> activityCls = entity.getActivity();
        Map<String, String> params = PTUriParser.getParams(mUri);

        Intent intent = new Intent();
        intent.setClass(context, activityCls);

        if(params.size() > 0){
            for (Map.Entry<String, String> entry: params.entrySet()){
                Bundle bundle = new Bundle();
                int type = PTParamTypes.getParamType(entry.getKey());
                switch (type){
                    case STRING:
                        bundle.putString(entry.getKey(), entry.getValue());
                        break;
                    case INT:
                        bundle.putInt(entry.getKey(), Integer.parseInt(entry.getValue()));
                        break;
                    case LONG:
                        bundle.putLong(entry.getKey(), Long.parseLong(entry.getValue()));
                        break;
                    case BOOL:
                        bundle.putBoolean(entry.getKey(), Boolean.parseBoolean(entry.getValue()));
                        break;
                    case SHORT:
                        bundle.putShort(entry.getKey(), Short.parseShort(entry.getValue()));
                        break;
                    case FLOAT:
                        bundle.putFloat(entry.getKey(), Float.parseFloat(entry.getValue()));
                        break;
                    case DOUBLE:
                        bundle.putDouble(entry.getKey(), Double.parseDouble(entry.getValue()));
                        break;
                    case BYTE:
                        bundle.putByte(entry.getKey(), Byte.parseByte(entry.getValue()));
                        break;
                    case CHAR:
                        bundle.putChar(entry.getKey(), entry.getValue().charAt(0));
                        break;
                }

                intent.putExtras(bundle);
            }
        }

        context.startActivity(intent);

        return true;
    }
}
