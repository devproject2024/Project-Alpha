package net.one97.paytm.passbook.transactionDetail.d;

import android.app.Application;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;

public final class b extends a implements g, i.a<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f59151a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59152b;

    /* renamed from: c  reason: collision with root package name */
    public int f59153c;

    /* renamed from: d  reason: collision with root package name */
    public y<Boolean> f59154d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<e> f59155e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<IJRDataModel> f59156f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<NetworkCustomError> f59157g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    private String f59158h;

    /* renamed from: i  reason: collision with root package name */
    private String f59159i;
    private final int j = 100;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final /* synthetic */ void onResponse(Object obj) {
        a();
        this.f59156f.postValue((IJRDataModel) obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cc, code lost:
        if (r2.equals("47") != false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010c, code lost:
        if (r2.equals("1") != false) goto L_0x010e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.beans.CJRTransaction r13) {
        /*
            r12 = this;
            java.lang.String r0 = "transaction"
            kotlin.g.b.k.c(r13, r0)
            boolean r0 = r12.f59152b
            if (r0 != 0) goto L_0x0173
            boolean r0 = r12.f59151a
            if (r0 == 0) goto L_0x000f
            goto L_0x0173
        L_0x000f:
            java.lang.String r0 = r13.getPayeeId()
            r12.f59159i = r0
            java.lang.String r0 = r13.getPayerId()
            r12.f59158h = r0
            java.lang.String r0 = r13.getTxnType()
            java.lang.String r1 = "transaction.txnType"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.passbook.mapping.e r0 = net.one97.paytm.passbook.mapping.e.a()
            java.lang.String r1 = "GTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = net.one97.paytm.passbook.mapping.e.g()
            android.app.Application r1 = r12.getApplication()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r3 = com.paytm.utility.b.s(r1, r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r7 = r0
            java.util.Map r7 = (java.util.Map) r7
            android.app.Application r0 = r12.getApplication()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = net.one97.paytm.passbook.mapping.b.a(r0)
            java.lang.String r1 = "CJRServerUtility.getSSOToken(getApplication())"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = "ssotoken"
            r7.put(r1, r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "startLimit"
            int r4 = r12.f59153c     // Catch:{ JSONException -> 0x0139 }
            r1.put(r2, r4)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r2 = "lastLimit"
            int r4 = r12.f59153c     // Catch:{ JSONException -> 0x0139 }
            int r5 = r12.j     // Catch:{ JSONException -> 0x0139 }
            int r4 = r4 + r5
            r1.put(r2, r4)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r2 = r13.getType()     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r4 = "txnType"
            if (r2 != 0) goto L_0x007c
            goto L_0x012c
        L_0x007c:
            int r5 = r2.hashCode()     // Catch:{ JSONException -> 0x0139 }
            r6 = 49
            if (r5 == r6) goto L_0x0106
            r6 = 50
            if (r5 == r6) goto L_0x00fd
            r6 = 53
            if (r5 == r6) goto L_0x00f4
            r6 = 1667(0x683, float:2.336E-42)
            if (r5 == r6) goto L_0x00c6
            r6 = 1731(0x6c3, float:2.426E-42)
            if (r5 == r6) goto L_0x00bd
            switch(r5) {
                case 1570: goto L_0x00b4;
                case 1571: goto L_0x00ab;
                case 1572: goto L_0x00a2;
                case 1573: goto L_0x0099;
                default: goto L_0x0097;
            }     // Catch:{ JSONException -> 0x0139 }
        L_0x0097:
            goto L_0x012c
        L_0x0099:
            java.lang.String r5 = "16"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x012c
            goto L_0x00ce
        L_0x00a2:
            java.lang.String r5 = "15"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x012c
            goto L_0x00ce
        L_0x00ab:
            java.lang.String r5 = "14"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x012c
            goto L_0x00ce
        L_0x00b4:
            java.lang.String r5 = "13"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x012c
            goto L_0x00ce
        L_0x00bd:
            java.lang.String r5 = "69"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x012c
            goto L_0x010e
        L_0x00c6:
            java.lang.String r5 = "47"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x012c
        L_0x00ce:
            org.json.JSONArray r13 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0139 }
            r13.<init>()     // Catch:{ JSONException -> 0x0139 }
            r2 = 13
            org.json.JSONArray r2 = r13.put(r2)     // Catch:{ JSONException -> 0x0139 }
            r5 = 14
            org.json.JSONArray r2 = r2.put(r5)     // Catch:{ JSONException -> 0x0139 }
            r5 = 15
            org.json.JSONArray r2 = r2.put(r5)     // Catch:{ JSONException -> 0x0139 }
            r5 = 16
            org.json.JSONArray r2 = r2.put(r5)     // Catch:{ JSONException -> 0x0139 }
            r5 = 47
            r2.put(r5)     // Catch:{ JSONException -> 0x0139 }
            r1.put(r4, r13)     // Catch:{ JSONException -> 0x0139 }
            goto L_0x0133
        L_0x00f4:
            java.lang.String r5 = "5"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x012c
            goto L_0x010e
        L_0x00fd:
            java.lang.String r5 = "2"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x012c
            goto L_0x010e
        L_0x0106:
            java.lang.String r5 = "1"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x012c
        L_0x010e:
            java.lang.String r13 = r12.f59159i     // Catch:{ JSONException -> 0x0139 }
            boolean r13 = com.paytm.utility.v.a((java.lang.String) r13)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r2 = "accompanimentId"
            if (r13 != 0) goto L_0x011e
            java.lang.String r13 = r12.f59159i     // Catch:{ JSONException -> 0x0139 }
            r1.put(r2, r13)     // Catch:{ JSONException -> 0x0139 }
            goto L_0x0133
        L_0x011e:
            java.lang.String r13 = r12.f59158h     // Catch:{ JSONException -> 0x0139 }
            boolean r13 = com.paytm.utility.v.a((java.lang.String) r13)     // Catch:{ JSONException -> 0x0139 }
            if (r13 != 0) goto L_0x0133
            java.lang.String r13 = r12.f59158h     // Catch:{ JSONException -> 0x0139 }
            r1.put(r2, r13)     // Catch:{ JSONException -> 0x0139 }
            goto L_0x0133
        L_0x012c:
            java.lang.String r13 = r13.getType()     // Catch:{ JSONException -> 0x0139 }
            r1.put(r4, r13)     // Catch:{ JSONException -> 0x0139 }
        L_0x0133:
            java.lang.String r13 = "request"
            r0.put(r13, r1)     // Catch:{ JSONException -> 0x0139 }
            goto L_0x013a
        L_0x0139:
        L_0x013a:
            net.one97.paytm.passbook.mapping.a.b r13 = new net.one97.paytm.passbook.mapping.a.b
            r4 = r12
            net.one97.paytm.passbook.mapping.a.i$a r4 = (net.one97.paytm.passbook.mapping.a.i.a) r4
            r5 = r12
            net.one97.paytm.passbook.mapping.a.g r5 = (net.one97.paytm.passbook.mapping.a.g) r5
            net.one97.paytm.passbook.beans.CJRLedger r1 = new net.one97.paytm.passbook.beans.CJRLedger
            r1.<init>()
            r6 = r1
            net.one97.paytm.passbook.mapping.IJRDataModel r6 = (net.one97.paytm.passbook.mapping.IJRDataModel) r6
            java.lang.String r8 = r0.toString()
            com.paytm.network.a$c r9 = com.paytm.network.a.c.PASSBOOK
            com.paytm.network.a$b r10 = com.paytm.network.a.b.USER_FACING
            java.lang.Class<net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity> r0 = net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity.class
            java.lang.String r11 = r0.getSimpleName()
            r2 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            android.app.Application r0 = r12.getApplication()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x016e
            net.one97.paytm.passbook.mapping.a.e r13 = (net.one97.paytm.passbook.mapping.a.e) r13
            r12.a((net.one97.paytm.passbook.mapping.a.e) r13)
            return
        L_0x016e:
            androidx.lifecycle.y<net.one97.paytm.passbook.mapping.a.e> r0 = r12.f59155e
            r0.postValue(r13)
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.d.b.a(net.one97.paytm.passbook.beans.CJRTransaction):void");
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a();
        if (networkCustomError != null) {
            this.f59157g.postValue(networkCustomError);
        }
    }

    private void a(e eVar) {
        b();
        getApplication();
        c.a();
        c.b(eVar);
    }

    private final void a() {
        this.f59154d.postValue(Boolean.FALSE);
    }

    private final void b() {
        this.f59154d.postValue(Boolean.TRUE);
    }
}
