package net.one97.paytm.feed.ui.feed.b;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.ui.feed.video.FullVideoActivity;

public final class c extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    View f34991a;

    /* renamed from: b  reason: collision with root package name */
    final e f34992b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view, e eVar) {
        super(view);
        k.c(view, "view");
        k.c(eVar, "listener");
        this.f34991a = view;
        this.f34992b = eVar;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f34993a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedGeneric f34994b;

        a(c cVar, FeedGeneric feedGeneric) {
            this.f34993a = cVar;
            this.f34994b = feedGeneric;
        }

        public final void onClick(View view) {
            new net.one97.paytm.feed.ui.feed.a();
            net.one97.paytm.feed.ui.feed.a.a(this.f34993a.f34991a, (FeedItem) this.f34994b);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f34995a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedGeneric f34996b;

        b(c cVar, FeedGeneric feedGeneric) {
            this.f34995a = cVar;
            this.f34996b = feedGeneric;
        }

        public final void onClick(View view) {
            new net.one97.paytm.feed.ui.feed.a();
            net.one97.paytm.feed.ui.feed.a.a(this.f34995a.f34991a, (FeedItem) this.f34996b);
        }
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.b.c$c  reason: collision with other inner class name */
    static final class C0573c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f34997a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedGeneric f34998b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FeedGenericData f34999c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f35000d;

        C0573c(c cVar, FeedGeneric feedGeneric, FeedGenericData feedGenericData, int i2) {
            this.f34997a = cVar;
            this.f34998b = feedGeneric;
            this.f34999c = feedGenericData;
            this.f35000d = i2;
        }

        public final void onClick(View view) {
            net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
            net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getPOST_CLICKED(), (FeedItem) this.f34998b, "", "");
            if (this.f34999c.getWebUrl() != null) {
                String webUrl = this.f34999c.getWebUrl();
                if ((webUrl != null ? Boolean.valueOf(p.a((CharSequence) webUrl, (CharSequence) "twitter", true)) : null).booleanValue()) {
                    new net.one97.paytm.feed.ui.feed.d.b();
                    Context context = this.f34997a.f34991a.getContext();
                    k.a((Object) context, "view.context");
                    net.one97.paytm.feed.ui.feed.d.b.a(context, this.f34999c);
                    this.f34997a.f34992b.a();
                    return;
                }
            }
            if (this.f34999c.getWebUrl() != null) {
                new net.one97.paytm.feed.ui.feed.d.b();
                Context context2 = this.f34997a.f34991a.getContext();
                k.a((Object) context2, "view.context");
                net.one97.paytm.feed.ui.feed.d.b.a(context2, this.f34999c);
                this.f34997a.f34992b.a();
            } else if (this.f34999c.getStreamUrl() != null) {
                this.f34997a.f34992b.a();
                FullVideoActivity.a aVar2 = FullVideoActivity.f35223a;
                Context context3 = this.f34997a.f34991a.getContext();
                k.a((Object) context3, "view.context");
                FullVideoActivity.a.a(context3, this.f34998b, 0);
            } else if (this.f34999c.getDeeplink() != null) {
                this.f34997a.f34992b.a();
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                Context context4 = this.f34997a.f34991a.getContext();
                k.a((Object) context4, "view.context");
                String deeplink = this.f34999c.getDeeplink();
                if (deeplink == null) {
                    k.a();
                }
                net.one97.paytm.feed.e.b.c(context4, deeplink);
            }
        }
    }
}
