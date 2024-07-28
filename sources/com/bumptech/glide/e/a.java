package com.bumptech.glide.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.bumptech.glide.e.a;
import com.bumptech.glide.f;
import com.bumptech.glide.f.c;
import com.bumptech.glide.g.b;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.d.a.k;
import com.bumptech.glide.load.d.a.l;
import com.bumptech.glide.load.d.a.n;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.d.a.q;
import com.bumptech.glide.load.d.a.s;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.m;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Map;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class a<T extends a<T>> implements Cloneable {
    boolean A = true;
    boolean B;

    /* renamed from: c  reason: collision with root package name */
    int f6505c;

    /* renamed from: d  reason: collision with root package name */
    float f6506d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    j f6507e = j.f6879e;

    /* renamed from: f  reason: collision with root package name */
    protected f f6508f = f.NORMAL;

    /* renamed from: g  reason: collision with root package name */
    Drawable f6509g;

    /* renamed from: h  reason: collision with root package name */
    int f6510h;

    /* renamed from: i  reason: collision with root package name */
    Drawable f6511i;
    int j;
    public boolean k = true;
    protected int l = -1;
    protected int m = -1;
    g n = c.a();
    boolean o;
    protected boolean p = true;
    Drawable q;
    int r;
    i s = new i();
    Map<Class<?>, m<?>> t = new b();
    Class<?> u = Object.class;
    public boolean v;
    Resources.Theme w;
    public boolean x;
    boolean y;
    boolean z;

    private static boolean b(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public final T b(float f2) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        aVar.f6506d = f2;
        aVar.f6505c |= 2;
        return aVar.m();
    }

    public final T d() {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.B = true;
        aVar.f6505c |= 1048576;
        return aVar.m();
    }

    public final T a(j jVar) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.f6507e = (j) com.bumptech.glide.g.j.a(jVar, "Argument must not be null");
        aVar.f6505c |= 4;
        return aVar.m();
    }

    public final T a(f fVar) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.f6508f = (f) com.bumptech.glide.g.j.a(fVar, "Argument must not be null");
        aVar.f6505c |= 8;
        return aVar.m();
    }

    public final T b(Drawable drawable) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.f6511i = drawable;
        aVar.f6505c |= 64;
        aVar.j = 0;
        aVar.f6505c &= -129;
        return aVar.m();
    }

    public final T a(int i2) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.j = i2;
        aVar.f6505c |= 128;
        aVar.f6511i = null;
        aVar.f6505c &= -65;
        return aVar.m();
    }

    public final T c(Drawable drawable) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.q = drawable;
        aVar.f6505c |= FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE;
        aVar.r = 0;
        aVar.f6505c &= -16385;
        return aVar.m();
    }

    public final T b(int i2) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.r = i2;
        aVar.f6505c |= 16384;
        aVar.q = null;
        aVar.f6505c &= -8193;
        return aVar.m();
    }

    public final T d(Drawable drawable) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.f6509g = drawable;
        aVar.f6505c |= 16;
        aVar.f6510h = 0;
        aVar.f6505c &= -33;
        return aVar.m();
    }

    public final T c(int i2) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.f6510h = i2;
        aVar.f6505c |= 32;
        aVar.f6509g = null;
        aVar.f6505c &= -17;
        return aVar.m();
    }

    public final T a(boolean z2) {
        boolean z3 = z2;
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
            z3 = true;
        }
        aVar.k = true ^ z3;
        aVar.f6505c |= UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
        return aVar.m();
    }

    public final T a(int i2, int i3) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.m = i2;
        aVar.l = i3;
        aVar.f6505c |= 512;
        return aVar.m();
    }

    public final T a(g gVar) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.n = (g) com.bumptech.glide.g.j.a(gVar, "Argument must not be null");
        aVar.f6505c |= TarConstants.EOF_BLOCK;
        return aVar.m();
    }

    /* renamed from: c */
    public T clone() {
        try {
            T t2 = (a) super.clone();
            t2.s = new i();
            t2.s.a(this.s);
            t2.t = new b();
            t2.t.putAll(this.t);
            t2.v = false;
            t2.x = false;
            return t2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    private <Y> T a(h<Y> hVar, Y y2) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        com.bumptech.glide.g.j.a(hVar, "Argument must not be null");
        com.bumptech.glide.g.j.a(y2, "Argument must not be null");
        aVar.s.a(hVar, y2);
        return aVar.m();
    }

    private T a(n nVar) {
        return a(n.f7157h, com.bumptech.glide.g.j.a(nVar, "Argument must not be null"));
    }

    public final T e() {
        return a(com.bumptech.glide.load.c.a.a.f6981a, Integer.valueOf(AppConstants.NOT_TIME));
    }

    public final T f() {
        return b(n.f7154e, (m<Bitmap>) new com.bumptech.glide.load.d.a.j());
    }

    public final T g() {
        return a(n.f7152c, (m<Bitmap>) new s(), true);
    }

    public final T h() {
        return a(n.f7153d, (m<Bitmap>) new k(), false);
    }

    public final T i() {
        return a(n.f7153d, (m<Bitmap>) new k(), true);
    }

    public final T j() {
        return b(n.f7153d, (m<Bitmap>) new l());
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.bumptech.glide.load.m, com.bumptech.glide.load.m<android.graphics.Bitmap>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T a(com.bumptech.glide.load.d.a.n r3, com.bumptech.glide.load.m<android.graphics.Bitmap> r4) {
        /*
            r2 = this;
            r0 = r2
        L_0x0001:
            boolean r1 = r0.x
            if (r1 == 0) goto L_0x000a
            com.bumptech.glide.e.a r0 = r0.clone()
            goto L_0x0001
        L_0x000a:
            r0.a((com.bumptech.glide.load.d.a.n) r3)
            r3 = 0
            com.bumptech.glide.e.a r3 = r0.a((com.bumptech.glide.load.m<android.graphics.Bitmap>) r4, (boolean) r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.a.a(com.bumptech.glide.load.d.a.n, com.bumptech.glide.load.m):com.bumptech.glide.e.a");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.bumptech.glide.load.m, com.bumptech.glide.load.m<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T b(com.bumptech.glide.load.d.a.n r3, com.bumptech.glide.load.m<android.graphics.Bitmap> r4) {
        /*
            r2 = this;
            r0 = r2
        L_0x0001:
            boolean r1 = r0.x
            if (r1 == 0) goto L_0x000a
            com.bumptech.glide.e.a r0 = r0.clone()
            goto L_0x0001
        L_0x000a:
            r0.a((com.bumptech.glide.load.d.a.n) r3)
            r3 = 1
            com.bumptech.glide.e.a r3 = r0.a((com.bumptech.glide.load.m<android.graphics.Bitmap>) r4, (boolean) r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.a.b(com.bumptech.glide.load.d.a.n, com.bumptech.glide.load.m):com.bumptech.glide.e.a");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.m, com.bumptech.glide.load.m<android.graphics.Bitmap>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T a(com.bumptech.glide.load.d.a.n r1, com.bumptech.glide.load.m<android.graphics.Bitmap> r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x0007
            com.bumptech.glide.e.a r1 = r0.b((com.bumptech.glide.load.d.a.n) r1, (com.bumptech.glide.load.m<android.graphics.Bitmap>) r2)
            goto L_0x000b
        L_0x0007:
            com.bumptech.glide.e.a r1 = r0.a((com.bumptech.glide.load.d.a.n) r1, (com.bumptech.glide.load.m<android.graphics.Bitmap>) r2)
        L_0x000b:
            r2 = 1
            r1.A = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.a.a(com.bumptech.glide.load.d.a.n, com.bumptech.glide.load.m, boolean):com.bumptech.glide.e.a");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.m, com.bumptech.glide.load.m<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T a(com.bumptech.glide.load.m<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.e.a r2 = r1.a((com.bumptech.glide.load.m<android.graphics.Bitmap>) r2, (boolean) r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.a.a(com.bumptech.glide.load.m):com.bumptech.glide.e.a");
    }

    public final T a(m<Bitmap> mVar, boolean z2) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        q qVar = new q(mVar, z2);
        aVar.a(Bitmap.class, mVar, z2);
        aVar.a(Drawable.class, qVar, z2);
        aVar.a(BitmapDrawable.class, qVar, z2);
        aVar.a(com.bumptech.glide.load.d.e.c.class, new com.bumptech.glide.load.d.e.f(mVar), z2);
        return aVar.m();
    }

    private <Y> T a(Class<Y> cls, m<Y> mVar, boolean z2) {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        com.bumptech.glide.g.j.a(cls, "Argument must not be null");
        com.bumptech.glide.g.j.a(mVar, "Argument must not be null");
        aVar.t.put(cls, mVar);
        aVar.f6505c |= EmiUtil.EMI_PLAN_REQUEST_CODE;
        aVar.p = true;
        aVar.f6505c |= 65536;
        aVar.A = false;
        if (z2) {
            aVar.f6505c |= 131072;
            aVar.o = true;
        }
        return aVar.m();
    }

    public final T k() {
        a aVar = this;
        while (aVar.x) {
            aVar = aVar.clone();
        }
        aVar.t.clear();
        aVar.f6505c &= -2049;
        aVar.o = false;
        aVar.f6505c &= -131073;
        aVar.p = false;
        aVar.f6505c |= 65536;
        aVar.A = true;
        return aVar.m();
    }

    public final T l() {
        return a(com.bumptech.glide.load.d.e.i.f7241b, Boolean.TRUE);
    }

    public T b(a<?> aVar) {
        if (this.x) {
            return clone().b(aVar);
        }
        if (b(aVar.f6505c, 2)) {
            this.f6506d = aVar.f6506d;
        }
        if (b(aVar.f6505c, 262144)) {
            this.y = aVar.y;
        }
        if (b(aVar.f6505c, 1048576)) {
            this.B = aVar.B;
        }
        if (b(aVar.f6505c, 4)) {
            this.f6507e = aVar.f6507e;
        }
        if (b(aVar.f6505c, 8)) {
            this.f6508f = aVar.f6508f;
        }
        if (b(aVar.f6505c, 16)) {
            this.f6509g = aVar.f6509g;
            this.f6510h = 0;
            this.f6505c &= -33;
        }
        if (b(aVar.f6505c, 32)) {
            this.f6510h = aVar.f6510h;
            this.f6509g = null;
            this.f6505c &= -17;
        }
        if (b(aVar.f6505c, 64)) {
            this.f6511i = aVar.f6511i;
            this.j = 0;
            this.f6505c &= -129;
        }
        if (b(aVar.f6505c, 128)) {
            this.j = aVar.j;
            this.f6511i = null;
            this.f6505c &= -65;
        }
        if (b(aVar.f6505c, (int) UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS)) {
            this.k = aVar.k;
        }
        if (b(aVar.f6505c, 512)) {
            this.m = aVar.m;
            this.l = aVar.l;
        }
        if (b(aVar.f6505c, (int) TarConstants.EOF_BLOCK)) {
            this.n = aVar.n;
        }
        if (b(aVar.f6505c, 4096)) {
            this.u = aVar.u;
        }
        if (b(aVar.f6505c, (int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE)) {
            this.q = aVar.q;
            this.r = 0;
            this.f6505c &= -16385;
        }
        if (b(aVar.f6505c, 16384)) {
            this.r = aVar.r;
            this.q = null;
            this.f6505c &= -8193;
        }
        if (b(aVar.f6505c, 32768)) {
            this.w = aVar.w;
        }
        if (b(aVar.f6505c, 65536)) {
            this.p = aVar.p;
        }
        if (b(aVar.f6505c, 131072)) {
            this.o = aVar.o;
        }
        if (b(aVar.f6505c, (int) EmiUtil.EMI_PLAN_REQUEST_CODE)) {
            this.t.putAll(aVar.t);
            this.A = aVar.A;
        }
        if (b(aVar.f6505c, 524288)) {
            this.z = aVar.z;
        }
        if (!this.p) {
            this.t.clear();
            this.f6505c &= -2049;
            this.o = false;
            this.f6505c &= -131073;
            this.A = true;
        }
        this.f6505c |= aVar.f6505c;
        this.s.a(aVar.s);
        return m();
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (Float.compare(aVar.f6506d, this.f6506d) == 0 && this.f6510h == aVar.f6510h && com.bumptech.glide.g.k.a((Object) this.f6509g, (Object) aVar.f6509g) && this.j == aVar.j && com.bumptech.glide.g.k.a((Object) this.f6511i, (Object) aVar.f6511i) && this.r == aVar.r && com.bumptech.glide.g.k.a((Object) this.q, (Object) aVar.q) && this.k == aVar.k && this.l == aVar.l && this.m == aVar.m && this.o == aVar.o && this.p == aVar.p && this.y == aVar.y && this.z == aVar.z && this.f6507e.equals(aVar.f6507e) && this.f6508f == aVar.f6508f && this.s.equals(aVar.s) && this.t.equals(aVar.t) && this.u.equals(aVar.u) && com.bumptech.glide.g.k.a((Object) this.n, (Object) aVar.n) && com.bumptech.glide.g.k.a((Object) this.w, (Object) aVar.w)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return com.bumptech.glide.g.k.a((Object) this.w, com.bumptech.glide.g.k.a((Object) this.n, com.bumptech.glide.g.k.a((Object) this.u, com.bumptech.glide.g.k.a((Object) this.t, com.bumptech.glide.g.k.a((Object) this.s, com.bumptech.glide.g.k.a((Object) this.f6508f, com.bumptech.glide.g.k.a((Object) this.f6507e, com.bumptech.glide.g.k.a(this.z, com.bumptech.glide.g.k.a(this.y, com.bumptech.glide.g.k.a(this.p, com.bumptech.glide.g.k.a(this.o, com.bumptech.glide.g.k.b(this.m, com.bumptech.glide.g.k.b(this.l, com.bumptech.glide.g.k.a(this.k, com.bumptech.glide.g.k.a((Object) this.q, com.bumptech.glide.g.k.b(this.r, com.bumptech.glide.g.k.a((Object) this.f6511i, com.bumptech.glide.g.k.b(this.j, com.bumptech.glide.g.k.a((Object) this.f6509g, com.bumptech.glide.g.k.b(this.f6510h, com.bumptech.glide.g.k.a(this.f6506d)))))))))))))))))))));
    }

    /* access modifiers changed from: package-private */
    public final T m() {
        if (!this.v) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final boolean n() {
        return com.bumptech.glide.g.k.a(this.m, this.l);
    }

    /* access modifiers changed from: protected */
    public final boolean d(int i2) {
        return b(this.f6505c, i2);
    }

    public final T a(com.bumptech.glide.load.b bVar) {
        com.bumptech.glide.g.j.a(bVar, "Argument must not be null");
        return a(o.f7159a, bVar).a(com.bumptech.glide.load.d.e.i.f7240a, bVar);
    }
}
