package net.one97.paytm.feed.ui.feed.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.exoplayer2.ag;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.z;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.aa;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.l;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.ci;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.FeedOfFeed;
import net.one97.paytm.feed.repository.models.bookmark.FeedBookmark;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.ui.feed.FeedWebViewActivity;
import net.one97.paytm.feed.ui.feed.story.StoryViewActivity;
import net.one97.paytm.feed.utility.r;
import net.one97.paytm.feed.utility.u;

public final class f extends net.one97.paytm.i.h {
    public static final a l = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    ObjectAnimator f35199a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35200b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35201c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f35202d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f35203e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f35204f;

    /* renamed from: g  reason: collision with root package name */
    public CustomConstraintLayout f35205g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f35206h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f35207i;
    public PlayerView j;
    public Stories k;
    /* access modifiers changed from: private */
    public String m = "StoryFragment::";
    private String n;
    /* access modifiers changed from: private */
    public String o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public Integer q;
    private int r;
    private ag s;
    /* access modifiers changed from: private */
    public int t;
    private Context u;
    /* access modifiers changed from: private */
    public boolean v;
    /* access modifiers changed from: private */
    public boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    private final z.a y = new i(this);
    private HashMap z;

    static final class c extends l implements kotlin.g.a.b<FeedOfFeed, x> {
        final /* synthetic */ String $postId;
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar, String str) {
            super(1);
            this.this$0 = fVar;
            this.$postId = str;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedOfFeed) obj);
            return x.f47997a;
        }

        public final void invoke(FeedOfFeed feedOfFeed) {
            if (feedOfFeed != null) {
                String unused = this.this$0.m;
                new StringBuilder("Got Api response success with Feeddata of storyid=").append(this.$postId);
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.t().put(this.$postId, feedOfFeed);
                this.this$0.b();
            }
            this.this$0.w = false;
        }
    }

    static final class j extends l implements kotlin.g.a.b<FeedOfFeed, x> {
        final /* synthetic */ x.e $postId;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(x.e eVar) {
            super(1);
            this.$postId = eVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedOfFeed) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(FeedOfFeed feedOfFeed) {
            if (feedOfFeed != null) {
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.t().put((String) this.$postId.element, feedOfFeed);
            }
        }
    }

    static final class k extends l implements kotlin.g.a.b<FeedBookmark, kotlin.x> {
        public static final k INSTANCE = new k();

        k() {
            super(1);
        }

        public final void invoke(FeedBookmark feedBookmark) {
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedBookmark) obj);
            return kotlin.x.f47997a;
        }
    }

    public final Stories a() {
        Stories stories = this.k;
        if (stories == null) {
            kotlin.g.b.k.a("story");
        }
        return stories;
    }

    public static final class i implements z.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f35217a;

        public /* synthetic */ void a() {
            z.a.CC.$default$a(this);
        }

        public /* synthetic */ void a(int i2) {
            z.a.CC.$default$a((z.a) this, i2);
        }

        public /* synthetic */ void a(ah ahVar) {
            z.a.CC.$default$a((z.a) this, ahVar);
        }

        public /* synthetic */ void a(com.google.android.exoplayer2.i iVar) {
            z.a.CC.$default$a((z.a) this, iVar);
        }

        public /* synthetic */ void a(boolean z) {
            z.a.CC.$default$a((z.a) this, z);
        }

        public /* synthetic */ void b() {
            z.a.CC.$default$b(this);
        }

        public /* synthetic */ void c() {
            z.a.CC.$default$c(this);
        }

        public /* synthetic */ void d() {
            z.a.CC.$default$d(this);
        }

        public /* synthetic */ void e() {
            z.a.CC.$default$e(this);
        }

        public /* synthetic */ void f() {
            z.a.CC.$default$f(this);
        }

        i(f fVar) {
            this.f35217a = fVar;
        }

        public final void b(boolean z) {
            z.a.CC.$default$b(this, z);
            if (z) {
                this.f35217a.c();
                if (this.f35217a.f35199a != null) {
                    ObjectAnimator objectAnimator = this.f35217a.f35199a;
                    if (objectAnimator == null) {
                        kotlin.g.b.k.a();
                    }
                    if (objectAnimator.isPaused()) {
                        ObjectAnimator objectAnimator2 = this.f35217a.f35199a;
                        if (objectAnimator2 == null) {
                            kotlin.g.b.k.a();
                        }
                        objectAnimator2.resume();
                        return;
                    }
                }
                f fVar = this.f35217a;
                int d2 = fVar.t;
                Integer j = this.f35217a.q;
                if (j == null) {
                    kotlin.g.b.k.a();
                }
                fVar.a(d2, j.intValue());
                return;
            }
            ObjectAnimator objectAnimator3 = this.f35217a.f35199a;
            if (objectAnimator3 == null) {
                kotlin.g.b.k.a();
            }
            objectAnimator3.pause();
            this.f35217a.d();
        }
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        this.u = context;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.feed_story_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.progressLayout);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById(R.id.progressLayout)");
        this.f35204f = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.feed_story_image);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById(R.id.feed_story_image)");
        this.f35207i = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.playerView);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById(R.id.playerView)");
        this.j = (PlayerView) findViewById3;
        View findViewById4 = view.findViewById(R.id.root);
        kotlin.g.b.k.a((Object) findViewById4, "view.findViewById(R.id.root)");
        this.f35205g = (CustomConstraintLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.progressBar);
        kotlin.g.b.k.a((Object) findViewById5, "view.findViewById(R.id.progressBar)");
        this.f35206h = (ProgressBar) findViewById5;
        View findViewById6 = view.findViewById(R.id.story_creator_icon);
        kotlin.g.b.k.a((Object) findViewById6, "view.findViewById(R.id.story_creator_icon)");
        this.f35203e = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R.id.story_creator_name);
        kotlin.g.b.k.a((Object) findViewById7, "view.findViewById(R.id.story_creator_name)");
        this.f35200b = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.urlContainer);
        kotlin.g.b.k.a((Object) findViewById8, "view.findViewById(R.id.urlContainer)");
        this.f35202d = (LinearLayout) findViewById8;
        View findViewById9 = view.findViewById(R.id.storyUrl);
        kotlin.g.b.k.a((Object) findViewById9, "view.findViewById(R.id.storyUrl)");
        this.f35201c = (TextView) findViewById9;
        Bundle arguments = getArguments();
        Stories stories = arguments != null ? (Stories) arguments.getParcelable("data") : null;
        if (stories == null) {
            kotlin.g.b.k.a();
        }
        this.k = stories;
        Bundle arguments2 = getArguments();
        Integer valueOf = arguments2 != null ? Integer.valueOf(arguments2.getInt(CLPConstants.ARGUMENT_KEY_POSITION)) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        this.r = valueOf.intValue();
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.s().containsKey(Integer.valueOf(this.r))) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            Integer num = net.one97.paytm.feed.e.b.s().get(Integer.valueOf(this.r));
            if (num == null) {
                kotlin.g.b.k.a();
            }
            this.t = num.intValue();
        }
        Stories stories2 = this.k;
        if (stories2 == null) {
            kotlin.g.b.k.a("story");
        }
        if (stories2.getStoryposition() - 1 > this.t) {
            Stories stories3 = this.k;
            if (stories3 == null) {
                kotlin.g.b.k.a("story");
            }
            this.t = stories3.getStoryposition() - 1;
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.s().put(Integer.valueOf(this.r), Integer.valueOf(this.t));
        }
        x.e eVar = new x.e();
        Context activity = getActivity();
        CustomConstraintLayout customConstraintLayout = this.f35205g;
        if (customConstraintLayout == null) {
            kotlin.g.b.k.a("root");
        }
        eVar.element = new GestureDetector(activity, new C0585f(this, customConstraintLayout));
        CustomConstraintLayout customConstraintLayout2 = this.f35205g;
        if (customConstraintLayout2 == null) {
            kotlin.g.b.k.a("root");
        }
        customConstraintLayout2.setOnTouchListener(new d(eVar));
        CustomConstraintLayout customConstraintLayout3 = this.f35205g;
        if (customConstraintLayout3 == null) {
            kotlin.g.b.k.a("root");
        }
        customConstraintLayout3.setGestureDetector((GestureDetector) eVar.element);
        LinearLayout linearLayout = this.f35202d;
        if (linearLayout == null) {
            kotlin.g.b.k.a("urlContainer");
        }
        linearLayout.setOnClickListener(new e(this));
        net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
        HashMap<String, FeedOfFeed> t2 = net.one97.paytm.feed.e.b.t();
        Stories stories4 = this.k;
        if (stories4 == null) {
            kotlin.g.b.k.a("story");
        }
        String id = stories4.getData().getId();
        Stories stories5 = this.k;
        if (stories5 == null) {
            kotlin.g.b.k.a("story");
        }
        t2.put(id, stories5.getData());
        Context context = view.getContext();
        kotlin.g.b.k.a((Object) context, "view.context");
        Stories stories6 = this.k;
        if (stories6 == null) {
            kotlin.g.b.k.a("story");
        }
        int size = stories6.getPostIds().size();
        LinearLayout linearLayout2 = this.f35204f;
        if (linearLayout2 == null) {
            kotlin.g.b.k.a("progresslayout");
        }
        a(context, size, linearLayout2);
        Stories stories7 = this.k;
        if (stories7 == null) {
            kotlin.g.b.k.a("story");
        }
        if (stories7.getUser() != null) {
            Stories stories8 = this.k;
            if (stories8 == null) {
                kotlin.g.b.k.a("story");
            }
            if (!TextUtils.isEmpty(stories8.getUser().getUserImageUrl())) {
                w a2 = w.a();
                Stories stories9 = this.k;
                if (stories9 == null) {
                    kotlin.g.b.k.a("story");
                }
                aa a3 = a2.a(stories9.getUser().getUserImageUrl());
                ImageView imageView = this.f35203e;
                if (imageView == null) {
                    kotlin.g.b.k.a("creatorImage");
                }
                a3.a(imageView, (com.squareup.picasso.e) null);
                Stories stories10 = this.k;
                if (stories10 == null) {
                    kotlin.g.b.k.a("story");
                }
                if (!TextUtils.isEmpty(stories10.getUser().getUserName())) {
                    TextView textView = this.f35200b;
                    if (textView == null) {
                        kotlin.g.b.k.a("creatorName");
                    }
                    Stories stories11 = this.k;
                    if (stories11 == null) {
                        kotlin.g.b.k.a("story");
                    }
                    textView.setText(stories11.getUser().getUserName());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        if (r0 >= r3.getPostIds().size()) goto L_0x0036;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0269  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r10 = this;
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            java.util.HashMap r0 = net.one97.paytm.feed.e.b.s()
            int r1 = r10.r
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            if (r0 != 0) goto L_0x0015
            kotlin.g.b.k.a()
        L_0x0015:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            r10.t = r0
            int r0 = r10.t
            java.lang.String r1 = "story"
            r2 = 0
            if (r0 < 0) goto L_0x0036
            net.one97.paytm.feed.repository.models.stories.Stories r3 = r10.k
            if (r3 != 0) goto L_0x002c
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x002c:
            java.util.List r3 = r3.getPostIds()
            int r3 = r3.size()
            if (r0 < r3) goto L_0x0038
        L_0x0036:
            r10.t = r2
        L_0x0038:
            int r0 = r10.t
            net.one97.paytm.feed.repository.models.stories.Stories r3 = r10.k
            if (r3 != 0) goto L_0x0041
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0041:
            java.util.List r3 = r3.getPostIds()
            int r3 = r3.size()
            r4 = 1
            int r3 = r3 - r4
            if (r0 != r3) goto L_0x0061
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            java.util.TreeSet r0 = net.one97.paytm.feed.e.b.c()
            if (r0 != 0) goto L_0x0058
            kotlin.g.b.k.a()
        L_0x0058:
            int r3 = r10.r
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.add(r3)
        L_0x0061:
            net.one97.paytm.feed.repository.models.stories.Stories r0 = r10.k
            if (r0 != 0) goto L_0x0068
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0068:
            java.util.List r0 = r0.getPostIds()
            int r3 = r10.t
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            net.one97.paytm.feed.e.b r3 = net.one97.paytm.feed.e.b.f34268c
            java.util.HashMap r3 = net.one97.paytm.feed.e.b.t()
            boolean r3 = r3.containsKey(r0)
            if (r3 == 0) goto L_0x026d
            int r3 = r10.t
            boolean r5 = r10.v
            if (r5 == 0) goto L_0x02a1
            net.one97.paytm.feed.e.b r5 = net.one97.paytm.feed.e.b.f34268c
            java.util.HashMap r5 = net.one97.paytm.feed.e.b.t()
            java.lang.Object r5 = r5.get(r0)
            net.one97.paytm.feed.repository.models.FeedOfFeed r5 = (net.one97.paytm.feed.repository.models.FeedOfFeed) r5
            r6 = 0
            if (r5 == 0) goto L_0x009a
            java.lang.String r7 = r5.getWebUrl()
            goto L_0x009b
        L_0x009a:
            r7 = r6
        L_0x009b:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r8 = "storyUrl"
            if (r7 != 0) goto L_0x00bd
            if (r5 == 0) goto L_0x00ac
            java.lang.String r6 = r5.getWebUrl()
        L_0x00ac:
            r10.o = r6
            android.widget.TextView r6 = r10.f35201c
            if (r6 != 0) goto L_0x00b5
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00b5:
            java.lang.String r7 = r10.o
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            goto L_0x00f6
        L_0x00bd:
            if (r5 == 0) goto L_0x00c4
            java.lang.String r7 = r5.getDeepLink()
            goto L_0x00c5
        L_0x00c4:
            r7 = r6
        L_0x00c5:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00e4
            if (r5 == 0) goto L_0x00d3
            java.lang.String r6 = r5.getDeepLink()
        L_0x00d3:
            r10.p = r6
            android.widget.TextView r6 = r10.f35201c
            if (r6 != 0) goto L_0x00dc
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00dc:
            java.lang.String r7 = r10.p
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            goto L_0x00f6
        L_0x00e4:
            r10.o = r6
            r10.p = r6
            android.widget.TextView r6 = r10.f35201c
            if (r6 != 0) goto L_0x00ef
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00ef:
            java.lang.String r7 = ""
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
        L_0x00f6:
            if (r5 != 0) goto L_0x00fb
            kotlin.g.b.k.a()
        L_0x00fb:
            java.lang.String r6 = r5.getStreamUrl()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r7 = "playerView"
            r8 = 8
            java.lang.String r9 = "imageView"
            if (r6 == 0) goto L_0x016e
            com.google.android.exoplayer2.ui.PlayerView r6 = r10.j
            if (r6 != 0) goto L_0x0114
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0114:
            r6.setVisibility(r8)
            android.widget.ImageView r6 = r10.f35207i
            if (r6 != 0) goto L_0x011e
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x011e:
            r6.setVisibility(r2)
            com.squareup.picasso.w$a r2 = new com.squareup.picasso.w$a
            android.content.Context r6 = r10.getContext()
            if (r6 != 0) goto L_0x012c
            kotlin.g.b.k.a()
        L_0x012c:
            r2.<init>(r6)
            net.one97.paytm.feed.ui.feed.story.f$g r6 = net.one97.paytm.feed.ui.feed.story.f.g.f35213a
            com.squareup.picasso.w$c r6 = (com.squareup.picasso.w.c) r6
            if (r6 == 0) goto L_0x0166
            com.squareup.picasso.w$c r7 = r2.f45454b
            if (r7 != 0) goto L_0x015e
            r2.f45454b = r6
            com.squareup.picasso.w r2 = r2.a()
            java.lang.String r5 = r5.getImageUrl()
            android.net.Uri r5 = android.net.Uri.parse(r5)
            com.squareup.picasso.aa r2 = r2.a((android.net.Uri) r5)
            android.widget.ImageView r5 = r10.f35207i
            if (r5 != 0) goto L_0x0152
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0152:
            net.one97.paytm.feed.ui.feed.story.f$h r6 = new net.one97.paytm.feed.ui.feed.story.f$h
            r6.<init>(r10, r0, r3)
            com.squareup.picasso.e r6 = (com.squareup.picasso.e) r6
            r2.a((android.widget.ImageView) r5, (com.squareup.picasso.e) r6)
            goto L_0x02a1
        L_0x015e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Listener already set."
            r0.<init>(r1)
            throw r0
        L_0x0166:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Listener must not be null."
            r0.<init>(r1)
            throw r0
        L_0x016e:
            java.lang.String r3 = r5.getStreamUrl()
            r10.n = r3
            java.lang.Integer r3 = r5.getDuration()
            r10.q = r3
            android.widget.ImageView r3 = r10.f35207i
            if (r3 != 0) goto L_0x0181
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x0181:
            r3.setVisibility(r8)
            com.google.android.exoplayer2.ui.PlayerView r3 = r10.j
            if (r3 != 0) goto L_0x018b
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x018b:
            r3.setVisibility(r2)
            r10.a((java.lang.String) r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Playing video with url="
            r0.<init>(r3)
            java.lang.String r3 = r10.n
            r0.append(r3)
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.k()
            java.lang.String r0 = r10.n
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x02a1
            java.lang.String r0 = r10.n
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r3 = "uri"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r3 = "story-exoplayer"
            java.lang.String r5 = r0.getLastPathSegment()
            if (r5 != 0) goto L_0x01c4
            kotlin.g.b.k.a()
        L_0x01c4:
            java.lang.String r6 = "uri.lastPathSegment!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r7 = "mp3"
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r7, false)
            if (r5 != 0) goto L_0x023b
            java.lang.String r5 = r0.getLastPathSegment()
            if (r5 != 0) goto L_0x01df
            kotlin.g.b.k.a()
        L_0x01df:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r7 = "mp4"
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r7, false)
            if (r5 == 0) goto L_0x01ef
            goto L_0x023b
        L_0x01ef:
            java.lang.String r5 = r0.getLastPathSegment()
            if (r5 != 0) goto L_0x01f8
            kotlin.g.b.k.a()
        L_0x01f8:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r6 = "m3u8"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r6, false)
            if (r5 == 0) goto L_0x021f
            com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory r5 = new com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory
            com.google.android.exoplayer2.f.r r6 = new com.google.android.exoplayer2.f.r
            r6.<init>(r3)
            com.google.android.exoplayer2.f.i$a r6 = (com.google.android.exoplayer2.f.i.a) r6
            r5.<init>((com.google.android.exoplayer2.f.i.a) r6)
            com.google.android.exoplayer2.source.hls.HlsMediaSource r0 = r5.createMediaSource(r0)
            java.lang.String r3 = "HlsMediaSource.Factory(D…  .createMediaSource(uri)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            com.google.android.exoplayer2.source.o r0 = (com.google.android.exoplayer2.source.o) r0
            goto L_0x0252
        L_0x021f:
            com.google.android.exoplayer2.source.dash.DashMediaSource$Factory r5 = new com.google.android.exoplayer2.source.dash.DashMediaSource$Factory
            com.google.android.exoplayer2.f.p r6 = new com.google.android.exoplayer2.f.p
            android.content.Context r7 = r10.getContext()
            r6.<init>(r7, r3)
            com.google.android.exoplayer2.f.i$a r6 = (com.google.android.exoplayer2.f.i.a) r6
            r5.<init>(r6)
            com.google.android.exoplayer2.source.dash.DashMediaSource r0 = r5.createMediaSource(r0)
            java.lang.String r3 = "DashMediaSource.Factory(…)).createMediaSource(uri)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            com.google.android.exoplayer2.source.o r0 = (com.google.android.exoplayer2.source.o) r0
            goto L_0x0252
        L_0x023b:
            com.google.android.exoplayer2.source.r$a r5 = new com.google.android.exoplayer2.source.r$a
            com.google.android.exoplayer2.f.r r6 = new com.google.android.exoplayer2.f.r
            r6.<init>(r3)
            com.google.android.exoplayer2.f.i$a r6 = (com.google.android.exoplayer2.f.i.a) r6
            r5.<init>(r6)
            com.google.android.exoplayer2.source.r r0 = r5.a(r0)
            java.lang.String r3 = "ProgressiveMediaSource.F…  .createMediaSource(uri)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            com.google.android.exoplayer2.source.o r0 = (com.google.android.exoplayer2.source.o) r0
        L_0x0252:
            com.google.android.exoplayer2.ag r3 = r10.s
            if (r3 == 0) goto L_0x0259
            r3.a((com.google.android.exoplayer2.source.o) r0, (boolean) r4, (boolean) r4)
        L_0x0259:
            com.google.android.exoplayer2.ag r0 = r10.s
            if (r0 == 0) goto L_0x0262
            r5 = 0
            r0.a((int) r2, (long) r5)
        L_0x0262:
            r10.c()
            com.google.android.exoplayer2.ag r0 = r10.s
            if (r0 == 0) goto L_0x02a1
            r0.a((boolean) r4)
            goto L_0x02a1
        L_0x026d:
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r5 = "Feeddata not present for storyid="
            r5.concat(r3)
            net.one97.paytm.feed.e.b r3 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.k()
            r10.w = r4
            java.lang.String r3 = "Calling api for Feeddata of storyid="
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x029f }
            r3.concat(r5)     // Catch:{ Exception -> 0x029f }
            net.one97.paytm.feed.e.b r3 = net.one97.paytm.feed.e.b.f34268c     // Catch:{ Exception -> 0x029f }
            net.one97.paytm.feed.e.b.k()     // Catch:{ Exception -> 0x029f }
            net.one97.paytm.feed.repository.a.b r3 = net.one97.paytm.feed.repository.a.b.f34366b     // Catch:{ Exception -> 0x029f }
            android.content.Context r5 = r10.u     // Catch:{ Exception -> 0x029f }
            if (r5 != 0) goto L_0x0294
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x029f }
        L_0x0294:
            net.one97.paytm.feed.ui.feed.story.f$c r6 = new net.one97.paytm.feed.ui.feed.story.f$c     // Catch:{ Exception -> 0x029f }
            r6.<init>(r10, r0)     // Catch:{ Exception -> 0x029f }
            kotlin.g.a.b r6 = (kotlin.g.a.b) r6     // Catch:{ Exception -> 0x029f }
            r3.g(r5, r0, r6)     // Catch:{ Exception -> 0x029f }
            goto L_0x02a1
        L_0x029f:
            r10.w = r2
        L_0x02a1:
            int r0 = r10.t
            int r0 = r0 + r4
            net.one97.paytm.feed.repository.models.stories.Stories r2 = r10.k
            if (r2 != 0) goto L_0x02ab
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x02ab:
            java.util.List r2 = r2.getPostIds()
            int r2 = r2.size()
            if (r2 <= r0) goto L_0x02fa
            kotlin.g.b.x$e r2 = new kotlin.g.b.x$e
            r2.<init>()
            net.one97.paytm.feed.repository.models.stories.Stories r3 = r10.k
            if (r3 != 0) goto L_0x02c1
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x02c1:
            java.util.List r1 = r3.getPostIds()
            java.lang.Object r0 = r1.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r2.element = r0
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            java.util.HashMap r0 = net.one97.paytm.feed.e.b.t()
            T r1 = r2.element
            java.lang.String r1 = (java.lang.String) r1
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x02fa
            net.one97.paytm.feed.repository.a.b r0 = net.one97.paytm.feed.repository.a.b.f34366b     // Catch:{ Exception -> 0x02f5 }
            android.content.Context r1 = r10.u     // Catch:{ Exception -> 0x02f5 }
            if (r1 != 0) goto L_0x02e6
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02f5 }
        L_0x02e6:
            T r3 = r2.element     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x02f5 }
            net.one97.paytm.feed.ui.feed.story.f$j r4 = new net.one97.paytm.feed.ui.feed.story.f$j     // Catch:{ Exception -> 0x02f5 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x02f5 }
            kotlin.g.a.b r4 = (kotlin.g.a.b) r4     // Catch:{ Exception -> 0x02f5 }
            r0.g(r1, r3, r4)     // Catch:{ Exception -> 0x02f5 }
            return
        L_0x02f5:
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.k()
        L_0x02fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.story.f.b():void");
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        "Calling api to update watched story with post::".concat(String.valueOf(str));
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        try {
            net.one97.paytm.feed.repository.a.b bVar2 = net.one97.paytm.feed.repository.a.b.f34366b;
            Context context = this.u;
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.a.b bVar3 = k.INSTANCE;
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(str, "postId");
            kotlin.g.b.k.c(bVar3, "completionHandler");
            String str2 = net.one97.paytm.feed.repository.a.b.f34365a;
            net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
            net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
            String b2 = net.one97.paytm.feed.utility.l.b(context, net.one97.paytm.feed.e.b.h(), "content-recommendation/v1/bloomfilter/viewedPost", (Map<String, ? extends Object>) null);
            String str3 = net.one97.paytm.feed.repository.a.b.f34365a;
            net.one97.paytm.feed.e.b bVar6 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            b.bd bdVar = new b.bd(bVar2, str, b2, bVar3, b2, new b.be(bVar3), new b.bf(bVar3));
            bdVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(context));
            net.one97.paytm.feed.repository.a.a a2 = net.one97.paytm.feed.repository.a.a.f34362b.a(context);
            if (a2 != null) {
                a2.a(bdVar);
            }
        } catch (Exception unused) {
            net.one97.paytm.feed.e.b bVar7 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
        }
    }

    static final class g implements w.c {

        /* renamed from: a  reason: collision with root package name */
        public static final g f35213a = new g();

        g() {
        }

        public final void a(Exception exc) {
            exc.getMessage();
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
        }
    }

    public static final class h implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f35214a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f35215b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f35216c;

        h(f fVar, String str, int i2) {
            this.f35214a = fVar;
            this.f35215b = str;
            this.f35216c = i2;
        }

        public final void onSuccess() {
            this.f35214a.c();
            this.f35214a.a(this.f35215b);
            if (this.f35214a.v && this.f35216c == this.f35214a.t) {
                f fVar = this.f35214a;
                fVar.a(fVar.t, 5000);
            }
        }

        public final void onError(Exception exc) {
            kotlin.g.b.k.c(exc, "e");
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
        }
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.story.f$f  reason: collision with other inner class name */
    public static final class C0585f extends b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f35212a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0585f(f fVar, View view) {
            super(view);
            this.f35212a = fVar;
        }

        public final boolean a(MotionEvent motionEvent) {
            kotlin.g.b.k.c(motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            float x = motionEvent.getX();
            r rVar = r.f35432a;
            if (x <= ((float) ((r.a() * 50) / 100))) {
                f.e(this.f35212a);
                return false;
            }
            f.f(this.f35212a);
            return false;
        }
    }

    static final class d implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f35210a;

        d(x.e eVar) {
            this.f35210a = eVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return !((GestureDetector) this.f35210a.element).onTouchEvent(motionEvent);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f35211a;

        e(f fVar) {
            this.f35211a = fVar;
        }

        public final void onClick(View view) {
            u uVar = u.f35438a;
            if (!u.a()) {
                if (!TextUtils.isEmpty(this.f35211a.o)) {
                    String g2 = this.f35211a.o;
                    Boolean valueOf = g2 != null ? Boolean.valueOf(p.a((CharSequence) g2, (CharSequence) "twitter", true)) : null;
                    if (valueOf == null) {
                        kotlin.g.b.k.a();
                    }
                    if (valueOf.booleanValue()) {
                        FeedWebViewActivity.a aVar = FeedWebViewActivity.f34900a;
                        Context context = this.f35211a.getContext();
                        if (context == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) context, "context!!");
                        String userName = this.f35211a.a().getUser().getUserName();
                        String g3 = this.f35211a.o;
                        if (g3 == null) {
                            kotlin.g.b.k.a();
                        }
                        FeedWebViewActivity.a.a(context, userName, g3, "#1ea1f1", "#1ea1f1");
                        return;
                    }
                    FeedWebViewActivity.a aVar2 = FeedWebViewActivity.f34900a;
                    Context context2 = this.f35211a.getContext();
                    if (context2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) context2, "context!!");
                    String userName2 = this.f35211a.a().getUser().getUserName();
                    String g4 = this.f35211a.o;
                    if (g4 == null) {
                        kotlin.g.b.k.a();
                    }
                    FeedWebViewActivity.a.a(context2, userName2, g4);
                } else if (!TextUtils.isEmpty(this.f35211a.p)) {
                    net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                    kotlin.g.b.k.a((Object) view, "it");
                    Context context3 = view.getContext();
                    kotlin.g.b.k.a((Object) context3, "it.context");
                    String h2 = this.f35211a.p;
                    if (h2 == null) {
                        kotlin.g.b.k.a();
                    }
                    net.one97.paytm.feed.e.b.c(context3, h2);
                }
            }
        }
    }

    public final void onResume() {
        super.onResume();
        this.v = true;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector();
        defaultTrackSelector.a(defaultTrackSelector.a().a());
        this.s = com.google.android.exoplayer2.k.a(getContext(), defaultTrackSelector);
        ag agVar = this.s;
        if (agVar != null) {
            agVar.a(this.y);
        }
        PlayerView playerView = this.j;
        if (playerView == null) {
            kotlin.g.b.k.a("playerView");
        }
        playerView.setPlayer(this.s);
        PlayerView playerView2 = this.j;
        if (playerView2 == null) {
            kotlin.g.b.k.a("playerView");
        }
        playerView2.setResizeMode(0);
        b();
    }

    public final void onPause() {
        super.onPause();
        this.v = false;
        e();
        ag agVar = this.s;
        if (agVar != null) {
            if (agVar != null) {
                agVar.r();
            }
            this.s = null;
        }
    }

    private final void a(Context context, int i2, LinearLayout linearLayout) {
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        Integer num = net.one97.paytm.feed.e.b.s().get(Integer.valueOf(this.r));
        if (num == null) {
            kotlin.g.b.k.a();
        }
        if (num.intValue() >= i2) {
            num = 0;
        }
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            r rVar = r.f35432a;
            float f2 = (float) i2;
            r rVar2 = r.f35432a;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) ((((float) r.a()) - (r.a(16.0f, context) * f2)) / f2), 60);
            r rVar3 = r.f35432a;
            r rVar4 = r.f35432a;
            layoutParams.setMargins((int) r.a(8.0f, context), 0, (int) r.a(8.0f, context), 0);
            for (int i3 = 0; i3 < i2; i3++) {
                View inflate = layoutInflater.inflate(R.layout.coverage_progress_layout, (ViewGroup) null);
                kotlin.g.b.k.a((Object) inflate, "progressView");
                inflate.setLayoutParams(layoutParams);
                if (num.intValue() > i3) {
                    ((ProgressBar) inflate).setProgress(100);
                }
                linearLayout.addView(inflate);
            }
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    private void f() {
        ag agVar = this.s;
        if (agVar != null) {
            agVar.a(false);
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2, int i3) {
        "Started animation for itemNumber=".concat(String.valueOf(i2));
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        LinearLayout linearLayout = this.f35204f;
        if (linearLayout == null) {
            kotlin.g.b.k.a("progresslayout");
        }
        this.f35199a = ObjectAnimator.ofInt(linearLayout.getChildAt(i2), H5Param.PROGRESS, new int[]{0, 100});
        ObjectAnimator objectAnimator = this.f35199a;
        if (objectAnimator == null) {
            kotlin.g.b.k.a();
        }
        objectAnimator.setDuration((long) i3);
        ObjectAnimator objectAnimator2 = this.f35199a;
        if (objectAnimator2 == null) {
            kotlin.g.b.k.a();
        }
        objectAnimator2.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimator3 = this.f35199a;
        if (objectAnimator3 == null) {
            kotlin.g.b.k.a();
        }
        objectAnimator3.addListener(new b(this, i2));
        ObjectAnimator objectAnimator4 = this.f35199a;
        if (objectAnimator4 == null) {
            kotlin.g.b.k.a();
        }
        objectAnimator4.start();
    }

    public static final class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f35208a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f35209b;

        public final void onAnimationRepeat(Animator animator) {
            kotlin.g.b.k.c(animator, "animator");
        }

        b(f fVar, int i2) {
            this.f35208a = fVar;
            this.f35209b = i2;
        }

        public final void onAnimationStart(Animator animator) {
            kotlin.g.b.k.c(animator, "animator");
            this.f35208a.x = false;
        }

        public final void onAnimationEnd(Animator animator) {
            kotlin.g.b.k.c(animator, "animator");
            String unused = this.f35208a.m;
            new StringBuilder("Animation ended for itemnum=").append(this.f35209b);
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            if (!this.f35208a.x) {
                String unused2 = this.f35208a.m;
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                f.f(this.f35208a);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            kotlin.g.b.k.c(animator, "animator");
            String unused = this.f35208a.m;
            new StringBuilder("Cancelling animation for itemnum=").append(this.f35209b);
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            this.f35208a.x = true;
        }
    }

    public final void c() {
        ProgressBar progressBar = this.f35206h;
        if (progressBar == null) {
            kotlin.g.b.k.a("progressBar");
        }
        progressBar.setVisibility(8);
    }

    public final void d() {
        ProgressBar progressBar = this.f35206h;
        if (progressBar == null) {
            kotlin.g.b.k.a("progressBar");
        }
        progressBar.setVisibility(0);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void e() {
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        ObjectAnimator objectAnimator = this.f35199a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public static final /* synthetic */ void e(f fVar) {
        fVar.e();
        fVar.f();
        if (fVar.t > 0) {
            LinearLayout linearLayout = fVar.f35204f;
            if (linearLayout == null) {
                kotlin.g.b.k.a("progresslayout");
            }
            View childAt = linearLayout.getChildAt(fVar.t);
            if (childAt != null) {
                ((ProgressBar) childAt).setProgress(0);
                fVar.t--;
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.s().put(Integer.valueOf(fVar.r), Integer.valueOf(fVar.t));
                fVar.b();
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.ProgressBar");
        }
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        if (fVar.r == 0) {
            fVar.b();
            return;
        }
        FragmentActivity activity = fVar.getActivity();
        if (activity != null) {
            StoryViewActivity storyViewActivity = (StoryViewActivity) activity;
            int i2 = fVar.r;
            storyViewActivity.f35183e = -1;
            ((ci) storyViewActivity.a()).f34052a.postDelayed(new StoryViewActivity.b(storyViewActivity, i2), 100);
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.feed.ui.feed.story.StoryViewActivity");
    }

    public static final /* synthetic */ void f(f fVar) {
        fVar.d();
        fVar.e();
        fVar.f();
        int i2 = fVar.t;
        Stories stories = fVar.k;
        if (stories == null) {
            kotlin.g.b.k.a("story");
        }
        if (i2 < stories.getPostIds().size() - 1) {
            LinearLayout linearLayout = fVar.f35204f;
            if (linearLayout == null) {
                kotlin.g.b.k.a("progresslayout");
            }
            View childAt = linearLayout.getChildAt(fVar.t);
            if (childAt != null) {
                ((ProgressBar) childAt).setProgress(100);
                fVar.t++;
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.s().put(Integer.valueOf(fVar.r), Integer.valueOf(fVar.t));
                fVar.b();
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.ProgressBar");
        }
        fVar.c();
        if (fVar.v) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            FragmentActivity activity = fVar.getActivity();
            if (activity != null) {
                StoryViewActivity storyViewActivity = (StoryViewActivity) activity;
                int i3 = fVar.r;
                ArrayList<Stories> arrayList = storyViewActivity.f35181c;
                if (arrayList == null) {
                    kotlin.g.b.k.a("stories");
                }
                if (i3 >= arrayList.size() - 1) {
                    storyViewActivity.onBackPressed();
                }
                storyViewActivity.f35183e = 1;
                ((ci) storyViewActivity.a()).f34052a.postDelayed(new StoryViewActivity.c(storyViewActivity, i3), 100);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.feed.ui.feed.story.StoryViewActivity");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.z;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
