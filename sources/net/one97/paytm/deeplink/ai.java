package net.one97.paytm.deeplink;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.j;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;

public final class ai {

    /* renamed from: a  reason: collision with root package name */
    public static final ai f50315a = new ai();

    /* renamed from: b  reason: collision with root package name */
    private static final String f50316b = f50316b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f50317c = f50317c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f50318d = f50318d;

    private ai() {
    }

    public static String a() {
        return f50316b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:282:0x0680  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0685  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0688  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0690  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0695  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x069d  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x06a2  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x06b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r39, net.one97.paytm.deeplink.DeepLinkData r40) {
        /*
            r6 = r39
            r0 = r40
            java.lang.String r1 = "context"
            kotlin.g.b.k.c(r6, r1)
            java.lang.String r1 = "deepLinkData"
            kotlin.g.b.k.c(r0, r1)
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            boolean r2 = net.one97.paytm.recharge.common.utils.az.c(r39)
            java.lang.String r3 = ""
            r4 = 1
            if (r2 == 0) goto L_0x0061
            java.lang.String r2 = r0.f50284b
            java.lang.String r5 = "automatic"
            boolean r2 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r4)
            if (r2 == 0) goto L_0x0061
            android.net.Uri r0 = r0.f50289g
            if (r0 == 0) goto L_0x005d
            java.util.Set r1 = r0.getQueryParameterNames()
            if (r1 == 0) goto L_0x005d
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x005d
            java.lang.String r2 = "recharge_number"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = "recharge_number"
            java.lang.String r1 = r0.getQueryParameter(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x005d
            java.lang.String r1 = "recharge_number"
            java.lang.String r0 = r0.getQueryParameter(r1)
            if (r0 != 0) goto L_0x0059
            r0 = r3
        L_0x0059:
            net.one97.paytm.recharge.common.utils.az.f(r6, r0)
            return
        L_0x005d:
            net.one97.paytm.recharge.common.utils.az.f(r6, r3)
            return
        L_0x0061:
            android.content.Context r2 = r39.getApplicationContext()
            boolean r2 = com.paytm.utility.d.c(r2)
            r5 = 0
            r7 = 0
            if (r2 == 0) goto L_0x0133
            net.one97.paytm.common.b.a r2 = net.one97.paytm.common.b.d.b()
            java.lang.String r8 = "frequentOrdersAndroid"
            java.lang.String r2 = r2.a((java.lang.String) r8)
            if (r2 != 0) goto L_0x007b
            goto L_0x0133
        L_0x007b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            if (r2 != 0) goto L_0x0082
            kotlin.g.b.k.a()
        L_0x0082:
            r8.<init>(r2)
            java.lang.String r2 = com.paytm.utility.c.a((android.content.Context) r6, (boolean) r5)
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            net.one97.paytm.recharge.widgets.c.d r8 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r15 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r7, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r7)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = r15.getFlowName()
            if (r8 != 0) goto L_0x00d0
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r16 = r8
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 1048575(0xfffff, float:1.469367E-39)
            r38 = 0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
        L_0x00d0:
            r15.setFlowName(r8)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = r15.getFlowName()
            if (r8 == 0) goto L_0x00de
            java.lang.String r9 = "frequent_api"
            r8.setTag(r9)
        L_0x00de:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = r15.getFlowName()
            if (r8 == 0) goto L_0x00ed
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r9 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r9 = r9.name()
            r8.setErrorType(r9)
        L_0x00ed:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r8 = r15.getFlowName()
            if (r8 == 0) goto L_0x00fc
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r9 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.FETCH_RECENTS
            java.lang.String r9 = r9.name()
            r8.setActionType(r9)
        L_0x00fc:
            boolean r8 = com.paytm.utility.a.m(r39)
            if (r8 == 0) goto L_0x0133
            boolean r8 = android.webkit.URLUtil.isValidUrl(r2)
            if (r8 == 0) goto L_0x0133
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.b r8 = new net.one97.paytm.recharge.common.f.b
            java.lang.String r11 = r2.toString()
            net.one97.paytm.deeplink.ai$a r2 = new net.one97.paytm.deeplink.ai$a
            r2.<init>(r6)
            r12 = r2
            net.one97.paytm.recharge.common.e.ai r12 = (net.one97.paytm.recharge.common.e.ai) r12
            net.one97.paytm.common.entity.recharge.CJRFrequentOrderList r2 = new net.one97.paytm.common.entity.recharge.CJRFrequentOrderList
            r2.<init>()
            r13 = r2
            com.paytm.network.model.IJRPaytmDataModel r13 = (com.paytm.network.model.IJRPaytmDataModel) r13
            java.util.HashMap r2 = com.paytm.utility.b.ah(r39)
            r14 = r2
            java.util.Map r14 = (java.util.Map) r14
            java.lang.String r10 = "frequent_api"
            r9 = r8
            r9.<init>(r10, r11, r12, r13, r14, r15)
            net.one97.paytm.recharge.common.f.a r8 = (net.one97.paytm.recharge.common.f.a) r8
            net.one97.paytm.recharge.common.f.d.b(r8)
        L_0x0133:
            net.one97.paytm.recharge.c$a r2 = net.one97.paytm.recharge.c.f60405a     // Catch:{ Exception -> 0x0184 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0184 }
            java.lang.String r2 = "migrateAllDonationToH5"
            boolean r2 = net.one97.paytm.j.c.a((java.lang.String) r2, (boolean) r5)     // Catch:{ Exception -> 0x0184 }
            if (r2 == 0) goto L_0x0184
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x0184 }
            java.util.HashSet r2 = net.one97.paytm.recharge.di.helper.c.m()     // Catch:{ Exception -> 0x0184 }
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x0184 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0184 }
            r8 = 0
        L_0x014d:
            boolean r9 = r2.hasNext()     // Catch:{ Exception -> 0x0182 }
            if (r9 == 0) goto L_0x0185
            java.lang.Object r9 = r2.next()     // Catch:{ Exception -> 0x0182 }
            java.lang.Number r9 = (java.lang.Number) r9     // Catch:{ Exception -> 0x0182 }
            long r9 = r9.longValue()     // Catch:{ Exception -> 0x0182 }
            java.lang.String r11 = "utility"
            java.lang.String r12 = r0.f50284b     // Catch:{ Exception -> 0x0182 }
            boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r12, (boolean) r4)     // Catch:{ Exception -> 0x0182 }
            if (r11 == 0) goto L_0x014d
            android.net.Uri r11 = r0.f50289g     // Catch:{ Exception -> 0x0182 }
            if (r11 == 0) goto L_0x014d
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0182 }
            if (r11 == 0) goto L_0x014d
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x0182 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0182 }
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0182 }
            boolean r9 = kotlin.m.p.a((java.lang.CharSequence) r11, (java.lang.CharSequence) r9, false)     // Catch:{ Exception -> 0x0182 }
            if (r9 != r4) goto L_0x014d
            r8 = 1
            goto L_0x014d
        L_0x0182:
            goto L_0x0185
        L_0x0184:
            r8 = 0
        L_0x0185:
            java.lang.String r2 = r0.f50284b
            java.lang.String r9 = "utility_donation"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r9, (boolean) r5)
            java.lang.String r9 = "id"
            java.lang.String r10 = "param"
            java.lang.String r11 = "showTitleBar"
            java.lang.String r12 = "Android"
            java.lang.String r13 = "source"
            java.lang.String r14 = "defaultParams"
            java.lang.String r15 = "v1.0"
            java.lang.String r7 = "fixVersion"
            java.lang.String r4 = "environment"
            java.lang.String r5 = "release"
            if (r2 != 0) goto L_0x065a
            if (r8 == 0) goto L_0x01ab
            goto L_0x065a
        L_0x01ab:
            java.lang.String r2 = r0.f50284b
            java.lang.String r8 = "fastag-recharge"
            r19 = r1
            r1 = 0
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r1)
            java.lang.String r1 = "appUniqueId"
            if (r2 == 0) goto L_0x0272
            net.one97.paytm.recharge.g r2 = net.one97.paytm.recharge.g.f62773a
            net.one97.paytm.recharge.g.b(r39)
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            r8.putString(r4, r5)
            r8.putString(r7, r15)
            net.one97.paytm.recharge.c$a r2 = net.one97.paytm.recharge.c.f60405a
            java.lang.String r2 = net.one97.paytm.recharge.c.a.a(r39)
            r8.putString(r14, r2)
            r8.putString(r13, r12)
            r2 = 0
            r8.putBoolean(r11, r2)
            android.net.Uri r0 = r0.f50289g
            net.one97.paytm.recharge.d r2 = new net.one97.paytm.recharge.d
            r2.<init>()
            if (r0 == 0) goto L_0x01e8
            java.lang.String r7 = r0.toString()
            goto L_0x01e9
        L_0x01e8:
            r7 = 0
        L_0x01e9:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x01f7
            int r4 = r7.length()
            if (r4 != 0) goto L_0x01f4
            goto L_0x01f7
        L_0x01f4:
            r18 = 0
            goto L_0x01f9
        L_0x01f7:
            r18 = 1
        L_0x01f9:
            if (r18 != 0) goto L_0x0218
            java.lang.String r4 = java.lang.String.valueOf(r0)
            r2.setUrl(r4)
            if (r0 == 0) goto L_0x0209
            java.lang.String r7 = r0.getQueryParameter(r10)
            goto L_0x020a
        L_0x0209:
            r7 = 0
        L_0x020a:
            r2.setParam(r7)
            if (r0 == 0) goto L_0x0214
            java.lang.String r7 = r0.getQueryParameter(r9)
            goto L_0x0215
        L_0x0214:
            r7 = 0
        L_0x0215:
            r2.setId(r7)
        L_0x0218:
            net.one97.paytm.deeplink.u r0 = net.one97.paytm.deeplink.u.a()
            net.one97.paytm.recharge.c$a r4 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r4 = "h5_fastag_AppUniqueId"
            java.lang.String r4 = net.one97.paytm.j.c.a((java.lang.String) r4, (java.lang.String) r3)
            r7 = r4
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0232
            java.lang.String r4 = "9a4dd0f1ace8d7abbb3b9fb41b7af84d38cdf30a"
        L_0x0232:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            net.one97.paytm.recharge.c$a r1 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "h5_fastag_url"
            java.lang.String r1 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r3)
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0258
            java.lang.String r1 = "staging"
            r3 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r3)
            if (r1 == 0) goto L_0x0256
            java.lang.String r1 = "https://staging.paytm.com/h5fasttag/v1/index.html"
            goto L_0x0258
        L_0x0256:
            java.lang.String r1 = "https://paytm.com/h5fasttag/v1/index.html"
        L_0x0258:
            r3 = r1
            java.lang.String r1 = "url"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            java.lang.String r5 = r1.a((java.lang.Object) r2)
            java.lang.String r1 = "Fastag"
            r2 = r4
            r4 = r8
            r6 = r39
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.lang.String) r5, (android.content.Context) r6)
            return
        L_0x0272:
            java.lang.String r2 = r0.f50284b
            java.lang.String r8 = "ottsubscription-recharge"
            r6 = 0
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r6)
            if (r2 == 0) goto L_0x0335
            net.one97.paytm.recharge.g r2 = net.one97.paytm.recharge.g.f62773a
            net.one97.paytm.recharge.g.b(r39)
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r6.putString(r4, r5)
            r6.putString(r7, r15)
            net.one97.paytm.recharge.c$a r2 = net.one97.paytm.recharge.c.f60405a
            java.lang.String r2 = net.one97.paytm.recharge.c.a.a(r39)
            r6.putString(r14, r2)
            r6.putString(r13, r12)
            r2 = 0
            r6.putBoolean(r11, r2)
            android.net.Uri r0 = r0.f50289g
            net.one97.paytm.recharge.d r2 = new net.one97.paytm.recharge.d
            r2.<init>()
            if (r0 == 0) goto L_0x02ab
            java.lang.String r7 = r0.toString()
            goto L_0x02ac
        L_0x02ab:
            r7 = 0
        L_0x02ac:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x02ba
            int r4 = r7.length()
            if (r4 != 0) goto L_0x02b7
            goto L_0x02ba
        L_0x02b7:
            r18 = 0
            goto L_0x02bc
        L_0x02ba:
            r18 = 1
        L_0x02bc:
            if (r18 != 0) goto L_0x02db
            java.lang.String r4 = java.lang.String.valueOf(r0)
            r2.setUrl(r4)
            if (r0 == 0) goto L_0x02cc
            java.lang.String r7 = r0.getQueryParameter(r10)
            goto L_0x02cd
        L_0x02cc:
            r7 = 0
        L_0x02cd:
            r2.setParam(r7)
            if (r0 == 0) goto L_0x02d7
            java.lang.String r7 = r0.getQueryParameter(r9)
            goto L_0x02d8
        L_0x02d7:
            r7 = 0
        L_0x02d8:
            r2.setId(r7)
        L_0x02db:
            net.one97.paytm.deeplink.u r0 = net.one97.paytm.deeplink.u.a()
            net.one97.paytm.recharge.c$a r4 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r4 = "h5_ott_subscription_AppUniqueId"
            java.lang.String r4 = net.one97.paytm.j.c.a((java.lang.String) r4, (java.lang.String) r3)
            r7 = r4
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x02f5
            java.lang.String r4 = "53677fc628566a71d23900a0b22eb577ac517036"
        L_0x02f5:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            net.one97.paytm.recharge.c$a r1 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "h5_ott_subscription_url"
            java.lang.String r1 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r3)
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x031b
            java.lang.String r1 = "staging"
            r3 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r3)
            if (r1 == 0) goto L_0x0319
            java.lang.String r1 = "https://staging.paytm.com/ott/v1/index.html?pageRedirectUrl=subscription-list"
            goto L_0x031b
        L_0x0319:
            java.lang.String r1 = "https://paytm.com/ott/v1/index.html?pageRedirectUrl=subscription-list"
        L_0x031b:
            r3 = r1
            java.lang.String r1 = "url"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            java.lang.String r5 = r1.a((java.lang.Object) r2)
            java.lang.String r1 = "OTTSubscription"
            r2 = r4
            r4 = r6
            r6 = r39
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.lang.String) r5, (android.content.Context) r6)
            return
        L_0x0335:
            java.lang.String r2 = r0.f50284b
            java.lang.String r6 = "mymonthlypayment"
            r8 = 0
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r6, (boolean) r8)
            if (r2 == 0) goto L_0x0405
            net.one97.paytm.recharge.g r2 = net.one97.paytm.recharge.g.f62773a
            net.one97.paytm.recharge.g.b(r39)
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r6.putString(r4, r5)
            r6.putString(r7, r15)
            net.one97.paytm.recharge.c$a r2 = net.one97.paytm.recharge.c.f60405a
            java.lang.String r2 = net.one97.paytm.recharge.c.a.a(r39)
            r6.putString(r14, r2)
            r6.putString(r13, r12)
            r2 = 0
            r6.putBoolean(r11, r2)
            android.net.Uri r0 = r0.f50289g
            net.one97.paytm.recharge.d r2 = new net.one97.paytm.recharge.d
            r2.<init>()
            if (r0 == 0) goto L_0x036e
            java.lang.String r7 = r0.toString()
            goto L_0x036f
        L_0x036e:
            r7 = 0
        L_0x036f:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x037c
            int r4 = r7.length()
            if (r4 != 0) goto L_0x037a
            goto L_0x037c
        L_0x037a:
            r4 = 0
            goto L_0x037d
        L_0x037c:
            r4 = 1
        L_0x037d:
            if (r4 != 0) goto L_0x039c
            java.lang.String r4 = java.lang.String.valueOf(r0)
            r2.setUrl(r4)
            if (r0 == 0) goto L_0x038d
            java.lang.String r7 = r0.getQueryParameter(r10)
            goto L_0x038e
        L_0x038d:
            r7 = 0
        L_0x038e:
            r2.setParam(r7)
            if (r0 == 0) goto L_0x0398
            java.lang.String r7 = r0.getQueryParameter(r9)
            goto L_0x0399
        L_0x0398:
            r7 = 0
        L_0x0399:
            r2.setId(r7)
        L_0x039c:
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r0 = f50318d
            r7 = 0
            r4[r7] = r0
            java.util.List r0 = kotlin.a.k.c(r4)
            net.one97.paytm.phoenix.PhoenixManager.addSubscribeBridges(r0)
            net.one97.paytm.deeplink.u r0 = net.one97.paytm.deeplink.u.a()
            net.one97.paytm.recharge.c$a r4 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r4 = "h5_my_monthly_payment_AppUniqueId"
            java.lang.String r4 = net.one97.paytm.j.c.a((java.lang.String) r4, (java.lang.String) r3)
            r7 = r4
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x03c5
            java.lang.String r4 = "e997d4b57b7da2c48b6a76193a87f3eb956044d0"
        L_0x03c5:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            net.one97.paytm.recharge.c$a r1 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "h5_my_monthly_payment_url"
            java.lang.String r1 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r3)
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x03eb
            java.lang.String r1 = "staging"
            r3 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r3)
            if (r1 == 0) goto L_0x03e9
            java.lang.String r1 = "https://staging.paytm.com/rentalservices/v1/index.html"
            goto L_0x03eb
        L_0x03e9:
            java.lang.String r1 = "https://paytm.com/rentalservices/v1/index.html"
        L_0x03eb:
            r3 = r1
            java.lang.String r1 = "url"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            java.lang.String r5 = r1.a((java.lang.Object) r2)
            java.lang.String r1 = "OTTSubscription"
            r2 = r4
            r4 = r6
            r6 = r39
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.lang.String) r5, (android.content.Context) r6)
            return
        L_0x0405:
            java.lang.String r2 = r0.f50284b
            java.lang.String r6 = "automatic-h5"
            r8 = 0
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r6, (boolean) r8)
            if (r2 == 0) goto L_0x04c8
            net.one97.paytm.recharge.g r2 = net.one97.paytm.recharge.g.f62773a
            net.one97.paytm.recharge.g.b(r39)
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r6.putString(r4, r5)
            r6.putString(r7, r15)
            net.one97.paytm.recharge.c$a r2 = net.one97.paytm.recharge.c.f60405a
            java.lang.String r2 = net.one97.paytm.recharge.c.a.a(r39)
            r6.putString(r14, r2)
            r6.putString(r13, r12)
            r2 = 0
            r6.putBoolean(r11, r2)
            android.net.Uri r0 = r0.f50289g
            net.one97.paytm.recharge.d r2 = new net.one97.paytm.recharge.d
            r2.<init>()
            if (r0 == 0) goto L_0x043e
            java.lang.String r7 = r0.toString()
            goto L_0x043f
        L_0x043e:
            r7 = 0
        L_0x043f:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x044d
            int r4 = r7.length()
            if (r4 != 0) goto L_0x044a
            goto L_0x044d
        L_0x044a:
            r18 = 0
            goto L_0x044f
        L_0x044d:
            r18 = 1
        L_0x044f:
            if (r18 != 0) goto L_0x046e
            java.lang.String r4 = java.lang.String.valueOf(r0)
            r2.setUrl(r4)
            if (r0 == 0) goto L_0x045f
            java.lang.String r7 = r0.getQueryParameter(r10)
            goto L_0x0460
        L_0x045f:
            r7 = 0
        L_0x0460:
            r2.setParam(r7)
            if (r0 == 0) goto L_0x046a
            java.lang.String r7 = r0.getQueryParameter(r9)
            goto L_0x046b
        L_0x046a:
            r7 = 0
        L_0x046b:
            r2.setId(r7)
        L_0x046e:
            net.one97.paytm.deeplink.u r0 = net.one97.paytm.deeplink.u.a()
            net.one97.paytm.recharge.c$a r4 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r4 = "h5_automatic_AppUniqueId"
            java.lang.String r4 = net.one97.paytm.j.c.a((java.lang.String) r4, (java.lang.String) r3)
            r7 = r4
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0488
            java.lang.String r4 = "01c52f85a351412fae839f7f3b63197a"
        L_0x0488:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            net.one97.paytm.recharge.c$a r1 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "h5_automatic_url"
            java.lang.String r1 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r3)
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x04ae
            java.lang.String r1 = "staging"
            r8 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r8)
            if (r1 == 0) goto L_0x04ac
            java.lang.String r1 = "https://staging.paytm.com/automatic-subscription/v1/index.html"
            goto L_0x04ae
        L_0x04ac:
            java.lang.String r1 = "https://paytm.com/automatic-subscription/v1/index.html"
        L_0x04ae:
            r3 = r1
            java.lang.String r1 = "url"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            java.lang.String r5 = r1.a((java.lang.Object) r2)
            java.lang.String r1 = "H5Automatic"
            r2 = r4
            r4 = r6
            r6 = r39
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.lang.String) r5, (android.content.Context) r6)
            return
        L_0x04c8:
            java.lang.String r1 = r0.f50284b
            java.lang.String r2 = "utility_creditcard"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x04de
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity> r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class
            r6 = r39
            r2 = r19
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x04de:
            r6 = r39
            r2 = r19
            java.lang.String r4 = "utility"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0534
            java.lang.String r1 = r0.f50283a
            boolean r1 = com.paytm.utility.b.I((java.lang.String) r1)
            if (r1 == 0) goto L_0x04fc
            net.one97.paytm.deeplink.h$a r0 = net.one97.paytm.deeplink.h.f50349a
            java.lang.String r0 = "paytmmp://buypayinsurance"
            r1 = 0
            net.one97.paytm.deeplink.h.a.a(r6, r0, r1)
            return
        L_0x04fc:
            java.lang.String r1 = r0.f50283a
            boolean r1 = net.one97.paytm.deeplink.j.a((java.lang.String) r1)
            if (r1 == 0) goto L_0x052d
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "is_education_h5_enabled"
            r4 = 0
            boolean r1 = net.one97.paytm.j.c.a((java.lang.String) r1, (boolean) r4)
            if (r1 == 0) goto L_0x052d
            java.lang.String r0 = r0.f50283a
            if (r0 == 0) goto L_0x051b
            java.lang.String r1 = "paytmmp://utility?url="
            java.lang.String r7 = kotlin.m.p.a(r0, r1, r3, r4)
            goto L_0x051c
        L_0x051b:
            r7 = 0
        L_0x051c:
            java.lang.String r0 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "paytmmp://edu-open-h5?qrCodeParams="
            java.lang.String r0 = r1.concat(r0)
            net.one97.paytm.deeplink.h$a r1 = net.one97.paytm.deeplink.h.f50349a
            r2 = 0
            net.one97.paytm.deeplink.h.a.a(r6, r0, r2)
            return
        L_0x052d:
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity> r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x0534:
            java.lang.String r3 = "dth"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0543
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity> r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x0543:
            java.lang.String r3 = "DTH"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0552
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity> r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x0552:
            java.lang.String r3 = "challan"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0561
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity> r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x0561:
            java.lang.String r3 = "mobile_prepaid"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0570
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x0570:
            java.lang.String r3 = "mobile_postpaid"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x057f
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x057f:
            java.lang.String r3 = "datacard_postpaid"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x058e
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x058e:
            java.lang.String r3 = "datacard_prepaid"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x059d
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x059d:
            java.lang.String r3 = "mobile-postpaid"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x05ac
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x05ac:
            java.lang.String r3 = "mobile-prepaid"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x05bb
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x05bb:
            java.lang.String r3 = "datacard-prepaid"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x05ca
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x05ca:
            java.lang.String r3 = "datacard-postpaid"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x05d8
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x05d8:
            java.lang.String r3 = "tollcard"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x05e7
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x05e7:
            java.lang.String r3 = "recharges"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x05f5
            java.lang.Class<net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity> r1 = net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x05f5:
            java.lang.String r3 = "mumbai_metro"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0603
            java.lang.Class<net.one97.paytm.recharge.metro.activity.AJRMetroTicketPurchaseActivity> r1 = net.one97.paytm.recharge.metro.activity.AJRMetroTicketPurchaseActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x0603:
            java.lang.String r3 = "automatic"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0611
            java.lang.Class<net.one97.paytm.recharge.presentation.activity.AJRAutomaticOptionListActivity> r1 = net.one97.paytm.recharge.presentation.activity.AJRAutomaticOptionListActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x0611:
            java.lang.String r3 = f50316b
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x061f
            java.lang.Class<net.one97.paytm.AJROrderSummaryActivity> r1 = net.one97.paytm.AJROrderSummaryActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x061f:
            java.lang.String r3 = "order_summary"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x062d
            java.lang.Class<net.one97.paytm.AJROrderSummaryActivity> r1 = net.one97.paytm.AJROrderSummaryActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x062d:
            java.lang.String r3 = "loan"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x063b
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity> r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class
            r2.setClass(r6, r1)
            goto L_0x0640
        L_0x063b:
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity> r1 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class
            r2.setClass(r6, r1)
        L_0x0640:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = a(r40)
            java.io.Serializable r0 = (java.io.Serializable) r0
            java.lang.String r1 = "extra_home_data"
            r2.putExtra(r1, r0)
            kotlin.x r0 = kotlin.x.f47997a
            boolean r0 = r6 instanceof android.app.Activity
            if (r0 != 0) goto L_0x0656
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r2.setFlags(r0)
        L_0x0656:
            r6.startActivity(r2)
            return
        L_0x065a:
            r2 = 0
            r8 = 1
            net.one97.paytm.recharge.g r1 = net.one97.paytm.recharge.g.f62773a
            net.one97.paytm.recharge.g.b(r39)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r1.putString(r4, r5)
            r1.putString(r7, r15)
            net.one97.paytm.recharge.c$a r4 = net.one97.paytm.recharge.c.f60405a
            java.lang.String r4 = net.one97.paytm.recharge.c.a.a(r39)
            r1.putString(r14, r4)
            r1.putString(r13, r12)
            r4 = 0
            r1.putBoolean(r11, r4)
            android.net.Uri r0 = r0.f50289g
            if (r0 == 0) goto L_0x0685
            android.net.Uri$Builder r7 = r0.buildUpon()
            goto L_0x0686
        L_0x0685:
            r7 = r2
        L_0x0686:
            if (r7 == 0) goto L_0x068e
            java.lang.String r0 = "utility_donation"
            r7.authority(r0)
        L_0x068e:
            if (r7 == 0) goto L_0x0695
            android.net.Uri r7 = r7.build()
            goto L_0x0696
        L_0x0695:
            r7 = r2
        L_0x0696:
            net.one97.paytm.recharge.d r0 = new net.one97.paytm.recharge.d
            r0.<init>()
            if (r7 == 0) goto L_0x06a2
            java.lang.String r5 = r7.toString()
            goto L_0x06a3
        L_0x06a2:
            r5 = r2
        L_0x06a3:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x06ad
            int r5 = r5.length()
            if (r5 != 0) goto L_0x06ae
        L_0x06ad:
            r4 = 1
        L_0x06ae:
            if (r4 != 0) goto L_0x06cc
            java.lang.String r4 = java.lang.String.valueOf(r7)
            r0.setUrl(r4)
            if (r7 == 0) goto L_0x06be
            java.lang.String r4 = r7.getQueryParameter(r10)
            goto L_0x06bf
        L_0x06be:
            r4 = r2
        L_0x06bf:
            r0.setParam(r4)
            if (r7 == 0) goto L_0x06c9
            java.lang.String r7 = r7.getQueryParameter(r9)
            r2 = r7
        L_0x06c9:
            r0.setId(r2)
        L_0x06cc:
            net.one97.paytm.deeplink.u r2 = net.one97.paytm.deeplink.u.a()
            net.one97.paytm.recharge.c$a r4 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r4 = "h5_donation_AppUniqueId"
            java.lang.String r4 = net.one97.paytm.j.c.a((java.lang.String) r4, (java.lang.String) r3)
            java.lang.String r5 = "GTMLoader.getInstance().…ION_APP_UNQIUE_ID_KEY,\"\")"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.recharge.c$a r5 = net.one97.paytm.recharge.c.f60405a
            net.one97.paytm.j.c.a()
            java.lang.String r5 = "h5_donation_url"
            java.lang.String r3 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r3)
            java.lang.String r5 = "GTMLoader.getInstance().…_DONATION_URL_GTM_KEY,\"\")"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            com.google.gsonhtcfix.f r5 = new com.google.gsonhtcfix.f
            r5.<init>()
            java.lang.String r5 = r5.a((java.lang.Object) r0)
            java.lang.String r7 = "Donation"
            r0 = r2
            r8 = r1
            r1 = r7
            r2 = r4
            r4 = r8
            r6 = r39
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.lang.String) r5, (android.content.Context) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.ai.b(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }

    public static final class a implements net.one97.paytm.recharge.common.e.ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f50319a;

        a(Context context) {
            this.f50319a = context;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                String str2 = null;
                cJRRechargeErrorModel.setErrorCode(networkCustomError != null ? String.valueOf(networkCustomError.getStatusCode()) : null);
                if (networkCustomError != null) {
                    str2 = networkCustomError.getUrl();
                }
                cJRRechargeErrorModel.setUrl(str2);
                new j(this.f50319a).sendEventToPaytmAnalytics(cJRRechargeErrorModel, this.f50319a);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            Context applicationContext = this.f50319a.getApplicationContext();
            if (applicationContext != null) {
                CJRJarvisApplication cJRJarvisApplication = (CJRJarvisApplication) applicationContext;
                if (iJRPaytmDataModel != null) {
                    cJRJarvisApplication.f49005a = (CJRFrequentOrderList) iJRPaytmDataModel;
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.recharge.CJRFrequentOrderList");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.app.CJRJarvisApplication");
        }
    }

    public static boolean a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        String str = deepLinkData.f50284b;
        if (p.a(str, "utility_creditcard", true) || p.a(str, "automatic", true) || p.a(str, "utility", true) || p.a(str, "dth", true) || p.a(str, "DTH", true) || p.a(str, "challan", true) || p.a(str, "mobile_prepaid", true) || p.a(str, "datacard_postpaid", true) || p.a(str, "datacard_prepaid", true) || p.a(str, "mobile-postpaid", true) || p.a(str, "mobile-prepaid", true) || p.a(str, "datacard-prepaid", true) || p.a(str, "datacard-postpaid", true) || p.a(str, "tollcard", true) || p.a(str, "recharges", true) || p.a(str, "mumbai_metro", true) || p.a(str, "loan", true) || p.a(str, f50316b, true) || p.a(str, "order_summary", true) || p.a(str, "mobile_postpaid", true) || p.a(str, "utility_donation", true) || p.a(str, "fastag-recharge", true) || p.a(str, "ottsubscription-recharge", true) || p.a(str, "mymonthlypayment", true) || (az.c(context) && p.a(str, "automatic-h5", true))) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0135, code lost:
        if (kotlin.m.p.a("automatic", r8, true) == false) goto L_0x0159;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01e6 A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0210 A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0221 A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x026d A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x027f A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02a7 A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x031b A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0109 A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x013f A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0148 A[Catch:{ Exception -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0174 A[SYNTHETIC, Splitter:B:91:0x0174] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.common.entity.shopping.CJRHomePageItem a(net.one97.paytm.deeplink.DeepLinkData r16) {
        /*
            r0 = r16
            java.lang.String r1 = "&"
            java.lang.String r2 = "url"
            java.lang.String r3 = "utility"
            java.lang.String r4 = "deepLinkData"
            kotlin.g.b.k.c(r0, r4)
            java.lang.String r4 = r0.f50283a
            r5 = 0
            if (r4 != 0) goto L_0x0019
            java.lang.String r4 = r0.f50284b
            if (r4 != 0) goto L_0x0019
            return r5
        L_0x0019:
            java.lang.String r4 = r0.f50283a     // Catch:{ Exception -> 0x033a }
            if (r4 != 0) goto L_0x0020
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x033a }
        L_0x0020:
            r6 = 36
            r7 = 38
            java.lang.String r4 = kotlin.m.p.a((java.lang.String) r4, (char) r6, (char) r7)     // Catch:{ Exception -> 0x033a }
            android.net.Uri r6 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x033a }
            if (r6 != 0) goto L_0x002f
            return r5
        L_0x002f:
            java.lang.String r8 = r6.getQueryParameter(r2)     // Catch:{ Exception -> 0x033a }
            if (r8 != 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r4 = r8
        L_0x0037:
            java.lang.String r8 = r0.f50284b     // Catch:{ Exception -> 0x033a }
            if (r8 != 0) goto L_0x003e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x033a }
        L_0x003e:
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x033a }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x033a }
            if (r9 == 0) goto L_0x0048
            return r5
        L_0x0048:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r9 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x033a }
            r9.<init>()     // Catch:{ Exception -> 0x033a }
            r10 = r4
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x033a }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x033a }
            if (r10 != 0) goto L_0x0059
            r9.setUrl(r4)     // Catch:{ Exception -> 0x033a }
        L_0x0059:
            java.lang.String r10 = r0.f50283a     // Catch:{ Exception -> 0x033a }
            r9.setDeeplink(r10)     // Catch:{ Exception -> 0x033a }
            r9.setUrlType(r8)     // Catch:{ Exception -> 0x033a }
            r10 = 1
            boolean r11 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r3, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            java.lang.String r12 = "dth"
            java.lang.String r13 = "postpaid"
            java.lang.String r14 = "prepaid"
            java.lang.String r15 = "utility_creditcard"
            java.lang.String r5 = "automatic"
            r7 = 0
            if (r11 != 0) goto L_0x00af
            boolean r11 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r15, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r11 == 0) goto L_0x007b
            goto L_0x00af
        L_0x007b:
            r11 = r8
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x033a }
            r10 = r14
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x033a }
            boolean r10 = kotlin.m.p.a((java.lang.CharSequence) r11, (java.lang.CharSequence) r10, (boolean) r7)     // Catch:{ Exception -> 0x033a }
            if (r10 != 0) goto L_0x00a9
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x033a }
            r11 = r13
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x033a }
            boolean r10 = kotlin.m.p.a((java.lang.CharSequence) r10, (java.lang.CharSequence) r11, (boolean) r7)     // Catch:{ Exception -> 0x033a }
            if (r10 == 0) goto L_0x0094
            goto L_0x00a9
        L_0x0094:
            r10 = 1
            boolean r11 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r12, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r11 == 0) goto L_0x009f
            r9.setName(r12)     // Catch:{ Exception -> 0x033a }
            goto L_0x00c2
        L_0x009f:
            boolean r11 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r11 == 0) goto L_0x00c2
            r9.setName(r5)     // Catch:{ Exception -> 0x033a }
            goto L_0x00c2
        L_0x00a9:
            java.lang.String r10 = "Mobile"
            r9.setName(r10)     // Catch:{ Exception -> 0x033a }
            goto L_0x00c2
        L_0x00af:
            java.lang.String r10 = "title"
            java.lang.String r10 = r6.getQueryParameter(r10)     // Catch:{ Exception -> 0x033a }
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x033a }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x033a }
            if (r11 != 0) goto L_0x00c2
            r9.setName(r10)     // Catch:{ Exception -> 0x033a }
        L_0x00c2:
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x033a }
            r11 = r14
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x033a }
            boolean r10 = kotlin.m.p.a((java.lang.CharSequence) r10, (java.lang.CharSequence) r11, (boolean) r7)     // Catch:{ Exception -> 0x033a }
            if (r10 != 0) goto L_0x00f3
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x033a }
            r11 = r13
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x033a }
            boolean r10 = kotlin.m.p.a((java.lang.CharSequence) r10, (java.lang.CharSequence) r11, (boolean) r7)     // Catch:{ Exception -> 0x033a }
            if (r10 != 0) goto L_0x00f3
            r10 = 1
            boolean r11 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r3, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r11 != 0) goto L_0x00f3
            boolean r11 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r12, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r11 != 0) goto L_0x00f3
            boolean r11 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r15, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r11 != 0) goto L_0x00f3
            boolean r11 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r11 == 0) goto L_0x010c
        L_0x00f3:
            r10 = r9
            net.one97.paytm.common.entity.CJRItem r10 = (net.one97.paytm.common.entity.CJRItem) r10     // Catch:{ Exception -> 0x033a }
            java.lang.String r10 = net.one97.paytm.utils.l.a((net.one97.paytm.common.entity.CJRItem) r10)     // Catch:{ Exception -> 0x033a }
            java.lang.Boolean r11 = com.paytm.utility.b.K((java.lang.String) r10)     // Catch:{ Exception -> 0x033a }
            java.lang.String r12 = "CJRAppCommonUtility.isValidInteger(categoryId)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x033a }
            boolean r11 = r11.booleanValue()     // Catch:{ Exception -> 0x033a }
            if (r11 == 0) goto L_0x010c
            r9.setCategoryId(r10)     // Catch:{ Exception -> 0x033a }
        L_0x010c:
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x033a }
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x033a }
            boolean r10 = kotlin.m.p.a((java.lang.CharSequence) r10, (java.lang.CharSequence) r14, (boolean) r7)     // Catch:{ Exception -> 0x033a }
            java.lang.String r11 = "related_category"
            if (r10 != 0) goto L_0x0137
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x033a }
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ Exception -> 0x033a }
            boolean r10 = kotlin.m.p.a((java.lang.CharSequence) r10, (java.lang.CharSequence) r13, (boolean) r7)     // Catch:{ Exception -> 0x033a }
            if (r10 != 0) goto L_0x0137
            r10 = 1
            boolean r3 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r3, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r3 != 0) goto L_0x0137
            boolean r3 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r15, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r3 != 0) goto L_0x0137
            boolean r3 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r10)     // Catch:{ Exception -> 0x033a }
            if (r3 == 0) goto L_0x0159
        L_0x0137:
            java.lang.String r3 = "label"
            java.lang.String r3 = r6.getQueryParameter(r3)     // Catch:{ Exception -> 0x033a }
            if (r3 == 0) goto L_0x0142
            r9.setLabel(r3)     // Catch:{ Exception -> 0x033a }
        L_0x0142:
            java.lang.String r3 = r6.getQueryParameter(r11)     // Catch:{ Exception -> 0x033a }
            if (r3 == 0) goto L_0x0159
            java.lang.String r3 = r6.getQueryParameter(r11)     // Catch:{ Exception -> 0x033a }
            java.util.ArrayList r5 = net.one97.paytm.utils.i.a(r3)     // Catch:{ Exception -> 0x033a }
            if (r5 == 0) goto L_0x0159
            java.util.ArrayList r3 = net.one97.paytm.utils.i.a(r3)     // Catch:{ Exception -> 0x033a }
            r9.setRelatedCategories(r3)     // Catch:{ Exception -> 0x033a }
        L_0x0159:
            r3 = r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x033a }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x033a }
            if (r3 != 0) goto L_0x0294
            java.util.Set r3 = r6.getQueryParameterNames()     // Catch:{ Exception -> 0x033a }
            if (r3 == 0) goto L_0x0294
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x033a }
        L_0x016c:
            boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x033a }
            java.lang.String r10 = "?"
            if (r5 == 0) goto L_0x01dd
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x033a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x033a }
            r12 = 1
            boolean r13 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r12)     // Catch:{ Exception -> 0x033a }
            if (r13 != 0) goto L_0x01da
            java.lang.String r13 = r6.getQueryParameter(r5)     // Catch:{ Exception -> 0x033a }
            boolean r14 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r11, (boolean) r12)     // Catch:{ Exception -> 0x033a }
            if (r14 == 0) goto L_0x0192
            java.lang.String r12 = "utf-8"
            java.lang.String r13 = java.net.URLEncoder.encode(r13, r12)     // Catch:{ Exception -> 0x033a }
        L_0x0192:
            if (r4 != 0) goto L_0x0197
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x033a }
        L_0x0197:
            r12 = r4
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ Exception -> 0x033a }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x033a }
            boolean r10 = kotlin.m.p.a((java.lang.CharSequence) r12, (java.lang.CharSequence) r10, (boolean) r7)     // Catch:{ Exception -> 0x033a }
            r12 = 61
            if (r10 != 0) goto L_0x01bf
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033a }
            r10.<init>()     // Catch:{ Exception -> 0x033a }
            r10.append(r4)     // Catch:{ Exception -> 0x033a }
            r4 = 63
            r10.append(r4)     // Catch:{ Exception -> 0x033a }
            r10.append(r5)     // Catch:{ Exception -> 0x033a }
            r10.append(r12)     // Catch:{ Exception -> 0x033a }
            r10.append(r13)     // Catch:{ Exception -> 0x033a }
            java.lang.String r4 = r10.toString()     // Catch:{ Exception -> 0x033a }
            goto L_0x016c
        L_0x01bf:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033a }
            r10.<init>()     // Catch:{ Exception -> 0x033a }
            r10.append(r4)     // Catch:{ Exception -> 0x033a }
            r14 = 38
            r10.append(r14)     // Catch:{ Exception -> 0x033a }
            r10.append(r5)     // Catch:{ Exception -> 0x033a }
            r10.append(r12)     // Catch:{ Exception -> 0x033a }
            r10.append(r13)     // Catch:{ Exception -> 0x033a }
            java.lang.String r4 = r10.toString()     // Catch:{ Exception -> 0x033a }
            goto L_0x016c
        L_0x01da:
            r14 = 38
            goto L_0x016c
        L_0x01dd:
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x033a }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x033a }
            if (r2 != 0) goto L_0x020e
            if (r4 != 0) goto L_0x01eb
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x033a }
        L_0x01eb:
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x033a }
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x033a }
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r3, false)     // Catch:{ Exception -> 0x033a }
            if (r2 == 0) goto L_0x020e
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x033a }
            r3 = r10
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x033a }
            boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r3, false)     // Catch:{ Exception -> 0x033a }
            if (r2 != 0) goto L_0x020e
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x033a }
            kotlin.m.l r2 = new kotlin.m.l     // Catch:{ Exception -> 0x033a }
            r2.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r4 = r2.replaceFirst(r4, r10)     // Catch:{ Exception -> 0x033a }
        L_0x020e:
            if (r4 != 0) goto L_0x0213
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x033a }
        L_0x0213:
            int r1 = r4.length()     // Catch:{ Exception -> 0x033a }
            r2 = 1
            int r1 = r1 - r2
            char r1 = r4.charAt(r1)     // Catch:{ Exception -> 0x033a }
            r3 = 47
            if (r1 != r3) goto L_0x022f
            int r1 = r4.length()     // Catch:{ Exception -> 0x033a }
            int r1 = r1 - r2
            java.lang.String r4 = r4.substring(r7, r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.b(r4, r1)     // Catch:{ Exception -> 0x033a }
        L_0x022f:
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x033a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x033a }
            if (r1 != 0) goto L_0x0291
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x033a }
            java.lang.String r2 = "versionidentifier"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x033a }
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, false)     // Catch:{ Exception -> 0x033a }
            if (r1 != 0) goto L_0x0291
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x033a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x033a }
            if (r1 != 0) goto L_0x0291
            java.lang.String r1 = "train_order_summary"
            r2 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x033a }
            if (r1 != 0) goto L_0x0291
            java.lang.String r1 = "train_order_summary_v2"
            boolean r1 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x033a }
            if (r1 != 0) goto L_0x0291
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x033a }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x033a }
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r10, false)     // Catch:{ Exception -> 0x033a }
            if (r1 != 0) goto L_0x027f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033a }
            r1.<init>()     // Catch:{ Exception -> 0x033a }
            r1.append(r4)     // Catch:{ Exception -> 0x033a }
            java.lang.String r2 = "?versionidentifier=1"
            r1.append(r2)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x033a }
            goto L_0x0290
        L_0x027f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033a }
            r1.<init>()     // Catch:{ Exception -> 0x033a }
            r1.append(r4)     // Catch:{ Exception -> 0x033a }
            java.lang.String r2 = "&versionidentifier=1"
            r1.append(r2)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x033a }
        L_0x0290:
            r4 = r1
        L_0x0291:
            r9.setUrl(r4)     // Catch:{ Exception -> 0x033a }
        L_0x0294:
            android.net.Uri r1 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x033a }
            java.lang.String r2 = "isAppLink"
            java.lang.String r1 = r1.getQueryParameter(r2)     // Catch:{ Exception -> 0x033a }
            java.lang.String r2 = "1"
            r3 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)     // Catch:{ Exception -> 0x033a }
            if (r1 == 0) goto L_0x02aa
            r9.setAppLink(r3)     // Catch:{ Exception -> 0x033a }
        L_0x02aa:
            java.lang.String r1 = "promo_code"
            java.lang.String r1 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x033a }
            r9.setPushPromoCode(r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = "product_id"
            java.lang.String r1 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x033a }
            r9.setPushProductId(r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = r0.f50283a     // Catch:{ Exception -> 0x033a }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x033a }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x033a }
            if (r1 != 0) goto L_0x02d4
            java.lang.String r1 = r0.f50283a     // Catch:{ Exception -> 0x033a }
            if (r1 == 0) goto L_0x02d4
            java.lang.String r2 = "paytmmp://"
            boolean r1 = kotlin.m.p.b(r1, r2, r7)     // Catch:{ Exception -> 0x033a }
            r10 = 1
            if (r1 != r10) goto L_0x02d4
            r7 = 1
        L_0x02d4:
            r9.setDeepLinking(r7)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = "recharge_number"
            java.lang.String r1 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x033a }
            r9.setPushRechargeNumber(r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = "price"
            java.lang.String r1 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x033a }
            r9.setPushRechargeAmount(r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = "promo"
            java.lang.String r1 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x033a }
            r9.setPushRechargePromo(r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = "roaming"
            java.lang.String r1 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x033a }
            r9.setPushRechargeRoaming(r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = net.one97.paytm.utils.n.w     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x033a }
            r9.setVertical(r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = net.one97.paytm.utils.n.au     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x033a }
            r9.setMtTitle(r1)     // Catch:{ Exception -> 0x033a }
            java.lang.String r1 = "verticalId"
            java.lang.String r1 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x033a }
            r9.setVerticalId(r1)     // Catch:{ Exception -> 0x033a }
            android.os.Bundle r1 = r0.f50290h     // Catch:{ Exception -> 0x033a }
            if (r1 == 0) goto L_0x0339
            android.os.Bundle r1 = r0.f50290h     // Catch:{ Exception -> 0x033a }
            if (r1 != 0) goto L_0x0322
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x033a }
        L_0x0322:
            java.lang.String r2 = "origin"
            boolean r1 = r1.containsKey(r2)     // Catch:{ Exception -> 0x033a }
            if (r1 == 0) goto L_0x0339
            android.os.Bundle r0 = r0.f50290h     // Catch:{ Exception -> 0x033a }
            if (r0 == 0) goto L_0x0335
            java.lang.String r1 = "origin"
            java.lang.String r5 = r0.getString(r1)     // Catch:{ Exception -> 0x033a }
            goto L_0x0336
        L_0x0335:
            r5 = 0
        L_0x0336:
            r9.setOrigin(r5)     // Catch:{ Exception -> 0x033a }
        L_0x0339:
            return r9
        L_0x033a:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.ai.a(net.one97.paytm.deeplink.DeepLinkData):net.one97.paytm.common.entity.shopping.CJRHomePageItem");
    }
}
