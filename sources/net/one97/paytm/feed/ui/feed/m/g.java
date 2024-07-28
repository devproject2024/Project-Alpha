package net.one97.paytm.feed.ui.feed.m;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.by;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.base.b;

public final class g extends b<by, NestedFeed, Object> {

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f35154b = ((RecyclerView) this.f35157e.findViewById(R.id.feed_recommended_recyclerview));

    /* renamed from: c  reason: collision with root package name */
    private d f35155c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f35156d;

    /* renamed from: e  reason: collision with root package name */
    private final View f35157e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view) {
        super(view);
        k.c(view, "view");
        this.f35157e = view;
        q qVar = new q();
        RecyclerView recyclerView = this.f35154b;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.f35156d = new LinearLayoutManager(recyclerView.getContext(), 0, false);
            recyclerView.setLayoutManager(this.f35156d);
            this.f35155c = new d();
            recyclerView.setAdapter(this.f35155c);
            qVar.attachToRecyclerView(recyclerView);
        }
    }

    public final void a(NestedFeed nestedFeed) {
        k.c(nestedFeed, "data");
        by byVar = (by) this.f34872a;
        byVar.setVariable(a.f33779f, nestedFeed.getNestedFeedData().getTitle());
        for (Map.Entry entry : new HashMap().entrySet()) {
            byVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        d dVar = this.f35155c;
        if (dVar != null) {
            k.c(nestedFeed, "data");
            dVar.f35149b.clear();
            dVar.f35148a = nestedFeed;
            ArrayList<FeedGeneric> arrayList = dVar.f35149b;
            List<FeedGeneric> genericPostList = nestedFeed.getNestedFeedData().getGenericPostList();
            if (genericPostList == null) {
                k.a();
            }
            arrayList.addAll(genericPostList);
            dVar.notifyDataSetChanged();
        }
    }
}
