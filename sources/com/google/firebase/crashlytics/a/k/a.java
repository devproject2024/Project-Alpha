package com.google.firebase.crashlytics.a.k;

import android.content.Context;
import com.google.firebase.crashlytics.a.g.i;
import java.io.File;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38651a;

    public a(Context context) {
        this.f38651a = context;
    }

    /* access modifiers changed from: package-private */
    public final File a() {
        return new File(new i(this.f38651a).a(), "com.crashlytics.settings.json");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.google.firebase.crashlytics.a.b.a().a(6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        r4 = r1;
        r1 = r0;
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject b() {
        /*
            r5 = this;
            com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()
            r1 = 3
            r0.a(r1)
            r0 = 0
            java.io.File r2 = r5.a()     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            if (r3 == 0) goto L_0x0023
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            java.lang.String r2 = com.google.firebase.crashlytics.a.c.g.a((java.io.InputStream) r1)     // Catch:{ Exception -> 0x0033 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0033 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0033 }
            r0 = r1
            goto L_0x002b
        L_0x0023:
            com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            r2.a(r1)     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            r3 = r0
        L_0x002b:
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r0)
            r0 = r3
            goto L_0x003e
        L_0x0030:
            r1 = move-exception
            goto L_0x0043
        L_0x0032:
            r1 = r0
        L_0x0033:
            com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x003f }
            r3 = 6
            r2.a(r3)     // Catch:{ all -> 0x003f }
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r1)
        L_0x003e:
            return r0
        L_0x003f:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0043:
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.k.a.b():org.json.JSONObject");
    }
}
