package net.one97.paytm.feed.ui.profile;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class e extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    boolean f35313a;

    /* renamed from: b  reason: collision with root package name */
    boolean f35314b = true;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayoutManager f35315c;

    /* renamed from: d  reason: collision with root package name */
    private a f35316d;

    public interface a {
        void a();
    }

    public e(LinearLayoutManager linearLayoutManager, a aVar) {
        k.c(linearLayoutManager, "linearLayoutManager");
        k.c(aVar, "successfulScrollListner");
        this.f35315c = linearLayoutManager;
        this.f35316d = aVar;
    }

    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        k.c(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        int childCount = this.f35315c.getChildCount();
        int itemCount = this.f35315c.getItemCount();
        int findFirstVisibleItemPosition = this.f35315c.findFirstVisibleItemPosition();
        if (!this.f35313a && this.f35314b && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0 && itemCount >= 4) {
            this.f35313a = true;
            this.f35316d.a();
        }
    }
}
