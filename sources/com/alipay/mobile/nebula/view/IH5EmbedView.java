package com.alipay.mobile.nebula.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import java.util.Map;

public interface IH5EmbedView {
    void execJavaScript(String str, IH5EmbedViewJSCallback iH5EmbedViewJSCallback);

    void getComponentResourceDataWithUrl(String str, H5ContentProvider.ResponseListen responseListen, H5Page h5Page);

    Bitmap getSnapshot(int i2, int i3, String str, String str2, Map<String, String> map);

    View getSpecialRestoreView(int i2, int i3, String str, String str2, Map<String, String> map);

    View getView(int i2, int i3, String str, String str2, Map<String, String> map);

    void onCreate(Context context, H5Page h5Page);

    void onEmbedViewAttachedToWebView(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewDestory(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewDetachedFromWebView(int i2, int i3, String str, String str2, Map<String, String> map);

    void onEmbedViewParamChanged(int i2, int i3, String str, String str2, Map<String, String> map, String[] strArr, String[] strArr2);

    void onEmbedViewVisibilityChanged(int i2, int i3, String str, String str2, Map<String, String> map, int i4);

    void onReceivedMessage(String str, e eVar, H5BridgeContext h5BridgeContext);

    void onReceivedRender(e eVar, H5BridgeContext h5BridgeContext);

    void onWebViewDestory();

    void onWebViewPause();

    void onWebViewResume();

    void triggerPreSnapshot();
}
