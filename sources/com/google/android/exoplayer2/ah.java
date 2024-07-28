package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.a.a;

public abstract class ah {

    /* renamed from: a  reason: collision with root package name */
    public static final ah f31122a = new ah() {
        public final int a(Object obj) {
            return -1;
        }

        public final int b() {
            return 0;
        }

        public final int c() {
            return 0;
        }

        public final b a(int i2, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        public final a a(int i2, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        public final Object a(int i2) {
            throw new IndexOutOfBoundsException();
        }
    };

    public abstract int a(Object obj);

    public abstract a a(int i2, a aVar, boolean z);

    public abstract b a(int i2, b bVar, boolean z, long j);

    public abstract Object a(int i2);

    public abstract int b();

    public abstract int c();

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f31129a;

        /* renamed from: b  reason: collision with root package name */
        public long f31130b;

        /* renamed from: c  reason: collision with root package name */
        public long f31131c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31132d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f31133e;

        /* renamed from: f  reason: collision with root package name */
        public int f31134f;

        /* renamed from: g  reason: collision with root package name */
        public int f31135g;

        /* renamed from: h  reason: collision with root package name */
        public long f31136h;

        /* renamed from: i  reason: collision with root package name */
        public long f31137i;
        public long j;

        public final b a(Object obj, long j2, long j3, boolean z, boolean z2, long j4, long j5, int i2, long j6) {
            this.f31129a = obj;
            this.f31130b = j2;
            this.f31131c = j3;
            this.f31132d = z;
            this.f31133e = z2;
            this.f31136h = j4;
            this.f31137i = j5;
            this.f31134f = 0;
            this.f31135g = i2;
            this.j = j6;
            return this;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object f31123a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31124b;

        /* renamed from: c  reason: collision with root package name */
        public int f31125c;

        /* renamed from: d  reason: collision with root package name */
        public long f31126d;

        /* renamed from: e  reason: collision with root package name */
        public long f31127e;

        /* renamed from: f  reason: collision with root package name */
        public com.google.android.exoplayer2.source.a.a f31128f = com.google.android.exoplayer2.source.a.a.f32790a;

        public final a a(Object obj, Object obj2, long j, long j2) {
            com.google.android.exoplayer2.source.a.a aVar = com.google.android.exoplayer2.source.a.a.f32790a;
            this.f31123a = obj;
            this.f31124b = obj2;
            this.f31125c = 0;
            this.f31126d = j;
            this.f31127e = j2;
            this.f31128f = aVar;
            return this;
        }

        public final long a(int i2) {
            return this.f31128f.f32792c[i2];
        }

        public final int b(int i2) {
            return this.f31128f.f32793d[i2].a(-1);
        }

        public final int a(int i2, int i3) {
            return this.f31128f.f32793d[i2].a(i3);
        }

        public final boolean c(int i2) {
            return !this.f31128f.f32793d[i2].a();
        }

        public final int a(long j) {
            return this.f31128f.a(j);
        }

        public final int b(long j) {
            return this.f31128f.a(j, this.f31126d);
        }

        public final int d(int i2) {
            return this.f31128f.f32793d[i2].f32796a;
        }

        public final boolean b(int i2, int i3) {
            a.C0546a aVar = this.f31128f.f32793d[i2];
            return (aVar.f32796a == -1 || aVar.f32798c[i3] == 0) ? false : true;
        }

        public final long c(int i2, int i3) {
            a.C0546a aVar = this.f31128f.f32793d[i2];
            if (aVar.f32796a != -1) {
                return aVar.f32799d[i3];
            }
            return -9223372036854775807L;
        }
    }

    public final boolean a() {
        return b() == 0;
    }

    public int a(int i2, int i3, boolean z) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 == 2) {
                return i2 == a(z) ? b(z) : i2 + 1;
            }
            throw new IllegalStateException();
        } else if (i2 == a(z)) {
            return -1;
        } else {
            return i2 + 1;
        }
    }

    public int b(int i2, int i3, boolean z) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 == 2) {
                return i2 == b(z) ? a(z) : i2 - 1;
            }
            throw new IllegalStateException();
        } else if (i2 == b(z)) {
            return -1;
        } else {
            return i2 - 1;
        }
    }

    public int a(boolean z) {
        if (a()) {
            return -1;
        }
        return b() - 1;
    }

    public int b(boolean z) {
        return a() ? -1 : 0;
    }

    public final b a(int i2, b bVar) {
        return a(i2, bVar, false, 0);
    }

    public final boolean b(int i2, a aVar, b bVar, int i3, boolean z) {
        return a(i2, aVar, bVar, i3, z) == -1;
    }

    public final Pair<Object, Long> a(b bVar, a aVar, int i2, long j) {
        return (Pair) com.google.android.exoplayer2.g.a.a(a(bVar, aVar, i2, j, 0));
    }

    public final Pair<Object, Long> a(b bVar, a aVar, int i2, long j, long j2) {
        com.google.android.exoplayer2.g.a.a(i2, b());
        a(i2, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.f31136h;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = bVar.f31134f;
        long j3 = bVar.j + j;
        long j4 = a(i3, aVar, true).f31126d;
        while (j4 != -9223372036854775807L && j3 >= j4 && i3 < bVar.f31135g) {
            j3 -= j4;
            i3++;
            j4 = a(i3, aVar, true).f31126d;
        }
        return Pair.create(com.google.android.exoplayer2.g.a.a(aVar.f31124b), Long.valueOf(j3));
    }

    public a a(Object obj, a aVar) {
        return a(a(obj), aVar, true);
    }

    public final int a(int i2, a aVar, b bVar, int i3, boolean z) {
        int i4 = a(i2, aVar, false).f31125c;
        if (a(i4, bVar).f31135g != i2) {
            return i2 + 1;
        }
        int a2 = a(i4, i3, z);
        if (a2 == -1) {
            return -1;
        }
        return a(a2, bVar).f31134f;
    }
}
