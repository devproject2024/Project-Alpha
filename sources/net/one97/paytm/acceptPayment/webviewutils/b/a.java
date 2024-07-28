package net.one97.paytm.acceptPayment.webviewutils.b;

import android.os.Handler;
import android.os.Message;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.List;

public class a extends WebViewClient {
    protected final WeakReference<Handler> mHandler;

    public a(Handler handler, List<String> list, String str) {
        this.mHandler = new WeakReference<>(handler);
    }

    public a(Handler handler, String str, String str2) {
        this.mHandler = new WeakReference<>(handler);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        WeakReference<Handler> weakReference = this.mHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((Handler) this.mHandler.get()).sendMessage(getWebViewError(webResourceError.getDescription().toString(), webResourceError.getErrorCode(), webResourceRequest.getUrl().toString()));
        }
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        WeakReference<Handler> weakReference = this.mHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((Handler) this.mHandler.get()).sendMessage(getWebViewError(str, i2, str2));
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    /* access modifiers changed from: protected */
    public Message getWebViewError(String str, int i2, String str2) {
        Message message = new Message();
        message.what = -4;
        message.obj = new net.one97.paytm.acceptPayment.webviewutils.a.a(str, i2, str2);
        return message;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
