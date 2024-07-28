package net.one97.paytm.insurance.b;

import f.a.a;
import f.a.b;

public final class d {
    public static void a(int i2) {
        a aVar = a.f13515a;
        a.a(Integer.valueOf(i2));
        a aVar2 = a.f13515a;
        b.a aVar3 = b.f13524a;
        a.a(b.a.a(Integer.valueOf(i2)));
    }

    public static void a(String str) {
        a aVar = a.f13515a;
        a.c(str);
    }

    public static void b(String str) {
        a aVar = a.f13515a;
        a.d(str);
    }

    public static void c(String str) {
        a aVar = a.f13515a;
        a.b(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(android.content.Context r7, java.lang.Boolean r8, java.lang.Boolean r9) {
        /*
            f.a.a r0 = f.a.a.f13515a
            java.lang.String r0 = f.a.a.b()
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r1) {
                case -1196055108: goto L_0x0045;
                case 106016069: goto L_0x003b;
                case 106016131: goto L_0x0031;
                case 1128214733: goto L_0x0027;
                case 1523927324: goto L_0x001d;
                case 1569159718: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x004f
        L_0x0013:
            java.lang.String r1 = "insurance_type_cycle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004f
            r0 = 3
            goto L_0x0050
        L_0x001d:
            java.lang.String r1 = "insurance_type_health"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004f
            r0 = 1
            goto L_0x0050
        L_0x0027:
            java.lang.String r1 = "insurance_type_new_vehicle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004f
            r0 = 4
            goto L_0x0050
        L_0x0031:
            java.lang.String r1 = "insurance_type_4w"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004f
            r0 = 2
            goto L_0x0050
        L_0x003b:
            java.lang.String r1 = "insurance_type_2w"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004f
            r0 = 5
            goto L_0x0050
        L_0x0045:
            java.lang.String r1 = "insurance_type_life"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004f
            r0 = 0
            goto L_0x0050
        L_0x004f:
            r0 = -1
        L_0x0050:
            if (r0 == 0) goto L_0x0072
            if (r0 == r6) goto L_0x0072
            if (r0 == r5) goto L_0x006a
            if (r0 == r4) goto L_0x006a
            if (r0 == r3) goto L_0x006a
            if (r0 == r2) goto L_0x006a
            android.content.Intent r0 = new android.content.Intent
            net.one97.paytm.insurance.a.a r1 = net.one97.paytm.insurance.b.c.a()
            java.lang.Class r1 = r1.getAJROrderSummaryActivityClass()
            r0.<init>(r7, r1)
            goto L_0x0086
        L_0x006a:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.InsuranceOrderSummary> r1 = net.one97.paytm.InsuranceOrderSummary.class
            r0.<init>(r7, r1)
            goto L_0x0086
        L_0x0072:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.InsurancePostPaymentActivity> r1 = net.one97.paytm.InsurancePostPaymentActivity.class
            r0.<init>(r7, r1)
            net.one97.paytm.insurance.a.a r7 = net.one97.paytm.insurance.b.c.a()
            java.lang.String r7 = r7.getOrderDetailUrl()
            java.lang.String r1 = "insurance_post_payment_url"
            r0.putExtra(r1, r7)
        L_0x0086:
            java.lang.String r7 = "IS_MY_ORDER_SCREEN"
            r0.putExtra(r7, r8)
            java.lang.String r7 = "IS_SHOW_HOME"
            r0.putExtra(r7, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.insurance.b.d.a(android.content.Context, java.lang.Boolean, java.lang.Boolean):android.content.Intent");
    }
}
