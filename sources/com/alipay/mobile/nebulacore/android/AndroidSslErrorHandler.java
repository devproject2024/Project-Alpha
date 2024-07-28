package com.alipay.mobile.nebulacore.android;

import android.webkit.SslErrorHandler;
import com.alipay.mobile.nebula.webview.APSslErrorHandler;

class AndroidSslErrorHandler implements APSslErrorHandler {
    private SslErrorHandler mSslErrorHandler;

    AndroidSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.mSslErrorHandler = sslErrorHandler;
    }

    public void cancel() {
        this.mSslErrorHandler.cancel();
    }

    public void proceed() {
        this.mSslErrorHandler.proceed();
    }
}
