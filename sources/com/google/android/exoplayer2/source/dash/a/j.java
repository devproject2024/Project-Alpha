package com.google.android.exoplayer2.source.dash.a;

import com.google.android.exoplayer2.g.ae;
import java.util.List;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    final h f32956a;

    /* renamed from: b  reason: collision with root package name */
    final long f32957b;

    /* renamed from: c  reason: collision with root package name */
    final long f32958c;

    public j(h hVar, long j, long j2) {
        this.f32956a = hVar;
        this.f32957b = j;
        this.f32958c = j2;
    }

    public h a(i iVar) {
        return this.f32956a;
    }

    public static class e extends j {

        /* renamed from: d  reason: collision with root package name */
        final long f32968d;

        /* renamed from: e  reason: collision with root package name */
        final long f32969e;

        public e(h hVar, long j, long j2, long j3, long j4) {
            super(hVar, j, j2);
            this.f32968d = j3;
            this.f32969e = j4;
        }

        public e() {
            this((h) null, 1, 0, 0, 0);
        }
    }

    public static abstract class a extends j {

        /* renamed from: d  reason: collision with root package name */
        final long f32959d;

        /* renamed from: e  reason: collision with root package name */
        final long f32960e;

        /* renamed from: f  reason: collision with root package name */
        final List<d> f32961f;

        public abstract h a(i iVar, long j);

        public abstract int b(long j);

        public a(h hVar, long j, long j2, long j3, long j4, List<d> list) {
            super(hVar, j, j2);
            this.f32959d = j3;
            this.f32960e = j4;
            this.f32961f = list;
        }

        public final long a(long j) {
            long j2;
            List<d> list = this.f32961f;
            if (list != null) {
                j2 = list.get((int) (j - this.f32959d)).f32966a - this.f32958c;
            } else {
                j2 = (j - this.f32959d) * this.f32960e;
            }
            return ae.b(j2, 1000000, this.f32957b);
        }

        public boolean a() {
            return this.f32961f != null;
        }
    }

    public static class b extends a {

        /* renamed from: g  reason: collision with root package name */
        final List<h> f32962g;

        public final boolean a() {
            return true;
        }

        public b(h hVar, long j, long j2, long j3, long j4, List<d> list, List<h> list2) {
            super(hVar, j, j2, j3, j4, list);
            this.f32962g = list2;
        }

        public final h a(i iVar, long j) {
            return this.f32962g.get((int) (j - this.f32959d));
        }

        public final int b(long j) {
            return this.f32962g.size();
        }
    }

    public static class c extends a {

        /* renamed from: g  reason: collision with root package name */
        final l f32963g;

        /* renamed from: h  reason: collision with root package name */
        final l f32964h;

        /* renamed from: i  reason: collision with root package name */
        final long f32965i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(h hVar, long j, long j2, long j3, long j4, long j5, List<d> list, l lVar, l lVar2) {
            super(hVar, j, j2, j3, j5, list);
            this.f32963g = lVar;
            this.f32964h = lVar2;
            this.f32965i = j4;
        }

        public final h a(i iVar) {
            l lVar = this.f32963g;
            if (lVar != null) {
                return new h(lVar.a(iVar.f32947b.f31061a, 0, iVar.f32947b.f31065e, 0), 0, -1);
            }
            return super.a(iVar);
        }

        public final h a(i iVar, long j) {
            long j2;
            i iVar2 = iVar;
            if (this.f32961f != null) {
                j2 = ((d) this.f32961f.get((int) (j - this.f32959d))).f32966a;
            } else {
                j2 = (j - this.f32959d) * this.f32960e;
            }
            long j3 = j2;
            return new h(this.f32964h.a(iVar2.f32947b.f31061a, j, iVar2.f32947b.f31065e, j3), 0, -1);
        }

        public final int b(long j) {
            if (this.f32961f != null) {
                return this.f32961f.size();
            }
            long j2 = this.f32965i;
            if (j2 != -1) {
                return (int) ((j2 - this.f32959d) + 1);
            }
            if (j != -9223372036854775807L) {
                return (int) ae.a(j, (this.f32960e * 1000000) / this.f32957b);
            }
            return -1;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        final long f32966a;

        /* renamed from: b  reason: collision with root package name */
        final long f32967b;

        public d(long j, long j2) {
            this.f32966a = j;
            this.f32967b = j2;
        }
    }
}
