package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.b.d;
import com.google.android.exoplayer2.source.b.e;
import com.google.android.exoplayer2.source.b.k;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    protected final b[] f32995a;

    /* renamed from: b  reason: collision with root package name */
    private final y f32996b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f32997c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32998d;

    /* renamed from: e  reason: collision with root package name */
    private final i f32999e;

    /* renamed from: f  reason: collision with root package name */
    private final long f33000f;

    /* renamed from: g  reason: collision with root package name */
    private final int f33001g;

    /* renamed from: h  reason: collision with root package name */
    private final h.c f33002h;

    /* renamed from: i  reason: collision with root package name */
    private com.google.android.exoplayer2.trackselection.f f33003i;
    private com.google.android.exoplayer2.source.dash.a.b j;
    private int k;
    private IOException l;
    private boolean m;
    private long n = -9223372036854775807L;

    public static final class a implements a.C0547a {

        /* renamed from: a  reason: collision with root package name */
        private final i.a f33004a;

        /* renamed from: b  reason: collision with root package name */
        private final int f33005b;

        public a(i.a aVar) {
            this(aVar, (byte) 0);
        }

        private a(i.a aVar, byte b2) {
            this.f33004a = aVar;
            this.f33005b = 1;
        }

        public final a a(y yVar, com.google.android.exoplayer2.source.dash.a.b bVar, int i2, int[] iArr, com.google.android.exoplayer2.trackselection.f fVar, int i3, long j, boolean z, List<Format> list, h.c cVar, ad adVar) {
            ad adVar2 = adVar;
            i a2 = this.f33004a.a();
            if (adVar2 != null) {
                a2.a(adVar2);
            }
            return new f(yVar, bVar, i2, iArr, fVar, i3, a2, j, this.f33005b, z, list, cVar);
        }
    }

    public f(y yVar, com.google.android.exoplayer2.source.dash.a.b bVar, int i2, int[] iArr, com.google.android.exoplayer2.trackselection.f fVar, int i3, i iVar, long j2, int i4, boolean z, List<Format> list, h.c cVar) {
        com.google.android.exoplayer2.trackselection.f fVar2 = fVar;
        this.f32996b = yVar;
        this.j = bVar;
        this.f32997c = iArr;
        this.f33003i = fVar2;
        this.f32998d = i3;
        this.f32999e = iVar;
        this.k = i2;
        this.f33000f = j2;
        this.f33001g = i4;
        this.f33002h = cVar;
        long b2 = bVar.b(i2);
        ArrayList<com.google.android.exoplayer2.source.dash.a.i> b3 = b();
        this.f32995a = new b[fVar.f()];
        for (int i5 = 0; i5 < this.f32995a.length; i5++) {
            this.f32995a[i5] = new b(b2, i3, b3.get(fVar2.b(i5)), z, list, cVar);
        }
    }

    public final long a(long j2, af afVar) {
        for (b bVar : this.f32995a) {
            if (bVar.f33008c != null) {
                long c2 = bVar.c(j2);
                long a2 = bVar.a(c2);
                return ae.a(j2, afVar, a2, (a2 >= j2 || c2 >= ((long) (bVar.b() + -1))) ? a2 : bVar.a(c2 + 1));
            }
        }
        return j2;
    }

    public final void a(com.google.android.exoplayer2.source.dash.a.b bVar, int i2) {
        b[] bVarArr;
        ArrayList<com.google.android.exoplayer2.source.dash.a.i> arrayList;
        b bVar2;
        long a2;
        f fVar = this;
        try {
            fVar.j = bVar;
            fVar.k = i2;
            long b2 = fVar.j.b(fVar.k);
            ArrayList<com.google.android.exoplayer2.source.dash.a.i> b3 = b();
            int i3 = 0;
            while (i3 < fVar.f32995a.length) {
                com.google.android.exoplayer2.source.dash.a.i iVar = b3.get(fVar.f33003i.b(i3));
                b[] bVarArr2 = fVar.f32995a;
                b bVar3 = bVarArr2[i3];
                d d2 = bVar3.f33007b.d();
                d d3 = iVar.d();
                if (d2 == null) {
                    try {
                        arrayList = b3;
                        bVarArr = bVarArr2;
                        bVar2 = new b(b2, iVar, bVar3.f33006a, bVar3.f33010e, d2);
                    } catch (com.google.android.exoplayer2.source.c e2) {
                        e = e2;
                    }
                } else {
                    if (!d2.b()) {
                        bVar2 = new b(b2, iVar, bVar3.f33006a, bVar3.f33010e, d3);
                    } else {
                        int c2 = d2.c(b2);
                        if (c2 == 0) {
                            bVar2 = new b(b2, iVar, bVar3.f33006a, bVar3.f33010e, d3);
                        } else {
                            long a3 = (d2.a() + ((long) c2)) - 1;
                            long a4 = d2.a(a3) + d2.b(a3, b2);
                            long a5 = d3.a();
                            arrayList = b3;
                            long a6 = d3.a(a5);
                            bVarArr = bVarArr2;
                            d dVar = d3;
                            long j2 = bVar3.f33010e;
                            int i4 = (a4 > a6 ? 1 : (a4 == a6 ? 0 : -1));
                            if (i4 == 0) {
                                a2 = j2 + ((a3 + 1) - a5);
                            } else if (i4 >= 0) {
                                a2 = j2 + (d2.a(a6, b2) - a5);
                            } else {
                                throw new com.google.android.exoplayer2.source.c();
                            }
                            bVar2 = new b(b2, iVar, bVar3.f33006a, a2, dVar);
                        }
                    }
                    arrayList = b3;
                    bVarArr = bVarArr2;
                }
                bVarArr[i3] = bVar2;
                i3++;
                fVar = this;
                b3 = arrayList;
            }
        } catch (com.google.android.exoplayer2.source.c e3) {
            e = e3;
            fVar = this;
            fVar.l = e;
        }
    }

    public final void a(com.google.android.exoplayer2.trackselection.f fVar) {
        this.f33003i = fVar;
    }

    public final void a() throws IOException {
        IOException iOException = this.l;
        if (iOException == null) {
            this.f32996b.a();
            return;
        }
        throw iOException;
    }

    public final int a(long j2, List<? extends l> list) {
        if (this.l != null || this.f33003i.f() < 2) {
            return list.size();
        }
        return this.f33003i.a(j2, list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: com.google.android.exoplayer2.source.b.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: com.google.android.exoplayer2.source.b.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v3, resolved type: com.google.android.exoplayer2.source.b.n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: com.google.android.exoplayer2.source.b.i} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(long r43, long r45, java.util.List<? extends com.google.android.exoplayer2.source.b.l> r47, com.google.android.exoplayer2.source.b.f r48) {
        /*
            r42 = this;
            r0 = r42
            r9 = r48
            java.io.IOException r1 = r0.l
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            long r10 = r45 - r43
            com.google.android.exoplayer2.source.dash.a.b r1 = r0.j
            boolean r1 = r1.f32908d
            r12 = 0
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = 1
            if (r1 == 0) goto L_0x0020
            long r1 = r0.n
            int r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0020
            r1 = 1
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x002a
            long r1 = r0.n
            long r1 = r1 - r43
            r16 = r1
            goto L_0x002c
        L_0x002a:
            r16 = r13
        L_0x002c:
            com.google.android.exoplayer2.source.dash.a.b r1 = r0.j
            long r1 = r1.f32905a
            long r1 = com.google.android.exoplayer2.c.b(r1)
            com.google.android.exoplayer2.source.dash.a.b r3 = r0.j
            int r4 = r0.k
            com.google.android.exoplayer2.source.dash.a.f r3 = r3.a((int) r4)
            long r3 = r3.f32934b
            long r3 = com.google.android.exoplayer2.c.b(r3)
            long r1 = r1 + r3
            long r1 = r1 + r45
            com.google.android.exoplayer2.source.dash.h$c r3 = r0.f33002h
            if (r3 == 0) goto L_0x0095
            com.google.android.exoplayer2.source.dash.h r3 = com.google.android.exoplayer2.source.dash.h.this
            com.google.android.exoplayer2.source.dash.a.b r4 = r3.f33024e
            boolean r4 = r4.f32908d
            if (r4 != 0) goto L_0x0053
            r1 = 0
            goto L_0x0092
        L_0x0053:
            boolean r4 = r3.f33027h
            if (r4 == 0) goto L_0x0059
            r1 = 1
            goto L_0x0092
        L_0x0059:
            com.google.android.exoplayer2.source.dash.a.b r4 = r3.f33024e
            long r4 = r4.f32912h
            java.util.TreeMap<java.lang.Long, java.lang.Long> r6 = r3.f33023d
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.util.Map$Entry r4 = r6.ceilingEntry(r4)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r5 = r4.getValue()
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x008c
            java.lang.Object r1 = r4.getKey()
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r3.f33025f = r1
            com.google.android.exoplayer2.source.dash.h$b r1 = r3.f33021b
            long r4 = r3.f33025f
            r1.a(r4)
            r1 = 1
            goto L_0x008d
        L_0x008c:
            r1 = 0
        L_0x008d:
            if (r1 == 0) goto L_0x0092
            r3.a()
        L_0x0092:
            if (r1 == 0) goto L_0x0095
            return
        L_0x0095:
            long r1 = r0.f33000f
            r3 = 0
            r5 = 1000(0x3e8, double:4.94E-321)
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x00a7
            long r1 = android.os.SystemClock.elapsedRealtime()
            long r3 = r0.f33000f
            long r1 = r1 + r3
            goto L_0x00ab
        L_0x00a7:
            long r1 = java.lang.System.currentTimeMillis()
        L_0x00ab:
            long r1 = r1 * r5
            r7 = r1
            boolean r1 = r47.isEmpty()
            r18 = 0
            if (r1 == 0) goto L_0x00bb
            r5 = r47
            r19 = r18
            goto L_0x00ca
        L_0x00bb:
            int r1 = r47.size()
            int r1 = r1 - r15
            r5 = r47
            java.lang.Object r1 = r5.get(r1)
            com.google.android.exoplayer2.source.b.l r1 = (com.google.android.exoplayer2.source.b.l) r1
            r19 = r1
        L_0x00ca:
            com.google.android.exoplayer2.trackselection.f r1 = r0.f33003i
            int r1 = r1.f()
            com.google.android.exoplayer2.source.b.m[] r6 = new com.google.android.exoplayer2.source.b.m[r1]
            r3 = 0
        L_0x00d3:
            int r1 = r6.length
            if (r3 >= r1) goto L_0x012d
            com.google.android.exoplayer2.source.dash.f$b[] r1 = r0.f32995a
            r4 = r1[r3]
            com.google.android.exoplayer2.source.dash.d r1 = r4.f33008c
            if (r1 != 0) goto L_0x00e9
            com.google.android.exoplayer2.source.b.m r1 = com.google.android.exoplayer2.source.b.m.f32857a
            r6[r3] = r1
            r26 = r3
            r27 = r6
            r28 = r7
            goto L_0x0124
        L_0x00e9:
            com.google.android.exoplayer2.source.dash.a.b r1 = r0.j
            int r2 = r0.k
            long r20 = r4.a(r1, r2, r7)
            com.google.android.exoplayer2.source.dash.a.b r1 = r0.j
            int r2 = r0.k
            long r24 = r4.b(r1, r2, r7)
            r1 = r4
            r2 = r19
            r26 = r3
            r22 = r4
            r3 = r45
            r27 = r6
            r5 = r20
            r28 = r7
            r7 = r24
            long r1 = a(r1, r2, r3, r5, r7)
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 >= 0) goto L_0x0117
            com.google.android.exoplayer2.source.b.m r1 = com.google.android.exoplayer2.source.b.m.f32857a
            r27[r26] = r1
            goto L_0x0124
        L_0x0117:
            com.google.android.exoplayer2.source.dash.f$c r3 = new com.google.android.exoplayer2.source.dash.f$c
            r20 = r3
            r21 = r22
            r22 = r1
            r20.<init>(r21, r22, r24)
            r27[r26] = r3
        L_0x0124:
            int r3 = r26 + 1
            r5 = r47
            r6 = r27
            r7 = r28
            goto L_0x00d3
        L_0x012d:
            r27 = r6
            r28 = r7
            com.google.android.exoplayer2.trackselection.f r2 = r0.f33003i
            r3 = r10
            r5 = r16
            r7 = r47
            r8 = r27
            r2.a(r3, r5, r7, r8)
            com.google.android.exoplayer2.source.dash.f$b[] r1 = r0.f32995a
            com.google.android.exoplayer2.trackselection.f r2 = r0.f33003i
            int r2 = r2.a()
            r10 = r1[r2]
            com.google.android.exoplayer2.source.b.e r1 = r10.f33006a
            if (r1 == 0) goto L_0x01ae
            com.google.android.exoplayer2.source.dash.a.i r1 = r10.f33007b
            com.google.android.exoplayer2.source.b.e r2 = r10.f33006a
            com.google.android.exoplayer2.Format[] r2 = r2.f32821c
            if (r2 != 0) goto L_0x0156
            com.google.android.exoplayer2.source.dash.a.h r2 = r1.f32951f
            goto L_0x0158
        L_0x0156:
            r2 = r18
        L_0x0158:
            com.google.android.exoplayer2.source.dash.d r3 = r10.f33008c
            if (r3 != 0) goto L_0x0160
            com.google.android.exoplayer2.source.dash.a.h r18 = r1.c()
        L_0x0160:
            r1 = r18
            if (r2 != 0) goto L_0x0166
            if (r1 == 0) goto L_0x01ae
        L_0x0166:
            com.google.android.exoplayer2.f.i r3 = r0.f32999e
            com.google.android.exoplayer2.trackselection.f r4 = r0.f33003i
            com.google.android.exoplayer2.Format r23 = r4.g()
            com.google.android.exoplayer2.trackselection.f r4 = r0.f33003i
            int r24 = r4.b()
            com.google.android.exoplayer2.trackselection.f r4 = r0.f33003i
            java.lang.Object r25 = r4.c()
            com.google.android.exoplayer2.source.dash.a.i r4 = r10.f33007b
            java.lang.String r4 = r4.f32948c
            if (r2 == 0) goto L_0x0187
            com.google.android.exoplayer2.source.dash.a.h r1 = r2.a(r1, r4)
            if (r1 != 0) goto L_0x0187
            r1 = r2
        L_0x0187:
            com.google.android.exoplayer2.f.l r2 = new com.google.android.exoplayer2.f.l
            android.net.Uri r12 = r1.a(r4)
            long r13 = r1.f32942a
            long r4 = r1.f32943b
            com.google.android.exoplayer2.source.dash.a.i r1 = r10.f33007b
            java.lang.String r17 = r1.e()
            r11 = r2
            r15 = r4
            r11.<init>((android.net.Uri) r12, (long) r13, (long) r15, (java.lang.String) r17)
            com.google.android.exoplayer2.source.b.k r1 = new com.google.android.exoplayer2.source.b.k
            com.google.android.exoplayer2.source.b.e r4 = r10.f33006a
            r20 = r1
            r21 = r3
            r22 = r2
            r26 = r4
            r20.<init>(r21, r22, r23, r24, r25, r26)
            r9.f32835a = r1
            return
        L_0x01ae:
            long r7 = r10.f33009d
            int r11 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x01b5
            r12 = 1
        L_0x01b5:
            int r1 = r10.b()
            if (r1 != 0) goto L_0x01be
            r9.f32836b = r12
            return
        L_0x01be:
            com.google.android.exoplayer2.source.dash.a.b r1 = r0.j
            int r2 = r0.k
            r3 = r28
            long r16 = r10.a(r1, r2, r3)
            com.google.android.exoplayer2.source.dash.a.b r1 = r0.j
            int r2 = r0.k
            long r5 = r10.b(r1, r2, r3)
            com.google.android.exoplayer2.source.dash.a.b r1 = r0.j
            boolean r1 = r1.f32908d
            if (r1 == 0) goto L_0x01db
            long r1 = r10.b(r5)
            goto L_0x01dc
        L_0x01db:
            r1 = r13
        L_0x01dc:
            r0.n = r1
            r1 = r10
            r2 = r19
            r3 = r45
            r18 = r5
            r5 = r16
            r20 = r7
            r7 = r18
            long r1 = a(r1, r2, r3, r5, r7)
            int r3 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x01fb
            com.google.android.exoplayer2.source.c r1 = new com.google.android.exoplayer2.source.c
            r1.<init>()
            r0.l = r1
            return
        L_0x01fb:
            int r3 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r3 > 0) goto L_0x02fb
            boolean r4 = r0.m
            if (r4 == 0) goto L_0x0207
            if (r3 < 0) goto L_0x0207
            goto L_0x02fb
        L_0x0207:
            if (r12 == 0) goto L_0x0214
            long r3 = r10.a(r1)
            int r5 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r5 < 0) goto L_0x0214
            r9.f32836b = r15
            return
        L_0x0214:
            int r3 = r0.f33001g
            long r3 = (long) r3
            long r5 = r18 - r1
            r7 = 1
            long r5 = r5 + r7
            long r3 = java.lang.Math.min(r3, r5)
            int r4 = (int) r3
            if (r11 == 0) goto L_0x0233
        L_0x0223:
            if (r4 <= r15) goto L_0x0233
            long r5 = (long) r4
            long r5 = r5 + r1
            long r5 = r5 - r7
            long r5 = r10.a(r5)
            int r3 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r3 < 0) goto L_0x0233
            int r4 = r4 + -1
            goto L_0x0223
        L_0x0233:
            boolean r3 = r47.isEmpty()
            if (r3 == 0) goto L_0x023c
            r32 = r45
            goto L_0x023e
        L_0x023c:
            r32 = r13
        L_0x023e:
            com.google.android.exoplayer2.f.i r3 = r0.f32999e
            int r5 = r0.f32998d
            com.google.android.exoplayer2.trackselection.f r6 = r0.f33003i
            com.google.android.exoplayer2.Format r6 = r6.g()
            com.google.android.exoplayer2.trackselection.f r11 = r0.f33003i
            int r26 = r11.b()
            com.google.android.exoplayer2.trackselection.f r11 = r0.f33003i
            java.lang.Object r27 = r11.c()
            com.google.android.exoplayer2.source.dash.a.i r11 = r10.f33007b
            long r28 = r10.a(r1)
            com.google.android.exoplayer2.source.dash.a.h r12 = r10.d(r1)
            java.lang.String r15 = r11.f32948c
            com.google.android.exoplayer2.source.b.e r13 = r10.f33006a
            if (r13 != 0) goto L_0x0294
            long r30 = r10.b(r1)
            com.google.android.exoplayer2.f.l r4 = new com.google.android.exoplayer2.f.l
            android.net.Uri r17 = r12.a(r15)
            long r7 = r12.f32942a
            long r12 = r12.f32943b
            java.lang.String r22 = r11.e()
            r16 = r4
            r18 = r7
            r20 = r12
            r16.<init>((android.net.Uri) r17, (long) r18, (long) r20, (java.lang.String) r22)
            com.google.android.exoplayer2.source.b.n r7 = new com.google.android.exoplayer2.source.b.n
            r22 = r7
            r23 = r3
            r24 = r4
            r25 = r6
            r32 = r1
            r34 = r5
            r35 = r6
            r22.<init>(r23, r24, r25, r26, r27, r28, r30, r32, r34, r35)
            r4 = r7
            goto L_0x02f8
        L_0x0294:
            r5 = 1
            r13 = 1
        L_0x0296:
            if (r5 >= r4) goto L_0x02ac
            long r7 = (long) r5
            long r7 = r7 + r1
            com.google.android.exoplayer2.source.dash.a.h r7 = r10.d(r7)
            com.google.android.exoplayer2.source.dash.a.h r7 = r12.a(r7, r15)
            if (r7 == 0) goto L_0x02ac
            int r13 = r13 + 1
            int r5 = r5 + 1
            r12 = r7
            r7 = 1
            goto L_0x0296
        L_0x02ac:
            long r4 = (long) r13
            long r4 = r4 + r1
            r7 = 1
            long r4 = r4 - r7
            long r30 = r10.b(r4)
            long r4 = r10.f33009d
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r14 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r14 == 0) goto L_0x02c7
            int r14 = (r4 > r30 ? 1 : (r4 == r30 ? 0 : -1))
            if (r14 > 0) goto L_0x02c7
            r34 = r4
            goto L_0x02c9
        L_0x02c7:
            r34 = r7
        L_0x02c9:
            com.google.android.exoplayer2.f.l r16 = new com.google.android.exoplayer2.f.l
            r24 = r16
            android.net.Uri r17 = r12.a(r15)
            long r4 = r12.f32942a
            long r7 = r12.f32943b
            java.lang.String r22 = r11.e()
            r18 = r4
            r20 = r7
            r16.<init>((android.net.Uri) r17, (long) r18, (long) r20, (java.lang.String) r22)
            long r4 = r11.f32949d
            long r4 = -r4
            r39 = r4
            com.google.android.exoplayer2.source.b.i r4 = new com.google.android.exoplayer2.source.b.i
            r22 = r4
            com.google.android.exoplayer2.source.b.e r5 = r10.f33006a
            r41 = r5
            r23 = r3
            r25 = r6
            r36 = r1
            r38 = r13
            r22.<init>(r23, r24, r25, r26, r27, r28, r30, r32, r34, r36, r38, r39, r41)
        L_0x02f8:
            r9.f32835a = r4
            return
        L_0x02fb:
            r9.f32836b = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.f.a(long, long, java.util.List, com.google.android.exoplayer2.source.b.f):void");
    }

    public final void a(d dVar) {
        o oVar;
        if (dVar instanceof k) {
            int a2 = this.f33003i.a(((k) dVar).f32816g);
            b bVar = this.f32995a[a2];
            if (bVar.f33008c == null && (oVar = bVar.f33006a.f32820b) != null) {
                this.f32995a[a2] = new b(bVar.f33009d, bVar.f33007b, bVar.f33006a, bVar.f33010e, new e((com.google.android.exoplayer2.extractor.b) oVar, bVar.f33007b.f32949d));
            }
        }
        h.c cVar = this.f33002h;
        if (cVar != null) {
            h hVar = h.this;
            if (hVar.f33026g != -9223372036854775807L || dVar.k > hVar.f33026g) {
                hVar.f33026g = dVar.k;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.android.exoplayer2.source.b.d r10, boolean r11, java.lang.Exception r12, long r13) {
        /*
            r9 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.exoplayer2.source.dash.h$c r11 = r9.f33002h
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3 = 1
            if (r11 == 0) goto L_0x0037
            com.google.android.exoplayer2.source.dash.h r11 = com.google.android.exoplayer2.source.dash.h.this
            com.google.android.exoplayer2.source.dash.a.b r4 = r11.f33024e
            boolean r4 = r4.f32908d
            if (r4 == 0) goto L_0x0033
            boolean r4 = r11.f33027h
            if (r4 == 0) goto L_0x001c
        L_0x001a:
            r11 = 1
            goto L_0x0034
        L_0x001c:
            long r4 = r11.f33026g
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x002c
            long r4 = r11.f33026g
            long r6 = r10.j
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x002c
            r4 = 1
            goto L_0x002d
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 == 0) goto L_0x0033
            r11.a()
            goto L_0x001a
        L_0x0033:
            r11 = 0
        L_0x0034:
            if (r11 == 0) goto L_0x0037
            return r3
        L_0x0037:
            com.google.android.exoplayer2.source.dash.a.b r11 = r9.j
            boolean r11 = r11.f32908d
            if (r11 != 0) goto L_0x0079
            boolean r11 = r10 instanceof com.google.android.exoplayer2.source.b.l
            if (r11 == 0) goto L_0x0079
            boolean r11 = r12 instanceof com.google.android.exoplayer2.f.v.e
            if (r11 == 0) goto L_0x0079
            com.google.android.exoplayer2.f.v$e r12 = (com.google.android.exoplayer2.f.v.e) r12
            int r11 = r12.responseCode
            r12 = 404(0x194, float:5.66E-43)
            if (r11 != r12) goto L_0x0079
            com.google.android.exoplayer2.source.dash.f$b[] r11 = r9.f32995a
            com.google.android.exoplayer2.trackselection.f r12 = r9.f33003i
            com.google.android.exoplayer2.Format r4 = r10.f32816g
            int r12 = r12.a((com.google.android.exoplayer2.Format) r4)
            r11 = r11[r12]
            int r12 = r11.b()
            r4 = -1
            if (r12 == r4) goto L_0x0079
            if (r12 == 0) goto L_0x0079
            long r4 = r11.a()
            long r11 = (long) r12
            long r4 = r4 + r11
            r11 = 1
            long r4 = r4 - r11
            r11 = r10
            com.google.android.exoplayer2.source.b.l r11 = (com.google.android.exoplayer2.source.b.l) r11
            long r11 = r11.f()
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0079
            r9.m = r3
            return r3
        L_0x0079:
            int r11 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r11 == 0) goto L_0x008c
            com.google.android.exoplayer2.trackselection.f r11 = r9.f33003i
            com.google.android.exoplayer2.Format r10 = r10.f32816g
            int r10 = r11.a((com.google.android.exoplayer2.Format) r10)
            boolean r10 = r11.a((int) r10, (long) r13)
            if (r10 == 0) goto L_0x008c
            return r3
        L_0x008c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.f.a(com.google.android.exoplayer2.source.b.d, boolean, java.lang.Exception, long):boolean");
    }

    private static long a(b bVar, l lVar, long j2, long j3, long j4) {
        if (lVar != null) {
            return lVar.f();
        }
        return ae.a(bVar.c(j2), j3, j4);
    }

    private ArrayList<com.google.android.exoplayer2.source.dash.a.i> b() {
        List<com.google.android.exoplayer2.source.dash.a.a> list = this.j.a(this.k).f32935c;
        ArrayList<com.google.android.exoplayer2.source.dash.a.i> arrayList = new ArrayList<>();
        for (int i2 : this.f32997c) {
            arrayList.addAll(list.get(i2).f32902c);
        }
        return arrayList;
    }

    protected static final class c extends com.google.android.exoplayer2.source.b.b {

        /* renamed from: b  reason: collision with root package name */
        private final b f33011b;

        public c(b bVar, long j, long j2) {
            super(j, j2);
            this.f33011b = bVar;
        }
    }

    protected static final class b {

        /* renamed from: a  reason: collision with root package name */
        final e f33006a;

        /* renamed from: b  reason: collision with root package name */
        public final com.google.android.exoplayer2.source.dash.a.i f33007b;

        /* renamed from: c  reason: collision with root package name */
        public final d f33008c;

        /* renamed from: d  reason: collision with root package name */
        final long f33009d;

        /* renamed from: e  reason: collision with root package name */
        final long f33010e;

        b(long j, com.google.android.exoplayer2.source.dash.a.i iVar, e eVar, long j2, d dVar) {
            this.f33009d = j;
            this.f33007b = iVar;
            this.f33010e = j2;
            this.f33006a = eVar;
            this.f33008c = dVar;
        }

        public final long a() {
            return this.f33008c.a() + this.f33010e;
        }

        public final int b() {
            return this.f33008c.c(this.f33009d);
        }

        public final long a(long j) {
            return this.f33008c.a(j - this.f33010e);
        }

        public final long b(long j) {
            return a(j) + this.f33008c.b(j - this.f33010e, this.f33009d);
        }

        public final long c(long j) {
            return this.f33008c.a(j, this.f33009d) + this.f33010e;
        }

        public final com.google.android.exoplayer2.source.dash.a.h d(long j) {
            return this.f33008c.b(j - this.f33010e);
        }

        public final long a(com.google.android.exoplayer2.source.dash.a.b bVar, int i2, long j) {
            if (b() != -1 || bVar.f32910f == -9223372036854775807L) {
                return a();
            }
            return Math.max(a(), c(((j - com.google.android.exoplayer2.c.b(bVar.f32905a)) - com.google.android.exoplayer2.c.b(bVar.a(i2).f32934b)) - com.google.android.exoplayer2.c.b(bVar.f32910f)));
        }

        public final long b(com.google.android.exoplayer2.source.dash.a.b bVar, int i2, long j) {
            long a2;
            int b2 = b();
            if (b2 == -1) {
                a2 = c((j - com.google.android.exoplayer2.c.b(bVar.f32905a)) - com.google.android.exoplayer2.c.b(bVar.a(i2).f32934b));
            } else {
                a2 = a() + ((long) b2);
            }
            return a2 - 1;
        }

        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.exoplayer2.extractor.c.d] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.exoplayer2.extractor.f.a] */
        /* JADX WARNING: Illegal instructions before constructor call */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        b(long r12, int r14, com.google.android.exoplayer2.source.dash.a.i r15, boolean r16, java.util.List<com.google.android.exoplayer2.Format> r17, com.google.android.exoplayer2.extractor.q r18) {
            /*
                r11 = this;
                r3 = r15
                com.google.android.exoplayer2.Format r0 = r3.f32947b
                java.lang.String r0 = r0.f31068h
                boolean r1 = com.google.android.exoplayer2.g.o.c(r0)
                r2 = 0
                r4 = 1
                if (r1 != 0) goto L_0x0018
                java.lang.String r1 = "application/ttml+xml"
                boolean r1 = r1.equals(r0)
                if (r1 == 0) goto L_0x0016
                goto L_0x0018
            L_0x0016:
                r1 = 0
                goto L_0x0019
            L_0x0018:
                r1 = 1
            L_0x0019:
                if (r1 == 0) goto L_0x001e
                r0 = 0
                r4 = r0
                goto L_0x006f
            L_0x001e:
                java.lang.String r1 = "application/x-rawcc"
                boolean r1 = r1.equals(r0)
                if (r1 == 0) goto L_0x002e
                com.google.android.exoplayer2.extractor.f.a r0 = new com.google.android.exoplayer2.extractor.f.a
                com.google.android.exoplayer2.Format r1 = r3.f32947b
                r0.<init>(r1)
                goto L_0x0066
            L_0x002e:
                java.lang.String r1 = "video/webm"
                boolean r1 = r0.startsWith(r1)
                if (r1 != 0) goto L_0x004a
                java.lang.String r1 = "audio/webm"
                boolean r1 = r0.startsWith(r1)
                if (r1 != 0) goto L_0x004a
                java.lang.String r1 = "application/webm"
                boolean r0 = r0.startsWith(r1)
                if (r0 == 0) goto L_0x0048
                goto L_0x004a
            L_0x0048:
                r0 = 0
                goto L_0x004b
            L_0x004a:
                r0 = 1
            L_0x004b:
                if (r0 == 0) goto L_0x0053
                com.google.android.exoplayer2.extractor.c.d r0 = new com.google.android.exoplayer2.extractor.c.d
                r0.<init>(r4)
                goto L_0x0066
            L_0x0053:
                if (r16 == 0) goto L_0x0058
                r2 = 4
                r5 = 4
                goto L_0x0059
            L_0x0058:
                r5 = 0
            L_0x0059:
                com.google.android.exoplayer2.extractor.mp4.e r0 = new com.google.android.exoplayer2.extractor.mp4.e
                r6 = 0
                r7 = 0
                r8 = 0
                r4 = r0
                r9 = r17
                r10 = r18
                r4.<init>(r5, r6, r7, r8, r9, r10)
            L_0x0066:
                com.google.android.exoplayer2.source.b.e r1 = new com.google.android.exoplayer2.source.b.e
                com.google.android.exoplayer2.Format r2 = r3.f32947b
                r4 = r14
                r1.<init>(r0, r14, r2)
                r4 = r1
            L_0x006f:
                r5 = 0
                com.google.android.exoplayer2.source.dash.d r7 = r15.d()
                r0 = r11
                r1 = r12
                r3 = r15
                r0.<init>(r1, r3, r4, r5, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.f.b.<init>(long, int, com.google.android.exoplayer2.source.dash.a.i, boolean, java.util.List, com.google.android.exoplayer2.extractor.q):void");
        }
    }
}
