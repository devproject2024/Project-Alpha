package com.google.zxing.client.a;

import java.util.regex.Pattern;

public final class ac extends q {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f39998b = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* renamed from: a  reason: collision with root package name */
    public final String f39999a;

    /* renamed from: c  reason: collision with root package name */
    private final String f40000c;

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        if (com.google.zxing.client.a.u.a(r3, r0, (r1 < 0 ? r3.length() : r1) - r0) != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ac(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            com.google.zxing.client.a.r r0 = com.google.zxing.client.a.r.URI
            r2.<init>(r0)
            java.lang.String r3 = r3.trim()
            r0 = 58
            int r0 = r3.indexOf(r0)
            if (r0 < 0) goto L_0x0026
            int r0 = r0 + 1
            r1 = 47
            int r1 = r3.indexOf(r1, r0)
            if (r1 >= 0) goto L_0x001f
            int r1 = r3.length()
        L_0x001f:
            int r1 = r1 - r0
            boolean r0 = com.google.zxing.client.a.u.a(r3, r0, r1)
            if (r0 == 0) goto L_0x0030
        L_0x0026:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r0 = "http://"
            java.lang.String r3 = r0.concat(r3)
        L_0x0030:
            r2.f39999a = r3
            r2.f40000c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.a.ac.<init>(java.lang.String, java.lang.String):void");
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(30);
        a(this.f40000c, sb);
        a(this.f39999a, sb);
        return sb.toString();
    }
}
