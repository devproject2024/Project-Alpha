package com.paytmmall.clpartifact.utils;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public abstract class EndlessRecyclerViewScrollListener extends RecyclerView.l {
    private int currentPage = 0;
    private boolean loading = true;
    RecyclerView.LayoutManager mLayoutManager;
    private int previousTotalItemCount = 0;
    private int startingPageIndex = 0;
    private int visibleThreshold = 5;

    public abstract void onLoadMore(int i2, int i3, RecyclerView recyclerView);

    public EndlessRecyclerViewScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public EndlessRecyclerViewScrollListener(GridLayoutManager gridLayoutManager) {
        this.mLayoutManager = gridLayoutManager;
        this.visibleThreshold *= gridLayoutManager.getSpanCount();
    }

    public EndlessRecyclerViewScrollListener(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.mLayoutManager = staggeredGridLayoutManager;
        this.visibleThreshold *= staggeredGridLayoutManager.f4106a;
    }

    private int getLastVisibleItem(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i3 == 0) {
                i2 = iArr[i3];
            } else if (iArr[i3] > i2) {
                i2 = iArr[i3];
            }
        }
        return i2;
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        int i4;
        int itemCount = this.mLayoutManager.getItemCount();
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            i4 = getLastVisibleItem(((StaggeredGridLayoutManager) layoutManager).b());
        } else if (layoutManager instanceof GridLayoutManager) {
            i4 = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else {
            i4 = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() : 0;
        }
        if (itemCount < this.previousTotalItemCount) {
            this.currentPage = this.startingPageIndex;
            this.previousTotalItemCount = itemCount;
            if (itemCount == 0) {
                this.loading = true;
            }
        }
        if (this.loading && itemCount > this.previousTotalItemCount) {
            this.loading = false;
            this.previousTotalItemCount = itemCount;
        }
        if (i4 + this.visibleThreshold > itemCount) {
            this.currentPage++;
            onLoadMore(this.currentPage, itemCount, recyclerView);
            this.loading = true;
        }
    }

    public void resetState() {
        this.currentPage = this.startingPageIndex;
        this.previousTotalItemCount = 0;
        this.loading = true;
    }
}
