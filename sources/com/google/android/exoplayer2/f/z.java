package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.google.android.exoplayer2.f.x;
import com.google.android.exoplayer2.g.ae;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class z<T> implements x.d {

    /* renamed from: a  reason: collision with root package name */
    public final l f32483a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32484b;

    /* renamed from: c  reason: collision with root package name */
    public final ab f32485c;

    /* renamed from: d  reason: collision with root package name */
    public volatile T f32486d;

    /* renamed from: e  reason: collision with root package name */
    private final a<? extends T> f32487e;

    public interface a<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    public final void a() {
    }

    public z(i iVar, Uri uri, int i2, a<? extends T> aVar) {
        this(iVar, new l(uri), i2, aVar);
    }

    private z(i iVar, l lVar, int i2, a<? extends T> aVar) {
        this.f32485c = new ab(iVar);
        this.f32483a = lVar;
        this.f32484b = i2;
        this.f32487e = aVar;
    }

    public final void b() throws IOException {
        ab abVar = this.f32485c;
        abVar.f32353a = 0;
        k kVar = new k(abVar, this.f32483a);
        try {
            kVar.a();
            this.f32486d = this.f32487e.a((Uri) com.google.android.exoplayer2.g.a.a(this.f32485c.a()), kVar);
        } finally {
            ae.a((Closeable) kVar);
        }
    }
}
