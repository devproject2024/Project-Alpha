package net.one97.paytm.upi.mandate.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public abstract class g extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f67532a;

    /* access modifiers changed from: protected */
    public abstract void a();

    public abstract boolean b();

    public abstract boolean c();

    public g(LinearLayoutManager linearLayoutManager) {
        k.c(linearLayoutManager, "layoutManager");
        this.f67532a = linearLayoutManager;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        k.c(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i2);
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        k.c(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        boolean z = true;
        if (!c() && !b()) {
            LinearLayoutManager linearLayoutManager = this.f67532a;
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (childCount + findFirstVisibleItemPosition < itemCount || findFirstVisibleItemPosition < 0) {
                z = false;
            }
            if (z) {
                a();
            }
        }
    }
}
