package net.one97.paytm.paymentsBank.chequebook.leaflist;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import kotlin.g.b.k;
import kotlin.m;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.b;
import net.one97.paytm.paymentsBank.chequebook.utils.e;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse;

public final class b extends net.one97.paytm.paymentsBank.chequebook.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<Integer> f17602a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public String f17603b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveData<net.one97.paytm.paymentsBank.chequebook.b<CbStopPaymentResponse>> f17604c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Application f17605d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final g f17606e;

    static final class a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f17607a;

        a(b bVar) {
            this.f17607a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Integer num = (Integer) obj;
            g a2 = this.f17607a.f17606e;
            String b2 = b.b(this.f17607a);
            String string = this.f17607a.f17605d.getString(R.string.cb_block_reason);
            k.a((Object) string, "app.getString(R.string.cb_block_reason)");
            k.a((Object) num, "it");
            int intValue = num.intValue();
            e eVar = e.f17951a;
            return ah.a(a2.a(b2, string, intValue, e.i()), new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f17608a;

                {
                    this.f17608a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
                    k.a((Object) bVar, "it");
                    return b.a(bVar);
                }
            });
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application, g gVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(gVar, "cbRepository");
        this.f17605d = application;
        this.f17606e = gVar;
        LiveData<net.one97.paytm.paymentsBank.chequebook.b<CbStopPaymentResponse>> b2 = ah.b(this.f17602a, new a(this));
        k.a((Object) b2, "Transformations.switchMa…del(it)\n        }\n\n\n    }");
        this.f17604c = b2;
    }

    public static final /* synthetic */ String b(b bVar) {
        String str = bVar.f17603b;
        if (str == null) {
            k.a("bankScopeToken");
        }
        return str;
    }

    public static final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.b a(net.one97.paytm.paymentsBank.chequebook.b bVar) {
        int i2 = c.f17609a[bVar.f17486a.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
                return b.a.a();
            } else if (i2 == 3) {
                b.a aVar2 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
                return b.a.a(bVar.f17488c);
            } else {
                throw new m();
            }
        } else if (bVar.f17487b != null) {
            b.a aVar3 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            ResultType resulttype = bVar.f17487b;
            if (resulttype == null) {
                k.a();
            }
            return b.a.a(resulttype, false);
        } else {
            b.a aVar4 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            return b.a.a(bVar.f17488c);
        }
    }
}
