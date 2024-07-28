package net.one97.paytm.feed.ui.feed;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import io.reactivex.rxjava3.j.b;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.d;
import net.one97.paytm.feed.events.b.a;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.ui.feed.FeedFragment;

public final class e extends ai {

    /* renamed from: a  reason: collision with root package name */
    LiveData<List<FeedDataMinimal>> f35037a;

    /* renamed from: b  reason: collision with root package name */
    LiveData<List<FeedDataMinimal>> f35038b;

    /* renamed from: c  reason: collision with root package name */
    b<Integer> f35039c;

    /* renamed from: d  reason: collision with root package name */
    private final net.one97.paytm.feed.repository.a.b f35040d;

    static final class a extends l implements kotlin.g.a.b<List<? extends FeedItem>, x> {
        final /* synthetic */ boolean $isRefreshRequest;
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar, boolean z) {
            super(1);
            this.this$0 = eVar;
            this.$isRefreshRequest = z;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends FeedItem>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<? extends FeedItem> list) {
            if (list != null && (!list.isEmpty())) {
                net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
                net.one97.paytm.feed.repository.b.j();
                if (this.$isRefreshRequest) {
                    net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
                    net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
                    net.one97.paytm.feed.b.b(net.one97.paytm.feed.b.j() + 1);
                    b<Integer> bVar4 = this.this$0.f35039c;
                    d.a aVar = d.f34256a;
                    bVar4.onNext(Integer.valueOf(d.f34258c));
                    net.one97.paytm.feed.events.a aVar2 = net.one97.paytm.feed.events.a.f34284a;
                    a.C0560a aVar3 = net.one97.paytm.feed.events.b.a.f34338a;
                    net.one97.paytm.feed.events.a.a(net.one97.paytm.feed.events.b.a.f34340d, 0, 0, System.currentTimeMillis(), 0);
                    return;
                }
                b<Integer> bVar5 = this.this$0.f35039c;
                d.a aVar4 = d.f34256a;
                bVar5.onNext(Integer.valueOf(d.f34257b));
            } else if (list == null || !list.isEmpty()) {
                net.one97.paytm.feed.repository.b bVar6 = net.one97.paytm.feed.repository.b.f34608a;
                if (!net.one97.paytm.feed.repository.b.k()) {
                    b<Integer> bVar7 = this.this$0.f35039c;
                    d.a aVar5 = d.f34256a;
                    bVar7.onNext(Integer.valueOf(d.f34262g));
                    return;
                }
                b<Integer> bVar8 = this.this$0.f35039c;
                d.a aVar6 = d.f34256a;
                bVar8.onNext(Integer.valueOf(d.f34260e));
            } else if (this.$isRefreshRequest) {
                b<Integer> bVar9 = this.this$0.f35039c;
                d.a aVar7 = d.f34256a;
                bVar9.onNext(Integer.valueOf(d.f34259d));
                net.one97.paytm.feed.b bVar10 = net.one97.paytm.feed.b.f33792d;
                net.one97.paytm.feed.b bVar11 = net.one97.paytm.feed.b.f33792d;
                net.one97.paytm.feed.b.b(net.one97.paytm.feed.b.j() + 1);
                net.one97.paytm.feed.events.a aVar8 = net.one97.paytm.feed.events.a.f34284a;
                a.C0560a aVar9 = net.one97.paytm.feed.events.b.a.f34338a;
                net.one97.paytm.feed.events.a.a(net.one97.paytm.feed.events.b.a.f34340d, 0, 0, System.currentTimeMillis(), 0);
            } else {
                b<Integer> bVar12 = this.this$0.f35039c;
                d.a aVar10 = d.f34256a;
                bVar12.onNext(Integer.valueOf(d.f34263h));
            }
        }
    }

    public e(net.one97.paytm.feed.repository.a.b bVar) {
        k.c(bVar, "provideVolleyHelper");
        this.f35040d = bVar;
        b<Integer> a2 = b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.f35039c = a2;
    }

    public final void a(Context context, String str, boolean z, String str2) {
        String str3;
        k.c(context, "context");
        k.c(str, "category");
        k.c(str2, "requestCode");
        net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.a(z);
        FeedFragment.a aVar = FeedFragment.f34877i;
        if (!str.equals(FeedFragment.C)) {
            net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
            net.one97.paytm.feed.b.a(str);
        }
        if (z) {
            net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            str3 = net.one97.paytm.feed.utility.l.a(context, net.one97.paytm.feed.e.b.h(), str, "REFRESH", str2);
        } else {
            net.one97.paytm.feed.utility.l lVar2 = net.one97.paytm.feed.utility.l.f35406a;
            net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
            str3 = net.one97.paytm.feed.utility.l.a(context, net.one97.paytm.feed.e.b.h(), str, "PREFETCH", str2);
        }
        this.f35040d.a(context, str3, str, (kotlin.g.a.b<? super List<? extends FeedItem>, x>) new a(this, z));
    }
}
