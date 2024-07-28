package net.one97.paytm.common.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
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
import android.view.animation.Interpolator;
import androidx.core.h.e;
import androidx.core.h.u;
import net.one97.paytm.wallet.R;

final class a {
    private static final boolean H = (Build.VERSION.SDK_INT < 18);
    private static final Paint I = null;
    StaticLayout A;
    float B;
    float C;
    float D;
    int E = 3;
    float F = 0.0f;
    float G = 1.0f;
    private final View J;
    private final RectF K;
    private float L = 15.0f;
    private float M = 15.0f;
    private float N;
    private float O;
    private float P;
    private float Q;
    private Typeface R;
    private boolean S;
    private Interpolator T;
    private float U;
    private float V;
    private float W;
    private int X;
    private float Y;
    private float Z;

    /* renamed from: a  reason: collision with root package name */
    boolean f49662a;
    private float aa;
    private int ab;

    /* renamed from: b  reason: collision with root package name */
    float f49663b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f49664c;

    /* renamed from: d  reason: collision with root package name */
    final Rect f49665d;

    /* renamed from: e  reason: collision with root package name */
    int f49666e = 16;

    /* renamed from: f  reason: collision with root package name */
    int f49667f = 16;

    /* renamed from: g  reason: collision with root package name */
    ColorStateList f49668g;

    /* renamed from: h  reason: collision with root package name */
    ColorStateList f49669h;

    /* renamed from: i  reason: collision with root package name */
    float f49670i;
    float j;
    Typeface k;
    Typeface l;
    CharSequence m;
    CharSequence n;
    boolean o;
    Bitmap p;
    Paint q;
    float r;
    float s;
    int[] t;
    boolean u;
    final TextPaint v;
    Interpolator w;
    CharSequence x;
    Bitmap y;
    Bitmap z;

    public a(View view) {
        this.J = view;
        this.v = new TextPaint(129);
        this.f49665d = new Rect();
        this.f49664c = new Rect();
        this.K = new RectF();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f49662a = this.f49665d.width() > 0 && this.f49665d.height() > 0 && this.f49664c.width() > 0 && this.f49664c.height() > 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (this.f49666e != i2) {
            this.f49666e = i2;
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        if (this.f49667f != i2) {
            this.f49667f = i2;
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2) {
        TypedArray obtainStyledAttributes = this.J.getContext().obtainStyledAttributes(i2, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            this.f49669h = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize)) {
            this.M = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int) this.M);
        }
        this.X = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        this.V = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.W = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.U = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.k = f(i2);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public final void d(int i2) {
        TypedArray obtainStyledAttributes = this.J.getContext().obtainStyledAttributes(i2, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            this.f49668g = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize)) {
            this.L = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int) this.L);
        }
        this.ab = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        this.Z = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.aa = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.Y = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.l = f(i2);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public final void e(int i2) {
        if (i2 != this.E) {
            this.E = i2;
            j();
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2) {
        if (f2 != this.F) {
            this.F = f2;
            j();
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(float f2) {
        if (f2 != this.G) {
            this.G = f2;
            j();
            c();
        }
    }

    private Typeface f(int i2) {
        TypedArray obtainStyledAttributes = this.J.getContext().obtainStyledAttributes(i2, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        c(this.f49663b);
    }

    private void c(float f2) {
        d(f2);
        this.f49670i = a(this.P, this.Q, f2, this.T);
        this.j = a(this.N, this.O, f2, this.T);
        e(a(this.L, this.M, f2, this.w));
        f(1.0f - a(0.0f, 1.0f, 1.0f - f2, net.one97.paytm.wallet.newdesign.universalp2p.utils.a.f71452b));
        g(a(1.0f, 0.0f, f2, net.one97.paytm.wallet.newdesign.universalp2p.utils.a.f71452b));
        if (this.f49669h != this.f49668g) {
            this.v.setColor(a(d(), e(), f2));
        } else {
            this.v.setColor(e());
        }
        this.v.setShadowLayer(a(this.Y, this.U, f2, (Interpolator) null), a(this.Z, this.V, f2, (Interpolator) null), a(this.aa, this.W, f2, (Interpolator) null), a(this.ab, this.X, f2));
        u.g(this.J);
    }

    private int d() {
        int[] iArr = this.t;
        if (iArr != null) {
            return this.f49668g.getColorForState(iArr, 0);
        }
        return this.f49668g.getDefaultColor();
    }

    private int e() {
        int[] iArr = this.t;
        if (iArr != null) {
            return this.f49669h.getColorForState(iArr, 0);
        }
        return this.f49669h.getDefaultColor();
    }

    private void f() {
        float f2 = this.s;
        h(this.M);
        this.x = this.n;
        CharSequence charSequence = this.x;
        float f3 = 0.0f;
        float measureText = charSequence != null ? this.v.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int a2 = e.a(this.f49667f, this.S ? 1 : 0);
        StaticLayout staticLayout = this.A;
        float height = staticLayout != null ? (float) staticLayout.getHeight() : 0.0f;
        int i2 = a2 & 112;
        if (i2 == 48) {
            this.O = (float) this.f49665d.top;
        } else if (i2 != 80) {
            this.O = ((float) this.f49665d.centerY()) - (height / 2.0f);
        } else {
            this.O = ((float) this.f49665d.bottom) - height;
        }
        int i3 = a2 & 8388615;
        if (i3 == 1) {
            this.Q = ((float) this.f49665d.centerX()) - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.Q = (float) this.f49665d.left;
        } else {
            this.Q = ((float) this.f49665d.right) - measureText;
        }
        h(this.L);
        StaticLayout staticLayout2 = this.A;
        float lineWidth = staticLayout2 != null ? staticLayout2.getLineWidth(0) : 0.0f;
        StaticLayout staticLayout3 = this.A;
        this.D = staticLayout3 != null ? staticLayout3.getLineLeft(0) : 0.0f;
        int a3 = e.a(this.f49666e, this.S ? 1 : 0);
        StaticLayout staticLayout4 = this.A;
        if (staticLayout4 != null) {
            f3 = (float) staticLayout4.getHeight();
        }
        int i4 = a3 & 112;
        if (i4 == 48) {
            this.N = (float) this.f49664c.top;
        } else if (i4 != 80) {
            this.N = ((float) this.f49664c.centerY()) - (f3 / 2.0f);
        } else {
            this.N = ((float) this.f49664c.bottom) - f3;
        }
        int i5 = a3 & 8388615;
        if (i5 == 1) {
            this.P = ((float) this.f49664c.centerX()) - (lineWidth / 2.0f);
        } else if (i5 != 5) {
            this.P = (float) this.f49664c.left;
        } else {
            this.P = ((float) this.f49664c.right) - lineWidth;
        }
        j();
        e(f2);
    }

    private void d(float f2) {
        this.K.left = a((float) this.f49664c.left, (float) this.f49665d.left, f2, this.T);
        this.K.top = a(this.N, this.O, f2, this.T);
        this.K.right = a((float) this.f49664c.right, (float) this.f49665d.right, f2, this.T);
        this.K.bottom = a((float) this.f49664c.bottom, (float) this.f49665d.bottom, f2, this.T);
    }

    private boolean b(CharSequence charSequence) {
        boolean z2 = true;
        if (u.j(this.J) != 1) {
            z2 = false;
        }
        return (z2 ? androidx.core.f.e.f2952d : androidx.core.f.e.f2951c).a(charSequence, charSequence.length());
    }

    private void e(float f2) {
        h(f2);
        this.o = H && this.r != 1.0f;
        if (this.o) {
            g();
            h();
            i();
        }
        u.g(this.J);
    }

    private void f(float f2) {
        this.B = f2;
        u.g(this.J);
    }

    private void g(float f2) {
        this.C = f2;
        u.g(this.J);
    }

    static boolean a(Typeface typeface, Typeface typeface2) {
        if (typeface == null || typeface.equals(typeface2)) {
            return typeface == null && typeface2 != null;
        }
        return true;
    }

    private void h(float f2) {
        boolean z2;
        int i2;
        float f3;
        CharSequence charSequence;
        Layout.Alignment alignment;
        boolean z3;
        float f4 = f2;
        if (this.m != null) {
            float width = (float) this.f49665d.width();
            float width2 = (float) this.f49664c.width();
            if (a(f4, this.M)) {
                f3 = this.M;
                this.r = 1.0f;
                if (a(this.R, this.k)) {
                    this.R = this.k;
                    z3 = true;
                } else {
                    z3 = false;
                }
                z2 = z3;
                i2 = 1;
            } else {
                float f5 = this.L;
                if (a(this.R, this.l)) {
                    this.R = this.l;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(f4, this.L)) {
                    this.r = 1.0f;
                } else {
                    this.r = f4 / this.L;
                }
                float f6 = width2;
                i2 = this.E;
                f3 = f5;
                width = f6;
            }
            if (width > 0.0f) {
                z2 = this.s != f3 || this.u || z2;
                this.s = f3;
                this.u = false;
            }
            if (this.n == null || z2) {
                this.v.setTextSize(this.s);
                this.v.setTypeface(this.R);
                int i3 = (int) width;
                StaticLayout staticLayout = new StaticLayout(this.m, this.v, i3, Layout.Alignment.ALIGN_NORMAL, this.G, this.F, false);
                if (staticLayout.getLineCount() > i2) {
                    int i4 = i2 - 1;
                    CharSequence charSequence2 = "";
                    CharSequence subSequence = i4 > 0 ? this.m.subSequence(0, staticLayout.getLineEnd(i4 - 1)) : charSequence2;
                    CharSequence subSequence2 = this.m.subSequence(staticLayout.getLineStart(i4), staticLayout.getLineEnd(i4));
                    if (subSequence2.charAt(subSequence2.length() - 1) == ' ') {
                        charSequence2 = subSequence2.subSequence(subSequence2.length() - 1, subSequence2.length());
                        subSequence2 = subSequence2.subSequence(0, subSequence2.length() - 1);
                    }
                    charSequence = TextUtils.concat(new CharSequence[]{subSequence, TextUtils.ellipsize(TextUtils.concat(new CharSequence[]{subSequence2, "…", charSequence2}), this.v, width, TextUtils.TruncateAt.END)});
                } else {
                    charSequence = this.m;
                }
                if (!TextUtils.equals(charSequence, this.n)) {
                    this.n = charSequence;
                    this.S = b(this.n);
                }
                int i5 = this.f49666e & 8388615;
                if (i5 == 1) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else if (i5 == 5 || i5 == 8388613) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                } else {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                }
                this.A = new StaticLayout(this.n, this.v, i3, alignment, this.G, this.F, false);
            }
        }
    }

    private void g() {
        if (this.p == null && !this.f49664c.isEmpty() && !TextUtils.isEmpty(this.n)) {
            c(0.0f);
            int width = this.A.getWidth();
            int height = this.A.getHeight();
            if (width > 0 && height > 0) {
                this.p = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.A.draw(new Canvas(this.p));
                if (this.q == null) {
                    this.q = new Paint(3);
                }
            }
        }
    }

    private void h() {
        if (this.y == null && !this.f49665d.isEmpty() && !TextUtils.isEmpty(this.n)) {
            c(0.0f);
            TextPaint textPaint = this.v;
            CharSequence charSequence = this.n;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.v.descent() - this.v.ascent());
            if (round > 0 || round2 > 0) {
                this.y = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.y);
                CharSequence charSequence2 = this.x;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, (-this.v.ascent()) / this.r, this.v);
                if (this.q == null) {
                    this.q = new Paint(3);
                }
            }
        }
    }

    private void i() {
        if (this.z == null && !this.f49665d.isEmpty() && !TextUtils.isEmpty(this.n)) {
            c(0.0f);
            int round = Math.round(this.v.measureText(this.n, this.A.getLineStart(0), this.A.getLineEnd(0)));
            int round2 = Math.round(this.v.descent() - this.v.ascent());
            if (round > 0 || round2 > 0) {
                this.z = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.z);
                String trim = this.x.toString().trim();
                if (trim.endsWith("…")) {
                    trim = trim.substring(0, trim.length() - 1);
                }
                String str = trim;
                canvas.drawText(str, 0, this.A.getLineEnd(0) <= str.length() ? this.A.getLineEnd(0) : str.length(), 0.0f, (-this.v.ascent()) / this.r, this.v);
                if (this.q == null) {
                    this.q = new Paint(3);
                }
            }
        }
    }

    public final void c() {
        if (this.J.getHeight() > 0 && this.J.getWidth() > 0) {
            f();
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.m)) {
            this.m = charSequence;
            this.n = null;
            j();
            c();
        }
    }

    private void j() {
        Bitmap bitmap = this.p;
        if (bitmap != null) {
            bitmap.recycle();
            this.p = null;
        }
        Bitmap bitmap2 = this.y;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.y = null;
        }
        Bitmap bitmap3 = this.z;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.z = null;
        }
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    private static float a(float f2, float f3, float f4, Interpolator interpolator) {
        if (interpolator != null) {
            f4 = interpolator.getInterpolation(f4);
        }
        return net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(f2, f3, f4);
    }

    static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
