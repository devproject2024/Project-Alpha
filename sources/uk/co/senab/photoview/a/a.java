package uk.co.senab.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected e f21286a;

    /* renamed from: b  reason: collision with root package name */
    float f21287b;

    /* renamed from: c  reason: collision with root package name */
    float f21288c;

    /* renamed from: d  reason: collision with root package name */
    final float f21289d;

    /* renamed from: e  reason: collision with root package name */
    final float f21290e;

    /* renamed from: f  reason: collision with root package name */
    private VelocityTracker f21291f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21292g;

    public boolean a() {
        return false;
    }

    public final void a(e eVar) {
        this.f21286a = eVar;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f21290e = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f21289d = (float) viewConfiguration.getScaledTouchSlop();
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
            this.f21291f = VelocityTracker.obtain();
            VelocityTracker velocityTracker2 = this.f21291f;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            this.f21287b = a(motionEvent);
            this.f21288c = b(motionEvent);
            this.f21292g = false;
        } else if (action == 1) {
            if (this.f21292g && this.f21291f != null) {
                this.f21287b = a(motionEvent);
                this.f21288c = b(motionEvent);
                this.f21291f.addMovement(motionEvent);
                this.f21291f.computeCurrentVelocity(1000);
                float xVelocity = this.f21291f.getXVelocity();
                float yVelocity = this.f21291f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f21290e) {
                    this.f21286a.b(-xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker3 = this.f21291f;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f21291f = null;
            }
        } else if (action == 2) {
            float a2 = a(motionEvent);
            float b2 = b(motionEvent);
            float f2 = a2 - this.f21287b;
            float f3 = b2 - this.f21288c;
            if (!this.f21292g) {
                if (Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f21289d)) {
                    z = true;
                }
                this.f21292g = z;
            }
            if (this.f21292g) {
                this.f21286a.a(f2, f3);
                this.f21287b = a2;
                this.f21288c = b2;
                VelocityTracker velocityTracker4 = this.f21291f;
                if (velocityTracker4 != null) {
                    velocityTracker4.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f21291f) != null) {
            velocityTracker.recycle();
            this.f21291f = null;
        }
        return true;
    }
}
