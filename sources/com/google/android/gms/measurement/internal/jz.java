package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.ab;

final class jz extends kc {

    /* renamed from: g  reason: collision with root package name */
    private ab.b f12311g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ jv f12312h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    jz(jv jvVar, String str, int i2, ab.b bVar) {
        super(str, i2);
        this.f12312h = jvVar;
        this.f12311g = bVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f12311g.zzd;
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r1v16, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x037c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x037d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.android.gms.internal.measurement.aj.c r11, long r12, com.google.android.gms.measurement.internal.k r14, boolean r15) {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.jv r0 = r10.f12312h
            com.google.android.gms.measurement.internal.ke r0 = r0.H_()
            java.lang.String r1 = r10.f12328a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.al
            boolean r0 = r0.d(r1, r2)
            com.google.android.gms.measurement.internal.jv r1 = r10.f12312h
            com.google.android.gms.measurement.internal.ke r1 = r1.H_()
            java.lang.String r2 = r10.f12328a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.o.am
            boolean r1 = r1.d(r2, r3)
            if (r1 == 0) goto L_0x0028
            if (r0 == 0) goto L_0x0028
            com.google.android.gms.internal.measurement.ab$b r1 = r10.f12311g
            boolean r1 = r1.zzk
            if (r1 == 0) goto L_0x0028
            long r12 = r14.f12317e
        L_0x0028:
            com.google.android.gms.measurement.internal.jv r14 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r14 = r14.J_()
            r1 = 2
            boolean r14 = r14.a((int) r1)
            r1 = 0
            if (r14 == 0) goto L_0x0082
            com.google.android.gms.measurement.internal.jv r14 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r14 = r14.J_()
            com.google.android.gms.measurement.internal.ea r14 = r14.k
            int r2 = r10.f12329b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.gms.internal.measurement.ab$b r3 = r10.f12311g
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x0055
            com.google.android.gms.internal.measurement.ab$b r3 = r10.f12311g
            int r3 = r3.zzd
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0056
        L_0x0055:
            r3 = r1
        L_0x0056:
            com.google.android.gms.measurement.internal.jv r4 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r4 = r4.l()
            com.google.android.gms.internal.measurement.ab$b r5 = r10.f12311g
            java.lang.String r5 = r5.zze
            java.lang.String r4 = r4.a((java.lang.String) r5)
            java.lang.String r5 = "Evaluating filter. audience, filter, event"
            r14.a(r5, r2, r3, r4)
            com.google.android.gms.measurement.internal.jv r14 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r14 = r14.J_()
            com.google.android.gms.measurement.internal.ea r14 = r14.k
            com.google.android.gms.measurement.internal.jv r2 = r10.f12312h
            com.google.android.gms.measurement.internal.jn r2 = r2.G_()
            com.google.android.gms.internal.measurement.ab$b r3 = r10.f12311g
            java.lang.String r2 = r2.a((com.google.android.gms.internal.measurement.ab.b) r3)
            java.lang.String r3 = "Filter definition"
            r14.a(r3, r2)
        L_0x0082:
            com.google.android.gms.internal.measurement.ab$b r14 = r10.f12311g
            boolean r14 = r14.a()
            r2 = 0
            r3 = 1
            if (r14 == 0) goto L_0x03a9
            com.google.android.gms.internal.measurement.ab$b r14 = r10.f12311g
            int r14 = r14.zzd
            r4 = 256(0x100, float:3.59E-43)
            if (r14 <= r4) goto L_0x0096
            goto L_0x03a9
        L_0x0096:
            com.google.android.gms.internal.measurement.ab$b r14 = r10.f12311g
            boolean r14 = r14.zzi
            com.google.android.gms.internal.measurement.ab$b r4 = r10.f12311g
            boolean r4 = r4.zzj
            if (r0 == 0) goto L_0x00a8
            com.google.android.gms.internal.measurement.ab$b r0 = r10.f12311g
            boolean r0 = r0.zzk
            if (r0 == 0) goto L_0x00a8
            r0 = 1
            goto L_0x00a9
        L_0x00a8:
            r0 = 0
        L_0x00a9:
            if (r14 != 0) goto L_0x00b2
            if (r4 != 0) goto L_0x00b2
            if (r0 == 0) goto L_0x00b0
            goto L_0x00b2
        L_0x00b0:
            r14 = 0
            goto L_0x00b3
        L_0x00b2:
            r14 = 1
        L_0x00b3:
            if (r15 == 0) goto L_0x00db
            if (r14 != 0) goto L_0x00db
            com.google.android.gms.measurement.internal.jv r11 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r11 = r11.J_()
            com.google.android.gms.measurement.internal.ea r11 = r11.k
            int r12 = r10.f12329b
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.google.android.gms.internal.measurement.ab$b r13 = r10.f12311g
            boolean r13 = r13.a()
            if (r13 == 0) goto L_0x00d5
            com.google.android.gms.internal.measurement.ab$b r13 = r10.f12311g
            int r13 = r13.zzd
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
        L_0x00d5:
            java.lang.String r13 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r11.a(r13, r12, r1)
            return r3
        L_0x00db:
            com.google.android.gms.internal.measurement.ab$b r15 = r10.f12311g
            java.lang.String r0 = r11.zze
            int r5 = r15.zzc
            r5 = r5 & 8
            if (r5 == 0) goto L_0x00e7
            r5 = 1
            goto L_0x00e8
        L_0x00e7:
            r5 = 0
        L_0x00e8:
            if (r5 == 0) goto L_0x0100
            com.google.android.gms.internal.measurement.ab$d r5 = r15.b()
            java.lang.Boolean r12 = a((long) r12, (com.google.android.gms.internal.measurement.ab.d) r5)
            if (r12 != 0) goto L_0x00f6
            goto L_0x0367
        L_0x00f6:
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x0100
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            goto L_0x0367
        L_0x0100:
            java.util.HashSet r12 = new java.util.HashSet
            r12.<init>()
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.ab$c> r13 = r15.zzf
            java.util.Iterator r13 = r13.iterator()
        L_0x010b:
            boolean r5 = r13.hasNext()
            if (r5 == 0) goto L_0x013e
            java.lang.Object r5 = r13.next()
            com.google.android.gms.internal.measurement.ab$c r5 = (com.google.android.gms.internal.measurement.ab.c) r5
            java.lang.String r6 = r5.zzg
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0138
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.f11831f
            com.google.android.gms.measurement.internal.jv r13 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r13 = r13.l()
            java.lang.String r13 = r13.a((java.lang.String) r0)
            java.lang.String r15 = "null or empty param name in filter. event"
            r12.a(r15, r13)
            goto L_0x0367
        L_0x0138:
            java.lang.String r5 = r5.zzg
            r12.add(r5)
            goto L_0x010b
        L_0x013e:
            androidx.a.a r13 = new androidx.a.a
            r13.<init>()
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.aj$e> r5 = r11.zzd
            java.util.Iterator r5 = r5.iterator()
        L_0x0149:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x01c4
            java.lang.Object r6 = r5.next()
            com.google.android.gms.internal.measurement.aj$e r6 = (com.google.android.gms.internal.measurement.aj.e) r6
            java.lang.String r7 = r6.zzd
            boolean r7 = r12.contains(r7)
            if (r7 == 0) goto L_0x0149
            boolean r7 = r6.b()
            if (r7 == 0) goto L_0x0177
            java.lang.String r7 = r6.zzd
            boolean r8 = r6.b()
            if (r8 == 0) goto L_0x0172
            long r8 = r6.zzf
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            goto L_0x0173
        L_0x0172:
            r6 = r1
        L_0x0173:
            r13.put(r7, r6)
            goto L_0x0149
        L_0x0177:
            boolean r7 = r6.c()
            if (r7 == 0) goto L_0x0191
            java.lang.String r7 = r6.zzd
            boolean r8 = r6.c()
            if (r8 == 0) goto L_0x018c
            double r8 = r6.zzh
            java.lang.Double r6 = java.lang.Double.valueOf(r8)
            goto L_0x018d
        L_0x018c:
            r6 = r1
        L_0x018d:
            r13.put(r7, r6)
            goto L_0x0149
        L_0x0191:
            boolean r7 = r6.a()
            if (r7 == 0) goto L_0x019f
            java.lang.String r7 = r6.zzd
            java.lang.String r6 = r6.zze
            r13.put(r7, r6)
            goto L_0x0149
        L_0x019f:
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.f11831f
            com.google.android.gms.measurement.internal.jv r13 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r13 = r13.l()
            java.lang.String r13 = r13.a((java.lang.String) r0)
            com.google.android.gms.measurement.internal.jv r15 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r15 = r15.l()
            java.lang.String r0 = r6.zzd
            java.lang.String r15 = r15.b(r0)
            java.lang.String r0 = "Unknown value for param. event, param"
            r12.a(r0, r13, r15)
            goto L_0x0367
        L_0x01c4:
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.ab$c> r12 = r15.zzf
            java.util.Iterator r12 = r12.iterator()
        L_0x01ca:
            boolean r15 = r12.hasNext()
            if (r15 == 0) goto L_0x0365
            java.lang.Object r15 = r12.next()
            com.google.android.gms.internal.measurement.ab$c r15 = (com.google.android.gms.internal.measurement.ab.c) r15
            boolean r5 = r15.e()
            if (r5 == 0) goto L_0x01e2
            boolean r5 = r15.zzf
            if (r5 == 0) goto L_0x01e2
            r5 = 1
            goto L_0x01e3
        L_0x01e2:
            r5 = 0
        L_0x01e3:
            java.lang.String r6 = r15.zzg
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0204
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.f11831f
            com.google.android.gms.measurement.internal.jv r13 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r13 = r13.l()
            java.lang.String r13 = r13.a((java.lang.String) r0)
            java.lang.String r15 = "Event has empty param name. event"
            r12.a(r15, r13)
            goto L_0x0367
        L_0x0204:
            java.lang.Object r7 = r13.get(r6)
            boolean r8 = r7 instanceof java.lang.Long
            if (r8 == 0) goto L_0x0251
            boolean r8 = r15.c()
            if (r8 != 0) goto L_0x0235
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.f11831f
            com.google.android.gms.measurement.internal.jv r13 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r13 = r13.l()
            java.lang.String r13 = r13.a((java.lang.String) r0)
            com.google.android.gms.measurement.internal.jv r15 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r15 = r15.l()
            java.lang.String r15 = r15.b(r6)
            java.lang.String r0 = "No number filter for long param. event, param"
            r12.a(r0, r13, r15)
            goto L_0x0367
        L_0x0235:
            java.lang.Long r7 = (java.lang.Long) r7
            long r6 = r7.longValue()
            com.google.android.gms.internal.measurement.ab$d r15 = r15.d()
            java.lang.Boolean r15 = a((long) r6, (com.google.android.gms.internal.measurement.ab.d) r15)
            if (r15 != 0) goto L_0x0247
            goto L_0x0367
        L_0x0247:
            boolean r15 = r15.booleanValue()
            if (r15 != r5) goto L_0x01ca
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            goto L_0x0367
        L_0x0251:
            boolean r8 = r7 instanceof java.lang.Double
            if (r8 == 0) goto L_0x029a
            boolean r8 = r15.c()
            if (r8 != 0) goto L_0x027e
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.f11831f
            com.google.android.gms.measurement.internal.jv r13 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r13 = r13.l()
            java.lang.String r13 = r13.a((java.lang.String) r0)
            com.google.android.gms.measurement.internal.jv r15 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r15 = r15.l()
            java.lang.String r15 = r15.b(r6)
            java.lang.String r0 = "No number filter for double param. event, param"
            r12.a(r0, r13, r15)
            goto L_0x0367
        L_0x027e:
            java.lang.Double r7 = (java.lang.Double) r7
            double r6 = r7.doubleValue()
            com.google.android.gms.internal.measurement.ab$d r15 = r15.d()
            java.lang.Boolean r15 = a((double) r6, (com.google.android.gms.internal.measurement.ab.d) r15)
            if (r15 != 0) goto L_0x0290
            goto L_0x0367
        L_0x0290:
            boolean r15 = r15.booleanValue()
            if (r15 != r5) goto L_0x01ca
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            goto L_0x0367
        L_0x029a:
            boolean r8 = r7 instanceof java.lang.String
            if (r8 == 0) goto L_0x031d
            boolean r8 = r15.a()
            if (r8 == 0) goto L_0x02b5
            java.lang.String r7 = (java.lang.String) r7
            com.google.android.gms.internal.measurement.ab$f r15 = r15.b()
            com.google.android.gms.measurement.internal.jv r6 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r6 = r6.J_()
            java.lang.Boolean r15 = a((java.lang.String) r7, (com.google.android.gms.internal.measurement.ab.f) r15, (com.google.android.gms.measurement.internal.dy) r6)
            goto L_0x02cb
        L_0x02b5:
            boolean r8 = r15.c()
            if (r8 == 0) goto L_0x02fb
            java.lang.String r7 = (java.lang.String) r7
            boolean r8 = com.google.android.gms.measurement.internal.jn.a((java.lang.String) r7)
            if (r8 == 0) goto L_0x02d9
            com.google.android.gms.internal.measurement.ab$d r15 = r15.d()
            java.lang.Boolean r15 = a((java.lang.String) r7, (com.google.android.gms.internal.measurement.ab.d) r15)
        L_0x02cb:
            if (r15 != 0) goto L_0x02cf
            goto L_0x0367
        L_0x02cf:
            boolean r15 = r15.booleanValue()
            if (r15 != r5) goto L_0x01ca
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            goto L_0x0367
        L_0x02d9:
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.f11831f
            com.google.android.gms.measurement.internal.jv r13 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r13 = r13.l()
            java.lang.String r13 = r13.a((java.lang.String) r0)
            com.google.android.gms.measurement.internal.jv r15 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r15 = r15.l()
            java.lang.String r15 = r15.b(r6)
            java.lang.String r0 = "Invalid param value for number filter. event, param"
            r12.a(r0, r13, r15)
            goto L_0x0367
        L_0x02fb:
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.f11831f
            com.google.android.gms.measurement.internal.jv r13 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r13 = r13.l()
            java.lang.String r13 = r13.a((java.lang.String) r0)
            com.google.android.gms.measurement.internal.jv r15 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r15 = r15.l()
            java.lang.String r15 = r15.b(r6)
            java.lang.String r0 = "No filter for String param. event, param"
            r12.a(r0, r13, r15)
            goto L_0x0367
        L_0x031d:
            if (r7 != 0) goto L_0x0343
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.k
            com.google.android.gms.measurement.internal.jv r13 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r13 = r13.l()
            java.lang.String r13 = r13.a((java.lang.String) r0)
            com.google.android.gms.measurement.internal.jv r15 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r15 = r15.l()
            java.lang.String r15 = r15.b(r6)
            java.lang.String r0 = "Missing param for filter. event, param"
            r12.a(r0, r13, r15)
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            goto L_0x0367
        L_0x0343:
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.f11831f
            com.google.android.gms.measurement.internal.jv r13 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r13 = r13.l()
            java.lang.String r13 = r13.a((java.lang.String) r0)
            com.google.android.gms.measurement.internal.jv r15 = r10.f12312h
            com.google.android.gms.measurement.internal.dw r15 = r15.l()
            java.lang.String r15 = r15.b(r6)
            java.lang.String r0 = "Unknown param type. event, param"
            r12.a(r0, r13, r15)
            goto L_0x0367
        L_0x0365:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
        L_0x0367:
            com.google.android.gms.measurement.internal.jv r12 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r12 = r12.J_()
            com.google.android.gms.measurement.internal.ea r12 = r12.k
            if (r1 != 0) goto L_0x0374
            java.lang.String r13 = "null"
            goto L_0x0375
        L_0x0374:
            r13 = r1
        L_0x0375:
            java.lang.String r15 = "Event filter result"
            r12.a(r15, r13)
            if (r1 != 0) goto L_0x037d
            return r2
        L_0x037d:
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r10.f12330c = r12
            boolean r12 = r1.booleanValue()
            if (r12 != 0) goto L_0x0388
            return r3
        L_0x0388:
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r10.f12331d = r12
            if (r14 == 0) goto L_0x03a8
            boolean r12 = r11.b()
            if (r12 != 0) goto L_0x0395
            goto L_0x03a8
        L_0x0395:
            if (r4 == 0) goto L_0x03a0
            long r11 = r11.zzf
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r10.f12333f = r11
            goto L_0x03a8
        L_0x03a0:
            long r11 = r11.zzf
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r10.f12332e = r11
        L_0x03a8:
            return r3
        L_0x03a9:
            com.google.android.gms.measurement.internal.jv r11 = r10.f12312h
            com.google.android.gms.measurement.internal.dy r11 = r11.J_()
            com.google.android.gms.measurement.internal.ea r11 = r11.f11831f
            java.lang.String r12 = r10.f12328a
            java.lang.Object r12 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r12)
            com.google.android.gms.internal.measurement.ab$b r13 = r10.f12311g
            boolean r13 = r13.a()
            if (r13 == 0) goto L_0x03c7
            com.google.android.gms.internal.measurement.ab$b r13 = r10.f12311g
            int r13 = r13.zzd
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
        L_0x03c7:
            java.lang.String r13 = java.lang.String.valueOf(r1)
            java.lang.String r14 = "Invalid event filter ID. appId, id"
            r11.a(r14, r12, r13)
            com.google.android.gms.measurement.internal.jv r11 = r10.f12312h
            com.google.android.gms.measurement.internal.ke r11 = r11.H_()
            java.lang.String r12 = r10.f12328a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.o.at
            boolean r11 = r11.d(r12, r13)
            if (r11 == 0) goto L_0x03e1
            return r2
        L_0x03e1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jz.a(com.google.android.gms.internal.measurement.aj$c, long, com.google.android.gms.measurement.internal.k, boolean):boolean");
    }
}
