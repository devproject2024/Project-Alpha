package net.one97.paytm.recharge.automatic.b.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import kotlin.g.b.k;

public final class f extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private final int f60249a = 4;

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        if (recyclerView.getChildAdapterPosition(view) >= this.f60249a) {
            rect.top = b.c(10);
        }
    }
}
