package net.one97.paytm.feed.ui.feed.m;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.bw;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.base.b;

public final class f extends b<bw, NestedFeed, Object> {

    /* renamed from: b  reason: collision with root package name */
    public c f35150b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f35151c = ((RecyclerView) this.f35153e.findViewById(R.id.feed_recommended_recyclerview));

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f35152d;

    /* renamed from: e  reason: collision with root package name */
    private final View f35153e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view) {
        super(view);
        k.c(view, "view");
        this.f35153e = view;
        q qVar = new q();
        RecyclerView recyclerView = this.f35151c;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.f35152d = new LinearLayoutManager(recyclerView.getContext(), 1, false);
            recyclerView.setLayoutManager(this.f35152d);
            this.f35150b = new c();
            recyclerView.setAdapter(this.f35150b);
            qVar.attachToRecyclerView(recyclerView);
        }
    }
}
