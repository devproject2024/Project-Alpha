package net.one97.paytm.recharge.common.utils;

import android.animation.TimeInterpolator;
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
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.ac;
import androidx.core.h.e;
import androidx.core.h.u;

public final class bg {
    private static final boolean K = (Build.VERSION.SDK_INT < 18);
    private static final Paint L = null;
    public Bitmap A;
    public Paint B;
    public float C;
    public float D;
    public float E;
    public int[] F;
    public boolean G;
    public final TextPaint H;
    public final TextPaint I;
    public TimeInterpolator J;
    private final View M;
    private final RectF N;
    private float O = 15.0f;
    private float P = 15.0f;
    private float Q = 15.0f;
    private float R = 15.0f;
    private float S;
    private float T;
    private float U;
    private float V;
    private Typeface W;
    private float X;
    private float Y;
    private float Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61594a;
    private float aa;
    private Typeface ab;
    private boolean ac;
    private float ad;
    private float ae;
    private float af;
    private float ag;
    private final TextPaint ah;
    private final TextPaint ai;
    private TimeInterpolator aj;
    private float ak;
    private float al;
    private float am;
    private int an;
    private float ao;
    private float ap;
    private float aq;
    private int ar;
    private float as;
    private float at;
    private float au;
    private int av;
    private float aw;
    private float ax;
    private float ay;
    private int az;

    /* renamed from: b  reason: collision with root package name */
    public float f61595b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f61596c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f61597d;

    /* renamed from: e  reason: collision with root package name */
    public int f61598e = 16;

    /* renamed from: f  reason: collision with root package name */
    public int f61599f = 16;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f61600g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f61601h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f61602i;
    public ColorStateList j;
    public float k;
    public float l;
    public Typeface m;
    public Typeface n;
    public float o;
    public float p;
    public Typeface q;
    public Typeface r;
    public CharSequence s;
    public CharSequence t;
    public CharSequence u;
    public CharSequence v;
    public boolean w;
    public Bitmap x;
    public Paint y;
    public float z;

    public bg(View view) {
        this.M = view;
        this.H = new TextPaint(129);
        this.ah = new TextPaint(this.H);
        this.I = new TextPaint(129);
        this.ai = new TextPaint(this.I);
        this.f61597d = new Rect();
        this.f61596c = new Rect();
        this.N = new RectF();
    }

    public final void a() {
        this.f61594a = this.f61597d.width() > 0 && this.f61597d.height() > 0 && this.f61596c.width() > 0 && this.f61596c.height() > 0;
    }

    public final void a(int i2) {
        if (this.f61598e != i2) {
            this.f61598e = i2;
            c();
        }
    }

    public final void b(int i2) {
        if (this.f61599f != i2) {
            this.f61599f = i2;
            c();
        }
    }

    public final void c(int i2) {
        ac a2 = ac.a(this.M.getContext(), i2, R.styleable.TextAppearance);
        if (a2.g(R.styleable.TextAppearance_android_textColor)) {
            this.f61601h = a2.e(R.styleable.TextAppearance_android_textColor);
        }
        if (a2.g(R.styleable.TextAppearance_android_textSize)) {
            this.P = (float) a2.e(R.styleable.TextAppearance_android_textSize, (int) this.P);
        }
        this.an = a2.a(R.styleable.TextAppearance_android_shadowColor, 0);
        this.al = a2.a(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.am = a2.a(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.ak = a2.a(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        a2.f1669a.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.m = g(i2);
        }
        c();
    }

    public final void d(int i2) {
        ac a2 = ac.a(this.M.getContext(), i2, R.styleable.TextAppearance);
        if (a2.g(R.styleable.TextAppearance_android_textColor)) {
            this.f61600g = a2.e(R.styleable.TextAppearance_android_textColor);
        }
        if (a2.g(R.styleable.TextAppearance_android_textSize)) {
            this.O = (float) a2.e(R.styleable.TextAppearance_android_textSize, (int) this.O);
        }
        this.ar = a2.a(R.styleable.TextAppearance_android_shadowColor, 0);
        this.ap = a2.a(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.aq = a2.a(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.ao = a2.a(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        a2.f1669a.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.n = g(i2);
        }
        c();
    }

    public final void e(int i2) {
        ac a2 = ac.a(this.M.getContext(), i2, R.styleable.TextAppearance);
        if (a2.g(R.styleable.TextAppearance_android_textColor)) {
            this.j = a2.e(R.styleable.TextAppearance_android_textColor);
        }
        if (a2.g(R.styleable.TextAppearance_android_textSize)) {
            this.R = (float) a2.e(R.styleable.TextAppearance_android_textSize, (int) this.R);
        }
        this.av = a2.a(R.styleable.TextAppearance_android_shadowColor, 0);
        this.at = a2.a(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.au = a2.a(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.as = a2.a(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        a2.f1669a.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.q = g(i2);
        }
        c();
    }

    public final void f(int i2) {
        ac a2 = ac.a(this.M.getContext(), i2, R.styleable.TextAppearance);
        if (a2.g(R.styleable.TextAppearance_android_textColor)) {
            this.f61602i = a2.e(R.styleable.TextAppearance_android_textColor);
        }
        if (a2.g(R.styleable.TextAppearance_android_textSize)) {
            this.Q = (float) a2.e(R.styleable.TextAppearance_android_textSize, (int) this.Q);
        }
        this.az = a2.a(R.styleable.TextAppearance_android_shadowColor, 0);
        this.ax = a2.a(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.ay = a2.a(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.aw = a2.a(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        a2.f1669a.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.r = g(i2);
        }
        c();
    }

    private Typeface g(int i2) {
        TypedArray obtainStyledAttributes = this.M.getContext().obtainStyledAttributes(i2, new int[]{16843692});
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

    public final void b() {
        a(this.f61595b);
    }

    private void a(float f2) {
        b(f2);
        this.k = a(this.U, this.V, f2, this.aj);
        this.l = a(this.S, this.T, f2, this.aj);
        this.o = a(this.Z, this.aa, f2, this.aj);
        this.p = a(this.X, this.Y, f2, this.aj);
        c(a(this.O, this.P, f2, this.J));
        e(a(this.Q, this.R, f2, this.J));
        if (this.f61601h != this.f61600g) {
            this.H.setColor(a(e(), f(), f2));
        } else {
            this.H.setColor(f());
        }
        this.H.setShadowLayer(a(this.ao, this.ak, f2, (TimeInterpolator) null), a(this.ap, this.al, f2, (TimeInterpolator) null), a(this.aq, this.am, f2, (TimeInterpolator) null), a(this.ar, this.an, f2));
        if (this.j != this.f61602i) {
            this.I.setColor(a(g(), h(), f2));
        } else {
            this.I.setColor(h());
        }
        this.I.setShadowLayer(a(this.aw, this.as, f2, (TimeInterpolator) null), a(this.ax, this.at, f2, (TimeInterpolator) null), a(this.ay, this.au, f2, (TimeInterpolator) null), a(this.az, this.av, f2));
        u.g(this.M);
    }

    private int e() {
        int[] iArr = this.F;
        if (iArr != null) {
            return this.f61600g.getColorForState(iArr, 0);
        }
        return this.f61600g.getDefaultColor();
    }

    private int f() {
        int[] iArr = this.F;
        if (iArr != null) {
            return this.f61601h.getColorForState(iArr, 0);
        }
        return this.f61601h.getDefaultColor();
    }

    private int g() {
        int[] iArr = this.F;
        if (iArr != null) {
            return this.f61602i.getColorForState(iArr, 0);
        }
        return this.f61602i.getDefaultColor();
    }

    private int h() {
        int[] iArr = this.F;
        if (iArr != null) {
            return this.j.getColorForState(iArr, 0);
        }
        return this.j.getDefaultColor();
    }

    private void i() {
        float f2 = this.af;
        float f3 = this.ag;
        boolean isEmpty = TextUtils.isEmpty(this.u);
        d(this.P);
        f(this.R);
        CharSequence charSequence = this.t;
        float f4 = 0.0f;
        float measureText = charSequence != null ? this.H.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        CharSequence charSequence2 = this.v;
        float measureText2 = charSequence2 != null ? this.I.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int a2 = e.a(this.f61599f, this.ac ? 1 : 0);
        float descent = this.H.descent() - this.H.ascent();
        this.H.descent();
        float descent2 = this.I.descent() - this.I.ascent();
        this.I.descent();
        if (isEmpty) {
            int i2 = a2 & 112;
            if (i2 == 48) {
                this.T = ((float) this.f61597d.top) - this.H.ascent();
            } else if (i2 != 80) {
                this.T = ((float) this.f61597d.centerY()) + (((this.H.descent() - this.H.ascent()) / 2.0f) - this.H.descent());
            } else {
                this.T = (float) this.f61597d.bottom;
            }
        } else {
            float height = (((float) this.f61597d.height()) - (descent2 + descent)) / 3.0f;
            this.T = (((float) this.f61597d.top) + height) - this.H.ascent();
            this.Y = ((((float) this.f61597d.top) + (height * 2.0f)) + descent) - this.I.ascent();
        }
        int i3 = a2 & 8388615;
        if (i3 == 1) {
            this.V = ((float) this.f61597d.centerX()) - (measureText / 2.0f);
            this.aa = ((float) this.f61597d.centerX()) - (measureText2 / 2.0f);
        } else if (i3 != 5) {
            this.V = (float) this.f61597d.left;
            this.aa = (float) this.f61597d.left;
        } else {
            this.V = ((float) this.f61597d.right) - measureText;
            this.aa = ((float) this.f61597d.right) - measureText2;
        }
        d(this.O);
        f(this.Q);
        CharSequence charSequence3 = this.t;
        float measureText3 = charSequence3 != null ? this.H.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        CharSequence charSequence4 = this.v;
        if (charSequence4 != null) {
            f4 = this.I.measureText(charSequence4, 0, charSequence4.length());
        }
        float descent3 = ((this.H.descent() - this.H.ascent()) / 2.0f) - this.H.descent();
        float descent4 = this.I.descent() - this.I.ascent();
        this.I.descent();
        int a3 = e.a(this.f61598e, this.ac ? 1 : 0);
        if (isEmpty) {
            int i4 = a3 & 112;
            if (i4 == 48) {
                this.S = ((float) this.f61596c.top) - this.H.ascent();
            } else if (i4 != 80) {
                this.S = ((float) this.f61596c.centerY()) + (((this.H.descent() - this.H.ascent()) / 2.0f) - this.H.descent());
            } else {
                this.S = (float) this.f61596c.bottom;
            }
        } else {
            int i5 = a3 & 112;
            if (i5 == 48) {
                this.S = ((float) this.f61596c.top) - this.H.ascent();
                this.X = this.S + descent4 + descent3;
            } else if (i5 != 80) {
                this.S = ((float) this.f61596c.centerY()) + descent3;
                this.X = this.S + descent4 + descent3;
            } else {
                this.S = (((float) this.f61596c.bottom) - descent4) - descent3;
                this.X = (float) this.f61596c.bottom;
            }
        }
        int i6 = a3 & 8388615;
        if (i6 == 1) {
            this.U = ((float) this.f61596c.centerX()) - (measureText3 / 2.0f);
            this.Z = ((float) this.f61596c.centerX()) - (f4 / 2.0f);
        } else if (i6 != 5) {
            this.U = (float) this.f61596c.left;
            this.Z = (float) this.f61596c.left;
        } else {
            this.U = ((float) this.f61596c.right) - measureText3;
            this.Z = ((float) this.f61596c.right) - f4;
        }
        d();
        c(f2);
        e(f3);
    }

    private void b(float f2) {
        this.N.left = a((float) this.f61596c.left, (float) this.f61597d.left, f2, this.aj);
        this.N.top = a(this.S, this.T, f2, this.aj);
        this.N.right = a((float) this.f61596c.right, (float) this.f61597d.right, f2, this.aj);
        this.N.bottom = a((float) this.f61596c.bottom, (float) this.f61597d.bottom, f2, this.aj);
    }

    private boolean a(CharSequence charSequence) {
        boolean z2 = true;
        if (u.j(this.M) != 1) {
            z2 = false;
        }
        return (z2 ? androidx.core.f.e.f2952d : androidx.core.f.e.f2951c).a(charSequence, charSequence.length());
    }

    private void c(float f2) {
        d(f2);
        this.w = K && this.D != 1.0f;
        if (this.w) {
            j();
        }
        u.g(this.M);
    }

    private void d(float f2) {
        boolean z2;
        float f3;
        boolean z3;
        if (this.s != null) {
            float width = (float) this.f61597d.width();
            float width2 = (float) this.f61596c.width();
            boolean z4 = true;
            if (a(f2, this.P)) {
                float f4 = this.P;
                this.D = 1.0f;
                Typeface typeface = this.W;
                Typeface typeface2 = this.m;
                if (typeface != typeface2) {
                    this.W = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
                f3 = f4;
                z2 = z3;
            } else {
                f3 = this.O;
                Typeface typeface3 = this.W;
                Typeface typeface4 = this.n;
                if (typeface3 != typeface4) {
                    this.W = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(f2, this.O)) {
                    this.D = 1.0f;
                } else {
                    this.D = f2 / this.O;
                }
                float f5 = this.P / this.O;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            }
            if (width > 0.0f) {
                z2 = this.af != f3 || this.G || z2;
                this.af = f3;
                this.G = false;
            }
            if (this.t == null || z2) {
                this.H.setTextSize(this.af);
                this.H.setTypeface(this.W);
                TextPaint textPaint = this.H;
                if (this.D == 1.0f) {
                    z4 = false;
                }
                textPaint.setLinearText(z4);
                CharSequence ellipsize = TextUtils.ellipsize(this.s, this.H, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.t)) {
                    this.t = ellipsize;
                    this.ac = a(this.t);
                }
            }
        }
    }

    private void j() {
        if (this.x == null && !this.f61596c.isEmpty() && !TextUtils.isEmpty(this.t)) {
            a(0.0f);
            this.z = this.H.ascent();
            this.ad = this.H.descent();
            TextPaint textPaint = this.H;
            CharSequence charSequence = this.t;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.ad - this.z);
            if (round > 0 && round2 > 0) {
                this.x = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.x);
                CharSequence charSequence2 = this.t;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, ((float) round2) - this.H.descent(), this.H);
                if (this.y == null) {
                    this.y = new Paint(3);
                }
            }
        }
    }

    private void e(float f2) {
        f(f2);
        this.w = K && this.E != 1.0f;
        if (this.w) {
            k();
        }
        u.g(this.M);
    }

    private void f(float f2) {
        boolean z2;
        float f3;
        boolean z3;
        if (this.u != null) {
            float width = (float) this.f61597d.width();
            float width2 = (float) this.f61596c.width();
            boolean z4 = true;
            if (a(f2, this.R)) {
                float f4 = this.R;
                this.E = 1.0f;
                Typeface typeface = this.ab;
                Typeface typeface2 = this.q;
                if (typeface != typeface2) {
                    this.ab = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
                f3 = f4;
                z2 = z3;
            } else {
                f3 = this.Q;
                Typeface typeface3 = this.ab;
                Typeface typeface4 = this.r;
                if (typeface3 != typeface4) {
                    this.ab = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(f2, this.Q)) {
                    this.E = 1.0f;
                } else {
                    this.E = f2 / this.Q;
                }
                float f5 = this.R / this.Q;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            }
            if (width > 0.0f) {
                z2 = this.ag != f3 || this.G || z2;
                this.ag = f3;
                this.G = false;
            }
            if (this.v == null || z2) {
                this.I.setTextSize(this.ag);
                this.I.setTypeface(this.ab);
                TextPaint textPaint = this.I;
                if (this.E == 1.0f) {
                    z4 = false;
                }
                textPaint.setLinearText(z4);
                CharSequence ellipsize = TextUtils.ellipsize(this.u, this.I, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.v)) {
                    this.v = ellipsize;
                    this.ac = a(this.v);
                }
            }
        }
    }

    private void k() {
        if (this.A == null && !this.f61596c.isEmpty() && !TextUtils.isEmpty(this.v)) {
            a(0.0f);
            this.C = this.I.ascent();
            this.ae = this.I.descent();
            TextPaint textPaint = this.I;
            CharSequence charSequence = this.v;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.ae - this.C);
            if (round > 0 && round2 > 0) {
                this.A = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.A);
                CharSequence charSequence2 = this.v;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, ((float) round2) - this.I.descent(), this.I);
                if (this.B == null) {
                    this.B = new Paint(3);
                }
            }
        }
    }

    public final void c() {
        if (this.M.getHeight() > 0 && this.M.getWidth() > 0) {
            i();
            b();
        }
    }

    public final void d() {
        Bitmap bitmap = this.x;
        if (bitmap != null) {
            bitmap.recycle();
            this.x = null;
        }
        Bitmap bitmap2 = this.A;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.A = null;
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
        return b.a(f2, f3, f4);
    }

    public static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
