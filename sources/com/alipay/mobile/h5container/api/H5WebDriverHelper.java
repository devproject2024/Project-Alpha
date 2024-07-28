package com.alipay.mobile.h5container.api;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.ConsoleMessage;
import com.alipay.mobile.nebula.webview.APSslErrorHandler;
import com.alipay.mobile.nebula.webview.APWebView;

public interface H5WebDriverHelper {
    public static final H5WebDriverHelper defaultHelper = new H5WebDriverHelper() {
        public final void doUpdateVisitedHistory(APWebView aPWebView, String str, boolean z) {
        }

        public final void onConsoleMessage(ConsoleMessage consoleMessage) {
        }

        public final void onPageFinished(APWebView aPWebView, String str) {
        }

        public final void onPageStarted(APWebView aPWebView, String str, Bitmap bitmap) {
        }

        public final void onReceivedError(APWebView aPWebView, int i2, String str, String str2) {
        }

        public final void onReceivedSslError(APWebView aPWebView, APSslErrorHandler aPSslErrorHandler, SslError sslError) {
        }

        public final void onWebViewCreated(APWebView aPWebView) {
        }

        public final void onWebViewDestroyed(APWebView aPWebView) {
        }

        public final void shouldOverrideUrlLoading(APWebView aPWebView, String str) {
        }
    };

    void doUpdateVisitedHistory(APWebView aPWebView, String str, boolean z);

    void onConsoleMessage(ConsoleMessage consoleMessage);

    void onPageFinished(APWebView aPWebView, String str);

    void onPageStarted(APWebView aPWebView, String str, Bitmap bitmap);

    void onReceivedError(APWebView aPWebView, int i2, String str, String str2);

    void onReceivedSslError(APWebView aPWebView, APSslErrorHandler aPSslErrorHandler, SslError sslError);

    void onWebViewCreated(APWebView aPWebView);

    void onWebViewDestroyed(APWebView aPWebView);

    void shouldOverrideUrlLoading(APWebView aPWebView, String str);
}
