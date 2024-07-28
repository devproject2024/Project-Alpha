package net.one97.paytm.passbook.spendanalytics.e;

import android.content.Context;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsResponse;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<e> f58572a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.passbook.mapping.a.b f58573b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<net.one97.paytm.passbook.mapping.a.b> f58574c = new ArrayList<>();

    /* renamed from: net.one97.paytm.passbook.spendanalytics.e.a$a  reason: collision with other inner class name */
    static final class C1132a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f58575a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58576b;

        C1132a(String str, x.e eVar) {
            this.f58575a = str;
            this.f58576b = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel != null) {
                SpendAnalyticsResponse spendAnalyticsResponse = (SpendAnalyticsResponse) iJRDataModel;
                spendAnalyticsResponse.setSelectedMonth(this.f58575a);
                ((y) this.f58576b.element).postValue(spendAnalyticsResponse);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsResponse");
        }
    }

    public final o<y<SpendAnalyticsResponse>, y<NetworkCustomError>> a(Context context, String str, String str2) {
        Context context2 = context;
        String str3 = str2;
        k.c(context2, "context");
        k.c(str, "requestType");
        k.c(str3, "selectedMonth");
        x.e eVar = new x.e();
        eVar.element = new y();
        x.e eVar2 = new x.e();
        eVar2.element = new y();
        o<y<SpendAnalyticsResponse>, y<NetworkCustomError>> oVar = new o<>((y) eVar.element, (y) eVar2.element);
        String c2 = d.b().c("getSpendAnalyticsURL");
        Map hashMap = new HashMap();
        hashMap.put("Accept-Encoding", "gzip");
        String a2 = net.one97.paytm.passbook.mapping.b.a(context);
        k.a((Object) a2, "CJRServerUtility.getSSOToken(context)");
        hashMap.put("ssotoken", a2);
        hashMap.put("Content-Type", "application/json");
        this.f58573b = new net.one97.paytm.passbook.mapping.a.b(c2, new C1132a(str3, eVar), new b(eVar2), new SpendAnalyticsResponse((String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (String) null, 127, (g) null), hashMap, a(str, str2), a.c.PASSBOOK, a.b.USER_FACING, a.class.getSimpleName());
        net.one97.paytm.passbook.mapping.a.b bVar = this.f58573b;
        if (bVar == null) {
            k.a("request");
        }
        net.one97.paytm.passbook.spendanalytics.a aVar = net.one97.paytm.passbook.spendanalytics.a.f58478a;
        a((e) bVar, context2, net.one97.paytm.passbook.spendanalytics.a.c(str2));
        ArrayList<net.one97.paytm.passbook.mapping.a.b> arrayList = this.f58574c;
        net.one97.paytm.passbook.mapping.a.b bVar2 = this.f58573b;
        if (bVar2 == null) {
            k.a("request");
        }
        arrayList.add(bVar2);
        net.one97.paytm.passbook.mapping.a.b bVar3 = this.f58573b;
        if (bVar3 == null) {
            k.a("request");
        }
        q.b(bVar3.toString());
        return oVar;
    }

    static final class b implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f58577a;

        b(x.e eVar) {
            this.f58577a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkCustomError");
            ((y) this.f58577a.element).postValue(networkCustomError);
        }
    }

    public final void a() {
        int size = this.f58574c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f58574c.get(i2).b();
            q.b(this.f58574c.get(i2).toString());
        }
        this.f58574c.clear();
    }

    private static String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String lowerCase = UpiConstants.FROM.toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        net.one97.paytm.passbook.spendanalytics.a aVar = net.one97.paytm.passbook.spendanalytics.a.f58478a;
        jSONObject2.put(lowerCase, net.one97.paytm.passbook.spendanalytics.a.a(str2));
        net.one97.paytm.passbook.spendanalytics.a aVar2 = net.one97.paytm.passbook.spendanalytics.a.f58478a;
        jSONObject2.put("to", net.one97.paytm.passbook.spendanalytics.a.b(str2));
        jSONObject2.put("metrics", new JSONArray(kotlin.a.k.d("SUM")));
        if (str != null) {
            if (str.contentEquals(r9)) {
                jSONObject2.put("dimensions", new JSONArray(kotlin.a.k.d("CATEGORY", "PAYEE")));
                jSONObject2.put("visualization", "GROUPED_DISTRIBUTION");
            } else {
                if (str == null) {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                } else if (str.contentEquals(r9)) {
                    jSONObject2.put("dimensions", new JSONArray(kotlin.a.k.d("PAYEE")));
                    jSONObject2.put("visualization", "DISTRIBUTION");
                    jSONObject2.put("filters", new JSONArray(kotlin.a.k.d("PAID")));
                } else {
                    if (str == null) {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    } else if (str.contentEquals(r9)) {
                        jSONObject2.put("dimensions", new JSONArray(kotlin.a.k.d("TXN_TYPE")));
                        jSONObject2.put("filters", new JSONArray(kotlin.a.k.d("RECEIVED")));
                        jSONObject2.put("visualization", "DISTRIBUTION");
                    }
                }
            }
            jSONObject.put("request", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            k.a((Object) jSONObject3, "jObjBody.toString()");
            return jSONObject3;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    private static void a(e eVar, Context context, boolean z) {
        net.one97.paytm.passbook.caching.a aVar = new net.one97.paytm.passbook.caching.a(context, !z);
        if (eVar != null) {
            c.a();
            c.a(eVar, aVar);
        }
    }

    public final void onCleared() {
        super.onCleared();
    }
}
