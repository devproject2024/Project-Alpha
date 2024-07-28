package net.one97.paytm.passbook.landing.repositories;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.passbook.beans.creditcard.CreditCardInfoResponse;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final b f57766b = new b();

    /* renamed from: net.one97.paytm.passbook.landing.repositories.b$b  reason: collision with other inner class name */
    static final class C1095b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57768a;

        C1095b(x.e eVar) {
            this.f57768a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CreditCardInfoResponse) {
                f.a aVar = f.f57885d;
                ((y) this.f57768a.element).postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private b() {
    }

    public final LiveData<f<CreditCardInfoResponse>> b() {
        x.e eVar = new x.e();
        eVar.element = new y();
        String str = null;
        if (!net.one97.paytm.passbook.utility.f.b(a())) {
            f.a aVar = f.f57885d;
            ((y) eVar.element).postValue(f.a.a(401, null, new net.one97.paytm.passbook.a.a.b()));
        } else {
            Context a2 = a();
            if (a2 != null) {
                str = net.one97.paytm.passbook.utility.f.d(a2);
            }
            e.a();
            String a3 = e.a(str);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            Context a4 = a();
            if (a4 != null) {
                String a5 = net.one97.paytm.passbook.mapping.b.a(a4);
                k.a((Object) a5, "CJRServerUtility.getSSOToken(it)");
                hashMap.put(AppConstants.SSO_TOKEN, a5);
            }
            i.a bVar = new C1095b(eVar);
            g aVar2 = new a(eVar);
            k.a((Object) a3, "paytmMoneyInfoURL");
            IJRDataModel creditCardInfoResponse = new CreditCardInfoResponse();
            k.c(a3, "url");
            k.c(creditCardInfoResponse, "model");
            k.c(bVar, "listener");
            k.c(aVar2, "errorListener");
            net.one97.paytm.passbook.mapping.a.a aVar3 = new net.one97.paytm.passbook.mapping.a.a(a3, bVar, aVar2, creditCardInfoResponse, hashMap, a.c.PASSBOOK, a.b.USER_FACING, "BaseRepository");
            com.paytm.network.b bVar2 = aVar3.f57873a;
            k.a((Object) bVar2, "request.mNetworkCallBuilder");
            bVar2.a(0);
            super.a(aVar3, a3, creditCardInfoResponse, aVar2);
        }
        return (y) eVar.element;
    }

    static final class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57767a;

        a(x.e eVar) {
            this.f57767a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof CreditCardInfoResponse) {
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                ((y) this.f57767a.element).postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
