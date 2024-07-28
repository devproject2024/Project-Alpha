package com.paytmmall.clpartifact.listeners;

import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridRVOnTouchListener implements RecyclerView.k {
    private final float[] mLastX = {0.0f};
    private final float[] mLastY = {0.0f};
    private int mPosition;
    private float oldY;

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public GridRVOnTouchListener(int i2) {
        this.mPosition = i2;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView mainRecyclerView = getMainRecyclerView(recyclerView);
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            float y = motionEvent.getY();
            float x = motionEvent.getX() - this.mLastX[0];
            float y2 = motionEvent.getY() - this.mLastY[0];
            if (recyclerView.getLayoutManager() == null || mainRecyclerView == null || mainRecyclerView.getLayoutManager() == null) {
                recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                boolean z = true;
                if (((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() == 0 && mainRecyclerView != null && ((LinearLayoutManager) mainRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == this.mPosition) {
                    if (Math.abs(y2) > Math.abs(x)) {
                        ViewParent parent = recyclerView.getParent();
                        if (y >= this.oldY) {
                            z = false;
                        }
                        parent.requestDisallowInterceptTouchEvent(z);
                    } else {
                        recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else if (((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() == -1 && ((LinearLayoutManager) mainRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == this.mPosition) {
                    if (Math.abs(y2) > Math.abs(x)) {
                        ViewParent parent2 = recyclerView.getParent();
                        if (y >= this.oldY) {
                            z = false;
                        }
                        parent2.requestDisallowInterceptTouchEvent(z);
                    } else {
                        recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else if (((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0 || ((LinearLayoutManager) mainRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() != this.mPosition) {
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
        }
        return false;
    }

    private RecyclerView getMainRecyclerView(RecyclerView recyclerView) {
        ViewParent parent = recyclerView.getParent();
        if (isList(parent.getParent().getParent().getParent())) {
            return (RecyclerView) parent.getParent().getParent().getParent();
        }
        try {
            return (RecyclerView) recyclerView.getParent().getParent().getParent().getParent().getParent();
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean isList(ViewParent viewParent) {
        return viewParent instanceof RecyclerView;
    }
}
