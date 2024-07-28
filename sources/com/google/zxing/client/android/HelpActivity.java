package com.google.zxing.client.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

public final class HelpActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40095a = ("file:///android_asset/html-" + m.a() + '/');

    /* renamed from: b  reason: collision with root package name */
    private WebView f40096b;

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.help);
        this.f40096b = (WebView) findViewById(R.id.help_contents);
        if (bundle == null) {
            WebView webView = this.f40096b;
            webView.loadUrl(f40095a + "index.html");
            return;
        }
        this.f40096b.restoreState(bundle);
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !this.f40096b.canGoBack()) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.f40096b.goBack();
        return true;
    }
}
