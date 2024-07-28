package net.one97.paytm.feed.ui.publisher;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import androidx.palette.a.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.google.android.material.appbar.AppBarLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.bg;
import net.one97.paytm.feed.d;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.progress.FeedProgress;
import net.one97.paytm.feed.repository.models.provider.ProviderResult;
import net.one97.paytm.feed.ui.base.FeedBaseActivity;
import net.one97.paytm.feed.ui.feed.FeedFragment;
import net.one97.paytm.feed.ui.publisher.a;

public final class FeedProviderActivity extends FeedBaseActivity<bg, b> implements AppBarLayout.b, net.one97.paytm.feed.ui.feed.b {

    /* renamed from: f  reason: collision with root package name */
    public static final a f35322f = new a((byte) 0);
    /* access modifiers changed from: private */
    public static boolean s;

    /* renamed from: c  reason: collision with root package name */
    boolean f35323c;

    /* renamed from: d  reason: collision with root package name */
    boolean f35324d;

    /* renamed from: e  reason: collision with root package name */
    Long f35325e;

    /* renamed from: g  reason: collision with root package name */
    private int f35326g = -1;

    /* renamed from: h  reason: collision with root package name */
    private final float f35327h = 0.9f;

    /* renamed from: i  reason: collision with root package name */
    private final float f35328i = 0.3f;
    private final int j = 200;
    private boolean k;
    private boolean l = true;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public ProviderResult n;
    private a o;
    private LinearLayoutManager p;
    /* access modifiers changed from: private */
    public final FeedFragment.c q = new FeedFragment.c(this);
    /* access modifiers changed from: private */
    public Bundle r = new Bundle();

    static final class b<T> implements io.reactivex.rxjava3.d.g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedProviderActivity f35329a;

        b(FeedProviderActivity feedProviderActivity) {
            this.f35329a = feedProviderActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            Integer num = (Integer) obj;
            ProgressBar progressBar = ((bg) this.f35329a.a()).f33942d;
            kotlin.g.b.k.a((Object) progressBar, "dataBinding.feedLoadingProgress");
            progressBar.setVisibility(8);
            d.a aVar = net.one97.paytm.feed.d.f34256a;
            int a2 = net.one97.paytm.feed.d.f34257b;
            if (num != null && num.intValue() == a2) {
                FeedProviderActivity.g(this.f35329a).a();
                this.f35329a.m = false;
            } else {
                d.a aVar2 = net.one97.paytm.feed.d.f34256a;
                int b2 = net.one97.paytm.feed.d.f34258c;
                if (num == null || num.intValue() != b2) {
                    d.a aVar3 = net.one97.paytm.feed.d.f34256a;
                    int c2 = net.one97.paytm.feed.d.f34259d;
                    if (num != null && num.intValue() == c2) {
                        Toast.makeText(this.f35329a, R.string.feed_no_feed_available, 0).show();
                        FeedProviderActivity.g(this.f35329a).a();
                    } else {
                        d.a aVar4 = net.one97.paytm.feed.d.f34256a;
                        int g2 = net.one97.paytm.feed.d.f34263h;
                        if (num != null && num.intValue() == g2) {
                            this.f35329a.m = true;
                            FeedProviderActivity.g(this.f35329a).a();
                        } else {
                            d.a aVar5 = net.one97.paytm.feed.d.f34256a;
                            int d2 = net.one97.paytm.feed.d.f34260e;
                            if (num != null && num.intValue() == d2) {
                                FeedProviderActivity.g(this.f35329a).a();
                                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                                if (net.one97.paytm.feed.e.b.C()) {
                                    Toast.makeText(this.f35329a, R.string.feed_server_error, 0).show();
                                }
                            } else {
                                d.a aVar6 = net.one97.paytm.feed.d.f34256a;
                                int unused = net.one97.paytm.feed.d.f34262g;
                                if (num != null) {
                                    num.intValue();
                                }
                            }
                        }
                    }
                }
            }
            new Handler().postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f35330a;

                {
                    this.f35330a = r1;
                }

                public final void run() {
                    this.f35330a.f35329a.f35324d = false;
                }
            }, 2000);
        }
    }

    static final class d extends l implements kotlin.g.a.b<ProviderResult, x> {
        final /* synthetic */ FeedProviderActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FeedProviderActivity feedProviderActivity) {
            super(1);
            this.this$0 = feedProviderActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ProviderResult) obj);
            return x.f47997a;
        }

        public final void invoke(ProviderResult providerResult) {
            if (providerResult != null) {
                if (this.this$0.n == null) {
                    this.this$0.n = providerResult;
                }
                this.this$0.f35325e = Long.valueOf(providerResult.getMaxId());
                TextView textView = FeedProviderActivity.a(this.this$0).k;
                kotlin.g.b.k.a((Object) textView, "dataBinding.providerName");
                textView.setText(providerResult.getProviderData().getName());
                if (!TextUtils.isEmpty(providerResult.getProviderData().getImageUrl())) {
                    androidx.vectordrawable.a.a.i a2 = androidx.vectordrawable.a.a.i.a(this.this$0.getResources(), R.drawable.feed_ic_placeholder, (Resources.Theme) null);
                    FeedProviderActivity feedProviderActivity = this.this$0;
                    RoundedImageView roundedImageView = FeedProviderActivity.a(feedProviderActivity).f33944f;
                    kotlin.g.b.k.a((Object) roundedImageView, "dataBinding.feedProviderIcon");
                    feedProviderActivity.a(roundedImageView, providerResult.getProviderData().getImageUrl(), a2, (String) null);
                }
                androidx.vectordrawable.a.a.i a3 = androidx.vectordrawable.a.a.i.a(this.this$0.getResources(), R.drawable.feed_ic_banner_placeholder, (Resources.Theme) null);
                FeedProviderActivity feedProviderActivity2 = this.this$0;
                ImageView imageView = FeedProviderActivity.a(feedProviderActivity2).f33943e;
                kotlin.g.b.k.a((Object) imageView, "dataBinding.feedProviderHeader");
                feedProviderActivity2.a(imageView, providerResult.getProviderData().getBannerImageUrl(), a3, providerResult.getProviderData().getImageUrl());
                if (providerResult.getProviderData().getFollowerCount() > 1) {
                    TextView textView2 = FeedProviderActivity.a(this.this$0).j;
                    kotlin.g.b.k.a((Object) textView2, "dataBinding.providerFollowerCount");
                    textView2.setText(providerResult.getProviderData().getFollowerCountDisplay() + " " + this.this$0.getString(R.string.followers));
                } else {
                    TextView textView3 = FeedProviderActivity.a(this.this$0).j;
                    kotlin.g.b.k.a((Object) textView3, "dataBinding.providerFollowerCount");
                    textView3.setText(providerResult.getProviderData().getFollowerCountDisplay() + " " + this.this$0.getString(R.string.follower));
                }
                TextView textView4 = FeedProviderActivity.a(this.this$0).o;
                kotlin.g.b.k.a((Object) textView4, "dataBinding.toolbarTitle");
                textView4.setText(providerResult.getProviderData().getName());
                TextView textView5 = FeedProviderActivity.a(this.this$0).f33946h;
                kotlin.g.b.k.a((Object) textView5, "dataBinding.providerFollow");
                net.one97.paytm.feed.utility.a.a(textView5, providerResult.getUserData().isFollowed());
                TextView textView6 = FeedProviderActivity.a(this.this$0).f33947i;
                kotlin.g.b.k.a((Object) textView6, "dataBinding.providerFollowToolbar");
                net.one97.paytm.feed.utility.a.a(textView6, providerResult.getUserData().isFollowed());
            }
        }
    }

    static final class e<T> implements z<List<? extends FeedDataMinimal>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedProviderActivity f35333a;

        e(FeedProviderActivity feedProviderActivity) {
            this.f35333a = feedProviderActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf.intValue() > 0) {
                Message obtainMessage = this.f35333a.q.obtainMessage();
                this.f35333a.r.putParcelableArrayList("data", new ArrayList(list));
                kotlin.g.b.k.a((Object) obtainMessage, "msg");
                obtainMessage.setData(this.f35333a.r);
                this.f35333a.q.removeCallbacksAndMessages((Object) null);
                this.f35333a.q.sendMessageDelayed(obtainMessage, 200);
            }
        }
    }

    static final class g extends l implements kotlin.g.a.b<ProviderResult, x> {
        final /* synthetic */ FeedProviderActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FeedProviderActivity feedProviderActivity) {
            super(1);
            this.this$0 = feedProviderActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ProviderResult) obj);
            return x.f47997a;
        }

        public final void invoke(ProviderResult providerResult) {
            if (providerResult != null) {
                this.this$0.f35325e = Long.valueOf(providerResult.getMaxId());
            }
        }
    }

    public static final /* synthetic */ bg a(FeedProviderActivity feedProviderActivity) {
        return (bg) feedProviderActivity.a();
    }

    public static final /* synthetic */ a g(FeedProviderActivity feedProviderActivity) {
        a aVar = feedProviderActivity.o;
        if (aVar == null) {
            kotlin.g.b.k.a("providerAdapter");
        }
        return aVar;
    }

    public final int c() {
        return R.layout.feed_provider_landing;
    }

    public final HashMap<Integer, Object> d() {
        return new HashMap<>();
    }

    public final void a(ArrayList<FeedDataMinimal> arrayList) {
        if (arrayList != null) {
            net.one97.paytm.feed.repository.db.b bVar = net.one97.paytm.feed.repository.db.b.f34805a;
            ArrayList<FeedItem> arrayList2 = (ArrayList) net.one97.paytm.feed.repository.db.b.a((List<? extends FeedDataMinimal>) arrayList);
            a aVar = this.o;
            if (aVar == null) {
                kotlin.g.b.k.a("providerAdapter");
            }
            kotlin.g.b.k.c(arrayList2, "list");
            if (aVar.f35341a.size() == 0) {
                aVar.f35341a = arrayList2;
                aVar.notifyItemRangeInserted(0, arrayList2.size());
            } else {
                h.b a2 = androidx.recyclerview.widget.h.a(new a.C0590a(aVar, arrayList2));
                kotlin.g.b.k.a((Object) a2, "DiffUtil.calculateDiff(o…            }\n\n        })");
                aVar.f35341a = arrayList2;
                a2.a((RecyclerView.a) aVar);
            }
            a aVar2 = this.o;
            if (aVar2 == null) {
                kotlin.g.b.k.a("providerAdapter");
            }
            aVar2.a();
        }
    }

    public final void a(ImageView imageView, String str, androidx.vectordrawable.a.a.i iVar, String str2) {
        Boolean bool;
        kotlin.g.b.k.c(imageView, "view");
        if (str != null) {
            bool = Boolean.valueOf(str.length() > 0);
        } else {
            bool = null;
        }
        if (bool == null) {
            kotlin.g.b.k.a();
        }
        if (bool.booleanValue()) {
            w.a().a(str).a(imageView, (com.squareup.picasso.e) null);
        } else if (str2 != null) {
            w.a().a(Uri.parse(str2)).a((af) new f(this, iVar));
        }
    }

    public static final class f implements af {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedProviderActivity f35334a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.vectordrawable.a.a.i f35335b;

        public final void onPrepareLoad(Drawable drawable) {
        }

        f(FeedProviderActivity feedProviderActivity, androidx.vectordrawable.a.a.i iVar) {
            this.f35334a = feedProviderActivity;
            this.f35335b = iVar;
        }

        public final void onBitmapFailed(Exception exc, Drawable drawable) {
            ImageView imageView = FeedProviderActivity.a(this.f35334a).f33943e;
            kotlin.g.b.k.a((Object) imageView, "dataBinding.feedProviderHeader");
            imageView.setBackground(this.f35335b);
        }

        public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
            if (bitmap != null) {
                androidx.palette.a.b.a(bitmap).a((b.c) new a(this));
            }
        }

        static final class a implements b.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f35336a;

            a(f fVar) {
                this.f35336a = fVar;
            }

            public final void onGenerated(androidx.palette.a.b bVar) {
                if (bVar != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{bVar.a(androidx.palette.a.c.f4007a, 0), bVar.a(androidx.palette.a.c.f4012f, 0)});
                    gradientDrawable.setCornerRadius(0.0f);
                    ImageView imageView = FeedProviderActivity.a(this.f35336a.f35334a).f33943e;
                    kotlin.g.b.k.a((Object) imageView, "dataBinding.feedProviderHeader");
                    imageView.setBackground(gradientDrawable);
                }
            }
        }
    }

    public final void e() {
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.r() == 0) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.b(1);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            Window window = getWindow();
            kotlin.g.b.k.a((Object) window, "window");
            window.setStatusBarColor(window.getContext().getResources().getColor(R.color.feed_transparent));
        } else if (i2 >= 19) {
            Window window2 = getWindow();
            kotlin.g.b.k.a((Object) window2, "window");
            window2.addFlags(67108864);
        }
        ProgressBar progressBar = ((bg) a()).f33942d;
        kotlin.g.b.k.a((Object) progressBar, "dataBinding.feedLoadingProgress");
        progressBar.setVisibility(0);
        s = true;
        this.f35326g = getIntent().getIntExtra("providerId", -1);
        Context context = this;
        ((b) b()).a(context, this.f35326g, this.f35325e, (ProviderResult) null, new d(this));
        ((bg) a()).f33939a.a((AppBarLayout.b) this);
        Toolbar toolbar = ((bg) a()).n;
        setSupportActionBar(toolbar);
        toolbar.setContentInsetStartWithNavigation(0);
        toolbar.setNavigationOnClickListener(new h(this));
        Drawable a2 = androidx.core.content.b.a(context, R.drawable.feed_ic_arrow_white);
        if (a2 == null) {
            kotlin.g.b.k.a();
        }
        toolbar.setNavigationIcon(androidx.core.graphics.drawable.a.f(a2));
        ((bg) a()).f33940b.setOnClickListener(new i(this));
        RecyclerView recyclerView = ((bg) a()).l;
        recyclerView.setItemAnimator((RecyclerView.f) null);
        this.p = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        LinearLayoutManager linearLayoutManager = this.p;
        if (linearLayoutManager == null) {
            kotlin.g.b.k.a("providerLayoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        Context context2 = recyclerView.getContext();
        kotlin.g.b.k.a((Object) context2, "context");
        this.o = new a(context2);
        a aVar = this.o;
        if (aVar == null) {
            kotlin.g.b.k.a("providerAdapter");
        }
        aVar.setHasStableIds(true);
        Context context3 = recyclerView.getContext();
        kotlin.g.b.k.a((Object) context3, "context");
        recyclerView.addItemDecoration(new net.one97.paytm.feed.utility.f(context3, 30.0f));
        a aVar2 = this.o;
        if (aVar2 == null) {
            kotlin.g.b.k.a("providerAdapter");
        }
        recyclerView.setAdapter(aVar2);
        ((b) b()).f35345a.subscribe(new b(this));
        bg bgVar = (bg) a();
        RecyclerView recyclerView2 = bgVar.l;
        if (recyclerView2 != null) {
            RecyclerView recyclerView3 = bgVar.l;
            kotlin.g.b.k.a((Object) recyclerView3, "recyclerview");
            RecyclerView.LayoutManager layoutManager = recyclerView3.getLayoutManager();
            if (layoutManager != null) {
                recyclerView2.addOnScrollListener(new c(bgVar, (LinearLayoutManager) layoutManager, this));
            } else {
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        }
        ((bg) a()).f33946h.setOnClickListener(new j(this));
        ((bg) a()).f33947i.setOnClickListener(new k(this));
        TextView textView = ((bg) a()).o;
        kotlin.g.b.k.a((Object) textView, "dataBinding.toolbarTitle");
        a((View) textView, 0, 4);
        TextView textView2 = ((bg) a()).f33947i;
        kotlin.g.b.k.a((Object) textView2, "dataBinding.providerFollowToolbar");
        a((View) textView2, 0, 4);
        b bVar3 = (b) b();
        kotlin.g.b.k.c(context, "context");
        if (bVar3.f35346b == null) {
            net.one97.paytm.feed.repository.db.a aVar3 = net.one97.paytm.feed.repository.db.a.f34614a;
            bVar3.f35346b = net.one97.paytm.feed.repository.db.a.e(context);
        }
        LiveData<List<FeedDataMinimal>> liveData = bVar3.f35346b;
        if (liveData == null) {
            kotlin.g.b.k.a();
        }
        liveData.observe(this, new e(this));
    }

    public static final class c extends net.one97.paytm.feed.ui.feed.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bg f35331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedProviderActivity f35332b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bg bgVar, LinearLayoutManager linearLayoutManager, FeedProviderActivity feedProviderActivity) {
            super(linearLayoutManager, 10);
            this.f35331a = bgVar;
            this.f35332b = feedProviderActivity;
        }

        public final boolean a() {
            return this.f35332b.f35323c;
        }

        public final boolean b() {
            return this.f35332b.f35324d;
        }

        public final void a(int i2, int i3) {
            net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
            if (net.one97.paytm.feed.utility.j.e(this.f35332b)) {
                if (!this.f35332b.m) {
                    FeedProviderActivity.f(this.f35332b);
                } else if (i2 == i3) {
                    FeedProviderActivity.f(this.f35332b);
                }
            } else if (i2 == i3) {
                Toast.makeText(this.f35332b, R.string.feed_no_internet_post, 0).show();
            }
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedProviderActivity f35339a;

        j(FeedProviderActivity feedProviderActivity) {
            this.f35339a = feedProviderActivity;
        }

        public final void onClick(View view) {
            FeedProviderActivity feedProviderActivity = this.f35339a;
            TextView textView = FeedProviderActivity.a(feedProviderActivity).f33946h;
            kotlin.g.b.k.a((Object) textView, "dataBinding.providerFollow");
            TextView textView2 = FeedProviderActivity.a(this.f35339a).f33947i;
            kotlin.g.b.k.a((Object) textView2, "dataBinding.providerFollowToolbar");
            FeedProviderActivity.a(feedProviderActivity, textView, textView2);
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedProviderActivity f35340a;

        k(FeedProviderActivity feedProviderActivity) {
            this.f35340a = feedProviderActivity;
        }

        public final void onClick(View view) {
            FeedProviderActivity feedProviderActivity = this.f35340a;
            TextView textView = FeedProviderActivity.a(feedProviderActivity).f33946h;
            kotlin.g.b.k.a((Object) textView, "dataBinding.providerFollow");
            TextView textView2 = FeedProviderActivity.a(this.f35340a).f33947i;
            kotlin.g.b.k.a((Object) textView2, "dataBinding.providerFollowToolbar");
            FeedProviderActivity.a(feedProviderActivity, textView, textView2);
        }
    }

    private static void a(View view, long j2, int i2) {
        AlphaAnimation alphaAnimation;
        kotlin.g.b.k.c(view, "v");
        if (i2 == 0) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        }
        alphaAnimation.setDuration(j2);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        if (appBarLayout == null) {
            kotlin.g.b.k.a();
        }
        float abs = ((float) Math.abs(i2)) / ((float) appBarLayout.getTotalScrollRange());
        if (abs >= this.f35328i) {
            if (this.l) {
                RelativeLayout relativeLayout = ((bg) a()).f33945g;
                kotlin.g.b.k.a((Object) relativeLayout, "dataBinding.providerData");
                a((View) relativeLayout, (long) this.j, 4);
                RoundedImageView roundedImageView = ((bg) a()).f33944f;
                kotlin.g.b.k.a((Object) roundedImageView, "dataBinding.feedProviderIcon");
                a((View) roundedImageView, (long) this.j, 4);
                ImageView imageView = ((bg) a()).f33940b;
                kotlin.g.b.k.a((Object) imageView, "dataBinding.back");
                a((View) imageView, (long) this.j, 4);
                this.l = false;
            }
        } else if (!this.l) {
            RelativeLayout relativeLayout2 = ((bg) a()).f33945g;
            kotlin.g.b.k.a((Object) relativeLayout2, "dataBinding.providerData");
            a((View) relativeLayout2, (long) this.j, 0);
            RoundedImageView roundedImageView2 = ((bg) a()).f33944f;
            kotlin.g.b.k.a((Object) roundedImageView2, "dataBinding.feedProviderIcon");
            a((View) roundedImageView2, (long) this.j, 0);
            ImageView imageView2 = ((bg) a()).f33940b;
            kotlin.g.b.k.a((Object) imageView2, "dataBinding.back");
            a((View) imageView2, (long) this.j, 0);
            this.l = true;
        }
        if (abs >= this.f35327h) {
            if (!this.k) {
                TextView textView = ((bg) a()).o;
                kotlin.g.b.k.a((Object) textView, "dataBinding.toolbarTitle");
                a((View) textView, (long) this.j, 0);
                TextView textView2 = ((bg) a()).f33947i;
                kotlin.g.b.k.a((Object) textView2, "dataBinding.providerFollowToolbar");
                a((View) textView2, (long) this.j, 0);
                Toolbar toolbar = ((bg) a()).n;
                kotlin.g.b.k.a((Object) toolbar, "dataBinding.toolbar");
                a((View) toolbar, (long) this.j, 0);
                this.k = true;
            }
        } else if (this.k) {
            TextView textView3 = ((bg) a()).o;
            kotlin.g.b.k.a((Object) textView3, "dataBinding.toolbarTitle");
            a((View) textView3, (long) this.j, 4);
            TextView textView4 = ((bg) a()).f33947i;
            kotlin.g.b.k.a((Object) textView4, "dataBinding.providerFollowToolbar");
            a((View) textView4, (long) this.j, 4);
            Toolbar toolbar2 = ((bg) a()).n;
            kotlin.g.b.k.a((Object) toolbar2, "dataBinding.toolbar");
            a((View) toolbar2, (long) this.j, 4);
            this.k = false;
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedProviderActivity f35337a;

        h(FeedProviderActivity feedProviderActivity) {
            this.f35337a = feedProviderActivity;
        }

        public final void onClick(View view) {
            this.f35337a.onBackPressed();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedProviderActivity f35338a;

        i(FeedProviderActivity feedProviderActivity) {
            this.f35338a = feedProviderActivity;
        }

        public final void onClick(View view) {
            this.f35338a.onBackPressed();
        }
    }

    public final void onResume() {
        super.onResume();
        s = true;
    }

    public final void onPause() {
        super.onPause();
        s = false;
    }

    public final void onBackPressed() {
        super.onBackPressed();
        net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
        net.one97.paytm.feed.repository.db.a.d(this);
        net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
        FeedFragment.a aVar2 = FeedFragment.f34877i;
        net.one97.paytm.feed.b.a(FeedFragment.z);
    }

    public final void onDestroy() {
        super.onDestroy();
        net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
        net.one97.paytm.feed.repository.db.a.d(this);
        net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
        FeedFragment.a aVar2 = FeedFragment.f34877i;
        net.one97.paytm.feed.b.a(FeedFragment.z);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, int i2) {
            kotlin.g.b.k.c(context, "context");
            Intent intent = new Intent(context, FeedProviderActivity.class);
            intent.putExtra("providerId", i2);
            context.startActivity(intent);
        }
    }

    public static final /* synthetic */ void f(FeedProviderActivity feedProviderActivity) {
        if (!feedProviderActivity.f35324d) {
            feedProviderActivity.f35324d = true;
            a aVar = feedProviderActivity.o;
            if (aVar == null) {
                kotlin.g.b.k.a("providerAdapter");
            }
            ArrayList<FeedItem> arrayList = aVar.f35341a;
            a aVar2 = feedProviderActivity.o;
            if (aVar2 == null) {
                kotlin.g.b.k.a("providerAdapter");
            }
            if (!(arrayList.get(aVar2.f35341a.size() - 1) instanceof FeedProgress)) {
                FeedProgress feedProgress = new FeedProgress(net.one97.paytm.feed.utility.k.PROGRESS.getType());
                feedProgress.setPid(net.one97.paytm.feed.utility.k.PROGRESS.getType());
                a aVar3 = feedProviderActivity.o;
                if (aVar3 == null) {
                    kotlin.g.b.k.a("providerAdapter");
                }
                kotlin.g.b.k.c(feedProgress, "feedProgress");
                aVar3.f35341a.add(feedProgress);
                aVar3.notifyItemInserted(aVar3.f35341a.size() - 1);
                ((b) feedProviderActivity.b()).a(feedProviderActivity, feedProviderActivity.f35326g, feedProviderActivity.f35325e, feedProviderActivity.n, new g(feedProviderActivity));
                return;
            }
            return;
        }
        Toast.makeText(feedProviderActivity, R.string.feed_request_already_in_progress, 0).show();
    }

    public static final /* synthetic */ void a(FeedProviderActivity feedProviderActivity, TextView textView, TextView textView2) {
        ProviderResult providerResult = feedProviderActivity.n;
        if (providerResult != null) {
            feedProviderActivity.b();
            b.a(feedProviderActivity.f35326g, providerResult.getProviderData().getName(), providerResult.getProviderData().getFollowerCount(), feedProviderActivity, providerResult.getUserData(), textView, textView2);
        }
    }
}
