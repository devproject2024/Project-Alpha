package net.one97.paytm.paymentsBank.chequebook.depositedCheque;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.b;
import net.one97.paytm.paymentsBank.chequebook.model.CBChequeStatusDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBHeading;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeDetailsForInwardOutward;
import net.one97.paytm.paymentsBank.chequebook.model.SectionDivider;
import net.one97.paytm.paymentsBank.chequebook.utils.e;
import net.one97.paytm.paymentsBank.chequebook.utils.g;

public final class b extends net.one97.paytm.paymentsBank.chequebook.a {

    /* renamed from: a  reason: collision with root package name */
    public final LiveData<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> f17513a;

    /* renamed from: b  reason: collision with root package name */
    private final y<Integer> f17514b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private final List<IJRDataModel> f17515c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final Application f17516d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final g f17517e;

    static final class a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17518a;

        a(b bVar) {
            this.f17518a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Integer num = (Integer) obj;
            g a2 = this.f17518a.f17517e;
            k.a((Object) num, "it");
            int intValue = num.intValue();
            e eVar = e.f17951a;
            return ah.a(a2.a(intValue, "outward", "", e.i()), new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f17519a;

                {
                    this.f17519a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
                    b bVar2 = this.f17519a.f17518a;
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
        this.f17516d = application;
        this.f17517e = gVar;
        LiveData<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> b2 = ah.b(this.f17514b, new a(this));
        k.a((Object) b2, "Transformations.switchMa…Model(it)\n        }\n    }");
        this.f17513a = b2;
    }

    public final void a(int i2) {
        this.f17514b.setValue(Integer.valueOf(i2));
    }

    public static final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.b a(b bVar, net.one97.paytm.paymentsBank.chequebook.b bVar2) {
        List list;
        List<ChequeDetailsForInwardOutward> chqListForInwrdOutwrd;
        List<ChequeDetailsForInwardOutward> chqListForInwrdOutwrd2;
        int i2 = c.f17520a[bVar2.f17486a.ordinal()];
        if (i2 == 1) {
            if (!bVar2.f17489d) {
                bVar.f17515c.add(0, new CBHeading("", ""));
            }
            CBChequeStatusDetailResponse cBChequeStatusDetailResponse = (CBChequeStatusDetailResponse) bVar2.f17487b;
            List list2 = null;
            if (cBChequeStatusDetailResponse == null || (chqListForInwrdOutwrd2 = cBChequeStatusDetailResponse.getChqListForInwrdOutwrd()) == null) {
                list = null;
            } else {
                Collection arrayList = new ArrayList();
                for (Object next : chqListForInwrdOutwrd2) {
                    String status = ((ChequeDetailsForInwardOutward) next).getStatus();
                    e eVar = e.f17951a;
                    if (p.a(status, e.Q(), true)) {
                        arrayList.add(next);
                    }
                }
                list = (List) arrayList;
            }
            CBChequeStatusDetailResponse cBChequeStatusDetailResponse2 = (CBChequeStatusDetailResponse) bVar2.f17487b;
            if (!(cBChequeStatusDetailResponse2 == null || (chqListForInwrdOutwrd = cBChequeStatusDetailResponse2.getChqListForInwrdOutwrd()) == null)) {
                Collection arrayList2 = new ArrayList();
                for (Object next2 : chqListForInwrdOutwrd) {
                    String status2 = ((ChequeDetailsForInwardOutward) next2).getStatus();
                    e eVar2 = e.f17951a;
                    if (p.a(status2, e.j(), true)) {
                        arrayList2.add(next2);
                    }
                }
                list2 = (List) arrayList2;
            }
            if (list != null) {
                Collection collection = list;
                if (!collection.isEmpty()) {
                    bVar.f17515c.addAll(collection);
                }
            }
            if (list2 != null) {
                Collection collection2 = list2;
                if (!collection2.isEmpty()) {
                    List<IJRDataModel> list3 = bVar.f17515c;
                    String string = bVar.f17516d.getApplicationContext().getString(R.string.cb_cleared_chq, new Object[]{Integer.valueOf(list2.size())});
                    k.a((Object) string, "app.applicationContext.g…chq, clearedChqList.size)");
                    list3.add(new SectionDivider(string));
                    bVar.f17515c.addAll(collection2);
                }
            }
        } else if (i2 == 2) {
            b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            return b.a.a();
        } else if (i2 == 3) {
            b.a aVar2 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            return b.a.a(bVar2.f17488c);
        }
        b.a aVar3 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
        return b.a.a(bVar.f17515c, bVar2.f17489d);
    }
}
