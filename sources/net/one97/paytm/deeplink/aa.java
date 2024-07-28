package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.AJRRechargePaymentActivity;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    public static final aa f50292a = new aa();

    private aa() {
    }

    public static void a(Context context, Uri uri) {
        k.c(context, "context");
        k.c(uri, "uri");
        a(context, uri, true);
    }

    private static void a(Context context, Uri uri, boolean z) {
        k.c(context, "context");
        k.c(uri, "uri");
        String queryParameter = uri.getQueryParameter("txnToken");
        String queryParameter2 = uri.getQueryParameter("orderId");
        String queryParameter3 = uri.getQueryParameter("mid");
        String queryParameter4 = uri.getQueryParameter("amount");
        String uri2 = uri.toString();
        k.a((Object) uri2, "uri.toString()");
        String host = uri.getHost();
        if (p.a((CharSequence) uri2, (CharSequence) "appInvokeDevice", false) || !z) {
            uri.getQueryParameter("appInvokeDevice");
            a(queryParameter, queryParameter2, queryParameter3, queryParameter4, host, context, z);
            return;
        }
        Intent intent = new Intent(context, AJRRechargePaymentActivity.class);
        intent.putExtra("nativeSdkEnabled", true);
        intent.putExtra("enable_paytm_invoke", true);
        intent.putExtra("orderid", queryParameter2);
        intent.putExtra("paytm_invoke", true);
        intent.putExtra("mid", queryParameter3);
        intent.putExtra("mWebInvoke", z);
        intent.putExtra("price", queryParameter4);
        intent.putExtra("txnToken", queryParameter);
        intent.putExtra("hostName", host);
        new Timer().schedule(new a(context, intent), 150);
    }

    private static void a(String str, String str2, String str3, String str4, String str5, Context context, boolean z) {
        Intent intent = new Intent(context, AJRRechargePaymentActivity.class);
        intent.putExtra("nativeSdkEnabled", true);
        intent.putExtra("enable_paytm_invoke", true);
        intent.putExtra("orderid", str2);
        intent.putExtra("mid", str3);
        intent.putExtra("mWebInvoke", z);
        intent.putExtra("price", str4);
        intent.putExtra("txnToken", str);
        intent.putExtra("hostName", str5);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 112);
        } else {
            context.startActivity(intent);
        }
    }

    public static final class a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f50293a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Intent f50294b;

        public a(Context context, Intent intent) {
            this.f50293a = context;
            this.f50294b = intent;
        }

        public final void run() {
            Context context = this.f50293a;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(this.f50294b, 112);
            } else {
                context.startActivity(this.f50294b);
            }
        }
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        String str = deepLinkData.f50284b;
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            return false;
        }
        if (str != null) {
            String lowerCase = str.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            int hashCode = lowerCase.hashCode();
            if (hashCode != 876697406) {
                if (hashCode == 1562496585 && lowerCase.equals("subscriptionpayment")) {
                    return true;
                }
            } else if (lowerCase.equals("merchantpayment")) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        String str;
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        Uri parse = Uri.parse(deepLinkData.f50283a);
        String str2 = deepLinkData.f50284b;
        if (str2 == null) {
            str = null;
        } else if (str2 != null) {
            str = str2.toLowerCase();
            k.b(str, "(this as java.lang.String).toLowerCase()");
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 876697406) {
                if (hashCode != 1562496585 || !str.equals("subscriptionpayment")) {
                    return;
                }
            } else if (!str.equals("merchantpayment")) {
                return;
            }
            k.a((Object) parse, "uri");
            k.c(context, "context");
            k.c(parse, "uri");
            a(context, parse, false);
        }
    }
}
