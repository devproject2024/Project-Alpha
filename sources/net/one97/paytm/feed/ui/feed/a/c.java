package net.one97.paytm.feed.ui.feed.a;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.base.b;

public final class c extends b<net.one97.paytm.feed.b.c, NestedFeed, Object> {

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f34925b = ((RecyclerView) this.f34928e.findViewById(R.id.feed_banner_recyclerview));

    /* renamed from: c  reason: collision with root package name */
    private a f34926c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f34927d;

    /* renamed from: e  reason: collision with root package name */
    private final View f34928e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        k.c(view, "view");
        this.f34928e = view;
        v vVar = new v();
        RecyclerView recyclerView = this.f34925b;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.f34927d = new LinearLayoutManager(recyclerView.getContext(), 0, false);
            recyclerView.setLayoutManager(this.f34927d);
            this.f34926c = new a(net.one97.paytm.feed.utility.k.BANNERS.getType());
            recyclerView.setAdapter(this.f34926c);
            vVar.attachToRecyclerView(recyclerView);
            recyclerView.setHasFixedSize(true);
        }
    }

    public final void a(NestedFeed nestedFeed) {
        k.c(nestedFeed, "data");
        net.one97.paytm.feed.b.c cVar = (net.one97.paytm.feed.b.c) this.f34872a;
        cVar.setVariable(a.f33779f, nestedFeed.getNestedFeedData().getTitle());
        for (Map.Entry entry : new HashMap().entrySet()) {
            cVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        a aVar = this.f34926c;
        if (aVar != null) {
            aVar.a(nestedFeed);
        }
    }
}
