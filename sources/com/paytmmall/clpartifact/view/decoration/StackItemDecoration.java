package com.paytmmall.clpartifact.view.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import kotlin.g.b.k;

public final class StackItemDecoration extends RecyclerView.h {
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        rect.set(0, childAdapterPosition != 0 ? (childAdapterPosition == 1 || childAdapterPosition == 2) ? a.a(-85) : a.a(-100) : 0, 0, 0);
    }
}
