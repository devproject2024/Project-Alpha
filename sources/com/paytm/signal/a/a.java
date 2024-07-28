package com.paytm.signal.a;

import com.google.gson.f;
import com.google.gson.l;
import com.google.gson.q;
import com.paytm.notification.b.e;
import com.paytm.signal.models.Config;
import com.paytm.signal.models.SignalEvent;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43590a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final f f43591b = new f();

    /* renamed from: c  reason: collision with root package name */
    private static ArrayList<String> f43592c;

    private a() {
    }

    public static String a(List<SignalEvent> list, Config config) {
        Config config2 = config;
        k.c(config2, Constants.EASY_PAY_CONFIG_PREF_KEY);
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SignalEvent next : list) {
            SignalEvent signalEvent = next;
            SignalEvent copy$default = SignalEvent.copy$default(next, (String) null, (Object) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16777215, (Object) null);
            try {
                Object payload = copy$default.getPayload();
                if (payload != null) {
                    l a2 = q.a((String) payload);
                    k.a((Object) a2, "JsonParser.parseString(t…pEvent.payload as String)");
                    copy$default.setPayload(a2.h());
                    copy$default.setUploadTime$paytmnotification_paytmRelease(Long.valueOf(System.currentTimeMillis()));
                    signalEvent.setUploadTime$paytmnotification_paytmRelease(copy$default.getUploadTime$paytmnotification_paytmRelease());
                    copy$default.setId$paytmnotification_paytmRelease((Long) null);
                    arrayList.add(copy$default);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            } catch (Exception e2) {
                e.f43014a.b(e2);
            }
        }
        b(arrayList, config2);
        return f43591b.b(arrayList);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0177, code lost:
        if (r2.equals("osVersion") != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x017e, code lost:
        if (r2.equals("appVersion") != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0185, code lost:
        if (r2.equals("deviceDateTime") != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x018c, code lost:
        if (r2.equals("messageVersion") != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0193, code lost:
        if (r2.equals(r4) != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x019a, code lost:
        if (r2.equals("clientId") != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01a1, code lost:
        if (r2.equals("model") != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01a8, code lost:
        if (r2.equals(com.paytmmall.clpartifact.utils.CLPConstants.BRAND_PARAMS) != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01af, code lost:
        if (r2.equals("uploadTime") != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b6, code lost:
        if (r2.equals(easypay.manager.Constants.RISK_OS_TYPE) != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01bd, code lost:
        if (r2.equals("lastAppOpenDate") != false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01c6, code lost:
        if (r2.equals(easypay.manager.Constants.RISK_SDK_VERSION) != false) goto L_0x01cb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(java.util.List<com.paytm.signal.models.SignalEvent> r21, com.paytm.signal.models.Config r22) {
        /*
            java.lang.String r0 = "config"
            r1 = r22
            kotlin.g.b.k.c(r1, r0)
            boolean r0 = r21.isEmpty()
            if (r0 == 0) goto L_0x000e
            return
        L_0x000e:
            java.util.Iterator r0 = r21.iterator()
        L_0x0012:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0284
            java.lang.Object r2 = r0.next()
            com.paytm.signal.models.SignalEvent r2 = (com.paytm.signal.models.SignalEvent) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            f43592c = r3
            java.lang.String r3 = r2.getDeviceId$paytmnotification_paytmRelease()
            java.lang.String r4 = "deviceId"
            a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = r2.getCustomerId$paytmnotification_paytmRelease()
            java.lang.String r5 = "customerId"
            a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.Long r3 = r2.getDeviceDateTime$paytmnotification_paytmRelease()
            java.lang.String r5 = "deviceDateTime"
            a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r3 = r2.getClientId$paytmnotification_paytmRelease()
            java.lang.String r6 = "clientId"
            a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.Integer r3 = r2.getMessageVersion$paytmnotification_paytmRelease()
            java.lang.String r7 = "messageVersion"
            a((java.lang.Object) r3, (java.lang.String) r7)
            java.lang.Long r3 = r2.getUploadTime$paytmnotification_paytmRelease()
            java.lang.String r8 = "uploadTime"
            a((java.lang.Object) r3, (java.lang.String) r8)
            java.lang.String r3 = r2.getAppVersion$paytmnotification_paytmRelease()
            java.lang.String r9 = "appVersion"
            a((java.lang.Object) r3, (java.lang.String) r9)
            java.lang.String r3 = r2.getAppLanguage$paytmnotification_paytmRelease()
            java.lang.String r10 = "appLanguage"
            a((java.lang.Object) r3, (java.lang.String) r10)
            java.lang.Long r3 = r2.getLastAppOpenDate$paytmnotification_paytmRelease()
            java.lang.String r10 = "lastAppOpenDate"
            a((java.lang.Object) r3, (java.lang.String) r10)
            java.lang.String r3 = r2.getOsType$paytmnotification_paytmRelease()
            java.lang.String r11 = "osType"
            a((java.lang.Object) r3, (java.lang.String) r11)
            java.lang.String r3 = r2.getOsVersion$paytmnotification_paytmRelease()
            java.lang.String r12 = "osVersion"
            a((java.lang.Object) r3, (java.lang.String) r12)
            java.lang.String r3 = r2.getModel$paytmnotification_paytmRelease()
            java.lang.String r13 = "model"
            a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r3 = r2.getBrand$paytmnotification_paytmRelease()
            java.lang.String r14 = "brand"
            a((java.lang.Object) r3, (java.lang.String) r14)
            java.lang.Boolean r3 = r22.isLocationEnable()
            java.lang.Boolean r15 = java.lang.Boolean.TRUE
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x00b9
            java.lang.String r3 = r2.getLongitude$paytmnotification_paytmRelease()
            java.lang.String r15 = "longitude"
            a((java.lang.Object) r3, (java.lang.String) r15)
            java.lang.String r3 = r2.getLatitude$paytmnotification_paytmRelease()
            java.lang.String r15 = "latitude"
            a((java.lang.Object) r3, (java.lang.String) r15)
        L_0x00b9:
            java.lang.String r3 = r2.getAdvertisementId$paytmnotification_paytmRelease()
            java.lang.String r15 = "advertisementId"
            a((java.lang.Object) r3, (java.lang.String) r15)
            java.lang.String r3 = r2.getIp$paytmnotification_paytmRelease()
            java.lang.String r15 = "ip"
            a((java.lang.Object) r3, (java.lang.String) r15)
            java.lang.String r3 = r2.getCarrier$paytmnotification_paytmRelease()
            java.lang.String r15 = "carrier"
            a((java.lang.Object) r3, (java.lang.String) r15)
            java.lang.String r3 = r2.getConnectionType$paytmnotification_paytmRelease()
            java.lang.String r15 = "connectionType"
            a((java.lang.Object) r3, (java.lang.String) r15)
            java.lang.String r3 = r2.getSdkVersion$paytmnotification_paytmRelease()
            java.lang.String r15 = "sdkVersion"
            a((java.lang.Object) r3, (java.lang.String) r15)
            java.util.ArrayList<java.lang.String> r3 = f43592c
            java.lang.String r15 = "missingFields"
            if (r3 != 0) goto L_0x00ef
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x00ef:
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x027c
            java.util.ArrayList<java.lang.String> r3 = f43592c
            if (r3 != 0) goto L_0x00fc
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x00fc:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            r21 = r0
            java.lang.String r0 = ""
            r1 = r0
            r17 = r1
            r16 = r2
            r2 = r17
            r0 = 0
        L_0x010e:
            boolean r18 = r3.hasNext()
            r19 = 1
            if (r18 == 0) goto L_0x022c
            r3.next()
            r18 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            if (r0 != 0) goto L_0x0135
            java.util.ArrayList<java.lang.String> r1 = f43592c
            if (r1 != 0) goto L_0x012c
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x012c:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            r20 = r2
            goto L_0x0152
        L_0x0135:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r20 = r2
            java.lang.String r2 = ", "
            r1.<init>(r2)
            java.util.ArrayList<java.lang.String> r2 = f43592c
            if (r2 != 0) goto L_0x0145
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x0145:
            java.lang.Object r2 = r2.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x0152:
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.util.ArrayList<java.lang.String> r2 = f43592c
            if (r2 != 0) goto L_0x0160
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x0160:
            java.lang.Object r2 = r2.get(r0)
            java.lang.String r3 = "missingFields[index]"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r2 = (java.lang.String) r2
            int r3 = r2.hashCode()
            switch(r3) {
                case -1962630338: goto L_0x01c0;
                case -1864942109: goto L_0x01b9;
                case -1008304322: goto L_0x01b2;
                case -243078034: goto L_0x01ab;
                case 93997959: goto L_0x01a4;
                case 104069929: goto L_0x019d;
                case 908408390: goto L_0x0196;
                case 1109191185: goto L_0x018f;
                case 1208676049: goto L_0x0188;
                case 1478491153: goto L_0x0181;
                case 1484112759: goto L_0x017a;
                case 1812004436: goto L_0x0173;
                default: goto L_0x0172;
            }
        L_0x0172:
            goto L_0x01c9
        L_0x0173:
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x017a:
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x0181:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x0188:
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x018f:
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x0196:
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x019d:
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01a4:
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01ab:
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01b2:
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01b9:
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01c0:
            java.lang.String r3 = "sdkVersion"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01c9:
            r19 = 0
        L_0x01cb:
            if (r19 == 0) goto L_0x0217
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = r20
            r2.append(r3)
            r20 = r4
            r4 = r17
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x01f1
            java.util.ArrayList<java.lang.String> r3 = f43592c
            if (r3 != 0) goto L_0x01e8
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x01e8:
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            r17 = r1
            goto L_0x020e
        L_0x01f1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r17 = r1
            java.lang.String r1 = ", "
            r3.<init>(r1)
            java.util.ArrayList<java.lang.String> r1 = f43592c
            if (r1 != 0) goto L_0x0201
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x0201:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            r3.append(r1)
            java.lang.String r3 = r3.toString()
        L_0x020e:
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            r2 = r1
            goto L_0x0220
        L_0x0217:
            r3 = r20
            r20 = r4
            r4 = r17
            r17 = r1
            r2 = r3
        L_0x0220:
            int r0 = r0 + 1
            r1 = r17
            r3 = r18
            r17 = r4
            r4 = r20
            goto L_0x010e
        L_0x022c:
            r3 = r2
            r4 = r17
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "SignalSDKLog - Event["
            r0.<init>(r2)
            java.lang.String r2 = r16.getEventType()
            r0.append(r2)
            java.lang.String r2 = "] is missing the following OPTIONAL fields - "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a
            r2 = 0
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r1.c(r0, r5)
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x027e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "SignalSDKLog - Event["
            r0.<init>(r1)
            java.lang.String r1 = r16.getEventType()
            r0.append(r1)
            java.lang.String r1 = "] is missing the following REQUIRED fields - "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r1.d(r0, r2)
            goto L_0x027e
        L_0x027c:
            r21 = r0
        L_0x027e:
            r0 = r21
            r1 = r22
            goto L_0x0012
        L_0x0284:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.signal.a.a.b(java.util.List, com.paytm.signal.models.Config):void");
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            ArrayList<String> arrayList = f43592c;
            if (arrayList == null) {
                k.a("missingFields");
            }
            arrayList.add(str);
        } else if ((obj instanceof Long) && ((Number) obj).longValue() == 0) {
            ArrayList<String> arrayList2 = f43592c;
            if (arrayList2 == null) {
                k.a("missingFields");
            }
            arrayList2.add(str);
        } else if ((obj instanceof Integer) && k.a(((Number) obj).intValue(), 0) == 0) {
            ArrayList<String> arrayList3 = f43592c;
            if (arrayList3 == null) {
                k.a("missingFields");
            }
            arrayList3.add(str);
        }
    }
}
