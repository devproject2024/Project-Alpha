package com.paytmmall.clpartifact.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class InfiniteScrollListener extends RecyclerView.l {
    private static final int ITEM_THRESOLD = 2;

    public abstract boolean hasMore();

    public abstract boolean isRequesting();

    public abstract void onLoadMore();

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        super.onScrolled(recyclerView, i2, i3);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int itemCount = linearLayoutManager.getItemCount();
            if (!isRequesting() && hasMore() && itemCount > 0 && findLastVisibleItemPosition + 2 >= itemCount) {
                onLoadMore();
            }
        }
    }
}
