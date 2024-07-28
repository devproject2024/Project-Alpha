package com.google.firebase.crashlytics.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.crashlytics.a.b;
import com.google.firebase.iid.internal.a;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

public final class v implements w {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f38321b = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: c  reason: collision with root package name */
    private static final String f38322c = Pattern.quote("/");

    /* renamed from: a  reason: collision with root package name */
    public final String f38323a;

    /* renamed from: d  reason: collision with root package name */
    private final x f38324d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f38325e;

    /* renamed from: f  reason: collision with root package name */
    private final a f38326f;

    /* renamed from: g  reason: collision with root package name */
    private String f38327g;

    public v(Context context, String str, a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.f38325e = context;
            this.f38323a = str;
            this.f38326f = aVar;
            this.f38324d = new x();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        if (r8.f38327g == null) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String a() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = r8.f38327g     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0009
            java.lang.String r0 = r8.f38327g     // Catch:{ all -> 0x007c }
            monitor-exit(r8)
            return r0
        L_0x0009:
            android.content.Context r0 = r8.f38325e     // Catch:{ all -> 0x007c }
            android.content.SharedPreferences r0 = com.google.firebase.crashlytics.a.c.g.a((android.content.Context) r0)     // Catch:{ all -> 0x007c }
            com.google.firebase.iid.internal.a r1 = r8.f38326f     // Catch:{ all -> 0x007c }
            java.lang.String r1 = r1.a()     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "firebase.installation.id"
            r3 = 0
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x007c }
            r4 = 3
            if (r2 != 0) goto L_0x004d
            android.content.Context r2 = r8.f38325e     // Catch:{ all -> 0x007c }
            android.content.SharedPreferences r2 = com.google.firebase.crashlytics.a.c.g.b((android.content.Context) r2)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "crashlytics.installation.id"
            java.lang.String r3 = r2.getString(r5, r3)     // Catch:{ all -> 0x007c }
            com.google.firebase.crashlytics.a.b r5 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x007c }
            java.lang.String r6 = "No cached FID; legacy id is "
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x007c }
            r6.concat(r7)     // Catch:{ all -> 0x007c }
            r5.a(r4)     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x0044
            java.lang.String r0 = r8.a(r1, r0)     // Catch:{ all -> 0x007c }
            r8.f38327g = r0     // Catch:{ all -> 0x007c }
            goto L_0x0049
        L_0x0044:
            r8.f38327g = r3     // Catch:{ all -> 0x007c }
            r8.a(r3, r1, r0, r2)     // Catch:{ all -> 0x007c }
        L_0x0049:
            java.lang.String r0 = r8.f38327g     // Catch:{ all -> 0x007c }
            monitor-exit(r8)
            return r0
        L_0x004d:
            boolean r2 = r2.equals(r1)     // Catch:{ all -> 0x007c }
            if (r2 == 0) goto L_0x0072
            java.lang.String r2 = "crashlytics.installation.id"
            java.lang.String r2 = r0.getString(r2, r3)     // Catch:{ all -> 0x007c }
            r8.f38327g = r2     // Catch:{ all -> 0x007c }
            com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "Found matching FID, using Crashlytics IID: "
            r3.<init>(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = r8.f38327g     // Catch:{ all -> 0x007c }
            r3.append(r5)     // Catch:{ all -> 0x007c }
            r2.a(r4)     // Catch:{ all -> 0x007c }
            java.lang.String r2 = r8.f38327g     // Catch:{ all -> 0x007c }
            if (r2 != 0) goto L_0x0078
        L_0x0072:
            java.lang.String r0 = r8.a(r1, r0)     // Catch:{ all -> 0x007c }
            r8.f38327g = r0     // Catch:{ all -> 0x007c }
        L_0x0078:
            java.lang.String r0 = r8.f38327g     // Catch:{ all -> 0x007c }
            monitor-exit(r8)
            return r0
        L_0x007c:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.v.a():java.lang.String");
    }

    private synchronized void a(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        b a2 = b.a();
        "Migrating legacy Crashlytics IID: ".concat(String.valueOf(str));
        a2.a(3);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    private synchronized String a(String str, SharedPreferences sharedPreferences) {
        String str2;
        String uuid = UUID.randomUUID().toString();
        if (uuid == null) {
            str2 = null;
        } else {
            str2 = f38321b.matcher(uuid).replaceAll("").toLowerCase(Locale.US);
        }
        b a2 = b.a();
        "Created new Crashlytics IID: ".concat(String.valueOf(str2));
        a2.a(3);
        sharedPreferences.edit().putString("crashlytics.installation.id", str2).putString("firebase.installation.id", str).apply();
        return str2;
    }

    public static String a(String str) {
        return str.replaceAll(f38322c, "");
    }

    public final String b() {
        return this.f38324d.a(this.f38325e);
    }
}
