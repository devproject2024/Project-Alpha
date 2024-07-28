package net.one97.paytm.oauth.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.widget.Toolbar;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.OAuthUtils;

public class OauthWebViewActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    WebViewClient f52545a = new WebViewClient() {
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            OAuthUtils.a(OauthWebViewActivity.this.f52548d);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OAuthUtils.b(OauthWebViewActivity.this.f52548d);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private String f52546b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f52547c = "";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f52548d;

    /* renamed from: e  reason: collision with root package name */
    private WebView f52549e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_oauth_web_view);
        this.f52549e = (WebView) findViewById(R.id.oauth_webview);
        this.f52548d = (LottieAnimationView) findViewById(R.id.lottie_web_loader);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OauthWebViewActivity.this.finish();
            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(true);
        }
        if (getIntent() != null && getIntent().hasExtra("webview_url")) {
            this.f52546b = getIntent().getStringExtra("webview_url");
            if (TextUtils.isEmpty(this.f52546b)) {
                finish();
            }
            this.f52547c = getIntent().getStringExtra("webview_title");
            if (!TextUtils.isEmpty(this.f52547c) && getSupportActionBar() != null) {
                getSupportActionBar().a((CharSequence) this.f52547c);
            }
        }
        this.f52549e.getSettings().setJavaScriptEnabled(true);
        this.f52549e.loadUrl(this.f52546b);
        this.f52549e.setWebViewClient(this.f52545a);
    }

    public void onPause() {
        super.onPause();
        OAuthUtils.b(this.f52548d);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
