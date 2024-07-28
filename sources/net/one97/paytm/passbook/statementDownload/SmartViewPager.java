package net.one97.paytm.passbook.statementDownload;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class SmartViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    boolean f58606a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f58607b;

    /* renamed from: c  reason: collision with root package name */
    private GestureDetector f58608c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f58609d = false;

    public SmartViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f58608c = new GestureDetector(context, new a(this, (byte) 0));
        this.f58606a = true;
    }

    public void setPagingEnabled(boolean z) {
        this.f58606a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f58606a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f58609d) {
            this.f58609d = this.f58608c.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            this.f58609d = false;
            this.f58607b = false;
        } else {
            this.f58607b = true;
        }
        getParent().requestDisallowInterceptTouchEvent(this.f58609d);
        if (this.f58606a) {
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
