package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class CJRRechargeSmartNoCacheViewPager extends CJRRechargeNoCacheViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f61471a;

    /* renamed from: b  reason: collision with root package name */
    private GestureDetector f61472b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f61473c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f61474d;

    public CJRRechargeSmartNoCacheViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f61472b = new GestureDetector(context, new a(this, (byte) 0));
        this.f61474d = true;
    }

    public void setPagingEnabled(boolean z) {
        this.f61474d = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f61474d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f61473c) {
            this.f61473c = this.f61472b.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            this.f61473c = false;
            this.f61471a = false;
        } else {
            this.f61471a = true;
        }
        getParent().requestDisallowInterceptTouchEvent(this.f61473c);
        if (this.f61474d) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(CJRRechargeSmartNoCacheViewPager cJRRechargeSmartNoCacheViewPager, byte b2) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Math.abs(f2) > Math.abs(f3);
        }
    }
}
