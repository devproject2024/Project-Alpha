package com.google.android.gms.internal.vision;

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

public final class l implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Uri, l> f11253d = new a();

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f11254h = {"key", "value"};

    /* renamed from: a  reason: collision with root package name */
    final Object f11255a = new Object();

    /* renamed from: b  reason: collision with root package name */
    volatile Map<String, String> f11256b;

    /* renamed from: c  reason: collision with root package name */
    final List<Object> f11257c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f11258e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f11259f;

    /* renamed from: g  reason: collision with root package name */
    private final ContentObserver f11260g = new m(this);

    private l(ContentResolver contentResolver, Uri uri) {
        this.f11258e = contentResolver;
        this.f11259f = uri;
        contentResolver.registerContentObserver(uri, false, this.f11260g);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.vision.l a(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.vision.l> r0 = com.google.android.gms.internal.vision.l.class
            monitor-enter(r0)
            java.util.Map<android.net.Uri, com.google.android.gms.internal.vision.l> r1 = f11253d     // Catch:{ all -> 0x001a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.vision.l r1 = (com.google.android.gms.internal.vision.l) r1     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.internal.vision.l r2 = new com.google.android.gms.internal.vision.l     // Catch:{ SecurityException -> 0x0018 }
            r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x0018 }
            java.util.Map<android.net.Uri, com.google.android.gms.internal.vision.l> r3 = f11253d     // Catch:{ SecurityException -> 0x0017 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.l.a(android.content.ContentResolver, android.net.Uri):com.google.android.gms.internal.vision.l");
    }

    private final Map<String, String> c() {
        Map<String, String> map = this.f11256b;
        if (map == null) {
            synchronized (this.f11255a) {
                map = this.f11256b;
                if (map == null) {
                    map = d();
                    this.f11256b = map;
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
            Map<String, String> map = (Map) n.a(new k(this));
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

    static synchronized void a() {
        synchronized (l.class) {
            for (l next : f11253d.values()) {
                next.f11258e.unregisterContentObserver(next.f11260g);
            }
            f11253d.clear();
        }
    }

    public final /* synthetic */ Object a(String str) {
        return c().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map b() {
        Map map;
        Cursor query = this.f11258e.query(this.f11259f, f11254h, (String) null, (String[]) null, (String) null);
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
