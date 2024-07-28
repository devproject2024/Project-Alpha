package net.one97.paytm.acceptPayment.onBoarding.view;

import net.one97.paytm.acceptPayment.activities.BaseActivity;

public final class OnBoardingActivity extends BaseActivity {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001b, code lost:
        r2 = r5.f50289g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            android.content.Intent r5 = r4.getIntent()
            java.lang.String r0 = "KEY_SCREEN"
            r5.getStringExtra(r0)
            android.content.Intent r5 = r4.getIntent()
            java.lang.String r0 = "deeplinkdata"
            android.os.Parcelable r5 = r5.getParcelableExtra(r0)
            net.one97.paytm.deeplink.DeepLinkData r5 = (net.one97.paytm.deeplink.DeepLinkData) r5
            r1 = 0
            if (r5 == 0) goto L_0x0026
            android.net.Uri r2 = r5.f50289g
            if (r2 == 0) goto L_0x0026
            java.lang.String r3 = "pageId"
            java.lang.String r2 = r2.getQueryParameter(r3)
            goto L_0x0027
        L_0x0026:
            r2 = r1
        L_0x0027:
            java.lang.String r3 = "onboarding"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x003d
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity> r2 = net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity.class
            r1.<init>(r4, r2)
            r1.putExtra(r0, r5)
            r4.startActivity(r1)
            goto L_0x0052
        L_0x003d:
            java.lang.String r5 = net.one97.paytm.acceptPayment.utils.b.a((java.lang.String) r3, (java.lang.String) r1)
            net.one97.paytm.deeplink.DeepLinkData r5 = net.one97.paytm.acceptPayment.utils.b.a((java.lang.String) r5)
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity> r2 = net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity.class
            r1.<init>(r4, r2)
            r1.putExtra(r0, r5)
            r4.startActivity(r1)
        L_0x0052:
            r4.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.onBoarding.view.OnBoardingActivity.onCreate(android.os.Bundle):void");
    }
}
