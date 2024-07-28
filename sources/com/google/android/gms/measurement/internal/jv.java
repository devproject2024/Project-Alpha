package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

final class jv extends jg {

    /* renamed from: a  reason: collision with root package name */
    private String f12298a;

    /* renamed from: c  reason: collision with root package name */
    private Set<Integer> f12299c;

    /* renamed from: d  reason: collision with root package name */
    private Map<Integer, jx> f12300d;

    jv(jj jjVar) {
        super(jjVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x05d2, code lost:
        if (r9.a() == false) goto L_0x05db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x05d4, code lost:
        r14 = java.lang.Integer.valueOf(r9.zzd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x05db, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x05dc, code lost:
        r8.a("Invalid property filter ID. appId, id", r11, java.lang.String.valueOf(r14));
        r12 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x02b0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.aj.a> a(java.lang.String r59, java.util.List<com.google.android.gms.internal.measurement.aj.c> r60, java.util.List<com.google.android.gms.internal.measurement.aj.k> r61, java.lang.Long r62) {
        /*
            r58 = this;
            r10 = r58
            com.google.android.gms.common.internal.s.a((java.lang.String) r59)
            com.google.android.gms.common.internal.s.a(r60)
            com.google.android.gms.common.internal.s.a(r61)
            r0 = r59
            r10.f12298a = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.f12299c = r0
            androidx.a.a r0 = new androidx.a.a
            r0.<init>()
            r10.f12300d = r0
            com.google.android.gms.measurement.internal.ke r0 = r58.H_()
            java.lang.String r1 = r10.f12298a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.al
            boolean r0 = r0.d(r1, r2)
            r11 = 1
            r12 = 0
            if (r0 != 0) goto L_0x003b
            com.google.android.gms.measurement.internal.ke r0 = r58.H_()
            java.lang.String r1 = r10.f12298a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.am
            boolean r0 = r0.d(r1, r2)
            if (r0 == 0) goto L_0x0057
        L_0x003b:
            java.util.Iterator r0 = r60.iterator()
        L_0x003f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.aj$c r1 = (com.google.android.gms.internal.measurement.aj.c) r1
            java.lang.String r1 = r1.zze
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x003f
            r1 = 1
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            com.google.android.gms.measurement.internal.ke r0 = r58.H_()
            java.lang.String r2 = r10.f12298a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.o.al
            boolean r13 = r0.d(r2, r3)
            com.google.android.gms.measurement.internal.ke r0 = r58.H_()
            java.lang.String r2 = r10.f12298a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.o.am
            boolean r0 = r0.d(r2, r3)
            if (r1 == 0) goto L_0x00b1
            if (r0 == 0) goto L_0x00b1
            com.google.android.gms.measurement.internal.d r2 = r58.F_()
            java.lang.String r3 = r10.f12298a
            r2.w()
            r2.h()
            com.google.android.gms.common.internal.s.a((java.lang.String) r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.e()     // Catch:{ SQLiteException -> 0x00a1 }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x00a1 }
            r7[r12] = r3     // Catch:{ SQLiteException -> 0x00a1 }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00a1 }
            goto L_0x00b1
        L_0x00a1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c
            java.lang.Object r3 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.a(r4, r3, r0)
        L_0x00b1:
            com.google.android.gms.measurement.internal.d r0 = r58.F_()
            java.lang.String r2 = r10.f12298a
            java.util.Map r0 = r0.f(r2)
            if (r0 == 0) goto L_0x02d8
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x00c5
            goto L_0x02d8
        L_0x00c5:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r3 = r0.keySet()
            r2.<init>(r3)
            if (r13 == 0) goto L_0x01b2
            if (r1 == 0) goto L_0x01b2
            java.lang.String r1 = r10.f12298a
            com.google.android.gms.common.internal.s.a((java.lang.String) r1)
            com.google.android.gms.common.internal.s.a(r0)
            androidx.a.a r3 = new androidx.a.a
            r3.<init>()
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x01b0
            com.google.android.gms.measurement.internal.d r4 = r58.F_()
            java.util.Map r1 = r4.e(r1)
            java.util.Set r4 = r0.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x00f5:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01b0
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r0.get(r6)
            com.google.android.gms.internal.measurement.aj$i r6 = (com.google.android.gms.internal.measurement.aj.i) r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Object r7 = r1.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x01a7
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x0123
            goto L_0x01a7
        L_0x0123:
            com.google.android.gms.measurement.internal.jn r8 = r58.G_()
            com.google.android.gms.internal.measurement.ee r9 = r6.zzd
            java.util.List r8 = r8.a((java.util.List<java.lang.Long>) r9, (java.util.List<java.lang.Integer>) r7)
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x00f5
            com.google.android.gms.internal.measurement.dv$b r9 = r6.m()
            com.google.android.gms.internal.measurement.dv$b r9 = (com.google.android.gms.internal.measurement.dv.b) r9
            com.google.android.gms.internal.measurement.aj$i$a r9 = (com.google.android.gms.internal.measurement.aj.i.a) r9
            com.google.android.gms.internal.measurement.aj$i$a r9 = r9.b()
            com.google.android.gms.internal.measurement.aj$i$a r8 = r9.b((java.lang.Iterable<? extends java.lang.Long>) r8)
            com.google.android.gms.measurement.internal.jn r9 = r58.G_()
            com.google.android.gms.internal.measurement.ee r15 = r6.zzc
            java.util.List r9 = r9.a((java.util.List<java.lang.Long>) r15, (java.util.List<java.lang.Integer>) r7)
            com.google.android.gms.internal.measurement.aj$i$a r15 = r8.a()
            r15.a((java.lang.Iterable<? extends java.lang.Long>) r9)
            r9 = 0
        L_0x0155:
            int r15 = r6.b()
            if (r9 >= r15) goto L_0x0175
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.aj$b> r15 = r6.zze
            java.lang.Object r15 = r15.get(r9)
            com.google.android.gms.internal.measurement.aj$b r15 = (com.google.android.gms.internal.measurement.aj.b) r15
            int r15 = r15.zzd
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            boolean r15 = r7.contains(r15)
            if (r15 == 0) goto L_0x0172
            r8.a((int) r9)
        L_0x0172:
            int r9 = r9 + 1
            goto L_0x0155
        L_0x0175:
            r9 = 0
        L_0x0176:
            int r15 = r6.c()
            if (r9 >= r15) goto L_0x0196
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.aj$j> r15 = r6.zzf
            java.lang.Object r15 = r15.get(r9)
            com.google.android.gms.internal.measurement.aj$j r15 = (com.google.android.gms.internal.measurement.aj.j) r15
            int r15 = r15.zzd
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            boolean r15 = r7.contains(r15)
            if (r15 == 0) goto L_0x0193
            r8.b((int) r9)
        L_0x0193:
            int r9 = r9 + 1
            goto L_0x0176
        L_0x0196:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.measurement.ff r6 = r8.w()
            com.google.android.gms.internal.measurement.dv r6 = (com.google.android.gms.internal.measurement.dv) r6
            com.google.android.gms.internal.measurement.aj$i r6 = (com.google.android.gms.internal.measurement.aj.i) r6
            r3.put(r5, r6)
            goto L_0x00f5
        L_0x01a7:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.put(r5, r6)
            goto L_0x00f5
        L_0x01b0:
            r15 = r3
            goto L_0x01b3
        L_0x01b2:
            r15 = r0
        L_0x01b3:
            java.util.Iterator r16 = r2.iterator()
        L_0x01b7:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x02d8
            java.lang.Object r1 = r16.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r17 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r15.get(r1)
            com.google.android.gms.internal.measurement.aj$i r1 = (com.google.android.gms.internal.measurement.aj.i) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.a.a r7 = new androidx.a.a
            r7.<init>()
            if (r1 == 0) goto L_0x0219
            int r2 = r1.b()
            if (r2 != 0) goto L_0x01e9
            goto L_0x0219
        L_0x01e9:
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.aj$b> r2 = r1.zze
            java.util.Iterator r2 = r2.iterator()
        L_0x01ef:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0219
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.aj$b r3 = (com.google.android.gms.internal.measurement.aj.b) r3
            boolean r4 = r3.a()
            if (r4 == 0) goto L_0x01ef
            int r4 = r3.zzd
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.b()
            if (r8 == 0) goto L_0x0214
            long r8 = r3.zze
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            goto L_0x0215
        L_0x0214:
            r3 = 0
        L_0x0215:
            r7.put(r4, r3)
            goto L_0x01ef
        L_0x0219:
            com.google.android.gms.internal.measurement.lf.a()
            com.google.android.gms.measurement.internal.ke r2 = r58.H_()
            java.lang.String r3 = r10.f12298a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.o.as
            boolean r2 = r2.d(r3, r4)
            if (r2 == 0) goto L_0x026f
            androidx.a.a r2 = new androidx.a.a
            r2.<init>()
            if (r1 == 0) goto L_0x026d
            int r3 = r1.c()
            if (r3 != 0) goto L_0x0238
            goto L_0x026d
        L_0x0238:
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.aj$j> r3 = r1.zzf
            java.util.Iterator r3 = r3.iterator()
        L_0x023e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x026d
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.measurement.aj$j r4 = (com.google.android.gms.internal.measurement.aj.j) r4
            boolean r8 = r4.a()
            if (r8 == 0) goto L_0x023e
            int r8 = r4.b()
            if (r8 <= 0) goto L_0x023e
            int r8 = r4.zzd
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r9 = r4.b()
            int r9 = r9 - r11
            long r18 = r4.b(r9)
            java.lang.Long r4 = java.lang.Long.valueOf(r18)
            r2.put(r8, r4)
            goto L_0x023e
        L_0x026d:
            r8 = r2
            goto L_0x0270
        L_0x026f:
            r8 = 0
        L_0x0270:
            if (r1 == 0) goto L_0x02b4
            r2 = 0
        L_0x0273:
            int r3 = r1.a()
            int r3 = r3 << 6
            if (r2 >= r3) goto L_0x02b4
            com.google.android.gms.internal.measurement.ee r3 = r1.zzc
            boolean r3 = com.google.android.gms.measurement.internal.jn.a((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02a6
            com.google.android.gms.measurement.internal.dy r3 = r58.J_()
            com.google.android.gms.measurement.internal.ea r3 = r3.k
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            java.lang.String r11 = "Filter already evaluated. audience ID, filter ID"
            r3.a(r11, r4, r9)
            r6.set(r2)
            com.google.android.gms.internal.measurement.ee r3 = r1.zzd
            boolean r3 = com.google.android.gms.measurement.internal.jn.a((java.util.List<java.lang.Long>) r3, (int) r2)
            if (r3 == 0) goto L_0x02a6
            r5.set(r2)
            r3 = 1
            goto L_0x02a7
        L_0x02a6:
            r3 = 0
        L_0x02a7:
            if (r3 != 0) goto L_0x02b0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r7.remove(r3)
        L_0x02b0:
            int r2 = r2 + 1
            r11 = 1
            goto L_0x0273
        L_0x02b4:
            if (r13 == 0) goto L_0x02c0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.aj$i r1 = (com.google.android.gms.internal.measurement.aj.i) r1
        L_0x02c0:
            r4 = r1
            com.google.android.gms.measurement.internal.jx r11 = new com.google.android.gms.measurement.internal.jx
            java.lang.String r3 = r10.f12298a
            r9 = 0
            r1 = r11
            r2 = r58
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.jx> r1 = r10.f12300d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            r1.put(r2, r11)
            r11 = 1
            goto L_0x01b7
        L_0x02d8:
            boolean r0 = r60.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 != 0) goto L_0x04a8
            com.google.android.gms.measurement.internal.ka r0 = new com.google.android.gms.measurement.internal.ka
            r0.<init>(r10, r12)
            androidx.a.a r2 = new androidx.a.a
            r2.<init>()
            java.util.Iterator r3 = r60.iterator()
        L_0x02ee:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a8
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.measurement.aj$c r4 = (com.google.android.gms.internal.measurement.aj.c) r4
            java.lang.String r5 = r10.f12298a
            com.google.android.gms.internal.measurement.aj$c r5 = r0.a(r5, r4)
            if (r5 == 0) goto L_0x02ee
            com.google.android.gms.measurement.internal.d r6 = r58.F_()
            java.lang.String r7 = r10.f12298a
            java.lang.String r8 = r5.zze
            com.google.android.gms.measurement.internal.ke r9 = r6.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.o.am
            boolean r9 = r9.d(r7, r11)
            java.lang.String r11 = r4.zze
            com.google.android.gms.measurement.internal.k r11 = r6.a((java.lang.String) r7, (java.lang.String) r11)
            if (r11 != 0) goto L_0x036d
            com.google.android.gms.measurement.internal.dy r11 = r6.J_()
            com.google.android.gms.measurement.internal.ea r11 = r11.f11831f
            java.lang.Object r13 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r7)
            com.google.android.gms.measurement.internal.dw r6 = r6.l()
            java.lang.String r6 = r6.a((java.lang.String) r8)
            java.lang.String r8 = "Event aggregate wasn't created during raw event logging. appId, event"
            r11.a(r8, r13, r6)
            if (r9 == 0) goto L_0x0356
            com.google.android.gms.measurement.internal.k r6 = new com.google.android.gms.measurement.internal.k
            r15 = r6
            java.lang.String r8 = r4.zze
            r17 = r8
            r18 = 1
            r20 = 1
            r22 = 1
            long r8 = r4.zzf
            r24 = r8
            r26 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r16 = r7
            r15.<init>(r16, r17, r18, r20, r22, r24, r26, r28, r29, r30, r31)
            goto L_0x036a
        L_0x0356:
            com.google.android.gms.measurement.internal.k r6 = new com.google.android.gms.measurement.internal.k
            java.lang.String r8 = r4.zze
            r18 = 1
            r20 = 1
            long r12 = r4.zzf
            r15 = r6
            r16 = r7
            r17 = r8
            r22 = r12
            r15.<init>(r16, r17, r18, r20, r22)
        L_0x036a:
            r4 = r6
            goto L_0x03d8
        L_0x036d:
            r6 = 1
            if (r9 == 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.k r4 = new com.google.android.gms.measurement.internal.k
            r25 = r4
            java.lang.String r8 = r11.f12313a
            r26 = r8
            java.lang.String r8 = r11.f12314b
            r27 = r8
            long r8 = r11.f12315c
            long r28 = r8 + r6
            long r8 = r11.f12316d
            long r30 = r8 + r6
            long r8 = r11.f12317e
            long r32 = r8 + r6
            long r6 = r11.f12318f
            r34 = r6
            long r6 = r11.f12319g
            r36 = r6
            java.lang.Long r6 = r11.f12320h
            r38 = r6
            java.lang.Long r6 = r11.f12321i
            r39 = r6
            java.lang.Long r6 = r11.j
            r40 = r6
            java.lang.Boolean r6 = r11.k
            r41 = r6
            r25.<init>(r26, r27, r28, r30, r32, r34, r36, r38, r39, r40, r41)
            goto L_0x03d8
        L_0x03a5:
            com.google.android.gms.measurement.internal.k r4 = new com.google.android.gms.measurement.internal.k
            r41 = r4
            java.lang.String r8 = r11.f12313a
            r42 = r8
            java.lang.String r8 = r11.f12314b
            r43 = r8
            long r8 = r11.f12315c
            long r44 = r8 + r6
            long r8 = r11.f12316d
            long r46 = r8 + r6
            long r6 = r11.f12317e
            r48 = r6
            long r6 = r11.f12318f
            r50 = r6
            long r6 = r11.f12319g
            r52 = r6
            java.lang.Long r6 = r11.f12320h
            r54 = r6
            java.lang.Long r6 = r11.f12321i
            r55 = r6
            java.lang.Long r6 = r11.j
            r56 = r6
            java.lang.Boolean r6 = r11.k
            r57 = r6
            r41.<init>(r42, r43, r44, r46, r48, r50, r52, r54, r55, r56, r57)
        L_0x03d8:
            com.google.android.gms.measurement.internal.d r6 = r58.F_()
            r6.a((com.google.android.gms.measurement.internal.k) r4)
            long r6 = r4.f12315c
            java.lang.String r8 = r5.zze
            java.lang.Object r9 = r2.get(r8)
            java.util.Map r9 = (java.util.Map) r9
            if (r9 != 0) goto L_0x03ff
            com.google.android.gms.measurement.internal.d r9 = r58.F_()
            java.lang.String r11 = r10.f12298a
            java.util.Map r9 = r9.f(r11, r8)
            if (r9 != 0) goto L_0x03fc
            androidx.a.a r9 = new androidx.a.a
            r9.<init>()
        L_0x03fc:
            r2.put(r8, r9)
        L_0x03ff:
            java.util.Set r8 = r9.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0407:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x04a5
            java.lang.Object r11 = r8.next()
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            java.util.Set<java.lang.Integer> r12 = r10.f12299c
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            boolean r12 = r12.contains(r13)
            if (r12 == 0) goto L_0x0431
            com.google.android.gms.measurement.internal.dy r12 = r58.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.k
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r12.a(r1, r11)
            goto L_0x0407
        L_0x0431:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            java.lang.Object r12 = r9.get(r12)
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r12 = r12.iterator()
            r13 = 1
        L_0x0440:
            boolean r15 = r12.hasNext()
            if (r15 == 0) goto L_0x0490
            java.lang.Object r13 = r12.next()
            com.google.android.gms.internal.measurement.ab$b r13 = (com.google.android.gms.internal.measurement.ab.b) r13
            com.google.android.gms.measurement.internal.jz r15 = new com.google.android.gms.measurement.internal.jz
            java.lang.String r14 = r10.f12298a
            r15.<init>(r10, r14, r11, r13)
            int r13 = r13.zzd
            boolean r20 = r10.a(r11, r13)
            r13 = r15
            r16 = r5
            r17 = r6
            r19 = r4
            boolean r14 = r15.a(r16, r17, r19, r20)
            com.google.android.gms.measurement.internal.ke r15 = r58.H_()
            r16 = r0
            java.lang.String r0 = r10.f12298a
            r17 = r2
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.at
            boolean r0 = r15.d(r0, r2)
            if (r0 == 0) goto L_0x0483
            if (r14 != 0) goto L_0x0483
            java.util.Set<java.lang.Integer> r0 = r10.f12299c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r0.add(r2)
            r13 = r14
            goto L_0x0494
        L_0x0483:
            com.google.android.gms.measurement.internal.jx r0 = r10.a(r11)
            r0.a(r13)
            r13 = r14
            r0 = r16
            r2 = r17
            goto L_0x0440
        L_0x0490:
            r16 = r0
            r17 = r2
        L_0x0494:
            if (r13 != 0) goto L_0x049f
            java.util.Set<java.lang.Integer> r0 = r10.f12299c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r0.add(r2)
        L_0x049f:
            r0 = r16
            r2 = r17
            goto L_0x0407
        L_0x04a5:
            r12 = 0
            goto L_0x02ee
        L_0x04a8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r2 = r61.isEmpty()
            if (r2 != 0) goto L_0x05fa
            androidx.a.a r2 = new androidx.a.a
            r2.<init>()
            java.util.Iterator r3 = r61.iterator()
        L_0x04bc:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x05fa
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.measurement.aj$k r4 = (com.google.android.gms.internal.measurement.aj.k) r4
            java.lang.String r5 = r4.zze
            r0.add(r5)
            java.lang.String r5 = r4.zze
            java.lang.Object r6 = r2.get(r5)
            java.util.Map r6 = (java.util.Map) r6
            if (r6 != 0) goto L_0x04eb
            com.google.android.gms.measurement.internal.d r6 = r58.F_()
            java.lang.String r7 = r10.f12298a
            java.util.Map r6 = r6.g(r7, r5)
            if (r6 != 0) goto L_0x04e8
            androidx.a.a r6 = new androidx.a.a
            r6.<init>()
        L_0x04e8:
            r2.put(r5, r6)
        L_0x04eb:
            java.util.Set r5 = r6.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x04f3:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x05f6
            java.lang.Object r7 = r5.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.util.Set<java.lang.Integer> r8 = r10.f12299c
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x051d
            com.google.android.gms.measurement.internal.dy r4 = r58.J_()
            com.google.android.gms.measurement.internal.ea r4 = r4.k
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r4.a(r1, r5)
            goto L_0x04bc
        L_0x051d:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            java.lang.Object r8 = r6.get(r8)
            java.util.List r8 = (java.util.List) r8
            java.util.Iterator r8 = r8.iterator()
            r12 = 1
        L_0x052c:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x05e7
            java.lang.Object r9 = r8.next()
            com.google.android.gms.internal.measurement.ab$e r9 = (com.google.android.gms.internal.measurement.ab.e) r9
            com.google.android.gms.measurement.internal.dy r11 = r58.J_()
            r12 = 2
            boolean r11 = r11.a((int) r12)
            if (r11 == 0) goto L_0x057d
            com.google.android.gms.measurement.internal.dy r11 = r58.J_()
            com.google.android.gms.measurement.internal.ea r11 = r11.k
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
            boolean r13 = r9.a()
            if (r13 == 0) goto L_0x055a
            int r13 = r9.zzd
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)
            goto L_0x055b
        L_0x055a:
            r14 = 0
        L_0x055b:
            com.google.android.gms.measurement.internal.dw r13 = r58.l()
            java.lang.String r15 = r9.zze
            java.lang.String r13 = r13.c(r15)
            java.lang.String r15 = "Evaluating filter. audience, filter, property"
            r11.a(r15, r12, r14, r13)
            com.google.android.gms.measurement.internal.dy r11 = r58.J_()
            com.google.android.gms.measurement.internal.ea r11 = r11.k
            com.google.android.gms.measurement.internal.jn r12 = r58.G_()
            java.lang.String r12 = r12.a((com.google.android.gms.internal.measurement.ab.e) r9)
            java.lang.String r13 = "Filter definition"
            r11.a(r13, r12)
        L_0x057d:
            boolean r11 = r9.a()
            if (r11 == 0) goto L_0x05c0
            int r11 = r9.zzd
            r12 = 256(0x100, float:3.59E-43)
            if (r11 <= r12) goto L_0x058a
            goto L_0x05c0
        L_0x058a:
            com.google.android.gms.measurement.internal.kb r11 = new com.google.android.gms.measurement.internal.kb
            java.lang.String r12 = r10.f12298a
            r11.<init>(r10, r12, r7, r9)
            int r9 = r9.zzd
            boolean r9 = r10.a(r7, r9)
            r13 = r62
            boolean r12 = r11.a(r13, r4, r9)
            com.google.android.gms.measurement.internal.ke r9 = r58.H_()
            java.lang.String r14 = r10.f12298a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.o.at
            boolean r9 = r9.d(r14, r15)
            if (r9 == 0) goto L_0x05b7
            if (r12 != 0) goto L_0x05b7
            java.util.Set<java.lang.Integer> r8 = r10.f12299c
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            r8.add(r9)
            goto L_0x05e9
        L_0x05b7:
            com.google.android.gms.measurement.internal.jx r9 = r10.a(r7)
            r9.a(r11)
            goto L_0x052c
        L_0x05c0:
            r13 = r62
            com.google.android.gms.measurement.internal.dy r8 = r58.J_()
            com.google.android.gms.measurement.internal.ea r8 = r8.f11831f
            java.lang.String r11 = r10.f12298a
            java.lang.Object r11 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)
            boolean r12 = r9.a()
            if (r12 == 0) goto L_0x05db
            int r9 = r9.zzd
            java.lang.Integer r14 = java.lang.Integer.valueOf(r9)
            goto L_0x05dc
        L_0x05db:
            r14 = 0
        L_0x05dc:
            java.lang.String r9 = java.lang.String.valueOf(r14)
            java.lang.String r12 = "Invalid property filter ID. appId, id"
            r8.a(r12, r11, r9)
            r12 = 0
            goto L_0x05e9
        L_0x05e7:
            r13 = r62
        L_0x05e9:
            if (r12 != 0) goto L_0x04f3
            java.util.Set<java.lang.Integer> r8 = r10.f12299c
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8.add(r7)
            goto L_0x04f3
        L_0x05f6:
            r13 = r62
            goto L_0x04bc
        L_0x05fa:
            com.google.android.gms.measurement.internal.ke r1 = r58.H_()
            java.lang.String r2 = r10.f12298a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.o.ar
            boolean r1 = r1.d(r2, r3)
            androidx.a.a r2 = new androidx.a.a
            r2.<init>()
            if (r1 == 0) goto L_0x0617
            com.google.android.gms.measurement.internal.d r1 = r58.F_()
            java.lang.String r2 = r10.f12298a
            java.util.Map r2 = r1.a((java.lang.String) r2, (java.util.List<java.lang.String>) r0)
        L_0x0617:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.jx> r0 = r10.f12300d
            java.util.Set r0 = r0.keySet()
            java.util.Set<java.lang.Integer> r3 = r10.f12299c
            r0.removeAll(r3)
            java.util.Iterator r3 = r0.iterator()
        L_0x062b:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x06c2
            java.lang.Object r0 = r3.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.jx> r4 = r10.f12300d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            java.lang.Object r4 = r4.get(r5)
            com.google.android.gms.measurement.internal.jx r4 = (com.google.android.gms.measurement.internal.jx) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            java.lang.Object r5 = r2.get(r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.aj$a r4 = r4.a(r0, r5)
            r1.add(r4)
            com.google.android.gms.measurement.internal.d r5 = r58.F_()
            java.lang.String r6 = r10.f12298a
            com.google.android.gms.internal.measurement.aj$i r4 = r4.a()
            r5.w()
            r5.h()
            com.google.android.gms.common.internal.s.a((java.lang.String) r6)
            com.google.android.gms.common.internal.s.a(r4)
            byte[] r4 = r4.i()
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            java.lang.String r8 = "app_id"
            r7.put(r8, r6)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r8 = "audience_id"
            r7.put(r8, r0)
            java.lang.String r0 = "current_results"
            r7.put(r0, r4)
            android.database.sqlite.SQLiteDatabase r0 = r5.e()     // Catch:{ SQLiteException -> 0x06af }
            java.lang.String r4 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r7 = r0.insertWithOnConflict(r4, r9, r7, r8)     // Catch:{ SQLiteException -> 0x06ad }
            r11 = -1
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x062b
            com.google.android.gms.measurement.internal.dy r0 = r5.J_()     // Catch:{ SQLiteException -> 0x06ad }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ SQLiteException -> 0x06ad }
            java.lang.String r4 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x06ad }
            r0.a(r4, r7)     // Catch:{ SQLiteException -> 0x06ad }
            goto L_0x062b
        L_0x06ad:
            r0 = move-exception
            goto L_0x06b1
        L_0x06af:
            r0 = move-exception
            r9 = 0
        L_0x06b1:
            com.google.android.gms.measurement.internal.dy r4 = r5.J_()
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c
            java.lang.Object r5 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r6)
            java.lang.String r6 = "Error storing filter results. appId"
            r4.a(r6, r5, r0)
            goto L_0x062b
        L_0x06c2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jv.a(java.lang.String, java.util.List, java.util.List, java.lang.Long):java.util.List");
    }

    private final jx a(int i2) {
        if (this.f12300d.containsKey(Integer.valueOf(i2))) {
            return this.f12300d.get(Integer.valueOf(i2));
        }
        jx jxVar = new jx(this, this.f12298a, (byte) 0);
        this.f12300d.put(Integer.valueOf(i2), jxVar);
        return jxVar;
    }

    private final boolean a(int i2, int i3) {
        if (this.f12300d.get(Integer.valueOf(i2)) == null) {
            return false;
        }
        return this.f12300d.get(Integer.valueOf(i2)).f12301a.get(i3);
    }
}
