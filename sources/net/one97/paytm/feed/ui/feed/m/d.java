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
import net.one97.paytm.feed.b.bo;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;

public final class d extends RecyclerView.a<b<bo, ? super FeedGeneric>> {

    /* renamed from: a  reason: collision with root package name */
    NestedFeed f35148a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<FeedGeneric> f35149b = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        FeedGeneric feedGeneric = this.f35149b.get(i2);
        k.a((Object) feedGeneric, "result[position]");
        FeedGeneric feedGeneric2 = feedGeneric;
        NestedFeed nestedFeed = this.f35148a;
        if (nestedFeed == null) {
            k.a("item");
        }
        FeedItem feedItem = nestedFeed;
        k.c(feedGeneric2, "data");
        k.c(feedItem, "item");
        B b2 = bVar.f35143a;
        b2.setVariable(a.f33780g, feedGeneric2);
        b2.setVariable(a.f33778e, Integer.valueOf(i2));
        b2.setVariable(a.f33776c, feedItem);
        if (bVar.f35144b == null) {
            bVar.f35144b = new e();
            b2.setVariable(a.f33775b, bVar.f35144b);
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        bVar.f35143a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_recommended_2_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new b(inflate);
    }

    public final int getItemCount() {
        return this.f35149b.size();
    }
}
