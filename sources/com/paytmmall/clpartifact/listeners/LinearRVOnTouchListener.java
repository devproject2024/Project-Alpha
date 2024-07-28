package com.paytmmall.clpartifact.listeners;

import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LinearRVOnTouchListener implements RecyclerView.k {
    private static final String TAG = LinearRVOnTouchListener.class.getSimpleName();
    private final float[] mLastX = {0.0f};
    private final float[] mLastY = {0.0f};
    private int mPosition;
    private float oldY;

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public LinearRVOnTouchListener(int i2) {
        this.mPosition = i2;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView mainRecyclerView = getMainRecyclerView(recyclerView);
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            float y = motionEvent.getY();
            float x = motionEvent.getX() - this.mLastX[0];
            float y2 = motionEvent.getY() - this.mLastY[0];
            boolean z = true;
            if (((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() == 0 && mainRecyclerView != null && ((LinearLayoutManager) mainRecyclerView.getLayoutManager()).findFirstVisibleItemPosition() == this.mPosition) {
                if (Math.abs(y2) <= Math.abs(x)) {
                    recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
                } else if (y < this.oldY) {
                    recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    int rVFirstChildTop = getRVFirstChildTop(recyclerView);
                    ViewParent parent = recyclerView.getParent();
                    if (rVFirstChildTop >= 0) {
                        z = false;
                    }
                    parent.requestDisallowInterceptTouchEvent(z);
                }
            } else if (((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() == 0 || mainRecyclerView == null || ((LinearLayoutManager) mainRecyclerView.getLayoutManager()).findFirstVisibleItemPosition() != this.mPosition) {
                recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
            } else if (Math.abs(y2) + 50.0f > Math.abs(x)) {
                recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.oldY = motionEvent.getY();
            this.mLastY[0] = motionEvent.getY();
            this.mLastX[0] = motionEvent.getX();
        }
        return false;
    }

    private int getRVFirstChildTop(RecyclerView recyclerView) {
        if (recyclerView.getChildCount() > 0) {
            return recyclerView.getChildAt(0).getTop();
        }
        return 0;
    }

    private RecyclerView getMainRecyclerView(RecyclerView recyclerView) {
        try {
            return (RecyclerView) recyclerView.getParent().getParent();
        } catch (Exception unused) {
            return null;
        }
    }
}
