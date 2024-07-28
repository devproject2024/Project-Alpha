package net.one97.paytm.feed.utility;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class d {
    /* JADX WARNING: Removed duplicated region for block: B:93:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.CharSequence a(java.lang.CharSequence r14, java.util.Calendar r15) {
        /*
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>(r14)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            net.one97.paytm.feed.utility.p r1 = net.one97.paytm.feed.utility.p.a(r1)
            int r14 = r14.length()
            r2 = 0
            r3 = r14
            r14 = 0
        L_0x0012:
            if (r14 >= r3) goto L_0x01b0
            char r4 = r0.charAt(r14)
            r5 = 39
            if (r4 != r5) goto L_0x0026
            int r3 = a(r0, r14, r3)
            int r4 = r0.length()
            goto L_0x01ac
        L_0x0026:
            r5 = 1
            r6 = 1
        L_0x0028:
            int r7 = r14 + r6
            if (r7 >= r3) goto L_0x0035
            char r8 = r0.charAt(r7)
            if (r8 != r4) goto L_0x0035
            int r6 = r6 + 1
            goto L_0x0028
        L_0x0035:
            r8 = 65
            if (r4 == r8) goto L_0x0191
            r8 = 69
            r9 = 4
            r10 = 99
            r11 = 5
            if (r4 == r8) goto L_0x0160
            r8 = 72
            if (r4 == r8) goto L_0x0155
            r8 = 97
            if (r4 == r8) goto L_0x0191
            r8 = 12
            r12 = 104(0x68, float:1.46E-43)
            if (r4 == r12) goto L_0x0144
            r13 = 107(0x6b, float:1.5E-43)
            if (r4 == r13) goto L_0x0155
            r13 = 109(0x6d, float:1.53E-43)
            if (r4 == r13) goto L_0x013b
            r13 = 115(0x73, float:1.61E-43)
            if (r4 == r13) goto L_0x012f
            if (r4 == r10) goto L_0x0160
            r10 = 100
            if (r4 == r10) goto L_0x0125
            r10 = 121(0x79, float:1.7E-43)
            r13 = 2
            if (r4 == r10) goto L_0x0103
            r10 = 122(0x7a, float:1.71E-43)
            if (r4 == r10) goto L_0x00b3
            switch(r4) {
                case 75: goto L_0x0144;
                case 76: goto L_0x0070;
                case 77: goto L_0x0070;
                default: goto L_0x006d;
            }
        L_0x006d:
            r4 = 0
            goto L_0x019c
        L_0x0070:
            int r8 = r15.get(r13)
            r10 = 76
            if (r4 != r10) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r5 = 0
        L_0x007a:
            if (r6 != r11) goto L_0x008a
            if (r5 == 0) goto L_0x0084
            java.lang.String[] r4 = r1.f35417g
            r4 = r4[r8]
            goto L_0x019c
        L_0x0084:
            java.lang.String[] r4 = r1.f35414d
            r4 = r4[r8]
            goto L_0x019c
        L_0x008a:
            if (r6 != r9) goto L_0x009a
            if (r5 == 0) goto L_0x0094
            java.lang.String[] r4 = r1.f35415e
            r4 = r4[r8]
            goto L_0x019c
        L_0x0094:
            java.lang.String[] r4 = r1.f35412b
            r4 = r4[r8]
            goto L_0x019c
        L_0x009a:
            r4 = 3
            if (r6 != r4) goto L_0x00ab
            if (r5 == 0) goto L_0x00a5
            java.lang.String[] r4 = r1.f35416f
            r4 = r4[r8]
            goto L_0x019c
        L_0x00a5:
            java.lang.String[] r4 = r1.f35413c
            r4 = r4[r8]
            goto L_0x019c
        L_0x00ab:
            int r8 = r8 + 1
            java.lang.String r4 = a((int) r8, (int) r6)
            goto L_0x019c
        L_0x00b3:
            java.util.TimeZone r4 = r15.getTimeZone()
            r8 = 16
            if (r6 >= r13) goto L_0x00f5
            int r4 = r15.get(r8)
            r5 = 15
            int r5 = r15.get(r5)
            int r4 = r4 + r5
            int r4 = r4 / 1000
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            if (r4 >= 0) goto L_0x00d6
            java.lang.String r8 = "-"
            r5.insert(r2, r8)
            int r4 = -r4
            goto L_0x00db
        L_0x00d6:
            java.lang.String r8 = "+"
            r5.insert(r2, r8)
        L_0x00db:
            int r8 = r4 / 3600
            int r4 = r4 % 3600
            int r4 = r4 / 60
            java.lang.String r8 = a((int) r8, (int) r13)
            r5.append(r8)
            java.lang.String r4 = a((int) r4, (int) r13)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x019c
        L_0x00f5:
            int r8 = r15.get(r8)
            if (r8 == 0) goto L_0x00fc
            goto L_0x00fd
        L_0x00fc:
            r5 = 0
        L_0x00fd:
            java.lang.String r4 = r4.getDisplayName(r5, r2)
            goto L_0x019c
        L_0x0103:
            int r4 = r15.get(r5)
            if (r6 > r13) goto L_0x0111
            int r4 = r4 % 100
            java.lang.String r4 = a((int) r4, (int) r13)
            goto L_0x019c
        L_0x0111:
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5[r2] = r4
            java.lang.String r4 = "%d"
            java.lang.String r4 = java.lang.String.format(r8, r4, r5)
            goto L_0x019c
        L_0x0125:
            int r4 = r15.get(r11)
            java.lang.String r4 = a((int) r4, (int) r6)
            goto L_0x019c
        L_0x012f:
            r4 = 13
            int r4 = r15.get(r4)
            java.lang.String r4 = a((int) r4, (int) r6)
            goto L_0x019c
        L_0x013b:
            int r4 = r15.get(r8)
            java.lang.String r4 = a((int) r4, (int) r6)
            goto L_0x019c
        L_0x0144:
            r5 = 10
            int r5 = r15.get(r5)
            if (r4 != r12) goto L_0x0150
            if (r5 != 0) goto L_0x0150
            r5 = 12
        L_0x0150:
            java.lang.String r4 = a((int) r5, (int) r6)
            goto L_0x019c
        L_0x0155:
            r4 = 11
            int r4 = r15.get(r4)
            java.lang.String r4 = a((int) r4, (int) r6)
            goto L_0x019c
        L_0x0160:
            r8 = 7
            int r8 = r15.get(r8)
            if (r4 != r10) goto L_0x0168
            goto L_0x0169
        L_0x0168:
            r5 = 0
        L_0x0169:
            if (r6 != r11) goto L_0x0177
            if (r5 == 0) goto L_0x0172
            java.lang.String[] r4 = r1.m
            r4 = r4[r8]
            goto L_0x019c
        L_0x0172:
            java.lang.String[] r4 = r1.j
            r4 = r4[r8]
            goto L_0x019c
        L_0x0177:
            if (r6 != r9) goto L_0x0185
            if (r5 == 0) goto L_0x0180
            java.lang.String[] r4 = r1.k
            r4 = r4[r8]
            goto L_0x019c
        L_0x0180:
            java.lang.String[] r4 = r1.f35418h
            r4 = r4[r8]
            goto L_0x019c
        L_0x0185:
            if (r5 == 0) goto L_0x018c
            java.lang.String[] r4 = r1.l
            r4 = r4[r8]
            goto L_0x019c
        L_0x018c:
            java.lang.String[] r4 = r1.f35419i
            r4 = r4[r8]
            goto L_0x019c
        L_0x0191:
            java.lang.String[] r4 = r1.f35411a
            r5 = 9
            int r5 = r15.get(r5)
            int r5 = r5 - r2
            r4 = r4[r5]
        L_0x019c:
            if (r4 == 0) goto L_0x01aa
            r0.replace(r14, r7, r4)
            int r3 = r4.length()
            int r4 = r0.length()
            goto L_0x01ac
        L_0x01aa:
            r4 = r3
            r3 = r6
        L_0x01ac:
            int r14 = r14 + r3
            r3 = r4
            goto L_0x0012
        L_0x01b0:
            java.lang.String r14 = r0.toString()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.utility.d.a(java.lang.CharSequence, java.util.Calendar):java.lang.CharSequence");
    }

    private static int a(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        int i4;
        int i5 = i2 + 1;
        if (i5 >= i3 || spannableStringBuilder.charAt(i5) != '\'') {
            int i6 = 0;
            spannableStringBuilder.delete(i2, i5);
            int i7 = i3 - 1;
            while (true) {
                if (i2 >= i7) {
                    break;
                } else if (spannableStringBuilder.charAt(i2) == '\'') {
                    i4 = i2 + 1;
                    if (i4 >= i7 || spannableStringBuilder.charAt(i4) != '\'') {
                        spannableStringBuilder.delete(i2, i4);
                    } else {
                        spannableStringBuilder.delete(i2, i4);
                        i7--;
                        i6++;
                        i2 = i4;
                    }
                } else {
                    i2++;
                    i6++;
                }
            }
            spannableStringBuilder.delete(i2, i4);
            return i6;
        }
        spannableStringBuilder.delete(i2, i5);
        return 1;
    }

    private static String a(int i2, int i3) {
        Locale locale = Locale.getDefault();
        return String.format(locale, "%0" + i3 + "d", new Object[]{Integer.valueOf(i2)});
    }
}
