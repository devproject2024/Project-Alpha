package net.one97.paytm.feed.ui.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.aa;
import net.one97.paytm.feed.b.ag;
import net.one97.paytm.feed.b.ao;
import net.one97.paytm.feed.b.ay;
import net.one97.paytm.feed.b.bw;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.cricket.FeedCricket;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.language.FeedLanguage;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.repository.models.livetv.FeedLiveTV;
import net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant;
import net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFront;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.repository.models.polls.Options;
import net.one97.paytm.feed.repository.models.polls.Polls;
import net.one97.paytm.feed.repository.models.progress.FeedProgress;
import net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedApps;
import net.one97.paytm.feed.repository.models.sheroes.FeedSheroes;
import net.one97.paytm.feed.repository.models.stories.StoryData;
import net.one97.paytm.feed.repository.models.weather.FeedWeather;
import net.one97.paytm.feed.ui.feed.b.d;
import net.one97.paytm.feed.ui.feed.c.b;
import net.one97.paytm.feed.ui.feed.e.a;
import net.one97.paytm.feed.ui.feed.g.a;
import net.one97.paytm.feed.ui.feed.h.b.f;
import net.one97.paytm.feed.ui.feed.m.g;
import net.one97.paytm.feed.ui.feed.p.a;
import net.one97.paytm.feed.utility.r;

public final class c extends RecyclerView.a<RecyclerView.v> implements a.C0579a {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<FeedItem> f35011a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private int f35012b = -1;

    /* renamed from: c  reason: collision with root package name */
    private a f35013c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f35014d;

    /* renamed from: e  reason: collision with root package name */
    private final net.one97.paytm.feed.ui.feed.e.b f35015e;

    public interface a {
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
    }

    public c(Context context, net.one97.paytm.feed.ui.feed.e.b bVar) {
        k.c(context, "context");
        k.c(bVar, "feedFragment");
        this.f35014d = context;
        this.f35015e = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0285  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.recyclerview.widget.RecyclerView.v onCreateViewHolder(android.view.ViewGroup r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "parent"
            kotlin.g.b.k.c(r5, r0)
            android.content.Context r0 = r5.getContext()
            com.google.android.play.core.splitcompat.a.a((android.content.Context) r0)
            android.content.Context r0 = r5.getContext()
            com.google.android.play.core.splitcompat.a.b((android.content.Context) r0)
            android.content.Context r0 = r4.f35014d
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r1 = 2
            java.lang.String r2 = "view"
            r3 = 0
            if (r6 == r1) goto L_0x0268
            r1 = 3
            if (r6 == r1) goto L_0x024f
            r1 = 5
            if (r6 == r1) goto L_0x0236
            r1 = 7
            if (r6 == r1) goto L_0x021d
            r1 = 9
            if (r6 == r1) goto L_0x0204
            r1 = 11
            if (r6 == r1) goto L_0x01ea
            r1 = 13
            if (r6 == r1) goto L_0x01d0
            r1 = 20
            if (r6 == r1) goto L_0x01b6
            switch(r6) {
                case 22: goto L_0x019c;
                case 23: goto L_0x0182;
                case 24: goto L_0x0168;
                case 25: goto L_0x014e;
                case 26: goto L_0x0134;
                case 27: goto L_0x0115;
                case 28: goto L_0x00fb;
                case 29: goto L_0x00e1;
                case 30: goto L_0x00c7;
                case 31: goto L_0x00ad;
                case 32: goto L_0x0093;
                case 33: goto L_0x0079;
                case 34: goto L_0x005c;
                case 35: goto L_0x0040;
                default: goto L_0x003c;
            }
        L_0x003c:
            r5 = 0
        L_0x003d:
            r6 = r5
            goto L_0x0283
        L_0x0040:
            if (r0 != 0) goto L_0x0045
            kotlin.g.b.k.a()
        L_0x0045:
            int r6 = net.one97.paytm.feed.R.layout.feed_greeting
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.e.a r6 = new net.one97.paytm.feed.ui.feed.e.a
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            net.one97.paytm.feed.ui.feed.e.b r0 = r4.f35015e
            r6.<init>(r5, r0)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x005c:
            if (r0 != 0) goto L_0x0061
            kotlin.g.b.k.a()
        L_0x0061:
            int r6 = net.one97.paytm.feed.R.layout.feed_language
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.g.a r6 = new net.one97.paytm.feed.ui.feed.g.a
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r0 = r4
            net.one97.paytm.feed.ui.feed.g.a$a r0 = (net.one97.paytm.feed.ui.feed.g.a.C0579a) r0
            r6.<init>(r5, r0)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x0079:
            if (r0 != 0) goto L_0x007e
            kotlin.g.b.k.a()
        L_0x007e:
            int r6 = net.one97.paytm.feed.R.layout.feed_topvideo
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.n.a r6 = new net.one97.paytm.feed.ui.feed.n.a
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x0093:
            if (r0 != 0) goto L_0x0098
            kotlin.g.b.k.a()
        L_0x0098:
            int r6 = net.one97.paytm.feed.R.layout.feed_publisher
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.k.a r6 = new net.one97.paytm.feed.ui.feed.k.a
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x00ad:
            if (r0 != 0) goto L_0x00b2
            kotlin.g.b.k.a()
        L_0x00b2:
            int r6 = net.one97.paytm.feed.R.layout.feed_banner
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.j.a r6 = new net.one97.paytm.feed.ui.feed.j.a
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x00c7:
            if (r0 != 0) goto L_0x00cc
            kotlin.g.b.k.a()
        L_0x00cc:
            int r6 = net.one97.paytm.feed.R.layout.feed_polls
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.i.b r6 = new net.one97.paytm.feed.ui.feed.i.b
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x00e1:
            if (r0 != 0) goto L_0x00e6
            kotlin.g.b.k.a()
        L_0x00e6:
            int r6 = net.one97.paytm.feed.R.layout.feed_banner
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.a.c r6 = new net.one97.paytm.feed.ui.feed.a.c
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x00fb:
            if (r0 != 0) goto L_0x0100
            kotlin.g.b.k.a()
        L_0x0100:
            int r6 = net.one97.paytm.feed.R.layout.feed_stories
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.story.c r6 = new net.one97.paytm.feed.ui.feed.story.c
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x0115:
            if (r0 != 0) goto L_0x011a
            kotlin.g.b.k.a()
        L_0x011a:
            int r6 = net.one97.paytm.feed.R.layout.feed_coverage
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.b.d r6 = new net.one97.paytm.feed.ui.feed.b.d
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r0 = r6
            net.one97.paytm.feed.ui.feed.c$a r0 = (net.one97.paytm.feed.ui.feed.c.a) r0
            r4.f35013c = r0
            r5.setTag(r6)
            goto L_0x0283
        L_0x0134:
            if (r0 != 0) goto L_0x0139
            kotlin.g.b.k.a()
        L_0x0139:
            int r6 = net.one97.paytm.feed.R.layout.feed_highlights
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.f.a r6 = new net.one97.paytm.feed.ui.feed.f.a
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x014e:
            if (r0 != 0) goto L_0x0153
            kotlin.g.b.k.a()
        L_0x0153:
            int r6 = net.one97.paytm.feed.R.layout.feed_weather
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.p.a r6 = new net.one97.paytm.feed.ui.feed.p.a
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x0168:
            if (r0 != 0) goto L_0x016d
            kotlin.g.b.k.a()
        L_0x016d:
            int r6 = net.one97.paytm.feed.R.layout.feed_recommendedposts_2
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.m.g r6 = new net.one97.paytm.feed.ui.feed.m.g
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x0182:
            if (r0 != 0) goto L_0x0187
            kotlin.g.b.k.a()
        L_0x0187:
            int r6 = net.one97.paytm.feed.R.layout.feed_recommendedposts_1
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.m.f r6 = new net.one97.paytm.feed.ui.feed.m.f
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x019c:
            if (r0 != 0) goto L_0x01a1
            kotlin.g.b.k.a()
        L_0x01a1:
            int r6 = net.one97.paytm.feed.R.layout.feed_recommendedapps_v2
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.l.c r6 = new net.one97.paytm.feed.ui.feed.l.c
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x01b6:
            if (r0 != 0) goto L_0x01bb
            kotlin.g.b.k.a()
        L_0x01bb:
            int r6 = net.one97.paytm.feed.R.layout.feed_generic
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.d.c r6 = new net.one97.paytm.feed.ui.feed.d.c
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x01d0:
            if (r0 != 0) goto L_0x01d5
            kotlin.g.b.k.a()
        L_0x01d5:
            int r6 = net.one97.paytm.feed.R.layout.feed_cricket_score
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.c.a r6 = new net.one97.paytm.feed.ui.feed.c.a
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x01ea:
            if (r0 != 0) goto L_0x01ef
            kotlin.g.b.k.a()
        L_0x01ef:
            int r6 = net.one97.paytm.feed.R.layout.feed_progress
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.h r6 = new net.one97.paytm.feed.ui.feed.h
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x0204:
            if (r0 != 0) goto L_0x0209
            kotlin.g.b.k.a()
        L_0x0209:
            int r6 = net.one97.paytm.feed.R.layout.feed_merchant
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.h.a.c r6 = new net.one97.paytm.feed.ui.feed.h.a.c
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x021d:
            if (r0 != 0) goto L_0x0222
            kotlin.g.b.k.a()
        L_0x0222:
            int r6 = net.one97.paytm.feed.R.layout.feed_merchant_storefront
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.h.b.f r6 = new net.one97.paytm.feed.ui.feed.h.b.f
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x0236:
            if (r0 != 0) goto L_0x023b
            kotlin.g.b.k.a()
        L_0x023b:
            int r6 = net.one97.paytm.feed.R.layout.feed_sheroes
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.sheroes.c r6 = new net.one97.paytm.feed.ui.feed.sheroes.c
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x024f:
            if (r0 != 0) goto L_0x0254
            kotlin.g.b.k.a()
        L_0x0254:
            int r6 = net.one97.paytm.feed.R.layout.feed_livetv
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.livetv.b r6 = new net.one97.paytm.feed.ui.feed.livetv.b
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            r5.setTag(r6)
            goto L_0x0283
        L_0x0268:
            if (r0 != 0) goto L_0x026d
            kotlin.g.b.k.a()
        L_0x026d:
            int r6 = net.one97.paytm.feed.R.layout.feed_video
            android.view.View r6 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.d.a.a r0 = new net.one97.paytm.feed.ui.feed.d.a.a
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            r0.<init>(r5, r6)
            r5 = r0
            androidx.recyclerview.widget.RecyclerView$v r5 = (androidx.recyclerview.widget.RecyclerView.v) r5
            r6.setTag(r5)
            goto L_0x003d
        L_0x0283:
            if (r6 != 0) goto L_0x028b
            java.lang.String r5 = "viewViewHolder"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x028b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.c.onCreateViewHolder(android.view.ViewGroup, int):androidx.recyclerview.widget.RecyclerView$v");
    }

    public final int getItemCount() {
        return this.f35011a.size();
    }

    public final long getItemId(int i2) {
        return (long) this.f35011a.get(i2).getPid().hashCode();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2, List<Object> list) {
        RecyclerView recyclerView;
        k.c(vVar, "holder");
        k.c(list, "payloads");
        if (list.isEmpty()) {
            String feedItemType = this.f35011a.get(i2).getFeedItemType();
            if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType())) {
                net.one97.paytm.feed.ui.feed.d.c cVar = (net.one97.paytm.feed.ui.feed.d.c) vVar;
                FeedItem feedItem = this.f35011a.get(i2);
                if (feedItem != null) {
                    cVar.a(new net.one97.paytm.feed.ui.feed.d.a((FeedGeneric) feedItem), i2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType())) {
                net.one97.paytm.feed.ui.feed.d.a.a aVar = (net.one97.paytm.feed.ui.feed.d.a.a) vVar;
                FeedItem feedItem2 = this.f35011a.get(i2);
                if (feedItem2 != null) {
                    aVar.a(new net.one97.paytm.feed.ui.feed.d.a((FeedGeneric) feedItem2), i2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.LIVETV.getType())) {
                net.one97.paytm.feed.ui.feed.livetv.b bVar = (net.one97.paytm.feed.ui.feed.livetv.b) vVar;
                FeedItem feedItem3 = this.f35011a.get(i2);
                if (feedItem3 != null) {
                    FeedLiveTV feedLiveTV = (FeedLiveTV) feedItem3;
                    k.c(feedLiveTV, "data");
                    ao aoVar = (ao) bVar.f34872a;
                    if (bVar.f35107b == null) {
                        bVar.f35107b = new net.one97.paytm.feed.ui.feed.livetv.a();
                        aoVar.setVariable(net.one97.paytm.feed.a.f33775b, bVar.f35107b);
                    }
                    for (Map.Entry entry : new HashMap().entrySet()) {
                        aoVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
                    }
                    net.one97.paytm.feed.ui.feed.livetv.c cVar2 = bVar.f35108c;
                    if (cVar2 != null) {
                        k.c(feedLiveTV, "data");
                        cVar2.f35110a.clear();
                        ArrayList<Channel> arrayList = cVar2.f35110a;
                        List<Channel> channels = feedLiveTV.getFeedLiveTVData().getChannels();
                        if (channels == null) {
                            k.a();
                        }
                        arrayList.addAll(channels);
                        cVar2.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.livetv.FeedLiveTV");
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.SHEROES.getType())) {
                net.one97.paytm.feed.ui.feed.sheroes.c cVar3 = (net.one97.paytm.feed.ui.feed.sheroes.c) vVar;
                FeedItem feedItem4 = this.f35011a.get(i2);
                if (feedItem4 != null) {
                    cVar3.a((FeedSheroes) feedItem4, i2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.sheroes.FeedSheroes");
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.MERCHANTSTOREFRONT.getType())) {
                f fVar = (f) vVar;
                FeedItem feedItem5 = this.f35011a.get(i2);
                if (feedItem5 != null) {
                    fVar.a((FeedMerchantStoreFront) feedItem5, i2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFront");
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.MERCHANTDEAL.getType())) {
                net.one97.paytm.feed.ui.feed.h.a.c cVar4 = (net.one97.paytm.feed.ui.feed.h.a.c) vVar;
                FeedItem feedItem6 = this.f35011a.get(i2);
                if (feedItem6 != null) {
                    cVar4.a(new net.one97.paytm.feed.ui.feed.h.a.a((FeedMerchant) feedItem6), i2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant");
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.BANNERS.getType())) {
                net.one97.paytm.feed.ui.feed.a.c cVar5 = (net.one97.paytm.feed.ui.feed.a.c) vVar;
                FeedItem feedItem7 = this.f35011a.get(i2);
                if (feedItem7 != null) {
                    cVar5.a((NestedFeed) feedItem7);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed");
            } else {
                if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.POLLS.getType())) {
                    net.one97.paytm.feed.ui.feed.i.b bVar2 = (net.one97.paytm.feed.ui.feed.i.b) vVar;
                    FeedItem feedItem8 = this.f35011a.get(i2);
                    if (feedItem8 != null) {
                        net.one97.paytm.feed.ui.feed.i.c cVar6 = new net.one97.paytm.feed.ui.feed.i.c((Polls) feedItem8);
                        k.c(cVar6, "viewModel");
                        ay ayVar = (ay) bVar2.f34872a;
                        ayVar.setVariable(net.one97.paytm.feed.a.f33780g, cVar6.f35079b);
                        ayVar.setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
                        ayVar.setVariable(net.one97.paytm.feed.a.f33777d, cVar6);
                        ayVar.setVariable(net.one97.paytm.feed.a.f33775b, new net.one97.paytm.feed.ui.feed.i.a(cVar6, bVar2));
                        bVar2.f35075b = cVar6.f35079b.getPollsList().get(0).getId();
                        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                        String str = bVar2.f35075b;
                        if (str == null) {
                            k.a("pollsId");
                        }
                        List<Options> c2 = net.one97.paytm.feed.e.b.c(str);
                        if (c2 != null) {
                            cVar6.a();
                            Context context = bVar2.f35076c.getContext();
                            k.a((Object) context, "view.context");
                            bVar2.a(context, c2);
                        } else if (cVar6.f35078a) {
                            Context context2 = bVar2.f35076c.getContext();
                            k.a((Object) context2, "view.context");
                            bVar2.a(context2, cVar6.f35079b.getPollsList().get(0).getOptions());
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.polls.Polls");
                    }
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.POSTER.getType())) {
                    net.one97.paytm.feed.ui.feed.j.a aVar2 = (net.one97.paytm.feed.ui.feed.j.a) vVar;
                    FeedItem feedItem9 = this.f35011a.get(i2);
                    if (feedItem9 != null) {
                        aVar2.a((NestedFeed) feedItem9);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.PROGRESS.getType())) {
                    h hVar = (h) vVar;
                    FeedItem feedItem10 = this.f35011a.get(i2);
                    if (feedItem10 != null) {
                        hVar.a((FeedProgress) feedItem10);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.progress.FeedProgress");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.SCORECARD.getType())) {
                    net.one97.paytm.feed.ui.feed.c.a aVar3 = (net.one97.paytm.feed.ui.feed.c.a) vVar;
                    FeedItem feedItem11 = this.f35011a.get(i2);
                    if (feedItem11 != null) {
                        aVar3.a(new b((FeedCricket) feedItem11), i2);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.cricket.FeedCricket");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDAPPS.getType())) {
                    net.one97.paytm.feed.ui.feed.l.b bVar4 = (net.one97.paytm.feed.ui.feed.l.b) vVar;
                    FeedItem feedItem12 = this.f35011a.get(i2);
                    if (feedItem12 != null) {
                        bVar4.a((FeedRecommendedApps) feedItem12);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedApps");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDAPPS_2.getType())) {
                    net.one97.paytm.feed.ui.feed.l.c cVar7 = (net.one97.paytm.feed.ui.feed.l.c) vVar;
                    FeedItem feedItem13 = this.f35011a.get(i2);
                    if (feedItem13 != null) {
                        cVar7.a((FeedRecommendedApps) feedItem13);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedApps");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS_2.getType())) {
                    g gVar = (g) vVar;
                    FeedItem feedItem14 = this.f35011a.get(i2);
                    if (feedItem14 != null) {
                        gVar.a((NestedFeed) feedItem14);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS.getType())) {
                    net.one97.paytm.feed.ui.feed.m.f fVar2 = (net.one97.paytm.feed.ui.feed.m.f) vVar;
                    FeedItem feedItem15 = this.f35011a.get(i2);
                    if (feedItem15 != null) {
                        NestedFeed nestedFeed = (NestedFeed) feedItem15;
                        k.c(nestedFeed, "data");
                        ((bw) fVar2.f34872a).setVariable(net.one97.paytm.feed.a.f33779f, nestedFeed.getNestedFeedData().getTitle());
                        net.one97.paytm.feed.ui.feed.m.c cVar8 = fVar2.f35150b;
                        if (cVar8 != null) {
                            k.c(nestedFeed, "data");
                            cVar8.f35147b.clear();
                            cVar8.f35146a = nestedFeed;
                            ArrayList<FeedGeneric> arrayList2 = cVar8.f35147b;
                            List<FeedGeneric> genericPostList = nestedFeed.getNestedFeedData().getGenericPostList();
                            if (genericPostList == null) {
                                k.a();
                            }
                            arrayList2.addAll(genericPostList);
                            cVar8.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.WEATHERCARD.getType())) {
                    net.one97.paytm.feed.ui.feed.p.a aVar4 = (net.one97.paytm.feed.ui.feed.p.a) vVar;
                    FeedItem feedItem16 = this.f35011a.get(i2);
                    if (feedItem16 != null) {
                        FeedWeather feedWeather = (FeedWeather) feedItem16;
                        k.c(feedWeather, "data");
                        if (!aVar4.f35172b) {
                            net.one97.paytm.feed.repository.a.b bVar5 = net.one97.paytm.feed.repository.a.b.f34366b;
                            Context context3 = aVar4.f35173c.getContext();
                            k.a((Object) context3, "view.context");
                            bVar5.f(context3, feedWeather.getFeedWeatherData().getDataUrl(), new a.C0584a(aVar4));
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.weather.FeedWeather");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GREETING.getType())) {
                    net.one97.paytm.feed.ui.feed.e.a aVar5 = (net.one97.paytm.feed.ui.feed.e.a) vVar;
                    FeedItem feedItem17 = this.f35011a.get(i2);
                    if (feedItem17 != null) {
                        FeedWeather feedWeather2 = (FeedWeather) feedItem17;
                        k.c(feedWeather2, "data");
                        if (aVar5.f35043d.j()) {
                            FrameLayout frameLayout = ((aa) aVar5.f34872a).f33804a;
                            k.a((Object) frameLayout, "dataBinding.askLocationBar");
                            frameLayout.setVisibility(8);
                            net.one97.paytm.feed.e.c cVar9 = net.one97.paytm.feed.e.c.f34275a;
                            if (net.one97.paytm.feed.e.c.e() != null) {
                                net.one97.paytm.feed.e.c cVar10 = net.one97.paytm.feed.e.c.f34275a;
                                if (!k.a(net.one97.paytm.feed.e.c.e())) {
                                    net.one97.paytm.feed.e.c cVar11 = net.one97.paytm.feed.e.c.f34275a;
                                    if (net.one97.paytm.feed.e.c.f() != null) {
                                        net.one97.paytm.feed.e.c cVar12 = net.one97.paytm.feed.e.c.f34275a;
                                        if (!k.a(net.one97.paytm.feed.e.c.f())) {
                                            if (!aVar5.f35041b) {
                                                net.one97.paytm.feed.e.b bVar6 = net.one97.paytm.feed.e.b.f34268c;
                                                if (net.one97.paytm.feed.e.b.C()) {
                                                    net.one97.paytm.feed.repository.a.b bVar7 = net.one97.paytm.feed.repository.a.b.f34366b;
                                                    Context context4 = aVar5.f35042c.getContext();
                                                    k.a((Object) context4, "view.context");
                                                    bVar7.f(context4, feedWeather2.getFeedWeatherData().getDataUrl(), new a.b(aVar5));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            aVar5.f35043d.a(i2);
                        } else {
                            FrameLayout frameLayout2 = ((aa) aVar5.f34872a).f33804a;
                            k.a((Object) frameLayout2, "dataBinding.askLocationBar");
                            frameLayout2.setVisibility(0);
                            ((aa) aVar5.f34872a).f33804a.setOnClickListener(new a.C0578a(aVar5, i2));
                            ((aa) aVar5.f34872a).f33807d.setText("Max _ _  / Min _ _");
                        }
                        TextView textView = ((aa) aVar5.f34872a).f33810g;
                        k.a((Object) textView, "dataBinding.helloUser");
                        net.one97.paytm.feed.e.c cVar13 = net.one97.paytm.feed.e.c.f34275a;
                        textView.setText(net.one97.paytm.feed.e.c.a());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.weather.FeedWeather");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.HIGHLIGHTS.getType())) {
                    net.one97.paytm.feed.ui.feed.f.a aVar6 = (net.one97.paytm.feed.ui.feed.f.a) vVar;
                    FeedItem feedItem18 = this.f35011a.get(i2);
                    if (feedItem18 != null) {
                        aVar6.a((FeedGeneric) feedItem18, i2);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.COVERAGE.getType())) {
                    d dVar = (d) vVar;
                    FeedItem feedItem19 = this.f35011a.get(i2);
                    if (feedItem19 != null) {
                        NestedFeed nestedFeed2 = (NestedFeed) feedItem19;
                        k.c(nestedFeed2, "data");
                        List<FeedGeneric> genericPostList2 = nestedFeed2.getNestedFeedData().getGenericPostList();
                        if (genericPostList2 == null) {
                            k.a();
                        }
                        if (genericPostList2.isEmpty()) {
                            net.one97.paytm.feed.ui.feed.b.a aVar7 = dVar.f35008i;
                            if (aVar7 == null) {
                                k.a();
                            }
                            aVar7.a(nestedFeed2.getNestedFeedData());
                            dVar.f35002c.removeAllViews();
                            return;
                        }
                        dVar.f35002c.removeAllViews();
                        Object systemService = dVar.j.getContext().getSystemService("layout_inflater");
                        if (systemService != null) {
                            LayoutInflater layoutInflater = (LayoutInflater) systemService;
                            r rVar = r.f35432a;
                            float a2 = (float) r.a();
                            List<FeedGeneric> genericPostList3 = nestedFeed2.getNestedFeedData().getGenericPostList();
                            if (genericPostList3 == null) {
                                k.a();
                            }
                            r rVar2 = r.f35432a;
                            Context context5 = dVar.j.getContext();
                            k.a((Object) context5, "view.context");
                            float size = a2 - (((float) (genericPostList3.size() + 2)) * r.a(16.0f, context5));
                            List<FeedGeneric> genericPostList4 = nestedFeed2.getNestedFeedData().getGenericPostList();
                            if (genericPostList4 == null) {
                                k.a();
                            }
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (size / ((float) genericPostList4.size())), 60);
                            r rVar3 = r.f35432a;
                            Context context6 = dVar.j.getContext();
                            k.a((Object) context6, "view.context");
                            r rVar4 = r.f35432a;
                            Context context7 = dVar.j.getContext();
                            k.a((Object) context7, "view.context");
                            layoutParams.setMargins((int) r.a(8.0f, context6), 0, (int) r.a(8.0f, context7), 0);
                            List<FeedGeneric> genericPostList5 = nestedFeed2.getNestedFeedData().getGenericPostList();
                            if (genericPostList5 == null) {
                                k.a();
                            }
                            int size2 = genericPostList5.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                com.google.android.play.core.splitcompat.a.a(dVar.j.getContext());
                                View inflate = layoutInflater.inflate(R.layout.coverage_progress_layout, (ViewGroup) null);
                                k.a((Object) inflate, "progressView");
                                inflate.setLayoutParams(layoutParams);
                                if (dVar.f35006g.contains(Integer.valueOf(i3))) {
                                    ((ProgressBar) inflate).setProgress(100);
                                }
                                dVar.f35002c.addView(inflate);
                            }
                            dVar.f35004e = true;
                            if (!dVar.f35006g.empty() && (recyclerView = dVar.f35007h) != null) {
                                Integer peek = dVar.f35006g.peek();
                                k.a((Object) peek, "postionStack.peek()");
                                recyclerView.scrollToPosition(peek.intValue());
                            }
                            net.one97.paytm.feed.ui.feed.b.a aVar8 = dVar.f35008i;
                            if (aVar8 == null) {
                                k.a();
                            }
                            aVar8.a(nestedFeed2.getNestedFeedData());
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.STORIES.getType())) {
                    net.one97.paytm.feed.ui.feed.story.c cVar14 = (net.one97.paytm.feed.ui.feed.story.c) vVar;
                    net.one97.paytm.feed.e.b bVar8 = net.one97.paytm.feed.e.b.f34268c;
                    FeedItem feedItem20 = this.f35011a.get(i2);
                    if (feedItem20 != null) {
                        StoryData a3 = net.one97.paytm.feed.e.b.a((StoryData) feedItem20);
                        k.c(a3, "data");
                        net.one97.paytm.feed.ui.feed.story.d dVar2 = cVar14.f35191b;
                        if (dVar2 != null) {
                            k.c(a3, "data");
                            dVar2.f35196b = Integer.valueOf(i2);
                            dVar2.f35197c.clear();
                            dVar2.f35195a = a3;
                            dVar2.f35197c.addAll(a3.getStoryList());
                            dVar2.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.stories.StoryData");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.PUBLISHER.getType())) {
                    net.one97.paytm.feed.ui.feed.k.a aVar9 = (net.one97.paytm.feed.ui.feed.k.a) vVar;
                    FeedItem feedItem21 = this.f35011a.get(i2);
                    if (feedItem21 != null) {
                        aVar9.a((NestedFeed) feedItem21);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.TOPVIDEOS.getType())) {
                    net.one97.paytm.feed.ui.feed.n.a aVar10 = (net.one97.paytm.feed.ui.feed.n.a) vVar;
                    FeedItem feedItem22 = this.f35011a.get(i2);
                    if (feedItem22 != null) {
                        aVar10.a((NestedFeed) feedItem22);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed");
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.LANGUAGE.getType())) {
                    net.one97.paytm.feed.ui.feed.g.a aVar11 = (net.one97.paytm.feed.ui.feed.g.a) vVar;
                    FeedItem feedItem23 = this.f35011a.get(i2);
                    if (feedItem23 != null) {
                        FeedLanguage feedLanguage = (FeedLanguage) feedItem23;
                        k.c(feedLanguage, "data");
                        if (aVar11.f35054c == null) {
                            aVar11.f35054c = new net.one97.paytm.feed.ui.feed.g.c();
                            ((ag) aVar11.f34872a).setVariable(net.one97.paytm.feed.a.f33775b, aVar11.f35054c);
                        }
                        ((ag) aVar11.f34872a).setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
                        ((ag) aVar11.f34872a).setVariable(net.one97.paytm.feed.a.f33780g, feedLanguage.getPid());
                        ((ag) aVar11.f34872a).setVariable(net.one97.paytm.feed.a.j, aVar11.f35055d);
                        net.one97.paytm.feed.ui.feed.g.b bVar9 = aVar11.f35053b;
                        if (bVar9 != null) {
                            List<FeedLanguageData> languages = feedLanguage.getLanguages();
                            k.c(languages, "data");
                            bVar9.f35059a.clear();
                            bVar9.f35059a.addAll(languages);
                            bVar9.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.language.FeedLanguage");
                }
            }
        } else {
            Iterator<Object> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next();
                if (vVar instanceof net.one97.paytm.feed.ui.feed.d.c) {
                    net.one97.paytm.feed.ui.feed.d.c cVar15 = (net.one97.paytm.feed.ui.feed.d.c) vVar;
                    FeedItem feedItem24 = this.f35011a.get(i2);
                    if (feedItem24 != null) {
                        cVar15.a(new net.one97.paytm.feed.ui.feed.d.a((FeedGeneric) feedItem24), i2);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                    }
                } else if (vVar instanceof net.one97.paytm.feed.ui.feed.d.a.a) {
                    net.one97.paytm.feed.ui.feed.d.a.a aVar12 = (net.one97.paytm.feed.ui.feed.d.a.a) vVar;
                    FeedItem feedItem25 = this.f35011a.get(i2);
                    if (feedItem25 != null) {
                        aVar12.a(new net.one97.paytm.feed.ui.feed.d.a((FeedGeneric) feedItem25), i2);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                    }
                } else if (vVar instanceof net.one97.paytm.feed.ui.feed.h.a.c) {
                    net.one97.paytm.feed.ui.feed.h.a.c cVar16 = (net.one97.paytm.feed.ui.feed.h.a.c) vVar;
                    FeedItem feedItem26 = this.f35011a.get(i2);
                    if (feedItem26 != null) {
                        cVar16.a(new net.one97.paytm.feed.ui.feed.h.a.a((FeedMerchant) feedItem26), i2);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public final int getItemViewType(int i2) {
        b.a aVar = b.f35021a;
        String feedItemType = this.f35011a.get(i2).getFeedItemType();
        if (feedItemType == null) {
            k.a();
        }
        return b.a.a(feedItemType);
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.c$c  reason: collision with other inner class name */
    public static final class C0575c extends h.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f35023a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f35024b;

        C0575c(c cVar, ArrayList arrayList) {
            this.f35023a = cVar;
            this.f35024b = arrayList;
        }

        public final int getOldListSize() {
            return this.f35023a.f35011a.size();
        }

        public final int getNewListSize() {
            return this.f35024b.size();
        }

        public final boolean areItemsTheSame(int i2, int i3) {
            return ((FeedItem) this.f35024b.get(i3)).getPid().equals(this.f35023a.f35011a.get(i2).getPid());
        }

        public final boolean areContentsTheSame(int i2, int i3) {
            boolean z;
            boolean z2;
            int i4;
            int i5;
            int i6;
            boolean z3;
            boolean z4;
            int i7;
            int i8;
            int i9;
            String feedItemType = this.f35023a.f35011a.get(i2).getFeedItemType();
            if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType())) {
                FeedItem feedItem = this.f35023a.f35011a.get(i2);
                k.a((Object) feedItem, "feedList[oldItemPosition]");
                FeedItem feedItem2 = feedItem;
                if (feedItem2 != null) {
                    FeedGeneric feedGeneric = (FeedGeneric) feedItem2;
                    Integer likeCount = feedGeneric.getFeedGenericData().getLikeCount();
                    if (likeCount == null) {
                        k.a();
                    }
                    i6 = likeCount.intValue();
                    Integer shareCount = feedGeneric.getFeedGenericData().getShareCount();
                    if (shareCount == null) {
                        k.a();
                    }
                    i5 = shareCount.intValue();
                    Integer commentCount = feedGeneric.getFeedGenericData().getCommentCount();
                    if (commentCount == null) {
                        k.a();
                    }
                    i4 = commentCount.intValue();
                    boolean isFollowed = feedGeneric.getFeedGenericData().isFollowed();
                    z2 = feedGeneric.getFeedGenericData().isBookmarked();
                    z = isFollowed;
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                }
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.LIVETV.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.CATEGORY.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GAMEPIND.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.SHEROES.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.MERCHANTSTOREFRONT.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.LANGUAGE.getType())) {
                return true;
            } else {
                if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.MERCHANTDEAL.getType())) {
                    FeedItem feedItem3 = this.f35023a.f35011a.get(i2);
                    k.a((Object) feedItem3, "feedList[oldItemPosition]");
                    FeedItem feedItem4 = feedItem3;
                    if (feedItem4 != null) {
                        FeedMerchant feedMerchant = (FeedMerchant) feedItem4;
                        i6 = feedMerchant.getFeedMerchantData().getLikeCount();
                        i5 = feedMerchant.getFeedMerchantData().getShareCount();
                        z = feedMerchant.getFeedMerchantData().isFollowed();
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant");
                    }
                } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.SCORECARD.getType())) {
                    return true;
                } else {
                    z = false;
                    i6 = 0;
                    i5 = 0;
                }
                i4 = 0;
                z2 = false;
            }
            String feedItemType2 = ((FeedItem) this.f35024b.get(i3)).getFeedItemType();
            if (k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType()) || k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType())) {
                Object obj = this.f35024b.get(i3);
                k.a(obj, "list[newItemPosition]");
                FeedItem feedItem5 = (FeedItem) obj;
                if (feedItem5 != null) {
                    FeedGeneric feedGeneric2 = (FeedGeneric) feedItem5;
                    Integer likeCount2 = feedGeneric2.getFeedGenericData().getLikeCount();
                    if (likeCount2 == null) {
                        k.a();
                    }
                    i9 = likeCount2.intValue();
                    Integer shareCount2 = feedGeneric2.getFeedGenericData().getShareCount();
                    if (shareCount2 == null) {
                        k.a();
                    }
                    i8 = shareCount2.intValue();
                    Integer commentCount2 = feedGeneric2.getFeedGenericData().getCommentCount();
                    if (commentCount2 == null) {
                        k.a();
                    }
                    i7 = commentCount2.intValue();
                    boolean isFollowed2 = feedGeneric2.getFeedGenericData().isFollowed();
                    z4 = feedGeneric2.getFeedGenericData().isBookmarked();
                    z3 = isFollowed2;
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                }
            } else if (k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.LIVETV.getType()) || k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.CATEGORY.getType()) || k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.GAMEPIND.getType()) || k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.SHEROES.getType()) || k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.MERCHANTSTOREFRONT.getType()) || k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.LANGUAGE.getType())) {
                return true;
            } else {
                if (k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.MERCHANTDEAL.getType())) {
                    Object obj2 = this.f35024b.get(i3);
                    k.a(obj2, "list[newItemPosition]");
                    FeedItem feedItem6 = (FeedItem) obj2;
                    if (feedItem6 != null) {
                        FeedMerchant feedMerchant2 = (FeedMerchant) feedItem6;
                        i9 = feedMerchant2.getFeedMerchantData().getLikeCount();
                        i8 = feedMerchant2.getFeedMerchantData().getShareCount();
                        z3 = feedMerchant2.getFeedMerchantData().isFollowed();
                        i4 = 0;
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant");
                    }
                } else if (k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.SCORECARD.getType())) {
                    return true;
                } else {
                    z3 = false;
                    i9 = 0;
                    i8 = 0;
                }
                i7 = 0;
                z4 = false;
            }
            return i4 == i7 && i6 == i9 && i5 == i8 && z == z3 && z2 == z4;
        }

        public final Object getChangePayload(int i2, int i3) {
            return this.f35024b.get(i3);
        }
    }

    public final void a() {
        if (this.f35011a.size() > 0) {
            ArrayList<FeedItem> arrayList = this.f35011a;
            if (arrayList.get(arrayList.size() - 1) instanceof FeedProgress) {
                ArrayList<FeedItem> arrayList2 = this.f35011a;
                arrayList2.remove(arrayList2.size() - 1);
                notifyItemRemoved(this.f35011a.size());
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f35021a = new a((byte) 0);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            public static int a(String str) {
                k.c(str, "type");
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.NEWS.getType())) {
                    return 1;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType())) {
                    return 2;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.LIVETV.getType())) {
                    return 3;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.CATEGORY.getType())) {
                    return 0;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.SHEROES.getType())) {
                    return 5;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.MERCHANTSTOREFRONT.getType())) {
                    return 7;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.MERCHANTDEAL.getType())) {
                    return 9;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.COMMENTS.getType())) {
                    return 10;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.PROGRESS.getType())) {
                    return 11;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.SCORECARD.getType())) {
                    return 13;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType())) {
                    return 20;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDAPPS.getType())) {
                    return 21;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDAPPS_2.getType())) {
                    return 22;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS.getType())) {
                    return 23;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS_2.getType())) {
                    return 24;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.WEATHERCARD.getType())) {
                    return 25;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.COVERAGE.getType())) {
                    return 27;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.HIGHLIGHTS.getType())) {
                    return 26;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.STORIES.getType())) {
                    return 28;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.BANNERS.getType())) {
                    return 29;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.POLLS.getType())) {
                    return 30;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.POSTER.getType())) {
                    return 31;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.PUBLISHER.getType())) {
                    return 32;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.TOPVIDEOS.getType())) {
                    return 33;
                }
                if (k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.LANGUAGE.getType())) {
                    return 34;
                }
                return k.a((Object) str, (Object) net.one97.paytm.feed.utility.k.GREETING.getType()) ? 35 : -1;
            }
        }
    }

    public final void a(List<FeedLanguageData> list) {
        if (list != null && this.f35011a.size() > 0) {
            FeedLanguage feedLanguage = new FeedLanguage(true, list);
            feedLanguage.setFeedItemType(net.one97.paytm.feed.utility.k.LANGUAGE.getType());
            int i2 = 2;
            if (net.one97.paytm.feed.utility.k.HIGHLIGHTS.equals(this.f35011a.get(0).getFeedItemType())) {
                i2 = 3;
            }
            if (this.f35011a.size() > 3) {
                this.f35011a.add(i2, feedLanguage);
                notifyItemInserted(i2);
                net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
                net.one97.paytm.feed.repository.b.c();
            }
        }
    }

    public final void a(int i2) {
        this.f35011a.remove(i2);
        notifyItemRemoved(i2);
    }

    public final void onViewRecycled(RecyclerView.v vVar) {
        k.c(vVar, "holder");
        super.onViewRecycled(vVar);
        if (vVar instanceof net.one97.paytm.feed.ui.base.b) {
            ((net.one97.paytm.feed.ui.base.b) vVar).f34872a.unbind();
        }
    }
}
