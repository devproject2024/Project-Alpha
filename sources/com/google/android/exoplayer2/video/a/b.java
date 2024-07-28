package com.google.android.exoplayer2.video.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.o;
import java.nio.ByteBuffer;

public final class b extends com.google.android.exoplayer2.b {

    /* renamed from: g  reason: collision with root package name */
    private final o f33667g = new o();

    /* renamed from: h  reason: collision with root package name */
    private final e f33668h = new e(1);

    /* renamed from: i  reason: collision with root package name */
    private final r f33669i = new r();
    private long j;
    private a k;
    private long l;

    public final boolean t() {
        return true;
    }

    public b() {
        super(5);
    }

    public final int a(Format format) {
        return "application/x-camera-motion".equals(format.f31069i) ? 4 : 0;
    }

    public final void a(int i2, Object obj) throws i {
        if (i2 == 7) {
            this.k = (a) obj;
        } else {
            super.a(i2, obj);
        }
    }

    public final void a(Format[] formatArr, long j2) throws i {
        this.j = j2;
    }

    public final void a(long j2, boolean z) throws i {
        v();
    }

    public final void r() {
        v();
    }

    public final void a(long j2, long j3) throws i {
        float[] fArr;
        while (!g() && this.l < 100000 + j2) {
            this.f33668h.a();
            if (a(this.f33667g, this.f33668h, false) == -4 && !this.f33668h.c()) {
                this.f33668h.g();
                this.l = this.f33668h.f31312d;
                if (this.k != null) {
                    ByteBuffer byteBuffer = this.f33668h.f31311c;
                    if (byteBuffer.remaining() != 16) {
                        fArr = null;
                    } else {
                        this.f33669i.a(byteBuffer.array(), byteBuffer.limit());
                        this.f33669i.c(byteBuffer.arrayOffset() + 4);
                        float[] fArr2 = new float[3];
                        for (int i2 = 0; i2 < 3; i2++) {
                            fArr2[i2] = Float.intBitsToFloat(this.f33669i.j());
                        }
                        fArr = fArr2;
                    }
                    if (fArr != null) {
                        ((a) ae.a(this.k)).a(this.l - this.j, fArr);
                    }
                }
            } else {
                return;
            }
        }
    }

    public final boolean u() {
        return g();
    }

    private void v() {
        this.l = 0;
        a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
    }
}
