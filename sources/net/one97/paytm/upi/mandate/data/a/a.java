package net.one97.paytm.upi.mandate.data.a;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Event;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.deserializer.BaseUpiDeserializer;
import net.one97.paytm.upi.g.g;
import net.one97.paytm.upi.mandate.data.b;
import net.one97.paytm.upi.mandate.data.model.AuthMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.CheckMandateStatusRequestModel;
import net.one97.paytm.upi.mandate.data.model.CheckMandateStatusResponseModel;
import net.one97.paytm.upi.mandate.data.model.CreateMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.CreateRecurringMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateListResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateTimeLineResponse;
import net.one97.paytm.upi.mandate.data.model.UpdateMandateRequestModel;
import net.one97.paytm.upi.mandate.update.UpdateMandateRequestBody;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import org.json.JSONObject;

public final class a implements net.one97.paytm.upi.mandate.data.b {

    /* renamed from: a  reason: collision with root package name */
    public static final C1356a f67121a = new C1356a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static a f67122d;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.f f67123b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f67124c;

    static final class b<T> implements Response.Listener<UpiBaseDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67125a;

        b(b.a aVar) {
            this.f67125a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
            b.a aVar = this.f67125a;
            kotlin.g.b.k.a((Object) upiBaseDataModel, "it");
            aVar.a(upiBaseDataModel);
        }
    }

    static final class g<T> implements Response.Listener<UpiBaseDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67133a;

        g(b.a aVar) {
            this.f67133a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
            b.a aVar = this.f67133a;
            kotlin.g.b.k.a((Object) upiBaseDataModel, "it");
            aVar.a(upiBaseDataModel);
        }
    }

    static final class i<T> implements Response.Listener<UpiBaseDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67135a;

        i(b.a aVar) {
            this.f67135a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
            b.a aVar = this.f67135a;
            kotlin.g.b.k.a((Object) upiBaseDataModel, "it");
            aVar.a(upiBaseDataModel);
        }
    }

    static final class k<T> implements Response.Listener<UpiBaseDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67137a;

        k(b.a aVar) {
            this.f67137a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
            b.a aVar = this.f67137a;
            kotlin.g.b.k.a((Object) upiBaseDataModel, "it");
            aVar.a(upiBaseDataModel);
        }
    }

    static final class m<T> implements Response.Listener<UpiBaseDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67139a;

        m(b.a aVar) {
            this.f67139a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
            b.a aVar = this.f67139a;
            kotlin.g.b.k.a((Object) upiBaseDataModel, "it");
            aVar.a(upiBaseDataModel);
        }
    }

    static final class o<T> implements Response.Listener<UpiBaseDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67141a;

        o(b.a aVar) {
            this.f67141a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
            b.a aVar = this.f67141a;
            kotlin.g.b.k.a((Object) upiBaseDataModel, "it");
            aVar.a(upiBaseDataModel);
        }
    }

    static final class q<T> implements Response.Listener<UpiBaseDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67143a;

        q(b.a aVar) {
            this.f67143a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
            b.a aVar = this.f67143a;
            kotlin.g.b.k.a((Object) upiBaseDataModel, "it");
            aVar.a(upiBaseDataModel);
        }
    }

    static final class s<T> implements Response.Listener<UpiBaseDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67145a;

        s(b.a aVar) {
            this.f67145a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
            b.a aVar = this.f67145a;
            kotlin.g.b.k.a((Object) upiBaseDataModel, "it");
            aVar.a(upiBaseDataModel);
        }
    }

    public a(Context context) {
        kotlin.g.b.k.c(context, "context");
        this.f67124c = context;
        com.google.gson.g gVar = new com.google.gson.g();
        gVar.f39467e = false;
        this.f67123b = gVar.a();
    }

    /* renamed from: net.one97.paytm.upi.mandate.data.a.a$a  reason: collision with other inner class name */
    public static final class C1356a {
        private C1356a() {
        }

        public /* synthetic */ C1356a(byte b2) {
            this();
        }
    }

    public final void a(CreateMandateRequestModel createMandateRequestModel, b.a aVar) {
        kotlin.g.b.k.c(createMandateRequestModel, "createMandateRequestModel");
        kotlin.g.b.k.c(aVar, H5Event.TYPE_CALL_BACK);
        StringBuilder sb = new StringBuilder();
        sb.append(UpiGTMLoader.getInstance().getUpiSecureBaseUrl());
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        sb.append(instance.getCreateMandateUrl());
        a(sb.toString(), b(), this.f67123b.b(createMandateRequestModel), aVar);
    }

    public final void a(UpdateMandateRequestModel updateMandateRequestModel, b.a aVar) {
        kotlin.g.b.k.c(updateMandateRequestModel, "updateMandateRequestModel");
        kotlin.g.b.k.c(aVar, H5Event.TYPE_CALL_BACK);
        StringBuilder sb = new StringBuilder();
        sb.append(UpiGTMLoader.getInstance().getUpiSecureBaseUrl());
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        sb.append(instance.getUpdateMandateUrl());
        a(sb.toString(), b(), this.f67123b.b(updateMandateRequestModel), aVar);
    }

    public final void a(AuthMandateRequestModel authMandateRequestModel, b.a aVar) {
        AuthMandateRequestModel authMandateRequestModel2 = authMandateRequestModel;
        b.a aVar2 = aVar;
        kotlin.g.b.k.c(authMandateRequestModel2, "authMandateRequestModel");
        kotlin.g.b.k.c(aVar2, H5Event.TYPE_CALL_BACK);
        String b2 = this.f67123b.b(authMandateRequestModel2);
        StringBuilder sb = new StringBuilder();
        sb.append(UpiGTMLoader.getInstance().getUpiSecureBaseUrl());
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        sb.append(instance.getAuthorizeMandateUrl());
        net.one97.paytm.upi.g.d.a(new net.one97.paytm.upi.g.b(UpiRequestBuilder.getUrlWithCommonParams(sb.toString(), this.f67124c), new b(aVar2), new c(aVar2), new MandateDefaultResponseModel((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (kotlin.g.b.g) null), (Map<String, String>) null, b(), b2.toString()));
    }

    static final class c implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67126a;

        c(b.a aVar) {
            this.f67126a = aVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            this.f67126a.a(new UpiCustomVolleyError((Throwable) volleyError));
        }
    }

    public final void a(int i2, b.a aVar) {
        b.a aVar2 = aVar;
        kotlin.g.b.k.c(aVar2, H5Event.TYPE_CALL_BACK);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageNo", i2);
        jSONObject.put("pageSize", 20);
        StringBuilder sb = new StringBuilder();
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        sb.append(instance.getUpiGatewayBaseUrl());
        UpiGTMLoader instance2 = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance2, "UpiGTMLoader.getInstance()");
        sb.append(instance2.getPendingMandate());
        net.one97.paytm.upi.g.d.a(new net.one97.paytm.upi.g.b(UpiRequestBuilder.getUrlWithCommonParams(sb.toString(), this.f67124c), new i(aVar2), new j(aVar2), new MandateListResponseModel((String) null, (String) null, (String) null, (String) null, (List) null, 31, (kotlin.g.b.g) null), (Map<String, String>) null, b(), jSONObject.toString()));
    }

    static final class j implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67136a;

        j(b.a aVar) {
            this.f67136a = aVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            this.f67136a.a(new UpiCustomVolleyError((Throwable) volleyError));
        }
    }

    public static final class d extends net.one97.paytm.upi.g.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67127a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckMandateStatusRequestModel f67128b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.a f67129c;

        /* JADX WARNING: type inference failed for: r1v0, types: [net.one97.paytm.upi.mandate.data.a.a, net.one97.paytm.upi.mandate.data.model.CheckMandateStatusRequestModel] */
        /* JADX WARNING: type inference failed for: r2v0, types: [net.one97.paytm.upi.mandate.data.b$a, net.one97.paytm.upi.mandate.data.model.CheckMandateStatusRequestModel] */
        /* JADX WARNING: type inference failed for: r3v0, types: [int, net.one97.paytm.upi.mandate.data.b$a] */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.android.volley.Response$Listener, java.lang.String] */
        /* JADX WARNING: type inference failed for: r5v0, types: [com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener] */
        /* JADX WARNING: type inference failed for: r6v0, types: [com.android.volley.Response$ErrorListener, net.one97.paytm.upi.g.g$d] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 6 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        d(net.one97.paytm.upi.mandate.data.model.CheckMandateStatusRequestModel r1, net.one97.paytm.upi.mandate.data.b.a r2, int r3, com.android.volley.Response.Listener r4, com.android.volley.Response.ErrorListener r5, net.one97.paytm.upi.g.g.d r6) {
            /*
                r0 = this;
                r0.f67127a = r1
                r0.f67128b = r2
                r0.f67129c = r3
                r1 = 1
                r0.<init>(r1, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.data.a.a.d.<init>(net.one97.paytm.upi.mandate.data.a.a, net.one97.paytm.upi.mandate.data.model.CheckMandateStatusRequestModel, net.one97.paytm.upi.mandate.data.b$a, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
        }

        public final Map<String, String> getParams() {
            Map<String, String> params = UpiRequestBuilder.UpiTransactionStatus.getParams(this.f67127a.f67124c, this.f67128b.getTxnId());
            kotlin.g.b.k.a((Object) params, "UpiRequestBuilder.UpiTra…StatusRequestModel.txnId)");
            return params;
        }

        public final Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> headers = UpiRequestBuilder.getHeaders(this.f67127a.f67124c);
            kotlin.g.b.k.a((Object) headers, "UpiRequestBuilder.getHeaders(context)");
            return headers;
        }
    }

    static final class e<T> implements Response.Listener<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67130a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.a f67131b;

        e(a aVar, b.a aVar2) {
            this.f67130a = aVar;
            this.f67131b = aVar2;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str = (String) obj;
            com.google.gson.g gVar = new com.google.gson.g();
            gVar.a(BaseUpiResponse.class, new BaseUpiDeserializer(29));
            try {
                CheckMandateStatusResponseModel checkMandateStatusResponseModel = (CheckMandateStatusResponseModel) gVar.a().a(str, CheckMandateStatusResponseModel.class);
                if (checkMandateStatusResponseModel.isSuccess()) {
                    b.a aVar = this.f67131b;
                    kotlin.g.b.k.a((Object) checkMandateStatusResponseModel, "baseUpiResponse");
                    aVar.a((UpiBaseDataModel) checkMandateStatusResponseModel);
                    return;
                }
                UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                upiCustomVolleyError.setUrl(UpiRequestBuilder.UpiTransactionStatus.getUpiTransactionStatusUrl(this.f67130a.f67124c));
                upiCustomVolleyError.setAlertMessage(checkMandateStatusResponseModel.getMessage());
                this.f67131b.a(upiCustomVolleyError);
            } catch (u e2) {
                e2.printStackTrace();
                UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                upiCustomVolleyError2.setUrl(UpiRequestBuilder.UpiTransactionStatus.getUpiTransactionStatusUrl(this.f67130a.f67124c));
                upiCustomVolleyError2.setAlertMessage("Parse Exception");
                this.f67131b.a(upiCustomVolleyError2);
            }
        }
    }

    public final void a(CheckMandateStatusRequestModel checkMandateStatusRequestModel, b.a aVar) {
        kotlin.g.b.k.c(checkMandateStatusRequestModel, "mandateStatusRequestModel");
        kotlin.g.b.k.c(aVar, H5Event.TYPE_CALL_BACK);
        if (UpiAppUtils.isNetworkAvailable(this.f67124c)) {
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.USER_FACING;
            new HashMap();
            d dVar2 = new d(this, checkMandateStatusRequestModel, aVar, UpiRequestBuilder.UpiTransactionStatus.getUpiTransactionStatusUrl(this.f67124c), new e(this, aVar), new f(aVar));
            PaytmLogs.d("[Request]", dVar2.toString());
            dVar2.setTag("");
            net.one97.paytm.upi.g.d.b(this.f67124c).add(dVar2);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setUrl(UpiRequestBuilder.UpiTransactionStatus.getUpiTransactionStatusUrl(this.f67124c));
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.a(upiCustomVolleyError);
    }

    static final class f implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67132a;

        f(b.a aVar) {
            this.f67132a = aVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            b.a aVar = this.f67132a;
            if (volleyError != null) {
                aVar.a((UpiCustomVolleyError) volleyError);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.upi.common.UpiCustomVolleyError");
        }
    }

    public final void b(int i2, b.a aVar) {
        b.a aVar2 = aVar;
        kotlin.g.b.k.c(aVar2, H5Event.TYPE_CALL_BACK);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageNo", i2);
        jSONObject.put("pageSize", 20);
        StringBuilder sb = new StringBuilder();
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        sb.append(instance.getUpiGatewayBaseUrl());
        UpiGTMLoader instance2 = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance2, "UpiGTMLoader.getInstance()");
        sb.append(instance2.getReceivedMandateUrl());
        net.one97.paytm.upi.g.d.a(new net.one97.paytm.upi.g.b(UpiRequestBuilder.getUrlWithCommonParams(sb.toString(), this.f67124c), new k(aVar2), new l(aVar2), new MandateListResponseModel((String) null, (String) null, (String) null, (String) null, (List) null, 31, (kotlin.g.b.g) null), (Map<String, String>) null, b(), jSONObject.toString()));
    }

    static final class l implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67138a;

        l(b.a aVar) {
            this.f67138a = aVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            this.f67138a.a(new UpiCustomVolleyError((Throwable) volleyError));
        }
    }

    public final void c(int i2, b.a aVar) {
        b.a aVar2 = aVar;
        kotlin.g.b.k.c(aVar2, H5Event.TYPE_CALL_BACK);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageNo", i2);
        jSONObject.put("pageSize", 20);
        StringBuilder sb = new StringBuilder();
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        sb.append(instance.getUpiGatewayBaseUrl());
        UpiGTMLoader instance2 = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance2, "UpiGTMLoader.getInstance()");
        sb.append(instance2.getScheduledMandateUrl());
        net.one97.paytm.upi.g.d.a(new net.one97.paytm.upi.g.b(UpiRequestBuilder.getUrlWithCommonParams(sb.toString(), this.f67124c), new m(aVar2), new n(aVar2), new MandateListResponseModel((String) null, (String) null, (String) null, (String) null, (List) null, 31, (kotlin.g.b.g) null), (Map<String, String>) null, b(), jSONObject.toString()));
    }

    static final class n implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67140a;

        n(b.a aVar) {
            this.f67140a = aVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            this.f67140a.a(new UpiCustomVolleyError((Throwable) volleyError));
        }
    }

    private final void a(String str, Map<String, String> map, String str2, b.a aVar) {
        b.a aVar2 = aVar;
        net.one97.paytm.upi.g.d.a(new net.one97.paytm.upi.g.b(UpiRequestBuilder.getUrlWithCommonParams(str, this.f67124c), new q(aVar2), new r(aVar2), new MandateDefaultResponseModel((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (kotlin.g.b.g) null), (Map<String, String>) null, map, str2));
    }

    static final class r implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67144a;

        r(b.a aVar) {
            this.f67144a = aVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            this.f67144a.a(new UpiCustomVolleyError((Throwable) volleyError));
        }
    }

    public final void a(String str, b.a aVar) {
        String str2 = str;
        b.a aVar2 = aVar;
        kotlin.g.b.k.c(str2, "umn");
        kotlin.g.b.k.c(aVar2, H5Event.TYPE_CALL_BACK);
        StringBuilder sb = new StringBuilder();
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        sb.append(instance.getUpiGatewayBaseUrl());
        UpiGTMLoader instance2 = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance2, "UpiGTMLoader.getInstance()");
        sb.append(instance2.getJourneyMandateUrl());
        String sb2 = sb.toString();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("umn", str2);
        net.one97.paytm.upi.g.d.a(new net.one97.paytm.upi.g.b(UpiRequestBuilder.getUrlWithCommonParams(sb2, this.f67124c), new o(aVar2), new p(aVar2), new MandateTimeLineResponse((String) null, (String) null, (String) null, (List) null, 15, (kotlin.g.b.g) null), (Map<String, String>) null, b(), jSONObject.toString()));
    }

    static final class p implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67142a;

        p(b.a aVar) {
            this.f67142a = aVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            this.f67142a.a(new UpiCustomVolleyError((Throwable) volleyError));
        }
    }

    public final void a(CreateRecurringMandateRequestModel createRecurringMandateRequestModel, b.a aVar) {
        CreateRecurringMandateRequestModel createRecurringMandateRequestModel2 = createRecurringMandateRequestModel;
        b.a aVar2 = aVar;
        kotlin.g.b.k.c(createRecurringMandateRequestModel2, "createMandateRequestModel");
        kotlin.g.b.k.c(aVar2, H5Event.TYPE_CALL_BACK);
        Map<String, String> b2 = b();
        StringBuilder sb = new StringBuilder();
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        sb.append(instance.getUpiSecureBaseUrl());
        UpiGTMLoader instance2 = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance2, "UpiGTMLoader.getInstance()");
        sb.append(instance2.getCreateRecurringMandateUrl());
        net.one97.paytm.upi.g.d.a(new net.one97.paytm.upi.g.b(UpiRequestBuilder.getUrlWithCommonParams(sb.toString(), this.f67124c), new g(aVar2), new h(aVar2), new MandateDefaultResponseModel((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (kotlin.g.b.g) null), (Map<String, String>) null, b2, this.f67123b.b(createRecurringMandateRequestModel2)));
    }

    static final class h implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67134a;

        h(b.a aVar) {
            this.f67134a = aVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            this.f67134a.a(new UpiCustomVolleyError((Throwable) volleyError));
        }
    }

    public final void a(UpdateMandateRequestBody updateMandateRequestBody, b.a aVar) {
        UpdateMandateRequestBody updateMandateRequestBody2 = updateMandateRequestBody;
        b.a aVar2 = aVar;
        kotlin.g.b.k.c(updateMandateRequestBody2, "updateMandateRequestBody");
        kotlin.g.b.k.c(aVar2, H5Event.TYPE_CALL_BACK);
        Map<String, String> b2 = b();
        StringBuilder sb = new StringBuilder();
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        sb.append(instance.getUpiSecureBaseUrl());
        UpiGTMLoader instance2 = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance2, "UpiGTMLoader.getInstance()");
        sb.append(instance2.getRecurringMandateUpdateUrl());
        net.one97.paytm.upi.g.d.a(new net.one97.paytm.upi.g.b(UpiRequestBuilder.getUrlWithCommonParams(sb.toString(), this.f67124c), new s(aVar2), new t(aVar2), new MandateDefaultResponseModel((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (kotlin.g.b.g) null), (Map<String, String>) null, b2, this.f67123b.b(updateMandateRequestBody2)));
    }

    static final class t implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f67146a;

        t(b.a aVar) {
            this.f67146a = aVar;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            this.f67146a.a(new UpiCustomVolleyError((Throwable) volleyError));
        }
    }

    private static Map<String, String> b() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("channel", "paytm");
        hashMap.put("Content-Type", "application/json");
        net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        String f2 = a2.f();
        kotlin.g.b.k.a((Object) f2, "PaytmUpiSdk.getInstance().ssoToken");
        hashMap.put(UpiConstants.CHANNEL_TOKEN, f2);
        return hashMap;
    }
}
