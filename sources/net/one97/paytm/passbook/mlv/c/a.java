package net.one97.paytm.passbook.mlv.c;

import android.content.Context;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.passbook.beans.mlv.MLVListResponse;
import net.one97.paytm.passbook.beans.mlv.MLVResponse;
import net.one97.paytm.passbook.beans.mlv.MLVTransactionListResponse;
import net.one97.paytm.passbook.beans.mlv.MLVTransactionResponse;
import net.one97.paytm.passbook.beans.mlv.MLoyalResponse;
import net.one97.paytm.passbook.beans.mlv.MLoyalResponseStatus;
import net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse;
import net.one97.paytm.passbook.beans.mlv.Response;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f58097a = new a();

    private a() {
    }

    public static e a(Context context, int i2, int i3, i.a<IJRDataModel> aVar, g gVar) {
        k.c(context, "mContext");
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        String a2 = d.b().a("mlvBaseURL");
        String e2 = b.e(context, a2 + d.b().a("mlvListAllTemplatesUrl"));
        k.a((Object) e2, "CJRAppCommonUtility.addA… mListAllMLVTemplatesUrl)");
        JSONObject jSONObject = new JSONObject();
        try {
            String a3 = d.b().a("mlvLoyaltyPromotionTool");
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject2.put("promotionTool", a3);
            jSONObject2.put("pageNum", String.valueOf(i3));
            jSONObject2.put("pageSize", String.valueOf(i2));
            jSONObject3.put("body", jSONObject2);
            jSONObject.put("request", jSONObject3);
        } catch (JSONException unused) {
        }
        Map hashMap = new HashMap();
        String a4 = com.paytm.utility.d.a(context);
        k.a((Object) a4, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put("ssotoken", a4);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
        return new net.one97.paytm.passbook.mapping.a.b(e2, aVar, gVar, new MlvTemplateListResponse((Response) null, 1, (kotlin.g.b.g) null), hashMap, jSONObject.toString(), a.c.PASSBOOK, a.b.USER_FACING, a.class.getSimpleName());
    }

    public static e a(Context context, int i2, int i3, String str, i.a<IJRDataModel> aVar, g gVar) {
        Context context2 = context;
        String str2 = str;
        k.c(context, "mContext");
        k.c(str2, PayUtility.TEMPLATE_ID);
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        String a2 = d.b().a("mlvBaseURL");
        String e2 = b.e(context, a2 + d.b().a("mlvListAllMLVurl"));
        k.a((Object) e2, "CJRAppCommonUtility.addA…mContext, mListAllMLVUrl)");
        JSONObject jSONObject = new JSONObject();
        try {
            String a3 = d.b().a("mlvLoyaltyPromotionTool");
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject2.put("promotionTool", a3);
            jSONObject2.put("pageNum", String.valueOf(i3));
            jSONObject2.put(PayUtility.TEMPLATE_ID, str2);
            jSONObject2.put("pageSize", String.valueOf(i2));
            jSONObject3.put("body", jSONObject2);
            jSONObject.put("request", jSONObject3);
        } catch (JSONException unused) {
        }
        Map hashMap = new HashMap();
        String a4 = com.paytm.utility.d.a(context);
        k.a((Object) a4, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put("ssotoken", a4);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
        return new net.one97.paytm.passbook.mapping.a.b(e2, aVar, gVar, new MLVListResponse((MLVResponse) null, 1, (kotlin.g.b.g) null), hashMap, jSONObject.toString(), a.c.PASSBOOK, a.b.USER_FACING, a.class.getSimpleName());
    }

    public static e b(Context context, int i2, int i3, String str, i.a<IJRDataModel> aVar, g gVar) {
        Context context2 = context;
        String str2 = str;
        k.c(context, "mContext");
        k.c(str2, "cardNo");
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        String a2 = d.b().a("mlvBaseURL");
        String e2 = b.e(context, a2 + d.b().a("mlvGetAllTransactions"));
        k.a((Object) e2, "CJRAppCommonUtility.addA…mContext, mListAllMLVUrl)");
        JSONObject jSONObject = new JSONObject();
        try {
            String a3 = d.b().a("mlvLoyaltyPromotionTool");
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject2.put("promotionTool", a3);
            jSONObject2.put("pageNum", String.valueOf(i3));
            jSONObject2.put("cardNo", str2);
            jSONObject2.put("pageSize", String.valueOf(i2));
            jSONObject3.put("body", jSONObject2);
            jSONObject.put("request", jSONObject3);
        } catch (JSONException unused) {
        }
        Map hashMap = new HashMap();
        String a4 = com.paytm.utility.d.a(context);
        k.a((Object) a4, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put("ssotoken", a4);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
        return new net.one97.paytm.passbook.mapping.a.b(e2, aVar, gVar, new MLVTransactionResponse((MLVTransactionListResponse) null, 1, (kotlin.g.b.g) null), hashMap, jSONObject.toString(), a.c.PASSBOOK, a.b.USER_FACING, a.class.getSimpleName());
    }

    public static e a(Context context, i.a<IJRDataModel> aVar, g gVar) {
        k.c(context, "mContext");
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        String e2 = b.e(context, d.b().a("passMLoyalURL"));
        Map hashMap = new HashMap();
        String a2 = com.paytm.utility.d.a(context);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put(AppConstants.SSO_TOKEN, a2);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
        return new net.one97.paytm.passbook.mapping.a.a(e2, aVar, gVar, new MLoyalResponse((ArrayList) null, (MLoyalResponseStatus) null, 3, (kotlin.g.b.g) null), hashMap, a.c.PASSBOOK, a.b.USER_FACING, a.class.getSimpleName());
    }
}
