package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.viewpager.widget.ViewPager;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

public class PreviewViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f45878a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f45879b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45880c;

    public PreviewViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f45878a = displayMetrics.heightPixels;
    }

    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        if (view instanceof ImageViewTouch) {
            return ((ImageViewTouch) view).a(i2) || super.canScroll(view, z, i2, i3, i4);
        }
        return super.canScroll(view, z, i2, i3, i4);
    }

    public void onMeasure(int i2, int i3) {
        if (this.f45879b) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.f45878a, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    private static MotionEvent a(MotionEvent motionEvent) {
        motionEvent.setLocation(motionEvent.getY(), motionEvent.getX());
        return motionEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f45880c) {
            return super.onInterceptTouchEvent(a(motionEvent));
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f45880c) {
            return super.onTouchEvent(a(motionEvent));
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setLockHeight(boolean z) {
        this.f45879b = z;
    }

    public void setVertical(boolean z) {
        this.f45880c = z;
        int i2 = 1;
        setPageTransformer(true, this.f45880c ? new a((byte) 0) : null);
        if (this.f45880c) {
            i2 = 2;
        }
        setOverScrollMode(i2);
    }

    static class a implements ViewPager.f {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void transformPage(View view, float f2) {
            if (f2 >= -1.0f && f2 <= 1.0f) {
                view.setTranslationX(((float) view.getWidth()) * (-f2));
                view.setTranslationY(f2 * ((float) view.getHeight()));
            }
        }
    }
}
