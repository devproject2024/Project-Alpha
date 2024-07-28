package net.one97.paytm.upgradeKyc.kycV3.c;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.upgradeKyc.UADPincode;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.kycV3.b.c;

public final class h extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<b<IJRPaytmDataModel>> f66240a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<b<IJRPaytmDataModel>> f66241b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final y<String> f66242c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<b<UADPincode>> f66243d;

    /* renamed from: e  reason: collision with root package name */
    public final c f66244e;

    static final class a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f66245a;

        a(h hVar) {
            this.f66245a = hVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            c a2 = this.f66245a.f66244e;
            k.a((Object) str, "it");
            return ah.a(a2.a(str), new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f66246a;

                {
                    this.f66246a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    b bVar = (b) obj;
                    k.a((Object) bVar, "it");
                    return h.a(bVar);
                }
            });
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Application application, c cVar) {
        super(application);
        k.c(application, "application");
        k.c(cVar, "kycRepository");
        this.f66244e = cVar;
        LiveData<b<UADPincode>> b2 = ah.b(this.f66242c, new a(this));
        k.a((Object) b2, "Transformations.switchMa…oUiUadPincode(it) }\n    }");
        this.f66243d = b2;
    }

    public final void a() {
        y<b<IJRPaytmDataModel>> yVar = this.f66240a;
        b.a aVar = b.f66167d;
        yVar.setValue(b.a.a());
        this.f66244e.a(this.f66240a);
    }

    public static final /* synthetic */ b a(b bVar) {
        String responseCode;
        int i2 = i.f66247a[bVar.f66168a.ordinal()];
        if (i2 == 1) {
            UADPincode uADPincode = (UADPincode) bVar.f66169b;
            if (!(uADPincode == null || (responseCode = uADPincode.getResponseCode()) == null || !p.a(responseCode, "200", true))) {
                b.a aVar = b.f66167d;
                ResultType resulttype = bVar.f66169b;
                if (resulttype == null) {
                    k.a();
                }
                return b.a.a(resulttype);
            }
        } else if (i2 == 2) {
            b.a aVar2 = b.f66167d;
            return b.a.a();
        } else if (i2 == 3) {
            b.a aVar3 = b.f66167d;
            return b.a.a(bVar.f66170c);
        }
        b.a aVar4 = b.f66167d;
        ResultType resulttype2 = bVar.f66169b;
        if (resulttype2 == null) {
            k.a();
        }
        return b.a.a(resulttype2);
    }
}
