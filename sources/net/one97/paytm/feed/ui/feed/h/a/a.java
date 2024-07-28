package net.one97.paytm.feed.ui.feed.h.a;

import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant;

public final class a extends net.one97.paytm.feed.c<FeedMerchant> {

    /* renamed from: net.one97.paytm.feed.ui.feed.h.a.a$a  reason: collision with other inner class name */
    public static final class C0580a extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0580a(a aVar) {
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
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getPOST_LIKED(), (FeedItem) this.this$0.f34253c, "", "");
                net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_like", "");
            }
        }
    }

    public static final class b extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar) {
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
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getPOST_UNLIKED(), (FeedItem) this.this$0.f34253c, "", "");
                net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_unlike", "");
            }
        }
    }

    public static final class c extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
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
    public a(FeedMerchant feedMerchant) {
        super(feedMerchant);
        k.c(feedMerchant, "feedMerchant");
    }
}
