package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.google.android.exoplayer2.g.a;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class ab implements i {

    /* renamed from: a  reason: collision with root package name */
    public long f32353a;

    /* renamed from: b  reason: collision with root package name */
    public Uri f32354b = Uri.EMPTY;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, List<String>> f32355c = Collections.emptyMap();

    /* renamed from: d  reason: collision with root package name */
    private final i f32356d;

    public ab(i iVar) {
        this.f32356d = (i) a.a(iVar);
    }

    public final void a(ad adVar) {
        this.f32356d.a(adVar);
    }

    public final long a(l lVar) throws IOException {
        this.f32354b = lVar.f32395a;
        this.f32355c = Collections.emptyMap();
        long a2 = this.f32356d.a(lVar);
        this.f32354b = (Uri) a.a(a());
        this.f32355c = b();
        return a2;
    }

    public final int a(byte[] bArr, int i2, int i3) throws IOException {
        int a2 = this.f32356d.a(bArr, i2, i3);
        if (a2 != -1) {
            this.f32353a += (long) a2;
        }
        return a2;
    }

    public final Uri a() {
        return this.f32356d.a();
    }

    public final Map<String, List<String>> b() {
        return this.f32356d.b();
    }

    public final void c() throws IOException {
        this.f32356d.c();
    }
}
