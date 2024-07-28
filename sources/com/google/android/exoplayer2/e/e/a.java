package com.google.android.exoplayer2.e.e;

import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f31533c = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f31534d = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f31535e = new StringBuilder();

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<String> f31536f = new ArrayList<>();

    public final /* bridge */ /* synthetic */ e a(byte[] bArr, int i2, boolean z) throws g {
        return a(bArr, i2);
    }

    public a() {
        super("SubripDecoder");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.e.e.b a(byte[] r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.google.android.exoplayer2.g.m r2 = new com.google.android.exoplayer2.g.m
            r2.<init>()
            com.google.android.exoplayer2.g.r r3 = new com.google.android.exoplayer2.g.r
            r4 = r19
            r5 = r20
            r3.<init>(r4, r5)
        L_0x0015:
            java.lang.String r4 = r3.r()
            if (r4 == 0) goto L_0x01ec
            int r5 = r4.length()
            if (r5 == 0) goto L_0x01e8
            java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x01dc }
            java.lang.String r4 = r3.r()
            if (r4 != 0) goto L_0x002f
            com.google.android.exoplayer2.g.l.c()
            goto L_0x01ec
        L_0x002f:
            java.util.regex.Pattern r5 = f31533c
            java.util.regex.Matcher r5 = r5.matcher(r4)
            boolean r6 = r5.matches()
            if (r6 == 0) goto L_0x01cf
            r4 = 1
            long r6 = a((java.util.regex.Matcher) r5, (int) r4)
            r2.a((long) r6)
            r6 = 6
            java.lang.String r7 = r5.group(r6)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r8 = 0
            if (r7 != 0) goto L_0x0058
            long r9 = a((java.util.regex.Matcher) r5, (int) r6)
            r2.a((long) r9)
            r5 = 1
            goto L_0x0059
        L_0x0058:
            r5 = 0
        L_0x0059:
            java.lang.StringBuilder r7 = r0.f31535e
            r7.setLength(r8)
            java.util.ArrayList<java.lang.String> r7 = r0.f31536f
            r7.clear()
            java.lang.String r7 = r3.r()
        L_0x0067:
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L_0x008c
            java.lang.StringBuilder r9 = r0.f31535e
            int r9 = r9.length()
            if (r9 <= 0) goto L_0x007c
            java.lang.StringBuilder r9 = r0.f31535e
            java.lang.String r10 = "<br>"
            r9.append(r10)
        L_0x007c:
            java.lang.StringBuilder r9 = r0.f31535e
            java.util.ArrayList<java.lang.String> r10 = r0.f31536f
            java.lang.String r7 = a((java.lang.String) r7, (java.util.ArrayList<java.lang.String>) r10)
            r9.append(r7)
            java.lang.String r7 = r3.r()
            goto L_0x0067
        L_0x008c:
            java.lang.StringBuilder r7 = r0.f31535e
            java.lang.String r7 = r7.toString()
            android.text.Spanned r10 = android.text.Html.fromHtml(r7)
            r7 = 0
            r9 = 0
        L_0x0098:
            java.util.ArrayList<java.lang.String> r11 = r0.f31536f
            int r11 = r11.size()
            if (r9 >= r11) goto L_0x00b5
            java.util.ArrayList<java.lang.String> r11 = r0.f31536f
            java.lang.Object r11 = r11.get(r9)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "\\{\\\\an[1-9]\\}"
            boolean r12 = r11.matches(r12)
            if (r12 == 0) goto L_0x00b2
            r7 = r11
            goto L_0x00b5
        L_0x00b2:
            int r9 = r9 + 1
            goto L_0x0098
        L_0x00b5:
            if (r7 != 0) goto L_0x00be
            com.google.android.exoplayer2.e.b r4 = new com.google.android.exoplayer2.e.b
            r4.<init>(r10)
            goto L_0x01c4
        L_0x00be:
            int r9 = r7.hashCode()
            java.lang.String r11 = "{\\an7}"
            java.lang.String r12 = "{\\an6}"
            java.lang.String r13 = "{\\an5}"
            java.lang.String r14 = "{\\an4}"
            java.lang.String r15 = "{\\an3}"
            java.lang.String r6 = "{\\an2}"
            java.lang.String r8 = "{\\an1}"
            r16 = -1
            r4 = 2
            switch(r9) {
                case -685620710: goto L_0x0125;
                case -685620679: goto L_0x011d;
                case -685620648: goto L_0x0115;
                case -685620617: goto L_0x010d;
                case -685620586: goto L_0x0105;
                case -685620555: goto L_0x00fd;
                case -685620524: goto L_0x00f5;
                case -685620493: goto L_0x00e9;
                case -685620462: goto L_0x00de;
                default: goto L_0x00dd;
            }
        L_0x00dd:
            goto L_0x012d
        L_0x00de:
            java.lang.String r9 = "{\\an9}"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x012d
            r9 = 5
            goto L_0x012e
        L_0x00e9:
            java.lang.String r9 = "{\\an8}"
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x012d
            r9 = 8
            goto L_0x012e
        L_0x00f5:
            boolean r9 = r7.equals(r11)
            if (r9 == 0) goto L_0x012d
            r9 = 2
            goto L_0x012e
        L_0x00fd:
            boolean r9 = r7.equals(r12)
            if (r9 == 0) goto L_0x012d
            r9 = 4
            goto L_0x012e
        L_0x0105:
            boolean r9 = r7.equals(r13)
            if (r9 == 0) goto L_0x012d
            r9 = 7
            goto L_0x012e
        L_0x010d:
            boolean r9 = r7.equals(r14)
            if (r9 == 0) goto L_0x012d
            r9 = 1
            goto L_0x012e
        L_0x0115:
            boolean r9 = r7.equals(r15)
            if (r9 == 0) goto L_0x012d
            r9 = 3
            goto L_0x012e
        L_0x011d:
            boolean r9 = r7.equals(r6)
            if (r9 == 0) goto L_0x012d
            r9 = 6
            goto L_0x012e
        L_0x0125:
            boolean r9 = r7.equals(r8)
            if (r9 == 0) goto L_0x012d
            r9 = 0
            goto L_0x012e
        L_0x012d:
            r9 = -1
        L_0x012e:
            if (r9 == 0) goto L_0x0142
            r0 = 1
            if (r9 == r0) goto L_0x0142
            if (r9 == r4) goto L_0x0142
            r0 = 3
            if (r9 == r0) goto L_0x0140
            r0 = 4
            if (r9 == r0) goto L_0x0140
            r0 = 5
            if (r9 == r0) goto L_0x0140
            r0 = 1
            goto L_0x0143
        L_0x0140:
            r0 = 2
            goto L_0x0143
        L_0x0142:
            r0 = 0
        L_0x0143:
            int r9 = r7.hashCode()
            switch(r9) {
                case -685620710: goto L_0x0192;
                case -685620679: goto L_0x018a;
                case -685620648: goto L_0x0182;
                case -685620617: goto L_0x017a;
                case -685620586: goto L_0x0172;
                case -685620555: goto L_0x0169;
                case -685620524: goto L_0x0161;
                case -685620493: goto L_0x0156;
                case -685620462: goto L_0x014b;
                default: goto L_0x014a;
            }
        L_0x014a:
            goto L_0x019a
        L_0x014b:
            java.lang.String r6 = "{\\an9}"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x019a
            r6 = 5
            goto L_0x019b
        L_0x0156:
            java.lang.String r6 = "{\\an8}"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x019a
            r6 = 4
            goto L_0x019b
        L_0x0161:
            boolean r6 = r7.equals(r11)
            if (r6 == 0) goto L_0x019a
            r6 = 3
            goto L_0x019b
        L_0x0169:
            boolean r6 = r7.equals(r12)
            if (r6 == 0) goto L_0x019a
            r6 = 8
            goto L_0x019b
        L_0x0172:
            boolean r6 = r7.equals(r13)
            if (r6 == 0) goto L_0x019a
            r6 = 7
            goto L_0x019b
        L_0x017a:
            boolean r6 = r7.equals(r14)
            if (r6 == 0) goto L_0x019a
            r6 = 6
            goto L_0x019b
        L_0x0182:
            boolean r6 = r7.equals(r15)
            if (r6 == 0) goto L_0x019a
            r6 = 2
            goto L_0x019b
        L_0x018a:
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x019a
            r6 = 1
            goto L_0x019b
        L_0x0192:
            boolean r6 = r7.equals(r8)
            if (r6 == 0) goto L_0x019a
            r6 = 0
            goto L_0x019b
        L_0x019a:
            r6 = -1
        L_0x019b:
            if (r6 == 0) goto L_0x01af
            r7 = 1
            if (r6 == r7) goto L_0x01af
            if (r6 == r4) goto L_0x01af
            r8 = 3
            if (r6 == r8) goto L_0x01ad
            r4 = 4
            if (r6 == r4) goto L_0x01ad
            r4 = 5
            if (r6 == r4) goto L_0x01ad
            r14 = 1
            goto L_0x01b0
        L_0x01ad:
            r14 = 0
            goto L_0x01b0
        L_0x01af:
            r14 = 2
        L_0x01b0:
            com.google.android.exoplayer2.e.b r4 = new com.google.android.exoplayer2.e.b
            r11 = 0
            float r12 = a(r14)
            r13 = 0
            float r15 = a(r0)
            r17 = 1
            r9 = r4
            r16 = r0
            r9.<init>((java.lang.CharSequence) r10, (android.text.Layout.Alignment) r11, (float) r12, (int) r13, (int) r14, (float) r15, (int) r16, (float) r17)
        L_0x01c4:
            r1.add(r4)
            if (r5 == 0) goto L_0x01e8
            com.google.android.exoplayer2.e.b r0 = com.google.android.exoplayer2.e.b.f31445a
            r1.add(r0)
            goto L_0x01e8
        L_0x01cf:
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r4 = "Skipping invalid timing: "
            r4.concat(r0)
            com.google.android.exoplayer2.g.l.c()
            goto L_0x01e8
        L_0x01dc:
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r4 = "Skipping invalid index: "
            r4.concat(r0)
            com.google.android.exoplayer2.g.l.c()
        L_0x01e8:
            r0 = r18
            goto L_0x0015
        L_0x01ec:
            int r0 = r1.size()
            com.google.android.exoplayer2.e.b[] r0 = new com.google.android.exoplayer2.e.b[r0]
            r1.toArray(r0)
            long[] r1 = r2.a()
            com.google.android.exoplayer2.e.e.b r2 = new com.google.android.exoplayer2.e.e.b
            r2.<init>(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.e.a.a(byte[], int):com.google.android.exoplayer2.e.e.b");
    }

    private static String a(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = f31534d.matcher(trim);
        int i2 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i2;
            int length = group.length();
            sb.replace(start, start + length, "");
            i2 += length;
        }
        return sb.toString();
    }

    private static long a(Matcher matcher, int i2) {
        return ((Long.parseLong(matcher.group(i2 + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 3)) * 1000) + Long.parseLong(matcher.group(i2 + 4))) * 1000;
    }

    private static float a(int i2) {
        if (i2 == 0) {
            return 0.08f;
        }
        if (i2 == 1) {
            return 0.5f;
        }
        if (i2 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }
}
