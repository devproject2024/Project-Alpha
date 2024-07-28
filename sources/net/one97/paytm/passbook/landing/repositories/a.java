package net.one97.paytm.passbook.landing.repositories;

import android.content.Context;
import com.paytm.network.a;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.b;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.f;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f57764a = {y.a((v) new w(y.b(a.class), "context", "getContext()Landroid/content/Context;"))};

    /* renamed from: b  reason: collision with root package name */
    private final g f57765b = h.a(C1094a.INSTANCE);

    public final Context a() {
        return (Context) this.f57765b.getValue();
    }

    /* renamed from: net.one97.paytm.passbook.landing.repositories.a$a  reason: collision with other inner class name */
    static final class C1094a extends l implements kotlin.g.a.a<Context> {
        public static final C1094a INSTANCE = new C1094a();

        C1094a() {
            super(0);
        }

        public final Context invoke() {
            f b2 = d.b();
            k.a((Object) b2, "PassbookHelper.getImplListener()");
            return b2.b();
        }
    }

    public final void a(String str, IJRDataModel iJRDataModel, Map<String, String> map, String str2, i.a<IJRDataModel> aVar, net.one97.paytm.passbook.mapping.a.g gVar) {
        String str3 = str;
        IJRDataModel iJRDataModel2 = iJRDataModel;
        net.one97.paytm.passbook.mapping.a.g gVar2 = gVar;
        k.c(str, "url");
        k.c(iJRDataModel2, "model");
        i.a<IJRDataModel> aVar2 = aVar;
        k.c(aVar2, "listener");
        k.c(gVar2, "errorListener");
        a(new b(str, aVar2, gVar, iJRDataModel, map, str2, a.c.PASSBOOK, a.b.USER_FACING, "BaseRepository"), str, iJRDataModel2, gVar2);
    }

    public final void a(String str, IJRDataModel iJRDataModel, Map<String, String> map, i.a<IJRDataModel> aVar, net.one97.paytm.passbook.mapping.a.g gVar) {
        k.c(str, "url");
        k.c(iJRDataModel, "model");
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        a(new net.one97.paytm.passbook.mapping.a.a(str, aVar, gVar, iJRDataModel, map, a.c.PASSBOOK, a.b.USER_FACING, "BaseRepository"), str, iJRDataModel, gVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(e eVar, String str, IJRDataModel iJRDataModel, net.one97.paytm.passbook.mapping.a.g gVar) {
        k.c(eVar, "request");
        k.c(str, "url");
        k.c(iJRDataModel, "model");
        k.c(gVar, "errorListener");
        if (net.one97.paytm.passbook.utility.f.a(a())) {
            a();
            c.a();
            c.b(eVar);
            return;
        }
        gVar.onErrorResponse(5001, iJRDataModel, new net.one97.paytm.passbook.a.a.a(str, eVar));
    }
}
