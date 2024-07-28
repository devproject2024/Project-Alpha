package net.one97.paytm.feed.ui.feed.d;

import android.content.Context;
import com.appsflyer.share.Constants;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;

public final class a extends net.one97.paytm.feed.c<FeedGeneric> {

    /* renamed from: d  reason: collision with root package name */
    public int f35026d = -1;

    /* renamed from: e  reason: collision with root package name */
    public final FeedGeneric f35027e;

    /* renamed from: net.one97.paytm.feed.ui.feed.d.a$a  reason: collision with other inner class name */
    static final class C0576a extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $pid;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0576a(a aVar, Context context, String str) {
            super(1);
            this.this$0 = aVar;
            this.$context = context;
            this.$pid = str;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getPOST_SAVED(), (FeedItem) this.this$0.f34253c, "", "");
                net.one97.paytm.feed.repository.db.a aVar2 = net.one97.paytm.feed.repository.db.a.f34614a;
                net.one97.paytm.feed.repository.db.a.b(this.$context, this.$pid, true);
            }
        }
    }

    static final class b extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $pid;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, String str) {
            super(1);
            this.$context = context;
            this.$pid = str;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                net.one97.paytm.feed.repository.db.a.b(this.$context, this.$pid, false);
            }
        }
    }

    public static final class c extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FeedGeneric $post;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, FeedGeneric feedGeneric) {
            super(1);
            this.this$0 = aVar;
            this.$post = feedGeneric;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getPOST_LIKED(), (FeedItem) this.this$0.f34253c, "", "");
                net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_like", this.$post.getFeedItemType());
            }
        }
    }

    public static final class d extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FeedGeneric $post;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, FeedGeneric feedGeneric) {
            super(1);
            this.this$0 = aVar;
            this.$post = feedGeneric;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getPOST_UNLIKED(), (FeedItem) this.this$0.f34253c, "", "");
                net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_unlike", this.$post.getFeedItemType());
            }
        }
    }

    public static final class e extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getPOST_SHARED(), (FeedItem) this.this$0.f34253c, "", "");
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(FeedGeneric feedGeneric) {
        super(feedGeneric);
        k.c(feedGeneric, "feedGeneric");
        this.f35027e = feedGeneric;
    }

    public final void a(String str, String str2, Context context, boolean z) {
        k.c(str, "id");
        k.c(str2, Constants.URL_MEDIA_SOURCE);
        k.c(context, "context");
        if (!z) {
            net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
            net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
            a2.d(context, "/content-actions/v1/actions/" + str + "/bookmarks", new C0576a(this, context, str2));
            return;
        }
        net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.repository.a.b a3 = net.one97.paytm.feed.c.a.a();
        a3.e(context, "/content-actions/v1/actions/" + str + "/bookmarks", new b(context, str2));
    }
}
