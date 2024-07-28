package net.one97.paytm.paymentsBank.pdc;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.pdc.response.PDCPriceResponse;
import net.one97.paytm.paymentsBank.pdc.response.PDCStatusResponse;
import net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0080 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.bankCommon.g.f a(android.content.Context r12, net.one97.paytm.bankCommon.g.g.b<com.paytm.network.model.IJRPaytmDataModel> r13, net.one97.paytm.bankCommon.g.g.a r14, java.lang.String r15, com.paytm.network.a.c r16, com.paytm.network.a.b r17, java.util.HashMap<java.lang.String, java.lang.String> r18) {
        /*
            java.lang.String r0 = "1"
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r1 = com.paytm.utility.a.q(r12)
            java.lang.String r2 = "userToken"
            r6.put(r2, r1)
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json"
            r6.put(r1, r2)
            r1 = 0
            r2 = 0
            r3 = r12
            java.util.Map r1 = com.paytm.utility.c.b((android.content.Context) r12, (boolean) r1)     // Catch:{ Exception -> 0x0053 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0053 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r1 = "channel"
            java.lang.String r5 = "B2C_ANDROID"
            r4.put(r1, r5)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "childSiteId"
            r4.put(r1, r0)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "client"
            net.one97.paytm.paymentsBank.h.a r5 = net.one97.paytm.paymentsBank.utils.o.a()     // Catch:{ Exception -> 0x0051 }
            java.lang.String r5 = r5.getClient()     // Catch:{ Exception -> 0x0051 }
            r4.put(r1, r5)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "customerMobileNumber"
            java.lang.String r3 = com.paytm.utility.b.l((android.content.Context) r12)     // Catch:{ Exception -> 0x0051 }
            r4.put(r1, r3)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "productId"
            r3 = r15
            r4.put(r1, r15)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "siteId"
            r4.put(r1, r0)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0058
        L_0x0051:
            r0 = move-exception
            goto L_0x0055
        L_0x0053:
            r0 = move-exception
            r4 = r2
        L_0x0055:
            r0.printStackTrace()
        L_0x0058:
            net.one97.paytm.bankCommon.utils.d.b()
            java.lang.String r0 = "pdc_new_prevalidate"
            java.lang.String r0 = net.one97.paytm.bankCommon.utils.d.a(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0080
            net.one97.paytm.bankCommon.g.b r11 = new net.one97.paytm.bankCommon.g.b
            net.one97.paytm.paymentsBank.pdc.response.PDCPrevalidateResponse r5 = new net.one97.paytm.paymentsBank.pdc.response.PDCPrevalidateResponse
            r5.<init>()
            java.lang.String r7 = r4.toString()
            r1 = r11
            r2 = r0
            r3 = r13
            r4 = r14
            r8 = r16
            r9 = r17
            r10 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        L_0x0080:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.pdc.a.a(android.content.Context, net.one97.paytm.bankCommon.g.g$b, net.one97.paytm.bankCommon.g.g$a, java.lang.String, com.paytm.network.a$c, com.paytm.network.a$b, java.util.HashMap):net.one97.paytm.bankCommon.g.f");
    }

    public static f b(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        d.b();
        sb.append(d.a("pdc_new_fetch_productlist"));
        if (TextUtils.isEmpty(sb)) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append("productId=");
            String str2 = str;
            sb.append(str);
        } else {
            sb.append("productType=PDC&productName=PDC_WITHOUT_PHOTO&productInitiator=CUSTOMER");
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Authorization", com.paytm.utility.a.q(context));
        hashMap2.put("Client-Id", UpiConstants.B2C_ANDROID);
        return new net.one97.paytm.bankCommon.g.a(sb.toString(), bVar, aVar, new PDCPriceResponse(), hashMap2, cVar, bVar2, hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x010b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.bankCommon.g.f a(android.content.Context r13, net.one97.paytm.bankCommon.g.g.b<com.paytm.network.model.IJRPaytmDataModel> r14, net.one97.paytm.bankCommon.g.g.a r15, java.lang.String r16, net.one97.paytm.bankCommon.model.PBCJRAddress r17, java.lang.String r18, java.lang.String r19, com.paytm.network.a.c r20, com.paytm.network.a.b r21, java.util.HashMap<java.lang.String, java.lang.String> r22) {
        /*
            r1 = r13
            java.lang.String r0 = "1"
            java.lang.String r2 = "channel"
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r3 = com.paytm.utility.a.q(r13)
            java.lang.String r4 = "userToken"
            r8.put(r4, r3)
            java.lang.String r3 = "application/json"
            java.lang.String r4 = "Content-Type"
            r8.put(r4, r3)
            java.lang.String r4 = "Accept"
            r8.put(r4, r3)
            java.lang.String r3 = "bankScopeToken"
            r4 = r16
            r8.put(r3, r4)
            r3 = 0
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00db }
            r4.<init>()     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "id"
            java.lang.String r6 = r17.getId()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "name"
            java.lang.String r6 = r17.getName()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "title"
            java.lang.String r6 = r17.getTitle()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "fulladdress"
            java.lang.String r6 = r17.getFulladdress()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "address1"
            java.lang.String r6 = r17.getAddress1()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "address2"
            java.lang.String r6 = r17.getAddress2()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "city"
            java.lang.String r6 = r17.getCity()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "state"
            java.lang.String r6 = r17.getState()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "country"
            java.lang.String r6 = r17.getCountry()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "pin"
            java.lang.String r6 = r17.getPin()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "mobile"
            java.lang.String r6 = r17.getMobile()     // Catch:{ Exception -> 0x00db }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x00db }
            r5 = 0
            java.util.Map r5 = com.paytm.utility.c.b((android.content.Context) r13, (boolean) r5)     // Catch:{ Exception -> 0x00db }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x00db }
            r6.<init>(r5)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = "B2C_ANDROID"
            r6.put(r2, r5)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r5 = "childSiteId"
            r6.put(r5, r0)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r5 = "client"
            net.one97.paytm.paymentsBank.h.a r7 = net.one97.paytm.paymentsBank.utils.o.a()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r7 = r7.getClient()     // Catch:{ Exception -> 0x00d9 }
            r6.put(r5, r7)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r5 = "customerMobileNumber"
            java.lang.String r7 = com.paytm.utility.b.l((android.content.Context) r13)     // Catch:{ Exception -> 0x00d9 }
            r6.put(r5, r7)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r5 = "productId"
            r7 = r18
            r6.put(r5, r7)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r5 = "siteId"
            r6.put(r5, r0)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r0 = "amount"
            double r9 = java.lang.Double.parseDouble(r19)     // Catch:{ Exception -> 0x00d9 }
            r6.put(r0, r9)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r0 = "BC"
            r6.put(r2, r0)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r0 = "address"
            r6.put(r0, r4)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00e0
        L_0x00d9:
            r0 = move-exception
            goto L_0x00dd
        L_0x00db:
            r0 = move-exception
            r6 = r3
        L_0x00dd:
            r0.printStackTrace()
        L_0x00e0:
            net.one97.paytm.bankCommon.utils.d.b()
            java.lang.String r0 = "pdc_new_checkout"
            java.lang.String r0 = net.one97.paytm.bankCommon.utils.d.a(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x010b
            java.lang.String r4 = com.paytm.utility.c.b((java.lang.String) r0, (android.content.Context) r13)
            net.one97.paytm.bankCommon.g.b r0 = new net.one97.paytm.bankCommon.g.b
            net.one97.paytm.paymentsBank.pdc.response.PDCCheckoutResponse r7 = new net.one97.paytm.paymentsBank.pdc.response.PDCCheckoutResponse
            r7.<init>()
            java.lang.String r9 = r6.toString()
            r3 = r0
            r5 = r14
            r6 = r15
            r10 = r20
            r11 = r21
            r12 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x010b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.pdc.a.a(android.content.Context, net.one97.paytm.bankCommon.g.g$b, net.one97.paytm.bankCommon.g.g$a, java.lang.String, net.one97.paytm.bankCommon.model.PBCJRAddress, java.lang.String, java.lang.String, com.paytm.network.a$c, com.paytm.network.a$b, java.util.HashMap):net.one97.paytm.bankCommon.g.f");
    }

    public static f c(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        d.b();
        StringBuilder sb = new StringBuilder(d.a("pdc_new_status_check"));
        if (TextUtils.isEmpty(sb)) {
            return null;
        }
        sb.append("orderId=");
        String str2 = str;
        sb.append(str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("authorization", com.paytm.utility.a.q(context));
        hashMap2.put("Accept", "application/json");
        return new net.one97.paytm.bankCommon.g.a(sb.toString(), bVar, aVar, new PDCStatusResponse(), hashMap2, cVar, bVar2, hashMap);
    }

    public static f a(Context context, String str, boolean z, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        boolean z2 = z;
        StringBuilder sb = new StringBuilder();
        d.b();
        sb.append(d.a("pdc_new_track_order"));
        if (TextUtils.isEmpty(sb)) {
            return null;
        }
        sb.append("orderId=");
        String str2 = str;
        sb.append(str);
        sb.append("&isfromMarketPlace=");
        sb.append(z);
        if (z2) {
            sb.append("&singleCard=true&itemTracking=1");
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("userToken", com.paytm.utility.a.q(context));
        hashMap2.put("Accept", "application/json");
        return new net.one97.paytm.bankCommon.g.a(sb.toString(), bVar, aVar, new PDCTrackOrderResponse(), hashMap2, cVar, bVar2, hashMap);
    }
}
