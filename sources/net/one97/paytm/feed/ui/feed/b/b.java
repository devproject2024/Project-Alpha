package net.one97.paytm.feed.ui.feed.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedOfFeed;
import net.one97.paytm.i.h;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34989a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f34990b;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.feed_coverage_item, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        FeedOfFeed feedOfFeed = arguments != null ? (FeedOfFeed) arguments.getParcelable("post") : null;
        if (feedOfFeed == null) {
            k.a();
        }
        View findViewById = view.findViewById(R.id.title);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.title)");
        ((TextView) findViewById).setText(feedOfFeed.getTitle());
        View findViewById2 = view.findViewById(R.id.coverage_provider_name);
        k.a((Object) findViewById2, "view.findViewById<TextVi…d.coverage_provider_name)");
        TextView textView = (TextView) findViewById2;
        CreatedBy createdBy = feedOfFeed.getCreatedBy();
        if (createdBy == null) {
            k.a();
        }
        textView.setText(createdBy.getName());
        View findViewById3 = view.findViewById(R.id.coverage_provider_icon);
        k.a((Object) findViewById3, "view.findViewById(R.id.coverage_provider_icon)");
        ImageView imageView = (ImageView) findViewById3;
        CreatedBy createdBy2 = feedOfFeed.getCreatedBy();
        if (createdBy2 == null) {
            k.a();
        }
        net.one97.paytm.feed.utility.a.a(imageView, createdBy2.getImageUrl());
        View findViewById4 = view.findViewById(R.id.coverage_bg);
        k.a((Object) findViewById4, "view.findViewById(R.id.coverage_bg)");
        ImageView imageView2 = (ImageView) findViewById4;
        String imageUrl = feedOfFeed.getImageUrl();
        if (imageUrl == null) {
            k.a();
        }
        net.one97.paytm.feed.utility.a.a(imageView2, imageUrl);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f34990b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
