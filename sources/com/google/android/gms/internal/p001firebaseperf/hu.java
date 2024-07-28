package com.google.android.gms.internal.p001firebaseperf;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.hu  reason: invalid package */
final class hu<K, V> extends hq<K, V> {
    static final hq<Object, Object> zzaa = new hu((Object) null, new Object[0], 0);
    private final transient int size;
    private final transient Object zzab;
    private final transient Object[] zzy;

    /* access modifiers changed from: package-private */
    public final boolean zzn() {
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r2v4 ?, r2v1 ?, r2v5 ?, r2v6 ?, r2v8 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static <K, V> com.google.android.gms.internal.p001firebaseperf.hu<K, V> zza(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            com.google.android.gms.internal.firebase-perf.hq<java.lang.Object, java.lang.Object> r10 = zzaa
            com.google.android.gms.internal.firebase-perf.hu r10 = (com.google.android.gms.internal.p001firebaseperf.hu) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x0019
            r10 = r11[r1]
            r1 = r11[r2]
            com.google.android.gms.internal.p001firebaseperf.hj.a((java.lang.Object) r10, (java.lang.Object) r1)
            com.google.android.gms.internal.firebase-perf.hu r10 = new com.google.android.gms.internal.firebase-perf.hu
            r10.<init>(r0, r11, r2)
            return r10
        L_0x0019:
            int r3 = r11.length
            int r3 = r3 >> r2
            com.google.android.gms.internal.p001firebaseperf.cc.b(r10, r3)
            r3 = 2
            int r3 = java.lang.Math.max(r10, r3)
            r4 = 751619276(0x2ccccccc, float:5.8207657E-12)
            r5 = 1073741824(0x40000000, float:2.0)
            if (r3 >= r4) goto L_0x0042
            int r4 = r3 + -1
            int r4 = java.lang.Integer.highestOneBit(r4)
            int r4 = r4 << r2
            r5 = r4
        L_0x0032:
            double r6 = (double) r5
            r8 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r6 = r6 * r8
            double r8 = (double) r3
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0049
            int r5 = r5 << 1
            goto L_0x0032
        L_0x0042:
            if (r3 >= r5) goto L_0x0046
            r3 = 1
            goto L_0x0047
        L_0x0046:
            r3 = 0
        L_0x0047:
            if (r3 == 0) goto L_0x010c
        L_0x0049:
            if (r10 != r2) goto L_0x0055
            r1 = r11[r1]
            r2 = r11[r2]
            com.google.android.gms.internal.p001firebaseperf.hj.a((java.lang.Object) r1, (java.lang.Object) r2)
            r2 = r0
            goto L_0x0106
        L_0x0055:
            int r0 = r5 + -1
            r2 = 128(0x80, float:1.794E-43)
            r3 = -1
            if (r5 > r2) goto L_0x0094
            byte[] r2 = new byte[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x0061:
            if (r1 >= r10) goto L_0x0106
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.p001firebaseperf.hj.a((java.lang.Object) r4, (java.lang.Object) r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.p001firebaseperf.hi.a(r6)
        L_0x0076:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x0084
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0061
        L_0x0084:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x008f
            int r6 = r6 + 1
            goto L_0x0076
        L_0x008f:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x0094:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r5 > r2) goto L_0x00d2
            short[] r2 = new short[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x009e:
            if (r1 >= r10) goto L_0x0106
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.p001firebaseperf.hj.a((java.lang.Object) r4, (java.lang.Object) r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.p001firebaseperf.hi.a(r6)
        L_0x00b3:
            r6 = r6 & r0
            short r7 = r2[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x00c2
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x009e
        L_0x00c2:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00cd
            int r6 = r6 + 1
            goto L_0x00b3
        L_0x00cd:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x00d2:
            int[] r2 = new int[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x00d7:
            if (r1 >= r10) goto L_0x0106
            int r4 = r1 * 2
            r5 = r11[r4]
            r6 = r4 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.p001firebaseperf.hj.a((java.lang.Object) r5, (java.lang.Object) r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.p001firebaseperf.hi.a(r7)
        L_0x00ec:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r3) goto L_0x00f6
            r2[r7] = r4
            int r1 = r1 + 1
            goto L_0x00d7
        L_0x00f6:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x0101
            int r7 = r7 + 1
            goto L_0x00ec
        L_0x0101:
            java.lang.IllegalArgumentException r10 = zza(r5, r6, r11, r8)
            throw r10
        L_0x0106:
            com.google.android.gms.internal.firebase-perf.hu r0 = new com.google.android.gms.internal.firebase-perf.hu
            r0.<init>(r2, r11, r10)
            return r0
        L_0x010c:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "collection too large"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseperf.hu.zza(int, java.lang.Object[]):com.google.android.gms.internal.firebase-perf.hu");
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i2) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i2]);
        String valueOf4 = String.valueOf(objArr[i2 ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private hu(Object obj, Object[] objArr, int i2) {
        this.zzab = obj;
        this.zzy = objArr;
        this.size = i2;
    }

    public final int size() {
        return this.size;
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzab;
        V[] vArr = this.zzy;
        int i2 = this.size;
        if (obj == null) {
            return null;
        }
        if (i2 == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int a2 = hi.a(obj.hashCode());
                while (true) {
                    int i3 = a2 & length;
                    byte b2 = bArr[i3] & 255;
                    if (b2 == 255) {
                        return null;
                    }
                    if (vArr[b2].equals(obj)) {
                        return vArr[b2 ^ 1];
                    }
                    a2 = i3 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int a3 = hi.a(obj.hashCode());
                while (true) {
                    int i4 = a3 & length2;
                    short s = sArr[i4] & 65535;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    a3 = i4 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int a4 = hi.a(obj.hashCode());
                while (true) {
                    int i5 = a4 & length3;
                    int i6 = iArr[i5];
                    if (i6 == -1) {
                        return null;
                    }
                    if (vArr[i6].equals(obj)) {
                        return vArr[i6 ^ 1];
                    }
                    a4 = i5 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final hs<Map.Entry<K, V>> zzk() {
        return new b(this, this.zzy, 0, this.size);
    }

    /* access modifiers changed from: package-private */
    public final hs<K> zzl() {
        return new d(this, new c(this.zzy, 0, this.size));
    }

    /* access modifiers changed from: package-private */
    public final hl<V> zzm() {
        return new c(this.zzy, 1, this.size);
    }
}
