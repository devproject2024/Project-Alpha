package net.one97.paytm.feed.ui.feed.n;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.co;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.base.b;

public final class a extends b<co, NestedFeed, Object> {

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f35158b = ((RecyclerView) this.f35161e.findViewById(R.id.feed_banner_recyclerview));

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.feed.ui.feed.a.a f35159c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f35160d;

    /* renamed from: e  reason: collision with root package name */
    private final View f35161e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "view");
        this.f35161e = view;
        v vVar = new v();
        RecyclerView recyclerView = this.f35158b;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.f35160d = new LinearLayoutManager(recyclerView.getContext(), 1, false);
            recyclerView.setLayoutManager(this.f35160d);
            this.f35159c = new net.one97.paytm.feed.ui.feed.a.a(net.one97.paytm.feed.utility.k.TOPVIDEOS.getType());
            recyclerView.setAdapter(this.f35159c);
            vVar.attachToRecyclerView(recyclerView);
            recyclerView.setHasFixedSize(true);
        }
    }

    public final void a(NestedFeed nestedFeed) {
        k.c(nestedFeed, "data");
        co coVar = (co) this.f34872a;
        coVar.setVariable(net.one97.paytm.feed.a.f33779f, nestedFeed.getNestedFeedData().getTitle());
        for (Map.Entry entry : new HashMap().entrySet()) {
            coVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        net.one97.paytm.feed.ui.feed.a.a aVar = this.f35159c;
        if (aVar != null) {
            aVar.a(nestedFeed);
        }
    }
}
