package net.one97.paytm.o2o.movies.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import net.one97.paytm.o2o.movies.R;

public class AJREntertainmentWebViewActivity extends AppBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private WebView f73975a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f73976b = true;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_entertainment_webview);
        String stringExtra = getIntent().getStringExtra("intent_movie_image_url");
        String stringExtra2 = getIntent().getStringExtra("intent_movie_title");
        this.f73975a = (WebView) findViewById(R.id.entertainment_webview);
        this.f73975a.setWebViewClient(new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (AJREntertainmentWebViewActivity.this.f73976b) {
                    boolean unused = AJREntertainmentWebViewActivity.this.f73976b = false;
                }
                super.onPageStarted(webView, str, bitmap);
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        });
        this.f73975a.getSettings().setJavaScriptEnabled(true);
        this.f73975a.loadUrl(stringExtra);
        findViewById(R.id.back_button).setOnClickListener(this);
        if (!TextUtils.isEmpty(stringExtra2)) {
            ((TextView) findViewById(R.id.title)).setText(stringExtra2);
        }
    }

    public void onBackPressed() {
        WebView webView = this.f73975a;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.f73975a.goBack();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            onBackPressed();
        }
    }
}
