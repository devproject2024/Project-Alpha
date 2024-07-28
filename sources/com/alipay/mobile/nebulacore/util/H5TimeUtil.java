package com.alipay.mobile.nebulacore.util;

import com.alipay.mobile.nebula.util.H5Log;

public class H5TimeUtil {
    public static final String CREATE_PAGE = "create_page";
    public static final String CREATE_WEBVIEW = "create_webView";
    public static final String INIT_PLUGIN = "init_plugin";
    public static final String PARSER_APP = "parser_app";
    public static final String PREPARE_APP = "prepare_app";
    public static final String START_APP = "start_app";
    public static final String TAG = "H5TimeLog";

    public static void timeLog(String str, long j) {
        H5Log.d(TAG, str + "|" + (System.currentTimeMillis() - j));
    }

    public static void timeLog(String str, String str2, long j) {
        H5Log.d(TAG, str + "|" + str2 + "|" + (System.currentTimeMillis() - j));
    }
}
