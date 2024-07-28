package com.alipay.mobile.nebulacore.android;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.alipay.mobile.c.a;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5SplitCompatUtils;
import com.alipay.mobile.nebula.util.H5Utils;
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
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AndroidWebView implements APWebView {
    private static final String AUTO_FOCUS_DISABLE = "no";
    private static final String KEY_AUTO_FOCUS_SWITCH = "h5_webview_auto_focus";
    private static final String TAG = "AndroidWebView";
    /* access modifiers changed from: private */
    public static boolean sWaitPreCreating = false;
    private static Queue<AndroidWebView> sWebViewPool = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public APWebViewListener apWebViewListener;
    /* access modifiers changed from: private */
    public H5ScrollChangedCallback mAPScrollChangedCallbackl;
    private float mScale = 1.0f;
    private String systemChromeVersion;
    private APWebSettings webSettings;
    private WebView webView;

    public void execJavaScript4EmbedView(String str, IH5EmbedViewJSCallback iH5EmbedViewJSCallback) {
    }

    public boolean getCurrentPageSnapshot(Rect rect, Rect rect2, Bitmap bitmap, boolean z, int i2) {
        return false;
    }

    public H5Plugin getH5NumInputKeyboard() {
        return null;
    }

    public boolean isPaused() {
        return false;
    }

    static void preCreateOnMainWithDelay(int i2) {
        if (AndroidWebViewPreCreator.sWebViewPoolCapacity > 0 && sWebViewPool.size() < AndroidWebViewPreCreator.sWebViewPoolCapacity && !sWaitPreCreating) {
            sWaitPreCreating = true;
            H5Utils.runOnMain(new Runnable() {
                public final void run() {
                    try {
                        AndroidWebView.preCreate();
                    } catch (Throwable th) {
                        boolean unused = AndroidWebView.sWaitPreCreating = false;
                        H5Log.d(AndroidWebView.TAG, "WebView is pre-created");
                        throw th;
                    }
                    boolean unused2 = AndroidWebView.sWaitPreCreating = false;
                    H5Log.d(AndroidWebView.TAG, "WebView is pre-created");
                }
            }, (long) i2);
        }
    }

    private void setWebViewClient(AndroidWebViewClient androidWebViewClient) {
        WebView webView2;
        if (androidWebViewClient != null && (webView2 = this.webView) != null) {
            webView2.setWebViewClient(androidWebViewClient);
        }
    }

    public WebView getWebViewEx() {
        return this.webView;
    }

    /* access modifiers changed from: private */
    public static void preCreate() {
        AndroidWebView poll;
        AndroidWebView androidWebView = null;
        try {
            AndroidWebView androidWebView2 = new AndroidWebView(new MutableContextWrapper(H5Utils.getContext()));
            androidWebView2.setWebViewClient(new AndroidWebViewClient(androidWebView2, (APWebViewClient) null));
            androidWebView = androidWebView2;
        } catch (Throwable th) {
            H5Log.e(TAG, "pre-create webView exception.", th);
        }
        if (androidWebView != null) {
            sWebViewPool.add(androidWebView);
            if (!AndroidWebViewPreCreator.sUseWebViewFromPool && (poll = sWebViewPool.poll()) != null) {
                H5Utils.runOnMain(new Runnable(poll) {
                    final /* synthetic */ AndroidWebView val$view;

                    {
                        this.val$view = r1;
                    }

                    public final void run() {
                        try {
                            if (this.val$view != null) {
                                this.val$view.destroy();
                            }
                        } catch (Throwable th) {
                            H5Log.w(AndroidWebView.TAG, "destroy preload android webview error!", th);
                        }
                    }
                }, 5000);
            }
        }
    }

    public static int getWebViewPoolSize() {
        Queue<AndroidWebView> queue = sWebViewPool;
        if (queue == null) {
            return 0;
        }
        return queue.size();
    }

    public static AndroidWebView pollOnce() {
        Queue<AndroidWebView> queue = sWebViewPool;
        if (queue == null) {
            return null;
        }
        return queue.poll();
    }

    public AndroidWebView(Context context) {
        this.webView = new WebViewEx(context);
        this.webView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.webSettings = new AndroidWebSettings(this.webView.getSettings());
        CookieManager instance = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                instance.setAcceptThirdPartyCookies(this.webView, true);
            } catch (Throwable th) {
                H5Log.e(TAG, "setAcceptThirdPartyCookies", th);
            }
        }
        this.webSettings.setSavePassword(false);
    }

    public int getScrollY() {
        return this.webView.getScrollY();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.webView.dispatchKeyEvent(keyEvent);
    }

    public String getVersion() {
        if (TextUtils.isEmpty(this.systemChromeVersion)) {
            String str = "1.1";
            if (Build.VERSION.SDK_INT >= 19) {
                String userAgentString = this.webSettings.getUserAgentString();
                try {
                    Pattern compile = H5PatternHelper.compile("Chrome/\\d+\\.\\d+\\.\\d+\\.\\d+");
                    if (compile != null) {
                        Matcher matcher = compile.matcher(userAgentString);
                        if (matcher.find()) {
                            str = matcher.group(0);
                        }
                    }
                } catch (Throwable th) {
                    H5Log.e(TAG, "catch exception ", th);
                }
            }
            this.systemChromeVersion = str;
        }
        return this.systemChromeVersion;
    }

    public WebViewType getType() {
        return WebViewType.SYSTEM_BUILD_IN;
    }

    public Picture capturePicture() {
        return this.webView.capturePicture();
    }

    public void setAPWebViewListener(APWebViewListener aPWebViewListener) {
        this.apWebViewListener = aPWebViewListener;
    }

    public void addJavascriptInterface(Object obj, String str) {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.addJavascriptInterface(obj, str);
        }
    }

    public void removeJavascriptInterface(String str) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.webView.removeJavascriptInterface(str);
        }
    }

    public void setWebContentsDebuggingEnabled(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z);
        }
    }

    public void flingScroll(int i2, int i3) {
        this.webView.flingScroll(i2, i3);
    }

    public boolean zoomIn() {
        return this.webView.zoomIn();
    }

    public boolean zoomOut() {
        return this.webView.zoomOut();
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        this.webView.setHorizontalScrollbarOverlay(z);
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        this.webView.setVerticalScrollbarOverlay(z);
    }

    public boolean overlayHorizontalScrollbar() {
        return this.webView.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.webView.overlayVerticalScrollbar();
    }

    public SslCertificate getCertificate() {
        return this.webView.getCertificate();
    }

    public void savePassword(String str, String str2, String str3) {
        this.webView.savePassword(str, str2, str3);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.webView.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.webView.getHttpAuthUsernamePassword(str, str2);
    }

    public void destroy() {
        this.webView.destroy();
    }

    public void setNetworkAvailable(boolean z) {
        this.webView.setNetworkAvailable(z);
    }

    public APWebBackForwardList saveState(Bundle bundle) {
        WebBackForwardList saveState = this.webView.saveState(bundle);
        if (saveState != null) {
            return new AndroidWebBackForwardList(saveState);
        }
        return null;
    }

    public APWebBackForwardList restoreState(Bundle bundle) {
        WebBackForwardList restoreState = this.webView.restoreState(bundle);
        if (restoreState != null) {
            return new AndroidWebBackForwardList(restoreState);
        }
        return null;
    }

    public void loadUrl(String str, Map<String, String> map) {
        H5PageData.loadUrlStart = System.currentTimeMillis();
        this.webView.loadUrl(str, map);
    }

    public void loadUrl(String str) {
        H5PageData.loadUrlStart = System.currentTimeMillis();
        this.webView.loadUrl(str);
    }

    public void postUrl(String str, byte[] bArr) {
        this.webView.postUrl(str, bArr);
    }

    public void loadData(String str, String str2, String str3) {
        this.webView.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.webView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.webView.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            valueCallback.onReceiveValue("");
        }
    }

    public void stopLoading() {
        this.webView.stopLoading();
    }

    public void reload() {
        this.webView.reload();
    }

    public boolean canGoBack() {
        return this.webView.canGoBack();
    }

    public void goBack() {
        this.webView.goBack();
    }

    public boolean canGoForward() {
        return this.webView.canGoForward();
    }

    public void goForward() {
        this.webView.goForward();
    }

    public boolean canGoBackOrForward(int i2) {
        return this.webView.canGoBackOrForward(i2);
    }

    public void goBackOrForward(int i2) {
        this.webView.goBackOrForward(i2);
    }

    public boolean pageUp(boolean z) {
        return this.webView.pageUp(z);
    }

    public boolean pageDown(boolean z) {
        return this.webView.pageDown(z);
    }

    public void setInitialScale(int i2) {
        this.webView.setInitialScale(i2);
    }

    public void invokeZoomPicker() {
        this.webView.invokeZoomPicker();
    }

    public String getUrl() {
        return this.webView.getUrl();
    }

    public String getOriginalUrl() {
        return this.webView.getOriginalUrl();
    }

    public String getTitle() {
        return this.webView.getTitle();
    }

    public Bitmap getFavicon() {
        return this.webView.getFavicon();
    }

    public int getProgress() {
        return this.webView.getProgress();
    }

    public int getContentHeight() {
        return this.webView.getContentHeight();
    }

    public int getContentWidth() {
        H5Log.w(TAG, "getContentWidth() is currently not supported yet");
        return 0;
    }

    public void onPause() {
        if (Build.VERSION.SDK_INT >= 11) {
            this.webView.onPause();
        }
    }

    public void onResume() {
        if (Build.VERSION.SDK_INT >= 11) {
            this.webView.onResume();
        }
    }

    public void freeMemory() {
        this.webView.freeMemory();
    }

    public void clearCache(boolean z) {
        this.webView.clearCache(z);
    }

    public void clearFormData() {
        this.webView.clearFormData();
    }

    public void clearHistory() {
        this.webView.clearHistory();
    }

    public void clearSslPreferences() {
        this.webView.clearSslPreferences();
    }

    public APWebBackForwardList copyBackForwardList() {
        WebBackForwardList copyBackForwardList = this.webView.copyBackForwardList();
        if (copyBackForwardList != null) {
            return new AndroidWebBackForwardList(copyBackForwardList);
        }
        return null;
    }

    public void setWebViewClient(APWebViewClient aPWebViewClient) {
        this.webView.setWebViewClient(new AndroidWebViewClient(this, aPWebViewClient));
    }

    public void setDownloadListener(APDownloadListener aPDownloadListener) {
        this.webView.setDownloadListener(new AndroidDownloadListener(aPDownloadListener));
    }

    public void setWebChromeClient(APWebChromeClient aPWebChromeClient) {
        this.webView.setWebChromeClient(new AndroidWebChromeClient(this, aPWebChromeClient));
    }

    public APWebSettings getSettings() {
        return this.webSettings;
    }

    public APHitTestResult getHitTestResult() {
        WebView.HitTestResult hitTestResult = this.webView.getHitTestResult();
        if (hitTestResult == null) {
            return null;
        }
        return new AndroidHitTestResult(hitTestResult);
    }

    public View getView() {
        return this.webView;
    }

    public void setScale(float f2) {
        this.mScale = f2;
    }

    public float getScale() {
        return this.mScale;
    }

    public void setVerticalScrollBarEnabled(boolean z) {
        this.webView.setVerticalScrollBarEnabled(z);
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
        this.webView.setHorizontalScrollBarEnabled(z);
    }

    public void setOnScrollChangedCallback(H5ScrollChangedCallback h5ScrollChangedCallback) {
        this.mAPScrollChangedCallbackl = h5ScrollChangedCallback;
    }

    final class WebViewEx extends WebView {
        public WebViewEx(Context context) {
            super(context);
            setTag("H5WebView");
            H5SplitCompatUtils.doInstall(context);
            H5SplitCompatUtils.doInstall(a.f14949b);
            H5SplitCompatUtils.doInstall(a.f14950c);
        }

        /* access modifiers changed from: protected */
        public final boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
            if (i3 >= 0 || i5 != 0 || AndroidWebView.this.apWebViewListener == null) {
                return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
            }
            return AndroidWebView.this.apWebViewListener.overScrollBy(i2, i3, i4, i5);
        }

        /* access modifiers changed from: protected */
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (AndroidWebView.this.apWebViewListener != null) {
                AndroidWebView.this.apWebViewListener.onDetachedFromWindow();
            }
        }

        /* access modifiers changed from: protected */
        public final void onScrollChanged(int i2, int i3, int i4, int i5) {
            if (AndroidWebView.this.mAPScrollChangedCallbackl != null) {
                AndroidWebView.this.mAPScrollChangedCallbackl.onScroll(i2 - i4, i3 - i5);
            } else {
                super.onScrollChanged(i2, i3, i4, i5);
            }
        }

        public final boolean requestFocus(int i2, Rect rect) {
            H5Log.d(AndroidWebView.TAG, "requestFocus: ".concat(String.valueOf(i2)));
            return super.requestFocus(130, rect);
        }

        public final void dispatchWindowFocusChanged(boolean z) {
            H5Log.d(AndroidWebView.TAG, "dispatchWindowFocusChanged: ".concat(String.valueOf(z)));
            H5Log.d(AndroidWebView.TAG, "has focus: " + hasFocus());
            if (!AndroidWebView.AUTO_FOCUS_DISABLE.equalsIgnoreCase(H5Environment.getConfig(AndroidWebView.KEY_AUTO_FOCUS_SWITCH)) && Build.VERSION.SDK_INT >= 28 && z && !hasFocus()) {
                requestFocus();
            }
            super.dispatchWindowFocusChanged(z);
        }
    }

    class AndroidHitTestResult implements APHitTestResult {
        WebView.HitTestResult droidHitTestResult;

        AndroidHitTestResult(WebView.HitTestResult hitTestResult) {
            this.droidHitTestResult = hitTestResult;
        }

        public String getExtra() {
            return this.droidHitTestResult.getExtra();
        }

        public int getType() {
            return this.droidHitTestResult.getType();
        }
    }
}
