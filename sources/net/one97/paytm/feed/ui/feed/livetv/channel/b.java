package net.one97.paytm.feed.ui.feed.livetv.channel;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.ui.feed.d;
import net.one97.paytm.feed.utility.j;

public final class b extends d {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Channel> f35131a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f35132b = "";

    /* renamed from: c  reason: collision with root package name */
    io.reactivex.rxjava3.j.b<ArrayList<Channel>> f35133c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35134d;

    /* renamed from: e  reason: collision with root package name */
    public int f35135e;

    /* renamed from: f  reason: collision with root package name */
    private final net.one97.paytm.feed.repository.a.b f35136f;

    static final class a extends l implements kotlin.g.a.b<List<? extends Channel>, x> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar) {
            super(1);
            this.this$0 = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<Channel>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<Channel> list) {
            this.this$0.a(false);
            if (list != null) {
                this.this$0.b(0);
                this.this$0.f35133c.onNext((ArrayList) list);
                return;
            }
            this.this$0.b(1);
            this.this$0.f35133c.onNext(this.this$0.f35131a);
        }
    }

    public b(net.one97.paytm.feed.repository.a.b bVar) {
        k.c(bVar, "provideVolleyHelper");
        this.f35136f = bVar;
        io.reactivex.rxjava3.j.b<ArrayList<Channel>> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.f35133c = a2;
    }

    public final void a(boolean z) {
        this.f35134d = z;
        a(net.one97.paytm.feed.a.u);
    }

    public final void b(int i2) {
        this.f35135e = i2;
        a(net.one97.paytm.feed.a.k);
    }

    public final void a(Context context, String str, View view) {
        k.c(context, "context");
        k.c(str, "categoryID");
        k.c(view, "view");
        j jVar = j.f35397a;
        if (j.e(context)) {
            a(true);
            net.one97.paytm.feed.repository.a.b bVar = this.f35136f;
            bVar.c(context, "/content-channels/v1/channel_categories/" + str + "/channels", new a(this));
            return;
        }
        b(2);
    }
}
