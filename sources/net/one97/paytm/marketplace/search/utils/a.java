package net.one97.paytm.marketplace.search.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private final int f53506a = 4;

    /* renamed from: b  reason: collision with root package name */
    private final int f53507b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f53508c = true;

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i2 = this.f53506a;
        int i3 = childAdapterPosition % i2;
        if (this.f53508c) {
            int i4 = this.f53507b;
            rect.left = i4 - ((i3 * i4) / i2);
            rect.right = ((i3 + 1) * i4) / i2;
            if (childAdapterPosition < i2) {
                rect.top = i4;
            }
            rect.bottom = this.f53507b;
            return;
        }
        int i5 = this.f53507b;
        rect.left = (i3 * i5) / i2;
        rect.right = i5 - (((i3 + 1) * i5) / i2);
        if (childAdapterPosition >= i2) {
            rect.top = i5;
        }
    }
}
