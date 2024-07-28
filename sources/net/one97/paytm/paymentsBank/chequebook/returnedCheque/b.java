package net.one97.paytm.paymentsBank.chequebook.returnedCheque;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paymentsBank.chequebook.b;
import net.one97.paytm.paymentsBank.chequebook.model.CBChequeStatusDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBHeading;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeDetailsForInwardOutward;
import net.one97.paytm.paymentsBank.chequebook.utils.e;
import net.one97.paytm.paymentsBank.chequebook.utils.g;

public final class b extends net.one97.paytm.paymentsBank.chequebook.a {

    /* renamed from: a  reason: collision with root package name */
    public final LiveData<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> f17736a;

    /* renamed from: b  reason: collision with root package name */
    private final y<Integer> f17737b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private final List<IJRDataModel> f17738c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final Application f17739d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final g f17740e;

    static final class a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17741a;

        a(b bVar) {
            this.f17741a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Integer num = (Integer) obj;
            g a2 = this.f17741a.f17740e;
            k.a((Object) num, "it");
            int intValue = num.intValue();
            e eVar = e.f17951a;
            String C = e.C();
            e eVar2 = e.f17951a;
            return ah.a(a2.a(intValue, "outward", C, e.i()), new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f17742a;

                {
                    this.f17742a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
                    b bVar2 = this.f17742a.f17741a;
                    k.a((Object) bVar, "it");
                    return b.a(bVar2, bVar);
                }
            });
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application, g gVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(gVar, "cbRepository");
        this.f17739d = application;
        this.f17740e = gVar;
        LiveData<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> b2 = ah.b(this.f17737b, new a(this));
        k.a((Object) b2, "Transformations.switchMa…Model(it)\n        }\n    }");
        this.f17736a = b2;
    }

    public final void a(int i2) {
        this.f17737b.setValue(Integer.valueOf(i2));
    }

    public static final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.b a(b bVar, net.one97.paytm.paymentsBank.chequebook.b bVar2) {
        int i2 = c.f17743a[bVar2.f17486a.ordinal()];
        if (i2 == 1) {
            if (!bVar2.f17489d) {
                bVar.f17738c.add(0, new CBHeading("", ""));
            }
            CBChequeStatusDetailResponse cBChequeStatusDetailResponse = (CBChequeStatusDetailResponse) bVar2.f17487b;
            List<ChequeDetailsForInwardOutward> chqListForInwrdOutwrd = cBChequeStatusDetailResponse != null ? cBChequeStatusDetailResponse.getChqListForInwrdOutwrd() : null;
            if (chqListForInwrdOutwrd != null) {
                Collection collection = chqListForInwrdOutwrd;
                if (!collection.isEmpty()) {
                    bVar.f17738c.addAll(collection);
                }
            }
            b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            return b.a.a(bVar.f17738c, bVar2.f17489d);
        } else if (i2 == 2) {
            b.a aVar2 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            return b.a.a();
        } else if (i2 == 3) {
            b.a aVar3 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            return b.a.a(bVar2.f17488c);
        } else {
            throw new m();
        }
    }
}
