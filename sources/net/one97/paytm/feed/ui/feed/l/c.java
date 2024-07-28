package net.one97.paytm.feed.ui.feed.l;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.bu;
import net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedApps;
import net.one97.paytm.feed.ui.base.b;
import net.one97.paytm.feed.ui.feed.a;

public final class c extends b<bu, FeedRecommendedApps, Object> {

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f35096b = ((RecyclerView) this.f35100f.findViewById(R.id.feed_recommended_recyclerview));

    /* renamed from: c  reason: collision with root package name */
    private g f35097c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f35098d;

    /* renamed from: e  reason: collision with root package name */
    private a f35099e;

    /* renamed from: f  reason: collision with root package name */
    private final View f35100f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        k.c(view, "view");
        this.f35100f = view;
        q qVar = new q();
        RecyclerView recyclerView = this.f35096b;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.f35098d = new LinearLayoutManager(recyclerView.getContext(), 0, false);
            recyclerView.setLayoutManager(this.f35098d);
            this.f35097c = new g();
            recyclerView.setAdapter(this.f35097c);
            qVar.attachToRecyclerView(recyclerView);
        }
    }

    public final void a(FeedRecommendedApps feedRecommendedApps) {
        k.c(feedRecommendedApps, "data");
        bu buVar = (bu) this.f34872a;
        buVar.setVariable(net.one97.paytm.feed.a.f33780g, feedRecommendedApps);
        if (this.f35099e == null) {
            this.f35099e = new a();
            buVar.setVariable(net.one97.paytm.feed.a.f33775b, this.f35099e);
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            buVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        g gVar = this.f35097c;
        if (gVar != null) {
            k.c(feedRecommendedApps, "data");
            gVar.f35105a.clear();
            gVar.f35105a.addAll(feedRecommendedApps.getFeedRecommendedAppsData().getAppsList());
            gVar.notifyDataSetChanged();
        }
    }
}
