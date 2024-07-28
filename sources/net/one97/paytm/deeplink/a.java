package net.one97.paytm.deeplink;

import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50291a = new a();

    private a() {
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        return (UpiConstants.URL_TYPE_CASH_WALLET.equals(deepLinkData.f50284b) && DeepLinkConstant.ACCEPT_PAYMENT_AUTHORITY.equals(deepLinkData.f50288f)) || "accept_payment_onboarding".equals(deepLinkData.f50284b) || DeepLinkConstant.ACCEPT_PAYMENT_AUTHORITY.equals(deepLinkData.f50284b) || "wallet-acceptpayment".equals(deepLinkData.f50284b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r3, net.one97.paytm.deeplink.DeepLinkData r4) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r4, r0)
            android.os.Bundle r0 = r4.f50290h
            if (r0 != 0) goto L_0x0012
            android.net.Uri r0 = r4.f50289g
            if (r0 == 0) goto L_0x0077
        L_0x0012:
            java.lang.String r0 = r4.f50284b
            java.lang.String r1 = "accept_payment_onboarding"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = r4.f50284b
            java.lang.String r1 = "accept_money"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0058
        L_0x0026:
            java.lang.String r0 = com.paytm.utility.b.J((android.content.Context) r3)
            r1 = 1
            java.lang.String r2 = "SD_MERCHANT"
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r1)
            if (r0 != 0) goto L_0x0040
            java.lang.String r0 = com.paytm.utility.b.K((android.content.Context) r3)
            java.lang.String r2 = "merchant"
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r1)
            if (r0 != 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            if (r1 == 0) goto L_0x0058
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.acceptPayment.onBoarding.view.OnBoardingActivity> r1 = net.one97.paytm.acceptPayment.onBoarding.view.OnBoardingActivity.class
            r0.<init>(r3, r1)
            java.lang.String r1 = "KEY_SCREEN"
            java.lang.String r2 = "is_from_home"
            android.content.Intent r1 = r0.putExtra(r1, r2)
            java.lang.String r2 = "intent.putExtra(AcceptPa…amConstants.IS_FROM_HOME)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            goto L_0x005f
        L_0x0058:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity> r1 = net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity.class
            r0.<init>(r3, r1)
        L_0x005f:
            android.os.Bundle r1 = r4.f50290h
            if (r1 == 0) goto L_0x006d
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r0.addFlags(r1)
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r1)
        L_0x006d:
            android.os.Parcelable r4 = (android.os.Parcelable) r4
            java.lang.String r1 = "deeplinkdata"
            r0.putExtra(r1, r4)
            r3.startActivity(r0)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.a.a(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }
}
