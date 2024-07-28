package net.one97.paytm.paymentsBank.utils.photocrop.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;

public final class b implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a  reason: collision with root package name */
    private d f19556a;

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public b(d dVar) {
        this.f19556a = dVar;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF b2;
        d dVar = this.f19556a;
        if (dVar == null) {
            return false;
        }
        dVar.c();
        if (this.f19556a.k == null || (b2 = this.f19556a.b()) == null || !b2.contains(motionEvent.getX(), motionEvent.getY())) {
            if (this.f19556a.l != null) {
                motionEvent.getX();
                motionEvent.getY();
            }
            return false;
        }
        float f2 = b2.left;
        b2.width();
        float f3 = b2.top;
        b2.height();
        return true;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        d dVar = this.f19556a;
        if (dVar == null) {
            return false;
        }
        try {
            float d2 = dVar.d();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (d2 < this.f19556a.f19565f) {
                this.f19556a.a(this.f19556a.f19565f, x, y, true);
            } else if (d2 < this.f19556a.f19565f || d2 >= this.f19556a.f19566g) {
                this.f19556a.a(this.f19556a.f19564e, x, y, true);
            } else {
                this.f19556a.a(this.f19556a.f19566g, x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }
}
