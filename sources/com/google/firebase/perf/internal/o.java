package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.by;
import java.util.Iterator;

final class o extends v {

    /* renamed from: a  reason: collision with root package name */
    private by f39221a;

    o(by byVar) {
        this.f39221a = byVar;
    }

    public final boolean a() {
        boolean z;
        boolean z2;
        if (!a(this.f39221a, 0)) {
            String valueOf = String.valueOf(this.f39221a.zzmd);
            if (valueOf.length() != 0) {
                "Invalid Trace:".concat(valueOf);
            } else {
                new String("Invalid Trace:");
            }
            return false;
        }
        by byVar = this.f39221a;
        if (!(byVar.zzmg.size() > 0)) {
            Iterator<by> it2 = byVar.zzmh.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                if (it2.next().zzmg.size() > 0) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
        } else {
            z = true;
        }
        if (!z || b(this.f39221a, 0)) {
            return true;
        }
        String valueOf2 = String.valueOf(this.f39221a.zzmd);
        if (valueOf2.length() != 0) {
            "Invalid Counters for Trace:".concat(valueOf2);
        } else {
            new String("Invalid Counters for Trace:");
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(com.google.android.gms.internal.p001firebaseperf.by r8, int r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            if (r9 <= r1) goto L_0x0008
            return r0
        L_0x0008:
            java.lang.String r2 = r8.zzmd
            if (r2 == 0) goto L_0x0020
            java.lang.String r2 = r2.trim()
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0020
            int r2 = r2.length()
            r3 = 100
            if (r2 > r3) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r2 != 0) goto L_0x003b
            java.lang.String r9 = "invalid TraceId:"
            java.lang.String r8 = r8.zzmd
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r1 = r8.length()
            if (r1 == 0) goto L_0x0035
            r9.concat(r8)
            goto L_0x003a
        L_0x0035:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r9)
        L_0x003a:
            return r0
        L_0x003b:
            if (r8 == 0) goto L_0x0047
            long r2 = r8.zzmf
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0047
            r2 = 1
            goto L_0x0048
        L_0x0047:
            r2 = 0
        L_0x0048:
            if (r2 != 0) goto L_0x005c
            long r8 = r8.zzmf
            r1 = 42
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "invalid TraceDuration:"
            r2.append(r1)
            r2.append(r8)
            return r0
        L_0x005c:
            boolean r2 = r8.a()
            if (r2 != 0) goto L_0x0063
            return r0
        L_0x0063:
            com.google.android.gms.internal.firebase-perf.dz<com.google.android.gms.internal.firebase-perf.by> r2 = r8.zzmh
            java.util.Iterator r2 = r2.iterator()
        L_0x0069:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x007e
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.firebase-perf.by r3 = (com.google.android.gms.internal.p001firebaseperf.by) r3
            int r4 = r9 + 1
            boolean r3 = r7.a(r3, r4)
            if (r3 != 0) goto L_0x0069
            return r0
        L_0x007e:
            com.google.android.gms.internal.firebase-perf.er<java.lang.String, java.lang.String> r8 = r8.zziz
            java.util.Map r8 = java.util.Collections.unmodifiableMap(r8)
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x008c:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00a0
            java.lang.Object r9 = r8.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.String r9 = com.google.firebase.perf.internal.v.a(r9)
            if (r9 == 0) goto L_0x008c
            r8 = 0
            goto L_0x00a1
        L_0x00a0:
            r8 = 1
        L_0x00a1:
            if (r8 != 0) goto L_0x00a4
            return r0
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.o.a(com.google.android.gms.internal.firebase-perf.by, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0043 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean b(com.google.android.gms.internal.p001firebaseperf.by r7, int r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            if (r8 <= r1) goto L_0x0008
            return r0
        L_0x0008:
            com.google.android.gms.internal.firebase-perf.er<java.lang.String, java.lang.Long> r2 = r7.zzmg
            java.util.Map r2 = java.util.Collections.unmodifiableMap(r2)
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0016:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x008c
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x002c
        L_0x002a:
            r4 = 0
            goto L_0x0041
        L_0x002c:
            java.lang.String r4 = r4.trim()
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x0037
            goto L_0x002a
        L_0x0037:
            int r4 = r4.length()
            r5 = 100
            if (r4 <= r5) goto L_0x0040
            goto L_0x002a
        L_0x0040:
            r4 = 1
        L_0x0041:
            if (r4 != 0) goto L_0x005f
            java.lang.String r7 = "invalid CounterId:"
            java.lang.Object r8 = r3.getKey()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r1 = r8.length()
            if (r1 == 0) goto L_0x0059
            r7.concat(r8)
            goto L_0x005e
        L_0x0059:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r7)
        L_0x005e:
            return r0
        L_0x005f:
            java.lang.Object r4 = r3.getValue()
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x0069
            r4 = 1
            goto L_0x006a
        L_0x0069:
            r4 = 0
        L_0x006a:
            if (r4 != 0) goto L_0x0016
            java.lang.Object r7 = r3.getValue()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = java.lang.String.valueOf(r7)
            int r8 = r8.length()
            int r8 = r8 + 21
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            java.lang.String r8 = "invalid CounterValue:"
            r1.append(r8)
            r1.append(r7)
            return r0
        L_0x008c:
            com.google.android.gms.internal.firebase-perf.dz<com.google.android.gms.internal.firebase-perf.by> r7 = r7.zzmh
            java.util.Iterator r7 = r7.iterator()
        L_0x0092:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x00a7
            java.lang.Object r2 = r7.next()
            com.google.android.gms.internal.firebase-perf.by r2 = (com.google.android.gms.internal.p001firebaseperf.by) r2
            int r3 = r8 + 1
            boolean r2 = r6.b(r2, r3)
            if (r2 != 0) goto L_0x0092
            return r0
        L_0x00a7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.o.b(com.google.android.gms.internal.firebase-perf.by, int):boolean");
    }
}
