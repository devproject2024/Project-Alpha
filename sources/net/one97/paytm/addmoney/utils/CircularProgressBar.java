package net.one97.paytm.addmoney.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircularProgressBar extends View {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f48903a = new d(this, (byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final RectF f48904b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final ValueAnimator f48905c = new ValueAnimator();

    /* renamed from: d  reason: collision with root package name */
    private final ValueAnimator f48906d = new ValueAnimator();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ValueAnimator f48907e = new ValueAnimator();

    /* renamed from: f  reason: collision with root package name */
    private final Paint f48908f = new Paint(1);

    /* renamed from: g  reason: collision with root package name */
    private final Paint f48909g = new Paint(1);

    /* renamed from: h  reason: collision with root package name */
    private int f48910h;

    /* renamed from: i  reason: collision with root package name */
    private float f48911i;
    private float j;
    private float k;
    /* access modifiers changed from: private */
    public float l;
    /* access modifiers changed from: private */
    public float m;
    /* access modifiers changed from: private */
    public float n;
    /* access modifiers changed from: private */
    public float o;
    private float p;
    private boolean q;
    private boolean r;
    private boolean s;
    /* access modifiers changed from: private */
    public boolean t;
    /* access modifiers changed from: private */
    public boolean u;

    public CircularProgressBar(Context context) {
        super(context);
        a(context, (AttributeSet) null, 0, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    public void setIndeterminate(boolean z) {
        d();
        this.q = z;
        invalidate();
        if (this.u && z) {
            e();
        }
    }

    public float getProgress() {
        return this.j;
    }

    public void setProgress(float f2) {
        if (this.q) {
            this.j = f2;
            return;
        }
        c();
        if (!this.u || !this.r) {
            setProgressInternal(f2);
        } else {
            setProgressAnimated(f2);
        }
    }

    public float getMaximum() {
        return this.f48911i;
    }

    public void setMaximum(float f2) {
        this.f48911i = f2;
        invalidate();
    }

    public void setStartAngle(float f2) {
        a(f2);
        this.k = f2;
        invalidate();
    }

    public void setAnimateProgress(boolean z) {
        this.r = z;
    }

    public void setProgressAnimationDuration(long j2) {
        a(j2);
        if (this.u && this.f48905c.isRunning()) {
            this.f48905c.end();
        }
        this.f48905c.setDuration(j2);
    }

    public void setIndeterminateMinimumAngle(float f2) {
        b(f2);
        d();
        this.o = f2;
        this.f48907e.setFloatValues(new float[]{360.0f - (f2 * 2.0f)});
        invalidate();
        if (this.u && this.q) {
            e();
        }
    }

    public void setIndeterminateRotationAnimationDuration(long j2) {
        a(j2);
        d();
        this.f48906d.setDuration(j2);
        invalidate();
        if (this.u && this.q) {
            e();
        }
    }

    public void setIndeterminateSweepAnimationDuration(long j2) {
        a(j2);
        d();
        this.f48907e.setDuration(j2);
        invalidate();
        if (this.u && this.q) {
            e();
        }
    }

    public void setForegroundStrokeCap(Paint.Cap cap) {
        this.f48908f.setStrokeCap(cap);
        b();
        invalidate();
    }

    public void setForegroundStrokeColor(int i2) {
        this.f48908f.setColor(i2);
        invalidate();
    }

    public void setForegroundStrokeWidth(float f2) {
        c(f2);
        this.f48908f.setStrokeWidth(f2);
        a();
        invalidate();
    }

    public void setBackgroundStrokeColor(int i2) {
        this.f48908f.setColor(i2);
        invalidate();
    }

    public void setBackgroundStrokeWidth(float f2) {
        c(f2);
        this.f48909g.setStrokeWidth(f2);
        a();
        invalidate();
    }

    public void setDrawBackgroundStroke(boolean z) {
        this.s = z;
        a();
        invalidate();
    }

    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        this.u = z;
        if (!this.q) {
            return;
        }
        if (z) {
            e();
        } else {
            d();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        if (this.s) {
            canvas.drawOval(this.f48904b, this.f48909g);
        }
        if (this.q) {
            float f4 = this.l;
            float f5 = this.m;
            float f6 = this.n;
            float f7 = this.o;
            if (this.t) {
                f3 = f4 - f6;
                f2 = f5 + f7;
            } else {
                f3 = (f4 + f5) - f6;
                f2 = (360.0f - f5) - f7;
            }
        } else {
            float f8 = this.f48911i;
            float f9 = this.j;
            float f10 = this.k;
            if (Math.abs(f9) < Math.abs(f8)) {
                f2 = (f9 / f8) * 360.0f;
                f3 = f10;
            } else {
                f3 = f10;
                f2 = 360.0f;
            }
        }
        float f11 = this.p;
        if (!(f11 == 0.0f || Math.abs(f2) == 360.0f)) {
            if (f2 > 0.0f) {
                f3 += f11;
                f2 -= f11 * 2.0f;
            } else if (f2 < 0.0f) {
                f3 -= f11;
                f2 += f11 * 2.0f;
            }
        }
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f48904b, f3, f2, false, this.f48908f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = this.f48910h;
        int max = Math.max(getSuggestedMinimumWidth(), i4);
        int max2 = Math.max(getSuggestedMinimumHeight(), i4);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(max, size);
        } else if (mode != 1073741824) {
            size = max;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(max2, size2);
        } else if (mode2 != 1073741824) {
            size2 = max2;
        }
        setMeasuredDimension(size, size2);
        a(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        a(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.u = true;
        if (this.q) {
            e();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.u = false;
        d();
        c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x01db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r17, android.util.AttributeSet r18, int r19, int r20) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            android.graphics.Paint r2 = r1.f48908f
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r2.setStyle(r3)
            android.graphics.Paint r2 = r1.f48909g
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r2.setStyle(r3)
            android.content.res.Resources r2 = r17.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r3 = r2.density
            r4 = 1111490560(0x42400000, float:48.0)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            r1.f48910h = r3
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r5 = 1077936128(0x40400000, float:3.0)
            r6 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r7 = 1114636288(0x42700000, float:60.0)
            r8 = 1132920832(0x43870000, float:270.0)
            r9 = 0
            r10 = 1120403456(0x42c80000, float:100.0)
            r11 = 1
            r12 = 0
            if (r0 != 0) goto L_0x008e
            r1.f48911i = r10
            r1.j = r9
            r1.k = r8
            r1.o = r7
            android.animation.ValueAnimator r0 = r1.f48905c
            r7 = 100
            r0.setDuration(r7)
            r1.q = r12
            r1.r = r11
            r1.s = r12
            android.graphics.Paint r0 = r1.f48908f
            r0.setColor(r6)
            android.graphics.Paint r0 = r1.f48908f
            float r6 = r2.density
            float r6 = r6 * r5
            int r5 = java.lang.Math.round(r6)
            float r5 = (float) r5
            r0.setStrokeWidth(r5)
            android.graphics.Paint r0 = r1.f48908f
            android.graphics.Paint$Cap r5 = a((int) r12)
            r0.setStrokeCap(r5)
            android.graphics.Paint r0 = r1.f48909g
            r0.setColor(r4)
            android.graphics.Paint r0 = r1.f48909g
            float r2 = r2.density
            float r2 = r2 * r3
            int r2 = java.lang.Math.round(r2)
            float r2 = (float) r2
            r0.setStrokeWidth(r2)
            android.animation.ValueAnimator r0 = r1.f48906d
            r2 = 1200(0x4b0, double:5.93E-321)
            r0.setDuration(r2)
            android.animation.ValueAnimator r0 = r1.f48907e
            r2 = 600(0x258, double:2.964E-321)
            r0.setDuration(r2)
            goto L_0x0166
        L_0x008e:
            android.content.res.Resources$Theme r14 = r17.getTheme()     // Catch:{ all -> 0x01d7 }
            int[] r15 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar     // Catch:{ all -> 0x01d7 }
            r13 = r19
            r11 = r20
            android.content.res.TypedArray r13 = r14.obtainStyledAttributes(r0, r15, r13, r11)     // Catch:{ all -> 0x01d7 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_maximum     // Catch:{ all -> 0x01d5 }
            float r0 = r13.getFloat(r0, r10)     // Catch:{ all -> 0x01d5 }
            r1.f48911i = r0     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_progress     // Catch:{ all -> 0x01d5 }
            float r0 = r13.getFloat(r0, r9)     // Catch:{ all -> 0x01d5 }
            r1.j = r0     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_startAngle     // Catch:{ all -> 0x01d5 }
            float r0 = r13.getFloat(r0, r8)     // Catch:{ all -> 0x01d5 }
            a((float) r0)     // Catch:{ all -> 0x01d5 }
            r1.k = r0     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_indeterminateMinimumAngle     // Catch:{ all -> 0x01d5 }
            float r0 = r13.getFloat(r0, r7)     // Catch:{ all -> 0x01d5 }
            b((float) r0)     // Catch:{ all -> 0x01d5 }
            r1.o = r0     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_progressAnimationDuration     // Catch:{ all -> 0x01d5 }
            r7 = 100
            int r0 = r13.getInteger(r0, r7)     // Catch:{ all -> 0x01d5 }
            long r7 = (long) r0     // Catch:{ all -> 0x01d5 }
            a((long) r7)     // Catch:{ all -> 0x01d5 }
            android.animation.ValueAnimator r0 = r1.f48905c     // Catch:{ all -> 0x01d5 }
            r0.setDuration(r7)     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_indeterminateRotationAnimationDuration     // Catch:{ all -> 0x01d5 }
            r7 = 1200(0x4b0, float:1.682E-42)
            int r0 = r13.getInteger(r0, r7)     // Catch:{ all -> 0x01d5 }
            long r7 = (long) r0     // Catch:{ all -> 0x01d5 }
            a((long) r7)     // Catch:{ all -> 0x01d5 }
            android.animation.ValueAnimator r0 = r1.f48906d     // Catch:{ all -> 0x01d5 }
            r0.setDuration(r7)     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_indeterminateSweepAnimationDuration     // Catch:{ all -> 0x01d5 }
            r7 = 600(0x258, float:8.41E-43)
            int r0 = r13.getInteger(r0, r7)     // Catch:{ all -> 0x01d5 }
            long r7 = (long) r0     // Catch:{ all -> 0x01d5 }
            a((long) r7)     // Catch:{ all -> 0x01d5 }
            android.animation.ValueAnimator r0 = r1.f48907e     // Catch:{ all -> 0x01d5 }
            r0.setDuration(r7)     // Catch:{ all -> 0x01d5 }
            android.graphics.Paint r0 = r1.f48908f     // Catch:{ all -> 0x01d5 }
            int r7 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_foregroundStrokeColor     // Catch:{ all -> 0x01d5 }
            int r6 = r13.getColor(r7, r6)     // Catch:{ all -> 0x01d5 }
            r0.setColor(r6)     // Catch:{ all -> 0x01d5 }
            android.graphics.Paint r0 = r1.f48909g     // Catch:{ all -> 0x01d5 }
            int r6 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_backgroundStrokeColor     // Catch:{ all -> 0x01d5 }
            int r4 = r13.getColor(r6, r4)     // Catch:{ all -> 0x01d5 }
            r0.setColor(r4)     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_foregroundStrokeWidth     // Catch:{ all -> 0x01d5 }
            float r4 = r2.density     // Catch:{ all -> 0x01d5 }
            float r4 = r4 * r5
            int r4 = java.lang.Math.round(r4)     // Catch:{ all -> 0x01d5 }
            float r4 = (float) r4     // Catch:{ all -> 0x01d5 }
            float r0 = r13.getDimension(r0, r4)     // Catch:{ all -> 0x01d5 }
            c((float) r0)     // Catch:{ all -> 0x01d5 }
            android.graphics.Paint r4 = r1.f48908f     // Catch:{ all -> 0x01d5 }
            r4.setStrokeWidth(r0)     // Catch:{ all -> 0x01d5 }
            android.graphics.Paint r0 = r1.f48908f     // Catch:{ all -> 0x01d5 }
            int r4 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_foregroundStrokeCap     // Catch:{ all -> 0x01d5 }
            int r4 = r13.getInt(r4, r12)     // Catch:{ all -> 0x01d5 }
            android.graphics.Paint$Cap r4 = a((int) r4)     // Catch:{ all -> 0x01d5 }
            r0.setStrokeCap(r4)     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_backgroundStrokeWidth     // Catch:{ all -> 0x01d5 }
            float r2 = r2.density     // Catch:{ all -> 0x01d5 }
            float r2 = r2 * r3
            int r2 = java.lang.Math.round(r2)     // Catch:{ all -> 0x01d5 }
            float r2 = (float) r2     // Catch:{ all -> 0x01d5 }
            float r0 = r13.getDimension(r0, r2)     // Catch:{ all -> 0x01d5 }
            c((float) r0)     // Catch:{ all -> 0x01d5 }
            android.graphics.Paint r2 = r1.f48909g     // Catch:{ all -> 0x01d5 }
            r2.setStrokeWidth(r0)     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_animateProgress     // Catch:{ all -> 0x01d5 }
            r2 = 1
            boolean r0 = r13.getBoolean(r0, r2)     // Catch:{ all -> 0x01d5 }
            r1.r = r0     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_drawBackgroundStroke     // Catch:{ all -> 0x01d5 }
            boolean r0 = r13.getBoolean(r0, r12)     // Catch:{ all -> 0x01d5 }
            r1.s = r0     // Catch:{ all -> 0x01d5 }
            int r0 = net.one97.paytm.addmoney.R.styleable.CircularProgressBar_indeterminate     // Catch:{ all -> 0x01d5 }
            boolean r0 = r13.getBoolean(r0, r12)     // Catch:{ all -> 0x01d5 }
            r1.q = r0     // Catch:{ all -> 0x01d5 }
            if (r13 == 0) goto L_0x0166
            r13.recycle()
        L_0x0166:
            android.animation.ValueAnimator r0 = r1.f48905c
            android.view.animation.DecelerateInterpolator r2 = new android.view.animation.DecelerateInterpolator
            r2.<init>()
            r0.setInterpolator(r2)
            android.animation.ValueAnimator r0 = r1.f48905c
            net.one97.paytm.addmoney.utils.CircularProgressBar$a r2 = new net.one97.paytm.addmoney.utils.CircularProgressBar$a
            r2.<init>(r1, r12)
            r0.addUpdateListener(r2)
            android.animation.ValueAnimator r0 = r1.f48906d
            r2 = 1
            float[] r3 = new float[r2]
            r4 = 1135869952(0x43b40000, float:360.0)
            r3[r12] = r4
            r0.setFloatValues(r3)
            android.animation.ValueAnimator r0 = r1.f48906d
            r0.setRepeatMode(r2)
            android.animation.ValueAnimator r0 = r1.f48906d
            r2 = -1
            r0.setRepeatCount(r2)
            android.animation.ValueAnimator r0 = r1.f48906d
            android.view.animation.LinearInterpolator r2 = new android.view.animation.LinearInterpolator
            r2.<init>()
            r0.setInterpolator(r2)
            android.animation.ValueAnimator r0 = r1.f48906d
            net.one97.paytm.addmoney.utils.CircularProgressBar$b r2 = new net.one97.paytm.addmoney.utils.CircularProgressBar$b
            r2.<init>(r1, r12)
            r0.addUpdateListener(r2)
            android.animation.ValueAnimator r0 = r1.f48907e
            r2 = 1
            float[] r2 = new float[r2]
            float r3 = r1.o
            r5 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 * r5
            float r4 = r4 - r3
            r2[r12] = r4
            r0.setFloatValues(r2)
            android.animation.ValueAnimator r0 = r1.f48907e
            android.view.animation.DecelerateInterpolator r2 = new android.view.animation.DecelerateInterpolator
            r2.<init>()
            r0.setInterpolator(r2)
            android.animation.ValueAnimator r0 = r1.f48907e
            net.one97.paytm.addmoney.utils.CircularProgressBar$e r2 = new net.one97.paytm.addmoney.utils.CircularProgressBar$e
            r2.<init>(r1, r12)
            r0.addUpdateListener(r2)
            android.animation.ValueAnimator r0 = r1.f48907e
            net.one97.paytm.addmoney.utils.CircularProgressBar$c r2 = new net.one97.paytm.addmoney.utils.CircularProgressBar$c
            r2.<init>(r1, r12)
            r0.addListener(r2)
            return
        L_0x01d5:
            r0 = move-exception
            goto L_0x01d9
        L_0x01d7:
            r0 = move-exception
            r13 = 0
        L_0x01d9:
            if (r13 == 0) goto L_0x01de
            r13.recycle()
        L_0x01de:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.utils.CircularProgressBar.a(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    private void a() {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            a(width, height);
        }
    }

    private void a(int i2, int i3) {
        float f2;
        if (this.s) {
            f2 = Math.max(this.f48908f.getStrokeWidth(), this.f48909g.getStrokeWidth());
        } else {
            f2 = this.f48908f.getStrokeWidth();
        }
        if (i2 > i3) {
            float f3 = ((float) (i2 - i3)) / 2.0f;
            float f4 = f2 / 2.0f;
            this.f48904b.set(f3 + f4 + 1.0f, f4 + 1.0f, ((((float) i2) - f3) - f4) - 1.0f, (((float) i3) - f4) - 1.0f);
        } else if (i2 < i3) {
            float f5 = ((float) (i3 - i2)) / 2.0f;
            float f6 = f2 / 2.0f;
            this.f48904b.set(f6 + 1.0f, f5 + f6 + 1.0f, (((float) i2) - f6) - 1.0f, ((((float) i3) - f5) - f6) - 1.0f);
        } else {
            float f7 = f2 / 2.0f;
            float f8 = f7 + 1.0f;
            this.f48904b.set(f8, f8, (((float) i2) - f7) - 1.0f, (((float) i3) - f7) - 1.0f);
        }
        b();
    }

    private void b() {
        Paint.Cap strokeCap = this.f48908f.getStrokeCap();
        if (strokeCap == null) {
            this.p = 0.0f;
            return;
        }
        int i2 = AnonymousClass1.f48912a[strokeCap.ordinal()];
        if (i2 == 1 || i2 == 2) {
            float width = this.f48904b.width() / 2.0f;
            if (width != 0.0f) {
                this.p = ((this.f48908f.getStrokeWidth() * 90.0f) / 3.1415927f) / width;
            } else {
                this.p = 0.0f;
            }
        } else {
            this.p = 0.0f;
        }
    }

    /* renamed from: net.one97.paytm.addmoney.utils.CircularProgressBar$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f48912a = new int[Paint.Cap.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                android.graphics.Paint$Cap[] r0 = android.graphics.Paint.Cap.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f48912a = r0
                int[] r0 = f48912a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.graphics.Paint$Cap r1 = android.graphics.Paint.Cap.SQUARE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f48912a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.graphics.Paint$Cap r1 = android.graphics.Paint.Cap.ROUND     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f48912a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.graphics.Paint$Cap r1 = android.graphics.Paint.Cap.BUTT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.utils.CircularProgressBar.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void setProgressInternal(float f2) {
        this.j = f2;
        invalidate();
    }

    private void setProgressAnimated(float f2) {
        this.f48905c.setFloatValues(new float[]{this.j, f2});
        this.f48905c.start();
    }

    private void c() {
        if (this.f48905c.isRunning()) {
            this.f48905c.cancel();
        }
    }

    private void d() {
        if (this.f48906d.isRunning()) {
            this.f48906d.cancel();
        }
        if (this.f48907e.isRunning()) {
            this.f48907e.cancel();
        }
    }

    private void e() {
        if (!this.f48906d.isRunning()) {
            this.f48906d.start();
        }
        if (!this.f48907e.isRunning()) {
            this.f48907e.start();
        }
    }

    private static void a(float f2) {
        if (f2 < -360.0f || f2 > 360.0f) {
            throw new IllegalArgumentException("Start angle value should be between -360 and 360 degrees (inclusive)");
        }
    }

    private static void b(float f2) {
        if (f2 < 0.0f || f2 > 180.0f) {
            throw new IllegalArgumentException("Indeterminate minimum angle value should be between 0 and 180 degrees (inclusive)");
        }
    }

    private static void a(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("Animation duration can't be negative");
        }
    }

    private static void c(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Width can't be negative");
        }
    }

    private static Paint.Cap a(int i2) {
        if (i2 == 1) {
            return Paint.Cap.ROUND;
        }
        if (i2 != 2) {
            return Paint.Cap.BUTT;
        }
        return Paint.Cap.SQUARE;
    }

    final class a implements ValueAnimator.AnimatorUpdateListener {
        private a() {
        }

        /* synthetic */ a(CircularProgressBar circularProgressBar, byte b2) {
            this();
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircularProgressBar.this.setProgressInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    final class b implements ValueAnimator.AnimatorUpdateListener {
        private b() {
        }

        /* synthetic */ b(CircularProgressBar circularProgressBar, byte b2) {
            this();
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = CircularProgressBar.this.l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircularProgressBar.this.invalidate();
        }
    }

    final class e implements ValueAnimator.AnimatorUpdateListener {
        private e() {
        }

        /* synthetic */ e(CircularProgressBar circularProgressBar, byte b2) {
            this();
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = CircularProgressBar.this.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    final class c implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f48916b;

        public final void onAnimationRepeat(Animator animator) {
        }

        private c() {
        }

        /* synthetic */ c(CircularProgressBar circularProgressBar, byte b2) {
            this();
        }

        public final void onAnimationStart(Animator animator) {
            this.f48916b = false;
        }

        public final void onAnimationEnd(Animator animator) {
            if (!this.f48916b) {
                CircularProgressBar circularProgressBar = CircularProgressBar.this;
                circularProgressBar.post(circularProgressBar.f48903a);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.f48916b = true;
        }
    }

    final class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(CircularProgressBar circularProgressBar, byte b2) {
            this();
        }

        public final void run() {
            CircularProgressBar circularProgressBar = CircularProgressBar.this;
            boolean unused = circularProgressBar.t = !circularProgressBar.t;
            if (CircularProgressBar.this.t) {
                CircularProgressBar circularProgressBar2 = CircularProgressBar.this;
                float unused2 = circularProgressBar2.n = (circularProgressBar2.n + (CircularProgressBar.this.o * 2.0f)) % 360.0f;
            }
            if (CircularProgressBar.this.f48907e.isRunning()) {
                CircularProgressBar.this.f48907e.cancel();
            }
            if (CircularProgressBar.this.u) {
                CircularProgressBar.this.f48907e.start();
            }
        }
    }
}
