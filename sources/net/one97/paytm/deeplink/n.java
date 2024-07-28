package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f50361a = new n();

    private n() {
    }

    private static void a(Context context, Intent intent) {
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e7, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) "paytm-emi", false) != false) goto L_0x00e9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r7, net.one97.paytm.deeplink.DeepLinkData r8) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r1 = "deepLinkData"
            kotlin.g.b.k.c(r8, r1)
            kotlin.g.b.k.c(r7, r0)
            kotlin.g.b.k.c(r8, r1)
            java.lang.String r1 = r8.f50284b
            if (r1 != 0) goto L_0x0017
            kotlin.g.b.k.a()
        L_0x0017:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "gold"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 0
            boolean r3 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r4)
            r5 = 1
            if (r3 != 0) goto L_0x00e9
            java.lang.String r3 = r8.f50283a
            if (r3 != 0) goto L_0x002d
            kotlin.g.b.k.a()
        L_0x002d:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.CharSequence) r2, (boolean) r4)
            if (r2 == 0) goto L_0x0039
            goto L_0x00e9
        L_0x0039:
            java.lang.String r2 = "paytm-postpaid"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r4)
            if (r3 != 0) goto L_0x00e9
            java.lang.String r3 = r8.f50283a
            if (r3 != 0) goto L_0x004b
            kotlin.g.b.k.a()
        L_0x004b:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.CharSequence) r2, (boolean) r4)
            if (r2 == 0) goto L_0x0057
            goto L_0x00e9
        L_0x0057:
            java.lang.String r2 = "weexurl"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r4)
            if (r3 != 0) goto L_0x00e9
            java.lang.String r3 = r8.f50283a
            if (r3 != 0) goto L_0x006a
            kotlin.g.b.k.a()
        L_0x006a:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.CharSequence) r2, (boolean) r4)
            if (r2 == 0) goto L_0x0076
            goto L_0x00e9
        L_0x0076:
            java.lang.String r2 = "forex"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r4)
            if (r3 != 0) goto L_0x00e9
            java.lang.String r3 = r8.f50283a
            if (r3 != 0) goto L_0x0088
            kotlin.g.b.k.a()
        L_0x0088:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.CharSequence) r2, (boolean) r4)
            if (r2 == 0) goto L_0x0093
            goto L_0x00e9
        L_0x0093:
            java.lang.String r2 = "fs-cir"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r4)
            if (r3 != 0) goto L_0x00e9
            java.lang.String r3 = r8.f50283a
            if (r3 != 0) goto L_0x00a5
            kotlin.g.b.k.a()
        L_0x00a5:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r3 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.CharSequence) r6, (boolean) r4)
            if (r3 == 0) goto L_0x00b1
            goto L_0x00e9
        L_0x00b1:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (boolean) r4)
            if (r2 != 0) goto L_0x00e9
            java.lang.String r2 = r8.f50283a
            if (r2 != 0) goto L_0x00c0
            kotlin.g.b.k.a()
        L_0x00c0:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r3 = "personal-loan"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r3, (boolean) r4)
            if (r2 == 0) goto L_0x00cd
            goto L_0x00e9
        L_0x00cd:
            java.lang.String r2 = "paytm-emi"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r4)
            if (r1 != 0) goto L_0x00e9
            java.lang.String r1 = r8.f50283a
            if (r1 != 0) goto L_0x00df
            kotlin.g.b.k.a()
        L_0x00df:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (boolean) r4)
            if (r1 == 0) goto L_0x00ea
        L_0x00e9:
            r4 = 1
        L_0x00ea:
            if (r4 == 0) goto L_0x012e
            kotlin.g.b.k.c(r7, r0)
            net.one97.paytm.dynamicModule.DynamicModuleManager r0 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()
            java.lang.String r1 = "paytm_finance"
            boolean r0 = r0.isInstalled(r1)
            java.lang.String r2 = "net.one97.paytm.finance.FinanceInitActivity"
            java.lang.String r3 = "EXTRA_DEEP_LINK_DATA"
            if (r0 == 0) goto L_0x0110
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            android.os.Parcelable r8 = (android.os.Parcelable) r8
            r0.putExtra(r3, r8)
            r0.setClassName(r7, r2)
            a((android.content.Context) r7, (android.content.Intent) r0)     // Catch:{ Exception -> 0x010f }
        L_0x010f:
            return
        L_0x0110:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity> r4 = net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity.class
            r0.<init>(r7, r4)
            android.os.Parcelable r8 = (android.os.Parcelable) r8
            r0.putExtra(r3, r8)
            java.lang.String r8 = "EXTRA_DEEP_LINK_FLAG"
            r0.putExtra(r8, r5)
            java.lang.String r8 = net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY
            r0.putExtra(r8, r2)
            java.lang.String r8 = net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity.EXTRA_INIT_MODULE
            r0.putExtra(r8, r1)
            a((android.content.Context) r7, (android.content.Intent) r0)
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.n.a(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r0.equals("gold-sip") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (r0.equals("weexurl") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        if (r0.equals("personal-loan") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r0.equals("paytm-emi") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r0.equals("forex") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
        if (r0.equals("digital-gold") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006b, code lost:
        if (r0.equals("gold") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        if (r0.equals("Gold") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        if (r0.equals("gold-passbook") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        if (r0.equals("fs-cir") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if (r0.equals("gold-gift") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        if (r0.equals("paytm-postpaid") != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009d, code lost:
        kotlin.g.b.k.a((java.lang.Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        r2 = net.one97.paytm.j.c.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        if (r2 == null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b4, code lost:
        if (r2.size() <= 0) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b6, code lost:
        r2 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00be, code lost:
        if (r2.hasNext() == false) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c0, code lost:
        r6 = r2.next();
        r7 = r9.f50283a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (r7 != null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ca, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cd, code lost:
        if (r7 == null) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cf, code lost:
        r7 = r7.toLowerCase();
        kotlin.g.b.k.b(r7, "(this as java.lang.String).toLowerCase()");
        kotlin.g.b.k.a((java.lang.Object) r6, "deeplinkName");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e3, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r6, false) == false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00eb, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ec, code lost:
        r2 = r9.f50283a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ee, code lost:
        if (r2 != null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f0, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f3, code lost:
        if (r2 == null) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f5, code lost:
        r2 = r2.toLowerCase();
        kotlin.g.b.k.b(r2, "(this as java.lang.String).toLowerCase()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0106, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) com.paytmmall.clpartifact.utils.CLPConstants.DEFAULT_GRID_VIEW_TYPE, false) != false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0108, code lost:
        r9 = r9.f50283a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010a, code lost:
        if (r9 != null) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010c, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010f, code lost:
        if (r9 == null) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0111, code lost:
        r9 = r9.toLowerCase();
        kotlin.g.b.k.b(r9, "(this as java.lang.String).toLowerCase()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0122, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.CharSequence) "gold-referral", false) == false) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012a, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012b, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012c, code lost:
        if (r3 != false) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0135, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(net.one97.paytm.deeplink.DeepLinkData r9) {
        /*
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = r9.f50284b
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0136
            java.lang.String r0 = r9.f50283a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001c
            goto L_0x0136
        L_0x001c:
            java.lang.String r0 = r9.f50284b
            if (r0 != 0) goto L_0x0023
            kotlin.g.b.k.a()
        L_0x0023:
            int r2 = r0.hashCode()
            r3 = 1
            switch(r2) {
                case -1950470504: goto L_0x0092;
                case -1332001155: goto L_0x0089;
                case -1267149876: goto L_0x0080;
                case -495870649: goto L_0x0077;
                case 2225280: goto L_0x006e;
                case 3178592: goto L_0x0065;
                case 84591349: goto L_0x005c;
                case 97618748: goto L_0x0053;
                case 119323157: goto L_0x004a;
                case 534816861: goto L_0x0041;
                case 1227266510: goto L_0x0037;
                case 2035253741: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x009c
        L_0x002d:
            java.lang.String r2 = "gold-sip"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x0037:
            java.lang.String r2 = "weexurl"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x0041:
            java.lang.String r2 = "personal-loan"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x004a:
            java.lang.String r2 = "paytm-emi"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x0053:
            java.lang.String r2 = "forex"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x005c:
            java.lang.String r2 = "digital-gold"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x0065:
            java.lang.String r2 = "gold"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x006e:
            java.lang.String r2 = "Gold"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x0077:
            java.lang.String r2 = "gold-passbook"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x0080:
            java.lang.String r2 = "fs-cir"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x0089:
            java.lang.String r2 = "gold-gift"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
            goto L_0x009a
        L_0x0092:
            java.lang.String r2 = "paytm-postpaid"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009c
        L_0x009a:
            r0 = 1
            goto L_0x009d
        L_0x009c:
            r0 = 0
        L_0x009d:
            net.one97.paytm.j.c r2 = net.one97.paytm.j.c.a()
            java.lang.String r4 = "GTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.util.List r2 = net.one97.paytm.j.c.n()
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r5 = "(this as java.lang.String).toLowerCase()"
            if (r2 == 0) goto L_0x00ec
            int r6 = r2.size()
            if (r6 <= 0) goto L_0x00ec
            java.util.Iterator r2 = r2.iterator()
        L_0x00ba:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x012c
            java.lang.Object r6 = r2.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = r9.f50283a
            if (r7 != 0) goto L_0x00cd
            kotlin.g.b.k.a()
        L_0x00cd:
            if (r7 == 0) goto L_0x00e6
            java.lang.String r7 = r7.toLowerCase()
            kotlin.g.b.k.b(r7, r5)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r8 = "deeplinkName"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r6, false)
            if (r6 == 0) goto L_0x00ba
            goto L_0x012b
        L_0x00e6:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r4)
            throw r9
        L_0x00ec:
            java.lang.String r2 = r9.f50283a
            if (r2 != 0) goto L_0x00f3
            kotlin.g.b.k.a()
        L_0x00f3:
            if (r2 == 0) goto L_0x0130
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.b(r2, r5)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r6 = "grid"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r6, false)
            if (r2 != 0) goto L_0x012b
            java.lang.String r9 = r9.f50283a
            if (r9 != 0) goto L_0x010f
            kotlin.g.b.k.a()
        L_0x010f:
            if (r9 == 0) goto L_0x0125
            java.lang.String r9 = r9.toLowerCase()
            kotlin.g.b.k.b(r9, r5)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r2 = "gold-referral"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r9 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.CharSequence) r2, false)
            if (r9 == 0) goto L_0x012c
            goto L_0x012b
        L_0x0125:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r4)
            throw r9
        L_0x012b:
            r3 = 0
        L_0x012c:
            if (r3 != 0) goto L_0x012f
            return r1
        L_0x012f:
            return r0
        L_0x0130:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r4)
            throw r9
        L_0x0136:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.n.a(net.one97.paytm.deeplink.DeepLinkData):boolean");
    }
}
