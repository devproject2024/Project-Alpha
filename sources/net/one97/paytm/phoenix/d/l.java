package net.one97.paytm.phoenix.d;

import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.util.d;

public final class l extends net.one97.paytm.phoenix.core.a {
    public l() {
        super("paytmFetchSignature", "paytmVerifyPasscode", "paytmFetchWalletToken");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        r3 = r3.get("passcode");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r12, net.one97.paytm.phoenix.api.b r13) {
        /*
            r11 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "event"
            kotlin.g.b.k.c(r12, r1)
            java.lang.String r1 = "bridgeContext"
            kotlin.g.b.k.c(r13, r1)
            super.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.b) r13)
            b(r12, r13)
            android.app.Activity r1 = r12.getActivity()
            r2 = 1
            if (r1 == 0) goto L_0x01e5
            java.lang.String r3 = r12.getBridgeName()
            if (r3 != 0) goto L_0x0021
            goto L_0x01e5
        L_0x0021:
            int r4 = r3.hashCode()
            r5 = -251450969(0xfffffffff10329a7, float:-6.4948625E29)
            if (r4 == r5) goto L_0x01d1
            r5 = -248736097(0xfffffffff12c969f, float:-8.546162E29)
            java.lang.String r6 = ""
            r7 = 24
            r8 = 0
            if (r4 == r5) goto L_0x0196
            r5 = 1035139224(0x3db2f898, float:0.08738822)
            if (r4 == r5) goto L_0x003b
            goto L_0x01e5
        L_0x003b:
            java.lang.String r4 = "paytmVerifyPasscode"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01e5
            org.json.JSONObject r3 = r12.getParams()
            java.lang.String r4 = "passcode"
            if (r3 == 0) goto L_0x0058
            java.lang.Object r3 = r3.get(r4)
            if (r3 == 0) goto L_0x0058
            boolean r5 = r3 instanceof java.lang.String
            if (r5 == 0) goto L_0x0058
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0059
        L_0x0058:
            r3 = r8
        L_0x0059:
            net.one97.paytm.phoenix.util.d$a r5 = net.one97.paytm.phoenix.util.d.f19890a
            boolean r5 = net.one97.paytm.phoenix.util.d.a.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.b) r13, (android.app.Activity) r1, (java.lang.String) r8, (int) r7)
            if (r5 != 0) goto L_0x01e5
            boolean r5 = a(r12, r3, r13)
            if (r5 == 0) goto L_0x01e5
            android.content.Context r1 = (android.content.Context) r1
            net.one97.paytm.phoenix.d.l$a r5 = new net.one97.paytm.phoenix.d.l$a
            r5.<init>(r11, r12, r13)
            com.paytm.network.listener.b r5 = (com.paytm.network.listener.b) r5
            java.lang.String r12 = "mContext"
            kotlin.g.b.k.c(r1, r12)
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x018d }
            r12.<init>()     // Catch:{ Exception -> 0x018d }
            r13 = r12
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x018d }
            java.lang.String r7 = "screen_name"
            java.lang.Class r8 = r11.getClass()     // Catch:{ Exception -> 0x018d }
            java.lang.String r8 = r8.getSimpleName()     // Catch:{ Exception -> 0x018d }
            r13.put(r7, r8)     // Catch:{ Exception -> 0x018d }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = "pb_rsa_key"
            java.lang.String r13 = net.one97.paytm.j.c.a(r13)     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = net.one97.paytm.upi.common.OfflineDataEncryption.encrypt(r13, r3)     // Catch:{ Exception -> 0x018d }
            java.lang.String r3 = "OfflineDataEncryption.en…_BANK_RSA_KEY), passcode)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)     // Catch:{ Exception -> 0x018d }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x018d }
            r3.<init>()     // Catch:{ Exception -> 0x018d }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x018d }
            java.lang.String r7 = "Authorization"
            java.lang.String r8 = com.paytm.utility.b.m()     // Catch:{ Exception -> 0x018d }
            java.lang.String r9 = "CJRAppCommonUtility.getAuthorizationValue()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x018d }
            r3.put(r7, r8)     // Catch:{ Exception -> 0x018d }
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "application/x-www-form-urlencoded"
            r3.put(r7, r8)     // Catch:{ Exception -> 0x018d }
            java.lang.String r7 = "session_token"
            java.lang.String r8 = com.paytm.utility.a.q(r1)     // Catch:{ Exception -> 0x018d }
            java.lang.String r9 = "ApplaunchUtility.getSSOToken(mContext)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x018d }
            r3.put(r7, r8)     // Catch:{ Exception -> 0x018d }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x018d }
            java.lang.String r7 = net.one97.paytm.j.c.f()     // Catch:{ Exception -> 0x018d }
            java.lang.String r7 = com.paytm.utility.b.e((android.content.Context) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x018d }
            net.one97.paytm.utils.ag$a r8 = net.one97.paytm.utils.ag.f69605a     // Catch:{ Exception -> 0x018d }
            android.content.Context r8 = r1.getApplicationContext()     // Catch:{ Exception -> 0x018d }
            java.lang.String r9 = "mContext.getApplicationContext()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x018d }
            com.paytm.b.a.a r8 = net.one97.paytm.utils.ag.a.a(r8)     // Catch:{ Exception -> 0x018d }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018d }
            java.lang.String r10 = "grant_type="
            r9.<init>(r10)     // Catch:{ Exception -> 0x018d }
            java.lang.String r10 = "password"
            java.lang.String r10 = java.net.URLEncoder.encode(r10, r0)     // Catch:{ Exception -> 0x018d }
            r9.append(r10)     // Catch:{ Exception -> 0x018d }
            java.lang.String r10 = "&login_id="
            r9.append(r10)     // Catch:{ Exception -> 0x018d }
            java.lang.String r10 = "mobile"
            java.lang.String r6 = r8.b((java.lang.String) r10, (java.lang.String) r6, (boolean) r2)     // Catch:{ Exception -> 0x018d }
            java.lang.String r6 = java.net.URLEncoder.encode(r6, r0)     // Catch:{ Exception -> 0x018d }
            r9.append(r6)     // Catch:{ Exception -> 0x018d }
            java.lang.String r6 = "&login_secret="
            r9.append(r6)     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = java.net.URLEncoder.encode(r13, r0)     // Catch:{ Exception -> 0x018d }
            r9.append(r13)     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = "&scope="
            r9.append(r13)     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = "bank_txn"
            java.lang.String r13 = java.net.URLEncoder.encode(r13, r0)     // Catch:{ Exception -> 0x018d }
            r9.append(r13)     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = "&login_id_type="
            r9.append(r13)     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = "phone"
            java.lang.String r13 = java.net.URLEncoder.encode(r13, r0)     // Catch:{ Exception -> 0x018d }
            r9.append(r13)     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = "&login_secret_type="
            r9.append(r13)     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = java.net.URLEncoder.encode(r4, r0)     // Catch:{ Exception -> 0x018d }
            r9.append(r13)     // Catch:{ Exception -> 0x018d }
            java.lang.String r13 = r9.toString()     // Catch:{ Exception -> 0x018d }
            java.lang.String r0 = "StringBuilder(\"grant_typ…de\", \"UTF-8\")).toString()"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r0 = new com.paytm.network.b     // Catch:{ Exception -> 0x018d }
            r0.<init>()     // Catch:{ Exception -> 0x018d }
            com.paytm.network.a$b r4 = com.paytm.network.a.b.SILENT     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.b) r4)     // Catch:{ Exception -> 0x018d }
            java.lang.String r4 = "AutoSubscriptionUtil"
            com.paytm.network.b r0 = r0.c(r4)     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r0 = r0.a((android.content.Context) r1)     // Catch:{ Exception -> 0x018d }
            com.paytm.network.a$c r1 = com.paytm.network.a.c.GOLD     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.c) r1)     // Catch:{ Exception -> 0x018d }
            com.paytm.network.a$a r1 = com.paytm.network.a.C0715a.POST     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.C0715a) r1)     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r0 = r0.a((java.lang.String) r7)     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r0 = r0.h()     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x018d }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r12 = r0.b((java.util.Map) r12)     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r12 = r12.b((java.lang.String) r13)     // Catch:{ Exception -> 0x018d }
            net.one97.paytm.common.entity.paymentsbank.CJRVerifyPasscodeResponse r13 = new net.one97.paytm.common.entity.paymentsbank.CJRVerifyPasscodeResponse     // Catch:{ Exception -> 0x018d }
            r13.<init>()     // Catch:{ Exception -> 0x018d }
            com.paytm.network.model.IJRPaytmDataModel r13 = (com.paytm.network.model.IJRPaytmDataModel) r13     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r12 = r12.a((com.paytm.network.model.IJRPaytmDataModel) r13)     // Catch:{ Exception -> 0x018d }
            com.paytm.network.b r12 = r12.a((com.paytm.network.listener.b) r5)     // Catch:{ Exception -> 0x018d }
            com.paytm.network.a r12 = r12.l()     // Catch:{ Exception -> 0x018d }
            r12.a()     // Catch:{ Exception -> 0x018d }
            goto L_0x01e5
        L_0x018d:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            com.paytm.utility.q.b(r12)
            goto L_0x01e5
        L_0x0196:
            java.lang.String r0 = "paytmFetchSignature"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x01e5
            org.json.JSONObject r0 = r12.getParams()
            if (r0 == 0) goto L_0x01b3
            java.lang.String r3 = "url"
            java.lang.Object r0 = r0.get(r3)
            if (r0 == 0) goto L_0x01b3
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L_0x01b3
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x01b4
        L_0x01b3:
            r0 = r8
        L_0x01b4:
            net.one97.paytm.phoenix.util.d$a r3 = net.one97.paytm.phoenix.util.d.f19890a
            boolean r1 = net.one97.paytm.phoenix.util.d.a.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.b) r13, (android.app.Activity) r1, (java.lang.String) r8, (int) r7)
            if (r1 != 0) goto L_0x01e5
            boolean r13 = a(r12, r0, r13)
            if (r13 == 0) goto L_0x01e5
            java.lang.String r13 = "POST"
            java.lang.String r13 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r13)
            if (r13 != 0) goto L_0x01cb
            r13 = r6
        L_0x01cb:
            r0 = 0
            r1 = 4
            net.one97.paytm.phoenix.core.a.a(r11, r12, r13, r0, r1)
            goto L_0x01e5
        L_0x01d1:
            java.lang.String r0 = "paytmFetchWalletToken"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x01e5
            net.one97.paytm.phoenix.d.l$b r0 = new net.one97.paytm.phoenix.d.l$b
            r0.<init>(r11, r12, r13)
            com.paytm.network.listener.b r0 = (com.paytm.network.listener.b) r0
            com.paytm.network.a$c r12 = com.paytm.network.a.c.GOLD
            net.one97.paytm.utils.t.a((android.app.Activity) r1, (com.paytm.network.listener.b) r0, (com.paytm.network.a.c) r12)
        L_0x01e5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.l.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f19823a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f19824b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f19825c;

        a(l lVar, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
            this.f19823a = lVar;
            this.f19824b = h5Event;
            this.f19825c = bVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            net.one97.paytm.phoenix.core.a.a(this.f19823a, this.f19824b, Boolean.TRUE, false, 4);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "error");
            net.one97.paytm.phoenix.core.a.a(this.f19823a, this.f19824b, Boolean.FALSE, false, 4);
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f19826a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f19827b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f19828c;

        b(l lVar, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
            this.f19826a = lVar;
            this.f19827b = h5Event;
            this.f19828c = bVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                Iterator<CJRPGToken> it2 = ((CJRPGTokenList) iJRPaytmDataModel).getPGTokenList().iterator();
                while (it2.hasNext()) {
                    CJRPGToken next = it2.next();
                    k.a((Object) next, "item");
                    if (k.a((Object) next.getScope(), (Object) "wallet")) {
                        net.one97.paytm.phoenix.core.a.a(this.f19826a, this.f19827b, next.getAccess_token(), false, 4);
                    }
                }
                return;
            }
            net.one97.paytm.phoenix.core.a.a(this.f19826a, this.f19827b, "", false, 4);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "error");
            net.one97.paytm.phoenix.core.a.a(this.f19826a, this.f19827b, "", false, 4);
        }
    }

    private static boolean a(H5Event h5Event, String str, net.one97.paytm.phoenix.api.b bVar) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return true;
        }
        d.a aVar = d.f19890a;
        d.a.a(h5Event, net.one97.paytm.phoenix.api.a.NOT_FOUND, "Key not found", bVar);
        return false;
    }
}
