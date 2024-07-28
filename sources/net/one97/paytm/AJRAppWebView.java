package net.one97.paytm;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import net.one97.paytm.paytm_finance.R;

public class AJRAppWebView extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f51325a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f51326b;

    /* renamed from: c  reason: collision with root package name */
    private a f51327c = new a();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_in_web_view);
        this.f51325a = (WebView) findViewById(R.id.web_view);
        this.f51326b = (ProgressBar) findViewById(R.id.webview_load_indicator);
        this.f51325a.getSettings().setJavaScriptEnabled(true);
        this.f51325a.setWebViewClient(this.f51327c);
        this.f51325a.getSettings().setBuiltInZoomControls(true);
        this.f51325a.getSettings().setJavaScriptEnabled(true);
        this.f51325a.requestFocus(130);
        this.f51325a.getSettings().setLoadWithOverviewMode(true);
        this.f51325a.getSettings().setUseWideViewPort(true);
        this.f51325a.loadUrl(getIntent().getStringExtra("url"));
    }

    public class a extends WebViewClient {
        public a() {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AJRAppWebView.this.f51326b.setVisibility(0);
            super.onPageStarted(webView, str, bitmap);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.clearView();
            webView.loadUrl(str);
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public final void onPageFinished(WebView webView, String str) {
            AJRAppWebView.this.f51326b.setVisibility(8);
            super.onPageFinished(webView, str);
        }

        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            AJRAppWebView.this.f51326b.setVisibility(8);
        }
    }

    public void onBackPressed() {
        WebView webView = this.f51325a;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.f51325a.goBack();
        }
    }
}
