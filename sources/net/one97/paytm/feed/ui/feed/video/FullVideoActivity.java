package net.one97.paytm.feed.ui.feed.video;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.q;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.appsflyer.share.Constants;
import com.google.android.exoplayer2.ag;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.r;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlaybackControlView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.z;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.w;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.utility.s;

public final class FullVideoActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f35223a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private ag f35224b;

    /* renamed from: c  reason: collision with root package name */
    private long f35225c;

    /* renamed from: d  reason: collision with root package name */
    private int f35226d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f35227e = true;

    /* renamed from: f  reason: collision with root package name */
    private String f35228f = "";

    /* renamed from: g  reason: collision with root package name */
    private w f35229g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f35230h = "FullVideoActivity";

    /* renamed from: i  reason: collision with root package name */
    private a f35231i;
    /* access modifiers changed from: private */
    public FeedItem j;
    /* access modifiers changed from: private */
    public net.one97.paytm.feed.ui.feed.a k = new net.one97.paytm.feed.ui.feed.a();
    /* access modifiers changed from: private */
    public net.one97.paytm.feed.ui.feed.d.a l;
    private Dialog m;
    /* access modifiers changed from: private */
    public boolean n;
    private ImageView o;
    private final z.a p = new l(this);
    private HashMap q;

    public final View a(int i2) {
        if (this.q == null) {
            this.q = new HashMap();
        }
        View view = (View) this.q.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.q.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class m<T> implements androidx.lifecycle.z<FeedDataMinimal> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35243a;

        m(FullVideoActivity fullVideoActivity) {
            this.f35243a = fullVideoActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FeedDataMinimal feedDataMinimal = (FeedDataMinimal) obj;
            if (feedDataMinimal != null) {
                net.one97.paytm.feed.repository.db.b bVar = net.one97.paytm.feed.repository.db.b.f34805a;
                FeedItem a2 = net.one97.paytm.feed.repository.db.b.a(feedDataMinimal);
                if (a2 != null) {
                    FeedGeneric feedGeneric = (FeedGeneric) a2;
                    this.f35243a.j = feedGeneric;
                    this.f35243a.a(feedGeneric);
                }
            }
        }
    }

    static final class n<T> implements androidx.lifecycle.z<FeedDataMinimal> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35244a;

        n(FullVideoActivity fullVideoActivity) {
            this.f35244a = fullVideoActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FeedDataMinimal feedDataMinimal = (FeedDataMinimal) obj;
            if (feedDataMinimal != null) {
                net.one97.paytm.feed.repository.db.b bVar = net.one97.paytm.feed.repository.db.b.f34805a;
                FeedItem a2 = net.one97.paytm.feed.repository.db.b.a(feedDataMinimal);
                if (a2 != null) {
                    FeedGeneric feedGeneric = (FeedGeneric) a2;
                    this.f35244a.j = feedGeneric;
                    this.f35244a.a(feedGeneric);
                }
            }
        }
    }

    public static final /* synthetic */ a d(FullVideoActivity fullVideoActivity) {
        a aVar = fullVideoActivity.f35231i;
        if (aVar == null) {
            kotlin.g.b.k.a("fullVideoViewModel");
        }
        return aVar;
    }

    public static final /* synthetic */ w i(FullVideoActivity fullVideoActivity) {
        w wVar = fullVideoActivity.f35229g;
        if (wVar == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        return wVar;
    }

    public static final class l implements z.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35242a;

        public final void a() {
        }

        public /* synthetic */ void a(ah ahVar) {
            z.a.CC.$default$a((z.a) this, ahVar);
        }

        public final void a(boolean z) {
        }

        public final void b() {
        }

        public /* synthetic */ void b(boolean z) {
            z.a.CC.$default$b(this, z);
        }

        public /* synthetic */ void c() {
            z.a.CC.$default$c(this);
        }

        public /* synthetic */ void d() {
            z.a.CC.$default$d(this);
        }

        public final void e() {
        }

        public /* synthetic */ void f() {
            z.a.CC.$default$f(this);
        }

        l(FullVideoActivity fullVideoActivity) {
            this.f35242a = fullVideoActivity;
        }

        public final void a(com.google.android.exoplayer2.i iVar) {
            String unused = this.f35242a.f35230h;
            if (iVar != null) {
                iVar.getMessage();
            }
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
        }

        public final void a(int i2) {
            FullVideoActivity.i(this.f35242a).f34239g.a();
            if (i2 == 2) {
                ProgressBar progressBar = (ProgressBar) this.f35242a.a(R.id.progressBar);
                kotlin.g.b.k.a((Object) progressBar, "progressBar");
                progressBar.setVisibility(0);
            } else if (i2 == 3) {
                ProgressBar progressBar2 = (ProgressBar) this.f35242a.a(R.id.progressBar);
                kotlin.g.b.k.a((Object) progressBar2, "progressBar");
                progressBar2.setVisibility(4);
            }
        }
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.a(context2);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        kotlin.g.b.k.a((Object) window, "window");
        View decorView = window.getDecorView();
        kotlin.g.b.k.a((Object) decorView, "window.decorView");
        decorView.setSystemUiVisibility(TarConstants.EOF_BLOCK);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window2 = getWindow();
            kotlin.g.b.k.a((Object) window2, "window");
            window2.setStatusBarColor(0);
        }
        ViewDataBinding a2 = androidx.databinding.f.a(this, R.layout.feed_fullscreen_video_activity);
        kotlin.g.b.k.a((Object) a2, "DataBindingUtil.setConte…ullscreen_video_activity)");
        this.f35229g = (w) a2;
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        this.f35231i = (a) net.one97.paytm.feed.c.a.a((AppCompatActivity) this);
        this.j = (FeedItem) getIntent().getParcelableExtra("data");
        this.f35225c = getIntent().getLongExtra("playedTime", 0);
        FeedItem feedItem = this.j;
        if (feedItem == null) {
            Toast.makeText(this, R.string.feed_server_error, 0).show();
            finish();
            return;
        }
        if (feedItem instanceof FeedGeneric) {
            if (feedItem != null) {
                FeedGeneric feedGeneric = (FeedGeneric) feedItem;
                a aVar2 = this.f35231i;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("fullVideoViewModel");
                }
                Context context = this;
                String id = feedGeneric.getFeedGenericData().getId();
                kotlin.g.b.k.c(context, "context");
                kotlin.g.b.k.c(id, Constants.URL_MEDIA_SOURCE);
                if (aVar2.f35245a == null) {
                    net.one97.paytm.feed.repository.db.a aVar3 = net.one97.paytm.feed.repository.db.a.f34614a;
                    aVar2.f35245a = net.one97.paytm.feed.repository.db.a.g(context, id);
                }
                LiveData<FeedDataMinimal> liveData = aVar2.f35245a;
                if (liveData == null) {
                    kotlin.g.b.k.a();
                }
                q qVar = this;
                liveData.observe(qVar, new m(this));
                a aVar4 = this.f35231i;
                if (aVar4 == null) {
                    kotlin.g.b.k.a("fullVideoViewModel");
                }
                String id2 = feedGeneric.getFeedGenericData().getId();
                kotlin.g.b.k.c(context, "context");
                kotlin.g.b.k.c(id2, Constants.URL_MEDIA_SOURCE);
                if (aVar4.f35246b == null) {
                    net.one97.paytm.feed.repository.db.a aVar5 = net.one97.paytm.feed.repository.db.a.f34614a;
                    aVar4.f35246b = net.one97.paytm.feed.repository.db.a.h(context, id2);
                }
                LiveData<FeedDataMinimal> liveData2 = aVar4.f35246b;
                if (liveData2 == null) {
                    kotlin.g.b.k.a();
                }
                liveData2.observe(qVar, new n(this));
                FeedItem feedItem2 = this.j;
                if (feedItem2 != null) {
                    String streamUrl = ((FeedGeneric) feedItem2).getFeedGenericData().getStreamUrl();
                    if (streamUrl == null) {
                        kotlin.g.b.k.a();
                    }
                    this.f35228f = streamUrl;
                    w wVar = this.f35229g;
                    if (wVar == null) {
                        kotlin.g.b.k.a("activityFullVideoBinding");
                    }
                    wVar.setVariable(net.one97.paytm.feed.a.f33780g, this.j);
                    wVar.setVariable(net.one97.paytm.feed.a.f33775b, new net.one97.paytm.feed.ui.feed.a());
                    int i2 = net.one97.paytm.feed.a.f33777d;
                    FeedItem feedItem3 = this.j;
                    if (feedItem3 != null) {
                        wVar.setVariable(i2, new net.one97.paytm.feed.ui.feed.d.a((FeedGeneric) feedItem3));
                        FeedItem feedItem4 = this.j;
                        if (feedItem4 != null) {
                            a((FeedGeneric) feedItem4);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
            }
        } else if (feedItem instanceof NestedFeed) {
            if (feedItem != null) {
                try {
                    List<FeedGeneric> genericPostList = ((NestedFeed) feedItem).getNestedFeedData().getGenericPostList();
                    if (genericPostList == null) {
                        kotlin.g.b.k.a();
                    }
                    FeedGeneric feedGeneric2 = genericPostList.get(0);
                    String streamUrl2 = feedGeneric2.getFeedGenericData().getStreamUrl();
                    if (streamUrl2 == null) {
                        kotlin.g.b.k.a();
                    }
                    this.f35228f = streamUrl2;
                    w wVar2 = this.f35229g;
                    if (wVar2 == null) {
                        kotlin.g.b.k.a("activityFullVideoBinding");
                    }
                    wVar2.setVariable(net.one97.paytm.feed.a.f33780g, feedGeneric2);
                    wVar2.setVariable(net.one97.paytm.feed.a.f33775b, new net.one97.paytm.feed.ui.feed.a());
                    wVar2.setVariable(net.one97.paytm.feed.a.f33777d, new net.one97.paytm.feed.ui.feed.d.a(feedGeneric2));
                    a(feedGeneric2);
                } catch (Exception unused) {
                    Toast.makeText(this, R.string.feed_server_error, 0).show();
                    finish();
                    return;
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed");
            }
        }
        b(8);
        this.m = new Dialog(this, 16973834);
        Dialog dialog = this.m;
        if (dialog == null) {
            kotlin.g.b.k.a();
        }
        dialog.setOnCancelListener(new c(this));
        w wVar3 = this.f35229g;
        if (wVar3 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        PlaybackControlView playbackControlView = (PlaybackControlView) wVar3.f34239g.findViewById(R.id.exo_controller);
        this.o = (ImageView) playbackControlView.findViewById(R.id.exo_fullscreen_icon);
        ((FrameLayout) playbackControlView.findViewById(R.id.exo_fullscreen_button)).setOnClickListener(new b(this));
        if (this.l == null) {
            FeedItem feedItem5 = this.j;
            if (feedItem5 != null) {
                this.l = new net.one97.paytm.feed.ui.feed.d.a((FeedGeneric) feedItem5);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
            }
        }
        w wVar4 = this.f35229g;
        if (wVar4 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        ImageView imageView = wVar4.f34235c;
        if (imageView != null) {
            imageView.setOnClickListener(new d(this));
        }
        w wVar5 = this.f35229g;
        if (wVar5 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        ImageView imageView2 = wVar5.f34233a;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new e(this));
        }
        w wVar6 = this.f35229g;
        if (wVar6 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        wVar6.f34241i.setOnClickListener(new f(this));
        w wVar7 = this.f35229g;
        if (wVar7 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        wVar7.f34236d.setOnClickListener(new g(this));
        w wVar8 = this.f35229g;
        if (wVar8 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        SimpleExoPlayerView simpleExoPlayerView = wVar8.f34239g;
        if (simpleExoPlayerView != null) {
            simpleExoPlayerView.setOnClickListener(new h(this));
        }
        w wVar9 = this.f35229g;
        if (wVar9 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        SimpleExoPlayerView simpleExoPlayerView2 = wVar9.f34239g;
        kotlin.g.b.k.a((Object) simpleExoPlayerView2, "activityFullVideoBinding.playerView");
        View videoSurfaceView = simpleExoPlayerView2.getVideoSurfaceView();
        if (videoSurfaceView != null) {
            videoSurfaceView.setOnClickListener(new i(this));
        }
        w wVar10 = this.f35229g;
        if (wVar10 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        RoundedImageView roundedImageView = wVar10.l;
        if (roundedImageView != null) {
            roundedImageView.setOnClickListener(new j(this));
        }
        w wVar11 = this.f35229g;
        if (wVar11 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        wVar11.j.setOnClickListener(new k(this));
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35234a;

        d(FullVideoActivity fullVideoActivity) {
            this.f35234a = fullVideoActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.feed.ui.feed.a unused = this.f35234a.k;
            kotlin.g.b.k.a((Object) view, "it");
            FeedItem a2 = this.f35234a.j;
            if (a2 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.feed.ui.feed.d.a c2 = this.f35234a.l;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.feed.ui.feed.a.a(view, a2, (ai) c2);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35235a;

        e(FullVideoActivity fullVideoActivity) {
            this.f35235a = fullVideoActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.feed.ui.feed.a unused = this.f35235a.k;
            kotlin.g.b.k.a((Object) view, "it");
            FeedItem a2 = this.f35235a.j;
            if (a2 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.feed.ui.feed.d.a c2 = this.f35235a.l;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.feed.ui.feed.a.c(view, a2, c2);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35236a;

        f(FullVideoActivity fullVideoActivity) {
            this.f35236a = fullVideoActivity;
        }

        public final void onClick(View view) {
            FullVideoActivity.d(this.f35236a);
            kotlin.g.b.k.a((Object) view, "it");
            Context context = view.getContext();
            kotlin.g.b.k.a((Object) context, "it.context");
            FeedItem a2 = this.f35236a.j;
            if (a2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(a2, "feedItem");
            if (a2 instanceof FeedGeneric) {
                FeedGeneric feedGeneric = (FeedGeneric) a2;
                if (!feedGeneric.getFeedGenericData().isFollowed()) {
                    String followed = FeedEventNames.INSTANCE.getFOLLOWED();
                    net.one97.paytm.feed.events.a.b bVar = net.one97.paytm.feed.events.a.b.f34303a;
                    a.a(context, feedGeneric, "/content-social-graph/v1/follow", followed, "v2_feed_follow", net.one97.paytm.feed.events.a.b.c(), true);
                    return;
                }
                String unfollowed = FeedEventNames.INSTANCE.getUNFOLLOWED();
                net.one97.paytm.feed.events.a.b bVar2 = net.one97.paytm.feed.events.a.b.f34303a;
                a.a(context, feedGeneric, "/content-social-graph/v1/unfollow", unfollowed, "v2_feed_follow", net.one97.paytm.feed.events.a.b.c(), false);
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35237a;

        g(FullVideoActivity fullVideoActivity) {
            this.f35237a = fullVideoActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.feed.ui.feed.a unused = this.f35237a.k;
            kotlin.g.b.k.a((Object) view, "it");
            FeedItem a2 = this.f35237a.j;
            if (a2 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.feed.ui.feed.d.a c2 = this.f35237a.l;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            ai aiVar = c2;
            kotlin.g.b.k.c(view, "view");
            kotlin.g.b.k.c(a2, "post");
            kotlin.g.b.k.c(aiVar, "viewModel");
            net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
            if (net.one97.paytm.feed.e.c.a(view.getContext())) {
                s sVar = s.f35433a;
                Context context = view.getContext();
                kotlin.g.b.k.a((Object) context, "view.context");
                if (!s.a(context)) {
                    Toast.makeText(view.getContext(), view.getContext().getString(R.string.feed_whatsappnotinstalled), 0).show();
                    return;
                }
                Context context2 = view.getContext();
                kotlin.g.b.k.a((Object) context2, "view.context");
                net.one97.paytm.feed.ui.feed.a.a(context2, a2, false, "WhatsApp", aiVar);
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35238a;

        h(FullVideoActivity fullVideoActivity) {
            this.f35238a = fullVideoActivity;
        }

        public final void onClick(View view) {
            this.f35238a.b(8);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35239a;

        i(FullVideoActivity fullVideoActivity) {
            this.f35239a = fullVideoActivity;
        }

        public final void onClick(View view) {
            this.f35239a.b(0);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35240a;

        j(FullVideoActivity fullVideoActivity) {
            this.f35240a = fullVideoActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.feed.ui.feed.a unused = this.f35240a.k;
            kotlin.g.b.k.a((Object) view, "it");
            FeedItem a2 = this.f35240a.j;
            if (a2 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.feed.ui.feed.a.a(view, a2);
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35241a;

        k(FullVideoActivity fullVideoActivity) {
            this.f35241a = fullVideoActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.feed.ui.feed.a unused = this.f35241a.k;
            kotlin.g.b.k.a((Object) view, "it");
            FeedItem a2 = this.f35241a.j;
            if (a2 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.feed.ui.feed.a.a(view, a2);
        }
    }

    /* access modifiers changed from: private */
    public final void a(FeedGeneric feedGeneric) {
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        Boolean isLiked = feedGeneric.getFeedGenericData().isLiked();
        if (isLiked == null) {
            kotlin.g.b.k.a();
        }
        if (isLiked.booleanValue()) {
            w wVar = this.f35229g;
            if (wVar == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            wVar.f34235c.setImageResource(R.drawable.feed_ic_like);
        } else {
            w wVar2 = this.f35229g;
            if (wVar2 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            wVar2.f34235c.setImageResource(R.drawable.feed_ic_like_svg);
        }
        if (feedGeneric.getFeedGenericData().isBookmarked()) {
            w wVar3 = this.f35229g;
            if (wVar3 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            wVar3.f34233a.setImageResource(R.drawable.feed_ic_bookmark);
        } else {
            w wVar4 = this.f35229g;
            if (wVar4 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            wVar4.f34233a.setImageResource(R.drawable.feed_ic_unbookmark);
        }
        w wVar5 = this.f35229g;
        if (wVar5 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        TextView textView = wVar5.n;
        kotlin.g.b.k.a((Object) textView, "activityFullVideoBinding.tvLike");
        textView.setText(String.valueOf(feedGeneric.getFeedGenericData().getLikeCount()));
        w wVar6 = this.f35229g;
        if (wVar6 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        TextView textView2 = wVar6.o;
        kotlin.g.b.k.a((Object) textView2, "activityFullVideoBinding.tvShare");
        textView2.setText(String.valueOf(feedGeneric.getFeedGenericData().getShareCount()));
        w wVar7 = this.f35229g;
        if (wVar7 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        TextView textView3 = wVar7.m;
        kotlin.g.b.k.a((Object) textView3, "activityFullVideoBinding.tvComment");
        textView3.setText(String.valueOf(feedGeneric.getFeedGenericData().getCommentCount()));
        if (feedGeneric.getFeedGenericData().isFollowed()) {
            w wVar8 = this.f35229g;
            if (wVar8 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            wVar8.f34241i.setTextColor(androidx.core.content.b.c(context, R.color.feed_colorAccent));
            w wVar9 = this.f35229g;
            if (wVar9 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            wVar9.f34241i.setText(R.string.feed_follow);
            return;
        }
        w wVar10 = this.f35229g;
        if (wVar10 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        wVar10.f34241i.setTextColor(androidx.core.content.b.c(context, R.color.feed_following));
        w wVar11 = this.f35229g;
        if (wVar11 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        wVar11.f34241i.setText(R.string.feed_following);
    }

    /* access modifiers changed from: private */
    public final void b(int i2) {
        w wVar = this.f35229g;
        if (wVar == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        SimpleExoPlayerView simpleExoPlayerView = wVar.f34239g;
        if (simpleExoPlayerView != null) {
            simpleExoPlayerView.a();
        }
        w wVar2 = this.f35229g;
        if (wVar2 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        RoundedImageView roundedImageView = wVar2.l;
        kotlin.g.b.k.a((Object) roundedImageView, "activityFullVideoBinding.sourceImage");
        roundedImageView.setVisibility(i2);
        w wVar3 = this.f35229g;
        if (wVar3 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        TextView textView = wVar3.j;
        kotlin.g.b.k.a((Object) textView, "activityFullVideoBinding.providerName");
        textView.setVisibility(i2);
        w wVar4 = this.f35229g;
        if (wVar4 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        LinearLayout linearLayout = wVar4.f34237e;
        kotlin.g.b.k.a((Object) linearLayout, "activityFullVideoBinding.likeShareContainer");
        linearLayout.setVisibility(i2);
        w wVar5 = this.f35229g;
        if (wVar5 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        TextView textView2 = wVar5.f34241i;
        kotlin.g.b.k.a((Object) textView2, "activityFullVideoBinding.providerFollow");
        textView2.setVisibility(i2);
    }

    public final void onStart() {
        super.onStart();
        if (ae.f32499a >= 24) {
            a();
        }
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
        if (ae.f32499a < 24 || this.f35224b == null) {
            a();
        }
    }

    public final void onPause() {
        super.onPause();
        if (ae.f32499a < 24) {
            b();
        }
    }

    public final void onStop() {
        super.onStop();
        if (ae.f32499a >= 24) {
            b();
        }
    }

    private final void a() {
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector();
        defaultTrackSelector.a(defaultTrackSelector.a().a());
        this.f35224b = com.google.android.exoplayer2.k.a(this, defaultTrackSelector);
        ag agVar = this.f35224b;
        if (agVar != null) {
            agVar.a(this.f35227e);
        }
        ag agVar2 = this.f35224b;
        if (agVar2 != null) {
            agVar2.a(this.p);
        }
        w wVar = this.f35229g;
        if (wVar == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        SimpleExoPlayerView simpleExoPlayerView = wVar.f34239g;
        if (simpleExoPlayerView != null) {
            simpleExoPlayerView.setPlayer(this.f35224b);
        }
        Uri parse = Uri.parse(this.f35228f);
        kotlin.g.b.k.a((Object) parse, "uri");
        o a2 = a(parse);
        ag agVar3 = this.f35224b;
        if (agVar3 != null) {
            agVar3.a(a2, true, true);
        }
        ag agVar4 = this.f35224b;
        if (agVar4 != null) {
            agVar4.a(this.f35226d, this.f35225c);
        }
        w wVar2 = this.f35229g;
        if (wVar2 == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        SimpleExoPlayerView simpleExoPlayerView2 = wVar2.f34239g;
        kotlin.g.b.k.a((Object) simpleExoPlayerView2, "activityFullVideoBinding.playerView");
        simpleExoPlayerView2.setResizeMode(0);
    }

    private final void b() {
        ag agVar = this.f35224b;
        if (agVar != null) {
            Boolean valueOf = agVar != null ? Boolean.valueOf(agVar.n()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            this.f35227e = valueOf.booleanValue();
            ag agVar2 = this.f35224b;
            Long valueOf2 = agVar2 != null ? Long.valueOf(agVar2.u()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            this.f35225c = valueOf2.longValue();
            ag agVar3 = this.f35224b;
            Integer valueOf3 = agVar3 != null ? Integer.valueOf(agVar3.s()) : null;
            if (valueOf3 == null) {
                kotlin.g.b.k.a();
            }
            this.f35226d = valueOf3.intValue();
            ag agVar4 = this.f35224b;
            if (agVar4 != null) {
                agVar4.r();
            }
            this.f35224b = null;
        }
    }

    private final o a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) lastPathSegment, "uri.lastPathSegment!!");
        if (!p.a((CharSequence) lastPathSegment, (CharSequence) "mp3", false)) {
            String lastPathSegment2 = uri.getLastPathSegment();
            if (lastPathSegment2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) lastPathSegment2, "uri.lastPathSegment!!");
            if (!p.a((CharSequence) lastPathSegment2, (CharSequence) "mp4", false)) {
                String lastPathSegment3 = uri.getLastPathSegment();
                if (lastPathSegment3 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) lastPathSegment3, "uri.lastPathSegment!!");
                if (p.a((CharSequence) lastPathSegment3, (CharSequence) "m3u8", false)) {
                    HlsMediaSource createMediaSource = new HlsMediaSource.Factory((i.a) new r("feed-exoplayer")).createMediaSource(uri);
                    kotlin.g.b.k.a((Object) createMediaSource, "HlsMediaSource.Factory(D…  .createMediaSource(uri)");
                    return createMediaSource;
                }
                DashMediaSource createMediaSource2 = new DashMediaSource.Factory(new com.google.android.exoplayer2.f.p(this, "feed-exoplayer")).createMediaSource(uri);
                kotlin.g.b.k.a((Object) createMediaSource2, "DashMediaSource.Factory(…)).createMediaSource(uri)");
                return createMediaSource2;
            }
        }
        com.google.android.exoplayer2.source.r a2 = new r.a(new com.google.android.exoplayer2.f.r("feed-exoplayer")).a(uri);
        kotlin.g.b.k.a((Object) a2, "ProgressiveMediaSource.F…  .createMediaSource(uri)");
        return a2;
    }

    static final class c implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35233a;

        c(FullVideoActivity fullVideoActivity) {
            this.f35233a = fullVideoActivity;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            if (this.f35233a.n) {
                FullVideoActivity.f(this.f35233a);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FullVideoActivity f35232a;

        b(FullVideoActivity fullVideoActivity) {
            this.f35232a = fullVideoActivity;
        }

        public final void onClick(View view) {
            if (!this.f35232a.n) {
                FullVideoActivity.g(this.f35232a);
            } else {
                FullVideoActivity.f(this.f35232a);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, FeedItem feedItem, long j) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(feedItem, "feed");
            Intent intent = new Intent(context, FullVideoActivity.class);
            intent.putExtra("data", feedItem);
            intent.putExtra("playedTime", j);
            context.startActivity(intent);
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        b();
    }

    public static final /* synthetic */ void f(FullVideoActivity fullVideoActivity) {
        fullVideoActivity.setRequestedOrientation(1);
        w wVar = fullVideoActivity.f35229g;
        if (wVar == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        SimpleExoPlayerView simpleExoPlayerView = wVar.f34239g;
        kotlin.g.b.k.a((Object) simpleExoPlayerView, "activityFullVideoBinding.playerView");
        ViewParent parent = simpleExoPlayerView.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            w wVar2 = fullVideoActivity.f35229g;
            if (wVar2 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            viewGroup.removeView(wVar2.f34239g);
            w wVar3 = fullVideoActivity.f35229g;
            if (wVar3 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            FrameLayout frameLayout = wVar3.f34238f;
            w wVar4 = fullVideoActivity.f35229g;
            if (wVar4 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            frameLayout.addView(wVar4.f34239g);
            fullVideoActivity.n = false;
            Dialog dialog = fullVideoActivity.m;
            if (dialog == null) {
                kotlin.g.b.k.a();
            }
            dialog.dismiss();
            try {
                com.google.android.play.core.splitcompat.a.a((Context) fullVideoActivity);
                ImageView imageView = fullVideoActivity.o;
                if (imageView == null) {
                    kotlin.g.b.k.a();
                }
                imageView.setImageDrawable(androidx.core.content.b.a((Context) fullVideoActivity, R.drawable.feed_ic_video_fullscreen_icon));
            } catch (Exception e2) {
                new StringBuilder("Exception is :: ").append(e2.getMessage());
            }
        } else {
            throw new u("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public static final /* synthetic */ void g(FullVideoActivity fullVideoActivity) {
        try {
            if (fullVideoActivity.j instanceof FeedGeneric) {
                FeedItem feedItem = fullVideoActivity.j;
                if (feedItem != null) {
                    String width = ((FeedGeneric) feedItem).getFeedGenericData().getWidth();
                    if (width == null) {
                        kotlin.g.b.k.a();
                    }
                    int parseInt = Integer.parseInt(width);
                    FeedItem feedItem2 = fullVideoActivity.j;
                    if (feedItem2 != null) {
                        String height = ((FeedGeneric) feedItem2).getFeedGenericData().getHeight();
                        if (height == null) {
                            kotlin.g.b.k.a();
                        }
                        if (parseInt > Integer.parseInt(height)) {
                            fullVideoActivity.setRequestedOrientation(0);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                }
            }
        } catch (Exception unused) {
        }
        w wVar = fullVideoActivity.f35229g;
        if (wVar == null) {
            kotlin.g.b.k.a("activityFullVideoBinding");
        }
        SimpleExoPlayerView simpleExoPlayerView = wVar.f34239g;
        kotlin.g.b.k.a((Object) simpleExoPlayerView, "activityFullVideoBinding.playerView");
        ViewParent parent = simpleExoPlayerView.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            w wVar2 = fullVideoActivity.f35229g;
            if (wVar2 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            viewGroup.removeView(wVar2.f34239g);
            Dialog dialog = fullVideoActivity.m;
            if (dialog == null) {
                kotlin.g.b.k.a();
            }
            w wVar3 = fullVideoActivity.f35229g;
            if (wVar3 == null) {
                kotlin.g.b.k.a("activityFullVideoBinding");
            }
            dialog.addContentView(wVar3.f34239g, new ViewGroup.LayoutParams(-1, -1));
            fullVideoActivity.n = true;
            Dialog dialog2 = fullVideoActivity.m;
            if (dialog2 == null) {
                kotlin.g.b.k.a();
            }
            dialog2.show();
            try {
                com.google.android.play.core.splitcompat.a.a((Context) fullVideoActivity);
                ImageView imageView = fullVideoActivity.o;
                if (imageView == null) {
                    kotlin.g.b.k.a();
                }
                imageView.setImageDrawable(androidx.core.content.b.a((Context) fullVideoActivity, R.drawable.feed_ic_video_fullscreen_shrink));
            } catch (Exception e2) {
                new StringBuilder("Exception is :: ").append(e2.getMessage());
            }
        } else {
            throw new u("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }
}
