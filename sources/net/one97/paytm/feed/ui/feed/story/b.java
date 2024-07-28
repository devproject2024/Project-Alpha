package net.one97.paytm.feed.ui.feed.story;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import kotlin.g.b.k;

public abstract class b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    private View f35190a;

    public abstract boolean a(MotionEvent motionEvent);

    public b(View view) {
        k.c(view, "mView");
        this.f35190a = view;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        k.c(motionEvent, "e");
        this.f35190a.onTouchEvent(motionEvent);
        return super.onSingleTapConfirmed(motionEvent);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        k.c(motionEvent, "e");
        a(motionEvent);
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        k.c(motionEvent, "e1");
        k.c(motionEvent2, "e2");
        if (motionEvent.getX() >= motionEvent2.getX() && motionEvent.getX() <= motionEvent2.getX()) {
            return a(motionEvent);
        }
        return false;
    }
}
