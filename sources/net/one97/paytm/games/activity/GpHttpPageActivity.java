package net.one97.paytm.games.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.c;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.a.f;
import net.one97.paytm.games.e.h;

public class GpHttpPageActivity extends GpBaseActivity implements SwipeRefreshLayout.b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f35503b = GpHttpPageActivity.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public SwipeRefreshLayout f35504c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public WebView f35505d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(2);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.games_back_arrow);
        f fVar = f.f35598a;
        int a2 = f.a(this, 12);
        f fVar2 = f.f35598a;
        int a3 = f.a(this, 16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(a2, a3, a2, a3);
        imageView.setLayoutParams(layoutParams);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GpHttpPageActivity.this.a(view);
            }
        });
        this.f35504c = new SwipeRefreshLayout(this);
        this.f35504c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f35504c.setOnRefreshListener(this);
        this.f35505d = new WebView(this);
        this.f35505d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f35505d.getSettings().setMixedContentMode(0);
        }
        this.f35505d.getSettings().setBuiltInZoomControls(true);
        this.f35505d.getSettings().setJavaScriptEnabled(true);
        this.f35505d.getSettings().setDatabasePath(getCacheDir().getAbsolutePath());
        this.f35505d.getSettings().setDatabaseEnabled(true);
        this.f35505d.getSettings().setDomStorageEnabled(true);
        this.f35505d.getSettings().setAppCachePath(getCacheDir().getAbsolutePath());
        this.f35505d.getSettings().setAppCacheEnabled(true);
        this.f35505d.addJavascriptInterface(new h(this), "PowerPlayAndroid");
        this.f35505d.setWebViewClient(new a(this, (byte) 0));
        this.f35505d.setWebChromeClient(new WebChromeClient() {
            public final void onProgressChanged(WebView webView, int i2) {
                GpHttpPageActivity.this.setProgress(i2 * 100);
            }
        });
        this.f35505d.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                GpHttpPageActivity.this.startActivity(intent);
            }
        });
        linearLayout.addView(imageView);
        this.f35504c.addView(this.f35505d);
        linearLayout.addView(this.f35504c);
        setContentView((View) linearLayout);
        a((Activity) this);
        Uri data = getIntent().getData();
        if (data == null) {
            a(getString(R.string.com_gamepind_title_invalid_parameter), getString(R.string.com_gamepind_msg_no_url));
            return;
        }
        String uri = data.toString();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            z = true;
        }
        if (z) {
            setProgressBarVisibility(true);
            this.f35505d.loadUrl(c.a(this, uri, "webview", "1"));
            return;
        }
        a(getString(R.string.com_gamepind_title_no_network), getString(R.string.com_gamepind_msg_network_connectivity));
    }

    private void a(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setCancelable(false);
        builder.setNeutralButton(getString(R.string.com_gamepind_btn_ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                GpHttpPageActivity.this.finish();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    public void onBackPressed() {
        if (this.f35505d.canGoBack()) {
            this.f35505d.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onRefresh() {
        WebView webView = this.f35505d;
        if (webView != null) {
            String url = webView.getUrl();
            if (!(url == null || url.trim().length() == 0)) {
                this.f35505d.loadUrl(url);
                this.f35504c.setRefreshing(true);
                this.f35504c.setEnabled(false);
            }
        }
    }

    class a extends WebViewClient {
        private a() {
        }

        /* synthetic */ a(GpHttpPageActivity gpHttpPageActivity, byte b2) {
            this();
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && str.startsWith("market://")) {
                GpHttpPageActivity.this.f35505d.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                GpHttpPageActivity.this.finish();
                return true;
            } else if (net.one97.paytm.games.e.c.a((Activity) GpHttpPageActivity.this, str) || super.shouldOverrideUrlLoading(webView, str)) {
                return true;
            } else {
                return false;
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
            if (uri != null && uri.startsWith("market://")) {
                GpHttpPageActivity.this.f35505d.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(uri)));
                GpHttpPageActivity.this.finish();
                return true;
            } else if (net.one97.paytm.games.e.c.a((Activity) GpHttpPageActivity.this, uri) || super.shouldOverrideUrlLoading(webView, uri)) {
                return true;
            } else {
                return false;
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            GpHttpPageActivity.this.setProgress(0);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (Build.VERSION.SDK_INT <= 21) {
                CookieSyncManager.getInstance().sync();
            } else {
                CookieManager.getInstance().flush();
            }
            GpHttpPageActivity.this.f35504c.setRefreshing(false);
            GpHttpPageActivity.this.f35504c.setEnabled(true);
            GpHttpPageActivity.this.setProgress(AppConstants.START_OTP_FLOW);
        }
    }
}
