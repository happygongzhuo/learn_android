package com.miracle.learn_android.util;

import android.content.Context;
import android.content.Intent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gongzhuo on 15/12/15.
 */
public class Tool {
    public static String getPkgName(Context contxt) {
        try {
            String pkName = contxt.getPackageName();
            return pkName;
        } catch (Exception e) {

        }
        return null;
    }

    public static String getVersionName(Context contxt) {
        try {
            String pkName = contxt.getPackageName();
            String versionName = contxt.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
            return versionName;
        } catch (Exception e) {
        }
        return null;
    }

    public static  Intent activityIntent(String pkg, String componentName) {
        Intent result = new Intent();
        result.setClassName(pkg, componentName);
        return result;
    }

    public static  void addItem(List<Map> data, String name, Intent intent) {
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("title", name);
        temp.put("intent", intent);
        data.add(temp);
    }

    public static boolean isEmptyString(String str) {
        if(str == null || str.length() ==0 || str.equals("")) {
            return true;
        }

        return false;
    }
}
