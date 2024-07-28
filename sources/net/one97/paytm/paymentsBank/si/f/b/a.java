package net.one97.paytm.paymentsBank.si.f.b;

import android.content.Context;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CJRAddBeneficiary;
import net.one97.paytm.bankCommon.model.CJRKYCBeneficiaryBase;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.si.f.a;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import org.json.JSONArray;
import org.json.JSONObject;

public class a implements net.one97.paytm.paymentsBank.si.f.a {

    /* renamed from: a  reason: collision with root package name */
    private static a f18901a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18902b = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private Context f18903c;

    private a(Context context) {
        this.f18903c = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f18901a == null) {
                f18901a = new a(context);
            }
            aVar = f18901a;
        }
        return aVar;
    }

    public final void a(a.C0325a aVar, a.b bVar, int i2, int i3) {
        if (b.c(this.f18903c)) {
            Context context = this.f18903c;
            $$Lambda$a$cFrvkofHzvw2LqpY38ad2Q1pZk r2 = new g.b() {
                public final void onResponse(Object obj) {
                    a.b(a.C0325a.this, (IJRPaytmDataModel) obj);
                }
            };
            $$Lambda$a$dDI8EZRUiWvb89GH3pyWNdMQIRo r3 = new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    a.C0325a.this.a(networkCustomError);
                }
            };
            if (context != null) {
                context.getApplicationContext();
                net.one97.paytm.bankCommon.mapping.g.a();
                String a2 = d.a("getBeneficiaryKYC_V2");
                if (URLUtil.isValidUrl(a2)) {
                    String str = b.e(context, a2) + "&offset=" + i2 + "&limit=" + i3 + "&type=otherBank";
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", com.paytm.utility.a.q(context));
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("screen_name", "MoneyTransferBenficiaryHelper");
                    new c();
                    c.a(new net.one97.paytm.bankCommon.g.a(str, r2, r3, new CJRKYCBeneficiaryBase(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2));
                    return;
                }
                return;
            }
            return;
        }
        bVar.a();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(a.C0325a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRKYCBeneficiaryBase)) {
            new CJRKYCBeneficiaryBase();
            aVar.a(new NetworkCustomError());
            return;
        }
        aVar.a(iJRPaytmDataModel);
    }

    public final void a(a.C0325a aVar, String str, String str2, boolean z) {
        a.C0325a aVar2 = aVar;
        Context context = this.f18903c;
        $$Lambda$a$0gQBn5G7a7XALLdDl2ekmWRWDtw r5 = new g.b() {
            public final void onResponse(Object obj) {
                a.C0325a.this.a((IJRPaytmDataModel) obj);
            }
        };
        $$Lambda$a$dMpAaQRXmNLTsVXeI9dUEYnGt8 r6 = new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                a.C0325a.this.a(networkCustomError);
            }
        };
        if (context != null) {
            context.getApplicationContext();
            net.one97.paytm.bankCommon.mapping.g.a();
            String a2 = d.a(UpiConstantServiceApi.DELETE_BENEFICIARY_URL);
            if (URLUtil.isValidUrl(a2)) {
                String e2 = b.e(context, a2);
                HashMap hashMap = new HashMap();
                hashMap.put("session_token", com.paytm.utility.a.q(context));
                hashMap.put("Content-Type", "application/json");
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject4 = new JSONObject();
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("status", StringSet.deleted);
                    jSONObject4.put("settings", jSONObject5);
                    jSONObject4.put("uuid", str);
                    jSONArray2.put(jSONObject4);
                    jSONObject3.put("accounts", jSONArray2);
                    if (z) {
                        jSONObject2.put("upi", jSONObject3);
                    } else {
                        jSONObject2.put("otherBank", jSONObject3);
                    }
                    jSONObject.put("instrumentPreferences", jSONObject2);
                    jSONObject.put("beneficiaryId", str2);
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("screen_name", "MoneyTransferBenficiaryHelper");
                context.getApplicationContext();
                new c();
                c.a(new net.one97.paytm.bankCommon.g.b(e2, (g.b<IJRPaytmDataModel>) r5, (g.a) r6, (IJRPaytmDataModel) new CJRAddBeneficiary(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONArray.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2));
            }
        }
    }
}
