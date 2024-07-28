package net.one97.paytm.feed.ui.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.profile.Following;
import net.one97.paytm.feed.ui.profile.c;
import net.one97.paytm.feed.ui.publisher.FeedProviderActivity;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<Following> f35284a;

    /* renamed from: b  reason: collision with root package name */
    final c.b f35285b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f35286c = new View.OnClickListener(this) {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f35287a;

        {
            this.f35287a = r1;
        }

        public final void onClick(View view) {
            k.a((Object) view, "v");
            Object tag = view.getTag();
            if (tag != null) {
                Following following = (Following) tag;
                c.b bVar = this.f35287a.f35285b;
                if (bVar != null) {
                    bVar.a(following);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.profile.Following");
        }
    };

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        Following following = this.f35284a.get(i2);
        if (following.getFollowingFeedItemData().getFollowerCount() > 1) {
            TextView textView = aVar.f35289b;
            textView.setText(following.getFollowingFeedItemData().getFollowerCountDisplay() + " " + aVar.f35289b.getContext().getString(R.string.followers));
        } else {
            TextView textView2 = aVar.f35289b;
            textView2.setText(following.getFollowingFeedItemData().getFollowerCountDisplay() + " " + aVar.f35289b.getContext().getString(R.string.follower));
        }
        if (following.getFollowing()) {
            aVar.f35290c.setText(aVar.f35289b.getContext().getString(R.string.unfollow));
        } else {
            aVar.f35290c.setText(aVar.f35289b.getContext().getString(R.string.follow));
        }
        net.one97.paytm.feed.utility.a.a(aVar.f35288a, following.getFollowingFeedItemData().getImageUrl(), H5BridgeContext.INVALID_ID, H5BridgeContext.INVALID_ID);
        TextView textView3 = aVar.f35290c;
        textView3.setTag(following);
        textView3.setOnClickListener(this.f35286c);
        aVar.f35288a.setOnClickListener(new C0588b(following));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_following_item_small, viewGroup, false);
        k.a((Object) inflate, "view");
        return new a(this, inflate);
    }

    public b(List<Following> list, c.b bVar) {
        k.c(list, "mValues");
        this.f35284a = list;
        this.f35285b = bVar;
    }

    /* renamed from: net.one97.paytm.feed.ui.profile.b$b  reason: collision with other inner class name */
    static final class C0588b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Following f35293a;

        C0588b(Following following) {
            this.f35293a = following;
        }

        public final void onClick(View view) {
            FeedProviderActivity.a aVar = FeedProviderActivity.f35322f;
            k.a((Object) view, "it");
            Context context = view.getContext();
            k.a((Object) context, "it.context");
            FeedProviderActivity.a.a(context, this.f35293a.getUserId());
        }
    }

    public final int getItemCount() {
        return this.f35284a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f35288a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f35289b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f35290c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f35291d;

        /* renamed from: e  reason: collision with root package name */
        private final View f35292e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            k.c(view, "mView");
            this.f35291d = bVar;
            this.f35292e = view;
            View findViewById = this.f35292e.findViewById(R.id.followingImageView);
            k.a((Object) findViewById, "mView.findViewById(R.id.followingImageView)");
            this.f35288a = (ImageView) findViewById;
            View findViewById2 = this.f35292e.findViewById(R.id.following_title);
            k.a((Object) findViewById2, "mView.findViewById(R.id.following_title)");
            this.f35289b = (TextView) findViewById2;
            View findViewById3 = this.f35292e.findViewById(R.id.following_provider);
            k.a((Object) findViewById3, "mView.findViewById(R.id.following_provider)");
            this.f35290c = (TextView) findViewById3;
        }
    }
}
