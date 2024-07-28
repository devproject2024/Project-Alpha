package com.google.android.exoplayer2.e.h;

import com.google.android.exoplayer2.g.r;
import java.util.regex.Pattern;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f31595a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: b  reason: collision with root package name */
    private final r f31596b = new r();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f31597c = new StringBuilder();

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0076, code lost:
        if (r0 != null) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.exoplayer2.e.h.d> a(com.google.android.exoplayer2.g.r r14) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = r13.f31597c
            r1 = 0
            r0.setLength(r1)
            int r0 = r14.f32567b
        L_0x0008:
            java.lang.String r2 = r14.r()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0008
            com.google.android.exoplayer2.g.r r2 = r13.f31596b
            byte[] r3 = r14.f32566a
            int r14 = r14.f32567b
            r2.a((byte[]) r3, (int) r14)
            com.google.android.exoplayer2.g.r r14 = r13.f31596b
            r14.c(r0)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x0025:
            com.google.android.exoplayer2.g.r r0 = r13.f31596b
            java.lang.StringBuilder r2 = r13.f31597c
            c(r0)
            int r3 = r0.b()
            java.lang.String r4 = "{"
            r5 = 5
            java.lang.String r6 = ""
            r7 = 0
            if (r3 >= r5) goto L_0x003b
        L_0x0039:
            r3 = r7
            goto L_0x0079
        L_0x003b:
            java.lang.String r3 = r0.e(r5)
            java.lang.String r5 = "::cue"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L_0x0048
            goto L_0x0039
        L_0x0048:
            int r3 = r0.f32567b
            java.lang.String r5 = a(r0, r2)
            if (r5 != 0) goto L_0x0051
            goto L_0x0039
        L_0x0051:
            boolean r8 = r4.equals(r5)
            if (r8 == 0) goto L_0x005c
            r0.c(r3)
            r3 = r6
            goto L_0x0079
        L_0x005c:
            java.lang.String r3 = "("
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0069
            java.lang.String r3 = b(r0)
            goto L_0x006a
        L_0x0069:
            r3 = r7
        L_0x006a:
            java.lang.String r0 = a(r0, r2)
            java.lang.String r2 = ")"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0039
            if (r0 != 0) goto L_0x0079
            goto L_0x0039
        L_0x0079:
            if (r3 == 0) goto L_0x01cd
            com.google.android.exoplayer2.g.r r0 = r13.f31596b
            java.lang.StringBuilder r2 = r13.f31597c
            java.lang.String r0 = a(r0, r2)
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x008a
            return r14
        L_0x008a:
            com.google.android.exoplayer2.e.h.d r0 = new com.google.android.exoplayer2.e.h.d
            r0.<init>()
            boolean r2 = r6.equals(r3)
            r4 = 1
            if (r2 != 0) goto L_0x00ea
            r2 = 91
            int r2 = r3.indexOf(r2)
            r5 = -1
            if (r2 == r5) goto L_0x00b9
            java.util.regex.Pattern r8 = f31595a
            java.lang.String r9 = r3.substring(r2)
            java.util.regex.Matcher r8 = r8.matcher(r9)
            boolean r9 = r8.matches()
            if (r9 == 0) goto L_0x00b5
            java.lang.String r8 = r8.group(r4)
            r0.f31607d = r8
        L_0x00b5:
            java.lang.String r3 = r3.substring(r1, r2)
        L_0x00b9:
            java.lang.String r2 = "\\."
            java.lang.String[] r2 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r3, (java.lang.String) r2)
            r3 = r2[r1]
            r8 = 35
            int r8 = r3.indexOf(r8)
            if (r8 == r5) goto L_0x00d8
            java.lang.String r5 = r3.substring(r1, r8)
            r0.f31605b = r5
            int r8 = r8 + 1
            java.lang.String r3 = r3.substring(r8)
            r0.f31604a = r3
            goto L_0x00da
        L_0x00d8:
            r0.f31605b = r3
        L_0x00da:
            int r3 = r2.length
            if (r3 <= r4) goto L_0x00ea
            int r3 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOfRange(r2, r4, r3)
            java.lang.String[] r2 = (java.lang.String[]) r2
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.f31606c = r2
        L_0x00ea:
            r2 = 0
        L_0x00eb:
            java.lang.String r3 = "}"
            if (r2 != 0) goto L_0x01c2
            com.google.android.exoplayer2.g.r r2 = r13.f31596b
            int r2 = r2.f32567b
            com.google.android.exoplayer2.g.r r5 = r13.f31596b
            java.lang.StringBuilder r7 = r13.f31597c
            java.lang.String r7 = a(r5, r7)
            if (r7 == 0) goto L_0x0107
            boolean r5 = r3.equals(r7)
            if (r5 == 0) goto L_0x0105
            goto L_0x0107
        L_0x0105:
            r5 = 0
            goto L_0x0108
        L_0x0107:
            r5 = 1
        L_0x0108:
            if (r5 != 0) goto L_0x01bf
            com.google.android.exoplayer2.g.r r8 = r13.f31596b
            r8.c(r2)
            com.google.android.exoplayer2.g.r r2 = r13.f31596b
            java.lang.StringBuilder r8 = r13.f31597c
            c(r2)
            java.lang.String r9 = c(r2, r8)
            boolean r10 = r6.equals(r9)
            if (r10 != 0) goto L_0x01bf
            java.lang.String r10 = a(r2, r8)
            java.lang.String r11 = ":"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x01bf
            c(r2)
            java.lang.String r10 = b(r2, r8)
            if (r10 == 0) goto L_0x01bf
            boolean r11 = r6.equals(r10)
            if (r11 == 0) goto L_0x013d
            goto L_0x01bf
        L_0x013d:
            int r11 = r2.f32567b
            java.lang.String r8 = a(r2, r8)
            java.lang.String r12 = ";"
            boolean r12 = r12.equals(r8)
            if (r12 != 0) goto L_0x0154
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x01bf
            r2.c(r11)
        L_0x0154:
            java.lang.String r2 = "color"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x0165
            int r2 = com.google.android.exoplayer2.g.d.b(r10)
            r0.f31609f = r2
            r0.f31610g = r4
            goto L_0x01bf
        L_0x0165:
            java.lang.String r2 = "background-color"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x0176
            int r2 = com.google.android.exoplayer2.g.d.b(r10)
            r0.f31611h = r2
            r0.f31612i = r4
            goto L_0x01bf
        L_0x0176:
            java.lang.String r2 = "text-decoration"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x018b
            java.lang.String r2 = "underline"
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x01bf
            r0.k = r4
            goto L_0x01bf
        L_0x018b:
            java.lang.String r2 = "font-family"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x019a
            java.lang.String r2 = com.google.android.exoplayer2.g.ae.d((java.lang.String) r10)
            r0.f31608e = r2
            goto L_0x01bf
        L_0x019a:
            java.lang.String r2 = "font-weight"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x01ad
            java.lang.String r2 = "bold"
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x01bf
            r0.l = r4
            goto L_0x01bf
        L_0x01ad:
            java.lang.String r2 = "font-style"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x01bf
            java.lang.String r2 = "italic"
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x01bf
            r0.m = r4
        L_0x01bf:
            r2 = r5
            goto L_0x00eb
        L_0x01c2:
            boolean r2 = r3.equals(r7)
            if (r2 == 0) goto L_0x0025
            r14.add(r0)
            goto L_0x0025
        L_0x01cd:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.h.a.a(com.google.android.exoplayer2.g.r):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069 A[LOOP:1: B:2:0x0002->B:35:0x0069, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0001 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(com.google.android.exoplayer2.g.r r8) {
        /*
            r0 = 1
        L_0x0001:
            r1 = 1
        L_0x0002:
            int r2 = r8.b()
            if (r2 <= 0) goto L_0x006b
            if (r1 == 0) goto L_0x006b
            int r1 = r8.f32567b
            byte[] r2 = r8.f32566a
            byte r1 = r2[r1]
            char r1 = (char) r1
            r2 = 9
            r3 = 0
            if (r1 == r2) goto L_0x0028
            r2 = 10
            if (r1 == r2) goto L_0x0028
            r2 = 12
            if (r1 == r2) goto L_0x0028
            r2 = 13
            if (r1 == r2) goto L_0x0028
            r2 = 32
            if (r1 == r2) goto L_0x0028
            r1 = 0
            goto L_0x002c
        L_0x0028:
            r8.d(r0)
            r1 = 1
        L_0x002c:
            if (r1 != 0) goto L_0x0001
            int r1 = r8.f32567b
            int r2 = r8.f32568c
            byte[] r4 = r8.f32566a
            int r5 = r1 + 2
            if (r5 > r2) goto L_0x0065
            int r5 = r1 + 1
            byte r1 = r4[r1]
            r6 = 47
            if (r1 != r6) goto L_0x0065
            int r1 = r5 + 1
            byte r5 = r4[r5]
            r7 = 42
            if (r5 != r7) goto L_0x0065
        L_0x0048:
            int r5 = r1 + 1
            if (r5 >= r2) goto L_0x005d
            byte r1 = r4[r1]
            char r1 = (char) r1
            if (r1 != r7) goto L_0x005b
            byte r1 = r4[r5]
            char r1 = (char) r1
            if (r1 != r6) goto L_0x005b
            int r5 = r5 + 1
            r1 = r5
            r2 = r1
            goto L_0x0048
        L_0x005b:
            r1 = r5
            goto L_0x0048
        L_0x005d:
            int r1 = r8.f32567b
            int r2 = r2 - r1
            r8.d(r2)
            r1 = 1
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            if (r1 == 0) goto L_0x0069
            goto L_0x0001
        L_0x0069:
            r1 = 0
            goto L_0x0002
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.h.a.c(com.google.android.exoplayer2.g.r):void");
    }

    private static String a(r rVar, StringBuilder sb) {
        c(rVar);
        if (rVar.b() == 0) {
            return null;
        }
        String c2 = c(rVar, sb);
        if (!"".equals(c2)) {
            return c2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) rVar.c());
        return sb2.toString();
    }

    private static String b(r rVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int i2 = rVar.f32567b;
            String a2 = a(rVar, sb);
            if (a2 == null) {
                return null;
            }
            if ("}".equals(a2) || ";".equals(a2)) {
                rVar.c(i2);
                z = true;
            } else {
                sb2.append(a2);
            }
        }
        return sb2.toString();
    }

    private static String c(r rVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int i2 = rVar.f32567b;
        int i3 = rVar.f32568c;
        while (i2 < i3 && !z) {
            char c2 = (char) rVar.f32566a[i2];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                i2++;
                sb.append(c2);
            }
        }
        rVar.d(i2 - rVar.f32567b);
        return sb.toString();
    }

    private static String b(r rVar) {
        int i2 = rVar.f32567b;
        int i3 = rVar.f32568c;
        boolean z = false;
        while (i2 < i3 && !z) {
            int i4 = i2 + 1;
            z = ((char) rVar.f32566a[i2]) == ')';
            i2 = i4;
        }
        return rVar.e((i2 - 1) - rVar.f32567b).trim();
    }
}
