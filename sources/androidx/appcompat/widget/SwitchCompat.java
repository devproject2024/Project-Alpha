package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.c.a;
import androidx.core.h.u;
import androidx.core.widget.i;

public class SwitchCompat extends CompoundButton {
    private static final int[] O = {16842912};

    /* renamed from: c  reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f1630c = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf(((SwitchCompat) obj).f1631a);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
        }
    };
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private final TextPaint H;
    private ColorStateList I;
    private Layout J;
    private Layout K;
    private TransformationMethod L;
    private final l M;
    private final Rect N;

    /* renamed from: a  reason: collision with root package name */
    float f1631a;

    /* renamed from: b  reason: collision with root package name */
    ObjectAnimator f1632b;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f1633d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f1634e;

    /* renamed from: f  reason: collision with root package name */
    private PorterDuff.Mode f1635f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1636g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1637h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f1638i;
    private ColorStateList j;
    private PorterDuff.Mode k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private CharSequence r;
    private CharSequence s;
    private boolean t;
    private int u;
    private int v;
    private float w;
    private float x;
    private VelocityTracker y;
    private int z;

    public SwitchCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1634e = null;
        this.f1635f = null;
        this.f1636g = false;
        this.f1637h = false;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = false;
        this.y = VelocityTracker.obtain();
        this.N = new Rect();
        y.a((View) this, getContext());
        this.H = new TextPaint(1);
        Resources resources = getResources();
        this.H.density = resources.getDisplayMetrics().density;
        ac a2 = ac.a(context, attributeSet, R.styleable.SwitchCompat, i2, 0);
        u.a(this, context, R.styleable.SwitchCompat, attributeSet, a2.f1669a, i2);
        this.f1633d = a2.a(R.styleable.SwitchCompat_android_thumb);
        Drawable drawable = this.f1633d;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f1638i = a2.a(R.styleable.SwitchCompat_track);
        Drawable drawable2 = this.f1638i;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.r = a2.c(R.styleable.SwitchCompat_android_textOn);
        this.s = a2.c(R.styleable.SwitchCompat_android_textOff);
        this.t = a2.a(R.styleable.SwitchCompat_showText, true);
        this.n = a2.e(R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.o = a2.e(R.styleable.SwitchCompat_switchMinWidth, 0);
        this.p = a2.e(R.styleable.SwitchCompat_switchPadding, 0);
        this.q = a2.a(R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList e2 = a2.e(R.styleable.SwitchCompat_thumbTint);
        if (e2 != null) {
            this.f1634e = e2;
            this.f1636g = true;
        }
        PorterDuff.Mode a3 = p.a(a2.a(R.styleable.SwitchCompat_thumbTintMode, -1), (PorterDuff.Mode) null);
        if (this.f1635f != a3) {
            this.f1635f = a3;
            this.f1637h = true;
        }
        if (this.f1636g || this.f1637h) {
            b();
        }
        ColorStateList e3 = a2.e(R.styleable.SwitchCompat_trackTint);
        if (e3 != null) {
            this.j = e3;
            this.l = true;
        }
        PorterDuff.Mode a4 = p.a(a2.a(R.styleable.SwitchCompat_trackTintMode, -1), (PorterDuff.Mode) null);
        if (this.k != a4) {
            this.k = a4;
            this.m = true;
        }
        if (this.l || this.m) {
            a();
        }
        int g2 = a2.g(R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (g2 != 0) {
            setSwitchTextAppearance(context, g2);
        }
        this.M = new l(this);
        this.M.a(attributeSet, i2);
        a2.f1669a.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.v = viewConfiguration.getScaledTouchSlop();
        this.z = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTextAppearance(Context context, int i2) {
        Typeface typeface;
        ac a2 = ac.a(context, i2, R.styleable.TextAppearance);
        ColorStateList e2 = a2.e(R.styleable.TextAppearance_android_textColor);
        if (e2 != null) {
            this.I = e2;
        } else {
            this.I = getTextColors();
        }
        int e3 = a2.e(R.styleable.TextAppearance_android_textSize, 0);
        if (e3 != 0) {
            float f2 = (float) e3;
            if (f2 != this.H.getTextSize()) {
                this.H.setTextSize(f2);
                requestLayout();
            }
        }
        int a3 = a2.a(R.styleable.TextAppearance_android_typeface, -1);
        int a4 = a2.a(R.styleable.TextAppearance_android_textStyle, -1);
        if (a3 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (a3 != 2) {
            typeface = a3 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        setSwitchTypeface(typeface, a4);
        if (a2.a(R.styleable.TextAppearance_textAllCaps, false)) {
            this.L = new a(getContext());
        } else {
            this.L = null;
        }
        a2.f1669a.recycle();
    }

    public void setSwitchTypeface(Typeface typeface, int i2) {
        Typeface typeface2;
        float f2 = 0.0f;
        boolean z2 = false;
        if (i2 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i2);
            } else {
                typeface2 = Typeface.create(typeface, i2);
            }
            setSwitchTypeface(typeface2);
            int i3 = (~(typeface2 != null ? typeface2.getStyle() : 0)) & i2;
            TextPaint textPaint = this.H;
            if ((i3 & 1) != 0) {
                z2 = true;
            }
            textPaint.setFakeBoldText(z2);
            TextPaint textPaint2 = this.H;
            if ((i3 & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint2.setTextSkewX(f2);
            return;
        }
        this.H.setFakeBoldText(false);
        this.H.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.H.getTypeface() != null && !this.H.getTypeface().equals(typeface)) || (this.H.getTypeface() == null && typeface != null)) {
            this.H.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i2) {
        this.p = i2;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.p;
    }

    public void setSwitchMinWidth(int i2) {
        this.o = i2;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.o;
    }

    public void setThumbTextPadding(int i2) {
        this.n = i2;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.n;
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1638i;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1638i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public Drawable getTrackDrawable() {
        return this.f1638i;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.l = true;
        a();
    }

    public ColorStateList getTrackTintList() {
        return this.j;
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.m = true;
        a();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.k;
    }

    private void a() {
        if (this.f1638i == null) {
            return;
        }
        if (this.l || this.m) {
            this.f1638i = androidx.core.graphics.drawable.a.f(this.f1638i).mutate();
            if (this.l) {
                androidx.core.graphics.drawable.a.a(this.f1638i, this.j);
            }
            if (this.m) {
                androidx.core.graphics.drawable.a.a(this.f1638i, this.k);
            }
            if (this.f1638i.isStateful()) {
                this.f1638i.setState(getDrawableState());
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1633d;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1633d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public Drawable getThumbDrawable() {
        return this.f1633d;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f1634e = colorStateList;
        this.f1636g = true;
        b();
    }

    public ColorStateList getThumbTintList() {
        return this.f1634e;
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f1635f = mode;
        this.f1637h = true;
        b();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f1635f;
    }

    private void b() {
        if (this.f1633d == null) {
            return;
        }
        if (this.f1636g || this.f1637h) {
            this.f1633d = androidx.core.graphics.drawable.a.f(this.f1633d).mutate();
            if (this.f1636g) {
                androidx.core.graphics.drawable.a.a(this.f1633d, this.f1634e);
            }
            if (this.f1637h) {
                androidx.core.graphics.drawable.a.a(this.f1633d, this.f1635f);
            }
            if (this.f1633d.isStateful()) {
                this.f1633d.setState(getDrawableState());
            }
        }
    }

    public void setSplitTrack(boolean z2) {
        this.q = z2;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.q;
    }

    public CharSequence getTextOn() {
        return this.r;
    }

    public void setTextOn(CharSequence charSequence) {
        this.r = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.s;
    }

    public void setTextOff(CharSequence charSequence) {
        this.s = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z2) {
        if (this.t != z2) {
            this.t = z2;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.t;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.t) {
            if (this.J == null) {
                this.J = a(this.r);
            }
            if (this.K == null) {
                this.K = a(this.s);
            }
        }
        Rect rect = this.N;
        Drawable drawable = this.f1633d;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i5 = (this.f1633d.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.f1633d.getIntrinsicHeight();
        } else {
            i5 = 0;
            i4 = 0;
        }
        this.C = Math.max(this.t ? Math.max(this.J.getWidth(), this.K.getWidth()) + (this.n * 2) : 0, i5);
        Drawable drawable2 = this.f1638i;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.f1638i.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.f1633d;
        if (drawable3 != null) {
            Rect a2 = p.a(drawable3);
            i7 = Math.max(i7, a2.left);
            i8 = Math.max(i8, a2.right);
        }
        int max = Math.max(this.o, (this.C * 2) + i7 + i8);
        int max2 = Math.max(i6, i4);
        this.A = max;
        this.B = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.r : this.s;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    private Layout a(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.L;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.H;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r0 != 3) goto L_0x0158;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            android.view.VelocityTracker r0 = r9.y
            r0.addMovement(r10)
            int r0 = r10.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0102
            r3 = 3
            r4 = 2
            r5 = 0
            if (r0 == r2) goto L_0x0095
            if (r0 == r4) goto L_0x0018
            if (r0 == r3) goto L_0x0095
            goto L_0x0158
        L_0x0018:
            int r0 = r9.u
            if (r0 == 0) goto L_0x0158
            if (r0 == r2) goto L_0x0061
            if (r0 == r4) goto L_0x0022
            goto L_0x0158
        L_0x0022:
            float r10 = r10.getX()
            int r0 = r9.getThumbScrollRange()
            float r1 = r9.w
            float r1 = r10 - r1
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0036
            float r0 = (float) r0
            float r0 = r1 / r0
            goto L_0x003f
        L_0x0036:
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x003d
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003f
        L_0x003d:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003f:
            boolean r1 = androidx.appcompat.widget.ai.a(r9)
            if (r1 == 0) goto L_0x0046
            float r0 = -r0
        L_0x0046:
            float r1 = r9.f1631a
            float r0 = r0 + r1
            int r1 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x004f
            r0 = 0
            goto L_0x0055
        L_0x004f:
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0055
            r0 = 1065353216(0x3f800000, float:1.0)
        L_0x0055:
            float r1 = r9.f1631a
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0060
            r9.w = r10
            r9.setThumbPosition(r0)
        L_0x0060:
            return r2
        L_0x0061:
            float r0 = r10.getX()
            float r1 = r10.getY()
            float r3 = r9.w
            float r3 = r0 - r3
            float r3 = java.lang.Math.abs(r3)
            int r5 = r9.v
            float r5 = (float) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0087
            float r3 = r9.x
            float r3 = r1 - r3
            float r3 = java.lang.Math.abs(r3)
            int r5 = r9.v
            float r5 = (float) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0158
        L_0x0087:
            r9.u = r4
            android.view.ViewParent r10 = r9.getParent()
            r10.requestDisallowInterceptTouchEvent(r2)
            r9.w = r0
            r9.x = r1
            return r2
        L_0x0095:
            int r0 = r9.u
            if (r0 != r4) goto L_0x00fa
            r9.u = r1
            int r0 = r10.getAction()
            if (r0 != r2) goto L_0x00a9
            boolean r0 = r9.isEnabled()
            if (r0 == 0) goto L_0x00a9
            r0 = 1
            goto L_0x00aa
        L_0x00a9:
            r0 = 0
        L_0x00aa:
            boolean r4 = r9.isChecked()
            if (r0 == 0) goto L_0x00e0
            android.view.VelocityTracker r0 = r9.y
            r6 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r6)
            android.view.VelocityTracker r0 = r9.y
            float r0 = r0.getXVelocity()
            float r6 = java.lang.Math.abs(r0)
            int r7 = r9.z
            float r7 = (float) r7
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x00db
            boolean r6 = androidx.appcompat.widget.ai.a(r9)
            if (r6 == 0) goto L_0x00d3
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d9
            goto L_0x00d7
        L_0x00d3:
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d9
        L_0x00d7:
            r0 = 1
            goto L_0x00e1
        L_0x00d9:
            r0 = 0
            goto L_0x00e1
        L_0x00db:
            boolean r0 = r9.getTargetCheckedState()
            goto L_0x00e1
        L_0x00e0:
            r0 = r4
        L_0x00e1:
            if (r0 == r4) goto L_0x00e6
            r9.playSoundEffect(r1)
        L_0x00e6:
            r9.setChecked(r0)
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r10)
            r0.setAction(r3)
            super.onTouchEvent(r0)
            r0.recycle()
            super.onTouchEvent(r10)
            return r2
        L_0x00fa:
            r9.u = r1
            android.view.VelocityTracker r0 = r9.y
            r0.clear()
            goto L_0x0158
        L_0x0102:
            float r0 = r10.getX()
            float r3 = r10.getY()
            boolean r4 = r9.isEnabled()
            if (r4 == 0) goto L_0x0158
            android.graphics.drawable.Drawable r4 = r9.f1633d
            if (r4 == 0) goto L_0x0150
            int r4 = r9.getThumbOffset()
            android.graphics.drawable.Drawable r5 = r9.f1633d
            android.graphics.Rect r6 = r9.N
            r5.getPadding(r6)
            int r5 = r9.E
            int r6 = r9.v
            int r5 = r5 - r6
            int r7 = r9.D
            int r7 = r7 + r4
            int r7 = r7 - r6
            int r4 = r9.C
            int r4 = r4 + r7
            android.graphics.Rect r6 = r9.N
            int r6 = r6.left
            int r4 = r4 + r6
            android.graphics.Rect r6 = r9.N
            int r6 = r6.right
            int r4 = r4 + r6
            int r6 = r9.v
            int r4 = r4 + r6
            int r8 = r9.G
            int r8 = r8 + r6
            float r6 = (float) r7
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0150
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0150
            float r4 = (float) r5
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0150
            float r4 = (float) r8
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0150
            r1 = 1
        L_0x0150:
            if (r1 == 0) goto L_0x0158
            r9.u = r2
            r9.w = r0
            r9.x = r3
        L_0x0158:
            boolean r10 = super.onTouchEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean getTargetCheckedState() {
        return this.f1631a > 0.5f;
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f2) {
        this.f1631a = f2;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z2) {
        super.setChecked(z2);
        boolean isChecked = isChecked();
        float f2 = 1.0f;
        if (getWindowToken() == null || !u.J(this)) {
            ObjectAnimator objectAnimator = this.f1632b;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (!isChecked) {
                f2 = 0.0f;
            }
            setThumbPosition(f2);
            return;
        }
        if (!isChecked) {
            f2 = 0.0f;
        }
        this.f1632b = ObjectAnimator.ofFloat(this, f1630c, new float[]{f2});
        this.f1632b.setDuration(250);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f1632b.setAutoCancel(true);
        }
        this.f1632b.start();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        super.onLayout(z2, i2, i3, i4, i5);
        int i12 = 0;
        if (this.f1633d != null) {
            Rect rect = this.N;
            Drawable drawable = this.f1638i;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a2 = p.a(this.f1633d);
            i6 = Math.max(0, a2.left - rect.left);
            i12 = Math.max(0, a2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (ai.a(this)) {
            i8 = getPaddingLeft() + i6;
            i7 = ((this.A + i8) - i6) - i12;
        } else {
            i7 = (getWidth() - getPaddingRight()) - i12;
            i8 = (i7 - this.A) + i6 + i12;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i11 = this.B;
            i10 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i11 / 2);
        } else if (gravity != 80) {
            i10 = getPaddingTop();
            i11 = this.B;
        } else {
            i9 = getHeight() - getPaddingBottom();
            i10 = i9 - this.B;
            this.D = i8;
            this.E = i10;
            this.G = i9;
            this.F = i7;
        }
        i9 = i11 + i10;
        this.D = i8;
        this.E = i10;
        this.G = i9;
        this.F = i7;
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        Rect rect2 = this.N;
        int i4 = this.D;
        int i5 = this.E;
        int i6 = this.F;
        int i7 = this.G;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f1633d;
        if (drawable != null) {
            rect = p.a(drawable);
        } else {
            rect = p.f1781a;
        }
        Drawable drawable2 = this.f1638i;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            thumbOffset += rect2.left;
            if (rect != null) {
                if (rect.left > rect2.left) {
                    i4 += rect.left - rect2.left;
                }
                i2 = rect.top > rect2.top ? (rect.top - rect2.top) + i5 : i5;
                if (rect.right > rect2.right) {
                    i6 -= rect.right - rect2.right;
                }
                if (rect.bottom > rect2.bottom) {
                    i3 = i7 - (rect.bottom - rect2.bottom);
                    this.f1638i.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f1638i.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f1633d;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i8 = thumbOffset - rect2.left;
            int i9 = thumbOffset + this.C + rect2.right;
            this.f1633d.setBounds(i8, i5, i9, i7);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.a(background, i8, i5, i9, i7);
            }
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        Rect rect = this.N;
        Drawable drawable = this.f1638i;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.E;
        int i4 = this.G;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.f1633d;
        if (drawable != null) {
            if (!this.q || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a2 = p.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a2.left;
                rect.right -= a2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.J : this.K;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.I;
            if (colorStateList != null) {
                this.H.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.H.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i2 = bounds.left + bounds.right;
            } else {
                i2 = getWidth();
            }
            canvas.translate((float) ((i2 / 2) - (layout.getWidth() / 2)), (float) (((i5 + i6) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public int getCompoundPaddingLeft() {
        if (!ai.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.p : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (ai.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.p : compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f2;
        if (ai.a(this)) {
            f2 = 1.0f - this.f1631a;
        } else {
            f2 = this.f1631a;
        }
        return (int) ((f2 * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f1638i;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.N;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.f1633d;
        if (drawable2 != null) {
            rect = p.a(drawable2);
        } else {
            rect = p.f1781a;
        }
        return ((((this.A - this.C) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, O);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1633d;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f1638i;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.f1633d;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, f2, f3);
        }
        Drawable drawable2 = this.f1638i;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.a(drawable2, f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1633d || drawable == this.f1638i;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1633d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1638i;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f1632b;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f1632b.end();
            this.f1632b = null;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.r : this.s;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }
}
