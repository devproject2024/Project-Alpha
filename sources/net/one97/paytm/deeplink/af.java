package net.one97.paytm.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.AJROrderSummaryActivity;
import net.one97.paytm.payments.d.a;
import net.one97.paytm.upi.util.UpiConstants;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    public static final af f50311a = new af();

    private af() {
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        return p.a(deepLinkData.f50284b, "first_point_summary", false);
    }

    public static boolean b(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        String str = deepLinkData.f50284b;
        if (str != null) {
            return str.equals("first_point_summary");
        }
        return false;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        Uri uri = deepLinkData.f50289g;
        String str = null;
        String queryParameter = uri != null ? uri.getQueryParameter("deeplinkType") : null;
        if (queryParameter == null) {
            return;
        }
        if (queryParameter.equals("paytmfirst")) {
            Uri uri2 = deepLinkData.f50289g;
            if (uri2 != null) {
                str = uri2.getQueryParameter("orderId");
            }
            if (str != null) {
                Intent intent = new Intent(context, AJROrderSummaryActivity.class);
                intent.putExtra("order_id", str);
                intent.putExtra("is_my_order_screen", true);
                intent.putExtra("show_home", false);
                intent.putExtra(UpiConstants.FROM, "Order_history");
                context.startActivity(intent);
                return;
            }
            return;
        }
        Uri uri3 = deepLinkData.f50289g;
        if (uri3 != null) {
            str = uri3.getQueryParameter("orderId");
        }
        if (str == null) {
            return;
        }
        if (queryParameter.equals("pointgv")) {
            a.a(context, "paytmmp://wallet-addmoney?featuretype=gvTxnDetail&orderId=".concat(String.valueOf(str)));
            return;
        }
        Intent intent2 = new Intent(context, AJROrderSummaryActivity.class);
        intent2.putExtra("order_id", str);
        intent2.putExtra("is_my_order_screen", true);
        intent2.putExtra("show_home", false);
        intent2.putExtra(UpiConstants.FROM, "Order_history");
        context.startActivity(intent2);
    }
}
