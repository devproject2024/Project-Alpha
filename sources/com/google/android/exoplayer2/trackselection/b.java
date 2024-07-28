package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.b.m;
import com.google.android.exoplayer2.trackselection.f;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f33483a;

    /* renamed from: b  reason: collision with root package name */
    private int f33484b;

    /* renamed from: c  reason: collision with root package name */
    protected final TrackGroup f33485c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f33486d;

    /* renamed from: e  reason: collision with root package name */
    protected final int[] f33487e;

    /* renamed from: f  reason: collision with root package name */
    final Format[] f33488f;

    public void a(float f2) {
    }

    public /* synthetic */ void a(long j, long j2, List<? extends l> list, m[] mVarArr) {
        f.CC.$default$a(this, j, j2, list, mVarArr);
    }

    public void d() {
    }

    @Deprecated
    public /* synthetic */ void i() {
        f.CC.$default$i(this);
    }

    public b(TrackGroup trackGroup, int... iArr) {
        int i2 = 0;
        com.google.android.exoplayer2.g.a.b(iArr.length > 0);
        this.f33485c = (TrackGroup) com.google.android.exoplayer2.g.a.a(trackGroup);
        this.f33486d = iArr.length;
        this.f33488f = new Format[this.f33486d];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.f33488f[i3] = trackGroup.f32781b[iArr[i3]];
        }
        Arrays.sort(this.f33488f, new a((byte) 0));
        this.f33487e = new int[this.f33486d];
        while (true) {
            int i4 = this.f33486d;
            if (i2 < i4) {
                this.f33487e[i2] = trackGroup.a(this.f33488f[i2]);
                i2++;
            } else {
                this.f33483a = new long[i4];
                return;
            }
        }
    }

    public final TrackGroup e() {
        return this.f33485c;
    }

    public final int f() {
        return this.f33487e.length;
    }

    public final Format a(int i2) {
        return this.f33488f[i2];
    }

    public final int b(int i2) {
        return this.f33487e[i2];
    }

    public final int a(Format format) {
        for (int i2 = 0; i2 < this.f33486d; i2++) {
            if (this.f33488f[i2] == format) {
                return i2;
            }
        }
        return -1;
    }

    public final int c(int i2) {
        for (int i3 = 0; i3 < this.f33486d; i3++) {
            if (this.f33487e[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public final Format g() {
        return this.f33488f[a()];
    }

    public final int h() {
        return this.f33487e[a()];
    }

    public int a(long j, List<? extends l> list) {
        return list.size();
    }

    public final boolean a(int i2, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b2 = b(i2, elapsedRealtime);
        int i3 = 0;
        while (i3 < this.f33486d && !b2) {
            b2 = i3 != i2 && !b(i3, elapsedRealtime);
            i3++;
        }
        if (!b2) {
            return false;
        }
        long[] jArr = this.f33483a;
        jArr[i2] = Math.max(jArr[i2], ae.b(elapsedRealtime, j));
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean b(int i2, long j) {
        return this.f33483a[i2] > j;
    }

    public int hashCode() {
        if (this.f33484b == 0) {
            this.f33484b = (System.identityHashCode(this.f33485c) * 31) + Arrays.hashCode(this.f33487e);
        }
        return this.f33484b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            return this.f33485c == bVar.f33485c && Arrays.equals(this.f33487e, bVar.f33487e);
        }
    }

    static final class a implements Comparator<Format> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Format) obj2).f31065e - ((Format) obj).f31065e;
        }
    }
}
