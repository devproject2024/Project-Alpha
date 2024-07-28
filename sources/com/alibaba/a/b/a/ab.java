package com.alibaba.a.b.a;

public final class ab extends a implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final ab f6180a = new ab();

    public final int a() {
        return 2;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0 = java.lang.Long.parseLong(r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T b(com.alibaba.a.b.b r4, java.lang.reflect.Type r5, java.lang.Object r6) {
        /*
            r3 = this;
            r5 = 0
            if (r6 != 0) goto L_0x0004
            return r5
        L_0x0004:
            boolean r0 = r6 instanceof java.util.Date
            if (r0 == 0) goto L_0x0014
            java.sql.Date r4 = new java.sql.Date
            java.util.Date r6 = (java.util.Date) r6
            long r5 = r6.getTime()
            r4.<init>(r5)
            goto L_0x0023
        L_0x0014:
            boolean r0 = r6 instanceof java.lang.Number
            if (r0 == 0) goto L_0x0024
            java.sql.Date r4 = new java.sql.Date
            java.lang.Number r6 = (java.lang.Number) r6
            long r5 = r6.longValue()
            r4.<init>(r5)
        L_0x0023:
            return r4
        L_0x0024:
            boolean r0 = r6 instanceof java.lang.String
            if (r0 == 0) goto L_0x006c
            java.lang.String r6 = (java.lang.String) r6
            int r0 = r6.length()
            if (r0 != 0) goto L_0x0031
            return r5
        L_0x0031:
            com.alibaba.a.b.f r5 = new com.alibaba.a.b.f
            r5.<init>(r6)
            boolean r0 = r5.z()     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0045
            java.util.Calendar r4 = r5.y()     // Catch:{ all -> 0x0067 }
            long r0 = r4.getTimeInMillis()     // Catch:{ all -> 0x0067 }
            goto L_0x005e
        L_0x0045:
            java.text.DateFormat r4 = r4.a()     // Catch:{ all -> 0x0067 }
            java.util.Date r4 = r4.parse(r6)     // Catch:{ ParseException -> 0x005a }
            java.sql.Date r0 = new java.sql.Date     // Catch:{ ParseException -> 0x005a }
            long r1 = r4.getTime()     // Catch:{ ParseException -> 0x005a }
            r0.<init>(r1)     // Catch:{ ParseException -> 0x005a }
            r5.close()
            return r0
        L_0x005a:
            long r0 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x0067 }
        L_0x005e:
            r5.close()
            java.sql.Date r4 = new java.sql.Date
            r4.<init>(r0)
            return r4
        L_0x0067:
            r4 = move-exception
            r5.close()
            throw r4
        L_0x006c:
            com.alibaba.a.d r4 = new com.alibaba.a.d
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "parse error : "
            java.lang.String r5 = r6.concat(r5)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.a.ab.b(com.alibaba.a.b.b, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
