package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.google.android.exoplayer2.g.a;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class ac implements i {

    /* renamed from: a  reason: collision with root package name */
    private final i f32357a;

    /* renamed from: b  reason: collision with root package name */
    private final h f32358b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f32359c;

    /* renamed from: d  reason: collision with root package name */
    private long f32360d;

    public ac(i iVar, h hVar) {
        this.f32357a = (i) a.a(iVar);
        this.f32358b = (h) a.a(hVar);
    }

    public final void a(ad adVar) {
        this.f32357a.a(adVar);
    }

    public final long a(l lVar) throws IOException {
        this.f32360d = this.f32357a.a(lVar);
        if (this.f32360d == 0) {
            return 0;
        }
        if (lVar.f32401g == -1) {
            long j = this.f32360d;
            if (j != -1) {
                lVar = lVar.a(0, j);
            }
        }
        this.f32359c = true;
        this.f32358b.a(lVar);
        return this.f32360d;
    }

    public final int a(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f32360d == 0) {
            return -1;
        }
        int a2 = this.f32357a.a(bArr, i2, i3);
        if (a2 > 0) {
            this.f32358b.a(bArr, i2, a2);
            long j = this.f32360d;
            if (j != -1) {
                this.f32360d = j - ((long) a2);
            }
        }
        return a2;
    }

    public final Uri a() {
        return this.f32357a.a();
    }

    public final Map<String, List<String>> b() {
        return this.f32357a.b();
    }

    public final void c() throws IOException {
        try {
            this.f32357a.c();
        } finally {
            if (this.f32359c) {
                this.f32359c = false;
                this.f32358b.a();
            }
        }
    }
}
