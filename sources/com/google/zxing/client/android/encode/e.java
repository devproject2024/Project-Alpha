package com.google.zxing.client.android.encode;

import java.util.List;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.upi.util.UpiConstants;

final class e extends a {
    e() {
    }

    public final String[] a(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2) {
        StringBuilder sb = new StringBuilder(100);
        sb.append("BEGIN:VCARD\n");
        sb.append("VERSION:3.0\n");
        StringBuilder sb2 = new StringBuilder(100);
        f fVar = new f();
        StringBuilder sb3 = sb;
        StringBuilder sb4 = sb2;
        f fVar2 = fVar;
        a(sb3, sb4, UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, list, 1, (b) null, (b) fVar2, 10);
        a(sb3, sb4, "ORG", str, fVar, 10);
        a(sb3, sb4, "ADR", list2, 1, (b) null, (b) fVar2, 10);
        List<Map<String, Set<String>>> a2 = a(list3, list4);
        g gVar = new g(a2);
        f fVar3 = new f(a2);
        StringBuilder sb5 = sb;
        a(sb5, sb4, "TEL", list3, Integer.MAX_VALUE, (b) gVar, (b) fVar3, 10);
        f fVar4 = fVar;
        a(sb5, sb4, "EMAIL", list5, Integer.MAX_VALUE, (b) null, (b) fVar4, 10);
        a(sb5, sb4, "URL", list6, Integer.MAX_VALUE, (b) null, (b) fVar4, 10);
        a(sb, sb2, "NOTE", str2, fVar, 10);
        sb.append("END:VCARD\n");
        return new String[]{sb.toString(), sb2.toString()};
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0093 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.util.Map<java.lang.String, java.util.Set<java.lang.String>>> a(java.util.Collection<java.lang.String> r8, java.util.List<java.lang.String> r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x0098
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L_0x000b
            goto L_0x0098
        L_0x000b:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
        L_0x0011:
            int r3 = r8.size()
            if (r2 >= r3) goto L_0x0097
            int r3 = r9.size()
            if (r3 > r2) goto L_0x0022
            r1.add(r0)
            goto L_0x0093
        L_0x0022:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r1.add(r3)
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.lang.String r5 = "TYPE"
            r3.put(r5, r4)
            java.lang.Object r3 = r9.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Integer r5 = b(r3)
            if (r5 != 0) goto L_0x0044
            r4.add(r3)
            goto L_0x0093
        L_0x0044:
            int r3 = r5.intValue()
            r6 = 4
            r7 = 18
            if (r3 == r6) goto L_0x006e
            r6 = 5
            if (r3 == r6) goto L_0x006e
            r6 = 6
            if (r3 == r6) goto L_0x006b
            r6 = 13
            if (r3 == r6) goto L_0x006e
            r6 = 16
            if (r3 == r6) goto L_0x0067
            if (r3 == r7) goto L_0x006b
            r6 = 20
            if (r3 == r6) goto L_0x0063
            r3 = r0
            goto L_0x0070
        L_0x0063:
            java.lang.String r3 = "text"
            goto L_0x0070
        L_0x0067:
            java.lang.String r3 = "textphone"
            goto L_0x0070
        L_0x006b:
            java.lang.String r3 = "pager"
            goto L_0x0070
        L_0x006e:
            java.lang.String r3 = "fax"
        L_0x0070:
            int r5 = r5.intValue()
            r6 = 10
            if (r5 == r6) goto L_0x0086
            r6 = 17
            if (r5 == r6) goto L_0x0086
            if (r5 == r7) goto L_0x0086
            switch(r5) {
                case 1: goto L_0x0083;
                case 2: goto L_0x0083;
                case 3: goto L_0x0086;
                case 4: goto L_0x0086;
                case 5: goto L_0x0083;
                case 6: goto L_0x0083;
                default: goto L_0x0081;
            }
        L_0x0081:
            r5 = r0
            goto L_0x0089
        L_0x0083:
            java.lang.String r5 = "home"
            goto L_0x0089
        L_0x0086:
            java.lang.String r5 = "work"
        L_0x0089:
            if (r3 == 0) goto L_0x008e
            r4.add(r3)
        L_0x008e:
            if (r5 == 0) goto L_0x0093
            r4.add(r5)
        L_0x0093:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x0097:
            return r1
        L_0x0098:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.encode.e.a(java.util.Collection, java.util.List):java.util.List");
    }

    private static Integer b(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
