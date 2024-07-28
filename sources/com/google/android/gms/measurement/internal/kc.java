package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.ab;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class kc {

    /* renamed from: a  reason: collision with root package name */
    String f12328a;

    /* renamed from: b  reason: collision with root package name */
    int f12329b;

    /* renamed from: c  reason: collision with root package name */
    Boolean f12330c;

    /* renamed from: d  reason: collision with root package name */
    Boolean f12331d;

    /* renamed from: e  reason: collision with root package name */
    Long f12332e;

    /* renamed from: f  reason: collision with root package name */
    Long f12333f;

    kc(String str, int i2) {
        this.f12328a = str;
        this.f12329b = i2;
    }

    /* access modifiers changed from: package-private */
    public abstract int a();

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    static Boolean a(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    static Boolean a(String str, ab.f fVar, dy dyVar) {
        List list;
        s.a(fVar);
        if (str == null || !fVar.a() || fVar.b() == ab.f.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (fVar.b() == ab.f.b.IN_LIST) {
            if (fVar.d() == 0) {
                return null;
            }
        } else if (!fVar.c()) {
            return null;
        }
        ab.f.b b2 = fVar.b();
        boolean z = fVar.zzf;
        String upperCase = (z || b2 == ab.f.b.REGEXP || b2 == ab.f.b.IN_LIST) ? fVar.zze : fVar.zze.toUpperCase(Locale.ENGLISH);
        if (fVar.d() == 0) {
            list = null;
        } else {
            List<String> list2 = fVar.zzg;
            if (!z) {
                ArrayList arrayList = new ArrayList(list2.size());
                for (String upperCase2 : list2) {
                    arrayList.add(upperCase2.toUpperCase(Locale.ENGLISH));
                }
                list2 = Collections.unmodifiableList(arrayList);
            }
            list = list2;
        }
        return a(str, b2, z, upperCase, list, b2 == ab.f.b.REGEXP ? upperCase : null, dyVar);
    }

    private static Boolean a(String str, ab.f.b bVar, boolean z, String str2, List<String> list, String str3, dy dyVar) {
        if (str == null) {
            return null;
        }
        if (bVar == ab.f.b.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && bVar != ab.f.b.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (jy.f12309a[bVar.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (dyVar != null) {
                        dyVar.f11831f.a("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean a(long j, ab.d dVar) {
        try {
            return a(new BigDecimal(j), dVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean a(double d2, ab.d dVar) {
        try {
            return a(new BigDecimal(d2), dVar, Math.ulp(d2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean a(String str, ab.d dVar) {
        if (!jn.a(str)) {
            return null;
        }
        try {
            return a(new BigDecimal(str), dVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (((r11.zzc & 16) != 0) == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0089, code lost:
        if (r2 != null) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean a(java.math.BigDecimal r10, com.google.android.gms.internal.measurement.ab.d r11, double r12) {
        /*
            com.google.android.gms.common.internal.s.a(r11)
            boolean r0 = r11.a()
            r1 = 0
            if (r0 == 0) goto L_0x0111
            com.google.android.gms.internal.measurement.ab$d$a r0 = r11.b()
            com.google.android.gms.internal.measurement.ab$d$a r2 = com.google.android.gms.internal.measurement.ab.d.a.UNKNOWN_COMPARISON_TYPE
            if (r0 != r2) goto L_0x0014
            goto L_0x0111
        L_0x0014:
            com.google.android.gms.internal.measurement.ab$d$a r0 = r11.b()
            com.google.android.gms.internal.measurement.ab$d$a r2 = com.google.android.gms.internal.measurement.ab.d.a.BETWEEN
            r3 = 4
            r4 = 0
            r5 = 1
            if (r0 != r2) goto L_0x0036
            int r0 = r11.zzc
            r0 = r0 & 8
            if (r0 == 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x0035
            int r0 = r11.zzc
            r0 = r0 & 16
            if (r0 == 0) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 != 0) goto L_0x0041
        L_0x0035:
            return r1
        L_0x0036:
            int r0 = r11.zzc
            r0 = r0 & r3
            if (r0 == 0) goto L_0x003d
            r0 = 1
            goto L_0x003e
        L_0x003d:
            r0 = 0
        L_0x003e:
            if (r0 != 0) goto L_0x0041
            return r1
        L_0x0041:
            com.google.android.gms.internal.measurement.ab$d$a r0 = r11.b()
            com.google.android.gms.internal.measurement.ab$d$a r2 = r11.b()
            com.google.android.gms.internal.measurement.ab$d$a r6 = com.google.android.gms.internal.measurement.ab.d.a.BETWEEN
            if (r2 != r6) goto L_0x0070
            java.lang.String r2 = r11.zzg
            boolean r2 = com.google.android.gms.measurement.internal.jn.a((java.lang.String) r2)
            if (r2 == 0) goto L_0x006f
            java.lang.String r2 = r11.zzh
            boolean r2 = com.google.android.gms.measurement.internal.jn.a((java.lang.String) r2)
            if (r2 != 0) goto L_0x005e
            goto L_0x006f
        L_0x005e:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x006f }
            java.lang.String r6 = r11.zzg     // Catch:{ NumberFormatException -> 0x006f }
            r2.<init>(r6)     // Catch:{ NumberFormatException -> 0x006f }
            java.math.BigDecimal r6 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x006f }
            java.lang.String r11 = r11.zzh     // Catch:{ NumberFormatException -> 0x006f }
            r6.<init>(r11)     // Catch:{ NumberFormatException -> 0x006f }
            r11 = r2
            r2 = r1
            goto L_0x0082
        L_0x006f:
            return r1
        L_0x0070:
            java.lang.String r2 = r11.zzf
            boolean r2 = com.google.android.gms.measurement.internal.jn.a((java.lang.String) r2)
            if (r2 != 0) goto L_0x0079
            return r1
        L_0x0079:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0111 }
            java.lang.String r11 = r11.zzf     // Catch:{ NumberFormatException -> 0x0111 }
            r2.<init>(r11)     // Catch:{ NumberFormatException -> 0x0111 }
            r11 = r1
            r6 = r11
        L_0x0082:
            com.google.android.gms.internal.measurement.ab$d$a r7 = com.google.android.gms.internal.measurement.ab.d.a.BETWEEN
            if (r0 != r7) goto L_0x0089
            if (r11 != 0) goto L_0x008b
            return r1
        L_0x0089:
            if (r2 == 0) goto L_0x0111
        L_0x008b:
            int[] r7 = com.google.android.gms.measurement.internal.jy.f12310b
            int r0 = r0.ordinal()
            r0 = r7[r0]
            r7 = -1
            if (r0 == r5) goto L_0x0105
            r8 = 2
            if (r0 == r8) goto L_0x00f9
            r9 = 3
            if (r0 == r9) goto L_0x00b1
            if (r0 == r3) goto L_0x009f
            goto L_0x0111
        L_0x009f:
            int r11 = r10.compareTo(r11)
            if (r11 == r7) goto L_0x00ac
            int r10 = r10.compareTo(r6)
            if (r10 == r5) goto L_0x00ac
            r4 = 1
        L_0x00ac:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r4)
            return r10
        L_0x00b1:
            r0 = 0
            int r11 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r11 == 0) goto L_0x00ed
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r12)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r8)
            java.math.BigDecimal r11 = r11.multiply(r0)
            java.math.BigDecimal r11 = r2.subtract(r11)
            int r11 = r10.compareTo(r11)
            if (r11 != r5) goto L_0x00e8
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r12)
            java.math.BigDecimal r12 = new java.math.BigDecimal
            r12.<init>(r8)
            java.math.BigDecimal r11 = r11.multiply(r12)
            java.math.BigDecimal r11 = r2.add(r11)
            int r10 = r10.compareTo(r11)
            if (r10 != r7) goto L_0x00e8
            r4 = 1
        L_0x00e8:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r4)
            return r10
        L_0x00ed:
            int r10 = r10.compareTo(r2)
            if (r10 != 0) goto L_0x00f4
            r4 = 1
        L_0x00f4:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r4)
            return r10
        L_0x00f9:
            int r10 = r10.compareTo(r2)
            if (r10 != r5) goto L_0x0100
            r4 = 1
        L_0x0100:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r4)
            return r10
        L_0x0105:
            int r10 = r10.compareTo(r2)
            if (r10 != r7) goto L_0x010c
            r4 = 1
        L_0x010c:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r4)
            return r10
        L_0x0111:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.kc.a(java.math.BigDecimal, com.google.android.gms.internal.measurement.ab$d, double):java.lang.Boolean");
    }
}
