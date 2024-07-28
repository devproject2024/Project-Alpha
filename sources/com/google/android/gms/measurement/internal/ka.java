package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.aj;

final class ka {

    /* renamed from: a  reason: collision with root package name */
    private aj.c f12322a;

    /* renamed from: b  reason: collision with root package name */
    private Long f12323b;

    /* renamed from: c  reason: collision with root package name */
    private long f12324c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ jv f12325d;

    private ka(jv jvVar) {
        this.f12325d = jvVar;
    }

    /* synthetic */ ka(jv jvVar, byte b2) {
        this(jvVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.aj.c a(java.lang.String r18, com.google.android.gms.internal.measurement.aj.c r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r8 = r19
            java.lang.String r9 = r8.zze
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.aj$e> r10 = r8.zzd
            com.google.android.gms.measurement.internal.jv r2 = r1.f12325d
            r2.G_()
            java.lang.String r2 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.jn.b(r8, r2)
            r4 = r3
            java.lang.Long r4 = (java.lang.Long) r4
            r3 = 1
            r5 = 0
            if (r4 == 0) goto L_0x001e
            r6 = 1
            goto L_0x001f
        L_0x001e:
            r6 = 0
        L_0x001f:
            if (r6 == 0) goto L_0x002b
            java.lang.String r7 = "_ep"
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            r11 = 0
            if (r7 == 0) goto L_0x0136
            com.google.android.gms.measurement.internal.jv r6 = r1.f12325d
            r6.G_()
            java.lang.String r6 = "_en"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.jn.b(r8, r6)
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            r7 = 0
            if (r6 == 0) goto L_0x0053
            com.google.android.gms.measurement.internal.jv r0 = r1.f12325d
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.a(r2, r4)
            return r7
        L_0x0053:
            com.google.android.gms.internal.measurement.aj$c r6 = r1.f12322a
            if (r6 == 0) goto L_0x0069
            java.lang.Long r6 = r1.f12323b
            if (r6 == 0) goto L_0x0069
            long r13 = r4.longValue()
            java.lang.Long r6 = r1.f12323b
            long r15 = r6.longValue()
            int r6 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r6 == 0) goto L_0x009a
        L_0x0069:
            com.google.android.gms.measurement.internal.jv r6 = r1.f12325d
            com.google.android.gms.measurement.internal.d r6 = r6.F_()
            android.util.Pair r6 = r6.a((java.lang.String) r0, (java.lang.Long) r4)
            if (r6 == 0) goto L_0x0128
            java.lang.Object r13 = r6.first
            if (r13 != 0) goto L_0x007b
            goto L_0x0128
        L_0x007b:
            java.lang.Object r7 = r6.first
            com.google.android.gms.internal.measurement.aj$c r7 = (com.google.android.gms.internal.measurement.aj.c) r7
            r1.f12322a = r7
            java.lang.Object r6 = r6.second
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            r1.f12324c = r6
            com.google.android.gms.measurement.internal.jv r6 = r1.f12325d
            r6.G_()
            com.google.android.gms.internal.measurement.aj$c r6 = r1.f12322a
            java.lang.Object r2 = com.google.android.gms.measurement.internal.jn.b(r6, r2)
            java.lang.Long r2 = (java.lang.Long) r2
            r1.f12323b = r2
        L_0x009a:
            long r6 = r1.f12324c
            r13 = 1
            long r6 = r6 - r13
            r1.f12324c = r6
            long r6 = r1.f12324c
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.jv r2 = r1.f12325d
            com.google.android.gms.measurement.internal.d r2 = r2.F_()
            r2.h()
            com.google.android.gms.measurement.internal.dy r4 = r2.J_()
            com.google.android.gms.measurement.internal.ea r4 = r4.k
            java.lang.String r6 = "Clearing complex main event info. appId"
            r4.a(r6, r0)
            android.database.sqlite.SQLiteDatabase r4 = r2.e()     // Catch:{ SQLiteException -> 0x00c9 }
            java.lang.String r6 = "delete from main_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00c9 }
            r3[r5] = r0     // Catch:{ SQLiteException -> 0x00c9 }
            r4.execSQL(r6, r3)     // Catch:{ SQLiteException -> 0x00c9 }
            goto L_0x00e5
        L_0x00c9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c
            java.lang.String r3 = "Error clearing complex main event"
            r2.a(r3, r0)
            goto L_0x00e5
        L_0x00d6:
            com.google.android.gms.measurement.internal.jv r2 = r1.f12325d
            com.google.android.gms.measurement.internal.d r2 = r2.F_()
            long r5 = r1.f12324c
            com.google.android.gms.internal.measurement.aj$c r7 = r1.f12322a
            r3 = r18
            r2.a(r3, r4, r5, r7)
        L_0x00e5:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.internal.measurement.aj$c r2 = r1.f12322a
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.aj$e> r2 = r2.zzd
            java.util.Iterator r2 = r2.iterator()
        L_0x00f2:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x010f
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.aj$e r3 = (com.google.android.gms.internal.measurement.aj.e) r3
            com.google.android.gms.measurement.internal.jv r4 = r1.f12325d
            r4.G_()
            java.lang.String r4 = r3.zzd
            com.google.android.gms.internal.measurement.aj$e r4 = com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c) r8, (java.lang.String) r4)
            if (r4 != 0) goto L_0x00f2
            r0.add(r3)
            goto L_0x00f2
        L_0x010f:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x011a
            r0.addAll(r10)
            r10 = r0
            goto L_0x017a
        L_0x011a:
            com.google.android.gms.measurement.internal.jv r0 = r1.f12325d
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.a(r2, r9)
            goto L_0x017a
        L_0x0128:
            com.google.android.gms.measurement.internal.jv r0 = r1.f12325d
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.a(r2, r9, r4)
            return r7
        L_0x0136:
            if (r6 == 0) goto L_0x017a
            r1.f12323b = r4
            r1.f12322a = r8
            com.google.android.gms.measurement.internal.jv r2 = r1.f12325d
            r2.G_()
            java.lang.Long r2 = java.lang.Long.valueOf(r11)
            java.lang.String r3 = "_epc"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.jn.b(r8, r3)
            if (r3 != 0) goto L_0x014e
            goto L_0x014f
        L_0x014e:
            r2 = r3
        L_0x014f:
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r1.f12324c = r2
            long r2 = r1.f12324c
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 > 0) goto L_0x016b
            com.google.android.gms.measurement.internal.jv r0 = r1.f12325d
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f
            java.lang.String r2 = "Complex event with zero extra param count. eventName"
            r0.a(r2, r9)
            goto L_0x017a
        L_0x016b:
            com.google.android.gms.measurement.internal.jv r2 = r1.f12325d
            com.google.android.gms.measurement.internal.d r2 = r2.F_()
            long r5 = r1.f12324c
            r3 = r18
            r7 = r19
            r2.a(r3, r4, r5, r7)
        L_0x017a:
            com.google.android.gms.internal.measurement.dv$b r0 = r19.m()
            com.google.android.gms.internal.measurement.dv$b r0 = (com.google.android.gms.internal.measurement.dv.b) r0
            com.google.android.gms.internal.measurement.aj$c$a r0 = (com.google.android.gms.internal.measurement.aj.c.a) r0
            com.google.android.gms.internal.measurement.aj$c$a r0 = r0.a((java.lang.String) r9)
            com.google.android.gms.internal.measurement.aj$c$a r0 = r0.c()
            com.google.android.gms.internal.measurement.aj$c$a r0 = r0.a((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.aj.e>) r10)
            com.google.android.gms.internal.measurement.ff r0 = r0.w()
            com.google.android.gms.internal.measurement.dv r0 = (com.google.android.gms.internal.measurement.dv) r0
            com.google.android.gms.internal.measurement.aj$c r0 = (com.google.android.gms.internal.measurement.aj.c) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ka.a(java.lang.String, com.google.android.gms.internal.measurement.aj$c):com.google.android.gms.internal.measurement.aj$c");
    }
}
