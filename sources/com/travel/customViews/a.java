package com.travel.customViews;

import androidx.recyclerview.widget.RecyclerView;

public abstract class a extends RecyclerView.a<RecyclerView.v> {
    public abstract int a();

    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
