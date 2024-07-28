package net.one97.paytm.upi.util;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upi.R;

public final class UpiWebViewActivity$mWebViewClient$1 extends WebViewClient {
    final /* synthetic */ UpiWebViewActivity this$0;

    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        k.c(webView, "view");
        k.c(str, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str2, "failingUrl");
    }

    UpiWebViewActivity$mWebViewClient$1(UpiWebViewActivity upiWebViewActivity) {
        this.this$0 = upiWebViewActivity;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        k.c(webView, "view");
        View findViewById = this.this$0.findViewById(R.id.webview_load_indicator);
        if (findViewById != null) {
            ((ProgressBar) findViewById).setVisibility(0);
            super.onPageStarted(webView, str, bitmap);
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.ProgressBar");
    }

    public final void onPageFinished(WebView webView, String str) {
        k.c(webView, "view");
        k.c(str, "url");
        View findViewById = this.this$0.findViewById(R.id.webview_load_indicator);
        if (findViewById != null) {
            ((ProgressBar) findViewById).setVisibility(8);
            super.onPageFinished(webView, str);
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.ProgressBar");
    }
}
