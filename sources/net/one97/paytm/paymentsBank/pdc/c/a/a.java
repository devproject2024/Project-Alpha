package net.one97.paytm.paymentsBank.pdc.c.a;

import android.content.Context;
import android.webkit.URLUtil;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.bankCommon.f.f;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBCJRAddress;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.bankCommon.utils.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements net.one97.paytm.paymentsBank.pdc.c.b.a {
    public final void a(PBCJRAddress pBCJRAddress, String str, String str2, String str3, Context context, f fVar) {
        f fVar2 = fVar;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.pdc.a.a(context, new g.b() {
                public final void onResponse(Object obj) {
                    f.this.a((IJRPaytmDataModel) obj);
                }
            }, new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    f.this.a(networkCustomError);
                }
            }, str, pBCJRAddress, str2, str3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
            a2.f16270b = getClass().getSimpleName();
            new c();
            c.a(a2);
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }

    public final void a(Context context, ArrayList<PBTncData> arrayList, f fVar) {
        Context context2 = context;
        f fVar2 = fVar;
        net.one97.paytm.bankCommon.mapping.g.a();
        String a2 = d.a("kyc_tnc_user_url");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = b.e(context2, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mode", "clickthrough");
                context2.getSystemService(ContactColumn.PHONE_NUMBER);
                jSONObject.put("deviceId", b.e(context));
                if (arrayList != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<PBTncData> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        PBTncData next = it2.next();
                        if (next != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("code", next.getCode());
                            jSONObject2.put("version", next.getVersion());
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("tnCList", jSONArray);
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            String jSONObject3 = jSONObject.toString();
            Map<String, String> e4 = net.one97.paytm.bankCommon.mapping.d.e(context);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            context.getApplicationContext();
            new c();
            c.a(new net.one97.paytm.bankCommon.g.b(e2, (g.b<IJRPaytmDataModel>) new g.b() {
                public final void onResponse(Object obj) {
                    f.this.a((IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    f.this.a(networkCustomError);
                }
            }, (IJRPaytmDataModel) new PBKYCTncAccept(), (Map<String, String>) null, e4, jSONObject3, a.C0715a.PUT, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap));
        }
    }

    public final void a(Context context, f fVar) {
        d.b();
        String a2 = d.a("bank_tnc");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = b.e(context, a2);
            Map<String, String> e3 = net.one97.paytm.bankCommon.mapping.d.e(context);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            context.getApplicationContext();
            new c();
            c.a(new net.one97.paytm.bankCommon.g.a(e2, new g.b() {
                public final void onResponse(Object obj) {
                    f.this.a((IJRPaytmDataModel) obj);
                }
            }, new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    f.this.a(networkCustomError);
                }
            }, new PBKYCFetchTnc(), e3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
        }
    }
}
