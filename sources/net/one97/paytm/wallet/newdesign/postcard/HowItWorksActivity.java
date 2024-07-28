package net.one97.paytm.wallet.newdesign.postcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.paytm.utility.q;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;

public class HowItWorksActivity extends Activity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f71133a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f71134b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f71135c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_how_it_works);
            this.f71133a = (ImageView) findViewById(R.id.iv_back_button);
            this.f71134b = (WebView) findViewById(R.id.web_view_tutorial);
            this.f71135c = (ProgressBar) findViewById(R.id.progress_bar);
            WebView webView = (WebView) findViewById(R.id.web_view_tutorial);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
            webView.setWebChromeClient(new WebChromeClient() {
                public final void onProgressChanged(WebView webView, int i2) {
                    if (i2 == 100) {
                        HowItWorksActivity.this.f71135c.setVisibility(8);
                    }
                    super.onProgressChanged(webView, i2);
                }
            });
            webView.loadUrl(b.a().getStringFromGTM(this, "postCardVideoPlaybackURL"));
            this.f71133a.setOnClickListener(this);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onClick(View view) {
        try {
            if (view == this.f71133a) {
                finish();
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }
}
