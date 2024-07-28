package com.paytmmall.clpartifact.utils;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;

public abstract class RVLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
    private final RecyclerView recyclerView;

    public abstract void runHomeSettle();

    public abstract void stopRenderingTrace();

    public RVLayoutListener(RecyclerView recyclerView2) {
        k.c(recyclerView2, "recyclerView");
        this.recyclerView = recyclerView2;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void onGlobalLayout() {
        if (this.recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
            if (layoutManager == null) {
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            } else if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= 0) {
                stopRenderingTrace();
                this.recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                runHomeSettle();
            }
        }
    }
}
