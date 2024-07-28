package com.alipay.mobile.nebula.provider;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.alipay.mobile.nebula.webview.APWebView;

public interface H5FileChooserProvider {
    boolean onShowFileChooser(APWebView aPWebView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

    void openFileChooser(APWebView aPWebView, ValueCallback<Uri> valueCallback);

    void openFileChooser(APWebView aPWebView, ValueCallback<Uri> valueCallback, String str);

    void openFileChooser(APWebView aPWebView, ValueCallback<Uri> valueCallback, String str, String str2);
}
