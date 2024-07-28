package net.one97.paytm.feed.ui.feed.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.bm;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;

public final class c extends RecyclerView.a<a<bm, ? super FeedGeneric>> {

    /* renamed from: a  reason: collision with root package name */
    public NestedFeed f35146a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<FeedGeneric> f35147b = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        FeedGeneric feedGeneric = this.f35147b.get(i2);
        k.a((Object) feedGeneric, "result[position]");
        FeedGeneric feedGeneric2 = feedGeneric;
        NestedFeed nestedFeed = this.f35146a;
        if (nestedFeed == null) {
            k.a("item");
        }
        k.c(feedGeneric2, "data");
        k.c(nestedFeed, "item");
        B b2 = aVar.f35140a;
        b2.setVariable(a.f33780g, feedGeneric2);
        b2.setVariable(a.f33778e, Integer.valueOf(i2));
        b2.setVariable(a.f33776c, nestedFeed);
        if (aVar.f35141b == null) {
            aVar.f35141b = new e();
            b2.setVariable(a.f33775b, aVar.f35141b);
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        aVar.f35140a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_recommended_1_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(inflate);
    }

    public final int getItemCount() {
        return this.f35147b.size();
    }
}
