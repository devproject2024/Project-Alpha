package com.alipay.mobile.nebulacore.android;

import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.mobile.nebula.util.H5ResourceCORSUtil;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APWebResourceRequest;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebula.webview.APWebViewClient;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.HashMap;

class AndroidWebViewClient extends WebViewClient {
    private long currentTrafficFlow;
    private APWebView mAPWebView;
    private APWebViewClient mAPWebViewClient;
    private int uid = H5Utils.getUid(H5Environment.getContext());

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    AndroidWebViewClient(APWebView aPWebView, APWebViewClient aPWebViewClient) {
        this.mAPWebViewClient = aPWebViewClient;
        this.mAPWebView = aPWebView;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        return aPWebViewClient != null && aPWebViewClient.shouldOverrideUrlLoading(this.mAPWebView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.mAPWebViewClient != null) {
            this.currentTrafficFlow = getTrafficFlow();
            this.mAPWebViewClient.onPageStarted(this.mAPWebView, str, bitmap);
        }
    }

    private long getTrafficFlow() {
        try {
            return TrafficStats.getUidRxBytes(this.uid);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.mAPWebViewClient != null) {
            this.mAPWebViewClient.onPageFinished(this.mAPWebView, str, getTrafficFlow() - this.currentTrafficFlow);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        if (aPWebViewClient != null) {
            aPWebViewClient.onLoadResource(this.mAPWebView, str);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        if (aPWebViewClient != null) {
            return aPWebViewClient.shouldInterceptRequest(this.mAPWebView, str);
        }
        return null;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String cORSUrl;
        if (this.mAPWebViewClient == null) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.mAPWebViewClient.shouldInterceptRequest(this.mAPWebView, (APWebResourceRequest) new AndroidWebResourceRequest(webResourceRequest));
        if (shouldInterceptRequest == null) {
            return shouldInterceptRequest;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Cache-Control", "no-cache");
        String pageUrl = this.mAPWebViewClient.getPageUrl();
        if (!(pageUrl == null || !H5ResourceCORSUtil.needAddHeader(pageUrl) || (cORSUrl = H5ResourceCORSUtil.getCORSUrl(pageUrl)) == null)) {
            hashMap.put("Access-Control-Allow-Origin", cORSUrl);
        }
        String uri = webResourceRequest.getUrl().toString();
        if (!hashMap.containsKey("Access-Control-Allow-Origin") && H5Utils.enableCheckCrossOrigin() && !TextUtils.isEmpty(uri) && H5Utils.containNebulaAddcors(uri) && !TextUtils.isEmpty(pageUrl)) {
            String cORSUrl2 = H5ResourceCORSUtil.getCORSUrl(pageUrl);
            if (!TextUtils.isEmpty(cORSUrl2)) {
                hashMap.put("Access-Control-Allow-Origin", cORSUrl2);
            }
        }
        shouldInterceptRequest.setResponseHeaders(hashMap);
        return shouldInterceptRequest;
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        if (aPWebViewClient != null) {
            aPWebViewClient.onReceivedError(this.mAPWebView, i2, str, str2);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        if (aPWebViewClient != null) {
            aPWebViewClient.onReceivedError(this.mAPWebView, webResourceRequest, webResourceError);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        if (aPWebViewClient != null) {
            aPWebViewClient.onFormResubmission(this.mAPWebView, message, message2);
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        if (aPWebViewClient != null) {
            aPWebViewClient.doUpdateVisitedHistory(this.mAPWebView, str, z);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        if (aPWebViewClient != null) {
            aPWebViewClient.onReceivedSslError(this.mAPWebView, new AndroidSslErrorHandler(sslErrorHandler), new AndroidSslError(0, (SslCertificate) null, sslError));
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        if (aPWebViewClient != null) {
            aPWebViewClient.onReceivedHttpAuthRequest(this.mAPWebView, new AndroidHttpAuthHandler(httpAuthHandler), str, str2);
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        return aPWebViewClient != null && aPWebViewClient.shouldOverrideKeyEvent(this.mAPWebView, keyEvent);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        APWebView aPWebView = this.mAPWebView;
        if (aPWebView != null) {
            this.mAPWebViewClient.onUnhandledKeyEvent(aPWebView, keyEvent);
        }
    }

    public void onScaleChanged(WebView webView, float f2, float f3) {
        APWebViewClient aPWebViewClient = this.mAPWebViewClient;
        if (aPWebViewClient != null) {
            aPWebViewClient.onScaleChanged(this.mAPWebView, f2, f3);
        }
    }
}
