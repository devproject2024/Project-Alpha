package com.google.android.exoplayer2.source.a;

import android.net.Uri;
import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32790a = new a(new long[0]);

    /* renamed from: b  reason: collision with root package name */
    public final int f32791b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f32792c;

    /* renamed from: d  reason: collision with root package name */
    public final C0546a[] f32793d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32794e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32795f;

    /* renamed from: com.google.android.exoplayer2.source.a.a$a  reason: collision with other inner class name */
    public static final class C0546a {

        /* renamed from: a  reason: collision with root package name */
        public final int f32796a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri[] f32797b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f32798c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f32799d;

        public C0546a() {
            this(new int[0], new Uri[0], new long[0]);
        }

        private C0546a(int[] iArr, Uri[] uriArr, long[] jArr) {
            com.google.android.exoplayer2.g.a.a(true);
            this.f32796a = -1;
            this.f32798c = iArr;
            this.f32797b = uriArr;
            this.f32799d = jArr;
        }

        public final int a(int i2) {
            int i3 = i2 + 1;
            while (true) {
                int[] iArr = this.f32798c;
                if (i3 >= iArr.length || iArr[i3] == 0 || iArr[i3] == 1) {
                    return i3;
                }
                i3++;
            }
            return i3;
        }

        public final boolean a() {
            return this.f32796a == -1 || a(-1) < this.f32796a;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                C0546a aVar = (C0546a) obj;
                return this.f32796a == aVar.f32796a && Arrays.equals(this.f32797b, aVar.f32797b) && Arrays.equals(this.f32798c, aVar.f32798c) && Arrays.equals(this.f32799d, aVar.f32799d);
            }
        }

        public final int hashCode() {
            return (((((this.f32796a * 31) + Arrays.hashCode(this.f32797b)) * 31) + Arrays.hashCode(this.f32798c)) * 31) + Arrays.hashCode(this.f32799d);
        }
    }

    private a(long... jArr) {
        this.f32792c = Arrays.copyOf(jArr, 0);
        this.f32793d = new C0546a[0];
        this.f32794e = 0;
        this.f32795f = -9223372036854775807L;
    }

    public final int a(long j) {
        int length = this.f32792c.length - 1;
        while (length >= 0 && a(j, length)) {
            length--;
        }
        if (length < 0 || !this.f32793d[length].a()) {
            return -1;
        }
        return length;
    }

    public final int a(long j, long j2) {
        if (j != Long.MIN_VALUE && (j2 == -9223372036854775807L || j < j2)) {
            int i2 = 0;
            while (true) {
                long[] jArr = this.f32792c;
                if (i2 < jArr.length && jArr[i2] != Long.MIN_VALUE && (j >= jArr[i2] || !this.f32793d[i2].a())) {
                    i2++;
                }
            }
            if (i2 < this.f32792c.length) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            return this.f32791b == aVar.f32791b && this.f32794e == aVar.f32794e && this.f32795f == aVar.f32795f && Arrays.equals(this.f32792c, aVar.f32792c) && Arrays.equals(this.f32793d, aVar.f32793d);
        }
    }

    public final int hashCode() {
        return (((((((this.f32791b * 31) + ((int) this.f32794e)) * 31) + ((int) this.f32795f)) * 31) + Arrays.hashCode(this.f32792c)) * 31) + Arrays.hashCode(this.f32793d);
    }

    private boolean a(long j, int i2) {
        if (j == Long.MIN_VALUE) {
            return false;
        }
        long j2 = this.f32792c[i2];
        if (j2 != Long.MIN_VALUE) {
            return j < j2;
        }
        long j3 = this.f32795f;
        return j3 == -9223372036854775807L || j < j3;
    }
}
