package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentHashMap<Uri, c> f9225c = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f9226i = {"key", "value"};

    /* renamed from: a  reason: collision with root package name */
    final Object f9227a = new Object();

    /* renamed from: b  reason: collision with root package name */
    volatile Map<String, String> f9228b;

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f9229d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri f9230e;

    /* renamed from: f  reason: collision with root package name */
    private final ContentObserver f9231f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f9232g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private final List<Object> f9233h = new ArrayList();

    private c(ContentResolver contentResolver, Uri uri) {
        this.f9229d = contentResolver;
        this.f9230e = uri;
        this.f9231f = new d(this);
    }

    public static c a(ContentResolver contentResolver, Uri uri) {
        c cVar = f9225c.get(uri);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(contentResolver, uri);
        c putIfAbsent = f9225c.putIfAbsent(uri, cVar2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        cVar2.f9229d.registerContentObserver(cVar2.f9230e, false, cVar2.f9231f);
        return cVar2;
    }

    private final Map<String, String> b() {
        Cursor query;
        try {
            HashMap hashMap = new HashMap();
            query = this.f9229d.query(this.f9230e, f9226i, (String) null, (String[]) null, (String) null);
            if (query != null) {
                while (query.moveToNext()) {
                    hashMap.put(query.getString(0), query.getString(1));
                }
                query.close();
            }
            return hashMap;
        } catch (SQLiteException | SecurityException unused) {
            return null;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    public final Map<String, String> a() {
        Map<String, String> b2 = e.b("gms:phenotype:phenotype_flag:debug_disable_caching") ? b() : this.f9228b;
        if (b2 == null) {
            synchronized (this.f9227a) {
                Map<String, String> map = this.f9228b;
                if (map == null) {
                    map = b();
                    this.f9228b = map;
                }
            }
        }
        return b2 != null ? b2 : Collections.emptyMap();
    }

    static /* synthetic */ void a(c cVar) {
        synchronized (cVar.f9232g) {
            Iterator<Object> it2 = cVar.f9233h.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }
}
