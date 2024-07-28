package com.travel.train.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;

public class AJRAppWebView extends CJRTrainBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private final String f25807a = "Terms and Conditions";

    /* renamed from: b  reason: collision with root package name */
    private WebView f25808b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f25809c;

    /* renamed from: d  reason: collision with root package name */
    private String f25810d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25811e = false;

    /* renamed from: f  reason: collision with root package name */
    private Toolbar f25812f;

    /* renamed from: g  reason: collision with root package name */
    private View f25813g;

    /* renamed from: h  reason: collision with root package name */
    private a f25814h = new a();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_app_in_web_view);
        this.f25808b = (WebView) findViewById(R.id.web_view);
        this.f25809c = (ProgressBar) findViewById(R.id.webview_load_indicator);
        this.f25812f = (Toolbar) findViewById(R.id.train_webview_toolbar);
        this.f25813g = findViewById(R.id.view_separator_bottom);
        this.f25810d = getIntent().getStringExtra("url");
        this.f25811e = getIntent().getBooleanExtra("show_title", false);
        if (this.f25811e) {
            this.f25812f.setVisibility(0);
            this.f25813g.setVisibility(0);
            ((TextView) findViewById(R.id.train_toolbar_title)).setText("Terms and Conditions");
            ((ImageView) findViewById(R.id.train_toolbar_back_arrow)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRAppWebView.this.onBackPressed();
                }
            });
        }
        this.f25808b.getSettings().setJavaScriptEnabled(true);
        this.f25808b.setWebViewClient(this.f25814h);
        this.f25808b.getSettings().setBuiltInZoomControls(true);
        this.f25808b.getSettings().setJavaScriptEnabled(true);
        this.f25808b.requestFocus(130);
        this.f25808b.getSettings().setLoadWithOverviewMode(true);
        this.f25808b.getSettings().setUseWideViewPort(true);
        this.f25808b.loadUrl(this.f25810d);
    }

    public class a extends WebViewClient {
        public a() {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AJRAppWebView.this.f25809c.setVisibility(0);
            super.onPageStarted(webView, str, bitmap);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.clearView();
            webView.loadUrl(str);
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public final void onPageFinished(WebView webView, String str) {
            AJRAppWebView.this.f25809c.setVisibility(8);
            super.onPageFinished(webView, str);
        }

        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            AJRAppWebView.this.f25809c.setVisibility(8);
        }
    }

    public void onBackPressed() {
        WebView webView = this.f25808b;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.f25808b.goBack();
        }
    }
}
