package com.alipay.mobile.nebulacore.android;

import android.webkit.HttpAuthHandler;
import com.alipay.mobile.nebula.webview.APHttpAuthHandler;

class AndroidHttpAuthHandler implements APHttpAuthHandler {
    HttpAuthHandler httpAuthHandler;

    AndroidHttpAuthHandler(HttpAuthHandler httpAuthHandler2) {
        this.httpAuthHandler = httpAuthHandler2;
    }

    public void cancel() {
        HttpAuthHandler httpAuthHandler2 = this.httpAuthHandler;
        if (httpAuthHandler2 != null) {
            httpAuthHandler2.cancel();
        }
    }

    public void proceed(String str, String str2) {
        HttpAuthHandler httpAuthHandler2 = this.httpAuthHandler;
        if (httpAuthHandler2 != null) {
            httpAuthHandler2.proceed(str, str2);
        }
    }

    public boolean useHttpAuthUsernamePassword() {
        HttpAuthHandler httpAuthHandler2 = this.httpAuthHandler;
        return httpAuthHandler2 != null && httpAuthHandler2.useHttpAuthUsernamePassword();
    }
}
