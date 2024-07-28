package net.one97.paytm.paymentsBank.chequebook.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.model.PBCJRAddresses;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.chequebook.b;
import net.one97.paytm.paymentsBank.chequebook.model.CBChequeStatusDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse;
import net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.model.GetDocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view.RequestCBActivity;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivity;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2;
import net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse;
import net.one97.paytm.paymentsBank.pdc.response.PDCStatusResponse;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g {

    /* renamed from: b  reason: collision with root package name */
    public static final a f17964b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static g f17965d;

    /* renamed from: a  reason: collision with root package name */
    public Context f17966a;

    /* renamed from: c  reason: collision with root package name */
    private final String f17967c = "ChequeBookRequestFactor";

    public static final g a(Context context) {
        return a.a(context);
    }

    public g(Context context) {
        this.f17966a = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g a(Context context) {
            if (context == null) {
                return null;
            }
            g b2 = g.f17965d;
            if (b2 != null) {
                return b2;
            }
            g gVar = new g(context);
            g.f17965d = gVar;
            return gVar;
        }
    }

    public final com.paytm.network.a a(com.paytm.network.listener.b bVar) {
        k.c(bVar, "apiListener");
        String stringFromGTM = o.a().getStringFromGTM("kyc_tnc_base_url");
        StringBuilder sb = new StringBuilder();
        sb.append(stringFromGTM);
        e eVar = e.f17951a;
        sb.append(e.X());
        String sb2 = sb.toString();
        if (!URLUtil.isValidUrl(sb2)) {
            return null;
        }
        String e2 = com.paytm.utility.b.e(this.f17966a, sb2);
        Map hashMap = new HashMap();
        String a2 = com.paytm.utility.d.a(this.f17966a);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put("session_token", a2);
        hashMap.put("Accept", "application/json");
        hashMap.put("Content-Type", "application/json");
        return new com.paytm.network.b().a(this.f17966a).a(e2).a((Map<String, String>) hashMap).a(a.C0715a.GET).a(a.c.PAYMENTSBANK).a(a.b.SILENT).a((IJRPaytmDataModel) new PBKYCFetchTnc()).f().a(bVar).c(RequestCBActivity.class.getName()).l();
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.utils.g$g  reason: collision with other inner class name */
    public static final class C0294g implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f17976a;

        public C0294g(com.paytm.network.listener.b bVar) {
            this.f17976a = bVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof GetDocumentCreateResponse) {
                ((GetDocumentCreateResponse) iJRPaytmDataModel).setDocumentGetApi(true);
                com.paytm.network.listener.b bVar = this.f17976a;
                if (bVar != null) {
                    bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                }
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof GetDocumentCreateResponse) {
                ((GetDocumentCreateResponse) iJRPaytmDataModel).setDocumentGetApi(true);
                com.paytm.network.listener.b bVar = this.f17976a;
                if (bVar != null) {
                    bVar.onApiSuccess(iJRPaytmDataModel);
                }
            }
        }
    }

    public final com.paytm.network.a a(com.paytm.network.listener.b bVar, String str) {
        k.c(bVar, "apiListener");
        if (TextUtils.isEmpty(str)) {
            str = "CURRENT";
        } else if (str == null) {
            k.a();
        }
        String str2 = n.B() + str;
        if (!URLUtil.isValidUrl(str2)) {
            return null;
        }
        String e2 = com.paytm.utility.b.e(this.f17966a, str2);
        Map hashMap = new HashMap();
        e eVar = e.f17951a;
        String a2 = e.a();
        String a3 = com.paytm.utility.d.a(this.f17966a);
        k.a((Object) a3, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put(a2, a3);
        hashMap.put("Accept", "application/json");
        hashMap.put("Content-Type", "application/json");
        return new com.paytm.network.b().a(this.f17966a).a(e2).a((Map<String, String>) hashMap).a(a.C0715a.GET).a(a.c.PAYMENTSBANK).a(a.b.SILENT).a((IJRPaytmDataModel) new CBGetSignatureResponse()).f().a(bVar).c(SignatureLandingActivity.class.getName()).l();
    }

    public final com.paytm.network.a a(com.paytm.network.listener.b bVar, String str, String str2) {
        k.c(bVar, "apiListener");
        String z = n.z();
        if (!TextUtils.isEmpty(str)) {
            k.a((Object) z, "url");
            if (str == null) {
                k.a();
            }
            z = p.a(z, "{imageID}", str, true);
        }
        if (!URLUtil.isValidUrl(z)) {
            return null;
        }
        String e2 = com.paytm.utility.b.e(this.f17966a, z);
        Map hashMap = new HashMap();
        e eVar = e.f17951a;
        String a2 = e.a();
        String a3 = com.paytm.utility.d.a(this.f17966a);
        k.a((Object) a3, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put(a2, a3);
        hashMap.put("Accept", "application/json");
        hashMap.put("Content-Type", "application/json");
        return new com.paytm.network.b().a(this.f17966a).a(e2).a((Map<String, String>) hashMap).a(a.C0715a.GET).a(a.c.PAYMENTSBANK).a(a.b.SILENT).a((IJRPaytmDataModel) new DocumentCreateResponse()).f().a((com.paytm.network.listener.b) new c(str2, bVar)).c(SignatureLandingActivity.class.getName()).l();
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17969a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f17970b;

        c(String str, com.paytm.network.listener.b bVar) {
            this.f17969a = str;
            this.f17970b = bVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof DocumentCreateResponse) {
                DocumentCreateResponse documentCreateResponse = (DocumentCreateResponse) iJRPaytmDataModel;
                documentCreateResponse.setViewSignature(true);
                documentCreateResponse.setSignatureType(this.f17969a);
                com.paytm.network.listener.b bVar = this.f17970b;
                if (bVar != null) {
                    bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                }
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof DocumentCreateResponse) {
                DocumentCreateResponse documentCreateResponse = (DocumentCreateResponse) iJRPaytmDataModel;
                documentCreateResponse.setViewSignature(true);
                documentCreateResponse.setSignatureType(this.f17969a);
                com.paytm.network.listener.b bVar = this.f17970b;
                if (bVar != null) {
                    bVar.onApiSuccess(iJRPaytmDataModel);
                }
            }
        }
    }

    public final com.paytm.network.a a(int i2, String str, com.paytm.network.listener.b bVar) {
        k.c(str, "code");
        k.c(bVar, "apiListener");
        String stringFromGTM = o.a().getStringFromGTM("kyc_tnc_user_url");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return null;
        }
        String e2 = com.paytm.utility.b.e(this.f17966a, stringFromGTM);
        Map hashMap = new HashMap();
        String a2 = com.paytm.utility.d.a(this.f17966a);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put("session_token", a2);
        hashMap.put("Accept", "application/json");
        hashMap.put("Content-Type", "application/json");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        e eVar = e.f17951a;
        jSONObject.put(e.M(), str);
        e eVar2 = e.f17951a;
        jSONObject.put(e.N(), i2);
        jSONArray.put(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        e eVar3 = e.f17951a;
        String K = e.K();
        e eVar4 = e.f17951a;
        jSONObject2.put(K, e.O());
        e eVar5 = e.f17951a;
        jSONObject2.put(e.L(), jSONArray);
        return new com.paytm.network.b().a(this.f17966a).a(e2).a((Map<String, String>) hashMap).a(a.C0715a.PUT).b(jSONObject2.toString()).a(a.c.PAYMENTSBANK).a(a.b.SILENT).a((IJRPaytmDataModel) new PBKYCTncAccept()).f().a(false).a(bVar).c(RequestCBActivity.class.getName()).l();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x01bb A[Catch:{ Exception -> 0x020d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.network.a a(android.content.Context r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, com.paytm.network.a.c r29, com.paytm.network.a.b r30, com.paytm.network.listener.b r31, net.one97.paytm.common.entity.upgradeKyc.PermanentAddress r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, boolean r36) {
        /*
            r24 = this;
            r1 = r24
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            r6 = r30
            r7 = r31
            r0 = r33
            r8 = r34
            r9 = r35
            java.lang.String r10 = "customerMobileNumber"
            java.lang.String r11 = "1"
            java.lang.String r12 = ""
            java.lang.String r13 = "context"
            r14 = r25
            kotlin.g.b.k.c(r14, r13)
            java.lang.String r13 = "bankScopeToken"
            kotlin.g.b.k.c(r2, r13)
            java.lang.String r15 = "screenName"
            kotlin.g.b.k.c(r4, r15)
            java.lang.String r15 = "verticalId"
            kotlin.g.b.k.c(r5, r15)
            java.lang.String r15 = "userFacing"
            kotlin.g.b.k.c(r6, r15)
            java.lang.String r15 = "apiListener"
            kotlin.g.b.k.c(r7, r15)
            java.lang.String r15 = "productID"
            kotlin.g.b.k.c(r0, r15)
            java.lang.String r15 = "cbName"
            kotlin.g.b.k.c(r9, r15)
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x015e }
            r15.<init>()     // Catch:{ Exception -> 0x015e }
            java.lang.String r14 = "productId"
            r15.put(r14, r0)     // Catch:{ Exception -> 0x015e }
            java.lang.String r0 = "quantity"
            r14 = 1
            r15.put(r0, r14)     // Catch:{ Exception -> 0x015e }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x015e }
            r0.<init>()     // Catch:{ Exception -> 0x015e }
            r0.put(r15)     // Catch:{ Exception -> 0x015e }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x015e }
            r15.<init>()     // Catch:{ Exception -> 0x015e }
            java.lang.String r14 = "address1"
            if (r32 == 0) goto L_0x006e
            java.lang.String r16 = r32.getStreet1()     // Catch:{ Exception -> 0x015e }
            r4 = r16
            goto L_0x006f
        L_0x006e:
            r4 = 0
        L_0x006f:
            r15.put(r14, r4)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "address2"
            if (r32 == 0) goto L_0x007b
            java.lang.String r14 = r32.getStreet2()     // Catch:{ Exception -> 0x015e }
            goto L_0x007c
        L_0x007b:
            r14 = 0
        L_0x007c:
            r15.put(r4, r14)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "city"
            if (r32 == 0) goto L_0x0088
            java.lang.String r14 = r32.getCity()     // Catch:{ Exception -> 0x015e }
            goto L_0x0089
        L_0x0088:
            r14 = 0
        L_0x0089:
            r15.put(r4, r14)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "countryCode"
            if (r32 == 0) goto L_0x0095
            java.lang.String r14 = r32.getState()     // Catch:{ Exception -> 0x015e }
            goto L_0x0096
        L_0x0095:
            r14 = 0
        L_0x0096:
            r15.put(r4, r14)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "country"
            java.lang.String r14 = "india"
            r15.put(r4, r14)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "pin"
            if (r32 == 0) goto L_0x00a9
            java.lang.String r14 = r32.getPostalCode()     // Catch:{ Exception -> 0x015e }
            goto L_0x00aa
        L_0x00a9:
            r14 = 0
        L_0x00aa:
            r15.put(r4, r14)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "mobile"
            android.content.Context r14 = r1.f17966a     // Catch:{ Exception -> 0x015e }
            java.lang.String r14 = com.paytm.utility.b.l((android.content.Context) r14)     // Catch:{ Exception -> 0x015e }
            r15.put(r4, r14)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "name"
            android.content.Context r14 = r1.f17966a     // Catch:{ Exception -> 0x015e }
            java.lang.String r14 = com.paytm.utility.b.C((android.content.Context) r14)     // Catch:{ Exception -> 0x015e }
            r15.put(r4, r14)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "state"
            if (r32 == 0) goto L_0x00cd
            java.lang.String r14 = r32.getState()     // Catch:{ Exception -> 0x015e }
            goto L_0x00ce
        L_0x00cd:
            r14 = 0
        L_0x00ce:
            r15.put(r4, r14)     // Catch:{ Exception -> 0x015e }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x015e }
            r4.<init>()     // Catch:{ Exception -> 0x015e }
            r14 = r8
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x015e }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x015e }
            java.lang.String r7 = "uploaded"
            java.lang.String r6 = "imageId"
            if (r14 == 0) goto L_0x00ec
            r4.put(r6, r12)     // Catch:{ Exception -> 0x015e }
            r6 = 0
            r4.put(r7, r6)     // Catch:{ Exception -> 0x015e }
            goto L_0x00f3
        L_0x00ec:
            r4.put(r6, r8)     // Catch:{ Exception -> 0x015e }
            r6 = 1
            r4.put(r7, r6)     // Catch:{ Exception -> 0x015e }
        L_0x00f3:
            android.content.Context r4 = r1.f17966a     // Catch:{ Exception -> 0x015e }
            r6 = 0
            java.util.Map r4 = com.paytm.utility.c.b((android.content.Context) r4, (boolean) r6)     // Catch:{ Exception -> 0x015e }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x015e }
            r6.<init>(r4)     // Catch:{ Exception -> 0x015e }
            java.lang.String r4 = "childSiteId"
            r6.put(r4, r11)     // Catch:{ Exception -> 0x015c }
            java.lang.String r4 = "client"
            net.one97.paytm.paymentsBank.chequebook.utils.e r7 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a     // Catch:{ Exception -> 0x015c }
            java.lang.String r7 = net.one97.paytm.paymentsBank.chequebook.utils.e.q()     // Catch:{ Exception -> 0x015c }
            r6.put(r4, r7)     // Catch:{ Exception -> 0x015c }
            android.content.Context r4 = r1.f17966a     // Catch:{ Exception -> 0x015c }
            java.lang.String r4 = com.paytm.utility.b.l((android.content.Context) r4)     // Catch:{ Exception -> 0x015c }
            r6.put(r10, r4)     // Catch:{ Exception -> 0x015c }
            java.lang.String r4 = "products"
            r6.put(r4, r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = "siteId"
            r6.put(r0, r11)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = "channel"
            java.lang.String r4 = "BCApp"
            r6.put(r0, r4)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = "address"
            r6.put(r0, r15)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = "uploadSignature"
            r4 = r36
            r6.put(r0, r4)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = "version"
            java.lang.String r4 = "6.0.2"
            r6.put(r0, r4)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = "latitude"
            java.lang.String r4 = "lat"
            r6.put(r0, r4)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = "longitude"
            java.lang.String r4 = "na"
            r6.put(r0, r4)     // Catch:{ Exception -> 0x015c }
            android.content.Context r0 = r1.f17966a     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = com.paytm.utility.b.l((android.content.Context) r0)     // Catch:{ Exception -> 0x015c }
            r6.put(r10, r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = "nameOnChequeBook"
            r6.put(r0, r9)     // Catch:{ Exception -> 0x015c }
            goto L_0x0163
        L_0x015c:
            r0 = move-exception
            goto L_0x0160
        L_0x015e:
            r0 = move-exception
            r6 = 0
        L_0x0160:
            r0.printStackTrace()     // Catch:{ Exception -> 0x020d }
        L_0x0163:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x020d }
            r0.<init>()     // Catch:{ Exception -> 0x020d }
            r4 = r0
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x020d }
            java.lang.String r7 = "ssotoken"
            java.lang.String r8 = net.one97.paytm.bankCommon.mapping.d.a(r25)     // Catch:{ Exception -> 0x020d }
            java.lang.String r9 = "CJRServerUtility.getSSOToken(context)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x020d }
            r4.put(r7, r8)     // Catch:{ Exception -> 0x020d }
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutResponse r4 = new net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutResponse     // Catch:{ Exception -> 0x020d }
            r7 = 10
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x020d }
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r8 = new net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad     // Catch:{ Exception -> 0x020d }
            java.lang.String r17 = ""
            java.lang.String r18 = ""
            r9 = 4607632778762754458(0x3ff199999999999a, double:1.1)
            java.lang.Double r19 = java.lang.Double.valueOf(r9)     // Catch:{ Exception -> 0x020d }
            java.lang.Boolean r20 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x020d }
            java.lang.String r21 = "errormessage"
            r9 = -1
            java.lang.Integer r22 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x020d }
            java.lang.String r23 = ""
            r16 = r8
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x020d }
            r4.<init>(r12, r7, r12, r8)     // Catch:{ Exception -> 0x020d }
            r7 = r0
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x020d }
            r7.put(r13, r2)     // Catch:{ Exception -> 0x020d }
            r2 = r0
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x020d }
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "application/json"
            r2.put(r7, r8)     // Catch:{ Exception -> 0x020d }
            r2 = r0
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x020d }
            java.lang.String r7 = "reqMappingId"
            if (r3 != 0) goto L_0x01be
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x020d }
        L_0x01be:
            r2.put(r7, r3)     // Catch:{ Exception -> 0x020d }
            java.lang.String r2 = net.one97.paytm.paymentsBank.utils.n.D()     // Catch:{ Exception -> 0x020d }
            com.paytm.network.b r3 = new com.paytm.network.b     // Catch:{ Exception -> 0x020d }
            r3.<init>()     // Catch:{ Exception -> 0x020d }
            android.content.Context r7 = r1.f17966a     // Catch:{ Exception -> 0x020d }
            com.paytm.network.b r3 = r3.a((android.content.Context) r7)     // Catch:{ Exception -> 0x020d }
            com.paytm.network.b r2 = r3.a((java.lang.String) r2)     // Catch:{ Exception -> 0x020d }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x020d }
            com.paytm.network.b r2 = r2.b((java.lang.String) r3)     // Catch:{ Exception -> 0x020d }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x020d }
            com.paytm.network.b r0 = r2.a((java.util.Map<java.lang.String, java.lang.String>) r0)     // Catch:{ Exception -> 0x020d }
            com.paytm.network.a$a r2 = com.paytm.network.a.C0715a.POST     // Catch:{ Exception -> 0x020d }
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.C0715a) r2)     // Catch:{ Exception -> 0x020d }
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.c) r5)     // Catch:{ Exception -> 0x020d }
            r2 = r30
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.b) r2)     // Catch:{ Exception -> 0x020d }
            com.paytm.network.model.IJRPaytmDataModel r4 = (com.paytm.network.model.IJRPaytmDataModel) r4     // Catch:{ Exception -> 0x020d }
            com.paytm.network.b r0 = r0.a((com.paytm.network.model.IJRPaytmDataModel) r4)     // Catch:{ Exception -> 0x020d }
            com.paytm.network.b r0 = r0.f()     // Catch:{ Exception -> 0x020d }
            r2 = r31
            com.paytm.network.b r0 = r0.a((com.paytm.network.listener.b) r2)     // Catch:{ Exception -> 0x020d }
            r2 = r28
            com.paytm.network.b r0 = r0.c(r2)     // Catch:{ Exception -> 0x020d }
            com.paytm.network.a r0 = r0.l()     // Catch:{ Exception -> 0x020d }
            return r0
        L_0x020d:
            r0 = move-exception
            r0.printStackTrace()
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.utils.g.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.paytm.network.a$c, com.paytm.network.a$b, com.paytm.network.listener.b, net.one97.paytm.common.entity.upgradeKyc.PermanentAddress, java.lang.String, java.lang.String, java.lang.String, boolean):com.paytm.network.a");
    }

    public final com.paytm.network.a a(Context context, String str, a.c cVar, a.b bVar, com.paytm.network.listener.b bVar2) {
        k.c(context, "context");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(cVar, "verticalId");
        k.c(bVar, "userFacing");
        k.c(bVar2, "apiListener");
        try {
            CbCatalogueResponse cbCatalogueResponse = new CbCatalogueResponse("", -1, "", (List<CbCataloguePayLoad>) null);
            String stringFromGTM = o.a().getStringFromGTM("cb_catlog_url");
            k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
            net.one97.paytm.bankCommon.utils.d.y();
            HashMap hashMap = new HashMap();
            hashMap.put("Accept", "application/json");
            return new com.paytm.network.b().a(stringFromGTM).a(this.f17966a).a((Map<String, String>) hashMap).a(a.C0715a.GET).a(cVar).a(bVar).a((IJRPaytmDataModel) cbCatalogueResponse).f().a(bVar2).c(str).l();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final com.paytm.network.a a(Context context, com.paytm.network.listener.b bVar, String str) {
        k.c(context, "context");
        k.c(bVar, "apiListener");
        try {
            String x = n.x();
            HashMap hashMap = new HashMap();
            hashMap.put("Accept", "*/*");
            Map map = hashMap;
            e eVar = e.f17951a;
            String a2 = e.a();
            if (str == null) {
                k.a();
            }
            map.put(a2, str);
            return new com.paytm.network.b().a(x).a(this.f17966a).a((Map<String, String>) hashMap).a(a.C0715a.PUT).a(a.c.PAYMENTSBANK).a(a.b.SILENT).a((IJRPaytmDataModel) new DocumentCreateResponse()).f().c(SignatureLandingActivityV2.class.getName()).a((com.paytm.network.listener.b) new b(bVar)).l();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f17968a;

        b(com.paytm.network.listener.b bVar) {
            this.f17968a = bVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (iJRPaytmDataModel instanceof DocumentCreateResponse) {
                ((DocumentCreateResponse) iJRPaytmDataModel).setAcknowledgeSig(true);
                com.paytm.network.listener.b bVar = this.f17968a;
                if (bVar != null) {
                    bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                }
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof DocumentCreateResponse) {
                ((DocumentCreateResponse) iJRPaytmDataModel).setAcknowledgeSig(true);
                com.paytm.network.listener.b bVar = this.f17968a;
                if (bVar != null) {
                    bVar.onApiSuccess(iJRPaytmDataModel);
                }
            }
        }
    }

    public final com.paytm.network.a a(Context context, String str, a.c cVar, com.paytm.network.listener.b bVar, a.b bVar2, String str2) {
        JSONObject jSONObject;
        k.c(context, "context");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(cVar, "verticalId");
        k.c(bVar, "apiListener");
        k.c(bVar2, "userFacing");
        k.c(str2, "productID");
        try {
            jSONObject = new JSONObject(com.paytm.utility.c.b(this.f17966a, false));
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject2);
                jSONObject2.put("productId", str2);
                jSONObject2.put("quantity", 1);
                jSONObject.put("customerMobileNumber", com.paytm.utility.b.l(this.f17966a));
                jSONObject.put("channel", UpiConstants.B2C_ANDROID);
                jSONObject.put("products", jSONArray);
                jSONObject.put("siteId", "1");
                jSONObject.put("utmSource", "market-app");
                jSONObject.put("version", "6.0.2");
                jSONObject.put("latitude", "NA");
                jSONObject.put("longitude", "NA");
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            jSONObject = null;
            try {
                e.printStackTrace();
                HashMap hashMap = new HashMap();
                CbPreValidateResponse cbPreValidateResponse = new CbPreValidateResponse(1, "", "", new CbPreValidatePayLoad("", -1, ""));
                String stringFromGTM = o.a().getStringFromGTM("cb_prevalidate_url");
                hashMap.put("ssotoken", net.one97.paytm.bankCommon.mapping.d.a(context));
                hashMap.put("Content-Type", "application/json");
                return new com.paytm.network.b().a(stringFromGTM).a(this.f17966a).a((Map<String, String>) hashMap).b(String.valueOf(jSONObject)).a(a.C0715a.POST).a(cVar).a(bVar2).a((IJRPaytmDataModel) cbPreValidateResponse).f().a(bVar).c(str).l();
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        HashMap hashMap2 = new HashMap();
        CbPreValidateResponse cbPreValidateResponse2 = new CbPreValidateResponse(1, "", "", new CbPreValidatePayLoad("", -1, ""));
        String stringFromGTM2 = o.a().getStringFromGTM("cb_prevalidate_url");
        hashMap2.put("ssotoken", net.one97.paytm.bankCommon.mapping.d.a(context));
        hashMap2.put("Content-Type", "application/json");
        return new com.paytm.network.b().a(stringFromGTM2).a(this.f17966a).a((Map<String, String>) hashMap2).b(String.valueOf(jSONObject)).a(a.C0715a.POST).a(cVar).a(bVar2).a((IJRPaytmDataModel) cbPreValidateResponse2).f().a(bVar).c(str).l();
    }

    public final com.paytm.network.a b(com.paytm.network.listener.b bVar, String str) {
        k.c(bVar, "apiListener");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String stringFromGTM = o.a().getStringFromGTM("kyc_add_url");
        Context context = this.f17966a;
        if (context == null) {
            return null;
        }
        String a2 = com.paytm.utility.d.a(context);
        if (TextUtils.isEmpty(a2) || !URLUtil.isValidUrl(stringFromGTM)) {
            return null;
        }
        Map hashMap = new HashMap();
        k.a((Object) a2, "userToken");
        hashMap.put("session_token", a2);
        return new com.paytm.network.b().a(stringFromGTM).a(this.f17966a).a((Map<String, String>) hashMap).a(a.C0715a.GET).a(a.b.USER_FACING).a(a.c.PAYMENTSBANK).c(str).a((IJRPaytmDataModel) new CJRAadharPanGet()).f().a(bVar).c(str).l();
    }

    public final com.paytm.network.a b(Context context, String str, a.c cVar, a.b bVar, com.paytm.network.listener.b bVar2) {
        k.c(context, "context");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(cVar, "verticalId");
        k.c(bVar, "userFacing");
        k.c(bVar2, "apiListener");
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap hashMap = new HashMap();
            e eVar = e.f17951a;
            String a2 = e.a();
            String a3 = com.paytm.utility.d.a(this.f17966a);
            k.a((Object) a3, "CJRNetUtility.getSSOToken(mContext)");
            hashMap.put(a2, a3);
            e eVar2 = e.f17951a;
            String b2 = e.b();
            e eVar3 = e.f17951a;
            hashMap.put(b2, e.U());
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept", "application/json");
            return new com.paytm.network.b().a(o.a().getStringFromGTM("create_sign_url")).a(this.f17966a).a((Map<String, String>) hashMap).a(a.C0715a.POST).a(cVar).b(jSONObject.toString()).a(bVar).a((IJRPaytmDataModel) new CbCreateSignature("", new CreateSignPayload("", "", ""), "", "")).f().a(bVar2).c(str).l();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final com.paytm.network.a a(Context context, String str, String str2, a.c cVar, a.b bVar, com.paytm.network.listener.b bVar2) {
        k.c(context, "context");
        k.c(str, "txnToken");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(cVar, "verticalId");
        k.c(bVar, "userFacing");
        k.c(bVar2, "apiListener");
        try {
            HashMap hashMap = new HashMap();
            e eVar = e.f17951a;
            hashMap.put(e.e(), "application/json");
            e eVar2 = e.f17951a;
            hashMap.put(e.d(), str);
            e eVar3 = e.f17951a;
            hashMap.put(e.b(), "B2CANDROID");
            String stringFromGTM = o.a().getStringFromGTM("fetch_img_url");
            return new com.paytm.network.b().a(stringFromGTM).a(this.f17966a).a((Map<String, String>) hashMap).a(a.C0715a.GET).a(cVar).a(bVar).a((IJRPaytmDataModel) new CbSignatureResponse("", -1, (CbSignaturePayload) null)).f().a(bVar2).c(str2).l();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final com.paytm.network.a a(Context context, String str, com.paytm.network.listener.b bVar, String str2) {
        k.c(context, "context");
        k.c(str, "offset");
        k.c(bVar, "apiListener");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (this.f17966a == null) {
            return null;
        }
        String stringFromGTM = o.a().getStringFromGTM("get_cb_list_url");
        HashMap hashMap = new HashMap();
        e eVar = e.f17951a;
        hashMap.put(e.f(), net.one97.paytm.bankCommon.mapping.d.a(this.f17966a));
        hashMap.put("Accept", "application/json");
        hashMap.put("Client-Id", UpiConstants.B2C_ANDROID);
        hashMap.put("Limit", "10");
        hashMap.put("Offset", str);
        return new com.paytm.network.b().a(context).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a(a.C0715a.GET).c(str2).a(stringFromGTM).a((Map<String, String>) hashMap).a(false).a((IJRPaytmDataModel) new ChequeBookDetailResponse()).a(bVar).l();
    }

    public final com.paytm.network.a b(Context context, String str, com.paytm.network.listener.b bVar, String str2) {
        k.c(context, "context");
        k.c(str, "orderId");
        k.c(bVar, "apiListener");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (this.f17966a != null) {
            new PBCJRAddresses();
            StringBuilder sb = new StringBuilder();
            sb.append(o.a().getStringFromGTM("pdc_new_status_check"));
            sb.append("orderId=".concat(String.valueOf(str)));
            k.a((Object) sb, "oderStatusUrl.append(\"orderId=$orderId\")");
            sb.append("&locale=en-IN&child_site_id=1&site_id=1");
            k.a((Object) sb, "oderStatusUrl.append(\"&l…ild_site_id=1&site_id=1\")");
            if (TextUtils.isEmpty(sb)) {
                return null;
            }
            Map hashMap = new HashMap();
            String a2 = net.one97.paytm.bankCommon.mapping.d.a(context);
            k.a((Object) a2, "CJRServerUtility.getSSOToken(context)");
            hashMap.put("authorization", a2);
            hashMap.put("Accept", "application/json");
            if (URLUtil.isValidUrl(sb.toString())) {
                com.paytm.utility.c.a(this.f17966a);
                return new com.paytm.network.b().a(sb.toString()).a(this.f17966a).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a((Map<String, String>) hashMap).a(a.C0715a.GET).a((IJRPaytmDataModel) new PDCStatusResponse()).f().a(bVar).c(str2).l();
            }
        }
        return null;
    }

    public static com.paytm.network.a a(Context context, String str, com.paytm.network.listener.b bVar, String str2, String str3) {
        k.c(context, "context");
        k.c(str, "imageId");
        k.c(bVar, "apiListener");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str3, "bankScopeToken");
        String stringFromGTM = o.a().getStringFromGTM("create_sign_url");
        HashMap hashMap = new HashMap();
        e eVar = e.f17951a;
        hashMap.put(e.f(), str3);
        hashMap.put("Accept", "application/json");
        hashMap.put("Client-Id", UpiConstants.B2C_ANDROID);
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imageId", str);
        jSONObject.put("uploaded", true);
        if (com.paytm.utility.b.c(context)) {
            return new com.paytm.network.b().a(context).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a(a.C0715a.PUT).c(str2).b(jSONObject.toString()).a(stringFromGTM).a((Map<String, String>) hashMap).a(false).a((IJRPaytmDataModel) new CbSignatureUpload((String) null, (CreateSignPayload) null, (String) null, (String) null, 15, (kotlin.g.b.g) null)).a(bVar).l();
        }
        return null;
    }

    public final com.paytm.network.a b(Context context, com.paytm.network.listener.b bVar, String str) {
        k.c(context, "context");
        k.c(bVar, "apiListener");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String stringFromGTM = o.a().getStringFromGTM("cb_finprod_url");
        Map hashMap = new HashMap();
        String a2 = net.one97.paytm.bankCommon.mapping.d.a(this.f17966a);
        k.a((Object) a2, "CJRServerUtility.getSSOToken(mContext)");
        hashMap.put("User-Token", a2);
        hashMap.put("Accept", "application/json");
        return new com.paytm.network.b().a(this.f17966a).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).c(str).a(a.C0715a.GET).a(j.a(stringFromGTM, new boolean[0])).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new ChequeBookFinResponse()).a(bVar).a(false).l();
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f17971a;

        public d(y yVar) {
            this.f17971a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CBLeafDetailResponse) {
                y yVar = this.f17971a;
                b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
                yVar.setValue(b.a.a(iJRPaytmDataModel, false));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f17971a;
            b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public final LiveData<net.one97.paytm.paymentsBank.chequebook.b<CBChequeStatusDetailResponse>> a(int i2, String str, String str2, String str3) {
        k.c(str, "chqType");
        k.c(str2, "chequeStatusType");
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        y yVar = new y();
        b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
        yVar.setValue(b.a.a());
        String stringFromGTM = o.a().getStringFromGTM("cb_info_url");
        if (URLUtil.isValidUrl(stringFromGTM)) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            e eVar = e.f17951a;
            jSONObject.put(e.p(), net.one97.paytm.bankCommon.mapping.d.a(this.f17966a));
            Map map = hashMap;
            e eVar2 = e.f17951a;
            String o = e.o();
            String jSONObject2 = jSONObject.toString();
            k.a((Object) jSONObject2, "authObj.toString()");
            map.put(o, jSONObject2);
            map.put("Accept", "application/json");
            net.one97.paytm.paymentsBank.h.a a2 = o.a();
            k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
            List<String> list = h.a(a2.getApplicationContext()).f17978a;
            JSONObject jSONObject3 = new JSONObject();
            e eVar3 = e.f17951a;
            jSONObject3.put(e.l(), str);
            e eVar4 = e.f17951a;
            String r = e.r();
            e eVar5 = e.f17951a;
            jSONObject3.put(r, e.q());
            e eVar6 = e.f17951a;
            String m = e.m();
            e eVar7 = e.f17951a;
            jSONObject3.put(m, e.n());
            e eVar8 = e.f17951a;
            jSONObject3.put(e.s(), str2);
            e eVar9 = e.f17951a;
            jSONObject3.put(e.t(), i2);
            e eVar10 = e.f17951a;
            String u = e.u();
            e eVar11 = e.f17951a;
            jSONObject3.put(u, e.z());
            if (!TextUtils.isEmpty(h.a(this.f17966a).f17979b)) {
                e eVar12 = e.f17951a;
                jSONObject3.put(e.w(), h.a(this.f17966a).f17979b);
            }
            e eVar13 = e.f17951a;
            jSONObject3.put(e.x(), "ISA");
            if (list != null && (!list.isEmpty()) && !p.a(str, "outward", true)) {
                JSONArray jSONArray = new JSONArray();
                for (String put : list) {
                    jSONArray.put(put);
                }
                e eVar14 = e.f17951a;
                jSONObject3.put(e.D(), jSONArray);
            }
            com.paytm.network.a l = new com.paytm.network.b().a(this.f17966a).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).c(str3).a(a.C0715a.POST).a(stringFromGTM).b(jSONObject3.toString()).a((Map<String, String>) map).a(false).a((IJRPaytmDataModel) new CBChequeStatusDetailResponse(0, 0, 0, (List) null, 15, (kotlin.g.b.g) null)).a((com.paytm.network.listener.b) new e(this, yVar, i2)).l();
            if (com.paytm.utility.b.c(this.f17966a)) {
                b.a aVar2 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
                yVar.setValue(b.a.a());
                l.a();
                return yVar;
            }
        }
        b.a aVar3 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
        yVar.setValue(b.a.a(a()));
        return yVar;
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f17972a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f17973b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f17974c;

        e(g gVar, y yVar, int i2) {
            this.f17972a = gVar;
            this.f17973b = yVar;
            this.f17974c = i2;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CBChequeStatusDetailResponse) {
                y yVar = this.f17973b;
                b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
                yVar.setValue(b.a.a(iJRPaytmDataModel, g.a(this.f17974c)));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f17973b;
            b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public final com.paytm.network.a a(String str, String str2, String str3, com.paytm.network.listener.b bVar, String str4) {
        k.c(str, "isaAcntNum");
        k.c(str2, "chqType");
        k.c(str3, "chequeStatusType");
        k.c(bVar, "apiListener");
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String stringFromGTM = o.a().getStringFromGTM("cb_info_url");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        e eVar = e.f17951a;
        jSONObject.put(e.p(), net.one97.paytm.bankCommon.mapping.d.a(this.f17966a));
        Map map = hashMap;
        e eVar2 = e.f17951a;
        String o = e.o();
        String jSONObject2 = jSONObject.toString();
        k.a((Object) jSONObject2, "authObj.toString()");
        map.put(o, jSONObject2);
        map.put("Accept", "application/json");
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        List<String> list = h.a(a2.getApplicationContext()).f17978a;
        h.a(this.f17966a).f17979b = str;
        JSONObject jSONObject3 = new JSONObject();
        e eVar3 = e.f17951a;
        jSONObject3.put(e.l(), str2);
        e eVar4 = e.f17951a;
        String r = e.r();
        e eVar5 = e.f17951a;
        jSONObject3.put(r, e.q());
        e eVar6 = e.f17951a;
        String m = e.m();
        e eVar7 = e.f17951a;
        jSONObject3.put(m, e.n());
        e eVar8 = e.f17951a;
        jSONObject3.put(e.s(), str3);
        e eVar9 = e.f17951a;
        jSONObject3.put(e.t(), 1);
        e eVar10 = e.f17951a;
        String u = e.u();
        e eVar11 = e.f17951a;
        jSONObject3.put(u, e.z());
        e eVar12 = e.f17951a;
        jSONObject3.put(e.w(), str);
        e eVar13 = e.f17951a;
        jSONObject3.put(e.x(), "ISA");
        if (list != null && (!list.isEmpty()) && !p.a(str2, "outward", true)) {
            e eVar14 = e.f17951a;
            jSONObject3.put(e.D(), list);
        }
        return new com.paytm.network.b().a(this.f17966a).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).c(str4).a(a.C0715a.POST).a(j.a(stringFromGTM, new boolean[0])).b(jSONObject3.toString()).a((Map<String, String>) map).a(false).a((IJRPaytmDataModel) new CBChequeStatusDetailResponse(0, 0, 0, (List) null, 15, (kotlin.g.b.g) null)).a(bVar).l();
    }

    public final LiveData<net.one97.paytm.paymentsBank.chequebook.b<CbStopPaymentResponse>> a(String str, String str2, int i2, String str3) {
        k.c(str, "bankScopeToken");
        k.c(str2, "blockReason");
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        y yVar = new y();
        b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
        yVar.setValue(b.a.a());
        String stringFromGTM = o.a().getStringFromGTM("cb_stop_leaf_url");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            b.a aVar2 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            yVar.setValue(b.a.a(a()));
        } else {
            Map hashMap = new HashMap();
            e eVar = e.f17951a;
            hashMap.put(e.a(), str);
            hashMap.put("Accept", "application/json");
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            e eVar2 = e.f17951a;
            jSONObject.put(e.E(), UpiConstants.B2C_ANDROID);
            e eVar3 = e.f17951a;
            jSONObject.put(e.F(), str2);
            e eVar4 = e.f17951a;
            jSONObject.put(e.H(), i2);
            e eVar5 = e.f17951a;
            String G = e.G();
            e eVar6 = e.f17951a;
            jSONObject.put(G, e.I());
            com.paytm.network.a l = new com.paytm.network.b().a(this.f17966a).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).c(str3).a(a.C0715a.PUT).a(stringFromGTM).b(jSONObject.toString()).a((Map<String, String>) hashMap).a(false).a((IJRPaytmDataModel) new CbStopPaymentResponse((String) null, (String) null, (String) null, (String) null, (String) null, 31, (kotlin.g.b.g) null)).a((com.paytm.network.listener.b) new f(yVar)).l();
            if (com.paytm.utility.b.c(this.f17966a)) {
                l.a();
            }
        }
        return yVar;
    }

    public static final class f implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f17975a;

        f(y yVar) {
            this.f17975a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CbStopPaymentResponse) {
                y yVar = this.f17975a;
                b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
                yVar.setValue(b.a.a(iJRPaytmDataModel, false));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f17975a;
            b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            yVar.setValue(b.a.a(networkCustomError));
        }
    }

    public static NetworkCustomError a() {
        return new NetworkCustomError("Url is null");
    }

    public static final /* synthetic */ boolean a(int i2) {
        e eVar = e.f17951a;
        return i2 > e.A();
    }
}
