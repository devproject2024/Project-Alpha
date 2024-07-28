package net.one97.paytm.feed.ui.feed.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.e;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.utility.r;

public final class a extends RecyclerView.a<b<e, ? super FeedGeneric>> {

    /* renamed from: a  reason: collision with root package name */
    private NestedFeed f34916a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<FeedGeneric> f34917b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private String f34918c;

    public a(String str) {
        k.c(str, "type");
        this.f34918c = str;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        FeedGeneric feedGeneric = this.f34917b.get(i2);
        k.a((Object) feedGeneric, "result[position]");
        FeedGeneric feedGeneric2 = feedGeneric;
        NestedFeed nestedFeed = this.f34916a;
        if (nestedFeed == null) {
            k.a("item");
        }
        FeedItem feedItem = nestedFeed;
        k.c(feedGeneric2, "data");
        k.c(feedItem, "item");
        B b2 = bVar.f34923b;
        b2.setVariable(net.one97.paytm.feed.a.f33780g, feedGeneric2);
        b2.setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
        b2.setVariable(net.one97.paytm.feed.a.f33776c, feedItem);
        if (bVar.f34922a == null) {
            bVar.f34922a = new net.one97.paytm.feed.ui.feed.m.e();
            b2.setVariable(net.one97.paytm.feed.a.f33775b, bVar.f34922a);
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        bVar.f34923b.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View view;
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (this.f34918c.equals(net.one97.paytm.feed.utility.k.BANNERS.getType())) {
            if (from == null) {
                k.a();
            }
            view = from.inflate(R.layout.feed_banner_item, viewGroup, false);
        } else if (this.f34918c.equals(net.one97.paytm.feed.utility.k.POSTER.getType())) {
            if (from == null) {
                k.a();
            }
            view = from.inflate(R.layout.feed_poster_item, viewGroup, false);
        } else if (this.f34918c.equals(net.one97.paytm.feed.utility.k.PUBLISHER.getType())) {
            if (from == null) {
                k.a();
            }
            view = from.inflate(R.layout.feed_publisher_item, viewGroup, false);
        } else {
            if (from == null) {
                k.a();
            }
            view = from.inflate(R.layout.feed_top_video_item, viewGroup, false);
        }
        if (k.a((Object) this.f34918c, (Object) net.one97.paytm.feed.utility.k.POSTER.getType()) || this.f34918c.equals(net.one97.paytm.feed.utility.k.BANNERS.getType())) {
            k.a((Object) view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            r rVar = r.f35432a;
            layoutParams.width = r.a() - 100;
            view.setLayoutParams(layoutParams);
        }
        k.a((Object) view, "view");
        return new b(view);
    }

    public final int getItemCount() {
        return this.f34917b.size();
    }

    public final void a(NestedFeed nestedFeed) {
        k.c(nestedFeed, "data");
        this.f34917b.clear();
        this.f34916a = nestedFeed;
        ArrayList<FeedGeneric> arrayList = this.f34917b;
        List<FeedGeneric> genericPostList = nestedFeed.getNestedFeedData().getGenericPostList();
        if (genericPostList == null) {
            k.a();
        }
        arrayList.addAll(genericPostList);
        notifyDataSetChanged();
    }

    public final long getItemId(int i2) {
        return (long) this.f34917b.get(i2).getFeedGenericData().getId().hashCode();
    }
}
