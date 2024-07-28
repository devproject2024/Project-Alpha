package com.google.zxing.f.c;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.google.zxing.b.d;
import com.google.zxing.w;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f40492a = {TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f40493b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f40494c = new byte[128];

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f40495d = new byte[128];

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f40496e = StandardCharsets.ISO_8859_1;

    private static boolean a(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean b(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean c(char c2) {
        if (c2 != ' ') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    static {
        Arrays.fill(f40494c, (byte) -1);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = f40492a;
            if (i3 >= bArr.length) {
                break;
            }
            byte b2 = bArr[i3];
            if (b2 > 0) {
                f40494c[b2] = (byte) i3;
            }
            i3++;
        }
        Arrays.fill(f40495d, (byte) -1);
        while (true) {
            byte[] bArr2 = f40493b;
            if (i2 < bArr2.length) {
                byte b3 = bArr2[i2];
                if (b3 > 0) {
                    f40495d[b3] = (byte) i2;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    static String a(String str, c cVar, Charset charset) throws w {
        int i2;
        d characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f40496e;
        } else if (!f40496e.equals(charset) && (characterSetECIByName = d.getCharacterSetECIByName(charset.name())) != null) {
            int value = characterSetECIByName.getValue();
            if (value >= 0 && value < 900) {
                sb.append(927);
                sb.append((char) value);
            } else if (value < 810900) {
                sb.append(926);
                sb.append((char) ((value / 900) - 1));
                sb.append((char) (value % 900));
            } else if (value < 811800) {
                sb.append(925);
                sb.append((char) (810900 - value));
            } else {
                throw new w("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(value)));
            }
        }
        int length = str.length();
        int i3 = AnonymousClass1.f40497a[cVar.ordinal()];
        if (i3 == 1) {
            a(str, 0, length, sb, 0);
        } else if (i3 == 2) {
            byte[] bytes = str.getBytes(charset);
            a(bytes, bytes.length, 1, sb);
        } else if (i3 != 3) {
            int i4 = 0;
            int i5 = 0;
            loop0:
            while (true) {
                int i6 = 0;
                while (i2 < length) {
                    int a2 = a(str, i2);
                    if (a2 >= 13) {
                        sb.append(902);
                        a(str, i2, a2, sb);
                        i4 = i2 + a2;
                        i5 = 2;
                    } else {
                        int b2 = b(str, i2);
                        if (b2 >= 5 || a2 == length) {
                            if (i5 != 0) {
                                sb.append(900);
                                i5 = 0;
                                i6 = 0;
                            }
                            i6 = a(str, i2, b2, sb, i6);
                            i2 += b2;
                        } else {
                            int a3 = a(str, i2, charset);
                            if (a3 == 0) {
                                a3 = 1;
                            }
                            int i7 = a3 + i2;
                            byte[] bytes2 = str.substring(i2, i7).getBytes(charset);
                            if (bytes2.length == 1 && i5 == 0) {
                                a(bytes2, 1, 0, sb);
                            } else {
                                a(bytes2, bytes2.length, i5, sb);
                                i5 = 1;
                                i6 = 0;
                            }
                            i2 = i7;
                        }
                    }
                }
                break loop0;
            }
        } else {
            sb.append(902);
            a(str, 0, length, sb);
        }
        return sb.toString();
    }

    /* renamed from: com.google.zxing.f.c.g$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f40497a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.google.zxing.f.c.c[] r0 = com.google.zxing.f.c.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40497a = r0
                int[] r0 = f40497a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.zxing.f.c.c r1 = com.google.zxing.f.c.c.TEXT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f40497a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.zxing.f.c.c r1 = com.google.zxing.f.c.c.BYTE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f40497a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.zxing.f.c.c r1 = com.google.zxing.f.c.c.NUMERIC     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.c.g.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f6 A[EDGE_INSN: B:68:0x00f6->B:53:0x00f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0011 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r4 = 2
            r5 = 0
            r6 = 1
            r8 = r20
            r7 = 0
        L_0x0011:
            int r9 = r17 + r7
            char r10 = r0.charAt(r9)
            r11 = 26
            r12 = 32
            r13 = 28
            r14 = 27
            r15 = 29
            if (r8 == 0) goto L_0x00bc
            if (r8 == r6) goto L_0x0083
            if (r8 == r4) goto L_0x003c
            boolean r9 = e(r10)
            if (r9 == 0) goto L_0x0037
            byte[] r9 = f40495d
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00f2
        L_0x0037:
            r3.append(r15)
        L_0x003a:
            r8 = 0
            goto L_0x0011
        L_0x003c:
            boolean r11 = d(r10)
            if (r11 == 0) goto L_0x004c
            byte[] r9 = f40494c
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00f2
        L_0x004c:
            boolean r11 = b(r10)
            if (r11 == 0) goto L_0x0056
            r3.append(r13)
            goto L_0x003a
        L_0x0056:
            boolean r11 = c(r10)
            if (r11 == 0) goto L_0x0061
            r3.append(r14)
            goto L_0x00d8
        L_0x0061:
            int r9 = r9 + 1
            if (r9 >= r1) goto L_0x0076
            char r9 = r0.charAt(r9)
            boolean r9 = e(r9)
            if (r9 == 0) goto L_0x0076
            r8 = 3
            r9 = 25
            r3.append(r9)
            goto L_0x0011
        L_0x0076:
            r3.append(r15)
            byte[] r9 = f40495d
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00f2
        L_0x0083:
            boolean r9 = c(r10)
            if (r9 == 0) goto L_0x0096
            if (r10 != r12) goto L_0x008f
            r3.append(r11)
            goto L_0x00f2
        L_0x008f:
            int r10 = r10 + -97
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00f2
        L_0x0096:
            boolean r9 = b(r10)
            if (r9 == 0) goto L_0x00a6
            r3.append(r14)
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00f2
        L_0x00a6:
            boolean r9 = d(r10)
            if (r9 == 0) goto L_0x00b0
            r3.append(r13)
            goto L_0x00e4
        L_0x00b0:
            r3.append(r15)
            byte[] r9 = f40495d
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00f2
        L_0x00bc:
            boolean r9 = b(r10)
            if (r9 == 0) goto L_0x00cf
            if (r10 != r12) goto L_0x00c8
            r3.append(r11)
            goto L_0x00f2
        L_0x00c8:
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00f2
        L_0x00cf:
            boolean r9 = c(r10)
            if (r9 == 0) goto L_0x00db
            r3.append(r14)
        L_0x00d8:
            r8 = 1
            goto L_0x0011
        L_0x00db:
            boolean r9 = d(r10)
            if (r9 == 0) goto L_0x00e7
            r3.append(r13)
        L_0x00e4:
            r8 = 2
            goto L_0x0011
        L_0x00e7:
            r3.append(r15)
            byte[] r9 = f40495d
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
        L_0x00f2:
            int r7 = r7 + 1
            if (r7 < r1) goto L_0x0011
            int r0 = r3.length()
            r1 = 0
            r7 = 0
        L_0x00fc:
            if (r1 >= r0) goto L_0x011a
            int r9 = r1 % 2
            if (r9 == 0) goto L_0x0104
            r9 = 1
            goto L_0x0105
        L_0x0104:
            r9 = 0
        L_0x0105:
            if (r9 == 0) goto L_0x0113
            int r7 = r7 * 30
            char r9 = r3.charAt(r1)
            int r7 = r7 + r9
            char r7 = (char) r7
            r2.append(r7)
            goto L_0x0117
        L_0x0113:
            char r7 = r3.charAt(r1)
        L_0x0117:
            int r1 = r1 + 1
            goto L_0x00fc
        L_0x011a:
            int r0 = r0 % r4
            if (r0 == 0) goto L_0x0124
            int r7 = r7 * 30
            int r7 = r7 + r15
            char r0 = (char) r7
            r2.append(r0)
        L_0x0124:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.c.g.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void a(byte[] bArr, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append(913);
        } else if (i2 % 6 == 0) {
            sb.append(924);
        } else {
            sb.append(901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = 0;
            while ((i2 + 0) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & 255));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = 0;
        }
        while (i4 < i2 + 0) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    private static void a(String str, int i2, int i3, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i4 = 0;
        while (i4 < i3) {
            sb2.setLength(0);
            int min = Math.min(44, i3 - i4);
            StringBuilder sb3 = new StringBuilder("1");
            int i5 = i2 + i4;
            sb3.append(str.substring(i5, i5 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i4 += min;
        }
    }

    private static boolean d(char c2) {
        return f40494c[c2] != -1;
    }

    private static boolean e(char c2) {
        return f40495d[c2] != -1;
    }

    private static int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char charAt = charSequence.charAt(i2);
            while (a(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    private static int b(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = i2;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            boolean z = false;
            int i4 = i3;
            int i5 = 0;
            while (i5 < 13 && a(charAt) && i4 < length) {
                i5++;
                i4++;
                if (i4 < length) {
                    charAt = charSequence.charAt(i4);
                }
            }
            if (i5 >= 13) {
                return (i4 - i2) - i5;
            }
            if (i5 <= 0) {
                char charAt2 = charSequence.charAt(i4);
                if (charAt2 == 9 || charAt2 == 10 || charAt2 == 13 || (charAt2 >= ' ' && charAt2 <= '~')) {
                    z = true;
                }
                if (!z) {
                    i3 = i4;
                    break;
                }
                i3 = i4 + 1;
            } else {
                i3 = i4;
            }
        }
        return i3 - i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws com.google.zxing.w {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L_0x0009:
            if (r1 >= r0) goto L_0x0057
            char r2 = r5.charAt(r1)
            r3 = 0
        L_0x0010:
            r4 = 13
            if (r3 >= r4) goto L_0x0025
            boolean r2 = a(r2)
            if (r2 == 0) goto L_0x0025
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 >= r0) goto L_0x0025
            char r2 = r5.charAt(r2)
            goto L_0x0010
        L_0x0025:
            if (r3 < r4) goto L_0x0029
            int r1 = r1 - r6
            return r1
        L_0x0029:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L_0x0036
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0036:
            com.google.zxing.w r5 = new com.google.zxing.w
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Non-encodable character detected: "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0057:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.c.g.a(java.lang.String, int, java.nio.charset.Charset):int");
    }
}
