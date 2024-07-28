package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ab;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.n;
import com.google.android.exoplayer2.source.u;
import java.io.IOException;

public abstract class b implements ab, ac {

    /* renamed from: a  reason: collision with root package name */
    protected ad f31138a;

    /* renamed from: b  reason: collision with root package name */
    protected int f31139b;

    /* renamed from: c  reason: collision with root package name */
    protected int f31140c;

    /* renamed from: d  reason: collision with root package name */
    protected u f31141d;

    /* renamed from: e  reason: collision with root package name */
    protected Format[] f31142e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f31143f;

    /* renamed from: g  reason: collision with root package name */
    private final int f31144g;

    /* renamed from: h  reason: collision with root package name */
    private long f31145h;

    /* renamed from: i  reason: collision with root package name */
    private long f31146i = Long.MIN_VALUE;

    public /* synthetic */ void a(float f2) throws i {
        ab.CC.$default$a(this, f2);
    }

    public void a(int i2, Object obj) throws i {
    }

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) throws i {
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) throws i {
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j) throws i {
    }

    public final ac b() {
        return this;
    }

    public n c() {
        return null;
    }

    public int o() throws i {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void p() throws i {
    }

    /* access modifiers changed from: protected */
    public void q() throws i {
    }

    /* access modifiers changed from: protected */
    public void r() {
    }

    /* access modifiers changed from: protected */
    public void s() {
    }

    public b(int i2) {
        this.f31144g = i2;
    }

    public final int a() {
        return this.f31144g;
    }

    public final void a(int i2) {
        this.f31139b = i2;
    }

    public final int f_() {
        return this.f31140c;
    }

    public final void a(ad adVar, Format[] formatArr, u uVar, long j, boolean z, long j2) throws i {
        a.b(this.f31140c == 0);
        this.f31138a = adVar;
        this.f31140c = 1;
        a(z);
        a(formatArr, uVar, j2);
        a(j, z);
    }

    public final void g_() throws i {
        boolean z = true;
        if (this.f31140c != 1) {
            z = false;
        }
        a.b(z);
        this.f31140c = 2;
        p();
    }

    public final void a(Format[] formatArr, u uVar, long j) throws i {
        a.b(!this.f31143f);
        this.f31141d = uVar;
        this.f31146i = j;
        this.f31142e = formatArr;
        this.f31145h = j;
        a(formatArr, j);
    }

    public final u f() {
        return this.f31141d;
    }

    public final boolean g() {
        return this.f31146i == Long.MIN_VALUE;
    }

    public final long h() {
        return this.f31146i;
    }

    public final void i() {
        this.f31143f = true;
    }

    public final boolean j() {
        return this.f31143f;
    }

    public final void k() throws IOException {
        this.f31141d.b();
    }

    public final void a(long j) throws i {
        this.f31143f = false;
        this.f31146i = j;
        a(j, false);
    }

    public final void l() throws i {
        a.b(this.f31140c == 2);
        this.f31140c = 1;
        q();
    }

    public final void m() {
        boolean z = true;
        if (this.f31140c != 1) {
            z = false;
        }
        a.b(z);
        this.f31140c = 0;
        this.f31141d = null;
        this.f31142e = null;
        this.f31143f = false;
        r();
    }

    public final void n() {
        a.b(this.f31140c == 0);
        s();
    }

    /* access modifiers changed from: protected */
    public final int a(o oVar, e eVar, boolean z) {
        int a2 = this.f31141d.a(oVar, eVar, z);
        if (a2 == -4) {
            if (eVar.c()) {
                this.f31146i = Long.MIN_VALUE;
                if (this.f31143f) {
                    return -4;
                }
                return -3;
            }
            eVar.f31312d += this.f31145h;
            this.f31146i = Math.max(this.f31146i, eVar.f31312d);
        } else if (a2 == -5) {
            Format format = oVar.f32757a;
            if (format.m != Long.MAX_VALUE) {
                oVar.f32757a = format.a(format.m + this.f31145h);
            }
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public final int b(long j) {
        return this.f31141d.b_(j - this.f31145h);
    }

    protected static boolean a(com.google.android.exoplayer2.drm.e<?> eVar, DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (eVar == null) {
            return false;
        }
        return eVar.a(drmInitData);
    }
}
