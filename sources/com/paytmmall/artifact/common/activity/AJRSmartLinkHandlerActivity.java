package com.paytmmall.artifact.common.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import com.paytm.utility.b;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.common.BaseActivity;
import com.paytmmall.artifact.d.d;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URISyntaxException;

public class AJRSmartLinkHandlerActivity extends BaseActivity implements a {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressBar f15633a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15634b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mall_activity_smart_link_handler);
        this.f15633a = (ProgressBar) findViewById(R.id.progressBar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRSmartLinkHandlerActivity.this.a(view);
            }
        });
        toolbar.setNavigationIcon(R.drawable.mall_back_arrow);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("url");
        this.f15634b = intent.getBooleanExtra("extra_allow_fallback", false);
        setTitle("");
        if (stringExtra == null) {
            throw new IllegalArgumentException("EXTRA_INTENT_URL extra value can't be null or empty");
        } else if (d.f(stringExtra) || d.e(stringExtra)) {
            WebView webView = (WebView) findViewById(R.id.order_datails_webiew);
            webView.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 19) {
                webView.setLayerType(2, (Paint) null);
            } else {
                webView.setLayerType(1, (Paint) null);
            }
            webView.setWebViewClient(new a(this.f15633a, this));
            webView.loadUrl(stringExtra);
        } else {
            throw new IllegalArgumentException("EXTRA_INTENT_URL extra value = " + stringExtra + " is not a valid smart link");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public final void a(String str) {
        if (b.u(str)) {
            com.paytmmall.artifact.d.a.a().a((Activity) this, str);
            finish();
            return;
        }
        String N = b.N(str);
        if (!this.f15634b || N.equalsIgnoreCase(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (intent.resolveActivity(getPackageManager()) != null) {
                intent.addFlags(67108864);
                intent.addFlags(268435456);
                startActivity(intent);
                finish();
            } else if (str.startsWith("paytmmp")) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat("net.one97.paytm"))));
                finish();
            } else if (str.startsWith("paytmmall")) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat("com.paytmmall"))));
                finish();
            }
        } else {
            com.paytmmall.artifact.d.a.a().a((Activity) this, N);
            finish();
        }
    }

    static class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private a f15635a;

        /* renamed from: b  reason: collision with root package name */
        private ProgressBar f15636b;

        a(ProgressBar progressBar, a aVar) {
            this.f15636b = progressBar;
            this.f15635a = aVar;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http")) {
                return false;
            }
            try {
                Uri data = Intent.parseUri(str.replaceAll("[$]", AppConstants.AND_SIGN), 1).getData();
                if (this.f15635a != null) {
                    this.f15635a.a(String.valueOf(data));
                    return true;
                }
            } catch (URISyntaxException unused) {
            }
            return false;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            ProgressBar progressBar = this.f15636b;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            ProgressBar progressBar = this.f15636b;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            super.onPageFinished(webView, str);
        }
    }
}
