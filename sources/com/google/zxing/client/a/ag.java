package com.google.zxing.client.a;

import com.google.zxing.r;
import java.util.List;

public final class ag extends u {
    public final /* synthetic */ q a(r rVar) {
        return d(rVar);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.zxing.client.a.g d(com.google.zxing.r r16) {
        /*
            java.lang.String r0 = b((com.google.zxing.r) r16)
            java.lang.String r1 = "BEGIN:VEVENT"
            int r1 = r0.indexOf(r1)
            r2 = 0
            if (r1 >= 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.String r1 = "SUMMARY"
            java.lang.String r4 = a(r1, r0)
            java.lang.String r1 = "DTSTART"
            java.lang.String r5 = a(r1, r0)
            if (r5 != 0) goto L_0x001d
            return r2
        L_0x001d:
            java.lang.String r1 = "DTEND"
            java.lang.String r6 = a(r1, r0)
            java.lang.String r1 = "DURATION"
            java.lang.String r7 = a(r1, r0)
            java.lang.String r1 = "LOCATION"
            java.lang.String r8 = a(r1, r0)
            java.lang.String r1 = "ORGANIZER"
            java.lang.String r1 = a(r1, r0)
            java.lang.String r9 = a((java.lang.String) r1)
            r1 = 1
            r3 = 0
            java.lang.String r10 = "ATTENDEE"
            java.util.List r10 = com.google.zxing.client.a.af.a(r10, r0, r1, r3)
            if (r10 == 0) goto L_0x0066
            boolean r11 = r10.isEmpty()
            if (r11 == 0) goto L_0x004a
            goto L_0x0066
        L_0x004a:
            int r11 = r10.size()
            java.lang.String[] r12 = new java.lang.String[r11]
            r13 = 0
        L_0x0051:
            if (r13 >= r11) goto L_0x0064
            java.lang.Object r14 = r10.get(r13)
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r14 = r14.get(r3)
            java.lang.String r14 = (java.lang.String) r14
            r12[r13] = r14
            int r13 = r13 + 1
            goto L_0x0051
        L_0x0064:
            r10 = r12
            goto L_0x0067
        L_0x0066:
            r10 = r2
        L_0x0067:
            if (r10 == 0) goto L_0x0078
            r11 = 0
        L_0x006a:
            int r12 = r10.length
            if (r11 >= r12) goto L_0x0078
            r12 = r10[r11]
            java.lang.String r12 = a((java.lang.String) r12)
            r10[r11] = r12
            int r11 = r11 + 1
            goto L_0x006a
        L_0x0078:
            java.lang.String r11 = "DESCRIPTION"
            java.lang.String r11 = a(r11, r0)
            java.lang.String r12 = "GEO"
            java.lang.String r0 = a(r12, r0)
            r12 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            if (r0 != 0) goto L_0x008a
            r14 = r12
            goto L_0x00a6
        L_0x008a:
            r12 = 59
            int r12 = r0.indexOf(r12)
            if (r12 >= 0) goto L_0x0093
            return r2
        L_0x0093:
            java.lang.String r3 = r0.substring(r3, r12)     // Catch:{ NumberFormatException -> 0x00ad }
            double r13 = java.lang.Double.parseDouble(r3)     // Catch:{ NumberFormatException -> 0x00ad }
            int r12 = r12 + r1
            java.lang.String r0 = r0.substring(r12)     // Catch:{ NumberFormatException -> 0x00ad }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ad }
            r12 = r13
            r14 = r0
        L_0x00a6:
            com.google.zxing.client.a.g r0 = new com.google.zxing.client.a.g     // Catch:{  }
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14)     // Catch:{  }
            return r0
        L_0x00ad:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.a.ag.d(com.google.zxing.r):com.google.zxing.client.a.g");
    }

    private static String a(CharSequence charSequence, String str) {
        List<String> b2 = af.b(charSequence, str, true, false);
        if (b2 == null || b2.isEmpty()) {
            return null;
        }
        return b2.get(0);
    }

    private static String a(String str) {
        if (str != null) {
            return (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str;
        }
        return str;
    }
}
