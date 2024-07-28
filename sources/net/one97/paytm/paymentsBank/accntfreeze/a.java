package net.one97.paytm.paymentsBank.accntfreeze;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.paymentsBank.accntfreeze.b;

public final class a implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: c  reason: collision with root package name */
    private static a f17336c;

    /* renamed from: a  reason: collision with root package name */
    public CustProductList f17337a;

    /* renamed from: b  reason: collision with root package name */
    public int f17338b = 0;

    /* renamed from: d  reason: collision with root package name */
    private List<Integer> f17339d;

    /* renamed from: e  reason: collision with root package name */
    private Context f17340e;

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel instanceof CustProductList) {
            this.f17337a = (CustProductList) iJRPaytmDataModel;
            a((AppCompatActivity) this.f17340e);
        }
    }

    private a() {
    }

    public static a a() {
        if (f17336c == null) {
            f17336c = new a();
        }
        return f17336c;
    }

    public final a a(AppCompatActivity appCompatActivity, int i2, int... iArr) {
        this.f17339d = new ArrayList();
        if (!(i2 == 0 || appCompatActivity.findViewById(i2) == null)) {
            this.f17338b = i2;
        }
        for (int i3 : iArr) {
            if (!(i3 == 0 || appCompatActivity.findViewById(i3) == null)) {
                this.f17339d.add(Integer.valueOf(i3));
            }
        }
        CustProductList custProductList = this.f17337a;
        if (custProductList != null) {
            this.f17337a = custProductList;
        }
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0129 A[Catch:{ Exception -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.appcompat.app.AppCompatActivity r18) {
        /*
            r17 = this;
            r8 = r17
            r9 = r18
            java.lang.String r0 = "title"
            net.one97.paytm.bankCommon.model.CustProductList r1 = r8.f17337a     // Catch:{ Exception -> 0x012c }
            if (r1 != 0) goto L_0x0039
            r8.f17340e = r9     // Catch:{ Exception -> 0x012c }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x012c }
            r6.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = "screen_name"
            java.lang.Class r1 = r17.getClass()     // Catch:{ Exception -> 0x012c }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Exception -> 0x012c }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x012c }
            com.paytm.network.a$c r4 = com.paytm.network.a.c.PAYMENTSBANK     // Catch:{ Exception -> 0x012c }
            com.paytm.network.a$b r5 = com.paytm.network.a.b.SILENT     // Catch:{ Exception -> 0x012c }
            r1 = r18
            r2 = r17
            r3 = r17
            net.one97.paytm.bankCommon.g.f r0 = net.one97.paytm.paymentsBank.b.a.a((android.content.Context) r1, (net.one97.paytm.bankCommon.g.g.b<com.paytm.network.model.IJRPaytmDataModel>) r2, (net.one97.paytm.bankCommon.g.g.a) r3, (com.paytm.network.a.c) r4, (com.paytm.network.a.b) r5, (java.util.HashMap<java.lang.String, java.lang.String>) r6)     // Catch:{ Exception -> 0x012c }
            r18.getApplicationContext()     // Catch:{ Exception -> 0x012c }
            net.one97.paytm.bankCommon.g.c r1 = new net.one97.paytm.bankCommon.g.c     // Catch:{ Exception -> 0x012c }
            r1.<init>()     // Catch:{ Exception -> 0x012c }
            net.one97.paytm.bankCommon.g.c.a(r0)     // Catch:{ Exception -> 0x012c }
            return
        L_0x0039:
            net.one97.paytm.paymentsBank.utils.a r1 = net.one97.paytm.paymentsBank.utils.a.f19494a     // Catch:{ Exception -> 0x012c }
            net.one97.paytm.bankCommon.model.CustProductList r1 = r8.f17337a     // Catch:{ Exception -> 0x012c }
            boolean r1 = net.one97.paytm.paymentsBank.utils.a.d(r1)     // Catch:{ Exception -> 0x012c }
            r10 = 0
            if (r1 == 0) goto L_0x0125
            net.one97.paytm.bankCommon.model.CustProductList r1 = r8.f17337a     // Catch:{ Exception -> 0x012c }
            net.one97.paytm.bankCommon.model.CustProductList$Isa r1 = r1.getIsa()     // Catch:{ Exception -> 0x012c }
            java.util.List<net.one97.paytm.bankCommon.model.CustProductList$FreezeDescriptionList> r1 = r1.freezeDescriptionList     // Catch:{ Exception -> 0x012c }
            if (r1 == 0) goto L_0x0125
            net.one97.paytm.bankCommon.model.CustProductList r1 = r8.f17337a     // Catch:{ Exception -> 0x012c }
            net.one97.paytm.bankCommon.model.CustProductList$Isa r1 = r1.getIsa()     // Catch:{ Exception -> 0x012c }
            java.util.List<net.one97.paytm.bankCommon.model.CustProductList$FreezeDescriptionList> r1 = r1.freezeDescriptionList     // Catch:{ Exception -> 0x012c }
            java.lang.Object r1 = r1.get(r10)     // Catch:{ Exception -> 0x012c }
            net.one97.paytm.bankCommon.model.CustProductList$FreezeDescriptionList r1 = (net.one97.paytm.bankCommon.model.CustProductList.FreezeDescriptionList) r1     // Catch:{ Exception -> 0x012c }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x011d }
            java.lang.String r1 = r1.getActionDescription()     // Catch:{ JSONException -> 0x011d }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r1 = "description"
            java.lang.String r11 = r2.getString(r1)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r1 = "reason"
            java.lang.String r12 = r2.getString(r1)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r1 = "action_text"
            java.lang.String r13 = r2.getString(r1)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r1 = "deeplink"
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r3 = "weblink"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x011d }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x011a }
            if (r3 == 0) goto L_0x008c
            r15 = r2
            goto L_0x008d
        L_0x008c:
            r15 = r1
        L_0x008d:
            int r1 = r8.f17338b     // Catch:{ JSONException -> 0x011a }
            if (r1 == 0) goto L_0x00d7
            net.one97.paytm.paymentsBank.accntfreeze.c$a r1 = net.one97.paytm.paymentsBank.accntfreeze.c.f17353a     // Catch:{ JSONException -> 0x011a }
            kotlin.g.b.k.c(r11, r0)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r1 = "subTitle"
            kotlin.g.b.k.c(r12, r1)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r1 = "action"
            kotlin.g.b.k.c(r15, r1)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r1 = "actionText"
            kotlin.g.b.k.c(r13, r1)     // Catch:{ JSONException -> 0x011a }
            net.one97.paytm.paymentsBank.accntfreeze.c r1 = new net.one97.paytm.paymentsBank.accntfreeze.c     // Catch:{ JSONException -> 0x011a }
            r1.<init>()     // Catch:{ JSONException -> 0x011a }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ JSONException -> 0x011a }
            r2.<init>()     // Catch:{ JSONException -> 0x011a }
            r2.putString(r0, r11)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r0 = "arg_subtitle"
            r2.putString(r0, r12)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r0 = "arg_action_txt"
            r2.putString(r0, r13)     // Catch:{ JSONException -> 0x011a }
            java.lang.String r0 = "arg_action"
            r2.putString(r0, r15)     // Catch:{ JSONException -> 0x011a }
            r1.setArguments(r2)     // Catch:{ JSONException -> 0x011a }
            androidx.fragment.app.j r0 = r18.getSupportFragmentManager()     // Catch:{ JSONException -> 0x011a }
            androidx.fragment.app.q r0 = r0.a()     // Catch:{ JSONException -> 0x011a }
            int r2 = r8.f17338b     // Catch:{ JSONException -> 0x011a }
            r3 = 0
            androidx.fragment.app.q r0 = r0.b(r2, r1, r3)     // Catch:{ JSONException -> 0x011a }
            r0.c()     // Catch:{ JSONException -> 0x011a }
        L_0x00d7:
            java.util.List<java.lang.Integer> r0 = r8.f17339d     // Catch:{ JSONException -> 0x011a }
            if (r0 == 0) goto L_0x0117
            java.util.List<java.lang.Integer> r0 = r8.f17339d     // Catch:{ JSONException -> 0x011a }
            int r0 = r0.size()     // Catch:{ JSONException -> 0x011a }
            if (r0 <= 0) goto L_0x0117
            java.util.List<java.lang.Integer> r0 = r8.f17339d     // Catch:{ JSONException -> 0x011a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x011a }
        L_0x00e9:
            boolean r1 = r0.hasNext()     // Catch:{ JSONException -> 0x011a }
            if (r1 == 0) goto L_0x0117
            java.lang.Object r1 = r0.next()     // Catch:{ JSONException -> 0x011a }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ JSONException -> 0x011a }
            int r1 = r1.intValue()     // Catch:{ JSONException -> 0x011a }
            android.view.View r7 = r9.findViewById(r1)     // Catch:{ JSONException -> 0x011a }
            if (r7 == 0) goto L_0x0115
            r7.setVisibility(r10)     // Catch:{ JSONException -> 0x011a }
            net.one97.paytm.paymentsBank.accntfreeze.-$$Lambda$a$PQnn7YC_4xmVFex8SFQyuD5dfio r6 = new net.one97.paytm.paymentsBank.accntfreeze.-$$Lambda$a$PQnn7YC_4xmVFex8SFQyuD5dfio     // Catch:{ JSONException -> 0x011a }
            r1 = r6
            r2 = r17
            r3 = r18
            r4 = r11
            r5 = r12
            r10 = r6
            r6 = r15
            r14 = r7
            r7 = r13
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x011a }
            r14.setOnClickListener(r10)     // Catch:{ JSONException -> 0x011a }
        L_0x0115:
            r10 = 0
            goto L_0x00e9
        L_0x0117:
            r16 = 1
            goto L_0x0127
        L_0x011a:
            r0 = move-exception
            r10 = 1
            goto L_0x011f
        L_0x011d:
            r0 = move-exception
            r10 = 0
        L_0x011f:
            r0.printStackTrace()     // Catch:{ Exception -> 0x012c }
            r16 = r10
            goto L_0x0127
        L_0x0125:
            r16 = 0
        L_0x0127:
            if (r16 != 0) goto L_0x012c
            r17.b(r18)     // Catch:{ Exception -> 0x012c }
        L_0x012c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.accntfreeze.a.a(androidx.appcompat.app.AppCompatActivity):void");
    }

    private void b(AppCompatActivity appCompatActivity) {
        int i2 = this.f17338b;
        if (i2 != 0) {
            appCompatActivity.findViewById(i2).setVisibility(8);
        }
        List<Integer> list = this.f17339d;
        if (list != null && list.size() > 0) {
            for (Integer intValue : this.f17339d) {
                View findViewById = appCompatActivity.findViewById(intValue.intValue());
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        }
    }

    public final void b() {
        this.f17337a = null;
        this.f17338b = 0;
        this.f17339d = new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4, View view) {
        b.a aVar = b.f17341a;
        k.c(str, "title");
        k.c(str2, "subTitle");
        k.c(str3, "action");
        k.c(str4, "actionText");
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("arg_subtitle", str2);
        bundle.putString("arg_action_txt", str4);
        bundle.putString("arg_action", str3);
        bVar.setArguments(bundle);
        bVar.show(appCompatActivity.getSupportFragmentManager(), "bottom");
    }
}
