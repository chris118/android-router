package com.hh.ptrouter.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chrisw on 2018/3/30.
 */

public class PTParamTypes {
    public static final int UNDEFINE = -1;
    public static final int STRING = 0;
    public static final int INT = 1;
    public static final int LONG = 2;
    public static final int BOOL = 3;
    public static final int SHORT = 4;
    public static final int FLOAT = 5;
    public static final int DOUBLE = 6;
    public static final int BYTE = 7;
    public static final int CHAR = 8;

    //TODO 多组件参数冲突未处理
    private static Map<String, Integer> type_list = new HashMap<>();
    public static void putParamType(String key, String sType){
        int type = -1;
        switch (sType){
            case "STRING":
                type = STRING;
                break;
            case "INT":
                type = INT;
                break;
            case "LONG":
                type = LONG;
                break;
            case "BOOL":
                type = BOOL;
                break;
            case "SHORT":
                type = SHORT;
                break;
            case "FLOAT":
                type = FLOAT;
                break;
            case "BYTE":
                type = BYTE;
                break;
            case "CHAR":
                type = CHAR;
                break;
        }
        type_list.put(key, type);
    }

    public static int getParamType(String key) {
        if(type_list.containsKey(key)){
            for (Map.Entry<String, Integer> entry: type_list.entrySet()) {
                if(entry.getKey().equals(key)){
                    return entry.getValue();
                }
            }
        }
        return UNDEFINE;
    }
}
