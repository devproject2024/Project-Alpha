package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.b.m;
import java.util.List;

public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private final int f33489a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f33490b;

    public final int a() {
        return 0;
    }

    public final void a(long j, long j2, List<? extends l> list, m[] mVarArr) {
    }

    public c(TrackGroup trackGroup, int i2, int i3, Object obj) {
        super(trackGroup, i2);
        this.f33489a = i3;
        this.f33490b = obj;
    }

    public final int b() {
        return this.f33489a;
    }

    public final Object c() {
        return this.f33490b;
    }
}
