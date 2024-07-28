package net.one97.paytm.kych5.bridge;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;

public final class b extends net.one97.paytm.phoenix.core.a {
    public b() {
        super("encryptedApiHit");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a4 A[LOOP:0: B:45:0x00a4->B:51:0x00bd, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r14, net.one97.paytm.phoenix.api.b r15) {
        /*
            r13 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r14, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r15, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r14, (net.one97.paytm.phoenix.api.b) r15)
            b(r14, r15)
            android.app.Activity r0 = r14.getActivity()
            r1 = 0
            if (r0 == 0) goto L_0x0178
            org.json.JSONObject r2 = r14.getParams()
            r3 = 0
            if (r2 == 0) goto L_0x0026
            java.lang.String r4 = "url"
            java.lang.String r4 = r2.getString(r4)
            goto L_0x0027
        L_0x0026:
            r4 = r3
        L_0x0027:
            if (r2 == 0) goto L_0x0036
            java.lang.String r5 = "body"
            org.json.JSONObject r5 = r2.getJSONObject(r5)
            if (r5 == 0) goto L_0x0036
            java.lang.String r5 = r5.toString()
            goto L_0x0037
        L_0x0036:
            r5 = r3
        L_0x0037:
            if (r2 == 0) goto L_0x0040
            java.lang.String r6 = "screenName"
            java.lang.String r6 = r2.getString(r6)
            goto L_0x0041
        L_0x0040:
            r6 = r3
        L_0x0041:
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8 = 1
            if (r7 == 0) goto L_0x0050
            int r7 = r7.length()
            if (r7 != 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = 1
        L_0x0051:
            if (r7 == 0) goto L_0x0055
            java.lang.String r6 = "bankH5"
        L_0x0055:
            if (r2 == 0) goto L_0x005e
            java.lang.String r7 = "method"
            java.lang.String r7 = r2.getString(r7)
            goto L_0x005f
        L_0x005e:
            r7 = r3
        L_0x005f:
            if (r7 != 0) goto L_0x0062
            goto L_0x0087
        L_0x0062:
            int r9 = r7.hashCode()
            r10 = 79599(0x136ef, float:1.11542E-40)
            if (r9 == r10) goto L_0x007c
            r10 = 2461856(0x2590a0, float:3.449795E-39)
            if (r9 == r10) goto L_0x0071
            goto L_0x0087
        L_0x0071:
            java.lang.String r9 = "POST"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0087
            com.paytm.network.a$a r7 = com.paytm.network.a.C0715a.POST
            goto L_0x0089
        L_0x007c:
            java.lang.String r9 = "PUT"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0087
            com.paytm.network.a$a r7 = com.paytm.network.a.C0715a.PUT
            goto L_0x0089
        L_0x0087:
            com.paytm.network.a$a r7 = com.paytm.network.a.C0715a.GET
        L_0x0089:
            if (r2 == 0) goto L_0x0092
            java.lang.String r9 = "header"
            org.json.JSONObject r2 = r2.getJSONObject(r9)
            goto L_0x0093
        L_0x0092:
            r2 = r3
        L_0x0093:
            if (r2 == 0) goto L_0x009a
            java.util.Iterator r9 = r2.keys()
            goto L_0x009b
        L_0x009a:
            r9 = r3
        L_0x009b:
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.Map r10 = (java.util.Map) r10
            if (r9 == 0) goto L_0x00c1
        L_0x00a4:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00c1
            java.lang.Object r11 = r9.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "key"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            if (r2 == 0) goto L_0x00bc
            java.lang.String r12 = r2.getString(r11)
            goto L_0x00bd
        L_0x00bc:
            r12 = r3
        L_0x00bd:
            r10.put(r11, r12)
            goto L_0x00a4
        L_0x00c1:
            java.lang.String r2 = com.paytm.utility.b.e()
            java.lang.String r3 = com.paytm.utility.b.f()
            net.one97.paytm.upgradeKyc.helper.e$a r9 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ Exception -> 0x00f2 }
            net.one97.paytm.upgradeKyc.helper.f r9 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r9 = r9.c()     // Catch:{ Exception -> 0x00f2 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f2 }
            r11.<init>()     // Catch:{ Exception -> 0x00f2 }
            r11.append(r2)     // Catch:{ Exception -> 0x00f2 }
            r12 = 58
            r11.append(r12)     // Catch:{ Exception -> 0x00f2 }
            r11.append(r3)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r9 = net.one97.paytm.common.utility.f.a(r9, r11)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r11 = "x-keyiv"
            r10.put(r11, r9)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x0106
        L_0x00f2:
            r9 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r9 = r9.getMessage()
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            com.paytm.utility.q.b(r9)
        L_0x0106:
            java.lang.String r5 = net.one97.paytm.common.utility.f.a(r3, r2, r5)     // Catch:{ Exception -> 0x010b }
            goto L_0x011f
        L_0x010b:
            r9 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r9 = r9.getMessage()
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            com.paytm.utility.q.b(r9)
        L_0x011f:
            net.one97.paytm.kych5.bridge.CJREncryptedModel r9 = new net.one97.paytm.kych5.bridge.CJREncryptedModel
            r9.<init>()
            r9.setIv(r3)
            r9.setKey(r2)
            com.paytm.network.b r2 = new com.paytm.network.b
            r2.<init>()
            android.content.Context r0 = (android.content.Context) r0
            com.paytm.network.b r2 = r2.a((android.content.Context) r0)
            com.paytm.network.b r2 = r2.a((com.paytm.network.a.C0715a) r7)
            com.paytm.network.b r2 = r2.a((java.util.Map<java.lang.String, java.lang.String>) r10)
            com.paytm.network.model.IJRPaytmDataModel r9 = (com.paytm.network.model.IJRPaytmDataModel) r9
            com.paytm.network.b r2 = r2.a((com.paytm.network.model.IJRPaytmDataModel) r9)
            com.paytm.network.b r2 = r2.b((java.lang.String) r5)
            com.paytm.network.b r2 = r2.a((java.lang.String) r4)
            com.paytm.network.b r2 = r2.a((boolean) r1)
            com.paytm.network.b r2 = r2.c(r6)
            com.paytm.network.a$b r3 = com.paytm.network.a.b.USER_FACING
            com.paytm.network.b r2 = r2.a((com.paytm.network.a.b) r3)
            com.paytm.network.a$c r3 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.b r2 = r2.a((com.paytm.network.a.c) r3)
            net.one97.paytm.kych5.bridge.b$a r3 = new net.one97.paytm.kych5.bridge.b$a
            r3.<init>(r13, r14, r15)
            com.paytm.network.listener.b r3 = (com.paytm.network.listener.b) r3
            com.paytm.network.b r14 = r2.a((com.paytm.network.listener.b) r3)
            com.paytm.network.a r14 = r14.l()
            boolean r15 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r15 == 0) goto L_0x0178
            r14.a()
            return r8
        L_0x0178:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.kych5.bridge.b.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f51051a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f51052b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f51053c;

        a(b bVar, H5Event h5Event, net.one97.paytm.phoenix.api.b bVar2) {
            this.f51051a = bVar;
            this.f51052b = h5Event;
            this.f51053c = bVar2;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof CJREncryptedModel) {
                net.one97.paytm.phoenix.core.a.a(this.f51051a, this.f51052b, ((CJREncryptedModel) iJRPaytmDataModel).getRawResponse(), false, 4);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            net.one97.paytm.phoenix.api.b bVar = this.f51053c;
            if (bVar != null) {
                H5Event h5Event = this.f51052b;
                int statusCode = networkCustomError.getStatusCode();
                String alertMessage = networkCustomError.getAlertMessage();
                k.a((Object) alertMessage, "networkCustomError.alertMessage");
                bVar.a(h5Event, statusCode, alertMessage);
            }
        }
    }
}
