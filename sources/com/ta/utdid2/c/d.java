package com.ta.utdid2.c;

import android.content.Context;
import android.provider.Settings;
import com.business.merchant_payments.utility.StringUtility;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.e;
import com.ta.utdid2.b.a.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class d {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f16160b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static d f16161c = null;
    private static final String j = (".UTSystemConfig" + File.separator + "Global");

    /* renamed from: a  reason: collision with root package name */
    private Context f16162a = null;

    /* renamed from: d  reason: collision with root package name */
    private String f16163d = null;

    /* renamed from: e  reason: collision with root package name */
    private e f16164e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f16165f = "xx_utdid_key";

    /* renamed from: g  reason: collision with root package name */
    private String f16166g = "xx_utdid_domain";

    /* renamed from: h  reason: collision with root package name */
    private c f16167h = null;

    /* renamed from: i  reason: collision with root package name */
    private c f16168i = null;
    private Pattern k = Pattern.compile("[^0-9a-zA-Z=/+]+");

    private d(Context context) {
        this.f16162a = context;
        this.f16168i = new c(context, j, "Alvin2");
        this.f16167h = new c(context, ".DataStorage", "ContextData");
        this.f16164e = new e();
        this.f16165f = String.format("K_%d", new Object[]{Integer.valueOf(e.b(this.f16165f))});
        this.f16166g = String.format("D_%d", new Object[]{Integer.valueOf(e.b(this.f16166g))});
    }

    public static d a(Context context) {
        if (context != null && f16161c == null) {
            synchronized (f16160b) {
                if (f16161c == null) {
                    d dVar = new d(context);
                    f16161c = dVar;
                    if (dVar.f16168i != null) {
                        if (e.a(dVar.f16168i.b("UTDID2"))) {
                            String b2 = dVar.f16168i.b("UTDID");
                            if (!e.a(b2)) {
                                dVar.a(b2);
                            }
                        }
                        boolean z = false;
                        if (!e.a(dVar.f16168i.b("DID"))) {
                            dVar.f16168i.a("DID");
                            z = true;
                        }
                        if (!e.a(dVar.f16168i.b("EI"))) {
                            dVar.f16168i.a("EI");
                            z = true;
                        }
                        if (!e.a(dVar.f16168i.b("SI"))) {
                            dVar.f16168i.a("SI");
                            z = true;
                        }
                        if (z) {
                            dVar.f16168i.a();
                        }
                    }
                }
            }
        }
        return f16161c;
    }

    private void a(String str) {
        c cVar;
        if (e(str)) {
            if (str.endsWith(StringUtility.NEW_LINE)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && (cVar = this.f16168i) != null) {
                cVar.a("UTDID2", str);
                this.f16168i.a();
            }
        }
    }

    private void b(String str) {
        c cVar;
        if (str != null && (cVar = this.f16167h) != null && !str.equals(cVar.b(this.f16165f))) {
            this.f16167h.a(this.f16165f, str);
            this.f16167h.a();
        }
    }

    private void c(String str) {
        if (this.f16162a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && e(str)) {
            if (str.endsWith(StringUtility.NEW_LINE)) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = Settings.System.getString(this.f16162a.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (!e(str2)) {
                    try {
                        Settings.System.putString(this.f16162a.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    private void d(String str) {
        if (this.f16162a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && str != null) {
            String str2 = null;
            try {
                str2 = Settings.System.getString(this.f16162a.getContentResolver(), "dxCRMxhQkdGePGnp");
            } catch (Exception unused) {
            }
            if (!str.equals(str2)) {
                try {
                    Settings.System.putString(this.f16162a.getContentResolver(), "dxCRMxhQkdGePGnp", str);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private boolean e(String str) {
        if (str != null) {
            if (str.endsWith(StringUtility.NEW_LINE)) {
                str = str.substring(0, str.length() - 1);
            }
            return 24 == str.length() && !this.k.matcher(str).find();
        }
    }

    public final synchronized String a() {
        if (this.f16163d != null) {
            return this.f16163d;
        }
        return b();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072 A[Catch:{ Exception -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a6 A[Catch:{ Exception -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bb A[SYNTHETIC, Splitter:B:56:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[SYNTHETIC, Splitter:B:9:0x0017] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String b() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = ""
            android.content.Context r1 = r6.f16162a     // Catch:{ Exception -> 0x000f }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Exception -> 0x000f }
            java.lang.String r2 = "mqBRboGZkQPcAkyk"
            java.lang.String r0 = android.provider.Settings.System.getString(r1, r2)     // Catch:{ Exception -> 0x000f }
        L_0x000f:
            boolean r1 = r6.e(r0)     // Catch:{ all -> 0x012d }
            if (r1 == 0) goto L_0x0017
            monitor-exit(r6)
            return r0
        L_0x0017:
            com.ta.utdid2.c.f r0 = new com.ta.utdid2.c.f     // Catch:{ all -> 0x012d }
            r0.<init>()     // Catch:{ all -> 0x012d }
            r1 = 0
            r2 = 0
            android.content.Context r3 = r6.f16162a     // Catch:{ Exception -> 0x002b }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ Exception -> 0x002b }
            java.lang.String r4 = "dxCRMxhQkdGePGnp"
            java.lang.String r3 = android.provider.Settings.System.getString(r3, r4)     // Catch:{ Exception -> 0x002b }
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            boolean r4 = com.ta.utdid2.a.a.e.a(r3)     // Catch:{ all -> 0x012d }
            if (r4 != 0) goto L_0x0083
            java.lang.String r4 = r0.b(r3)     // Catch:{ all -> 0x012d }
            boolean r5 = r6.e(r4)     // Catch:{ all -> 0x012d }
            if (r5 == 0) goto L_0x0041
            r6.c(r4)     // Catch:{ all -> 0x012d }
            monitor-exit(r6)
            return r4
        L_0x0041:
            java.lang.String r4 = r0.a(r3)     // Catch:{ all -> 0x012d }
            boolean r5 = r6.e(r4)     // Catch:{ all -> 0x012d }
            if (r5 == 0) goto L_0x0066
            com.ta.utdid2.c.e r5 = r6.f16164e     // Catch:{ all -> 0x012d }
            java.lang.String r4 = r5.a(r4)     // Catch:{ all -> 0x012d }
            boolean r5 = com.ta.utdid2.a.a.e.a(r4)     // Catch:{ all -> 0x012d }
            if (r5 != 0) goto L_0x0066
            r6.d(r4)     // Catch:{ all -> 0x012d }
            android.content.Context r4 = r6.f16162a     // Catch:{ Exception -> 0x0066 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r5 = "dxCRMxhQkdGePGnp"
            java.lang.String r3 = android.provider.Settings.System.getString(r4, r5)     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            com.ta.utdid2.c.e r4 = r6.f16164e     // Catch:{ all -> 0x012d }
            java.lang.String r4 = r4.b(r3)     // Catch:{ all -> 0x012d }
            boolean r5 = r6.e(r4)     // Catch:{ all -> 0x012d }
            if (r5 == 0) goto L_0x0084
            r6.f16163d = r4     // Catch:{ all -> 0x012d }
            r6.a((java.lang.String) r4)     // Catch:{ all -> 0x012d }
            r6.b(r3)     // Catch:{ all -> 0x012d }
            java.lang.String r0 = r6.f16163d     // Catch:{ all -> 0x012d }
            r6.c(r0)     // Catch:{ all -> 0x012d }
            java.lang.String r0 = r6.f16163d     // Catch:{ all -> 0x012d }
            monitor-exit(r6)
            return r0
        L_0x0083:
            r1 = 1
        L_0x0084:
            com.ta.utdid2.b.a.c r3 = r6.f16168i     // Catch:{ all -> 0x012d }
            if (r3 == 0) goto L_0x009f
            com.ta.utdid2.b.a.c r3 = r6.f16168i     // Catch:{ all -> 0x012d }
            java.lang.String r4 = "UTDID2"
            java.lang.String r3 = r3.b(r4)     // Catch:{ all -> 0x012d }
            boolean r4 = com.ta.utdid2.a.a.e.a(r3)     // Catch:{ all -> 0x012d }
            if (r4 != 0) goto L_0x009f
            com.ta.utdid2.c.e r4 = r6.f16164e     // Catch:{ all -> 0x012d }
            java.lang.String r4 = r4.a(r3)     // Catch:{ all -> 0x012d }
            if (r4 == 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r3 = r2
        L_0x00a0:
            boolean r4 = r6.e(r3)     // Catch:{ all -> 0x012d }
            if (r4 == 0) goto L_0x00bb
            com.ta.utdid2.c.e r0 = r6.f16164e     // Catch:{ all -> 0x012d }
            java.lang.String r0 = r0.a(r3)     // Catch:{ all -> 0x012d }
            if (r1 == 0) goto L_0x00b1
            r6.d(r0)     // Catch:{ all -> 0x012d }
        L_0x00b1:
            r6.c(r3)     // Catch:{ all -> 0x012d }
            r6.b(r0)     // Catch:{ all -> 0x012d }
            r6.f16163d = r3     // Catch:{ all -> 0x012d }
            monitor-exit(r6)
            return r3
        L_0x00bb:
            com.ta.utdid2.b.a.c r3 = r6.f16167h     // Catch:{ all -> 0x012d }
            java.lang.String r4 = r6.f16165f     // Catch:{ all -> 0x012d }
            java.lang.String r3 = r3.b(r4)     // Catch:{ all -> 0x012d }
            boolean r4 = com.ta.utdid2.a.a.e.a(r3)     // Catch:{ all -> 0x012d }
            if (r4 != 0) goto L_0x00fb
            java.lang.String r0 = r0.a(r3)     // Catch:{ all -> 0x012d }
            boolean r4 = r6.e(r0)     // Catch:{ all -> 0x012d }
            if (r4 != 0) goto L_0x00d9
            com.ta.utdid2.c.e r0 = r6.f16164e     // Catch:{ all -> 0x012d }
            java.lang.String r0 = r0.b(r3)     // Catch:{ all -> 0x012d }
        L_0x00d9:
            boolean r3 = r6.e(r0)     // Catch:{ all -> 0x012d }
            if (r3 == 0) goto L_0x00fb
            com.ta.utdid2.c.e r3 = r6.f16164e     // Catch:{ all -> 0x012d }
            java.lang.String r3 = r3.a(r0)     // Catch:{ all -> 0x012d }
            boolean r4 = com.ta.utdid2.a.a.e.a(r0)     // Catch:{ all -> 0x012d }
            if (r4 != 0) goto L_0x00fb
            r6.f16163d = r0     // Catch:{ all -> 0x012d }
            if (r1 == 0) goto L_0x00f2
            r6.d(r3)     // Catch:{ all -> 0x012d }
        L_0x00f2:
            java.lang.String r0 = r6.f16163d     // Catch:{ all -> 0x012d }
            r6.a((java.lang.String) r0)     // Catch:{ all -> 0x012d }
            java.lang.String r0 = r6.f16163d     // Catch:{ all -> 0x012d }
            monitor-exit(r6)
            return r0
        L_0x00fb:
            byte[] r0 = r6.c()     // Catch:{ Exception -> 0x0127 }
            if (r0 == 0) goto L_0x012b
            r3 = 2
            java.lang.String r4 = com.ta.utdid2.a.a.b.a(r0, r3)     // Catch:{ Exception -> 0x0127 }
            r6.f16163d = r4     // Catch:{ Exception -> 0x0127 }
            java.lang.String r4 = r6.f16163d     // Catch:{ Exception -> 0x0127 }
            r6.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0127 }
            com.ta.utdid2.c.e r4 = r6.f16164e     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = com.ta.utdid2.a.a.b.a(r0, r3)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = r4.f16170a     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = com.ta.utdid2.a.a.a.a(r3, r0)     // Catch:{ Exception -> 0x0127 }
            if (r0 == 0) goto L_0x0123
            if (r1 == 0) goto L_0x0120
            r6.d(r0)     // Catch:{ Exception -> 0x0127 }
        L_0x0120:
            r6.b(r0)     // Catch:{ Exception -> 0x0127 }
        L_0x0123:
            java.lang.String r0 = r6.f16163d     // Catch:{ Exception -> 0x0127 }
            monitor-exit(r6)
            return r0
        L_0x0127:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x012d }
        L_0x012b:
            monitor-exit(r6)
            return r2
        L_0x012d:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.c.d.b():java.lang.String");
    }

    private final byte[] c() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a2 = com.ta.utdid2.a.a.c.a(currentTimeMillis);
        byte[] a3 = com.ta.utdid2.a.a.c.a(nextInt);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(a3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = com.ta.utdid2.a.a.d.a(this.f16162a);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(new Random().nextInt());
            str = sb.toString();
        }
        byteArrayOutputStream.write(com.ta.utdid2.a.a.c.a(e.b(str)), 0, 4);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), instance.getAlgorithm()));
        byteArrayOutputStream.write(com.ta.utdid2.a.a.c.a(e.b(b.a(instance.doFinal(byteArray), 2))));
        return byteArrayOutputStream.toByteArray();
    }
}
