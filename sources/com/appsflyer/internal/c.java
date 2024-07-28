package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.appsflyer.AFLogger;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {

    /* renamed from: ı  reason: contains not printable characters */
    private static char[] f224 = {61163, 22514, 40130, 50618, 2749, 29581, 47210, 57662, 9806, 28457, 54330, 7453, 17394, 35068, 61905, 13998, 32659, 42194, 60754, 21069, 39774, 49185, 2334, 19992, 46325, 64962, 8911, 27541, 53379, 6554, 24191, 34631, 52271, 13614, 52353, 60956, 4935, 43601, 24939, 14341, 63307, 36381, 17911, 7305, 56298, 37532, 10685, 57476, 48766, 30029, 3175, 51975, 33325, 22802, 21602, 60791, 9806, 32551, 45113, 51467, 692, 23471, 40073, 54690, 28393, 42945, 63849, 12924, 19213, 35961, 50516, 7696, 22456, 59591, 8588, 31403, 46032, 62666, 3700, 18207, 38925, 53556, 27226, 41806, 58533, 15771, 47429, '\\', 52076, 37396, 23827, 9251, 61380, 46736, 29179, 14481, 33750, 19092, 5197, 57166, 42596, 24843, 10294, 62251, 47845, 1511, 52466, 38795, 24231, 6587, 58182, 30898, 49579, 2715, 21475, 40164, 58836, 11827, 30567, 45067, 63860, 17021, 35653, 54700, 7852, 26517, 41212, 59805, 13046, 31546, 50207, 3352, 22130, 40773, 42262, 7183, 55103, 36423, 16704, 14448, 62359, 43715, 28072, 9410, 40837, 22212, 2060, 49936, 47661, 32094, 13379, 61280, 42632, 6590, 'a', 47480, 29256, 11056, 58423, 40199, 22240, 4020, 51422, 33187, 15016, 62428, 44381, 26220, 8029, 49716, 45998, 2762, 64061, 17184, 34829, 53620, 7713, 26448, 44220, 62947, 12947, 31740, 49403, 2497, 22326, 39995, '/', 47477, 29261, 11041, 58416, 40203, 13489, 36259, 18076, 8065, 53428, 43483, 25139, 15147, 64517, 46448, 'C', 47486, 29257, 11041, 58419, 40221, 22257, 4087, 51445, 33214, 15039, 62359, 44408, 26218, 8029, 55333, 37134, 50529, 31824, 46946, 60937, 8474, 22573, 37763, 51913, 3576, 17601, 65436, 14000, 26715, 41753, 55920, 7436, 21540, 36665, 50894, 31141, 45295, 60296, 8887, 26037, 40727, 54902, 2418, 16385, 64295, 12921, 30166, 44277, 59268, 7828, 20923, 35665, 49750, 1382, 48141, 63303, 11895, 17313, 64181, 12702, 26829, 42992, 57051, 5430, 19517, 35610, 49772, 31103, 45136, 61071, 9640, 23682, 39904, 53967, 2515, 16427, 65296, 13847, 28007, 42060, 58191, 48803, 1950, 52393, 38337, 23251, 9213, 59409, 45335, 30210, 16195, 33882, 19838, 5005, 55453, 41376, 26351, 12280, 62709, 48393, 562, 52012, 36935, 22891, 7796, 48359, 1494, 52964, 38799, 22684, 8619, 59909, 45906, 29823, 15633, 34322, 20280, 4556, 55967, 41959, 25742, 11687, 63163, 48968, '`', 51565, 37386, 23329, 7291, 59100, 45026, 28905, 14747, 33446, 19387, 3093, 54652, 40456, 26371, 10277, 62083, 48092, 31991, 50566, 36510, 22433, 6227, 57684, 43644, 29447, 13381, 64885};

    /* renamed from: ǃ  reason: contains not printable characters */
    private static int f225 = 0;

    /* renamed from: Ι  reason: contains not printable characters */
    private static long f226 = 5583085843407419670L;

    /* renamed from: ι  reason: contains not printable characters */
    private static int f227 = 1;

    c() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b7  */
    /* renamed from: ı  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m161(android.content.Context r15, long r16) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 34
            r4 = 0
            r5 = 61066(0xee8a, float:8.5572E-41)
            java.lang.String r5 = m166(r4, r5, r3)
            java.lang.String r5 = r5.intern()
            boolean r5 = m162((java.lang.String) r5)
            r6 = 2
            r7 = 60972(0xee2c, float:8.544E-41)
            r8 = 35
            r9 = 52400(0xccb0, float:7.3428E-41)
            r10 = 1
            if (r5 != 0) goto L_0x0032
            java.lang.String r5 = m166(r8, r7, r10)
            goto L_0x004c
        L_0x0032:
            int r5 = f225
            int r5 = r5 + 73
            int r11 = r5 % 128
            f227 = r11
            int r5 = r5 % r6
            if (r5 != 0) goto L_0x0048
            r5 = 113(0x71, float:1.58E-43)
            java.lang.String r5 = m166(r5, r9, r4)
            java.lang.String r5 = r5.intern()
            goto L_0x0050
        L_0x0048:
            java.lang.String r5 = m166(r3, r9, r10)
        L_0x004c:
            java.lang.String r5 = r5.intern()
        L_0x0050:
            r1.append(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r11 = r15.getPackageName()
            java.lang.String r12 = m165(r11)
            java.lang.String r13 = m166(r3, r9, r10)
            java.lang.String r13 = r13.intern()
            r1.append(r13)
            r5.append(r12)
            java.lang.String r12 = m160((android.content.Context) r15)
            if (r12 == 0) goto L_0x0076
            r12 = 0
            goto L_0x0077
        L_0x0076:
            r12 = 1
        L_0x0077:
            if (r12 == r10) goto L_0x0088
            java.lang.String r12 = m166(r3, r9, r10)
            java.lang.String r12 = r12.intern()
            r1.append(r12)
            r5.append(r11)
            goto L_0x0096
        L_0x0088:
            java.lang.String r12 = m166(r8, r7, r10)
            java.lang.String r12 = r12.intern()
            r1.append(r12)
            r5.append(r11)
        L_0x0096:
            java.lang.String r12 = m163(r15)
            r13 = 53
            if (r12 == 0) goto L_0x00a1
            r14 = 53
            goto L_0x00a3
        L_0x00a1:
            r14 = 94
        L_0x00a3:
            if (r14 == r13) goto L_0x00b5
            java.lang.String r12 = m166(r8, r7, r10)
            java.lang.String r12 = r12.intern()
            r1.append(r12)
            r5.append(r11)
        L_0x00b3:
            r12 = r15
            goto L_0x00c4
        L_0x00b5:
            java.lang.String r13 = m166(r3, r9, r10)
            java.lang.String r13 = r13.intern()
            r1.append(r13)
            r5.append(r12)
            goto L_0x00b3
        L_0x00c4:
            java.lang.String r11 = m164(r15, r11)
            r5.append(r11)
            java.lang.String r5 = r5.toString()
            r0.append(r5)
            android.content.pm.PackageManager r5 = r15.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0230 }
            java.lang.String r11 = r15.getPackageName()     // Catch:{ NameNotFoundException -> 0x0230 }
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r11, r4)     // Catch:{ NameNotFoundException -> 0x0230 }
            long r11 = r5.firstInstallTime     // Catch:{ NameNotFoundException -> 0x0230 }
            r5 = 36
            r13 = 4926(0x133e, float:6.903E-42)
            r14 = 18
            java.lang.String r5 = m166(r5, r13, r14)     // Catch:{ NameNotFoundException -> 0x0230 }
            java.lang.String r5 = r5.intern()     // Catch:{ NameNotFoundException -> 0x0230 }
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat     // Catch:{ NameNotFoundException -> 0x0230 }
            java.util.Locale r14 = java.util.Locale.US     // Catch:{ NameNotFoundException -> 0x0230 }
            r13.<init>(r5, r14)     // Catch:{ NameNotFoundException -> 0x0230 }
            java.util.Date r5 = new java.util.Date     // Catch:{ NameNotFoundException -> 0x0230 }
            r5.<init>(r11)     // Catch:{ NameNotFoundException -> 0x0230 }
            java.lang.String r5 = r13.format(r5)     // Catch:{ NameNotFoundException -> 0x0230 }
            r0.append(r5)     // Catch:{ NameNotFoundException -> 0x0230 }
            r11 = r16
            r0.append(r11)
            r5 = 86
            r13 = 47396(0xb924, float:6.6416E-41)
            r14 = 25
            java.lang.String r5 = m166(r5, r13, r14)
            java.lang.String r5 = r5.intern()
            boolean r5 = m162((java.lang.String) r5)
            if (r5 != 0) goto L_0x011d
            r5 = 1
            goto L_0x011e
        L_0x011d:
            r5 = 0
        L_0x011e:
            if (r5 == 0) goto L_0x0132
            java.lang.String r5 = m166(r8, r7, r10)
            java.lang.String r5 = r5.intern()
            int r13 = f227
            int r13 = r13 + 91
            int r14 = r13 % 128
            f225 = r14
            int r13 = r13 % r6
            goto L_0x013a
        L_0x0132:
            java.lang.String r5 = m166(r3, r9, r10)
            java.lang.String r5 = r5.intern()
        L_0x013a:
            r2.append(r5)
            r5 = 111(0x6f, float:1.56E-43)
            r13 = 30931(0x78d3, float:4.3344E-41)
            r14 = 23
            java.lang.String r5 = m166(r5, r13, r14)
            java.lang.String r5 = r5.intern()
            boolean r5 = m162((java.lang.String) r5)
            r13 = 4
            if (r5 != 0) goto L_0x0155
            r5 = 47
            goto L_0x0156
        L_0x0155:
            r5 = 4
        L_0x0156:
            if (r5 == r13) goto L_0x0161
            java.lang.String r5 = m166(r8, r7, r10)
        L_0x015c:
            java.lang.String r5 = r5.intern()
            goto L_0x0166
        L_0x0161:
            java.lang.String r5 = m166(r3, r9, r10)
            goto L_0x015c
        L_0x0166:
            r2.append(r5)
            r5 = 134(0x86, float:1.88E-43)
            r13 = 42359(0xa577, float:5.9358E-41)
            r14 = 20
            java.lang.String r5 = m166(r5, r13, r14)
            java.lang.String r5 = r5.intern()
            boolean r5 = m162((java.lang.String) r5)
            if (r5 != 0) goto L_0x0183
            java.lang.String r5 = m166(r8, r7, r10)
            goto L_0x0190
        L_0x0183:
            int r5 = f227
            int r5 = r5 + 105
            int r13 = r5 % 128
            f225 = r13
            int r5 = r5 % r6
            java.lang.String r5 = m166(r3, r9, r10)
        L_0x0190:
            java.lang.String r5 = r5.intern()
            r2.append(r5)
            r5 = 154(0x9a, float:2.16E-43)
            r13 = 15
            java.lang.String r5 = m166(r5, r4, r13)
            java.lang.String r5 = r5.intern()
            boolean r5 = m162((java.lang.String) r5)
            if (r5 != 0) goto L_0x01ab
            r5 = 0
            goto L_0x01ac
        L_0x01ab:
            r5 = 1
        L_0x01ac:
            if (r5 == r10) goto L_0x01b7
            java.lang.String r3 = m166(r8, r7, r10)
        L_0x01b2:
            java.lang.String r3 = r3.intern()
            goto L_0x01da
        L_0x01b7:
            int r5 = f227
            int r5 = r5 + 91
            int r7 = r5 % 128
            f225 = r7
            int r5 = r5 % r6
            r7 = 52
            if (r5 != 0) goto L_0x01c7
            r5 = 98
            goto L_0x01c9
        L_0x01c7:
            r5 = 52
        L_0x01c9:
            if (r5 == r7) goto L_0x01d0
            java.lang.String r3 = m166(r3, r9, r10)
            goto L_0x01b2
        L_0x01d0:
            r3 = 97
            java.lang.String r3 = m166(r3, r9, r4)
            java.lang.String r3 = r3.intern()
        L_0x01da:
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.appsflyer.internal.z.m212(r0)
            java.lang.String r0 = com.appsflyer.internal.z.m211(r0)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r0 = 17
            int r1 = java.lang.Integer.parseInt(r1, r6)
            r5 = 16
            java.lang.String r1 = java.lang.Integer.toString(r1, r5)
            char r1 = r1.charAt(r4)
            r3.setCharAt(r0, r1)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = r2.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            r0 = 27
            int r1 = java.lang.Integer.parseInt(r1, r6)
            java.lang.String r1 = java.lang.Integer.toString(r1, r5)
            char r1 = r1.charAt(r4)
            r2.setCharAt(r0, r1)
            java.lang.String r0 = r2.toString()
            java.lang.Long r1 = java.lang.Long.valueOf(r16)
            java.lang.String r0 = m167(r0, r1)
            return r0
        L_0x0230:
            r0 = 54
            r1 = 21504(0x5400, float:3.0134E-41)
            r2 = 32
            java.lang.String r0 = m166(r0, r1, r2)
            java.lang.String r0 = r0.intern()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.c.m161(android.content.Context, long):java.lang.String");
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static String m167(String str, Long l) {
        if (!(str == null)) {
            int i2 = f227 + 125;
            f225 = i2 % 128;
            int i3 = i2 % 2;
            if (!(l == null)) {
                int i4 = f225 + 59;
                f227 = i4 % 128;
                int i5 = i4 % 2;
                if (str.length() == 32) {
                    StringBuilder sb = new StringBuilder(str);
                    String obj = l.toString();
                    long j = 0;
                    int i6 = 0;
                    for (int i7 = 0; i7 < obj.length(); i7++) {
                        i6 += Character.getNumericValue(obj.charAt(i7));
                    }
                    String hexString = Integer.toHexString(i6);
                    sb.replace(7, hexString.length() + 7, hexString);
                    for (int i8 = 0; i8 < sb.length(); i8++) {
                        j += (long) Character.getNumericValue(sb.charAt(i8));
                    }
                    while (true) {
                        if (!(j > 100)) {
                            break;
                        }
                        j %= 100;
                    }
                    sb.insert(23, (int) j);
                    if ((j >= 10 ? '`' : 'Q') != '`') {
                        sb.insert(23, m166(35, 60972, 1).intern());
                    }
                    return sb.toString();
                }
            }
        }
        return m166(54, 21504, 32).intern();
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static boolean m162(String str) {
        int i2 = f225 + 89;
        f227 = i2 % 128;
        int i3 = i2 % 2;
        try {
            Class.forName(str);
            int i4 = f227 + 49;
            f225 = i4 % 128;
            int i5 = i4 % 2;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static String m165(String str) {
        int i2 = f227 + 65;
        f225 = i2 % 128;
        int i3 = i2 % 2;
        if (!(str.contains(m166(169, 49690, 1).intern()))) {
            return str;
        }
        String[] split = str.split(m166(170, 46066, 2).intern());
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        int i4 = length - 1;
        sb.append(split[i4]);
        sb.append(m166(169, 49690, 1).intern());
        int i5 = f225 + 103;
        f227 = i5 % 128;
        int i6 = i5 % 2;
        int i7 = 1;
        while (true) {
            if (i7 < i4) {
                int i8 = f225 + 61;
                f227 = i8 % 128;
                int i9 = i8 % 2;
                sb.append(split[i7]);
                sb.append(m166(169, 49690, 1).intern());
                i7++;
            } else {
                sb.append(split[0]);
                return sb.toString();
            }
        }
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static String m160(Context context) {
        if ((!System.getProperties().containsKey(m166(172, 64087, 14).intern()) ? 'C' : '.') == 'C') {
            return null;
        }
        int i2 = f225 + 51;
        f227 = i2 % 128;
        int i3 = i2 % 2;
        try {
            Matcher matcher = Pattern.compile(m166(192, 13471, 10).intern()).matcher(context.getCacheDir().getPath().replace(m166(186, 0, 6).intern(), ""));
            if ((!matcher.find() ? 'c' : ')') != ')') {
                return null;
            }
            int i4 = f227 + 89;
            f225 = i4 % 128;
            if ((i4 % 2 == 0 ? ']' : 20) != ']') {
                return matcher.group(1);
            }
            return matcher.group(1);
        } catch (Exception e2) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
                int i5 = f225 + 87;
                f227 = i5 % 128;
                int i6 = i5 % 2;
            }
            ai aiVar = ai.f183;
            String intern = m166(202, 0, 17).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m166(219, 50471, 41).intern());
            sb.append(e2);
            aiVar.m144((String) null, intern, sb.toString());
            return null;
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static String m163(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            int i2 = f225 + 83;
            f227 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = f227 + 79;
            f225 = i4 % 128;
            int i5 = i4 % 2;
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static String m164(Context context, String str) {
        boolean z;
        int i2 = f227 + 27;
        f225 = i2 % 128;
        int i3 = i2 % 2;
        try {
            Iterator it2 = ((List) PackageManager.class.getDeclaredMethod(m166(260, 17350, 24).intern(), new Class[]{Integer.TYPE}).invoke(context.getPackageManager(), new Object[]{0})).iterator();
            int i4 = f227 + 1;
            f225 = i4 % 128;
            int i5 = i4 % 2;
            do {
                if ((!it2.hasNext() ? 7 : '7') != '7') {
                    return Boolean.FALSE.toString();
                }
                if (!((ApplicationInfo) it2.next()).packageName.equals(str)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
            } while (!z);
            int i6 = f225 + 101;
            f227 = i6 % 128;
            return i6 % 2 == 0 ? Boolean.TRUE.toString() : Boolean.TRUE.toString();
        } catch (IllegalAccessException e2) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai aiVar = ai.f183;
            String intern = m166(284, 48864, 24).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m166(308, 48289, 47).intern());
            sb.append(e2);
            aiVar.m144((String) null, intern, sb.toString());
        } catch (NoSuchMethodException e3) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
                int i7 = f225 + 25;
                f227 = i7 % 128;
                if (i7 % 2 != 0) {
                }
            }
            ai aiVar2 = ai.f183;
            String intern2 = m166(284, 48864, 24).intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m166(308, 48289, 47).intern());
            sb2.append(e3);
            aiVar2.m144((String) null, intern2, sb2.toString());
        } catch (InvocationTargetException e4) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai aiVar3 = ai.f183;
            String intern3 = m166(284, 48864, 24).intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m166(308, 48289, 47).intern());
            sb3.append(e4);
            aiVar3.m144((String) null, intern3, sb3.toString());
        }
    }

    public static class a extends HashMap<String, Object> {

        /* renamed from: ǃ  reason: contains not printable characters */
        private static long f228 = -8771784815112425056L;

        /* renamed from: Ι  reason: contains not printable characters */
        private static int f229 = 0;

        /* renamed from: ι  reason: contains not printable characters */
        private static char[] f230 = {'a', 61894, 58143, 54420, 50921, 47181, 43429, 39699, 36212, 32449, 28717, 24976, 'b', 61906, 58145, 54414, 50916, 'N', 61935, 58143, 54434, 50898, 47201, 43406, 39716, 'k', 61893, 58150, 'f', 61889, 58153, 54412, 50917, 47172, 43488, 39687, 36197, 32462, 28709, 24978, 21473, 17748, 13993, 10254, 6759, 2944, 64811, 61061, 57574, 53760, 50091, 46341, 42873, 39040, 35383, 31625, 28148, 24392, 20704, 16901, 13432, 9667, 5925, 2192, 64244, 60489, 56751, 53006, 49466, 45696, 14536, 51558, 56197, 60538, 65050, 32954, 37210, 'f', 61897, 58162, 54419, 50932, 47212, 43425, 39701, 36206, 32451, 28712, 24996, 21473, 17748, 13989, '5', 61838, 58228, 54478, 50864, 24553, 44566, 48359, 35594, 39278, 14334, 50777, 54449, 58132, 61821, 36828, 40568, 44191, 47869, 18774, 18365, 22026, 25721, 29388, 305, 8086, 11775, 15384, 51891, 55581, 55166, 58776, 62510, 33433, 37108, 44877, 48573, 19544, 23151, 26833, 26412, 30096, 952, 4701, 8352, 16155, 52605, 56264, 59948, 63633, 63223, 34134, 37858, 41560, 51824, 15315, 10544, 7831, 3315, 29271, 25570, 20807, 18214, 46210, 47670, 43979, 39331, 36692, 64736, 57922, 53283, 49546, 'a', 61902, 58148, 54418, 50927, 47177, 43428, 39758, 36201, 32462, 28724, 24965, 21486, 17748, 14062, 10241, 6755, 3028, 64809, 61071, 57582, 53774, 50050, 46369, 42836, 39156, 35333, 31666, 28121, 24447, 20611, 16936, 13377, 9710, 5895, 2213, 64196, 't', 61893, 58157, 54416, 50917, 47186, 43425, 39700, 36213, 32466, 28709, 64752, 3344, 8190, 26734, 39384, 35635, 48270, 44786, 53327, 24021, 33232, 28718, '&', 61907, '&', 61904, 'f', 61840, 58161, 54480, 50929, 47121, 43440, 39761, 36208, 32402, 28786, 24963, 21480, 17748, 13985, 10253};

        /* renamed from: І  reason: contains not printable characters */
        private static int f231 = 1;

        /* renamed from: ı  reason: contains not printable characters */
        private final Map<String, Object> f232;

        /* renamed from: ɩ  reason: contains not printable characters */
        private final Context f233;

        public a(Map<String, Object> map, Context context) {
            this.f232 = map;
            this.f233 = context;
            put(m170(), m168());
        }

        /* renamed from: Ι  reason: contains not printable characters */
        private static StringBuilder m171(String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                if ((i2 >= 3 ? (char) 13 : 22) == 13) {
                    break;
                }
                arrayList.add(Integer.valueOf(strArr[i2].length()));
                i2++;
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < intValue; i3++) {
                int i4 = f229 + 105;
                f231 = i4 % 128;
                int i5 = i4 % 2;
                Integer num = null;
                int i6 = 0;
                while (true) {
                    if (!(i6 < 3)) {
                        break;
                    }
                    char charAt = strArr[i6].charAt(i3);
                    if (num == null) {
                        int i7 = f229 + 95;
                        f231 = i7 % 128;
                        int i8 = i7 % 2;
                    } else {
                        charAt ^= num.intValue();
                    }
                    num = Integer.valueOf(charAt);
                    i6++;
                    int i9 = f229 + 87;
                    f231 = i9 % 128;
                    int i10 = i9 % 2;
                }
                sb.append(Integer.toHexString(num.intValue()));
            }
            return sb;
        }

        /* renamed from: Ι  reason: contains not printable characters */
        private String m170() {
            int i2 = f231 + 49;
            f229 = i2 % 128;
            int i3 = i2 % 2;
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                String obj = this.f232.get(m169(0, 0, 12).intern()).toString();
                String obj2 = this.f232.get(m169(12, 0, 5).intern()).toString();
                if (obj2 == null) {
                    obj2 = m169(17, 0, 8).intern();
                    int i4 = f231 + 117;
                    f229 = i4 % 128;
                    int i5 = i4 % 2;
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder r3 = m171(num, obj2, sb.toString());
                int length = r3.length();
                if (length <= 4) {
                    while (true) {
                        if (length >= 4) {
                            break;
                        }
                        length++;
                        r3.append('1');
                        int i6 = f231 + 67;
                        f229 = i6 % 128;
                        int i7 = i6 % 2;
                    }
                } else {
                    int i8 = f231 + 73;
                    f229 = i8 % 128;
                    if (!(i8 % 2 == 0)) {
                        r3.delete(3, length);
                    } else {
                        r3.delete(4, length);
                    }
                }
                r3.insert(0, m169(25, 0, 3).intern());
                return r3.toString();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m169(28, 0, 42).intern());
                sb2.append(e2);
                AFLogger.afRDLog(sb2.toString());
                return m169(70, 14499, 7).intern();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:37:0x01e0  */
        /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
        /* renamed from: ı  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String m168() {
            /*
                r14 = this;
                java.lang.String r0 = ""
                r1 = 15
                r2 = 16
                r3 = 44
                r4 = 14232(0x3798, float:1.9943E-41)
                r5 = 102(0x66, float:1.43E-43)
                r6 = 0
                java.util.Map<java.lang.String, java.lang.Object> r7 = r14.f232     // Catch:{ Exception -> 0x007a }
                r8 = 12
                java.lang.String r8 = m169(r6, r6, r8)     // Catch:{ Exception -> 0x007a }
                java.lang.String r8 = r8.intern()     // Catch:{ Exception -> 0x007a }
                java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x007a }
                java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x007a }
                java.util.Map<java.lang.String, java.lang.Object> r8 = r14.f232     // Catch:{ Exception -> 0x007a }
                r9 = 77
                java.lang.String r9 = m169(r9, r6, r1)     // Catch:{ Exception -> 0x007a }
                java.lang.String r9 = r9.intern()     // Catch:{ Exception -> 0x007a }
                java.lang.Object r8 = r8.get(r9)     // Catch:{ Exception -> 0x007a }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x007a }
                r9 = 92
                r10 = 5
                java.lang.String r9 = m169(r9, r6, r10)     // Catch:{ Exception -> 0x007a }
                java.lang.String r9 = r9.intern()     // Catch:{ Exception -> 0x007a }
                r11 = 97
                r12 = 24516(0x5fc4, float:3.4354E-41)
                java.lang.String r10 = m169(r11, r12, r10)     // Catch:{ Exception -> 0x007a }
                java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x007a }
                java.lang.String r9 = r9.replaceAll(r10, r0)     // Catch:{ Exception -> 0x007a }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007a }
                r10.<init>()     // Catch:{ Exception -> 0x007a }
                r10.append(r7)     // Catch:{ Exception -> 0x007a }
                r10.append(r8)     // Catch:{ Exception -> 0x007a }
                r10.append(r9)     // Catch:{ Exception -> 0x007a }
                java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x007a }
                java.lang.String r7 = com.appsflyer.internal.z.m212(r7)     // Catch:{ Exception -> 0x007a }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007a }
                r8.<init>()     // Catch:{ Exception -> 0x007a }
                r8.append(r0)     // Catch:{ Exception -> 0x007a }
                java.lang.String r7 = r7.substring(r6, r2)     // Catch:{ Exception -> 0x007a }
                r8.append(r7)     // Catch:{ Exception -> 0x007a }
                java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x007a }
                goto L_0x00b3
            L_0x007a:
                r7 = move-exception
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = m169(r5, r4, r3)
                java.lang.String r9 = r9.intern()
                r8.append(r9)
                r8.append(r7)
                java.lang.String r7 = r8.toString()
                com.appsflyer.AFLogger.afRDLog(r7)
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r0)
                r0 = 146(0x92, float:2.05E-43)
                r8 = 51730(0xca12, float:7.2489E-41)
                r9 = 18
                java.lang.String r0 = m169(r0, r8, r9)
                java.lang.String r0 = r0.intern()
                r7.append(r0)
                java.lang.String r0 = r7.toString()
            L_0x00b3:
                android.content.Context r7 = r14.f233     // Catch:{ Exception -> 0x01e2 }
                r8 = 0
                android.content.IntentFilter r9 = new android.content.IntentFilter     // Catch:{ Exception -> 0x01e2 }
                r10 = 164(0xa4, float:2.3E-43)
                r11 = 37
                java.lang.String r10 = m169(r10, r6, r11)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x01e2 }
                r9.<init>(r10)     // Catch:{ Exception -> 0x01e2 }
                android.content.Intent r7 = r7.registerReceiver(r8, r9)     // Catch:{ Exception -> 0x01e2 }
                r8 = -2700(0xfffffffffffff574, float:NaN)
                r9 = 2
                if (r7 != 0) goto L_0x00d1
                goto L_0x00ff
            L_0x00d1:
                int r10 = f231
                int r10 = r10 + 51
                int r11 = r10 % 128
                f229 = r11
                int r10 = r10 % r9
                if (r10 == 0) goto L_0x00ef
                r8 = 15579(0x3cdb, float:2.1831E-41)
                r10 = 109(0x6d, float:1.53E-43)
                java.lang.String r8 = m169(r8, r6, r10)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r8 = r8.intern()     // Catch:{ Exception -> 0x01e2 }
                r10 = 25996(0x658c, float:3.6428E-41)
                int r8 = r7.getIntExtra(r8, r10)     // Catch:{ Exception -> 0x01e2 }
                goto L_0x00ff
            L_0x00ef:
                r10 = 201(0xc9, float:2.82E-43)
                r11 = 11
                java.lang.String r10 = m169(r10, r6, r11)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x01e2 }
                int r8 = r7.getIntExtra(r10, r8)     // Catch:{ Exception -> 0x01e2 }
            L_0x00ff:
                android.content.Context r7 = r14.f233     // Catch:{ Exception -> 0x01e2 }
                android.content.pm.ApplicationInfo r7 = r7.getApplicationInfo()     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r7 = r7.nativeLibraryDir     // Catch:{ Exception -> 0x01e2 }
                r10 = 48
                if (r7 != 0) goto L_0x010e
                r11 = 86
                goto L_0x0110
            L_0x010e:
                r11 = 48
            L_0x0110:
                r12 = 1
                if (r11 == r10) goto L_0x0114
                goto L_0x0130
            L_0x0114:
                int r10 = f231
                int r10 = r10 + r1
                int r1 = r10 % 128
                f229 = r1
                int r10 = r10 % r9
                r1 = 212(0xd4, float:2.97E-43)
                r10 = 64648(0xfc88, float:9.0591E-41)
                r11 = 3
                java.lang.String r1 = m169(r1, r10, r11)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r1 = r1.intern()     // Catch:{ Exception -> 0x01e2 }
                boolean r1 = r7.contains(r1)     // Catch:{ Exception -> 0x01e2 }
                if (r1 != 0) goto L_0x0132
            L_0x0130:
                r1 = 0
                goto L_0x0148
            L_0x0132:
                int r1 = f231
                int r1 = r1 + 111
                int r7 = r1 % 128
                f229 = r7
                int r1 = r1 % r9
                r7 = 79
                if (r1 != 0) goto L_0x0142
                r1 = 79
                goto L_0x0144
            L_0x0142:
                r1 = 52
            L_0x0144:
                if (r1 == r7) goto L_0x0147
                goto L_0x0130
            L_0x0147:
                r1 = 1
            L_0x0148:
                android.content.Context r7 = r14.f233     // Catch:{ Exception -> 0x01e2 }
                r10 = 215(0xd7, float:3.01E-43)
                r11 = 26653(0x681d, float:3.7349E-41)
                r13 = 6
                java.lang.String r10 = m169(r10, r11, r13)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x01e2 }
                java.lang.Object r7 = r7.getSystemService(r10)     // Catch:{ Exception -> 0x01e2 }
                android.hardware.SensorManager r7 = (android.hardware.SensorManager) r7     // Catch:{ Exception -> 0x01e2 }
                r10 = -1
                java.util.List r7 = r7.getSensorList(r10)     // Catch:{ Exception -> 0x01e2 }
                int r7 = r7.size()     // Catch:{ Exception -> 0x01e2 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e2 }
                r10.<init>()     // Catch:{ Exception -> 0x01e2 }
                r11 = 221(0xdd, float:3.1E-43)
                r13 = 23991(0x5db7, float:3.3619E-41)
                java.lang.String r11 = m169(r11, r13, r12)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r11 = r11.intern()     // Catch:{ Exception -> 0x01e2 }
                r10.append(r11)     // Catch:{ Exception -> 0x01e2 }
                r10.append(r8)     // Catch:{ Exception -> 0x01e2 }
                r8 = 222(0xde, float:3.11E-43)
                r11 = 33270(0x81f6, float:4.6621E-41)
                java.lang.String r8 = m169(r8, r11, r9)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r8 = r8.intern()     // Catch:{ Exception -> 0x01e2 }
                r10.append(r8)     // Catch:{ Exception -> 0x01e2 }
                r10.append(r1)     // Catch:{ Exception -> 0x01e2 }
                r1 = 224(0xe0, float:3.14E-43)
                java.lang.String r1 = m169(r1, r6, r9)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r1 = r1.intern()     // Catch:{ Exception -> 0x01e2 }
                r10.append(r1)     // Catch:{ Exception -> 0x01e2 }
                r10.append(r7)     // Catch:{ Exception -> 0x01e2 }
                r1 = 226(0xe2, float:3.17E-43)
                java.lang.String r1 = m169(r1, r6, r9)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r1 = r1.intern()     // Catch:{ Exception -> 0x01e2 }
                r10.append(r1)     // Catch:{ Exception -> 0x01e2 }
                java.util.Map<java.lang.String, java.lang.Object> r1 = r14.f232     // Catch:{ Exception -> 0x01e2 }
                int r1 = r1.size()     // Catch:{ Exception -> 0x01e2 }
                r10.append(r1)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r1 = r10.toString()     // Catch:{ Exception -> 0x01e2 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e2 }
                r7.<init>()     // Catch:{ Exception -> 0x01e2 }
                r7.append(r0)     // Catch:{ Exception -> 0x01e2 }
                byte[] r1 = com.appsflyer.internal.c.a.C0085c.m173((java.lang.String) r1)     // Catch:{ Exception -> 0x01e2 }
                byte[] r1 = com.appsflyer.internal.c.a.C0085c.m174(r1)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r1 = com.appsflyer.internal.c.a.C0085c.m176((byte[]) r1)     // Catch:{ Exception -> 0x01e2 }
                r7.append(r1)     // Catch:{ Exception -> 0x01e2 }
                java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x01e2 }
                int r1 = f231
                int r1 = r1 + 13
                int r2 = r1 % 128
                f229 = r2
                int r1 = r1 % r9
                if (r1 != 0) goto L_0x0216
                r6 = 1
                goto L_0x0216
            L_0x01e2:
                r1 = move-exception
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r3 = m169(r5, r4, r3)
                java.lang.String r3 = r3.intern()
                r7.append(r3)
                r7.append(r1)
                java.lang.String r1 = r7.toString()
                com.appsflyer.AFLogger.afRDLog(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                r0 = 228(0xe4, float:3.2E-43)
                java.lang.String r0 = m169(r0, r6, r2)
                java.lang.String r0 = r0.intern()
                r1.append(r0)
                java.lang.String r0 = r1.toString()
            L_0x0216:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.c.a.m168():java.lang.String");
        }

        /* renamed from: com.appsflyer.internal.c$a$c  reason: collision with other inner class name */
        public static class C0085c {

            /* renamed from: ı  reason: contains not printable characters */
            private final Object f234;

            /* renamed from: ɩ  reason: contains not printable characters */
            public String f235;

            /* renamed from: Ι  reason: contains not printable characters */
            private long f236;

            C0085c() {
            }

            /* renamed from: ɩ  reason: contains not printable characters */
            static byte[] m173(String str) throws Exception {
                return str.getBytes();
            }

            /* renamed from: Ι  reason: contains not printable characters */
            static byte[] m174(byte[] bArr) throws Exception {
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) (bArr[i2] ^ ((i2 % 2) + 42));
                }
                return bArr;
            }

            /* renamed from: ι  reason: contains not printable characters */
            static String m176(byte[] bArr) throws Exception {
                StringBuilder sb = new StringBuilder();
                for (byte hexString : bArr) {
                    String hexString2 = Integer.toHexString(hexString);
                    if (hexString2.length() == 1) {
                        hexString2 = "0".concat(String.valueOf(hexString2));
                    }
                    sb.append(hexString2);
                }
                return sb.toString();
            }

            public C0085c(long j, String str) {
                this.f234 = new Object();
                this.f236 = 0;
                this.f235 = "";
                this.f236 = j;
                this.f235 = str;
            }

            /* renamed from: ι  reason: contains not printable characters */
            public static C0085c m175(String str) {
                if (str == null) {
                    return new C0085c(0, "");
                }
                String[] split = str.split(AppConstants.COMMA);
                return split.length < 2 ? new C0085c(0, "") : new C0085c(Long.parseLong(split[0]), split[1]);
            }

            /* renamed from: ɩ  reason: contains not printable characters */
            public final boolean m178(C0085c cVar) {
                return m172(cVar.f236, cVar.f235);
            }

            /* renamed from: ı  reason: contains not printable characters */
            private boolean m172(long j, String str) {
                synchronized (this.f234) {
                    if (str != null) {
                        if (!str.equals(this.f235) && m177(j)) {
                            this.f236 = j;
                            this.f235 = str;
                            return true;
                        }
                    }
                    return false;
                }
            }

            /* renamed from: ι  reason: contains not printable characters */
            private boolean m177(long j) {
                return j - this.f236 > 2000;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f236);
                sb.append(AppConstants.COMMA);
                sb.append(this.f235);
                return sb.toString();
            }
        }

        /* renamed from: ɩ  reason: contains not printable characters */
        private static String m169(int i2, char c2, int i3) {
            int i4 = f229 + 19;
            f231 = i4 % 128;
            int i5 = i4 % 2;
            char[] cArr = new char[i3];
            int i6 = 0;
            while (true) {
                if (!(i6 < i3)) {
                    return new String(cArr);
                }
                int i7 = f231 + 95;
                f229 = i7 % 128;
                int i8 = i7 % 2;
                cArr[i6] = (char) ((int) ((((long) f230[i2 + i6]) ^ (((long) i6) * f228)) ^ ((long) c2)));
                i6++;
                int i9 = f229 + 125;
                f231 = i9 % 128;
                if (i9 % 2 != 0) {
                }
            }
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static String m166(int i2, char c2, int i3) {
        char[] cArr = new char[i3];
        int i4 = 0;
        while (true) {
            if ((i4 >= i3 ? 'Y' : 'J') == 'Y') {
                return new String(cArr);
            }
            int i5 = f227 + 85;
            f225 = i5 % 128;
            if (i5 % 2 != 0) {
                cArr[i4] = (char) ((int) ((((long) f224[i2 + i4]) | (((long) i4) % f226)) * ((long) c2)));
                i4 += 37;
            } else {
                cArr[i4] = (char) ((int) ((((long) f224[i2 + i4]) ^ (((long) i4) * f226)) ^ ((long) c2)));
                i4++;
            }
            int i6 = f227 + 109;
            f225 = i6 % 128;
            if (i6 % 2 == 0) {
            }
        }
    }
}
