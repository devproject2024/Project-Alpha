package net.one97.paytm.paymentsBank.slfd.redeemFd;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class h extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private final int f19338a;

    public h(int i2) {
        this.f19338a = i2;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.top = 0;
        } else {
            rect.top = this.f19338a;
        }
    }
}
