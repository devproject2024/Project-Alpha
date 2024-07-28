package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.mp4.a;
import com.google.android.exoplayer2.extractor.mp4.d;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.v;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f32168a = ae.h("vide");

    /* renamed from: b  reason: collision with root package name */
    private static final int f32169b = ae.h("soun");

    /* renamed from: c  reason: collision with root package name */
    private static final int f32170c = ae.h(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);

    /* renamed from: d  reason: collision with root package name */
    private static final int f32171d = ae.h("sbtl");

    /* renamed from: e  reason: collision with root package name */
    private static final int f32172e = ae.h("subt");

    /* renamed from: f  reason: collision with root package name */
    private static final int f32173f = ae.h("clcp");

    /* renamed from: g  reason: collision with root package name */
    private static final int f32174g = ae.h("meta");

    /* renamed from: h  reason: collision with root package name */
    private static final int f32175h = ae.h("mdta");

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f32176i = ae.c("OpusHead");

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.b$b  reason: collision with other inner class name */
    interface C0543b {
        int a();

        int b();

        boolean c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
        if (r12 == 0) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.extractor.mp4.j a(com.google.android.exoplayer2.extractor.mp4.a.C0542a r26, com.google.android.exoplayer2.extractor.mp4.a.b r27, long r28, com.google.android.exoplayer2.drm.DrmInitData r30, boolean r31, boolean r32) throws com.google.android.exoplayer2.v {
        /*
            r0 = r26
            int r1 = com.google.android.exoplayer2.extractor.mp4.a.T
            com.google.android.exoplayer2.extractor.mp4.a$a r1 = r0.e(r1)
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.af
            com.google.android.exoplayer2.extractor.mp4.a$b r2 = r1.d(r2)
            com.google.android.exoplayer2.g.r r2 = r2.bh
            int r2 = a((com.google.android.exoplayer2.g.r) r2)
            int r3 = f32169b
            r4 = -1
            r6 = 4
            if (r2 != r3) goto L_0x001c
            r9 = 1
            goto L_0x003e
        L_0x001c:
            int r3 = f32168a
            if (r2 != r3) goto L_0x0023
            r2 = 2
            r9 = 2
            goto L_0x003e
        L_0x0023:
            int r3 = f32170c
            if (r2 == r3) goto L_0x003c
            int r3 = f32171d
            if (r2 == r3) goto L_0x003c
            int r3 = f32172e
            if (r2 == r3) goto L_0x003c
            int r3 = f32173f
            if (r2 != r3) goto L_0x0034
            goto L_0x003c
        L_0x0034:
            int r3 = f32174g
            if (r2 != r3) goto L_0x003a
            r9 = 4
            goto L_0x003e
        L_0x003a:
            r9 = -1
            goto L_0x003e
        L_0x003c:
            r2 = 3
            r9 = 3
        L_0x003e:
            r2 = 0
            if (r9 != r4) goto L_0x0042
            return r2
        L_0x0042:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.ab
            com.google.android.exoplayer2.extractor.mp4.a$b r3 = r0.d(r3)
            com.google.android.exoplayer2.g.r r3 = r3.bh
            r7 = 8
            r3.c(r7)
            int r8 = r3.i()
            int r8 = com.google.android.exoplayer2.extractor.mp4.a.a(r8)
            r10 = 16
            if (r8 != 0) goto L_0x005e
            r11 = 8
            goto L_0x0060
        L_0x005e:
            r11 = 16
        L_0x0060:
            r3.d(r11)
            int r11 = r3.i()
            r3.d(r6)
            int r12 = r3.f32567b
            if (r8 != 0) goto L_0x0070
            r13 = 4
            goto L_0x0072
        L_0x0070:
            r13 = 8
        L_0x0072:
            r15 = 0
        L_0x0073:
            if (r15 >= r13) goto L_0x0083
            byte[] r5 = r3.f32566a
            int r17 = r12 + r15
            byte r5 = r5[r17]
            if (r5 == r4) goto L_0x0080
            r16 = 0
            goto L_0x0085
        L_0x0080:
            int r15 = r15 + 1
            goto L_0x0073
        L_0x0083:
            r16 = 1
        L_0x0085:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r16 == 0) goto L_0x0091
            r3.d(r13)
        L_0x008f:
            r12 = r4
            goto L_0x00a3
        L_0x0091:
            if (r8 != 0) goto L_0x0098
            long r12 = r3.g()
            goto L_0x009c
        L_0x0098:
            long r12 = r3.p()
        L_0x009c:
            r15 = 0
            int r8 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r8 != 0) goto L_0x00a3
            goto L_0x008f
        L_0x00a3:
            r3.d(r10)
            int r8 = r3.i()
            int r15 = r3.i()
            r3.d(r6)
            int r6 = r3.i()
            int r3 = r3.i()
            r10 = 65536(0x10000, float:9.18355E-41)
            r14 = -65536(0xffffffffffff0000, float:NaN)
            if (r8 != 0) goto L_0x00c8
            if (r15 != r10) goto L_0x00c8
            if (r6 != r14) goto L_0x00c8
            if (r3 != 0) goto L_0x00c8
            r14 = 90
            goto L_0x00df
        L_0x00c8:
            if (r8 != 0) goto L_0x00d3
            if (r15 != r14) goto L_0x00d3
            if (r6 != r10) goto L_0x00d3
            if (r3 != 0) goto L_0x00d3
            r14 = 270(0x10e, float:3.78E-43)
            goto L_0x00df
        L_0x00d3:
            if (r8 != r14) goto L_0x00de
            if (r15 != 0) goto L_0x00de
            if (r6 != 0) goto L_0x00de
            if (r3 != r14) goto L_0x00de
            r14 = 180(0xb4, float:2.52E-43)
            goto L_0x00df
        L_0x00de:
            r14 = 0
        L_0x00df:
            com.google.android.exoplayer2.extractor.mp4.b$f r3 = new com.google.android.exoplayer2.extractor.mp4.b$f
            r3.<init>(r11, r12, r14)
            int r6 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x00ed
            long r10 = r3.f32199b
            r6 = r27
            goto L_0x00f1
        L_0x00ed:
            r6 = r27
            r10 = r28
        L_0x00f1:
            com.google.android.exoplayer2.g.r r6 = r6.bh
            r6.c(r7)
            int r8 = r6.i()
            int r8 = com.google.android.exoplayer2.extractor.mp4.a.a(r8)
            if (r8 != 0) goto L_0x0103
            r8 = 8
            goto L_0x0105
        L_0x0103:
            r8 = 16
        L_0x0105:
            r6.d(r8)
            long r18 = r6.g()
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0111
            goto L_0x011a
        L_0x0111:
            r12 = 1000000(0xf4240, double:4.940656E-318)
            r14 = r18
            long r4 = com.google.android.exoplayer2.g.ae.b((long) r10, (long) r12, (long) r14)
        L_0x011a:
            r14 = r4
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.U
            com.google.android.exoplayer2.extractor.mp4.a$a r4 = r1.e(r4)
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.V
            com.google.android.exoplayer2.extractor.mp4.a$a r4 = r4.e(r5)
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.ae
            com.google.android.exoplayer2.extractor.mp4.a$b r1 = r1.d(r5)
            com.google.android.exoplayer2.g.r r1 = r1.bh
            r1.c(r7)
            int r5 = r1.i()
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.a(r5)
            if (r5 != 0) goto L_0x013f
            r6 = 8
            goto L_0x0141
        L_0x013f:
            r6 = 16
        L_0x0141:
            r1.d(r6)
            long r10 = r1.g()
            if (r5 != 0) goto L_0x014b
            r7 = 4
        L_0x014b:
            r1.d(r7)
            int r1 = r1.d()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r1 >> 10
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r5.append(r6)
            int r6 = r1 >> 5
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r5.append(r6)
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            java.lang.Long r5 = java.lang.Long.valueOf(r10)
            android.util.Pair r1 = android.util.Pair.create(r5, r1)
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.ag
            com.google.android.exoplayer2.extractor.mp4.a$b r4 = r4.d(r5)
            com.google.android.exoplayer2.g.r r4 = r4.bh
            int r5 = r3.f32198a
            int r6 = r3.f32200c
            java.lang.Object r7 = r1.second
            r23 = r7
            java.lang.String r23 = (java.lang.String) r23
            r20 = r4
            r21 = r5
            r22 = r6
            r24 = r30
            r25 = r32
            com.google.android.exoplayer2.extractor.mp4.b$c r4 = a((com.google.android.exoplayer2.g.r) r20, (int) r21, (int) r22, (java.lang.String) r23, (com.google.android.exoplayer2.drm.DrmInitData) r24, (boolean) r25)
            if (r31 != 0) goto L_0x01b8
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.ac
            com.google.android.exoplayer2.extractor.mp4.a$a r0 = r0.e(r5)
            android.util.Pair r0 = b((com.google.android.exoplayer2.extractor.mp4.a.C0542a) r0)
            java.lang.Object r5 = r0.first
            long[] r5 = (long[]) r5
            java.lang.Object r0 = r0.second
            long[] r0 = (long[]) r0
            r21 = r0
            r20 = r5
            goto L_0x01bc
        L_0x01b8:
            r20 = r2
            r21 = r20
        L_0x01bc:
            com.google.android.exoplayer2.Format r0 = r4.f32187b
            if (r0 != 0) goto L_0x01c1
            return r2
        L_0x01c1:
            com.google.android.exoplayer2.extractor.mp4.j r0 = new com.google.android.exoplayer2.extractor.mp4.j
            int r8 = r3.f32198a
            java.lang.Object r1 = r1.first
            java.lang.Long r1 = (java.lang.Long) r1
            long r10 = r1.longValue()
            com.google.android.exoplayer2.Format r1 = r4.f32187b
            int r2 = r4.f32189d
            com.google.android.exoplayer2.extractor.mp4.k[] r3 = r4.f32186a
            int r4 = r4.f32188c
            r7 = r0
            r12 = r18
            r16 = r1
            r17 = r2
            r18 = r3
            r19 = r4
            r7.<init>(r8, r9, r10, r12, r14, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.b.a(com.google.android.exoplayer2.extractor.mp4.a$a, com.google.android.exoplayer2.extractor.mp4.a$b, long, com.google.android.exoplayer2.drm.DrmInitData, boolean, boolean):com.google.android.exoplayer2.extractor.mp4.j");
    }

    public static m a(j jVar, a.C0542a aVar, k kVar) throws v {
        C0543b bVar;
        boolean z;
        int i2;
        int i3;
        int i4;
        long j;
        int[] iArr;
        long[] jArr;
        int i5;
        int[] iArr2;
        long[] jArr2;
        int[] iArr3;
        int[] iArr4;
        int i6;
        boolean z2;
        int i7;
        boolean z3;
        int i8;
        int i9;
        int i10;
        j jVar2 = jVar;
        a.C0542a aVar2 = aVar;
        k kVar2 = kVar;
        a.b d2 = aVar2.d(a.aD);
        if (d2 != null) {
            bVar = new d(d2);
        } else {
            a.b d3 = aVar2.d(a.aE);
            if (d3 != null) {
                bVar = new e(d3);
            } else {
                throw new v("Track has no sample table size information");
            }
        }
        int a2 = bVar.a();
        if (a2 == 0) {
            return new m(jVar, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        a.b d4 = aVar2.d(a.aF);
        if (d4 == null) {
            d4 = aVar2.d(a.aG);
            z = true;
        } else {
            z = false;
        }
        r rVar = d4.bh;
        r rVar2 = aVar2.d(a.aC).bh;
        r rVar3 = aVar2.d(a.az).bh;
        a.b d5 = aVar2.d(a.aA);
        r rVar4 = d5 != null ? d5.bh : null;
        a.b d6 = aVar2.d(a.aB);
        r rVar5 = d6 != null ? d6.bh : null;
        a aVar3 = new a(rVar2, rVar, z);
        rVar3.c(12);
        int n = rVar3.n() - 1;
        int n2 = rVar3.n();
        int n3 = rVar3.n();
        if (rVar5 != null) {
            rVar5.c(12);
            i2 = rVar5.n();
        } else {
            i2 = 0;
        }
        int i11 = -1;
        if (rVar4 != null) {
            rVar4.c(12);
            i3 = rVar4.n();
            if (i3 > 0) {
                i11 = rVar4.n() - 1;
            } else {
                rVar4 = null;
            }
        } else {
            i3 = 0;
        }
        if (!(bVar.c() && "audio/raw".equals(jVar2.f32262f.f31069i) && n == 0 && i2 == 0 && i3 == 0)) {
            long[] jArr3 = new long[a2];
            int[] iArr5 = new int[a2];
            long[] jArr4 = new long[a2];
            int i12 = i3;
            iArr = new int[a2];
            int i13 = n;
            r rVar6 = rVar3;
            int i14 = n3;
            long j2 = 0;
            long j3 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = i12;
            int i20 = i2;
            int i21 = n2;
            int i22 = i11;
            int i23 = 0;
            while (true) {
                if (i16 >= a2) {
                    i7 = i13;
                    i4 = a2;
                    break;
                }
                long j4 = j3;
                boolean z4 = true;
                while (i23 == 0) {
                    z4 = aVar3.a();
                    if (!z4) {
                        break;
                    }
                    j4 = aVar3.f32180d;
                    i23 = aVar3.f32179c;
                    a2 = a2;
                    i13 = i13;
                }
                i7 = i13;
                int i24 = a2;
                if (!z4) {
                    l.c();
                    jArr3 = Arrays.copyOf(jArr3, i16);
                    iArr5 = Arrays.copyOf(iArr5, i16);
                    jArr4 = Arrays.copyOf(jArr4, i16);
                    iArr = Arrays.copyOf(iArr, i16);
                    i4 = i16;
                    break;
                }
                if (rVar5 != null) {
                    int i25 = i20;
                    while (i17 == 0 && i25 > 0) {
                        i17 = rVar5.n();
                        i18 = rVar5.i();
                        i25--;
                    }
                    i17--;
                    i10 = i25;
                } else {
                    i10 = i20;
                }
                int i26 = i18;
                jArr3[i16] = j4;
                iArr5[i16] = bVar.b();
                i20 = i10;
                if (iArr5[i16] > i15) {
                    i15 = iArr5[i16];
                }
                C0543b bVar2 = bVar;
                jArr4[i16] = j2 + ((long) i26);
                iArr[i16] = rVar4 == null ? 1 : 0;
                if (i16 == i22) {
                    iArr[i16] = 1;
                    i19--;
                    if (i19 > 0) {
                        i22 = rVar4.n() - 1;
                    }
                }
                j2 += (long) i14;
                i21--;
                if (i21 == 0 && i7 > 0) {
                    i21 = rVar6.n();
                    i7--;
                    i14 = rVar6.i();
                }
                i23--;
                i16++;
                i18 = i26;
                i13 = i7;
                bVar = bVar2;
                a2 = i24;
                j3 = j4 + ((long) iArr5[i16]);
            }
            int i27 = i23;
            j = j2 + ((long) i18);
            int i28 = i20;
            while (true) {
                if (i28 <= 0) {
                    z3 = true;
                    break;
                } else if (rVar5.n() != 0) {
                    z3 = false;
                    break;
                } else {
                    rVar5.i();
                    i28--;
                }
            }
            if (i19 == 0 && i21 == 0 && i27 == 0 && i7 == 0) {
                i9 = i17;
                if (i9 == 0 && z3) {
                    i8 = i15;
                    jVar2 = jVar;
                    jArr2 = jArr3;
                    jArr = jArr4;
                    i5 = i8;
                    iArr2 = iArr5;
                }
            } else {
                i9 = i17;
            }
            StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
            i8 = i15;
            jVar2 = jVar;
            sb.append(jVar2.f32257a);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i19);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i21);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i27);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i7);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i9);
            sb.append(!z3 ? ", ctts invalid" : "");
            l.c();
            jArr2 = jArr3;
            jArr = jArr4;
            i5 = i8;
            iArr2 = iArr5;
        } else {
            i4 = a2;
            long[] jArr5 = new long[aVar3.f32177a];
            int[] iArr6 = new int[aVar3.f32177a];
            while (aVar3.a()) {
                jArr5[aVar3.f32178b] = aVar3.f32180d;
                iArr6[aVar3.f32178b] = aVar3.f32179c;
            }
            d.a a3 = d.a(ae.b(jVar2.f32262f.x, jVar2.f32262f.v), jArr5, iArr6, (long) n3);
            jArr2 = a3.f32205a;
            iArr2 = a3.f32206b;
            i5 = a3.f32207c;
            jArr = a3.f32208d;
            iArr = a3.f32209e;
            j = a3.f32210f;
        }
        int i29 = i4;
        long b2 = ae.b(j, 1000000, jVar2.f32259c);
        if (jVar2.f32264h == null || kVar.a()) {
            long[] jArr6 = jArr2;
            ae.a(jArr, jVar2.f32259c);
            return new m(jVar, jArr6, iArr2, i5, jArr, iArr, b2);
        }
        if (jVar2.f32264h.length == 1 && jVar2.f32258b == 1 && jArr.length >= 2) {
            long j5 = jVar2.f32265i[0];
            long b3 = j5 + ae.b(jVar2.f32264h[0], jVar2.f32259c, jVar2.f32260d);
            int length = jArr.length - 1;
            if (jArr[0] <= j5 && j5 < jArr[ae.a(4, 0, length)] && jArr[ae.a(jArr.length - 4, 0, length)] < b3 && b3 <= j) {
                long b4 = ae.b(j5 - jArr[0], (long) jVar2.f32262f.w, jVar2.f32259c);
                long b5 = ae.b(j - b3, (long) jVar2.f32262f.w, jVar2.f32259c);
                if (!(b4 == 0 && b5 == 0) && b4 <= 2147483647L && b5 <= 2147483647L) {
                    int i30 = (int) b4;
                    k kVar3 = kVar;
                    kVar3.f32143a = i30;
                    kVar3.f32144b = (int) b5;
                    ae.a(jArr, jVar2.f32259c);
                    return new m(jVar, jArr2, iArr2, i5, jArr, iArr, ae.b(jVar2.f32264h[0], 1000000, jVar2.f32260d));
                }
            }
        }
        if (jVar2.f32264h.length == 1 && jVar2.f32264h[0] == 0) {
            long j6 = jVar2.f32265i[0];
            for (int i31 = 0; i31 < jArr.length; i31++) {
                jArr[i31] = ae.b(jArr[i31] - j6, 1000000, jVar2.f32259c);
            }
            return new m(jVar, jArr2, iArr2, i5, jArr, iArr, ae.b(j - j6, 1000000, jVar2.f32259c));
        }
        boolean z5 = jVar2.f32258b == 1;
        int[] iArr7 = new int[jVar2.f32264h.length];
        int[] iArr8 = new int[jVar2.f32264h.length];
        int i32 = 0;
        boolean z6 = false;
        int i33 = 0;
        int i34 = 0;
        while (i32 < jVar2.f32264h.length) {
            int[] iArr9 = iArr2;
            int i35 = i5;
            long j7 = jVar2.f32265i[i32];
            if (j7 != -1) {
                i6 = i35;
                boolean z7 = z6;
                int i36 = i33;
                long b6 = ae.b(jVar2.f32264h[i32], jVar2.f32259c, jVar2.f32260d);
                iArr7[i32] = ae.a(jArr, j7, true, true);
                iArr8[i32] = ae.a(jArr, j7 + b6, z5, false);
                while (iArr7[i32] < iArr8[i32] && (iArr[iArr7[i32]] & 1) == 0) {
                    iArr7[i32] = iArr7[i32] + 1;
                }
                i33 = i36 + (iArr8[i32] - iArr7[i32]);
                z2 = z7 | (i34 != iArr7[i32]);
                i34 = iArr8[i32];
            } else {
                z2 = z6;
                int i37 = i33;
                i6 = i35;
            }
            i32++;
            iArr2 = iArr9;
            i5 = i6;
            z6 = z2;
        }
        int[] iArr10 = iArr2;
        int i38 = i5;
        boolean z8 = z6;
        int i39 = 0;
        boolean z9 = true;
        if (i33 == i29) {
            z9 = false;
        }
        boolean z10 = z8 | z9;
        long[] jArr7 = z10 ? new long[i33] : jArr2;
        int[] iArr11 = z10 ? new int[i33] : iArr10;
        int i40 = z10 ? 0 : i38;
        int[] iArr12 = z10 ? new int[i33] : iArr;
        long[] jArr8 = new long[i33];
        long j8 = 0;
        int i41 = 0;
        while (i39 < jVar2.f32264h.length) {
            long j9 = jVar2.f32265i[i39];
            int i42 = iArr7[i39];
            int i43 = iArr8[i39];
            int[] iArr13 = iArr7;
            if (z10) {
                int i44 = i43 - i42;
                System.arraycopy(jArr2, i42, jArr7, i41, i44);
                iArr3 = iArr8;
                iArr4 = iArr10;
                System.arraycopy(iArr4, i42, iArr11, i41, i44);
                System.arraycopy(iArr, i42, iArr12, i41, i44);
            } else {
                iArr3 = iArr8;
                iArr4 = iArr10;
            }
            int i45 = i41;
            int i46 = i40;
            int i47 = i42;
            while (i47 < i43) {
                long[] jArr9 = jArr2;
                long[] jArr10 = jArr7;
                int[] iArr14 = iArr;
                int i48 = i46;
                int i49 = i43;
                jArr8[i45] = ae.b(j8, 1000000, jVar2.f32260d) + ae.b(jArr[i47] - j9, 1000000, jVar2.f32259c);
                i46 = (!z10 || iArr11[i45] <= i48) ? i48 : iArr4[i47];
                i45++;
                i47++;
                jArr2 = jArr9;
                jArr7 = jArr10;
                iArr = iArr14;
                i43 = i49;
            }
            long[] jArr11 = jArr7;
            j8 += jVar2.f32264h[i39];
            i39++;
            jArr2 = jArr2;
            i40 = i46;
            i41 = i45;
            iArr10 = iArr4;
            iArr7 = iArr13;
            iArr8 = iArr3;
            iArr = iArr;
        }
        return new m(jVar, jArr7, iArr11, i40, jArr8, iArr12, ae.b(j8, 1000000, jVar2.f32260d));
    }

    public static Metadata a(a.b bVar, boolean z) {
        if (z) {
            return null;
        }
        r rVar = bVar.bh;
        rVar.c(8);
        while (rVar.b() >= 8) {
            int i2 = rVar.f32567b;
            int i3 = rVar.i();
            if (rVar.i() == a.aO) {
                rVar.c(i2);
                int i4 = i2 + i3;
                rVar.d(12);
                while (true) {
                    if (rVar.f32567b >= i4) {
                        break;
                    }
                    int i5 = rVar.f32567b;
                    int i6 = rVar.i();
                    if (rVar.i() == a.aQ) {
                        rVar.c(i5);
                        int i7 = i5 + i6;
                        rVar.d(8);
                        ArrayList arrayList = new ArrayList();
                        while (rVar.f32567b < i7) {
                            Metadata.Entry a2 = f.a(rVar);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new Metadata((List<? extends Metadata.Entry>) arrayList);
                        }
                    } else {
                        rVar.c(i5 + i6);
                    }
                }
                return null;
            }
            rVar.c(i2 + i3);
        }
        return null;
    }

    public static Metadata a(a.C0542a aVar) {
        a.b d2 = aVar.d(a.af);
        a.b d3 = aVar.d(a.aP);
        a.b d4 = aVar.d(a.aQ);
        if (d2 == null || d3 == null || d4 == null || a(d2.bh) != f32175h) {
            return null;
        }
        r rVar = d3.bh;
        rVar.c(12);
        int i2 = rVar.i();
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = rVar.i();
            rVar.d(4);
            strArr[i3] = rVar.e(i4 - 8);
        }
        r rVar2 = d4.bh;
        rVar2.c(8);
        ArrayList arrayList = new ArrayList();
        while (rVar2.b() > 8) {
            int i5 = rVar2.f32567b;
            int i6 = rVar2.i();
            int i7 = rVar2.i() - 1;
            if (i7 < 0 || i7 >= strArr.length) {
                "Skipped metadata with unknown key index: ".concat(String.valueOf(i7));
                l.c();
            } else {
                MdtaMetadataEntry a2 = f.a(rVar2, i5 + i6, strArr[i7]);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            rVar2.c(i5 + i6);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static int a(r rVar) {
        rVar.c(16);
        return rVar.i();
    }

    /* JADX WARNING: Removed duplicated region for block: B:210:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0332  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.extractor.mp4.b.c a(com.google.android.exoplayer2.g.r r31, int r32, int r33, java.lang.String r34, com.google.android.exoplayer2.drm.DrmInitData r35, boolean r36) throws com.google.android.exoplayer2.v {
        /*
            r10 = r31
            r11 = r35
            r0 = 12
            r10.c(r0)
            int r12 = r31.i()
            com.google.android.exoplayer2.extractor.mp4.b$c r13 = new com.google.android.exoplayer2.extractor.mp4.b$c
            r13.<init>(r12)
            r14 = 0
            r15 = 0
        L_0x0014:
            if (r15 >= r12) goto L_0x035a
            int r9 = r10.f32567b
            int r8 = r31.i()
            r0 = 1
            if (r8 <= 0) goto L_0x0021
            r1 = 1
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            java.lang.String r2 = "childAtomSize should be positive"
            com.google.android.exoplayer2.g.a.a((boolean) r1, (java.lang.Object) r2)
            int r1 = r31.i()
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.f32160b
            r5 = 8
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.f32161c
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.am
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.ay
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.f32163e
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.f32164f
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.s
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.f32166h
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.f32167i
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.k
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.m
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.n
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.o
            if (r1 == r3) goto L_0x0158
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.p
            if (r1 != r3) goto L_0x0067
            goto L_0x0158
        L_0x0067:
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.v
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.an
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.A
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.C
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.E
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.G
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.J
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.H
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.I
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aL
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aM
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.y
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.z
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.w
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aZ
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.ba
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.bb
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.bc
            if (r1 == r2) goto L_0x0141
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.be
            if (r1 != r2) goto L_0x00b5
            goto L_0x0141
        L_0x00b5:
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aw
            if (r1 == r2) goto L_0x00db
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aH
            if (r1 == r2) goto L_0x00db
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aI
            if (r1 == r2) goto L_0x00db
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aJ
            if (r1 == r2) goto L_0x00db
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aK
            if (r1 != r2) goto L_0x00ca
            goto L_0x00db
        L_0x00ca:
            int r0 = com.google.android.exoplayer2.extractor.mp4.a.aY
            if (r1 != r0) goto L_0x0135
            java.lang.String r0 = java.lang.Integer.toString(r32)
            java.lang.String r1 = "application/x-camera-motion"
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a((java.lang.String) r0, (java.lang.String) r1)
            r13.f32187b = r0
            goto L_0x0135
        L_0x00db:
            int r2 = r9 + 8
            int r2 = r2 + r5
            r10.c(r2)
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r6 = com.google.android.exoplayer2.extractor.mp4.a.aw
            java.lang.String r7 = "application/ttml+xml"
            if (r1 != r6) goto L_0x00f3
        L_0x00ec:
            r22 = r2
            r17 = r7
            r24 = 0
            goto L_0x0123
        L_0x00f3:
            int r6 = com.google.android.exoplayer2.extractor.mp4.a.aH
            if (r1 != r6) goto L_0x010c
            int r0 = r8 + -8
            int r0 = r0 - r5
            byte[] r1 = new byte[r0]
            r10.a(r1, r14, r0)
            java.util.List r4 = java.util.Collections.singletonList(r1)
            java.lang.String r7 = "application/x-quicktime-tx3g"
            r22 = r2
            r24 = r4
            r17 = r7
            goto L_0x0123
        L_0x010c:
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.aI
            if (r1 != r5) goto L_0x0113
            java.lang.String r7 = "application/x-mp4-vtt"
            goto L_0x00ec
        L_0x0113:
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.aJ
            if (r1 != r5) goto L_0x011a
            r2 = 0
            goto L_0x00ec
        L_0x011a:
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.aK
            if (r1 != r5) goto L_0x013b
            r13.f32189d = r0
            java.lang.String r7 = "application/x-mp4-cea-608"
            goto L_0x00ec
        L_0x0123:
            java.lang.String r16 = java.lang.Integer.toString(r32)
            r18 = 0
            r20 = -1
            r21 = 0
            r19 = r34
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a((java.lang.String) r16, (java.lang.String) r17, (int) r18, (java.lang.String) r19, (int) r20, (com.google.android.exoplayer2.drm.DrmInitData) r21, (long) r22, (java.util.List<byte[]>) r24)
            r13.f32187b = r0
        L_0x0135:
            r14 = r8
            r17 = r12
            r12 = r9
            goto L_0x034e
        L_0x013b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0141:
            r0 = r31
            r2 = r9
            r3 = r8
            r4 = r32
            r5 = r34
            r6 = r36
            r7 = r35
            r14 = r8
            r8 = r13
            r17 = r12
            r12 = r9
            r9 = r15
            a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x034e
        L_0x0158:
            r14 = r8
            r17 = r12
            r12 = r9
            int r9 = r12 + 8
            int r9 = r9 + r5
            r10.c(r9)
            r3 = 16
            r10.d(r3)
            int r22 = r31.d()
            int r23 = r31.d()
            r3 = 1065353216(0x3f800000, float:1.0)
            r6 = 50
            r10.d(r6)
            int r6 = r10.f32567b
            int r7 = com.google.android.exoplayer2.extractor.mp4.a.am
            if (r1 != r7) goto L_0x01a8
            android.util.Pair r7 = a((com.google.android.exoplayer2.g.r) r10, (int) r12, (int) r14)
            if (r7 == 0) goto L_0x01a1
            java.lang.Object r1 = r7.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r11 != 0) goto L_0x018e
            r8 = 0
            goto L_0x0198
        L_0x018e:
            java.lang.Object r8 = r7.second
            com.google.android.exoplayer2.extractor.mp4.k r8 = (com.google.android.exoplayer2.extractor.mp4.k) r8
            java.lang.String r8 = r8.f32267b
            com.google.android.exoplayer2.drm.DrmInitData r8 = r11.a(r8)
        L_0x0198:
            com.google.android.exoplayer2.extractor.mp4.k[] r9 = r13.f32186a
            java.lang.Object r7 = r7.second
            com.google.android.exoplayer2.extractor.mp4.k r7 = (com.google.android.exoplayer2.extractor.mp4.k) r7
            r9[r15] = r7
            goto L_0x01a2
        L_0x01a1:
            r8 = r11
        L_0x01a2:
            r10.c(r6)
            r30 = r8
            goto L_0x01aa
        L_0x01a8:
            r30 = r11
        L_0x01aa:
            r7 = -1
            r3 = 0
            r19 = 0
            r20 = 0
            r24 = 0
            r26 = 1065353216(0x3f800000, float:1.0)
            r27 = 0
            r28 = -1
        L_0x01b8:
            int r7 = r6 - r12
            if (r7 >= r14) goto L_0x033c
            r10.c(r6)
            int r7 = r10.f32567b
            int r8 = r31.i()
            if (r8 != 0) goto L_0x01cc
            int r9 = r10.f32567b
            int r9 = r9 - r12
            if (r9 == r14) goto L_0x033c
        L_0x01cc:
            if (r8 <= 0) goto L_0x01d0
            r9 = 1
            goto L_0x01d1
        L_0x01d0:
            r9 = 0
        L_0x01d1:
            com.google.android.exoplayer2.g.a.a((boolean) r9, (java.lang.Object) r2)
            int r9 = r31.i()
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.f32162d
            r5 = 3
            if (r9 != r4) goto L_0x01fe
            if (r19 != 0) goto L_0x01e1
            r4 = 1
            goto L_0x01e2
        L_0x01e1:
            r4 = 0
        L_0x01e2:
            com.google.android.exoplayer2.g.a.b(r4)
            int r7 = r7 + 8
            r10.c(r7)
            com.google.android.exoplayer2.video.a r4 = com.google.android.exoplayer2.video.a.a(r31)
            java.util.List<byte[]> r5 = r4.f33662a
            int r7 = r4.f33663b
            r13.f32188c = r7
            if (r3 != 0) goto L_0x01fa
            float r4 = r4.f33666e
            r26 = r4
        L_0x01fa:
            java.lang.String r4 = "video/avc"
            goto L_0x021c
        L_0x01fe:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.f32165g
            if (r9 != r4) goto L_0x0222
            if (r19 != 0) goto L_0x0206
            r4 = 1
            goto L_0x0207
        L_0x0206:
            r4 = 0
        L_0x0207:
            com.google.android.exoplayer2.g.a.b(r4)
            int r7 = r7 + 8
            r10.c(r7)
            com.google.android.exoplayer2.video.c r4 = com.google.android.exoplayer2.video.c.a(r31)
            java.util.List<byte[]> r5 = r4.f33692a
            int r4 = r4.f33693b
            r13.f32188c = r4
            java.lang.String r4 = "video/hevc"
        L_0x021c:
            r19 = r4
            r24 = r5
            goto L_0x0336
        L_0x0222:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.q
            if (r9 == r4) goto L_0x02d5
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.r
            if (r9 != r4) goto L_0x022c
            goto L_0x02d5
        L_0x022c:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.j
            if (r9 != r4) goto L_0x0244
            if (r19 != 0) goto L_0x0234
            r4 = 1
            goto L_0x0235
        L_0x0234:
            r4 = 0
        L_0x0235:
            com.google.android.exoplayer2.g.a.b(r4)
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.f32166h
            if (r1 != r4) goto L_0x0240
            java.lang.String r4 = "video/x-vnd.on2.vp8"
            goto L_0x0253
        L_0x0240:
            java.lang.String r4 = "video/x-vnd.on2.vp9"
            goto L_0x0253
        L_0x0244:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.l
            if (r9 != r4) goto L_0x0257
            if (r19 != 0) goto L_0x024c
            r4 = 1
            goto L_0x024d
        L_0x024c:
            r4 = 0
        L_0x024d:
            com.google.android.exoplayer2.g.a.b(r4)
            java.lang.String r4 = "video/av01"
        L_0x0253:
            r19 = r4
            goto L_0x0336
        L_0x0257:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.t
            if (r9 != r4) goto L_0x0267
            if (r19 != 0) goto L_0x025f
            r4 = 1
            goto L_0x0260
        L_0x025f:
            r4 = 0
        L_0x0260:
            com.google.android.exoplayer2.g.a.b(r4)
            java.lang.String r4 = "video/3gpp"
            goto L_0x0253
        L_0x0267:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.W
            if (r9 != r4) goto L_0x0287
            if (r19 != 0) goto L_0x026f
            r4 = 1
            goto L_0x0270
        L_0x026f:
            r4 = 0
        L_0x0270:
            com.google.android.exoplayer2.g.a.b(r4)
            android.util.Pair r4 = a((com.google.android.exoplayer2.g.r) r10, (int) r7)
            java.lang.Object r5 = r4.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.second
            java.util.List r4 = java.util.Collections.singletonList(r4)
            r24 = r4
            r19 = r5
            goto L_0x0336
        L_0x0287:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.av
            if (r9 != r4) goto L_0x029f
            int r7 = r7 + 8
            r10.c(r7)
            int r3 = r31.n()
            int r4 = r31.n()
            float r3 = (float) r3
            float r4 = (float) r4
            float r26 = r3 / r4
            r3 = 1
            goto L_0x0336
        L_0x029f:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aW
            if (r9 != r4) goto L_0x02ab
            byte[] r4 = c(r10, r7, r8)
            r27 = r4
            goto L_0x0336
        L_0x02ab:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aV
            if (r9 != r4) goto L_0x0336
            int r4 = r31.c()
            r10.d(r5)
            if (r4 != 0) goto L_0x0336
            int r4 = r31.c()
            if (r4 == 0) goto L_0x02d2
            if (r4 == r0) goto L_0x02cf
            r7 = 2
            if (r4 == r7) goto L_0x02cb
            if (r4 == r5) goto L_0x02c7
            goto L_0x0336
        L_0x02c7:
            r28 = 3
            goto L_0x0336
        L_0x02cb:
            r28 = 2
            goto L_0x0336
        L_0x02cf:
            r28 = 1
            goto L_0x0336
        L_0x02d2:
            r28 = 0
            goto L_0x0336
        L_0x02d5:
            r7 = 2
            r10.d(r7)
            int r4 = r31.c()
            int r7 = r4 >> 1
            r4 = r4 & r0
            r9 = 5
            int r4 = r4 << r9
            int r25 = r31.c()
            int r5 = r25 >> 3
            r5 = r5 & 31
            r4 = r4 | r5
            r5 = 4
            if (r7 == r5) goto L_0x0303
            if (r7 != r9) goto L_0x02f1
            goto L_0x0303
        L_0x02f1:
            r5 = 8
            if (r7 != r5) goto L_0x02fa
            java.lang.String r21 = "hev1"
            r0 = r21
            goto L_0x0307
        L_0x02fa:
            r0 = 9
            if (r7 != r0) goto L_0x0301
            java.lang.String r0 = "avc3"
            goto L_0x0307
        L_0x0301:
            r5 = 0
            goto L_0x0326
        L_0x0303:
            r5 = 8
            java.lang.String r0 = "dvhe"
        L_0x0307:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r0 = ".0"
            r5.append(r0)
            r5.append(r7)
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = r5.toString()
            com.google.android.exoplayer2.video.b r5 = new com.google.android.exoplayer2.video.b
            r5.<init>(r7, r4, r0)
        L_0x0326:
            if (r5 == 0) goto L_0x0332
            int r0 = r5.f33689a
            if (r0 != r9) goto L_0x0332
            java.lang.String r0 = r5.f33691c
            java.lang.String r19 = "video/dolby-vision"
            goto L_0x0334
        L_0x0332:
            r0 = r20
        L_0x0334:
            r20 = r0
        L_0x0336:
            int r6 = r6 + r8
            r0 = 1
            r5 = 8
            goto L_0x01b8
        L_0x033c:
            if (r19 == 0) goto L_0x034e
            java.lang.String r18 = java.lang.Integer.toString(r32)
            r21 = -1
            r29 = 0
            r25 = r33
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a((java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (int) r21, (int) r22, (int) r23, (java.util.List<byte[]>) r24, (int) r25, (float) r26, (byte[]) r27, (int) r28, (com.google.android.exoplayer2.video.ColorInfo) r29, (com.google.android.exoplayer2.drm.DrmInitData) r30)
            r13.f32187b = r0
        L_0x034e:
            int r9 = r12 + r14
            r10.c(r9)
            int r15 = r15 + 1
            r12 = r17
            r14 = 0
            goto L_0x0014
        L_0x035a:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.b.a(com.google.android.exoplayer2.g.r, int, int, java.lang.String, com.google.android.exoplayer2.drm.DrmInitData, boolean):com.google.android.exoplayer2.extractor.mp4.b$c");
    }

    private static Pair<long[], long[]> b(a.C0542a aVar) {
        a.b d2;
        long j;
        if (aVar == null || (d2 = aVar.d(a.ad)) == null) {
            return Pair.create((Object) null, (Object) null);
        }
        r rVar = d2.bh;
        rVar.c(8);
        int a2 = a.a(rVar.i());
        int n = rVar.n();
        long[] jArr = new long[n];
        long[] jArr2 = new long[n];
        int i2 = 0;
        while (i2 < n) {
            jArr[i2] = a2 == 1 ? rVar.p() : rVar.g();
            if (a2 == 1) {
                j = rVar.k();
            } else {
                j = (long) rVar.i();
            }
            jArr2[i2] = j;
            byte[] bArr = rVar.f32566a;
            int i3 = rVar.f32567b;
            rVar.f32567b = i3 + 1;
            byte[] bArr2 = rVar.f32566a;
            int i4 = rVar.f32567b;
            rVar.f32567b = i4 + 1;
            if (((short) (((bArr[i3] & 255) << 8) | (bArr2[i4] & 255))) == 1) {
                rVar.d(2);
                i2++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: byte[]} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x02a6: MOVE  (r3v5 java.lang.String) = (r24v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    private static void a(com.google.android.exoplayer2.g.r r25, int r26, int r27, int r28, int r29, java.lang.String r30, boolean r31, com.google.android.exoplayer2.drm.DrmInitData r32, com.google.android.exoplayer2.extractor.mp4.b.c r33, int r34) throws com.google.android.exoplayer2.v {
        /*
            r0 = r25
            r1 = r27
            r2 = r28
            r12 = r30
            r3 = r32
            r13 = r33
            int r4 = r1 + 8
            r5 = 8
            int r4 = r4 + r5
            r0.c(r4)
            r4 = 6
            r14 = 0
            if (r31 == 0) goto L_0x0020
            int r6 = r25.d()
            r0.d(r4)
            goto L_0x0024
        L_0x0020:
            r0.d(r5)
            r6 = 0
        L_0x0024:
            r7 = 16
            r15 = 2
            r11 = 1
            if (r6 == 0) goto L_0x004b
            if (r6 != r11) goto L_0x002d
            goto L_0x004b
        L_0x002d:
            if (r6 != r15) goto L_0x004a
            r0.d(r7)
            long r4 = r25.k()
            double r4 = java.lang.Double.longBitsToDouble(r4)
            long r4 = java.lang.Math.round(r4)
            int r5 = (int) r4
            int r4 = r25.n()
            r6 = 20
            r0.d(r6)
            r8 = r4
            goto L_0x0076
        L_0x004a:
            return
        L_0x004b:
            int r8 = r25.d()
            r0.d(r4)
            byte[] r4 = r0.f32566a
            int r9 = r0.f32567b
            int r10 = r9 + 1
            r0.f32567b = r10
            byte r4 = r4[r9]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r5
            byte[] r5 = r0.f32566a
            int r9 = r0.f32567b
            int r10 = r9 + 1
            r0.f32567b = r10
            byte r5 = r5[r9]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r5 | r4
            int r4 = r0.f32567b
            int r4 = r4 + r15
            r0.f32567b = r4
            if (r6 != r11) goto L_0x0076
            r0.d(r7)
        L_0x0076:
            int r4 = r0.f32567b
            int r6 = com.google.android.exoplayer2.extractor.mp4.a.an
            r16 = 0
            r7 = r26
            if (r7 != r6) goto L_0x00a8
            android.util.Pair r6 = a((com.google.android.exoplayer2.g.r) r0, (int) r1, (int) r2)
            if (r6 == 0) goto L_0x00a5
            java.lang.Object r7 = r6.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r3 != 0) goto L_0x0093
            r3 = r16
            goto L_0x009d
        L_0x0093:
            java.lang.Object r9 = r6.second
            com.google.android.exoplayer2.extractor.mp4.k r9 = (com.google.android.exoplayer2.extractor.mp4.k) r9
            java.lang.String r9 = r9.f32267b
            com.google.android.exoplayer2.drm.DrmInitData r3 = r3.a(r9)
        L_0x009d:
            com.google.android.exoplayer2.extractor.mp4.k[] r9 = r13.f32186a
            java.lang.Object r6 = r6.second
            com.google.android.exoplayer2.extractor.mp4.k r6 = (com.google.android.exoplayer2.extractor.mp4.k) r6
            r9[r34] = r6
        L_0x00a5:
            r0.c(r4)
        L_0x00a8:
            r10 = r3
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.A
            java.lang.String r9 = "audio/raw"
            if (r7 != r3) goto L_0x00b3
            java.lang.String r3 = "audio/ac3"
            goto L_0x0123
        L_0x00b3:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.C
            if (r7 != r3) goto L_0x00bb
            java.lang.String r3 = "audio/eac3"
            goto L_0x0123
        L_0x00bb:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.E
            if (r7 != r3) goto L_0x00c3
            java.lang.String r3 = "audio/ac4"
            goto L_0x0123
        L_0x00c3:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.G
            if (r7 != r3) goto L_0x00cb
            java.lang.String r3 = "audio/vnd.dts"
            goto L_0x0123
        L_0x00cb:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.H
            if (r7 == r3) goto L_0x0121
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.I
            if (r7 != r3) goto L_0x00d4
            goto L_0x0121
        L_0x00d4:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.J
            if (r7 != r3) goto L_0x00db
            java.lang.String r3 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x0123
        L_0x00db:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.aL
            if (r7 != r3) goto L_0x00e2
            java.lang.String r3 = "audio/3gpp"
            goto L_0x0123
        L_0x00e2:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.aM
            if (r7 != r3) goto L_0x00e9
            java.lang.String r3 = "audio/amr-wb"
            goto L_0x0123
        L_0x00e9:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.y
            if (r7 == r3) goto L_0x011f
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.z
            if (r7 != r3) goto L_0x00f2
            goto L_0x011f
        L_0x00f2:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.w
            if (r7 != r3) goto L_0x00f9
            java.lang.String r3 = "audio/mpeg"
            goto L_0x0123
        L_0x00f9:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.aZ
            if (r7 != r3) goto L_0x0100
            java.lang.String r3 = "audio/alac"
            goto L_0x0123
        L_0x0100:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.ba
            if (r7 != r3) goto L_0x0107
            java.lang.String r3 = "audio/g711-alaw"
            goto L_0x0123
        L_0x0107:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.bb
            if (r7 != r3) goto L_0x010e
            java.lang.String r3 = "audio/g711-mlaw"
            goto L_0x0123
        L_0x010e:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.bc
            if (r7 != r3) goto L_0x0115
            java.lang.String r3 = "audio/opus"
            goto L_0x0123
        L_0x0115:
            int r3 = com.google.android.exoplayer2.extractor.mp4.a.be
            if (r7 != r3) goto L_0x011c
            java.lang.String r3 = "audio/flac"
            goto L_0x0123
        L_0x011c:
            r3 = r16
            goto L_0x0123
        L_0x011f:
            r3 = r9
            goto L_0x0123
        L_0x0121:
            java.lang.String r3 = "audio/vnd.dts.hd"
        L_0x0123:
            r7 = r3
            r18 = r5
            r17 = r8
            r19 = r16
            r8 = r4
        L_0x012b:
            int r3 = r8 - r1
            r4 = -1
            if (r3 >= r2) goto L_0x029b
            r0.c(r8)
            int r6 = r25.i()
            if (r6 <= 0) goto L_0x013b
            r3 = 1
            goto L_0x013c
        L_0x013b:
            r3 = 0
        L_0x013c:
            java.lang.String r5 = "childAtomSize should be positive"
            com.google.android.exoplayer2.g.a.a((boolean) r3, (java.lang.Object) r5)
            int r3 = r25.i()
            int r11 = com.google.android.exoplayer2.extractor.mp4.a.W
            if (r3 == r11) goto L_0x0229
            if (r31 == 0) goto L_0x0151
            int r11 = com.google.android.exoplayer2.extractor.mp4.a.x
            if (r3 != r11) goto L_0x0151
            goto L_0x0229
        L_0x0151:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.B
            if (r3 != r4) goto L_0x0172
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r29)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.b.a.a(r0, r3, r12, r10)
            r13.f32187b = r3
        L_0x0164:
            r15 = r6
            r24 = r7
            r22 = r8
            r23 = r9
            r21 = r10
            r7 = 2
            r20 = 1
            goto L_0x028f
        L_0x0172:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.D
            if (r3 != r4) goto L_0x0186
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r29)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.b.a.b(r0, r3, r12, r10)
            r13.f32187b = r3
            goto L_0x0164
        L_0x0186:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.F
            if (r3 != r4) goto L_0x019a
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r29)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.b.b.a(r0, r3, r12, r10)
            r13.f32187b = r3
            goto L_0x0164
        L_0x019a:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.K
            if (r3 != r4) goto L_0x01c3
            java.lang.String r3 = java.lang.Integer.toString(r29)
            r5 = -1
            r11 = -1
            r21 = 0
            r4 = r7
            r15 = r6
            r6 = r11
            r11 = r7
            r7 = r17
            r22 = r8
            r8 = r18
            r23 = r9
            r9 = r21
            r21 = r10
            r24 = r11
            r20 = 1
            r11 = r30
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a((java.lang.String) r3, (java.lang.String) r4, (int) r5, (int) r6, (int) r7, (int) r8, (java.util.List<byte[]>) r9, (com.google.android.exoplayer2.drm.DrmInitData) r10, (java.lang.String) r11)
            r13.f32187b = r3
            goto L_0x01eb
        L_0x01c3:
            r15 = r6
            r24 = r7
            r22 = r8
            r23 = r9
            r21 = r10
            r20 = 1
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.bd
            if (r3 != r4) goto L_0x01ee
            int r6 = r15 + -8
            byte[] r3 = f32176i
            int r4 = r3.length
            int r4 = r4 + r6
            byte[] r4 = new byte[r4]
            int r5 = r3.length
            java.lang.System.arraycopy(r3, r14, r4, r14, r5)
            int r8 = r22 + 8
            r0.c(r8)
            byte[] r3 = f32176i
            int r3 = r3.length
            r0.a(r4, r3, r6)
            r19 = r4
        L_0x01eb:
            r7 = 2
            goto L_0x028f
        L_0x01ee:
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.bf
            if (r3 != r4) goto L_0x0217
            int r6 = r15 + -12
            int r3 = r6 + 4
            byte[] r3 = new byte[r3]
            r4 = 102(0x66, float:1.43E-43)
            r3[r14] = r4
            r4 = 76
            r3[r20] = r4
            r4 = 97
            r7 = 2
            r3[r7] = r4
            r4 = 3
            r5 = 67
            r3[r4] = r5
            int r8 = r22 + 12
            r0.c(r8)
            r4 = 4
            r0.a(r3, r4, r6)
        L_0x0213:
            r19 = r3
            goto L_0x028f
        L_0x0217:
            r7 = 2
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aZ
            if (r3 != r4) goto L_0x028f
            int r6 = r15 + -12
            byte[] r3 = new byte[r6]
            int r8 = r22 + 12
            r0.c(r8)
            r0.a(r3, r14, r6)
            goto L_0x0213
        L_0x0229:
            r15 = r6
            r24 = r7
            r22 = r8
            r23 = r9
            r21 = r10
            r7 = 2
            r20 = 1
            int r6 = com.google.android.exoplayer2.extractor.mp4.a.W
            if (r3 != r6) goto L_0x023c
            r8 = r22
            goto L_0x025e
        L_0x023c:
            int r3 = r0.f32567b
            r8 = r3
        L_0x023f:
            int r3 = r8 - r22
            if (r3 >= r15) goto L_0x025d
            r0.c(r8)
            int r3 = r25.i()
            if (r3 <= 0) goto L_0x024e
            r6 = 1
            goto L_0x024f
        L_0x024e:
            r6 = 0
        L_0x024f:
            com.google.android.exoplayer2.g.a.a((boolean) r6, (java.lang.Object) r5)
            int r6 = r25.i()
            int r9 = com.google.android.exoplayer2.extractor.mp4.a.W
            if (r6 != r9) goto L_0x025b
            goto L_0x025e
        L_0x025b:
            int r8 = r8 + r3
            goto L_0x023f
        L_0x025d:
            r8 = -1
        L_0x025e:
            if (r8 == r4) goto L_0x028b
            android.util.Pair r3 = a((com.google.android.exoplayer2.g.r) r0, (int) r8)
            java.lang.Object r4 = r3.first
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.second
            r19 = r3
            byte[] r19 = (byte[]) r19
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x028d
            android.util.Pair r3 = com.google.android.exoplayer2.g.c.a((byte[]) r19)
            java.lang.Object r5 = r3.first
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r18 = r5.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r17 = r3.intValue()
            goto L_0x028d
        L_0x028b:
            r4 = r24
        L_0x028d:
            r24 = r4
        L_0x028f:
            int r8 = r22 + r15
            r10 = r21
            r9 = r23
            r7 = r24
            r11 = 1
            r15 = 2
            goto L_0x012b
        L_0x029b:
            r24 = r7
            r23 = r9
            r21 = r10
            r7 = 2
            com.google.android.exoplayer2.Format r0 = r13.f32187b
            if (r0 != 0) goto L_0x02d6
            r3 = r24
            if (r3 == 0) goto L_0x02d6
            r0 = r23
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x02b4
            r6 = 2
            goto L_0x02b5
        L_0x02b4:
            r6 = -1
        L_0x02b5:
            java.lang.String r0 = java.lang.Integer.toString(r29)
            r2 = -1
            r4 = -1
            if (r19 != 0) goto L_0x02c0
            r7 = r16
            goto L_0x02c5
        L_0x02c0:
            java.util.List r1 = java.util.Collections.singletonList(r19)
            r7 = r1
        L_0x02c5:
            r9 = 0
            r1 = r3
            r3 = r4
            r4 = r17
            r5 = r18
            r8 = r21
            r10 = r30
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a((java.lang.String) r0, (java.lang.String) r1, (int) r2, (int) r3, (int) r4, (int) r5, (int) r6, (java.util.List<byte[]>) r7, (com.google.android.exoplayer2.drm.DrmInitData) r8, (int) r9, (java.lang.String) r10)
            r13.f32187b = r0
        L_0x02d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.b.a(com.google.android.exoplayer2.g.r, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.b$c, int):void");
    }

    private static Pair<String, byte[]> a(r rVar, int i2) {
        rVar.c(i2 + 8 + 4);
        rVar.d(1);
        b(rVar);
        rVar.d(2);
        int c2 = rVar.c();
        if ((c2 & 128) != 0) {
            rVar.d(2);
        }
        if ((c2 & 64) != 0) {
            rVar.d(rVar.d());
        }
        if ((c2 & 32) != 0) {
            rVar.d(2);
        }
        rVar.d(1);
        b(rVar);
        String a2 = o.a(rVar.c());
        if ("audio/mpeg".equals(a2) || "audio/vnd.dts".equals(a2) || "audio/vnd.dts.hd".equals(a2)) {
            return Pair.create(a2, (Object) null);
        }
        rVar.d(12);
        rVar.d(1);
        int b2 = b(rVar);
        byte[] bArr = new byte[b2];
        rVar.a(bArr, 0, b2);
        return Pair.create(a2, bArr);
    }

    private static Pair<Integer, k> b(r rVar, int i2, int i3) {
        int i4 = i2 + 8;
        String str = null;
        Integer num = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            rVar.c(i4);
            int i7 = rVar.i();
            int i8 = rVar.i();
            if (i8 == a.ao) {
                num = Integer.valueOf(rVar.i());
            } else if (i8 == a.aj) {
                rVar.d(4);
                str = rVar.e(4);
            } else if (i8 == a.ak) {
                i5 = i4;
                i6 = i7;
            }
            i4 += i7;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        boolean z = true;
        com.google.android.exoplayer2.g.a.a(num != null, (Object) "frma atom is mandatory");
        com.google.android.exoplayer2.g.a.a(i5 != -1, (Object) "schi atom is mandatory");
        k a2 = a(rVar, i5, i6, str);
        if (a2 == null) {
            z = false;
        }
        com.google.android.exoplayer2.g.a.a(z, (Object) "tenc atom is mandatory");
        return Pair.create(num, a2);
    }

    private static k a(r rVar, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            rVar.c(i6);
            int i7 = rVar.i();
            if (rVar.i() == a.al) {
                int a2 = a.a(rVar.i());
                rVar.d(1);
                if (a2 == 0) {
                    rVar.d(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int c2 = rVar.c();
                    i4 = c2 & 15;
                    i5 = (c2 & 240) >> 4;
                }
                boolean z = rVar.c() == 1;
                int c3 = rVar.c();
                byte[] bArr2 = new byte[16];
                rVar.a(bArr2, 0, 16);
                if (z && c3 == 0) {
                    int c4 = rVar.c();
                    bArr = new byte[c4];
                    rVar.a(bArr, 0, c4);
                }
                return new k(z, str, c3, bArr2, i5, i4, bArr);
            }
            i6 += i7;
        }
    }

    private static byte[] c(r rVar, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            rVar.c(i4);
            int i5 = rVar.i();
            if (rVar.i() == a.aX) {
                return Arrays.copyOfRange(rVar.f32566a, i4, i5 + i4);
            }
            i4 += i5;
        }
        return null;
    }

    private static int b(r rVar) {
        int c2 = rVar.c();
        int i2 = c2 & 127;
        while ((c2 & 128) == 128) {
            c2 = rVar.c();
            i2 = (i2 << 7) | (c2 & 127);
        }
        return i2;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f32177a;

        /* renamed from: b  reason: collision with root package name */
        public int f32178b;

        /* renamed from: c  reason: collision with root package name */
        public int f32179c;

        /* renamed from: d  reason: collision with root package name */
        public long f32180d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f32181e;

        /* renamed from: f  reason: collision with root package name */
        private final r f32182f;

        /* renamed from: g  reason: collision with root package name */
        private final r f32183g;

        /* renamed from: h  reason: collision with root package name */
        private int f32184h;

        /* renamed from: i  reason: collision with root package name */
        private int f32185i;

        public a(r rVar, r rVar2, boolean z) {
            this.f32183g = rVar;
            this.f32182f = rVar2;
            this.f32181e = z;
            rVar2.c(12);
            this.f32177a = rVar2.n();
            rVar.c(12);
            this.f32185i = rVar.n();
            com.google.android.exoplayer2.g.a.b(rVar.i() != 1 ? false : true, "first_chunk must be 1");
            this.f32178b = -1;
        }

        public final boolean a() {
            long j;
            int i2 = this.f32178b + 1;
            this.f32178b = i2;
            if (i2 == this.f32177a) {
                return false;
            }
            if (this.f32181e) {
                j = this.f32182f.p();
            } else {
                j = this.f32182f.g();
            }
            this.f32180d = j;
            if (this.f32178b == this.f32184h) {
                this.f32179c = this.f32183g.n();
                this.f32183g.d(4);
                int i3 = this.f32185i - 1;
                this.f32185i = i3;
                this.f32184h = i3 > 0 ? this.f32183g.n() - 1 : -1;
            }
            return true;
        }
    }

    static final class f {

        /* renamed from: a  reason: collision with root package name */
        final int f32198a;

        /* renamed from: b  reason: collision with root package name */
        final long f32199b;

        /* renamed from: c  reason: collision with root package name */
        final int f32200c;

        public f(int i2, long j, int i3) {
            this.f32198a = i2;
            this.f32199b = j;
            this.f32200c = i3;
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final k[] f32186a;

        /* renamed from: b  reason: collision with root package name */
        public Format f32187b;

        /* renamed from: c  reason: collision with root package name */
        public int f32188c;

        /* renamed from: d  reason: collision with root package name */
        public int f32189d = 0;

        public c(int i2) {
            this.f32186a = new k[i2];
        }
    }

    static final class d implements C0543b {

        /* renamed from: a  reason: collision with root package name */
        private final int f32190a = this.f32192c.n();

        /* renamed from: b  reason: collision with root package name */
        private final int f32191b = this.f32192c.n();

        /* renamed from: c  reason: collision with root package name */
        private final r f32192c;

        public d(a.b bVar) {
            this.f32192c = bVar.bh;
            this.f32192c.c(12);
        }

        public final int a() {
            return this.f32191b;
        }

        public final int b() {
            int i2 = this.f32190a;
            return i2 == 0 ? this.f32192c.n() : i2;
        }

        public final boolean c() {
            return this.f32190a != 0;
        }
    }

    static final class e implements C0543b {

        /* renamed from: a  reason: collision with root package name */
        private final r f32193a;

        /* renamed from: b  reason: collision with root package name */
        private final int f32194b = this.f32193a.n();

        /* renamed from: c  reason: collision with root package name */
        private final int f32195c = (this.f32193a.n() & PriceRangeSeekBar.INVALID_POINTER_ID);

        /* renamed from: d  reason: collision with root package name */
        private int f32196d;

        /* renamed from: e  reason: collision with root package name */
        private int f32197e;

        public final boolean c() {
            return false;
        }

        public e(a.b bVar) {
            this.f32193a = bVar.bh;
            this.f32193a.c(12);
        }

        public final int a() {
            return this.f32194b;
        }

        public final int b() {
            int i2 = this.f32195c;
            if (i2 == 8) {
                return this.f32193a.c();
            }
            if (i2 == 16) {
                return this.f32193a.d();
            }
            int i3 = this.f32196d;
            this.f32196d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f32197e & 15;
            }
            this.f32197e = this.f32193a.c();
            return (this.f32197e & 240) >> 4;
        }
    }

    private static Pair<Integer, k> a(r rVar, int i2, int i3) {
        Pair<Integer, k> b2;
        int i4 = rVar.f32567b;
        while (i4 - i2 < i3) {
            rVar.c(i4);
            int i5 = rVar.i();
            com.google.android.exoplayer2.g.a.a(i5 > 0, (Object) "childAtomSize should be positive");
            if (rVar.i() == a.ai && (b2 = b(rVar, i4, i5)) != null) {
                return b2;
            }
            i4 += i5;
        }
        return null;
    }
}
