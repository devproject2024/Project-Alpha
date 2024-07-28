package com.google.android.exoplayer2.extractor.c;

import android.util.Pair;
import android.util.SparseArray;
import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.m;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import easypay.manager.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import net.one97.paytm.nativesdk.instruments.upicollect.view.UpiCollectViewNew;

public final class d implements g {
    private static final byte[] H = {TarHeader.LF_LINK, 10, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 44, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 32, 45, 45, 62, 32, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 44, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 10};
    private static final byte[] I = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] J = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 44, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 58, TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 44};
    private static final byte[] K = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */
    public static final UUID L = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: a  reason: collision with root package name */
    public static final j f31723a = $$Lambda$d$4NKUlcGdFQZKbE5g3Nixf6is5E.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    static final byte[] f31724b = ae.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    int A;
    int[] B;
    int C;
    int D;
    int E;
    boolean F;
    i G;
    private final c M;
    private final r N;
    private final r O;
    private final r P;
    private final r Q;
    private final r R;
    private final r S;
    private final r T;
    private ByteBuffer U;
    private long V;
    private int W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private boolean aa;
    private byte ab;
    private int ac;
    private int ad;
    private int ae;
    private boolean af;

    /* renamed from: c  reason: collision with root package name */
    final f f31725c;

    /* renamed from: d  reason: collision with root package name */
    final SparseArray<b> f31726d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f31727e;

    /* renamed from: f  reason: collision with root package name */
    final r f31728f;

    /* renamed from: g  reason: collision with root package name */
    final r f31729g;

    /* renamed from: h  reason: collision with root package name */
    long f31730h;

    /* renamed from: i  reason: collision with root package name */
    long f31731i;
    long j;
    long k;
    long l;
    b m;
    boolean n;
    int o;
    long p;
    boolean q;
    long r;
    long s;
    m t;
    m u;
    boolean v;
    int w;
    long x;
    long y;
    int z;

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        final byte[] f31742a = new byte[10];

        /* renamed from: b  reason: collision with root package name */
        boolean f31743b;

        /* renamed from: c  reason: collision with root package name */
        int f31744c;

        /* renamed from: d  reason: collision with root package name */
        int f31745d;

        /* renamed from: e  reason: collision with root package name */
        long f31746e;

        /* renamed from: f  reason: collision with root package name */
        int f31747f;
    }

    protected static int a(int i2) {
        switch (i2) {
            case 131:
            case 136:
            case 155:
            case Constants.ACTION_NB_NEXT_BTN_CLICKED /*159*/:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case UpiCollectViewNew.REQUEST_CODE_UPI_APP /*187*/:
            case Constants.EASY_PAY_INVISIBLE_ASSIST /*224*/:
            case Constants.EASY_PAY_GENERIC_CALLBACK /*225*/:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case Constants.ACTION_NB_WV_LOGIN_CLICKED /*161*/:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected static boolean b(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] c() {
        return new g[]{new d()};
    }

    public d() {
        this(0);
    }

    public d(int i2) {
        this(new a(), i2);
    }

    private d(c cVar, int i2) {
        this.f31731i = -1;
        this.j = -9223372036854775807L;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.r = -1;
        this.V = -1;
        this.s = -9223372036854775807L;
        this.M = cVar;
        this.M.a((b) new a(this, (byte) 0));
        this.f31727e = (i2 & 1) != 0 ? false : true;
        this.f31725c = new f();
        this.f31726d = new SparseArray<>();
        this.f31728f = new r(4);
        this.P = new r(ByteBuffer.allocate(4).putInt(-1).array());
        this.f31729g = new r(4);
        this.N = new r(p.f32546a);
        this.O = new r(4);
        this.Q = new r();
        this.R = new r();
        this.S = new r(8);
        this.T = new r();
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        long a2;
        int i2;
        h hVar2 = hVar;
        e eVar = new e();
        long d2 = hVar.d();
        long j2 = 1024;
        int i3 = (d2 > -1 ? 1 : (d2 == -1 ? 0 : -1));
        if (i3 != 0 && d2 <= 1024) {
            j2 = d2;
        }
        int i4 = (int) j2;
        hVar2.c(eVar.f31748a.f32566a, 0, 4);
        long g2 = eVar.f31748a.g();
        eVar.f31749b = 4;
        while (true) {
            if (g2 != 440786851) {
                int i5 = eVar.f31749b + 1;
                eVar.f31749b = i5;
                if (i5 == i4) {
                    break;
                }
                hVar2.c(eVar.f31748a.f32566a, 0, 1);
                g2 = ((g2 << 8) & -256) | ((long) (eVar.f31748a.f32566a[0] & 255));
            } else {
                long a3 = eVar.a(hVar2);
                long j3 = (long) eVar.f31749b;
                if (a3 != Long.MIN_VALUE && (i3 == 0 || j3 + a3 < d2)) {
                    while (true) {
                        long j4 = j3 + a3;
                        if (((long) eVar.f31749b) < j4) {
                            if (eVar.a(hVar2) == Long.MIN_VALUE || a2 < 0 || a2 > 2147483647L) {
                                return false;
                            }
                            if (i2 != 0) {
                                int a4 = (int) (a2 = eVar.a(hVar2));
                                hVar2.c(a4);
                                eVar.f31749b += a4;
                            }
                        } else if (((long) eVar.f31749b) == j4) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void a(i iVar) {
        this.G = iVar;
    }

    public final void a(long j2, long j3) {
        this.s = -9223372036854775807L;
        this.w = 0;
        this.M.a();
        this.f31725c.a();
        b();
        for (int i2 = 0; i2 < this.f31726d.size(); i2++) {
            b valueAt = this.f31726d.valueAt(i2);
            if (valueAt.Q != null) {
                valueAt.Q.f31743b = false;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0039 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0005 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.extractor.h r11, com.google.android.exoplayer2.extractor.n r12) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r10 = this;
            r0 = 0
            r10.af = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            if (r2 == 0) goto L_0x003a
            boolean r3 = r10.af
            if (r3 != 0) goto L_0x003a
            com.google.android.exoplayer2.extractor.c.c r2 = r10.M
            boolean r2 = r2.a((com.google.android.exoplayer2.extractor.h) r11)
            if (r2 == 0) goto L_0x0005
            long r3 = r11.c()
            boolean r5 = r10.q
            if (r5 == 0) goto L_0x0025
            r10.V = r3
            long r3 = r10.r
            r12.f32288a = r3
            r10.q = r0
        L_0x0023:
            r3 = 1
            goto L_0x0037
        L_0x0025:
            boolean r3 = r10.n
            if (r3 == 0) goto L_0x0036
            long r3 = r10.V
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            r12.f32288a = r3
            r10.V = r5
            goto L_0x0023
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x0005
            return r1
        L_0x003a:
            if (r2 != 0) goto L_0x0070
            r11 = 0
        L_0x003d:
            android.util.SparseArray<com.google.android.exoplayer2.extractor.c.d$b> r12 = r10.f31726d
            int r12 = r12.size()
            if (r11 >= r12) goto L_0x006e
            android.util.SparseArray<com.google.android.exoplayer2.extractor.c.d$b> r12 = r10.f31726d
            java.lang.Object r12 = r12.valueAt(r11)
            com.google.android.exoplayer2.extractor.c.d$b r12 = (com.google.android.exoplayer2.extractor.c.d.b) r12
            com.google.android.exoplayer2.extractor.c.d$c r1 = r12.Q
            if (r1 == 0) goto L_0x006b
            com.google.android.exoplayer2.extractor.c.d$c r1 = r12.Q
            boolean r2 = r1.f31743b
            if (r2 == 0) goto L_0x006b
            int r2 = r1.f31744c
            if (r2 <= 0) goto L_0x006b
            com.google.android.exoplayer2.extractor.q r3 = r12.U
            long r4 = r1.f31746e
            int r6 = r1.f31747f
            int r7 = r1.f31745d
            r8 = 0
            com.google.android.exoplayer2.extractor.q$a r9 = r12.f31740h
            r3.a(r4, r6, r7, r8, r9)
            r1.f31744c = r0
        L_0x006b:
            int r11 = r11 + 1
            goto L_0x003d
        L_0x006e:
            r11 = -1
            return r11
        L_0x0070:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.c.d.a(com.google.android.exoplayer2.extractor.h, com.google.android.exoplayer2.extractor.n):int");
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar, long j2) {
        b bVar2 = bVar;
        if (bVar2.Q != null) {
            c cVar = bVar2.Q;
            if (cVar.f31743b) {
                int i2 = cVar.f31744c;
                cVar.f31744c = i2 + 1;
                if (i2 == 0) {
                    cVar.f31746e = j2;
                }
                if (cVar.f31744c >= 16) {
                    bVar2.U.a(cVar.f31746e, cVar.f31747f, cVar.f31745d, 0, bVar2.f31740h);
                    cVar.f31744c = 0;
                }
            }
        } else {
            long j3 = j2;
            if ("S_TEXT/UTF8".equals(bVar2.f31734b)) {
                a(bVar, "%02d:%02d:%02d,%03d", 19, 1000, I);
            } else if ("S_TEXT/ASS".equals(bVar2.f31734b)) {
                a(bVar, "%01d:%02d:%02d:%02d", 21, 10000, K);
            }
            bVar2.U.a(j2, this.E, this.ae, 0, bVar2.f31740h);
        }
        this.af = true;
        b();
    }

    private void b() {
        this.W = 0;
        this.ae = 0;
        this.ad = 0;
        this.X = false;
        this.Y = false;
        this.aa = false;
        this.ac = 0;
        this.ab = 0;
        this.Z = false;
        this.Q.a();
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar, int i2) throws IOException, InterruptedException {
        if (this.f31728f.f32568c < i2) {
            if (this.f31728f.f32566a.length < i2) {
                r rVar = this.f31728f;
                rVar.a(Arrays.copyOf(rVar.f32566a, Math.max(this.f31728f.f32566a.length * 2, i2)), this.f31728f.f32568c);
            }
            hVar.b(this.f31728f.f32566a, this.f31728f.f32568c, i2 - this.f31728f.f32568c);
            this.f31728f.b(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar, b bVar, int i2) throws IOException, InterruptedException {
        int i3;
        if ("S_TEXT/UTF8".equals(bVar.f31734b)) {
            a(hVar, H, i2);
        } else if ("S_TEXT/ASS".equals(bVar.f31734b)) {
            a(hVar, J, i2);
        } else {
            q qVar = bVar.U;
            if (!this.X) {
                if (bVar.f31738f) {
                    this.E &= -1073741825;
                    int i4 = 128;
                    if (!this.Y) {
                        hVar.b(this.f31728f.f32566a, 0, 1);
                        this.W++;
                        if ((this.f31728f.f32566a[0] & 128) != 128) {
                            this.ab = this.f31728f.f32566a[0];
                            this.Y = true;
                        } else {
                            throw new v("Extension bit is set in signal byte");
                        }
                    }
                    if ((this.ab & 1) == 1) {
                        boolean z2 = (this.ab & 2) == 2;
                        this.E |= 1073741824;
                        if (!this.Z) {
                            hVar.b(this.S.f32566a, 0, 8);
                            this.W += 8;
                            this.Z = true;
                            byte[] bArr = this.f31728f.f32566a;
                            if (!z2) {
                                i4 = 0;
                            }
                            bArr[0] = (byte) (i4 | 8);
                            this.f31728f.c(0);
                            qVar.a(this.f31728f, 1);
                            this.ae++;
                            this.S.c(0);
                            qVar.a(this.S, 8);
                            this.ae += 8;
                        }
                        if (z2) {
                            if (!this.aa) {
                                hVar.b(this.f31728f.f32566a, 0, 1);
                                this.W++;
                                this.f31728f.c(0);
                                this.ac = this.f31728f.c();
                                this.aa = true;
                            }
                            int i5 = this.ac * 4;
                            this.f31728f.a(i5);
                            hVar.b(this.f31728f.f32566a, 0, i5);
                            this.W += i5;
                            short s2 = (short) ((this.ac / 2) + 1);
                            int i6 = (s2 * 6) + 2;
                            ByteBuffer byteBuffer = this.U;
                            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                                this.U = ByteBuffer.allocate(i6);
                            }
                            this.U.position(0);
                            this.U.putShort(s2);
                            int i7 = 0;
                            int i8 = 0;
                            while (true) {
                                i3 = this.ac;
                                if (i7 >= i3) {
                                    break;
                                }
                                int n2 = this.f31728f.n();
                                if (i7 % 2 == 0) {
                                    this.U.putShort((short) (n2 - i8));
                                } else {
                                    this.U.putInt(n2 - i8);
                                }
                                i7++;
                                i8 = n2;
                            }
                            int i9 = (i2 - this.W) - i8;
                            if (i3 % 2 == 1) {
                                this.U.putInt(i9);
                            } else {
                                this.U.putShort((short) i9);
                                this.U.putInt(0);
                            }
                            this.T.a(this.U.array(), i6);
                            qVar.a(this.T, i6);
                            this.ae += i6;
                        }
                    }
                } else if (bVar.f31739g != null) {
                    this.Q.a(bVar.f31739g, bVar.f31739g.length);
                }
                this.X = true;
            }
            int i10 = i2 + this.Q.f32568c;
            if (!"V_MPEG4/ISO/AVC".equals(bVar.f31734b) && !"V_MPEGH/ISO/HEVC".equals(bVar.f31734b)) {
                if (bVar.Q != null) {
                    com.google.android.exoplayer2.g.a.b(this.Q.f32568c == 0);
                    c cVar = bVar.Q;
                    int i11 = this.E;
                    if (!cVar.f31743b) {
                        hVar.c(cVar.f31742a, 0, 10);
                        hVar.a();
                        if (com.google.android.exoplayer2.b.a.b(cVar.f31742a) != 0) {
                            cVar.f31743b = true;
                            cVar.f31744c = 0;
                        }
                    }
                    if (cVar.f31744c == 0) {
                        cVar.f31747f = i11;
                        cVar.f31745d = 0;
                    }
                    cVar.f31745d += i10;
                }
                while (true) {
                    int i12 = this.W;
                    if (i12 >= i10) {
                        break;
                    }
                    a(hVar, qVar, i10 - i12);
                }
            } else {
                byte[] bArr2 = this.O.f32566a;
                bArr2[0] = 0;
                bArr2[1] = 0;
                bArr2[2] = 0;
                int i13 = bVar.V;
                int i14 = 4 - bVar.V;
                while (this.W < i10) {
                    int i15 = this.ad;
                    if (i15 == 0) {
                        int min = Math.min(i13, this.Q.b());
                        hVar.b(bArr2, i14 + min, i13 - min);
                        if (min > 0) {
                            this.Q.a(bArr2, i14, min);
                        }
                        this.W += i13;
                        this.O.c(0);
                        this.ad = this.O.n();
                        this.N.c(0);
                        qVar.a(this.N, 4);
                        this.ae += 4;
                    } else {
                        this.ad = i15 - a(hVar, qVar, i15);
                    }
                }
            }
            if ("A_VORBIS".equals(bVar.f31734b)) {
                this.P.c(0);
                qVar.a(this.P, 4);
                this.ae += 4;
            }
        }
    }

    private void a(h hVar, byte[] bArr, int i2) throws IOException, InterruptedException {
        int length = bArr.length + i2;
        if (this.R.f32566a.length < length) {
            this.R.f32566a = Arrays.copyOf(bArr, length + i2);
        } else {
            System.arraycopy(bArr, 0, this.R.f32566a, 0, bArr.length);
        }
        hVar.b(this.R.f32566a, bArr.length, i2);
        this.R.a(length);
    }

    private void a(b bVar, String str, int i2, long j2, byte[] bArr) {
        a(this.R.f32566a, this.y, str, i2, j2, bArr);
        q qVar = bVar.U;
        r rVar = this.R;
        qVar.a(rVar, rVar.f32568c);
        this.ae += this.R.f32568c;
    }

    private static void a(byte[] bArr, long j2, String str, int i2, long j3, byte[] bArr2) {
        byte[] bArr3;
        byte[] bArr4;
        if (j2 == -9223372036854775807L) {
            bArr4 = bArr2;
            bArr3 = bArr4;
        } else {
            int i3 = (int) (j2 / 3600000000L);
            long j4 = j2 - (((long) (i3 * 3600)) * 1000000);
            int i4 = (int) (j4 / 60000000);
            long j5 = j4 - (((long) (i4 * 60)) * 1000000);
            int i5 = (int) (j5 / 1000000);
            int i6 = (int) ((j5 - (((long) i5) * 1000000)) / j3);
            Locale locale = Locale.US;
            Object[] objArr = {Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            String str2 = str;
            bArr3 = ae.c(String.format(locale, str, objArr));
            bArr4 = bArr2;
        }
        byte[] bArr5 = bArr;
        int i7 = i2;
        System.arraycopy(bArr3, 0, bArr, i2, bArr4.length);
    }

    private int a(h hVar, q qVar, int i2) throws IOException, InterruptedException {
        int i3;
        int b2 = this.Q.b();
        if (b2 > 0) {
            i3 = Math.min(i2, b2);
            qVar.a(this.Q, i3);
        } else {
            i3 = qVar.a(hVar, i2, false);
        }
        this.W += i3;
        this.ae += i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final long a(long j2) throws v {
        long j3 = this.j;
        if (j3 != -9223372036854775807L) {
            return ae.b(j2, j3, 1000);
        }
        throw new v("Can't scale timecode prior to timecodeScale being set.");
    }

    static int[] a(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        if (iArr.length >= i2) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i2)];
    }

    final class a implements b {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final int a(int i2) {
            return d.a(i2);
        }

        public final boolean b(int i2) {
            return d.b(i2);
        }

        public final void a(int i2, long j, long j2) throws v {
            d dVar = d.this;
            if (i2 == 160) {
                dVar.F = false;
            } else if (i2 == 174) {
                dVar.m = new b((byte) 0);
            } else if (i2 == 187) {
                dVar.v = false;
            } else if (i2 == 19899) {
                dVar.o = -1;
                dVar.p = -1;
            } else if (i2 == 20533) {
                dVar.m.f31738f = true;
            } else if (i2 == 21968) {
                dVar.m.v = true;
            } else if (i2 == 25152) {
            } else {
                if (i2 != 408125543) {
                    if (i2 == 475249515) {
                        dVar.t = new m();
                        dVar.u = new m();
                    } else if (i2 != 524531317 || dVar.n) {
                    } else {
                        if (!dVar.f31727e || dVar.r == -1) {
                            dVar.G.a(new o.b(dVar.l));
                            dVar.n = true;
                            return;
                        }
                        dVar.q = true;
                    }
                } else if (dVar.f31731i == -1 || dVar.f31731i == j) {
                    dVar.f31731i = j;
                    dVar.f31730h = j2;
                } else {
                    throw new v("Multiple Segment elements not supported");
                }
            }
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x0431, code lost:
            r18 = r3;
            r3 = null;
            r13 = r11;
            r15 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:260:0x04a1, code lost:
            r3 = null;
            r13 = r11;
            r15 = 4096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:268:0x0547, code lost:
            r13 = r3;
            r3 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:278:0x0569, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:279:0x056a, code lost:
            r13 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:280:0x056b, code lost:
            r15 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:281:0x056c, code lost:
            r18 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:282:0x056e, code lost:
            r11 = r1.S | false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:283:0x0573, code lost:
            if (r1.R == false) goto L_0x0577;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:284:0x0575, code lost:
            r12 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:285:0x0577, code lost:
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:286:0x0578, code lost:
            r11 = r11 | r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:287:0x057d, code lost:
            if (com.google.android.exoplayer2.g.o.a(r13) == false) goto L_0x059f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:288:0x057f, code lost:
            r3 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r10), r13, -1, r15, r1.L, r1.N, r18, r3, r1.j, r11 ? 1 : 0, r1.T);
            r4 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:290:0x05a3, code lost:
            if (com.google.android.exoplayer2.g.o.b(r13) == false) goto L_0x0766;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:292:0x05a7, code lost:
            if (r1.o != 0) goto L_0x05bf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:294:0x05ab, code lost:
            if (r1.m != -1) goto L_0x05b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:295:0x05ad, code lost:
            r5 = r1.k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:296:0x05b0, code lost:
            r5 = r1.m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:297:0x05b2, code lost:
            r1.m = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:298:0x05b6, code lost:
            if (r1.n != -1) goto L_0x05bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:299:0x05b8, code lost:
            r5 = r1.l;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:300:0x05bb, code lost:
            r5 = r1.n;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:301:0x05bd, code lost:
            r1.n = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:303:0x05c3, code lost:
            if (r1.m == -1) goto L_0x05db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:305:0x05c7, code lost:
            if (r1.n == -1) goto L_0x05db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:306:0x05c9, code lost:
            r20 = ((float) (r1.l * r1.m)) / ((float) (r1.k * r1.n));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:307:0x05db, code lost:
            r20 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:309:0x05df, code lost:
            if (r1.v == false) goto L_0x06b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:311:0x05e5, code lost:
            if (r1.B == -1.0f) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:313:0x05eb, code lost:
            if (r1.C == -1.0f) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:315:0x05f1, code lost:
            if (r1.D == -1.0f) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:317:0x05f7, code lost:
            if (r1.E == -1.0f) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:319:0x05fd, code lost:
            if (r1.F == -1.0f) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:321:0x0603, code lost:
            if (r1.G == -1.0f) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:323:0x0609, code lost:
            if (r1.H == -1.0f) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:325:0x060f, code lost:
            if (r1.I == -1.0f) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:327:0x0615, code lost:
            if (r1.J == -1.0f) goto L_0x06a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:329:0x061b, code lost:
            if (r1.K != -1.0f) goto L_0x061f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:330:0x061f, code lost:
            r5 = new byte[25];
            r11 = java.nio.ByteBuffer.wrap(r5);
            r11.put((byte) 0);
            r11.putShort((short) ((int) ((r1.B * 50000.0f) + 0.5f)));
            r11.putShort((short) ((int) ((r1.C * 50000.0f) + 0.5f)));
            r11.putShort((short) ((int) ((r1.D * 50000.0f) + 0.5f)));
            r11.putShort((short) ((int) ((r1.E * 50000.0f) + 0.5f)));
            r11.putShort((short) ((int) ((r1.F * 50000.0f) + 0.5f)));
            r11.putShort((short) ((int) ((r1.G * 50000.0f) + 0.5f)));
            r11.putShort((short) ((int) ((r1.H * 50000.0f) + 0.5f)));
            r11.putShort((short) ((int) ((r1.I * 50000.0f) + 0.5f)));
            r11.putShort((short) ((int) (r1.J + 0.5f)));
            r11.putShort((short) ((int) (r1.K + 0.5f)));
            r11.putShort((short) r1.z);
            r11.putShort((short) r1.A);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:331:0x06a6, code lost:
            r5 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:332:0x06a7, code lost:
            r23 = new com.google.android.exoplayer2.video.ColorInfo(r1.w, r1.y, r1.x, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:333:0x06b5, code lost:
            r23 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:335:0x06bf, code lost:
            if ("htc_video_rotA-000".equals(r1.f31733a) == false) goto L_0x06c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:336:0x06c1, code lost:
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:338:0x06cb, code lost:
            if ("htc_video_rotA-090".equals(r1.f31733a) == false) goto L_0x06d0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:339:0x06cd, code lost:
            r5 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:341:0x06d8, code lost:
            if ("htc_video_rotA-180".equals(r1.f31733a) == false) goto L_0x06dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:342:0x06da, code lost:
            r5 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.READ_TIME_OUT;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:344:0x06e5, code lost:
            if ("htc_video_rotA-270".equals(r1.f31733a) == false) goto L_0x06ea;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:345:0x06e7, code lost:
            r5 = 270;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:346:0x06ea, code lost:
            r5 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:348:0x06ed, code lost:
            if (r1.p != 0) goto L_0x0743;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:350:0x06f6, code lost:
            if (java.lang.Float.compare(r1.q, 0.0f) != 0) goto L_0x0743;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:352:0x06fe, code lost:
            if (java.lang.Float.compare(r1.r, 0.0f) != 0) goto L_0x0743;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:354:0x0706, code lost:
            if (java.lang.Float.compare(r1.s, 0.0f) != 0) goto L_0x070b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:355:0x0708, code lost:
            r19 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:357:0x0713, code lost:
            if (java.lang.Float.compare(r1.r, 90.0f) != 0) goto L_0x071a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:358:0x0715, code lost:
            r19 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:360:0x0722, code lost:
            if (java.lang.Float.compare(r1.r, -180.0f) == 0) goto L_0x073e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:362:0x072c, code lost:
            if (java.lang.Float.compare(r1.r, 180.0f) != 0) goto L_0x072f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:364:0x0737, code lost:
            if (java.lang.Float.compare(r1.r, -90.0f) != 0) goto L_0x0743;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:365:0x0739, code lost:
            r19 = 270;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:366:0x073e, code lost:
            r19 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.READ_TIME_OUT;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:367:0x0743, code lost:
            r19 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:368:0x0745, code lost:
            r3 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r10), r13, (java.lang.String) null, r15, r1.k, r1.l, r3, r19, r20, r1.t, r1.u, r23, r1.j);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:370:0x076c, code lost:
            if ("application/x-subrip".equals(r13) == false) goto L_0x077c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:371:0x076e, code lost:
            r3 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r10), r13, r11 ? 1 : 0, r1.T, r1.j);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:372:0x077a, code lost:
            r4 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:374:0x0783, code lost:
            if ("text/x-ssa".equals(r13) == false) goto L_0x07ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:375:0x0785, code lost:
            r3 = new java.util.ArrayList(2);
            r3.add(com.google.android.exoplayer2.extractor.c.d.f31724b);
            r3.add(r1.f31741i);
            r3 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r10), r13, r11 ? 1 : 0, r1.T, -1, r1.j, Long.MAX_VALUE, (java.util.List<byte[]>) r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:377:0x07b3, code lost:
            if ("application/vobsub".equals(r13) != false) goto L_0x07ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:379:0x07bb, code lost:
            if ("application/pgs".equals(r13) != false) goto L_0x07ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:381:0x07c3, code lost:
            if ("application/dvbsubs".equals(r13) == false) goto L_0x07c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:383:0x07cd, code lost:
            throw new com.google.android.exoplayer2.v("Unexpected MIME type.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:384:0x07ce, code lost:
            r3 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r10), r13, r11 ? 1 : 0, r3, r1.T, r1.j);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:385:0x07e1, code lost:
            r1.U = r9.a(r1.f31735c, r4);
            r1.U.a(r3);
            r2.f31726d.put(r2.m.f31735c, r2.m);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void c(int r26) throws com.google.android.exoplayer2.v {
            /*
                r25 = this;
                r0 = r25
                r1 = r26
                com.google.android.exoplayer2.extractor.c.d r2 = com.google.android.exoplayer2.extractor.c.d.this
                r3 = 160(0xa0, float:2.24E-43)
                r4 = 2
                r5 = 1
                r6 = 0
                if (r1 == r3) goto L_0x07fc
                r3 = 174(0xae, float:2.44E-43)
                r7 = 0
                r8 = -1
                if (r1 == r3) goto L_0x0161
                r3 = 19899(0x4dbb, float:2.7884E-41)
                r4 = 475249515(0x1c53bb6b, float:7.0056276E-22)
                if (r1 == r3) goto L_0x0144
                r3 = 25152(0x6240, float:3.5245E-41)
                if (r1 == r3) goto L_0x0112
                r3 = 28032(0x6d80, float:3.9281E-41)
                if (r1 == r3) goto L_0x00fc
                r3 = 357149030(0x1549a966, float:4.072526E-26)
                r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                if (r1 == r3) goto L_0x00e2
                r3 = 374648427(0x1654ae6b, float:1.718026E-25)
                if (r1 == r3) goto L_0x00cb
                if (r1 == r4) goto L_0x0035
                goto L_0x081a
            L_0x0035:
                boolean r1 = r2.n
                if (r1 != 0) goto L_0x081a
                com.google.android.exoplayer2.extractor.i r1 = r2.G
                long r3 = r2.f31731i
                r10 = -1
                int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
                if (r12 == 0) goto L_0x00ba
                long r3 = r2.l
                int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
                if (r10 == 0) goto L_0x00ba
                com.google.android.exoplayer2.g.m r3 = r2.t
                if (r3 == 0) goto L_0x00ba
                com.google.android.exoplayer2.g.m r3 = r2.t
                int r3 = r3.f32540a
                if (r3 == 0) goto L_0x00ba
                com.google.android.exoplayer2.g.m r3 = r2.u
                if (r3 == 0) goto L_0x00ba
                com.google.android.exoplayer2.g.m r3 = r2.u
                int r3 = r3.f32540a
                com.google.android.exoplayer2.g.m r4 = r2.t
                int r4 = r4.f32540a
                if (r3 == r4) goto L_0x0062
                goto L_0x00ba
            L_0x0062:
                com.google.android.exoplayer2.g.m r3 = r2.t
                int r3 = r3.f32540a
                int[] r4 = new int[r3]
                long[] r8 = new long[r3]
                long[] r9 = new long[r3]
                long[] r10 = new long[r3]
                r11 = 0
            L_0x006f:
                if (r11 >= r3) goto L_0x0087
                com.google.android.exoplayer2.g.m r12 = r2.t
                long r12 = r12.a((int) r11)
                r10[r11] = r12
                long r12 = r2.f31731i
                com.google.android.exoplayer2.g.m r14 = r2.u
                long r14 = r14.a((int) r11)
                long r12 = r12 + r14
                r8[r11] = r12
                int r11 = r11 + 1
                goto L_0x006f
            L_0x0087:
                int r11 = r3 + -1
                if (r6 >= r11) goto L_0x009e
                int r11 = r6 + 1
                r12 = r8[r11]
                r14 = r8[r6]
                long r12 = r12 - r14
                int r13 = (int) r12
                r4[r6] = r13
                r12 = r10[r11]
                r14 = r10[r6]
                long r12 = r12 - r14
                r9[r6] = r12
                r6 = r11
                goto L_0x0087
            L_0x009e:
                long r12 = r2.f31731i
                long r14 = r2.f31730h
                long r12 = r12 + r14
                r14 = r8[r11]
                long r12 = r12 - r14
                int r3 = (int) r12
                r4[r11] = r3
                long r12 = r2.l
                r14 = r10[r11]
                long r12 = r12 - r14
                r9[r11] = r12
                r2.t = r7
                r2.u = r7
                com.google.android.exoplayer2.extractor.b r3 = new com.google.android.exoplayer2.extractor.b
                r3.<init>(r4, r8, r9, r10)
                goto L_0x00c5
            L_0x00ba:
                r2.t = r7
                r2.u = r7
                com.google.android.exoplayer2.extractor.o$b r3 = new com.google.android.exoplayer2.extractor.o$b
                long r6 = r2.l
                r3.<init>(r6)
            L_0x00c5:
                r1.a(r3)
                r2.n = r5
                return
            L_0x00cb:
                android.util.SparseArray<com.google.android.exoplayer2.extractor.c.d$b> r1 = r2.f31726d
                int r1 = r1.size()
                if (r1 == 0) goto L_0x00da
                com.google.android.exoplayer2.extractor.i r1 = r2.G
                r1.a()
                goto L_0x081a
            L_0x00da:
                com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
                java.lang.String r2 = "No valid tracks were found"
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x00e2:
                long r3 = r2.j
                int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
                if (r1 != 0) goto L_0x00ed
                r3 = 1000000(0xf4240, double:4.940656E-318)
                r2.j = r3
            L_0x00ed:
                long r3 = r2.k
                int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
                if (r1 == 0) goto L_0x081a
                long r3 = r2.k
                long r3 = r2.a((long) r3)
                r2.l = r3
                return
            L_0x00fc:
                com.google.android.exoplayer2.extractor.c.d$b r1 = r2.m
                boolean r1 = r1.f31738f
                if (r1 == 0) goto L_0x081a
                com.google.android.exoplayer2.extractor.c.d$b r1 = r2.m
                byte[] r1 = r1.f31739g
                if (r1 != 0) goto L_0x010a
                goto L_0x081a
            L_0x010a:
                com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
                java.lang.String r2 = "Combining encryption and compression is not supported"
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x0112:
                com.google.android.exoplayer2.extractor.c.d$b r1 = r2.m
                boolean r1 = r1.f31738f
                if (r1 == 0) goto L_0x081a
                com.google.android.exoplayer2.extractor.c.d$b r1 = r2.m
                com.google.android.exoplayer2.extractor.q$a r1 = r1.f31740h
                if (r1 == 0) goto L_0x013c
                com.google.android.exoplayer2.extractor.c.d$b r1 = r2.m
                com.google.android.exoplayer2.drm.DrmInitData r3 = new com.google.android.exoplayer2.drm.DrmInitData
                com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r4 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r5]
                com.google.android.exoplayer2.drm.DrmInitData$SchemeData r5 = new com.google.android.exoplayer2.drm.DrmInitData$SchemeData
                java.util.UUID r7 = com.google.android.exoplayer2.c.f31284a
                com.google.android.exoplayer2.extractor.c.d$b r2 = r2.m
                com.google.android.exoplayer2.extractor.q$a r2 = r2.f31740h
                byte[] r2 = r2.f32297b
                java.lang.String r8 = "video/webm"
                r5.<init>(r7, r8, r2)
                r4[r6] = r5
                r3.<init>((com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r4)
                r1.j = r3
                return
            L_0x013c:
                com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
                java.lang.String r2 = "Encrypted Track found but ContentEncKeyID was not found"
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x0144:
                int r1 = r2.o
                if (r1 == r8) goto L_0x0159
                long r5 = r2.p
                r7 = -1
                int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r1 == 0) goto L_0x0159
                int r1 = r2.o
                if (r1 != r4) goto L_0x081a
                long r3 = r2.p
                r2.r = r3
                return
            L_0x0159:
                com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
                java.lang.String r2 = "Mandatory element SeekID or SeekPosition not found"
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x0161:
                com.google.android.exoplayer2.extractor.c.d$b r1 = r2.m
                java.lang.String r1 = r1.f31734b
                java.lang.String r3 = "V_VP8"
                boolean r9 = r3.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_VP9"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_AV1"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_MPEG2"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_MPEG4/ISO/SP"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_MPEG4/ISO/ASP"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_MPEG4/ISO/AP"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_MPEG4/ISO/AVC"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_MPEGH/ISO/HEVC"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_MS/VFW/FOURCC"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "V_THEORA"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_OPUS"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_VORBIS"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_AAC"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_MPEG/L2"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_MPEG/L3"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_AC3"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_EAC3"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_TRUEHD"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_DTS"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_DTS/EXPRESS"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_DTS/LOSSLESS"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_FLAC"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_MS/ACM"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "A_PCM/INT/LIT"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "S_TEXT/UTF8"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "S_TEXT/ASS"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "S_VOBSUB"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "S_HDMV/PGS"
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0258
                java.lang.String r9 = "S_DVBSUB"
                boolean r1 = r9.equals(r1)
                if (r1 == 0) goto L_0x0256
                goto L_0x0258
            L_0x0256:
                r1 = 0
                goto L_0x0259
            L_0x0258:
                r1 = 1
            L_0x0259:
                if (r1 == 0) goto L_0x07f9
                com.google.android.exoplayer2.extractor.c.d$b r1 = r2.m
                com.google.android.exoplayer2.extractor.i r9 = r2.G
                com.google.android.exoplayer2.extractor.c.d$b r10 = r2.m
                int r10 = r10.f31735c
                java.lang.String r11 = r1.f31734b
                int r12 = r11.hashCode()
                r13 = 8
                r14 = 3
                switch(r12) {
                    case -2095576542: goto L_0x03bc;
                    case -2095575984: goto L_0x03b2;
                    case -1985379776: goto L_0x03a7;
                    case -1784763192: goto L_0x039c;
                    case -1730367663: goto L_0x0391;
                    case -1482641358: goto L_0x0386;
                    case -1482641357: goto L_0x037b;
                    case -1373388978: goto L_0x0370;
                    case -933872740: goto L_0x0365;
                    case -538363189: goto L_0x035a;
                    case -538363109: goto L_0x034f;
                    case -425012669: goto L_0x0343;
                    case -356037306: goto L_0x0337;
                    case 62923557: goto L_0x032b;
                    case 62923603: goto L_0x031f;
                    case 62927045: goto L_0x0313;
                    case 82318131: goto L_0x0308;
                    case 82338133: goto L_0x02ff;
                    case 82338134: goto L_0x02f4;
                    case 99146302: goto L_0x02e8;
                    case 444813526: goto L_0x02dc;
                    case 542569478: goto L_0x02d0;
                    case 725957860: goto L_0x02c4;
                    case 738597099: goto L_0x02b8;
                    case 855502857: goto L_0x02ac;
                    case 1422270023: goto L_0x02a0;
                    case 1809237540: goto L_0x0295;
                    case 1950749482: goto L_0x0289;
                    case 1950789798: goto L_0x027d;
                    case 1951062397: goto L_0x0271;
                    default: goto L_0x026f;
                }
            L_0x026f:
                goto L_0x03c6
            L_0x0271:
                java.lang.String r3 = "A_OPUS"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 12
                goto L_0x03c7
            L_0x027d:
                java.lang.String r3 = "A_FLAC"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 22
                goto L_0x03c7
            L_0x0289:
                java.lang.String r3 = "A_EAC3"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 17
                goto L_0x03c7
            L_0x0295:
                java.lang.String r3 = "V_MPEG2"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 3
                goto L_0x03c7
            L_0x02a0:
                java.lang.String r3 = "S_TEXT/UTF8"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 25
                goto L_0x03c7
            L_0x02ac:
                java.lang.String r3 = "V_MPEGH/ISO/HEVC"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 8
                goto L_0x03c7
            L_0x02b8:
                java.lang.String r3 = "S_TEXT/ASS"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 26
                goto L_0x03c7
            L_0x02c4:
                java.lang.String r3 = "A_PCM/INT/LIT"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 24
                goto L_0x03c7
            L_0x02d0:
                java.lang.String r3 = "A_DTS/EXPRESS"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 20
                goto L_0x03c7
            L_0x02dc:
                java.lang.String r3 = "V_THEORA"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 10
                goto L_0x03c7
            L_0x02e8:
                java.lang.String r3 = "S_HDMV/PGS"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 28
                goto L_0x03c7
            L_0x02f4:
                java.lang.String r3 = "V_VP9"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 1
                goto L_0x03c7
            L_0x02ff:
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 0
                goto L_0x03c7
            L_0x0308:
                java.lang.String r3 = "V_AV1"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 2
                goto L_0x03c7
            L_0x0313:
                java.lang.String r3 = "A_DTS"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 19
                goto L_0x03c7
            L_0x031f:
                java.lang.String r3 = "A_AC3"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 16
                goto L_0x03c7
            L_0x032b:
                java.lang.String r3 = "A_AAC"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 13
                goto L_0x03c7
            L_0x0337:
                java.lang.String r3 = "A_DTS/LOSSLESS"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 21
                goto L_0x03c7
            L_0x0343:
                java.lang.String r3 = "S_VOBSUB"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 27
                goto L_0x03c7
            L_0x034f:
                java.lang.String r3 = "V_MPEG4/ISO/AVC"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 7
                goto L_0x03c7
            L_0x035a:
                java.lang.String r3 = "V_MPEG4/ISO/ASP"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 5
                goto L_0x03c7
            L_0x0365:
                java.lang.String r3 = "S_DVBSUB"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 29
                goto L_0x03c7
            L_0x0370:
                java.lang.String r3 = "V_MS/VFW/FOURCC"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 9
                goto L_0x03c7
            L_0x037b:
                java.lang.String r3 = "A_MPEG/L3"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 15
                goto L_0x03c7
            L_0x0386:
                java.lang.String r3 = "A_MPEG/L2"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 14
                goto L_0x03c7
            L_0x0391:
                java.lang.String r3 = "A_VORBIS"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 11
                goto L_0x03c7
            L_0x039c:
                java.lang.String r3 = "A_TRUEHD"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 18
                goto L_0x03c7
            L_0x03a7:
                java.lang.String r3 = "A_MS/ACM"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 23
                goto L_0x03c7
            L_0x03b2:
                java.lang.String r3 = "V_MPEG4/ISO/SP"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 4
                goto L_0x03c7
            L_0x03bc:
                java.lang.String r3 = "V_MPEG4/ISO/AP"
                boolean r3 = r11.equals(r3)
                if (r3 == 0) goto L_0x03c6
                r3 = 6
                goto L_0x03c7
            L_0x03c6:
                r3 = -1
            L_0x03c7:
                java.lang.String r11 = "audio/x-unknown"
                switch(r3) {
                    case 0: goto L_0x0566;
                    case 1: goto L_0x0562;
                    case 2: goto L_0x055e;
                    case 3: goto L_0x055a;
                    case 4: goto L_0x054a;
                    case 5: goto L_0x054a;
                    case 6: goto L_0x054a;
                    case 7: goto L_0x0533;
                    case 8: goto L_0x051e;
                    case 9: goto L_0x050a;
                    case 10: goto L_0x0506;
                    case 11: goto L_0x04f7;
                    case 12: goto L_0x04b1;
                    case 13: goto L_0x04a7;
                    case 14: goto L_0x049d;
                    case 15: goto L_0x0498;
                    case 16: goto L_0x0494;
                    case 17: goto L_0x0490;
                    case 18: goto L_0x0485;
                    case 19: goto L_0x0481;
                    case 20: goto L_0x0481;
                    case 21: goto L_0x047d;
                    case 22: goto L_0x0473;
                    case 23: goto L_0x0438;
                    case 24: goto L_0x040e;
                    case 25: goto L_0x040a;
                    case 26: goto L_0x0405;
                    case 27: goto L_0x03fb;
                    case 28: goto L_0x03f7;
                    case 29: goto L_0x03d4;
                    default: goto L_0x03cc;
                }
            L_0x03cc:
                com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
                java.lang.String r2 = "Unrecognized codec identifier."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x03d4:
                r3 = 4
                byte[] r3 = new byte[r3]
                byte[] r11 = r1.f31741i
                byte r11 = r11[r6]
                r3[r6] = r11
                byte[] r11 = r1.f31741i
                byte r11 = r11[r5]
                r3[r5] = r11
                byte[] r11 = r1.f31741i
                byte r11 = r11[r4]
                r3[r4] = r11
                byte[] r11 = r1.f31741i
                byte r11 = r11[r14]
                r3[r14] = r11
                java.util.List r3 = java.util.Collections.singletonList(r3)
                java.lang.String r11 = "application/dvbsubs"
                goto L_0x056a
            L_0x03f7:
                java.lang.String r11 = "application/pgs"
                goto L_0x0569
            L_0x03fb:
                byte[] r3 = r1.f31741i
                java.util.List r3 = java.util.Collections.singletonList(r3)
                java.lang.String r11 = "application/vobsub"
                goto L_0x056a
            L_0x0405:
                java.lang.String r11 = "text/x-ssa"
                goto L_0x0569
            L_0x040a:
                java.lang.String r11 = "application/x-subrip"
                goto L_0x0569
            L_0x040e:
                int r3 = r1.M
                int r3 = com.google.android.exoplayer2.g.ae.b((int) r3)
                if (r3 != 0) goto L_0x042f
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r12 = "Unsupported PCM bit depth: "
                r3.<init>(r12)
                int r12 = r1.M
                r3.append(r12)
                java.lang.String r12 = ". Setting mimeType to "
                r3.append(r12)
                r3.append(r11)
                com.google.android.exoplayer2.g.l.c()
                goto L_0x0569
            L_0x042f:
                java.lang.String r11 = "audio/raw"
            L_0x0431:
                r18 = r3
                r3 = r7
                r13 = r11
                r15 = -1
                goto L_0x056e
            L_0x0438:
                com.google.android.exoplayer2.g.r r3 = new com.google.android.exoplayer2.g.r
                byte[] r12 = r1.f31741i
                r3.<init>((byte[]) r12)
                boolean r3 = com.google.android.exoplayer2.extractor.c.d.b.b(r3)
                if (r3 == 0) goto L_0x0469
                int r3 = r1.M
                int r3 = com.google.android.exoplayer2.g.ae.b((int) r3)
                if (r3 != 0) goto L_0x0466
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r12 = "Unsupported PCM bit depth: "
                r3.<init>(r12)
                int r12 = r1.M
                r3.append(r12)
                java.lang.String r12 = ". Setting mimeType to "
                r3.append(r12)
                r3.append(r11)
                com.google.android.exoplayer2.g.l.c()
                goto L_0x0569
            L_0x0466:
                java.lang.String r11 = "audio/raw"
                goto L_0x0431
            L_0x0469:
                java.lang.String r3 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                r3.concat(r11)
                com.google.android.exoplayer2.g.l.c()
                goto L_0x0569
            L_0x0473:
                byte[] r3 = r1.f31741i
                java.util.List r3 = java.util.Collections.singletonList(r3)
                java.lang.String r11 = "audio/flac"
                goto L_0x056a
            L_0x047d:
                java.lang.String r11 = "audio/vnd.dts.hd"
                goto L_0x0569
            L_0x0481:
                java.lang.String r11 = "audio/vnd.dts"
                goto L_0x0569
            L_0x0485:
                com.google.android.exoplayer2.extractor.c.d$c r3 = new com.google.android.exoplayer2.extractor.c.d$c
                r3.<init>()
                r1.Q = r3
                java.lang.String r11 = "audio/true-hd"
                goto L_0x0569
            L_0x0490:
                java.lang.String r11 = "audio/eac3"
                goto L_0x0569
            L_0x0494:
                java.lang.String r11 = "audio/ac3"
                goto L_0x0569
            L_0x0498:
                r3 = 4096(0x1000, float:5.74E-42)
                java.lang.String r11 = "audio/mpeg"
                goto L_0x04a1
            L_0x049d:
                r3 = 4096(0x1000, float:5.74E-42)
                java.lang.String r11 = "audio/mpeg-L2"
            L_0x04a1:
                r3 = r7
                r13 = r11
                r15 = 4096(0x1000, float:5.74E-42)
                goto L_0x056c
            L_0x04a7:
                byte[] r3 = r1.f31741i
                java.util.List r3 = java.util.Collections.singletonList(r3)
                java.lang.String r11 = "audio/mp4a-latm"
                goto L_0x056a
            L_0x04b1:
                r3 = 5760(0x1680, float:8.071E-42)
                java.util.ArrayList r11 = new java.util.ArrayList
                r11.<init>(r14)
                byte[] r12 = r1.f31741i
                r11.add(r12)
                java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r13)
                java.nio.ByteOrder r15 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r12 = r12.order(r15)
                long r14 = r1.O
                java.nio.ByteBuffer r12 = r12.putLong(r14)
                byte[] r12 = r12.array()
                r11.add(r12)
                java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r13)
                java.nio.ByteOrder r13 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r12 = r12.order(r13)
                long r13 = r1.P
                java.nio.ByteBuffer r12 = r12.putLong(r13)
                byte[] r12 = r12.array()
                r11.add(r12)
                java.lang.String r12 = "audio/opus"
                r3 = r11
                r13 = r12
                r15 = 5760(0x1680, float:8.071E-42)
                goto L_0x056c
            L_0x04f7:
                r3 = 8192(0x2000, float:1.14794E-41)
                byte[] r11 = r1.f31741i
                java.util.List r11 = com.google.android.exoplayer2.extractor.c.d.b.a((byte[]) r11)
                java.lang.String r12 = "audio/vorbis"
                r3 = r11
                r13 = r12
                r15 = 8192(0x2000, float:1.14794E-41)
                goto L_0x056c
            L_0x0506:
                java.lang.String r11 = "video/x-unknown"
                goto L_0x0569
            L_0x050a:
                com.google.android.exoplayer2.g.r r3 = new com.google.android.exoplayer2.g.r
                byte[] r11 = r1.f31741i
                r3.<init>((byte[]) r11)
                android.util.Pair r3 = com.google.android.exoplayer2.extractor.c.d.b.a((com.google.android.exoplayer2.g.r) r3)
                java.lang.Object r11 = r3.first
                java.lang.String r11 = (java.lang.String) r11
                java.lang.Object r3 = r3.second
                java.util.List r3 = (java.util.List) r3
                goto L_0x056a
            L_0x051e:
                com.google.android.exoplayer2.g.r r3 = new com.google.android.exoplayer2.g.r
                byte[] r11 = r1.f31741i
                r3.<init>((byte[]) r11)
                com.google.android.exoplayer2.video.c r3 = com.google.android.exoplayer2.video.c.a(r3)
                java.util.List<byte[]> r11 = r3.f33692a
                int r3 = r3.f33693b
                r1.V = r3
                java.lang.String r3 = "video/hevc"
                goto L_0x0547
            L_0x0533:
                com.google.android.exoplayer2.g.r r3 = new com.google.android.exoplayer2.g.r
                byte[] r11 = r1.f31741i
                r3.<init>((byte[]) r11)
                com.google.android.exoplayer2.video.a r3 = com.google.android.exoplayer2.video.a.a(r3)
                java.util.List<byte[]> r11 = r3.f33662a
                int r3 = r3.f33663b
                r1.V = r3
                java.lang.String r3 = "video/avc"
            L_0x0547:
                r13 = r3
                r3 = r11
                goto L_0x056b
            L_0x054a:
                byte[] r3 = r1.f31741i
                if (r3 != 0) goto L_0x0550
                r3 = r7
                goto L_0x0556
            L_0x0550:
                byte[] r3 = r1.f31741i
                java.util.List r3 = java.util.Collections.singletonList(r3)
            L_0x0556:
                java.lang.String r11 = "video/mp4v-es"
                goto L_0x056a
            L_0x055a:
                java.lang.String r11 = "video/mpeg2"
                goto L_0x0569
            L_0x055e:
                java.lang.String r11 = "video/av01"
                goto L_0x0569
            L_0x0562:
                java.lang.String r11 = "video/x-vnd.on2.vp9"
                goto L_0x0569
            L_0x0566:
                java.lang.String r11 = "video/x-vnd.on2.vp8"
            L_0x0569:
                r3 = r7
            L_0x056a:
                r13 = r11
            L_0x056b:
                r15 = -1
            L_0x056c:
                r18 = -1
            L_0x056e:
                boolean r11 = r1.S
                r11 = r11 | r6
                boolean r12 = r1.R
                if (r12 == 0) goto L_0x0577
                r12 = 2
                goto L_0x0578
            L_0x0577:
                r12 = 0
            L_0x0578:
                r11 = r11 | r12
                boolean r12 = com.google.android.exoplayer2.g.o.a((java.lang.String) r13)
                if (r12 == 0) goto L_0x059f
                java.lang.String r12 = java.lang.Integer.toString(r10)
                r14 = -1
                int r4 = r1.L
                int r6 = r1.N
                com.google.android.exoplayer2.drm.DrmInitData r8 = r1.j
                java.lang.String r10 = r1.T
                r16 = r4
                r17 = r6
                r19 = r3
                r20 = r8
                r21 = r11
                r22 = r10
                com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a((java.lang.String) r12, (java.lang.String) r13, (int) r14, (int) r15, (int) r16, (int) r17, (int) r18, (java.util.List<byte[]>) r19, (com.google.android.exoplayer2.drm.DrmInitData) r20, (int) r21, (java.lang.String) r22)
                r4 = 1
                goto L_0x07e1
            L_0x059f:
                boolean r5 = com.google.android.exoplayer2.g.o.b(r13)
                if (r5 == 0) goto L_0x0766
                int r5 = r1.o
                if (r5 != 0) goto L_0x05bf
                int r5 = r1.m
                if (r5 != r8) goto L_0x05b0
                int r5 = r1.k
                goto L_0x05b2
            L_0x05b0:
                int r5 = r1.m
            L_0x05b2:
                r1.m = r5
                int r5 = r1.n
                if (r5 != r8) goto L_0x05bb
                int r5 = r1.l
                goto L_0x05bd
            L_0x05bb:
                int r5 = r1.n
            L_0x05bd:
                r1.n = r5
            L_0x05bf:
                int r5 = r1.m
                r11 = -1082130432(0xffffffffbf800000, float:-1.0)
                if (r5 == r8) goto L_0x05db
                int r5 = r1.n
                if (r5 == r8) goto L_0x05db
                int r5 = r1.l
                int r12 = r1.m
                int r5 = r5 * r12
                float r5 = (float) r5
                int r12 = r1.k
                int r14 = r1.n
                int r12 = r12 * r14
                float r12 = (float) r12
                float r5 = r5 / r12
                r20 = r5
                goto L_0x05dd
            L_0x05db:
                r20 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x05dd:
                boolean r5 = r1.v
                if (r5 == 0) goto L_0x06b5
                float r5 = r1.B
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x06a6
                float r5 = r1.C
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x06a6
                float r5 = r1.D
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x06a6
                float r5 = r1.E
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x06a6
                float r5 = r1.F
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x06a6
                float r5 = r1.G
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x06a6
                float r5 = r1.H
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x06a6
                float r5 = r1.I
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x06a6
                float r5 = r1.J
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 == 0) goto L_0x06a6
                float r5 = r1.K
                int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r5 != 0) goto L_0x061f
                goto L_0x06a6
            L_0x061f:
                r5 = 25
                byte[] r5 = new byte[r5]
                java.nio.ByteBuffer r11 = java.nio.ByteBuffer.wrap(r5)
                r11.put(r6)
                float r12 = r1.B
                r14 = 1195593728(0x47435000, float:50000.0)
                float r12 = r12 * r14
                r16 = 1056964608(0x3f000000, float:0.5)
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                float r12 = r1.C
                float r12 = r12 * r14
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                float r12 = r1.D
                float r12 = r12 * r14
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                float r12 = r1.E
                float r12 = r12 * r14
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                float r12 = r1.F
                float r12 = r12 * r14
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                float r12 = r1.G
                float r12 = r12 * r14
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                float r12 = r1.H
                float r12 = r12 * r14
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                float r12 = r1.I
                float r12 = r12 * r14
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                float r12 = r1.J
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                float r12 = r1.K
                float r12 = r12 + r16
                int r12 = (int) r12
                short r12 = (short) r12
                r11.putShort(r12)
                int r12 = r1.z
                short r12 = (short) r12
                r11.putShort(r12)
                int r12 = r1.A
                short r12 = (short) r12
                r11.putShort(r12)
                goto L_0x06a7
            L_0x06a6:
                r5 = r7
            L_0x06a7:
                com.google.android.exoplayer2.video.ColorInfo r11 = new com.google.android.exoplayer2.video.ColorInfo
                int r12 = r1.w
                int r14 = r1.y
                int r8 = r1.x
                r11.<init>(r12, r14, r8, r5)
                r23 = r11
                goto L_0x06b7
            L_0x06b5:
                r23 = r7
            L_0x06b7:
                java.lang.String r5 = r1.f31733a
                java.lang.String r8 = "htc_video_rotA-000"
                boolean r5 = r8.equals(r5)
                if (r5 == 0) goto L_0x06c3
                r5 = 0
                goto L_0x06eb
            L_0x06c3:
                java.lang.String r5 = r1.f31733a
                java.lang.String r8 = "htc_video_rotA-090"
                boolean r5 = r8.equals(r5)
                if (r5 == 0) goto L_0x06d0
                r5 = 90
                goto L_0x06eb
            L_0x06d0:
                java.lang.String r5 = r1.f31733a
                java.lang.String r8 = "htc_video_rotA-180"
                boolean r5 = r8.equals(r5)
                if (r5 == 0) goto L_0x06dd
                r5 = 180(0xb4, float:2.52E-43)
                goto L_0x06eb
            L_0x06dd:
                java.lang.String r5 = r1.f31733a
                java.lang.String r8 = "htc_video_rotA-270"
                boolean r5 = r8.equals(r5)
                if (r5 == 0) goto L_0x06ea
                r5 = 270(0x10e, float:3.78E-43)
                goto L_0x06eb
            L_0x06ea:
                r5 = -1
            L_0x06eb:
                int r8 = r1.p
                if (r8 != 0) goto L_0x0743
                float r8 = r1.q
                r11 = 0
                int r8 = java.lang.Float.compare(r8, r11)
                if (r8 != 0) goto L_0x0743
                float r8 = r1.r
                int r8 = java.lang.Float.compare(r8, r11)
                if (r8 != 0) goto L_0x0743
                float r8 = r1.s
                int r8 = java.lang.Float.compare(r8, r11)
                if (r8 != 0) goto L_0x070b
                r19 = 0
                goto L_0x0745
            L_0x070b:
                float r6 = r1.r
                r8 = 1119092736(0x42b40000, float:90.0)
                int r6 = java.lang.Float.compare(r6, r8)
                if (r6 != 0) goto L_0x071a
                r6 = 90
                r19 = 90
                goto L_0x0745
            L_0x071a:
                float r6 = r1.r
                r8 = -1020002304(0xffffffffc3340000, float:-180.0)
                int r6 = java.lang.Float.compare(r6, r8)
                if (r6 == 0) goto L_0x073e
                float r6 = r1.r
                r8 = 1127481344(0x43340000, float:180.0)
                int r6 = java.lang.Float.compare(r6, r8)
                if (r6 != 0) goto L_0x072f
                goto L_0x073e
            L_0x072f:
                float r6 = r1.r
                r8 = -1028390912(0xffffffffc2b40000, float:-90.0)
                int r6 = java.lang.Float.compare(r6, r8)
                if (r6 != 0) goto L_0x0743
                r6 = 270(0x10e, float:3.78E-43)
                r19 = 270(0x10e, float:3.78E-43)
                goto L_0x0745
            L_0x073e:
                r6 = 180(0xb4, float:2.52E-43)
                r19 = 180(0xb4, float:2.52E-43)
                goto L_0x0745
            L_0x0743:
                r19 = r5
            L_0x0745:
                java.lang.String r12 = java.lang.Integer.toString(r10)
                r14 = 0
                int r5 = r1.k
                int r6 = r1.l
                byte[] r8 = r1.t
                int r10 = r1.u
                com.google.android.exoplayer2.drm.DrmInitData r11 = r1.j
                r16 = r5
                r17 = r6
                r18 = r3
                r21 = r8
                r22 = r10
                r24 = r11
                com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (int) r15, (int) r16, (int) r17, (java.util.List<byte[]>) r18, (int) r19, (float) r20, (byte[]) r21, (int) r22, (com.google.android.exoplayer2.video.ColorInfo) r23, (com.google.android.exoplayer2.drm.DrmInitData) r24)
                goto L_0x07e1
            L_0x0766:
                java.lang.String r5 = "application/x-subrip"
                boolean r5 = r5.equals(r13)
                if (r5 == 0) goto L_0x077c
                java.lang.String r3 = java.lang.Integer.toString(r10)
                java.lang.String r4 = r1.T
                com.google.android.exoplayer2.drm.DrmInitData r5 = r1.j
                com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a(r3, r13, r11, r4, r5)
            L_0x077a:
                r4 = 3
                goto L_0x07e1
            L_0x077c:
                java.lang.String r5 = "text/x-ssa"
                boolean r5 = r5.equals(r13)
                if (r5 == 0) goto L_0x07ad
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>(r4)
                byte[] r4 = com.google.android.exoplayer2.extractor.c.d.f31724b
                r3.add(r4)
                byte[] r4 = r1.f31741i
                r3.add(r4)
                java.lang.String r12 = java.lang.Integer.toString(r10)
                java.lang.String r15 = r1.T
                r16 = -1
                com.google.android.exoplayer2.drm.DrmInitData r4 = r1.j
                r18 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r14 = r11
                r17 = r4
                r20 = r3
                com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a((java.lang.String) r12, (java.lang.String) r13, (int) r14, (java.lang.String) r15, (int) r16, (com.google.android.exoplayer2.drm.DrmInitData) r17, (long) r18, (java.util.List<byte[]>) r20)
                goto L_0x077a
            L_0x07ad:
                java.lang.String r4 = "application/vobsub"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x07ce
                java.lang.String r4 = "application/pgs"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x07ce
                java.lang.String r4 = "application/dvbsubs"
                boolean r4 = r4.equals(r13)
                if (r4 == 0) goto L_0x07c6
                goto L_0x07ce
            L_0x07c6:
                com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
                java.lang.String r2 = "Unexpected MIME type."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x07ce:
                java.lang.String r12 = java.lang.Integer.toString(r10)
                java.lang.String r4 = r1.T
                com.google.android.exoplayer2.drm.DrmInitData r5 = r1.j
                r14 = r11
                r15 = r3
                r16 = r4
                r17 = r5
                com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a(r12, r13, r14, r15, r16, r17)
                goto L_0x077a
            L_0x07e1:
                int r5 = r1.f31735c
                com.google.android.exoplayer2.extractor.q r4 = r9.a(r5, r4)
                r1.U = r4
                com.google.android.exoplayer2.extractor.q r1 = r1.U
                r1.a(r3)
                android.util.SparseArray<com.google.android.exoplayer2.extractor.c.d$b> r1 = r2.f31726d
                com.google.android.exoplayer2.extractor.c.d$b r3 = r2.m
                int r3 = r3.f31735c
                com.google.android.exoplayer2.extractor.c.d$b r4 = r2.m
                r1.put(r3, r4)
            L_0x07f9:
                r2.m = r7
                return
            L_0x07fc:
                int r1 = r2.w
                if (r1 != r4) goto L_0x081a
                boolean r1 = r2.F
                if (r1 != 0) goto L_0x0809
                int r1 = r2.E
                r1 = r1 | r5
                r2.E = r1
            L_0x0809:
                android.util.SparseArray<com.google.android.exoplayer2.extractor.c.d$b> r1 = r2.f31726d
                int r3 = r2.C
                java.lang.Object r1 = r1.get(r3)
                com.google.android.exoplayer2.extractor.c.d$b r1 = (com.google.android.exoplayer2.extractor.c.d.b) r1
                long r3 = r2.x
                r2.a((com.google.android.exoplayer2.extractor.c.d.b) r1, (long) r3)
                r2.w = r6
            L_0x081a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.c.d.a.c(int):void");
        }

        public final void a(int i2, long j) throws v {
            d dVar = d.this;
            if (i2 != 20529) {
                if (i2 != 20530) {
                    boolean z = false;
                    switch (i2) {
                        case 131:
                            dVar.m.f31736d = (int) j;
                            return;
                        case 136:
                            b bVar = dVar.m;
                            if (j == 1) {
                                z = true;
                            }
                            bVar.S = z;
                            return;
                        case 155:
                            dVar.y = dVar.a(j);
                            return;
                        case Constants.ACTION_NB_NEXT_BTN_CLICKED /*159*/:
                            dVar.m.L = (int) j;
                            return;
                        case 176:
                            dVar.m.k = (int) j;
                            return;
                        case 179:
                            dVar.t.a(dVar.a(j));
                            return;
                        case 186:
                            dVar.m.l = (int) j;
                            return;
                        case 215:
                            dVar.m.f31735c = (int) j;
                            return;
                        case 231:
                            dVar.s = dVar.a(j);
                            return;
                        case 241:
                            if (!dVar.v) {
                                dVar.u.a(j);
                                dVar.v = true;
                                return;
                            }
                            return;
                        case 251:
                            dVar.F = true;
                            return;
                        case 16980:
                            if (j != 3) {
                                throw new v("ContentCompAlgo " + j + " not supported");
                            }
                            return;
                        case 17029:
                            if (j < 1 || j > 2) {
                                throw new v("DocTypeReadVersion " + j + " not supported");
                            }
                            return;
                        case 17143:
                            if (j != 1) {
                                throw new v("EBMLReadVersion " + j + " not supported");
                            }
                            return;
                        case 18401:
                            if (j != 5) {
                                throw new v("ContentEncAlgo " + j + " not supported");
                            }
                            return;
                        case 18408:
                            if (j != 1) {
                                throw new v("AESSettingsCipherMode " + j + " not supported");
                            }
                            return;
                        case 21420:
                            dVar.p = j + dVar.f31731i;
                            return;
                        case 21432:
                            int i3 = (int) j;
                            if (i3 == 0) {
                                dVar.m.u = 0;
                                return;
                            } else if (i3 == 1) {
                                dVar.m.u = 2;
                                return;
                            } else if (i3 == 3) {
                                dVar.m.u = 1;
                                return;
                            } else if (i3 == 15) {
                                dVar.m.u = 3;
                                return;
                            } else {
                                return;
                            }
                        case 21680:
                            dVar.m.m = (int) j;
                            return;
                        case 21682:
                            dVar.m.o = (int) j;
                            return;
                        case 21690:
                            dVar.m.n = (int) j;
                            return;
                        case 21930:
                            b bVar2 = dVar.m;
                            if (j == 1) {
                                z = true;
                            }
                            bVar2.R = z;
                            return;
                        case 22186:
                            dVar.m.O = j;
                            return;
                        case 22203:
                            dVar.m.P = j;
                            return;
                        case 25188:
                            dVar.m.M = (int) j;
                            return;
                        case 30321:
                            int i4 = (int) j;
                            if (i4 == 0) {
                                dVar.m.p = 0;
                                return;
                            } else if (i4 == 1) {
                                dVar.m.p = 1;
                                return;
                            } else if (i4 == 2) {
                                dVar.m.p = 2;
                                return;
                            } else if (i4 == 3) {
                                dVar.m.p = 3;
                                return;
                            } else {
                                return;
                            }
                        case 2352003:
                            dVar.m.f31737e = (int) j;
                            return;
                        case 2807729:
                            dVar.j = j;
                            return;
                        default:
                            switch (i2) {
                                case 21945:
                                    int i5 = (int) j;
                                    if (i5 == 1) {
                                        dVar.m.y = 2;
                                        return;
                                    } else if (i5 == 2) {
                                        dVar.m.y = 1;
                                        return;
                                    } else {
                                        return;
                                    }
                                case 21946:
                                    int i6 = (int) j;
                                    if (i6 != 1) {
                                        if (i6 == 16) {
                                            dVar.m.x = 6;
                                            return;
                                        } else if (i6 == 18) {
                                            dVar.m.x = 7;
                                            return;
                                        } else if (!(i6 == 6 || i6 == 7)) {
                                            return;
                                        }
                                    }
                                    dVar.m.x = 3;
                                    return;
                                case 21947:
                                    dVar.m.v = true;
                                    int i7 = (int) j;
                                    if (i7 == 1) {
                                        dVar.m.w = 1;
                                        return;
                                    } else if (i7 == 9) {
                                        dVar.m.w = 6;
                                        return;
                                    } else if (i7 == 4 || i7 == 5 || i7 == 6 || i7 == 7) {
                                        dVar.m.w = 2;
                                        return;
                                    } else {
                                        return;
                                    }
                                case 21948:
                                    dVar.m.z = (int) j;
                                    return;
                                case 21949:
                                    dVar.m.A = (int) j;
                                    return;
                                default:
                                    return;
                            }
                    }
                } else if (j != 1) {
                    throw new v("ContentEncodingScope " + j + " not supported");
                }
            } else if (j != 0) {
                throw new v("ContentEncodingOrder " + j + " not supported");
            }
        }

        public final void a(int i2, double d2) throws v {
            d dVar = d.this;
            if (i2 == 181) {
                dVar.m.N = (int) d2;
            } else if (i2 != 17545) {
                switch (i2) {
                    case 21969:
                        dVar.m.B = (float) d2;
                        return;
                    case 21970:
                        dVar.m.C = (float) d2;
                        return;
                    case 21971:
                        dVar.m.D = (float) d2;
                        return;
                    case 21972:
                        dVar.m.E = (float) d2;
                        return;
                    case 21973:
                        dVar.m.F = (float) d2;
                        return;
                    case 21974:
                        dVar.m.G = (float) d2;
                        return;
                    case 21975:
                        dVar.m.H = (float) d2;
                        return;
                    case 21976:
                        dVar.m.I = (float) d2;
                        return;
                    case 21977:
                        dVar.m.J = (float) d2;
                        return;
                    case 21978:
                        dVar.m.K = (float) d2;
                        return;
                    default:
                        switch (i2) {
                            case 30323:
                                dVar.m.q = (float) d2;
                                return;
                            case 30324:
                                dVar.m.r = (float) d2;
                                return;
                            case 30325:
                                dVar.m.s = (float) d2;
                                return;
                            default:
                                return;
                        }
                }
            } else {
                dVar.k = (long) d2;
            }
        }

        public final void a(int i2, String str) throws v {
            d dVar = d.this;
            if (i2 == 134) {
                dVar.m.f31734b = str;
            } else if (i2 != 17026) {
                if (i2 == 21358) {
                    dVar.m.f31733a = str;
                } else if (i2 == 2274716) {
                    dVar.m.T = str;
                }
            } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                throw new v("DocType " + str + " not supported");
            }
        }

        public final void a(int i2, int i3, h hVar) throws IOException, InterruptedException {
            byte b2;
            int i4 = i2;
            int i5 = i3;
            h hVar2 = hVar;
            d dVar = d.this;
            int i6 = 4;
            int i7 = 0;
            int i8 = 1;
            if (i4 == 161 || i4 == 163) {
                int i9 = 8;
                if (dVar.w == 0) {
                    dVar.C = (int) dVar.f31725c.a(hVar2, false, true, 8);
                    dVar.D = dVar.f31725c.f31751a;
                    dVar.y = -9223372036854775807L;
                    dVar.w = 1;
                    dVar.f31728f.a();
                }
                b bVar = dVar.f31726d.get(dVar.C);
                if (bVar == null) {
                    hVar2.b(i5 - dVar.D);
                    dVar.w = 0;
                    return;
                }
                if (dVar.w == 1) {
                    dVar.a(hVar2, 3);
                    int i10 = (dVar.f31728f.f32566a[2] & 6) >> 1;
                    byte b3 = 255;
                    if (i10 == 0) {
                        dVar.A = 1;
                        dVar.B = d.a(dVar.B, 1);
                        dVar.B[0] = (i5 - dVar.D) - 3;
                    } else if (i4 == 163) {
                        dVar.a(hVar2, 4);
                        dVar.A = (dVar.f31728f.f32566a[3] & 255) + 1;
                        dVar.B = d.a(dVar.B, dVar.A);
                        if (i10 == 2) {
                            Arrays.fill(dVar.B, 0, dVar.A, ((i5 - dVar.D) - 4) / dVar.A);
                        } else if (i10 == 1) {
                            int i11 = 0;
                            for (int i12 = 0; i12 < dVar.A - 1; i12++) {
                                dVar.B[i12] = 0;
                                do {
                                    i6++;
                                    dVar.a(hVar2, i6);
                                    b2 = dVar.f31728f.f32566a[i6 - 1] & 255;
                                    int[] iArr = dVar.B;
                                    iArr[i12] = iArr[i12] + b2;
                                } while (b2 == 255);
                                i11 += dVar.B[i12];
                            }
                            dVar.B[dVar.A - 1] = ((i5 - dVar.D) - i6) - i11;
                        } else if (i10 == 3) {
                            int i13 = 0;
                            int i14 = 0;
                            while (i13 < dVar.A - i8) {
                                dVar.B[i13] = i7;
                                int i15 = i6 + 1;
                                dVar.a(hVar2, i15);
                                int i16 = i15 - 1;
                                if (dVar.f31728f.f32566a[i16] != 0) {
                                    long j = 0;
                                    int i17 = 0;
                                    while (true) {
                                        if (i17 >= i9) {
                                            break;
                                        }
                                        int i18 = i8 << (7 - i17);
                                        if ((dVar.f31728f.f32566a[i16] & i18) != 0) {
                                            i15 += i17;
                                            dVar.a(hVar2, i15);
                                            int i19 = i16 + 1;
                                            j = (long) (dVar.f31728f.f32566a[i16] & b3 & (~i18));
                                            while (i19 < i15) {
                                                long j2 = j << i9;
                                                i9 = 8;
                                                long j3 = j2 | ((long) (dVar.f31728f.f32566a[i19] & 255));
                                                i19++;
                                                j = j3;
                                            }
                                            if (i13 > 0) {
                                                j -= (1 << ((i17 * 7) + 6)) - 1;
                                            }
                                        } else {
                                            i17++;
                                            i8 = 1;
                                            i9 = 8;
                                            b3 = 255;
                                        }
                                    }
                                    int i20 = i15;
                                    long j4 = j;
                                    if (j4 < -2147483648L || j4 > 2147483647L) {
                                        throw new v("EBML lacing sample size out of range.");
                                    }
                                    int i21 = (int) j4;
                                    int[] iArr2 = dVar.B;
                                    if (i13 != 0) {
                                        i21 += dVar.B[i13 - 1];
                                    }
                                    iArr2[i13] = i21;
                                    i14 += dVar.B[i13];
                                    i13++;
                                    i6 = i20;
                                    i7 = 0;
                                    i8 = 1;
                                    i9 = 8;
                                    b3 = 255;
                                } else {
                                    throw new v("No valid varint length mask found");
                                }
                            }
                            dVar.B[dVar.A - 1] = ((i5 - dVar.D) - i6) - i14;
                        } else {
                            throw new v("Unexpected lacing value: ".concat(String.valueOf(i10)));
                        }
                    } else {
                        throw new v("Lacing only supported in SimpleBlocks.");
                    }
                    dVar.x = dVar.s + dVar.a((long) ((dVar.f31728f.f32566a[0] << 8) | (dVar.f31728f.f32566a[1] & 255)));
                    dVar.E = ((bVar.f31736d == 2 || (i4 == 163 && (dVar.f31728f.f32566a[2] & 128) == 128)) ? 1 : 0) | ((dVar.f31728f.f32566a[2] & 8) == 8 ? Integer.MIN_VALUE : 0);
                    dVar.w = 2;
                    dVar.z = 0;
                }
                if (i4 == 163) {
                    while (dVar.z < dVar.A) {
                        dVar.a(hVar2, bVar, dVar.B[dVar.z]);
                        dVar.a(bVar, dVar.x + ((long) ((dVar.z * bVar.f31737e) / 1000)));
                        dVar.z++;
                    }
                    dVar.w = 0;
                    return;
                }
                dVar.a(hVar2, bVar, dVar.B[0]);
            } else if (i4 == 16981) {
                dVar.m.f31739g = new byte[i5];
                hVar2.b(dVar.m.f31739g, 0, i5);
            } else if (i4 == 18402) {
                byte[] bArr = new byte[i5];
                hVar2.b(bArr, 0, i5);
                dVar.m.f31740h = new q.a(1, bArr, 0, 0);
            } else if (i4 == 21419) {
                Arrays.fill(dVar.f31729g.f32566a, (byte) 0);
                hVar2.b(dVar.f31729g.f32566a, 4 - i5, i5);
                dVar.f31729g.c(0);
                dVar.o = (int) dVar.f31729g.g();
            } else if (i4 == 25506) {
                dVar.m.f31741i = new byte[i5];
                hVar2.b(dVar.m.f31741i, 0, i5);
            } else if (i4 == 30322) {
                dVar.m.t = new byte[i5];
                hVar2.b(dVar.m.t, 0, i5);
            } else {
                throw new v("Unexpected id: ".concat(String.valueOf(i2)));
            }
        }
    }

    static final class b {
        public int A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public int L;
        public int M;
        public int N;
        public long O;
        public long P;
        public c Q;
        public boolean R;
        public boolean S;
        String T;
        public q U;
        public int V;

        /* renamed from: a  reason: collision with root package name */
        public String f31733a;

        /* renamed from: b  reason: collision with root package name */
        public String f31734b;

        /* renamed from: c  reason: collision with root package name */
        public int f31735c;

        /* renamed from: d  reason: collision with root package name */
        public int f31736d;

        /* renamed from: e  reason: collision with root package name */
        public int f31737e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31738f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f31739g;

        /* renamed from: h  reason: collision with root package name */
        public q.a f31740h;

        /* renamed from: i  reason: collision with root package name */
        public byte[] f31741i;
        public DrmInitData j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public float q;
        public float r;
        public float s;
        public byte[] t;
        public int u;
        public boolean v;
        public int w;
        public int x;
        public int y;
        public int z;

        private b() {
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = 0;
            this.p = -1;
            this.q = 0.0f;
            this.r = 0.0f;
            this.s = 0.0f;
            this.t = null;
            this.u = -1;
            this.v = false;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 1000;
            this.A = 200;
            this.B = -1.0f;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = -1.0f;
            this.K = -1.0f;
            this.L = 1;
            this.M = -1;
            this.N = 8000;
            this.O = 0;
            this.P = 0;
            this.S = true;
            this.T = "eng";
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        static Pair<String, List<byte[]>> a(r rVar) throws v {
            try {
                rVar.d(16);
                long h2 = rVar.h();
                if (h2 == 1482049860) {
                    return new Pair<>("video/divx", (Object) null);
                }
                if (h2 == 859189832) {
                    return new Pair<>("video/3gpp", (Object) null);
                }
                if (h2 == 826496599) {
                    byte[] bArr = rVar.f32566a;
                    for (int i2 = rVar.f32567b + 20; i2 < bArr.length - 4; i2++) {
                        if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 1 && bArr[i2 + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArr, i2, bArr.length)));
                        }
                    }
                    throw new v("Failed to find FourCC VC1 initialization data");
                }
                l.c();
                return new Pair<>("video/x-unknown", (Object) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new v("Error parsing FourCC private data");
            }
        }

        static List<byte[]> a(byte[] bArr) throws v {
            try {
                if (bArr[0] == 2) {
                    int i2 = 1;
                    int i3 = 0;
                    while (bArr[i2] == -1) {
                        i3 += PriceRangeSeekBar.INVALID_POINTER_ID;
                        i2++;
                    }
                    int i4 = i2 + 1;
                    int i5 = i3 + bArr[i2];
                    int i6 = 0;
                    while (bArr[i4] == -1) {
                        i6 += PriceRangeSeekBar.INVALID_POINTER_ID;
                        i4++;
                    }
                    int i7 = i4 + 1;
                    int i8 = i6 + bArr[i4];
                    if (bArr[i7] == 1) {
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(bArr, i7, bArr2, 0, i5);
                        int i9 = i7 + i5;
                        if (bArr[i9] == 3) {
                            int i10 = i9 + i8;
                            if (bArr[i10] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i10)];
                                System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new v("Error parsing vorbis codec private");
                        }
                        throw new v("Error parsing vorbis codec private");
                    }
                    throw new v("Error parsing vorbis codec private");
                }
                throw new v("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new v("Error parsing vorbis codec private");
            }
        }

        static boolean b(r rVar) throws v {
            try {
                int e2 = rVar.e();
                if (e2 == 1) {
                    return true;
                }
                if (e2 == 65534) {
                    rVar.c(24);
                    return rVar.k() == d.L.getMostSignificantBits() && rVar.k() == d.L.getLeastSignificantBits();
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new v("Error parsing MS/ACM codec private");
            }
        }
    }
}
