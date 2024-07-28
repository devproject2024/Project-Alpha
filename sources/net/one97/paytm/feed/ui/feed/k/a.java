package net.one97.paytm.feed.ui.feed.k;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.bi;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.ui.base.b;

public final class a extends b<bi, NestedFeed, Object> {

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f35085b = ((RecyclerView) this.f35089f.findViewById(R.id.feed_banner_recyclerview));

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.feed.ui.feed.a.a f35086c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f35087d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.feed.ui.feed.a f35088e;

    /* renamed from: f  reason: collision with root package name */
    private final View f35089f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "view");
        this.f35089f = view;
        v vVar = new v();
        RecyclerView recyclerView = this.f35085b;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.f35087d = new LinearLayoutManager(recyclerView.getContext(), 1, false);
            recyclerView.setLayoutManager(this.f35087d);
            this.f35086c = new net.one97.paytm.feed.ui.feed.a.a(net.one97.paytm.feed.utility.k.PUBLISHER.getType());
            recyclerView.setAdapter(this.f35086c);
            vVar.attachToRecyclerView(recyclerView);
            recyclerView.setHasFixedSize(true);
        }
    }

    public final void a(NestedFeed nestedFeed) {
        k.c(nestedFeed, "data");
        bi biVar = (bi) this.f34872a;
        biVar.setVariable(net.one97.paytm.feed.a.f33779f, nestedFeed.getNestedFeedData().getTitle());
        if (this.f35088e == null) {
            this.f35088e = new net.one97.paytm.feed.ui.feed.a();
            biVar.setVariable(net.one97.paytm.feed.a.f33775b, this.f35088e);
        }
        try {
            List<FeedGeneric> genericPostList = nestedFeed.getNestedFeedData().getGenericPostList();
            Integer num = null;
            Integer valueOf = genericPostList != null ? Integer.valueOf(genericPostList.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 0) {
                int i2 = net.one97.paytm.feed.a.D;
                List<FeedGeneric> genericPostList2 = nestedFeed.getNestedFeedData().getGenericPostList();
                if (genericPostList2 == null) {
                    k.a();
                }
                CreatedBy createdBy = genericPostList2.get(0).getFeedGenericData().getCreatedBy();
                biVar.setVariable(i2, createdBy != null ? createdBy.getImageUrl() : null);
                int i3 = net.one97.paytm.feed.a.m;
                List<FeedGeneric> genericPostList3 = nestedFeed.getNestedFeedData().getGenericPostList();
                if (genericPostList3 == null) {
                    k.a();
                }
                CreatedBy createdBy2 = genericPostList3.get(0).getFeedGenericData().getCreatedBy();
                biVar.setVariable(i3, createdBy2 != null ? createdBy2.getName() : null);
                int i4 = net.one97.paytm.feed.a.f33780g;
                List<FeedGeneric> genericPostList4 = nestedFeed.getNestedFeedData().getGenericPostList();
                if (genericPostList4 == null) {
                    k.a();
                }
                CreatedBy createdBy3 = genericPostList4.get(0).getFeedGenericData().getCreatedBy();
                if (createdBy3 != null) {
                    num = createdBy3.getId();
                }
                biVar.setVariable(i4, num);
            }
        } catch (Exception unused) {
            biVar.setVariable(net.one97.paytm.feed.a.D, "");
            biVar.setVariable(net.one97.paytm.feed.a.m, "");
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            biVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        net.one97.paytm.feed.ui.feed.a.a aVar = this.f35086c;
        if (aVar != null) {
            aVar.a(nestedFeed);
        }
    }
}
