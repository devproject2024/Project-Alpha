package net.one97.paytm.feed.ui.feed.actions.comment;

import android.content.Context;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.feed.c;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;

public final class i extends c<CommentResponse> {

    /* renamed from: d  reason: collision with root package name */
    public boolean f34972d = p.a(this.f34974f.getModerationType(), a.SENSITIVE.getType(), true);

    /* renamed from: e  reason: collision with root package name */
    public boolean f34973e = p.a(this.f34974f.getModerationType(), a.BLOCKED.getType(), true);

    /* renamed from: f  reason: collision with root package name */
    public CommentResponse f34974f;

    static final class a extends l implements b<String, x> {
        final /* synthetic */ b $completionHandler;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar) {
            super(1);
            this.$completionHandler = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            this.$completionHandler.invoke(str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(CommentResponse commentResponse) {
        super(commentResponse);
        k.c(commentResponse, CJRQRScanResultModel.KEY_COMMENT_SMALL);
        this.f34974f = commentResponse;
    }

    public static void a(String str, String str2, b<? super String, x> bVar) {
        k.c(str, "pID");
        k.c(str2, "commentID");
        k.c(bVar, "completionHandler");
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        Context x = net.one97.paytm.feed.e.b.x();
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            k.a();
        }
        b aVar2 = new a(bVar);
        k.c(x, "context");
        k.c(h2, "baseURL");
        k.c("/content-comments/v1/post/", H5TabbarUtils.MATCH_TYPE_PATH);
        k.c(str, "pID");
        k.c(str2, "commentID");
        k.c(aVar2, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
        String h3 = net.one97.paytm.feed.e.b.h();
        if (h3 == null) {
            k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(x, h3, "/content-comments/v1/post/" + str + "/comment/" + str2, (Map<String, ? extends Object>) null);
        String str3 = net.one97.paytm.feed.repository.a.b.f34365a;
        net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        b.e eVar = new b.e(a2, b2, x, str, aVar2, b2, new b.f(x, str, aVar2), new b.g(aVar2, x));
        eVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(x));
        net.one97.paytm.feed.repository.a.a a3 = net.one97.paytm.feed.repository.a.a.f34362b.a(x);
        if (a3 != null) {
            a3.a(eVar);
        }
    }
}
