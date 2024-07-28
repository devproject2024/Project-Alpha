package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.g.a;

public abstract class l extends d {
    public final long m;

    public abstract boolean g();

    public l(i iVar, com.google.android.exoplayer2.f.l lVar, Format format, int i2, Object obj, long j, long j2, long j3) {
        super(iVar, lVar, 1, format, i2, obj, j, j2);
        a.a(format);
        this.m = j3;
    }

    public long f() {
        long j = this.m;
        if (j != -1) {
            return j + 1;
        }
        return -1;
    }
}
