package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.upi.util.UpiConstants;
import sun.misc.Unsafe;

final class cq<T> implements de<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f9246a = eb.c();

    /* renamed from: b  reason: collision with root package name */
    private final int[] f9247b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f9248c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9249d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9250e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9251f;

    /* renamed from: g  reason: collision with root package name */
    private final cm f9252g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f9253h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f9254i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int[] m;
    private final int[] n;
    private final cu o;
    private final bw p;
    private final dv<?, ?> q;
    private final as<?> r;
    private final ch s;

    private cq(int[] iArr, Object[] objArr, int i2, int i3, int i4, cm cmVar, boolean z, int[] iArr2, int[] iArr3, int[] iArr4, cu cuVar, bw bwVar, dv<?, ?> dvVar, as<?> asVar, ch chVar) {
        this.f9247b = iArr;
        this.f9248c = objArr;
        this.f9249d = i2;
        this.f9250e = i3;
        this.f9251f = i4;
        this.f9254i = cmVar instanceof bf;
        this.j = z;
        this.f9253h = asVar != null && asVar.a(cmVar);
        this.k = false;
        this.l = iArr2;
        this.m = iArr3;
        this.n = iArr4;
        this.o = cuVar;
        this.p = bwVar;
        this.q = dvVar;
        this.r = asVar;
        this.f9252g = cmVar;
        this.s = chVar;
    }

    private static int a(int i2, byte[] bArr, int i3, int i4, Object obj, x xVar) throws IOException {
        return w.a(i2, bArr, i3, i4, e(obj), xVar);
    }

    private static int a(de<?> deVar, int i2, byte[] bArr, int i3, int i4, bm<?> bmVar, x xVar) throws IOException {
        int a2 = a((de) deVar, bArr, i3, i4, xVar);
        while (true) {
            bmVar.add(xVar.f9434c);
            if (a2 >= i4) {
                break;
            }
            int a3 = w.a(bArr, a2, xVar);
            if (i2 != xVar.f9432a) {
                break;
            }
            a2 = a((de) deVar, bArr, a3, i4, xVar);
        }
        return a2;
    }

    private static int a(de deVar, byte[] bArr, int i2, int i3, int i4, x xVar) throws IOException {
        cq cqVar = (cq) deVar;
        Object a2 = cqVar.a();
        int a3 = cqVar.a(a2, bArr, i2, i3, i4, xVar);
        cqVar.c(a2);
        xVar.f9434c = a2;
        return a3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(com.google.android.gms.internal.clearcut.de r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.clearcut.x r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = com.google.android.gms.internal.clearcut.w.a((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.clearcut.x) r10)
            int r8 = r10.f9432a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.a()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.a(r1, r2, r3, r4, r5)
            r6.c(r9)
            r10.f9434c = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.clearcut.bn r6 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(com.google.android.gms.internal.clearcut.de, byte[], int, int, com.google.android.gms.internal.clearcut.x):int");
    }

    private static <UT, UB> int a(dv<UT, UB> dvVar, T t) {
        return dvVar.d(dvVar.a(t));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b7, code lost:
        r2 = r2 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013f, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014c, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0150, code lost:
        r12.putObject(r1, r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015e, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x016f, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0174, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.clearcut.x r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = f9246a
            int[] r7 = r0.f9247b
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0164;
                case 52: goto L_0x0154;
                case 53: goto L_0x0144;
                case 54: goto L_0x0144;
                case 55: goto L_0x0137;
                case 56: goto L_0x012b;
                case 57: goto L_0x0120;
                case 58: goto L_0x010a;
                case 59: goto L_0x00de;
                case 60: goto L_0x00ba;
                case 61: goto L_0x00a2;
                case 62: goto L_0x0137;
                case 63: goto L_0x0074;
                case 64: goto L_0x0120;
                case 65: goto L_0x012b;
                case 66: goto L_0x0066;
                case 67: goto L_0x0058;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x0178
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x0178
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.clearcut.de r2 = r0.a((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = a((com.google.android.gms.internal.clearcut.de) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.clearcut.x) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            java.lang.Object r3 = r11.f9434c
            if (r15 != 0) goto L_0x0052
            goto L_0x0150
        L_0x0052:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.bh.a((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x0150
        L_0x0058:
            if (r5 != 0) goto L_0x0178
            int r2 = com.google.android.gms.internal.clearcut.w.b(r3, r4, r11)
            long r3 = r11.f9433b
            long r3 = com.google.android.gms.internal.clearcut.ak.a((long) r3)
            goto L_0x014c
        L_0x0066:
            if (r5 != 0) goto L_0x0178
            int r2 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r11)
            int r3 = r11.f9432a
            int r3 = com.google.android.gms.internal.clearcut.ak.b(r3)
            goto L_0x013f
        L_0x0074:
            if (r5 != 0) goto L_0x0178
            int r3 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r11)
            int r4 = r11.f9432a
            com.google.android.gms.internal.clearcut.bj r5 = r0.b((int) r6)
            if (r5 == 0) goto L_0x0098
            com.google.android.gms.internal.clearcut.bi r5 = r5.a(r4)
            if (r5 == 0) goto L_0x0089
            goto L_0x0098
        L_0x0089:
            com.google.android.gms.internal.clearcut.dw r1 = e((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.a((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x0179
        L_0x0098:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x0174
        L_0x00a2:
            if (r5 != r15) goto L_0x0178
            int r2 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r11)
            int r4 = r11.f9432a
            if (r4 != 0) goto L_0x00b0
            com.google.android.gms.internal.clearcut.ab r3 = com.google.android.gms.internal.clearcut.ab.zzfi
            goto L_0x0150
        L_0x00b0:
            com.google.android.gms.internal.clearcut.ab r3 = com.google.android.gms.internal.clearcut.ab.zzb((byte[]) r3, (int) r2, (int) r4)
            r12.putObject(r1, r9, r3)
        L_0x00b7:
            int r2 = r2 + r4
            goto L_0x0174
        L_0x00ba:
            if (r5 != r15) goto L_0x0178
            com.google.android.gms.internal.clearcut.de r2 = r0.a((int) r6)
            r5 = r20
            int r2 = a((com.google.android.gms.internal.clearcut.de) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.clearcut.x) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00d1
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00d2
        L_0x00d1:
            r15 = 0
        L_0x00d2:
            java.lang.Object r3 = r11.f9434c
            if (r15 != 0) goto L_0x00d8
            goto L_0x0150
        L_0x00d8:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.bh.a((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x0150
        L_0x00de:
            if (r5 != r15) goto L_0x0178
            int r2 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r11)
            int r4 = r11.f9432a
            if (r4 != 0) goto L_0x00eb
            java.lang.String r3 = ""
            goto L_0x0150
        L_0x00eb:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x00ff
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.clearcut.ed.a((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x00fa
            goto L_0x00ff
        L_0x00fa:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbp()
            throw r1
        L_0x00ff:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.clearcut.bh.f9208a
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            goto L_0x00b7
        L_0x010a:
            if (r5 != 0) goto L_0x0178
            int r2 = com.google.android.gms.internal.clearcut.w.b(r3, r4, r11)
            long r3 = r11.f9433b
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x011a
            r15 = 1
            goto L_0x011b
        L_0x011a:
            r15 = 0
        L_0x011b:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            goto L_0x0150
        L_0x0120:
            if (r5 != r7) goto L_0x0178
            int r2 = com.google.android.gms.internal.clearcut.w.a(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x015e
        L_0x012b:
            r2 = 1
            if (r5 != r2) goto L_0x0178
            long r2 = com.google.android.gms.internal.clearcut.w.b(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x016f
        L_0x0137:
            if (r5 != 0) goto L_0x0178
            int r2 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r11)
            int r3 = r11.f9432a
        L_0x013f:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0150
        L_0x0144:
            if (r5 != 0) goto L_0x0178
            int r2 = com.google.android.gms.internal.clearcut.w.b(r3, r4, r11)
            long r3 = r11.f9433b
        L_0x014c:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x0150:
            r12.putObject(r1, r9, r3)
            goto L_0x0174
        L_0x0154:
            if (r5 != r7) goto L_0x0178
            float r2 = com.google.android.gms.internal.clearcut.w.d(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x015e:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x0174
        L_0x0164:
            r2 = 1
            if (r5 != r2) goto L_0x0178
            double r2 = com.google.android.gms.internal.clearcut.w.c(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
        L_0x016f:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
        L_0x0174:
            r12.putInt(r1, r13, r8)
            goto L_0x0179
        L_0x0178:
            r2 = r4
        L_0x0179:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.clearcut.x):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0232, code lost:
        if (r7.f9433b != 0) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0234, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0236, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0237, code lost:
        r11.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x023a, code lost:
        if (r4 >= r5) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x023c, code lost:
        r6 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0242, code lost:
        if (r2 != r7.f9432a) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0244, code lost:
        r4 = com.google.android.gms.internal.clearcut.w.b(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x024c, code lost:
        if (r7.f9433b == 0) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013a, code lost:
        if (r4 == 0) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013c, code lost:
        r11.add(com.google.android.gms.internal.clearcut.ab.zzfi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0142, code lost:
        r11.add(com.google.android.gms.internal.clearcut.ab.zzb(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x014a, code lost:
        if (r1 >= r5) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014c, code lost:
        r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0152, code lost:
        if (r2 != r7.f9432a) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7);
        r4 = r7.f9432a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015a, code lost:
        if (r4 != 0) goto L_0x0142;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.clearcut.x r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = f9246a
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.clearcut.bm r11 = (com.google.android.gms.internal.clearcut.bm) r11
            boolean r12 = r11.a()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.clearcut.bm r11 = r11.a(r12)
            sun.misc.Unsafe r12 = f9246a
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x035d;
                case 19: goto L_0x031f;
                case 20: goto L_0x02e7;
                case 21: goto L_0x02e7;
                case 22: goto L_0x02cd;
                case 23: goto L_0x028e;
                case 24: goto L_0x024f;
                case 25: goto L_0x01fe;
                case 26: goto L_0x0177;
                case 27: goto L_0x015d;
                case 28: goto L_0x0132;
                case 29: goto L_0x02cd;
                case 30: goto L_0x00fa;
                case 31: goto L_0x024f;
                case 32: goto L_0x028e;
                case 33: goto L_0x00ba;
                case 34: goto L_0x007a;
                case 35: goto L_0x035d;
                case 36: goto L_0x031f;
                case 37: goto L_0x02e7;
                case 38: goto L_0x02e7;
                case 39: goto L_0x02cd;
                case 40: goto L_0x028e;
                case 41: goto L_0x024f;
                case 42: goto L_0x01fe;
                case 43: goto L_0x02cd;
                case 44: goto L_0x00fa;
                case 45: goto L_0x024f;
                case 46: goto L_0x028e;
                case 47: goto L_0x00ba;
                case 48: goto L_0x007a;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x039b
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x039b
            com.google.android.gms.internal.clearcut.de r1 = r0.a((int) r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = a((com.google.android.gms.internal.clearcut.de) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.clearcut.x) r27)
        L_0x005a:
            java.lang.Object r8 = r7.f9434c
            r11.add(r8)
            if (r4 >= r5) goto L_0x039b
            int r8 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r9 = r7.f9432a
            if (r2 != r9) goto L_0x039b
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = a((com.google.android.gms.internal.clearcut.de) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.clearcut.x) r27)
            goto L_0x005a
        L_0x007a:
            if (r6 != r10) goto L_0x009e
            com.google.android.gms.internal.clearcut.ca r11 = (com.google.android.gms.internal.clearcut.ca) r11
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r2 = r7.f9432a
            int r2 = r2 + r1
        L_0x0085:
            if (r1 >= r2) goto L_0x0095
            int r1 = com.google.android.gms.internal.clearcut.w.b(r3, r1, r7)
            long r4 = r7.f9433b
            long r4 = com.google.android.gms.internal.clearcut.ak.a((long) r4)
            r11.a((long) r4)
            goto L_0x0085
        L_0x0095:
            if (r1 != r2) goto L_0x0099
            goto L_0x039c
        L_0x0099:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r1
        L_0x009e:
            if (r6 != 0) goto L_0x039b
            com.google.android.gms.internal.clearcut.ca r11 = (com.google.android.gms.internal.clearcut.ca) r11
        L_0x00a2:
            int r1 = com.google.android.gms.internal.clearcut.w.b(r3, r4, r7)
            long r8 = r7.f9433b
            long r8 = com.google.android.gms.internal.clearcut.ak.a((long) r8)
            r11.a((long) r8)
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7)
            int r6 = r7.f9432a
            if (r2 != r6) goto L_0x039c
            goto L_0x00a2
        L_0x00ba:
            if (r6 != r10) goto L_0x00de
            com.google.android.gms.internal.clearcut.bg r11 = (com.google.android.gms.internal.clearcut.bg) r11
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r2 = r7.f9432a
            int r2 = r2 + r1
        L_0x00c5:
            if (r1 >= r2) goto L_0x00d5
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7)
            int r4 = r7.f9432a
            int r4 = com.google.android.gms.internal.clearcut.ak.b(r4)
            r11.c(r4)
            goto L_0x00c5
        L_0x00d5:
            if (r1 != r2) goto L_0x00d9
            goto L_0x039c
        L_0x00d9:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r1
        L_0x00de:
            if (r6 != 0) goto L_0x039b
            com.google.android.gms.internal.clearcut.bg r11 = (com.google.android.gms.internal.clearcut.bg) r11
        L_0x00e2:
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r4 = r7.f9432a
            int r4 = com.google.android.gms.internal.clearcut.ak.b(r4)
            r11.c(r4)
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7)
            int r6 = r7.f9432a
            if (r2 != r6) goto L_0x039c
            goto L_0x00e2
        L_0x00fa:
            if (r6 != r10) goto L_0x0101
            int r2 = com.google.android.gms.internal.clearcut.w.a((byte[]) r3, (int) r4, (com.google.android.gms.internal.clearcut.bm<?>) r11, (com.google.android.gms.internal.clearcut.x) r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x039b
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.clearcut.w.a((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.clearcut.bm<?>) r6, (com.google.android.gms.internal.clearcut.x) r7)
        L_0x0112:
            com.google.android.gms.internal.clearcut.bf r1 = (com.google.android.gms.internal.clearcut.bf) r1
            com.google.android.gms.internal.clearcut.dw r3 = r1.zzjp
            com.google.android.gms.internal.clearcut.dw r4 = com.google.android.gms.internal.clearcut.dw.a()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.clearcut.bj r4 = r0.b((int) r8)
            com.google.android.gms.internal.clearcut.dv<?, ?> r5 = r0.q
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.dg.a(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.clearcut.dw r3 = (com.google.android.gms.internal.clearcut.dw) r3
            if (r3 == 0) goto L_0x012f
            r1.zzjp = r3
        L_0x012f:
            r1 = r2
            goto L_0x039c
        L_0x0132:
            if (r6 != r10) goto L_0x039b
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r4 = r7.f9432a
            if (r4 != 0) goto L_0x0142
        L_0x013c:
            com.google.android.gms.internal.clearcut.ab r4 = com.google.android.gms.internal.clearcut.ab.zzfi
            r11.add(r4)
            goto L_0x014a
        L_0x0142:
            com.google.android.gms.internal.clearcut.ab r6 = com.google.android.gms.internal.clearcut.ab.zzb((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            int r1 = r1 + r4
        L_0x014a:
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7)
            int r6 = r7.f9432a
            if (r2 != r6) goto L_0x039c
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r4 = r7.f9432a
            if (r4 != 0) goto L_0x0142
            goto L_0x013c
        L_0x015d:
            if (r6 != r10) goto L_0x039b
            com.google.android.gms.internal.clearcut.de r1 = r0.a((int) r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = a(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x039c
        L_0x0177:
            if (r6 != r10) goto L_0x039b
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            if (r6 != 0) goto L_0x01b6
            int r6 = r7.f9432a
            if (r6 != 0) goto L_0x0190
        L_0x018c:
            r11.add(r1)
            goto L_0x019b
        L_0x0190:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.clearcut.bh.f9208a
            r8.<init>(r3, r4, r6, r9)
        L_0x0197:
            r11.add(r8)
            int r4 = r4 + r6
        L_0x019b:
            if (r4 >= r5) goto L_0x039b
            int r6 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r8 = r7.f9432a
            if (r2 != r8) goto L_0x039b
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r6, r7)
            int r6 = r7.f9432a
            if (r6 != 0) goto L_0x01ae
            goto L_0x018c
        L_0x01ae:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.clearcut.bh.f9208a
            r8.<init>(r3, r4, r6, r9)
            goto L_0x0197
        L_0x01b6:
            int r6 = r7.f9432a
            if (r6 != 0) goto L_0x01be
        L_0x01ba:
            r11.add(r1)
            goto L_0x01d1
        L_0x01be:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.clearcut.ed.a((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x01f9
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.clearcut.bh.f9208a
            r9.<init>(r3, r4, r6, r10)
        L_0x01cd:
            r11.add(r9)
            r4 = r8
        L_0x01d1:
            if (r4 >= r5) goto L_0x039b
            int r6 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r8 = r7.f9432a
            if (r2 != r8) goto L_0x039b
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r6, r7)
            int r6 = r7.f9432a
            if (r6 != 0) goto L_0x01e4
            goto L_0x01ba
        L_0x01e4:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.clearcut.ed.a((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x01f4
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.clearcut.bh.f9208a
            r9.<init>(r3, r4, r6, r10)
            goto L_0x01cd
        L_0x01f4:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbp()
            throw r1
        L_0x01f9:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbp()
            throw r1
        L_0x01fe:
            r1 = 0
            if (r6 != r10) goto L_0x0226
            com.google.android.gms.internal.clearcut.y r11 = (com.google.android.gms.internal.clearcut.y) r11
            int r2 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r4 = r7.f9432a
            int r4 = r4 + r2
        L_0x020a:
            if (r2 >= r4) goto L_0x021d
            int r2 = com.google.android.gms.internal.clearcut.w.b(r3, r2, r7)
            long r5 = r7.f9433b
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0218
            r5 = 1
            goto L_0x0219
        L_0x0218:
            r5 = 0
        L_0x0219:
            r11.a((boolean) r5)
            goto L_0x020a
        L_0x021d:
            if (r2 != r4) goto L_0x0221
            goto L_0x012f
        L_0x0221:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r1
        L_0x0226:
            if (r6 != 0) goto L_0x039b
            com.google.android.gms.internal.clearcut.y r11 = (com.google.android.gms.internal.clearcut.y) r11
            int r4 = com.google.android.gms.internal.clearcut.w.b(r3, r4, r7)
            long r8 = r7.f9433b
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0236
        L_0x0234:
            r6 = 1
            goto L_0x0237
        L_0x0236:
            r6 = 0
        L_0x0237:
            r11.a((boolean) r6)
            if (r4 >= r5) goto L_0x039b
            int r6 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r8 = r7.f9432a
            if (r2 != r8) goto L_0x039b
            int r4 = com.google.android.gms.internal.clearcut.w.b(r3, r6, r7)
            long r8 = r7.f9433b
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0236
            goto L_0x0234
        L_0x024f:
            if (r6 != r10) goto L_0x026f
            com.google.android.gms.internal.clearcut.bg r11 = (com.google.android.gms.internal.clearcut.bg) r11
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r2 = r7.f9432a
            int r2 = r2 + r1
        L_0x025a:
            if (r1 >= r2) goto L_0x0266
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1)
            r11.c(r4)
            int r1 = r1 + 4
            goto L_0x025a
        L_0x0266:
            if (r1 != r2) goto L_0x026a
            goto L_0x039c
        L_0x026a:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r1
        L_0x026f:
            if (r6 != r9) goto L_0x039b
            com.google.android.gms.internal.clearcut.bg r11 = (com.google.android.gms.internal.clearcut.bg) r11
            int r1 = com.google.android.gms.internal.clearcut.w.a(r18, r19)
            r11.c(r1)
        L_0x027a:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7)
            int r6 = r7.f9432a
            if (r2 != r6) goto L_0x039c
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4)
            r11.c(r1)
            goto L_0x027a
        L_0x028e:
            if (r6 != r10) goto L_0x02ae
            com.google.android.gms.internal.clearcut.ca r11 = (com.google.android.gms.internal.clearcut.ca) r11
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r2 = r7.f9432a
            int r2 = r2 + r1
        L_0x0299:
            if (r1 >= r2) goto L_0x02a5
            long r4 = com.google.android.gms.internal.clearcut.w.b(r3, r1)
            r11.a((long) r4)
            int r1 = r1 + 8
            goto L_0x0299
        L_0x02a5:
            if (r1 != r2) goto L_0x02a9
            goto L_0x039c
        L_0x02a9:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r1
        L_0x02ae:
            if (r6 != r13) goto L_0x039b
            com.google.android.gms.internal.clearcut.ca r11 = (com.google.android.gms.internal.clearcut.ca) r11
            long r8 = com.google.android.gms.internal.clearcut.w.b(r18, r19)
            r11.a((long) r8)
        L_0x02b9:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7)
            int r6 = r7.f9432a
            if (r2 != r6) goto L_0x039c
            long r8 = com.google.android.gms.internal.clearcut.w.b(r3, r4)
            r11.a((long) r8)
            goto L_0x02b9
        L_0x02cd:
            if (r6 != r10) goto L_0x02d5
            int r1 = com.google.android.gms.internal.clearcut.w.a((byte[]) r3, (int) r4, (com.google.android.gms.internal.clearcut.bm<?>) r11, (com.google.android.gms.internal.clearcut.x) r7)
            goto L_0x039c
        L_0x02d5:
            if (r6 != 0) goto L_0x039b
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.clearcut.w.a((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.clearcut.bm<?>) r25, (com.google.android.gms.internal.clearcut.x) r26)
            goto L_0x039c
        L_0x02e7:
            if (r6 != r10) goto L_0x0307
            com.google.android.gms.internal.clearcut.ca r11 = (com.google.android.gms.internal.clearcut.ca) r11
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r2 = r7.f9432a
            int r2 = r2 + r1
        L_0x02f2:
            if (r1 >= r2) goto L_0x02fe
            int r1 = com.google.android.gms.internal.clearcut.w.b(r3, r1, r7)
            long r4 = r7.f9433b
            r11.a((long) r4)
            goto L_0x02f2
        L_0x02fe:
            if (r1 != r2) goto L_0x0302
            goto L_0x039c
        L_0x0302:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r1
        L_0x0307:
            if (r6 != 0) goto L_0x039b
            com.google.android.gms.internal.clearcut.ca r11 = (com.google.android.gms.internal.clearcut.ca) r11
        L_0x030b:
            int r1 = com.google.android.gms.internal.clearcut.w.b(r3, r4, r7)
            long r8 = r7.f9433b
            r11.a((long) r8)
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7)
            int r6 = r7.f9432a
            if (r2 != r6) goto L_0x039c
            goto L_0x030b
        L_0x031f:
            if (r6 != r10) goto L_0x033e
            com.google.android.gms.internal.clearcut.bd r11 = (com.google.android.gms.internal.clearcut.bd) r11
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r2 = r7.f9432a
            int r2 = r2 + r1
        L_0x032a:
            if (r1 >= r2) goto L_0x0336
            float r4 = com.google.android.gms.internal.clearcut.w.d(r3, r1)
            r11.a((float) r4)
            int r1 = r1 + 4
            goto L_0x032a
        L_0x0336:
            if (r1 != r2) goto L_0x0339
            goto L_0x039c
        L_0x0339:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r1
        L_0x033e:
            if (r6 != r9) goto L_0x039b
            com.google.android.gms.internal.clearcut.bd r11 = (com.google.android.gms.internal.clearcut.bd) r11
            float r1 = com.google.android.gms.internal.clearcut.w.d(r18, r19)
            r11.a((float) r1)
        L_0x0349:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7)
            int r6 = r7.f9432a
            if (r2 != r6) goto L_0x039c
            float r1 = com.google.android.gms.internal.clearcut.w.d(r3, r4)
            r11.a((float) r1)
            goto L_0x0349
        L_0x035d:
            if (r6 != r10) goto L_0x037c
            com.google.android.gms.internal.clearcut.ao r11 = (com.google.android.gms.internal.clearcut.ao) r11
            int r1 = com.google.android.gms.internal.clearcut.w.a(r3, r4, r7)
            int r2 = r7.f9432a
            int r2 = r2 + r1
        L_0x0368:
            if (r1 >= r2) goto L_0x0374
            double r4 = com.google.android.gms.internal.clearcut.w.c(r3, r1)
            r11.a((double) r4)
            int r1 = r1 + 8
            goto L_0x0368
        L_0x0374:
            if (r1 != r2) goto L_0x0377
            goto L_0x039c
        L_0x0377:
            com.google.android.gms.internal.clearcut.bn r1 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r1
        L_0x037c:
            if (r6 != r13) goto L_0x039b
            com.google.android.gms.internal.clearcut.ao r11 = (com.google.android.gms.internal.clearcut.ao) r11
            double r8 = com.google.android.gms.internal.clearcut.w.c(r18, r19)
            r11.a((double) r8)
        L_0x0387:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.w.a(r3, r1, r7)
            int r6 = r7.f9432a
            if (r2 != r6) goto L_0x039c
            double r8 = com.google.android.gms.internal.clearcut.w.c(r3, r4)
            r11.a((double) r8)
            goto L_0x0387
        L_0x039b:
            r1 = r4
        L_0x039c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.clearcut.x):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02f6, code lost:
        if (r0 == r15) goto L_0x0351;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0333, code lost:
        if (r0 == r15) goto L_0x0351;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x034f, code lost:
        if (r0 == r15) goto L_0x0351;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0351, code lost:
        r7 = r29;
        r6 = r31;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        r5 = r4;
        r29 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d4, code lost:
        r12 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0121, code lost:
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0138, code lost:
        r6 = r6 | r20;
        r13 = r30;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x013d, code lost:
        r1 = r9;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x018c, code lost:
        r10.putObject(r14, r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01c6, code lost:
        r6 = r6 | r20;
        r7 = r29;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01ed, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0256, code lost:
        r6 = r6 | r20;
        r7 = r29;
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x025c, code lost:
        r1 = r9;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x025e, code lost:
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x025f, code lost:
        r11 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0263, code lost:
        r19 = r29;
        r2 = r5;
        r20 = r6;
        r7 = r9;
        r25 = r10;
        r6 = r31;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int a(T r27, byte[] r28, int r29, int r30, int r31, com.google.android.gms.internal.clearcut.x r32) throws java.io.IOException {
        /*
            r26 = this;
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r11 = r31
            r9 = r32
            sun.misc.Unsafe r10 = f9246a
            r16 = 0
            r8 = -1
            r0 = r29
            r1 = 0
            r6 = 0
            r7 = -1
        L_0x0016:
            r17 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 >= r13) goto L_0x038e
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.clearcut.w.a((int) r0, (byte[]) r12, (int) r1, (com.google.android.gms.internal.clearcut.x) r9)
            int r1 = r9.f9432a
            r4 = r0
            r5 = r1
            goto L_0x002c
        L_0x002a:
            r5 = r0
            r4 = r1
        L_0x002c:
            int r3 = r5 >>> 3
            r2 = r5 & 7
            int r1 = r15.e((int) r3)
            if (r1 == r8) goto L_0x0357
            int[] r0 = r15.f9247b
            int r18 = r1 + 1
            r8 = r0[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r8 & r18
            int r11 = r18 >>> 20
            r29 = r5
            r5 = r8 & r17
            long r12 = (long) r5
            r5 = 17
            r18 = r8
            if (r11 > r5) goto L_0x026f
            int r5 = r1 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r8 = 1
            int r20 = r8 << r5
            r0 = r0 & r17
            r5 = -1
            if (r0 == r7) goto L_0x0067
            if (r7 == r5) goto L_0x0061
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0061:
            long r6 = (long) r0
            int r6 = r10.getInt(r14, r6)
            r7 = r0
        L_0x0067:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x0240;
                case 1: goto L_0x022a;
                case 2: goto L_0x0206;
                case 3: goto L_0x0206;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01cd;
                case 6: goto L_0x01b0;
                case 7: goto L_0x0190;
                case 8: goto L_0x016d;
                case 9: goto L_0x0141;
                case 10: goto L_0x0124;
                case 11: goto L_0x01f0;
                case 12: goto L_0x00ef;
                case 13: goto L_0x01b0;
                case 14: goto L_0x01cd;
                case 15: goto L_0x00d7;
                case 16: goto L_0x00b1;
                case 17: goto L_0x0076;
                default: goto L_0x006b;
            }
        L_0x006b:
            r12 = r28
            r9 = r29
            r11 = r32
        L_0x0071:
            r5 = r4
            r29 = r7
            goto L_0x0263
        L_0x0076:
            r0 = 3
            if (r2 != r0) goto L_0x00ac
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.clearcut.de r0 = r15.a((int) r1)
            r1 = r28
            r2 = r4
            r3 = r30
            r4 = r8
            r9 = r29
            r8 = -1
            r5 = r32
            int r0 = a((com.google.android.gms.internal.clearcut.de) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.clearcut.x) r5)
            r1 = r6 & r20
            r11 = r32
            if (r1 != 0) goto L_0x0099
            java.lang.Object r1 = r11.f9434c
            goto L_0x00a3
        L_0x0099:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r11.f9434c
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.bh.a((java.lang.Object) r1, (java.lang.Object) r2)
        L_0x00a3:
            r10.putObject(r14, r12, r1)
            r6 = r6 | r20
            r12 = r28
            goto L_0x0121
        L_0x00ac:
            r9 = r29
            r11 = r32
            goto L_0x00d4
        L_0x00b1:
            r9 = r29
            r11 = r32
            r8 = -1
            if (r2 != 0) goto L_0x00d4
            r2 = r12
            r12 = r28
            int r13 = com.google.android.gms.internal.clearcut.w.b(r12, r4, r11)
            long r0 = r11.f9433b
            long r4 = com.google.android.gms.internal.clearcut.ak.a((long) r0)
            r0 = r10
            r1 = r27
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            r1 = r9
            r9 = r11
            r0 = r13
            r13 = r30
            goto L_0x025f
        L_0x00d4:
            r12 = r28
            goto L_0x0071
        L_0x00d7:
            r9 = r29
            r11 = r32
            r0 = r12
            r8 = -1
            r12 = r28
            if (r2 != 0) goto L_0x0071
            int r2 = com.google.android.gms.internal.clearcut.w.a(r12, r4, r11)
            int r3 = r11.f9432a
            int r3 = com.google.android.gms.internal.clearcut.ak.b(r3)
            r10.putInt(r14, r0, r3)
            goto L_0x0138
        L_0x00ef:
            r9 = r29
            r11 = r32
            r21 = r12
            r8 = -1
            r12 = r28
            if (r2 != 0) goto L_0x0071
            int r0 = com.google.android.gms.internal.clearcut.w.a(r12, r4, r11)
            int r2 = r11.f9432a
            com.google.android.gms.internal.clearcut.bj r1 = r15.b((int) r1)
            if (r1 == 0) goto L_0x011a
            com.google.android.gms.internal.clearcut.bi r1 = r1.a(r2)
            if (r1 == 0) goto L_0x010d
            goto L_0x011a
        L_0x010d:
            com.google.android.gms.internal.clearcut.dw r1 = e((java.lang.Object) r27)
            long r2 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.a((int) r9, (java.lang.Object) r2)
            goto L_0x0121
        L_0x011a:
            r3 = r21
            r10.putInt(r14, r3, r2)
            r6 = r6 | r20
        L_0x0121:
            r13 = r30
            goto L_0x013d
        L_0x0124:
            r9 = r29
            r11 = r32
            r0 = r12
            r3 = 2
            r8 = -1
            r12 = r28
            if (r2 != r3) goto L_0x0071
            int r2 = com.google.android.gms.internal.clearcut.w.e(r12, r4, r11)
            java.lang.Object r3 = r11.f9434c
            r10.putObject(r14, r0, r3)
        L_0x0138:
            r6 = r6 | r20
            r13 = r30
            r0 = r2
        L_0x013d:
            r1 = r9
            r9 = r11
            goto L_0x025f
        L_0x0141:
            r9 = r29
            r11 = r32
            r29 = r7
            r7 = r12
            r3 = 2
            r12 = r28
            if (r2 != r3) goto L_0x0169
            com.google.android.gms.internal.clearcut.de r0 = r15.a((int) r1)
            r5 = r30
            int r0 = a((com.google.android.gms.internal.clearcut.de) r0, (byte[]) r12, (int) r4, (int) r5, (com.google.android.gms.internal.clearcut.x) r11)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x015e
            java.lang.Object r1 = r11.f9434c
            goto L_0x018c
        L_0x015e:
            java.lang.Object r1 = r10.getObject(r14, r7)
            java.lang.Object r2 = r11.f9434c
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.bh.a((java.lang.Object) r1, (java.lang.Object) r2)
            goto L_0x018c
        L_0x0169:
            r5 = r30
            goto L_0x01ed
        L_0x016d:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r0 = 2
            r12 = r28
            if (r2 != r0) goto L_0x01ed
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r18 & r0
            if (r0 != 0) goto L_0x0186
            int r0 = com.google.android.gms.internal.clearcut.w.c(r12, r4, r11)
            goto L_0x018a
        L_0x0186:
            int r0 = com.google.android.gms.internal.clearcut.w.d(r12, r4, r11)
        L_0x018a:
            java.lang.Object r1 = r11.f9434c
        L_0x018c:
            r10.putObject(r14, r7, r1)
            goto L_0x01c6
        L_0x0190:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != 0) goto L_0x01ed
            int r0 = com.google.android.gms.internal.clearcut.w.b(r12, r4, r11)
            long r1 = r11.f9433b
            r3 = 0
            int r17 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r17 == 0) goto L_0x01ab
            r1 = 1
            goto L_0x01ac
        L_0x01ab:
            r1 = 0
        L_0x01ac:
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r7, (boolean) r1)
            goto L_0x01c6
        L_0x01b0:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != r0) goto L_0x01ed
            int r0 = com.google.android.gms.internal.clearcut.w.a(r12, r4)
            r10.putInt(r14, r7, r0)
            int r0 = r4 + 4
        L_0x01c6:
            r6 = r6 | r20
            r7 = r29
            r13 = r5
            goto L_0x025c
        L_0x01cd:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r0 = 1
            r12 = r28
            if (r2 != r0) goto L_0x01ed
            long r17 = com.google.android.gms.internal.clearcut.w.b(r12, r4)
            r0 = r10
            r1 = r27
            r2 = r7
            r7 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x0256
        L_0x01ed:
            r5 = r4
            goto L_0x0263
        L_0x01f0:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != 0) goto L_0x0263
            int r0 = com.google.android.gms.internal.clearcut.w.a(r12, r5, r11)
            int r1 = r11.f9432a
            r10.putInt(r14, r7, r1)
            goto L_0x0256
        L_0x0206:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != 0) goto L_0x0263
            int r17 = com.google.android.gms.internal.clearcut.w.b(r12, r5, r11)
            long r4 = r11.f9433b
            r0 = r10
            r1 = r27
            r2 = r7
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            r7 = r29
            r13 = r30
            r1 = r9
            r9 = r11
            r0 = r17
            goto L_0x025e
        L_0x022a:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != r0) goto L_0x0263
            float r0 = com.google.android.gms.internal.clearcut.w.d(r12, r5)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r7, (float) r0)
            int r0 = r5 + 4
            goto L_0x0256
        L_0x0240:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r0 = 1
            r12 = r28
            if (r2 != r0) goto L_0x0263
            double r0 = com.google.android.gms.internal.clearcut.w.c(r12, r5)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r7, (double) r0)
            int r0 = r5 + 8
        L_0x0256:
            r6 = r6 | r20
            r7 = r29
            r13 = r30
        L_0x025c:
            r1 = r9
            r9 = r11
        L_0x025e:
            r8 = -1
        L_0x025f:
            r11 = r31
            goto L_0x0016
        L_0x0263:
            r19 = r29
            r2 = r5
            r20 = r6
            r7 = r9
            r25 = r10
            r6 = r31
            goto L_0x0365
        L_0x026f:
            r9 = r29
            r5 = r4
            r19 = r7
            r7 = r12
            r12 = r28
            r0 = 27
            if (r11 != r0) goto L_0x02c4
            r0 = 2
            if (r2 != r0) goto L_0x02bd
            java.lang.Object r0 = r10.getObject(r14, r7)
            com.google.android.gms.internal.clearcut.bm r0 = (com.google.android.gms.internal.clearcut.bm) r0
            boolean r2 = r0.a()
            if (r2 != 0) goto L_0x029c
            int r2 = r0.size()
            if (r2 != 0) goto L_0x0293
            r2 = 10
            goto L_0x0295
        L_0x0293:
            int r2 = r2 << 1
        L_0x0295:
            com.google.android.gms.internal.clearcut.bm r0 = r0.a(r2)
            r10.putObject(r14, r7, r0)
        L_0x029c:
            r7 = r0
            com.google.android.gms.internal.clearcut.de r0 = r15.a((int) r1)
            r1 = r9
            r2 = r28
            r3 = r5
            r4 = r30
            r5 = r7
            r20 = r6
            r6 = r32
            int r0 = a(r0, r1, r2, r3, r4, r5, r6)
            r13 = r30
            r11 = r31
            r7 = r19
            r6 = r20
            r8 = -1
            r9 = r32
            goto L_0x0016
        L_0x02bd:
            r20 = r6
            r15 = r5
            r29 = r9
            goto L_0x035e
        L_0x02c4:
            r20 = r6
            r0 = 49
            if (r11 > r0) goto L_0x030a
            r6 = r18
            long r13 = (long) r6
            r0 = r26
            r18 = r1
            r1 = r27
            r6 = r2
            r2 = r28
            r21 = r3
            r3 = r5
            r4 = r30
            r15 = r5
            r5 = r9
            r22 = r6
            r6 = r21
            r23 = r7
            r7 = r22
            r8 = r18
            r29 = r9
            r25 = r10
            r9 = r13
            r14 = r31
            r12 = r23
            r14 = r32
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.clearcut.x) r14)
            if (r0 != r15) goto L_0x02fa
            goto L_0x0351
        L_0x02fa:
            r15 = r26
            r14 = r27
            r12 = r28
            r1 = r29
            r13 = r30
            r11 = r31
            r9 = r32
            goto L_0x0385
        L_0x030a:
            r22 = r2
            r21 = r3
            r15 = r5
            r23 = r7
            r29 = r9
            r25 = r10
            r6 = r18
            r18 = r1
            r0 = 50
            r7 = r22
            if (r11 != r0) goto L_0x0336
            r0 = 2
            if (r7 != r0) goto L_0x0360
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r23
            r7 = r32
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (long) r5, (com.google.android.gms.internal.clearcut.x) r7)
            if (r0 != r15) goto L_0x02fa
            goto L_0x0351
        L_0x0336:
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r29
            r8 = r6
            r6 = r21
            r9 = r11
            r10 = r23
            r12 = r18
            r13 = r32
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.clearcut.x) r13)
            if (r0 != r15) goto L_0x02fa
        L_0x0351:
            r7 = r29
            r6 = r31
            r2 = r0
            goto L_0x0365
        L_0x0357:
            r15 = r4
            r29 = r5
            r20 = r6
            r19 = r7
        L_0x035e:
            r25 = r10
        L_0x0360:
            r7 = r29
            r6 = r31
            r2 = r15
        L_0x0365:
            if (r7 != r6) goto L_0x036c
            if (r6 != 0) goto L_0x036a
            goto L_0x036c
        L_0x036a:
            r8 = r2
            goto L_0x0397
        L_0x036c:
            r0 = r7
            r1 = r28
            r3 = r30
            r4 = r27
            r5 = r32
            int r0 = a((int) r0, (byte[]) r1, (int) r2, (int) r3, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.x) r5)
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r9 = r32
            r11 = r6
            r1 = r7
        L_0x0385:
            r7 = r19
            r6 = r20
            r10 = r25
            r8 = -1
            goto L_0x0016
        L_0x038e:
            r20 = r6
            r19 = r7
            r25 = r10
            r6 = r11
            r8 = r0
            r7 = r1
        L_0x0397:
            r0 = r19
            r1 = r20
            r2 = -1
            if (r0 == r2) goto L_0x03a7
            long r2 = (long) r0
            r9 = r27
            r0 = r25
            r0.putInt(r9, r2, r1)
            goto L_0x03a9
        L_0x03a7:
            r9 = r27
        L_0x03a9:
            r10 = r26
            int[] r11 = r10.m
            if (r11 == 0) goto L_0x03ea
            r0 = 0
            int r12 = r11.length
            r4 = r0
            r13 = 0
        L_0x03b3:
            if (r13 >= r12) goto L_0x03e3
            r0 = r11[r13]
            com.google.android.gms.internal.clearcut.dv<?, ?> r5 = r10.q
            int[] r1 = r10.f9247b
            r1 = r1[r0]
            int r2 = r10.c((int) r0)
            r2 = r2 & r17
            long r2 = (long) r2
            java.lang.Object r2 = com.google.android.gms.internal.clearcut.eb.f(r9, r2)
            if (r2 != 0) goto L_0x03cb
            goto L_0x03de
        L_0x03cb:
            com.google.android.gms.internal.clearcut.bj r3 = r10.b((int) r0)
            if (r3 != 0) goto L_0x03d2
            goto L_0x03de
        L_0x03d2:
            com.google.android.gms.internal.clearcut.ch r0 = r10.s
            java.util.Map r2 = r0.a(r2)
            r0 = r26
            java.lang.Object r4 = r0.a((int) r1, r2, (com.google.android.gms.internal.clearcut.bj<?>) r3, r4, r5)
        L_0x03de:
            com.google.android.gms.internal.clearcut.dw r4 = (com.google.android.gms.internal.clearcut.dw) r4
            int r13 = r13 + 1
            goto L_0x03b3
        L_0x03e3:
            if (r4 == 0) goto L_0x03ea
            com.google.android.gms.internal.clearcut.dv<?, ?> r0 = r10.q
            r0.b((java.lang.Object) r9, r4)
        L_0x03ea:
            r0 = r30
            if (r6 != 0) goto L_0x03f6
            if (r8 != r0) goto L_0x03f1
            goto L_0x03fa
        L_0x03f1:
            com.google.android.gms.internal.clearcut.bn r0 = com.google.android.gms.internal.clearcut.bn.zzbo()
            throw r0
        L_0x03f6:
            if (r8 > r0) goto L_0x03fb
            if (r7 != r6) goto L_0x03fb
        L_0x03fa:
            return r8
        L_0x03fb:
            com.google.android.gms.internal.clearcut.bn r0 = com.google.android.gms.internal.clearcut.bn.zzbo()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.x):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int a(T r9, byte[] r10, int r11, int r12, long r13, com.google.android.gms.internal.clearcut.x r15) throws java.io.IOException {
        /*
            r8 = this;
            sun.misc.Unsafe r0 = f9246a
            java.lang.Object r1 = r0.getObject(r9, r13)
            com.google.android.gms.internal.clearcut.ch r2 = r8.s
            boolean r2 = r2.c(r1)
            if (r2 == 0) goto L_0x001d
            com.google.android.gms.internal.clearcut.ch r2 = r8.s
            java.lang.Object r2 = r2.a()
            com.google.android.gms.internal.clearcut.ch r3 = r8.s
            r3.a(r2, r1)
            r0.putObject(r9, r13, r2)
            r1 = r2
        L_0x001d:
            com.google.android.gms.internal.clearcut.ch r9 = r8.s
            com.google.android.gms.internal.clearcut.cf r9 = r9.b()
            com.google.android.gms.internal.clearcut.ch r13 = r8.s
            java.util.Map r13 = r13.a(r1)
            int r11 = com.google.android.gms.internal.clearcut.w.a(r10, r11, r15)
            int r14 = r15.f9432a
            if (r14 < 0) goto L_0x0093
            int r0 = r12 - r11
            if (r14 > r0) goto L_0x0093
            int r14 = r14 + r11
            K r0 = r9.f9241b
            V r1 = r9.f9243d
        L_0x003a:
            if (r11 >= r14) goto L_0x0088
            int r2 = r11 + 1
            byte r11 = r10[r11]
            if (r11 >= 0) goto L_0x0048
            int r2 = com.google.android.gms.internal.clearcut.w.a((int) r11, (byte[]) r10, (int) r2, (com.google.android.gms.internal.clearcut.x) r15)
            int r11 = r15.f9432a
        L_0x0048:
            r3 = r2
            int r2 = r11 >>> 3
            r4 = r11 & 7
            r5 = 1
            if (r2 == r5) goto L_0x006e
            r5 = 2
            if (r2 == r5) goto L_0x0054
            goto L_0x0083
        L_0x0054:
            com.google.android.gms.internal.clearcut.ej r2 = r9.f9242c
            int r2 = r2.zzel()
            if (r4 != r2) goto L_0x0083
            com.google.android.gms.internal.clearcut.ej r5 = r9.f9242c
            V r11 = r9.f9243d
            java.lang.Class r6 = r11.getClass()
            r2 = r10
            r4 = r12
            r7 = r15
            int r11 = a((byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.clearcut.ej) r5, (java.lang.Class<?>) r6, (com.google.android.gms.internal.clearcut.x) r7)
            java.lang.Object r1 = r15.f9434c
            goto L_0x003a
        L_0x006e:
            com.google.android.gms.internal.clearcut.ej r2 = r9.f9240a
            int r2 = r2.zzel()
            if (r4 != r2) goto L_0x0083
            com.google.android.gms.internal.clearcut.ej r5 = r9.f9240a
            r6 = 0
            r2 = r10
            r4 = r12
            r7 = r15
            int r11 = a((byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.clearcut.ej) r5, (java.lang.Class<?>) r6, (com.google.android.gms.internal.clearcut.x) r7)
            java.lang.Object r0 = r15.f9434c
            goto L_0x003a
        L_0x0083:
            int r11 = com.google.android.gms.internal.clearcut.w.a(r11, r10, r3, r12, r15)
            goto L_0x003a
        L_0x0088:
            if (r11 != r14) goto L_0x008e
            r13.put(r0, r1)
            return r14
        L_0x008e:
            com.google.android.gms.internal.clearcut.bn r9 = com.google.android.gms.internal.clearcut.bn.zzbo()
            throw r9
        L_0x0093:
            com.google.android.gms.internal.clearcut.bn r9 = com.google.android.gms.internal.clearcut.bn.zzbl()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(java.lang.Object, byte[], int, int, long, com.google.android.gms.internal.clearcut.x):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        r2 = java.lang.Integer.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        r6.f9434c = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006f, code lost:
        r6.f9434c = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007c, code lost:
        r6.f9434c = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0043, code lost:
        r2 = java.lang.Long.valueOf(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(byte[] r1, int r2, int r3, com.google.android.gms.internal.clearcut.ej r4, java.lang.Class<?> r5, com.google.android.gms.internal.clearcut.x r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.clearcut.cr.f9255a
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0086;
                case 2: goto L_0x0081;
                case 3: goto L_0x0074;
                case 4: goto L_0x0067;
                case 5: goto L_0x0067;
                case 6: goto L_0x005e;
                case 7: goto L_0x005e;
                case 8: goto L_0x0055;
                case 9: goto L_0x0048;
                case 10: goto L_0x0048;
                case 11: goto L_0x0048;
                case 12: goto L_0x003d;
                case 13: goto L_0x003d;
                case 14: goto L_0x0030;
                case 15: goto L_0x0025;
                case 16: goto L_0x001a;
                case 17: goto L_0x0014;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0014:
            int r1 = com.google.android.gms.internal.clearcut.w.d(r1, r2, r6)
            goto L_0x009a
        L_0x001a:
            int r1 = com.google.android.gms.internal.clearcut.w.b(r1, r2, r6)
            long r2 = r6.f9433b
            long r2 = com.google.android.gms.internal.clearcut.ak.a((long) r2)
            goto L_0x0043
        L_0x0025:
            int r1 = com.google.android.gms.internal.clearcut.w.a(r1, r2, r6)
            int r2 = r6.f9432a
            int r2 = com.google.android.gms.internal.clearcut.ak.b(r2)
            goto L_0x004e
        L_0x0030:
            com.google.android.gms.internal.clearcut.cz r4 = com.google.android.gms.internal.clearcut.cz.a()
            com.google.android.gms.internal.clearcut.de r4 = r4.a(r5)
            int r1 = a((com.google.android.gms.internal.clearcut.de) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.clearcut.x) r6)
            goto L_0x009a
        L_0x003d:
            int r1 = com.google.android.gms.internal.clearcut.w.b(r1, r2, r6)
            long r2 = r6.f9433b
        L_0x0043:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0052
        L_0x0048:
            int r1 = com.google.android.gms.internal.clearcut.w.a(r1, r2, r6)
            int r2 = r6.f9432a
        L_0x004e:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0052:
            r6.f9434c = r2
            goto L_0x009a
        L_0x0055:
            float r1 = com.google.android.gms.internal.clearcut.w.d(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x006f
        L_0x005e:
            long r3 = com.google.android.gms.internal.clearcut.w.b(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            goto L_0x007c
        L_0x0067:
            int r1 = com.google.android.gms.internal.clearcut.w.a(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x006f:
            r6.f9434c = r1
            int r1 = r2 + 4
            goto L_0x009a
        L_0x0074:
            double r3 = com.google.android.gms.internal.clearcut.w.c(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
        L_0x007c:
            r6.f9434c = r1
            int r1 = r2 + 8
            goto L_0x009a
        L_0x0081:
            int r1 = com.google.android.gms.internal.clearcut.w.e(r1, r2, r6)
            goto L_0x009a
        L_0x0086:
            int r1 = com.google.android.gms.internal.clearcut.w.b(r1, r2, r6)
            long r2 = r6.f9433b
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0094
            r2 = 1
            goto L_0x0095
        L_0x0094:
            r2 = 0
        L_0x0095:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0052
        L_0x009a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(byte[], int, int, com.google.android.gms.internal.clearcut.ej, java.lang.Class, com.google.android.gms.internal.clearcut.x):int");
    }

    private final de a(int i2) {
        int i3 = (i2 / 4) << 1;
        de deVar = (de) this.f9248c[i3];
        if (deVar != null) {
            return deVar;
        }
        de a2 = cz.a().a((Class) this.f9248c[i3 + 1]);
        this.f9248c[i3] = a2;
        return a2;
    }

    private static <E> List<E> a(Object obj, long j2) {
        return (List) eb.f(obj, j2);
    }

    private static void a(int i2, Object obj, ep epVar) throws IOException {
        if (obj instanceof String) {
            epVar.a(i2, (String) obj);
        } else {
            epVar.a(i2, (ab) obj);
        }
    }

    private static <UT, UB> void a(dv<UT, UB> dvVar, T t, ep epVar) throws IOException {
        dvVar.a(dvVar.a(t), epVar);
    }

    private final <K, V> void a(ep epVar, int i2, Object obj) throws IOException {
        if (obj != null) {
            epVar.a(i2, this.s.b(), this.s.b(obj));
        }
    }

    private final void a(T t, T t2, int i2) {
        long c2 = (long) (c(i2) & 1048575);
        if (a(t2, i2)) {
            Object f2 = eb.f(t, c2);
            Object f3 = eb.f(t2, c2);
            if (f2 != null && f3 != null) {
                eb.a((Object) t, c2, bh.a(f2, f3));
                b(t, i2);
            } else if (f3 != null) {
                eb.a((Object) t, c2, f3);
                b(t, i2);
            }
        }
    }

    private final boolean a(T t, int i2) {
        if (this.j) {
            int c2 = c(i2);
            long j2 = (long) (c2 & 1048575);
            switch ((c2 & 267386880) >>> 20) {
                case 0:
                    return eb.e(t, j2) != 0.0d;
                case 1:
                    return eb.d(t, j2) != 0.0f;
                case 2:
                    return eb.b(t, j2) != 0;
                case 3:
                    return eb.b(t, j2) != 0;
                case 4:
                    return eb.a((Object) t, j2) != 0;
                case 5:
                    return eb.b(t, j2) != 0;
                case 6:
                    return eb.a((Object) t, j2) != 0;
                case 7:
                    return eb.c(t, j2);
                case 8:
                    Object f2 = eb.f(t, j2);
                    if (f2 instanceof String) {
                        return !((String) f2).isEmpty();
                    }
                    if (f2 instanceof ab) {
                        return !ab.zzfi.equals(f2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return eb.f(t, j2) != null;
                case 10:
                    return !ab.zzfi.equals(eb.f(t, j2));
                case 11:
                    return eb.a((Object) t, j2) != 0;
                case 12:
                    return eb.a((Object) t, j2) != 0;
                case 13:
                    return eb.a((Object) t, j2) != 0;
                case 14:
                    return eb.b(t, j2) != 0;
                case 15:
                    return eb.a((Object) t, j2) != 0;
                case 16:
                    return eb.b(t, j2) != 0;
                case 17:
                    return eb.f(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int d2 = d(i2);
            return (eb.a((Object) t, (long) (d2 & 1048575)) & (1 << (d2 >>> 20))) != 0;
        }
    }

    private final boolean a(T t, int i2, int i3) {
        return eb.a((Object) t, (long) (d(i3) & 1048575)) == i2;
    }

    private final boolean a(T t, int i2, int i3, int i4) {
        return this.j ? a(t, i2) : (i3 & i4) != 0;
    }

    private static boolean a(Object obj, int i2, de deVar) {
        return deVar.d(eb.f(obj, (long) (i2 & 1048575)));
    }

    private static <T> double b(T t, long j2) {
        return ((Double) eb.f(t, j2)).doubleValue();
    }

    private final bj<?> b(int i2) {
        return (bj) this.f9248c[((i2 / 4) << 1) + 1];
    }

    private final void b(T t, int i2) {
        if (!this.j) {
            int d2 = d(i2);
            long j2 = (long) (d2 & 1048575);
            eb.a((Object) t, j2, eb.a((Object) t, j2) | (1 << (d2 >>> 20)));
        }
    }

    private final void b(T t, int i2, int i3) {
        eb.a((Object) t, (long) (d(i3) & 1048575), i2);
    }

    private final void b(T t, T t2, int i2) {
        int c2 = c(i2);
        int i3 = this.f9247b[i2];
        long j2 = (long) (c2 & 1048575);
        if (a(t2, i3, i2)) {
            Object f2 = eb.f(t, j2);
            Object f3 = eb.f(t2, j2);
            if (f2 != null && f3 != null) {
                eb.a((Object) t, j2, bh.a(f2, f3));
                b(t, i3, i2);
            } else if (f3 != null) {
                eb.a((Object) t, j2, f3);
                b(t, i3, i2);
            }
        }
    }

    private static <T> float c(T t, long j2) {
        return ((Float) eb.f(t, j2)).floatValue();
    }

    private final int c(int i2) {
        return this.f9247b[i2 + 1];
    }

    private final boolean c(T t, T t2, int i2) {
        return a(t, i2) == a(t2, i2);
    }

    private final int d(int i2) {
        return this.f9247b[i2 + 2];
    }

    private static <T> int d(T t, long j2) {
        return ((Integer) eb.f(t, j2)).intValue();
    }

    private final int e(int i2) {
        int i3 = this.f9249d;
        if (i2 >= i3) {
            int i4 = this.f9251f;
            if (i2 < i4) {
                int i5 = (i2 - i3) << 2;
                if (this.f9247b[i5] == i2) {
                    return i5;
                }
                return -1;
            } else if (i2 <= this.f9250e) {
                int i6 = i4 - i3;
                int length = (this.f9247b.length / 4) - 1;
                while (i6 <= length) {
                    int i7 = (length + i6) >>> 1;
                    int i8 = i7 << 2;
                    int i9 = this.f9247b[i8];
                    if (i2 == i9) {
                        return i8;
                    }
                    if (i2 < i9) {
                        length = i7 - 1;
                    } else {
                        i6 = i7 + 1;
                    }
                }
            }
        }
        return -1;
    }

    private static <T> long e(T t, long j2) {
        return ((Long) eb.f(t, j2)).longValue();
    }

    private static dw e(Object obj) {
        bf bfVar = (bf) obj;
        dw dwVar = bfVar.zzjp;
        if (dwVar != dw.a()) {
            return dwVar;
        }
        dw b2 = dw.b();
        bfVar.zzjp = b2;
        return b2;
    }

    private static <T> boolean f(T t, long j2) {
        return ((Boolean) eb.f(t, j2)).booleanValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r3 = com.google.android.gms.internal.clearcut.eb.f(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
        r2 = r2 * 53;
        r3 = d(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        r2 = r2 * 53;
        r3 = e(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.clearcut.eb.f(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d7, code lost:
        r3 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ea, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) com.google.android.gms.internal.clearcut.eb.f(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fd, code lost:
        r3 = com.google.android.gms.internal.clearcut.bh.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0116, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0121, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0125, code lost:
        r3 = com.google.android.gms.internal.clearcut.bh.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0129, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012a, code lost:
        r1 = r1 + 4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f9247b
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x012e
            int r3 = r8.c((int) r1)
            int[] r4 = r8.f9247b
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x011b;
                case 1: goto L_0x0110;
                case 2: goto L_0x0109;
                case 3: goto L_0x0109;
                case 4: goto L_0x0102;
                case 5: goto L_0x0109;
                case 6: goto L_0x0102;
                case 7: goto L_0x00f7;
                case 8: goto L_0x00ea;
                case 9: goto L_0x00dc;
                case 10: goto L_0x00d1;
                case 11: goto L_0x0102;
                case 12: goto L_0x0102;
                case 13: goto L_0x0102;
                case 14: goto L_0x0109;
                case 15: goto L_0x0102;
                case 16: goto L_0x0109;
                case 17: goto L_0x00ca;
                case 18: goto L_0x00d1;
                case 19: goto L_0x00d1;
                case 20: goto L_0x00d1;
                case 21: goto L_0x00d1;
                case 22: goto L_0x00d1;
                case 23: goto L_0x00d1;
                case 24: goto L_0x00d1;
                case 25: goto L_0x00d1;
                case 26: goto L_0x00d1;
                case 27: goto L_0x00d1;
                case 28: goto L_0x00d1;
                case 29: goto L_0x00d1;
                case 30: goto L_0x00d1;
                case 31: goto L_0x00d1;
                case 32: goto L_0x00d1;
                case 33: goto L_0x00d1;
                case 34: goto L_0x00d1;
                case 35: goto L_0x00d1;
                case 36: goto L_0x00d1;
                case 37: goto L_0x00d1;
                case 38: goto L_0x00d1;
                case 39: goto L_0x00d1;
                case 40: goto L_0x00d1;
                case 41: goto L_0x00d1;
                case 42: goto L_0x00d1;
                case 43: goto L_0x00d1;
                case 44: goto L_0x00d1;
                case 45: goto L_0x00d1;
                case 46: goto L_0x00d1;
                case 47: goto L_0x00d1;
                case 48: goto L_0x00d1;
                case 49: goto L_0x00d1;
                case 50: goto L_0x00d1;
                case 51: goto L_0x00bd;
                case 52: goto L_0x00b0;
                case 53: goto L_0x00a2;
                case 54: goto L_0x009b;
                case 55: goto L_0x008d;
                case 56: goto L_0x0086;
                case 57: goto L_0x007f;
                case 58: goto L_0x0071;
                case 59: goto L_0x0069;
                case 60: goto L_0x005b;
                case 61: goto L_0x0053;
                case 62: goto L_0x004c;
                case 63: goto L_0x0045;
                case 64: goto L_0x003e;
                case 65: goto L_0x0036;
                case 66: goto L_0x002f;
                case 67: goto L_0x0027;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x012a
        L_0x0020:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0061
        L_0x0027:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x002f:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x004b
        L_0x0036:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x003e:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x004b
        L_0x0045:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x004b:
            goto L_0x0093
        L_0x004c:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0093
        L_0x0053:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00d1
        L_0x005b:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x0061:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.eb.f(r9, r5)
            int r2 = r2 * 53
            goto L_0x00d7
        L_0x0069:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00ea
        L_0x0071:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            boolean r3 = f(r9, r5)
            goto L_0x00fd
        L_0x007f:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0093
        L_0x0086:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x008d:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x0093:
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0129
        L_0x009b:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x00a2:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x00a8:
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            goto L_0x0125
        L_0x00b0:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            float r3 = c(r9, r5)
            goto L_0x0116
        L_0x00bd:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            double r3 = b(r9, (long) r5)
            goto L_0x0121
        L_0x00ca:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.eb.f(r9, r5)
            if (r3 == 0) goto L_0x00e6
            goto L_0x00e2
        L_0x00d1:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.eb.f(r9, r5)
        L_0x00d7:
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00dc:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.eb.f(r9, r5)
            if (r3 == 0) goto L_0x00e6
        L_0x00e2:
            int r7 = r3.hashCode()
        L_0x00e6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x012a
        L_0x00ea:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.eb.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00f7:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.clearcut.eb.c(r9, r5)
        L_0x00fd:
            int r3 = com.google.android.gms.internal.clearcut.bh.a((boolean) r3)
            goto L_0x0129
        L_0x0102:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r9, (long) r5)
            goto L_0x0129
        L_0x0109:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.clearcut.eb.b(r9, r5)
            goto L_0x0125
        L_0x0110:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.clearcut.eb.d(r9, r5)
        L_0x0116:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0129
        L_0x011b:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.clearcut.eb.e(r9, r5)
        L_0x0121:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x0125:
            int r3 = com.google.android.gms.internal.clearcut.bh.a((long) r3)
        L_0x0129:
            int r2 = r2 + r3
        L_0x012a:
            int r1 = r1 + 4
            goto L_0x0005
        L_0x012e:
            int r2 = r2 * 53
            com.google.android.gms.internal.clearcut.dv<?, ?> r0 = r8.q
            java.lang.Object r0 = r0.a(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f9253h
            if (r0 == 0) goto L_0x014c
            int r2 = r2 * 53
            com.google.android.gms.internal.clearcut.as<?> r0 = r8.r
            com.google.android.gms.internal.clearcut.aw r9 = r0.a((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x014c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(java.lang.Object):int");
    }

    public final T a() {
        return this.o.a(this.f9252g);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (r7 == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r1 = r11.f9434c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        r9.putObject(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ce, code lost:
        if (r7 == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d0, code lost:
        r0 = com.google.android.gms.internal.clearcut.w.a(r12, r10, r11);
        r1 = r11.f9432a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d6, code lost:
        r9.putInt(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e3, code lost:
        r9.putLong(r23, r2, r4);
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f5, code lost:
        r0 = r10 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0102, code lost:
        r0 = r10 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0164, code lost:
        if (r0 == r15) goto L_0x01a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0187, code lost:
        if (r0 == r15) goto L_0x01a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a0, code lost:
        if (r0 == r15) goto L_0x01a2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r23, byte[] r24, int r25, int r26, com.google.android.gms.internal.clearcut.x r27) throws java.io.IOException {
        /*
            r22 = this;
            r15 = r22
            r14 = r23
            r12 = r24
            r13 = r26
            r11 = r27
            boolean r0 = r15.j
            if (r0 == 0) goto L_0x01cd
            sun.misc.Unsafe r9 = f9246a
            r0 = r25
        L_0x0012:
            if (r0 >= r13) goto L_0x01c4
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0024
            int r0 = com.google.android.gms.internal.clearcut.w.a((int) r0, (byte[]) r12, (int) r1, (com.google.android.gms.internal.clearcut.x) r11)
            int r1 = r11.f9432a
            r10 = r0
            r16 = r1
            goto L_0x0027
        L_0x0024:
            r16 = r0
            r10 = r1
        L_0x0027:
            int r6 = r16 >>> 3
            r7 = r16 & 7
            int r8 = r15.e((int) r6)
            if (r8 < 0) goto L_0x01a4
            int[] r0 = r15.f9247b
            int r1 = r8 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r4 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r2 = (long) r0
            r0 = 17
            r1 = 2
            if (r4 > r0) goto L_0x0106
            r0 = 5
            r6 = 1
            switch(r4) {
                case 0: goto L_0x00f9;
                case 1: goto L_0x00ec;
                case 2: goto L_0x00db;
                case 3: goto L_0x00db;
                case 4: goto L_0x00ce;
                case 5: goto L_0x00c1;
                case 6: goto L_0x00b7;
                case 7: goto L_0x00a2;
                case 8: goto L_0x0091;
                case 9: goto L_0x0079;
                case 10: goto L_0x006d;
                case 11: goto L_0x00ce;
                case 12: goto L_0x0069;
                case 13: goto L_0x00b7;
                case 14: goto L_0x00c1;
                case 15: goto L_0x005b;
                case 16: goto L_0x004d;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x01a4
        L_0x004d:
            if (r7 != 0) goto L_0x01a4
            int r6 = com.google.android.gms.internal.clearcut.w.b(r12, r10, r11)
            long r0 = r11.f9433b
            long r4 = com.google.android.gms.internal.clearcut.ak.a((long) r0)
            goto L_0x00e3
        L_0x005b:
            if (r7 != 0) goto L_0x01a4
            int r0 = com.google.android.gms.internal.clearcut.w.a(r12, r10, r11)
            int r1 = r11.f9432a
            int r1 = com.google.android.gms.internal.clearcut.ak.b(r1)
            goto L_0x00d6
        L_0x0069:
            if (r7 != 0) goto L_0x01a4
            goto L_0x00d0
        L_0x006d:
            if (r7 != r1) goto L_0x01a4
            int r0 = com.google.android.gms.internal.clearcut.w.e(r12, r10, r11)
        L_0x0073:
            java.lang.Object r1 = r11.f9434c
        L_0x0075:
            r9.putObject(r14, r2, r1)
            goto L_0x0012
        L_0x0079:
            if (r7 != r1) goto L_0x01a4
            com.google.android.gms.internal.clearcut.de r0 = r15.a((int) r8)
            int r0 = a((com.google.android.gms.internal.clearcut.de) r0, (byte[]) r12, (int) r10, (int) r13, (com.google.android.gms.internal.clearcut.x) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x008a
            goto L_0x0073
        L_0x008a:
            java.lang.Object r4 = r11.f9434c
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.bh.a((java.lang.Object) r1, (java.lang.Object) r4)
            goto L_0x0075
        L_0x0091:
            if (r7 != r1) goto L_0x01a4
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x009d
            int r0 = com.google.android.gms.internal.clearcut.w.c(r12, r10, r11)
            goto L_0x0073
        L_0x009d:
            int r0 = com.google.android.gms.internal.clearcut.w.d(r12, r10, r11)
            goto L_0x0073
        L_0x00a2:
            if (r7 != 0) goto L_0x01a4
            int r0 = com.google.android.gms.internal.clearcut.w.b(r12, r10, r11)
            long r4 = r11.f9433b
            r7 = 0
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r6 = 0
        L_0x00b2:
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r2, (boolean) r6)
            goto L_0x0012
        L_0x00b7:
            if (r7 != r0) goto L_0x01a4
            int r0 = com.google.android.gms.internal.clearcut.w.a(r12, r10)
            r9.putInt(r14, r2, r0)
            goto L_0x00f5
        L_0x00c1:
            if (r7 != r6) goto L_0x01a4
            long r4 = com.google.android.gms.internal.clearcut.w.b(r12, r10)
            r0 = r9
            r1 = r23
            r0.putLong(r1, r2, r4)
            goto L_0x0102
        L_0x00ce:
            if (r7 != 0) goto L_0x01a4
        L_0x00d0:
            int r0 = com.google.android.gms.internal.clearcut.w.a(r12, r10, r11)
            int r1 = r11.f9432a
        L_0x00d6:
            r9.putInt(r14, r2, r1)
            goto L_0x0012
        L_0x00db:
            if (r7 != 0) goto L_0x01a4
            int r6 = com.google.android.gms.internal.clearcut.w.b(r12, r10, r11)
            long r4 = r11.f9433b
        L_0x00e3:
            r0 = r9
            r1 = r23
            r0.putLong(r1, r2, r4)
            r0 = r6
            goto L_0x0012
        L_0x00ec:
            if (r7 != r0) goto L_0x01a4
            float r0 = com.google.android.gms.internal.clearcut.w.d(r12, r10)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r2, (float) r0)
        L_0x00f5:
            int r0 = r10 + 4
            goto L_0x0012
        L_0x00f9:
            if (r7 != r6) goto L_0x01a4
            double r0 = com.google.android.gms.internal.clearcut.w.c(r12, r10)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x0102:
            int r0 = r10 + 8
            goto L_0x0012
        L_0x0106:
            r0 = 27
            if (r4 != r0) goto L_0x013e
            if (r7 != r1) goto L_0x01a4
            java.lang.Object r0 = r9.getObject(r14, r2)
            com.google.android.gms.internal.clearcut.bm r0 = (com.google.android.gms.internal.clearcut.bm) r0
            boolean r1 = r0.a()
            if (r1 != 0) goto L_0x012a
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0121
            r1 = 10
            goto L_0x0123
        L_0x0121:
            int r1 = r1 << 1
        L_0x0123:
            com.google.android.gms.internal.clearcut.bm r0 = r0.a(r1)
            r9.putObject(r14, r2, r0)
        L_0x012a:
            r5 = r0
            com.google.android.gms.internal.clearcut.de r0 = r15.a((int) r8)
            r1 = r16
            r2 = r24
            r3 = r10
            r4 = r26
            r6 = r27
            int r0 = a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0012
        L_0x013e:
            r0 = 49
            if (r4 > r0) goto L_0x0167
            long r0 = (long) r5
            r17 = r0
            r0 = r22
            r1 = r23
            r19 = r2
            r2 = r24
            r3 = r10
            r5 = r4
            r4 = r26
            r25 = r5
            r5 = r16
            r21 = r9
            r15 = r10
            r9 = r17
            r11 = r25
            r12 = r19
            r14 = r27
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.clearcut.x) r14)
            if (r0 != r15) goto L_0x01b6
            goto L_0x01a2
        L_0x0167:
            r19 = r2
            r25 = r4
            r21 = r9
            r15 = r10
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x018a
            if (r7 != r1) goto L_0x01a7
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r15
            r4 = r26
            r5 = r19
            r7 = r27
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (long) r5, (com.google.android.gms.internal.clearcut.x) r7)
            if (r0 != r15) goto L_0x01b6
            goto L_0x01a2
        L_0x018a:
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r15
            r4 = r26
            r10 = r5
            r5 = r16
            r12 = r8
            r8 = r10
            r10 = r19
            r13 = r27
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.clearcut.x) r13)
            if (r0 != r15) goto L_0x01b6
        L_0x01a2:
            r2 = r0
            goto L_0x01a8
        L_0x01a4:
            r21 = r9
            r15 = r10
        L_0x01a7:
            r2 = r15
        L_0x01a8:
            r0 = r16
            r1 = r24
            r3 = r26
            r4 = r23
            r5 = r27
            int r0 = a((int) r0, (byte[]) r1, (int) r2, (int) r3, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.x) r5)
        L_0x01b6:
            r15 = r22
            r14 = r23
            r12 = r24
            r13 = r26
            r11 = r27
            r9 = r21
            goto L_0x0012
        L_0x01c4:
            r4 = r13
            if (r0 != r4) goto L_0x01c8
            return
        L_0x01c8:
            com.google.android.gms.internal.clearcut.bn r0 = com.google.android.gms.internal.clearcut.bn.zzbo()
            throw r0
        L_0x01cd:
            r4 = r13
            r5 = 0
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r6 = r27
            r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.clearcut.x) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.x):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (com.google.android.gms.internal.clearcut.dg.a(com.google.android.gms.internal.clearcut.eb.f(r10, r6), com.google.android.gms.internal.clearcut.eb.f(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (com.google.android.gms.internal.clearcut.eb.b(r10, r6) == com.google.android.gms.internal.clearcut.eb.b(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (com.google.android.gms.internal.clearcut.eb.b(r10, r6) == com.google.android.gms.internal.clearcut.eb.b(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (com.google.android.gms.internal.clearcut.dg.a(com.google.android.gms.internal.clearcut.eb.f(r10, r6), com.google.android.gms.internal.clearcut.eb.f(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (com.google.android.gms.internal.clearcut.dg.a(com.google.android.gms.internal.clearcut.eb.f(r10, r6), com.google.android.gms.internal.clearcut.eb.f(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (com.google.android.gms.internal.clearcut.dg.a(com.google.android.gms.internal.clearcut.eb.f(r10, r6), com.google.android.gms.internal.clearcut.eb.f(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.android.gms.internal.clearcut.eb.c(r10, r6) == com.google.android.gms.internal.clearcut.eb.c(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (com.google.android.gms.internal.clearcut.eb.b(r10, r6) == com.google.android.gms.internal.clearcut.eb.b(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.android.gms.internal.clearcut.eb.b(r10, r6) == com.google.android.gms.internal.clearcut.eb.b(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.android.gms.internal.clearcut.eb.b(r10, r6) == com.google.android.gms.internal.clearcut.eb.b(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018d, code lost:
        if (com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a0, code lost:
        if (com.google.android.gms.internal.clearcut.eb.b(r10, r6) == com.google.android.gms.internal.clearcut.eb.b(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a2, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.clearcut.dg.a(com.google.android.gms.internal.clearcut.eb.f(r10, r6), com.google.android.gms.internal.clearcut.eb.f(r11, r6)) != false) goto L_0x01a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.f9247b
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01aa
            int r4 = r9.c((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x0190;
                case 1: goto L_0x017f;
                case 2: goto L_0x016c;
                case 3: goto L_0x0159;
                case 4: goto L_0x0148;
                case 5: goto L_0x0135;
                case 6: goto L_0x0124;
                case 7: goto L_0x0112;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d0;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x009a;
                case 14: goto L_0x0086;
                case 15: goto L_0x0074;
                case 16: goto L_0x0060;
                case 17: goto L_0x004a;
                case 18: goto L_0x003c;
                case 19: goto L_0x003c;
                case 20: goto L_0x003c;
                case 21: goto L_0x003c;
                case 22: goto L_0x003c;
                case 23: goto L_0x003c;
                case 24: goto L_0x003c;
                case 25: goto L_0x003c;
                case 26: goto L_0x003c;
                case 27: goto L_0x003c;
                case 28: goto L_0x003c;
                case 29: goto L_0x003c;
                case 30: goto L_0x003c;
                case 31: goto L_0x003c;
                case 32: goto L_0x003c;
                case 33: goto L_0x003c;
                case 34: goto L_0x003c;
                case 35: goto L_0x003c;
                case 36: goto L_0x003c;
                case 37: goto L_0x003c;
                case 38: goto L_0x003c;
                case 39: goto L_0x003c;
                case 40: goto L_0x003c;
                case 41: goto L_0x003c;
                case 42: goto L_0x003c;
                case 43: goto L_0x003c;
                case 44: goto L_0x003c;
                case 45: goto L_0x003c;
                case 46: goto L_0x003c;
                case 47: goto L_0x003c;
                case 48: goto L_0x003c;
                case 49: goto L_0x003c;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01a3
        L_0x001c:
            int r4 = r9.d((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.eb.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.eb.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.dg.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x018f
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.eb.f(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.eb.f(r11, r6)
            boolean r3 = com.google.android.gms.internal.clearcut.dg.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01a3
        L_0x004a:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.eb.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.eb.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.dg.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x01a2
        L_0x0060:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.eb.b(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.eb.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x018f
        L_0x0074:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x0086:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.eb.b(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.eb.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x018f
        L_0x009a:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x00ac:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x018f
        L_0x00be:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x00d0:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.eb.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.eb.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.dg.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x018f
        L_0x00e6:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.eb.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.eb.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.dg.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x01a2
        L_0x00fc:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.eb.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.eb.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.dg.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x018f
        L_0x0112:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            boolean r4 = com.google.android.gms.internal.clearcut.eb.c(r10, r6)
            boolean r5 = com.google.android.gms.internal.clearcut.eb.c(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x0124:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x018f
        L_0x0135:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.eb.b(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.eb.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x01a2
        L_0x0148:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x018f
        L_0x0159:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.eb.b(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.eb.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x01a2
        L_0x016c:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.eb.b(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.eb.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x018f
        L_0x017f:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01a3
        L_0x018f:
            goto L_0x01a2
        L_0x0190:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.eb.b(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.eb.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
        L_0x01a2:
            r3 = 0
        L_0x01a3:
            if (r3 != 0) goto L_0x01a6
            return r1
        L_0x01a6:
            int r2 = r2 + 4
            goto L_0x0005
        L_0x01aa:
            com.google.android.gms.internal.clearcut.dv<?, ?> r0 = r9.q
            java.lang.Object r0 = r0.a(r10)
            com.google.android.gms.internal.clearcut.dv<?, ?> r2 = r9.q
            java.lang.Object r2 = r2.a(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01bd
            return r1
        L_0x01bd:
            boolean r0 = r9.f9253h
            if (r0 == 0) goto L_0x01d2
            com.google.android.gms.internal.clearcut.as<?> r0 = r9.r
            com.google.android.gms.internal.clearcut.aw r10 = r0.a((java.lang.Object) r10)
            com.google.android.gms.internal.clearcut.as<?> r0 = r9.r
            com.google.android.gms.internal.clearcut.aw r11 = r0.a((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01d2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, r2, com.google.android.gms.internal.clearcut.eb.f(r8, r2));
        b(r7, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, r2, com.google.android.gms.internal.clearcut.eb.f(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, r2, com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, r2, com.google.android.gms.internal.clearcut.eb.b(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        b(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        r0 = r0 + 4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(T r7, T r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0105
            r0 = 0
        L_0x0003:
            int[] r1 = r6.f9247b
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00f2
            int r1 = r6.c((int) r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.f9247b
            r4 = r4[r0]
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r1 = r1 & r5
            int r1 = r1 >>> 20
            switch(r1) {
                case 0: goto L_0x00de;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00ad;
                case 5: goto L_0x00a6;
                case 6: goto L_0x009f;
                case 7: goto L_0x0091;
                case 8: goto L_0x0083;
                case 9: goto L_0x007e;
                case 10: goto L_0x0077;
                case 11: goto L_0x0070;
                case 12: goto L_0x0069;
                case 13: goto L_0x0062;
                case 14: goto L_0x005a;
                case 15: goto L_0x0053;
                case 16: goto L_0x004b;
                case 17: goto L_0x007e;
                case 18: goto L_0x0044;
                case 19: goto L_0x0044;
                case 20: goto L_0x0044;
                case 21: goto L_0x0044;
                case 22: goto L_0x0044;
                case 23: goto L_0x0044;
                case 24: goto L_0x0044;
                case 25: goto L_0x0044;
                case 26: goto L_0x0044;
                case 27: goto L_0x0044;
                case 28: goto L_0x0044;
                case 29: goto L_0x0044;
                case 30: goto L_0x0044;
                case 31: goto L_0x0044;
                case 32: goto L_0x0044;
                case 33: goto L_0x0044;
                case 34: goto L_0x0044;
                case 35: goto L_0x0044;
                case 36: goto L_0x0044;
                case 37: goto L_0x0044;
                case 38: goto L_0x0044;
                case 39: goto L_0x0044;
                case 40: goto L_0x0044;
                case 41: goto L_0x0044;
                case 42: goto L_0x0044;
                case 43: goto L_0x0044;
                case 44: goto L_0x0044;
                case 45: goto L_0x0044;
                case 46: goto L_0x0044;
                case 47: goto L_0x0044;
                case 48: goto L_0x0044;
                case 49: goto L_0x0044;
                case 50: goto L_0x003d;
                case 51: goto L_0x002b;
                case 52: goto L_0x002b;
                case 53: goto L_0x002b;
                case 54: goto L_0x002b;
                case 55: goto L_0x002b;
                case 56: goto L_0x002b;
                case 57: goto L_0x002b;
                case 58: goto L_0x002b;
                case 59: goto L_0x002b;
                case 60: goto L_0x0026;
                case 61: goto L_0x001f;
                case 62: goto L_0x001f;
                case 63: goto L_0x001f;
                case 64: goto L_0x001f;
                case 65: goto L_0x001f;
                case 66: goto L_0x001f;
                case 67: goto L_0x001f;
                case 68: goto L_0x0026;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00ee
        L_0x001f:
            boolean r1 = r6.a(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0031
        L_0x0026:
            r6.b(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x002b:
            boolean r1 = r6.a(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0031:
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.eb.f(r8, r2)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            r6.b(r7, (int) r4, (int) r0)
            goto L_0x00ee
        L_0x003d:
            com.google.android.gms.internal.clearcut.ch r1 = r6.s
            com.google.android.gms.internal.clearcut.dg.a((com.google.android.gms.internal.clearcut.ch) r1, r7, r8, (long) r2)
            goto L_0x00ee
        L_0x0044:
            com.google.android.gms.internal.clearcut.bw r1 = r6.p
            r1.a(r7, r8, r2)
            goto L_0x00ee
        L_0x004b:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0053:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x005a:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0062:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x0069:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x006f:
            goto L_0x00b3
        L_0x0070:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x0077:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0089
        L_0x007e:
            r6.a(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x0083:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0089:
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.eb.f(r8, r2)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            goto L_0x00eb
        L_0x0091:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            boolean r1 = com.google.android.gms.internal.clearcut.eb.c(r8, r2)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, (long) r2, (boolean) r1)
            goto L_0x00eb
        L_0x009f:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x00a6:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00ad:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00b3:
            int r1 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r8, (long) r2)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, (long) r2, (int) r1)
            goto L_0x00eb
        L_0x00bb:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00c2:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00c8:
            long r4 = com.google.android.gms.internal.clearcut.eb.b(r8, r2)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, (long) r2, (long) r4)
            goto L_0x00eb
        L_0x00d0:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            float r1 = com.google.android.gms.internal.clearcut.eb.d(r8, r2)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, (long) r2, (float) r1)
            goto L_0x00eb
        L_0x00de:
            boolean r1 = r6.a(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            double r4 = com.google.android.gms.internal.clearcut.eb.e(r8, r2)
            com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r7, (long) r2, (double) r4)
        L_0x00eb:
            r6.b(r7, (int) r0)
        L_0x00ee:
            int r0 = r0 + 4
            goto L_0x0003
        L_0x00f2:
            boolean r0 = r6.j
            if (r0 != 0) goto L_0x0104
            com.google.android.gms.internal.clearcut.dv<?, ?> r0 = r6.q
            com.google.android.gms.internal.clearcut.dg.a(r0, r7, r8)
            boolean r0 = r6.f9253h
            if (r0 == 0) goto L_0x0104
            com.google.android.gms.internal.clearcut.as<?> r0 = r6.r
            com.google.android.gms.internal.clearcut.dg.a(r0, r7, r8)
        L_0x0104:
            return
        L_0x0105:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.b(java.lang.Object, java.lang.Object):void");
    }

    public final void c(T t) {
        int[] iArr = this.m;
        if (iArr != null) {
            for (int c2 : iArr) {
                long c3 = (long) (c(c2) & 1048575);
                Object f2 = eb.f(t, c3);
                if (f2 != null) {
                    eb.a((Object) t, c3, this.s.d(f2));
                }
            }
        }
        int[] iArr2 = this.n;
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                this.p.a(t, (long) i2);
            }
        }
        this.q.b(t);
        if (this.f9253h) {
            this.r.c(t);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0105 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0117 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(T r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int[] r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L_0x012f
            int r4 = r2.length
            if (r4 != 0) goto L_0x000e
            goto L_0x012f
        L_0x000e:
            r4 = -1
            int r5 = r2.length
            r6 = 0
            r4 = 0
            r7 = -1
            r8 = 0
        L_0x0014:
            if (r4 >= r5) goto L_0x011c
            r9 = r2[r4]
            int r10 = r0.e((int) r9)
            int r11 = r0.c((int) r10)
            boolean r12 = r0.j
            r13 = 1048575(0xfffff, float:1.469367E-39)
            if (r12 != 0) goto L_0x0042
            int[] r12 = r0.f9247b
            int r14 = r10 + 2
            r12 = r12[r14]
            r14 = r12 & r13
            int r12 = r12 >>> 20
            int r12 = r3 << r12
            if (r14 == r7) goto L_0x0040
            sun.misc.Unsafe r7 = f9246a
            r15 = r4
            long r3 = (long) r14
            int r3 = r7.getInt(r1, r3)
            r8 = r3
            r7 = r14
            goto L_0x0044
        L_0x0040:
            r15 = r4
            goto L_0x0044
        L_0x0042:
            r15 = r4
            r12 = 0
        L_0x0044:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r3 & r11
            if (r3 == 0) goto L_0x004b
            r3 = 1
            goto L_0x004c
        L_0x004b:
            r3 = 0
        L_0x004c:
            if (r3 == 0) goto L_0x0055
            boolean r3 = r0.a(r1, r10, r8, r12)
            if (r3 != 0) goto L_0x0055
            return r6
        L_0x0055:
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r11
            int r3 = r3 >>> 20
            r4 = 9
            if (r3 == r4) goto L_0x0106
            r4 = 17
            if (r3 == r4) goto L_0x0106
            r4 = 27
            if (r3 == r4) goto L_0x00d9
            r4 = 60
            if (r3 == r4) goto L_0x00c8
            r4 = 68
            if (r3 == r4) goto L_0x00c8
            r4 = 49
            if (r3 == r4) goto L_0x00d9
            r4 = 50
            if (r3 == r4) goto L_0x0078
            goto L_0x0117
        L_0x0078:
            com.google.android.gms.internal.clearcut.ch r3 = r0.s
            r4 = r11 & r13
            long r9 = (long) r4
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.eb.f(r1, r9)
            java.util.Map r3 = r3.b(r4)
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x00c4
            com.google.android.gms.internal.clearcut.ch r4 = r0.s
            com.google.android.gms.internal.clearcut.cf r4 = r4.b()
            com.google.android.gms.internal.clearcut.ej r4 = r4.f9242c
            com.google.android.gms.internal.clearcut.eo r4 = r4.zzek()
            com.google.android.gms.internal.clearcut.eo r9 = com.google.android.gms.internal.clearcut.eo.MESSAGE
            if (r4 != r9) goto L_0x00c4
            r4 = 0
            java.util.Collection r3 = r3.values()
            java.util.Iterator r3 = r3.iterator()
        L_0x00a4:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x00c4
            java.lang.Object r9 = r3.next()
            if (r4 != 0) goto L_0x00bc
            com.google.android.gms.internal.clearcut.cz r4 = com.google.android.gms.internal.clearcut.cz.a()
            java.lang.Class r10 = r9.getClass()
            com.google.android.gms.internal.clearcut.de r4 = r4.a(r10)
        L_0x00bc:
            boolean r9 = r4.d(r9)
            if (r9 != 0) goto L_0x00a4
            r3 = 0
            goto L_0x00c5
        L_0x00c4:
            r3 = 1
        L_0x00c5:
            if (r3 != 0) goto L_0x0117
            return r6
        L_0x00c8:
            boolean r3 = r0.a(r1, (int) r9, (int) r10)
            if (r3 == 0) goto L_0x0117
            com.google.android.gms.internal.clearcut.de r3 = r0.a((int) r10)
            boolean r3 = a((java.lang.Object) r1, (int) r11, (com.google.android.gms.internal.clearcut.de) r3)
            if (r3 != 0) goto L_0x0117
            return r6
        L_0x00d9:
            r3 = r11 & r13
            long r3 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.eb.f(r1, r3)
            java.util.List r3 = (java.util.List) r3
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0102
            com.google.android.gms.internal.clearcut.de r4 = r0.a((int) r10)
            r9 = 0
        L_0x00ed:
            int r10 = r3.size()
            if (r9 >= r10) goto L_0x0102
            java.lang.Object r10 = r3.get(r9)
            boolean r10 = r4.d(r10)
            if (r10 != 0) goto L_0x00ff
            r3 = 0
            goto L_0x0103
        L_0x00ff:
            int r9 = r9 + 1
            goto L_0x00ed
        L_0x0102:
            r3 = 1
        L_0x0103:
            if (r3 != 0) goto L_0x0117
            return r6
        L_0x0106:
            boolean r3 = r0.a(r1, r10, r8, r12)
            if (r3 == 0) goto L_0x0117
            com.google.android.gms.internal.clearcut.de r3 = r0.a((int) r10)
            boolean r3 = a((java.lang.Object) r1, (int) r11, (com.google.android.gms.internal.clearcut.de) r3)
            if (r3 != 0) goto L_0x0117
            return r6
        L_0x0117:
            int r4 = r15 + 1
            r3 = 1
            goto L_0x0014
        L_0x011c:
            boolean r2 = r0.f9253h
            if (r2 == 0) goto L_0x012d
            com.google.android.gms.internal.clearcut.as<?> r2 = r0.r
            com.google.android.gms.internal.clearcut.aw r1 = r2.a((java.lang.Object) r1)
            boolean r1 = r1.d()
            if (r1 != 0) goto L_0x012d
            return r6
        L_0x012d:
            r1 = 1
            return r1
        L_0x012f:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.d(java.lang.Object):boolean");
    }

    static <T> cq<T> a(ck ckVar, cu cuVar, bw bwVar, dv<?, ?> dvVar, as<?> asVar, ch chVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        Field field;
        Field field2;
        Field field3;
        ck ckVar2 = ckVar;
        if (ckVar2 instanceof db) {
            db dbVar = (db) ckVar2;
            int i10 = 1;
            boolean z2 = dbVar.a() == bf.g.f9204i;
            if (dbVar.f9269b.f9274d == 0) {
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                int i11 = dbVar.f9269b.f9276f;
                int i12 = dbVar.f9269b.f9277g;
                i4 = dbVar.f9269b.j;
                i3 = i11;
                i2 = i12;
            }
            int[] iArr = new int[(i4 << 2)];
            Object[] objArr = new Object[(i4 << 1)];
            int[] iArr2 = dbVar.f9269b.f9278h > 0 ? new int[dbVar.f9269b.f9278h] : null;
            int[] iArr3 = dbVar.f9269b.k > 0 ? new int[dbVar.f9269b.k] : null;
            dc dcVar = dbVar.f9269b;
            if (dcVar.a()) {
                int i13 = dcVar.m;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                while (true) {
                    if (i13 >= dbVar.f9269b.f9279i || i14 >= ((i13 - i3) << 2)) {
                        if (dcVar.b()) {
                            int i17 = dcVar.p << i10;
                            Object obj = dcVar.f9271a[i17];
                            if (obj instanceof Field) {
                                field2 = (Field) obj;
                            } else {
                                field2 = dc.a(dcVar.f9272b, (String) obj);
                                dcVar.f9271a[i17] = field2;
                            }
                            int a2 = (int) eb.a(field2);
                            int i18 = (dcVar.p << i10) + i10;
                            Object obj2 = dcVar.f9271a[i18];
                            if (obj2 instanceof Field) {
                                field3 = (Field) obj2;
                            } else {
                                field3 = dc.a(dcVar.f9272b, (String) obj2);
                                dcVar.f9271a[i18] = field3;
                            }
                            int i19 = a2;
                            i7 = (int) eb.a(field3);
                            i6 = i19;
                            i8 = 0;
                        } else {
                            int a3 = (int) eb.a(dcVar.r);
                            if (dcVar.c()) {
                                int i20 = (dcVar.f9275e << 1) + (dcVar.q / 32);
                                Object obj3 = dcVar.f9271a[i20];
                                if (obj3 instanceof Field) {
                                    field = (Field) obj3;
                                } else {
                                    field = dc.a(dcVar.f9272b, (String) obj3);
                                    dcVar.f9271a[i20] = field;
                                }
                                i6 = a3;
                                i7 = (int) eb.a(field);
                                i8 = dcVar.q % 32;
                            } else {
                                i6 = a3;
                                i8 = 0;
                                i7 = 0;
                            }
                        }
                        iArr[i14] = dcVar.m;
                        int i21 = i14 + 1;
                        z = z2;
                        if ((dcVar.n & 512) != 0) {
                            i9 = 536870912;
                            i5 = i2;
                        } else {
                            i5 = i2;
                            i9 = 0;
                        }
                        iArr[i21] = ((dcVar.n & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? 268435456 : 0) | i9 | (dcVar.o << 20) | i6;
                        iArr[i14 + 2] = (i8 << 20) | i7;
                        if (dcVar.u != null) {
                            int i22 = (i14 / 4) << 1;
                            objArr[i22] = dcVar.u;
                            if (dcVar.s != null) {
                                objArr[i22 + 1] = dcVar.s;
                            } else if (dcVar.t != null) {
                                objArr[i22 + 1] = dcVar.t;
                            }
                        } else if (dcVar.s != null) {
                            objArr[((i14 / 4) << 1) + 1] = dcVar.s;
                        } else if (dcVar.t != null) {
                            objArr[((i14 / 4) << 1) + 1] = dcVar.t;
                        }
                        int i23 = dcVar.o;
                        if (i23 == ba.MAP.ordinal()) {
                            iArr2[i15] = i14;
                            i15++;
                        } else if (i23 >= 18 && i23 <= 49) {
                            iArr3[i16] = iArr[i21] & 1048575;
                            i16++;
                        }
                        if (!dcVar.a()) {
                            break;
                        }
                        i13 = dcVar.m;
                    } else {
                        for (int i24 = 0; i24 < 4; i24++) {
                            iArr[i14 + i24] = -1;
                        }
                        i5 = i2;
                        z = z2;
                    }
                    i14 += 4;
                    z2 = z;
                    i2 = i5;
                    i10 = 1;
                }
            } else {
                i5 = i2;
                z = z2;
            }
            return new cq(iArr, objArr, i3, i5, dbVar.f9269b.f9279i, dbVar.f9268a, z, dbVar.f9269b.l, iArr2, iArr3, cuVar, bwVar, dvVar, asVar, chVar);
        }
        throw new NoSuchMethodError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d0, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e1, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f2, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0203, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0205, code lost:
        r2.putInt(r1, (long) r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0209, code lost:
        r8 = (com.google.android.gms.internal.clearcut.am.l(r10) + com.google.android.gms.internal.clearcut.am.n(r9)) + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x028e, code lost:
        r7 = r7 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0297, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.c(r10, (com.google.android.gms.internal.clearcut.cm) com.google.android.gms.internal.clearcut.eb.f(r1, r11), a(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02b0, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.f(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02bf, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.h(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02ca, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.h(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02d5, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.f(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02e4, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.i(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02f3, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.g(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02fe, code lost:
        r8 = com.google.android.gms.internal.clearcut.eb.f(r1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0302, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.c(r10, (com.google.android.gms.internal.clearcut.ab) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x030f, code lost:
        r8 = com.google.android.gms.internal.clearcut.dg.a(r10, com.google.android.gms.internal.clearcut.eb.f(r1, r11), a(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0329, code lost:
        if ((r8 instanceof com.google.android.gms.internal.clearcut.ab) != false) goto L_0x0302;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x032c, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.b(r10, (java.lang.String) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x033a, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.k(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0346, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.e(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0352, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.g(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0362, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.f(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0372, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.e(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0382, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.d(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x038e, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.i(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x039a, code lost:
        r8 = com.google.android.gms.internal.clearcut.am.j(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03a0, code lost:
        r6 = r6 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0468, code lost:
        if ((r3 instanceof com.google.android.gms.internal.clearcut.ab) != false) goto L_0x06d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x04e2, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x04f4, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0506, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0518, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x052a, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x053c, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x054e, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0560, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0571, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0582, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x0593, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x05a4, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x05b5, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x05c6, code lost:
        if (r0.k != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x05c8, code lost:
        r2.putInt(r1, (long) r11, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x05cc, code lost:
        r7 = r7 + ((com.google.android.gms.internal.clearcut.am.l(r12) + com.google.android.gms.internal.clearcut.am.n(r3)) + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x066e, code lost:
        r7 = r7 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0675, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.c(r12, (com.google.android.gms.internal.clearcut.cm) r2.getObject(r1, r3), a(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x068c, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.f(r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0699, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.h(r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x06a2, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.h(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x06ab, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.f(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x06b8, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.i(r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x06c5, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.g(r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x06ce, code lost:
        r3 = r2.getObject(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x06d2, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.c(r12, (com.google.android.gms.internal.clearcut.ab) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x06dd, code lost:
        r3 = com.google.android.gms.internal.clearcut.dg.a(r12, r2.getObject(r1, r3), a(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x06f4, code lost:
        if ((r3 instanceof com.google.android.gms.internal.clearcut.ab) != false) goto L_0x06d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x06f7, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.b(r12, (java.lang.String) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0703, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.k(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        if ((r8 instanceof com.google.android.gms.internal.clearcut.ab) != false) goto L_0x0302;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x070d, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.e(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0717, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.g(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x0725, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.f(r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x0733, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.e(r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0741, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.d(r12, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x074b, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.i(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x0755, code lost:
        r3 = com.google.android.gms.internal.clearcut.am.j(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x075b, code lost:
        r6 = r6 + 4;
        r3 = 267386880;
        r4 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011f, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0131, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0143, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0155, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0167, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0179, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x018b, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x019d, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01ae, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01bf, code lost:
        if (r0.k != false) goto L_0x0205;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r0.j
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            if (r2 == 0) goto L_0x03ac
            sun.misc.Unsafe r2 = f9246a
            r6 = 0
            r7 = 0
        L_0x0012:
            int[] r8 = r0.f9247b
            int r8 = r8.length
            if (r6 >= r8) goto L_0x03a4
            int r8 = r0.c((int) r6)
            r9 = r8 & r3
            int r9 = r9 >>> 20
            int[] r10 = r0.f9247b
            r10 = r10[r6]
            r8 = r8 & r4
            long r11 = (long) r8
            com.google.android.gms.internal.clearcut.ba r8 = com.google.android.gms.internal.clearcut.ba.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r9 < r8) goto L_0x003d
            com.google.android.gms.internal.clearcut.ba r8 = com.google.android.gms.internal.clearcut.ba.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r9 > r8) goto L_0x003d
            int[] r8 = r0.f9247b
            int r13 = r6 + 2
            r8 = r8[r13]
            r8 = r8 & r4
            goto L_0x003e
        L_0x003d:
            r8 = 0
        L_0x003e:
            switch(r9) {
                case 0: goto L_0x0394;
                case 1: goto L_0x0388;
                case 2: goto L_0x0378;
                case 3: goto L_0x0368;
                case 4: goto L_0x0358;
                case 5: goto L_0x034c;
                case 6: goto L_0x0340;
                case 7: goto L_0x0334;
                case 8: goto L_0x031d;
                case 9: goto L_0x0309;
                case 10: goto L_0x02f8;
                case 11: goto L_0x02e9;
                case 12: goto L_0x02da;
                case 13: goto L_0x02cf;
                case 14: goto L_0x02c4;
                case 15: goto L_0x02b5;
                case 16: goto L_0x02a6;
                case 17: goto L_0x0291;
                case 18: goto L_0x0286;
                case 19: goto L_0x027d;
                case 20: goto L_0x0274;
                case 21: goto L_0x026b;
                case 22: goto L_0x0262;
                case 23: goto L_0x0286;
                case 24: goto L_0x027d;
                case 25: goto L_0x0259;
                case 26: goto L_0x0250;
                case 27: goto L_0x0243;
                case 28: goto L_0x023a;
                case 29: goto L_0x0231;
                case 30: goto L_0x0228;
                case 31: goto L_0x027d;
                case 32: goto L_0x0286;
                case 33: goto L_0x021f;
                case 34: goto L_0x0215;
                case 35: goto L_0x01f5;
                case 36: goto L_0x01e4;
                case 37: goto L_0x01d3;
                case 38: goto L_0x01c2;
                case 39: goto L_0x01b1;
                case 40: goto L_0x01a0;
                case 41: goto L_0x018f;
                case 42: goto L_0x017d;
                case 43: goto L_0x016b;
                case 44: goto L_0x0159;
                case 45: goto L_0x0147;
                case 46: goto L_0x0135;
                case 47: goto L_0x0123;
                case 48: goto L_0x0111;
                case 49: goto L_0x0103;
                case 50: goto L_0x00f7;
                case 51: goto L_0x00ef;
                case 52: goto L_0x00e7;
                case 53: goto L_0x00db;
                case 54: goto L_0x00cf;
                case 55: goto L_0x00c3;
                case 56: goto L_0x00bb;
                case 57: goto L_0x00b3;
                case 58: goto L_0x00ab;
                case 59: goto L_0x009b;
                case 60: goto L_0x0093;
                case 61: goto L_0x008b;
                case 62: goto L_0x007f;
                case 63: goto L_0x0073;
                case 64: goto L_0x006b;
                case 65: goto L_0x0063;
                case 66: goto L_0x0057;
                case 67: goto L_0x004b;
                case 68: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x03a0
        L_0x0043:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x0297
        L_0x004b:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            long r8 = e(r1, r11)
            goto L_0x02b0
        L_0x0057:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            int r8 = d(r1, r11)
            goto L_0x02bf
        L_0x0063:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x02ca
        L_0x006b:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x02d5
        L_0x0073:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            int r8 = d(r1, r11)
            goto L_0x02e4
        L_0x007f:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            int r8 = d(r1, r11)
            goto L_0x02f3
        L_0x008b:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x02fe
        L_0x0093:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x030f
        L_0x009b:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r1, r11)
            boolean r9 = r8 instanceof com.google.android.gms.internal.clearcut.ab
            if (r9 == 0) goto L_0x032c
            goto L_0x032b
        L_0x00ab:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x033a
        L_0x00b3:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x0346
        L_0x00bb:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x0352
        L_0x00c3:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            int r8 = d(r1, r11)
            goto L_0x0362
        L_0x00cf:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            long r8 = e(r1, r11)
            goto L_0x0372
        L_0x00db:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            long r8 = e(r1, r11)
            goto L_0x0382
        L_0x00e7:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x038e
        L_0x00ef:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x03a0
            goto L_0x039a
        L_0x00f7:
            com.google.android.gms.internal.clearcut.ch r8 = r0.s
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r1, r11)
            int r8 = r8.e(r9)
            goto L_0x028e
        L_0x0103:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            com.google.android.gms.internal.clearcut.de r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.clearcut.dg.b((int) r10, (java.util.List<com.google.android.gms.internal.clearcut.cm>) r8, (com.google.android.gms.internal.clearcut.de) r9)
            goto L_0x028e
        L_0x0111:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.c(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x0123:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.g(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x0135:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.i(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x0147:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.h(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x0159:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.d(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x016b:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.f(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x017d:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.j(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x018f:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.h(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x01a0:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.i(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x01b1:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.e(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x01c2:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.b(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x01d3:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.a((java.util.List<java.lang.Long>) r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x01e4:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.h(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
            goto L_0x0205
        L_0x01f5:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.clearcut.dg.i(r9)
            if (r9 <= 0) goto L_0x03a0
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0209
        L_0x0205:
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0209:
            int r8 = com.google.android.gms.internal.clearcut.am.l(r10)
            int r10 = com.google.android.gms.internal.clearcut.am.n(r9)
            int r8 = r8 + r10
            int r8 = r8 + r9
            goto L_0x028e
        L_0x0215:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.c(r10, r8)
            goto L_0x028e
        L_0x021f:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.g(r10, r8)
            goto L_0x028e
        L_0x0228:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.d(r10, r8)
            goto L_0x028e
        L_0x0231:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.f(r10, r8)
            goto L_0x028e
        L_0x023a:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.l(r10, r8)
            goto L_0x028e
        L_0x0243:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            com.google.android.gms.internal.clearcut.de r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.clearcut.dg.a((int) r10, (java.util.List<?>) r8, (com.google.android.gms.internal.clearcut.de) r9)
            goto L_0x028e
        L_0x0250:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.k(r10, r8)
            goto L_0x028e
        L_0x0259:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.j(r10, r8)
            goto L_0x028e
        L_0x0262:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.e(r10, r8)
            goto L_0x028e
        L_0x026b:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.b(r10, r8)
            goto L_0x028e
        L_0x0274:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.a((int) r10, (java.util.List<java.lang.Long>) r8)
            goto L_0x028e
        L_0x027d:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.h(r10, r8)
            goto L_0x028e
        L_0x0286:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.clearcut.dg.i(r10, r8)
        L_0x028e:
            int r7 = r7 + r8
            goto L_0x03a0
        L_0x0291:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x0297:
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r1, r11)
            com.google.android.gms.internal.clearcut.cm r8 = (com.google.android.gms.internal.clearcut.cm) r8
            com.google.android.gms.internal.clearcut.de r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.clearcut.am.c(r10, r8, r9)
            goto L_0x028e
        L_0x02a6:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
            long r8 = com.google.android.gms.internal.clearcut.eb.b(r1, r11)
        L_0x02b0:
            int r8 = com.google.android.gms.internal.clearcut.am.f((int) r10, (long) r8)
            goto L_0x028e
        L_0x02b5:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r1, (long) r11)
        L_0x02bf:
            int r8 = com.google.android.gms.internal.clearcut.am.h(r10, r8)
            goto L_0x028e
        L_0x02c4:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x02ca:
            int r8 = com.google.android.gms.internal.clearcut.am.h(r10)
            goto L_0x028e
        L_0x02cf:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x02d5:
            int r8 = com.google.android.gms.internal.clearcut.am.f((int) r10)
            goto L_0x028e
        L_0x02da:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r1, (long) r11)
        L_0x02e4:
            int r8 = com.google.android.gms.internal.clearcut.am.i(r10, r8)
            goto L_0x028e
        L_0x02e9:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r1, (long) r11)
        L_0x02f3:
            int r8 = com.google.android.gms.internal.clearcut.am.g(r10, r8)
            goto L_0x028e
        L_0x02f8:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x02fe:
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r1, r11)
        L_0x0302:
            com.google.android.gms.internal.clearcut.ab r8 = (com.google.android.gms.internal.clearcut.ab) r8
            int r8 = com.google.android.gms.internal.clearcut.am.c((int) r10, (com.google.android.gms.internal.clearcut.ab) r8)
            goto L_0x028e
        L_0x0309:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x030f:
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r1, r11)
            com.google.android.gms.internal.clearcut.de r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.clearcut.dg.a((int) r10, (java.lang.Object) r8, (com.google.android.gms.internal.clearcut.de) r9)
            goto L_0x028e
        L_0x031d:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r1, r11)
            boolean r9 = r8 instanceof com.google.android.gms.internal.clearcut.ab
            if (r9 == 0) goto L_0x032c
        L_0x032b:
            goto L_0x0302
        L_0x032c:
            java.lang.String r8 = (java.lang.String) r8
            int r8 = com.google.android.gms.internal.clearcut.am.b((int) r10, (java.lang.String) r8)
            goto L_0x028e
        L_0x0334:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x033a:
            int r8 = com.google.android.gms.internal.clearcut.am.k(r10)
            goto L_0x028e
        L_0x0340:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x0346:
            int r8 = com.google.android.gms.internal.clearcut.am.e((int) r10)
            goto L_0x028e
        L_0x034c:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x0352:
            int r8 = com.google.android.gms.internal.clearcut.am.g((int) r10)
            goto L_0x028e
        L_0x0358:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r1, (long) r11)
        L_0x0362:
            int r8 = com.google.android.gms.internal.clearcut.am.f((int) r10, (int) r8)
            goto L_0x028e
        L_0x0368:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
            long r8 = com.google.android.gms.internal.clearcut.eb.b(r1, r11)
        L_0x0372:
            int r8 = com.google.android.gms.internal.clearcut.am.e((int) r10, (long) r8)
            goto L_0x028e
        L_0x0378:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
            long r8 = com.google.android.gms.internal.clearcut.eb.b(r1, r11)
        L_0x0382:
            int r8 = com.google.android.gms.internal.clearcut.am.d((int) r10, (long) r8)
            goto L_0x028e
        L_0x0388:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x038e:
            int r8 = com.google.android.gms.internal.clearcut.am.i(r10)
            goto L_0x028e
        L_0x0394:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x03a0
        L_0x039a:
            int r8 = com.google.android.gms.internal.clearcut.am.j(r10)
            goto L_0x028e
        L_0x03a0:
            int r6 = r6 + 4
            goto L_0x0012
        L_0x03a4:
            com.google.android.gms.internal.clearcut.dv<?, ?> r2 = r0.q
            int r1 = a(r2, r1)
            int r7 = r7 + r1
            return r7
        L_0x03ac:
            sun.misc.Unsafe r2 = f9246a
            r6 = -1
            r6 = 0
            r7 = 0
            r8 = -1
            r9 = 0
        L_0x03b3:
            int[] r10 = r0.f9247b
            int r10 = r10.length
            if (r6 >= r10) goto L_0x0764
            int r10 = r0.c((int) r6)
            int[] r11 = r0.f9247b
            r12 = r11[r6]
            r13 = r10 & r3
            int r13 = r13 >>> 20
            r14 = 17
            if (r13 > r14) goto L_0x03df
            int r14 = r6 + 2
            r11 = r11[r14]
            r14 = r11 & r4
            int r15 = r11 >>> 20
            r16 = 1
            int r15 = r16 << r15
            if (r14 == r8) goto L_0x03dc
            long r8 = (long) r14
            int r9 = r2.getInt(r1, r8)
            goto L_0x03dd
        L_0x03dc:
            r14 = r8
        L_0x03dd:
            r8 = r14
            goto L_0x03fd
        L_0x03df:
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x03fb
            com.google.android.gms.internal.clearcut.ba r11 = com.google.android.gms.internal.clearcut.ba.DOUBLE_LIST_PACKED
            int r11 = r11.id()
            if (r13 < r11) goto L_0x03fb
            com.google.android.gms.internal.clearcut.ba r11 = com.google.android.gms.internal.clearcut.ba.SINT64_LIST_PACKED
            int r11 = r11.id()
            if (r13 > r11) goto L_0x03fb
            int[] r11 = r0.f9247b
            int r14 = r6 + 2
            r11 = r11[r14]
            r11 = r11 & r4
            goto L_0x03fc
        L_0x03fb:
            r11 = 0
        L_0x03fc:
            r15 = 0
        L_0x03fd:
            r10 = r10 & r4
            long r3 = (long) r10
            switch(r13) {
                case 0: goto L_0x0751;
                case 1: goto L_0x0747;
                case 2: goto L_0x0739;
                case 3: goto L_0x072b;
                case 4: goto L_0x071d;
                case 5: goto L_0x0713;
                case 6: goto L_0x0709;
                case 7: goto L_0x06ff;
                case 8: goto L_0x06ea;
                case 9: goto L_0x06d9;
                case 10: goto L_0x06ca;
                case 11: goto L_0x06bd;
                case 12: goto L_0x06b0;
                case 13: goto L_0x06a7;
                case 14: goto L_0x069e;
                case 15: goto L_0x0691;
                case 16: goto L_0x0684;
                case 17: goto L_0x0671;
                case 18: goto L_0x0664;
                case 19: goto L_0x0659;
                case 20: goto L_0x064e;
                case 21: goto L_0x0643;
                case 22: goto L_0x0638;
                case 23: goto L_0x0664;
                case 24: goto L_0x0659;
                case 25: goto L_0x062d;
                case 26: goto L_0x0622;
                case 27: goto L_0x0613;
                case 28: goto L_0x0608;
                case 29: goto L_0x05fd;
                case 30: goto L_0x05f1;
                case 31: goto L_0x0659;
                case 32: goto L_0x0664;
                case 33: goto L_0x05e5;
                case 34: goto L_0x05d9;
                case 35: goto L_0x05b8;
                case 36: goto L_0x05a7;
                case 37: goto L_0x0596;
                case 38: goto L_0x0585;
                case 39: goto L_0x0574;
                case 40: goto L_0x0563;
                case 41: goto L_0x0552;
                case 42: goto L_0x0540;
                case 43: goto L_0x052e;
                case 44: goto L_0x051c;
                case 45: goto L_0x050a;
                case 46: goto L_0x04f8;
                case 47: goto L_0x04e6;
                case 48: goto L_0x04d4;
                case 49: goto L_0x04c4;
                case 50: goto L_0x04b8;
                case 51: goto L_0x04b0;
                case 52: goto L_0x04a8;
                case 53: goto L_0x049c;
                case 54: goto L_0x0490;
                case 55: goto L_0x0484;
                case 56: goto L_0x047c;
                case 57: goto L_0x0474;
                case 58: goto L_0x046c;
                case 59: goto L_0x045c;
                case 60: goto L_0x0454;
                case 61: goto L_0x044c;
                case 62: goto L_0x0440;
                case 63: goto L_0x0434;
                case 64: goto L_0x042c;
                case 65: goto L_0x0424;
                case 66: goto L_0x0418;
                case 67: goto L_0x040c;
                case 68: goto L_0x0404;
                default: goto L_0x0402;
            }
        L_0x0402:
            goto L_0x075b
        L_0x0404:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            goto L_0x0675
        L_0x040c:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            long r3 = e(r1, r3)
            goto L_0x068c
        L_0x0418:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            int r3 = d(r1, r3)
            goto L_0x0699
        L_0x0424:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x075b
            goto L_0x06a2
        L_0x042c:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x075b
            goto L_0x06ab
        L_0x0434:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            int r3 = d(r1, r3)
            goto L_0x06b8
        L_0x0440:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            int r3 = d(r1, r3)
            goto L_0x06c5
        L_0x044c:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            goto L_0x06ce
        L_0x0454:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            goto L_0x06dd
        L_0x045c:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.clearcut.ab
            if (r4 == 0) goto L_0x06f7
            goto L_0x06f6
        L_0x046c:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x075b
            goto L_0x0703
        L_0x0474:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x075b
            goto L_0x070d
        L_0x047c:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x075b
            goto L_0x0717
        L_0x0484:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            int r3 = d(r1, r3)
            goto L_0x0725
        L_0x0490:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            long r3 = e(r1, r3)
            goto L_0x0733
        L_0x049c:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x075b
            long r3 = e(r1, r3)
            goto L_0x0741
        L_0x04a8:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x075b
            goto L_0x074b
        L_0x04b0:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x075b
            goto L_0x0755
        L_0x04b8:
            com.google.android.gms.internal.clearcut.ch r10 = r0.s
            java.lang.Object r3 = r2.getObject(r1, r3)
            int r3 = r10.e(r3)
            goto L_0x066e
        L_0x04c4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.clearcut.de r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.clearcut.dg.b((int) r12, (java.util.List<com.google.android.gms.internal.clearcut.cm>) r3, (com.google.android.gms.internal.clearcut.de) r4)
            goto L_0x066e
        L_0x04d4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.c(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x04e6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.g(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x04f8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.i(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x050a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.h(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x051c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.d(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x052e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.f(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x0540:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.j(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x0552:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.h(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x0563:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.i(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x0574:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.e(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x0585:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.b(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x0596:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.a((java.util.List<java.lang.Long>) r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x05a7:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.h(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
            goto L_0x05c8
        L_0x05b8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.i(r3)
            if (r3 <= 0) goto L_0x075b
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x05cc
        L_0x05c8:
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x05cc:
            int r4 = com.google.android.gms.internal.clearcut.am.l(r12)
            int r10 = com.google.android.gms.internal.clearcut.am.n(r3)
            int r4 = r4 + r10
            int r4 = r4 + r3
            int r7 = r7 + r4
            goto L_0x075b
        L_0x05d9:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.c(r12, r3)
            goto L_0x066e
        L_0x05e5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.g(r12, r3)
            goto L_0x066e
        L_0x05f1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.d(r12, r3)
            goto L_0x066e
        L_0x05fd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.f(r12, r3)
            goto L_0x066e
        L_0x0608:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.l(r12, r3)
            goto L_0x066e
        L_0x0613:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.clearcut.de r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.clearcut.dg.a((int) r12, (java.util.List<?>) r3, (com.google.android.gms.internal.clearcut.de) r4)
            goto L_0x066e
        L_0x0622:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.k(r12, r3)
            goto L_0x066e
        L_0x062d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.j(r12, r3)
            goto L_0x066e
        L_0x0638:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.e(r12, r3)
            goto L_0x066e
        L_0x0643:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.b(r12, r3)
            goto L_0x066e
        L_0x064e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.a((int) r12, (java.util.List<java.lang.Long>) r3)
            goto L_0x066e
        L_0x0659:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.h(r12, r3)
            goto L_0x066e
        L_0x0664:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.clearcut.dg.i(r12, r3)
        L_0x066e:
            int r7 = r7 + r3
            goto L_0x075b
        L_0x0671:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
        L_0x0675:
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.clearcut.cm r3 = (com.google.android.gms.internal.clearcut.cm) r3
            com.google.android.gms.internal.clearcut.de r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.clearcut.am.c(r12, r3, r4)
            goto L_0x066e
        L_0x0684:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
            long r3 = r2.getLong(r1, r3)
        L_0x068c:
            int r3 = com.google.android.gms.internal.clearcut.am.f((int) r12, (long) r3)
            goto L_0x066e
        L_0x0691:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
            int r3 = r2.getInt(r1, r3)
        L_0x0699:
            int r3 = com.google.android.gms.internal.clearcut.am.h(r12, r3)
            goto L_0x066e
        L_0x069e:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x075b
        L_0x06a2:
            int r3 = com.google.android.gms.internal.clearcut.am.h(r12)
            goto L_0x066e
        L_0x06a7:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x075b
        L_0x06ab:
            int r3 = com.google.android.gms.internal.clearcut.am.f((int) r12)
            goto L_0x066e
        L_0x06b0:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
            int r3 = r2.getInt(r1, r3)
        L_0x06b8:
            int r3 = com.google.android.gms.internal.clearcut.am.i(r12, r3)
            goto L_0x066e
        L_0x06bd:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
            int r3 = r2.getInt(r1, r3)
        L_0x06c5:
            int r3 = com.google.android.gms.internal.clearcut.am.g(r12, r3)
            goto L_0x066e
        L_0x06ca:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
        L_0x06ce:
            java.lang.Object r3 = r2.getObject(r1, r3)
        L_0x06d2:
            com.google.android.gms.internal.clearcut.ab r3 = (com.google.android.gms.internal.clearcut.ab) r3
            int r3 = com.google.android.gms.internal.clearcut.am.c((int) r12, (com.google.android.gms.internal.clearcut.ab) r3)
            goto L_0x066e
        L_0x06d9:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
        L_0x06dd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.clearcut.de r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.clearcut.dg.a((int) r12, (java.lang.Object) r3, (com.google.android.gms.internal.clearcut.de) r4)
            goto L_0x066e
        L_0x06ea:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.clearcut.ab
            if (r4 == 0) goto L_0x06f7
        L_0x06f6:
            goto L_0x06d2
        L_0x06f7:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.clearcut.am.b((int) r12, (java.lang.String) r3)
            goto L_0x066e
        L_0x06ff:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x075b
        L_0x0703:
            int r3 = com.google.android.gms.internal.clearcut.am.k(r12)
            goto L_0x066e
        L_0x0709:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x075b
        L_0x070d:
            int r3 = com.google.android.gms.internal.clearcut.am.e((int) r12)
            goto L_0x066e
        L_0x0713:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x075b
        L_0x0717:
            int r3 = com.google.android.gms.internal.clearcut.am.g((int) r12)
            goto L_0x066e
        L_0x071d:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
            int r3 = r2.getInt(r1, r3)
        L_0x0725:
            int r3 = com.google.android.gms.internal.clearcut.am.f((int) r12, (int) r3)
            goto L_0x066e
        L_0x072b:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
            long r3 = r2.getLong(r1, r3)
        L_0x0733:
            int r3 = com.google.android.gms.internal.clearcut.am.e((int) r12, (long) r3)
            goto L_0x066e
        L_0x0739:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x075b
            long r3 = r2.getLong(r1, r3)
        L_0x0741:
            int r3 = com.google.android.gms.internal.clearcut.am.d((int) r12, (long) r3)
            goto L_0x066e
        L_0x0747:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x075b
        L_0x074b:
            int r3 = com.google.android.gms.internal.clearcut.am.i(r12)
            goto L_0x066e
        L_0x0751:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x075b
        L_0x0755:
            int r3 = com.google.android.gms.internal.clearcut.am.j(r12)
            goto L_0x066e
        L_0x075b:
            int r6 = r6 + 4
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x03b3
        L_0x0764:
            com.google.android.gms.internal.clearcut.dv<?, ?> r2 = r0.q
            int r2 = a(r2, r1)
            int r7 = r7 + r2
            boolean r2 = r0.f9253h
            if (r2 == 0) goto L_0x07bd
            com.google.android.gms.internal.clearcut.as<?> r2 = r0.r
            com.google.android.gms.internal.clearcut.aw r1 = r2.a((java.lang.Object) r1)
            r2 = 0
        L_0x0776:
            com.google.android.gms.internal.clearcut.dh<FieldDescriptorType, java.lang.Object> r3 = r1.f9169a
            int r3 = r3.b()
            if (r5 >= r3) goto L_0x0796
            com.google.android.gms.internal.clearcut.dh<FieldDescriptorType, java.lang.Object> r3 = r1.f9169a
            java.util.Map$Entry r3 = r3.b((int) r5)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.clearcut.az r4 = (com.google.android.gms.internal.clearcut.az) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.clearcut.aw.a(r4, r3)
            int r2 = r2 + r3
            int r5 = r5 + 1
            goto L_0x0776
        L_0x0796:
            com.google.android.gms.internal.clearcut.dh<FieldDescriptorType, java.lang.Object> r1 = r1.f9169a
            java.lang.Iterable r1 = r1.c()
            java.util.Iterator r1 = r1.iterator()
        L_0x07a0:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x07bc
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.clearcut.az r4 = (com.google.android.gms.internal.clearcut.az) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.clearcut.aw.a(r4, r3)
            int r2 = r2 + r3
            goto L_0x07a0
        L_0x07bc:
            int r7 = r7 + r2
        L_0x07bd:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.b(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03a2, code lost:
        r15.b(r9, com.google.android.gms.internal.clearcut.eb.f(r14, (long) (r8 & 1048575)), a(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03bd, code lost:
        r15.e(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03ce, code lost:
        r15.f(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03df, code lost:
        r15.b(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03f0, code lost:
        r15.a(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0401, code lost:
        r15.b(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0412, code lost:
        r15.e(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x041d, code lost:
        r15.a(r9, (com.google.android.gms.internal.clearcut.ab) com.google.android.gms.internal.clearcut.eb.f(r14, (long) (r8 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0430, code lost:
        r15.a(r9, com.google.android.gms.internal.clearcut.eb.f(r14, (long) (r8 & 1048575)), a(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0445, code lost:
        a(r9, com.google.android.gms.internal.clearcut.eb.f(r14, (long) (r8 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x045c, code lost:
        r15.a(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x046d, code lost:
        r15.d(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x047d, code lost:
        r15.d(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x048d, code lost:
        r15.c(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x049d, code lost:
        r15.c(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x04ad, code lost:
        r15.a(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04bd, code lost:
        r15.a(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x04cd, code lost:
        r15.a(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0862, code lost:
        r15.b(r10, com.google.android.gms.internal.clearcut.eb.f(r14, (long) (r9 & 1048575)), a(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x087d, code lost:
        r15.e(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x088e, code lost:
        r15.f(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x089f, code lost:
        r15.b(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x08b0, code lost:
        r15.a(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x08c1, code lost:
        r15.b(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x08d2, code lost:
        r15.e(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x08dd, code lost:
        r15.a(r10, (com.google.android.gms.internal.clearcut.ab) com.google.android.gms.internal.clearcut.eb.f(r14, (long) (r9 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x08f0, code lost:
        r15.a(r10, com.google.android.gms.internal.clearcut.eb.f(r14, (long) (r9 & 1048575)), a(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0905, code lost:
        a(r10, com.google.android.gms.internal.clearcut.eb.f(r14, (long) (r9 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x091c, code lost:
        r15.a(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x092d, code lost:
        r15.d(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x093d, code lost:
        r15.d(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x094d, code lost:
        r15.c(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x095d, code lost:
        r15.c(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x096d, code lost:
        r15.a(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x097d, code lost:
        r15.a(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x098d, code lost:
        r15.a(r10, r11);
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x04d6  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0996  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r14, com.google.android.gms.internal.clearcut.ep r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.a()
            int r1 = com.google.android.gms.internal.clearcut.bf.g.k
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04ec
            com.google.android.gms.internal.clearcut.dv<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.gms.internal.clearcut.ep) r15)
            boolean r0 = r13.f9253h
            if (r0 == 0) goto L_0x004d
            com.google.android.gms.internal.clearcut.as<?> r0 = r13.r
            com.google.android.gms.internal.clearcut.aw r0 = r0.a((java.lang.Object) r14)
            com.google.android.gms.internal.clearcut.dh<FieldDescriptorType, java.lang.Object> r1 = r0.f9169a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x004d
            boolean r1 = r0.f9171c
            if (r1 == 0) goto L_0x003c
            com.google.android.gms.internal.clearcut.bs r1 = new com.google.android.gms.internal.clearcut.bs
            com.google.android.gms.internal.clearcut.dh<FieldDescriptorType, java.lang.Object> r0 = r0.f9169a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
            r1.<init>(r0)
            r0 = r1
            goto L_0x0046
        L_0x003c:
            com.google.android.gms.internal.clearcut.dh<FieldDescriptorType, java.lang.Object> r0 = r0.f9169a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
        L_0x0046:
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x004f
        L_0x004d:
            r0 = r3
            r1 = r0
        L_0x004f:
            int[] r7 = r13.f9247b
            int r7 = r7.length
            int r7 = r7 + -4
        L_0x0054:
            if (r7 < 0) goto L_0x04d4
            int r8 = r13.c((int) r7)
            int[] r9 = r13.f9247b
            r9 = r9[r7]
        L_0x005e:
            if (r1 == 0) goto L_0x007c
            com.google.android.gms.internal.clearcut.as<?> r10 = r13.r
            int r10 = r10.a((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x007c
            com.google.android.gms.internal.clearcut.as<?> r10 = r13.r
            r10.a((com.google.android.gms.internal.clearcut.ep) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x005e
        L_0x007a:
            r1 = r3
            goto L_0x005e
        L_0x007c:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04c1;
                case 1: goto L_0x04b1;
                case 2: goto L_0x04a1;
                case 3: goto L_0x0491;
                case 4: goto L_0x0481;
                case 5: goto L_0x0471;
                case 6: goto L_0x0461;
                case 7: goto L_0x0450;
                case 8: goto L_0x043f;
                case 9: goto L_0x042a;
                case 10: goto L_0x0417;
                case 11: goto L_0x0406;
                case 12: goto L_0x03f5;
                case 13: goto L_0x03e4;
                case 14: goto L_0x03d3;
                case 15: goto L_0x03c2;
                case 16: goto L_0x03b1;
                case 17: goto L_0x039c;
                case 18: goto L_0x038b;
                case 19: goto L_0x037a;
                case 20: goto L_0x0369;
                case 21: goto L_0x0358;
                case 22: goto L_0x0347;
                case 23: goto L_0x0336;
                case 24: goto L_0x0325;
                case 25: goto L_0x0314;
                case 26: goto L_0x0303;
                case 27: goto L_0x02ee;
                case 28: goto L_0x02dd;
                case 29: goto L_0x02cc;
                case 30: goto L_0x02bb;
                case 31: goto L_0x02aa;
                case 32: goto L_0x0299;
                case 33: goto L_0x0288;
                case 34: goto L_0x0277;
                case 35: goto L_0x0266;
                case 36: goto L_0x0255;
                case 37: goto L_0x0244;
                case 38: goto L_0x0233;
                case 39: goto L_0x0222;
                case 40: goto L_0x0211;
                case 41: goto L_0x0200;
                case 42: goto L_0x01ef;
                case 43: goto L_0x01de;
                case 44: goto L_0x01cd;
                case 45: goto L_0x01bc;
                case 46: goto L_0x01ab;
                case 47: goto L_0x019a;
                case 48: goto L_0x0189;
                case 49: goto L_0x0174;
                case 50: goto L_0x0169;
                case 51: goto L_0x015b;
                case 52: goto L_0x014d;
                case 53: goto L_0x013f;
                case 54: goto L_0x0131;
                case 55: goto L_0x0123;
                case 56: goto L_0x0115;
                case 57: goto L_0x0107;
                case 58: goto L_0x00f9;
                case 59: goto L_0x00f1;
                case 60: goto L_0x00e9;
                case 61: goto L_0x00e1;
                case 62: goto L_0x00d3;
                case 63: goto L_0x00c5;
                case 64: goto L_0x00b7;
                case 65: goto L_0x00a9;
                case 66: goto L_0x009b;
                case 67: goto L_0x008d;
                case 68: goto L_0x0085;
                default: goto L_0x0083;
            }
        L_0x0083:
            goto L_0x04d0
        L_0x0085:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            goto L_0x03a2
        L_0x008d:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            goto L_0x03bd
        L_0x009b:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            goto L_0x03ce
        L_0x00a9:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            goto L_0x03df
        L_0x00b7:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            goto L_0x03f0
        L_0x00c5:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            goto L_0x0401
        L_0x00d3:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            goto L_0x0412
        L_0x00e1:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            goto L_0x041d
        L_0x00e9:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            goto L_0x0430
        L_0x00f1:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            goto L_0x0445
        L_0x00f9:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = f(r14, r10)
            goto L_0x045c
        L_0x0107:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            goto L_0x046d
        L_0x0115:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            goto L_0x047d
        L_0x0123:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            goto L_0x048d
        L_0x0131:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            goto L_0x049d
        L_0x013f:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            goto L_0x04ad
        L_0x014d:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = c(r14, r10)
            goto L_0x04bd
        L_0x015b:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = b(r14, (long) r10)
            goto L_0x04cd
        L_0x0169:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            r13.a((com.google.android.gms.internal.clearcut.ep) r15, (int) r9, (java.lang.Object) r8)
            goto L_0x04d0
        L_0x0174:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.de r10 = r13.a((int) r7)
            com.google.android.gms.internal.clearcut.dg.b((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.clearcut.ep) r15, (com.google.android.gms.internal.clearcut.de) r10)
            goto L_0x04d0
        L_0x0189:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.e(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x019a:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.j(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x01ab:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.g(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x01bc:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.l(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x01cd:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.m(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x01de:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.i(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x01ef:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.n(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x0200:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.k(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x0211:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.f(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x0222:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.h(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x0233:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.d(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x0244:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.c(r9, r8, r15, r4)
            goto L_0x04d0
        L_0x0255:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.clearcut.ep) r15, (boolean) r4)
            goto L_0x04d0
        L_0x0266:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.clearcut.ep) r15, (boolean) r4)
            goto L_0x04d0
        L_0x0277:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.e(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x0288:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.j(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x0299:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.g(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x02aa:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.l(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x02bb:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.m(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x02cc:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.i(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x02dd:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.b((int) r9, (java.util.List<com.google.android.gms.internal.clearcut.ab>) r8, (com.google.android.gms.internal.clearcut.ep) r15)
            goto L_0x04d0
        L_0x02ee:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.de r10 = r13.a((int) r7)
            com.google.android.gms.internal.clearcut.dg.a((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.clearcut.ep) r15, (com.google.android.gms.internal.clearcut.de) r10)
            goto L_0x04d0
        L_0x0303:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.a((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.clearcut.ep) r15)
            goto L_0x04d0
        L_0x0314:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.n(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x0325:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.k(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x0336:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.f(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x0347:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.h(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x0358:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.d(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x0369:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.c(r9, r8, r15, r5)
            goto L_0x04d0
        L_0x037a:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.clearcut.ep) r15, (boolean) r5)
            goto L_0x04d0
        L_0x038b:
            int[] r9 = r13.f9247b
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.dg.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.clearcut.ep) r15, (boolean) r5)
            goto L_0x04d0
        L_0x039c:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
        L_0x03a2:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            com.google.android.gms.internal.clearcut.de r10 = r13.a((int) r7)
            r15.b((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.clearcut.de) r10)
            goto L_0x04d0
        L_0x03b1:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.eb.b(r14, r10)
        L_0x03bd:
            r15.e((int) r9, (long) r10)
            goto L_0x04d0
        L_0x03c2:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r10)
        L_0x03ce:
            r15.f(r9, r8)
            goto L_0x04d0
        L_0x03d3:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.eb.b(r14, r10)
        L_0x03df:
            r15.b((int) r9, (long) r10)
            goto L_0x04d0
        L_0x03e4:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r10)
        L_0x03f0:
            r15.a((int) r9, (int) r8)
            goto L_0x04d0
        L_0x03f5:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r10)
        L_0x0401:
            r15.b((int) r9, (int) r8)
            goto L_0x04d0
        L_0x0406:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r10)
        L_0x0412:
            r15.e((int) r9, (int) r8)
            goto L_0x04d0
        L_0x0417:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
        L_0x041d:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            com.google.android.gms.internal.clearcut.ab r8 = (com.google.android.gms.internal.clearcut.ab) r8
            r15.a((int) r9, (com.google.android.gms.internal.clearcut.ab) r8)
            goto L_0x04d0
        L_0x042a:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
        L_0x0430:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            com.google.android.gms.internal.clearcut.de r10 = r13.a((int) r7)
            r15.a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.clearcut.de) r10)
            goto L_0x04d0
        L_0x043f:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
        L_0x0445:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.eb.f(r14, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.clearcut.ep) r15)
            goto L_0x04d0
        L_0x0450:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.clearcut.eb.c(r14, r10)
        L_0x045c:
            r15.a((int) r9, (boolean) r8)
            goto L_0x04d0
        L_0x0461:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r10)
        L_0x046d:
            r15.d((int) r9, (int) r8)
            goto L_0x04d0
        L_0x0471:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.eb.b(r14, r10)
        L_0x047d:
            r15.d((int) r9, (long) r10)
            goto L_0x04d0
        L_0x0481:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r10)
        L_0x048d:
            r15.c((int) r9, (int) r8)
            goto L_0x04d0
        L_0x0491:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.eb.b(r14, r10)
        L_0x049d:
            r15.c((int) r9, (long) r10)
            goto L_0x04d0
        L_0x04a1:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.eb.b(r14, r10)
        L_0x04ad:
            r15.a((int) r9, (long) r10)
            goto L_0x04d0
        L_0x04b1:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.clearcut.eb.d(r14, r10)
        L_0x04bd:
            r15.a((int) r9, (float) r8)
            goto L_0x04d0
        L_0x04c1:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x04d0
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.clearcut.eb.e(r14, r10)
        L_0x04cd:
            r15.a((int) r9, (double) r10)
        L_0x04d0:
            int r7 = r7 + -4
            goto L_0x0054
        L_0x04d4:
            if (r1 == 0) goto L_0x04eb
            com.google.android.gms.internal.clearcut.as<?> r14 = r13.r
            r14.a((com.google.android.gms.internal.clearcut.ep) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x04e9
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x04d4
        L_0x04e9:
            r1 = r3
            goto L_0x04d4
        L_0x04eb:
            return
        L_0x04ec:
            boolean r0 = r13.j
            if (r0 == 0) goto L_0x09b1
            boolean r0 = r13.f9253h
            if (r0 == 0) goto L_0x050d
            com.google.android.gms.internal.clearcut.as<?> r0 = r13.r
            com.google.android.gms.internal.clearcut.aw r0 = r0.a((java.lang.Object) r14)
            com.google.android.gms.internal.clearcut.dh<FieldDescriptorType, java.lang.Object> r1 = r0.f9169a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x050d
            java.util.Iterator r0 = r0.c()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x050f
        L_0x050d:
            r0 = r3
            r1 = r0
        L_0x050f:
            int[] r7 = r13.f9247b
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x0514:
            if (r1 >= r7) goto L_0x0994
            int r9 = r13.c((int) r1)
            int[] r10 = r13.f9247b
            r10 = r10[r1]
        L_0x051e:
            if (r8 == 0) goto L_0x053c
            com.google.android.gms.internal.clearcut.as<?> r11 = r13.r
            int r11 = r11.a((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x053c
            com.google.android.gms.internal.clearcut.as<?> r11 = r13.r
            r11.a((com.google.android.gms.internal.clearcut.ep) r15, (java.util.Map.Entry<?, ?>) r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x053a
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x051e
        L_0x053a:
            r8 = r3
            goto L_0x051e
        L_0x053c:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0981;
                case 1: goto L_0x0971;
                case 2: goto L_0x0961;
                case 3: goto L_0x0951;
                case 4: goto L_0x0941;
                case 5: goto L_0x0931;
                case 6: goto L_0x0921;
                case 7: goto L_0x0910;
                case 8: goto L_0x08ff;
                case 9: goto L_0x08ea;
                case 10: goto L_0x08d7;
                case 11: goto L_0x08c6;
                case 12: goto L_0x08b5;
                case 13: goto L_0x08a4;
                case 14: goto L_0x0893;
                case 15: goto L_0x0882;
                case 16: goto L_0x0871;
                case 17: goto L_0x085c;
                case 18: goto L_0x084b;
                case 19: goto L_0x083a;
                case 20: goto L_0x0829;
                case 21: goto L_0x0818;
                case 22: goto L_0x0807;
                case 23: goto L_0x07f6;
                case 24: goto L_0x07e5;
                case 25: goto L_0x07d4;
                case 26: goto L_0x07c3;
                case 27: goto L_0x07ae;
                case 28: goto L_0x079d;
                case 29: goto L_0x078c;
                case 30: goto L_0x077b;
                case 31: goto L_0x076a;
                case 32: goto L_0x0759;
                case 33: goto L_0x0748;
                case 34: goto L_0x0737;
                case 35: goto L_0x0726;
                case 36: goto L_0x0715;
                case 37: goto L_0x0704;
                case 38: goto L_0x06f3;
                case 39: goto L_0x06e2;
                case 40: goto L_0x06d1;
                case 41: goto L_0x06c0;
                case 42: goto L_0x06af;
                case 43: goto L_0x069e;
                case 44: goto L_0x068d;
                case 45: goto L_0x067c;
                case 46: goto L_0x066b;
                case 47: goto L_0x065a;
                case 48: goto L_0x0649;
                case 49: goto L_0x0634;
                case 50: goto L_0x0629;
                case 51: goto L_0x061b;
                case 52: goto L_0x060d;
                case 53: goto L_0x05ff;
                case 54: goto L_0x05f1;
                case 55: goto L_0x05e3;
                case 56: goto L_0x05d5;
                case 57: goto L_0x05c7;
                case 58: goto L_0x05b9;
                case 59: goto L_0x05b1;
                case 60: goto L_0x05a9;
                case 61: goto L_0x05a1;
                case 62: goto L_0x0593;
                case 63: goto L_0x0585;
                case 64: goto L_0x0577;
                case 65: goto L_0x0569;
                case 66: goto L_0x055b;
                case 67: goto L_0x054d;
                case 68: goto L_0x0545;
                default: goto L_0x0543;
            }
        L_0x0543:
            goto L_0x0990
        L_0x0545:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            goto L_0x0862
        L_0x054d:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            goto L_0x087d
        L_0x055b:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            goto L_0x088e
        L_0x0569:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            goto L_0x089f
        L_0x0577:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            goto L_0x08b0
        L_0x0585:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            goto L_0x08c1
        L_0x0593:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            goto L_0x08d2
        L_0x05a1:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            goto L_0x08dd
        L_0x05a9:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            goto L_0x08f0
        L_0x05b1:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            goto L_0x0905
        L_0x05b9:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = f(r14, r11)
            goto L_0x091c
        L_0x05c7:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            goto L_0x092d
        L_0x05d5:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            goto L_0x093d
        L_0x05e3:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            goto L_0x094d
        L_0x05f1:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            goto L_0x095d
        L_0x05ff:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            goto L_0x096d
        L_0x060d:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = c(r14, r11)
            goto L_0x097d
        L_0x061b:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = b(r14, (long) r11)
            goto L_0x098d
        L_0x0629:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            r13.a((com.google.android.gms.internal.clearcut.ep) r15, (int) r10, (java.lang.Object) r9)
            goto L_0x0990
        L_0x0634:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.de r11 = r13.a((int) r1)
            com.google.android.gms.internal.clearcut.dg.b((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.clearcut.ep) r15, (com.google.android.gms.internal.clearcut.de) r11)
            goto L_0x0990
        L_0x0649:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.e(r10, r9, r15, r4)
            goto L_0x0990
        L_0x065a:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.j(r10, r9, r15, r4)
            goto L_0x0990
        L_0x066b:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.g(r10, r9, r15, r4)
            goto L_0x0990
        L_0x067c:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.l(r10, r9, r15, r4)
            goto L_0x0990
        L_0x068d:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.m(r10, r9, r15, r4)
            goto L_0x0990
        L_0x069e:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.i(r10, r9, r15, r4)
            goto L_0x0990
        L_0x06af:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.n(r10, r9, r15, r4)
            goto L_0x0990
        L_0x06c0:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.k(r10, r9, r15, r4)
            goto L_0x0990
        L_0x06d1:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.f(r10, r9, r15, r4)
            goto L_0x0990
        L_0x06e2:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.h(r10, r9, r15, r4)
            goto L_0x0990
        L_0x06f3:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.d(r10, r9, r15, r4)
            goto L_0x0990
        L_0x0704:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.c(r10, r9, r15, r4)
            goto L_0x0990
        L_0x0715:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.clearcut.ep) r15, (boolean) r4)
            goto L_0x0990
        L_0x0726:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.clearcut.ep) r15, (boolean) r4)
            goto L_0x0990
        L_0x0737:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.e(r10, r9, r15, r5)
            goto L_0x0990
        L_0x0748:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.j(r10, r9, r15, r5)
            goto L_0x0990
        L_0x0759:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.g(r10, r9, r15, r5)
            goto L_0x0990
        L_0x076a:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.l(r10, r9, r15, r5)
            goto L_0x0990
        L_0x077b:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.m(r10, r9, r15, r5)
            goto L_0x0990
        L_0x078c:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.i(r10, r9, r15, r5)
            goto L_0x0990
        L_0x079d:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.b((int) r10, (java.util.List<com.google.android.gms.internal.clearcut.ab>) r9, (com.google.android.gms.internal.clearcut.ep) r15)
            goto L_0x0990
        L_0x07ae:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.de r11 = r13.a((int) r1)
            com.google.android.gms.internal.clearcut.dg.a((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.clearcut.ep) r15, (com.google.android.gms.internal.clearcut.de) r11)
            goto L_0x0990
        L_0x07c3:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.a((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.clearcut.ep) r15)
            goto L_0x0990
        L_0x07d4:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.n(r10, r9, r15, r5)
            goto L_0x0990
        L_0x07e5:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.k(r10, r9, r15, r5)
            goto L_0x0990
        L_0x07f6:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.f(r10, r9, r15, r5)
            goto L_0x0990
        L_0x0807:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.h(r10, r9, r15, r5)
            goto L_0x0990
        L_0x0818:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.d(r10, r9, r15, r5)
            goto L_0x0990
        L_0x0829:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.c(r10, r9, r15, r5)
            goto L_0x0990
        L_0x083a:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.clearcut.ep) r15, (boolean) r5)
            goto L_0x0990
        L_0x084b:
            int[] r10 = r13.f9247b
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.clearcut.ep) r15, (boolean) r5)
            goto L_0x0990
        L_0x085c:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
        L_0x0862:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            com.google.android.gms.internal.clearcut.de r11 = r13.a((int) r1)
            r15.b((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.clearcut.de) r11)
            goto L_0x0990
        L_0x0871:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.eb.b(r14, r11)
        L_0x087d:
            r15.e((int) r10, (long) r11)
            goto L_0x0990
        L_0x0882:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r11)
        L_0x088e:
            r15.f(r10, r9)
            goto L_0x0990
        L_0x0893:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.eb.b(r14, r11)
        L_0x089f:
            r15.b((int) r10, (long) r11)
            goto L_0x0990
        L_0x08a4:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r11)
        L_0x08b0:
            r15.a((int) r10, (int) r9)
            goto L_0x0990
        L_0x08b5:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r11)
        L_0x08c1:
            r15.b((int) r10, (int) r9)
            goto L_0x0990
        L_0x08c6:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r11)
        L_0x08d2:
            r15.e((int) r10, (int) r9)
            goto L_0x0990
        L_0x08d7:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
        L_0x08dd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            com.google.android.gms.internal.clearcut.ab r9 = (com.google.android.gms.internal.clearcut.ab) r9
            r15.a((int) r10, (com.google.android.gms.internal.clearcut.ab) r9)
            goto L_0x0990
        L_0x08ea:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
        L_0x08f0:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            com.google.android.gms.internal.clearcut.de r11 = r13.a((int) r1)
            r15.a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.clearcut.de) r11)
            goto L_0x0990
        L_0x08ff:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
        L_0x0905:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.eb.f(r14, r11)
            a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.clearcut.ep) r15)
            goto L_0x0990
        L_0x0910:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.clearcut.eb.c(r14, r11)
        L_0x091c:
            r15.a((int) r10, (boolean) r9)
            goto L_0x0990
        L_0x0921:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r11)
        L_0x092d:
            r15.d((int) r10, (int) r9)
            goto L_0x0990
        L_0x0931:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.eb.b(r14, r11)
        L_0x093d:
            r15.d((int) r10, (long) r11)
            goto L_0x0990
        L_0x0941:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.eb.a((java.lang.Object) r14, (long) r11)
        L_0x094d:
            r15.c((int) r10, (int) r9)
            goto L_0x0990
        L_0x0951:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.eb.b(r14, r11)
        L_0x095d:
            r15.c((int) r10, (long) r11)
            goto L_0x0990
        L_0x0961:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.eb.b(r14, r11)
        L_0x096d:
            r15.a((int) r10, (long) r11)
            goto L_0x0990
        L_0x0971:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.clearcut.eb.d(r14, r11)
        L_0x097d:
            r15.a((int) r10, (float) r9)
            goto L_0x0990
        L_0x0981:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0990
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.clearcut.eb.e(r14, r11)
        L_0x098d:
            r15.a((int) r10, (double) r11)
        L_0x0990:
            int r1 = r1 + 4
            goto L_0x0514
        L_0x0994:
            if (r8 == 0) goto L_0x09ab
            com.google.android.gms.internal.clearcut.as<?> r1 = r13.r
            r1.a((com.google.android.gms.internal.clearcut.ep) r15, (java.util.Map.Entry<?, ?>) r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x09a9
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0994
        L_0x09a9:
            r8 = r3
            goto L_0x0994
        L_0x09ab:
            com.google.android.gms.internal.clearcut.dv<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.gms.internal.clearcut.ep) r15)
            return
        L_0x09b1:
            r13.b(r14, (com.google.android.gms.internal.clearcut.ep) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.a(java.lang.Object, com.google.android.gms.internal.clearcut.ep):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0280, code lost:
        com.google.android.gms.internal.clearcut.dg.j(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0290, code lost:
        com.google.android.gms.internal.clearcut.dg.g(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02a0, code lost:
        com.google.android.gms.internal.clearcut.dg.l(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02b0, code lost:
        com.google.android.gms.internal.clearcut.dg.m(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02c0, code lost:
        com.google.android.gms.internal.clearcut.dg.i(r4, (java.util.List) r8.getObject(r1, r12), r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0479, code lost:
        r5 = r5 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0276, code lost:
        com.google.android.gms.internal.clearcut.dg.e(r4, r9, r2, r14);
     */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(T r19, com.google.android.gms.internal.clearcut.ep r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.f9253h
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.clearcut.as<?> r3 = r0.r
            com.google.android.gms.internal.clearcut.aw r3 = r3.a((java.lang.Object) r1)
            com.google.android.gms.internal.clearcut.dh<FieldDescriptorType, java.lang.Object> r5 = r3.f9169a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.c()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.f9247b
            int r7 = r7.length
            sun.misc.Unsafe r8 = f9246a
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x047d
            int r12 = r0.c((int) r5)
            int[] r13 = r0.f9247b
            r14 = r13[r5]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.j
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x0062
            r4 = 17
            if (r15 > r4) goto L_0x0062
            int r4 = r5 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            r17 = r10
            if (r13 == r6) goto L_0x0058
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            goto L_0x0059
        L_0x0058:
            r13 = r6
        L_0x0059:
            int r4 = r4 >>> 20
            r6 = 1
            int r9 = r6 << r4
            r6 = r13
            r10 = r17
            goto L_0x0067
        L_0x0062:
            r17 = r10
            r10 = r17
            r9 = 0
        L_0x0067:
            if (r10 == 0) goto L_0x0086
            com.google.android.gms.internal.clearcut.as<?> r4 = r0.r
            int r4 = r4.a((java.util.Map.Entry<?, ?>) r10)
            if (r4 > r14) goto L_0x0086
            com.google.android.gms.internal.clearcut.as<?> r4 = r0.r
            r4.a((com.google.android.gms.internal.clearcut.ep) r2, (java.util.Map.Entry<?, ?>) r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0084
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0067
        L_0x0084:
            r10 = 0
            goto L_0x0067
        L_0x0086:
            r4 = r12 & r16
            long r12 = (long) r4
            switch(r15) {
                case 0: goto L_0x046d;
                case 1: goto L_0x0460;
                case 2: goto L_0x0453;
                case 3: goto L_0x0446;
                case 4: goto L_0x0439;
                case 5: goto L_0x042c;
                case 6: goto L_0x041f;
                case 7: goto L_0x0412;
                case 8: goto L_0x0404;
                case 9: goto L_0x03f2;
                case 10: goto L_0x03e2;
                case 11: goto L_0x03d4;
                case 12: goto L_0x03c6;
                case 13: goto L_0x03b8;
                case 14: goto L_0x03aa;
                case 15: goto L_0x039c;
                case 16: goto L_0x038e;
                case 17: goto L_0x037c;
                case 18: goto L_0x036c;
                case 19: goto L_0x035c;
                case 20: goto L_0x034c;
                case 21: goto L_0x033c;
                case 22: goto L_0x032c;
                case 23: goto L_0x031c;
                case 24: goto L_0x030c;
                case 25: goto L_0x02fc;
                case 26: goto L_0x02ed;
                case 27: goto L_0x02da;
                case 28: goto L_0x02cb;
                case 29: goto L_0x02bb;
                case 30: goto L_0x02ab;
                case 31: goto L_0x029b;
                case 32: goto L_0x028b;
                case 33: goto L_0x027b;
                case 34: goto L_0x026b;
                case 35: goto L_0x025b;
                case 36: goto L_0x024b;
                case 37: goto L_0x023b;
                case 38: goto L_0x022b;
                case 39: goto L_0x021b;
                case 40: goto L_0x020b;
                case 41: goto L_0x01fb;
                case 42: goto L_0x01eb;
                case 43: goto L_0x01e4;
                case 44: goto L_0x01dd;
                case 45: goto L_0x01d6;
                case 46: goto L_0x01cf;
                case 47: goto L_0x01c8;
                case 48: goto L_0x01bb;
                case 49: goto L_0x01a8;
                case 50: goto L_0x019f;
                case 51: goto L_0x0190;
                case 52: goto L_0x0181;
                case 53: goto L_0x0172;
                case 54: goto L_0x0163;
                case 55: goto L_0x0154;
                case 56: goto L_0x0145;
                case 57: goto L_0x0136;
                case 58: goto L_0x0127;
                case 59: goto L_0x0118;
                case 60: goto L_0x0105;
                case 61: goto L_0x00f5;
                case 62: goto L_0x00e7;
                case 63: goto L_0x00d9;
                case 64: goto L_0x00cb;
                case 65: goto L_0x00bd;
                case 66: goto L_0x00af;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008f;
                default: goto L_0x008c;
            }
        L_0x008c:
            r15 = 0
            goto L_0x0479
        L_0x008f:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.de r9 = r0.a((int) r5)
            r2.b((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.de) r9)
            goto L_0x008c
        L_0x00a1:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.e((int) r14, (long) r12)
            goto L_0x008c
        L_0x00af:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.f(r14, r4)
            goto L_0x008c
        L_0x00bd:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.b((int) r14, (long) r12)
            goto L_0x008c
        L_0x00cb:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.a((int) r14, (int) r4)
            goto L_0x008c
        L_0x00d9:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.b((int) r14, (int) r4)
            goto L_0x008c
        L_0x00e7:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.e((int) r14, (int) r4)
            goto L_0x008c
        L_0x00f5:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.ab r4 = (com.google.android.gms.internal.clearcut.ab) r4
            r2.a((int) r14, (com.google.android.gms.internal.clearcut.ab) r4)
            goto L_0x008c
        L_0x0105:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.de r9 = r0.a((int) r5)
            r2.a((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.de) r9)
            goto L_0x008c
        L_0x0118:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            a((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.ep) r2)
            goto L_0x008c
        L_0x0127:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            boolean r4 = f(r1, r12)
            r2.a((int) r14, (boolean) r4)
            goto L_0x008c
        L_0x0136:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.d((int) r14, (int) r4)
            goto L_0x008c
        L_0x0145:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.d((int) r14, (long) r12)
            goto L_0x008c
        L_0x0154:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.c((int) r14, (int) r4)
            goto L_0x008c
        L_0x0163:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.c((int) r14, (long) r12)
            goto L_0x008c
        L_0x0172:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.a((int) r14, (long) r12)
            goto L_0x008c
        L_0x0181:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            float r4 = c(r1, r12)
            r2.a((int) r14, (float) r4)
            goto L_0x008c
        L_0x0190:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            double r12 = b(r1, (long) r12)
            r2.a((int) r14, (double) r12)
            goto L_0x008c
        L_0x019f:
            java.lang.Object r4 = r8.getObject(r1, r12)
            r0.a((com.google.android.gms.internal.clearcut.ep) r2, (int) r14, (java.lang.Object) r4)
            goto L_0x008c
        L_0x01a8:
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.de r12 = r0.a((int) r5)
            com.google.android.gms.internal.clearcut.dg.b((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.clearcut.ep) r2, (com.google.android.gms.internal.clearcut.de) r12)
            goto L_0x008c
        L_0x01bb:
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 1
            goto L_0x0276
        L_0x01c8:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            goto L_0x0280
        L_0x01cf:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            goto L_0x0290
        L_0x01d6:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            goto L_0x02a0
        L_0x01dd:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            goto L_0x02b0
        L_0x01e4:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            goto L_0x02c0
        L_0x01eb:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.n(r4, r9, r2, r14)
            goto L_0x008c
        L_0x01fb:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.k(r4, r9, r2, r14)
            goto L_0x008c
        L_0x020b:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.f(r4, r9, r2, r14)
            goto L_0x008c
        L_0x021b:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.h(r4, r9, r2, r14)
            goto L_0x008c
        L_0x022b:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.d(r4, r9, r2, r14)
            goto L_0x008c
        L_0x023b:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.c(r4, r9, r2, r14)
            goto L_0x008c
        L_0x024b:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.clearcut.ep) r2, (boolean) r14)
            goto L_0x008c
        L_0x025b:
            r14 = 1
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.clearcut.ep) r2, (boolean) r14)
            goto L_0x008c
        L_0x026b:
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 0
        L_0x0276:
            com.google.android.gms.internal.clearcut.dg.e(r4, r9, r2, r14)
            goto L_0x008c
        L_0x027b:
            r14 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
        L_0x0280:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.j(r4, r9, r2, r14)
            goto L_0x008c
        L_0x028b:
            r14 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
        L_0x0290:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.g(r4, r9, r2, r14)
            goto L_0x008c
        L_0x029b:
            r14 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
        L_0x02a0:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.l(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02ab:
            r14 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
        L_0x02b0:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.m(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02bb:
            r14 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
        L_0x02c0:
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.i(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02cb:
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.b((int) r4, (java.util.List<com.google.android.gms.internal.clearcut.ab>) r9, (com.google.android.gms.internal.clearcut.ep) r2)
            goto L_0x008c
        L_0x02da:
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.de r12 = r0.a((int) r5)
            com.google.android.gms.internal.clearcut.dg.a((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.clearcut.ep) r2, (com.google.android.gms.internal.clearcut.de) r12)
            goto L_0x008c
        L_0x02ed:
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.a((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.clearcut.ep) r2)
            goto L_0x008c
        L_0x02fc:
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.clearcut.dg.n(r4, r9, r2, r15)
            goto L_0x0479
        L_0x030c:
            r15 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.k(r4, r9, r2, r15)
            goto L_0x0479
        L_0x031c:
            r15 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.f(r4, r9, r2, r15)
            goto L_0x0479
        L_0x032c:
            r15 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.h(r4, r9, r2, r15)
            goto L_0x0479
        L_0x033c:
            r15 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.d(r4, r9, r2, r15)
            goto L_0x0479
        L_0x034c:
            r15 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.c(r4, r9, r2, r15)
            goto L_0x0479
        L_0x035c:
            r15 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.clearcut.ep) r2, (boolean) r15)
            goto L_0x0479
        L_0x036c:
            r15 = 0
            int[] r4 = r0.f9247b
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.dg.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.clearcut.ep) r2, (boolean) r15)
            goto L_0x0479
        L_0x037c:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.de r9 = r0.a((int) r5)
            r2.b((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.de) r9)
            goto L_0x0479
        L_0x038e:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.e((int) r14, (long) r12)
            goto L_0x0479
        L_0x039c:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.f(r14, r4)
            goto L_0x0479
        L_0x03aa:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.b((int) r14, (long) r12)
            goto L_0x0479
        L_0x03b8:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.a((int) r14, (int) r4)
            goto L_0x0479
        L_0x03c6:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.b((int) r14, (int) r4)
            goto L_0x0479
        L_0x03d4:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.e((int) r14, (int) r4)
            goto L_0x0479
        L_0x03e2:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.ab r4 = (com.google.android.gms.internal.clearcut.ab) r4
            r2.a((int) r14, (com.google.android.gms.internal.clearcut.ab) r4)
            goto L_0x0479
        L_0x03f2:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.de r9 = r0.a((int) r5)
            r2.a((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.de) r9)
            goto L_0x0479
        L_0x0404:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            java.lang.Object r4 = r8.getObject(r1, r12)
            a((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.ep) r2)
            goto L_0x0479
        L_0x0412:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            boolean r4 = com.google.android.gms.internal.clearcut.eb.c(r1, r12)
            r2.a((int) r14, (boolean) r4)
            goto L_0x0479
        L_0x041f:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.d((int) r14, (int) r4)
            goto L_0x0479
        L_0x042c:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.d((int) r14, (long) r12)
            goto L_0x0479
        L_0x0439:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            int r4 = r8.getInt(r1, r12)
            r2.c((int) r14, (int) r4)
            goto L_0x0479
        L_0x0446:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.c((int) r14, (long) r12)
            goto L_0x0479
        L_0x0453:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            long r12 = r8.getLong(r1, r12)
            r2.a((int) r14, (long) r12)
            goto L_0x0479
        L_0x0460:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            float r4 = com.google.android.gms.internal.clearcut.eb.d(r1, r12)
            r2.a((int) r14, (float) r4)
            goto L_0x0479
        L_0x046d:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x0479
            double r12 = com.google.android.gms.internal.clearcut.eb.e(r1, r12)
            r2.a((int) r14, (double) r12)
        L_0x0479:
            int r5 = r5 + 4
            goto L_0x002e
        L_0x047d:
            r17 = r10
            r4 = r17
        L_0x0481:
            if (r4 == 0) goto L_0x0497
            com.google.android.gms.internal.clearcut.as<?> r5 = r0.r
            r5.a((com.google.android.gms.internal.clearcut.ep) r2, (java.util.Map.Entry<?, ?>) r4)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0495
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x0481
        L_0x0495:
            r4 = 0
            goto L_0x0481
        L_0x0497:
            com.google.android.gms.internal.clearcut.dv<?, ?> r3 = r0.q
            a(r3, r1, (com.google.android.gms.internal.clearcut.ep) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.cq.b(java.lang.Object, com.google.android.gms.internal.clearcut.ep):void");
    }

    private final <K, V, UT, UB> UB a(int i2, Map<K, V> map, bj<?> bjVar, UB ub, dv<UT, UB> dvVar) {
        cf<?, ?> b2 = this.s.b();
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (bjVar.a(((Integer) next.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = dvVar.a();
                }
                ag zzk = ab.zzk(ce.a(b2, next.getKey(), next.getValue()));
                try {
                    ce.a(zzk.f9124a, b2, next.getKey(), next.getValue());
                    dvVar.a(ub, i2, zzk.a());
                    it2.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }
}
