package com.google.zxing.e;

public final class b extends s {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f40362a = {'A', 'B', 'C', 'D'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f40363b = {'T', 'N', '*', 'E'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f40364c = {'/', ':', '+', '.'};

    /* renamed from: d  reason: collision with root package name */
    private static final char f40365d = f40362a[0];

    public final boolean[] a(String str) {
        int i2;
        if (str.length() < 2) {
            str = f40365d + str + f40365d;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean a2 = a.a(f40362a, upperCase);
            boolean a3 = a.a(f40362a, upperCase2);
            boolean a4 = a.a(f40363b, upperCase);
            boolean a5 = a.a(f40363b, upperCase2);
            if (a2) {
                if (!a3) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
            } else if (a4) {
                if (!a5) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
            } else if (a3 || a5) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
            } else {
                str = f40365d + str + f40365d;
            }
        }
        int i3 = 20;
        for (int i4 = 1; i4 < str.length() - 1; i4++) {
            if (Character.isDigit(str.charAt(i4)) || str.charAt(i4) == '-' || str.charAt(i4) == '$') {
                i3 += 9;
            } else if (a.a(f40364c, str.charAt(i4))) {
                i3 += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i4) + '\'');
            }
        }
        boolean[] zArr = new boolean[(i3 + (str.length() - 1))];
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i6));
            if (i6 == 0 || i6 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i7 = 0;
            while (true) {
                if (i7 >= a.f40304a.length) {
                    i2 = 0;
                    break;
                } else if (upperCase3 == a.f40304a[i7]) {
                    i2 = a.f40305b[i7];
                    break;
                } else {
                    i7++;
                }
            }
            int i8 = i5;
            int i9 = 0;
            boolean z = true;
            while (true) {
                int i10 = 0;
                while (i9 < 7) {
                    zArr[i8] = z;
                    i8++;
                    if (((i2 >> (6 - i9)) & 1) == 0 || i10 == 1) {
                        z = !z;
                        i9++;
                    } else {
                        i10++;
                    }
                }
                break;
            }
            if (i6 < str.length() - 1) {
                zArr[i8] = false;
                i8++;
            }
            i5 = i8;
        }
        return zArr;
    }
}
