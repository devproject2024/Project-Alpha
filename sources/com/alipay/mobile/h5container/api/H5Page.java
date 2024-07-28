package com.alipay.mobile.h5container.api;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.alipay.mobile.nebula.provider.H5EmbededViewProvider;
import com.alipay.mobile.nebula.view.H5LoadingView;
import com.alipay.mobile.nebula.view.H5TitleView;
import com.alipay.mobile.nebula.view.IH5EmbedViewJSCallback;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebula.webview.APWebViewClient;

public interface H5Page extends H5CoreNode {

    public interface H5ErrorHandler {
        boolean shouldInterceptError(String str, int i2);
    }

    public interface H5PageHandler {
        boolean shouldExit();
    }

    public interface H5TitleBarReadyCallback {
        void onCreate();
    }

    void execJavaScript4EmbedView(String str, IH5EmbedViewJSCallback iH5EmbedViewJSCallback);

    boolean exitPage();

    boolean exitTabPage();

    APWebViewClient getAPWebViewClient();

    H5AvailablePageData getAvailablePageData();

    H5Bridge getBridge();

    View getContentView();

    H5Context getContext();

    H5EmbededViewProvider getEmbededViewProvider();

    H5LoadingView getH5LoadingView();

    H5TitleView getH5TitleBar();

    long getLastTouch();

    H5PageData getPageData();

    int getPageId();

    Bundle getParams();

    String getPerformance();

    String getRedirectUrl();

    View getRootView();

    H5Session getSession();

    String getShareUrl();

    String getTitle();

    H5TitleBarReadyCallback getTitleBarReadyCallBack();

    String getUrl();

    String getVersion();

    ViewGroup getViewGroup();

    APWebView getWebView();

    int getWebViewId();

    boolean ifContainsEmbedView();

    boolean isTransparentTitleState();

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    boolean onInterceptError(String str, int i2);

    boolean pageIsClose();

    void replace(String str);

    boolean scriptbizLoadedAndBridgeLoaded();

    void sendExitEvent();

    void setContainsEmbedView(boolean z);

    void setH5ErrorHandler(H5ErrorHandler h5ErrorHandler);

    void setH5TitleBar(H5TitleView h5TitleView);

    void setHandler(H5PageHandler h5PageHandler);

    void setPageId(int i2);

    void setPerformance(String str);

    void setRootView(View view);

    void setTextSize(int i2);

    void setTitle(String str);

    void setTitleBarReadyCallBack(H5TitleBarReadyCallback h5TitleBarReadyCallback);

    void setWebViewId(int i2);
}
