package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

public class CJRCustomRecyclerView extends RecyclerView {
    private boolean mChildIsScrolling = false;
    private float mOriginalX;
    private float mOriginalY;
    private int mTouchSlop;

    public CJRCustomRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public CJRCustomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CJRCustomRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOriginalMotionEvent(MotionEvent motionEvent) {
        this.mOriginalX = motionEvent.getX();
        this.mOriginalY = motionEvent.getY();
    }

    public int calculateDistanceX(MotionEvent motionEvent) {
        return (int) Math.abs(this.mOriginalX - motionEvent.getX());
    }

    public int calculateDistanceY(MotionEvent motionEvent) {
        return (int) Math.abs(this.mOriginalY - motionEvent.getY());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r0 != 2) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            r1 = 0
            r2 = 3
            if (r0 == r2) goto L_0x0032
            r2 = 1
            if (r0 != r2) goto L_0x000c
            goto L_0x0032
        L_0x000c:
            if (r0 == 0) goto L_0x0012
            r3 = 2
            if (r0 == r3) goto L_0x0017
            goto L_0x002d
        L_0x0012:
            r5.mChildIsScrolling = r1
            r5.setOriginalMotionEvent(r6)
        L_0x0017:
            boolean r0 = r5.mChildIsScrolling
            if (r0 == 0) goto L_0x001c
            return r1
        L_0x001c:
            int r0 = r5.calculateDistanceX(r6)
            int r3 = r5.calculateDistanceY(r6)
            int r4 = r5.mTouchSlop
            if (r0 <= r4) goto L_0x002d
            if (r0 <= r3) goto L_0x002d
            r5.mChildIsScrolling = r2
            return r1
        L_0x002d:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        L_0x0032:
            r5.mChildIsScrolling = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.CJRCustomRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
