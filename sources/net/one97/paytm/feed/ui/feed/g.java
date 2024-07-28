package net.one97.paytm.feed.ui.feed;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public abstract class g extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayoutManager f35051a;

    /* renamed from: b  reason: collision with root package name */
    private final int f35052b;

    public abstract void a(int i2, int i3);

    public abstract boolean a();

    public abstract boolean b();

    public g(LinearLayoutManager linearLayoutManager, int i2) {
        k.c(linearLayoutManager, "layoutManager");
        this.f35051a = linearLayoutManager;
        this.f35052b = i2;
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        int i4;
        k.c(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        if (i3 > 0) {
            int childCount = this.f35051a.getChildCount();
            int itemCount = this.f35051a.getItemCount();
            int findFirstVisibleItemPosition = this.f35051a.findFirstVisibleItemPosition();
            if (!b() && !a() && (i4 = childCount + findFirstVisibleItemPosition) >= itemCount - this.f35052b && findFirstVisibleItemPosition >= 0) {
                a(i4, itemCount);
            }
        }
    }
}
