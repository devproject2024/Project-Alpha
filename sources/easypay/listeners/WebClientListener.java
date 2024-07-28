package easypay.listeners;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

public interface WebClientListener {
    void OnWcPageFinish(WebView webView, String str);

    void OnWcPageStart(WebView webView, String str, Bitmap bitmap);

    void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void WcshouldInterceptRequest(WebView webView, String str);

    boolean WcshouldOverrideUrlLoading(WebView webView, Object obj);

    void onReceivedError(WebView webView, int i2, String str, String str2);
}
