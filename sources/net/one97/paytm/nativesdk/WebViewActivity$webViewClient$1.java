package net.one97.paytm.nativesdk;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public final class WebViewActivity$webViewClient$1 extends WebViewClient {
    final /* synthetic */ WebViewActivity this$0;

    WebViewActivity$webViewClient$1(WebViewActivity webViewActivity) {
        this.this$0 = webViewActivity;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(R.id.webview_load_indicator);
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(R.id.webview_load_indicator);
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }
}
