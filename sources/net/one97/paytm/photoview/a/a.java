package net.one97.paytm.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected e f59663a;

    /* renamed from: b  reason: collision with root package name */
    float f59664b;

    /* renamed from: c  reason: collision with root package name */
    float f59665c;

    /* renamed from: d  reason: collision with root package name */
    final float f59666d;

    /* renamed from: e  reason: collision with root package name */
    final float f59667e;

    /* renamed from: f  reason: collision with root package name */
    private VelocityTracker f59668f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f59669g;

    public boolean a() {
        return false;
    }

    public final void a(e eVar) {
        this.f59663a = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f59667e = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f59666d = (float) viewConfiguration.getScaledTouchSlop();
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
            this.f59668f = VelocityTracker.obtain();
            VelocityTracker velocityTracker2 = this.f59668f;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            this.f59664b = a(motionEvent);
            this.f59665c = b(motionEvent);
            this.f59669g = false;
        } else if (action == 1) {
            if (this.f59669g && this.f59668f != null) {
                this.f59664b = a(motionEvent);
                this.f59665c = b(motionEvent);
                this.f59668f.addMovement(motionEvent);
                this.f59668f.computeCurrentVelocity(1000);
                float xVelocity = this.f59668f.getXVelocity();
                float yVelocity = this.f59668f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f59667e) {
                    this.f59663a.b(-xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker3 = this.f59668f;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f59668f = null;
            }
        } else if (action == 2) {
            float a2 = a(motionEvent);
            float b2 = b(motionEvent);
            float f2 = a2 - this.f59664b;
            float f3 = b2 - this.f59665c;
            if (!this.f59669g) {
                if (Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f59666d)) {
                    z = true;
                }
                this.f59669g = z;
            }
            if (this.f59669g) {
                this.f59663a.a(f2, f3);
                this.f59664b = a2;
                this.f59665c = b2;
                VelocityTracker velocityTracker4 = this.f59668f;
                if (velocityTracker4 != null) {
                    velocityTracker4.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f59668f) != null) {
            velocityTracker.recycle();
            this.f59668f = null;
        }
        return true;
    }
}
