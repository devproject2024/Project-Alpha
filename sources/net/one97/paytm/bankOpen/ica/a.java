package net.one97.paytm.bankOpen.ica;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.bankOpen.ica.model.CAQuestionDetailResponse;
import net.one97.paytm.bankOpen.ica.model.ICAStatusResponse;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16435a = new a();

    private a() {
    }

    public static void a(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "listener");
        k.c(aVar, "errorListener");
        String stringFromGTM = f.a().getStringFromGTM("kycFetchProfileInfoV2");
        if (URLUtil.isValidUrl(stringFromGTM)) {
            net.one97.paytm.bankOpen.c a2 = f.a();
            k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
            Context applicationContext = a2.getApplicationContext();
            if (!TextUtils.isEmpty(d.a(applicationContext))) {
                String e2 = com.paytm.utility.b.e(applicationContext, stringFromGTM);
                Map hashMap = new HashMap();
                String a3 = d.a(applicationContext);
                k.a((Object) a3, "CJRNetUtility.getSSOToken(context)");
                hashMap.put("session_token", a3);
                com.paytm.network.a l = new com.paytm.network.b().a(applicationContext).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new CJRAadharPanGet()).a(e2).c("icaapifactory").a(a.c.KYC).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new b(bVar, aVar)).l();
                if (com.paytm.utility.b.c(applicationContext)) {
                    l.a();
                }
            }
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g.b f16449a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g.a f16450b;

        b(g.b bVar, g.a aVar) {
            this.f16449a = bVar;
            this.f16450b = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            this.f16449a.onResponse(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f16450b.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        }
    }

    public static void b(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "listener");
        k.c(aVar, "errorListener");
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String J = net.one97.paytm.bankCommon.utils.d.J();
        if (URLUtil.isValidUrl(J)) {
            String a2 = k.a(J, (Object) "?entityType=INDIVIDUAL&solutionType=limited_ca&questionType=additional&solutionSubType=Others");
            net.one97.paytm.bankOpen.c a3 = f.a();
            k.a((Object) a3, "PaymentBankAccOpenHelper.getImplListener()");
            Context applicationContext = a3.getApplicationContext();
            if (!TextUtils.isEmpty(d.a(applicationContext))) {
                Map hashMap = new HashMap();
                hashMap.put("applanguage", "en");
                hashMap.put("X-SRC", UpiConstants.B2C_ANDROID);
                com.paytm.network.a l = new com.paytm.network.b().a(applicationContext).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new CAQuestionDetailResponse((Boolean) null, (String) null, (List) null, (String) null, (String) null, 31, (kotlin.g.b.g) null)).a(a2).c("icaapifactory").a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c(bVar, aVar)).l();
                if (com.paytm.utility.b.c(applicationContext)) {
                    l.a();
                }
            }
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g.b f16451a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g.a f16452b;

        c(g.b bVar, g.a aVar) {
            this.f16451a = bVar;
            this.f16452b = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            this.f16451a.onResponse(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f16452b.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        }
    }

    public static void c(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        g.b<IJRPaytmDataModel> bVar2 = bVar;
        g.a aVar2 = aVar;
        k.c(bVar2, "responseListener");
        k.c(aVar2, "errorListener");
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String I = net.one97.paytm.bankCommon.utils.d.I();
        net.one97.paytm.bankOpen.c a2 = f.a();
        k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
        Context applicationContext = a2.getApplicationContext();
        if (!TextUtils.isEmpty(d.a(applicationContext))) {
            Map hashMap = new HashMap();
            hashMap.put("applanguage", "en");
            hashMap.put("X-SRC", UpiConstants.B2C_ANDROID);
            hashMap.put("channel", UpiConstants.B2C_ANDROID);
            String a3 = d.a(applicationContext);
            k.a((Object) a3, "CJRNetUtility.getSSOToken(context)");
            hashMap.put("session_token", a3);
            net.one97.paytm.bankOpen.c a4 = f.a();
            k.a((Object) a4, "PaymentBankAccOpenHelper.getImplListener()");
            String A = com.paytm.utility.b.A(a4.getApplicationContext());
            k.a((Object) A, "CJRAppCommonUtility.getD…ner().applicationContext)");
            hashMap.put("deviceIdentifier", A);
            com.paytm.network.a l = new com.paytm.network.b().a(applicationContext).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new ICAStatusResponse(false, false, 0, false, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (kotlin.g.b.g) null)).a(I + "?entityType=INDIVIDUAL&solutionType=limited_ca").c("icaapifactory").a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new C0231a(bVar2, aVar2)).l();
            if (com.paytm.utility.b.c(applicationContext)) {
                l.a();
            }
        }
    }

    /* renamed from: net.one97.paytm.bankOpen.ica.a$a  reason: collision with other inner class name */
    public static final class C0231a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g.b f16436a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g.a f16437b;

        C0231a(g.b bVar, g.a aVar) {
            this.f16436a = bVar;
            this.f16437b = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            this.f16436a.onResponse(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f16437b.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        }
    }

    public final void d(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "responseListener");
        k.c(aVar, "errorListener");
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String F = net.one97.paytm.bankCommon.utils.d.F();
        if (URLUtil.isValidUrl(F)) {
            net.one97.paytm.bankOpen.c a2 = f.a();
            k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
            Context applicationContext = a2.getApplicationContext();
            String e2 = com.paytm.utility.b.e(applicationContext, F);
            Map<String, String> e3 = net.one97.paytm.bankCommon.mapping.d.e(applicationContext);
            HashMap hashMap = new HashMap();
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            hashMap.put("screen_name", simpleName);
            PBKYCFetchTnc pBKYCFetchTnc = new PBKYCFetchTnc();
            if (com.paytm.utility.b.c(applicationContext)) {
                k.a((Object) applicationContext, "mContext");
                applicationContext.getApplicationContext();
                net.one97.paytm.bankCommon.g.c.a();
                net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.a(e2, bVar, aVar, pBKYCFetchTnc, e3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
                return;
            }
            aVar.onErrorResponse(-1, pBKYCFetchTnc, new NetworkCustomError());
        }
    }

    public final void a(ArrayList<PBTncData> arrayList, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        g.a aVar2 = aVar;
        g.b<IJRPaytmDataModel> bVar2 = bVar;
        k.c(bVar, "responseListener");
        k.c(aVar2, "errorListener");
        net.one97.paytm.bankOpen.c a2 = f.a();
        k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
        Context applicationContext = a2.getApplicationContext();
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(mContext)");
        String d2 = net.one97.paytm.bankCommon.utils.d.d();
        if (URLUtil.isValidUrl(d2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, d2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mode", "clickthrough");
                if (applicationContext.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
                    jSONObject.put("deviceId", com.paytm.utility.b.e(applicationContext));
                    JSONArray jSONArray = new JSONArray();
                    Iterator<PBTncData> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        PBTncData next = it2.next();
                        if (next != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("code", next.getCode());
                            jSONObject2.put("version", next.getVersion());
                            jSONObject2.put("accept", 1);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("tnCList", jSONArray);
                    String jSONObject3 = jSONObject.toString();
                    k.a((Object) jSONObject3, "requestBody.toString()");
                    Map<String, String> e3 = net.one97.paytm.bankCommon.mapping.d.e(applicationContext);
                    HashMap hashMap = new HashMap();
                    String simpleName = getClass().getSimpleName();
                    k.a((Object) simpleName, "javaClass.simpleName");
                    hashMap.put("screen_name", simpleName);
                    if (com.paytm.utility.b.c(applicationContext)) {
                        k.a((Object) applicationContext, "mContext");
                        applicationContext.getApplicationContext();
                        net.one97.paytm.bankCommon.g.c.a();
                        net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.b(e2, bVar, aVar, (IJRPaytmDataModel) new PBKYCTncAccept(), (Map<String, String>) null, e3, jSONObject3, a.C0715a.PUT, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap));
                        return;
                    }
                    aVar2.onErrorResponse(-1, new PBKYCTncAccept(), new NetworkCustomError());
                    return;
                }
                throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }
}
