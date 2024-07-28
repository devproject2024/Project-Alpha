package com.alipay.mobile.nebula.appcenter.downloadImpl;

import android.text.TextUtils;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5DownLoadCallBackList {
    public static Map<String, List<H5DownloadCallback>> callbackData = new ConcurrentHashMap();

    public static void unRegisterCallbacks(String str) {
        if (!TextUtils.isEmpty(str)) {
            callbackData.remove(str);
        }
    }

    public static void registerCallback(String str, H5DownloadCallback h5DownloadCallback) {
        List list;
        if (str != null && h5DownloadCallback != null) {
            if (!callbackData.containsKey(str)) {
                list = new ArrayList();
            } else if (callbackData.get(str) == null) {
                list = new ArrayList();
            } else {
                list = callbackData.get(str);
            }
            callbackData.put(str, list);
            if (!list.contains(h5DownloadCallback)) {
                list.add(h5DownloadCallback);
            }
        }
    }

    public static boolean isDownloadTaskExists(String str) {
        List list;
        if (str == null || (list = callbackData.get(str)) == null || list.size() <= 0) {
            return false;
        }
        return true;
    }
}
