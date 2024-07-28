package net.one97.paytm.passbook.mlv.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1111a f58098a = new C1111a((byte) 0);

    /* renamed from: net.one97.paytm.passbook.mlv.d.a$a  reason: collision with other inner class name */
    public static final class C1111a {
        private C1111a() {
        }

        public /* synthetic */ C1111a(byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
            r1 = r3.getMerchantLogoInfo();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String a(net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r3) {
            /*
                r0 = 0
                if (r3 == 0) goto L_0x000e
                net.one97.paytm.passbook.beans.mlv.MerchantLogoInfo r1 = r3.getMerchantLogoInfo()
                if (r1 == 0) goto L_0x000e
                java.lang.String r1 = r1.getMerchantDisplayName()
                goto L_0x000f
            L_0x000e:
                r1 = r0
            L_0x000f:
                r2 = r1
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x0019
                return r1
            L_0x0019:
                if (r3 == 0) goto L_0x0020
                java.lang.String r3 = r3.getName()
                return r3
            L_0x0020:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mlv.d.a.C1111a.a(net.one97.paytm.passbook.beans.mlv.MLVCardTemplate):java.lang.String");
        }
    }
}
