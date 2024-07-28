package com.paytmmall.clpartifact.widgets;

import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import kotlin.g.b.k;

public abstract class HidingScrollListener extends RecyclerView.l {
    private final int HIDE_THRESHOLD = a.a(100);
    private boolean controlsVisible = true;
    private int scrolledDistance;

    public abstract void onHide();

    public abstract void onShow();

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        k.c(recyclerView, "recyclerView");
        this.scrolledDistance = recyclerView.computeVerticalScrollOffset();
        if (this.scrolledDistance > this.HIDE_THRESHOLD && this.controlsVisible) {
            onHide();
            this.controlsVisible = false;
        } else if (this.scrolledDistance < this.HIDE_THRESHOLD && !this.controlsVisible) {
            onShow();
            this.controlsVisible = true;
        }
    }
}
