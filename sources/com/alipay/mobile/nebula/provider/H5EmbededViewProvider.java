package com.alipay.mobile.nebula.provider;

import android.graphics.Bitmap;
import android.view.View;
import com.alipay.mobile.nebula.view.IH5EmbedView;
import java.util.Map;

public interface H5EmbededViewProvider {
    View getEmbedView(int i2, int i3, String str, String str2, Map<String, String> map);

    IH5EmbedView getEmbedViewWrapperById(String str);

    Bitmap getSnapshot(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewAttachedToWebView(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewDestory(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewDetachedFromWebView(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewParamChanged(int i2, int i3, String str, String str2, Map<String, String> map, String[] strArr, String[] strArr2);

    void onEmbedViewVisibilityChanged(int i2, int i3, String str, String str2, Map<String, String> map, int i4);

    void onWebViewDestory();

    void onWebViewPause();

    void onWebViewResume();

    void releaseView();

    void triggerPreSnapshot();
}
