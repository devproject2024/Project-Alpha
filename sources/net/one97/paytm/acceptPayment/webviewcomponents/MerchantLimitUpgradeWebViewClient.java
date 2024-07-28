package net.one97.paytm.acceptPayment.webviewcomponents;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.List;
import net.one97.paytm.acceptPayment.webviewutils.b.a;

public class MerchantLimitUpgradeWebViewClient extends a {
    public MerchantLimitUpgradeWebViewClient(Handler handler, List<String> list, String str) {
        super(handler, list, str);
    }

    public MerchantLimitUpgradeWebViewClient(Handler handler, String str, String str2) {
        super(handler, str, str2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        String queryParameter;
        try {
            String host = Uri.parse(str).getHost();
            if (host != null && host.contains("www.google-analytics.com") && (queryParameter = Uri.parse(str).getQueryParameter("ec")) != null && queryParameter.equals("Upgrade_account_page")) {
                openP4bApp();
                return null;
            }
        } catch (Exception unused) {
        }
        return super.shouldInterceptRequest(webView, str);
    }

    private void openP4bApp() {
        WeakReference<Handler> weakReference = this.mHandler;
        if (weakReference != null && weakReference.get() != null) {
            Message message = new Message();
            message.what = 11;
            ((Handler) this.mHandler.get()).sendMessage(message);
        }
    }
}
