package net.one97.paytm.paymentsBank.chequebook.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public abstract class i extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f17982a;

    public abstract boolean a();

    /* access modifiers changed from: protected */
    public abstract void b();

    public abstract boolean c();

    public i(LinearLayoutManager linearLayoutManager) {
        k.c(linearLayoutManager, "layoutManager");
        this.f17982a = linearLayoutManager;
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        k.c(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        boolean z = true;
        if (!a() && !c()) {
            LinearLayoutManager linearLayoutManager = this.f17982a;
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (childCount + findFirstVisibleItemPosition < itemCount || findFirstVisibleItemPosition < 0) {
                z = false;
            }
            if (z) {
                b();
            }
        }
    }
}
