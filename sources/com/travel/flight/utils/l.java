package com.travel.flight.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class l extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private int f25602a;

    public l(int i2) {
        this.f25602a = i2;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
            rect.bottom = this.f25602a;
        } else {
            rect.bottom = 0;
        }
    }
}
