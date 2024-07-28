package net.one97.paytm.passbook.landing.repositories;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.passbook.beans.mgv.Data;
import net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final d f57772b = new d();

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57774a;

        b(x.e eVar) {
            this.f57774a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof ListAllTemplateResponse) {
                f.a aVar = f.f57885d;
                ((y) this.f57774a.element).postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private d() {
    }

    public final LiveData<f<ListAllTemplateResponse>> b() {
        String c2;
        x.e eVar = new x.e();
        eVar.element = new y();
        if (!net.one97.paytm.passbook.utility.f.b(b.f57766b.a())) {
            f.a aVar = f.f57885d;
            ((y) eVar.element).postValue(f.a.a(401, null, new net.one97.paytm.passbook.a.a.b()));
        } else {
            String e2 = com.paytm.utility.b.e(a(), net.one97.paytm.passbook.d.b().c("fetchAllMGVTemplatesURL"));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("promotionTool", "GIFT_VOUCHER");
                String d2 = net.one97.paytm.passbook.utility.f.d(a());
                if (d2 != null) {
                    jSONObject.put("userId", d2);
                }
            } catch (JSONException unused) {
            }
            Map hashMap = new HashMap();
            Context a2 = a();
            if (!(a2 == null || (c2 = net.one97.paytm.passbook.utility.f.c(a2)) == null)) {
                hashMap.put("ssotoken", c2);
            }
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Content-Type", "application/json");
            k.a((Object) e2, "mListAllMGVTemplatesUrl");
            a(e2, new ListAllTemplateResponse((Data) null, (String) null, (Integer) null, (String) null, (String) null, 31, (g) null), hashMap, jSONObject.toString(), new b(eVar), new a(eVar));
        }
        return (y) eVar.element;
    }

    static final class a implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57773a;

        a(x.e eVar) {
            this.f57773a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof ListAllTemplateResponse) {
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                ((y) this.f57773a.element).postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
