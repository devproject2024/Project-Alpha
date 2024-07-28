package com.alipay.imobile.network.quake.d.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.a.a.a;
import com.alipay.imobile.network.quake.c;
import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {

    /* renamed from: g  reason: collision with root package name */
    private static b f14759g;

    /* renamed from: a  reason: collision with root package name */
    final Context f14760a;

    /* renamed from: b  reason: collision with root package name */
    final Object f14761b = new Object();

    /* renamed from: c  reason: collision with root package name */
    String f14762c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f14763d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public String f14764e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f14765f = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", AppConstants.FEED_COMMUNITY, UpiConstants.DEFAULT_ACCOUNT_CONSTANT, "E", AppConstants.FEED_SUB_TYPE, "G", "H", AppConstants.IMAGE_SUBTYPE, "J", AppConstants.THOUSANDS, "L", "M", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, "O", AppConstants.FEED_COMMUNITY_POST, "Q", "R", "S", "T", AppConstants.USER_SUB_TYPE, "V", AppConstants.CAROUSEL_SUB_TYPE, "X", "Y", "Z"};

    /* renamed from: h  reason: collision with root package name */
    private String f14766h;

    /* renamed from: i  reason: collision with root package name */
    private final SimpleDateFormat f14767i = new SimpleDateFormat("yyMMddHHmmssSSS");

    private b(Context context) {
        this.f14760a = context.getApplicationContext();
    }

    private String a(String str, String str2) {
        return d(str) + "|" + d(str2);
    }

    private static boolean a(String str) {
        if (b(str)) {
            return false;
        }
        String trim = str.trim();
        return !trim.equalsIgnoreCase(SDKConstants.UNKNOWN) && !trim.equalsIgnoreCase("null") && !trim.matches("[0]+") && trim.length() > 5;
    }

    private String b() {
        Random random = new Random(System.currentTimeMillis());
        int length = this.f14765f.length;
        String str = "";
        for (int i2 = 0; i2 < 10; i2++) {
            str = str + this.f14765f[random.nextInt(length)];
        }
        return str;
    }

    private static boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }

    private String d() {
        return this.f14767i.format(Long.valueOf(System.currentTimeMillis()));
    }

    private String d(String str) {
        if (!a(str)) {
            str = d();
        }
        return c((str + "123456789012345").substring(0, 15));
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r2.f14763d
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x001c
            java.lang.Object r0 = r2.f14761b
            monitor-enter(r0)
            java.lang.Object r1 = r2.f14761b     // Catch:{ InterruptedException -> 0x0013 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0013 }
            goto L_0x0018
        L_0x0011:
            r1 = move-exception
            goto L_0x001a
        L_0x0013:
            java.lang.String r1 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0011 }
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x0011 }
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            goto L_0x001c
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1
        L_0x001c:
            java.lang.String r0 = r2.f14762c
            if (r0 == 0) goto L_0x002c
            java.lang.String r1 = ""
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0029
            goto L_0x002c
        L_0x0029:
            java.lang.String r0 = r2.f14762c
            return r0
        L_0x002c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r2.f14764e
            r0.append(r1)
            java.lang.String r1 = "|"
            r0.append(r1)
            java.lang.String r1 = r2.f14766h
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.d.a.b.a():java.lang.String");
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f14759g == null) {
                b bVar2 = new b(context);
                f14759g = bVar2;
                bVar2.f14764e = bVar2.c();
                Context context2 = bVar2.f14760a;
                SharedPreferences sharedPreferences = context2.getSharedPreferences(bVar2.f14760a.getPackageName() + ".quake.config", 0);
                String string = sharedPreferences.getString("clientKey", "");
                if ("".equals(string)) {
                    string = bVar2.b();
                    sharedPreferences.edit().putString("clientKey", string).apply();
                }
                bVar2.f14766h = string;
                try {
                    if (Class.forName("com.a.a.a") != null) {
                        new Thread(new Runnable() {
                            public final void run() {
                                b.this.f14763d.set(true);
                                String str = c.f14737a;
                                com.alipay.iap.android.common.b.c.b();
                                b bVar = b.this;
                                bVar.f14762c = a.a(bVar.f14760a);
                                String str2 = c.f14737a;
                                com.alipay.iap.android.common.b.c.b();
                                b.this.f14763d.set(false);
                                synchronized (b.this.f14761b) {
                                    b.this.f14761b.notifyAll();
                                }
                            }
                        }, "generateUtDid").start();
                    }
                } catch (ClassNotFoundException e2) {
                    String str = c.f14737a;
                    e2.getMessage();
                    com.alipay.iap.android.common.b.c.e();
                }
            }
            bVar = f14759g;
        }
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c() {
        /*
            r15 = this;
            android.content.Context r0 = r15.f14760a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = r15.f14760a
            java.lang.String r2 = r2.getPackageName()
            r1.append(r2)
            java.lang.String r2 = ".quake.config"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            android.content.SharedPreferences$Editor r1 = r0.edit()
            r3 = 2
            r4 = 1
            r5 = 0
            java.lang.String r6 = "androidx.core.content.c"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x004f }
            if (r6 == 0) goto L_0x0050
            java.lang.String r7 = "checkSelfPermission"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x004f }
            java.lang.Class<android.content.Context> r9 = android.content.Context.class
            r8[r2] = r9     // Catch:{ Exception -> 0x004f }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r8[r4] = r9     // Catch:{ Exception -> 0x004f }
            java.lang.reflect.Method r7 = r6.getMethod(r7, r8)     // Catch:{ Exception -> 0x004f }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x004f }
            android.content.Context r9 = r15.f14760a     // Catch:{ Exception -> 0x004f }
            r8[r2] = r9     // Catch:{ Exception -> 0x004f }
            java.lang.String r9 = "android.permission.READ_PHONE_STATE"
            r8[r4] = r9     // Catch:{ Exception -> 0x004f }
            java.lang.Object r6 = r7.invoke(r6, r8)     // Catch:{ Exception -> 0x004f }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x004f }
            r5 = r6
            goto L_0x0050
        L_0x004f:
        L_0x0050:
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0063
            int r5 = r5.intValue()
            r7 = -1
            if (r5 != r7) goto L_0x0063
            java.lang.String r5 = com.alipay.imobile.network.quake.c.f14737a
            com.alipay.iap.android.common.b.c.c()
            r5 = r6
            r7 = r5
            goto L_0x007d
        L_0x0063:
            android.content.Context r5 = r15.f14760a
            java.lang.String r7 = "phone"
            java.lang.Object r5 = r5.getSystemService(r7)
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5
            java.lang.String r7 = r5.getDeviceId()     // Catch:{ Exception -> 0x0076 }
            java.lang.String r5 = r5.getSubscriberId()     // Catch:{ Exception -> 0x0077 }
            goto L_0x007d
        L_0x0076:
            r7 = r6
        L_0x0077:
            java.lang.String r5 = com.alipay.imobile.network.quake.c.f14737a
            com.alipay.iap.android.common.b.c.f()
            r5 = r6
        L_0x007d:
            java.lang.String r8 = "clientId"
            java.lang.String r0 = r0.getString(r8, r6)
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r9 = "saved clientid:"
            r9.concat(r6)
            com.alipay.iap.android.common.b.c.e()
            boolean r6 = b(r0)
            if (r6 != 0) goto L_0x00a1
            java.lang.String r6 = "[[a-z][A-Z][0-9]]{15}\\|[[a-z][A-Z][0-9]]{15}"
            boolean r6 = r0.matches(r6)
            if (r6 == 0) goto L_0x00a1
            r6 = 1
            goto L_0x00a2
        L_0x00a1:
            r6 = 0
        L_0x00a2:
            r9 = 3
            java.lang.String r10 = "normalize, imei:%s, imsi:%s, newClientId:%s"
            if (r6 == 0) goto L_0x0126
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r11 = "client id is valid:"
            r11.concat(r6)
            com.alipay.iap.android.common.b.c.e()
            r6 = 15
            java.lang.String r12 = r0.substring(r2, r6)
            boolean r13 = a((java.lang.String) r5)
            if (r13 == 0) goto L_0x00d6
            java.lang.String r13 = c(r5)
            int r14 = r13.length()
            if (r14 <= r6) goto L_0x00cf
            java.lang.String r13 = r13.substring(r2, r6)
        L_0x00cf:
            boolean r13 = r12.startsWith(r13)
            if (r13 != 0) goto L_0x00d6
            r12 = r5
        L_0x00d6:
            int r13 = r0.length()
            int r13 = r13 - r6
            int r14 = r0.length()
            java.lang.String r0 = r0.substring(r13, r14)
            boolean r13 = a((java.lang.String) r7)
            if (r13 == 0) goto L_0x00fe
            java.lang.String r13 = c(r7)
            int r14 = r13.length()
            if (r14 <= r6) goto L_0x00f7
            java.lang.String r13 = r13.substring(r2, r6)
        L_0x00f7:
            boolean r6 = r0.startsWith(r13)
            if (r6 != 0) goto L_0x00fe
            r0 = r7
        L_0x00fe:
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r11)
            r6.append(r12)
            java.lang.String r11 = "|"
            r6.append(r11)
            r6.append(r0)
            com.alipay.iap.android.common.b.c.e()
            java.lang.String r0 = r15.a(r12, r0)
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.Object[] r6 = new java.lang.Object[r9]
            r6[r2] = r7
            r6[r4] = r5
            r6[r3] = r0
            com.alipay.iap.android.common.b.c.a(r10, r6)
            goto L_0x015b
        L_0x0126:
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r2] = r7
            r0[r4] = r5
            java.lang.String r6 = "client is is not valid, imei:%s, imsi:%s"
            com.alipay.iap.android.common.b.c.a(r6, r0)
            com.alipay.iap.android.common.b.c.e()
            boolean r0 = a((java.lang.String) r7)
            if (r0 != 0) goto L_0x0140
            java.lang.String r7 = r15.d()
        L_0x0140:
            boolean r0 = a((java.lang.String) r5)
            if (r0 != 0) goto L_0x014a
            java.lang.String r5 = r15.d()
        L_0x014a:
            java.lang.String r0 = r15.a(r5, r7)
            java.lang.String r6 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.Object[] r6 = new java.lang.Object[r9]
            r6[r2] = r7
            r6[r4] = r5
            r6[r3] = r0
            com.alipay.iap.android.common.b.c.a(r10, r6)
        L_0x015b:
            com.alipay.iap.android.common.b.c.e()
            r1.putString(r8, r0)
            r1.apply()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.d.a.b.c():java.lang.String");
    }

    private static String c(String str) {
        if (b(str)) {
            return str;
        }
        byte[] bytes = str.getBytes();
        for (int i2 = 0; i2 < bytes.length; i2++) {
            byte b2 = bytes[i2];
            if (!((b2 >= 48 && b2 <= 57) || (b2 >= 97 && b2 <= 122) || (b2 >= 65 && b2 <= 90))) {
                bytes[i2] = TarHeader.LF_NORMAL;
            }
        }
        return new String(bytes);
    }
}
