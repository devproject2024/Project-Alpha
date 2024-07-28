package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class a implements com.google.android.exoplayer2.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0545a f32717a = $$Lambda$a$RySM_bRX12uxzGLT1ReK5zH0Mxg.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    public static final int f32718b = ae.h("ID3");

    /* renamed from: c  reason: collision with root package name */
    private final C0545a f32719c;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.a$a  reason: collision with other inner class name */
    public interface C0545a {
        boolean evaluate(int i2, int i3, int i4, int i5, int i6);
    }

    private static String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : AppConstants.UTF_8 : "UTF-16BE" : "UTF-16";
    }

    private static int b(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean b(int i2, int i3, int i4, int i5, int i6) {
        return false;
    }

    public a() {
        this((C0545a) null);
    }

    public a(C0545a aVar) {
        this.f32719c = aVar;
    }

    public final Metadata a(c cVar) {
        ByteBuffer byteBuffer = cVar.f31311c;
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    public final Metadata a(byte[] bArr, int i2) {
        ArrayList arrayList = new ArrayList();
        r rVar = new r(bArr, i2);
        b a2 = a(rVar);
        if (a2 == null) {
            return null;
        }
        int i3 = rVar.f32567b;
        int i4 = a2.f32720a == 2 ? 6 : 10;
        int i5 = a2.f32722c;
        if (a2.f32721b) {
            i5 = b(rVar, a2.f32722c);
        }
        rVar.b(i3 + i5);
        boolean z = false;
        if (!a(rVar, a2.f32720a, i4, false)) {
            if (a2.f32720a != 4 || !a(rVar, 4, i4, true)) {
                new StringBuilder("Failed to validate ID3 tag with majorVersion=").append(a2.f32720a);
                l.c();
                return null;
            }
            z = true;
        }
        while (rVar.b() >= i4) {
            Id3Frame a3 = a(a2.f32720a, rVar, z, i4, this.f32719c);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static b a(r rVar) {
        if (rVar.b() < 10) {
            l.c();
            return null;
        }
        int f2 = rVar.f();
        if (f2 != f32718b) {
            "Unexpected first three bytes of ID3 tag header: ".concat(String.valueOf(f2));
            l.c();
            return null;
        }
        int c2 = rVar.c();
        boolean z = true;
        rVar.d(1);
        int c3 = rVar.c();
        int m = rVar.m();
        if (c2 == 2) {
            if ((c3 & 64) != 0) {
                l.c();
                return null;
            }
        } else if (c2 == 3) {
            if ((c3 & 64) != 0) {
                int i2 = rVar.i();
                rVar.d(i2);
                m -= i2 + 4;
            }
        } else if (c2 == 4) {
            if ((c3 & 64) != 0) {
                int m2 = rVar.m();
                rVar.d(m2 - 4);
                m -= m2;
            }
            if ((c3 & 16) != 0) {
                m -= 10;
            }
        } else {
            "Skipped ID3 tag with unsupported majorVersion=".concat(String.valueOf(c2));
            l.c();
            return null;
        }
        if (c2 >= 4 || (c3 & 128) == 0) {
            z = false;
        }
        return new b(c2, z, m);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.google.android.exoplayer2.metadata.id3.Id3Frame} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: com.google.android.exoplayer2.metadata.id3.Id3Frame} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v44, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v45, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v46, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.exoplayer2.metadata.id3.Id3Frame] */
    /* JADX WARNING: type inference failed for: r5v18, types: [com.google.android.exoplayer2.metadata.id3.GeobFrame] */
    /* JADX WARNING: type inference failed for: r5v23, types: [com.google.android.exoplayer2.metadata.id3.UrlLinkFrame] */
    /* JADX WARNING: type inference failed for: r5v25, types: [com.google.android.exoplayer2.metadata.id3.TextInformationFrame] */
    /* JADX WARNING: type inference failed for: r5v29, types: [com.google.android.exoplayer2.metadata.id3.TextInformationFrame] */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x025a, code lost:
        if (r13 == 67) goto L_0x025c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0369 A[Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x036e A[Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x037f A[Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame a(int r18, com.google.android.exoplayer2.g.r r19, boolean r20, int r21, com.google.android.exoplayer2.metadata.id3.a.C0545a r22) {
        /*
            r0 = r18
            r7 = r19
            int r8 = r19.c()
            int r9 = r19.c()
            int r10 = r19.c()
            r11 = 3
            if (r0 < r11) goto L_0x0019
            int r1 = r19.c()
            r13 = r1
            goto L_0x001a
        L_0x0019:
            r13 = 0
        L_0x001a:
            r14 = 4
            if (r0 != r14) goto L_0x003c
            int r1 = r19.n()
            if (r20 != 0) goto L_0x003a
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 7
            r2 = r2 | r3
            int r3 = r1 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 14
            r2 = r2 | r3
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 21
            r1 = r1 | r2
        L_0x003a:
            r15 = r1
            goto L_0x0048
        L_0x003c:
            if (r0 != r11) goto L_0x0043
            int r1 = r19.n()
            goto L_0x003a
        L_0x0043:
            int r1 = r19.f()
            goto L_0x003a
        L_0x0048:
            if (r0 < r11) goto L_0x0050
            int r1 = r19.d()
            r6 = r1
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            r5 = 0
            if (r8 != 0) goto L_0x0064
            if (r9 != 0) goto L_0x0064
            if (r10 != 0) goto L_0x0064
            if (r13 != 0) goto L_0x0064
            if (r15 != 0) goto L_0x0064
            if (r6 != 0) goto L_0x0064
            int r0 = r7.f32568c
            r7.c(r0)
            return r5
        L_0x0064:
            int r1 = r7.f32567b
            int r4 = r1 + r15
            int r1 = r7.f32568c
            if (r4 <= r1) goto L_0x0075
            com.google.android.exoplayer2.g.l.c()
            int r0 = r7.f32568c
            r7.c(r0)
            return r5
        L_0x0075:
            if (r22 == 0) goto L_0x008d
            r1 = r22
            r2 = r18
            r3 = r8
            r12 = r4
            r4 = r9
            r14 = r5
            r5 = r10
            r16 = r6
            r6 = r13
            boolean r1 = r1.evaluate(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x0091
            r7.c(r12)
            return r14
        L_0x008d:
            r12 = r4
            r14 = r5
            r16 = r6
        L_0x0091:
            r1 = 1
            if (r0 != r11) goto L_0x00af
            r2 = r16
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x009c
            r3 = 1
            goto L_0x009d
        L_0x009c:
            r3 = 0
        L_0x009d:
            r4 = r2 & 64
            if (r4 == 0) goto L_0x00a3
            r4 = 1
            goto L_0x00a4
        L_0x00a3:
            r4 = 0
        L_0x00a4:
            r2 = r2 & 32
            if (r2 == 0) goto L_0x00aa
            r2 = 1
            goto L_0x00ab
        L_0x00aa:
            r2 = 0
        L_0x00ab:
            r5 = r4
            r6 = 0
            r4 = r3
            goto L_0x00de
        L_0x00af:
            r2 = r16
            r3 = 4
            if (r0 != r3) goto L_0x00d9
            r3 = r2 & 64
            if (r3 == 0) goto L_0x00ba
            r3 = 1
            goto L_0x00bb
        L_0x00ba:
            r3 = 0
        L_0x00bb:
            r4 = r2 & 8
            if (r4 == 0) goto L_0x00c1
            r4 = 1
            goto L_0x00c2
        L_0x00c1:
            r4 = 0
        L_0x00c2:
            r5 = r2 & 4
            if (r5 == 0) goto L_0x00c8
            r5 = 1
            goto L_0x00c9
        L_0x00c8:
            r5 = 0
        L_0x00c9:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x00cf
            r6 = 1
            goto L_0x00d0
        L_0x00cf:
            r6 = 0
        L_0x00d0:
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00d6
            r2 = r3
            r3 = 1
            goto L_0x00de
        L_0x00d6:
            r2 = r3
            r3 = 0
            goto L_0x00de
        L_0x00d9:
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x00de:
            if (r4 != 0) goto L_0x03b3
            if (r5 == 0) goto L_0x00e4
            goto L_0x03b3
        L_0x00e4:
            if (r2 == 0) goto L_0x00eb
            int r15 = r15 + -1
            r7.d(r1)
        L_0x00eb:
            if (r3 == 0) goto L_0x00f3
            int r15 = r15 + -4
            r2 = 4
            r7.d(r2)
        L_0x00f3:
            if (r6 == 0) goto L_0x00fa
            int r2 = b((com.google.android.exoplayer2.g.r) r7, (int) r15)
            r15 = r2
        L_0x00fa:
            r2 = 84
            r3 = 88
            r4 = 2
            if (r8 != r2) goto L_0x013b
            if (r9 != r3) goto L_0x013b
            if (r10 != r3) goto L_0x013b
            if (r0 == r4) goto L_0x0109
            if (r13 != r3) goto L_0x013b
        L_0x0109:
            if (r15 > 0) goto L_0x010d
        L_0x010b:
            r5 = r14
            goto L_0x0162
        L_0x010d:
            int r1 = r19.c()     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r2 = a((int) r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r3 = r15 + -1
            byte[] r4 = new byte[r3]     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r5 = 0
            r7.a(r4, r5, r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r3 = a(r4, r5, r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r6 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r6.<init>(r4, r5, r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r5 = b(r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r3 = r3 + r5
            int r1 = a(r4, r3, r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r1 = a((byte[]) r4, (int) r3, (int) r1, (java.lang.String) r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r5 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r2 = "TXXX"
            r5.<init>(r2, r6, r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            goto L_0x0162
        L_0x013b:
            if (r8 != r2) goto L_0x016d
            java.lang.String r1 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            if (r15 > 0) goto L_0x0144
            goto L_0x010b
        L_0x0144:
            int r2 = r19.c()     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r3 = a((int) r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r4 = r15 + -1
            byte[] r5 = new byte[r4]     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r6 = 0
            r7.a(r5, r6, r4)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r2 = a(r5, r6, r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r4 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r4.<init>(r5, r6, r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r5 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r5.<init>(r1, r14, r4)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
        L_0x0162:
            r17 = r12
            goto L_0x037d
        L_0x0166:
            r0 = move-exception
            r1 = r12
            goto L_0x03af
        L_0x016a:
            r1 = r12
            goto L_0x03a6
        L_0x016d:
            r5 = 87
            java.lang.String r6 = "ISO-8859-1"
            if (r8 != r5) goto L_0x01ac
            if (r9 != r3) goto L_0x01ac
            if (r10 != r3) goto L_0x01ac
            if (r0 == r4) goto L_0x017b
            if (r13 != r3) goto L_0x01ac
        L_0x017b:
            if (r15 > 0) goto L_0x017e
            goto L_0x010b
        L_0x017e:
            int r1 = r19.c()     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r2 = a((int) r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r3 = r15 + -1
            byte[] r4 = new byte[r3]     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r5 = 0
            r7.a(r4, r5, r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r3 = a(r4, r5, r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r11 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r11.<init>(r4, r5, r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r1 = b(r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r3 = r3 + r1
            int r1 = b((byte[]) r4, (int) r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r1 = a((byte[]) r4, (int) r3, (int) r1, (java.lang.String) r6)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r5 = new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r2 = "WXXX"
            r5.<init>(r2, r11, r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            goto L_0x0162
        L_0x01ac:
            r3 = 87
            if (r8 != r3) goto L_0x01ca
            java.lang.String r1 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            byte[] r2 = new byte[r15]     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r3 = 0
            r7.a(r2, r3, r15)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r4 = b((byte[]) r2, (int) r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r5.<init>(r2, r3, r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r2 = new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r2.<init>(r1, r14, r5)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
        L_0x01c8:
            r5 = r2
            goto L_0x0162
        L_0x01ca:
            r3 = 73
            r5 = 80
            if (r8 != r5) goto L_0x01f5
            r14 = 82
            if (r9 != r14) goto L_0x01f5
            if (r10 != r3) goto L_0x01f5
            r14 = 86
            if (r13 != r14) goto L_0x01f5
            byte[] r2 = new byte[r15]     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r3 = 0
            r7.a(r2, r3, r15)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r4 = b((byte[]) r2, (int) r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r5.<init>(r2, r3, r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r4 = r4 + r1
            int r1 = r2.length     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            byte[] r1 = b(r2, r4, r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            com.google.android.exoplayer2.metadata.id3.PrivFrame r2 = new com.google.android.exoplayer2.metadata.id3.PrivFrame     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r2.<init>(r5, r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            goto L_0x01c8
        L_0x01f5:
            r14 = 71
            r2 = 79
            if (r8 != r14) goto L_0x0247
            r14 = 69
            if (r9 != r14) goto L_0x0247
            if (r10 != r2) goto L_0x0247
            r14 = 66
            if (r13 == r14) goto L_0x0207
            if (r0 != r4) goto L_0x0247
        L_0x0207:
            int r2 = r19.c()     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r3 = a((int) r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r4 = r15 + -1
            byte[] r5 = new byte[r4]     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r11 = 0
            r7.a(r5, r11, r4)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r4 = b((byte[]) r5, (int) r11)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r14 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r14.<init>(r5, r11, r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r4 = r4 + r1
            int r1 = a(r5, r4, r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r4 = a((byte[]) r5, (int) r4, (int) r1, (java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r6 = b(r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r1 = r1 + r6
            int r6 = a(r5, r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r1 = a((byte[]) r5, (int) r1, (int) r6, (java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r2 = b(r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r6 = r6 + r2
            int r2 = r5.length     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            byte[] r2 = b(r5, r6, r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            com.google.android.exoplayer2.metadata.id3.GeobFrame r5 = new com.google.android.exoplayer2.metadata.id3.GeobFrame     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r5.<init>(r14, r4, r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            goto L_0x0162
        L_0x0247:
            r1 = 67
            if (r0 != r4) goto L_0x0252
            if (r8 != r5) goto L_0x02d9
            if (r9 != r3) goto L_0x02d9
            if (r10 != r1) goto L_0x02d9
            goto L_0x025c
        L_0x0252:
            r14 = 65
            if (r8 != r14) goto L_0x02d9
            if (r9 != r5) goto L_0x02d9
            if (r10 != r3) goto L_0x02d9
            if (r13 != r1) goto L_0x02d9
        L_0x025c:
            int r1 = r19.c()     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r2 = a((int) r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            int r3 = r15 + -1
            byte[] r5 = new byte[r3]     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r14 = 0
            r7.a(r5, r14, r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            if (r0 != r4) goto L_0x0292
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r14 = "image/"
            r3.<init>(r14)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r14 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r4 = 0
            r14.<init>(r5, r4, r11, r6)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r4 = com.google.android.exoplayer2.g.ae.d((java.lang.String) r14)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r3.append(r4)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r3 = r3.toString()     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r4 = "image/jpg"
            boolean r4 = r4.equals(r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            if (r4 == 0) goto L_0x0290
            java.lang.String r3 = "image/jpeg"
        L_0x0290:
            r4 = 2
            goto L_0x02b3
        L_0x0292:
            r3 = 0
            int r4 = b((byte[]) r5, (int) r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r11 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r11.<init>(r5, r3, r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r3 = com.google.android.exoplayer2.g.ae.d((java.lang.String) r11)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r6 = 47
            int r6 = r3.indexOf(r6)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r11 = -1
            if (r6 != r11) goto L_0x02b3
            java.lang.String r6 = "image/"
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r3 = r6.concat(r3)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
        L_0x02b3:
            int r6 = r4 + 1
            byte r6 = r5[r6]     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            r11 = 2
            int r4 = r4 + r11
            int r11 = a(r5, r4, r1)     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            java.lang.String r14 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x016a, all -> 0x0166 }
            r17 = r12
            int r12 = r11 - r4
            r14.<init>(r5, r4, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            int r1 = b(r1)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            int r11 = r11 + r1
            int r1 = r5.length     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            byte[] r1 = b(r5, r11, r1)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            com.google.android.exoplayer2.metadata.id3.ApicFrame r5 = new com.google.android.exoplayer2.metadata.id3.ApicFrame     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r5.<init>(r3, r14, r6, r1)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            goto L_0x037d
        L_0x02d9:
            r17 = r12
            r3 = 77
            if (r8 != r1) goto L_0x0325
            if (r9 != r2) goto L_0x0325
            if (r10 != r3) goto L_0x0325
            if (r13 == r3) goto L_0x02e8
            r4 = 2
            if (r0 != r4) goto L_0x0325
        L_0x02e8:
            r1 = 4
            if (r15 >= r1) goto L_0x02ee
            r5 = 0
            goto L_0x037d
        L_0x02ee:
            int r1 = r19.c()     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            java.lang.String r2 = a((int) r1)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            byte[] r3 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r4 = 0
            r7.a(r3, r4, r11)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r5.<init>(r3, r4, r11)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            int r3 = r15 + -4
            byte[] r6 = new byte[r3]     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r7.a(r6, r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            int r3 = a(r6, r4, r1)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            java.lang.String r11 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r11.<init>(r6, r4, r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            int r4 = b(r1)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            int r3 = r3 + r4
            int r1 = a(r6, r3, r1)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            java.lang.String r1 = a((byte[]) r6, (int) r3, (int) r1, (java.lang.String) r2)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            com.google.android.exoplayer2.metadata.id3.CommentFrame r2 = new com.google.android.exoplayer2.metadata.id3.CommentFrame     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r2.<init>(r5, r11, r1)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r5 = r2
            goto L_0x037d
        L_0x0325:
            if (r8 != r1) goto L_0x0341
            r4 = 72
            if (r9 != r4) goto L_0x0341
            r4 = 65
            if (r10 != r4) goto L_0x0341
            if (r13 != r5) goto L_0x0341
            r1 = r19
            r2 = r15
            r3 = r18
            r4 = r20
            r5 = r21
            r6 = r22
            com.google.android.exoplayer2.metadata.id3.ChapterFrame r5 = a(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            goto L_0x037d
        L_0x0341:
            if (r8 != r1) goto L_0x035b
            r4 = 84
            if (r9 != r4) goto L_0x035b
            if (r10 != r2) goto L_0x035b
            if (r13 != r1) goto L_0x035b
            r1 = r19
            r2 = r15
            r3 = r18
            r4 = r20
            r5 = r21
            r6 = r22
            com.google.android.exoplayer2.metadata.id3.ChapterTocFrame r5 = b(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            goto L_0x037d
        L_0x035b:
            if (r8 != r3) goto L_0x036e
            r1 = 76
            if (r9 != r1) goto L_0x036e
            r1 = 76
            if (r10 != r1) goto L_0x036e
            r1 = 84
            if (r13 != r1) goto L_0x036e
            com.google.android.exoplayer2.metadata.id3.MlltFrame r5 = a((com.google.android.exoplayer2.g.r) r7, (int) r15)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            goto L_0x037d
        L_0x036e:
            java.lang.String r1 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            byte[] r2 = new byte[r15]     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r3 = 0
            r7.a(r2, r3, r15)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            com.google.android.exoplayer2.metadata.id3.BinaryFrame r5 = new com.google.android.exoplayer2.metadata.id3.BinaryFrame     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r5.<init>(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
        L_0x037d:
            if (r5 != 0) goto L_0x03a0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            java.lang.String r2 = "Failed to decode frame: id="
            r1.<init>(r2)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            java.lang.String r0 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r1.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            java.lang.String r0 = ", frameSize="
            r1.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            r1.append(r15)     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            com.google.android.exoplayer2.g.l.c()     // Catch:{ UnsupportedEncodingException -> 0x039d, all -> 0x0399 }
            goto L_0x03a0
        L_0x0399:
            r0 = move-exception
            r1 = r17
            goto L_0x03af
        L_0x039d:
            r1 = r17
            goto L_0x03a6
        L_0x03a0:
            r1 = r17
            r7.c(r1)
            return r5
        L_0x03a6:
            com.google.android.exoplayer2.g.l.c()     // Catch:{ all -> 0x03ae }
            r7.c(r1)
            r0 = 0
            return r0
        L_0x03ae:
            r0 = move-exception
        L_0x03af:
            r7.c(r1)
            throw r0
        L_0x03b3:
            r1 = r12
            r0 = r14
            com.google.android.exoplayer2.g.l.c()
            r7.c(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.a.a(int, com.google.android.exoplayer2.g.r, boolean, int, com.google.android.exoplayer2.metadata.id3.a$a):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static MlltFrame a(r rVar, int i2) {
        int d2 = rVar.d();
        int f2 = rVar.f();
        int f3 = rVar.f();
        int c2 = rVar.c();
        int c3 = rVar.c();
        q qVar = new q();
        qVar.a(rVar.f32566a, rVar.f32568c);
        qVar.a(rVar.f32567b * 8);
        int i3 = ((i2 - 10) * 8) / (c2 + c3);
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int c4 = qVar.c(c2);
            int c5 = qVar.c(c3);
            iArr[i4] = c4;
            iArr2[i4] = c5;
        }
        return new MlltFrame(d2, f2, f3, iArr, iArr2);
    }

    private static int b(r rVar, int i2) {
        byte[] bArr = rVar.f32566a;
        int i3 = rVar.f32567b;
        int i4 = i2;
        int i5 = i3;
        while (true) {
            int i6 = i5 + 1;
            if (i6 >= i3 + i4) {
                return i4;
            }
            if ((bArr[i5] & 255) == 255 && bArr[i6] == 0) {
                System.arraycopy(bArr, i5 + 2, bArr, i6, (i4 - (i5 - i3)) - 2);
                i4--;
            }
            i5 = i6;
        }
    }

    private static String a(int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    private static int a(byte[] bArr, int i2, int i3) {
        int b2 = b(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return b2;
        }
        while (b2 < bArr.length - 1) {
            if (b2 % 2 == 0 && bArr[b2 + 1] == 0) {
                return b2;
            }
            b2 = b(bArr, b2 + 1);
        }
        return bArr.length;
    }

    private static int b(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    private static byte[] b(byte[] bArr, int i2, int i3) {
        if (i3 <= i2) {
            return ae.f32504f;
        }
        return Arrays.copyOfRange(bArr, i2, i3);
    }

    private static String a(byte[] bArr, int i2, int i3, String str) throws UnsupportedEncodingException {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, str);
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f32720a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f32721b;

        /* renamed from: c  reason: collision with root package name */
        final int f32722c;

        public b(int i2, boolean z, int i3) {
            this.f32720a = i2;
            this.f32721b = z;
            this.f32722c = i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
        if ((r10 & 1) != 0) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        if ((r10 & 128) != 0) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0099 A[SYNTHETIC, Splitter:B:49:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0095 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.google.android.exoplayer2.g.r r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.f32567b
        L_0x0006:
            int r3 = r18.b()     // Catch:{ all -> 0x00b0 }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00ac
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0020
            int r7 = r18.i()     // Catch:{ all -> 0x00b0 }
            long r8 = r18.g()     // Catch:{ all -> 0x00b0 }
            int r10 = r18.d()     // Catch:{ all -> 0x00b0 }
            goto L_0x002a
        L_0x0020:
            int r7 = r18.f()     // Catch:{ all -> 0x00b0 }
            int r8 = r18.f()     // Catch:{ all -> 0x00b0 }
            long r8 = (long) r8
            r10 = 0
        L_0x002a:
            r11 = 0
            if (r7 != 0) goto L_0x0038
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0038
            if (r10 != 0) goto L_0x0038
            r1.c(r2)
            return r4
        L_0x0038:
            r7 = 4
            if (r0 != r7) goto L_0x0069
            if (r21 != 0) goto L_0x0069
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x0049
            r1.c(r2)
            return r6
        L_0x0049:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x0069:
            if (r0 != r7) goto L_0x0078
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0071
            r3 = 1
            goto L_0x0072
        L_0x0071:
            r3 = 0
        L_0x0072:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0087
        L_0x0076:
            r7 = 1
            goto L_0x0088
        L_0x0078:
            if (r0 != r3) goto L_0x0086
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0080
            r3 = 1
            goto L_0x0081
        L_0x0080:
            r3 = 0
        L_0x0081:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0087
            goto L_0x0076
        L_0x0086:
            r3 = 0
        L_0x0087:
            r7 = 0
        L_0x0088:
            if (r3 == 0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r4 = 0
        L_0x008c:
            if (r7 == 0) goto L_0x0090
            int r4 = r4 + 4
        L_0x0090:
            long r3 = (long) r4
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0099
            r1.c(r2)
            return r6
        L_0x0099:
            int r3 = r18.b()     // Catch:{ all -> 0x00b0 }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a6
            r1.c(r2)
            return r6
        L_0x00a6:
            int r3 = (int) r8
            r1.d(r3)     // Catch:{ all -> 0x00b0 }
            goto L_0x0006
        L_0x00ac:
            r1.c(r2)
            return r4
        L_0x00b0:
            r0 = move-exception
            r1.c(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.a.a(com.google.android.exoplayer2.g.r, int, int, boolean):boolean");
    }

    private static ChapterFrame a(r rVar, int i2, int i3, boolean z, int i4, C0545a aVar) throws UnsupportedEncodingException {
        r rVar2 = rVar;
        int i5 = rVar2.f32567b;
        int b2 = b(rVar2.f32566a, i5);
        String str = new String(rVar2.f32566a, i5, b2 - i5, "ISO-8859-1");
        rVar.c(b2 + 1);
        int i6 = rVar.i();
        int i7 = rVar.i();
        long g2 = rVar.g();
        long j = g2 == 4294967295L ? -1 : g2;
        long g3 = rVar.g();
        long j2 = g3 == 4294967295L ? -1 : g3;
        ArrayList arrayList = new ArrayList();
        int i8 = i5 + i2;
        while (rVar2.f32567b < i8) {
            Id3Frame a2 = a(i3, rVar, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, i6, i7, j, j2, id3FrameArr);
    }

    private static ChapterTocFrame b(r rVar, int i2, int i3, boolean z, int i4, C0545a aVar) throws UnsupportedEncodingException {
        r rVar2 = rVar;
        int i5 = rVar2.f32567b;
        int b2 = b(rVar2.f32566a, i5);
        String str = new String(rVar2.f32566a, i5, b2 - i5, "ISO-8859-1");
        rVar.c(b2 + 1);
        int c2 = rVar.c();
        boolean z2 = (c2 & 2) != 0;
        boolean z3 = (c2 & 1) != 0;
        int c3 = rVar.c();
        String[] strArr = new String[c3];
        for (int i6 = 0; i6 < c3; i6++) {
            int i7 = rVar2.f32567b;
            int b3 = b(rVar2.f32566a, i7);
            strArr[i6] = new String(rVar2.f32566a, i7, b3 - i7, "ISO-8859-1");
            rVar.c(b3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i8 = i5 + i2;
        while (rVar2.f32567b < i8) {
            Id3Frame a2 = a(i3, rVar, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }
}
