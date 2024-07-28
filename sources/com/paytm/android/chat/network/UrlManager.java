package com.paytm.android.chat.network;

import com.paytm.utility.q;

public class UrlManager {
    private static String SERVER_ADDRESS = "https://digitalproxy.paytm.com/pcchat";

    public static void setServerAddr(String str) {
        SERVER_ADDRESS = str;
    }

    public static String getUrl(String str) {
        String str2 = SERVER_ADDRESS + str;
        q.b("getUrl:".concat(String.valueOf(str2)));
        return str2;
    }
}
