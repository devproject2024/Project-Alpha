package net.one97.paytm.feed.ui.feed.livetv;

import android.view.View;
import androidx.lifecycle.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.ao;
import net.one97.paytm.feed.repository.models.livetv.FeedLiveTV;

public final class b extends net.one97.paytm.feed.ui.base.b<ao, FeedLiveTV, a> {

    /* renamed from: b  reason: collision with root package name */
    public a f35107b;

    /* renamed from: c  reason: collision with root package name */
    public c f35108c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f35109d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        k.c(view, "view");
        this.f35109d = (RecyclerView) view.findViewById(R.id.feed_tv_recyclerview);
        RecyclerView recyclerView = this.f35109d;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            this.f35108c = new c();
            c cVar = this.f35108c;
            if (cVar == null) {
                k.a();
            }
            cVar.setHasStableIds(true);
            recyclerView.setAdapter(this.f35108c);
        }
    }
}
