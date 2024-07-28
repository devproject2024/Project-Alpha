package com.travel.train.helper;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class k extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Rect f27327a;

    public k(Rect rect) {
        this.f27327a = rect;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        rect.left = this.f27327a.left;
        rect.top = this.f27327a.top;
        rect.right = this.f27327a.right;
        rect.bottom = this.f27327a.bottom;
    }
}
