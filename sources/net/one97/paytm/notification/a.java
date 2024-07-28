package net.one97.paytm.notification;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f55972a;

    /* renamed from: b  reason: collision with root package name */
    private final String f55973b = a.class.getName();

    private a() {
    }

    public static a a() {
        return f55972a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r4, java.util.Map<java.lang.String, java.lang.Object> r5, java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = -902467928(0xffffffffca356ea8, float:-2972586.0)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = 96673(0x179a1, float:1.35468E-40)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "all"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = 1
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "signal"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = 0
            goto L_0x0026
        L_0x0025:
            r6 = -1
        L_0x0026:
            if (r6 == 0) goto L_0x002b
            if (r6 == r3) goto L_0x002b
            goto L_0x0039
        L_0x002b:
            com.paytm.analytics.b$b r6 = com.paytm.analytics.b.f40911e
            com.paytm.analytics.models.SignalEvent r6 = new com.paytm.analytics.models.SignalEvent
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            r6.<init>(r4, r5, r0)
            com.paytm.analytics.b.C0683b.a((com.paytm.analytics.models.SignalEvent) r6)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.notification.a.a(java.lang.String, java.util.Map, java.lang.String):void");
    }

    public static void b() {
        synchronized (a.class) {
            if (f55972a == null) {
                f55972a = new a();
            }
        }
    }
}
