package com.paytm.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.LinkedList;
import kotlin.g.b.k;
import kotlin.u;

public final class c extends WebView {

    /* renamed from: a  reason: collision with root package name */
    final LinkedList<String> f40879a = new LinkedList<>();

    public static final class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f40880a;

        a(c cVar) {
            this.f40880a = cVar;
        }

        public final void onPageFinished(WebView webView, String str) {
            k.c(webView, "view");
            k.c(str, "url");
            super.onPageFinished(webView, str);
            try {
                timber.log.a.a("[AdEvent]PaytmWebView: load url successful: ".concat(String.valueOf(str)), new Object[0]);
                this.f40880a.a();
            } catch (Exception e2) {
                this.f40880a.destroy();
                new StringBuilder(" couldn't load the url:  ").append(e2.getMessage());
            }
        }

        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            k.c(str, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            timber.log.a.a("[AdEvent]PaytmWebView: Failed load url: " + str2 + ". Error Code: " + i2 + ". Description: " + str + '.', new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ? error code ");
            sb.append(i2);
        }
    }

    public final void destroy() {
        try {
            super.destroy();
            timber.log.a.a("Paytm Web view destroyed", new Object[0]);
        } catch (Exception e2) {
            String.valueOf(e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        boolean z = true;
        String removeFirst = this.f40879a.isEmpty() ^ true ? this.f40879a.removeFirst() : null;
        Context context = getContext();
        k.a((Object) context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        k.c(this, "$this$isInternetAvailable");
        k.c(applicationContext, "context");
        Object systemService = applicationContext.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                z = false;
            }
            if (!z) {
                destroy();
                throw new Exception("No internet connectivity");
            } else if (removeFirst == null) {
                destroy();
            } else {
                loadUrl(removeFirst);
            }
        } else {
            throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        k.c(context, "appContext");
        try {
            setWebViewClient(new a(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
