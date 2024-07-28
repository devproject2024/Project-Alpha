package net.one97.paytm.feed.ui.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.repository.models.profile.FeedProfile;
import net.one97.paytm.feed.repository.models.profile.Following;
import net.one97.paytm.feed.ui.feed.FeedWebViewActivity;
import net.one97.paytm.feed.ui.feed.video.FullVideoActivity;
import net.one97.paytm.feed.ui.profile.e;
import net.one97.paytm.feed.ui.profile.f;
import net.one97.paytm.feed.ui.publisher.FeedProviderActivity;
import net.one97.paytm.feed.utility.j;

public final class ProfileDiscoverActivity extends PaytmActivity implements e.a, f.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Following> f35262a = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<FeedItem> f35263b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private String f35264c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f35265d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.feed.b.a f35266e;

    /* renamed from: f  reason: collision with root package name */
    private f f35267f;

    /* renamed from: g  reason: collision with root package name */
    private e f35268g;

    static final class a extends l implements kotlin.g.a.b<FeedProfile, x> {
        final /* synthetic */ ProfileDiscoverActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ProfileDiscoverActivity profileDiscoverActivity) {
            super(1);
            this.this$0 = profileDiscoverActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedProfile) obj);
            return x.f47997a;
        }

        public final void invoke(FeedProfile feedProfile) {
            if (feedProfile == null || !(!feedProfile.getResult().getFeed().isEmpty())) {
                ProfileDiscoverActivity.c(this.this$0).f35314b = false;
                if (ProfileDiscoverActivity.d(this.this$0).getItemCount() == 0) {
                    ProfileDiscoverActivity.a(this.this$0, 1);
                }
            } else {
                this.this$0.f35263b.addAll(feedProfile.getResult().getFeed());
                RecyclerView recyclerView = ProfileDiscoverActivity.b(this.this$0).f33802e;
                k.a((Object) recyclerView, "profileDiscoverBinding.rvDiscoveryList");
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                ProfileDiscoverActivity.c(this.this$0).f35314b = true;
            }
            ProfileDiscoverActivity.c(this.this$0).f35313a = false;
            ProfileDiscoverActivity.e(this.this$0);
        }
    }

    static final class b extends l implements kotlin.g.a.b<FeedProfile, x> {
        final /* synthetic */ ProfileDiscoverActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ProfileDiscoverActivity profileDiscoverActivity) {
            super(1);
            this.this$0 = profileDiscoverActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedProfile) obj);
            return x.f47997a;
        }

        public final void invoke(FeedProfile feedProfile) {
            if (feedProfile != null && (!feedProfile.getResult().getFollowing().isEmpty())) {
                this.this$0.f35262a.addAll(feedProfile.getResult().getFollowing());
                RecyclerView recyclerView = ProfileDiscoverActivity.b(this.this$0).f33802e;
                k.a((Object) recyclerView, "profileDiscoverBinding.rvDiscoveryList");
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            } else if (ProfileDiscoverActivity.d(this.this$0).getItemCount() == 0) {
                ProfileDiscoverActivity.a(this.this$0, 0);
            }
            ProfileDiscoverActivity.e(this.this$0);
        }
    }

    static final class c extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ boolean $following;
        final /* synthetic */ int $position;
        final /* synthetic */ ProfileDiscoverActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ProfileDiscoverActivity profileDiscoverActivity, boolean z, int i2) {
            super(1);
            this.this$0 = profileDiscoverActivity;
            this.$following = z;
            this.$position = i2;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                ((Following) this.this$0.f35262a.get(this.$position)).setFollowing(!this.$following);
                RecyclerView recyclerView = ProfileDiscoverActivity.b(this.this$0).f33802e;
                k.a((Object) recyclerView, "profileDiscoverBinding.rvDiscoveryList");
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.feed.b.a b(ProfileDiscoverActivity profileDiscoverActivity) {
        net.one97.paytm.feed.b.a aVar = profileDiscoverActivity.f35266e;
        if (aVar == null) {
            k.a("profileDiscoverBinding");
        }
        return aVar;
    }

    public static final /* synthetic */ e c(ProfileDiscoverActivity profileDiscoverActivity) {
        e eVar = profileDiscoverActivity.f35268g;
        if (eVar == null) {
            k.a("paginationScrollListener");
        }
        return eVar;
    }

    public static final /* synthetic */ f d(ProfileDiscoverActivity profileDiscoverActivity) {
        f fVar = profileDiscoverActivity.f35267f;
        if (fVar == null) {
            k.a("profileDiscoverAdapter");
        }
        return fVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = androidx.databinding.f.a(this, R.layout.activity_profile_discover);
        k.a((Object) a2, "DataBindingUtil.setConte…ctivity_profile_discover)");
        this.f35266e = (net.one97.paytm.feed.b.a) a2;
        net.one97.paytm.feed.b.a aVar = this.f35266e;
        if (aVar == null) {
            k.a("profileDiscoverBinding");
        }
        aVar.f33798a.setOnClickListener(new d(this));
        this.f35264c = getIntent().getStringExtra("discover_type");
        if (net.one97.paytm.feed.utility.c.a().equals(this.f35264c)) {
            net.one97.paytm.feed.b.a aVar2 = this.f35266e;
            if (aVar2 == null) {
                k.a("profileDiscoverBinding");
            }
            aVar2.f33803f.setText(getString(R.string.feed_following));
        } else if (net.one97.paytm.feed.utility.c.b().equals(this.f35264c)) {
            net.one97.paytm.feed.b.a aVar3 = this.f35266e;
            if (aVar3 == null) {
                k.a("profileDiscoverBinding");
            }
            aVar3.f33803f.setText(getString(R.string.bookmarks));
        }
        net.one97.paytm.feed.b.a aVar4 = this.f35266e;
        if (aVar4 == null) {
            k.a("profileDiscoverBinding");
        }
        RecyclerView recyclerView = aVar4.f33802e;
        Context context = this;
        this.f35267f = new f(context, this.f35264c, this);
        this.f35265d = new LinearLayoutManager(context, 1, false);
        LinearLayoutManager linearLayoutManager = this.f35265d;
        if (linearLayoutManager == null) {
            k.a("linearLayoutManager");
        }
        this.f35268g = new e(linearLayoutManager, this);
        f fVar = this.f35267f;
        if (fVar == null) {
            k.a("profileDiscoverAdapter");
        }
        recyclerView.setAdapter(fVar);
        LinearLayoutManager linearLayoutManager2 = this.f35265d;
        if (linearLayoutManager2 == null) {
            k.a("linearLayoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager2);
        e eVar = this.f35268g;
        if (eVar == null) {
            k.a("paginationScrollListener");
        }
        recyclerView.addOnScrollListener(eVar);
        recyclerView.addItemDecoration(new net.one97.paytm.feed.utility.f(context, 15.0f));
        if (k.a((Object) net.one97.paytm.feed.utility.c.a(), (Object) this.f35264c)) {
            net.one97.paytm.feed.b.a aVar5 = this.f35266e;
            if (aVar5 == null) {
                k.a("profileDiscoverBinding");
            }
            RecyclerView recyclerView2 = aVar5.f33802e;
            k.a((Object) recyclerView2, "profileDiscoverBinding.rvDiscoveryList");
            RecyclerView.a adapter = recyclerView2.getAdapter();
            if (adapter != null) {
                List<Following> list = this.f35262a;
                k.c(list, "list");
                ((f) adapter).f35317a = list;
                c();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.ui.profile.ProfileDiscoverAdapter");
        }
        net.one97.paytm.feed.b.a aVar6 = this.f35266e;
        if (aVar6 == null) {
            k.a("profileDiscoverBinding");
        }
        RecyclerView recyclerView3 = aVar6.f33802e;
        k.a((Object) recyclerView3, "profileDiscoverBinding.rvDiscoveryList");
        RecyclerView.a adapter2 = recyclerView3.getAdapter();
        if (adapter2 != null) {
            List list2 = this.f35263b;
            k.c(list2, "list");
            ((f) adapter2).f35318b = (ArrayList) list2;
            b();
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.ui.profile.ProfileDiscoverAdapter");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProfileDiscoverActivity f35269a;

        d(ProfileDiscoverActivity profileDiscoverActivity) {
            this.f35269a = profileDiscoverActivity;
        }

        public final void onClick(View view) {
            this.f35269a.onBackPressed();
        }
    }

    private final void b() {
        d();
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.c.a.a().b((Context) this, (kotlin.g.a.b<? super FeedProfile, x>) new a(this));
    }

    private final void c() {
        d();
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.c.a.a().a((Context) this, (kotlin.g.a.b<? super FeedProfile, x>) new b(this));
    }

    public final void a(int i2, boolean z, int i3) {
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
        Context context = this;
        kotlin.g.a.b cVar = new c(this, z, i2);
        k.c(context, "context");
        k.c(cVar, "completionHandler");
        if (z) {
            a2.b(context, "/content-social-graph/v1/unfollow", i3, (kotlin.g.a.b<? super String, x>) cVar);
        } else {
            a2.b(context, "/content-social-graph/v1/follow", i3, (kotlin.g.a.b<? super String, x>) cVar);
        }
    }

    public final void a(int i2) {
        FeedProviderActivity.a aVar = FeedProviderActivity.f35322f;
        if (!FeedProviderActivity.s) {
            j jVar = j.f35397a;
            Context context = this;
            if (j.e(context)) {
                net.one97.paytm.feed.utility.u uVar = net.one97.paytm.feed.utility.u.f35438a;
                if (!net.one97.paytm.feed.utility.u.a()) {
                    FeedProviderActivity.a aVar2 = FeedProviderActivity.f35322f;
                    FeedProviderActivity.a.a(context, i2);
                    return;
                }
                return;
            }
            Toast.makeText(context, R.string.feed_no_internet, 0).show();
        }
    }

    public final void a(FeedGeneric feedGeneric) {
        k.c(feedGeneric, "feedItem");
        FeedGenericData feedGenericData = feedGeneric.getFeedGenericData();
        j jVar = j.f35397a;
        Context context = this;
        if (j.e(context)) {
            net.one97.paytm.feed.utility.u uVar = net.one97.paytm.feed.utility.u.f35438a;
            if (!net.one97.paytm.feed.utility.u.a()) {
                String str = null;
                if (feedGenericData.getWebUrl() != null) {
                    String webUrl = feedGenericData.getWebUrl();
                    Boolean valueOf = webUrl != null ? Boolean.valueOf(p.a((CharSequence) webUrl, (CharSequence) "twitter", true)) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (valueOf.booleanValue()) {
                        FeedWebViewActivity.a aVar = FeedWebViewActivity.f34900a;
                        CreatedBy createdBy = feedGenericData.getCreatedBy();
                        if (createdBy != null) {
                            str = createdBy.getName();
                        }
                        if (str == null) {
                            k.a();
                        }
                        String webUrl2 = feedGenericData.getWebUrl();
                        if (webUrl2 == null) {
                            k.a();
                        }
                        FeedWebViewActivity.a.a(context, str, webUrl2, "#1ea1f1", "#1ea1f1", feedGeneric);
                        return;
                    }
                }
                if (feedGenericData.getWebUrl() != null) {
                    FeedWebViewActivity.a aVar2 = FeedWebViewActivity.f34900a;
                    CreatedBy createdBy2 = feedGenericData.getCreatedBy();
                    if (createdBy2 != null) {
                        str = createdBy2.getName();
                    }
                    if (str == null) {
                        k.a();
                    }
                    String webUrl3 = feedGenericData.getWebUrl();
                    if (webUrl3 == null) {
                        k.a();
                    }
                    FeedWebViewActivity.a.a(context, str, webUrl3, feedGeneric);
                } else if (feedGenericData.getStreamUrl() != null) {
                    FullVideoActivity.a aVar3 = FullVideoActivity.f35223a;
                    FullVideoActivity.a.a(context, feedGeneric, 0);
                }
            }
        } else {
            Toast.makeText(context, R.string.feed_no_internet, 0).show();
        }
    }

    public final void b(int i2) {
        f fVar = this.f35267f;
        if (fVar == null) {
            k.a("profileDiscoverAdapter");
        }
        ArrayList<FeedItem> arrayList = fVar.f35318b;
        if (arrayList == null) {
            k.a("bookmarkList");
        }
        arrayList.remove(i2);
        fVar.notifyItemRemoved(i2);
        ArrayList<FeedItem> arrayList2 = fVar.f35318b;
        if (arrayList2 == null) {
            k.a("bookmarkList");
        }
        fVar.notifyItemRangeChanged(i2, arrayList2.size());
    }

    public final void a() {
        if (k.a((Object) net.one97.paytm.feed.utility.c.a(), (Object) this.f35264c)) {
            c();
        } else if (k.a((Object) net.one97.paytm.feed.utility.c.b(), (Object) this.f35264c)) {
            b();
        }
    }

    private final void d() {
        net.one97.paytm.feed.b.a aVar = this.f35266e;
        if (aVar == null) {
            k.a("profileDiscoverBinding");
        }
        ProgressBar progressBar = aVar.f33801d;
        k.a((Object) progressBar, "profileDiscoverBinding.progress");
        progressBar.setVisibility(0);
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public static final /* synthetic */ void a(ProfileDiscoverActivity profileDiscoverActivity, int i2) {
        net.one97.paytm.feed.b.a aVar = profileDiscoverActivity.f35266e;
        if (aVar == null) {
            k.a("profileDiscoverBinding");
        }
        ImageView imageView = aVar.f33800c;
        k.a((Object) imageView, "profileDiscoverBinding.emptyView");
        imageView.setVisibility(0);
        net.one97.paytm.feed.b.a aVar2 = profileDiscoverActivity.f35266e;
        if (aVar2 == null) {
            k.a("profileDiscoverBinding");
        }
        TextView textView = aVar2.f33799b;
        k.a((Object) textView, "profileDiscoverBinding.emptyTitle");
        textView.setVisibility(0);
        if (i2 == 0) {
            net.one97.paytm.feed.b.a aVar3 = profileDiscoverActivity.f35266e;
            if (aVar3 == null) {
                k.a("profileDiscoverBinding");
            }
            aVar3.f33800c.setImageResource(R.drawable.feed_ic_no_following);
            net.one97.paytm.feed.b.a aVar4 = profileDiscoverActivity.f35266e;
            if (aVar4 == null) {
                k.a("profileDiscoverBinding");
            }
            TextView textView2 = aVar4.f33799b;
            k.a((Object) textView2, "profileDiscoverBinding.emptyTitle");
            textView2.setText(profileDiscoverActivity.getString(R.string.feed_no_followers));
            return;
        }
        net.one97.paytm.feed.b.a aVar5 = profileDiscoverActivity.f35266e;
        if (aVar5 == null) {
            k.a("profileDiscoverBinding");
        }
        aVar5.f33800c.setImageResource(R.drawable.feed_ic_no_bookmark);
        net.one97.paytm.feed.b.a aVar6 = profileDiscoverActivity.f35266e;
        if (aVar6 == null) {
            k.a("profileDiscoverBinding");
        }
        TextView textView3 = aVar6.f33799b;
        k.a((Object) textView3, "profileDiscoverBinding.emptyTitle");
        textView3.setText(profileDiscoverActivity.getString(R.string.feed_no_bookmarks));
    }

    public static final /* synthetic */ void e(ProfileDiscoverActivity profileDiscoverActivity) {
        net.one97.paytm.feed.b.a aVar = profileDiscoverActivity.f35266e;
        if (aVar == null) {
            k.a("profileDiscoverBinding");
        }
        ProgressBar progressBar = aVar.f33801d;
        k.a((Object) progressBar, "profileDiscoverBinding.progress");
        progressBar.setVisibility(8);
    }
}
