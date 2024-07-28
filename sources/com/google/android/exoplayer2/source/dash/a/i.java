package com.google.android.exoplayer2.source.dash.a;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.dash.a.j;
import com.google.android.exoplayer2.source.dash.d;
import java.util.Collections;
import java.util.List;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f32946a;

    /* renamed from: b  reason: collision with root package name */
    public final Format f32947b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32948c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32949d;

    /* renamed from: e  reason: collision with root package name */
    public final List<d> f32950e;

    /* renamed from: f  reason: collision with root package name */
    public final h f32951f;

    public abstract h c();

    public abstract d d();

    public abstract String e();

    /* synthetic */ i(long j, Format format, String str, j jVar, List list, byte b2) {
        this(j, format, str, jVar, list);
    }

    private i(long j, Format format, String str, j jVar, List<d> list) {
        List<d> list2;
        this.f32946a = j;
        this.f32947b = format;
        this.f32948c = str;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.f32950e = list2;
        this.f32951f = jVar.a(this);
        this.f32949d = ae.b(jVar.f32958c, 1000000, jVar.f32957b);
    }

    public static class b extends i {

        /* renamed from: g  reason: collision with root package name */
        public final Uri f32953g;

        /* renamed from: h  reason: collision with root package name */
        public final long f32954h;

        /* renamed from: i  reason: collision with root package name */
        private final String f32955i;
        private final h j;
        private final k k;

        public b(long j2, Format format, String str, j.e eVar, List<d> list) {
            super(j2, format, str, eVar, list, (byte) 0);
            this.f32953g = Uri.parse(str);
            k kVar = null;
            this.j = eVar.f32969e <= 0 ? null : new h((String) null, eVar.f32968d, eVar.f32969e);
            this.f32955i = null;
            this.f32954h = -1;
            this.k = this.j == null ? new k(new h((String) null, 0, -1)) : kVar;
        }

        public final h c() {
            return this.j;
        }

        public final d d() {
            return this.k;
        }

        public final String e() {
            return this.f32955i;
        }
    }

    public static class a extends i implements d {

        /* renamed from: g  reason: collision with root package name */
        private final j.a f32952g;

        public final h c() {
            return null;
        }

        public final d d() {
            return this;
        }

        public final String e() {
            return null;
        }

        public a(long j, Format format, String str, j.a aVar, List<d> list) {
            super(j, format, str, aVar, list, (byte) 0);
            this.f32952g = aVar;
        }

        public final h b(long j) {
            return this.f32952g.a(this, j);
        }

        public final long a(long j, long j2) {
            long j3;
            j.a aVar = this.f32952g;
            long j4 = aVar.f32959d;
            long b2 = (long) aVar.b(j2);
            if (b2 == 0) {
                return j4;
            }
            if (aVar.f32961f == null) {
                j3 = aVar.f32959d + (j / ((aVar.f32960e * 1000000) / aVar.f32957b));
                if (j3 < j4) {
                    return j4;
                }
                if (b2 != -1) {
                    return Math.min(j3, (j4 + b2) - 1);
                }
            } else {
                j3 = (b2 + j4) - 1;
                long j5 = j4;
                while (j5 <= j3) {
                    long j6 = ((j3 - j5) / 2) + j5;
                    int i2 = (aVar.a(j6) > j ? 1 : (aVar.a(j6) == j ? 0 : -1));
                    if (i2 < 0) {
                        j5 = j6 + 1;
                    } else if (i2 <= 0) {
                        return j6;
                    } else {
                        j3 = j6 - 1;
                    }
                }
                if (j5 == j4) {
                    return j5;
                }
            }
            return j3;
        }

        public final long a(long j) {
            return this.f32952g.a(j);
        }

        public final long b(long j, long j2) {
            j.a aVar = this.f32952g;
            if (aVar.f32961f != null) {
                return (aVar.f32961f.get((int) (j - aVar.f32959d)).f32967b * 1000000) / aVar.f32957b;
            }
            int b2 = aVar.b(j2);
            return (b2 == -1 || j != (aVar.f32959d + ((long) b2)) - 1) ? (aVar.f32960e * 1000000) / aVar.f32957b : j2 - aVar.a(j);
        }

        public final long a() {
            return this.f32952g.f32959d;
        }

        public final int c(long j) {
            return this.f32952g.b(j);
        }

        public final boolean b() {
            return this.f32952g.a();
        }
    }
}
