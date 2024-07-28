package com.paytmmoney.lite.mod;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.g.b.k;
import kotlin.m.p;

public final class PaymentWebview$initWebViewSetup$1 extends WebViewClient {
    final /* synthetic */ PaymentWebview this$0;

    public final void onLoadResource(WebView webView, String str) {
        k.c(webView, "view");
        k.c(str, "url");
    }

    PaymentWebview$initWebViewSetup$1(PaymentWebview paymentWebview) {
        this.this$0 = paymentWebview;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        PaymentWebview.access$getProgress_bar$p(this.this$0).setVisibility(8);
        Boolean valueOf = str != null ? Boolean.valueOf(p.b(str, this.this$0.paymentSuccessUrl, true)) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            this.this$0.handleRedirectLogic(str, true);
        }
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        PaymentWebview.access$getProgress_bar$p(this.this$0).setVisibility(8);
    }
}
