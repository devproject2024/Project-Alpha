package net.one97.paytm.acceptPayment.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.business.common_module.utilities.LogUtility;
import java.util.Map;
import net.one97.paytm.acceptPayment.webviewutils.b.e;

public class VideoEnabledWebView extends WebView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public e f52217a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f52218b = false;

    public class a {
        public a() {
        }

        @JavascriptInterface
        public final void notifyVideoEnd() {
            LogUtility.d("___", "GOT IT");
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    if (VideoEnabledWebView.this.f52217a != null) {
                        VideoEnabledWebView.this.f52217a.onHideCustomView();
                    }
                }
            });
        }
    }

    public VideoEnabledWebView(Context context) {
        super(a(context));
    }

    public VideoEnabledWebView(Context context, AttributeSet attributeSet) {
        super(a(context), attributeSet);
    }

    public VideoEnabledWebView(Context context, AttributeSet attributeSet, int i2) {
        super(a(context), attributeSet, i2);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        getSettings().setJavaScriptEnabled(true);
        if (webChromeClient instanceof e) {
            this.f52217a = (e) webChromeClient;
        }
        super.setWebChromeClient(webChromeClient);
    }

    public void loadData(String str, String str2, String str3) {
        a();
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        a();
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        a();
        super.loadUrl(str);
    }

    public void loadUrl(String str, Map<String, String> map) {
        a();
        super.loadUrl(str, map);
    }

    private void a() {
        if (!this.f52218b) {
            addJavascriptInterface(new a(), "_VideoEnabledWebView");
            this.f52218b = true;
        }
    }

    private static Context a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }
}
