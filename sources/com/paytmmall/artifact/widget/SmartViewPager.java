package com.paytmmall.artifact.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class SmartViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16027a;

    /* renamed from: b  reason: collision with root package name */
    private GestureDetector f16028b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16029c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16030d;

    public SmartViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16028b = new GestureDetector(context, new a(this, (byte) 0));
        this.f16030d = true;
    }

    public void setPagingEnabled(boolean z) {
        this.f16030d = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f16030d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f16029c) {
            this.f16029c = this.f16028b.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            this.f16029c = false;
            this.f16027a = false;
        } else {
            this.f16027a = true;
        }
        getParent().requestDisallowInterceptTouchEvent(this.f16029c);
        if (this.f16030d) {
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
