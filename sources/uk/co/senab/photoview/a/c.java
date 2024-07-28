package uk.co.senab.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public final class c extends b {

    /* renamed from: f  reason: collision with root package name */
    protected final ScaleGestureDetector f21295f;

    public c(Context context) {
        super(context);
        this.f21295f = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {
            public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }

            public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                c.this.f21286a.b(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
        });
    }

    public final boolean a() {
        return this.f21295f.isInProgress();
    }

    public final boolean c(MotionEvent motionEvent) {
        this.f21295f.onTouchEvent(motionEvent);
        return super.c(motionEvent);
    }
}
