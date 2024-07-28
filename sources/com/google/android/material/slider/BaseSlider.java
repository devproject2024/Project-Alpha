package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import androidx.core.h.a.c;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.internal.p;
import com.google.android.material.internal.q;
import com.google.android.material.k.d;
import com.google.android.material.k.h;
import com.google.android.material.k.i;
import com.google.android.material.k.m;
import com.google.android.material.slider.BaseSlider;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.Object;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends Object<S>, T extends Object<S>> extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36632a = BaseSlider.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final int f36633b = R.style.Widget_MaterialComponents_Slider;
    private a A;
    private boolean B;
    private float C;
    private float D;
    private ArrayList<Float> E;
    private int F;
    private int G;
    private float H;
    private float[] I;
    private int J;
    private boolean K;
    private boolean L;
    private boolean M;
    private ColorStateList N;
    private ColorStateList O;
    private ColorStateList P;
    private ColorStateList Q;
    private ColorStateList R;
    private final h S;
    private float T;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f36634c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f36635d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f36636e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f36637f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f36638g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f36639h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final b f36640i;
    private final AccessibilityManager j;
    private BaseSlider<S, L, T>.defpackage.a k;
    private final c l;
    private final List<com.google.android.material.l.a> m;
    private final List<L> n;
    private final List<T> o;
    private final int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private float y;
    private MotionEvent z;

    interface c {
        com.google.android.material.l.a a();
    }

    public BaseSlider(Context context) {
        this(context, (AttributeSet) null);
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public BaseSlider(Context context, final AttributeSet attributeSet, final int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f36633b), attributeSet, i2);
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.B = false;
        this.E = new ArrayList<>();
        this.F = -1;
        this.G = -1;
        this.H = 0.0f;
        this.L = false;
        this.S = new h();
        Context context2 = getContext();
        this.f36634c = new Paint();
        this.f36634c.setStyle(Paint.Style.STROKE);
        this.f36634c.setStrokeCap(Paint.Cap.ROUND);
        this.f36635d = new Paint();
        this.f36635d.setStyle(Paint.Style.STROKE);
        this.f36635d.setStrokeCap(Paint.Cap.ROUND);
        this.f36636e = new Paint(1);
        this.f36636e.setStyle(Paint.Style.FILL);
        this.f36636e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f36637f = new Paint(1);
        this.f36637f.setStyle(Paint.Style.FILL);
        this.f36638g = new Paint();
        this.f36638g.setStyle(Paint.Style.STROKE);
        this.f36638g.setStrokeCap(Paint.Cap.ROUND);
        this.f36639h = new Paint();
        this.f36639h.setStyle(Paint.Style.STROKE);
        this.f36639h.setStrokeCap(Paint.Cap.ROUND);
        Resources resources = context2.getResources();
        this.q = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        this.t = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.u = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.x = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        this.l = new c() {
            public final com.google.android.material.l.a a() {
                TypedArray a2 = k.a(BaseSlider.this.getContext(), attributeSet, R.styleable.Slider, i2, BaseSlider.f36633b, new int[0]);
                com.google.android.material.l.a a3 = com.google.android.material.l.a.a(BaseSlider.this.getContext(), a2.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
                a2.recycle();
                return a3;
            }
        };
        TypedArray a2 = k.a(context2, attributeSet, R.styleable.Slider, i2, f36633b, new int[0]);
        this.C = a2.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.D = a2.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.C));
        this.H = a2.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        boolean hasValue = a2.hasValue(R.styleable.Slider_trackColor);
        int i3 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorInactive;
        int i4 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorActive;
        ColorStateList a3 = com.google.android.material.h.c.a(context2, a2, i3);
        setTrackInactiveTintList(a3 == null ? androidx.appcompat.a.a.a.a(context2, R.color.material_slider_inactive_track_color) : a3);
        ColorStateList a4 = com.google.android.material.h.c.a(context2, a2, i4);
        setTrackActiveTintList(a4 == null ? androidx.appcompat.a.a.a.a(context2, R.color.material_slider_active_track_color) : a4);
        this.S.g(com.google.android.material.h.c.a(context2, a2, R.styleable.Slider_thumbColor));
        ColorStateList a5 = com.google.android.material.h.c.a(context2, a2, R.styleable.Slider_haloColor);
        setHaloTintList(a5 == null ? androidx.appcompat.a.a.a.a(context2, R.color.material_slider_halo_color) : a5);
        boolean hasValue2 = a2.hasValue(R.styleable.Slider_tickColor);
        int i5 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorInactive;
        int i6 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorActive;
        ColorStateList a6 = com.google.android.material.h.c.a(context2, a2, i5);
        setTickInactiveTintList(a6 == null ? androidx.appcompat.a.a.a.a(context2, R.color.material_slider_inactive_tick_marks_color) : a6);
        ColorStateList a7 = com.google.android.material.h.c.a(context2, a2, i6);
        setTickActiveTintList(a7 == null ? androidx.appcompat.a.a.a.a(context2, R.color.material_slider_active_tick_marks_color) : a7);
        setThumbRadius(a2.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(a2.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(a2.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(a2.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.r = a2.getInt(R.styleable.Slider_labelBehavior, 0);
        a2.recycle();
        setFocusable(true);
        setClickable(true);
        this.S.h();
        this.p = ViewConfiguration.get(context2).getScaledTouchSlop();
        this.f36640i = new b(this);
        u.a((View) this, (androidx.core.h.a) this.f36640i);
        this.j = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private void e() {
        Iterator<Float> it2 = this.E.iterator();
        while (it2.hasNext()) {
            Float next = it2.next();
            if (next.floatValue() < this.C || next.floatValue() > this.D) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[]{Float.toString(next.floatValue()), Float.toString(this.C), Float.toString(this.D)}));
            } else if (this.H > 0.0f && ((double) (((this.C - next.floatValue()) / this.H) % 1.0f)) > 1.0E-4d) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[]{Float.toString(next.floatValue()), Float.toString(this.C), Float.toString(this.H), Float.toString(this.H)}));
            }
        }
    }

    private void f() {
        if (this.M) {
            float f2 = this.C;
            float f3 = this.D;
            if (f2 >= f3) {
                throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[]{Float.toString(f2), Float.toString(this.D)}));
            } else if (f3 > f2) {
                float f4 = this.H;
                if (f4 <= 0.0f || ((double) (((f3 - f2) / f4) % 1.0f)) <= 1.0E-4d) {
                    e();
                    this.M = false;
                    return;
                }
                throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.toString(f4), Float.toString(this.C), Float.toString(this.D)}));
            } else {
                throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[]{Float.toString(f3), Float.toString(this.C)}));
            }
        }
    }

    public float getValueFrom() {
        return this.C;
    }

    public void setValueFrom(float f2) {
        this.C = f2;
        this.M = true;
        postInvalidate();
    }

    public float getValueTo() {
        return this.D;
    }

    public void setValueTo(float f2) {
        this.D = f2;
        this.M = true;
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public List<Float> getValues() {
        return new ArrayList(this.E);
    }

    /* access modifiers changed from: package-private */
    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList(list));
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.E.size() != arrayList.size() || !this.E.equals(arrayList)) {
                this.E = arrayList;
                this.M = true;
                this.G = 0;
                i();
                g();
                m();
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private void g() {
        if (this.m.size() > this.E.size()) {
            List<com.google.android.material.l.a> subList = this.m.subList(this.E.size(), this.m.size());
            for (com.google.android.material.l.a next : subList) {
                if (u.M(this)) {
                    b(next);
                }
            }
            subList.clear();
        }
        while (this.m.size() < this.E.size()) {
            com.google.android.material.l.a a2 = this.l.a();
            this.m.add(a2);
            if (u.M(this)) {
                a(a2);
            }
        }
        int i2 = 1;
        if (this.m.size() == 1) {
            i2 = 0;
        }
        for (com.google.android.material.l.a n2 : this.m) {
            n2.n((float) i2);
        }
    }

    public float getStepSize() {
        return this.H;
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.toString(f2), Float.toString(this.C), Float.toString(this.D)}));
        } else if (this.H != f2) {
            this.H = f2;
            this.M = true;
            postInvalidate();
        }
    }

    public int getFocusedThumbIndex() {
        return this.G;
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 < 0 || i2 >= this.E.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.G = i2;
        this.f36640i.d(this.G);
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void setActiveThumbIndex(int i2) {
        this.F = i2;
    }

    public int getActiveThumbIndex() {
        return this.F;
    }

    public boolean a() {
        return this.A != null;
    }

    public void setLabelFormatter(a aVar) {
        this.A = aVar;
    }

    public float getThumbElevation() {
        return this.S.G.o;
    }

    public void setThumbElevation(float f2) {
        this.S.r(f2);
    }

    public void setThumbElevationResource(int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public int getThumbRadius() {
        return this.v;
    }

    public void setThumbRadius(int i2) {
        if (i2 != this.v) {
            this.v = i2;
            h hVar = this.S;
            m.a a2 = m.a();
            d a3 = i.a(0);
            hVar.setShapeAppearanceModel(a2.a(a3).b(a3).c(a3).d(a3).a((float) this.v).a());
            h hVar2 = this.S;
            int i3 = this.v;
            hVar2.setBounds(0, 0, i3 * 2, i3 * 2);
            postInvalidate();
        }
    }

    public void setThumbRadiusResource(int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public int getHaloRadius() {
        return this.w;
    }

    public void setHaloRadius(int i2) {
        if (i2 != this.w) {
            this.w = i2;
            Drawable background = getBackground();
            if (k() || !(background instanceof RippleDrawable)) {
                postInvalidate();
                return;
            }
            RippleDrawable rippleDrawable = (RippleDrawable) background;
            int i3 = this.w;
            if (Build.VERSION.SDK_INT >= 23) {
                rippleDrawable.setRadius(i3);
                return;
            }
            Class<RippleDrawable> cls = RippleDrawable.class;
            try {
                cls.getDeclaredMethod("setMaxRadius", new Class[]{Integer.TYPE}).invoke(rippleDrawable, new Object[]{Integer.valueOf(i3)});
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                throw new IllegalStateException("Couldn't set RippleDrawable radius", e2);
            }
        }
    }

    public void setHaloRadiusResource(int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public int getLabelBehavior() {
        return this.r;
    }

    public void setLabelBehavior(int i2) {
        if (this.r != i2) {
            this.r = i2;
            requestLayout();
        }
    }

    public int getTrackSidePadding() {
        return this.t;
    }

    public int getTrackWidth() {
        return this.J;
    }

    public int getTrackHeight() {
        return this.s;
    }

    public void setTrackHeight(int i2) {
        if (this.s != i2) {
            this.s = i2;
            this.f36634c.setStrokeWidth((float) this.s);
            this.f36635d.setStrokeWidth((float) this.s);
            this.f36638g.setStrokeWidth(((float) this.s) / 2.0f);
            this.f36639h.setStrokeWidth(((float) this.s) / 2.0f);
            postInvalidate();
        }
    }

    public ColorStateList getHaloTintList() {
        return this.N;
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.N)) {
            this.N = colorStateList;
            Drawable background = getBackground();
            if (k() || !(background instanceof RippleDrawable)) {
                this.f36637f.setColor(a(colorStateList));
                this.f36637f.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    public ColorStateList getThumbTintList() {
        return this.S.G.f36539d;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.S.g(colorStateList);
    }

    public ColorStateList getTickTintList() {
        if (this.P.equals(this.O)) {
            return this.O;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public ColorStateList getTickActiveTintList() {
        return this.O;
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.O)) {
            this.O = colorStateList;
            this.f36639h.setColor(a(this.O));
            invalidate();
        }
    }

    public ColorStateList getTickInactiveTintList() {
        return this.P;
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.P)) {
            this.P = colorStateList;
            this.f36638g.setColor(a(this.P));
            invalidate();
        }
    }

    public ColorStateList getTrackTintList() {
        if (this.R.equals(this.Q)) {
            return this.Q;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public ColorStateList getTrackActiveTintList() {
        return this.Q;
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.Q)) {
            this.Q = colorStateList;
            this.f36635d.setColor(a(this.Q));
            invalidate();
        }
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.R;
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.R)) {
            this.R = colorStateList;
            this.f36634c.setColor(a(this.R));
            invalidate();
        }
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setLayerType(z2 ? 0 : 2, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (com.google.android.material.l.a a2 : this.m) {
            a(a2);
        }
    }

    private void a(com.google.android.material.l.a aVar) {
        aVar.a((View) q.d(this));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.defpackage.a aVar = this.k;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
        for (com.google.android.material.l.a b2 : this.m) {
            b(b2);
        }
        super.onDetachedFromWindow();
    }

    private void b(com.google.android.material.l.a aVar) {
        p e2 = q.e(this);
        if (e2 != null) {
            e2.b(aVar);
            aVar.b(q.d(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = this.q;
        int i5 = 0;
        if (this.r == 1) {
            i5 = this.m.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4 + i5, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.J = Math.max(i2 - (this.t * 2), 0);
        if (this.H > 0.0f) {
            h();
        }
        i();
    }

    private void h() {
        f();
        int min = Math.min((int) (((this.D - this.C) / this.H) + 1.0f), (this.J / (this.s * 2)) + 1);
        float[] fArr = this.I;
        if (fArr == null || fArr.length != min * 2) {
            this.I = new float[(min * 2)];
        }
        float f2 = ((float) this.J) / ((float) (min - 1));
        for (int i2 = 0; i2 < min * 2; i2 += 2) {
            float[] fArr2 = this.I;
            fArr2[i2] = ((float) this.t) + (((float) (i2 / 2)) * f2);
            fArr2[i2 + 1] = (float) j();
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (!k() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int a2 = (int) ((a(this.E.get(this.G).floatValue()) * ((float) this.J)) + ((float) this.t));
                int j2 = j();
                int i2 = this.w;
                androidx.core.graphics.drawable.a.a(background, a2 - i2, j2 - i2, a2 + i2, j2 + i2);
            }
        }
    }

    private int j() {
        int i2 = this.u;
        int i3 = 0;
        if (this.r == 1) {
            i3 = this.m.get(0).getIntrinsicHeight();
        }
        return i2 + i3;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.M) {
            f();
            if (this.H > 0.0f) {
                h();
            }
        }
        super.onDraw(canvas);
        int j2 = j();
        int i2 = this.J;
        float[] activeRange = getActiveRange();
        int i3 = this.t;
        float f2 = (float) i2;
        float f3 = ((float) i3) + (activeRange[1] * f2);
        if (f3 < ((float) (i3 + i2))) {
            float f4 = (float) j2;
            canvas.drawLine(f3, f4, (float) (i3 + i2), f4, this.f36634c);
        }
        int i4 = this.t;
        float f5 = ((float) i4) + (activeRange[0] * f2);
        if (f5 > ((float) i4)) {
            float f6 = (float) j2;
            canvas.drawLine((float) i4, f6, f5, f6, this.f36634c);
        }
        if (((Float) Collections.max(getValues())).floatValue() > this.C) {
            int i5 = this.J;
            float[] activeRange2 = getActiveRange();
            int i6 = this.t;
            float f7 = (float) i5;
            float f8 = ((float) i6) + (activeRange2[1] * f7);
            float f9 = activeRange2[0] * f7;
            float f10 = (float) j2;
            canvas.drawLine(f9 + ((float) i6), f10, f8, f10, this.f36635d);
        }
        if (this.H > 0.0f) {
            float[] activeRange3 = getActiveRange();
            int a2 = a(this.I, activeRange3[0]);
            int a3 = a(this.I, activeRange3[1]);
            int i7 = a2 * 2;
            canvas.drawPoints(this.I, 0, i7, this.f36638g);
            int i8 = a3 * 2;
            canvas.drawPoints(this.I, i7, i8 - i7, this.f36639h);
            float[] fArr = this.I;
            canvas.drawPoints(fArr, i8, fArr.length - i8, this.f36638g);
        }
        if ((this.B || isFocused()) && isEnabled()) {
            int i9 = this.J;
            if (k()) {
                int a4 = (int) (((float) this.t) + (a(this.E.get(this.G).floatValue()) * ((float) i9)));
                if (Build.VERSION.SDK_INT < 28) {
                    int i10 = this.w;
                    canvas.clipRect((float) (a4 - i10), (float) (j2 - i10), (float) (a4 + i10), (float) (i10 + j2), Region.Op.UNION);
                }
                canvas.drawCircle((float) a4, (float) j2, (float) this.w, this.f36637f);
            }
            if (!(this.F == -1 || this.r == 2)) {
                Iterator<com.google.android.material.l.a> it2 = this.m.iterator();
                for (int i11 = 0; i11 < this.E.size() && it2.hasNext(); i11++) {
                    if (i11 != this.G) {
                        a(it2.next(), this.E.get(i11).floatValue());
                    }
                }
                if (it2.hasNext()) {
                    a(it2.next(), this.E.get(this.G).floatValue());
                } else {
                    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.m.size()), Integer.valueOf(this.E.size())}));
                }
            }
        }
        a(canvas, this.J, j2);
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.E.size() == 1) {
            floatValue2 = this.C;
        }
        float a2 = a(floatValue2);
        float a3 = a(floatValue);
        if (c()) {
            return new float[]{a3, a2};
        }
        return new float[]{a2, a3};
    }

    private float a(float f2) {
        float f3 = this.C;
        float f4 = (f2 - f3) / (this.D - f3);
        return c() ? 1.0f - f4 : f4;
    }

    private void a(Canvas canvas, int i2, int i3) {
        if (!isEnabled()) {
            Iterator<Float> it2 = this.E.iterator();
            while (it2.hasNext()) {
                canvas.drawCircle(((float) this.t) + (a(it2.next().floatValue()) * ((float) i2)), (float) i3, (float) this.v, this.f36636e);
            }
        }
        Iterator<Float> it3 = this.E.iterator();
        while (it3.hasNext()) {
            canvas.save();
            int a2 = this.t + ((int) (a(it3.next().floatValue()) * ((float) i2)));
            int i4 = this.v;
            canvas.translate((float) (a2 - i4), (float) (i3 - i4));
            this.S.draw(canvas);
            canvas.restore();
        }
    }

    private boolean k() {
        return this.K || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2 = false;
        if (!isEnabled()) {
            return false;
        }
        float x2 = motionEvent.getX();
        this.T = (x2 - ((float) this.t)) / ((float) this.J);
        this.T = Math.max(0.0f, this.T);
        this.T = Math.min(1.0f, this.T);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.B = false;
                MotionEvent motionEvent2 = this.z;
                if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.z.getX() - motionEvent.getX()) <= ((float) this.p) && Math.abs(this.z.getY() - motionEvent.getY()) <= ((float) this.p)) {
                    b();
                }
                if (this.F != -1) {
                    l();
                    this.F = -1;
                }
                for (com.google.android.material.l.a b2 : this.m) {
                    q.e(this).b(b2);
                }
                Iterator<T> it2 = this.o.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            } else if (actionMasked == 2) {
                if (!this.B) {
                    if (Math.abs(x2 - this.y) < ((float) this.p)) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    n();
                }
                if (b()) {
                    this.B = true;
                    l();
                    i();
                }
            }
            invalidate();
        } else {
            this.y = x2;
            ViewParent parent = getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    break;
                } else if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                    z2 = true;
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
            if (!z2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (b()) {
                    requestFocus();
                    this.B = true;
                    l();
                    i();
                    invalidate();
                    n();
                }
            }
        }
        setPressed(this.B);
        this.z = MotionEvent.obtain(motionEvent);
        return true;
    }

    private static int a(float[] fArr, float f2) {
        return Math.round(f2 * ((float) ((fArr.length / 2) - 1)));
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        if (this.F != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float c2 = c(valueOfTouchPositionAbsolute);
        this.F = 0;
        float abs = Math.abs(this.E.get(this.F).floatValue() - valueOfTouchPositionAbsolute);
        for (int i2 = 1; i2 < this.E.size(); i2++) {
            float abs2 = Math.abs(this.E.get(i2).floatValue() - valueOfTouchPositionAbsolute);
            float c3 = c(this.E.get(i2).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z2 = !c() ? c3 - c2 < 0.0f : c3 - c2 > 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.F = i2;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(c3 - c2) < ((float) this.p)) {
                    this.F = -1;
                    return false;
                } else if (z2) {
                    this.F = i2;
                }
            }
            abs = abs2;
        }
        if (this.F != -1) {
            return true;
        }
        return false;
    }

    private float getValueOfTouchPositionAbsolute() {
        float f2 = this.T;
        if (c()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.D;
        float f4 = this.C;
        return (f2 * (f3 - f4)) + f4;
    }

    private boolean l() {
        return b(getValueOfTouchPosition());
    }

    private boolean b(float f2) {
        return a(this.F, f2);
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, float f2) {
        if (((double) Math.abs(f2 - this.E.get(i2).floatValue())) < 1.0E-4d) {
            return false;
        }
        this.E.set(i2, Float.valueOf(b(i2, f2)));
        this.G = i2;
        a(i2);
        return true;
    }

    private float b(int i2, float f2) {
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        return androidx.core.c.a.a(f2, i4 < 0 ? this.C : this.E.get(i4).floatValue(), i3 >= this.E.size() ? this.D : this.E.get(i3).floatValue());
    }

    private float getValueOfTouchPosition() {
        double d2;
        float f2 = this.T;
        float f3 = this.H;
        if (f3 > 0.0f) {
            int i2 = (int) ((this.D - this.C) / f3);
            d2 = ((double) Math.round(f2 * ((float) i2))) / ((double) i2);
        } else {
            d2 = (double) f2;
        }
        if (c()) {
            d2 = 1.0d - d2;
        }
        float f4 = this.D;
        float f5 = this.C;
        return (float) ((d2 * ((double) (f4 - f5))) + ((double) f5));
    }

    private float c(float f2) {
        return (a(f2) * ((float) this.J)) + ((float) this.t);
    }

    /* access modifiers changed from: private */
    public String d(float f2) {
        if (a()) {
            return this.A.a();
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", new Object[]{Float.valueOf(f2)});
    }

    private void a(com.google.android.material.l.a aVar, float f2) {
        aVar.a((CharSequence) d(f2));
        int a2 = (this.t + ((int) (a(f2) * ((float) this.J)))) - (aVar.getIntrinsicWidth() / 2);
        int j2 = j() - (this.x + this.v);
        aVar.setBounds(a2, j2 - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + a2, j2);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.b.a(q.d(this), (View) this, rect);
        aVar.setBounds(rect);
        q.e(this).a(aVar);
    }

    private void m() {
        Iterator<L> it2 = this.n.iterator();
        while (it2.hasNext()) {
            it2.next();
            Iterator<Float> it3 = this.E.iterator();
            while (it3.hasNext()) {
                it3.next().floatValue();
            }
        }
    }

    private void a(int i2) {
        Iterator<L> it2 = this.n.iterator();
        while (it2.hasNext()) {
            it2.next();
            this.E.get(i2).floatValue();
        }
        AccessibilityManager accessibilityManager = this.j;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            d(i2);
        }
    }

    private void n() {
        Iterator<T> it2 = this.o.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f36634c.setColor(a(this.R));
        this.f36635d.setColor(a(this.Q));
        this.f36638g.setColor(a(this.P));
        this.f36639h.setColor(a(this.O));
        for (com.google.android.material.l.a next : this.m) {
            if (next.isStateful()) {
                next.setState(getDrawableState());
            }
        }
        if (this.S.isStateful()) {
            this.S.setState(getDrawableState());
        }
        this.f36637f.setColor(a(this.N));
        this.f36637f.setAlpha(63);
    }

    private int a(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Boolean} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r12, android.view.KeyEvent r13) {
        /*
            r11 = this;
            boolean r0 = r11.isEnabled()
            if (r0 != 0) goto L_0x000b
            boolean r12 = super.onKeyDown(r12, r13)
            return r12
        L_0x000b:
            java.util.ArrayList<java.lang.Float> r0 = r11.E
            int r0 = r0.size()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x0017
            r11.F = r1
        L_0x0017:
            int r0 = r11.F
            r3 = 0
            r4 = 70
            r5 = 69
            r6 = 81
            r7 = 66
            r8 = 61
            r9 = -1
            if (r0 != r9) goto L_0x0083
            if (r12 == r8) goto L_0x0057
            if (r12 == r7) goto L_0x004d
            if (r12 == r6) goto L_0x0047
            if (r12 == r5) goto L_0x0041
            if (r12 == r4) goto L_0x0047
            switch(r12) {
                case 21: goto L_0x003b;
                case 22: goto L_0x0035;
                case 23: goto L_0x004d;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x0077
        L_0x0035:
            r11.c((int) r2)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x003b:
            r11.c((int) r9)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x0041:
            r11.b((int) r9)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x0047:
            r11.b((int) r2)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x004d:
            int r0 = r11.G
            r11.F = r0
            r11.postInvalidate()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            goto L_0x0077
        L_0x0057:
            boolean r0 = r13.hasNoModifiers()
            if (r0 == 0) goto L_0x0066
            boolean r0 = r11.b((int) r2)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            goto L_0x0077
        L_0x0066:
            boolean r0 = r13.isShiftPressed()
            if (r0 == 0) goto L_0x0075
            boolean r0 = r11.b((int) r9)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            goto L_0x0077
        L_0x0075:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
        L_0x0077:
            if (r3 == 0) goto L_0x007e
            boolean r12 = r3.booleanValue()
            return r12
        L_0x007e:
            boolean r12 = super.onKeyDown(r12, r13)
            return r12
        L_0x0083:
            boolean r0 = r11.L
            boolean r10 = r13.isLongPress()
            r0 = r0 | r10
            r11.L = r0
            boolean r0 = r11.L
            if (r0 == 0) goto L_0x0095
            float r0 = r11.p()
            goto L_0x0099
        L_0x0095:
            float r0 = r11.o()
        L_0x0099:
            r10 = 21
            if (r12 == r10) goto L_0x00bf
            r10 = 22
            if (r12 == r10) goto L_0x00b3
            if (r12 == r5) goto L_0x00ad
            if (r12 == r4) goto L_0x00a8
            if (r12 == r6) goto L_0x00a8
            goto L_0x00cb
        L_0x00a8:
            java.lang.Float r3 = java.lang.Float.valueOf(r0)
            goto L_0x00cb
        L_0x00ad:
            float r0 = -r0
            java.lang.Float r3 = java.lang.Float.valueOf(r0)
            goto L_0x00cb
        L_0x00b3:
            boolean r3 = r11.c()
            if (r3 == 0) goto L_0x00ba
            float r0 = -r0
        L_0x00ba:
            java.lang.Float r3 = java.lang.Float.valueOf(r0)
            goto L_0x00cb
        L_0x00bf:
            boolean r3 = r11.c()
            if (r3 == 0) goto L_0x00c6
            goto L_0x00c7
        L_0x00c6:
            float r0 = -r0
        L_0x00c7:
            java.lang.Float r3 = java.lang.Float.valueOf(r0)
        L_0x00cb:
            if (r3 == 0) goto L_0x00ed
            java.util.ArrayList<java.lang.Float> r12 = r11.E
            int r13 = r11.F
            java.lang.Object r12 = r12.get(r13)
            java.lang.Float r12 = (java.lang.Float) r12
            float r12 = r12.floatValue()
            float r13 = r3.floatValue()
            float r12 = r12 + r13
            boolean r12 = r11.b((float) r12)
            if (r12 == 0) goto L_0x00ec
            r11.i()
            r11.postInvalidate()
        L_0x00ec:
            return r2
        L_0x00ed:
            r0 = 23
            if (r12 == r0) goto L_0x0111
            if (r12 == r8) goto L_0x00fa
            if (r12 == r7) goto L_0x0111
            boolean r12 = super.onKeyDown(r12, r13)
            return r12
        L_0x00fa:
            boolean r12 = r13.hasNoModifiers()
            if (r12 == 0) goto L_0x0105
            boolean r12 = r11.b((int) r2)
            return r12
        L_0x0105:
            boolean r12 = r13.isShiftPressed()
            if (r12 == 0) goto L_0x0110
            boolean r12 = r11.b((int) r9)
            return r12
        L_0x0110:
            return r1
        L_0x0111:
            r11.F = r9
            java.util.List<com.google.android.material.l.a> r12 = r11.m
            java.util.Iterator r12 = r12.iterator()
        L_0x0119:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x012d
            java.lang.Object r13 = r12.next()
            com.google.android.material.l.a r13 = (com.google.android.material.l.a) r13
            com.google.android.material.internal.p r0 = com.google.android.material.internal.q.e(r11)
            r0.b(r13)
            goto L_0x0119
        L_0x012d:
            r11.postInvalidate()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        this.L = false;
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return u.j(this) == 1;
    }

    private boolean b(int i2) {
        int i3 = this.G;
        this.G = (int) androidx.core.c.a.a(((long) i3) + ((long) i2), (long) (this.E.size() - 1));
        int i4 = this.G;
        if (i4 == i3) {
            return false;
        }
        if (this.F != -1) {
            this.F = i4;
        }
        i();
        postInvalidate();
        return true;
    }

    private boolean c(int i2) {
        if (c()) {
            i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
        }
        return b(i2);
    }

    private float o() {
        float f2 = this.H;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    /* access modifiers changed from: private */
    public float p() {
        float o2 = o();
        float f2 = (this.D - this.C) / o2;
        if (f2 <= 20.0f) {
            return o2;
        }
        return ((float) Math.round(f2 / 20.0f)) * o2;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (!z2) {
            this.F = -1;
            for (com.google.android.material.l.a b2 : this.m) {
                q.e(this).b(b2);
            }
            this.f36640i.e(this.G);
            return;
        }
        if (i2 == 1) {
            b(Integer.MAX_VALUE);
        } else if (i2 == 2) {
            b(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            c(Integer.MAX_VALUE);
        } else if (i2 == 66) {
            c(Integer.MIN_VALUE);
        }
        this.f36640i.d(this.G);
    }

    /* access modifiers changed from: package-private */
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f36640i.f3221a;
    }

    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f36640i.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    private void d(int i2) {
        BaseSlider<S, L, T>.defpackage.a aVar = this.k;
        if (aVar == null) {
            this.k = new a(this, (byte) 0);
        } else {
            removeCallbacks(aVar);
        }
        BaseSlider<S, L, T>.defpackage.a aVar2 = this.k;
        aVar2.f36649a = i2;
        postDelayed(aVar2, 200);
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f36649a;

        private a() {
            this.f36649a = -1;
        }

        /* synthetic */ a(BaseSlider baseSlider, byte b2) {
            this();
        }

        public final void run() {
            BaseSlider.this.f36640i.a(this.f36649a, 4);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f36644a = this.C;
        sliderState.f36645b = this.D;
        sliderState.f36646c = new ArrayList<>(this.E);
        sliderState.f36647d = this.H;
        sliderState.f36648e = hasFocus();
        return sliderState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.C = sliderState.f36644a;
        this.D = sliderState.f36645b;
        setValuesInternal(sliderState.f36646c);
        this.H = sliderState.f36647d;
        if (sliderState.f36648e) {
            requestFocus();
        }
        m();
    }

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SliderState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SliderState(parcel, (byte) 0);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        float f36644a;

        /* renamed from: b  reason: collision with root package name */
        float f36645b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<Float> f36646c;

        /* renamed from: d  reason: collision with root package name */
        float f36647d;

        /* renamed from: e  reason: collision with root package name */
        boolean f36648e;

        /* synthetic */ SliderState(Parcel parcel, byte b2) {
            this(parcel);
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.f36644a = parcel.readFloat();
            this.f36645b = parcel.readFloat();
            this.f36646c = new ArrayList<>();
            parcel.readList(this.f36646c, Float.class.getClassLoader());
            this.f36647d = parcel.readFloat();
            this.f36648e = parcel.createBooleanArray()[0];
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.f36644a);
            parcel.writeFloat(this.f36645b);
            parcel.writeList(this.f36646c);
            parcel.writeFloat(this.f36647d);
            parcel.writeBooleanArray(new boolean[]{this.f36648e});
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Rect rect) {
        int a2 = this.t + ((int) (a(getValues().get(i2).floatValue()) * ((float) this.J)));
        int j2 = j();
        int i3 = this.v;
        rect.set(a2 - i3, j2 - i3, a2 + i3, j2 + i3);
    }

    static class b extends androidx.customview.a.a {

        /* renamed from: d  reason: collision with root package name */
        Rect f36651d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        private final BaseSlider<?, ?, ?> f36652e;

        b(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f36652e = baseSlider;
        }

        public final int a(float f2, float f3) {
            for (int i2 = 0; i2 < this.f36652e.getValues().size(); i2++) {
                this.f36652e.a(i2, this.f36651d);
                if (this.f36651d.contains((int) f2, (int) f3)) {
                    return i2;
                }
            }
            return -1;
        }

        public final void a(List<Integer> list) {
            for (int i2 = 0; i2 < this.f36652e.getValues().size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }

        public final void a(int i2, androidx.core.h.a.c cVar) {
            c.d dVar;
            String str;
            cVar.a(c.a.H);
            List<Float> values = this.f36652e.getValues();
            float floatValue = values.get(i2).floatValue();
            float valueFrom = this.f36652e.getValueFrom();
            float valueTo = this.f36652e.getValueTo();
            if (this.f36652e.isEnabled()) {
                if (floatValue > valueFrom) {
                    cVar.a((int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                if (floatValue < valueTo) {
                    cVar.a(4096);
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                dVar = new c.d(AccessibilityNodeInfo.RangeInfo.obtain(1, valueFrom, valueTo, floatValue));
            } else {
                dVar = new c.d((Object) null);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                cVar.f3041a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) dVar.f3055a);
            }
            cVar.b((CharSequence) SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.f36652e.getContentDescription() != null) {
                sb.append(this.f36652e.getContentDescription());
                sb.append(AppConstants.COMMA);
            }
            if (values.size() > 1) {
                if (i2 == this.f36652e.getValues().size() - 1) {
                    str = this.f36652e.getContext().getString(R.string.material_slider_range_end);
                } else {
                    str = i2 == 0 ? this.f36652e.getContext().getString(R.string.material_slider_range_start) : "";
                }
                sb.append(str);
                sb.append(this.f36652e.d(floatValue));
            }
            cVar.e((CharSequence) sb.toString());
            this.f36652e.a(i2, this.f36651d);
            cVar.b(this.f36651d);
        }

        public final boolean b(int i2, int i3, Bundle bundle) {
            if (!this.f36652e.isEnabled()) {
                return false;
            }
            if (i3 == 4096 || i3 == 8192) {
                float c2 = this.f36652e.p();
                if (i3 == 8192) {
                    c2 = -c2;
                }
                if (this.f36652e.c()) {
                    c2 = -c2;
                }
                if (!this.f36652e.a(i2, androidx.core.c.a.a(this.f36652e.getValues().get(i2).floatValue() + c2, this.f36652e.getValueFrom(), this.f36652e.getValueTo()))) {
                    return false;
                }
                this.f36652e.i();
                this.f36652e.postInvalidate();
                a(i2);
                return true;
            }
            if (i3 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                if (this.f36652e.a(i2, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                    this.f36652e.i();
                    this.f36652e.postInvalidate();
                    a(i2);
                    return true;
                }
            }
            return false;
        }
    }
}
