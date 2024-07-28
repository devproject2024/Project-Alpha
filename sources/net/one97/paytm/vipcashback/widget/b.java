package net.one97.paytm.vipcashback.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class b extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private final int f21064a;

    public b(int i2) {
        this.f21064a = i2;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        rect.right = this.f21064a;
    }
}
