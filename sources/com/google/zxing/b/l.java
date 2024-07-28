package com.google.zxing.b;

import com.google.zxing.e;
import java.nio.charset.Charset;
import java.util.Map;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39935a = Charset.defaultCharset().name();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f39936b = ("SJIS".equalsIgnoreCase(f39935a) || "EUC_JP".equalsIgnoreCase(f39935a));

    public static String a(byte[] bArr, Map<e, ?> map) {
        byte[] bArr2 = bArr;
        Map<e, ?> map2 = map;
        if (map2 != null && map2.containsKey(e.CHARACTER_SET)) {
            return map2.get(e.CHARACTER_SET).toString();
        }
        int length = bArr2.length;
        int i2 = 0;
        boolean z = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i4 < length && (z2 || z3 || z4)) {
            byte b2 = bArr2[i4] & 255;
            if (z4) {
                if (i5 > 0) {
                    if ((b2 & 128) != 0) {
                        i5--;
                    }
                } else if ((b2 & 128) != 0) {
                    if ((b2 & 64) != 0) {
                        i5++;
                        if ((b2 & 32) == 0) {
                            i7++;
                        } else {
                            i5++;
                            if ((b2 & 16) == 0) {
                                i8++;
                            } else {
                                i5++;
                                if ((b2 & 8) == 0) {
                                    i9++;
                                }
                            }
                        }
                    }
                }
                z4 = false;
            }
            if (z2) {
                if (b2 > Byte.MAX_VALUE && b2 < 160) {
                    z2 = false;
                } else if (b2 > 159 && (b2 < 192 || b2 == 215 || b2 == 247)) {
                    i11++;
                }
            }
            if (z3) {
                if (i6 > 0) {
                    if (b2 >= 64 && b2 != Byte.MAX_VALUE && b2 <= 252) {
                        i6--;
                    }
                } else if (!(b2 == 128 || b2 == 160 || b2 > 239)) {
                    if (b2 <= 160 || b2 >= 224) {
                        if (b2 > Byte.MAX_VALUE) {
                            i6++;
                            int i14 = i12 + 1;
                            if (i14 > i2) {
                                i2 = i14;
                                i12 = i2;
                            } else {
                                i12 = i14;
                            }
                        } else {
                            i12 = 0;
                        }
                        i13 = 0;
                    } else {
                        i3++;
                        int i15 = i13 + 1;
                        if (i15 > i10) {
                            i10 = i15;
                            i13 = i10;
                        } else {
                            i13 = i15;
                        }
                        i12 = 0;
                    }
                }
                z3 = false;
            }
            i4++;
            bArr2 = bArr;
        }
        if (z4 && i5 > 0) {
            z4 = false;
        }
        if (z3 && i6 > 0) {
            z3 = false;
        }
        if (z4 && (z || i7 + i8 + i9 > 0)) {
            return "UTF8";
        }
        if (z3 && (f39936b || i10 >= 3 || i2 >= 3)) {
            return "SJIS";
        }
        if (!z2 || !z3) {
            if (z2) {
                return "ISO8859_1";
            }
            if (z3) {
                return "SJIS";
            }
            if (z4) {
                return "UTF8";
            }
            return f39935a;
        } else if ((i10 != 2 || i3 != 2) && i11 * 10 < length) {
            return "ISO8859_1";
        } else {
            return "SJIS";
        }
    }
}
