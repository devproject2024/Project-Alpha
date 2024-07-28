package com.alipay.imobile.network.quake.i;

public final class c {
    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            String str2 = com.alipay.imobile.network.quake.c.f14737a;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" not found.");
            com.alipay.iap.android.common.b.c.c();
            return null;
        }
    }
}
