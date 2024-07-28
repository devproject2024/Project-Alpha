package net.one97.paytm.paymentsBank.si.d;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CJRAddBeneficiary;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.si.response.AllSIResponse;
import net.one97.paytm.paymentsBank.si.response.SIActivateResponse;
import net.one97.paytm.paymentsBank.si.response.SICreationResponse;
import net.one97.paytm.paymentsBank.si.response.SIEndDateResponse;
import net.one97.paytm.paymentsBank.si.response.SIPrevalidateResponse;
import net.one97.paytm.paymentsBank.si.response.SITransactionListResponse;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static f a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Authorization", com.paytm.utility.a.q(context));
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        d.b();
        String a2 = d.a("siAllList");
        if (!URLUtil.isValidUrl(a2)) {
            return null;
        }
        String e2 = b.e(context, a2);
        net.one97.paytm.bankCommon.b.b bVar3 = new net.one97.paytm.bankCommon.b.b();
        bVar3.a(e2, bVar, aVar, new AllSIResponse(), hashMap2, cVar, bVar2, hashMap);
        return bVar3.a();
    }

    public static f a(Context context, String str, String str2, int i2, String str3, long j, long j2, double d2, String str4, String str5, String str6, String str7, String str8, String str9, int i3, g.b<IJRPaytmDataModel> bVar, g.a aVar, String str10, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Authorization", str10);
            hashMap2.put("Content-Type", "application/json");
            hashMap2.put("channel", UpiConstants.B2C_ANDROID);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("destinationIfsc", str6);
            jSONObject.put("beneficiaryName", str7);
            jSONObject.put("displayName", str8);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("client", UpiConstants.B2C_ANDROID);
            jSONObject2.put("sourceAccountNumber", str5);
            jSONObject2.put("dayOfWeekIndex", str4);
            jSONObject2.put("amount", d2);
            String str11 = str2;
            jSONObject2.put("frequency", str2);
            String str12 = str3;
            jSONObject2.put("type", str3);
            long j3 = j2;
            jSONObject2.put("endDate", j2);
            long j4 = j;
            jSONObject2.put("startDate", j);
            int i4 = i2;
            jSONObject2.put("dateIndex", i2);
            jSONObject2.put("supportingData", jSONObject);
            jSONObject2.put("monthIndex", str9);
            String str13 = str;
            jSONObject2.put("beneficiaryId", str);
            jSONObject2.put("paymentCount", i3);
            String jSONObject3 = jSONObject2.toString();
            d.b();
            String a2 = d.a("siAddNew");
            if (!URLUtil.isValidUrl(a2)) {
                return null;
            }
            Context context2 = context;
            String e2 = b.e(context, a2);
            net.one97.paytm.bankCommon.b.b bVar3 = new net.one97.paytm.bankCommon.b.b();
            bVar3.a(e2, bVar, aVar, new SICreationResponse(), hashMap2, jSONObject3, a.C0715a.POST, cVar, bVar2, hashMap);
            return bVar3.a();
        } catch (Exception e3) {
            q.b(e3.getMessage());
            return null;
        }
    }

    public static f a(Context context, String str, String str2, int i2, String str3, long j, long j2, double d2, String str4, String str5, String str6, String str7, String str8, String str9, int i3, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Authorization", com.paytm.utility.a.q(context));
            hashMap2.put("Content-Type", "application/json");
            hashMap2.put("channel", UpiConstants.B2C_ANDROID);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("destinationIfsc", str6);
            jSONObject.put("beneficiaryName", str7);
            jSONObject.put("displayName", str8);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("client", UpiConstants.B2C_ANDROID);
            jSONObject2.put("sourceAccountNumber", str5);
            jSONObject2.put("dayOfWeekIndex", str4);
            jSONObject2.put("amount", d2);
            String str10 = str2;
            jSONObject2.put("frequency", str2);
            String str11 = str3;
            jSONObject2.put("type", str3);
            long j3 = j2;
            jSONObject2.put("endDate", j2);
            long j4 = j;
            jSONObject2.put("startDate", j);
            int i4 = i2;
            jSONObject2.put("dateIndex", i2);
            jSONObject2.put("supportingData", jSONObject);
            jSONObject2.put("monthIndex", str9);
            String str12 = str;
            jSONObject2.put("beneficiaryId", str);
            jSONObject2.put("paymentCount", i3);
            String jSONObject3 = jSONObject2.toString();
            d.b();
            String a2 = d.a("siPrevalidate");
            if (!URLUtil.isValidUrl(a2)) {
                return null;
            }
            Context context2 = context;
            String e2 = b.e(context, a2);
            net.one97.paytm.bankCommon.b.b bVar3 = new net.one97.paytm.bankCommon.b.b();
            bVar3.a(e2, bVar, aVar, new SIPrevalidateResponse(), hashMap2, jSONObject3, a.C0715a.POST, cVar, bVar2, hashMap);
            return bVar3.a();
        } catch (Exception e3) {
            q.b(e3.getMessage());
            return null;
        }
    }

    public static f a(Context context, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        String str3 = str;
        hashMap2.put("Authorization", str);
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        hashMap2.put("Content-Type", "application/json");
        d.b();
        String a2 = d.a("siResume");
        if (!URLUtil.isValidUrl(a2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append("&siId=");
        String str4 = str2;
        sb.append(str2);
        String sb2 = sb.toString();
        Context context2 = context;
        String e2 = b.e(context, sb2);
        net.one97.paytm.bankCommon.b.b bVar3 = new net.one97.paytm.bankCommon.b.b();
        bVar3.a(e2, bVar, aVar, new SIActivateResponse(), hashMap2, (String) null, a.C0715a.PUT, cVar, bVar2, hashMap);
        return bVar3.a();
    }

    public static f b(Context context, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        d.b();
        String a2 = d.a("siTransactionHistory");
        if (!URLUtil.isValidUrl(a2)) {
            return null;
        }
        Context context2 = context;
        String e2 = b.e(context, a2);
        try {
            HashMap hashMap2 = new HashMap();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userToken", com.paytm.utility.a.q(context));
            hashMap2.put("authorization", jSONObject.toString());
            hashMap2.put("channel", UpiConstants.B2C_ANDROID);
            JSONObject jSONObject2 = new JSONObject();
            String str3 = str;
            jSONObject2.put("siId", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("client", "androidapp");
            jSONObject3.put("limit", 20);
            jSONObject3.put("apiType", "transactionHistory");
            jSONObject3.put("accountType", "isa");
            jSONObject3.put("properties", jSONObject2);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject3.put("middlewareId", str2);
            }
            String jSONObject4 = jSONObject3.toString();
            net.one97.paytm.bankCommon.b.b bVar3 = new net.one97.paytm.bankCommon.b.b();
            bVar3.a(e2, bVar, aVar, new SITransactionListResponse(), hashMap2, jSONObject4, a.C0715a.POST, cVar, bVar2, hashMap);
            return bVar3.a();
        } catch (Exception unused) {
            return null;
        }
    }

    public static f b(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        d.b();
        String a2 = d.a("siGetTnc");
        if (!URLUtil.isValidUrl(a2)) {
            return null;
        }
        return new net.one97.paytm.bankCommon.g.a(b.e(context, a2), bVar, aVar, new PBKYCFetchTnc(), a(context), cVar, bVar2, hashMap);
    }

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("client_id", b.k());
        hashMap.put("client_secret", b.l());
        hashMap.put("session_token", com.paytm.utility.a.q(context));
        hashMap.put("Authorization", b.m());
        if (com.paytm.utility.d.b(context) != null) {
            hashMap.put("cart_id", com.paytm.utility.d.b(context));
        }
        return hashMap;
    }

    public static f a(Context context, ArrayList<PBTncData> arrayList, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        Context context2 = context;
        d.a();
        String a2 = d.a("kyc_tnc_user_url");
        if (!URLUtil.isValidUrl(a2)) {
            return null;
        }
        String e2 = b.e(context, a2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", "clickthrough");
            context.getSystemService(ContactColumn.PHONE_NUMBER);
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
            q.b(e3.getMessage());
        }
        String jSONObject3 = jSONObject.toString();
        return new net.one97.paytm.bankCommon.g.b(e2, bVar, aVar, (IJRPaytmDataModel) new PBKYCTncAccept(), (Map<String, String>) null, a(context), jSONObject3, a.C0715a.PUT, cVar, bVar2, hashMap);
    }

    public static f a(Context context, Map<String, String> map, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        try {
            d.b();
            String a2 = d.a("addBeneficiaryKYC");
            if (!URLUtil.isValidUrl(a2)) {
                return null;
            }
            Context context2 = context;
            return new net.one97.paytm.bankCommon.g.b(b.e(context, a2), bVar, aVar, new CJRAddBeneficiary(), map, str, cVar, bVar2, hashMap);
        } catch (Exception unused) {
            return null;
        }
    }

    public static f a(Context context, long j, String str, String str2, int i2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Accept", "application/json");
            hashMap2.put("Authorization", com.paytm.utility.a.q(context));
            d.b();
            String a2 = d.a("si_get_end_date");
            if (!URLUtil.isValidUrl(a2)) {
                return null;
            }
            Context context2 = context;
            String e2 = b.e(context, a2);
            StringBuilder sb = new StringBuilder();
            sb.append(e2);
            sb.append("&startDate=");
            long j2 = j;
            sb.append(j);
            sb.append("&frequency=");
            String str4 = str;
            sb.append(str);
            sb.append("&paymentCount=");
            String str5 = str2;
            sb.append(str2);
            sb.append("&dateIndex=");
            sb.append(i2);
            sb.append("&destinationIfsc=");
            sb.append(str3);
            return new net.one97.paytm.bankCommon.g.a(sb.toString(), bVar, aVar, new SIEndDateResponse(), hashMap2, cVar, bVar2, hashMap);
        } catch (Exception unused) {
            return null;
        }
    }
}
