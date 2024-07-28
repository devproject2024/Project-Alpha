package com.alipay.mobile.nebulacore.android;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.alipay.mobile.nebula.webview.APWebResourceRequest;
import java.util.Map;

public class AndroidWebResourceRequest implements APWebResourceRequest {
    private WebResourceRequest request;

    public AndroidWebResourceRequest(WebResourceRequest webResourceRequest) {
        this.request = webResourceRequest;
    }

    public String getMethod() {
        WebResourceRequest webResourceRequest = this.request;
        if (webResourceRequest != null) {
            return webResourceRequest.getMethod();
        }
        return null;
    }

    public Map<String, String> getRequestHeaders() {
        WebResourceRequest webResourceRequest = this.request;
        if (webResourceRequest != null) {
            return webResourceRequest.getRequestHeaders();
        }
        return null;
    }

    public Uri getUrl() {
        WebResourceRequest webResourceRequest = this.request;
        if (webResourceRequest != null) {
            return webResourceRequest.getUrl();
        }
        return null;
    }

    public boolean hasGesture() {
        WebResourceRequest webResourceRequest = this.request;
        if (webResourceRequest != null) {
            return webResourceRequest.hasGesture();
        }
        return false;
    }

    public boolean isForMainFrame() {
        WebResourceRequest webResourceRequest = this.request;
        if (webResourceRequest != null) {
            return webResourceRequest.isForMainFrame();
        }
        return false;
    }
}
