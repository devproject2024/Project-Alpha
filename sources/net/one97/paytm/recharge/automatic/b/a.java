package net.one97.paytm.recharge.automatic.b;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import kotlin.g.b.k;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private boolean f60237a;

    /* renamed from: b  reason: collision with root package name */
    private int f60238b;

    public /* synthetic */ a() {
        this(true, 10);
    }

    public a(boolean z, int i2) {
        this.f60237a = z;
        this.f60238b = i2;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int a2 = sVar.a();
        if (!this.f60237a) {
            a2--;
        }
        if (childAdapterPosition < a2) {
            rect.bottom = b.c(this.f60238b);
        }
    }
}
