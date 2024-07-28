package com.paytmmall.clpartifact.view.viewHolder;

import androidx.recyclerview.widget.RecyclerView;

public final class BackwardsDrawingOrderCallback implements RecyclerView.d {
    public final int onGetChildDrawingOrder(int i2, int i3) {
        return (i2 - i3) - 1;
    }
}
