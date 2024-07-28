package net.one97.paytm.photoview.a;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class b extends a {

    /* renamed from: f  reason: collision with root package name */
    private int f59670f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f59671g = 0;

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public final float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f59671g);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* access modifiers changed from: package-private */
    public final float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f59671g);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action != 0) {
            int i2 = 1;
            if (action == 1 || action == 3) {
                this.f59670f = -1;
            } else if (action == 6) {
                int action2 = motionEvent.getAction();
                int i3 = Build.VERSION.SDK_INT;
                int i4 = (action2 & PriceRangeSeekBar.ACTION_POINTER_INDEX_MASK) >> 8;
                if (motionEvent.getPointerId(i4) == this.f59670f) {
                    if (i4 != 0) {
                        i2 = 0;
                    }
                    this.f59670f = motionEvent.getPointerId(i2);
                    this.f59664b = motionEvent.getX(i2);
                    this.f59665c = motionEvent.getY(i2);
                }
            }
        } else {
            this.f59670f = motionEvent.getPointerId(0);
        }
        int i5 = this.f59670f;
        if (i5 == -1) {
            i5 = 0;
        }
        this.f59671g = motionEvent.findPointerIndex(i5);
        return super.c(motionEvent);
    }
}
