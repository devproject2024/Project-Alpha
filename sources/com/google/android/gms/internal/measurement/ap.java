package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import androidx.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ap implements au {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Uri, ap> f10454d = new a();

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f10455h = {"key", "value"};

    /* renamed from: a  reason: collision with root package name */
    final Object f10456a = new Object();

    /* renamed from: b  reason: collision with root package name */
    volatile Map<String, String> f10457b;

    /* renamed from: c  reason: collision with root package name */
    final List<Object> f10458c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f10459e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f10460f;

    /* renamed from: g  reason: collision with root package name */
    private final ContentObserver f10461g = new ar(this);

    private ap(ContentResolver contentResolver, Uri uri) {
        this.f10459e = contentResolver;
        this.f10460f = uri;
        contentResolver.registerContentObserver(uri, false, this.f10461g);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.ap a(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.ap> r0 = com.google.android.gms.internal.measurement.ap.class
            monitor-enter(r0)
            java.util.Map<android.net.Uri, com.google.android.gms.internal.measurement.ap> r1 = f10454d     // Catch:{ all -> 0x001a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.ap r1 = (com.google.android.gms.internal.measurement.ap) r1     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.internal.measurement.ap r2 = new com.google.android.gms.internal.measurement.ap     // Catch:{ SecurityException -> 0x0018 }
            r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x0018 }
            java.util.Map<android.net.Uri, com.google.android.gms.internal.measurement.ap> r3 = f10454d     // Catch:{ SecurityException -> 0x0017 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.ap.a(android.content.ContentResolver, android.net.Uri):com.google.android.gms.internal.measurement.ap");
    }

    public final Map<String, String> a() {
        Map<String, String> map = this.f10457b;
        if (map == null) {
            synchronized (this.f10456a) {
                map = this.f10457b;
                if (map == null) {
                    map = d();
                    this.f10457b = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    /* JADX INFO: finally extract failed */
    private final Map<String, String> d() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Map<String, String> map = (Map) aw.a(new at(this));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return map;
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return null;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    static synchronized void b() {
        synchronized (ap.class) {
            for (ap next : f10454d.values()) {
                next.f10459e.unregisterContentObserver(next.f10461g);
            }
            f10454d.clear();
        }
    }

    public final /* synthetic */ Object a(String str) {
        return a().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map c() {
        Map map;
        Cursor query = this.f10459e.query(this.f10460f, f10455h, (String) null, (String[]) null, (String) null);
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
