package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.e;
import com.google.android.material.R;
import com.google.android.material.h.c;
import com.google.android.material.h.d;
import com.google.android.material.i.b;
import com.google.android.material.internal.i;
import com.google.android.material.internal.k;
import com.google.android.material.k.h;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class a extends h implements Drawable.Callback, e, i.a {
    private static final int[] I = {16842910};
    private static final ShapeDrawable J = new ShapeDrawable(new OvalShape());
    final Context A;
    final i B;
    boolean C;
    TextUtils.TruncateAt D;
    boolean E;
    int F;
    private ColorStateList K;
    private float L = -1.0f;
    private boolean M;
    private Drawable N;
    private boolean O;
    private Drawable P;
    private boolean Q;
    private final Paint R = new Paint(1);
    private final Paint S;
    private final Paint.FontMetrics T = new Paint.FontMetrics();
    private final RectF U = new RectF();
    private final PointF V = new PointF();
    private final Path W = new Path();
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a  reason: collision with root package name */
    ColorStateList f36105a;
    private int aa;
    private int ab;
    private int ac;
    private boolean ad;
    private int ae;
    private int af = PriceRangeSeekBar.INVALID_POINTER_ID;
    private ColorFilter ag;
    private PorterDuffColorFilter ah;
    private ColorStateList ai;
    private PorterDuff.Mode aj = PorterDuff.Mode.SRC_IN;
    private int[] ak;
    private ColorStateList al;
    private WeakReference<C0603a> am = new WeakReference<>((Object) null);
    private boolean an;

    /* renamed from: b  reason: collision with root package name */
    float f36106b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f36107c;

    /* renamed from: d  reason: collision with root package name */
    float f36108d;

    /* renamed from: e  reason: collision with root package name */
    ColorStateList f36109e;

    /* renamed from: f  reason: collision with root package name */
    CharSequence f36110f;

    /* renamed from: g  reason: collision with root package name */
    ColorStateList f36111g;

    /* renamed from: h  reason: collision with root package name */
    float f36112h;

    /* renamed from: i  reason: collision with root package name */
    boolean f36113i;
    Drawable j;
    ColorStateList k;
    float l;
    CharSequence m;
    boolean n;
    Drawable o;
    ColorStateList p;
    com.google.android.material.a.h q;
    com.google.android.material.a.h r;
    float s;
    float t;
    float u;
    float v;
    float w;
    float x;
    float y;
    float z;

    /* renamed from: com.google.android.material.chip.a$a  reason: collision with other inner class name */
    public interface C0603a {
        void a();
    }

    public final int getOpacity() {
        return -3;
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        TypedArray a2 = k.a(aVar.A, attributeSet, R.styleable.Chip, i2, i3, new int[0]);
        aVar.an = a2.hasValue(R.styleable.Chip_shapeAppearance);
        ColorStateList a3 = c.a(aVar.A, a2, R.styleable.Chip_chipSurfaceColor);
        if (aVar.K != a3) {
            aVar.K = a3;
            aVar.onStateChange(aVar.getState());
        }
        aVar.a(c.a(aVar.A, a2, R.styleable.Chip_chipBackgroundColor));
        aVar.a(a2.getDimension(R.styleable.Chip_chipMinHeight, 0.0f));
        if (a2.hasValue(R.styleable.Chip_chipCornerRadius)) {
            aVar.b(a2.getDimension(R.styleable.Chip_chipCornerRadius, 0.0f));
        }
        aVar.b(c.a(aVar.A, a2, R.styleable.Chip_chipStrokeColor));
        aVar.c(a2.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0f));
        aVar.c(c.a(aVar.A, a2, R.styleable.Chip_rippleColor));
        aVar.a(a2.getText(R.styleable.Chip_android_text));
        aVar.a(c.c(aVar.A, a2, R.styleable.Chip_android_textAppearance));
        int i4 = a2.getInt(R.styleable.Chip_android_ellipsize, 0);
        if (i4 == 1) {
            aVar.D = TextUtils.TruncateAt.START;
        } else if (i4 == 2) {
            aVar.D = TextUtils.TruncateAt.MIDDLE;
        } else if (i4 == 3) {
            aVar.D = TextUtils.TruncateAt.END;
        }
        aVar.b(a2.getBoolean(R.styleable.Chip_chipIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            aVar.b(a2.getBoolean(R.styleable.Chip_chipIconEnabled, false));
        }
        aVar.b(c.b(aVar.A, a2, R.styleable.Chip_chipIcon));
        if (a2.hasValue(R.styleable.Chip_chipIconTint)) {
            aVar.d(c.a(aVar.A, a2, R.styleable.Chip_chipIconTint));
        }
        aVar.d(a2.getDimension(R.styleable.Chip_chipIconSize, 0.0f));
        aVar.c(a2.getBoolean(R.styleable.Chip_closeIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            aVar.c(a2.getBoolean(R.styleable.Chip_closeIconEnabled, false));
        }
        aVar.c(c.b(aVar.A, a2, R.styleable.Chip_closeIcon));
        aVar.e(c.a(aVar.A, a2, R.styleable.Chip_closeIconTint));
        aVar.e(a2.getDimension(R.styleable.Chip_closeIconSize, 0.0f));
        aVar.d(a2.getBoolean(R.styleable.Chip_android_checkable, false));
        aVar.e(a2.getBoolean(R.styleable.Chip_checkedIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            aVar.e(a2.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
        }
        aVar.d(c.b(aVar.A, a2, R.styleable.Chip_checkedIcon));
        if (a2.hasValue(R.styleable.Chip_checkedIconTint)) {
            aVar.f(c.a(aVar.A, a2, R.styleable.Chip_checkedIconTint));
        }
        aVar.q = com.google.android.material.a.h.a(aVar.A, a2, R.styleable.Chip_showMotionSpec);
        aVar.r = com.google.android.material.a.h.a(aVar.A, a2, R.styleable.Chip_hideMotionSpec);
        aVar.f(a2.getDimension(R.styleable.Chip_chipStartPadding, 0.0f));
        aVar.g(a2.getDimension(R.styleable.Chip_iconStartPadding, 0.0f));
        aVar.h(a2.getDimension(R.styleable.Chip_iconEndPadding, 0.0f));
        aVar.i(a2.getDimension(R.styleable.Chip_textStartPadding, 0.0f));
        aVar.j(a2.getDimension(R.styleable.Chip_textEndPadding, 0.0f));
        aVar.k(a2.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0f));
        aVar.l(a2.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0f));
        aVar.m(a2.getDimension(R.styleable.Chip_chipEndPadding, 0.0f));
        aVar.F = a2.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE);
        a2.recycle();
        return aVar;
    }

    private a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context);
        this.A = context;
        this.B = new i(this);
        this.f36110f = "";
        this.B.f36480a.density = context.getResources().getDisplayMetrics().density;
        this.S = null;
        Paint paint = this.S;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(I);
        a(I);
        this.E = true;
        if (b.f36380a) {
            J.setTint(-1);
        }
    }

    public final void a(boolean z2) {
        if (this.C != z2) {
            this.C = z2;
            x();
            onStateChange(getState());
        }
    }

    public final void a(C0603a aVar) {
        this.am = new WeakReference<>(aVar);
    }

    private void r() {
        C0603a aVar = (C0603a) this.am.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public final int getIntrinsicWidth() {
        return Math.min(Math.round(this.s + b() + this.v + this.B.a(this.f36110f.toString()) + this.w + c() + this.z), this.F);
    }

    public final int getIntrinsicHeight() {
        return (int) this.f36106b;
    }

    private boolean s() {
        return this.M && this.N != null;
    }

    private boolean t() {
        return this.Q && this.o != null && this.ad;
    }

    private boolean u() {
        return this.f36113i && this.j != null;
    }

    private boolean v() {
        return this.Q && this.o != null && this.n;
    }

    /* access modifiers changed from: package-private */
    public final float b() {
        if (s() || t()) {
            return this.t + this.f36112h + this.u;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final float c() {
        if (u()) {
            return this.x + this.l + this.y;
        }
        return 0.0f;
    }

    public final void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            if (this.af < 255) {
                float f2 = (float) bounds.left;
                float f3 = (float) bounds.top;
                float f4 = (float) bounds.right;
                float f5 = (float) bounds.bottom;
                int i4 = this.af;
                if (Build.VERSION.SDK_INT > 21) {
                    i2 = canvas.saveLayerAlpha(f2, f3, f4, f5, i4);
                } else {
                    i2 = canvas.saveLayerAlpha(f2, f3, f4, f5, i4, 31);
                }
            } else {
                i2 = 0;
            }
            if (!this.an) {
                this.R.setColor(this.X);
                this.R.setStyle(Paint.Style.FILL);
                this.U.set(bounds);
                canvas.drawRoundRect(this.U, d(), d(), this.R);
            }
            if (!this.an) {
                this.R.setColor(this.Y);
                this.R.setStyle(Paint.Style.FILL);
                this.R.setColorFilter(w());
                this.U.set(bounds);
                canvas.drawRoundRect(this.U, d(), d(), this.R);
            }
            if (this.an) {
                super.draw(canvas);
            }
            if (this.f36108d > 0.0f && !this.an) {
                this.R.setColor(this.aa);
                this.R.setStyle(Paint.Style.STROKE);
                if (!this.an) {
                    this.R.setColorFilter(w());
                }
                this.U.set(((float) bounds.left) + (this.f36108d / 2.0f), ((float) bounds.top) + (this.f36108d / 2.0f), ((float) bounds.right) - (this.f36108d / 2.0f), ((float) bounds.bottom) - (this.f36108d / 2.0f));
                float f6 = this.L - (this.f36108d / 2.0f);
                canvas.drawRoundRect(this.U, f6, f6, this.R);
            }
            this.R.setColor(this.ab);
            this.R.setStyle(Paint.Style.FILL);
            this.U.set(bounds);
            if (!this.an) {
                canvas.drawRoundRect(this.U, d(), d(), this.R);
            } else {
                a(new RectF(bounds), this.W);
                super.a(canvas, this.R, this.W, this.G.f36536a, g());
            }
            if (s()) {
                b(bounds, this.U);
                float f7 = this.U.left;
                float f8 = this.U.top;
                canvas.translate(f7, f8);
                this.N.setBounds(0, 0, (int) this.U.width(), (int) this.U.height());
                this.N.draw(canvas);
                canvas.translate(-f7, -f8);
            }
            if (t()) {
                b(bounds, this.U);
                float f9 = this.U.left;
                float f10 = this.U.top;
                canvas.translate(f9, f10);
                this.o.setBounds(0, 0, (int) this.U.width(), (int) this.U.height());
                this.o.draw(canvas);
                canvas.translate(-f9, -f10);
            }
            if (this.E && this.f36110f != null) {
                PointF pointF = this.V;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.f36110f != null) {
                    float b2 = this.s + b() + this.v;
                    if (androidx.core.graphics.drawable.a.h(this) == 0) {
                        pointF.x = ((float) bounds.left) + b2;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = ((float) bounds.right) - b2;
                        align = Paint.Align.RIGHT;
                    }
                    this.B.f36480a.getFontMetrics(this.T);
                    pointF.y = ((float) bounds.centerY()) - ((this.T.descent + this.T.ascent) / 2.0f);
                }
                RectF rectF = this.U;
                rectF.setEmpty();
                if (this.f36110f != null) {
                    float b3 = this.s + b() + this.v;
                    float c2 = this.z + c() + this.w;
                    if (androidx.core.graphics.drawable.a.h(this) == 0) {
                        rectF.left = ((float) bounds.left) + b3;
                        rectF.right = ((float) bounds.right) - c2;
                    } else {
                        rectF.left = ((float) bounds.left) + c2;
                        rectF.right = ((float) bounds.right) - b3;
                    }
                    rectF.top = (float) bounds.top;
                    rectF.bottom = (float) bounds.bottom;
                }
                if (this.B.f36483d != null) {
                    this.B.f36480a.drawableState = getState();
                    this.B.a(this.A);
                }
                this.B.f36480a.setTextAlign(align);
                boolean z2 = Math.round(this.B.a(this.f36110f.toString())) > Math.round(this.U.width());
                if (z2) {
                    i3 = canvas.save();
                    canvas.clipRect(this.U);
                } else {
                    i3 = 0;
                }
                CharSequence charSequence = this.f36110f;
                if (z2 && this.D != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.B.f36480a, this.U.width(), this.D);
                }
                CharSequence charSequence2 = charSequence;
                canvas.drawText(charSequence2, 0, charSequence2.length(), this.V.x, this.V.y, this.B.f36480a);
                if (z2) {
                    canvas.restoreToCount(i3);
                }
            }
            if (u()) {
                c(bounds, this.U);
                float f11 = this.U.left;
                float f12 = this.U.top;
                canvas.translate(f11, f12);
                this.j.setBounds(0, 0, (int) this.U.width(), (int) this.U.height());
                if (b.f36380a) {
                    this.P.setBounds(this.j.getBounds());
                    this.P.jumpToCurrentState();
                    this.P.draw(canvas);
                } else {
                    this.j.draw(canvas);
                }
                canvas.translate(-f11, -f12);
            }
            Paint paint = this.S;
            if (paint != null) {
                paint.setColor(androidx.core.graphics.a.b(-16777216, 127));
                canvas.drawRect(bounds, this.S);
                if (s() || t()) {
                    b(bounds, this.U);
                    canvas.drawRect(this.U, this.S);
                }
                if (this.f36110f != null) {
                    canvas.drawLine((float) bounds.left, bounds.exactCenterY(), (float) bounds.right, bounds.exactCenterY(), this.S);
                }
                if (u()) {
                    c(bounds, this.U);
                    canvas.drawRect(this.U, this.S);
                }
                this.S.setColor(androidx.core.graphics.a.b(-65536, 127));
                RectF rectF2 = this.U;
                rectF2.set(bounds);
                if (u()) {
                    float f13 = this.z + this.y + this.l + this.x + this.w;
                    if (androidx.core.graphics.drawable.a.h(this) == 0) {
                        rectF2.right = ((float) bounds.right) - f13;
                    } else {
                        rectF2.left = ((float) bounds.left) + f13;
                    }
                }
                canvas.drawRect(this.U, this.S);
                this.S.setColor(androidx.core.graphics.a.b(-16711936, 127));
                a(bounds, this.U);
                canvas.drawRect(this.U, this.S);
            }
            if (this.af < 255) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private void b(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (s() || t()) {
            float f2 = this.s + this.t;
            if (androidx.core.graphics.drawable.a.h(this) == 0) {
                rectF.left = ((float) rect.left) + f2;
                rectF.right = rectF.left + this.f36112h;
            } else {
                rectF.right = ((float) rect.right) - f2;
                rectF.left = rectF.right - this.f36112h;
            }
            rectF.top = rect.exactCenterY() - (this.f36112h / 2.0f);
            rectF.bottom = rectF.top + this.f36112h;
        }
    }

    private void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (u()) {
            float f2 = this.z + this.y;
            if (androidx.core.graphics.drawable.a.h(this) == 0) {
                rectF.right = ((float) rect.right) - f2;
                rectF.left = rectF.right - this.l;
            } else {
                rectF.left = ((float) rect.left) + f2;
                rectF.right = rectF.left + this.l;
            }
            rectF.top = rect.exactCenterY() - (this.l / 2.0f);
            rectF.bottom = rectF.top + this.l;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (u()) {
            float f2 = this.z + this.y + this.l + this.x + this.w;
            if (androidx.core.graphics.drawable.a.h(this) == 0) {
                rectF.right = (float) rect.right;
                rectF.left = rectF.right - f2;
            } else {
                rectF.left = (float) rect.left;
                rectF.right = ((float) rect.left) + f2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    public final boolean isStateful() {
        if (!i(this.K) && !i(this.f36105a) && !i(this.f36107c) && (!this.C || !i(this.al))) {
            d dVar = this.B.f36483d;
            if (((dVar == null || dVar.f36363b == null || !dVar.f36363b.isStateful()) ? false : true) || v() || a(this.N) || a(this.o) || i(this.ai)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean a(int[] iArr) {
        if (Arrays.equals(this.ak, iArr)) {
            return false;
        }
        this.ak = iArr;
        if (u()) {
            return a(getState(), iArr);
        }
        return false;
    }

    public final void a() {
        r();
        invalidateSelf();
    }

    public final boolean onStateChange(int[] iArr) {
        if (this.an) {
            super.onStateChange(iArr);
        }
        return a(iArr, this.ak);
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int[] r7, int[] r8) {
        /*
            r6 = this;
            boolean r0 = super.onStateChange(r7)
            android.content.res.ColorStateList r1 = r6.K
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r6.X
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r3 = r6.X
            r4 = 1
            if (r3 == r1) goto L_0x0019
            r6.X = r1
            r0 = 1
        L_0x0019:
            android.content.res.ColorStateList r3 = r6.f36105a
            if (r3 == 0) goto L_0x0024
            int r5 = r6.Y
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            int r5 = r6.Y
            if (r5 == r3) goto L_0x002c
            r6.Y = r3
            r0 = 1
        L_0x002c:
            int r1 = androidx.core.graphics.a.a((int) r3, (int) r1)
            int r3 = r6.Z
            if (r3 == r1) goto L_0x0036
            r3 = 1
            goto L_0x0037
        L_0x0036:
            r3 = 0
        L_0x0037:
            com.google.android.material.k.h$a r5 = r6.G
            android.content.res.ColorStateList r5 = r5.f36539d
            if (r5 != 0) goto L_0x003f
            r5 = 1
            goto L_0x0040
        L_0x003f:
            r5 = 0
        L_0x0040:
            r3 = r3 | r5
            if (r3 == 0) goto L_0x004f
            r6.Z = r1
            int r0 = r6.Z
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r6.g(r0)
            r0 = 1
        L_0x004f:
            android.content.res.ColorStateList r1 = r6.f36107c
            if (r1 == 0) goto L_0x005a
            int r3 = r6.aa
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x005b
        L_0x005a:
            r1 = 0
        L_0x005b:
            int r3 = r6.aa
            if (r3 == r1) goto L_0x0062
            r6.aa = r1
            r0 = 1
        L_0x0062:
            android.content.res.ColorStateList r1 = r6.al
            if (r1 == 0) goto L_0x0075
            boolean r1 = com.google.android.material.i.b.a((int[]) r7)
            if (r1 == 0) goto L_0x0075
            android.content.res.ColorStateList r1 = r6.al
            int r3 = r6.ab
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0076
        L_0x0075:
            r1 = 0
        L_0x0076:
            int r3 = r6.ab
            if (r3 == r1) goto L_0x0081
            r6.ab = r1
            boolean r1 = r6.C
            if (r1 == 0) goto L_0x0081
            r0 = 1
        L_0x0081:
            com.google.android.material.internal.i r1 = r6.B
            com.google.android.material.h.d r1 = r1.f36483d
            if (r1 == 0) goto L_0x009c
            com.google.android.material.internal.i r1 = r6.B
            com.google.android.material.h.d r1 = r1.f36483d
            android.content.res.ColorStateList r1 = r1.f36363b
            if (r1 == 0) goto L_0x009c
            com.google.android.material.internal.i r1 = r6.B
            com.google.android.material.h.d r1 = r1.f36483d
            android.content.res.ColorStateList r1 = r1.f36363b
            int r3 = r6.ac
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x009d
        L_0x009c:
            r1 = 0
        L_0x009d:
            int r3 = r6.ac
            if (r3 == r1) goto L_0x00a4
            r6.ac = r1
            r0 = 1
        L_0x00a4:
            int[] r1 = r6.getState()
            boolean r1 = b((int[]) r1)
            if (r1 == 0) goto L_0x00b4
            boolean r1 = r6.n
            if (r1 == 0) goto L_0x00b4
            r1 = 1
            goto L_0x00b5
        L_0x00b4:
            r1 = 0
        L_0x00b5:
            boolean r3 = r6.ad
            if (r3 == r1) goto L_0x00cf
            android.graphics.drawable.Drawable r3 = r6.o
            if (r3 == 0) goto L_0x00cf
            float r0 = r6.b()
            r6.ad = r1
            float r1 = r6.b()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00ce
            r0 = 1
            r1 = 1
            goto L_0x00d0
        L_0x00ce:
            r0 = 1
        L_0x00cf:
            r1 = 0
        L_0x00d0:
            android.content.res.ColorStateList r3 = r6.ai
            if (r3 == 0) goto L_0x00db
            int r5 = r6.ae
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x00dc
        L_0x00db:
            r3 = 0
        L_0x00dc:
            int r5 = r6.ae
            if (r5 == r3) goto L_0x00ed
            r6.ae = r3
            android.content.res.ColorStateList r0 = r6.ai
            android.graphics.PorterDuff$Mode r3 = r6.aj
            android.graphics.PorterDuffColorFilter r0 = com.google.android.material.d.a.a(r6, r0, r3)
            r6.ah = r0
            r0 = 1
        L_0x00ed:
            android.graphics.drawable.Drawable r3 = r6.N
            boolean r3 = a((android.graphics.drawable.Drawable) r3)
            if (r3 == 0) goto L_0x00fc
            android.graphics.drawable.Drawable r3 = r6.N
            boolean r3 = r3.setState(r7)
            r0 = r0 | r3
        L_0x00fc:
            android.graphics.drawable.Drawable r3 = r6.o
            boolean r3 = a((android.graphics.drawable.Drawable) r3)
            if (r3 == 0) goto L_0x010b
            android.graphics.drawable.Drawable r3 = r6.o
            boolean r3 = r3.setState(r7)
            r0 = r0 | r3
        L_0x010b:
            android.graphics.drawable.Drawable r3 = r6.j
            boolean r3 = a((android.graphics.drawable.Drawable) r3)
            if (r3 == 0) goto L_0x0128
            int r3 = r7.length
            int r4 = r8.length
            int r3 = r3 + r4
            int[] r3 = new int[r3]
            int r4 = r7.length
            java.lang.System.arraycopy(r7, r2, r3, r2, r4)
            int r7 = r7.length
            int r4 = r8.length
            java.lang.System.arraycopy(r8, r2, r3, r7, r4)
            android.graphics.drawable.Drawable r7 = r6.j
            boolean r7 = r7.setState(r3)
            r0 = r0 | r7
        L_0x0128:
            boolean r7 = com.google.android.material.i.b.f36380a
            if (r7 == 0) goto L_0x013b
            android.graphics.drawable.Drawable r7 = r6.P
            boolean r7 = a((android.graphics.drawable.Drawable) r7)
            if (r7 == 0) goto L_0x013b
            android.graphics.drawable.Drawable r7 = r6.P
            boolean r7 = r7.setState(r8)
            r0 = r0 | r7
        L_0x013b:
            if (r0 == 0) goto L_0x0140
            r6.invalidateSelf()
        L_0x0140:
            if (r1 == 0) goto L_0x0145
            r6.r()
        L_0x0145:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.a(int[], int[]):boolean");
    }

    private static boolean i(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    static boolean a(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (s()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.b(this.N, i2);
        }
        if (t()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.b(this.o, i2);
        }
        if (u()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.b(this.j, i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (s()) {
            onLevelChange |= this.N.setLevel(i2);
        }
        if (t()) {
            onLevelChange |= this.o.setLevel(i2);
        }
        if (u()) {
            onLevelChange |= this.j.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public final boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (s()) {
            visible |= this.N.setVisible(z2, z3);
        }
        if (t()) {
            visible |= this.o.setVisible(z2, z3);
        }
        if (u()) {
            visible |= this.j.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void setAlpha(int i2) {
        if (this.af != i2) {
            this.af = i2;
            invalidateSelf();
        }
    }

    public final int getAlpha() {
        return this.af;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.ag != colorFilter) {
            this.ag = colorFilter;
            invalidateSelf();
        }
    }

    public final ColorFilter getColorFilter() {
        return this.ag;
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.ai != colorStateList) {
            this.ai = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.aj != mode) {
            this.aj = mode;
            this.ah = com.google.android.material.d.a.a(this, this.ai, mode);
            invalidateSelf();
        }
    }

    public final void getOutline(Outline outline) {
        if (this.an) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.L);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.L);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private static void e(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void f(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            androidx.core.graphics.drawable.a.b(drawable, androidx.core.graphics.drawable.a.h(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.j) {
                if (drawable.isStateful()) {
                    drawable.setState(this.ak);
                }
                androidx.core.graphics.drawable.a.a(drawable, this.k);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.N;
            if (drawable == drawable2 && this.O) {
                androidx.core.graphics.drawable.a.a(drawable2, this.f36111g);
            }
        }
    }

    private ColorFilter w() {
        ColorFilter colorFilter = this.ag;
        return colorFilter != null ? colorFilter : this.ah;
    }

    private void x() {
        this.al = this.C ? b.b(this.f36109e) : null;
    }

    private static boolean b(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == 16842912) {
                return true;
            }
        }
        return false;
    }

    public final void a(ColorStateList colorStateList) {
        if (this.f36105a != colorStateList) {
            this.f36105a = colorStateList;
            onStateChange(getState());
        }
    }

    public final void a(float f2) {
        if (this.f36106b != f2) {
            this.f36106b = f2;
            invalidateSelf();
            r();
        }
    }

    public final float d() {
        return this.an ? m() : this.L;
    }

    @Deprecated
    public final void b(float f2) {
        if (this.L != f2) {
            this.L = f2;
            setShapeAppearanceModel(this.G.f36536a.a(f2));
        }
    }

    public final void b(ColorStateList colorStateList) {
        if (this.f36107c != colorStateList) {
            this.f36107c = colorStateList;
            if (this.an) {
                h(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void c(float f2) {
        if (this.f36108d != f2) {
            this.f36108d = f2;
            this.R.setStrokeWidth(f2);
            if (this.an) {
                super.n(f2);
            }
            invalidateSelf();
        }
    }

    public final void c(ColorStateList colorStateList) {
        if (this.f36109e != colorStateList) {
            this.f36109e = colorStateList;
            x();
            onStateChange(getState());
        }
    }

    public final void a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.f36110f, charSequence)) {
            this.f36110f = charSequence;
            this.B.f36481b = true;
            invalidateSelf();
            r();
        }
    }

    public final void a(int i2) {
        a(new d(this.A, i2));
    }

    public final void a(d dVar) {
        this.B.a(dVar, this.A);
    }

    public final void b(boolean z2) {
        if (this.M != z2) {
            boolean s2 = s();
            this.M = z2;
            boolean s3 = s();
            if (s2 != s3) {
                if (s3) {
                    f(this.N);
                } else {
                    e(this.N);
                }
                invalidateSelf();
                r();
            }
        }
    }

    public final Drawable e() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.g(drawable);
        }
        return null;
    }

    public final void b(Drawable drawable) {
        Drawable e2 = e();
        if (e2 != drawable) {
            float b2 = b();
            this.N = drawable != null ? androidx.core.graphics.drawable.a.f(drawable).mutate() : null;
            float b3 = b();
            e(e2);
            if (s()) {
                f(this.N);
            }
            invalidateSelf();
            if (b2 != b3) {
                r();
            }
        }
    }

    public final void d(ColorStateList colorStateList) {
        this.O = true;
        if (this.f36111g != colorStateList) {
            this.f36111g = colorStateList;
            if (s()) {
                androidx.core.graphics.drawable.a.a(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void d(float f2) {
        if (this.f36112h != f2) {
            float b2 = b();
            this.f36112h = f2;
            float b3 = b();
            invalidateSelf();
            if (b2 != b3) {
                r();
            }
        }
    }

    public final void c(boolean z2) {
        if (this.f36113i != z2) {
            boolean u2 = u();
            this.f36113i = z2;
            boolean u3 = u();
            if (u2 != u3) {
                if (u3) {
                    f(this.j);
                } else {
                    e(this.j);
                }
                invalidateSelf();
                r();
            }
        }
    }

    public final Drawable f() {
        Drawable drawable = this.j;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.g(drawable);
        }
        return null;
    }

    public final void c(Drawable drawable) {
        Drawable f2 = f();
        if (f2 != drawable) {
            float c2 = c();
            this.j = drawable != null ? androidx.core.graphics.drawable.a.f(drawable).mutate() : null;
            if (b.f36380a) {
                y();
            }
            float c3 = c();
            e(f2);
            if (u()) {
                f(this.j);
            }
            invalidateSelf();
            if (c2 != c3) {
                r();
            }
        }
    }

    private void y() {
        this.P = new RippleDrawable(b.b(this.f36109e), this.j, J);
    }

    public final void e(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            if (u()) {
                androidx.core.graphics.drawable.a.a(this.j, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void e(float f2) {
        if (this.l != f2) {
            this.l = f2;
            invalidateSelf();
            if (u()) {
                r();
            }
        }
    }

    public final void d(boolean z2) {
        if (this.n != z2) {
            this.n = z2;
            float b2 = b();
            if (!z2 && this.ad) {
                this.ad = false;
            }
            float b3 = b();
            invalidateSelf();
            if (b2 != b3) {
                r();
            }
        }
    }

    public final void e(boolean z2) {
        if (this.Q != z2) {
            boolean t2 = t();
            this.Q = z2;
            boolean t3 = t();
            if (t2 != t3) {
                if (t3) {
                    f(this.o);
                } else {
                    e(this.o);
                }
                invalidateSelf();
                r();
            }
        }
    }

    public final void d(Drawable drawable) {
        if (this.o != drawable) {
            float b2 = b();
            this.o = drawable;
            float b3 = b();
            e(this.o);
            f(this.o);
            invalidateSelf();
            if (b2 != b3) {
                r();
            }
        }
    }

    public final void f(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            if (v()) {
                androidx.core.graphics.drawable.a.a(this.o, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void f(float f2) {
        if (this.s != f2) {
            this.s = f2;
            invalidateSelf();
            r();
        }
    }

    public final void g(float f2) {
        if (this.t != f2) {
            float b2 = b();
            this.t = f2;
            float b3 = b();
            invalidateSelf();
            if (b2 != b3) {
                r();
            }
        }
    }

    public final void h(float f2) {
        if (this.u != f2) {
            float b2 = b();
            this.u = f2;
            float b3 = b();
            invalidateSelf();
            if (b2 != b3) {
                r();
            }
        }
    }

    public final void i(float f2) {
        if (this.v != f2) {
            this.v = f2;
            invalidateSelf();
            r();
        }
    }

    public final void j(float f2) {
        if (this.w != f2) {
            this.w = f2;
            invalidateSelf();
            r();
        }
    }

    public final void k(float f2) {
        if (this.x != f2) {
            this.x = f2;
            invalidateSelf();
            if (u()) {
                r();
            }
        }
    }

    public final void l(float f2) {
        if (this.y != f2) {
            this.y = f2;
            invalidateSelf();
            if (u()) {
                r();
            }
        }
    }

    public final void m(float f2) {
        if (this.z != f2) {
            this.z = f2;
            invalidateSelf();
            r();
        }
    }
}
