package net.one97.paytm.passbook.landing.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.goldv2.GoldCustomer;
import net.one97.paytm.passbook.beans.goldv2.GoldError;
import net.one97.paytm.passbook.beans.goldv2.GoldResponse;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.i;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final c f57769b = new c();

    static final class a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57770a;

        a(y yVar) {
            this.f57770a = yVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof GoldResponse) {
                y yVar = this.f57770a;
                f.a aVar = f.f57885d;
                yVar.postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private c() {
    }

    public static LiveData<f<GoldResponse>> b() {
        String a2;
        y yVar = new y();
        String a3 = d.b().a("passPaytmGoldURL");
        if (a3 != null) {
            aa aaVar = aa.f47921a;
            String format = String.format(a3, Arrays.copyOf(new Object[]{net.one97.paytm.passbook.mapping.a.n(f57769b.a())}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            Map hashMap = new HashMap();
            if (!(f57769b.a() == null || (a2 = com.paytm.utility.d.a(f57769b.a())) == null)) {
                hashMap.put(AppConstants.SSO_TOKEN, a2);
            }
            f57769b.a(format, new GoldResponse((GoldCustomer) null, (GoldError) null, (String) null, (String) null, 15, (g) null), hashMap, new a(yVar), new b(yVar));
        }
        return yVar;
    }

    static final class b implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57771a;

        b(y yVar) {
            this.f57771a = yVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof GoldResponse) {
                y yVar = this.f57771a;
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
