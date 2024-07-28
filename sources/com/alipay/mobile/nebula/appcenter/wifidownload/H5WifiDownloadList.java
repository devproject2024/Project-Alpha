package com.alipay.mobile.nebula.appcenter.wifidownload;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5WifiDownloadList {
    private static Map<String, String> map;

    public static synchronized void put(String str, String str2) {
        synchronized (H5WifiDownloadList.class) {
            if (map == null) {
                map = new ConcurrentHashMap();
            }
            map.put(str, str2);
        }
    }

    public static void remove(String str) {
        Map<String, String> map2 = map;
        if (map2 != null) {
            map2.remove(str);
        }
    }

    public static Map<String, String> getWifiDownloadMap() {
        return map;
    }
}
