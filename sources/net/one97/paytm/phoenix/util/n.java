package net.one97.paytm.phoenix.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import kotlin.g.b.k;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f59650a = new n();

    /* renamed from: b  reason: collision with root package name */
    private static final SparseArray<String> f59651b = new SparseArray<>();

    private n() {
    }

    public static final synchronized String a(Context context, int i2) {
        String str;
        synchronized (n.class) {
            k.c(context, "context");
            if (f59651b.get(i2) == null) {
                Resources resources = context.getResources();
                k.a((Object) resources, "context.resources");
                f59651b.put(i2, a(resources, i2));
            }
            String str2 = f59651b.get(i2);
            k.a((Object) str2, "resMap[resId]");
            str = str2;
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        kotlin.f.a.a(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String a(android.content.res.Resources r2, int r3) {
        /*
            java.io.InputStream r2 = r2.openRawResource(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x0036 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x0036 }
            r0.<init>(r3)     // Catch:{ all -> 0x0036 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0036 }
            java.io.Reader r0 = (java.io.Reader) r0     // Catch:{ all -> 0x0036 }
            r3.<init>(r0)     // Catch:{ all -> 0x0036 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r0.<init>()     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x0036 }
        L_0x001e:
            if (r1 == 0) goto L_0x002d
            r0.append(r1)     // Catch:{ all -> 0x0036 }
            r1 = 10
            r0.append(r1)     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x0036 }
            goto L_0x001e
        L_0x002d:
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0036 }
            r0 = 0
            kotlin.f.a.a(r2, r0)
            return r3
        L_0x0036:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            kotlin.f.a.a(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.util.n.a(android.content.res.Resources, int):java.lang.String");
    }
}
