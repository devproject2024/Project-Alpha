package net.one97.paytm.managebeneficiary;

import android.content.Context;
import android.webkit.URLUtil;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    public static void a(Context context, BeneficiaryEntity beneficiaryEntity, final b bVar) {
        String addBeneficiaryURL = f.a().addBeneficiaryURL(context);
        if (URLUtil.isValidUrl(addBeneficiaryURL)) {
            String e2 = com.paytm.utility.b.e(context, addBeneficiaryURL);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", f.a().getSSOToken(context));
            hashMap.put("Content-Type", "text/plain");
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.put(new JSONObject(new f().a((Object) beneficiaryEntity)));
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = context;
            bVar2.f42882f = hashMap;
            bVar2.f42884h = jSONArray.toString();
            bVar2.f42878b = a.c.PAYMENTSBANK;
            bVar2.f42879c = a.C0715a.POST;
            bVar2.n = a.b.USER_FACING;
            bVar2.o = context.getClass().getSimpleName();
            bVar2.f42880d = e2;
            bVar2.f42885i = new CJRAddBeneficiary();
            bVar2.j = new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    bVar.onApiSuccess(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                }
            };
            bVar2.l().a();
        }
    }

    public static void a(Context context, BeneficiaryEntity beneficiaryEntity, final Response.Listener<IJRPaytmDataModel> listener, final Response.ErrorListener errorListener) {
        String editBeneficiaryURL = f.a().editBeneficiaryURL(context);
        if (URLUtil.isValidUrl(editBeneficiaryURL)) {
            String e2 = com.paytm.utility.b.e(context, editBeneficiaryURL);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", f.a().getSSOToken(context));
            hashMap.put("Content-Type", "application/json");
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.put(new JSONObject(new f().a((Object) beneficiaryEntity)));
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            a a2 = f.a(context, e2, new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    listener.onResponse(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    errorListener.onErrorResponse((VolleyError) null);
                }
            }, hashMap, a.C0715a.POST, jSONArray.toString(), new CJRAddBeneficiary(), a.c.HOME, a.b.SILENT);
            if (com.paytm.utility.b.c(context)) {
                a2.a();
            } else {
                net.one97.paytm.managebeneficiary.b.a.a(a2, context);
            }
        }
    }
}
