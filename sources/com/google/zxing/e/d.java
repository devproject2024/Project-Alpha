package com.google.zxing.e;

import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.w;
import java.util.ArrayList;
import java.util.Map;

public final class d extends s {

    enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public final b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (aVar == com.google.zxing.a.CODE_128) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int i2;
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (charAt <= 127) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                    }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        while (i5 < length) {
            int a2 = a(str, i5, i7);
            int i9 = 100;
            if (a2 == i7) {
                switch (str.charAt(i5)) {
                    case 241:
                        i9 = 102;
                        break;
                    case 242:
                        i9 = 97;
                        break;
                    case 243:
                        i9 = 96;
                        break;
                    case 244:
                        if (i7 == 101) {
                            i9 = 101;
                            break;
                        }
                        break;
                    default:
                        if (i7 != 100) {
                            if (i7 == 101) {
                                i9 = str.charAt(i5) - ' ';
                                if (i9 < 0) {
                                    i9 += 96;
                                    break;
                                }
                            } else {
                                i9 = Integer.parseInt(str.substring(i5, i5 + 2));
                                i5++;
                                break;
                            }
                        } else {
                            i9 = str.charAt(i5) - ' ';
                            break;
                        }
                        break;
                }
                i5++;
            } else {
                i2 = i7 == 0 ? a2 != 100 ? a2 != 101 ? 105 : 103 : 104 : a2;
                i7 = a2;
            }
            arrayList.add(c.f40366a[i2]);
            i6 += i2 * i8;
            if (i5 != 0) {
                i8++;
            }
        }
        arrayList.add(c.f40366a[i6 % 103]);
        arrayList.add(c.f40366a[106]);
        int i10 = 0;
        for (int[] iArr : arrayList) {
            int i11 = i10;
            for (int i12 : (int[]) r13.next()) {
                i11 += i12;
            }
            i10 = i11;
        }
        boolean[] zArr = new boolean[i10];
        for (int[] a3 : arrayList) {
            i3 += a(zArr, i3, a3, true);
        }
        return zArr;
    }

    private static a a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            return a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i3);
        if (charAt2 < '0' || charAt2 > '9') {
            return a.ONE_DIGIT;
        }
        return a.TWO_DIGITS;
    }

    private static int a(CharSequence charSequence, int i2, int i3) {
        a a2;
        a a3;
        char charAt;
        a a4 = a(charSequence, i2);
        if (a4 == a.ONE_DIGIT) {
            return 100;
        }
        if (a4 == a.UNCODABLE) {
            if (i2 >= charSequence.length() || ((charAt = charSequence.charAt(i2)) >= ' ' && (i3 != 101 || charAt >= '`'))) {
                return 100;
            }
            return 101;
        } else if (i3 == 99) {
            return 99;
        } else {
            if (i3 != 100) {
                if (a4 == a.FNC_1) {
                    a4 = a(charSequence, i2 + 1);
                }
                if (a4 == a.TWO_DIGITS) {
                    return 99;
                }
                return 100;
            } else if (a4 == a.FNC_1 || (a2 = a(charSequence, i2 + 2)) == a.UNCODABLE || a2 == a.ONE_DIGIT) {
                return 100;
            } else {
                if (a2 != a.FNC_1) {
                    int i4 = i2 + 4;
                    while (true) {
                        a3 = a(charSequence, i4);
                        if (a3 != a.TWO_DIGITS) {
                            break;
                        }
                        i4 += 2;
                    }
                    if (a3 == a.ONE_DIGIT) {
                        return 100;
                    }
                    return 99;
                } else if (a(charSequence, i2 + 3) == a.TWO_DIGITS) {
                    return 99;
                } else {
                    return 100;
                }
            }
        }
    }
}
