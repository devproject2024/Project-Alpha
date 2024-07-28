package net.one97.paytm.phoenix.core.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.R;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.c;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.n;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f59404a = new a();

    private a() {
    }

    public static final void a(WebView webView, String str) {
        k.c(webView, "webView");
        k.c(str, "javascript");
        if (str.length() > 0) {
            webView.post(new C1147a(webView, str));
        }
    }

    /* renamed from: net.one97.paytm.phoenix.core.web.a$a  reason: collision with other inner class name */
    static final class C1147a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f59405a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f59406b;

        C1147a(WebView webView, String str) {
            this.f59405a = webView;
            this.f59406b = str;
        }

        public final void run() {
            WebView webView = this.f59405a;
            webView.loadUrl("javascript:" + this.f59406b);
        }
    }

    public static final boolean a(WebView webView) {
        k.c(webView, "webView");
        Context context = webView.getContext();
        k.a((Object) context, "webView.context");
        a(webView, n.a(context, R.raw.phoenix_core));
        b(webView);
        return true;
    }

    private static boolean b(WebView webView) {
        k.c(webView, "webView");
        Context context = webView.getContext();
        if (!(context instanceof PhoenixActivity)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        PhoenixActivity phoenixActivity = (PhoenixActivity) context;
        Intent intent = phoenixActivity.getIntent();
        k.a((Object) intent, "context.intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, extras.get(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        c cVar = phoenixActivity.f59604b;
        if (cVar == null) {
            k.a("service");
        }
        b a2 = cVar.a((Activity) context);
        if (a2 == null) {
            return true;
        }
        a2.a(jSONObject);
        return true;
    }
}
