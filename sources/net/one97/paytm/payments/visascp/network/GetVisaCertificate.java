package net.one97.paytm.payments.visascp.network;

import android.content.Context;
import com.android.volley.Response;

public class GetVisaCertificate {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean f584 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f585 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f586;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ boolean m690(boolean z) {
        int i2 = f585;
        int i3 = i2 & 23;
        int i4 = i3 + ((i2 ^ 23) | i3);
        f586 = i4 % 128;
        if (i4 % 2 == 0) {
        }
        f584 = z;
        return z;
    }

    public static void executeGetCertificateApi(Context context, boolean z, String str) {
        Throwable cause;
        int i2 = f586;
        int i3 = i2 & 65;
        int i4 = (i2 | 65) & (~i3);
        int i5 = -(-(i3 << 1));
        int i6 = ((i4 | i5) << 1) - (i4 ^ i5);
        f585 = i6 % 128;
        int i7 = i6 % 2;
        if (!f584) {
            f584 = true;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Object[] objArr = new Object[3];
                objArr[2] = str;
                objArr[1] = context;
                objArr[0] = Long.valueOf(currentTimeMillis);
                Response.Listener listener = (Response.Listener) ((Class) If.m692(0, 61, 54)).getDeclaredConstructor(new Class[]{Long.TYPE, Context.class, String.class}).newInstance(objArr);
                try {
                    Object[] objArr2 = new Object[3];
                    objArr2[2] = str;
                    objArr2[1] = context;
                    objArr2[0] = Long.valueOf(currentTimeMillis);
                    callGetCertificateApi(context, z, str, listener, (Response.ErrorListener) ((Class) If.m692(26695, 61, 115)).getDeclaredConstructor(new Class[]{Long.TYPE, Context.class, String.class}).newInstance(objArr2));
                    int i8 = f585 + 89;
                    f586 = i8 % 128;
                    int i9 = i8 % 2;
                } catch (Throwable th) {
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } finally {
                cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
            }
        }
        int i10 = f586;
        int i11 = i10 & 83;
        int i12 = (i10 ^ 83) | i11;
        int i13 = (i11 & i12) + (i12 | i11);
        f585 = i13 % 128;
        if (i13 % 2 == 0) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if ((r20 ? 'X' : 14) != 14) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        if ((r20) != true) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (isCertificateApiCallNeeded(r19) != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        r8 = new java.util.HashMap();
        r8.put(net.one97.paytm.payments.visascp.util.VisaSCPConstants.AUTHENTICATION_HEADER, new net.one97.paytm.payments.visascp.security.Encrypter().createJWTTokenForVisaCertificate(r19.getApplicationContext().getPackageName(), r21));
        net.one97.paytm.payments.visascp.network.HawkEyeEvent.getInstance(r19).logLocalEvent(false, "create-JWT-Token-visa-certificate", r21, new java.sql.Timestamp(java.lang.System.currentTimeMillis()).toString(), java.lang.String.valueOf(java.lang.System.currentTimeMillis()), 200, "Success", "", "");
        net.one97.paytm.payments.visascp.network.VolleyWrapper.newRequestQueue(r19).add(new net.one97.paytm.payments.visascp.network.VolleyRequest(1, net.one97.paytm.payments.visascp.util.Utils.getVisaCertificateURL(), (java.lang.String) null, r8, new net.one97.paytm.payments.visascp.network.model.GetVisaCertificateResponseModel(), r22, r23));
        r0 = f585;
        r1 = r0 ^ 19;
        r0 = ((((r0 & 19) | r1) << 1) - (~(-r1))) - 1;
        f586 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        r0 = f586;
        r1 = ((r0 | 83) << 1) - (r0 ^ 83);
        f585 = r1 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b6, code lost:
        if ((r1 % 2) == 0) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b9, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ba, code lost:
        if (r2 == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bc, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void callGetCertificateApi(android.content.Context r19, boolean r20, java.lang.String r21, com.android.volley.Response.Listener<net.one97.paytm.payments.visascp.network.model.BaseModel> r22, com.android.volley.Response.ErrorListener r23) {
        /*
            int r0 = f586
            int r0 = r0 + 15
            int r1 = r0 % 128
            f585 = r1
            int r0 = r0 % 2
            r1 = 57
            if (r0 == 0) goto L_0x0011
            r0 = 63
            goto L_0x0013
        L_0x0011:
            r0 = 57
        L_0x0013:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0023
            r0 = 14
            if (r20 == 0) goto L_0x001e
            r1 = 88
            goto L_0x0020
        L_0x001e:
            r1 = 14
        L_0x0020:
            if (r1 == r0) goto L_0x002e
            goto L_0x0034
        L_0x0023:
            r0 = 0
            super.hashCode()     // Catch:{ all -> 0x00bd }
            if (r20 == 0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            if (r0 == r3) goto L_0x0034
        L_0x002e:
            boolean r0 = isCertificateApiCallNeeded(r19)
            if (r0 == 0) goto L_0x00a8
        L_0x0034:
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            net.one97.paytm.payments.visascp.security.Encrypter r0 = new net.one97.paytm.payments.visascp.security.Encrypter
            r0.<init>()
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.AUTHENTICATION_HEADER
            android.content.Context r4 = r19.getApplicationContext()
            java.lang.String r4 = r4.getPackageName()
            r5 = r21
            java.lang.String r0 = r0.createJWTTokenForVisaCertificate(r4, r5)
            r8.put(r1, r0)
            net.one97.paytm.payments.visascp.network.HawkEyeEvent r9 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.getInstance(r19)
            r10 = 0
            java.sql.Timestamp r0 = new java.sql.Timestamp
            long r6 = java.lang.System.currentTimeMillis()
            r0.<init>(r6)
            java.lang.String r13 = r0.toString()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r14 = java.lang.String.valueOf(r0)
            r15 = 200(0xc8, float:2.8E-43)
            java.lang.String r11 = "create-JWT-Token-visa-certificate"
            java.lang.String r16 = "Success"
            java.lang.String r17 = ""
            java.lang.String r18 = ""
            r12 = r21
            r9.logLocalEvent(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            net.one97.paytm.payments.visascp.network.model.GetVisaCertificateResponseModel r9 = new net.one97.paytm.payments.visascp.network.model.GetVisaCertificateResponseModel
            r9.<init>()
            net.one97.paytm.payments.visascp.network.VolleyRequest r0 = new net.one97.paytm.payments.visascp.network.VolleyRequest
            r5 = 1
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.Utils.getVisaCertificateURL()
            r7 = 0
            r4 = r0
            r10 = r22
            r11 = r23
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            com.android.volley.RequestQueue r1 = net.one97.paytm.payments.visascp.network.VolleyWrapper.newRequestQueue(r19)
            r1.add(r0)
            int r0 = f585
            r1 = r0 ^ 19
            r0 = r0 & 19
            r0 = r0 | r1
            int r0 = r0 << r3
            int r1 = -r1
            int r1 = ~r1
            int r0 = r0 - r1
            int r0 = r0 - r3
            int r1 = r0 % 128
            f586 = r1
            int r0 = r0 % 2
        L_0x00a8:
            int r0 = f586
            r1 = r0 | 83
            int r1 = r1 << r3
            r0 = r0 ^ 83
            int r1 = r1 - r0
            int r0 = r1 % 128
            f585 = r0
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r2 = 1
        L_0x00ba:
            if (r2 == 0) goto L_0x00bc
        L_0x00bc:
            return
        L_0x00bd:
            r0 = move-exception
            r1 = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.GetVisaCertificate.callGetCertificateApi(android.content.Context, boolean, java.lang.String, com.android.volley.Response$Listener, com.android.volley.Response$ErrorListener):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        if (r0 != false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        if ((r0 ? '6' : 'T') != '6') goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCertificateApiCallNeeded(android.content.Context r4) {
        /*
            int r0 = f585
            r1 = r0 & 15
            r0 = r0 | 15
            r2 = r1 & r0
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f586 = r0
            int r2 = r2 % 2
            java.util.ArrayList r4 = net.one97.paytm.payments.visascp.util.Utils.getCertificate(r4)
            r0 = 44
            if (r4 != 0) goto L_0x001b
            r1 = 48
            goto L_0x001d
        L_0x001b:
            r1 = 44
        L_0x001d:
            r2 = 1
            if (r1 == r0) goto L_0x0021
            goto L_0x007a
        L_0x0021:
            int r0 = f585
            r1 = r0 ^ 63
            r3 = r0 & 63
            r1 = r1 | r3
            int r1 = r1 << r2
            r3 = r0 & -64
            int r0 = ~r0
            r0 = r0 & 63
            r0 = r0 | r3
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r0 = r1 % 128
            f586 = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 != 0) goto L_0x003e
            r1 = 1
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            if (r1 == 0) goto L_0x004b
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L_0x0048
            r0 = 1
        L_0x0048:
            if (r0 == 0) goto L_0x005e
            goto L_0x007a
        L_0x004b:
            boolean r0 = r4.isEmpty()
            r1 = 0
            super.hashCode()     // Catch:{ all -> 0x008e }
            r1 = 54
            if (r0 == 0) goto L_0x005a
            r0 = 54
            goto L_0x005c
        L_0x005a:
            r0 = 84
        L_0x005c:
            if (r0 == r1) goto L_0x007a
        L_0x005e:
            boolean r4 = m688(r4)
            int r0 = f586
            r1 = r0 ^ 117(0x75, float:1.64E-43)
            r3 = r0 & 117(0x75, float:1.64E-43)
            r1 = r1 | r3
            int r1 = r1 << r2
            int r2 = ~r3
            r0 = r0 | 117(0x75, float:1.64E-43)
            r0 = r0 & r2
            int r0 = -r0
            r2 = r1 & r0
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f585 = r0
            int r2 = r2 % 2
            return r4
        L_0x007a:
            int r4 = f586
            int r4 = r4 + 104
            int r4 = r4 - r2
            int r0 = r4 % 128
            f585 = r0
            int r4 = r4 % 2
            r0 = 58
            if (r4 == 0) goto L_0x008b
            r4 = 6
            goto L_0x008d
        L_0x008b:
            r4 = 58
        L_0x008d:
            return r2
        L_0x008e:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.GetVisaCertificate.isCertificateApiCallNeeded(android.content.Context):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0076, code lost:
        if ((r3.longValue() == 0) != false) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
        if ((r3.longValue() == 1 ? '^' : '+') != '+') goto L_0x00ad;
     */
    /* renamed from: ˋ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m688(java.util.ArrayList<net.one97.paytm.payments.visascp.network.model.VisaCertificateData> r12) {
        /*
            int r0 = f586
            r1 = r0 & 81
            r0 = r0 ^ 81
            r0 = r0 | r1
            int r0 = ~r0
            int r1 = r1 - r0
            r0 = 1
            int r1 = r1 - r0
            int r2 = r1 % 128
            f585 = r2
            int r1 = r1 % 2
            r1 = 0
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            java.util.Iterator r12 = r12.iterator()
            int r4 = f585
            r5 = r4 ^ 49
            r6 = r4 & 49
            r5 = r5 | r6
            int r5 = r5 << r0
            int r6 = ~r6
            r4 = r4 | 49
            r4 = r4 & r6
            int r4 = -r4
            r6 = r5 & r4
            r4 = r4 | r5
            int r6 = r6 + r4
            int r4 = r6 % 128
            f586 = r4
            int r6 = r6 % 2
            r4 = 79
            if (r6 != 0) goto L_0x0039
            r5 = 46
            goto L_0x003b
        L_0x0039:
            r5 = 79
        L_0x003b:
            boolean r4 = r12.hasNext()
            r5 = 0
            if (r4 != 0) goto L_0x0044
            r4 = 1
            goto L_0x0045
        L_0x0044:
            r4 = 0
        L_0x0045:
            if (r4 == r0) goto L_0x00d8
            int r4 = f585
            r6 = r4 | 61
            int r6 = r6 << r0
            r7 = r4 & -62
            int r4 = ~r4
            r4 = r4 & 61
            r4 = r4 | r7
            int r4 = -r4
            r7 = r6 | r4
            int r7 = r7 << r0
            r4 = r4 ^ r6
            int r7 = r7 - r4
            int r4 = r7 % 128
            f586 = r4
            int r7 = r7 % 2
            if (r7 != 0) goto L_0x0062
            r4 = 1
            goto L_0x0063
        L_0x0062:
            r4 = 0
        L_0x0063:
            if (r4 == 0) goto L_0x0079
            java.lang.Object r4 = r12.next()
            net.one97.paytm.payments.visascp.network.model.VisaCertificateData r4 = (net.one97.paytm.payments.visascp.network.model.VisaCertificateData) r4
            long r6 = r3.longValue()
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x0075
            r6 = 1
            goto L_0x0076
        L_0x0075:
            r6 = 0
        L_0x0076:
            if (r6 == 0) goto L_0x0093
            goto L_0x00ad
        L_0x0079:
            java.lang.Object r4 = r12.next()
            net.one97.paytm.payments.visascp.network.model.VisaCertificateData r4 = (net.one97.paytm.payments.visascp.network.model.VisaCertificateData) r4
            long r6 = r3.longValue()
            r8 = 1
            r10 = 43
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 != 0) goto L_0x008e
            r6 = 94
            goto L_0x0090
        L_0x008e:
            r6 = 43
        L_0x0090:
            if (r6 == r10) goto L_0x0093
            goto L_0x00ad
        L_0x0093:
            long r6 = r3.longValue()
            java.lang.Long r8 = r4.getEndDate()
            long r8 = r8.longValue()
            r10 = 25
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 > 0) goto L_0x00a8
            r6 = 71
            goto L_0x00aa
        L_0x00a8:
            r6 = 25
        L_0x00aa:
            if (r6 == r10) goto L_0x00ad
            goto L_0x00c3
        L_0x00ad:
            java.lang.Long r3 = r4.getEndDate()
            int r4 = f586
            r6 = r4 ^ 17
            r4 = r4 & 17
            int r4 = r4 << r0
            int r6 = r6 + r4
            int r4 = r6 % 128
            f585 = r4
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x00c2
            goto L_0x00c3
        L_0x00c2:
            r5 = 1
        L_0x00c3:
            int r4 = f586
            r5 = r4 ^ 14
            r4 = r4 & 14
            int r4 = r4 << r0
            int r5 = r5 + r4
            r4 = r5 | -1
            int r4 = r4 << r0
            int r5 = ~r5
            int r4 = r4 - r5
            int r5 = r4 % 128
            f585 = r5
            int r4 = r4 % 2
            goto L_0x003b
        L_0x00d8:
            boolean r12 = m689(r3)
            int r1 = f586
            r2 = r1 ^ 115(0x73, float:1.61E-43)
            r1 = r1 & 115(0x73, float:1.61E-43)
            r1 = r1 | r2
            int r1 = r1 << r0
            int r2 = -r2
            int r2 = ~r2
            int r1 = r1 - r2
            int r1 = r1 - r0
            int r2 = r1 % 128
            f585 = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x00f1
            r0 = 0
        L_0x00f1:
            if (r0 == 0) goto L_0x00f3
        L_0x00f3:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.GetVisaCertificate.m688(java.util.ArrayList):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        if ((r0.longValue() >= r9.longValue()) != true) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if ((r0.longValue() < r9.longValue() ? 4 : '<') != 4) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0081, code lost:
        if (java.util.concurrent.TimeUnit.DAYS.convert(r9.longValue() - r0.longValue(), java.util.concurrent.TimeUnit.SECONDS) <= ((long) net.one97.paytm.payments.visascp.util.VisaSCPConstants.NO_OF_DAYS)) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0083, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0085, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        if (r9 == false) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        r9 = f585;
        r0 = (((r9 & -10) | ((~r9) & 9)) - (~((r9 & 9) << 1))) - 1;
        f586 = r0 % 128;
        r0 = r0 % 2;
        r9 = f585;
        r0 = r9 & 9;
        r9 = ((r9 | 9) & (~r0)) + (r0 << 1);
        f586 = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ac, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ad, code lost:
        r9 = (f585 + 73) - 1;
        r0 = (~r9) + ((r9 & -1) << 1);
        f586 = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bd, code lost:
        if ((r0 % 2) != 0) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bf, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c1, code lost:
        r9 = '5';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c3, code lost:
        if (r9 == 0) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c5, code lost:
        return false;
     */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m689(java.lang.Long r9) {
        /*
            int r0 = f586
            r1 = r0 & 46
            r0 = r0 | 46
            int r1 = r1 + r0
            r0 = r1 | -1
            r2 = 1
            int r0 = r0 << r2
            int r1 = ~r1
            int r0 = r0 - r1
            int r1 = r0 % 128
            f585 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L_0x0018
            r0 = 0
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            r3 = 1000(0x3e8, double:4.94E-321)
            if (r0 == r2) goto L_0x0038
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 / r3
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            long r3 = r0.longValue()
            long r5 = r9.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0034
            r3 = 0
            goto L_0x0035
        L_0x0034:
            r3 = 1
        L_0x0035:
            if (r3 == r2) goto L_0x0054
            goto L_0x006b
        L_0x0038:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 % r3
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            long r3 = r0.longValue()
            long r5 = r9.longValue()
            r7 = 4
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x0050
            r3 = 4
            goto L_0x0052
        L_0x0050:
            r3 = 60
        L_0x0052:
            if (r3 == r7) goto L_0x006b
        L_0x0054:
            int r9 = f586
            r0 = r9 & -104(0xffffffffffffff98, float:NaN)
            int r1 = ~r9
            r1 = r1 & 103(0x67, float:1.44E-43)
            r0 = r0 | r1
            r9 = r9 & 103(0x67, float:1.44E-43)
            int r9 = r9 << r2
            r1 = r0 ^ r9
            r9 = r9 & r0
            int r9 = r9 << r2
            int r1 = r1 + r9
            int r9 = r1 % 128
            f585 = r9
            int r1 = r1 % 2
            return r2
        L_0x006b:
            long r3 = r9.longValue()
            long r5 = r0.longValue()
            long r3 = r3 - r5
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.DAYS
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            long r3 = r9.convert(r3, r0)
            int r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.NO_OF_DAYS
            long r5 = (long) r9
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x0085
            r9 = 0
            goto L_0x0086
        L_0x0085:
            r9 = 1
        L_0x0086:
            if (r9 == 0) goto L_0x00ad
            int r9 = f585
            r0 = r9 & -10
            int r1 = ~r9
            r1 = r1 & 9
            r0 = r0 | r1
            r9 = r9 & 9
            int r9 = r9 << r2
            int r9 = ~r9
            int r0 = r0 - r9
            int r0 = r0 - r2
            int r9 = r0 % 128
            f586 = r9
            int r0 = r0 % 2
            int r9 = f585
            r0 = r9 & 9
            int r1 = ~r0
            r9 = r9 | 9
            r9 = r9 & r1
            int r0 = r0 << r2
            int r9 = r9 + r0
            int r0 = r9 % 128
            f586 = r0
            int r9 = r9 % 2
            return r2
        L_0x00ad:
            int r9 = f585
            int r9 = r9 + 73
            int r9 = r9 - r2
            int r0 = ~r9
            r9 = r9 & -1
            int r9 = r9 << r2
            int r0 = r0 + r9
            int r9 = r0 % 128
            f586 = r9
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x00c1
            r9 = 0
            goto L_0x00c3
        L_0x00c1:
            r9 = 53
        L_0x00c3:
            if (r9 == 0) goto L_0x00c5
        L_0x00c5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.GetVisaCertificate.m689(java.lang.Long):boolean");
    }
}
