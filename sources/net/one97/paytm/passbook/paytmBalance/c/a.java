package net.one97.paytm.passbook.paytmBalance.c;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends net.one97.paytm.passbook.landing.repositories.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f58205b = new a();

    /* renamed from: net.one97.paytm.passbook.paytmBalance.c.a$a  reason: collision with other inner class name */
    static final class C1119a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f58206a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f58207b;

        C1119a(y yVar, String str) {
            this.f58206a = yVar;
            this.f58207b = str;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRLedger) {
                y yVar = this.f58206a;
                f.a aVar = f.f57885d;
                yVar.postValue(f.a.a(iJRDataModel));
            }
        }
    }

    private a() {
    }

    public static LiveData<f<CJRLedger>> a(String str, int i2) {
        k.c(str, "selectedFilter");
        y yVar = new y();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userGuid", "");
        jSONObject2.put("startLimit", i2);
        jSONObject2.put("lastLimit", 20);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("subWalletType", new JSONArray(kotlin.a.k.b((T[]) new String[]{"PAYTM WALLET", "GIFT", "BLOCKED", "TOLL", "CLOSED_LOOP_SUB_WALLET", "FUEL", "INTERNATIONAL_FUNDS_TRANSFER", "GIFT_VOUCHER", "COMMUNICATION"})));
        jSONObject2.put("subWalletParams", jSONObject3);
        if (TextUtils.isEmpty(str)) {
            jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
        } else {
            jSONObject2.put("walletTransactiontype", str);
        }
        jSONObject.put("request", jSONObject2);
        String jSONObject4 = jSONObject.toString();
        k.a((Object) jSONObject4, "jsonObject.toString()");
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String i3 = e.i();
        if (i3 != null) {
            String e2 = com.paytm.utility.b.e(f58205b.a(), i3);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept-Encoding", "gzip");
            String a2 = net.one97.paytm.passbook.mapping.b.a(f58205b.a());
            if (a2 != null) {
                hashMap.put("ssotoken", a2);
            }
            a aVar = f58205b;
            k.a((Object) e2, "mLedgerUrl");
            aVar.a(e2, new CJRLedger(), hashMap, jSONObject4, new C1119a(yVar, jSONObject4), new b(yVar, jSONObject4));
        }
        return yVar;
    }

    static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f58208a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f58209b;

        b(y yVar, String str) {
            this.f58208a = yVar;
            this.f58209b = str;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof CJRLedger) {
                y yVar = this.f58208a;
                f.a aVar = f.f57885d;
                k.a((Object) networkCustomError, "networkError");
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }
}
