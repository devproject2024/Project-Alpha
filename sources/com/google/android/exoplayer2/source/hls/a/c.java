package com.google.android.exoplayer2.source.hls.a;

import com.google.android.exoplayer2.f.z;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.offline.b;
import java.util.List;

public final class c implements h {

    /* renamed from: a  reason: collision with root package name */
    private final h f33092a;

    /* renamed from: b  reason: collision with root package name */
    private final List<StreamKey> f33093b;

    public c(h hVar, List<StreamKey> list) {
        this.f33092a = hVar;
        this.f33093b = list;
    }

    public final z.a<f> a() {
        return new b(this.f33092a.a(), this.f33093b);
    }

    public final z.a<f> a(d dVar) {
        return new b(this.f33092a.a(dVar), this.f33093b);
    }
}
