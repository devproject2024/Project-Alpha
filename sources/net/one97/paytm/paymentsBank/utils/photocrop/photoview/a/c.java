package net.one97.paytm.paymentsBank.utils.photocrop.photoview.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public final class c extends b {

    /* renamed from: f  reason: collision with root package name */
    protected final ScaleGestureDetector f19554f;

    public c(Context context) {
        super(context);
        this.f19554f = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {
            public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }

            public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                c.this.f19547c.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
        });
    }

    public final boolean a() {
        return this.f19554f.isInProgress();
    }

    public final boolean c(MotionEvent motionEvent) {
        this.f19554f.onTouchEvent(motionEvent);
        return super.c(motionEvent);
    }
}
