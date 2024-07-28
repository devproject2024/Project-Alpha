package com.paytmmoney.lite.mod;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import kotlin.g.b.k;
import kotlin.m.p;

public final class GenericWebView$initWebViewSetup$1 extends WebViewClient {
    final /* synthetic */ GenericWebView this$0;

    GenericWebView$initWebViewSetup$1(GenericWebView genericWebView) {
        this.this$0 = genericWebView;
    }

    public final void onPageFinished(WebView webView, String str) {
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(R.id.generic_web_view_progress);
        k.a((Object) progressBar, "generic_web_view_progress");
        progressBar.setVisibility(8);
        super.onPageFinished(webView, str);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null && p.b(str, "mailto:", false)) {
            this.this$0.startActivity(Intent.parseUri(str, 1));
        } else if (str != null && p.b(str, "tel:", false)) {
            this.this$0.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
        } else if (webView != null) {
            webView.loadUrl(str);
        }
        return true;
    }
}
