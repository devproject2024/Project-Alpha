package com.google.zxing.f.a;

import com.google.zxing.b.d;
import com.google.zxing.f.c;
import com.google.zxing.h;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f40444a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f40445b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final BigInteger[] f40446c;

    enum a {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f40446c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        f40446c[1] = valueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f40446c;
            if (i2 < bigIntegerArr2.length) {
                bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(valueOf);
                i2++;
            } else {
                return;
            }
        }
    }

    static com.google.zxing.b.e a(int[] iArr, String str) throws h {
        int i2;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i3 = iArr[1];
        c cVar = new c();
        int i4 = 2;
        while (i4 < iArr[0]) {
            if (i3 != 913) {
                switch (i3) {
                    case 900:
                        i2 = a(iArr, i4, sb);
                        break;
                    case 901:
                        i2 = a(i3, iArr, charset, i4, sb);
                        break;
                    case 902:
                        i2 = b(iArr, i4, sb);
                        break;
                    default:
                        switch (i3) {
                            case 922:
                            case 923:
                                throw h.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i2 = i4 + 1;
                                break;
                            case 926:
                                i2 = i4 + 2;
                                break;
                            case 927:
                                i2 = i4 + 1;
                                charset = Charset.forName(d.getCharacterSetECIByValue(iArr[i4]).name());
                                break;
                            case 928:
                                i2 = a(iArr, i4, cVar);
                                break;
                            default:
                                i2 = a(iArr, i4 - 1, sb);
                                break;
                        }
                        i2 = a(i3, iArr, charset, i4, sb);
                        break;
                }
            } else {
                i2 = i4 + 1;
                sb.append((char) iArr[i4]);
            }
            if (i2 < iArr.length) {
                i4 = i2 + 1;
                i3 = iArr[i2];
            } else {
                throw h.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            com.google.zxing.b.e eVar = new com.google.zxing.b.e((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            eVar.f39917h = cVar;
            return eVar;
        }
        throw h.getFormatInstance();
    }

    private static int a(int[] iArr, int i2, c cVar) throws h {
        if (i2 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i3 = i2;
            int i4 = 0;
            while (i4 < 2) {
                iArr2[i4] = iArr[i3];
                i4++;
                i3++;
            }
            cVar.f40463a = Integer.parseInt(a(iArr2, 2));
            StringBuilder sb = new StringBuilder();
            int a2 = a(iArr, i3, sb);
            cVar.f40464b = sb.toString();
            int i5 = iArr[a2] == 923 ? a2 + 1 : -1;
            while (a2 < iArr[0]) {
                int i6 = iArr[a2];
                if (i6 == 922) {
                    a2++;
                    cVar.f40465c = true;
                } else if (i6 == 923) {
                    int i7 = a2 + 1;
                    switch (iArr[i7]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            a2 = a(iArr, i7 + 1, sb2);
                            cVar.f40469g = sb2.toString();
                            break;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            a2 = b(iArr, i7 + 1, sb3);
                            cVar.f40466d = Integer.parseInt(sb3.toString());
                            break;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            a2 = b(iArr, i7 + 1, sb4);
                            cVar.f40471i = Long.parseLong(sb4.toString());
                            break;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            a2 = a(iArr, i7 + 1, sb5);
                            cVar.f40467e = sb5.toString();
                            break;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            a2 = a(iArr, i7 + 1, sb6);
                            cVar.f40468f = sb6.toString();
                            break;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            a2 = b(iArr, i7 + 1, sb7);
                            cVar.f40470h = Long.parseLong(sb7.toString());
                            break;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            a2 = b(iArr, i7 + 1, sb8);
                            cVar.j = Integer.parseInt(sb8.toString());
                            break;
                        default:
                            throw h.getFormatInstance();
                    }
                } else {
                    throw h.getFormatInstance();
                }
            }
            if (i5 != -1) {
                int i8 = a2 - i5;
                if (cVar.f40465c) {
                    i8--;
                }
                cVar.k = Arrays.copyOfRange(iArr, i5, i8 + i5);
            }
            return a2;
        }
        throw h.getFormatInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0099, code lost:
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0113, code lost:
        r11 = (char) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0114, code lost:
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0120, code lost:
        r13 = 0;
        r16 = r8;
        r8 = r6;
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0136, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0137, code lost:
        if (r13 == 0) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0139, code lost:
        r0.append(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013c, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(int[] r17, int r18, java.lang.StringBuilder r19) {
        /*
            r0 = r19
            r1 = 0
            r2 = r17[r1]
            int r2 = r2 - r18
            r3 = 1
            int r2 = r2 << r3
            int[] r2 = new int[r2]
            r4 = r17[r1]
            int r4 = r4 - r18
            int r4 = r4 << r3
            int[] r4 = new int[r4]
            r5 = r18
            r6 = 0
            r7 = 0
        L_0x0016:
            r8 = r17[r1]
            r9 = 913(0x391, float:1.28E-42)
            r10 = 900(0x384, float:1.261E-42)
            if (r5 >= r8) goto L_0x0056
            if (r6 != 0) goto L_0x0056
            int r8 = r5 + 1
            r5 = r17[r5]
            if (r5 >= r10) goto L_0x0034
            int r9 = r5 / 30
            r2[r7] = r9
            int r9 = r7 + 1
            int r5 = r5 % 30
            r2[r9] = r5
            int r7 = r7 + 2
        L_0x0032:
            r5 = r8
            goto L_0x0016
        L_0x0034:
            if (r5 == r9) goto L_0x004b
            r9 = 928(0x3a0, float:1.3E-42)
            if (r5 == r9) goto L_0x0047
            switch(r5) {
                case 900: goto L_0x0041;
                case 901: goto L_0x0047;
                case 902: goto L_0x0047;
                default: goto L_0x003d;
            }
        L_0x003d:
            switch(r5) {
                case 922: goto L_0x0047;
                case 923: goto L_0x0047;
                case 924: goto L_0x0047;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x0032
        L_0x0041:
            int r5 = r7 + 1
            r2[r7] = r10
            r7 = r5
            goto L_0x0032
        L_0x0047:
            int r5 = r8 + -1
            r6 = 1
            goto L_0x0016
        L_0x004b:
            r2[r7] = r9
            int r5 = r8 + 1
            r8 = r17[r8]
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0016
        L_0x0056:
            com.google.zxing.f.a.e$a r3 = com.google.zxing.f.a.e.a.ALPHA
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
            r8 = r6
            r6 = r3
            r3 = 0
        L_0x005d:
            if (r3 >= r7) goto L_0x0140
            r11 = r2[r3]
            int[] r12 = com.google.zxing.f.a.e.AnonymousClass1.f40447a
            int r13 = r6.ordinal()
            r12 = r12[r13]
            r13 = 32
            r14 = 29
            r15 = 26
            switch(r12) {
                case 1: goto L_0x010f;
                case 2: goto L_0x00ef;
                case 3: goto L_0x00c5;
                case 4: goto L_0x00a5;
                case 5: goto L_0x0093;
                case 6: goto L_0x0074;
                default: goto L_0x0072;
            }
        L_0x0072:
            goto L_0x0136
        L_0x0074:
            if (r11 >= r14) goto L_0x007b
            char[] r6 = f40444a
            char r6 = r6[r11]
            goto L_0x0098
        L_0x007b:
            if (r11 == r14) goto L_0x008f
            if (r11 == r10) goto L_0x008b
            if (r11 == r9) goto L_0x0082
            goto L_0x0088
        L_0x0082:
            r6 = r4[r3]
            char r6 = (char) r6
            r0.append(r6)
        L_0x0088:
            r6 = r8
            goto L_0x0136
        L_0x008b:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
            goto L_0x0136
        L_0x008f:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
            goto L_0x0136
        L_0x0093:
            if (r11 >= r15) goto L_0x009c
            int r11 = r11 + 65
            char r6 = (char) r11
        L_0x0098:
            r13 = r6
        L_0x0099:
            r6 = r8
            goto L_0x0137
        L_0x009c:
            if (r11 == r15) goto L_0x0099
            if (r11 == r10) goto L_0x00a1
            goto L_0x0088
        L_0x00a1:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
            goto L_0x0136
        L_0x00a5:
            if (r11 >= r14) goto L_0x00ad
            char[] r12 = f40444a
            char r11 = r12[r11]
            goto L_0x0114
        L_0x00ad:
            if (r11 == r14) goto L_0x00c1
            if (r11 == r10) goto L_0x00bd
            if (r11 == r9) goto L_0x00b5
            goto L_0x0136
        L_0x00b5:
            r11 = r4[r3]
            char r11 = (char) r11
            r0.append(r11)
            goto L_0x0136
        L_0x00bd:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
            goto L_0x0136
        L_0x00c1:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
            goto L_0x0136
        L_0x00c5:
            r12 = 25
            if (r11 >= r12) goto L_0x00ce
            char[] r12 = f40445b
            char r11 = r12[r11]
            goto L_0x0114
        L_0x00ce:
            if (r11 == r10) goto L_0x00ec
            if (r11 == r9) goto L_0x00e5
            switch(r11) {
                case 25: goto L_0x00e2;
                case 26: goto L_0x0137;
                case 27: goto L_0x00de;
                case 28: goto L_0x00da;
                case 29: goto L_0x00d7;
                default: goto L_0x00d5;
            }
        L_0x00d5:
            goto L_0x0136
        L_0x00d7:
            com.google.zxing.f.a.e$a r8 = com.google.zxing.f.a.e.a.PUNCT_SHIFT
            goto L_0x0120
        L_0x00da:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
            goto L_0x0136
        L_0x00de:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.LOWER
            goto L_0x0136
        L_0x00e2:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.PUNCT
            goto L_0x0136
        L_0x00e5:
            r11 = r4[r3]
            char r11 = (char) r11
            r0.append(r11)
            goto L_0x0136
        L_0x00ec:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
            goto L_0x0136
        L_0x00ef:
            if (r11 >= r15) goto L_0x00f4
            int r11 = r11 + 97
            goto L_0x0113
        L_0x00f4:
            if (r11 == r10) goto L_0x010c
            if (r11 == r9) goto L_0x0105
            switch(r11) {
                case 26: goto L_0x0137;
                case 27: goto L_0x0102;
                case 28: goto L_0x00ff;
                case 29: goto L_0x00fc;
                default: goto L_0x00fb;
            }
        L_0x00fb:
            goto L_0x0136
        L_0x00fc:
            com.google.zxing.f.a.e$a r8 = com.google.zxing.f.a.e.a.PUNCT_SHIFT
            goto L_0x0120
        L_0x00ff:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.MIXED
            goto L_0x0136
        L_0x0102:
            com.google.zxing.f.a.e$a r8 = com.google.zxing.f.a.e.a.ALPHA_SHIFT
            goto L_0x0120
        L_0x0105:
            r11 = r4[r3]
            char r11 = (char) r11
            r0.append(r11)
            goto L_0x0136
        L_0x010c:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
            goto L_0x0136
        L_0x010f:
            if (r11 >= r15) goto L_0x0116
            int r11 = r11 + 65
        L_0x0113:
            char r11 = (char) r11
        L_0x0114:
            r13 = r11
            goto L_0x0137
        L_0x0116:
            if (r11 == r10) goto L_0x0134
            if (r11 == r9) goto L_0x012d
            switch(r11) {
                case 26: goto L_0x0137;
                case 27: goto L_0x012a;
                case 28: goto L_0x0127;
                case 29: goto L_0x011e;
                default: goto L_0x011d;
            }
        L_0x011d:
            goto L_0x0136
        L_0x011e:
            com.google.zxing.f.a.e$a r8 = com.google.zxing.f.a.e.a.PUNCT_SHIFT
        L_0x0120:
            r13 = 0
            r16 = r8
            r8 = r6
            r6 = r16
            goto L_0x0137
        L_0x0127:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.MIXED
            goto L_0x0136
        L_0x012a:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.LOWER
            goto L_0x0136
        L_0x012d:
            r11 = r4[r3]
            char r11 = (char) r11
            r0.append(r11)
            goto L_0x0136
        L_0x0134:
            com.google.zxing.f.a.e$a r6 = com.google.zxing.f.a.e.a.ALPHA
        L_0x0136:
            r13 = 0
        L_0x0137:
            if (r13 == 0) goto L_0x013c
            r0.append(r13)
        L_0x013c:
            int r3 = r3 + 1
            goto L_0x005d
        L_0x0140:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.a.e.a(int[], int, java.lang.StringBuilder):int");
    }

    private static int a(int i2, int[] iArr, Charset charset, int i3, StringBuilder sb) {
        int i4;
        long j;
        int i5;
        int i6;
        int i7 = i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j2 = 900;
        int i8 = 6;
        if (i7 == 901) {
            int[] iArr2 = new int[6];
            int i9 = i3 + 1;
            int i10 = iArr[i3];
            boolean z = false;
            while (true) {
                i6 = 0;
                long j3 = 0;
                while (i5 < iArr[0] && !z) {
                    int i11 = i6 + 1;
                    iArr2[i6] = i10;
                    j3 = (j3 * j) + ((long) i10);
                    int i12 = i5 + 1;
                    i10 = iArr[i5];
                    if (i10 != 928) {
                        switch (i10) {
                            case 900:
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i10) {
                                    case 922:
                                    case 923:
                                    case 924:
                                        break;
                                    default:
                                        if (i11 % 5 != 0 || i11 <= 0) {
                                            z = z;
                                            i5 = i12;
                                            i6 = i11;
                                            j = 900;
                                            i8 = 6;
                                            break;
                                        } else {
                                            int i13 = 0;
                                            while (i13 < i8) {
                                                byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i13) * 8))));
                                                i13++;
                                                i8 = 6;
                                                z = z;
                                            }
                                            boolean z2 = z;
                                            i9 = i12;
                                            j2 = 900;
                                        }
                                }
                                break;
                        }
                    }
                    i5 = i12 - 1;
                    i6 = i11;
                    j = 900;
                    i8 = 6;
                    z = true;
                }
            }
            if (i5 == iArr[0] && i10 < 900) {
                iArr2[i6] = i10;
                i6++;
            }
            for (int i14 = 0; i14 < i6; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
            i4 = i5;
        } else if (i7 != 924) {
            i4 = i3;
        } else {
            i4 = i3;
            boolean z3 = false;
            while (true) {
                int i15 = 0;
                long j4 = 0;
                while (i4 < iArr[0] && !z3) {
                    int i16 = i4 + 1;
                    int i17 = iArr[i4];
                    if (i17 < 900) {
                        i15++;
                        j4 = (j4 * 900) + ((long) i17);
                    } else {
                        if (i17 != 928) {
                            switch (i17) {
                                case 900:
                                case 901:
                                case 902:
                                    break;
                                default:
                                    switch (i17) {
                                        case 922:
                                        case 923:
                                        case 924:
                                            break;
                                    }
                            }
                        }
                        i4 = i16 - 1;
                        z3 = true;
                        if (i15 % 5 != 0 && i15 > 0) {
                            for (int i18 = 0; i18 < 6; i18++) {
                                byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i18) * 8))));
                            }
                        }
                    }
                    i4 = i16;
                    if (i15 % 5 != 0) {
                    }
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i4;
    }

    private static int b(int[] iArr, int i2, StringBuilder sb) throws h {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i3] = i5;
                i3++;
            } else {
                if (!(i5 == 900 || i5 == 901 || i5 == 928)) {
                    switch (i5) {
                        case 922:
                        case 923:
                        case 924:
                            break;
                    }
                }
                i4--;
                z = true;
            }
            if ((i3 % 15 == 0 || i5 == 902 || z) && i3 > 0) {
                sb.append(a(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    private static String a(int[] iArr, int i2) throws h {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigInteger = bigInteger.add(f40446c[(i2 - i3) - 1].multiply(BigInteger.valueOf((long) iArr[i3])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw h.getFormatInstance();
    }
}
