package com.paytm.ads.c;

import android.content.Context;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f40881a;

    /* renamed from: b  reason: collision with root package name */
    public int f40882b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f40883c;

    /* renamed from: d  reason: collision with root package name */
    public final String f40884d;

    /* renamed from: e  reason: collision with root package name */
    public final String f40885e;

    /* renamed from: f  reason: collision with root package name */
    private final String f40886f = "omsdk_v2.js";

    public a(Context context, String str, String str2) {
        k.c(str, "partnerName");
        k.c(str2, "version");
        this.f40883c = context;
        this.f40884d = str;
        this.f40885e = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        kotlin.f.a.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.io.InputStream r6) {
        /*
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x002d }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x002d }
            java.nio.charset.Charset r2 = kotlin.m.d.f47971a     // Catch:{ all -> 0x002d }
            r1.<init>(r6, r2)     // Catch:{ all -> 0x002d }
            r0.<init>(r1)     // Catch:{ all -> 0x002d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r1.<init>()     // Catch:{ all -> 0x002d }
            r2 = 8192(0x2000, float:1.14794E-41)
            char[] r3 = new char[r2]     // Catch:{ all -> 0x002d }
            r4 = 0
            int r5 = r0.read(r3, r4, r2)     // Catch:{ all -> 0x002d }
        L_0x001a:
            if (r5 <= 0) goto L_0x0024
            r1.append(r3, r4, r5)     // Catch:{ all -> 0x002d }
            int r5 = r0.read(r3, r4, r2)     // Catch:{ all -> 0x002d }
            goto L_0x001a
        L_0x0024:
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x002d }
            r1 = 0
            kotlin.f.a.a(r6, r1)
            return r0
        L_0x002d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            kotlin.f.a.a(r6, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.ads.c.a.a(java.io.InputStream):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0005, code lost:
        r1 = r1.getAssets();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r3 = this;
            r0 = 1
            android.content.Context r1 = r3.f40883c     // Catch:{ IOException -> 0x001f }
            if (r1 == 0) goto L_0x0012
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ IOException -> 0x001f }
            if (r1 == 0) goto L_0x0012
            java.lang.String r2 = r3.f40886f     // Catch:{ IOException -> 0x001f }
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ IOException -> 0x001f }
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            java.lang.String r1 = a(r1)     // Catch:{ IOException -> 0x001f }
            r3.f40881a = r1     // Catch:{ IOException -> 0x001f }
            int r1 = r3.f40882b     // Catch:{ IOException -> 0x001f }
            int r1 = r1 + r0
            r3.f40882b = r1     // Catch:{ IOException -> 0x001f }
            return r0
        L_0x001f:
            int r1 = r3.f40882b
            int r1 = r1 + r0
            r3.f40882b = r1
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.ads.c.a.a():boolean");
    }
}
