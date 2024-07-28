package com.google.android.gms.internal.icing;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import androidx.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o implements r {

    /* renamed from: a  reason: collision with root package name */
    static final Map<Uri, o> f10265a = new a();

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f10266g = {"key", "value"};

    /* renamed from: b  reason: collision with root package name */
    final Object f10267b = new Object();

    /* renamed from: c  reason: collision with root package name */
    volatile Map<String, String> f10268c;

    /* renamed from: d  reason: collision with root package name */
    final List<Object> f10269d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f10270e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f10271f;

    private o(ContentResolver contentResolver, Uri uri) {
        this.f10270e = contentResolver;
        this.f10271f = uri;
        this.f10270e.registerContentObserver(uri, false, new p(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.icing.o a(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.icing.o> r0 = com.google.android.gms.internal.icing.o.class
            monitor-enter(r0)
            java.util.Map<android.net.Uri, com.google.android.gms.internal.icing.o> r1 = f10265a     // Catch:{ all -> 0x001a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.icing.o r1 = (com.google.android.gms.internal.icing.o) r1     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.internal.icing.o r2 = new com.google.android.gms.internal.icing.o     // Catch:{ SecurityException -> 0x0018 }
            r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x0018 }
            java.util.Map<android.net.Uri, com.google.android.gms.internal.icing.o> r3 = f10265a     // Catch:{ SecurityException -> 0x0017 }
            r3.put(r4, r2)     // Catch:{ SecurityException -> 0x0017 }
        L_0x0017:
            r1 = r2
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return r1
        L_0x001a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.o.a(android.content.ContentResolver, android.net.Uri):com.google.android.gms.internal.icing.o");
    }

    private final Map<String, String> b() {
        Map<String, String> map = this.f10268c;
        if (map == null) {
            synchronized (this.f10267b) {
                map = this.f10268c;
                if (map == null) {
                    map = c();
                    this.f10268c = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    private final Map<String, String> c() {
        try {
            return (Map) q.a(new n(this));
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            return null;
        }
    }

    public final /* synthetic */ Object a(String str) {
        return b().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map a() {
        Map map;
        Cursor query = this.f10270e.query(this.f10271f, f10266g, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new a(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }
}
