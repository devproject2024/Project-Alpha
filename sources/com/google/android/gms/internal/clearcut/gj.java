package com.google.android.gms.internal.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.common.c.c;
import com.google.android.gms.internal.clearcut.fv;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import net.one97.paytm.upi.util.UpiContract;

public final class gj implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f9395a = Charset.forName(AppConstants.UTF_8);

    /* renamed from: b  reason: collision with root package name */
    private static final n f9396b = new n(com.google.android.gms.phenotype.a.a("com.google.android.gms.clearcut.public")).a("gms:playlog:service:samplingrules_").b("LogSamplingRules__");

    /* renamed from: c  reason: collision with root package name */
    private static final n f9397c = new n(com.google.android.gms.phenotype.a.a("com.google.android.gms.clearcut.public")).a("gms:playlog:service:sampling_").b("LogSampling__");

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap<String, e<fv.a>> f9398e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, e<String>> f9399f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f9400g = null;

    /* renamed from: h  reason: collision with root package name */
    private static Long f9401h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final e<Boolean> f9402i = e.a(f9396b, "enable_log_sampling_rules");

    /* renamed from: d  reason: collision with root package name */
    private final Context f9403d;

    public gj(Context context) {
        this.f9403d = context;
        Context context2 = this.f9403d;
        if (context2 != null) {
            e.a(context2);
        }
    }

    private static long a(String str, long j) {
        if (str == null || str.isEmpty()) {
            return ge.a(ByteBuffer.allocate(8).putLong(j).array());
        }
        byte[] bytes = str.getBytes(f9395a);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return ge.a(allocate.array());
    }

    private static fv.a.b a(String str) {
        String str2;
        int i2;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i2 = indexOf + 1;
        } else {
            str2 = "";
            i2 = 0;
        }
        int indexOf2 = str.indexOf(47, i2);
        if (indexOf2 <= 0) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Failed to parse the rule: ".concat(valueOf);
            } else {
                new String("Failed to parse the rule: ");
            }
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i2, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return (fv.a.b) fv.a.b.a().a(str2).a(parseLong).b(parseLong2).e();
            }
            StringBuilder sb = new StringBuilder(72);
            sb.append("negative values not supported: ");
            sb.append(parseLong);
            sb.append("/");
            sb.append(parseLong2);
            return null;
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                "parseLong() failed while parsing: ".concat(valueOf2);
            } else {
                new String("parseLong() failed while parsing: ");
            }
            return null;
        }
    }

    private static boolean a(long j, long j2, long j3) {
        if (j2 < 0 || j3 <= 0) {
            return true;
        }
        return ((j > 0 ? 1 : (j == 0 ? 0 : -1)) >= 0 ? j % j3 : (((Long.MAX_VALUE % j3) + 1) + ((j & Long.MAX_VALUE) % j3)) % j3) < j2;
    }

    private static boolean a(Context context) {
        if (f9400g == null) {
            f9400g = Boolean.valueOf(c.a(context).a("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return f9400g.booleanValue();
    }

    private static long b(Context context) {
        if (f9401h == null) {
            long j = 0;
            if (context == null) {
                return 0;
            }
            if (a(context)) {
                j = gr.b(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
            }
            f9401h = Long.valueOf(j);
        }
        return f9401h.longValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009e, code lost:
        r1 = com.google.android.gms.internal.clearcut.e.a(f9396b, r0, com.google.android.gms.internal.clearcut.fv.a.a(), com.google.android.gms.internal.clearcut.gk.f9404a);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.android.gms.clearcut.zze r15) {
        /*
            r14 = this;
            com.google.android.gms.internal.clearcut.zzr r0 = r15.f8319a
            java.lang.String r0 = r0.f9440b
            com.google.android.gms.internal.clearcut.zzr r1 = r15.f8319a
            int r1 = r1.f9439a
            com.google.android.gms.internal.clearcut.ga r2 = r15.f8321c
            r3 = 0
            if (r2 == 0) goto L_0x0012
            com.google.android.gms.internal.clearcut.ga r15 = r15.f8321c
            int r15 = r15.f9386e
            goto L_0x0013
        L_0x0012:
            r15 = 0
        L_0x0013:
            com.google.android.gms.internal.clearcut.e<java.lang.Boolean> r2 = f9402i
            java.lang.Object r2 = r2.a()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x0078
            if (r0 == 0) goto L_0x002c
            boolean r15 = r0.isEmpty()
            if (r15 != 0) goto L_0x002c
            goto L_0x0034
        L_0x002c:
            if (r1 < 0) goto L_0x0033
            java.lang.String r0 = java.lang.String.valueOf(r1)
            goto L_0x0034
        L_0x0033:
            r0 = r4
        L_0x0034:
            if (r0 == 0) goto L_0x00f6
            android.content.Context r15 = r14.f9403d
            if (r15 == 0) goto L_0x005d
            boolean r15 = a((android.content.Context) r15)
            if (r15 != 0) goto L_0x0041
            goto L_0x005d
        L_0x0041:
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.clearcut.e<java.lang.String>> r15 = f9399f
            java.lang.Object r15 = r15.get(r0)
            com.google.android.gms.internal.clearcut.e r15 = (com.google.android.gms.internal.clearcut.e) r15
            if (r15 != 0) goto L_0x0056
            com.google.android.gms.internal.clearcut.n r15 = f9397c
            com.google.android.gms.internal.clearcut.e r15 = com.google.android.gms.internal.clearcut.e.b(r15, r0)
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.clearcut.e<java.lang.String>> r1 = f9399f
            r1.put(r0, r15)
        L_0x0056:
            java.lang.Object r15 = r15.a()
            r4 = r15
            java.lang.String r4 = (java.lang.String) r4
        L_0x005d:
            com.google.android.gms.internal.clearcut.fv$a$b r15 = a((java.lang.String) r4)
            if (r15 == 0) goto L_0x00f6
            java.lang.String r0 = r15.zzbis
            android.content.Context r1 = r14.f9403d
            long r1 = b(r1)
            long r3 = a(r0, r1)
            long r5 = r15.zzbit
            long r7 = r15.zzbiu
            boolean r15 = a(r3, r5, r7)
            return r15
        L_0x0078:
            if (r0 == 0) goto L_0x0081
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0081
            goto L_0x0089
        L_0x0081:
            if (r1 < 0) goto L_0x0088
            java.lang.String r0 = java.lang.String.valueOf(r1)
            goto L_0x0089
        L_0x0088:
            r0 = r4
        L_0x0089:
            if (r0 == 0) goto L_0x00f6
            android.content.Context r1 = r14.f9403d
            if (r1 != 0) goto L_0x0094
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00bd
        L_0x0094:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.google.android.gms.internal.clearcut.e<com.google.android.gms.internal.clearcut.fv$a>> r1 = f9398e
            java.lang.Object r1 = r1.get(r0)
            com.google.android.gms.internal.clearcut.e r1 = (com.google.android.gms.internal.clearcut.e) r1
            if (r1 != 0) goto L_0x00b5
            com.google.android.gms.internal.clearcut.n r1 = f9396b
            com.google.android.gms.internal.clearcut.fv$a r2 = com.google.android.gms.internal.clearcut.fv.a.a()
            com.google.android.gms.internal.clearcut.m r4 = com.google.android.gms.internal.clearcut.gk.f9404a
            com.google.android.gms.internal.clearcut.e r1 = com.google.android.gms.internal.clearcut.e.a(r1, r0, r2, r4)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.google.android.gms.internal.clearcut.e<com.google.android.gms.internal.clearcut.fv$a>> r2 = f9398e
            java.lang.Object r0 = r2.putIfAbsent(r0, r1)
            com.google.android.gms.internal.clearcut.e r0 = (com.google.android.gms.internal.clearcut.e) r0
            if (r0 == 0) goto L_0x00b5
            r1 = r0
        L_0x00b5:
            java.lang.Object r0 = r1.a()
            com.google.android.gms.internal.clearcut.fv$a r0 = (com.google.android.gms.internal.clearcut.fv.a) r0
            com.google.android.gms.internal.clearcut.bm<com.google.android.gms.internal.clearcut.fv$a$b> r0 = r0.zzbiq
        L_0x00bd:
            java.util.Iterator r0 = r0.iterator()
        L_0x00c1:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f6
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.clearcut.fv$a$b r1 = (com.google.android.gms.internal.clearcut.fv.a.b) r1
            int r2 = r1.zzbb
            r2 = r2 & r5
            if (r2 != r5) goto L_0x00d4
            r2 = 1
            goto L_0x00d5
        L_0x00d4:
            r2 = 0
        L_0x00d5:
            if (r2 == 0) goto L_0x00df
            int r2 = r1.zzya
            if (r2 == 0) goto L_0x00df
            int r2 = r1.zzya
            if (r2 != r15) goto L_0x00c1
        L_0x00df:
            java.lang.String r2 = r1.zzbis
            android.content.Context r4 = r14.f9403d
            long r6 = b(r4)
            long r8 = a(r2, r6)
            long r10 = r1.zzbit
            long r12 = r1.zzbiu
            boolean r1 = a(r8, r10, r12)
            if (r1 != 0) goto L_0x00c1
            return r3
        L_0x00f6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.gj.a(com.google.android.gms.clearcut.zze):boolean");
    }
}
