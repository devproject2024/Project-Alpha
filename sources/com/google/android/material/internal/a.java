package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.core.h.e;
import androidx.core.h.u;
import com.google.android.material.h.a;
import com.google.android.material.h.d;
import com.google.android.material.h.f;
import com.google.android.material.internal.h;

public final class a {
    private static final boolean l = (Build.VERSION.SDK_INT < 18);
    private static final Paint m = null;
    private Typeface A;
    private com.google.android.material.h.a B;
    private com.google.android.material.h.a C;
    private CharSequence D;
    private boolean E;
    private boolean F;
    private Bitmap G;
    private Paint H;
    private float I;
    private float J;
    private int[] K;
    private boolean L;
    private final TextPaint M;
    private TimeInterpolator N;
    private float O;
    private float P;
    private float Q;
    private ColorStateList R;
    private float S;
    private float T;
    private float U;
    private ColorStateList V;
    private StaticLayout W;
    private float X;
    private float Y;
    private float Z;

    /* renamed from: a  reason: collision with root package name */
    public float f36432a;
    private CharSequence aa;

    /* renamed from: b  reason: collision with root package name */
    public int f36433b = 16;

    /* renamed from: c  reason: collision with root package name */
    public int f36434c = 16;

    /* renamed from: d  reason: collision with root package name */
    public float f36435d = 15.0f;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f36436e;

    /* renamed from: f  reason: collision with root package name */
    public Typeface f36437f;

    /* renamed from: g  reason: collision with root package name */
    public Typeface f36438g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f36439h;

    /* renamed from: i  reason: collision with root package name */
    public final TextPaint f36440i;
    public TimeInterpolator j;
    public int k = 1;
    private final View n;
    private boolean o;
    private final Rect p;
    private final Rect q;
    private final RectF r;
    private float s = 15.0f;
    private ColorStateList t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    public a(View view) {
        this.n = view;
        this.M = new TextPaint(129);
        this.f36440i = new TextPaint(this.M);
        this.q = new Rect();
        this.p = new Rect();
        this.r = new RectF();
    }

    public final void a(TimeInterpolator timeInterpolator) {
        this.N = timeInterpolator;
        c();
    }

    public final void a(float f2) {
        if (this.f36435d != f2) {
            this.f36435d = f2;
            c();
        }
    }

    public final void a(ColorStateList colorStateList) {
        if (this.f36436e != colorStateList) {
            this.f36436e = colorStateList;
            c();
        }
    }

    public final void b(ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            c();
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        if (!a(this.p, i2, i3, i4, i5)) {
            this.p.set(i2, i3, i4, i5);
            this.L = true;
            e();
        }
    }

    public final void b(int i2, int i3, int i4, int i5) {
        if (!a(this.q, i2, i3, i4, i5)) {
            this.q.set(i2, i3, i4, i5);
            this.L = true;
            e();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.graphics.RectF r8, int r9, int r10) {
        /*
            r7 = this;
            java.lang.CharSequence r0 = r7.f36439h
            boolean r0 = r7.b((java.lang.CharSequence) r0)
            r7.E = r0
            r0 = 1
            r1 = 17
            r2 = 5
            r3 = 8388613(0x800005, float:1.175495E-38)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r10 == r1) goto L_0x0043
            r5 = r10 & 7
            if (r5 != r0) goto L_0x0018
            goto L_0x0043
        L_0x0018:
            r5 = r10 & r3
            if (r5 == r3) goto L_0x002f
            r5 = r10 & 5
            if (r5 != r2) goto L_0x0021
            goto L_0x002f
        L_0x0021:
            boolean r5 = r7.E
            if (r5 == 0) goto L_0x003d
            android.graphics.Rect r5 = r7.q
            int r5 = r5.right
            float r5 = (float) r5
            float r6 = r7.d()
            goto L_0x004a
        L_0x002f:
            boolean r5 = r7.E
            if (r5 != 0) goto L_0x003d
            android.graphics.Rect r5 = r7.q
            int r5 = r5.right
            float r5 = (float) r5
            float r6 = r7.d()
            goto L_0x004a
        L_0x003d:
            android.graphics.Rect r5 = r7.q
            int r5 = r5.left
            float r5 = (float) r5
            goto L_0x004b
        L_0x0043:
            float r5 = (float) r9
            float r5 = r5 / r4
            float r6 = r7.d()
            float r6 = r6 / r4
        L_0x004a:
            float r5 = r5 - r6
        L_0x004b:
            r8.left = r5
            android.graphics.Rect r5 = r7.q
            int r5 = r5.top
            float r5 = (float) r5
            r8.top = r5
            if (r10 == r1) goto L_0x007e
            r1 = r10 & 7
            if (r1 != r0) goto L_0x005b
            goto L_0x007e
        L_0x005b:
            r9 = r10 & r3
            if (r9 == r3) goto L_0x006d
            r9 = r10 & 5
            if (r9 != r2) goto L_0x0064
            goto L_0x006d
        L_0x0064:
            boolean r9 = r7.E
            if (r9 == 0) goto L_0x0077
            android.graphics.Rect r9 = r7.q
            int r9 = r9.right
            goto L_0x0075
        L_0x006d:
            boolean r9 = r7.E
            if (r9 != 0) goto L_0x0077
            android.graphics.Rect r9 = r7.q
            int r9 = r9.right
        L_0x0075:
            float r9 = (float) r9
            goto L_0x0086
        L_0x0077:
            float r9 = r8.left
            float r10 = r7.d()
            goto L_0x0085
        L_0x007e:
            float r9 = (float) r9
            float r9 = r9 / r4
            float r10 = r7.d()
            float r10 = r10 / r4
        L_0x0085:
            float r9 = r9 + r10
        L_0x0086:
            r8.right = r9
            android.graphics.Rect r9 = r7.q
            int r9 = r9.top
            float r9 = (float) r9
            float r10 = r7.a()
            float r9 = r9 + r10
            r8.bottom = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.a.a(android.graphics.RectF, int, int):void");
    }

    private float d() {
        if (this.f36439h == null) {
            return 0.0f;
        }
        a(this.f36440i);
        TextPaint textPaint = this.f36440i;
        CharSequence charSequence = this.f36439h;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public final float a() {
        a(this.f36440i);
        return -this.f36440i.ascent();
    }

    private void a(TextPaint textPaint) {
        textPaint.setTextSize(this.s);
        textPaint.setTypeface(this.f36437f);
    }

    private void e() {
        this.o = this.q.width() > 0 && this.q.height() > 0 && this.p.width() > 0 && this.p.height() > 0;
    }

    public final void a(int i2) {
        if (this.f36433b != i2) {
            this.f36433b = i2;
            c();
        }
    }

    public final void b(int i2) {
        if (this.f36434c != i2) {
            this.f36434c = i2;
            c();
        }
    }

    public final void c(int i2) {
        d dVar = new d(this.n.getContext(), i2);
        if (dVar.f36363b != null) {
            this.f36436e = dVar.f36363b;
        }
        if (dVar.f36362a != 0.0f) {
            this.s = dVar.f36362a;
        }
        if (dVar.f36370i != null) {
            this.R = dVar.f36370i;
        }
        this.P = dVar.j;
        this.Q = dVar.k;
        this.O = dVar.l;
        com.google.android.material.h.a aVar = this.C;
        if (aVar != null) {
            aVar.f36359a = true;
        }
        this.C = new com.google.android.material.h.a(new a.C0606a() {
            public final void a(Typeface typeface) {
                a.this.a(typeface);
            }
        }, dVar.a());
        dVar.a(this.n.getContext(), (f) this.C);
        c();
    }

    public final void d(int i2) {
        d dVar = new d(this.n.getContext(), i2);
        if (dVar.f36363b != null) {
            this.t = dVar.f36363b;
        }
        if (dVar.f36362a != 0.0f) {
            this.f36435d = dVar.f36362a;
        }
        if (dVar.f36370i != null) {
            this.V = dVar.f36370i;
        }
        this.T = dVar.j;
        this.U = dVar.k;
        this.S = dVar.l;
        com.google.android.material.h.a aVar = this.B;
        if (aVar != null) {
            aVar.f36359a = true;
        }
        this.B = new com.google.android.material.h.a(new a.C0606a() {
            public final void a(Typeface typeface) {
                a.this.b(typeface);
            }
        }, dVar.a());
        dVar.a(this.n.getContext(), (f) this.B);
        c();
    }

    public final void a(Typeface typeface) {
        if (d(typeface)) {
            c();
        }
    }

    public final void b(Typeface typeface) {
        if (e(typeface)) {
            c();
        }
    }

    public final void c(Typeface typeface) {
        boolean d2 = d(typeface);
        boolean e2 = e(typeface);
        if (d2 || e2) {
            c();
        }
    }

    private boolean d(Typeface typeface) {
        com.google.android.material.h.a aVar = this.C;
        if (aVar != null) {
            aVar.f36359a = true;
        }
        if (this.f36437f == typeface) {
            return false;
        }
        this.f36437f = typeface;
        return true;
    }

    private boolean e(Typeface typeface) {
        com.google.android.material.h.a aVar = this.B;
        if (aVar != null) {
            aVar.f36359a = true;
        }
        if (this.f36438g == typeface) {
            return false;
        }
        this.f36438g = typeface;
        return true;
    }

    public final void b(float f2) {
        float a2 = androidx.core.c.a.a(f2, 0.0f, 1.0f);
        if (a2 != this.f36432a) {
            this.f36432a = a2;
            g();
        }
    }

    public final boolean a(int[] iArr) {
        this.K = iArr;
        if (!f()) {
            return false;
        }
        c();
        return true;
    }

    private boolean f() {
        ColorStateList colorStateList = this.f36436e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.t;
        return colorStateList2 != null && colorStateList2.isStateful();
    }

    private void g() {
        c(this.f36432a);
    }

    private void c(float f2) {
        d(f2);
        this.y = a(this.w, this.x, f2, this.j);
        this.z = a(this.u, this.v, f2, this.j);
        g(a(this.f36435d, this.s, f2, this.N));
        e(1.0f - a(0.0f, 1.0f, 1.0f - f2, com.google.android.material.a.a.f35801b));
        f(a(1.0f, 0.0f, f2, com.google.android.material.a.a.f35801b));
        if (this.f36436e != this.t) {
            this.M.setColor(a(h(), b(), f2));
        } else {
            this.M.setColor(b());
        }
        this.M.setShadowLayer(a(this.S, this.O, f2, (TimeInterpolator) null), a(this.T, this.P, f2, (TimeInterpolator) null), a(this.U, this.Q, f2, (TimeInterpolator) null), a(c(this.V), c(this.R), f2));
        u.g(this.n);
    }

    private int h() {
        return c(this.t);
    }

    public final int b() {
        return c(this.f36436e);
    }

    private int c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.K;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private void i() {
        StaticLayout staticLayout;
        float f2 = this.J;
        h(this.s);
        CharSequence charSequence = this.D;
        if (!(charSequence == null || (staticLayout = this.W) == null)) {
            this.aa = TextUtils.ellipsize(charSequence, this.M, (float) staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.aa;
        float f3 = 0.0f;
        float measureText = charSequence2 != null ? this.M.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int a2 = e.a(this.f36434c, this.E ? 1 : 0);
        int i2 = a2 & 112;
        if (i2 == 48) {
            this.v = (float) this.q.top;
        } else if (i2 != 80) {
            this.v = ((float) this.q.centerY()) - ((this.M.descent() - this.M.ascent()) / 2.0f);
        } else {
            this.v = ((float) this.q.bottom) + this.M.ascent();
        }
        int i3 = a2 & 8388615;
        if (i3 == 1) {
            this.x = ((float) this.q.centerX()) - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.x = (float) this.q.left;
        } else {
            this.x = ((float) this.q.right) - measureText;
        }
        h(this.f36435d);
        StaticLayout staticLayout2 = this.W;
        float height = staticLayout2 != null ? (float) staticLayout2.getHeight() : 0.0f;
        CharSequence charSequence3 = this.D;
        float measureText2 = charSequence3 != null ? this.M.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout3 = this.W;
        if (staticLayout3 != null && this.k > 1 && !this.E) {
            measureText2 = (float) staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.W;
        if (staticLayout4 != null) {
            f3 = staticLayout4.getLineLeft(0);
        }
        this.Z = f3;
        int a3 = e.a(this.f36433b, this.E ? 1 : 0);
        int i4 = a3 & 112;
        if (i4 == 48) {
            this.u = (float) this.p.top;
        } else if (i4 != 80) {
            this.u = ((float) this.p.centerY()) - (height / 2.0f);
        } else {
            this.u = (((float) this.p.bottom) - height) + this.M.descent();
        }
        int i5 = a3 & 8388615;
        if (i5 == 1) {
            this.w = ((float) this.p.centerX()) - (measureText2 / 2.0f);
        } else if (i5 != 5) {
            this.w = (float) this.p.left;
        } else {
            this.w = ((float) this.p.right) - measureText2;
        }
        m();
        g(f2);
    }

    private void d(float f2) {
        this.r.left = a((float) this.p.left, (float) this.q.left, f2, this.j);
        this.r.top = a(this.u, this.v, f2, this.j);
        this.r.right = a((float) this.p.right, (float) this.q.right, f2, this.j);
        this.r.bottom = a((float) this.p.bottom, (float) this.q.bottom, f2, this.j);
    }

    private void e(float f2) {
        this.X = f2;
        u.g(this.n);
    }

    private void f(float f2) {
        this.Y = f2;
        u.g(this.n);
    }

    public final void a(Canvas canvas) {
        int save = canvas.save();
        if (this.D != null && this.o) {
            boolean z2 = false;
            float lineLeft = (this.y + this.W.getLineLeft(0)) - (this.Z * 2.0f);
            this.M.setTextSize(this.J);
            float f2 = this.y;
            float f3 = this.z;
            if (this.F && this.G != null) {
                z2 = true;
            }
            float f4 = this.I;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f2, f3);
            }
            if (z2) {
                canvas.drawBitmap(this.G, f2, f3, this.H);
                canvas.restoreToCount(save);
                return;
            }
            if (j()) {
                a(canvas, lineLeft, f3);
            } else {
                canvas.translate(f2, f3);
                this.W.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    private boolean j() {
        return this.k > 1 && !this.E && !this.F;
    }

    private void a(Canvas canvas, float f2, float f3) {
        int alpha = this.M.getAlpha();
        canvas.translate(f2, f3);
        float f4 = (float) alpha;
        this.M.setAlpha((int) (this.Y * f4));
        this.W.draw(canvas);
        this.M.setAlpha((int) (this.X * f4));
        int lineBaseline = this.W.getLineBaseline(0);
        CharSequence charSequence = this.aa;
        float f5 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.M);
        String trim = this.aa.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.M.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.W.getLineEnd(0), str.length()), 0.0f, f5, this.M);
    }

    private boolean b(CharSequence charSequence) {
        return (k() ? androidx.core.f.e.f2952d : androidx.core.f.e.f2951c).a(charSequence, charSequence.length());
    }

    private boolean k() {
        return u.j(this.n) == 1;
    }

    private void g(float f2) {
        h(f2);
        this.F = l && this.I != 1.0f;
        if (this.F) {
            l();
        }
        u.g(this.n);
    }

    private void h(float f2) {
        boolean z2;
        float f3;
        boolean z3;
        if (this.f36439h != null) {
            float width = (float) this.q.width();
            float width2 = (float) this.p.width();
            boolean z4 = false;
            int i2 = 1;
            if (a(f2, this.s)) {
                float f4 = this.s;
                this.I = 1.0f;
                Typeface typeface = this.A;
                Typeface typeface2 = this.f36437f;
                if (typeface != typeface2) {
                    this.A = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
                f3 = f4;
                z2 = z3;
            } else {
                f3 = this.f36435d;
                Typeface typeface3 = this.A;
                Typeface typeface4 = this.f36438g;
                if (typeface3 != typeface4) {
                    this.A = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(f2, this.f36435d)) {
                    this.I = 1.0f;
                } else {
                    this.I = f2 / this.f36435d;
                }
                float f5 = this.s / this.f36435d;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            }
            if (width > 0.0f) {
                z2 = this.J != f3 || this.L || z2;
                this.J = f3;
                this.L = false;
            }
            if (this.D == null || z2) {
                this.M.setTextSize(this.J);
                this.M.setTypeface(this.A);
                TextPaint textPaint = this.M;
                if (this.I != 1.0f) {
                    z4 = true;
                }
                textPaint.setLinearText(z4);
                this.E = b(this.f36439h);
                if (j()) {
                    i2 = this.k;
                }
                this.W = a(i2, width, this.E);
                this.D = this.W.getText();
            }
        }
    }

    private StaticLayout a(int i2, float f2, boolean z2) {
        StaticLayout staticLayout;
        try {
            h a2 = h.a(this.f36439h, this.M, (int) f2);
            a2.f36478e = TextUtils.TruncateAt.END;
            a2.f36477d = z2;
            a2.f36474a = Layout.Alignment.ALIGN_NORMAL;
            a2.f36476c = false;
            a2.f36475b = i2;
            staticLayout = a2.a();
        } catch (h.a e2) {
            e2.getCause().getMessage();
            staticLayout = null;
        }
        return (StaticLayout) androidx.core.g.f.a(staticLayout);
    }

    private void l() {
        if (this.G == null && !this.p.isEmpty() && !TextUtils.isEmpty(this.D)) {
            c(0.0f);
            int width = this.W.getWidth();
            int height = this.W.getHeight();
            if (width > 0 && height > 0) {
                this.G = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.W.draw(new Canvas(this.G));
                if (this.H == null) {
                    this.H = new Paint(3);
                }
            }
        }
    }

    public final void c() {
        if (this.n.getHeight() > 0 && this.n.getWidth() > 0) {
            i();
            g();
        }
    }

    public final void a(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f36439h, charSequence)) {
            this.f36439h = charSequence;
            this.D = null;
            m();
            c();
        }
    }

    private void m() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = null;
        }
    }

    public final void e(int i2) {
        if (i2 != this.k) {
            this.k = i2;
            m();
            c();
        }
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    private static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return com.google.android.material.a.a.a(f2, f3, f4);
    }

    private static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
