package net.one97.paytm.transport.iocl_v1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import net.one97.paytm.iocl.R;

public class IOCLWebviewActivity extends Activity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f14407a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f14408b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.iocl_webview);
            this.f14407a = (ImageView) findViewById(R.id.iv_back_button);
            this.f14408b = (ProgressBar) findViewById(R.id.progress_bar);
            WebView webView = (WebView) findViewById(R.id.webview);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
            webView.setWebChromeClient(new WebChromeClient() {
                public final void onProgressChanged(WebView webView, int i2) {
                    if (i2 == 100) {
                        IOCLWebviewActivity.this.f14408b.setVisibility(8);
                    }
                    super.onProgressChanged(webView, i2);
                }
            });
            webView.loadUrl("http://www.google.com");
            this.f14407a.setOnClickListener(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onClick(View view) {
        try {
            if (view == this.f14407a) {
                finish();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
