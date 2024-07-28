package net.one97.paytm.deeplink;

import android.content.Context;
import android.content.Intent;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.impsRefund.view.RefundHomePageActivity;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f50306a = new ad();

    private ad() {
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (!p.a(deepLinkData.f50284b, "payment_settings", false) || !p.a(deepLinkData.f50288f, "bank_refund", true)) {
            return false;
        }
        return true;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, "payment_settings", false) && p.a(deepLinkData.f50288f, "bank_refund", true)) {
            k.c(context, "context");
            Intent intent = new Intent(context, RefundHomePageActivity.class);
            intent.setFlags(536870912);
            context.startActivity(intent);
        }
    }
}
