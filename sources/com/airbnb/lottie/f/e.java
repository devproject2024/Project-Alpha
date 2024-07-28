package com.airbnb.lottie.f;

import android.animation.Animator;
import android.os.Build;
import android.view.Choreographer;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;

public final class e extends a implements Choreographer.FrameCallback {

    /* renamed from: b  reason: collision with root package name */
    public float f6111b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f6112c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f6113d = -2.14748365E9f;

    /* renamed from: e  reason: collision with root package name */
    public float f6114e = 2.14748365E9f;

    /* renamed from: f  reason: collision with root package name */
    public d f6115f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f6116g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6117h = false;

    /* renamed from: i  reason: collision with root package name */
    private long f6118i = 0;
    private int j = 0;

    public final Object getAnimatedValue() {
        return Float.valueOf(b());
    }

    public final float b() {
        d dVar = this.f6115f;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f6112c - dVar.j) / (this.f6115f.k - this.f6115f.j);
    }

    public final float getAnimatedFraction() {
        float h2;
        float i2;
        float h3;
        if (this.f6115f == null) {
            return 0.0f;
        }
        if (j()) {
            h2 = i() - this.f6112c;
            i2 = i();
            h3 = h();
        } else {
            h2 = this.f6112c - h();
            i2 = i();
            h3 = h();
        }
        return h2 / (i2 - h3);
    }

    public final long getDuration() {
        d dVar = this.f6115f;
        if (dVar == null) {
            return 0;
        }
        return (long) dVar.a();
    }

    public final boolean isRunning() {
        return this.f6116g;
    }

    public final void doFrame(long j2) {
        float f2;
        k();
        if (this.f6115f != null && isRunning()) {
            c.a("LottieValueAnimator#doFrame");
            long j3 = this.f6118i;
            long j4 = 0;
            if (j3 != 0) {
                j4 = j2 - j3;
            }
            d dVar = this.f6115f;
            if (dVar == null) {
                f2 = Float.MAX_VALUE;
            } else {
                f2 = (1.0E9f / dVar.l) / Math.abs(this.f6111b);
            }
            float f3 = ((float) j4) / f2;
            float f4 = this.f6112c;
            if (j()) {
                f3 = -f3;
            }
            this.f6112c = f4 + f3;
            boolean z = !g.c(this.f6112c, h(), i());
            this.f6112c = g.b(this.f6112c, h(), i());
            this.f6118i = j2;
            a();
            if (z) {
                if (getRepeatCount() == -1 || this.j < getRepeatCount()) {
                    for (Animator.AnimatorListener onAnimationRepeat : this.f6107a) {
                        onAnimationRepeat.onAnimationRepeat(this);
                    }
                    this.j++;
                    if (getRepeatMode() == 2) {
                        this.f6117h = !this.f6117h;
                        d();
                    } else {
                        this.f6112c = j() ? i() : h();
                    }
                    this.f6118i = j2;
                } else {
                    this.f6112c = this.f6111b < 0.0f ? h() : i();
                    b(true);
                    a(j());
                }
            }
            if (this.f6115f != null) {
                float f5 = this.f6112c;
                if (f5 < this.f6113d || f5 > this.f6114e) {
                    throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f6113d), Float.valueOf(this.f6114e), Float.valueOf(this.f6112c)}));
                }
            }
            c.b("LottieValueAnimator#doFrame");
        }
    }

    public final void c() {
        this.f6115f = null;
        this.f6113d = -2.14748365E9f;
        this.f6114e = 2.14748365E9f;
    }

    public final void a(float f2) {
        if (this.f6112c != f2) {
            this.f6112c = g.b(f2, h(), i());
            this.f6118i = 0;
            a();
        }
    }

    public final void a(int i2) {
        a((float) i2, (float) ((int) this.f6114e));
    }

    public final void b(float f2) {
        a(this.f6113d, f2);
    }

    public final void a(float f2, float f3) {
        if (f2 <= f3) {
            d dVar = this.f6115f;
            float f4 = dVar == null ? -3.4028235E38f : dVar.j;
            d dVar2 = this.f6115f;
            float f5 = dVar2 == null ? Float.MAX_VALUE : dVar2.k;
            this.f6113d = g.b(f2, f4, f5);
            this.f6114e = g.b(f3, f4, f5);
            a((float) ((int) g.b(this.f6112c, f2, f3)));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f2), Float.valueOf(f3)}));
    }

    public final void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 != 2 && this.f6117h) {
            this.f6117h = false;
            d();
        }
    }

    public final void e() {
        this.f6116g = true;
        boolean j2 = j();
        for (Animator.AnimatorListener next : this.f6107a) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationStart(this, j2);
            } else {
                next.onAnimationStart(this);
            }
        }
        a((float) ((int) (j() ? i() : h())));
        this.f6118i = 0;
        this.j = 0;
        k();
    }

    public final void g() {
        this.f6116g = true;
        k();
        this.f6118i = 0;
        if (j() && this.f6112c == h()) {
            this.f6112c = i();
        } else if (!j() && this.f6112c == i()) {
            this.f6112c = h();
        }
    }

    public final float h() {
        d dVar = this.f6115f;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f6113d;
        return f2 == -2.14748365E9f ? dVar.j : f2;
    }

    public final float i() {
        d dVar = this.f6115f;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f6114e;
        return f2 == 2.14748365E9f ? dVar.k : f2;
    }

    private void k() {
        if (isRunning()) {
            b(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public final void b(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f6116g = false;
        }
    }

    public final void d() {
        this.f6111b = -this.f6111b;
    }

    public final void f() {
        b(true);
        a(j());
    }

    public final void cancel() {
        for (Animator.AnimatorListener onAnimationCancel : this.f6107a) {
            onAnimationCancel.onAnimationCancel(this);
        }
        b(true);
    }

    private boolean j() {
        return this.f6111b < 0.0f;
    }
}
