package net.one97.paytm.p2b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import net.one97.paytm.upi.util.UpiConstants;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f56880a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final String f56881b = f56881b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f56882c = f56882c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f56883d = f56883d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f56884e = f56884e;

    private c() {
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_CASH_WALLET, false)) {
            String str = deepLinkData.f50288f;
            if (p.a(str, "wallet_to_ppb", true) || p.a(str, "send_money_bank", false)) {
                return true;
            }
        }
        return false;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        String str;
        k.c(context, "context");
        if (deepLinkData != null) {
            Uri uri = deepLinkData.f50289g;
            String str2 = null;
            if (uri != null) {
                str = uri.getQueryParameter("amount");
            } else {
                str = null;
            }
            Uri uri2 = deepLinkData.f50289g;
            if (uri2 != null) {
                str2 = uri2.getQueryParameter("source");
            }
            Intent intent = new Intent(context, SendMoneyToBankActivity.class);
            intent.putExtra("uam_add_money", true);
            if (str2 != null) {
                intent.putExtra("key_source", str2);
            }
            if (str != null) {
                intent.putExtra("amount", str);
            }
            context.startActivity(intent);
        }
    }
}
