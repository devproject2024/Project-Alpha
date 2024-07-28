package com.paytmmoney.lite.mod;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.play.core.splitcompat.a;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;

public final class GenericWebView extends AppCompatActivity {
    private HashMap _$_findViewCache;
    private Toolbar toolbar;
    private String webViewTitle = "";
    private String webViewUrl = "";

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

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pm_generic_webview);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.get("webview_url") != null) {
                Object obj = extras.get("webview_url");
                if (obj != null) {
                    this.webViewUrl = (String) obj;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            if (extras.get("webViewTitle") != null) {
                Object obj2 = extras.get("webViewTitle");
                if (obj2 != null) {
                    this.webViewTitle = (String) obj2;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            initWebViewSetup(this.webViewUrl);
        }
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            setSupportActionBar(toolbar2);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.a((CharSequence) this.webViewTitle);
            }
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.b(true);
            }
            getSupportActionBar();
            invalidateOptionsMenu();
        }
    }

    private final void initWebViewSetup(String str) {
        WebSettings settings;
        WebView webView = (WebView) _$_findCachedViewById(R.id.generic_web_view);
        if (!(webView == null || (settings = webView.getSettings()) == null)) {
            settings.setJavaScriptEnabled(true);
        }
        WebView webView2 = (WebView) _$_findCachedViewById(R.id.generic_web_view);
        if (webView2 != null) {
            webView2.setWebViewClient(new GenericWebView$initWebViewSetup$1(this));
        }
        WebView webView3 = (WebView) _$_findCachedViewById(R.id.generic_web_view);
        if (webView3 != null) {
            webView3.setWebChromeClient(new WebChromeClient());
        }
        ((WebView) _$_findCachedViewById(R.id.generic_web_view)).loadUrl(str);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }
}
