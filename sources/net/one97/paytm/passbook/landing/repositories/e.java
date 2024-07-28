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
import net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse;
import net.one97.paytm.passbook.beans.mlv.Response;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final e f57775b = new e();

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57777a;

        b(x.e eVar) {
            this.f57777a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof MlvTemplateListResponse) {
                f.a aVar = f.f57885d;
                ((y) this.f57777a.element).postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private e() {
    }

    public final LiveData<f<MlvTemplateListResponse>> b() {
        x.e eVar = new x.e();
        eVar.element = new y();
        if (!net.one97.paytm.passbook.utility.f.b(a())) {
            f.a aVar = f.f57885d;
            ((y) eVar.element).postValue(f.a.a(401, null, new net.one97.paytm.passbook.a.a.b()));
        } else {
            String a2 = d.b().a("mlvBaseURL");
            String e2 = com.paytm.utility.b.e(a(), a2 + d.b().a("mlvListAllTemplatesUrl"));
            JSONObject jSONObject = new JSONObject();
            try {
                String a3 = d.b().a("mlvLoyaltyPromotionTool");
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("promotionTool", a3);
                jSONObject3.put("pageNum", "1");
                jSONObject3.put("pageSize", "20");
                jSONObject2.put("body", jSONObject3);
                jSONObject.put("request", jSONObject2);
            } catch (JSONException unused) {
            }
            Map hashMap = new HashMap();
            Context a4 = a();
            if (a4 != null) {
                String a5 = com.paytm.utility.d.a(a4);
                k.a((Object) a5, "CJRNetUtility.getSSOToken(it)");
                hashMap.put("ssotoken", a5);
            }
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Content-Type", "application/json");
            k.a((Object) e2, "mListAllMLVTemplatesUrl");
            a(e2, new MlvTemplateListResponse((Response) null, 1, (g) null), hashMap, jSONObject.toString(), new b(eVar), new a(eVar));
        }
        return (y) eVar.element;
    }

    static final class a implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57776a;

        a(x.e eVar) {
            this.f57776a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof MlvTemplateListResponse) {
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                ((y) this.f57776a.element).postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
