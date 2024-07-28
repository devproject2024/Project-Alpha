package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.ab;

final class kb extends kc {

    /* renamed from: g  reason: collision with root package name */
    private ab.e f12326g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ jv f12327h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    kb(jv jvVar, String str, int i2, ab.e eVar) {
        super(str, i2);
        this.f12327h = jvVar;
        this.f12326g = eVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f12326g.zzd;
    }

    /* JADX WARNING: type inference failed for: r7v15, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.Long r13, com.google.android.gms.internal.measurement.aj.k r14, boolean r15) {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.jv r0 = r12.f12327h
            com.google.android.gms.measurement.internal.ke r0 = r0.H_()
            java.lang.String r1 = r12.f12328a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.al
            boolean r0 = r0.d(r1, r2)
            com.google.android.gms.measurement.internal.jv r1 = r12.f12327h
            com.google.android.gms.measurement.internal.ke r1 = r1.H_()
            java.lang.String r2 = r12.f12328a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.o.ar
            boolean r1 = r1.d(r2, r3)
            com.google.android.gms.internal.measurement.ab$e r2 = r12.f12326g
            boolean r2 = r2.zzg
            com.google.android.gms.internal.measurement.ab$e r3 = r12.f12326g
            boolean r3 = r3.zzh
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x0030
            com.google.android.gms.internal.measurement.ab$e r6 = r12.f12326g
            boolean r6 = r6.zzi
            if (r6 == 0) goto L_0x0030
            r6 = 1
            goto L_0x0031
        L_0x0030:
            r6 = 0
        L_0x0031:
            if (r2 != 0) goto L_0x003a
            if (r3 != 0) goto L_0x003a
            if (r6 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r2 = 0
            goto L_0x003b
        L_0x003a:
            r2 = 1
        L_0x003b:
            r7 = 0
            if (r15 == 0) goto L_0x0064
            if (r2 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.jv r13 = r12.f12327h
            com.google.android.gms.measurement.internal.dy r13 = r13.J_()
            com.google.android.gms.measurement.internal.ea r13 = r13.k
            int r14 = r12.f12329b
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            com.google.android.gms.internal.measurement.ab$e r15 = r12.f12326g
            boolean r15 = r15.a()
            if (r15 == 0) goto L_0x005e
            com.google.android.gms.internal.measurement.ab$e r15 = r12.f12326g
            int r15 = r15.zzd
            java.lang.Integer r7 = java.lang.Integer.valueOf(r15)
        L_0x005e:
            java.lang.String r15 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r13.a(r15, r14, r7)
            return r5
        L_0x0064:
            com.google.android.gms.internal.measurement.ab$e r8 = r12.f12326g
            com.google.android.gms.internal.measurement.ab$c r8 = r8.b()
            boolean r9 = r8.zzf
            boolean r10 = r14.b()
            if (r10 == 0) goto L_0x00a3
            boolean r10 = r8.c()
            if (r10 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.jv r8 = r12.f12327h
            com.google.android.gms.measurement.internal.dy r8 = r8.J_()
            com.google.android.gms.measurement.internal.ea r8 = r8.f11831f
            com.google.android.gms.measurement.internal.jv r9 = r12.f12327h
            com.google.android.gms.measurement.internal.dw r9 = r9.l()
            java.lang.String r10 = r14.zze
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = "No number filter for long property. property"
            r8.a(r10, r9)
            goto L_0x016c
        L_0x0093:
            long r10 = r14.zzg
            com.google.android.gms.internal.measurement.ab$d r7 = r8.d()
            java.lang.Boolean r7 = a((long) r10, (com.google.android.gms.internal.measurement.ab.d) r7)
            java.lang.Boolean r7 = a((java.lang.Boolean) r7, (boolean) r9)
            goto L_0x016c
        L_0x00a3:
            boolean r10 = r14.c()
            if (r10 == 0) goto L_0x00da
            boolean r10 = r8.c()
            if (r10 != 0) goto L_0x00ca
            com.google.android.gms.measurement.internal.jv r8 = r12.f12327h
            com.google.android.gms.measurement.internal.dy r8 = r8.J_()
            com.google.android.gms.measurement.internal.ea r8 = r8.f11831f
            com.google.android.gms.measurement.internal.jv r9 = r12.f12327h
            com.google.android.gms.measurement.internal.dw r9 = r9.l()
            java.lang.String r10 = r14.zze
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = "No number filter for double property. property"
            r8.a(r10, r9)
            goto L_0x016c
        L_0x00ca:
            double r10 = r14.zzi
            com.google.android.gms.internal.measurement.ab$d r7 = r8.d()
            java.lang.Boolean r7 = a((double) r10, (com.google.android.gms.internal.measurement.ab.d) r7)
            java.lang.Boolean r7 = a((java.lang.Boolean) r7, (boolean) r9)
            goto L_0x016c
        L_0x00da:
            int r10 = r14.zzc
            r10 = r10 & 4
            if (r10 == 0) goto L_0x00e2
            r10 = 1
            goto L_0x00e3
        L_0x00e2:
            r10 = 0
        L_0x00e3:
            if (r10 == 0) goto L_0x0153
            boolean r10 = r8.a()
            if (r10 != 0) goto L_0x013e
            boolean r10 = r8.c()
            if (r10 != 0) goto L_0x010b
            com.google.android.gms.measurement.internal.jv r8 = r12.f12327h
            com.google.android.gms.measurement.internal.dy r8 = r8.J_()
            com.google.android.gms.measurement.internal.ea r8 = r8.f11831f
            com.google.android.gms.measurement.internal.jv r9 = r12.f12327h
            com.google.android.gms.measurement.internal.dw r9 = r9.l()
            java.lang.String r10 = r14.zze
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = "No string or number filter defined. property"
            r8.a(r10, r9)
            goto L_0x016c
        L_0x010b:
            java.lang.String r10 = r14.zzf
            boolean r10 = com.google.android.gms.measurement.internal.jn.a((java.lang.String) r10)
            if (r10 == 0) goto L_0x0122
            java.lang.String r7 = r14.zzf
            com.google.android.gms.internal.measurement.ab$d r8 = r8.d()
            java.lang.Boolean r7 = a((java.lang.String) r7, (com.google.android.gms.internal.measurement.ab.d) r8)
            java.lang.Boolean r7 = a((java.lang.Boolean) r7, (boolean) r9)
            goto L_0x016c
        L_0x0122:
            com.google.android.gms.measurement.internal.jv r8 = r12.f12327h
            com.google.android.gms.measurement.internal.dy r8 = r8.J_()
            com.google.android.gms.measurement.internal.ea r8 = r8.f11831f
            com.google.android.gms.measurement.internal.jv r9 = r12.f12327h
            com.google.android.gms.measurement.internal.dw r9 = r9.l()
            java.lang.String r10 = r14.zze
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = r14.zzf
            java.lang.String r11 = "Invalid user property value for Numeric number filter. property, value"
            r8.a(r11, r9, r10)
            goto L_0x016c
        L_0x013e:
            java.lang.String r7 = r14.zzf
            com.google.android.gms.internal.measurement.ab$f r8 = r8.b()
            com.google.android.gms.measurement.internal.jv r10 = r12.f12327h
            com.google.android.gms.measurement.internal.dy r10 = r10.J_()
            java.lang.Boolean r7 = a((java.lang.String) r7, (com.google.android.gms.internal.measurement.ab.f) r8, (com.google.android.gms.measurement.internal.dy) r10)
            java.lang.Boolean r7 = a((java.lang.Boolean) r7, (boolean) r9)
            goto L_0x016c
        L_0x0153:
            com.google.android.gms.measurement.internal.jv r8 = r12.f12327h
            com.google.android.gms.measurement.internal.dy r8 = r8.J_()
            com.google.android.gms.measurement.internal.ea r8 = r8.f11831f
            com.google.android.gms.measurement.internal.jv r9 = r12.f12327h
            com.google.android.gms.measurement.internal.dw r9 = r9.l()
            java.lang.String r10 = r14.zze
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = "User property has no value, property"
            r8.a(r10, r9)
        L_0x016c:
            com.google.android.gms.measurement.internal.jv r8 = r12.f12327h
            com.google.android.gms.measurement.internal.dy r8 = r8.J_()
            com.google.android.gms.measurement.internal.ea r8 = r8.k
            if (r7 != 0) goto L_0x0179
            java.lang.String r9 = "null"
            goto L_0x017a
        L_0x0179:
            r9 = r7
        L_0x017a:
            java.lang.String r10 = "Property filter result"
            r8.a(r10, r9)
            if (r7 != 0) goto L_0x0182
            return r4
        L_0x0182:
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r12.f12330c = r4
            if (r0 == 0) goto L_0x0191
            if (r6 == 0) goto L_0x0191
            boolean r0 = r7.booleanValue()
            if (r0 != 0) goto L_0x0191
            return r5
        L_0x0191:
            if (r15 == 0) goto L_0x0199
            com.google.android.gms.internal.measurement.ab$e r15 = r12.f12326g
            boolean r15 = r15.zzg
            if (r15 == 0) goto L_0x019b
        L_0x0199:
            r12.f12331d = r7
        L_0x019b:
            boolean r15 = r7.booleanValue()
            if (r15 == 0) goto L_0x01c3
            if (r2 == 0) goto L_0x01c3
            boolean r15 = r14.a()
            if (r15 != 0) goto L_0x01aa
            goto L_0x01c3
        L_0x01aa:
            long r14 = r14.zzd
            if (r1 == 0) goto L_0x01b4
            if (r13 == 0) goto L_0x01b4
            long r14 = r13.longValue()
        L_0x01b4:
            if (r3 == 0) goto L_0x01bd
            java.lang.Long r13 = java.lang.Long.valueOf(r14)
            r12.f12333f = r13
            goto L_0x01c3
        L_0x01bd:
            java.lang.Long r13 = java.lang.Long.valueOf(r14)
            r12.f12332e = r13
        L_0x01c3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.kb.a(java.lang.Long, com.google.android.gms.internal.measurement.aj$k, boolean):boolean");
    }
}
