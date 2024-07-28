package com.alipay.imobile.network.quake.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.imobile.network.quake.c;
import com.alipay.imobile.network.quake.e;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14897a = false;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f14898a;

        /* renamed from: b  reason: collision with root package name */
        public String f14899b;

        public a() {
        }

        public a(String str, String str2) {
            this.f14898a = str;
            this.f14899b = str2;
        }
    }

    public static String a(Context context, a aVar, String str, String str2) {
        if (!f14897a || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (aVar == null || TextUtils.isEmpty(aVar.f14898a)) {
            String str3 = c.f14737a;
            com.alipay.iap.android.common.b.c.g();
            return "";
        } else if (context != null) {
            return a(context, aVar, g.b(str), str2);
        } else {
            throw new com.alipay.imobile.network.quake.c.a((Integer) 0, "the input context can not be null");
        }
    }

    public static String a(e eVar, Context context, a aVar) throws com.alipay.mobile.b.b.a {
        if (!f14897a) {
            return "";
        }
        if (eVar == null) {
            throw new com.alipay.imobile.network.quake.c.a((Integer) 0, "the input request can not be null");
        } else if (context == null) {
            throw new com.alipay.imobile.network.quake.c.a((Integer) 0, "the input context can not be null");
        } else if (aVar == null || TextUtils.isEmpty(aVar.f14898a)) {
            String str = c.f14737a;
            com.alipay.iap.android.common.b.c.g();
            return "";
        } else {
            byte[] a2 = eVar.b().a(eVar);
            if (a2 == null) {
                return "";
            }
            String d2 = eVar.d();
            String a3 = e.a();
            StringBuilder sb = new StringBuilder();
            String a4 = eVar.a();
            if (a4 == null) {
                String str2 = c.f14737a;
                "getSignData with null operationType and url is ".concat(String.valueOf(d2));
                com.alipay.iap.android.common.b.c.e();
            } else {
                sb.append("operationType=");
                sb.append(a4);
                sb.append(AppConstants.AND_SIGN);
            }
            sb.append("requestData=");
            sb.append(Base64.encodeToString(a2, 2));
            sb.append(AppConstants.AND_SIGN);
            sb.append("ts=");
            sb.append(a3);
            return a(context, aVar, g.b(d2), sb.toString());
        }
    }

    public static void a() {
        try {
            Class<?> cls = Class.forName("com.alibaba.wireless.security.b.c");
            Class<?> cls2 = Class.forName("com.alibaba.wireless.security.b.k.a");
            if (cls != null && cls2 != null) {
                f14897a = true;
            }
        } catch (Exception unused) {
            String str = c.f14737a;
            com.alipay.iap.android.common.b.c.g();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0070 A[Catch:{ all -> 0x00a0, Exception -> 0x00b7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r6, com.alipay.imobile.network.quake.i.b.a r7, boolean r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "appKey:"
            java.lang.String r1 = ""
            com.alibaba.wireless.security.b.c r2 = com.alibaba.wireless.security.b.c.a(r6)     // Catch:{ Exception -> 0x00b7 }
            if (r2 != 0) goto L_0x0010
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ Exception -> 0x00b7 }
            com.alipay.iap.android.common.b.c.g()     // Catch:{ Exception -> 0x00b7 }
            return r1
        L_0x0010:
            com.alibaba.wireless.security.b.a r2 = r2.a()     // Catch:{ Exception -> 0x00b7 }
            com.alibaba.wireless.security.b.k.a r2 = (com.alibaba.wireless.security.b.k.a) r2     // Catch:{ Exception -> 0x00b7 }
            if (r2 != 0) goto L_0x001e
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ Exception -> 0x00b7 }
            com.alipay.iap.android.common.b.c.g()     // Catch:{ Exception -> 0x00b7 }
            return r1
        L_0x001e:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x00b7 }
            r3.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r4 = "INPUT"
            r3.put(r4, r9)     // Catch:{ Exception -> 0x00b7 }
            com.alibaba.wireless.security.b.d r9 = new com.alibaba.wireless.security.b.d     // Catch:{ Exception -> 0x00b7 }
            r9.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r4 = r7.f14898a     // Catch:{ Exception -> 0x00b7 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00a0 }
            if (r5 != 0) goto L_0x004d
            r9.f14652b = r4     // Catch:{ all -> 0x00a0 }
            boolean r6 = com.alipay.imobile.network.quake.i.g.b((android.content.Context) r6)     // Catch:{ Exception -> 0x00b7 }
            if (r6 == 0) goto L_0x0067
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r8 = r9.f14652b     // Catch:{ Exception -> 0x00b7 }
        L_0x0046:
            r6.append(r8)     // Catch:{ Exception -> 0x00b7 }
            com.alipay.iap.android.common.b.c.b()     // Catch:{ Exception -> 0x00b7 }
            goto L_0x0067
        L_0x004d:
            if (r8 == 0) goto L_0x0054
            java.lang.String r8 = "rpc-sdk-online"
        L_0x0051:
            r9.f14652b = r8     // Catch:{ all -> 0x00a0 }
            goto L_0x0057
        L_0x0054:
            java.lang.String r8 = "rpc-sdk"
            goto L_0x0051
        L_0x0057:
            boolean r6 = com.alipay.imobile.network.quake.i.g.b((android.content.Context) r6)     // Catch:{ Exception -> 0x00b7 }
            if (r6 == 0) goto L_0x0067
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r8 = r9.f14652b     // Catch:{ Exception -> 0x00b7 }
            goto L_0x0046
        L_0x0067:
            r9.f14651a = r3     // Catch:{ Exception -> 0x00b7 }
            r6 = 4
            r9.f14653c = r6     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = r7.f14899b     // Catch:{ Exception -> 0x00b7 }
            if (r6 != 0) goto L_0x0071
            r6 = r1
        L_0x0071:
            java.lang.String r8 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r8 = "Before security sign. appKey = %s, authCode = %s"
            r9 = 2
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r3 = r7.f14898a     // Catch:{ Exception -> 0x00b7 }
            r4 = 0
            r0[r4] = r3     // Catch:{ Exception -> 0x00b7 }
            r3 = 1
            r0[r3] = r6     // Catch:{ Exception -> 0x00b7 }
            java.lang.String.format(r8, r0)     // Catch:{ Exception -> 0x00b7 }
            com.alipay.iap.android.common.b.c.b()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r8 = r2.a()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r0 = "Get security signed string: %s. appKey = %s, authCode = %s"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00b7 }
            r2[r4] = r8     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r7 = r7.f14898a     // Catch:{ Exception -> 0x00b7 }
            r2[r3] = r7     // Catch:{ Exception -> 0x00b7 }
            r2[r9] = r6     // Catch:{ Exception -> 0x00b7 }
            java.lang.String.format(r0, r2)     // Catch:{ Exception -> 0x00b7 }
            com.alipay.iap.android.common.b.c.b()     // Catch:{ Exception -> 0x00b7 }
            return r8
        L_0x00a0:
            r7 = move-exception
            boolean r6 = com.alipay.imobile.network.quake.i.g.b((android.content.Context) r6)     // Catch:{ Exception -> 0x00b7 }
            if (r6 == 0) goto L_0x00b6
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r8 = r9.f14652b     // Catch:{ Exception -> 0x00b7 }
            r6.append(r8)     // Catch:{ Exception -> 0x00b7 }
            com.alipay.iap.android.common.b.c.b()     // Catch:{ Exception -> 0x00b7 }
        L_0x00b6:
            throw r7     // Catch:{ Exception -> 0x00b7 }
        L_0x00b7:
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a
            com.alipay.iap.android.common.b.c.j()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.i.b.a(android.content.Context, com.alipay.imobile.network.quake.i.b$a, boolean, java.lang.String):java.lang.String");
    }
}
