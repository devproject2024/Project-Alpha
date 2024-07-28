package net.one97.paytm.paymentsBank.createfd.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import net.one97.paytm.paymentsBank.createfd.utils.c;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    d f18195a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f18196b;

    /* renamed from: c  reason: collision with root package name */
    private Double f18197c;

    /* renamed from: d  reason: collision with root package name */
    private int f18198d;

    /* renamed from: e  reason: collision with root package name */
    private int f18199e;

    public interface d {
        void a(String str);
    }

    public c(WebView webView, Context context, d dVar) {
        try {
            this.f18195a = dVar;
            this.f18196b = webView;
            this.f18196b.addJavascriptInterface(new a(context), "AndroidInterface");
            this.f18196b.getSettings().setJavaScriptEnabled(true);
            this.f18196b.setWebChromeClient(new b(this, (byte) 0));
            this.f18196b.setWebViewClient(new C0307c(this, (byte) 0));
        } catch (Exception unused) {
        }
    }

    public final void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel) {
        try {
            this.f18197c = slfdMetaApiResponseModel.getPeakInterestRatePerAnnum();
            this.f18198d = slfdMetaApiResponseModel.getPeakTenureMonths().intValue();
            this.f18199e = slfdMetaApiResponseModel.getPeakTenureDays().intValue();
            slfdMetaApiResponseModel.getFdCalculatorFunc();
            try {
                String encodeToString = Base64.encodeToString(URLEncoder.encode(new String(slfdMetaApiResponseModel.getFdCalculatorFunc().getBytes(), StandardCharsets.UTF_8), AppConstants.UTF_8).replace("+", "%20").getBytes(), 2);
                WebView webView = this.f18196b;
                webView.loadUrl("javascript:(function() {var parent = document.getElementsByTagName('head').item(0);var script = document.createElement('script');script.type = 'text/javascript';script.innerHTML = decodeURIComponent(window.atob('" + encodeToString + "'));parent.appendChild(script)})();");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused) {
        }
    }

    public final void a(long j) {
        WebView webView = this.f18196b;
        webView.loadUrl("javascript:calculateInterest(" + j + AppConstants.COMMA + this.f18197c + AppConstants.COMMA + this.f18198d + AppConstants.COMMA + this.f18199e + ")");
    }

    class a {

        /* renamed from: b  reason: collision with root package name */
        private Context f18201b;

        a(Context context) {
            this.f18201b = context;
        }

        @JavascriptInterface
        public final void showTotalInterest(String str) {
            ((Activity) this.f18201b).runOnUiThread(new Runnable(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    c.a.this.a(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            try {
                c.this.f18195a.a(String.valueOf(str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class b extends WebChromeClient {
        private b() {
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }

        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.createfd.utils.c$c  reason: collision with other inner class name */
    class C0307c extends WebViewClient {
        public final void onPageFinished(WebView webView, String str) {
        }

        private C0307c() {
        }

        /* synthetic */ C0307c(c cVar, byte b2) {
            this();
        }
    }
}
