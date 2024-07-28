package com.travel.bus.busticket;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private int f21531a;

    public a() {
        this.f21531a = 0;
        this.f21531a = 15;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != recyclerView.getAdapter().getItemCount() - 1 || childAdapterPosition != 0) {
            rect.right = this.f21531a;
        }
    }
}
