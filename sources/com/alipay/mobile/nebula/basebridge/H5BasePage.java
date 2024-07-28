package com.alipay.mobile.nebula.basebridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.h5container.api.H5AvailablePageData;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5EmbededViewProvider;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5LoadingView;
import com.alipay.mobile.nebula.view.H5TitleView;
import com.alipay.mobile.nebula.view.IH5EmbedViewJSCallback;
import com.alipay.mobile.nebula.webview.APDownloadListener;
import com.alipay.mobile.nebula.webview.APHitTestResult;
import com.alipay.mobile.nebula.webview.APWebBackForwardList;
import com.alipay.mobile.nebula.webview.APWebChromeClient;
import com.alipay.mobile.nebula.webview.APWebSettings;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebula.webview.APWebViewClient;
import com.alipay.mobile.nebula.webview.APWebViewListener;
import com.alipay.mobile.nebula.webview.H5ScrollChangedCallback;
import com.alipay.mobile.nebula.webview.WebViewType;
import h.a.a;
import java.lang.ref.WeakReference;
import java.util.Map;

public class H5BasePage extends H5BaseNebulaService implements H5Page, APWebView {
    private H5Bridge bridge;
    private H5Context mH5Context;
    private final H5PageData mPageData;
    private final Bundle mStartParams;
    private final InternalWebSettings mWebSettings;

    public void addJavascriptInterface(Object obj, String str) {
    }

    public boolean canGoBack() {
        return false;
    }

    public boolean canGoBackOrForward(int i2) {
        return false;
    }

    public boolean canGoForward() {
        return false;
    }

    public Picture capturePicture() {
        return null;
    }

    public void clearCache(boolean z) {
    }

    public void clearFormData() {
    }

    public void clearHistory() {
    }

    public void clearSslPreferences() {
    }

    public APWebBackForwardList copyBackForwardList() {
        return null;
    }

    public void destroy() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
    }

    public void execJavaScript4EmbedView(String str, IH5EmbedViewJSCallback iH5EmbedViewJSCallback) {
    }

    public boolean exitTabPage() {
        return false;
    }

    public void flingScroll(int i2, int i3) {
    }

    public void freeMemory() {
    }

    public APWebViewClient getAPWebViewClient() {
        return null;
    }

    public H5AvailablePageData getAvailablePageData() {
        return null;
    }

    public SslCertificate getCertificate() {
        return null;
    }

    public int getContentHeight() {
        return 0;
    }

    public View getContentView() {
        return null;
    }

    public int getContentWidth() {
        return 0;
    }

    public boolean getCurrentPageSnapshot(Rect rect, Rect rect2, Bitmap bitmap, boolean z, int i2) {
        return false;
    }

    public H5EmbededViewProvider getEmbededViewProvider() {
        return null;
    }

    public Bitmap getFavicon() {
        return null;
    }

    public H5LoadingView getH5LoadingView() {
        return null;
    }

    public H5Plugin getH5NumInputKeyboard() {
        return null;
    }

    public H5TitleView getH5TitleBar() {
        return null;
    }

    public APHitTestResult getHitTestResult() {
        return null;
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return new String[0];
    }

    public long getLastTouch() {
        return 0;
    }

    public String getOriginalUrl() {
        return null;
    }

    public int getPageId() {
        return 0;
    }

    public String getPerformance() {
        return null;
    }

    public int getProgress() {
        return 0;
    }

    public String getRedirectUrl() {
        return null;
    }

    public View getRootView() {
        return null;
    }

    public float getScale() {
        return 0.0f;
    }

    public int getScrollY() {
        return 0;
    }

    public H5Session getSession() {
        return null;
    }

    public String getShareUrl() {
        return null;
    }

    public String getTitle() {
        return null;
    }

    public H5Page.H5TitleBarReadyCallback getTitleBarReadyCallBack() {
        return null;
    }

    public String getVersion() {
        return null;
    }

    public View getView() {
        return null;
    }

    public ViewGroup getViewGroup() {
        return null;
    }

    public APWebView getWebView() {
        return this;
    }

    public int getWebViewId() {
        return 0;
    }

    public void goBack() {
    }

    public void goBackOrForward(int i2) {
    }

    public void goForward() {
    }

    public boolean ifContainsEmbedView() {
        return false;
    }

    public void invokeZoomPicker() {
    }

    public boolean isPaused() {
        return false;
    }

    public boolean isTransparentTitleState() {
        return false;
    }

    public void loadData(String str, String str2, String str3) {
    }

    public void loadUrl(String str, Map<String, String> map) {
    }

    public boolean onInterceptError(String str, int i2) {
        return false;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public boolean overlayHorizontalScrollbar() {
        return false;
    }

    public boolean overlayVerticalScrollbar() {
        return false;
    }

    public boolean pageDown(boolean z) {
        return false;
    }

    public boolean pageIsClose() {
        return false;
    }

    public boolean pageUp(boolean z) {
        return false;
    }

    public void postUrl(String str, byte[] bArr) {
    }

    public void reload() {
    }

    public void removeJavascriptInterface(String str) {
    }

    public void replace(String str) {
    }

    public APWebBackForwardList restoreState(Bundle bundle) {
        return null;
    }

    public void savePassword(String str, String str2, String str3) {
    }

    public APWebBackForwardList saveState(Bundle bundle) {
        return null;
    }

    public boolean scriptbizLoadedAndBridgeLoaded() {
        return false;
    }

    public void sendExitEvent() {
    }

    public void setAPWebViewListener(APWebViewListener aPWebViewListener) {
    }

    public void setContainsEmbedView(boolean z) {
    }

    public void setDownloadListener(APDownloadListener aPDownloadListener) {
    }

    public void setH5ErrorHandler(H5Page.H5ErrorHandler h5ErrorHandler) {
    }

    public void setH5TitleBar(H5TitleView h5TitleView) {
    }

    public void setHandler(H5Page.H5PageHandler h5PageHandler) {
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
    }

    public void setInitialScale(int i2) {
    }

    public void setNetworkAvailable(boolean z) {
    }

    public void setOnScrollChangedCallback(H5ScrollChangedCallback h5ScrollChangedCallback) {
    }

    public void setPageId(int i2) {
    }

    public void setPerformance(String str) {
    }

    public void setRootView(View view) {
    }

    public void setScale(float f2) {
    }

    public void setTextSize(int i2) {
    }

    public void setTitle(String str) {
    }

    public void setTitleBarReadyCallBack(H5Page.H5TitleBarReadyCallback h5TitleBarReadyCallback) {
    }

    public void setVerticalScrollBarEnabled(boolean z) {
    }

    public void setVerticalScrollbarOverlay(boolean z) {
    }

    public void setWebChromeClient(APWebChromeClient aPWebChromeClient) {
    }

    public void setWebContentsDebuggingEnabled(boolean z) {
    }

    public void setWebViewClient(APWebViewClient aPWebViewClient) {
    }

    public void setWebViewId(int i2) {
    }

    public void stopLoading() {
    }

    public boolean zoomIn() {
        return false;
    }

    public boolean zoomOut() {
        return false;
    }

    public void setH5Context(Context context) {
        if (enableUseOldContext()) {
            this.mH5Context = new H5Context(context);
        }
    }

    private boolean enableUseOldContext() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider != null && H5AppHandler.CHECK_VALUE.equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_enableUseOldContext"));
    }

    public H5BasePage(Context context, H5Bridge h5Bridge, Bundle bundle) {
        if (enableUseOldContext()) {
            this.mH5Context = new H5Context(context);
        }
        this.mStartParams = bundle;
        this.bridge = h5Bridge;
        b.a();
        H5Service h5Service = (H5Service) c.a(H5Service.class.getName());
        setParent(h5Service.getItsOwnNode());
        getPluginManager().register(h5Service.createPlugin(H5Param.PAGE, getPluginManager()));
        this.mPageData = new H5PageData();
        this.mPageData.setAppId(bundle.getString("appId", (String) null));
        this.mPageData.setWebViewType("tiny");
        this.mPageData.setPageUrl(bundle.getString("url", (String) null));
        this.mWebSettings = new InternalWebSettings();
        this.mWebSettings.setUserAgentString("");
    }

    public H5Context getContext() {
        if (enableUseOldContext()) {
            return this.mH5Context;
        }
        b.a();
        WeakReference weakReference = null;
        Context context = (Context) weakReference.get();
        if (context == null) {
            context = H5Utils.getContext();
        }
        return new H5Context(context);
    }

    public void loadUrl(String str) {
        a.assertTrue(false);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        a.assertTrue(false);
    }

    public String getUrl() {
        return this.mPageData.getPageUrl();
    }

    public APWebSettings getSettings() {
        return this.mWebSettings;
    }

    public H5Bridge getBridge() {
        return this.bridge;
    }

    public Bundle getParams() {
        return this.mStartParams;
    }

    public boolean exitPage() {
        if (getParent() == null) {
            return true;
        }
        getParent().removeChild(this);
        setParent((H5CoreNode) null);
        return true;
    }

    public H5PageData getPageData() {
        return this.mPageData;
    }

    public WebViewType getType() {
        return WebViewType.RN_VIEW;
    }

    class InternalWebSettings implements APWebSettings {
        private String mUaString;

        public boolean getAllowContentAccess() {
            return false;
        }

        public boolean getAllowFileAccess() {
            return false;
        }

        public boolean getAllowFileAccessFromFileURLs() {
            return false;
        }

        public boolean getAllowUniversalAccessFromFileURLs() {
            return false;
        }

        public boolean getBlockNetworkImage() {
            return false;
        }

        public boolean getBuiltInZoomControls() {
            return false;
        }

        public int getCacheMode() {
            return 0;
        }

        public String getCursiveFontFamily() {
            return null;
        }

        public boolean getDatabaseEnabled() {
            return false;
        }

        public String getDatabasePath() {
            return null;
        }

        public int getDefaultFixedFontSize() {
            return 0;
        }

        public int getDefaultFontSize() {
            return 0;
        }

        public String getDefaultTextEncodingName() {
            return null;
        }

        public String getDefaultUserAgent(Context context) {
            return null;
        }

        public APWebSettings.ZoomDensity getDefaultZoom() {
            return null;
        }

        public boolean getDisplayZoomControls() {
            return false;
        }

        public boolean getDomStorageEnabled() {
            return false;
        }

        public String getFantasyFontFamily() {
            return null;
        }

        public String getFixedFontFamily() {
            return null;
        }

        public boolean getJavaScriptCanOpenWindowsAutomatically() {
            return false;
        }

        public boolean getJavaScriptEnabled() {
            return false;
        }

        public APWebSettings.LayoutAlgorithm getLayoutAlgorithm() {
            return null;
        }

        public boolean getLoadWithOverviewMode() {
            return false;
        }

        public boolean getLoadsImagesAutomatically() {
            return false;
        }

        public boolean getMediaPlaybackRequiresUserGesture() {
            return false;
        }

        public int getMinimumFontSize() {
            return 0;
        }

        public int getMinimumLogicalFontSize() {
            return 0;
        }

        public APWebSettings.PluginState getPluginState() {
            return null;
        }

        public String getSansSerifFontFamily() {
            return null;
        }

        public boolean getSaveFormData() {
            return false;
        }

        public boolean getSavePassword() {
            return false;
        }

        public String getSerifFontFamily() {
            return null;
        }

        public String getStandardFontFamily() {
            return null;
        }

        public APWebSettings.TextSize getTextSize() {
            return null;
        }

        public int getTextZoom() {
            return 0;
        }

        public boolean getUseWideViewPort() {
            return false;
        }

        public void setAllowContentAccess(boolean z) {
        }

        public void setAllowFileAccess(boolean z) {
        }

        public void setAllowFileAccessFromFileURLs(boolean z) {
        }

        public void setAllowUniversalAccessFromFileURLs(boolean z) {
        }

        public void setAppCacheEnabled(boolean z) {
        }

        public void setAppCachePath(String str) {
        }

        public void setBlockNetworkImage(boolean z) {
        }

        public void setBuiltInZoomControls(boolean z) {
        }

        public void setCacheMode(int i2) {
        }

        public void setCursiveFontFamily(String str) {
        }

        public void setDatabaseEnabled(boolean z) {
        }

        public void setDatabasePath(String str) {
        }

        public void setDefaultFixedFontSize(int i2) {
        }

        public void setDefaultFontSize(int i2) {
        }

        public void setDefaultTextEncodingName(String str) {
        }

        public void setDisplayZoomControls(boolean z) {
        }

        public void setDomStorageEnabled(boolean z) {
        }

        public void setEnableFastScroller(boolean z) {
        }

        public void setFantasyFontFamily(String str) {
        }

        public void setFixedFontFamily(String str) {
        }

        public void setGeolocationDatabasePath(String str) {
        }

        public void setGeolocationEnabled(boolean z) {
        }

        public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        }

        public void setJavaScriptEnabled(boolean z) {
        }

        public void setLayoutAlgorithm(APWebSettings.LayoutAlgorithm layoutAlgorithm) {
        }

        public void setLoadWithOverviewMode(boolean z) {
        }

        public void setLoadsImagesAutomatically(boolean z) {
        }

        public void setMediaPlaybackRequiresUserGesture(boolean z) {
        }

        public void setMinimumFontSize(int i2) {
        }

        public void setMinimumLogicalFontSize(int i2) {
        }

        public void setNeedInitialFocus(boolean z) {
        }

        public void setPageCacheCapacity(int i2) {
        }

        public void setPluginState(APWebSettings.PluginState pluginState) {
        }

        public void setSansSerifFontFamily(String str) {
        }

        public void setSaveFormData(boolean z) {
        }

        public void setSavePassword(boolean z) {
        }

        public void setSerifFontFamily(String str) {
        }

        public void setStandardFontFamily(String str) {
        }

        public void setSupportMultipleWindows(boolean z) {
        }

        public void setSupportZoom(boolean z) {
        }

        public void setTextSize(APWebSettings.TextSize textSize) {
        }

        public void setTextZoom(int i2) {
        }

        public void setUseWideViewPort(boolean z) {
        }

        public boolean supportMultipleWindows() {
            return false;
        }

        public boolean supportZoom() {
            return false;
        }

        private InternalWebSettings() {
        }

        public String getUserAgentString() {
            return this.mUaString;
        }

        public void setUserAgentString(String str) {
            this.mUaString = str;
        }
    }
}
