package org.apache.xml.security.utils;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f72745a = new byte[PriceRangeSeekBar.INVALID_POINTER_ID];

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f72746b = new char[64];

    static {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 255; i5++) {
            f72745a[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            f72745a[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            f72745a[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            f72745a[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = f72745a;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i9 = 0; i9 <= 25; i9++) {
            f72746b[i9] = (char) (i9 + 65);
        }
        int i10 = 0;
        while (i2 <= 51) {
            f72746b[i2] = (char) (i10 + 97);
            i2++;
            i10++;
        }
        while (i3 <= 61) {
            f72746b[i3] = (char) (i4 + 48);
            i3++;
            i4++;
        }
        char[] cArr = f72746b;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    private Base64() {
    }

    protected static final int a(String str, byte[] bArr) {
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte charAt = (byte) str.charAt(i3);
            if (!a(charAt)) {
                bArr[i2] = charAt;
                i2++;
            }
        }
        return i2;
    }

    public static final String a(byte[] bArr, int i2) {
        byte b2;
        int i3;
        byte[] bArr2 = bArr;
        int i4 = i2;
        if (i4 < 4) {
            i4 = Integer.MAX_VALUE;
        }
        if (bArr2 == null) {
            return null;
        }
        int length = bArr2.length * 8;
        if (length == 0) {
            return "";
        }
        int i5 = length % 24;
        int i6 = length / 24;
        int i7 = i5 != 0 ? i6 + 1 : i6;
        int i8 = (i7 - 1) / (i4 / 4);
        char[] cArr = new char[((i7 * 4) + i8)];
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i9 < i8) {
            int i13 = i12;
            int i14 = i11;
            int i15 = i10;
            int i16 = 0;
            while (i16 < 19) {
                int i17 = i14 + 1;
                byte b3 = bArr2[i14];
                int i18 = i17 + 1;
                byte b4 = bArr2[i17];
                int i19 = i18 + 1;
                byte b5 = bArr2[i18];
                byte b6 = (byte) (b4 & 15);
                byte b7 = (byte) (b3 & 3);
                byte b8 = b3 & Byte.MIN_VALUE;
                int i20 = b3 >> 2;
                if (b8 != 0) {
                    i20 ^= 192;
                }
                byte b9 = (byte) i20;
                byte b10 = b4 & Byte.MIN_VALUE;
                int i21 = b4 >> 4;
                if (b10 != 0) {
                    i21 ^= 240;
                }
                byte b11 = (byte) i21;
                int i22 = b5 >> 6;
                if ((b5 & Byte.MIN_VALUE) != 0) {
                    i22 ^= 252;
                }
                int i23 = i15 + 1;
                char[] cArr2 = f72746b;
                cArr[i15] = cArr2[b9];
                int i24 = i23 + 1;
                cArr[i23] = cArr2[(b7 << 4) | b11];
                int i25 = i24 + 1;
                cArr[i24] = cArr2[((byte) i22) | (b6 << 2)];
                i15 = i25 + 1;
                cArr[i25] = cArr2[b5 & 63];
                i13++;
                i16++;
                i14 = i19;
            }
            i10 = i15 + 1;
            cArr[i15] = 10;
            i9++;
            i11 = i14;
            i12 = i13;
        }
        while (i12 < i6) {
            int i26 = i11 + 1;
            byte b12 = bArr2[i11];
            int i27 = i26 + 1;
            byte b13 = bArr2[i26];
            i11 = i27 + 1;
            byte b14 = bArr2[i27];
            byte b15 = (byte) (b13 & 15);
            byte b16 = (byte) (b12 & 3);
            byte b17 = b12 & Byte.MIN_VALUE;
            int i28 = b12 >> 2;
            if (b17 != 0) {
                i28 ^= 192;
            }
            byte b18 = (byte) i28;
            byte b19 = b13 & Byte.MIN_VALUE;
            int i29 = b13 >> 4;
            if (b19 != 0) {
                i29 ^= 240;
            }
            byte b20 = (byte) i29;
            int i30 = (b14 & Byte.MIN_VALUE) == 0 ? b14 >> 6 : (b14 >> 6) ^ 252;
            int i31 = i10 + 1;
            char[] cArr3 = f72746b;
            cArr[i10] = cArr3[b18];
            int i32 = i31 + 1;
            cArr[i31] = cArr3[b20 | (b16 << 4)];
            int i33 = i32 + 1;
            cArr[i32] = cArr3[(b15 << 2) | ((byte) i30)];
            i10 = i33 + 1;
            cArr[i33] = cArr3[b14 & 63];
            i12++;
        }
        if (i5 == 8) {
            byte b21 = bArr2[i11];
            byte b22 = (byte) (b21 & 3);
            byte b23 = b21 & Byte.MIN_VALUE;
            int i34 = b21 >> 2;
            if (b23 != 0) {
                i34 ^= 192;
            }
            int i35 = i10 + 1;
            char[] cArr4 = f72746b;
            cArr[i10] = cArr4[(byte) i34];
            int i36 = i35 + 1;
            cArr[i35] = cArr4[b22 << 4];
            cArr[i36] = '=';
            cArr[i36 + 1] = '=';
        } else if (i5 == 16) {
            byte b24 = bArr2[i11];
            byte b25 = bArr2[i11 + 1];
            byte b26 = (byte) (b25 & 15);
            byte b27 = (byte) (b24 & 3);
            byte b28 = b24 & Byte.MIN_VALUE;
            int i37 = b24 >> 2;
            if (b28 != 0) {
                i37 ^= 192;
            }
            byte b29 = (byte) i37;
            if ((b25 & Byte.MIN_VALUE) == 0) {
                b2 = 4;
                i3 = b25 >> 4;
            } else {
                b2 = 4;
                i3 = (b25 >> 4) ^ 240;
            }
            int i38 = i10 + 1;
            char[] cArr5 = f72746b;
            cArr[i10] = cArr5[b29];
            int i39 = i38 + 1;
            cArr[i38] = cArr5[((byte) i3) | (b27 << b2)];
            cArr[i39] = cArr5[b26 << 2];
            cArr[i39 + 1] = '=';
        }
        return new String(cArr);
    }

    public static final void a(InputStream inputStream, OutputStream outputStream) {
        int i2;
        int i3;
        byte b2;
        byte[] bArr = new byte[4];
        loop0:
        while (true) {
            int i4 = 0;
            while (true) {
                int read = inputStream.read();
                if (read <= 0) {
                    break loop0;
                }
                byte b3 = (byte) read;
                if (!a(b3)) {
                    if (b(b3)) {
                        int i5 = i4 + 1;
                        bArr[i4] = b3;
                        if (i5 == 3) {
                            bArr[i5] = (byte) inputStream.read();
                        }
                    } else {
                        int i6 = i4 + 1;
                        bArr[i4] = b3;
                        if (b3 == -1) {
                            throw new Base64DecodingException("decoding.general");
                        } else if (i6 == 4) {
                            break;
                        } else {
                            i4 = i6;
                        }
                    }
                }
            }
            byte[] bArr2 = f72745a;
            byte b4 = bArr2[bArr[0]];
            byte b5 = bArr2[bArr[1]];
            byte b6 = bArr2[bArr[2]];
            byte b7 = bArr2[bArr[3]];
            outputStream.write((byte) ((b4 << 2) | (b5 >> 4)));
            outputStream.write((byte) (((b5 & 15) << 4) | ((b6 >> 2) & 15)));
            outputStream.write((byte) (b7 | (b6 << 6)));
        }
        byte b8 = bArr[0];
        byte b9 = bArr[1];
        byte b10 = bArr[2];
        byte b11 = bArr[3];
        byte[] bArr3 = f72745a;
        byte b12 = bArr3[b8];
        byte b13 = bArr3[b9];
        byte b14 = bArr3[b10];
        byte b15 = bArr3[b11];
        if (b14 == -1 || b15 == -1) {
            if (!b(b10) || !b(b11)) {
                if (b(b10) || !b(b11)) {
                    throw new Base64DecodingException("decoding.general");
                }
                byte b16 = f72745a[b10];
                if ((b16 & 3) == 0) {
                    outputStream.write((byte) ((b12 << 2) | (b13 >> 4)));
                    i2 = (b13 & 15) << 4;
                    i3 = (b16 >> 2) & 15;
                } else {
                    throw new Base64DecodingException("decoding.general");
                }
            } else if ((b13 & 15) == 0) {
                i2 = b12 << 2;
                i3 = b13 >> 4;
            } else {
                throw new Base64DecodingException("decoding.general");
            }
            b2 = i2 | i3;
        } else {
            outputStream.write((byte) ((b12 << 2) | (b13 >> 4)));
            outputStream.write((byte) (((b13 & 15) << 4) | ((b14 >> 2) & 15)));
            b2 = (b14 << 6) | b15;
        }
        outputStream.write((byte) b2);
    }

    public static final void a(String str, OutputStream outputStream) {
        byte[] bArr = new byte[str.length()];
        a(bArr, outputStream, a(str, bArr));
    }

    public static final void a(byte[] bArr, OutputStream outputStream) {
        a(bArr, outputStream, -1);
    }

    /* JADX WARNING: type inference failed for: r10v5, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r1v4, types: [int, byte] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int, byte] */
    /* JADX WARNING: type inference failed for: r6v0, types: [int, byte] */
    /* JADX WARNING: type inference failed for: r10v6, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r10v6, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static final void a(byte[] r8, java.io.OutputStream r9, int r10) {
        /*
            r0 = -1
            if (r10 != r0) goto L_0x0007
            int r10 = c(r8)
        L_0x0007:
            int r1 = r10 % 4
            if (r1 != 0) goto L_0x00ee
            int r10 = r10 / 4
            if (r10 != 0) goto L_0x0010
            return
        L_0x0010:
            r1 = 0
            int r10 = r10 + -1
        L_0x0013:
            java.lang.String r2 = "decoding.general"
            if (r10 <= 0) goto L_0x0060
            byte[] r3 = f72745a
            int r4 = r1 + 1
            byte r1 = r8[r1]
            byte r1 = r3[r1]
            int r5 = r4 + 1
            byte r4 = r8[r4]
            byte r4 = r3[r4]
            int r6 = r5 + 1
            byte r5 = r8[r5]
            byte r5 = r3[r5]
            int r7 = r6 + 1
            byte r6 = r8[r6]
            byte r3 = r3[r6]
            if (r1 == r0) goto L_0x005a
            if (r4 == r0) goto L_0x005a
            if (r5 == r0) goto L_0x005a
            if (r3 == r0) goto L_0x005a
            int r1 = r1 << 2
            int r2 = r4 >> 4
            r1 = r1 | r2
            byte r1 = (byte) r1
            r9.write(r1)
            r1 = r4 & 15
            int r1 = r1 << 4
            int r2 = r5 >> 2
            r2 = r2 & 15
            r1 = r1 | r2
            byte r1 = (byte) r1
            r9.write(r1)
            int r1 = r5 << 6
            r1 = r1 | r3
            byte r1 = (byte) r1
            r9.write(r1)
            int r10 = r10 + -1
            r1 = r7
            goto L_0x0013
        L_0x005a:
            org.apache.xml.security.exceptions.Base64DecodingException r8 = new org.apache.xml.security.exceptions.Base64DecodingException
            r8.<init>(r2)
            throw r8
        L_0x0060:
            byte[] r10 = f72745a
            int r3 = r1 + 1
            byte r1 = r8[r1]
            byte r1 = r10[r1]
            int r4 = r3 + 1
            byte r3 = r8[r3]
            byte r3 = r10[r3]
            if (r1 == r0) goto L_0x00e8
            if (r3 == r0) goto L_0x00e8
            int r5 = r4 + 1
            byte r4 = r8[r4]
            byte r6 = r10[r4]
            byte r8 = r8[r5]
            byte r10 = r10[r8]
            if (r6 == r0) goto L_0x009f
            if (r10 != r0) goto L_0x0081
            goto L_0x009f
        L_0x0081:
            int r8 = r1 << 2
            int r0 = r3 >> 4
            r8 = r8 | r0
            byte r8 = (byte) r8
            r9.write(r8)
            r8 = r3 & 15
            int r8 = r8 << 4
            int r0 = r6 >> 2
            r0 = r0 & 15
            r8 = r8 | r0
            byte r8 = (byte) r8
            r9.write(r8)
            int r8 = r6 << 6
        L_0x0099:
            r8 = r8 | r10
            byte r8 = (byte) r8
            r9.write(r8)
            return
        L_0x009f:
            boolean r10 = b((byte) r4)
            if (r10 == 0) goto L_0x00ba
            boolean r10 = b((byte) r8)
            if (r10 == 0) goto L_0x00ba
            r8 = r3 & 15
            if (r8 != 0) goto L_0x00b4
            int r8 = r1 << 2
            int r10 = r3 >> 4
            goto L_0x0099
        L_0x00b4:
            org.apache.xml.security.exceptions.Base64DecodingException r8 = new org.apache.xml.security.exceptions.Base64DecodingException
            r8.<init>(r2)
            throw r8
        L_0x00ba:
            boolean r10 = b((byte) r4)
            if (r10 != 0) goto L_0x00e2
            boolean r8 = b((byte) r8)
            if (r8 == 0) goto L_0x00e2
            r8 = r6 & 3
            if (r8 != 0) goto L_0x00dc
            int r8 = r1 << 2
            int r10 = r3 >> 4
            r8 = r8 | r10
            byte r8 = (byte) r8
            r9.write(r8)
            r8 = r3 & 15
            int r8 = r8 << 4
            int r10 = r6 >> 2
            r10 = r10 & 15
            goto L_0x0099
        L_0x00dc:
            org.apache.xml.security.exceptions.Base64DecodingException r8 = new org.apache.xml.security.exceptions.Base64DecodingException
            r8.<init>(r2)
            throw r8
        L_0x00e2:
            org.apache.xml.security.exceptions.Base64DecodingException r8 = new org.apache.xml.security.exceptions.Base64DecodingException
            r8.<init>(r2)
            throw r8
        L_0x00e8:
            org.apache.xml.security.exceptions.Base64DecodingException r8 = new org.apache.xml.security.exceptions.Base64DecodingException
            r8.<init>(r2)
            throw r8
        L_0x00ee:
            org.apache.xml.security.exceptions.Base64DecodingException r8 = new org.apache.xml.security.exceptions.Base64DecodingException
            java.lang.String r9 = "decoding.divisible.four"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.utils.Base64.a(byte[], java.io.OutputStream, int):void");
    }

    protected static final boolean a(byte b2) {
        return b2 == 32 || b2 == 13 || b2 == 10 || b2 == 9;
    }

    public static final byte[] a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bArr = new byte[str.length()];
        return b(bArr, a(str, bArr));
    }

    public static final byte[] a(Element element) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 3) {
                stringBuffer.append(((Text) firstChild).getData());
            }
        }
        return a(stringBuffer.toString());
    }

    public static final byte[] a(byte[] bArr) {
        return b(bArr, -1);
    }

    public static final String b(byte[] bArr) {
        return a(bArr, XMLUtils.a() ? Integer.MAX_VALUE : 76);
    }

    protected static final boolean b(byte b2) {
        return b2 == 61;
    }

    protected static final byte[] b(byte[] bArr, int i2) {
        byte[] bArr2;
        if (i2 == -1) {
            i2 = c(bArr);
        }
        if (i2 % 4 == 0) {
            int i3 = i2 / 4;
            int i4 = 0;
            if (i3 == 0) {
                return new byte[0];
            }
            int i5 = i3 - 1;
            int i6 = i5 * 4;
            int i7 = i5 * 3;
            byte[] bArr3 = f72745a;
            int i8 = i6 + 1;
            byte b2 = bArr3[bArr[i6]];
            int i9 = i8 + 1;
            byte b3 = bArr3[bArr[i8]];
            if (b2 == -1 || b3 == -1) {
                throw new Base64DecodingException("decoding.general");
            }
            int i10 = i9 + 1;
            byte b4 = bArr[i9];
            byte b5 = bArr3[b4];
            byte b6 = bArr[i10];
            byte b7 = bArr3[b6];
            if (b5 != -1 && b7 != -1) {
                bArr2 = new byte[(i7 + 3)];
                int i11 = i7 + 1;
                bArr2[i7] = (byte) ((b2 << 2) | (b3 >> 4));
                bArr2[i11] = (byte) (((b3 & 15) << 4) | ((b5 >> 2) & 15));
                bArr2[i11 + 1] = (byte) ((b5 << 6) | b7);
            } else if (!b(b4) || !b(b6)) {
                if (b(b4) || !b(b6)) {
                    throw new Base64DecodingException("decoding.general");
                } else if ((b5 & 3) == 0) {
                    bArr2 = new byte[(i7 + 2)];
                    bArr2[i7] = (byte) ((b2 << 2) | (b3 >> 4));
                    bArr2[i7 + 1] = (byte) (((b3 & 15) << 4) | ((b5 >> 2) & 15));
                } else {
                    throw new Base64DecodingException("decoding.general");
                }
            } else if ((b3 & 15) == 0) {
                bArr2 = new byte[(i7 + 1)];
                bArr2[i7] = (byte) ((b2 << 2) | (b3 >> 4));
            } else {
                throw new Base64DecodingException("decoding.general");
            }
            int i12 = 0;
            while (i5 > 0) {
                byte[] bArr4 = f72745a;
                int i13 = i4 + 1;
                byte b8 = bArr4[bArr[i4]];
                int i14 = i13 + 1;
                byte b9 = bArr4[bArr[i13]];
                int i15 = i14 + 1;
                byte b10 = bArr4[bArr[i14]];
                int i16 = i15 + 1;
                byte b11 = bArr4[bArr[i15]];
                if (b8 == -1 || b9 == -1 || b10 == -1 || b11 == -1) {
                    throw new Base64DecodingException("decoding.general");
                }
                int i17 = i12 + 1;
                bArr2[i12] = (byte) ((b8 << 2) | (b9 >> 4));
                int i18 = i17 + 1;
                bArr2[i17] = (byte) (((b9 & 15) << 4) | ((b10 >> 2) & 15));
                i12 = i18 + 1;
                bArr2[i18] = (byte) (b11 | (b10 << 6));
                i5--;
                i4 = i16;
            }
            return bArr2;
        }
        throw new Base64DecodingException("decoding.divisible.four");
    }

    protected static final int c(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int i2 = 0;
        for (byte b2 : bArr) {
            if (!a(b2)) {
                bArr[i2] = b2;
                i2++;
            }
        }
        return i2;
    }
}
