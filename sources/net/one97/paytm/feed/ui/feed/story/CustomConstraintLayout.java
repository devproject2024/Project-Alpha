package net.one97.paytm.feed.ui.feed.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomConstraintLayout extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private GestureDetector f35178a;

    public CustomConstraintLayout(Context context) {
        super(context);
    }

    public CustomConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f35178a;
        if (gestureDetector == null) {
            return false;
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.f35178a = gestureDetector;
    }
}
