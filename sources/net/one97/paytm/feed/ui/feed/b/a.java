package net.one97.paytm.feed.ui.feed.b;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeedData;
import net.one97.paytm.feed.ui.feed.b.c;

public final class a extends RecyclerView.a<c> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<FeedGeneric> f34987a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final e f34988b;

    public a(e eVar) {
        k.c(eVar, "listener");
        this.f34988b = eVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        c cVar = (c) vVar;
        k.c(cVar, "holder");
        FeedGeneric feedGeneric = this.f34987a.get(i2);
        k.a((Object) feedGeneric, "result[position]");
        FeedGeneric feedGeneric2 = feedGeneric;
        k.c(feedGeneric2, "data");
        FeedGenericData feedGenericData = feedGeneric2.getFeedGenericData();
        if (Build.VERSION.SDK_INT >= 21) {
            View findViewById = cVar.f34991a.findViewById(R.id.coverage_bg);
            k.a((Object) findViewById, "view.findViewById<ImageView>(R.id.coverage_bg)");
            ((ImageView) findViewById).setClipToOutline(true);
        }
        View findViewById2 = cVar.f34991a.findViewById(R.id.title);
        k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.title)");
        ((TextView) findViewById2).setText(feedGenericData.getTitle());
        View findViewById3 = cVar.f34991a.findViewById(R.id.coverage_provider_name);
        k.a((Object) findViewById3, "view.findViewById<TextVi…d.coverage_provider_name)");
        TextView textView = (TextView) findViewById3;
        CreatedBy createdBy = feedGenericData.getCreatedBy();
        if (createdBy == null) {
            k.a();
        }
        textView.setText(createdBy.getName());
        ((ImageView) cVar.f34991a.findViewById(R.id.coverage_provider_icon)).setOnClickListener(new c.a(cVar, feedGeneric2));
        ((TextView) cVar.f34991a.findViewById(R.id.coverage_provider_name)).setOnClickListener(new c.b(cVar, feedGeneric2));
        View findViewById4 = cVar.f34991a.findViewById(R.id.coverage_provider_icon);
        k.a((Object) findViewById4, "view.findViewById(R.id.coverage_provider_icon)");
        ImageView imageView = (ImageView) findViewById4;
        CreatedBy createdBy2 = feedGenericData.getCreatedBy();
        if (createdBy2 == null) {
            k.a();
        }
        net.one97.paytm.feed.utility.a.a(imageView, createdBy2.getImageUrl());
        b bVar = b.f34268c;
        if (b.v()) {
            View findViewById5 = cVar.f34991a.findViewById(R.id.coverage_bg);
            k.a((Object) findViewById5, "view.findViewById(R.id.coverage_bg)");
            ImageView imageView2 = (ImageView) findViewById5;
            String imageUrl = feedGenericData.getImageUrl();
            if (imageUrl == null) {
                k.a();
            }
            net.one97.paytm.feed.utility.a.a(imageView2, imageUrl);
            View findViewById6 = cVar.f34991a.findViewById(R.id.coverage_bg_no_kenburn);
            k.a((Object) findViewById6, "view.findViewById<ImageV…d.coverage_bg_no_kenburn)");
            ((ImageView) findViewById6).setVisibility(4);
            View findViewById7 = cVar.f34991a.findViewById(R.id.coverage_bg);
            k.a((Object) findViewById7, "view.findViewById<ImageView>(R.id.coverage_bg)");
            ((ImageView) findViewById7).setVisibility(0);
        } else {
            View findViewById8 = cVar.f34991a.findViewById(R.id.coverage_bg_no_kenburn);
            k.a((Object) findViewById8, "view.findViewById(R.id.coverage_bg_no_kenburn)");
            ImageView imageView3 = (ImageView) findViewById8;
            String imageUrl2 = feedGenericData.getImageUrl();
            if (imageUrl2 == null) {
                k.a();
            }
            net.one97.paytm.feed.utility.a.a(imageView3, imageUrl2);
            View findViewById9 = cVar.f34991a.findViewById(R.id.coverage_bg);
            k.a((Object) findViewById9, "view.findViewById<ImageView>(R.id.coverage_bg)");
            ((ImageView) findViewById9).setVisibility(4);
            View findViewById10 = cVar.f34991a.findViewById(R.id.coverage_bg_no_kenburn);
            k.a((Object) findViewById10, "view.findViewById<ImageV…d.coverage_bg_no_kenburn)");
            ((ImageView) findViewById10).setVisibility(0);
        }
        if (feedGeneric2.getFeedGenericData().getStreamUrl() == null) {
            View findViewById11 = cVar.f34991a.findViewById(R.id.video_icon);
            k.a((Object) findViewById11, "view.findViewById<ImageView>(R.id.video_icon)");
            ((ImageView) findViewById11).setVisibility(8);
        } else {
            View findViewById12 = cVar.f34991a.findViewById(R.id.video_icon);
            k.a((Object) findViewById12, "view.findViewById<ImageView>(R.id.video_icon)");
            ((ImageView) findViewById12).setVisibility(0);
        }
        ((ConstraintLayout) cVar.f34991a.findViewById(R.id.root)).setOnClickListener(new c.C0573c(cVar, feedGeneric2, feedGenericData, i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_coverage_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new c(inflate, this.f34988b);
    }

    public final int getItemCount() {
        return this.f34987a.size();
    }

    public final long getItemId(int i2) {
        return (long) this.f34987a.get(i2).getFeedGenericData().getId().hashCode();
    }

    public final void a(NestedFeedData nestedFeedData) {
        k.c(nestedFeedData, "data");
        this.f34987a.clear();
        ArrayList<FeedGeneric> arrayList = this.f34987a;
        List<FeedGeneric> genericPostList = nestedFeedData.getGenericPostList();
        if (genericPostList == null) {
            k.a();
        }
        arrayList.addAll(genericPostList);
        notifyDataSetChanged();
    }
}
