package net.one97.paytm.recharge.automatic.e;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.network.b;
import kotlin.g.b.k;
import org.json.JSONArray;
import org.json.JSONException;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private b f60271a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f60272b;

    /* renamed from: c  reason: collision with root package name */
    private final String f60273c = "staging-util.paytm.com";

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0138 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.network.b a(android.content.Context r11, java.lang.String r12, net.one97.paytm.recharge.widgets.a.d r13, com.paytm.network.model.IJRPaytmDataModel r14, java.util.Map<java.lang.String, java.lang.String> r15) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r1 = "url"
            kotlin.g.b.k.c(r12, r1)
            java.lang.String r2 = "listener"
            kotlin.g.b.k.c(r13, r2)
            java.lang.String r2 = "model"
            kotlin.g.b.k.c(r14, r2)
            com.paytm.network.b r2 = new com.paytm.network.b
            r2.<init>()
            com.paytm.network.b r2 = r2.a((android.content.Context) r11)
            kotlin.g.b.k.c(r12, r1)
            kotlin.g.b.k.c(r11, r0)
            org.json.JSONArray r11 = a(r11)
            java.lang.String r0 = "staging"
            java.lang.String r1 = "release"
            r3 = 1
            boolean r4 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r3)
            r5 = 0
            if (r4 == 0) goto L_0x00ea
            r4 = r12
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r6 = "catalog.paytm.com"
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r7, (boolean) r5)
            java.lang.String r8 = "catalog-staging.paytm.com"
            if (r7 == 0) goto L_0x0049
            java.lang.String r12 = kotlin.m.p.b(r12, r6, r8, r3)
            goto L_0x0139
        L_0x0049:
            java.lang.String r6 = "digitalcatalog.paytm.com"
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r7, (boolean) r5)
            if (r7 == 0) goto L_0x005c
            java.lang.String r11 = "digitalcatalog-staging.paytm.com"
            java.lang.String r12 = kotlin.m.p.a(r12, r6, r11, r5)
            goto L_0x0139
        L_0x005c:
            boolean r6 = r10.f60272b
            if (r6 == 0) goto L_0x00ea
            java.lang.String r6 = "cart-staging.paytm.com"
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r7, (boolean) r5)
            if (r7 == 0) goto L_0x0083
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r10.f60273c
            r4.append(r7)
            java.lang.String r7 = "/cart-staging"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = kotlin.m.p.b(r12, r6, r4, r3)
            goto L_0x00eb
        L_0x0083:
            java.lang.String r6 = "oms-staging.paytm.com"
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r7, false)
            if (r7 == 0) goto L_0x00a6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r10.f60273c
            r4.append(r7)
            java.lang.String r7 = "/oms-staging"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = kotlin.m.p.b(r12, r6, r4, r3)
            goto L_0x00eb
        L_0x00a6:
            r6 = r8
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r6, false)
            if (r6 == 0) goto L_0x00c7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = r10.f60273c
            r4.append(r6)
            java.lang.String r6 = "/catalog-staging"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = kotlin.m.p.b(r12, r8, r4, r3)
            goto L_0x00eb
        L_0x00c7:
            java.lang.String r6 = "digitalproxy-staging.paytm.com"
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.CharSequence) r7, false)
            if (r4 == 0) goto L_0x00ea
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r10.f60273c
            r4.append(r7)
            java.lang.String r7 = "/digitalproxy-staging"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = kotlin.m.p.b(r12, r6, r4, r3)
            goto L_0x00eb
        L_0x00ea:
            r4 = r12
        L_0x00eb:
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r3)
            if (r0 == 0) goto L_0x0139
            int r0 = r11.length()
            if (r0 <= 0) goto L_0x0139
            int r12 = r11.length()
            r0 = 0
        L_0x00fc:
            if (r0 >= r12) goto L_0x0138
            org.json.JSONObject r1 = r11.getJSONObject(r0)
            java.lang.String r6 = "ruleArray.getJSONObject(i)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r7 = "search_pattern"
            java.lang.String r8 = r1.optString(r7)
            java.lang.String r9 = "jsonObject.optString(\"search_pattern\")"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r6 = kotlin.m.p.a((java.lang.CharSequence) r6, (java.lang.CharSequence) r8, (boolean) r3)
            if (r6 == 0) goto L_0x0135
            java.lang.String r11 = r1.optString(r7)
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r9)
            java.lang.String r12 = "replacement_pattern"
            java.lang.String r12 = r1.optString(r12)
            java.lang.String r0 = "jsonObject.optString(\"replacement_pattern\")"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            java.lang.String r11 = kotlin.m.p.a(r4, r11, r12, r5)
            r12 = r11
            goto L_0x0139
        L_0x0135:
            int r0 = r0 + 1
            goto L_0x00fc
        L_0x0138:
            r12 = r4
        L_0x0139:
            com.paytm.network.b r11 = r2.a((java.lang.String) r12)
            com.paytm.network.b r11 = r11.a((java.util.Map<java.lang.String, java.lang.String>) r15)
            com.paytm.network.b r11 = r11.a((com.paytm.network.model.IJRPaytmDataModel) r14)
            com.paytm.network.b r11 = r11.a((boolean) r5)
            com.paytm.network.listener.b r13 = (com.paytm.network.listener.b) r13
            com.paytm.network.b r11 = r11.a((com.paytm.network.listener.b) r13)
            java.lang.String r12 = "CJRCommonNetworkCallBuil…mmonApiListener(listener)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            r10.f60271a = r11
            com.paytm.network.b r11 = r10.f60271a
            if (r11 != 0) goto L_0x015f
            java.lang.String r12 = "networkCall"
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x015f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.automatic.e.a.a(android.content.Context, java.lang.String, net.one97.paytm.recharge.widgets.a.d, com.paytm.network.model.IJRPaytmDataModel, java.util.Map):com.paytm.network.b");
    }

    private static JSONArray a(Context context) {
        k.c(context, "context");
        a.C0708a aVar = com.paytm.b.a.a.f42641a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        String b2 = a.C0708a.a(applicationContext, a.c.RECHARGES).b("key_added_rule", "", true);
        if (k.a((Object) b2, (Object) "")) {
            return new JSONArray();
        }
        try {
            return new JSONArray(b2);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }
}
