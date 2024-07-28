package com.google.a.a.c.a;

public final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f7553a = {'+'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f7554b = "0123456789ABCDEF".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7555c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean[] f7556d;

    public c(String str, boolean z) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        } else if (z && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        } else if (!str.contains("%")) {
            this.f7555c = z;
            this.f7556d = b(str);
        } else {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
    }

    private static boolean[] b(String str) {
        char[] charArray = str.toCharArray();
        int i2 = 122;
        for (char max : charArray) {
            i2 = Math.max(max, i2);
        }
        boolean[] zArr = new boolean[(i2 + 1)];
        for (int i3 = 48; i3 <= 57; i3++) {
            zArr[i3] = true;
        }
        for (int i4 = 65; i4 <= 90; i4++) {
            zArr[i4] = true;
        }
        for (int i5 = 97; i5 <= 122; i5++) {
            zArr[i5] = true;
        }
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        return zArr;
    }

    /* access modifiers changed from: protected */
    public final int a(CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            boolean[] zArr = this.f7556d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public final String a(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            boolean[] zArr = this.f7556d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return a(str, i2);
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final char[] a(int i2) {
        boolean[] zArr = this.f7556d;
        if (i2 < zArr.length && zArr[i2]) {
            return null;
        }
        if (i2 == 32 && this.f7555c) {
            return f7553a;
        }
        if (i2 <= 127) {
            char[] cArr = new char[3];
            cArr[0] = '%';
            char[] cArr2 = f7554b;
            cArr[2] = cArr2[i2 & 15];
            cArr[1] = cArr2[i2 >>> 4];
            return cArr;
        } else if (i2 <= 2047) {
            char[] cArr3 = new char[6];
            cArr3[0] = '%';
            cArr3[3] = '%';
            char[] cArr4 = f7554b;
            cArr3[5] = cArr4[i2 & 15];
            int i3 = i2 >>> 4;
            cArr3[4] = cArr4[(i3 & 3) | 8];
            int i4 = i3 >>> 2;
            cArr3[2] = cArr4[i4 & 15];
            cArr3[1] = cArr4[(i4 >>> 4) | 12];
            return cArr3;
        } else if (i2 <= 65535) {
            char[] cArr5 = new char[9];
            cArr5[0] = '%';
            cArr5[1] = 'E';
            cArr5[3] = '%';
            cArr5[6] = '%';
            char[] cArr6 = f7554b;
            cArr5[8] = cArr6[i2 & 15];
            int i5 = i2 >>> 4;
            cArr5[7] = cArr6[(i5 & 3) | 8];
            int i6 = i5 >>> 2;
            cArr5[5] = cArr6[i6 & 15];
            int i7 = i6 >>> 4;
            cArr5[4] = cArr6[(i7 & 3) | 8];
            cArr5[2] = cArr6[i7 >>> 2];
            return cArr5;
        } else if (i2 <= 1114111) {
            char[] cArr7 = new char[12];
            cArr7[0] = '%';
            cArr7[1] = 'F';
            cArr7[3] = '%';
            cArr7[6] = '%';
            cArr7[9] = '%';
            char[] cArr8 = f7554b;
            cArr7[11] = cArr8[i2 & 15];
            int i8 = i2 >>> 4;
            cArr7[10] = cArr8[(i8 & 3) | 8];
            int i9 = i8 >>> 2;
            cArr7[8] = cArr8[i9 & 15];
            int i10 = i9 >>> 4;
            cArr7[7] = cArr8[(i10 & 3) | 8];
            int i11 = i10 >>> 2;
            cArr7[5] = cArr8[i11 & 15];
            int i12 = i11 >>> 4;
            cArr7[4] = cArr8[(i12 & 3) | 8];
            cArr7[2] = cArr8[(i12 >>> 2) & 7];
            return cArr7;
        } else {
            throw new IllegalArgumentException("Invalid unicode character value ".concat(String.valueOf(i2)));
        }
    }
}
