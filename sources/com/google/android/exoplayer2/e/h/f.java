package com.google.android.exoplayer2.e.h;

import android.text.TextUtils;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.exoplayer2.e.h.e;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f31623a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f31624b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f31625c = new StringBuilder();

    public final boolean a(r rVar, e.a aVar, List<d> list) {
        String r = rVar.r();
        if (r == null) {
            return false;
        }
        Matcher matcher = f31623a.matcher(r);
        if (matcher.matches()) {
            return a((String) null, matcher, rVar, aVar, this.f31625c, list);
        }
        String r2 = rVar.r();
        if (r2 == null) {
            return false;
        }
        Matcher matcher2 = f31623a.matcher(r2);
        if (!matcher2.matches()) {
            return false;
        }
        return a(r.trim(), matcher2, rVar, aVar, this.f31625c, list);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(java.lang.String r9, com.google.android.exoplayer2.e.h.e.a r10) {
        /*
            java.util.regex.Pattern r0 = f31624b
            java.util.regex.Matcher r9 = r0.matcher(r9)
        L_0x0006:
            boolean r0 = r9.find()
            if (r0 == 0) goto L_0x0136
            r0 = 1
            java.lang.String r1 = r9.group(r0)
            r2 = 2
            java.lang.String r3 = r9.group(r2)
            java.lang.String r4 = "line"
            boolean r4 = r4.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 44
            r7 = 0
            r8 = -1
            if (r4 == 0) goto L_0x005c
            int r1 = r3.indexOf(r6)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r1 == r8) goto L_0x003b
            int r2 = r1 + 1
            java.lang.String r2 = r3.substring(r2)     // Catch:{ NumberFormatException -> 0x0123 }
            int r2 = a(r2)     // Catch:{ NumberFormatException -> 0x0123 }
            r10.f31620g = r2     // Catch:{ NumberFormatException -> 0x0123 }
            java.lang.String r3 = r3.substring(r7, r1)     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x003d
        L_0x003b:
            r10.f31620g = r5     // Catch:{ NumberFormatException -> 0x0123 }
        L_0x003d:
            java.lang.String r1 = "%"
            boolean r1 = r3.endsWith(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r1 == 0) goto L_0x004e
            float r0 = com.google.android.exoplayer2.e.h.h.b((java.lang.String) r3)     // Catch:{ NumberFormatException -> 0x0123 }
            r10.f31618e = r0     // Catch:{ NumberFormatException -> 0x0123 }
            r10.f31619f = r7     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x0006
        L_0x004e:
            int r1 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r1 >= 0) goto L_0x0056
            int r1 = r1 + -1
        L_0x0056:
            float r1 = (float) r1     // Catch:{ NumberFormatException -> 0x0123 }
            r10.f31618e = r1     // Catch:{ NumberFormatException -> 0x0123 }
            r10.f31619f = r0     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x0006
        L_0x005c:
            java.lang.String r4 = "align"
            boolean r4 = r4.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r4 == 0) goto L_0x00d2
            int r1 = r3.hashCode()     // Catch:{ NumberFormatException -> 0x0123 }
            r4 = 5
            r5 = 4
            r6 = 3
            switch(r1) {
                case -1364013995: goto L_0x00a1;
                case -1074341483: goto L_0x0097;
                case 100571: goto L_0x008d;
                case 3317767: goto L_0x0083;
                case 108511772: goto L_0x0079;
                case 109757538: goto L_0x006f;
                default: goto L_0x006e;
            }     // Catch:{ NumberFormatException -> 0x0123 }
        L_0x006e:
            goto L_0x00ab
        L_0x006f:
            java.lang.String r1 = "start"
            boolean r1 = r3.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r1 == 0) goto L_0x00ab
            goto L_0x00ac
        L_0x0079:
            java.lang.String r1 = "right"
            boolean r1 = r3.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r1 == 0) goto L_0x00ab
            r7 = 5
            goto L_0x00ac
        L_0x0083:
            java.lang.String r1 = "left"
            boolean r1 = r3.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r1 == 0) goto L_0x00ab
            r7 = 1
            goto L_0x00ac
        L_0x008d:
            java.lang.String r1 = "end"
            boolean r1 = r3.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r1 == 0) goto L_0x00ab
            r7 = 4
            goto L_0x00ac
        L_0x0097:
            java.lang.String r1 = "middle"
            boolean r1 = r3.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r1 == 0) goto L_0x00ab
            r7 = 3
            goto L_0x00ac
        L_0x00a1:
            java.lang.String r1 = "center"
            boolean r1 = r3.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r1 == 0) goto L_0x00ab
            r7 = 2
            goto L_0x00ac
        L_0x00ab:
            r7 = -1
        L_0x00ac:
            if (r7 == 0) goto L_0x00cc
            if (r7 == r0) goto L_0x00cc
            if (r7 == r2) goto L_0x00c9
            if (r7 == r6) goto L_0x00c9
            if (r7 == r5) goto L_0x00c6
            if (r7 == r4) goto L_0x00c6
            java.lang.String r0 = "Invalid alignment value: "
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ NumberFormatException -> 0x0123 }
            r0.concat(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            com.google.android.exoplayer2.g.l.c()     // Catch:{ NumberFormatException -> 0x0123 }
            r0 = 0
            goto L_0x00ce
        L_0x00c6:
            android.text.Layout$Alignment r0 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x00ce
        L_0x00c9:
            android.text.Layout$Alignment r0 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x00ce
        L_0x00cc:
            android.text.Layout$Alignment r0 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NumberFormatException -> 0x0123 }
        L_0x00ce:
            r10.f31617d = r0     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x0006
        L_0x00d2:
            java.lang.String r0 = "position"
            boolean r0 = r0.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r0 == 0) goto L_0x00fb
            int r0 = r3.indexOf(r6)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r0 == r8) goto L_0x00f1
            int r1 = r0 + 1
            java.lang.String r1 = r3.substring(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            int r1 = a(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            r10.f31622i = r1     // Catch:{ NumberFormatException -> 0x0123 }
            java.lang.String r3 = r3.substring(r7, r0)     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x00f3
        L_0x00f1:
            r10.f31622i = r5     // Catch:{ NumberFormatException -> 0x0123 }
        L_0x00f3:
            float r0 = com.google.android.exoplayer2.e.h.h.b((java.lang.String) r3)     // Catch:{ NumberFormatException -> 0x0123 }
            r10.f31621h = r0     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x0006
        L_0x00fb:
            java.lang.String r0 = "size"
            boolean r0 = r0.equals(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            if (r0 == 0) goto L_0x010c
            float r0 = com.google.android.exoplayer2.e.h.h.b((java.lang.String) r3)     // Catch:{ NumberFormatException -> 0x0123 }
            r10.j = r0     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x0006
        L_0x010c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0123 }
            java.lang.String r2 = "Unknown cue setting "
            r0.<init>(r2)     // Catch:{ NumberFormatException -> 0x0123 }
            r0.append(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            java.lang.String r1 = ":"
            r0.append(r1)     // Catch:{ NumberFormatException -> 0x0123 }
            r0.append(r3)     // Catch:{ NumberFormatException -> 0x0123 }
            com.google.android.exoplayer2.g.l.c()     // Catch:{ NumberFormatException -> 0x0123 }
            goto L_0x0006
        L_0x0123:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Skipping bad cue setting: "
            r0.<init>(r1)
            java.lang.String r1 = r9.group()
            r0.append(r1)
            com.google.android.exoplayer2.g.l.c()
            goto L_0x0006
        L_0x0136:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.h.f.a(java.lang.String, com.google.android.exoplayer2.e.h.e$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(java.lang.String r16, java.lang.String r17, com.google.android.exoplayer2.e.h.e.a r18, java.util.List<com.google.android.exoplayer2.e.h.d> r19) {
        /*
            r0 = r16
            r1 = r17
            r2 = r19
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder
            r3.<init>()
            java.util.ArrayDeque r4 = new java.util.ArrayDeque
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
            r7 = 0
        L_0x0017:
            int r8 = r17.length()
            if (r7 >= r8) goto L_0x01c0
            char r8 = r1.charAt(r7)
            r9 = 62
            r10 = 60
            r11 = 38
            r13 = 2
            r14 = -1
            r15 = 1
            if (r8 == r11) goto L_0x0123
            if (r8 == r10) goto L_0x0035
            r3.append(r8)
            int r7 = r7 + 1
            goto L_0x011e
        L_0x0035:
            int r8 = r7 + 1
            int r10 = r17.length()
            if (r8 < r10) goto L_0x003f
            r7 = r8
            goto L_0x0017
        L_0x003f:
            char r10 = r1.charAt(r8)
            r11 = 47
            if (r10 != r11) goto L_0x0049
            r10 = 1
            goto L_0x004a
        L_0x0049:
            r10 = 0
        L_0x004a:
            int r8 = r1.indexOf(r9, r8)
            if (r8 != r14) goto L_0x0055
            int r8 = r17.length()
            goto L_0x0057
        L_0x0055:
            int r8 = r8 + 1
        L_0x0057:
            int r9 = r8 + -2
            char r14 = r1.charAt(r9)
            if (r14 != r11) goto L_0x0061
            r11 = 1
            goto L_0x0062
        L_0x0061:
            r11 = 0
        L_0x0062:
            if (r10 == 0) goto L_0x0066
            r14 = 2
            goto L_0x0067
        L_0x0066:
            r14 = 1
        L_0x0067:
            int r7 = r7 + r14
            if (r11 == 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            int r9 = r8 + -1
        L_0x006d:
            java.lang.String r7 = r1.substring(r7, r9)
            java.lang.String r9 = r7.trim()
            boolean r14 = r9.isEmpty()
            if (r14 == 0) goto L_0x007d
            r9 = 0
            goto L_0x0085
        L_0x007d:
            java.lang.String r14 = "[ \\.]"
            java.lang.String[] r9 = com.google.android.exoplayer2.g.ae.b((java.lang.String) r9, (java.lang.String) r14)
            r9 = r9[r6]
        L_0x0085:
            if (r9 == 0) goto L_0x0121
            int r14 = r9.hashCode()
            r6 = 98
            r12 = 4
            if (r14 == r6) goto L_0x00da
            r6 = 99
            if (r14 == r6) goto L_0x00d0
            r6 = 105(0x69, float:1.47E-43)
            if (r14 == r6) goto L_0x00c6
            r6 = 3314158(0x3291ee, float:4.644125E-39)
            if (r14 == r6) goto L_0x00bc
            r6 = 117(0x75, float:1.64E-43)
            if (r14 == r6) goto L_0x00b1
            r6 = 118(0x76, float:1.65E-43)
            if (r14 == r6) goto L_0x00a6
            goto L_0x00e4
        L_0x00a6:
            java.lang.String r6 = "v"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x00e4
            r6 = 5
            goto L_0x00e5
        L_0x00b1:
            java.lang.String r6 = "u"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x00e4
            r6 = 4
            goto L_0x00e5
        L_0x00bc:
            java.lang.String r6 = "lang"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x00e4
            r6 = 3
            goto L_0x00e5
        L_0x00c6:
            java.lang.String r6 = "i"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x00e4
            r6 = 2
            goto L_0x00e5
        L_0x00d0:
            java.lang.String r6 = "c"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x00e4
            r6 = 1
            goto L_0x00e5
        L_0x00da:
            java.lang.String r6 = "b"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x00e4
            r6 = 0
            goto L_0x00e5
        L_0x00e4:
            r6 = -1
        L_0x00e5:
            if (r6 == 0) goto L_0x00f4
            if (r6 == r15) goto L_0x00f4
            if (r6 == r13) goto L_0x00f4
            r13 = 3
            if (r6 == r13) goto L_0x00f4
            if (r6 == r12) goto L_0x00f4
            r12 = 5
            if (r6 == r12) goto L_0x00f4
            r15 = 0
        L_0x00f4:
            if (r15 == 0) goto L_0x0121
            if (r10 == 0) goto L_0x0110
        L_0x00f8:
            boolean r6 = r4.isEmpty()
            if (r6 != 0) goto L_0x0121
            java.lang.Object r6 = r4.pop()
            com.google.android.exoplayer2.e.h.f$a r6 = (com.google.android.exoplayer2.e.h.f.a) r6
            a(r0, r6, r3, r2, r5)
            java.lang.String r6 = r6.f31627a
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x00f8
            goto L_0x0121
        L_0x0110:
            if (r11 != 0) goto L_0x0121
            int r6 = r3.length()
            com.google.android.exoplayer2.e.h.f$a r6 = com.google.android.exoplayer2.e.h.f.a.a(r7, r6)
            r4.push(r6)
            goto L_0x0121
        L_0x011e:
            r6 = 0
            goto L_0x0017
        L_0x0121:
            r7 = r8
            goto L_0x011e
        L_0x0123:
            r6 = 59
            int r7 = r7 + 1
            int r6 = r1.indexOf(r6, r7)
            r12 = 32
            int r14 = r1.indexOf(r12, r7)
            r10 = -1
            if (r6 != r10) goto L_0x0136
            r6 = r14
            goto L_0x013d
        L_0x0136:
            if (r14 != r10) goto L_0x0139
            goto L_0x013d
        L_0x0139:
            int r6 = java.lang.Math.min(r6, r14)
        L_0x013d:
            if (r6 == r10) goto L_0x01bb
            java.lang.String r7 = r1.substring(r7, r6)
            int r8 = r7.hashCode()
            r10 = 3309(0xced, float:4.637E-42)
            if (r8 == r10) goto L_0x0178
            r10 = 3464(0xd88, float:4.854E-42)
            if (r8 == r10) goto L_0x016e
            r10 = 96708(0x179c4, float:1.35517E-40)
            if (r8 == r10) goto L_0x0164
            r10 = 3374865(0x337f11, float:4.729193E-39)
            if (r8 == r10) goto L_0x015a
            goto L_0x0182
        L_0x015a:
            java.lang.String r8 = "nbsp"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0182
            r8 = 2
            goto L_0x0183
        L_0x0164:
            java.lang.String r8 = "amp"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0182
            r8 = 3
            goto L_0x0183
        L_0x016e:
            java.lang.String r8 = "lt"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0182
            r8 = 0
            goto L_0x0183
        L_0x0178:
            java.lang.String r8 = "gt"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0182
            r8 = 1
            goto L_0x0183
        L_0x0182:
            r8 = -1
        L_0x0183:
            if (r8 == 0) goto L_0x01ab
            if (r8 == r15) goto L_0x01a7
            if (r8 == r13) goto L_0x01a3
            r9 = 3
            if (r8 == r9) goto L_0x019f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "ignoring unsupported entity: '&"
            r8.<init>(r9)
            r8.append(r7)
            java.lang.String r7 = ";'"
            r8.append(r7)
            com.google.android.exoplayer2.g.l.c()
            goto L_0x01b0
        L_0x019f:
            r3.append(r11)
            goto L_0x01b0
        L_0x01a3:
            r3.append(r12)
            goto L_0x01b0
        L_0x01a7:
            r3.append(r9)
            goto L_0x01b0
        L_0x01ab:
            r7 = 60
            r3.append(r7)
        L_0x01b0:
            if (r6 != r14) goto L_0x01b7
            java.lang.String r7 = " "
            r3.append(r7)
        L_0x01b7:
            int r7 = r6 + 1
            goto L_0x011e
        L_0x01bb:
            r3.append(r8)
            goto L_0x011e
        L_0x01c0:
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x01d0
            java.lang.Object r1 = r4.pop()
            com.google.android.exoplayer2.e.h.f$a r1 = (com.google.android.exoplayer2.e.h.f.a) r1
            a(r0, r1, r3, r2, r5)
            goto L_0x01c0
        L_0x01d0:
            com.google.android.exoplayer2.e.h.f$a r1 = com.google.android.exoplayer2.e.h.f.a.a()
            a(r0, r1, r3, r2, r5)
            r0 = r18
            r0.f31616c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.h.f.a(java.lang.String, java.lang.String, com.google.android.exoplayer2.e.h.e$a, java.util.List):void");
    }

    private static boolean a(String str, Matcher matcher, r rVar, e.a aVar, StringBuilder sb, List<d> list) {
        try {
            aVar.f31614a = h.a(matcher.group(1));
            aVar.f31615b = h.a(matcher.group(2));
            a(matcher.group(3), aVar);
            sb.setLength(0);
            while (true) {
                String r = rVar.r();
                if (!TextUtils.isEmpty(r)) {
                    if (sb.length() > 0) {
                        sb.append(StringUtility.NEW_LINE);
                    }
                    sb.append(r.trim());
                } else {
                    a(str, sb.toString(), aVar, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            new StringBuilder("Skipping cue with bad header: ").append(matcher.group());
            l.c();
            return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L_0x002b;
                case -1074341483: goto L_0x0021;
                case 100571: goto L_0x0017;
                case 109757538: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0035
        L_0x000c:
            java.lang.String r0 = "start"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0035
            r0 = 0
            goto L_0x0036
        L_0x0017:
            java.lang.String r0 = "end"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0035
            r0 = 3
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "middle"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0035
            r0 = 2
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "center"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0035
            r0 = 1
            goto L_0x0036
        L_0x0035:
            r0 = -1
        L_0x0036:
            if (r0 == 0) goto L_0x004f
            if (r0 == r4) goto L_0x004e
            if (r0 == r3) goto L_0x004e
            if (r0 == r2) goto L_0x004d
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r0 = "Invalid anchor value: "
            r0.concat(r5)
            com.google.android.exoplayer2.g.l.c()
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            return r5
        L_0x004d:
            return r3
        L_0x004e:
            return r4
        L_0x004f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.h.f.a(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r10, com.google.android.exoplayer2.e.h.f.a r11, android.text.SpannableStringBuilder r12, java.util.List<com.google.android.exoplayer2.e.h.d> r13, java.util.List<com.google.android.exoplayer2.e.h.f.b> r14) {
        /*
            int r0 = r11.f31628b
            int r1 = r12.length()
            java.lang.String r2 = r11.f31627a
            int r3 = r2.hashCode()
            r4 = 3
            r5 = -1
            r6 = 2
            r7 = 0
            r8 = 1
            if (r3 == 0) goto L_0x006b
            r9 = 105(0x69, float:1.47E-43)
            if (r3 == r9) goto L_0x0061
            r9 = 3314158(0x3291ee, float:4.644125E-39)
            if (r3 == r9) goto L_0x0057
            r9 = 98
            if (r3 == r9) goto L_0x004d
            r9 = 99
            if (r3 == r9) goto L_0x0043
            r9 = 117(0x75, float:1.64E-43)
            if (r3 == r9) goto L_0x0038
            r9 = 118(0x76, float:1.65E-43)
            if (r3 == r9) goto L_0x002d
            goto L_0x0075
        L_0x002d:
            java.lang.String r3 = "v"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0075
            r2 = 5
            goto L_0x0076
        L_0x0038:
            java.lang.String r3 = "u"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0075
            r2 = 2
            goto L_0x0076
        L_0x0043:
            java.lang.String r3 = "c"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0075
            r2 = 3
            goto L_0x0076
        L_0x004d:
            java.lang.String r3 = "b"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0075
            r2 = 0
            goto L_0x0076
        L_0x0057:
            java.lang.String r3 = "lang"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0075
            r2 = 4
            goto L_0x0076
        L_0x0061:
            java.lang.String r3 = "i"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0075
            r2 = 1
            goto L_0x0076
        L_0x006b:
            java.lang.String r3 = ""
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0075
            r2 = 6
            goto L_0x0076
        L_0x0075:
            r2 = -1
        L_0x0076:
            r3 = 33
            switch(r2) {
                case 0: goto L_0x008e;
                case 1: goto L_0x0085;
                case 2: goto L_0x007c;
                case 3: goto L_0x0096;
                case 4: goto L_0x0096;
                case 5: goto L_0x0096;
                case 6: goto L_0x0096;
                default: goto L_0x007b;
            }
        L_0x007b:
            return
        L_0x007c:
            android.text.style.UnderlineSpan r2 = new android.text.style.UnderlineSpan
            r2.<init>()
            r12.setSpan(r2, r0, r1, r3)
            goto L_0x0096
        L_0x0085:
            android.text.style.StyleSpan r2 = new android.text.style.StyleSpan
            r2.<init>(r6)
            r12.setSpan(r2, r0, r1, r3)
            goto L_0x0096
        L_0x008e:
            android.text.style.StyleSpan r2 = new android.text.style.StyleSpan
            r2.<init>(r8)
            r12.setSpan(r2, r0, r1, r3)
        L_0x0096:
            r14.clear()
            a((java.util.List<com.google.android.exoplayer2.e.h.d>) r13, (java.lang.String) r10, (com.google.android.exoplayer2.e.h.f.a) r11, (java.util.List<com.google.android.exoplayer2.e.h.f.b>) r14)
            int r10 = r14.size()
            r11 = 0
        L_0x00a1:
            if (r11 >= r10) goto L_0x0164
            java.lang.Object r13 = r14.get(r11)
            com.google.android.exoplayer2.e.h.f$b r13 = (com.google.android.exoplayer2.e.h.f.b) r13
            com.google.android.exoplayer2.e.h.d r13 = r13.f31632b
            if (r13 == 0) goto L_0x0160
            int r2 = r13.a()
            if (r2 == r5) goto L_0x00bf
            android.text.style.StyleSpan r2 = new android.text.style.StyleSpan
            int r9 = r13.a()
            r2.<init>(r9)
            r12.setSpan(r2, r0, r1, r3)
        L_0x00bf:
            int r2 = r13.j
            if (r2 != r8) goto L_0x00c5
            r2 = 1
            goto L_0x00c6
        L_0x00c5:
            r2 = 0
        L_0x00c6:
            if (r2 == 0) goto L_0x00d0
            android.text.style.StrikethroughSpan r2 = new android.text.style.StrikethroughSpan
            r2.<init>()
            r12.setSpan(r2, r0, r1, r3)
        L_0x00d0:
            int r2 = r13.k
            if (r2 != r8) goto L_0x00d6
            r2 = 1
            goto L_0x00d7
        L_0x00d6:
            r2 = 0
        L_0x00d7:
            if (r2 == 0) goto L_0x00e1
            android.text.style.UnderlineSpan r2 = new android.text.style.UnderlineSpan
            r2.<init>()
            r12.setSpan(r2, r0, r1, r3)
        L_0x00e1:
            boolean r2 = r13.f31610g
            if (r2 == 0) goto L_0x00fc
            android.text.style.ForegroundColorSpan r2 = new android.text.style.ForegroundColorSpan
            boolean r9 = r13.f31610g
            if (r9 == 0) goto L_0x00f4
            int r9 = r13.f31609f
            r2.<init>(r9)
            r12.setSpan(r2, r0, r1, r3)
            goto L_0x00fc
        L_0x00f4:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Font color not defined"
            r10.<init>(r11)
            throw r10
        L_0x00fc:
            boolean r2 = r13.f31612i
            if (r2 == 0) goto L_0x0117
            android.text.style.BackgroundColorSpan r2 = new android.text.style.BackgroundColorSpan
            boolean r9 = r13.f31612i
            if (r9 == 0) goto L_0x010f
            int r9 = r13.f31611h
            r2.<init>(r9)
            r12.setSpan(r2, r0, r1, r3)
            goto L_0x0117
        L_0x010f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Background color not defined."
            r10.<init>(r11)
            throw r10
        L_0x0117:
            java.lang.String r2 = r13.f31608e
            if (r2 == 0) goto L_0x0125
            android.text.style.TypefaceSpan r2 = new android.text.style.TypefaceSpan
            java.lang.String r9 = r13.f31608e
            r2.<init>(r9)
            r12.setSpan(r2, r0, r1, r3)
        L_0x0125:
            android.text.Layout$Alignment r2 = r13.p
            if (r2 == 0) goto L_0x0133
            android.text.style.AlignmentSpan$Standard r2 = new android.text.style.AlignmentSpan$Standard
            android.text.Layout$Alignment r9 = r13.p
            r2.<init>(r9)
            r12.setSpan(r2, r0, r1, r3)
        L_0x0133:
            int r2 = r13.n
            if (r2 == r8) goto L_0x0155
            if (r2 == r6) goto L_0x014a
            if (r2 == r4) goto L_0x013c
            goto L_0x0160
        L_0x013c:
            android.text.style.RelativeSizeSpan r2 = new android.text.style.RelativeSizeSpan
            float r13 = r13.o
            r9 = 1120403456(0x42c80000, float:100.0)
            float r13 = r13 / r9
            r2.<init>(r13)
            r12.setSpan(r2, r0, r1, r3)
            goto L_0x0160
        L_0x014a:
            android.text.style.RelativeSizeSpan r2 = new android.text.style.RelativeSizeSpan
            float r13 = r13.o
            r2.<init>(r13)
            r12.setSpan(r2, r0, r1, r3)
            goto L_0x0160
        L_0x0155:
            android.text.style.AbsoluteSizeSpan r2 = new android.text.style.AbsoluteSizeSpan
            float r13 = r13.o
            int r13 = (int) r13
            r2.<init>(r13, r8)
            r12.setSpan(r2, r0, r1, r3)
        L_0x0160:
            int r11 = r11 + 1
            goto L_0x00a1
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.h.f.a(java.lang.String, com.google.android.exoplayer2.e.h.f$a, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.util.List<com.google.android.exoplayer2.e.h.d> r10, java.lang.String r11, com.google.android.exoplayer2.e.h.f.a r12, java.util.List<com.google.android.exoplayer2.e.h.f.b> r13) {
        /*
            int r0 = r10.size()
            r1 = 0
            r2 = 0
        L_0x0006:
            if (r2 >= r0) goto L_0x007a
            java.lang.Object r3 = r10.get(r2)
            com.google.android.exoplayer2.e.h.d r3 = (com.google.android.exoplayer2.e.h.d) r3
            java.lang.String r4 = r12.f31627a
            java.lang.String[] r5 = r12.f31630d
            java.lang.String r6 = r12.f31629c
            java.lang.String r7 = r3.f31604a
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x003c
            java.lang.String r7 = r3.f31605b
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x003c
            java.util.List<java.lang.String> r7 = r3.f31606c
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x003c
            java.lang.String r7 = r3.f31607d
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x003c
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x006c
            r4 = 1
            goto L_0x006d
        L_0x003c:
            java.lang.String r7 = r3.f31604a
            r8 = 1073741824(0x40000000, float:2.0)
            int r7 = com.google.android.exoplayer2.e.h.d.a(r1, r7, r11, r8)
            java.lang.String r8 = r3.f31605b
            r9 = 2
            int r4 = com.google.android.exoplayer2.e.h.d.a(r7, r8, r4, r9)
            java.lang.String r7 = r3.f31607d
            r8 = 4
            int r4 = com.google.android.exoplayer2.e.h.d.a(r4, r7, r6, r8)
            r6 = -1
            if (r4 == r6) goto L_0x006c
            java.util.List r5 = java.util.Arrays.asList(r5)
            java.util.List<java.lang.String> r6 = r3.f31606c
            boolean r5 = r5.containsAll(r6)
            if (r5 != 0) goto L_0x0062
            goto L_0x006c
        L_0x0062:
            java.util.List<java.lang.String> r5 = r3.f31606c
            int r5 = r5.size()
            int r5 = r5 * 4
            int r4 = r4 + r5
            goto L_0x006d
        L_0x006c:
            r4 = 0
        L_0x006d:
            if (r4 <= 0) goto L_0x0077
            com.google.android.exoplayer2.e.h.f$b r5 = new com.google.android.exoplayer2.e.h.f$b
            r5.<init>(r4, r3)
            r13.add(r5)
        L_0x0077:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x007a:
            java.util.Collections.sort(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.h.f.a(java.util.List, java.lang.String, com.google.android.exoplayer2.e.h.f$a, java.util.List):void");
    }

    static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final int f31631a;

        /* renamed from: b  reason: collision with root package name */
        public final d f31632b;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f31631a - ((b) obj).f31631a;
        }

        public b(int i2, d dVar) {
            this.f31631a = i2;
            this.f31632b = dVar;
        }
    }

    static final class a {

        /* renamed from: e  reason: collision with root package name */
        private static final String[] f31626e = new String[0];

        /* renamed from: a  reason: collision with root package name */
        public final String f31627a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31628b;

        /* renamed from: c  reason: collision with root package name */
        public final String f31629c;

        /* renamed from: d  reason: collision with root package name */
        public final String[] f31630d;

        private a(String str, int i2, String str2, String[] strArr) {
            this.f31628b = i2;
            this.f31627a = str;
            this.f31629c = str2;
            this.f31630d = strArr;
        }

        public static a a(String str, int i2) {
            String str2;
            String[] strArr;
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] a2 = ae.a(trim, "\\.");
            String str3 = a2[0];
            if (a2.length > 1) {
                strArr = (String[]) Arrays.copyOfRange(a2, 1, a2.length);
            } else {
                strArr = f31626e;
            }
            return new a(str3, i2, str2, strArr);
        }

        public static a a() {
            return new a("", 0, "", new String[0]);
        }
    }
}
