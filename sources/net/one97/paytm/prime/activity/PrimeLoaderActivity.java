package net.one97.paytm.prime.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.fragment.app.j;
import com.appsflyer.AFInAppEventParameterName;
import com.google.firebase.crashlytics.c;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import easypay.listeners.WebClientListener;
import easypay.manager.AssistMerchantDetails;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.prime.R;
import net.one97.paytm.prime.c.a;
import net.one97.paytm.prime.e.b;
import net.one97.paytm.prime.f.b;
import org.json.JSONObject;

public class PrimeLoaderActivity extends PaytmActivity implements WebClientListener, b {

    /* renamed from: a  reason: collision with root package name */
    a f59737a;

    /* renamed from: b  reason: collision with root package name */
    protected ProgressDialog f59738b;

    /* renamed from: c  reason: collision with root package name */
    String f59739c = "";

    /* renamed from: d  reason: collision with root package name */
    private AssistMerchantDetails f59740d;

    /* renamed from: e  reason: collision with root package name */
    private String f59741e = "orderId";

    /* renamed from: f  reason: collision with root package name */
    private String f59742f = "checkout";

    public void OnWcPageFinish(WebView webView, String str) {
    }

    public void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
    }

    public void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    public void WcshouldInterceptRequest(WebView webView, String str) {
    }

    public boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        return false;
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: net.one97.paytm.prime.activity.PrimeLoaderActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: net.one97.paytm.prime.activity.PrimeLoaderActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: net.one97.paytm.prime.activity.PrimeLoaderActivity} */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x027b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x027c, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x027e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x027f, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0289, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x028a, code lost:
        r2 = r1;
        r17 = "\n\n Cart Response :- ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02d6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02d7, code lost:
        r2 = r1;
        r5 = "\n\n Cart Response :- ";
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x031f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0320, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0351, code lost:
        r0 = e;
        r2 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0289 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:39:0x018f] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x031f A[Catch:{ Exception -> 0x0351 }, ExcHandler: NullPointerException (e java.lang.NullPointerException), Splitter:B:39:0x018f] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0362  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r19) {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r2 = "pgUrlToHit"
            java.lang.String r3 = "\n\n Cart Response :- "
            java.lang.String r4 = "hitPG"
            java.lang.String r5 = "message"
            java.lang.String r6 = "status"
            java.lang.String r7 = "ORDER_ID"
            java.lang.String r8 = "ORDERID"
            java.lang.String r9 = "&"
            java.lang.String r10 = "="
            java.lang.String r11 = "UTF-8"
            super.onCreate(r19)
            int r0 = android.os.Build.VERSION.SDK_INT
            r12 = 1
            r13 = 26
            if (r0 == r13) goto L_0x0023
            r1.setRequestedOrientation(r12)
        L_0x0023:
            int r0 = net.one97.paytm.prime.R.layout.activity_prime_loader
            androidx.databinding.ViewDataBinding r0 = androidx.databinding.f.a(r1, r0)
            net.one97.paytm.prime.c.a r0 = (net.one97.paytm.prime.c.a) r0
            r1.f59737a = r0
            android.content.Intent r0 = r18.getIntent()
            if (r0 == 0) goto L_0x0376
            android.content.Intent r0 = r18.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0376
            android.content.Intent r0 = r18.getIntent()
            java.lang.String r13 = r1.f59741e
            boolean r0 = r0.hasExtra(r13)
            if (r0 == 0) goto L_0x006c
            android.content.Intent r0 = r18.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r2 = r1.f59741e
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = r18.isFinishing()
            if (r2 != 0) goto L_0x0064
            net.one97.paytm.prime.c.a r2 = r1.f59737a
            com.airbnb.lottie.LottieAnimationView r2 = r2.f59748c
            net.one97.paytm.common.widgets.a.a(r2)
        L_0x0064:
            com.paytm.network.a r0 = net.one97.paytm.prime.a.a.a(r1, r0, r1)
            r0.a()
            return
        L_0x006c:
            android.content.Intent r0 = r18.getIntent()
            java.lang.String r13 = r1.f59742f
            boolean r0 = r0.hasExtra(r13)
            if (r0 == 0) goto L_0x0374
            android.content.Intent r0 = r18.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r13 = r1.f59742f
            java.io.Serializable r0 = r0.getSerializable(r13)
            boolean r0 = r0 instanceof java.lang.String
            if (r0 == 0) goto L_0x009b
            android.content.Intent r0 = r18.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r13 = r1.f59742f
            java.io.Serializable r0 = r0.getSerializable(r13)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00b4
        L_0x009b:
            android.content.Intent r0 = r18.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r13 = r1.f59742f
            java.io.Serializable r0 = r0.getSerializable(r13)
            java.util.HashMap r0 = (java.util.HashMap) r0
            com.google.gsonhtcfix.f r13 = new com.google.gsonhtcfix.f
            r13.<init>()
            java.lang.String r0 = r13.a((java.lang.Object) r0)
        L_0x00b4:
            r13 = r0
            boolean r0 = r18.isFinishing()
            if (r0 != 0) goto L_0x0372
            net.one97.paytm.prime.c.a r0 = r1.f59737a     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebView r0 = r0.f59749d     // Catch:{ Exception -> 0x0353 }
            r14 = 0
            r0.setVisibility(r14)     // Catch:{ Exception -> 0x0353 }
            easypay.manager.AssistMerchantDetails r0 = easypay.manager.AssistMerchantDetails.getInstance()     // Catch:{ Exception -> 0x0353 }
            r1.f59740d = r0     // Catch:{ Exception -> 0x0353 }
            easypay.manager.PaytmAssist$Builder r0 = new easypay.manager.PaytmAssist$Builder     // Catch:{ Exception -> 0x0353 }
            java.lang.String r15 = "verticalOrderID:0"
            java.lang.String r12 = "Paytm-Main-App-Transactions"
            r0.<init>(r1, r15, r12)     // Catch:{ Exception -> 0x0353 }
            r0.setAssistEnabled(r14)     // Catch:{ Exception -> 0x0353 }
            r0.setNativeEnabled(r14)     // Catch:{ Exception -> 0x0353 }
            net.one97.paytm.prime.c.a r12 = r1.f59737a     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebView r12 = r12.f59749d     // Catch:{ Exception -> 0x0353 }
            r0.setWebView(r12)     // Catch:{ Exception -> 0x0353 }
            int r12 = net.one97.paytm.prime.R.id.prime_webview     // Catch:{ Exception -> 0x0353 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0353 }
            r0.setViewId(r12)     // Catch:{ Exception -> 0x0353 }
            java.lang.String r12 = "PRODUCTION"
            r0.setServer(r12)     // Catch:{ Exception -> 0x0353 }
            r12 = 1
            r0.setEnableLogging(r12)     // Catch:{ Exception -> 0x0353 }
            r0.build()     // Catch:{ Exception -> 0x0353 }
            easypay.manager.PaytmAssist.startAssist()     // Catch:{ Exception -> 0x0353 }
            android.content.res.Resources r0 = r18.getResources()     // Catch:{ Exception -> 0x0353 }
            int r12 = net.one97.paytm.prime.R.string.please_wait_progress_msg     // Catch:{ Exception -> 0x0353 }
            java.lang.String r0 = r0.getString(r12)     // Catch:{ Exception -> 0x0353 }
            android.app.ProgressDialog r12 = r1.f59738b     // Catch:{ Exception -> 0x0353 }
            if (r12 == 0) goto L_0x010d
            android.app.ProgressDialog r12 = r1.f59738b     // Catch:{ Exception -> 0x0353 }
            boolean r12 = r12.isShowing()     // Catch:{ Exception -> 0x0353 }
            if (r12 != 0) goto L_0x013a
        L_0x010d:
            android.app.ProgressDialog r12 = new android.app.ProgressDialog     // Catch:{ Exception -> 0x0353 }
            r12.<init>(r1)     // Catch:{ Exception -> 0x0353 }
            r1.f59738b = r12     // Catch:{ Exception -> 0x0353 }
            android.app.ProgressDialog r12 = r1.f59738b     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            r12.setProgressStyle(r14)     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            android.app.ProgressDialog r12 = r1.f59738b     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            r12.setMessage(r0)     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            android.app.ProgressDialog r0 = r1.f59738b     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            r0.setCancelable(r14)     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            android.app.ProgressDialog r0 = r1.f59738b     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            r0.setCanceledOnTouchOutside(r14)     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            android.app.ProgressDialog r0 = r1.f59738b     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            r0.show()     // Catch:{ IllegalArgumentException -> 0x012e, Exception -> 0x013a }
            goto L_0x013a
        L_0x012e:
            r0 = move-exception
            boolean r12 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x0353 }
            if (r12 == 0) goto L_0x013a
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0353 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x0353 }
        L_0x013a:
            net.one97.paytm.prime.c.a r0 = r1.f59737a     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebView r0 = r0.f59749d     // Catch:{ Exception -> 0x0353 }
            net.one97.paytm.prime.activity.PrimeLoaderActivity$1 r12 = new net.one97.paytm.prime.activity.PrimeLoaderActivity$1     // Catch:{ Exception -> 0x0353 }
            r12.<init>()     // Catch:{ Exception -> 0x0353 }
            r0.setWebViewClient(r12)     // Catch:{ Exception -> 0x0353 }
            easypay.manager.AssistMerchantDetails r0 = r1.f59740d     // Catch:{ Exception -> 0x0353 }
            easypay.manager.EasypayWebViewClient r0 = r0.getWebClientInstance()     // Catch:{ Exception -> 0x0353 }
            r0.addAssistWebClientListener(r1)     // Catch:{ Exception -> 0x0353 }
            net.one97.paytm.prime.c.a r0 = r1.f59737a     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebView r0 = r0.f59749d     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ Exception -> 0x0353 }
            r12 = 1
            r0.setJavaScriptEnabled(r12)     // Catch:{ Exception -> 0x0353 }
            net.one97.paytm.prime.c.a r0 = r1.f59737a     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebView r0 = r0.f59749d     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ Exception -> 0x0353 }
            r0.setJavaScriptCanOpenWindowsAutomatically(r12)     // Catch:{ Exception -> 0x0353 }
            net.one97.paytm.prime.c.a r0 = r1.f59737a     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebView r0 = r0.f59749d     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ Exception -> 0x0353 }
            r0.setDomStorageEnabled(r12)     // Catch:{ Exception -> 0x0353 }
            net.one97.paytm.prime.c.a r0 = r1.f59737a     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebView r0 = r0.f59749d     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ Exception -> 0x0353 }
            r0.setBuiltInZoomControls(r12)     // Catch:{ Exception -> 0x0353 }
            net.one97.paytm.prime.c.a r0 = r1.f59737a     // Catch:{ Exception -> 0x0353 }
            android.webkit.WebView r0 = r0.f59749d     // Catch:{ Exception -> 0x0353 }
            r12 = 130(0x82, float:1.82E-43)
            r0.requestFocus(r12)     // Catch:{ Exception -> 0x0353 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0353 }
            r12 = 19
            if (r0 < r12) goto L_0x018f
            r12 = 1
            android.webkit.WebView.setWebContentsDebuggingEnabled(r12)     // Catch:{ Exception -> 0x0353 }
        L_0x018f:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x02d6, Exception -> 0x0289 }
            r0.<init>(r13)     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x0281, Exception -> 0x0289 }
            java.lang.Object r12 = r0.get(r8)     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x0281, Exception -> 0x0289 }
            java.lang.String r12 = r12.toString()     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x0281, Exception -> 0x0289 }
            java.lang.Object r14 = r0.get(r7)     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x0281, Exception -> 0x0289 }
            java.lang.String r14 = r14.toString()     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x0281, Exception -> 0x0289 }
            java.lang.Object r15 = r0.get(r6)     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x0281, Exception -> 0x0289 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x0281, Exception -> 0x0289 }
            java.lang.Object r16 = r0.get(r5)     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x0281, Exception -> 0x0289 }
            r17 = r3
            r3 = r16
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x027e, Exception -> 0x027b }
            java.lang.Object r16 = r0.get(r4)     // Catch:{ NullPointerException -> 0x031f, UnsupportedEncodingException -> 0x027e, Exception -> 0x027b }
            r1 = r16
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NullPointerException -> 0x0276, UnsupportedEncodingException -> 0x0272, Exception -> 0x026e }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ NullPointerException -> 0x0276, UnsupportedEncodingException -> 0x0272, Exception -> 0x026e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NullPointerException -> 0x0276, UnsupportedEncodingException -> 0x0272, Exception -> 0x026e }
            r16 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.<init>()     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r8 = java.net.URLEncoder.encode(r8, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r8)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r10)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r8 = java.net.URLEncoder.encode(r12, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r8)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r9)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r7 = java.net.URLEncoder.encode(r7, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r7)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r10)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r7 = java.net.URLEncoder.encode(r14, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r7)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r9)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r6 = java.net.URLEncoder.encode(r6, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r6)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r10)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r6 = java.net.URLEncoder.encode(r15, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r6)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r9)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r5 = java.net.URLEncoder.encode(r5, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r5)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r10)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r3)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r9)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r3 = java.net.URLEncoder.encode(r4, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r3)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r10)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r1)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r9)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r1 = java.net.URLEncoder.encode(r2, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r1)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r10)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r11)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r13.append(r0)     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            java.lang.String r0 = r13.toString()     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            byte[] r0 = r0.getBytes()     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            net.one97.paytm.prime.activity.-$$Lambda$PrimeLoaderActivity$YQ2x0WUk5CYr0EFmxsmeeyjOgVw r1 = new net.one97.paytm.prime.activity.-$$Lambda$PrimeLoaderActivity$YQ2x0WUk5CYr0EFmxsmeeyjOgVw     // Catch:{ NullPointerException -> 0x0267, UnsupportedEncodingException -> 0x0261, Exception -> 0x025b }
            r2 = r18
            r3 = r16
            r1.<init>(r3, r0)     // Catch:{ NullPointerException -> 0x0258, UnsupportedEncodingException -> 0x0256, Exception -> 0x0254 }
            r2.runOnUiThread(r1)     // Catch:{ NullPointerException -> 0x0258, UnsupportedEncodingException -> 0x0256, Exception -> 0x0254 }
            goto L_0x035c
        L_0x0254:
            r0 = move-exception
            goto L_0x028e
        L_0x0256:
            r0 = move-exception
            goto L_0x0286
        L_0x0258:
            r0 = move-exception
            goto L_0x0322
        L_0x025b:
            r0 = move-exception
            r2 = r18
            r3 = r16
            goto L_0x028e
        L_0x0261:
            r0 = move-exception
            r2 = r18
            r3 = r16
            goto L_0x0286
        L_0x0267:
            r0 = move-exception
            r2 = r18
            r3 = r16
            goto L_0x0322
        L_0x026e:
            r0 = move-exception
            r2 = r18
            goto L_0x028d
        L_0x0272:
            r0 = move-exception
            r2 = r18
            goto L_0x0285
        L_0x0276:
            r0 = move-exception
            r2 = r18
            goto L_0x0321
        L_0x027b:
            r0 = move-exception
            r2 = r1
            goto L_0x028d
        L_0x027e:
            r0 = move-exception
            r2 = r1
            goto L_0x0285
        L_0x0281:
            r0 = move-exception
            r2 = r1
            r17 = r3
        L_0x0285:
            r3 = r13
        L_0x0286:
            r5 = r17
            goto L_0x02da
        L_0x0289:
            r0 = move-exception
            r2 = r1
            r17 = r3
        L_0x028d:
            r3 = r13
        L_0x028e:
            android.content.res.Resources r1 = r18.getResources()     // Catch:{ Exception -> 0x0351 }
            int r4 = net.one97.paytm.prime.R.string.error     // Catch:{ Exception -> 0x0351 }
            java.lang.String r1 = r1.getString(r4)     // Catch:{ Exception -> 0x0351 }
            android.content.res.Resources r4 = r18.getResources()     // Catch:{ Exception -> 0x0351 }
            int r5 = net.one97.paytm.prime.R.string.some_went_wrong     // Catch:{ Exception -> 0x0351 }
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0351 }
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x0351 }
            com.google.firebase.crashlytics.c r1 = com.google.firebase.crashlytics.c.a()     // Catch:{ Exception -> 0x0351 }
            r1.a((java.lang.Throwable) r0)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r1 = "Generic Exception  :- "
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0351 }
            r4.<init>()     // Catch:{ Exception -> 0x0351 }
            java.lang.String r5 = r0.getMessage()     // Catch:{ Exception -> 0x0351 }
            r4.append(r5)     // Catch:{ Exception -> 0x0351 }
            r5 = r17
            r4.append(r5)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0351 }
            r4.append(r3)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0351 }
            net.one97.paytm.common.utility.l.a(r1, r3)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0351 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x0351 }
            goto L_0x035c
        L_0x02d6:
            r0 = move-exception
            r2 = r1
            r5 = r3
            r3 = r13
        L_0x02da:
            android.content.res.Resources r1 = r18.getResources()     // Catch:{ Exception -> 0x0351 }
            int r4 = net.one97.paytm.prime.R.string.pg_error_heading     // Catch:{ Exception -> 0x0351 }
            java.lang.String r1 = r1.getString(r4)     // Catch:{ Exception -> 0x0351 }
            android.content.res.Resources r4 = r18.getResources()     // Catch:{ Exception -> 0x0351 }
            int r6 = net.one97.paytm.prime.R.string.pg_encoding_exception     // Catch:{ Exception -> 0x0351 }
            java.lang.String r4 = r4.getString(r6)     // Catch:{ Exception -> 0x0351 }
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x0351 }
            com.google.firebase.crashlytics.c r1 = com.google.firebase.crashlytics.c.a()     // Catch:{ Exception -> 0x0351 }
            r1.a((java.lang.Throwable) r0)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r1 = "UnsupportedEncodingException :- "
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0351 }
            r4.<init>()     // Catch:{ Exception -> 0x0351 }
            java.lang.String r6 = r0.getMessage()     // Catch:{ Exception -> 0x0351 }
            r4.append(r6)     // Catch:{ Exception -> 0x0351 }
            r4.append(r5)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0351 }
            r4.append(r3)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0351 }
            net.one97.paytm.common.utility.l.a(r1, r3)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0351 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x0351 }
            goto L_0x035c
        L_0x031f:
            r0 = move-exception
            r2 = r1
        L_0x0321:
            r3 = r13
        L_0x0322:
            android.content.res.Resources r1 = r18.getResources()     // Catch:{ Exception -> 0x0351 }
            int r4 = net.one97.paytm.prime.R.string.pg_error_cart_heading     // Catch:{ Exception -> 0x0351 }
            java.lang.String r1 = r1.getString(r4)     // Catch:{ Exception -> 0x0351 }
            android.content.res.Resources r4 = r18.getResources()     // Catch:{ Exception -> 0x0351 }
            int r5 = net.one97.paytm.prime.R.string.pg_encoding_cart_exception     // Catch:{ Exception -> 0x0351 }
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0351 }
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x0351 }
            com.google.firebase.crashlytics.c r1 = com.google.firebase.crashlytics.c.a()     // Catch:{ Exception -> 0x0351 }
            r1.a((java.lang.Throwable) r0)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r1 = "Cart Response :- "
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0351 }
            net.one97.paytm.common.utility.l.a(r1, r3)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0351 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x0351 }
            goto L_0x035c
        L_0x0351:
            r0 = move-exception
            goto L_0x0355
        L_0x0353:
            r0 = move-exception
            r2 = r1
        L_0x0355:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x035c:
            net.one97.paytm.prime.c.a r0 = r2.f59737a
            android.webkit.WebView r0 = r0.f59749d
            if (r0 == 0) goto L_0x0373
            net.one97.paytm.prime.c.a r0 = r2.f59737a
            android.webkit.WebView r0 = r0.f59749d
            r1 = 1
            r0.clearCache(r1)
            net.one97.paytm.prime.c.a r0 = r2.f59737a
            android.webkit.WebView r0 = r0.f59749d
            r0.clearHistory()
            goto L_0x0373
        L_0x0372:
            r2 = r1
        L_0x0373:
            return
        L_0x0374:
            r2 = r1
            goto L_0x0380
        L_0x0376:
            r2 = r1
            net.one97.paytm.prime.c.a r0 = r2.f59737a
            android.view.View r0 = r0.f59746a
            r1 = 8
            r0.setVisibility(r1)
        L_0x0380:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.prime.activity.PrimeLoaderActivity.onCreate(android.os.Bundle):void");
    }

    public void onStop() {
        super.onStop();
        b();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    public void onResume() {
        super.onResume();
    }

    private void b() {
        if (!isFinishing()) {
            net.one97.paytm.common.widgets.a.c(this.f59737a.f59748c);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.f59737a.f59750e.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public final void a() {
        b();
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        CJROrderSummary cJROrderSummary;
        CJROrderedCart cJROrderedCart;
        b();
        if ((iJRPaytmDataModel instanceof CJROrderSummary) && (cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel) != null) {
            if ("success".equalsIgnoreCase(cJROrderSummary.getPaymentStatus())) {
                if (cJROrderSummary.getOrderedCartList() != null) {
                    Iterator<CJROrderedCart> it2 = cJROrderSummary.getOrderedCartList().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        cJROrderedCart = it2.next();
                        if (cJROrderedCart.getProductDetail().getVertical().equalsIgnoreCase("Paytm Prime")) {
                            break;
                        }
                    }
                }
                cJROrderedCart = null;
                if (cJROrderedCart != null && (cJROrderedCart.getItemStatus().equalsIgnoreCase("success") || cJROrderedCart.getItemStatus().equalsIgnoreCase("delivered") || cJROrderedCart.getItemStatus().equalsIgnoreCase("delivered and gratified") || cJROrderedCart.getStatus().equalsIgnoreCase("210") || cJROrderedCart.getItemStatus().equalsIgnoreCase("210") || cJROrderedCart.getItemStatus().equalsIgnoreCase("7") || cJROrderedCart.getItemStatus().equalsIgnoreCase("20"))) {
                    a(b.a.SUCCESS, cJROrderSummary);
                    String str = "";
                    String orderId = cJROrderSummary.getPaymentInfo().get(0).getOrderId() != null ? cJROrderSummary.getPaymentInfo().get(0).getOrderId() : str;
                    if (cJROrderSummary.getPaymentInfo().get(0).getBankTransactionId() != null) {
                        str = cJROrderSummary.getPaymentInfo().get(0).getBankTransactionId();
                    }
                    a(net.one97.paytm.prime.f.b.f59792d, "first_successful_membership", "Paytm First", "plan_750", orderId, str, this, "/prime/offers");
                } else if (cJROrderedCart == null || (!cJROrderedCart.getStatus().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE) && !cJROrderedCart.getStatus().equalsIgnoreCase("failed"))) {
                    a(b.a.PENDING, cJROrderSummary);
                } else {
                    a(b.a.FAILURE, cJROrderSummary);
                }
            } else if (SDKConstants.GA_NATIVE_FAILED.equalsIgnoreCase(cJROrderSummary.getPaymentStatus()) || "Failure".equalsIgnoreCase(cJROrderSummary.getPaymentStatus())) {
                a(b.a.FAILURE, cJROrderSummary);
            } else {
                a(b.a.PENDING, cJROrderSummary);
            }
        }
        try {
            if (this.f59738b != null && this.f59738b.isShowing() && !isFinishing()) {
                this.f59738b.dismiss();
                this.f59738b = null;
            }
        } catch (Exception e2) {
            c.a().a((Throwable) e2);
        }
    }

    public final void a(b.a aVar, CJROrderSummary cJROrderSummary) {
        if (aVar.equals(b.a.SUCCESS)) {
            String str = "";
            String orderId = cJROrderSummary.getPaymentInfo().get(0).getOrderId() != null ? cJROrderSummary.getPaymentInfo().get(0).getOrderId() : str;
            if (cJROrderSummary.getPaymentInfo().get(0).getBankTransactionId() != null) {
                str = cJROrderSummary.getPaymentInfo().get(0).getBankTransactionId();
            }
            a(net.one97.paytm.prime.f.b.f59792d, "first_successful_membership", "Paytm First", "plan_750", str, orderId, this, "/prime/offers");
            net.one97.paytm.prime.b.a.a().c(this);
            b(cJROrderSummary);
            Intent intent = new Intent();
            intent.setClassName(this, "net.one97.paytm.landingpage.activity.AJRMainActivity");
            intent.setFlags(67108864);
            Intent intent2 = new Intent();
            intent2.setClassName(this, "paytm_first.PaytmFirstInitActivity");
            startActivities(new Intent[]{intent, intent2});
            finish();
        } else if (aVar.equals(b.a.FAILURE)) {
            a(cJROrderSummary);
        } else if (aVar.equals(b.a.PENDING)) {
            c(cJROrderSummary);
        }
    }

    private void a(CJROrderSummary cJROrderSummary) {
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            net.one97.paytm.prime.d.b bVar = new net.one97.paytm.prime.d.b();
            Bundle bundle = new Bundle();
            bundle.putSerializable(net.one97.paytm.prime.f.b.f59790b, cJROrderSummary);
            bVar.setArguments(bundle);
            supportFragmentManager.a().b(R.id.prime_container_new, bVar, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE).c();
        }
    }

    private void b(CJROrderSummary cJROrderSummary) {
        CJROrderSummaryPayment cJROrderSummaryPayment;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            Iterator<CJROrderedCart> it2 = cJROrderSummary.getOrderedCartList().iterator();
            while (it2.hasNext()) {
                CJROrderedCart next = it2.next();
                if (!(next == null || next.getProductDetail() == null || TextUtils.isEmpty(next.getProductDetail().getName()))) {
                    String str = "Subscription";
                    if (!str.equalsIgnoreCase(next.getProductDetail().getName())) {
                        double price = next.getProductDetail().getPrice();
                        if (price > 1.0d) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("af_order_id", cJROrderSummary.getId());
                            hashMap.put("af_item_id", String.valueOf(next.getId()));
                            Map map = (Map) next.getMetaDataResponse();
                            if (map != null && map.containsKey("plan_id")) {
                                hashMap.put("af_plan_id", map.get("plan_id"));
                            }
                            hashMap.put(AFInAppEventParameterName.PRICE, String.valueOf(price));
                            hashMap.put("af_plan_name", next.getProductDetail().getName());
                            if (cJROrderSummary.getOrderedCartList().size() != 2) {
                                str = "One time";
                            }
                            hashMap.put("af_purchase_type", str);
                            hashMap.put("af_customer_id", cJROrderSummary.getCustomerId());
                            if (cJROrderSummary.getPaymentInfo() != null && cJROrderSummary.getPaymentInfo().size() > 0 && (cJROrderSummaryPayment = cJROrderSummary.getPaymentInfo().get(0)) != null && !TextUtils.isEmpty(cJROrderSummaryPayment.getMID())) {
                                hashMap.put("af_paytm_first_mid", cJROrderSummaryPayment.getMID());
                                net.one97.paytm.prime.b.a.a().a((Context) this, "af_paytmfirst_purchase", (Map<String, String>) hashMap);
                            }
                        }
                    }
                }
            }
        }
    }

    private void c(CJROrderSummary cJROrderSummary) {
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            net.one97.paytm.prime.d.c cVar = new net.one97.paytm.prime.d.c();
            Bundle bundle = new Bundle();
            bundle.putSerializable(net.one97.paytm.prime.f.b.f59790b, cJROrderSummary);
            cVar.setArguments(bundle);
            supportFragmentManager.a().b(R.id.prime_container_new, cVar, SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING).c();
        }
    }

    private static void a(String str, String str2, String str3, String str4, String str5, String str6, Context context, String str7) {
        try {
            net.one97.paytm.prime.b.a.a().a(context, str, str2, str3, str4, str5, str6, str7, net.one97.paytm.prime.f.b.f59792d);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, byte[] bArr) {
        try {
            this.f59737a.f59749d.postUrl((String) new JSONObject(str).get(CJRPGTransactionRequestUtils.PG_PAGE_URL), bArr);
        } catch (NullPointerException e2) {
            com.paytm.utility.b.b((Context) this, "Error, URL is empty/null", "Some error occurred while getting URL");
            c.a().a((Throwable) e2);
            l.a("Cart Response :- ", str.toString());
            e2.printStackTrace();
        } catch (Exception e3) {
            com.paytm.utility.b.b((Context) this, "Invalid Response", "Some error occurred while creating your order");
            c.a().a((Throwable) e3);
            l.a("Post Url Exception :- ", e3.getMessage());
            e3.printStackTrace();
        }
    }
}
