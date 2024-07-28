package net.one97.paytm.h5.a;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.h5.a.e;
import net.one97.paytm.h5paytmsdk.b.ad;

public final class j extends ad {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j() {
        super(e.j, e.k, e.l);
        e.a aVar = e.f16836a;
        e.a aVar2 = e.f16836a;
        e.a aVar3 = e.f16836a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r12 = r12.get("url");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleEvent(com.alipay.mobile.h5container.api.H5Event r12, com.alipay.mobile.h5container.api.H5BridgeContext r13) {
        /*
            r11 = this;
            java.lang.String r0 = "UTF-8"
            super.handleEvent(r12, r13)
            boolean r1 = r11.a((com.alipay.mobile.h5container.api.H5Event) r12)
            r2 = 1
            if (r1 == 0) goto L_0x01d4
            if (r12 == 0) goto L_0x01d4
            android.app.Activity r1 = r12.getActivity()
            if (r1 == 0) goto L_0x01d4
            java.lang.String r3 = r12.getAction()
            net.one97.paytm.h5.a.e$a r4 = net.one97.paytm.h5.a.e.f16836a
            java.lang.String r4 = net.one97.paytm.h5.a.e.j
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            java.lang.String r5 = ""
            r6 = 12
            r7 = 0
            if (r4 == 0) goto L_0x005b
            com.alibaba.a.e r12 = r12.getParam()
            if (r12 == 0) goto L_0x003e
            java.lang.String r0 = "url"
            java.lang.Object r12 = r12.get(r0)
            if (r12 == 0) goto L_0x003e
            boolean r0 = r12 instanceof java.lang.String
            if (r0 == 0) goto L_0x003e
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x003f
        L_0x003e:
            r12 = r7
        L_0x003f:
            net.one97.paytm.h5.a.e$a r0 = net.one97.paytm.h5.a.e.f16836a
            boolean r0 = net.one97.paytm.h5.a.e.a.a((com.alipay.mobile.h5container.api.H5BridgeContext) r13, (android.app.Activity) r1, (java.lang.String) r7, (int) r6)
            if (r0 != 0) goto L_0x01d4
            boolean r13 = a(r12, r13)
            if (r13 == 0) goto L_0x01d4
            java.lang.String r13 = "POST"
            java.lang.String r12 = com.paytm.utility.b.d((java.lang.String) r12, (java.lang.String) r13)
            if (r12 != 0) goto L_0x0056
            r12 = r5
        L_0x0056:
            r11.a((java.lang.Object) r12)
            goto L_0x01d4
        L_0x005b:
            net.one97.paytm.h5.a.e$a r4 = net.one97.paytm.h5.a.e.f16836a
            java.lang.String r4 = net.one97.paytm.h5.a.e.k
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x01bc
            com.alibaba.a.e r3 = r12.getParam()
            java.lang.String r4 = "passcode"
            if (r3 == 0) goto L_0x007c
            java.lang.Object r3 = r3.get(r4)
            if (r3 == 0) goto L_0x007c
            boolean r8 = r3 instanceof java.lang.String
            if (r8 == 0) goto L_0x007c
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x007d
        L_0x007c:
            r3 = r7
        L_0x007d:
            net.one97.paytm.h5.a.e$a r8 = net.one97.paytm.h5.a.e.f16836a
            boolean r6 = net.one97.paytm.h5.a.e.a.a((com.alipay.mobile.h5container.api.H5BridgeContext) r13, (android.app.Activity) r1, (java.lang.String) r7, (int) r6)
            if (r6 != 0) goto L_0x01d4
            boolean r6 = a(r3, r13)
            if (r6 == 0) goto L_0x01d4
            android.content.Context r1 = (android.content.Context) r1
            net.one97.paytm.h5.a.j$a r6 = new net.one97.paytm.h5.a.j$a
            r6.<init>(r11, r12, r13)
            com.paytm.network.listener.b r6 = (com.paytm.network.listener.b) r6
            java.lang.String r12 = "mContext"
            kotlin.g.b.k.c(r1, r12)
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x01b1 }
            r12.<init>()     // Catch:{ Exception -> 0x01b1 }
            r13 = r12
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r7 = "screen_name"
            java.lang.Class r8 = r11.getClass()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r8 = r8.getSimpleName()     // Catch:{ Exception -> 0x01b1 }
            r13.put(r7, r8)     // Catch:{ Exception -> 0x01b1 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = "pb_rsa_key"
            java.lang.String r13 = net.one97.paytm.j.c.a(r13)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = net.one97.paytm.upi.common.OfflineDataEncryption.encrypt(r13, r3)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r3 = "OfflineDataEncryption.en…_BANK_RSA_KEY), passcode)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)     // Catch:{ Exception -> 0x01b1 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x01b1 }
            r3.<init>()     // Catch:{ Exception -> 0x01b1 }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r7 = "Authorization"
            java.lang.String r8 = com.paytm.utility.b.m()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r9 = "CJRAppCommonUtility.getAuthorizationValue()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x01b1 }
            r3.put(r7, r8)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "application/x-www-form-urlencoded"
            r3.put(r7, r8)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r7 = "session_token"
            java.lang.String r8 = com.paytm.utility.a.q(r1)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r9 = "ApplaunchUtility.getSSOToken(mContext)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x01b1 }
            r3.put(r7, r8)     // Catch:{ Exception -> 0x01b1 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r7 = net.one97.paytm.j.c.f()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r7 = com.paytm.utility.b.e((android.content.Context) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x01b1 }
            net.one97.paytm.utils.ag$a r8 = net.one97.paytm.utils.ag.f69605a     // Catch:{ Exception -> 0x01b1 }
            android.content.Context r8 = r1.getApplicationContext()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r9 = "mContext.getApplicationContext()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.b.a.a r8 = net.one97.paytm.utils.ag.a.a(r8)     // Catch:{ Exception -> 0x01b1 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r10 = "grant_type="
            r9.<init>(r10)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r10 = "password"
            java.lang.String r10 = java.net.URLEncoder.encode(r10, r0)     // Catch:{ Exception -> 0x01b1 }
            r9.append(r10)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r10 = "&login_id="
            r9.append(r10)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r10 = "mobile"
            java.lang.String r5 = r8.b((java.lang.String) r10, (java.lang.String) r5, (boolean) r2)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r5 = java.net.URLEncoder.encode(r5, r0)     // Catch:{ Exception -> 0x01b1 }
            r9.append(r5)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r5 = "&login_secret="
            r9.append(r5)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = java.net.URLEncoder.encode(r13, r0)     // Catch:{ Exception -> 0x01b1 }
            r9.append(r13)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = "&scope="
            r9.append(r13)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = "bank_txn"
            java.lang.String r13 = java.net.URLEncoder.encode(r13, r0)     // Catch:{ Exception -> 0x01b1 }
            r9.append(r13)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = "&login_id_type="
            r9.append(r13)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = "phone"
            java.lang.String r13 = java.net.URLEncoder.encode(r13, r0)     // Catch:{ Exception -> 0x01b1 }
            r9.append(r13)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = "&login_secret_type="
            r9.append(r13)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = java.net.URLEncoder.encode(r4, r0)     // Catch:{ Exception -> 0x01b1 }
            r9.append(r13)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = r9.toString()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r0 = "StringBuilder(\"grant_typ…de\", \"UTF-8\")).toString()"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r0 = new com.paytm.network.b     // Catch:{ Exception -> 0x01b1 }
            r0.<init>()     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.a$b r4 = com.paytm.network.a.b.SILENT     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.b) r4)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r4 = "AutoSubscriptionUtil"
            com.paytm.network.b r0 = r0.c(r4)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r0 = r0.a((android.content.Context) r1)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.a$c r1 = com.paytm.network.a.c.GOLD     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.c) r1)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.a$a r1 = com.paytm.network.a.C0715a.POST     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.C0715a) r1)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r0 = r0.a((java.lang.String) r7)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r0 = r0.h()     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x01b1 }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r12 = r0.b((java.util.Map) r12)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r12 = r12.b((java.lang.String) r13)     // Catch:{ Exception -> 0x01b1 }
            net.one97.paytm.common.entity.paymentsbank.CJRVerifyPasscodeResponse r13 = new net.one97.paytm.common.entity.paymentsbank.CJRVerifyPasscodeResponse     // Catch:{ Exception -> 0x01b1 }
            r13.<init>()     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.model.IJRPaytmDataModel r13 = (com.paytm.network.model.IJRPaytmDataModel) r13     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r12 = r12.a((com.paytm.network.model.IJRPaytmDataModel) r13)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.b r12 = r12.a((com.paytm.network.listener.b) r6)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.network.a r12 = r12.l()     // Catch:{ Exception -> 0x01b1 }
            r12.a()     // Catch:{ Exception -> 0x01b1 }
            goto L_0x01d4
        L_0x01b1:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            java.lang.String r13 = "PaytmH5GoldPlugin"
            net.one97.paytm.upi.common.PaytmLogs.e(r13, r12)
            goto L_0x01d4
        L_0x01bc:
            net.one97.paytm.h5.a.e$a r0 = net.one97.paytm.h5.a.e.f16836a
            java.lang.String r0 = net.one97.paytm.h5.a.e.l
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x01d4
            net.one97.paytm.h5.a.j$b r0 = new net.one97.paytm.h5.a.j$b
            r0.<init>(r11, r12, r13)
            com.paytm.network.listener.b r0 = (com.paytm.network.listener.b) r0
            com.paytm.network.a$c r12 = com.paytm.network.a.c.GOLD
            net.one97.paytm.utils.t.a((android.app.Activity) r1, (com.paytm.network.listener.b) r0, (com.paytm.network.a.c) r12)
        L_0x01d4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5.a.j.handleEvent(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):boolean");
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f16863a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f16864b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f16865c;

        a(j jVar, H5Event h5Event, H5BridgeContext h5BridgeContext) {
            this.f16863a = jVar;
            this.f16864b = h5Event;
            this.f16865c = h5BridgeContext;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            this.f16863a.a((Object) Boolean.TRUE);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "error");
            this.f16863a.a((Object) Boolean.FALSE);
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f16866a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f16867b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f16868c;

        b(j jVar, H5Event h5Event, H5BridgeContext h5BridgeContext) {
            this.f16866a = jVar;
            this.f16867b = h5Event;
            this.f16868c = h5BridgeContext;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                Iterator<CJRPGToken> it2 = ((CJRPGTokenList) iJRPaytmDataModel).getPGTokenList().iterator();
                while (it2.hasNext()) {
                    CJRPGToken next = it2.next();
                    k.a((Object) next, "item");
                    if (k.a((Object) next.getScope(), (Object) "wallet")) {
                        this.f16866a.a((Object) next.getAccess_token());
                    }
                }
                return;
            }
            this.f16866a.a((Object) "");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "error");
            this.f16866a.a((Object) "");
        }
    }

    private static boolean a(String str, H5BridgeContext h5BridgeContext) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return true;
        }
        e.a aVar = e.f16836a;
        e.a.a(Integer.valueOf(H5Event.Error.NOT_FOUND.ordinal()), "Key not found", h5BridgeContext);
        return false;
    }
}
