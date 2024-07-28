package net.one97.paytm.feed.ui.feed;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.t;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.cricket.FeedCricket;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.ui.feed.FeedWebViewActivity;
import net.one97.paytm.feed.ui.feed.actions.c;
import net.one97.paytm.feed.ui.feed.actions.comment.FeedCommentActivity;
import net.one97.paytm.feed.ui.feed.actions.d;
import net.one97.paytm.feed.ui.feed.d.a;
import net.one97.paytm.feed.ui.feed.video.FullVideoActivity;
import net.one97.paytm.feed.ui.publisher.FeedProviderActivity;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.feed.utility.l;
import net.one97.paytm.feed.utility.m;
import net.one97.paytm.feed.utility.s;
import net.one97.paytm.feed.utility.u;

public final class a implements t.b, c {

    /* renamed from: a  reason: collision with root package name */
    Context f34911a;

    /* renamed from: b  reason: collision with root package name */
    FeedItem f34912b;

    /* renamed from: c  reason: collision with root package name */
    private final String f34913c = "ActionsItemClickHandler";

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.feed.c<?> f34914d;

    public static void a(View view, FeedGeneric feedGeneric, int i2) {
        k.c(view, "view");
        k.c(feedGeneric, "feedItem");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.a(i2);
        FeedGenericData feedGenericData = feedGeneric.getFeedGenericData();
        j jVar = j.f35397a;
        Context context = view.getContext();
        k.a((Object) context, "view.context");
        if (j.e(context)) {
            u uVar = u.f35438a;
            if (!u.a()) {
                String str = null;
                if (feedGenericData.getWebUrl() != null && p.a((CharSequence) feedGenericData.getWebUrl(), (CharSequence) "twitter", true)) {
                    FeedWebViewActivity.a aVar = FeedWebViewActivity.f34900a;
                    Context context2 = view.getContext();
                    k.a((Object) context2, "view.context");
                    CreatedBy createdBy = feedGenericData.getCreatedBy();
                    if (createdBy != null) {
                        str = createdBy.getName();
                    }
                    String str2 = str;
                    if (str2 == null) {
                        k.a();
                    }
                    String webUrl = feedGenericData.getWebUrl();
                    if (webUrl == null) {
                        k.a();
                    }
                    FeedWebViewActivity.a.a(context2, str2, webUrl, "#1ea1f1", "#1ea1f1", feedGeneric);
                } else if (feedGenericData.getWebUrl() != null) {
                    FeedWebViewActivity.a aVar2 = FeedWebViewActivity.f34900a;
                    Context context3 = view.getContext();
                    k.a((Object) context3, "view.context");
                    CreatedBy createdBy2 = feedGenericData.getCreatedBy();
                    if (createdBy2 != null) {
                        str = createdBy2.getName();
                    }
                    if (str == null) {
                        k.a();
                    }
                    String webUrl2 = feedGenericData.getWebUrl();
                    if (webUrl2 == null) {
                        k.a();
                    }
                    FeedWebViewActivity.a.a(context3, str, webUrl2, feedGeneric);
                } else if (feedGenericData.getStreamUrl() != null) {
                    FullVideoActivity.a aVar3 = FullVideoActivity.f35223a;
                    Context context4 = view.getContext();
                    k.a((Object) context4, "view.context");
                    FullVideoActivity.a.a(context4, feedGeneric, 0);
                } else if (feedGenericData.getDeeplink() != null) {
                    net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                    Context context5 = view.getContext();
                    k.a((Object) context5, "view.context");
                    String deeplink = feedGenericData.getDeeplink();
                    if (deeplink == null) {
                        k.a();
                    }
                    net.one97.paytm.feed.e.b.c(context5, deeplink);
                }
                net.one97.paytm.feed.events.a aVar4 = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getPOST_CLICKED(), (FeedItem) feedGeneric, "", "");
            } else {
                return;
            }
        } else {
            Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
        }
        FeedCommentActivity.a aVar5 = FeedCommentActivity.f34935e;
        if (FeedCommentActivity.q) {
            net.one97.paytm.feed.events.a.a aVar6 = net.one97.paytm.feed.events.a.a.f34296a;
            String name = net.one97.paytm.feed.utility.k.NEWS.name();
            net.one97.paytm.feed.events.a.b bVar3 = net.one97.paytm.feed.events.a.b.f34303a;
            net.one97.paytm.feed.events.a.a.a("v2_feed_post_click", name, net.one97.paytm.feed.events.a.b.d(), "");
            return;
        }
        net.one97.paytm.feed.events.a.a aVar7 = net.one97.paytm.feed.events.a.a.f34296a;
        String name2 = net.one97.paytm.feed.utility.k.NEWS.name();
        net.one97.paytm.feed.events.a.b bVar4 = net.one97.paytm.feed.events.a.b.f34303a;
        net.one97.paytm.feed.events.a.a.a("v2_feed_post_click", name2, net.one97.paytm.feed.events.a.b.c(), "");
    }

    public static void a(View view, FeedCricket feedCricket) {
        k.c(view, "view");
        k.c(feedCricket, "feedItem");
        j jVar = j.f35397a;
        Context context = view.getContext();
        k.a((Object) context, "view.context");
        if (j.e(context)) {
            u uVar = u.f35438a;
            if (!u.a()) {
                m mVar = m.f35407a;
                m.b(feedCricket.getFeedCricketData().getDataUrl());
                FeedWebViewActivity.a aVar = FeedWebViewActivity.f34900a;
                Context context2 = view.getContext();
                k.a((Object) context2, "view.context");
                FeedItem feedItem = feedCricket;
                FeedWebViewActivity.a.a(context2, feedCricket.getFeedCricketData().getTitle(), feedCricket.getFeedCricketData().getClickUrl(), feedItem);
                net.one97.paytm.feed.events.a aVar2 = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getPOST_CLICKED(), feedItem, "", "");
            } else {
                return;
            }
        } else {
            Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
        }
        FeedCommentActivity.a aVar3 = FeedCommentActivity.f34935e;
        if (FeedCommentActivity.q) {
            net.one97.paytm.feed.events.a.a aVar4 = net.one97.paytm.feed.events.a.a.f34296a;
            String name = net.one97.paytm.feed.utility.k.SCORECARD.name();
            net.one97.paytm.feed.events.a.b bVar = net.one97.paytm.feed.events.a.b.f34303a;
            net.one97.paytm.feed.events.a.a.a("v2_feed_scorecard_click", name, net.one97.paytm.feed.events.a.b.d(), "");
            return;
        }
        net.one97.paytm.feed.events.a.a aVar5 = net.one97.paytm.feed.events.a.a.f34296a;
        String name2 = net.one97.paytm.feed.utility.k.SCORECARD.name();
        net.one97.paytm.feed.events.a.b bVar2 = net.one97.paytm.feed.events.a.b.f34303a;
        net.one97.paytm.feed.events.a.a.a("v2_feed_scorecard_click", name2, net.one97.paytm.feed.events.a.b.c(), "");
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        androidx.fragment.app.j jVar = null;
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        int i2 = R.id.share;
        if (valueOf != null && valueOf.intValue() == i2) {
            try {
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                Context context = this.f34911a;
                if (context == null) {
                    k.a();
                }
                FeedItem feedItem = this.f34912b;
                if (feedItem == null) {
                    k.a();
                }
                net.one97.paytm.feed.repository.db.a.e(context, feedItem.getPid());
            } catch (Exception unused) {
            }
            s sVar = s.f35433a;
            StringBuilder sb = new StringBuilder("http://m.p-y.tm/feed/?p=");
            FeedItem feedItem2 = this.f34912b;
            if (feedItem2 == null) {
                k.a();
            }
            sb.append(feedItem2.getPid());
            String sb2 = sb.toString();
            Context context2 = this.f34911a;
            if (context2 == null) {
                k.a();
            }
            s.a(sb2, context2);
            this.f34911a = null;
            return true;
        }
        int i3 = R.id.Hide;
        if (valueOf == null || valueOf.intValue() != i3) {
            return false;
        }
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("feedItem", this.f34912b);
        dVar.setArguments(bundle);
        dVar.f34976e = this;
        Context context3 = this.f34911a;
        if (context3 != null) {
            FragmentActivity fragmentActivity = (FragmentActivity) context3;
            if (fragmentActivity != null) {
                jVar = fragmentActivity.getSupportFragmentManager();
            }
            dVar.show(jVar, dVar.getTag());
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            return true;
        }
        throw new kotlin.u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void a() {
        this.f34914d = null;
        this.f34911a = null;
    }

    public static void a(View view, FeedItem feedItem, ai aiVar) {
        FeedItem feedItem2 = feedItem;
        ai aiVar2 = aiVar;
        k.c(view, "view");
        k.c(feedItem2, "post");
        k.c(aiVar2, "viewModel");
        j jVar = j.f35397a;
        Context context = view.getContext();
        k.a((Object) context, "view.context");
        boolean z = false;
        if (j.e(context)) {
            Context context2 = view.getContext();
            k.a((Object) context2, "view.context");
            net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
            if (!net.one97.paytm.feed.e.c.j()) {
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.a(context2);
            } else {
                z = true;
            }
            if (z) {
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                u uVar = u.f35438a;
                if (u.a()) {
                    net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.e.b.k();
                    return;
                }
                net.one97.paytm.feed.ui.feed.d.a aVar = (net.one97.paytm.feed.ui.feed.d.a) aiVar2;
                FeedGeneric feedGeneric = (FeedGeneric) feedItem2;
                k.c(feedGeneric, "post");
                Boolean isLiked = feedGeneric.getFeedGenericData().isLiked();
                if (isLiked == null) {
                    k.a();
                }
                if (!isLiked.booleanValue()) {
                    net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
                    net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                    net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                    Context x = net.one97.paytm.feed.e.b.x();
                    String pid = feedGeneric.getPid();
                    kotlin.g.a.b cVar2 = new a.c(aVar, feedGeneric);
                    k.c(x, "context");
                    k.c("/content-actions/v1/actions/", H5TabbarUtils.MATCH_TYPE_PATH);
                    k.c(pid, "pID");
                    k.c(cVar2, "completionHandler");
                    l lVar = l.f35406a;
                    net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
                    String h2 = net.one97.paytm.feed.e.b.h();
                    if (h2 == null) {
                        k.a();
                    }
                    String b2 = l.b(x, h2, "/content-actions/v1/actions/" + pid + "/likes", (Map<String, ? extends Object>) null);
                    String str = net.one97.paytm.feed.repository.a.b.f34365a;
                    net.one97.paytm.feed.e.b bVar6 = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.e.b.k();
                    net.one97.paytm.feed.repository.db.a aVar3 = net.one97.paytm.feed.repository.db.a.f34614a;
                    net.one97.paytm.feed.repository.db.a.b(x, pid);
                    b.bp bpVar = new b.bp(a2, b2, cVar2, x, pid, b2, new b.bq(cVar2), new b.br(x, pid, cVar2));
                    bpVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(x));
                    net.one97.paytm.feed.repository.a.a a3 = net.one97.paytm.feed.repository.a.a.f34362b.a(x);
                    if (a3 != null) {
                        a3.a(bpVar);
                        return;
                    }
                    return;
                }
                net.one97.paytm.feed.c.a aVar4 = net.one97.paytm.feed.c.a.f34255a;
                net.one97.paytm.feed.repository.a.b a4 = net.one97.paytm.feed.c.a.a();
                net.one97.paytm.feed.e.b bVar7 = net.one97.paytm.feed.e.b.f34268c;
                Context x2 = net.one97.paytm.feed.e.b.x();
                String pid2 = feedGeneric.getPid();
                kotlin.g.a.b dVar = new a.d(aVar, feedGeneric);
                k.c(x2, "context");
                k.c("/content-actions/v1/actions/", H5TabbarUtils.MATCH_TYPE_PATH);
                k.c(pid2, "pID");
                k.c(dVar, "completionHandler");
                l lVar2 = l.f35406a;
                net.one97.paytm.feed.e.b bVar8 = net.one97.paytm.feed.e.b.f34268c;
                String h3 = net.one97.paytm.feed.e.b.h();
                if (h3 == null) {
                    k.a();
                }
                String b3 = l.b(x2, h3, "/content-actions/v1/actions/" + pid2 + "/likes", (Map<String, ? extends Object>) null);
                String str2 = net.one97.paytm.feed.repository.a.b.f34365a;
                net.one97.paytm.feed.e.b bVar9 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                net.one97.paytm.feed.repository.db.a aVar5 = net.one97.paytm.feed.repository.db.a.f34614a;
                net.one97.paytm.feed.repository.db.a.c(x2, pid2);
                b.cb cbVar = new b.cb(a4, b3, dVar, x2, pid2, b3, new b.cc(dVar), new b.cd(x2, pid2, dVar));
                cbVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(x2));
                net.one97.paytm.feed.repository.a.a a5 = net.one97.paytm.feed.repository.a.a.f34362b.a(x2);
                if (a5 != null) {
                    a5.a(cbVar);
                    return;
                }
                return;
            }
            return;
        }
        Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
    }

    public static void a(View view, FeedItem feedItem, int i2, ai aiVar) {
        k.c(view, "view");
        k.c(feedItem, "post");
        k.c(aiVar, "viewModel");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.a(i2);
        a(view, feedItem, aiVar);
    }

    public final void a(String str, Context context) {
        k.c(str, "id");
        k.c(context, "context");
        net.one97.paytm.feed.c<?> cVar = this.f34914d;
        if (cVar != null) {
            cVar.f34251a = true;
            cVar.a(net.one97.paytm.feed.a.G);
        }
        new Handler().postDelayed(new b(this, context, str), 2500);
        this.f34914d = null;
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f34919a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f34920b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34921c;

        b(a aVar, Context context, String str) {
            this.f34919a = aVar;
            this.f34920b = context;
            this.f34921c = str;
        }

        public final void run() {
            net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
            net.one97.paytm.feed.repository.db.a.f(this.f34920b, this.f34921c);
            this.f34919a.f34911a = null;
        }
    }

    public static void a(View view, FeedItem feedItem, boolean z) {
        k.c(view, "view");
        k.c(feedItem, "feed");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.r() != 1) {
            j jVar = j.f35397a;
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            if (j.e(context)) {
                net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                if (net.one97.paytm.feed.e.c.a(view.getContext())) {
                    u uVar = u.f35438a;
                    if (!u.a()) {
                        FeedCommentActivity.a aVar = FeedCommentActivity.f34935e;
                        if (!FeedCommentActivity.p) {
                            FeedCommentActivity.a aVar2 = FeedCommentActivity.f34935e;
                            Context context2 = view.getContext();
                            k.a((Object) context2, "view.context");
                            FeedCommentActivity.a.a(context2, feedItem, z);
                            net.one97.paytm.feed.events.a.a aVar3 = net.one97.paytm.feed.events.a.a.f34296a;
                            net.one97.paytm.feed.events.a.a.a("v2_feed_comment", feedItem.getFeedItemType());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
        }
    }

    public static void a(View view, FeedItem feedItem, int i2, boolean z) {
        k.c(view, "view");
        k.c(feedItem, "feed");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.r() != 1) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.a(i2);
            a(view, feedItem, z);
        }
    }

    public static void a(Context context, FeedItem feedItem, boolean z, String str, ai aiVar) {
        String str2;
        if (feedItem != null) {
            FeedGeneric feedGeneric = (FeedGeneric) feedItem;
            feedGeneric.setPid(p.b(feedGeneric.getFeedGenericData().getId(), "|", feedGeneric.getFeedGenericData().getId()));
            if (feedGeneric.getFeedGenericData().getTitle() != null) {
                str2 = feedGeneric.getFeedGenericData().getTitle() + "\nhttp://m.p-y.tm/feed/?p=" + feedGeneric.getPid();
            } else {
                str2 = "http://m.p-y.tm/feed/?p=";
            }
            if (z) {
                s sVar = s.f35433a;
                s.a(str2, context);
                net.one97.paytm.feed.events.a.a aVar = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_share", feedGeneric.getFeedItemType());
            } else {
                s sVar2 = s.f35433a;
                s.b(str2, context);
                net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_share_whatsapp", feedGeneric.getFeedItemType());
            }
            if (aiVar != null) {
                k.c(feedGeneric, "post");
                k.c(str, "appShareName");
                net.one97.paytm.feed.c.a aVar3 = net.one97.paytm.feed.c.a.f34255a;
                net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                Context x = net.one97.paytm.feed.e.b.x();
                String pid = feedGeneric.getPid();
                kotlin.g.a.b eVar = new a.e((net.one97.paytm.feed.ui.feed.d.a) aiVar);
                k.c(x, "context");
                k.c("/content-actions/v1/actions/", H5TabbarUtils.MATCH_TYPE_PATH);
                k.c(pid, "pID");
                k.c(str, "sharedOnApp");
                k.c(eVar, "completionHandler");
                l lVar = l.f35406a;
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                String h2 = net.one97.paytm.feed.e.b.h();
                if (h2 == null) {
                    k.a();
                }
                String b2 = l.b(x, h2, "/content-actions/v1/actions/" + pid + "/shares", (Map<String, ? extends Object>) null);
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                b.bv bvVar = new b.bv(a2, str, b2, eVar, x, b2, new b.bw(eVar), new b.bx(eVar, x));
                bvVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(x));
                net.one97.paytm.feed.repository.a.a a3 = net.one97.paytm.feed.repository.a.a.f34362b.a(x);
                if (a3 != null) {
                    a3.a(bvVar);
                }
                try {
                    net.one97.paytm.feed.repository.db.a aVar4 = net.one97.paytm.feed.repository.db.a.f34614a;
                    net.one97.paytm.feed.repository.db.a.e(context, feedGeneric.getFeedGenericData().getId());
                } catch (Exception unused) {
                }
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.feed.ui.feed.generic.FeedGenericModel");
            }
        } else {
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
        }
    }

    public final void b(View view, FeedItem feedItem, ai aiVar) {
        k.c(view, "view");
        k.c(feedItem, "post");
        k.c(aiVar, "viewModel");
        net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
        if (net.one97.paytm.feed.e.c.a(view.getContext())) {
            u uVar = u.f35438a;
            if (!u.a()) {
                this.f34914d = (net.one97.paytm.feed.c) aiVar;
                Context context = view.getContext();
                k.a((Object) context, "view.context");
                net.one97.paytm.feed.c<?> cVar2 = this.f34914d;
                if (cVar2 == null) {
                    k.a();
                }
                a(context, feedItem, true, "", cVar2);
            }
        }
    }

    public static void c(View view, FeedItem feedItem, ai aiVar) {
        k.c(view, "view");
        k.c(feedItem, "feedItem");
        k.c(aiVar, "viewModel");
        j jVar = j.f35397a;
        Context context = view.getContext();
        k.a((Object) context, "view.context");
        if (j.e(context)) {
            u uVar = u.f35438a;
            if (!u.a()) {
                net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                if (net.one97.paytm.feed.e.c.a(view.getContext())) {
                    String pid = feedItem.getPid();
                    FeedGeneric feedGeneric = (FeedGeneric) feedItem;
                    String id = feedGeneric.getFeedGenericData().getId();
                    Context context2 = view.getContext();
                    k.a((Object) context2, "view.context");
                    ((net.one97.paytm.feed.ui.feed.d.a) aiVar).a(pid, id, context2, feedGeneric.getFeedGenericData().isBookmarked());
                    return;
                }
                return;
            }
            return;
        }
        Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
    }

    public static void a(View view, FeedItem feedItem) {
        CreatedBy createdBy;
        Integer id;
        k.c(view, "view");
        k.c(feedItem, "feedItem");
        FeedProviderActivity.a aVar = FeedProviderActivity.f35322f;
        if (!FeedProviderActivity.s) {
            j jVar = j.f35397a;
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            if (j.e(context)) {
                u uVar = u.f35438a;
                if (!u.a() && (createdBy = ((FeedGeneric) feedItem).getFeedGenericData().getCreatedBy()) != null && (id = createdBy.getId()) != null) {
                    int intValue = id.intValue();
                    FeedProviderActivity.a aVar2 = FeedProviderActivity.f35322f;
                    Context context2 = view.getContext();
                    k.a((Object) context2, "view.context");
                    FeedProviderActivity.a.a(context2, intValue);
                    return;
                }
                return;
            }
            Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
        }
    }

    public static void a(Context context, int i2) {
        k.c(context, "context");
        FeedProviderActivity.a aVar = FeedProviderActivity.f35322f;
        if (!FeedProviderActivity.s) {
            j jVar = j.f35397a;
            if (j.e(context)) {
                u uVar = u.f35438a;
                if (!u.a()) {
                    FeedProviderActivity.a aVar2 = FeedProviderActivity.f35322f;
                    FeedProviderActivity.a.a(context, i2);
                    return;
                }
                return;
            }
            Toast.makeText(context, R.string.feed_no_internet, 0).show();
        }
    }

    public final void d(View view, FeedItem feedItem, ai aiVar) {
        k.c(view, "view");
        k.c(feedItem, "feedItem");
        k.c(aiVar, "viewModel");
        net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
        if (net.one97.paytm.feed.e.c.a(view.getContext())) {
            u uVar = u.f35438a;
            if (!u.a()) {
                this.f34911a = view.getContext();
                this.f34914d = (net.one97.paytm.feed.c) aiVar;
                this.f34912b = feedItem;
                t tVar = new t(new androidx.appcompat.view.d(view.getContext(), R.style.popupMenuStyle), view);
                MenuInflater b2 = tVar.b();
                k.a((Object) b2, "popup.menuInflater");
                b2.inflate(R.menu.feed_post_actions_menu, tVar.f1796a);
                tVar.f1798c = this;
                try {
                    Field declaredField = t.class.getDeclaredField("b");
                    k.a((Object) declaredField, "PopupMenu::class.java.getDeclaredField(\"mPopup\")");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(tVar);
                    if (obj != null) {
                        Class[] clsArr = new Class[1];
                        Class cls = Boolean.TYPE;
                        if (cls == null) {
                            k.a();
                        }
                        clsArr[0] = cls;
                        obj.getClass().getDeclaredMethod("setForceShowIcon", (Class[]) Arrays.copyOf(clsArr, 1)).invoke(obj, new Object[]{Boolean.TRUE});
                        tVar.f1797b.a();
                        tVar.f1799d = new C0568a(this);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type java.lang.Object");
                } catch (Exception unused) {
                    tVar.f1797b.a();
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.a$a  reason: collision with other inner class name */
    static final class C0568a implements t.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f34915a;

        C0568a(a aVar) {
            this.f34915a = aVar;
        }

        public final void a() {
            this.f34915a.f34912b = null;
        }
    }
}
