package net.one97.paytm.recharge.common.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class g extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    int f62157a;

    /* renamed from: b  reason: collision with root package name */
    int f62158b;

    public g(int i2, int i3) {
        this.f62158b = i2;
        this.f62157a = i3;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.getItemOffsets(rect, view, recyclerView, sVar);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i2 = childAdapterPosition % this.f62158b;
        int a2 = sVar.a();
        if (i2 == 0) {
            rect.left = this.f62157a;
        }
        int i3 = this.f62157a;
        rect.right = i3;
        rect.top = i3;
        if (a2 > 0 && childAdapterPosition >= a2 - this.f62158b) {
            rect.bottom = i3;
        }
    }
}
