package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public final class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    ValueAnimator f7453a;

    /* renamed from: b  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f7454b = new ValueAnimator.AnimatorUpdateListener() {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.invalidateSelf();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final Paint f7455c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f7456d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f7457e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private a f7458f;

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public b() {
        this.f7455c.setAntiAlias(true);
    }

    public final void a(a aVar) {
        boolean z;
        this.f7458f = aVar;
        a aVar2 = this.f7458f;
        if (aVar2 != null) {
            this.f7455c.setXfermode(new PorterDuffXfermode(aVar2.q ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        c();
        if (this.f7458f != null) {
            ValueAnimator valueAnimator = this.f7453a;
            if (valueAnimator != null) {
                z = valueAnimator.isStarted();
                this.f7453a.cancel();
                this.f7453a.removeAllUpdateListeners();
            } else {
                z = false;
            }
            this.f7453a = ValueAnimator.ofFloat(new float[]{0.0f, ((float) (this.f7458f.u / this.f7458f.t)) + 1.0f});
            this.f7453a.setRepeatMode(this.f7458f.s);
            this.f7453a.setRepeatCount(this.f7458f.r);
            this.f7453a.setDuration(this.f7458f.t + this.f7458f.u);
            this.f7453a.addUpdateListener(this.f7454b);
            if (z) {
                this.f7453a.start();
            }
        }
        invalidateSelf();
    }

    public final boolean a() {
        ValueAnimator valueAnimator = this.f7453a;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f7456d.set(0, 0, rect.width(), rect.height());
        c();
        b();
    }

    public final void draw(Canvas canvas) {
        float f2;
        float f3;
        if (this.f7458f != null && this.f7455c.getShader() != null) {
            float tan = (float) Math.tan(Math.toRadians((double) this.f7458f.n));
            float height = ((float) this.f7456d.height()) + (((float) this.f7456d.width()) * tan);
            float width = ((float) this.f7456d.width()) + (tan * ((float) this.f7456d.height()));
            ValueAnimator valueAnimator = this.f7453a;
            float f4 = 0.0f;
            float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
            int i2 = this.f7458f.f7446d;
            if (i2 != 1) {
                if (i2 == 2) {
                    f2 = width + (((-width) - width) * animatedFraction);
                } else if (i2 != 3) {
                    float f5 = -width;
                    f2 = f5 + ((width - f5) * animatedFraction);
                } else {
                    f3 = height + (((-height) - height) * animatedFraction);
                }
                this.f7457e.reset();
                this.f7457e.setRotate(this.f7458f.n, ((float) this.f7456d.width()) / 2.0f, ((float) this.f7456d.height()) / 2.0f);
                this.f7457e.postTranslate(f2, f4);
                this.f7455c.getShader().setLocalMatrix(this.f7457e);
                canvas.drawRect(this.f7456d, this.f7455c);
            }
            float f6 = -height;
            f3 = f6 + ((height - f6) * animatedFraction);
            f4 = f3;
            f2 = 0.0f;
            this.f7457e.reset();
            this.f7457e.setRotate(this.f7458f.n, ((float) this.f7456d.width()) / 2.0f, ((float) this.f7456d.height()) / 2.0f);
            this.f7457e.postTranslate(f2, f4);
            this.f7455c.getShader().setLocalMatrix(this.f7457e);
            canvas.drawRect(this.f7456d, this.f7455c);
        }
    }

    public final int getOpacity() {
        a aVar = this.f7458f;
        if (aVar != null) {
            return (aVar.o || this.f7458f.q) ? -3 : -1;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        a aVar;
        ValueAnimator valueAnimator = this.f7453a;
        if (valueAnimator != null && !valueAnimator.isStarted() && (aVar = this.f7458f) != null && aVar.p && getCallback() != null) {
            this.f7453a.start();
        }
    }

    /* JADX WARNING: type inference failed for: r3v8, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r19 = this;
            r0 = r19
            android.graphics.Rect r1 = r19.getBounds()
            int r2 = r1.width()
            int r1 = r1.height()
            if (r2 == 0) goto L_0x0082
            if (r1 == 0) goto L_0x0082
            com.facebook.shimmer.a r3 = r0.f7458f
            if (r3 != 0) goto L_0x0017
            goto L_0x0082
        L_0x0017:
            int r2 = r3.a(r2)
            com.facebook.shimmer.a r3 = r0.f7458f
            int r1 = r3.b(r1)
            com.facebook.shimmer.a r3 = r0.f7458f
            int r3 = r3.f7449g
            r4 = 1
            if (r3 == r4) goto L_0x0054
            com.facebook.shimmer.a r3 = r0.f7458f
            int r3 = r3.f7446d
            r5 = 0
            if (r3 == r4) goto L_0x0038
            com.facebook.shimmer.a r3 = r0.f7458f
            int r3 = r3.f7446d
            r6 = 3
            if (r3 != r6) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r4 = 0
        L_0x0038:
            if (r4 == 0) goto L_0x003b
            r2 = 0
        L_0x003b:
            if (r4 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            android.graphics.LinearGradient r11 = new android.graphics.LinearGradient
            r4 = 0
            r5 = 0
            float r6 = (float) r2
            float r7 = (float) r1
            com.facebook.shimmer.a r1 = r0.f7458f
            int[] r8 = r1.f7444b
            com.facebook.shimmer.a r1 = r0.f7458f
            float[] r9 = r1.f7443a
            android.graphics.Shader$TileMode r10 = android.graphics.Shader.TileMode.CLAMP
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x007d
        L_0x0054:
            android.graphics.RadialGradient r3 = new android.graphics.RadialGradient
            float r4 = (float) r2
            r5 = 1073741824(0x40000000, float:2.0)
            float r13 = r4 / r5
            float r4 = (float) r1
            float r14 = r4 / r5
            int r1 = java.lang.Math.max(r2, r1)
            double r1 = (double) r1
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = java.lang.Math.sqrt(r4)
            double r1 = r1 / r4
            float r15 = (float) r1
            com.facebook.shimmer.a r1 = r0.f7458f
            int[] r1 = r1.f7444b
            com.facebook.shimmer.a r2 = r0.f7458f
            float[] r2 = r2.f7443a
            android.graphics.Shader$TileMode r18 = android.graphics.Shader.TileMode.CLAMP
            r12 = r3
            r16 = r1
            r17 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18)
        L_0x007d:
            android.graphics.Paint r1 = r0.f7455c
            r1.setShader(r3)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.shimmer.b.c():void");
    }
}
