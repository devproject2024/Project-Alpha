package net.one97.paytm.upi.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.f;

public final class UpiWebViewActivity extends PaytmActivity {
    public static final Companion Companion = new Companion((g) null);
    private static final String SHOW_TOOLBAR = "show_toolbar";
    private HashMap _$_findViewCache;
    private String mUrl;
    private WebView mWebView;
    private final UpiWebViewActivity$mWebViewClient$1 mWebViewClient = new UpiWebViewActivity$mWebViewClient$1(this);

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class Companion {
        public final void startActivity(Activity activity, String str) {
            startActivity$default(this, activity, str, (Boolean) null, 4, (Object) null);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Activity activity, String str, Boolean bool, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                bool = Boolean.FALSE;
            }
            companion.startActivity(activity, str, bool);
        }

        public final void startActivity(Activity activity, String str, Boolean bool) {
            k.c(activity, "activity");
            k.c(str, "url");
            Intent intent = new Intent(activity, UpiWebViewActivity.class);
            intent.putExtra("url", str);
            intent.putExtra(UpiWebViewActivity.SHOW_TOOLBAR, bool);
            activity.startActivity(intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        WebSettings settings;
        WebSettings settings2;
        WebSettings settings3;
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_web_view);
        boolean booleanExtra = getIntent().getBooleanExtra(SHOW_TOOLBAR, false);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        ImageView imageView = (ImageView) findViewById(R.id.backArrow);
        if (booleanExtra) {
            k.a((Object) appBarLayout, "toolbar");
            f.b((View) appBarLayout);
        } else {
            k.a((Object) appBarLayout, "toolbar");
            f.a((View) appBarLayout);
        }
        this.mUrl = getIntent().getStringExtra("url");
        View findViewById = findViewById(R.id.payment_webview);
        if (findViewById != null) {
            this.mWebView = (WebView) findViewById;
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.setWebViewClient(this.mWebViewClient);
            }
            WebView webView2 = this.mWebView;
            if (!(webView2 == null || (settings3 = webView2.getSettings()) == null)) {
                settings3.setJavaScriptEnabled(true);
            }
            WebView webView3 = this.mWebView;
            if (!(webView3 == null || (settings2 = webView3.getSettings()) == null)) {
                settings2.setDomStorageEnabled(true);
            }
            WebView webView4 = this.mWebView;
            if (!(webView4 == null || (settings = webView4.getSettings()) == null)) {
                settings.setPluginState(WebSettings.PluginState.ON);
            }
            String stringExtra = getIntent().getStringExtra("url");
            String stringExtra2 = getIntent().getStringExtra("url");
            k.a((Object) stringExtra2, "intent.getStringExtra(\"url\")");
            if (p.a((CharSequence) stringExtra2, (CharSequence) ".pdf", false)) {
                stringExtra = "http://docs.google.com/gview?embedded=true&url=".concat(String.valueOf(stringExtra));
            }
            WebView webView5 = this.mWebView;
            if (webView5 != null) {
                webView5.loadUrl(stringExtra);
            }
            imageView.setOnClickListener(new a(this));
            return;
        }
        throw new u("null cannot be cast to non-null type android.webkit.WebView");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UpiWebViewActivity f69545a;

        a(UpiWebViewActivity upiWebViewActivity) {
            this.f69545a = upiWebViewActivity;
        }

        public final void onClick(View view) {
            this.f69545a.onBackPressed();
        }
    }

    public final void onBackPressed() {
        WebView webView = this.mWebView;
        if (webView == null) {
            k.a();
        }
        if (webView.canGoBack()) {
            WebView webView2 = this.mWebView;
            if (webView2 == null) {
                k.a();
            }
            webView2.goBack();
            return;
        }
        finish();
    }
}
