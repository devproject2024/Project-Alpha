package net.one97.paytm.passbook.mgv.b;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.passbook.beans.mgv.Data;
import net.one97.paytm.passbook.beans.mgv.FetchTransactionsResponse;
import net.one97.paytm.passbook.beans.mgv.GVListData;
import net.one97.paytm.passbook.beans.mgv.ListAllGVResponse;
import net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse;
import net.one97.paytm.passbook.beans.mgv.TransactionListPGResponse;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f57962a = new a();

    private a() {
    }

    public static e a(Context context, int i2, int i3, String str, i.a<IJRDataModel> aVar, g gVar) {
        Context context2 = context;
        String str2 = str;
        k.c(context2, "context");
        k.c(str2, PayUtility.TEMPLATE_ID);
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        String n = b.n(context);
        String a2 = net.one97.paytm.passbook.mapping.b.a(context);
        String e2 = b.e(context2, d.b().c("fetchAllMGVURL"));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotionTool", "GIFT_VOUCHER");
            jSONObject.put("pageSize", i2);
            jSONObject.put(PayUtility.TEMPLATE_ID, str2);
            jSONObject.put("userId", n);
            jSONObject.put("pageNum", i3);
        } catch (JSONException unused) {
        }
        Map hashMap = new HashMap();
        k.a((Object) a2, "ssoToken");
        hashMap.put("ssotoken", a2);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
        return new net.one97.paytm.passbook.mapping.a.b(e2, aVar, gVar, new ListAllGVResponse((GVListData) null, (String) null, (Integer) null, (String) null, (String) null, 31, (kotlin.g.b.g) null), hashMap, jSONObject.toString(), a.c.PASSBOOK, a.b.USER_FACING, a.class.getSimpleName());
    }

    public static e a(Context context, int i2, int i3, String str, String str2, String str3, i.a<IJRDataModel> aVar, g gVar) {
        Context context2 = context;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        k.c(context2, "context");
        k.c(str4, "changedDateStart");
        k.c(str5, "changedDateEnd");
        k.c(str6, "cardNo");
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        String n = b.n(context);
        String a2 = net.one97.paytm.passbook.mapping.b.a(context);
        String e2 = b.e(context2, d.b().c("fetchAllMGVTransactionsURL"));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotionTool", "GIFT_VOUCHER");
            jSONObject.put("pageSize", i2);
            jSONObject.put("pageNum", i3);
            jSONObject.put("changedDateStart", str4);
            jSONObject.put("changedDateEnd", str5);
            jSONObject.put("cardNo", str6);
            jSONObject.put("userId", n);
        } catch (JSONException unused) {
        }
        Map hashMap = new HashMap();
        k.a((Object) a2, "ssoToken");
        hashMap.put("ssotoken", a2);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
        return new net.one97.paytm.passbook.mapping.a.b(e2, aVar, gVar, new FetchTransactionsResponse((TransactionListPGResponse) null, (String) null, (Integer) null, (String) null, (String) null, 31, (kotlin.g.b.g) null), hashMap, jSONObject.toString(), a.c.PASSBOOK, a.b.USER_FACING, a.class.getSimpleName());
    }

    public static e a(Context context, i.a<IJRDataModel> aVar, g gVar) {
        Context context2 = context;
        k.c(context2, "context");
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
        String e2 = b.e(context2, net.one97.paytm.passbook.mapping.e.A());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotionTool", "GIFT_VOUCHER");
            jSONObject.put("userId", b.n(context));
        } catch (JSONException unused) {
        }
        Map hashMap = new HashMap();
        String a2 = net.one97.paytm.passbook.mapping.b.a(context);
        k.a((Object) a2, "CJRServerUtility.getSSOToken(context)");
        hashMap.put("ssotoken", a2);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
        return new net.one97.paytm.passbook.mapping.a.b(e2, aVar, gVar, new ListAllTemplateResponse((Data) null, (String) null, (Integer) null, (String) null, (String) null, 31, (kotlin.g.b.g) null), hashMap, jSONObject.toString(), a.c.PASSBOOK, a.b.USER_FACING, a.class.getSimpleName());
    }
}
