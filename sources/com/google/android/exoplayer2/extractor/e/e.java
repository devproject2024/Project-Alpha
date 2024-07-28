package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.EOFException;
import java.io.IOException;

final class e {
    private static final int k = ae.h("OggS");

    /* renamed from: a  reason: collision with root package name */
    public int f31818a;

    /* renamed from: b  reason: collision with root package name */
    public int f31819b;

    /* renamed from: c  reason: collision with root package name */
    public long f31820c;

    /* renamed from: d  reason: collision with root package name */
    public long f31821d;

    /* renamed from: e  reason: collision with root package name */
    public long f31822e;

    /* renamed from: f  reason: collision with root package name */
    public long f31823f;

    /* renamed from: g  reason: collision with root package name */
    public int f31824g;

    /* renamed from: h  reason: collision with root package name */
    public int f31825h;

    /* renamed from: i  reason: collision with root package name */
    public int f31826i;
    public final int[] j = new int[PriceRangeSeekBar.INVALID_POINTER_ID];
    private final r l = new r((int) PriceRangeSeekBar.INVALID_POINTER_ID);

    e() {
    }

    public final void a() {
        this.f31818a = 0;
        this.f31819b = 0;
        this.f31820c = 0;
        this.f31821d = 0;
        this.f31822e = 0;
        this.f31823f = 0;
        this.f31824g = 0;
        this.f31825h = 0;
        this.f31826i = 0;
    }

    public final boolean a(h hVar, boolean z) throws IOException, InterruptedException {
        this.l.a();
        a();
        if (!(hVar.d() == -1 || hVar.d() - hVar.b() >= 27) || !hVar.b(this.l.f32566a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.l.g() == ((long) k)) {
            this.f31818a = this.l.c();
            if (this.f31818a == 0) {
                this.f31819b = this.l.c();
                this.f31820c = this.l.l();
                this.f31821d = this.l.h();
                this.f31822e = this.l.h();
                this.f31823f = this.l.h();
                this.f31824g = this.l.c();
                this.f31825h = this.f31824g + 27;
                this.l.a();
                hVar.c(this.l.f32566a, 0, this.f31824g);
                for (int i2 = 0; i2 < this.f31824g; i2++) {
                    this.j[i2] = this.l.c();
                    this.f31826i += this.j[i2];
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new v("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new v("expected OggS capture pattern at begin of page");
        }
    }
}
