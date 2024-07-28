package net.one97.paytm.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.util.UpiConstants;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f50366a = new r();

    private r() {
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        return p.a(deepLinkData.f50284b, "ins_order_summary", false);
    }

    public static boolean b(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        String str = deepLinkData.f50284b;
        if (str != null) {
            return str.equals("ins_order_summary");
        }
        return false;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        String str;
        String str2;
        int i2;
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        Uri uri = deepLinkData.f50289g;
        String str3 = null;
        if (uri != null) {
            str = uri.getQueryParameter("orderId");
        } else {
            str = null;
        }
        Uri uri2 = deepLinkData.f50289g;
        if (uri2 != null) {
            str2 = uri2.getQueryParameter("insurance_type");
        } else {
            str2 = null;
        }
        Uri uri3 = deepLinkData.f50289g;
        if (uri3 != null) {
            str3 = uri3.getQueryParameter("vertical_label");
        }
        Intent intent = new Intent();
        intent.putExtra("insurance_paytmfirst_h5_flow", true);
        intent.putExtra("order_id", str);
        if (str2 != null) {
            i2 = Integer.parseInt(str2);
        } else {
            i2 = 0;
        }
        intent.putExtra("insurance_type", i2);
        intent.putExtra("is_my_order_screen", true);
        intent.putExtra("show_home", false);
        intent.putExtra("vertical_label", str3);
        intent.putExtra(UpiConstants.FROM, "Order_history");
        q qVar = q.f50365a;
        q.a(context, intent);
    }
}
