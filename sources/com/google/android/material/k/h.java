package com.google.android.material.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.g.c;
import androidx.core.graphics.drawable.e;
import com.google.android.material.R;
import com.google.android.material.h.b;
import com.google.android.material.k.n;
import com.google.android.material.k.o;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.BitSet;

public class h extends Drawable implements e, p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36524a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f36525b = new Paint(1);
    public a G;
    public boolean H;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final o.f[] f36526c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final o.f[] f36527d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final BitSet f36528e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f36529f;

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f36530g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f36531h;

    /* renamed from: i  reason: collision with root package name */
    private final Path f36532i;
    private final RectF j;
    private final RectF k;
    private final Region l;
    private final Region m;
    private m n;
    private final Paint o;
    private final Paint p;
    private final com.google.android.material.j.a q;
    private final n.a r;
    private final n s;
    private PorterDuffColorFilter t;
    private PorterDuffColorFilter u;
    private final RectF v;

    private static int b(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    public int getOpacity() {
        return -3;
    }

    /* synthetic */ h(a aVar, byte b2) {
        this(aVar);
    }

    public static h a(Context context, float f2) {
        int a2 = b.a(context, R.attr.colorSurface, h.class.getSimpleName());
        h hVar = new h();
        hVar.a(context);
        hVar.g(ColorStateList.valueOf(a2));
        hVar.r(f2);
        return hVar;
    }

    public h() {
        this(new m());
    }

    public h(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(m.a(context, attributeSet, i2, i3).a());
    }

    public h(m mVar) {
        this(new a(mVar));
    }

    private h(a aVar) {
        this.f36526c = new o.f[4];
        this.f36527d = new o.f[4];
        this.f36528e = new BitSet(8);
        this.f36530g = new Matrix();
        this.f36531h = new Path();
        this.f36532i = new Path();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new Region();
        this.m = new Region();
        this.o = new Paint(1);
        this.p = new Paint(1);
        this.q = new com.google.android.material.j.a();
        this.s = new n();
        this.v = new RectF();
        this.H = true;
        this.G = aVar;
        this.p.setStyle(Paint.Style.STROKE);
        this.o.setStyle(Paint.Style.FILL);
        f36525b.setColor(-1);
        f36525b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        e();
        a(getState());
        this.r = new n.a() {
            public final void a(o oVar, Matrix matrix, int i2) {
                h.this.f36528e.set(i2, oVar.f36587g);
                h.this.f36526c[i2] = oVar.a(matrix);
            }

            public final void b(o oVar, Matrix matrix, int i2) {
                h.this.f36528e.set(i2 + 4, oVar.f36587g);
                h.this.f36527d[i2] = oVar.a(matrix);
            }
        };
    }

    public Drawable.ConstantState getConstantState() {
        return this.G;
    }

    public Drawable mutate() {
        this.G = new a(this.G);
        return this;
    }

    public void setShapeAppearanceModel(m mVar) {
        this.G.f36536a = mVar;
        invalidateSelf();
    }

    public final void g(ColorStateList colorStateList) {
        if (this.G.f36539d != colorStateList) {
            this.G.f36539d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void h(ColorStateList colorStateList) {
        if (this.G.f36540e != colorStateList) {
            this.G.f36540e = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.G.f36543h != mode) {
            this.G.f36543h = mode;
            e();
            super.invalidateSelf();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        this.G.f36542g = colorStateList;
        e();
        super.invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public final void a(float f2, int i2) {
        n(f2);
        h(ColorStateList.valueOf(i2));
    }

    public final void a(float f2, ColorStateList colorStateList) {
        n(f2);
        h(colorStateList);
    }

    public final void n(float f2) {
        this.G.l = f2;
        invalidateSelf();
    }

    public void setAlpha(int i2) {
        if (this.G.m != i2) {
            this.G.m = i2;
            super.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.G.f36538c = colorFilter;
        super.invalidateSelf();
    }

    public Region getTransparentRegion() {
        this.l.set(getBounds());
        b(g(), this.f36531h);
        this.m.setPath(this.f36531h, this.l);
        this.l.op(this.m, Region.Op.DIFFERENCE);
        return this.l;
    }

    /* access modifiers changed from: protected */
    public final RectF g() {
        this.j.set(getBounds());
        return this.j;
    }

    public final void o(float f2) {
        setShapeAppearanceModel(this.G.f36536a.a(f2));
    }

    public boolean getPadding(Rect rect) {
        if (this.G.f36544i == null) {
            return super.getPadding(rect);
        }
        rect.set(this.G.f36544i);
        return true;
    }

    public final void a(int i2, int i3) {
        if (this.G.f36544i == null) {
            this.G.f36544i = new Rect();
        }
        this.G.f36544i.set(0, i2, 0, i3);
        invalidateSelf();
    }

    public final void h() {
        if (this.G.q != 2) {
            this.G.q = 2;
            super.invalidateSelf();
        }
    }

    public final boolean i() {
        return this.G.f36537b != null && this.G.f36537b.f36266a;
    }

    public final void a(Context context) {
        this.G.f36537b = new com.google.android.material.e.a(context);
        b();
    }

    private int a(int i2) {
        return this.G.f36537b != null ? this.G.f36537b.a(i2, a() + this.G.n) : i2;
    }

    public final void p(float f2) {
        if (this.G.k != f2) {
            this.G.k = f2;
            this.f36529f = true;
            invalidateSelf();
        }
    }

    public final void q(float f2) {
        if (this.G.n != f2) {
            this.G.n = f2;
            b();
        }
    }

    public final void r(float f2) {
        if (this.G.o != f2) {
            this.G.o = f2;
            b();
        }
    }

    private void b() {
        float a2 = a();
        this.G.r = (int) Math.ceil((double) (0.75f * a2));
        this.G.s = (int) Math.ceil((double) (a2 * 0.25f));
        e();
        super.invalidateSelf();
    }

    public void invalidateSelf() {
        this.f36529f = true;
        super.invalidateSelf();
    }

    public final void j() {
        super.invalidateSelf();
    }

    public final void k() {
        this.q.a(-12303292);
        this.G.u = false;
        super.invalidateSelf();
    }

    private boolean c() {
        return (this.G.v == Paint.Style.FILL_AND_STROKE || this.G.v == Paint.Style.STROKE) && this.p.getStrokeWidth() > 0.0f;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f36529f = true;
        super.onBoundsChange(rect);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c8, code lost:
        if ((android.os.Build.VERSION.SDK_INT < 21 || (!q() && !r10.f36531h.isConvex() && android.os.Build.VERSION.SDK_INT < 29)) != false) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            android.graphics.Paint r0 = r10.o
            android.graphics.PorterDuffColorFilter r1 = r10.t
            r0.setColorFilter(r1)
            android.graphics.Paint r0 = r10.o
            int r0 = r0.getAlpha()
            android.graphics.Paint r1 = r10.o
            com.google.android.material.k.h$a r2 = r10.G
            int r2 = r2.m
            int r2 = b((int) r0, (int) r2)
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r10.p
            android.graphics.PorterDuffColorFilter r2 = r10.u
            r1.setColorFilter(r2)
            android.graphics.Paint r1 = r10.p
            com.google.android.material.k.h$a r2 = r10.G
            float r2 = r2.l
            r1.setStrokeWidth(r2)
            android.graphics.Paint r1 = r10.p
            int r1 = r1.getAlpha()
            android.graphics.Paint r2 = r10.p
            com.google.android.material.k.h$a r3 = r10.G
            int r3 = r3.m
            int r3 = b((int) r1, (int) r3)
            r2.setAlpha(r3)
            boolean r2 = r10.f36529f
            r3 = 0
            if (r2 == 0) goto L_0x0096
            float r2 = r10.f()
            float r2 = -r2
            com.google.android.material.k.h$a r4 = r10.G
            com.google.android.material.k.m r4 = r4.f36536a
            com.google.android.material.k.h$2 r5 = new com.google.android.material.k.h$2
            r5.<init>(r2)
            com.google.android.material.k.m$a r2 = r4.b()
            com.google.android.material.k.c r6 = r4.f36554f
            com.google.android.material.k.c r6 = r5.a(r6)
            r2.f36562e = r6
            com.google.android.material.k.c r6 = r4.f36555g
            com.google.android.material.k.c r6 = r5.a(r6)
            r2.f36563f = r6
            com.google.android.material.k.c r6 = r4.f36557i
            com.google.android.material.k.c r6 = r5.a(r6)
            r2.f36565h = r6
            com.google.android.material.k.c r4 = r4.f36556h
            com.google.android.material.k.c r4 = r5.a(r4)
            r2.f36564g = r4
            com.google.android.material.k.m r2 = r2.a()
            r10.n = r2
            com.google.android.material.k.n r2 = r10.s
            com.google.android.material.k.m r4 = r10.n
            com.google.android.material.k.h$a r5 = r10.G
            float r5 = r5.k
            android.graphics.RectF r6 = r10.r()
            android.graphics.Path r7 = r10.f36532i
            r2.a(r4, r5, r6, r7)
            android.graphics.RectF r2 = r10.g()
            android.graphics.Path r4 = r10.f36531h
            r10.b((android.graphics.RectF) r2, (android.graphics.Path) r4)
            r10.f36529f = r3
        L_0x0096:
            com.google.android.material.k.h$a r2 = r10.G
            int r2 = r2.q
            r4 = 21
            r5 = 2
            r6 = 1
            if (r2 == r6) goto L_0x00cc
            com.google.android.material.k.h$a r2 = r10.G
            int r2 = r2.r
            if (r2 <= 0) goto L_0x00cc
            com.google.android.material.k.h$a r2 = r10.G
            int r2 = r2.q
            if (r2 == r5) goto L_0x00ca
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r4) goto L_0x00c7
            boolean r2 = r10.q()
            if (r2 != 0) goto L_0x00c5
            android.graphics.Path r2 = r10.f36531h
            boolean r2 = r2.isConvex()
            if (r2 != 0) goto L_0x00c5
            int r2 = android.os.Build.VERSION.SDK_INT
            r7 = 29
            if (r2 >= r7) goto L_0x00c5
            goto L_0x00c7
        L_0x00c5:
            r2 = 0
            goto L_0x00c8
        L_0x00c7:
            r2 = 1
        L_0x00c8:
            if (r2 == 0) goto L_0x00cc
        L_0x00ca:
            r2 = 1
            goto L_0x00cd
        L_0x00cc:
            r2 = 0
        L_0x00cd:
            if (r2 == 0) goto L_0x0190
            r11.save()
            int r2 = r10.d()
            int r7 = r10.l()
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 >= r4) goto L_0x00fb
            boolean r4 = r10.H
            if (r4 == 0) goto L_0x00fb
            android.graphics.Rect r4 = r11.getClipBounds()
            com.google.android.material.k.h$a r8 = r10.G
            int r8 = r8.r
            int r8 = -r8
            com.google.android.material.k.h$a r9 = r10.G
            int r9 = r9.r
            int r9 = -r9
            r4.inset(r8, r9)
            r4.offset(r2, r7)
            android.graphics.Region$Op r8 = android.graphics.Region.Op.REPLACE
            r11.clipRect(r4, r8)
        L_0x00fb:
            float r2 = (float) r2
            float r4 = (float) r7
            r11.translate(r2, r4)
            boolean r2 = r10.H
            if (r2 != 0) goto L_0x010c
            r10.a((android.graphics.Canvas) r11)
            r11.restore()
            goto L_0x0190
        L_0x010c:
            android.graphics.RectF r2 = r10.v
            float r2 = r2.width()
            android.graphics.Rect r4 = r10.getBounds()
            int r4 = r4.width()
            float r4 = (float) r4
            float r2 = r2 - r4
            int r2 = (int) r2
            android.graphics.RectF r4 = r10.v
            float r4 = r4.height()
            android.graphics.Rect r7 = r10.getBounds()
            int r7 = r7.height()
            float r7 = (float) r7
            float r4 = r4 - r7
            int r4 = (int) r4
            if (r2 < 0) goto L_0x0188
            if (r4 < 0) goto L_0x0188
            android.graphics.RectF r7 = r10.v
            float r7 = r7.width()
            int r7 = (int) r7
            com.google.android.material.k.h$a r8 = r10.G
            int r8 = r8.r
            int r8 = r8 * 2
            int r7 = r7 + r8
            int r7 = r7 + r2
            android.graphics.RectF r8 = r10.v
            float r8 = r8.height()
            int r8 = (int) r8
            com.google.android.material.k.h$a r9 = r10.G
            int r9 = r9.r
            int r9 = r9 * 2
            int r8 = r8 + r9
            int r8 = r8 + r4
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r7, r8, r5)
            android.graphics.Canvas r7 = new android.graphics.Canvas
            r7.<init>(r5)
            android.graphics.Rect r8 = r10.getBounds()
            int r8 = r8.left
            com.google.android.material.k.h$a r9 = r10.G
            int r9 = r9.r
            int r8 = r8 - r9
            int r8 = r8 - r2
            float r2 = (float) r8
            android.graphics.Rect r8 = r10.getBounds()
            int r8 = r8.top
            com.google.android.material.k.h$a r9 = r10.G
            int r9 = r9.r
            int r8 = r8 - r9
            int r8 = r8 - r4
            float r4 = (float) r8
            float r8 = -r2
            float r9 = -r4
            r7.translate(r8, r9)
            r10.a((android.graphics.Canvas) r7)
            r7 = 0
            r11.drawBitmap(r5, r2, r4, r7)
            r5.recycle()
            r11.restore()
            goto L_0x0190
        L_0x0188:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "Invalid shadow bounds. Check that the treatments result in a valid path."
            r11.<init>(r0)
            throw r11
        L_0x0190:
            com.google.android.material.k.h$a r2 = r10.G
            android.graphics.Paint$Style r2 = r2.v
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL_AND_STROKE
            if (r2 == r4) goto L_0x01a0
            com.google.android.material.k.h$a r2 = r10.G
            android.graphics.Paint$Style r2 = r2.v
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            if (r2 != r4) goto L_0x01a1
        L_0x01a0:
            r3 = 1
        L_0x01a1:
            if (r3 == 0) goto L_0x01b4
            android.graphics.Paint r6 = r10.o
            android.graphics.Path r7 = r10.f36531h
            com.google.android.material.k.h$a r2 = r10.G
            com.google.android.material.k.m r8 = r2.f36536a
            android.graphics.RectF r9 = r10.g()
            r4 = r10
            r5 = r11
            r4.a(r5, r6, r7, r8, r9)
        L_0x01b4:
            boolean r2 = r10.c()
            if (r2 == 0) goto L_0x01c9
            android.graphics.Paint r5 = r10.p
            android.graphics.Path r6 = r10.f36532i
            com.google.android.material.k.m r7 = r10.n
            android.graphics.RectF r8 = r10.r()
            r3 = r10
            r4 = r11
            r3.a(r4, r5, r6, r7, r8)
        L_0x01c9:
            android.graphics.Paint r11 = r10.o
            r11.setAlpha(r0)
            android.graphics.Paint r11 = r10.p
            r11.setAlpha(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.k.h.draw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public final void a(Canvas canvas, Paint paint, Path path, m mVar, RectF rectF) {
        if (mVar.a(rectF)) {
            float a2 = mVar.f36555g.a(rectF) * this.G.k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(Canvas canvas) {
        this.f36528e.cardinality();
        if (this.G.s != 0) {
            canvas.drawPath(this.f36531h, this.q.f36513a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.f36526c[i2].a(this.q, this.G.r, canvas);
            this.f36527d[i2].a(this.q, this.G.r, canvas);
        }
        if (this.H) {
            int d2 = d();
            int l2 = l();
            canvas.translate((float) (-d2), (float) (-l2));
            canvas.drawPath(this.f36531h, f36525b);
            canvas.translate((float) d2, (float) l2);
        }
    }

    private int d() {
        return (int) (((double) this.G.s) * Math.sin(Math.toRadians((double) this.G.t)));
    }

    public final int l() {
        return (int) (((double) this.G.s) * Math.cos(Math.toRadians((double) this.G.t)));
    }

    /* access modifiers changed from: protected */
    public final void a(RectF rectF, Path path) {
        this.s.a(this.G.f36536a, this.G.k, rectF, this.r, path);
    }

    public void getOutline(Outline outline) {
        if (this.G.q != 2) {
            if (q()) {
                outline.setRoundRect(getBounds(), m() * this.G.k);
                return;
            }
            b(g(), this.f36531h);
            if (this.f36531h.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.f36531h);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    private void b(RectF rectF, Path path) {
        a(rectF, path);
        if (this.G.j != 1.0f) {
            this.f36530g.reset();
            this.f36530g.setScale(this.G.j, this.G.j, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f36530g);
        }
        path.computeBounds(this.v, true);
    }

    private boolean e() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        this.t = a(this.G.f36542g, this.G.f36543h, this.o, true);
        this.u = a(this.G.f36541f, this.G.f36543h, this.p, false);
        if (this.G.u) {
            this.q.a(this.G.f36542g.getColorForState(getState(), 0));
        }
        if (!c.a(porterDuffColorFilter, this.t) || !c.a(porterDuffColorFilter2, this.u)) {
            return true;
        }
        return false;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        if (colorStateList == null || mode == null) {
            return a(paint, z);
        }
        return a(colorStateList, mode, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.getColor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.PorterDuffColorFilter a(android.graphics.Paint r2, boolean r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0014
            int r2 = r2.getColor()
            int r3 = r1.a((int) r2)
            if (r3 == r2) goto L_0x0014
            android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.<init>(r3, r0)
            return r2
        L_0x0014:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.k.h.a(android.graphics.Paint, boolean):android.graphics.PorterDuffColorFilter");
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = a(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        if (this.G.f36542g != null && this.G.f36542g.isStateful()) {
            return true;
        }
        if (this.G.f36541f != null && this.G.f36541f.isStateful()) {
            return true;
        }
        if (this.G.f36540e == null || !this.G.f36540e.isStateful()) {
            return this.G.f36539d != null && this.G.f36539d.isStateful();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z = a(iArr) || e();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    private boolean a(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.G.f36539d == null || (color2 = this.o.getColor()) == (colorForState2 = this.G.f36539d.getColorForState(iArr, color2))) {
            z = false;
        } else {
            this.o.setColor(colorForState2);
            z = true;
        }
        if (this.G.f36540e == null || (color = this.p.getColor()) == (colorForState = this.G.f36540e.getColorForState(iArr, color))) {
            return z;
        }
        this.p.setColor(colorForState);
        return true;
    }

    private float f() {
        if (c()) {
            return this.p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private RectF r() {
        this.k.set(g());
        float f2 = f();
        this.k.inset(f2, f2);
        return this.k;
    }

    public final float m() {
        return this.G.f36536a.f36554f.a(g());
    }

    public final float n() {
        return this.G.f36536a.f36555g.a(g());
    }

    public final float o() {
        return this.G.f36536a.f36557i.a(g());
    }

    public final float p() {
        return this.G.f36536a.f36556h.a(g());
    }

    public final boolean q() {
        return this.G.f36536a.a(g());
    }

    public static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public m f36536a;

        /* renamed from: b  reason: collision with root package name */
        public com.google.android.material.e.a f36537b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f36538c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f36539d = null;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f36540e = null;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f36541f = null;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f36542g = null;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f36543h = PorterDuff.Mode.SRC_IN;

        /* renamed from: i  reason: collision with root package name */
        public Rect f36544i = null;
        public float j = 1.0f;
        public float k = 1.0f;
        public float l;
        public int m = PriceRangeSeekBar.INVALID_POINTER_ID;
        public float n = 0.0f;
        public float o = 0.0f;
        public float p = 0.0f;
        public int q = 0;
        public int r = 0;
        public int s = 0;
        public int t = 0;
        public boolean u = false;
        public Paint.Style v = Paint.Style.FILL_AND_STROKE;

        public final int getChangingConfigurations() {
            return 0;
        }

        public a(m mVar) {
            this.f36536a = mVar;
            this.f36537b = null;
        }

        public a(a aVar) {
            this.f36536a = aVar.f36536a;
            this.f36537b = aVar.f36537b;
            this.l = aVar.l;
            this.f36538c = aVar.f36538c;
            this.f36539d = aVar.f36539d;
            this.f36540e = aVar.f36540e;
            this.f36543h = aVar.f36543h;
            this.f36542g = aVar.f36542g;
            this.m = aVar.m;
            this.j = aVar.j;
            this.s = aVar.s;
            this.q = aVar.q;
            this.u = aVar.u;
            this.k = aVar.k;
            this.n = aVar.n;
            this.o = aVar.o;
            this.p = aVar.p;
            this.r = aVar.r;
            this.t = aVar.t;
            this.f36541f = aVar.f36541f;
            this.v = aVar.v;
            Rect rect = aVar.f36544i;
            if (rect != null) {
                this.f36544i = new Rect(rect);
            }
        }

        public final Drawable newDrawable() {
            h hVar = new h(this, (byte) 0);
            boolean unused = hVar.f36529f = true;
            return hVar;
        }
    }

    private float a() {
        return this.G.o + this.G.p;
    }
}
