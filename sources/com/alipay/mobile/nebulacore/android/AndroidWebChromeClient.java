package com.alipay.mobile.nebulacore.android;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.alipay.mobile.nebula.provider.H5FileChooserProvider;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APJsPromptResult;
import com.alipay.mobile.nebula.webview.APJsResult;
import com.alipay.mobile.nebula.webview.APWebChromeClient;
import com.alipay.mobile.nebula.webview.APWebView;

class AndroidWebChromeClient extends WebChromeClient {
    private APWebView mAPView;
    private APWebChromeClient mClient;

    AndroidWebChromeClient(APWebView aPWebView, APWebChromeClient aPWebChromeClient) {
        this.mAPView = aPWebView;
        this.mClient = aPWebChromeClient;
    }

    public void onProgressChanged(WebView webView, int i2) {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onProgressChanged(this.mAPView, i2);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onReceivedTitle(this.mAPView, str);
        }
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onReceivedIcon(this.mAPView, bitmap);
        }
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onReceivedTouchIconUrl(this.mAPView, str, z);
        }
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onShowCustomView(view, (APWebChromeClient.CustomViewCallback) DynamicProxy.dynamicProxy(APWebChromeClient.CustomViewCallback.class, customViewCallback));
        }
    }

    public void onHideCustomView() {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onHideCustomView();
        }
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.mClient.onCreateWindow(this.mAPView, z, z2, message);
    }

    public void onRequestFocus(WebView webView) {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onRequestFocus(this.mAPView);
        }
    }

    public void onCloseWindow(WebView webView) {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onCloseWindow(this.mAPView);
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mClient.onJsAlert(this.mAPView, str, str2, (APJsResult) DynamicProxy.dynamicProxy(APJsResult.class, jsResult));
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mClient.onJsConfirm(this.mAPView, str, str2, (APJsResult) DynamicProxy.dynamicProxy(APJsResult.class, jsResult));
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.mClient.onJsPrompt(this.mAPView, str, str2, str3, (APJsPromptResult) DynamicProxy.dynamicProxy(APJsPromptResult.class, jsPromptResult));
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mClient.onJsBeforeUnload(this.mAPView, str, str2, (APJsResult) DynamicProxy.dynamicProxy(APJsResult.class, jsResult));
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onGeolocationPermissionsShowPrompt(str, (GeolocationPermissions.Callback) DynamicProxy.dynamicProxy(GeolocationPermissions.Callback.class, callback));
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onGeolocationPermissionsHidePrompt();
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        APWebChromeClient aPWebChromeClient = this.mClient;
        return aPWebChromeClient != null && aPWebChromeClient.onConsoleMessage(new ConsoleMessage(consoleMessage.message(), consoleMessage.sourceId(), consoleMessage.lineNumber(), ConsoleMessage.MessageLevel.valueOf(consoleMessage.messageLevel().name())));
    }

    public Bitmap getDefaultVideoPoster() {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            return aPWebChromeClient.getDefaultVideoPoster();
        }
        return null;
    }

    public View getVideoLoadingProgressView() {
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            return aPWebChromeClient.getVideoLoadingProgressView();
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.webkit.ValueCallback<java.lang.String[]>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getVisitedHistory(android.webkit.ValueCallback<java.lang.String[]> r3) {
        /*
            r2 = this;
            com.alipay.mobile.nebula.webview.APWebChromeClient r0 = r2.mClient
            java.lang.Class<android.webkit.ValueCallback> r1 = android.webkit.ValueCallback.class
            java.lang.Object r3 = com.alipay.mobile.nebulacore.android.DynamicProxy.dynamicProxy(r1, r3)
            android.webkit.ValueCallback r3 = (android.webkit.ValueCallback) r3
            r0.getVisitedHistory(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.android.AndroidWebChromeClient.getVisitedHistory(android.webkit.ValueCallback):void");
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        H5FileChooserProvider h5FileChooserProvider = (H5FileChooserProvider) H5Utils.getProvider(H5FileChooserProvider.class.getName());
        if (h5FileChooserProvider != null) {
            h5FileChooserProvider.openFileChooser(this.mAPView, valueCallback);
            return;
        }
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.openFileChooser(valueCallback, false);
        }
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        H5FileChooserProvider h5FileChooserProvider = (H5FileChooserProvider) H5Utils.getProvider(H5FileChooserProvider.class.getName());
        if (h5FileChooserProvider != null) {
            h5FileChooserProvider.openFileChooser(this.mAPView, valueCallback, str);
            return;
        }
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.openFileChooser(valueCallback, false);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        H5FileChooserProvider h5FileChooserProvider = (H5FileChooserProvider) H5Utils.getProvider(H5FileChooserProvider.class.getName());
        if (h5FileChooserProvider != null) {
            h5FileChooserProvider.openFileChooser(this.mAPView, valueCallback, str, str2);
            return;
        }
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.openFileChooser(valueCallback, false);
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        H5FileChooserProvider h5FileChooserProvider = (H5FileChooserProvider) H5Utils.getProvider(H5FileChooserProvider.class.getName());
        if (h5FileChooserProvider != null) {
            return h5FileChooserProvider.onShowFileChooser(this.mAPView, valueCallback, fileChooserParams);
        }
        APWebChromeClient aPWebChromeClient = this.mClient;
        if (aPWebChromeClient == null) {
            return false;
        }
        aPWebChromeClient.openFileChooser(valueCallback, true);
        return true;
    }
}
