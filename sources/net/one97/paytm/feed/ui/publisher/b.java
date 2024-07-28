package net.one97.paytm.feed.ui.publisher;

import android.content.Context;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.o;
import kotlin.x;
import net.one97.paytm.feed.d;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.provider.ProviderResult;
import net.one97.paytm.feed.repository.models.provider.UserData;

public final class b extends ai {

    /* renamed from: a  reason: collision with root package name */
    io.reactivex.rxjava3.j.b<Integer> f35345a;

    /* renamed from: b  reason: collision with root package name */
    LiveData<List<FeedDataMinimal>> f35346b;

    static final class a extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ long $count;
        final /* synthetic */ int $id;
        final /* synthetic */ String $name;
        final /* synthetic */ TextView $toolBarView;
        final /* synthetic */ UserData $userData;
        final /* synthetic */ TextView $view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, int i2, TextView textView, TextView textView2, UserData userData, String str, long j) {
            super(1);
            this.$context = context;
            this.$id = i2;
            this.$view = textView;
            this.$toolBarView = textView2;
            this.$userData = userData;
            this.$name = str;
            this.$count = j;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                net.one97.paytm.feed.repository.db.a.a(this.$context, this.$id, true);
                net.one97.paytm.feed.utility.a.a(this.$view, true);
                net.one97.paytm.feed.utility.a.a(this.$toolBarView, true);
                this.$userData.setFollowed(true);
                net.one97.paytm.feed.events.a aVar2 = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getFOLLOWED(), this.$id, this.$name, this.$count);
                net.one97.paytm.feed.events.a.a aVar3 = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.b bVar = net.one97.paytm.feed.events.a.b.f34303a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_follow", net.one97.paytm.feed.events.a.b.e(), this.$name, "");
            }
        }
    }

    /* renamed from: net.one97.paytm.feed.ui.publisher.b$b  reason: collision with other inner class name */
    static final class C0591b extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ long $count;
        final /* synthetic */ int $id;
        final /* synthetic */ String $name;
        final /* synthetic */ TextView $toolBarView;
        final /* synthetic */ UserData $userData;
        final /* synthetic */ TextView $view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0591b(Context context, int i2, TextView textView, TextView textView2, UserData userData, String str, long j) {
            super(1);
            this.$context = context;
            this.$id = i2;
            this.$view = textView;
            this.$toolBarView = textView2;
            this.$userData = userData;
            this.$name = str;
            this.$count = j;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                net.one97.paytm.feed.repository.db.a.a(this.$context, this.$id, false);
                net.one97.paytm.feed.utility.a.a(this.$view, false);
                net.one97.paytm.feed.utility.a.a(this.$toolBarView, false);
                this.$userData.setFollowed(false);
                net.one97.paytm.feed.events.a aVar2 = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getUNFOLLOWED(), this.$id, this.$name, this.$count);
            }
        }
    }

    static final class c extends l implements kotlin.g.a.b<ProviderResult, x> {
        final /* synthetic */ Long $maxId;
        final /* synthetic */ kotlin.g.a.b $responseHandler;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, Long l, kotlin.g.a.b bVar2) {
            super(1);
            this.this$0 = bVar;
            this.$maxId = l;
            this.$responseHandler = bVar2;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ProviderResult) obj);
            return x.f47997a;
        }

        public final void invoke(ProviderResult providerResult) {
            if (providerResult != null && (!providerResult.getFeed().isEmpty())) {
                io.reactivex.rxjava3.j.b<Integer> bVar = this.this$0.f35345a;
                d.a aVar = d.f34256a;
                bVar.onNext(Integer.valueOf(d.f34257b));
            } else if (providerResult == null || !providerResult.getFeed().isEmpty()) {
                io.reactivex.rxjava3.j.b<Integer> bVar2 = this.this$0.f35345a;
                d.a aVar2 = d.f34256a;
                bVar2.onNext(Integer.valueOf(d.f34260e));
            } else if (this.$maxId == null) {
                io.reactivex.rxjava3.j.b<Integer> bVar3 = this.this$0.f35345a;
                d.a aVar3 = d.f34256a;
                bVar3.onNext(Integer.valueOf(d.f34259d));
            } else {
                io.reactivex.rxjava3.j.b<Integer> bVar4 = this.this$0.f35345a;
                d.a aVar4 = d.f34256a;
                bVar4.onNext(Integer.valueOf(d.f34263h));
            }
            this.$responseHandler.invoke(providerResult);
        }
    }

    public b() {
        io.reactivex.rxjava3.j.b<Integer> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.f35345a = a2;
    }

    public final void a(Context context, int i2, Long l, ProviderResult providerResult, kotlin.g.a.b<? super ProviderResult, x> bVar) {
        String str;
        k.c(context, "context");
        k.c(bVar, "responseHandler");
        if (l == null) {
            net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            String h2 = net.one97.paytm.feed.e.b.h();
            if (h2 == null) {
                k.a();
            }
            str = net.one97.paytm.feed.utility.l.a(context, h2, "/content-feed/v2/provider/".concat(String.valueOf(i2)), (Map<String, ? extends Object>) null);
        } else {
            net.one97.paytm.feed.utility.l lVar2 = net.one97.paytm.feed.utility.l.f35406a;
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            String h3 = net.one97.paytm.feed.e.b.h();
            if (h3 == null) {
                k.a();
            }
            str = net.one97.paytm.feed.utility.l.a(context, h3, "/content-feed/v2/provider/".concat(String.valueOf(i2)), ae.c(new o("maxId", l)));
        }
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.c.a.a().a(context, str, providerResult, (kotlin.g.a.b<? super ProviderResult, x>) new c(this, l, bVar));
    }

    public static void a(int i2, String str, long j, Context context, UserData userData, TextView textView, TextView textView2) {
        int i3 = i2;
        Context context2 = context;
        String str2 = str;
        k.c(str, "name");
        k.c(context2, "context");
        k.c(userData, "userData");
        k.c(textView, "view");
        k.c(textView2, "toolBarView");
        if (!userData.isFollowed()) {
            net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
            net.one97.paytm.feed.c.a.a().b(context2, "/content-social-graph/v1/follow", i2, (kotlin.g.a.b<? super String, x>) new a(context, i2, textView, textView2, userData, str, j));
            return;
        }
        net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.c.a.a().b(context2, "/content-social-graph/v1/unfollow", i2, (kotlin.g.a.b<? super String, x>) new C0591b(context, i2, textView, textView2, userData, str, j));
    }
}
