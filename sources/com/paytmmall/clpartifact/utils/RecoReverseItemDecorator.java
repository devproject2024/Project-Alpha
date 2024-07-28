package com.paytmmall.clpartifact.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class RecoReverseItemDecorator extends RecyclerView.h {
    private final int mSpace;

    public RecoReverseItemDecorator(int i2) {
        this.mSpace = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            rect.right = this.mSpace;
        }
    }
}
