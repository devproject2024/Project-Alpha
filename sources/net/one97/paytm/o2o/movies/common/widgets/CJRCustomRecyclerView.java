package net.one97.paytm.o2o.movies.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

public class CJRCustomRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f75212a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f75213b;

    /* renamed from: c  reason: collision with root package name */
    private float f75214c;

    /* renamed from: d  reason: collision with root package name */
    private float f75215d;

    public CJRCustomRecyclerView(Context context) {
        super(context);
        a(context);
    }

    public CJRCustomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CJRCustomRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.f75213b = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOriginalMotionEvent(MotionEvent motionEvent) {
        this.f75214c = motionEvent.getX();
        this.f75215d = motionEvent.getY();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r0 != 2) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            r1 = 0
            r2 = 3
            if (r0 == r2) goto L_0x0042
            r2 = 1
            if (r0 != r2) goto L_0x000c
            goto L_0x0042
        L_0x000c:
            if (r0 == 0) goto L_0x0012
            r3 = 2
            if (r0 == r3) goto L_0x0017
            goto L_0x003d
        L_0x0012:
            r5.f75212a = r1
            r5.setOriginalMotionEvent(r6)
        L_0x0017:
            boolean r0 = r5.f75212a
            if (r0 == 0) goto L_0x001c
            return r1
        L_0x001c:
            float r0 = r5.f75214c
            float r3 = r6.getX()
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            int r0 = (int) r0
            float r3 = r5.f75215d
            float r4 = r6.getY()
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            int r3 = (int) r3
            int r4 = r5.f75213b
            if (r0 <= r4) goto L_0x003d
            if (r0 <= r3) goto L_0x003d
            r5.f75212a = r2
            return r1
        L_0x003d:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        L_0x0042:
            r5.f75212a = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.widgets.CJRCustomRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
