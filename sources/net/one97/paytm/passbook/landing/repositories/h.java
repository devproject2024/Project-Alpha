package net.one97.paytm.passbook.landing.repositories;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2;
import net.one97.paytm.passbook.beans.DataInfo;
import net.one97.paytm.passbook.beans.MetaInfo;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;

public final class h extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final h f57790b = new h();

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57792a;

        b(x.e eVar) {
            this.f57792a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRPaytmMoneyInfoV2) {
                f.a aVar = f.f57885d;
                ((y) this.f57792a.element).postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private h() {
    }

    public final LiveData<f<CJRPaytmMoneyInfoV2>> b() {
        x.e eVar = new x.e();
        eVar.element = new y();
        if (!net.one97.paytm.passbook.utility.f.b(a())) {
            f.a aVar = f.f57885d;
            ((y) eVar.element).postValue(f.a.a(401, null, new net.one97.paytm.passbook.a.a.b()));
        } else {
            String d2 = net.one97.paytm.passbook.utility.f.d(a());
            try {
                aa aaVar = aa.f47921a;
                String a2 = d.b().a("passPaytmMoneyV2URL");
                k.a((Object) a2, "PassbookHelper.getImplLi….PASS_PAYTM_MONEY_V2_URL)");
                String format = String.format(a2, Arrays.copyOf(new Object[]{d2}, 1));
                k.a((Object) format, "java.lang.String.format(format, *args)");
                Map hashMap = new HashMap();
                Context a3 = a();
                if (a3 != null) {
                    String a4 = net.one97.paytm.passbook.mapping.b.a(a3);
                    k.a((Object) a4, "CJRServerUtility.getSSOToken(it)");
                    hashMap.put("x-sso-token", a4);
                }
                String m = com.paytm.utility.b.m();
                k.a((Object) m, "CJRAppCommonUtility.getAuthorizationValue()");
                hashMap.put("Authorization", m);
                HashMap hashMap2 = new HashMap();
                String Q = com.paytm.utility.b.Q(a());
                k.a((Object) Q, "CJRAppCommonUtility.getAppVersionName(context)");
                hashMap2.put("app_version", Q);
                String c2 = com.paytm.utility.b.c();
                k.a((Object) c2, "CJRAppCommonUtility.getDeviceModelName()");
                hashMap2.put("model", c2);
                hashMap2.put("os_version", String.valueOf(com.paytm.utility.b.d()));
                String d3 = net.one97.paytm.passbook.utility.f.d(a());
                if (d3 != null) {
                    hashMap2.put("user_id", d3);
                }
                hashMap2.put("platform", "android");
                String b2 = new com.google.gson.f().b(hashMap2);
                if (b2 != null) {
                    hashMap.put("x-user-agent", b2);
                }
                i.a bVar = new b(eVar);
                g aVar2 = new a(eVar);
                if (format != null) {
                    f57790b.a(format, new CJRPaytmMoneyInfoV2((DataInfo) null, (MetaInfo) null, 3, (kotlin.g.b.g) null), hashMap, bVar, aVar2);
                }
            } catch (Exception e2) {
                l.a((Throwable) e2);
            }
        }
        return (y) eVar.element;
    }

    static final class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57791a;

        a(x.e eVar) {
            this.f57791a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof CJRPaytmMoneyInfoV2) {
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                ((y) this.f57791a.element).postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
