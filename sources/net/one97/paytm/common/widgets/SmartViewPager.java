package net.one97.paytm.common.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.q;

public class SmartViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49875a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f49876b;

    /* renamed from: c  reason: collision with root package name */
    private GestureDetector f49877c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49878d = false;

    public SmartViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49877c = new GestureDetector(context, new a(this, (byte) 0), new Handler(Looper.getMainLooper()));
        this.f49875a = true;
    }

    public void setPagingEnabled(boolean z) {
        this.f49875a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.f49875a) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        } catch (IllegalArgumentException e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f49878d) {
            this.f49878d = this.f49877c.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            this.f49878d = false;
            this.f49876b = false;
        } else {
            this.f49876b = true;
        }
        getParent().requestDisallowInterceptTouchEvent(this.f49878d);
        if (this.f49875a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(SmartViewPager smartViewPager, byte b2) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Math.abs(f2) > Math.abs(f3);
        }
    }
}
