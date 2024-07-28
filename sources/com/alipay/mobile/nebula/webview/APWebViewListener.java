package com.alipay.mobile.nebula.webview;

import android.graphics.Bitmap;
import android.view.View;
import java.util.Map;

public interface APWebViewListener {
    View getEmbedView(int i2, int i3, String str, String str2, Map<String, String> map);

    Bitmap getSnapshot(int i2, int i3, String str, String str2, Map<String, String> map);

    void onDetachedFromWindow();

    void onEmbedViewAttachedToWebView(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewDestory(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewDetachedFromWebView(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewParamChanged(int i2, int i3, String str, String str2, Map<String, String> map, String[] strArr, String[] strArr2);

    void onEmbedViewVisibilityChanged(int i2, int i3, String str, String str2, Map<String, String> map, int i4);

    boolean overScrollBy(int i2, int i3, int i4, int i5);
}
