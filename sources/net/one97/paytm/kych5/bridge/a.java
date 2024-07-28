package net.one97.paytm.kych5.bridge;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;

public final class a extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    private H5Event f51047a;

    public a() {
        super("encryptAOTPJson");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0270 A[Catch:{ Exception -> 0x0286 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009e A[LOOP:0: B:39:0x009e->B:45:0x00b9, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015b A[SYNTHETIC, Splitter:B:63:0x015b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r22, net.one97.paytm.phoenix.api.b r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "(this as java.lang.String).getBytes(charset)"
            java.lang.String r4 = ""
            java.lang.String r5 = "event"
            kotlin.g.b.k.c(r1, r5)
            java.lang.String r5 = "bridgeContext"
            kotlin.g.b.k.c(r2, r5)
            super.a((net.one97.paytm.phoenix.api.H5Event) r22, (net.one97.paytm.phoenix.api.b) r23)
            r0.f51047a = r1
            b(r22, r23)
            android.app.Activity r5 = r22.getActivity()
            if (r5 == 0) goto L_0x02ed
            org.json.JSONObject r7 = r22.getParams()
            if (r7 == 0) goto L_0x0030
            java.lang.String r9 = "url"
            java.lang.String r9 = r7.getString(r9)
            goto L_0x0031
        L_0x0030:
            r9 = 0
        L_0x0031:
            if (r7 == 0) goto L_0x003a
            java.lang.String r10 = "method"
            java.lang.String r10 = r7.getString(r10)
            goto L_0x003b
        L_0x003a:
            r10 = 0
        L_0x003b:
            if (r10 != 0) goto L_0x003e
            goto L_0x0063
        L_0x003e:
            int r11 = r10.hashCode()
            r12 = 79599(0x136ef, float:1.11542E-40)
            if (r11 == r12) goto L_0x0058
            r12 = 2461856(0x2590a0, float:3.449795E-39)
            if (r11 == r12) goto L_0x004d
            goto L_0x0063
        L_0x004d:
            java.lang.String r11 = "POST"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x0063
            com.paytm.network.a$a r10 = com.paytm.network.a.C0715a.POST
            goto L_0x0065
        L_0x0058:
            java.lang.String r11 = "PUT"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x0063
            com.paytm.network.a$a r10 = com.paytm.network.a.C0715a.PUT
            goto L_0x0065
        L_0x0063:
            com.paytm.network.a$a r10 = com.paytm.network.a.C0715a.GET
        L_0x0065:
            if (r7 == 0) goto L_0x006e
            java.lang.String r11 = "body"
            org.json.JSONObject r11 = r7.getJSONObject(r11)
            goto L_0x006f
        L_0x006e:
            r11 = 0
        L_0x006f:
            java.lang.String r12 = "referenceNumber"
            if (r11 == 0) goto L_0x0078
            java.lang.String r13 = r11.getString(r12)
            goto L_0x0079
        L_0x0078:
            r13 = 0
        L_0x0079:
            if (r11 == 0) goto L_0x0082
            java.lang.String r14 = "otp"
            java.lang.String r11 = r11.getString(r14)
            goto L_0x0083
        L_0x0082:
            r11 = 0
        L_0x0083:
            if (r7 == 0) goto L_0x008c
            java.lang.String r14 = "header"
            org.json.JSONObject r7 = r7.getJSONObject(r14)
            goto L_0x008d
        L_0x008c:
            r7 = 0
        L_0x008d:
            if (r7 == 0) goto L_0x0094
            java.util.Iterator r14 = r7.keys()
            goto L_0x0095
        L_0x0094:
            r14 = 0
        L_0x0095:
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            java.util.Map r15 = (java.util.Map) r15
            if (r14 == 0) goto L_0x00bd
        L_0x009e:
            boolean r16 = r14.hasNext()
            if (r16 == 0) goto L_0x00bd
            java.lang.Object r16 = r14.next()
            r8 = r16
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r6 = "key"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            if (r7 == 0) goto L_0x00b8
            java.lang.String r6 = r7.getString(r8)
            goto L_0x00b9
        L_0x00b8:
            r6 = 0
        L_0x00b9:
            r15.put(r8, r6)
            goto L_0x009e
        L_0x00bd:
            java.lang.String r6 = com.paytm.utility.b.e()
            java.lang.String r7 = com.paytm.utility.b.f()
            net.one97.paytm.kych5.bridge.CJREncryptedModel r8 = new net.one97.paytm.kych5.bridge.CJREncryptedModel
            r8.<init>()
            r8.setIv(r7)
            r8.setKey(r6)
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027d }
            r1.<init>(r6)     // Catch:{ Exception -> 0x027d }
            r17 = r9
            r9 = 58
            r1.append(r9)     // Catch:{ Exception -> 0x027a }
            r1.append(r7)     // Catch:{ Exception -> 0x027a }
            net.one97.paytm.upgradeKyc.helper.e$a r9 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ Exception -> 0x027a }
            net.one97.paytm.upgradeKyc.helper.f r9 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ Exception -> 0x027a }
            java.lang.String r9 = r9.c()     // Catch:{ Exception -> 0x027a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x027a }
            java.lang.String r1 = net.one97.paytm.common.utility.f.a(r9, r1)     // Catch:{ Exception -> 0x027a }
            java.lang.String r9 = "x-keyiv"
            r15.put(r9, r1)     // Catch:{ Exception -> 0x027a }
            java.lang.String r1 = "uidai_auth.cer"
            net.one97.paytm.upgradeKyc.utils.a r9 = new net.one97.paytm.upgradeKyc.utils.a     // Catch:{ Exception -> 0x027a }
            r18 = r8
            android.content.res.AssetManager r8 = r5.getAssets()     // Catch:{ Exception -> 0x0281 }
            java.io.InputStream r1 = r8.open(r1)     // Catch:{ Exception -> 0x0281 }
            r9.<init>(r1)     // Catch:{ Exception -> 0x0281 }
            byte[] r1 = net.one97.paytm.upgradeKyc.utils.a.a()     // Catch:{ Exception -> 0x0281 }
            java.lang.String r8 = r9.a(r1)     // Catch:{ Exception -> 0x0281 }
            r19 = r15
            java.util.Calendar r15 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0277 }
            r20 = r10
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0285 }
            java.lang.String r0 = "yyyy-MM-dd'T'HH:mm:ss"
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0285 }
            r10.<init>(r0, r2)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r0 = "calendar"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)     // Catch:{ Exception -> 0x0285 }
            java.util.Date r0 = r15.getTime()     // Catch:{ Exception -> 0x0285 }
            java.lang.String r0 = r10.format(r0)     // Catch:{ Exception -> 0x0285 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = "<Pid ts=\""
            r2.<init>(r10)     // Catch:{ Exception -> 0x0285 }
            r2.append(r0)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = "\" ver=\"2.0\" wadh=\"pc0K1hVqt6oaWRjtxuFDfkB7aCL356jpGa28E1WIZ/4=\"><Pv otp=\""
            r2.append(r10)     // Catch:{ Exception -> 0x0285 }
            r2.append(r11)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r10 = "\" /></Pid>"
            r2.append(r10)     // Catch:{ Exception -> 0x0285 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0285 }
            net.one97.paytm.upgradeKyc.utils.g r10 = new net.one97.paytm.upgradeKyc.utils.g     // Catch:{ Exception -> 0x0285 }
            r10.<init>()     // Catch:{ Exception -> 0x0285 }
            java.nio.charset.Charset r10 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x0285 }
            java.lang.String r11 = "null cannot be cast to non-null type java.lang.String"
            if (r2 == 0) goto L_0x0270
            byte[] r10 = r2.getBytes(r10)     // Catch:{ Exception -> 0x0285 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r3)     // Catch:{ Exception -> 0x0285 }
            byte[] r10 = net.one97.paytm.upgradeKyc.utils.g.a(r10)     // Catch:{ Exception -> 0x0285 }
            r15 = 0
            java.lang.String r10 = net.one97.paytm.upgradeKyc.utils.a.a(r1, r10, r0, r15)     // Catch:{ Exception -> 0x0285 }
            java.nio.charset.Charset r15 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x0285 }
            if (r2 == 0) goto L_0x0269
            byte[] r2 = r2.getBytes(r15)     // Catch:{ Exception -> 0x0285 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0285 }
            r3 = 1
            java.lang.String r1 = net.one97.paytm.upgradeKyc.utils.a.a(r1, r2, r0, r3)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r2 = "phone"
            r5.getSystemService(r2)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r2 = "userId"
            r11 = r5
            android.content.Context r11 = (android.content.Context) r11     // Catch:{ Exception -> 0x0286 }
            java.lang.String r11 = com.paytm.utility.b.n((android.content.Context) r11)     // Catch:{ Exception -> 0x0286 }
            r14.put(r2, r11)     // Catch:{ Exception -> 0x0286 }
            r14.put(r12, r13)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r2 = "encHMac"
            r14.put(r2, r10)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r2 = "encryptedPid"
            r14.put(r2, r1)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "certificateExpiry"
            java.lang.String r2 = r9.b()     // Catch:{ Exception -> 0x0286 }
            r14.put(r1, r2)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "sessionKey"
            r14.put(r1, r8)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "pincode"
            java.lang.String r2 = "201301"
            r14.put(r1, r2)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "timeStamp"
            r14.put(r1, r0)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r0 = "channel"
            java.lang.String r1 = "mobile"
            r14.put(r0, r1)     // Catch:{ Exception -> 0x0286 }
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x0286 }
            java.lang.String r0 = com.paytm.utility.b.d((android.content.Context) r0)     // Catch:{ Exception -> 0x0286 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0286 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "deviceCode"
            if (r0 != 0) goto L_0x01d9
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x0286 }
            java.lang.String r0 = com.paytm.utility.b.d((android.content.Context) r0)     // Catch:{ Exception -> 0x0286 }
            r14.put(r1, r0)     // Catch:{ Exception -> 0x0286 }
            goto L_0x01de
        L_0x01d9:
            java.lang.String r0 = "0-0"
            r14.put(r1, r0)     // Catch:{ Exception -> 0x0286 }
        L_0x01de:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0286 }
            r0.<init>()     // Catch:{ Exception -> 0x0286 }
            r1 = r5
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = com.paytm.utility.b.s((android.content.Context) r1)     // Catch:{ Exception -> 0x0286 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0286 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r2 = "0.0"
            java.lang.String r8 = "latitude"
            if (r1 != 0) goto L_0x0201
            r1 = r5
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = com.paytm.utility.b.s((android.content.Context) r1)     // Catch:{ Exception -> 0x0286 }
            r0.put(r8, r1)     // Catch:{ Exception -> 0x0286 }
            goto L_0x0204
        L_0x0201:
            r0.put(r8, r2)     // Catch:{ Exception -> 0x0286 }
        L_0x0204:
            r1 = r5
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = com.paytm.utility.b.t((android.content.Context) r1)     // Catch:{ Exception -> 0x0286 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0286 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r8 = "longitude"
            if (r1 != 0) goto L_0x0220
            r1 = r5
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = com.paytm.utility.b.t((android.content.Context) r1)     // Catch:{ Exception -> 0x0286 }
            r0.put(r8, r1)     // Catch:{ Exception -> 0x0286 }
            goto L_0x0223
        L_0x0220:
            r0.put(r8, r2)     // Catch:{ Exception -> 0x0286 }
        L_0x0223:
            java.lang.String r1 = "location"
            r14.put(r1, r0)     // Catch:{ Exception -> 0x0286 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0286 }
            r0.<init>()     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "deviceDetails"
            r14.put(r1, r0)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "rdsId"
            r0.put(r1, r4)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "rdsVer"
            r0.put(r1, r4)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "dpId"
            r0.put(r1, r4)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "dc"
            r0.put(r1, r4)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "mi"
            r0.put(r1, r4)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "mc"
            r0.put(r1, r4)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r0 = r14.toString()     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = "reqJsonObject.toString()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0286 }
            java.lang.String r1 = net.one97.paytm.common.utility.f.a(r7, r6, r0)     // Catch:{ Exception -> 0x0267 }
            java.lang.String r2 = "KycDataEncryption.encryptRequest(iv, key, body)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0267 }
            r4 = r21
            r6 = r23
            goto L_0x0291
        L_0x0267:
            r1 = r0
            goto L_0x0287
        L_0x0269:
            r3 = 1
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0286 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x0286 }
            throw r0     // Catch:{ Exception -> 0x0286 }
        L_0x0270:
            r3 = 1
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0286 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x0286 }
            throw r0     // Catch:{ Exception -> 0x0286 }
        L_0x0277:
            r20 = r10
            goto L_0x0285
        L_0x027a:
            r18 = r8
            goto L_0x0281
        L_0x027d:
            r18 = r8
            r17 = r9
        L_0x0281:
            r20 = r10
            r19 = r15
        L_0x0285:
            r3 = 1
        L_0x0286:
            r1 = r4
        L_0x0287:
            r0 = -1
            java.lang.String r2 = "Something went wrong"
            r4 = r21
            r6 = r23
            r4.a(r6, r0, r2)
        L_0x0291:
            net.one97.paytm.upgradeKyc.helper.a$a r0 = net.one97.paytm.upgradeKyc.helper.a.f66022a
            com.paytm.network.b r0 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a()
            android.content.Context r5 = (android.content.Context) r5
            com.paytm.network.b r0 = r0.a((android.content.Context) r5)
            r10 = r20
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.C0715a) r10)
            r15 = r19
            com.paytm.network.b r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r15)
            r8 = r18
            com.paytm.network.model.IJRPaytmDataModel r8 = (com.paytm.network.model.IJRPaytmDataModel) r8
            com.paytm.network.b r0 = r0.a((com.paytm.network.model.IJRPaytmDataModel) r8)
            java.lang.String r2 = "text/plain"
            com.paytm.network.b r0 = r0.e(r2)
            com.paytm.network.b r0 = r0.b((java.lang.String) r1)
            r8 = r17
            com.paytm.network.b r0 = r0.a((java.lang.String) r8)
            java.lang.Class<net.one97.paytm.upgradeKyc.activity.AadhaarOtpActivity> r1 = net.one97.paytm.upgradeKyc.activity.AadhaarOtpActivity.class
            java.lang.String r1 = r1.getName()
            com.paytm.network.b r0 = r0.c(r1)
            com.paytm.network.a$b r1 = com.paytm.network.a.b.USER_FACING
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.b) r1)
            com.paytm.network.a$c r1 = com.paytm.network.a.c.KYC
            com.paytm.network.b r0 = r0.a((com.paytm.network.a.c) r1)
            net.one97.paytm.kych5.bridge.a$a r1 = new net.one97.paytm.kych5.bridge.a$a
            r2 = r22
            r1.<init>(r4, r2, r6)
            com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1
            com.paytm.network.b r0 = r0.a((com.paytm.network.listener.b) r1)
            com.paytm.network.a r0 = r0.l()
            r0.a()
            return r3
        L_0x02ed:
            r4 = r0
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.kych5.bridge.a.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    /* renamed from: net.one97.paytm.kych5.bridge.a$a  reason: collision with other inner class name */
    public static final class C0924a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f51048a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f51049b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f51050c;

        C0924a(a aVar, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
            this.f51048a = aVar;
            this.f51049b = h5Event;
            this.f51050c = bVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof CJREncryptedModel) {
                net.one97.paytm.phoenix.core.a.a(this.f51048a, this.f51049b, ((CJREncryptedModel) iJRPaytmDataModel).getRawResponse(), false, 4);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            a aVar = this.f51048a;
            net.one97.paytm.phoenix.api.b bVar = this.f51050c;
            int statusCode = networkCustomError.getStatusCode();
            String alertMessage = networkCustomError.getAlertMessage();
            k.a((Object) alertMessage, "networkCustomError.alertMessage");
            aVar.a(bVar, statusCode, alertMessage);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(net.one97.paytm.phoenix.api.b bVar, int i2, String str) {
        if (bVar != null) {
            H5Event h5Event = this.f51047a;
            if (h5Event == null) {
                k.a("ev");
            }
            bVar.a(h5Event, i2, str);
        }
    }
}
