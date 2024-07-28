package net.one97.paytm.paymentsBank.utils.photocrop.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    final float f19545a;

    /* renamed from: b  reason: collision with root package name */
    final float f19546b;

    /* renamed from: c  reason: collision with root package name */
    protected e f19547c;

    /* renamed from: d  reason: collision with root package name */
    float f19548d;

    /* renamed from: e  reason: collision with root package name */
    float f19549e;

    /* renamed from: f  reason: collision with root package name */
    private VelocityTracker f19550f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19551g;

    public boolean a() {
        return false;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f19546b = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f19545a = (float) viewConfiguration.getScaledTouchSlop();
    }

    public final void a(e eVar) {
        this.f19547c = eVar;
    }

    /* access modifiers changed from: package-private */
    public float a(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    /* access modifiers changed from: package-private */
    public float b(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    public boolean c(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.f19550f = VelocityTracker.obtain();
            VelocityTracker velocityTracker2 = this.f19550f;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            this.f19548d = a(motionEvent);
            this.f19549e = b(motionEvent);
            this.f19551g = false;
        } else if (action == 1) {
            if (this.f19551g && this.f19550f != null) {
                this.f19548d = a(motionEvent);
                this.f19549e = b(motionEvent);
                this.f19550f.addMovement(motionEvent);
                this.f19550f.computeCurrentVelocity(1000);
                if (Math.max(Math.abs(this.f19550f.getXVelocity()), Math.abs(this.f19550f.getYVelocity())) >= this.f19546b) {
                    this.f19547c.e();
                }
            }
            VelocityTracker velocityTracker3 = this.f19550f;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f19550f = null;
            }
        } else if (action == 2) {
            float a2 = a(motionEvent);
            float b2 = b(motionEvent);
            float f2 = a2 - this.f19548d;
            float f3 = b2 - this.f19549e;
            if (!this.f19551g) {
                if (Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f19545a)) {
                    z = true;
                }
                this.f19551g = z;
            }
            if (this.f19551g) {
                this.f19547c.a(f2, f3);
                this.f19548d = a2;
                this.f19549e = b2;
                VelocityTracker velocityTracker4 = this.f19550f;
                if (velocityTracker4 != null) {
                    velocityTracker4.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f19550f) != null) {
            velocityTracker.recycle();
            this.f19550f = null;
        }
        return true;
    }
}
