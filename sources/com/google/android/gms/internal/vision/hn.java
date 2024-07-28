package com.google.android.gms.internal.vision;

import net.one97.paytm.nativesdk.Constants.SDKConstants;

final class hn extends hk {
    hn() {
    }

    /* access modifiers changed from: package-private */
    public final int b(byte[] bArr, int i2, int i3) {
        while (r9 < i3 && bArr[r9] >= 0) {
            i2 = r9 + 1;
        }
        if (r9 >= i3) {
            return 0;
        }
        while (r9 < i3) {
            int i4 = r9 + 1;
            byte b2 = bArr[r9];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i4 >= i3) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        r9 = i4 + 1;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                } else if (b2 < -16) {
                    if (i4 >= i3 - 1) {
                        return hj.c(bArr, i4, i3);
                    }
                    int i5 = i4 + 1;
                    byte b3 = bArr[i4];
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        r9 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                } else if (i4 >= i3 - 2) {
                    return hj.c(bArr, i4, i3);
                } else {
                    int i6 = i4 + 1;
                    byte b4 = bArr[i4];
                    if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                        int i7 = i6 + 1;
                        if (bArr[i6] <= -65) {
                            i4 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            r9 = i4;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final String c(byte[] bArr, int i2, int i3) throws eu {
        if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (r13 < i4) {
                byte b2 = bArr[r13];
                if (!(b2 >= 0)) {
                    break;
                }
                i2 = r13 + 1;
                cArr[i5] = (char) b2;
                i5++;
            }
            int i6 = i5;
            while (r13 < i4) {
                int i7 = r13 + 1;
                byte b3 = bArr[r13];
                if (b3 >= 0) {
                    int i8 = i6 + 1;
                    cArr[i6] = (char) b3;
                    while (i7 < i4) {
                        byte b4 = bArr[i7];
                        if (!(b4 >= 0)) {
                            break;
                        }
                        i7++;
                        cArr[i8] = (char) b4;
                        i8++;
                    }
                    r13 = i7;
                    i6 = i8;
                } else if (hl.a(b3)) {
                    if (i7 < i4) {
                        hl.a(b3, bArr[i7], cArr, i6);
                        r13 = i7 + 1;
                        i6++;
                    } else {
                        throw eu.zzgt();
                    }
                } else if (hl.b(b3)) {
                    if (i7 < i4 - 1) {
                        int i9 = i7 + 1;
                        hl.a(b3, bArr[i7], bArr[i9], cArr, i6);
                        r13 = i9 + 1;
                        i6++;
                    } else {
                        throw eu.zzgt();
                    }
                } else if (i7 < i4 - 2) {
                    int i10 = i7 + 1;
                    byte b5 = bArr[i7];
                    int i11 = i10 + 1;
                    hl.a(b3, b5, bArr[i10], bArr[i11], cArr, i6);
                    r13 = i11 + 1;
                    i6 = i6 + 1 + 1;
                } else {
                    throw eu.zzgt();
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    /* access modifiers changed from: package-private */
    public final int a(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        char charAt;
        int length = charSequence.length();
        int i7 = i3 + i2;
        int i8 = 0;
        while (i8 < length && (i6 = i8 + i2) < i7 && (charAt = charSequence.charAt(i8)) < 128) {
            bArr[i6] = (byte) charAt;
            i8++;
        }
        if (i8 == length) {
            return i2 + length;
        }
        int i9 = i2 + i8;
        while (i8 < length) {
            char charAt2 = charSequence.charAt(i8);
            if (charAt2 < 128 && i9 < i7) {
                i5 = i9 + 1;
                bArr[i9] = (byte) charAt2;
            } else if (charAt2 < 2048 && i9 <= i7 - 2) {
                int i10 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 >>> 6) | 960);
                i9 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 & '?') | 128);
                i8++;
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i9 <= i7 - 3) {
                int i11 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 >>> 12) | SDKConstants.ERROR_CODE_480);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i5 = i12 + 1;
                bArr[i12] = (byte) ((charAt2 & '?') | 128);
            } else if (i9 <= i7 - 4) {
                int i13 = i8 + 1;
                if (i13 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i13);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i14 = i9 + 1;
                        bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i16 = i15 + 1;
                        bArr[i15] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i9 = i16 + 1;
                        bArr[i16] = (byte) ((codePoint & 63) | 128);
                        i8 = i13;
                        i8++;
                    } else {
                        i8 = i13;
                    }
                }
                throw new hm(i8 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i4 = i8 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i9);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            } else {
                throw new hm(i8, length);
            }
            i9 = i5;
            i8++;
        }
        return i9;
    }
}
