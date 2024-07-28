package com.google.android.exoplayer2.source.b;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

public final class e implements i {

    /* renamed from: a  reason: collision with root package name */
    public final g f32819a;

    /* renamed from: b  reason: collision with root package name */
    public o f32820b;

    /* renamed from: c  reason: collision with root package name */
    public Format[] f32821c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32822d;

    /* renamed from: e  reason: collision with root package name */
    private final Format f32823e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<a> f32824f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    private boolean f32825g;

    /* renamed from: h  reason: collision with root package name */
    private b f32826h;

    /* renamed from: i  reason: collision with root package name */
    private long f32827i;

    public interface b {
        q a(int i2);
    }

    public e(g gVar, int i2, Format format) {
        this.f32819a = gVar;
        this.f32822d = i2;
        this.f32823e = format;
    }

    public final void a(b bVar, long j, long j2) {
        this.f32826h = bVar;
        this.f32827i = j2;
        if (!this.f32825g) {
            this.f32819a.a((i) this);
            if (j != -9223372036854775807L) {
                this.f32819a.a(0, j);
            }
            this.f32825g = true;
            return;
        }
        g gVar = this.f32819a;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        gVar.a(0, j);
        for (int i2 = 0; i2 < this.f32824f.size(); i2++) {
            this.f32824f.valueAt(i2).a(bVar, j2);
        }
    }

    public final q a(int i2, int i3) {
        a aVar = this.f32824f.get(i2);
        if (aVar == null) {
            com.google.android.exoplayer2.g.a.b(this.f32821c == null);
            aVar = new a(i2, i3, i3 == this.f32822d ? this.f32823e : null);
            aVar.a(this.f32826h, this.f32827i);
            this.f32824f.put(i2, aVar);
        }
        return aVar;
    }

    public final void a() {
        Format[] formatArr = new Format[this.f32824f.size()];
        for (int i2 = 0; i2 < this.f32824f.size(); i2++) {
            formatArr[i2] = this.f32824f.valueAt(i2).f32828a;
        }
        this.f32821c = formatArr;
    }

    public final void a(o oVar) {
        this.f32820b = oVar;
    }

    static final class a implements q {

        /* renamed from: a  reason: collision with root package name */
        public Format f32828a;

        /* renamed from: b  reason: collision with root package name */
        private final int f32829b;

        /* renamed from: c  reason: collision with root package name */
        private final int f32830c;

        /* renamed from: d  reason: collision with root package name */
        private final Format f32831d;

        /* renamed from: e  reason: collision with root package name */
        private final f f32832e = new f();

        /* renamed from: f  reason: collision with root package name */
        private q f32833f;

        /* renamed from: g  reason: collision with root package name */
        private long f32834g;

        public a(int i2, int i3, Format format) {
            this.f32829b = i2;
            this.f32830c = i3;
            this.f32831d = format;
        }

        public final void a(b bVar, long j) {
            if (bVar == null) {
                this.f32833f = this.f32832e;
                return;
            }
            this.f32834g = j;
            this.f32833f = bVar.a(this.f32830c);
            Format format = this.f32828a;
            if (format != null) {
                this.f32833f.a(format);
            }
        }

        public final void a(Format format) {
            Format format2 = this.f32831d;
            if (format2 != null) {
                format = format.a(format2);
            }
            this.f32828a = format;
            this.f32833f.a(this.f32828a);
        }

        public final int a(h hVar, int i2, boolean z) throws IOException, InterruptedException {
            return this.f32833f.a(hVar, i2, z);
        }

        public final void a(r rVar, int i2) {
            this.f32833f.a(rVar, i2);
        }

        public final void a(long j, int i2, int i3, int i4, q.a aVar) {
            long j2 = this.f32834g;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.f32833f = this.f32832e;
            }
            this.f32833f.a(j, i2, i3, i4, aVar);
        }
    }
}
