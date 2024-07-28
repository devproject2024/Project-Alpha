package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.ab;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.f.x;
import com.google.android.exoplayer2.g.a;
import java.util.List;
import java.util.Map;

public abstract class d implements x.d {

    /* renamed from: e  reason: collision with root package name */
    public final l f32814e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32815f;

    /* renamed from: g  reason: collision with root package name */
    public final Format f32816g;

    /* renamed from: h  reason: collision with root package name */
    public final int f32817h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f32818i;
    public final long j;
    public final long k;
    protected final ab l;

    public d(i iVar, l lVar, int i2, Format format, int i3, Object obj, long j2, long j3) {
        this.l = new ab(iVar);
        this.f32814e = (l) a.a(lVar);
        this.f32815f = i2;
        this.f32816g = format;
        this.f32817h = i3;
        this.f32818i = obj;
        this.j = j2;
        this.k = j3;
    }

    public final long c() {
        return this.l.f32353a;
    }

    public final Uri d() {
        return this.l.f32354b;
    }

    public final Map<String, List<String>> e() {
        return this.l.f32355c;
    }
}
