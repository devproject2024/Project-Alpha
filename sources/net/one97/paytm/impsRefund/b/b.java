package net.one97.paytm.impsRefund.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.l;
import net.one97.paytm.common.entity.impsdatamodel.CJRAddRefundAmount;
import net.one97.paytm.common.entity.impsdatamodel.CJRFetchRefundAccount;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.impsRefund.b.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50588a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private static String f50589c = "requestId";

    /* renamed from: d  reason: collision with root package name */
    private static String f50590d = StringSet.token;

    /* renamed from: e  reason: collision with root package name */
    private static String f50591e = "tokenType";

    /* renamed from: f  reason: collision with root package name */
    private static String f50592f = "version";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static b f50593g;

    /* renamed from: b  reason: collision with root package name */
    private final Context f50594b;

    public b(Context context) {
        k.c(context, "context");
        this.f50594b = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(Context context) {
            k.c(context, "context");
            b a2 = b.f50593g;
            if (a2 != null) {
                return a2;
            }
            b bVar = new b(context);
            b.f50593g = bVar;
            return bVar;
        }
    }

    public final void a(a.C0917a aVar) {
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a2 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, this.f50594b);
        k.a((Object) a2, "ApplaunchUtility.addSSOT…nHeader(headers, context)");
        String b2 = com.paytm.utility.c.b(net.one97.paytm.common.b.d.b().a("fetch_refund_account"), this.f50594b);
        if (URLUtil.isValidUrl(b2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("head", a(this.f50594b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("channelId", "APP");
                jSONObject.put("body", jSONObject2);
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
            if (com.paytm.utility.a.m(this.f50594b)) {
                net.one97.paytm.common.b.d.a(this.f50594b, b2, new c(aVar), a2, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRFetchRefundAccount(), a.c.PAYMENTS, a.b.USER_FACING).a();
                return;
            }
            Context context = this.f50594b;
            com.paytm.utility.b.b(context, "", context.getResources().getString(R.string.no_internet));
            return;
        }
        Context context2 = this.f50594b;
        com.paytm.utility.b.b(context2, "", context2.getResources().getString(R.string.msg_invalid_url));
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.C0917a f50596a;

        c(a.C0917a aVar) {
            this.f50596a = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            this.f50596a.a(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f50596a.a(networkCustomError);
        }
    }

    public final void a(a.C0917a aVar, String str, String str2, String str3, String str4, String str5) {
        String[] strArr;
        JSONObject jSONObject;
        List<String> split;
        a.C0917a aVar2 = aVar;
        k.c(aVar2, H5Event.TYPE_CALL_BACK);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a2 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, this.f50594b);
        k.a((Object) a2, "ApplaunchUtility.addSSOT…nHeader(headers, context)");
        String b2 = com.paytm.utility.c.b(net.one97.paytm.common.b.d.b().a("add_refund_account"), this.f50594b);
        if (URLUtil.isValidUrl(b2)) {
            if (str == null || (split = new l(" ").split(str, 2)) == null) {
                strArr = null;
            } else {
                Object[] array = split.toArray(new String[0]);
                if (array != null) {
                    strArr = (String[]) array;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            if (strArr == null) {
                k.a();
            }
            if (strArr.length > 1) {
                jSONObject = a(this.f50594b, str2, str3, str4, strArr[0], strArr[1], str5);
            } else {
                jSONObject = a(this.f50594b, str2, str3, str4, str, "", str5);
            }
            if (com.paytm.utility.a.m(this.f50594b)) {
                net.one97.paytm.common.b.d.a(this.f50594b, b2, new C0918b(aVar2), a2, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRAddRefundAmount(), a.c.PAYMENTS, a.b.USER_FACING).a();
                return;
            }
            Context context = this.f50594b;
            com.paytm.utility.b.b(context, "", context.getResources().getString(R.string.no_internet));
            return;
        }
        Context context2 = this.f50594b;
        com.paytm.utility.b.b(context2, "", context2.getResources().getString(R.string.msg_invalid_url));
    }

    /* renamed from: net.one97.paytm.impsRefund.b.b$b  reason: collision with other inner class name */
    public static final class C0918b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.C0917a f50595a;

        C0918b(a.C0917a aVar) {
            this.f50595a = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            this.f50595a.a(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f50595a.a(networkCustomError);
        }
    }

    private final JSONObject a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (TextUtils.isEmpty(str6)) {
                jSONObject2.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put("ifsc", str2);
                }
                jSONObject2.put("bankName", str3);
            } else {
                jSONObject2.put("upiAccountId", str6);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("firstName", str4);
            jSONObject3.put("lastName", str5);
            jSONObject2.put("holderName", jSONObject3);
            jSONObject2.put("channelId", "APP");
            jSONObject2.put("deviceId", com.paytm.utility.b.v(this.f50594b));
            jSONObject.put("head", a(context));
            jSONObject.put("body", jSONObject2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f50589c, com.paytm.utility.b.v(context) + System.currentTimeMillis());
            jSONObject.put(SDKConstants.KEY_REQUEST_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject.put(f50590d, com.paytm.utility.a.q(context));
            String str = f50591e;
            String a2 = com.paytm.utility.b.a();
            k.a((Object) a2, "CJRAppCommonUtility.getTokenType()");
            String upperCase = a2.toUpperCase();
            k.b(upperCase, "(this as java.lang.String).toUpperCase()");
            jSONObject.put(str, upperCase);
            jSONObject.put(f50592f, "2.0");
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public final void a(a.C0917a aVar, String str) {
        a.C0917a aVar2 = aVar;
        String str2 = str;
        k.c(aVar2, H5Event.TYPE_CALL_BACK);
        k.c(str2, "assetId");
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a2 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, this.f50594b);
        k.a((Object) a2, "ApplaunchUtility.addSSOT…nHeader(headers, context)");
        String b2 = com.paytm.utility.c.b(net.one97.paytm.common.b.d.b().a("remove_refund_account"), this.f50594b);
        if (URLUtil.isValidUrl(b2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("head", a(this.f50594b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assetId", str2);
                jSONObject2.put("channelId", "APP");
                jSONObject.put("body", jSONObject2);
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
            if (com.paytm.utility.a.m(this.f50594b)) {
                net.one97.paytm.common.b.d.a(this.f50594b, b2, new d(aVar2), a2, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRFetchRefundAccount(), a.c.PAYMENTS, a.b.USER_FACING).a();
                return;
            }
            Context context = this.f50594b;
            com.paytm.utility.b.b(context, "", context.getResources().getString(R.string.no_internet));
            return;
        }
        Context context2 = this.f50594b;
        com.paytm.utility.b.b(context2, "", context2.getResources().getString(R.string.msg_invalid_url));
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.C0917a f50597a;

        d(a.C0917a aVar) {
            this.f50597a = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "dataModel");
            this.f50597a.a(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f50597a.a(networkCustomError);
        }
    }
}
