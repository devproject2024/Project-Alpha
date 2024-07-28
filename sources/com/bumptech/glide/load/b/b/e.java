package com.bumptech.glide.load.b.b;

import android.util.Log;
import com.bumptech.glide.a.a;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.c;
import com.bumptech.glide.load.g;
import java.io.File;
import java.io.IOException;

public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f6781a;

    /* renamed from: b  reason: collision with root package name */
    private final File f6782b;

    /* renamed from: c  reason: collision with root package name */
    private final long f6783c;

    /* renamed from: d  reason: collision with root package name */
    private final c f6784d = new c();

    /* renamed from: e  reason: collision with root package name */
    private a f6785e;

    @Deprecated
    e(File file, long j) {
        this.f6782b = file;
        this.f6783c = j;
        this.f6781a = new j();
    }

    private synchronized a a() throws IOException {
        if (this.f6785e == null) {
            this.f6785e = a.a(this.f6782b, this.f6783c);
        }
        return this.f6785e;
    }

    public final File a(g gVar) {
        String a2 = this.f6781a.a(gVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            StringBuilder sb = new StringBuilder("Get: Obtained: ");
            sb.append(a2);
            sb.append(" for for Key: ");
            sb.append(gVar);
        }
        try {
            a.d a3 = a().a(a2);
            if (a3 != null) {
                return a3.f6410a[0];
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public final void a(g gVar, a.b bVar) {
        c.a aVar;
        a.b b2;
        String a2 = this.f6781a.a(gVar);
        c cVar = this.f6784d;
        synchronized (cVar) {
            aVar = cVar.f6774a.get(a2);
            if (aVar == null) {
                aVar = cVar.f6775b.a();
                cVar.f6774a.put(a2, aVar);
            }
            aVar.f6777b++;
        }
        aVar.f6776a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                StringBuilder sb = new StringBuilder("Put: Obtained: ");
                sb.append(a2);
                sb.append(" for for Key: ");
                sb.append(gVar);
            }
            try {
                com.bumptech.glide.a.a a3 = a();
                if (a3.a(a2) == null) {
                    b2 = a3.b(a2);
                    if (b2 != null) {
                        if (bVar.a(b2.a())) {
                            com.bumptech.glide.a.a.this.a(b2, true);
                            b2.f6400c = true;
                        }
                        b2.c();
                    } else {
                        throw new IllegalStateException("Had two simultaneous puts for: ".concat(String.valueOf(a2)));
                    }
                }
            } catch (IOException unused) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            } catch (Throwable th) {
                b2.c();
                throw th;
            }
        } finally {
            this.f6784d.a(a2);
        }
    }
}
