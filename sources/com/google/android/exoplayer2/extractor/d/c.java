package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.v;
import java.io.EOFException;
import java.io.IOException;

public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f31764a = $$Lambda$c$y6l1XnVdjPUr2KKKJ_kvIk8Pic.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final a.C0545a f31765b = $$Lambda$c$7pPfbF6PbJ3sl4fLLTj1S9mRJiw.INSTANCE;

    /* renamed from: c  reason: collision with root package name */
    private static final int f31766c = ae.h("Xing");

    /* renamed from: d  reason: collision with root package name */
    private static final int f31767d = ae.h("Info");

    /* renamed from: e  reason: collision with root package name */
    private static final int f31768e = ae.h("VBRI");

    /* renamed from: f  reason: collision with root package name */
    private final int f31769f;

    /* renamed from: g  reason: collision with root package name */
    private final long f31770g;

    /* renamed from: h  reason: collision with root package name */
    private final r f31771h;

    /* renamed from: i  reason: collision with root package name */
    private final m f31772i;
    private final k j;
    private final l k;
    private i l;
    private q m;
    private int n;
    private Metadata o;
    private a p;
    private long q;
    private long r;
    private long s;
    private int t;

    interface a extends o {
        long c();

        long c(long j);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(int i2, int i3, int i4, int i5, int i6) {
        if (i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2)) {
            return true;
        }
        if (i3 == 77 && i4 == 76 && i5 == 76) {
            return i6 == 84 || i2 == 2;
        }
        return false;
    }

    private static boolean a(int i2, long j2) {
        return ((long) (i2 & -128000)) == (j2 & -128000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new c()};
    }

    public c() {
        this(0);
    }

    public c(int i2) {
        this(i2, -9223372036854775807L);
    }

    public c(int i2, long j2) {
        this.f31769f = i2;
        this.f31770g = j2;
        this.f31771h = new r(10);
        this.f31772i = new m();
        this.j = new k();
        this.q = -9223372036854775807L;
        this.k = new l();
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        return a(hVar, true);
    }

    public final void a(i iVar) {
        this.l = iVar;
        this.m = this.l.a(0, 1);
        this.l.a();
    }

    public final void a(long j2, long j3) {
        this.n = 0;
        this.q = -9223372036854775807L;
        this.r = 0;
        this.t = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        if (r2 != f31767d) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.extractor.h r42, com.google.android.exoplayer2.extractor.n r43) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r41 = this;
            r0 = r41
            r1 = r42
            int r2 = r0.n
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x000f
            r0.a((com.google.android.exoplayer2.extractor.h) r1, (boolean) r4)     // Catch:{ EOFException -> 0x000e }
            goto L_0x000f
        L_0x000e:
            return r3
        L_0x000f:
            com.google.android.exoplayer2.extractor.d.c$a r2 = r0.p
            r5 = 1000000(0xf4240, double:4.940656E-318)
            r9 = 1
            if (r2 != 0) goto L_0x01f6
            com.google.android.exoplayer2.g.r r15 = new com.google.android.exoplayer2.g.r
            com.google.android.exoplayer2.extractor.m r2 = r0.f31772i
            int r2 = r2.f32150c
            r15.<init>((int) r2)
            byte[] r2 = r15.f32566a
            com.google.android.exoplayer2.extractor.m r10 = r0.f31772i
            int r10 = r10.f32150c
            r1.c(r2, r4, r10)
            com.google.android.exoplayer2.extractor.m r2 = r0.f31772i
            int r2 = r2.f32148a
            r2 = r2 & r9
            r10 = 36
            r11 = 21
            if (r2 == 0) goto L_0x003d
            com.google.android.exoplayer2.extractor.m r2 = r0.f31772i
            int r2 = r2.f32152e
            if (r2 == r9) goto L_0x0048
            r11 = 36
            goto L_0x0048
        L_0x003d:
            com.google.android.exoplayer2.extractor.m r2 = r0.f31772i
            int r2 = r2.f32152e
            if (r2 == r9) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            r2 = 13
            r11 = 13
        L_0x0048:
            int r2 = r15.f32568c
            int r12 = r11 + 4
            if (r2 < r12) goto L_0x005e
            r15.c(r11)
            int r2 = r15.i()
            int r12 = f31766c
            if (r2 == r12) goto L_0x0072
            int r12 = f31767d
            if (r2 != r12) goto L_0x005e
            goto L_0x0072
        L_0x005e:
            int r2 = r15.f32568c
            r12 = 40
            if (r2 < r12) goto L_0x0071
            r15.c(r10)
            int r2 = r15.i()
            int r10 = f31768e
            if (r2 != r10) goto L_0x0071
            r2 = r10
            goto L_0x0072
        L_0x0071:
            r2 = 0
        L_0x0072:
            int r10 = f31766c
            r16 = 0
            if (r2 == r10) goto L_0x009f
            int r10 = f31767d
            if (r2 != r10) goto L_0x007d
            goto L_0x009f
        L_0x007d:
            int r10 = f31768e
            if (r2 != r10) goto L_0x0098
            long r10 = r42.d()
            long r12 = r42.c()
            com.google.android.exoplayer2.extractor.m r14 = r0.f31772i
            com.google.android.exoplayer2.extractor.d.d r2 = com.google.android.exoplayer2.extractor.d.d.a(r10, r12, r14, r15)
            com.google.android.exoplayer2.extractor.m r10 = r0.f31772i
            int r10 = r10.f32150c
            r1.b(r10)
            goto L_0x017b
        L_0x0098:
            r42.a()
            r2 = r16
            goto L_0x017b
        L_0x009f:
            long r12 = r42.d()
            long r18 = r42.c()
            com.google.android.exoplayer2.extractor.m r10 = r0.f31772i
            int r14 = r10.f32154g
            int r3 = r10.f32151d
            int r17 = r15.i()
            r7 = r17 & 1
            if (r7 != r9) goto L_0x012d
            int r7 = r15.n()
            if (r7 != 0) goto L_0x00bd
            goto L_0x012d
        L_0x00bd:
            long r7 = (long) r7
            r26 = r10
            long r9 = (long) r14
            long r22 = r9 * r5
            long r9 = (long) r3
            r20 = r7
            r24 = r9
            long r21 = com.google.android.exoplayer2.g.ae.b((long) r20, (long) r22, (long) r24)
            r3 = 6
            r7 = r17 & 6
            if (r7 == r3) goto L_0x00df
            com.google.android.exoplayer2.extractor.d.e r3 = new com.google.android.exoplayer2.extractor.d.e
            r7 = r26
            int r7 = r7.f32150c
            r17 = r3
            r20 = r7
            r17.<init>(r18, r20, r21)
            goto L_0x012f
        L_0x00df:
            r7 = r26
            int r3 = r15.n()
            long r8 = (long) r3
            r3 = 100
            long[] r10 = new long[r3]
            r14 = 0
        L_0x00eb:
            if (r14 >= r3) goto L_0x00fc
            int r3 = r15.c()
            long r5 = (long) r3
            r10[r14] = r5
            int r14 = r14 + 1
            r3 = 100
            r5 = 1000000(0xf4240, double:4.940656E-318)
            goto L_0x00eb
        L_0x00fc:
            r5 = -1
            int r3 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x011d
            long r5 = r18 + r8
            int r3 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x011d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r14 = "XING data size mismatch: "
            r3.<init>(r14)
            r3.append(r12)
            java.lang.String r12 = ", "
            r3.append(r12)
            r3.append(r5)
            com.google.android.exoplayer2.g.l.c()
        L_0x011d:
            com.google.android.exoplayer2.extractor.d.e r3 = new com.google.android.exoplayer2.extractor.d.e
            int r5 = r7.f32150c
            r17 = r3
            r20 = r5
            r23 = r8
            r25 = r10
            r17.<init>(r18, r20, r21, r23, r25)
            goto L_0x012f
        L_0x012d:
            r3 = r16
        L_0x012f:
            if (r3 == 0) goto L_0x0162
            com.google.android.exoplayer2.extractor.k r5 = r0.j
            boolean r5 = r5.a()
            if (r5 != 0) goto L_0x0162
            r42.a()
            int r11 = r11 + 141
            r1.c(r11)
            com.google.android.exoplayer2.g.r r5 = r0.f31771h
            byte[] r5 = r5.f32566a
            r6 = 3
            r1.c(r5, r4, r6)
            com.google.android.exoplayer2.g.r r5 = r0.f31771h
            r5.c(r4)
            com.google.android.exoplayer2.extractor.k r5 = r0.j
            com.google.android.exoplayer2.g.r r6 = r0.f31771h
            int r6 = r6.f()
            int r7 = r6 >> 12
            r6 = r6 & 4095(0xfff, float:5.738E-42)
            if (r7 > 0) goto L_0x015e
            if (r6 <= 0) goto L_0x0162
        L_0x015e:
            r5.f32143a = r7
            r5.f32144b = r6
        L_0x0162:
            com.google.android.exoplayer2.extractor.m r5 = r0.f31772i
            int r5 = r5.f32150c
            r1.b(r5)
            if (r3 == 0) goto L_0x017a
            boolean r5 = r3.h_()
            if (r5 != 0) goto L_0x017a
            int r5 = f31767d
            if (r2 != r5) goto L_0x017a
            com.google.android.exoplayer2.extractor.d.c$a r2 = r41.c(r42)
            goto L_0x017b
        L_0x017a:
            r2 = r3
        L_0x017b:
            com.google.android.exoplayer2.metadata.Metadata r3 = r0.o
            long r5 = r42.c()
            com.google.android.exoplayer2.extractor.d.b r3 = a((com.google.android.exoplayer2.metadata.Metadata) r3, (long) r5)
            if (r3 == 0) goto L_0x018a
            r0.p = r3
            goto L_0x018e
        L_0x018a:
            if (r2 == 0) goto L_0x018e
            r0.p = r2
        L_0x018e:
            com.google.android.exoplayer2.extractor.d.c$a r2 = r0.p
            if (r2 == 0) goto L_0x019e
            boolean r2 = r2.h_()
            if (r2 != 0) goto L_0x01a4
            int r2 = r0.f31769f
            r3 = 1
            r2 = r2 & r3
            if (r2 == 0) goto L_0x01a4
        L_0x019e:
            com.google.android.exoplayer2.extractor.d.c$a r2 = r41.c(r42)
            r0.p = r2
        L_0x01a4:
            com.google.android.exoplayer2.extractor.i r2 = r0.l
            com.google.android.exoplayer2.extractor.d.c$a r3 = r0.p
            r2.a(r3)
            com.google.android.exoplayer2.extractor.q r2 = r0.m
            r27 = 0
            com.google.android.exoplayer2.extractor.m r3 = r0.f31772i
            java.lang.String r3 = r3.f32149b
            r29 = -1
            r30 = 4096(0x1000, float:5.74E-42)
            com.google.android.exoplayer2.extractor.m r5 = r0.f31772i
            int r5 = r5.f32152e
            com.google.android.exoplayer2.extractor.m r6 = r0.f31772i
            int r6 = r6.f32151d
            r33 = -1
            com.google.android.exoplayer2.extractor.k r7 = r0.j
            int r7 = r7.f32143a
            com.google.android.exoplayer2.extractor.k r8 = r0.j
            int r8 = r8.f32144b
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            int r9 = r0.f31769f
            r9 = r9 & 2
            if (r9 == 0) goto L_0x01da
            r40 = r16
            goto L_0x01de
        L_0x01da:
            com.google.android.exoplayer2.metadata.Metadata r9 = r0.o
            r40 = r9
        L_0x01de:
            r28 = r3
            r31 = r5
            r32 = r6
            r34 = r7
            r35 = r8
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            r2.a(r3)
            long r2 = r42.c()
            r0.s = r2
            goto L_0x020d
        L_0x01f6:
            long r2 = r0.s
            r5 = 0
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x020d
            long r2 = r42.c()
            long r5 = r0.s
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x020d
            long r5 = r5 - r2
            int r2 = (int) r5
            r1.b(r2)
        L_0x020d:
            int r2 = r0.t
            if (r2 != 0) goto L_0x0278
            r42.a()
            boolean r2 = r41.b(r42)
            if (r2 == 0) goto L_0x021c
            r2 = -1
            return r2
        L_0x021c:
            r2 = -1
            com.google.android.exoplayer2.g.r r3 = r0.f31771h
            r3.c(r4)
            com.google.android.exoplayer2.g.r r3 = r0.f31771h
            int r3 = r3.i()
            int r5 = r0.n
            long r5 = (long) r5
            boolean r5 = a((int) r3, (long) r5)
            if (r5 == 0) goto L_0x0271
            int r5 = com.google.android.exoplayer2.extractor.m.a(r3)
            if (r5 != r2) goto L_0x0238
            goto L_0x0271
        L_0x0238:
            com.google.android.exoplayer2.extractor.m r2 = r0.f31772i
            com.google.android.exoplayer2.extractor.m.a(r3, r2)
            long r2 = r0.q
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x026a
            com.google.android.exoplayer2.extractor.d.c$a r2 = r0.p
            long r7 = r42.c()
            long r2 = r2.c(r7)
            r0.q = r2
            long r2 = r0.f31770g
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x026a
            com.google.android.exoplayer2.extractor.d.c$a r2 = r0.p
            r5 = 0
            long r2 = r2.c(r5)
            long r5 = r0.q
            long r7 = r0.f31770g
            long r7 = r7 - r2
            long r5 = r5 + r7
            r0.q = r5
        L_0x026a:
            com.google.android.exoplayer2.extractor.m r2 = r0.f31772i
            int r2 = r2.f32150c
            r0.t = r2
            goto L_0x0278
        L_0x0271:
            r2 = 1
            r1.b(r2)
            r0.n = r4
            return r4
        L_0x0278:
            r2 = 1
            com.google.android.exoplayer2.extractor.q r3 = r0.m
            int r5 = r0.t
            int r1 = r3.a(r1, r5, r2)
            r2 = -1
            if (r1 != r2) goto L_0x0285
            return r2
        L_0x0285:
            int r2 = r0.t
            int r2 = r2 - r1
            r0.t = r2
            int r1 = r0.t
            if (r1 <= 0) goto L_0x028f
            return r4
        L_0x028f:
            long r1 = r0.q
            long r5 = r0.r
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r5 * r7
            com.google.android.exoplayer2.extractor.m r3 = r0.f31772i
            int r3 = r3.f32151d
            long r7 = (long) r3
            long r5 = r5 / r7
            long r8 = r1 + r5
            com.google.android.exoplayer2.extractor.q r7 = r0.m
            r10 = 1
            com.google.android.exoplayer2.extractor.m r1 = r0.f31772i
            int r11 = r1.f32150c
            r12 = 0
            r13 = 0
            r7.a(r8, r10, r11, r12, r13)
            long r1 = r0.r
            com.google.android.exoplayer2.extractor.m r3 = r0.f31772i
            int r3 = r3.f32154g
            long r5 = (long) r3
            long r1 = r1 + r5
            r0.r = r1
            r0.t = r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.d.c.a(com.google.android.exoplayer2.extractor.h, com.google.android.exoplayer2.extractor.n):int");
    }

    private boolean a(h hVar, boolean z) throws IOException, InterruptedException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int a2;
        a.C0545a aVar;
        int i7 = z ? 16384 : 131072;
        hVar.a();
        if (hVar.c() == 0) {
            if ((this.f31769f & 2) == 0) {
                aVar = null;
            } else {
                aVar = f31765b;
            }
            this.o = this.k.a(hVar, aVar);
            Metadata metadata = this.o;
            if (metadata != null) {
                this.j.a(metadata);
            }
            int b2 = (int) hVar.b();
            if (!z) {
                hVar.b(b2);
            }
            i2 = b2;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        while (true) {
            if (!b(hVar)) {
                this.f31771h.c(0);
                int i8 = this.f31771h.i();
                if ((i5 == 0 || a(i8, (long) i5)) && (a2 = m.a(i8)) != -1) {
                    i6 = i4 + 1;
                    if (i6 != 1) {
                        if (i6 == 4) {
                            break;
                        }
                    } else {
                        m.a(i8, this.f31772i);
                        i5 = i8;
                    }
                    hVar.c(a2 - 4);
                } else {
                    int i9 = i3 + 1;
                    if (i3 != i7) {
                        if (z) {
                            hVar.a();
                            hVar.c(i2 + i9);
                        } else {
                            hVar.b(1);
                        }
                        i3 = i9;
                        i5 = 0;
                        i6 = 0;
                    } else if (z) {
                        return false;
                    } else {
                        throw new v("Searched too many bytes.");
                    }
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            hVar.b(i2 + i3);
        } else {
            hVar.a();
        }
        this.n = i5;
        return true;
    }

    private boolean b(h hVar) throws IOException, InterruptedException {
        a aVar = this.p;
        if (aVar != null) {
            long c2 = aVar.c();
            if (c2 != -1 && hVar.b() > c2 - 4) {
                return true;
            }
        }
        try {
            if (!hVar.b(this.f31771h.f32566a, 0, 4, true)) {
                return true;
            }
            return false;
        } catch (EOFException unused) {
            return true;
        }
    }

    private a c(h hVar) throws IOException, InterruptedException {
        hVar.c(this.f31771h.f32566a, 0, 4);
        this.f31771h.c(0);
        m.a(this.f31771h.i(), this.f31772i);
        return new a(hVar.d(), hVar.c(), this.f31772i);
    }

    private static b a(Metadata metadata, long j2) {
        if (metadata == null) {
            return null;
        }
        for (Metadata.Entry entry : metadata.f32644a) {
            if (entry instanceof MlltFrame) {
                MlltFrame mlltFrame = (MlltFrame) entry;
                int length = mlltFrame.f32709d.length;
                int i2 = length + 1;
                long[] jArr = new long[i2];
                long[] jArr2 = new long[i2];
                jArr[0] = j2;
                long j3 = 0;
                jArr2[0] = 0;
                for (int i3 = 1; i3 <= length; i3++) {
                    int i4 = i3 - 1;
                    j2 += (long) (mlltFrame.f32707b + mlltFrame.f32709d[i4]);
                    j3 += (long) (mlltFrame.f32708c + mlltFrame.f32710e[i4]);
                    jArr[i3] = j2;
                    jArr2[i3] = j3;
                }
                return new b(jArr, jArr2);
            }
        }
        return null;
    }
}
