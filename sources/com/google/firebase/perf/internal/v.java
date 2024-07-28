package com.google.firebase.perf.internal;

import java.util.Locale;
import java.util.Map;

public abstract class v {
    public abstract boolean a();

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r7, int r8) {
        /*
            r0 = 0
            r1 = 2
            r2 = 1
            if (r7 != 0) goto L_0x0015
            int[] r7 = com.google.firebase.perf.internal.u.f39236a
            int r8 = r8 - r2
            r7 = r7[r8]
            if (r7 == r2) goto L_0x0012
            if (r7 == r1) goto L_0x000f
            goto L_0x0079
        L_0x000f:
            java.lang.String r7 = "Metric name must not be null"
            return r7
        L_0x0012:
            java.lang.String r7 = "Counter name must not be null"
            return r7
        L_0x0015:
            int r3 = r7.length()
            r4 = 0
            r5 = 100
            if (r3 <= r5) goto L_0x004a
            int[] r7 = com.google.firebase.perf.internal.u.f39236a
            int r8 = r8 - r2
            r7 = r7[r8]
            if (r7 == r2) goto L_0x0039
            if (r7 == r1) goto L_0x0028
            goto L_0x0079
        L_0x0028:
            java.util.Locale r7 = java.util.Locale.US
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r8[r4] = r0
            java.lang.String r0 = "Metric name must not exceed %d characters"
            java.lang.String r7 = java.lang.String.format(r7, r0, r8)
            return r7
        L_0x0039:
            java.util.Locale r7 = java.util.Locale.US
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r8[r4] = r0
            java.lang.String r0 = "Counter name must not exceed %d characters"
            java.lang.String r7 = java.lang.String.format(r7, r0, r8)
            return r7
        L_0x004a:
            java.lang.String r3 = "_"
            boolean r3 = r7.startsWith(r3)
            if (r3 == 0) goto L_0x0079
            com.google.android.gms.internal.firebase-perf.x[] r3 = com.google.android.gms.internal.p001firebaseperf.x.values()
            int r5 = r3.length
        L_0x0057:
            if (r4 >= r5) goto L_0x0069
            r6 = r3[r4]
            java.lang.String r6 = r6.toString()
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0066
            return r0
        L_0x0066:
            int r4 = r4 + 1
            goto L_0x0057
        L_0x0069:
            int[] r7 = com.google.firebase.perf.internal.u.f39236a
            int r8 = r8 - r2
            r7 = r7[r8]
            if (r7 == r2) goto L_0x0076
            if (r7 == r1) goto L_0x0073
            goto L_0x0079
        L_0x0073:
            java.lang.String r7 = "Metric name must not start with '_'"
            return r7
        L_0x0076:
            java.lang.String r7 = "Counter name must not start with '_'"
            return r7
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.v.a(java.lang.String, int):java.lang.String");
    }

    public static String a(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        String value = entry.getValue();
        if (key == null) {
            return "Attribute key must not be null";
        }
        if (value == null) {
            return "Attribute value must not be null";
        }
        if (key.length() > 40) {
            return String.format(Locale.US, "Attribute key length must not exceed %d characters", new Object[]{40});
        } else if (value.length() > 100) {
            return String.format(Locale.US, "Attribute value length must not exceed %d characters", new Object[]{100});
        } else if (!key.matches("^(?!(firebase_|google_|ga_))[A-Za-z][A-Za-z_0-9]*")) {
            return "Attribute key must start with letter, must only contain alphanumeric characters and underscore and must not start with \"firebase_\", \"google_\" and \"ga_";
        } else {
            return null;
        }
    }
}
