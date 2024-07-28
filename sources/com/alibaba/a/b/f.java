package com.alibaba.a.b;

import com.alibaba.a.a;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class f extends e {
    protected static final char[] q = ("\"" + a.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    public final int r;
    public final int s;
    public final int t;
    private final String u;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r5 <= '4') goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(char r4, char r5, char r6, char r7, char r8, char r9) {
        /*
            r0 = 57
            r1 = 0
            r2 = 48
            if (r4 != r2) goto L_0x000c
            if (r5 < r2) goto L_0x000b
            if (r5 <= r0) goto L_0x0020
        L_0x000b:
            return r1
        L_0x000c:
            r3 = 49
            if (r4 != r3) goto L_0x0015
            if (r5 < r2) goto L_0x0014
            if (r5 <= r0) goto L_0x0020
        L_0x0014:
            return r1
        L_0x0015:
            r3 = 50
            if (r4 != r3) goto L_0x0042
            if (r5 < r2) goto L_0x0042
            r4 = 52
            if (r5 <= r4) goto L_0x0020
            goto L_0x0042
        L_0x0020:
            r4 = 53
            r5 = 54
            if (r6 < r2) goto L_0x002d
            if (r6 > r4) goto L_0x002d
            if (r7 < r2) goto L_0x002c
            if (r7 <= r0) goto L_0x0032
        L_0x002c:
            return r1
        L_0x002d:
            if (r6 != r5) goto L_0x0042
            if (r7 == r2) goto L_0x0032
            return r1
        L_0x0032:
            if (r8 < r2) goto L_0x003b
            if (r8 > r4) goto L_0x003b
            if (r9 < r2) goto L_0x003a
            if (r9 <= r0) goto L_0x0040
        L_0x003a:
            return r1
        L_0x003b:
            if (r8 != r5) goto L_0x0042
            if (r9 == r2) goto L_0x0040
            return r1
        L_0x0040:
            r4 = 1
            return r4
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.f.a(char, char, char, char, char, char):boolean");
    }

    private static boolean a(char c2, char c3, char c4, char c5, char c6, char c7, int i2, int i3) {
        if ((c2 == '1' || c2 == '2') && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9' && c5 >= '0' && c5 <= '9') {
            if (c6 == '0') {
                if (c7 < '1' || c7 > '9') {
                    return false;
                }
            } else if (!(c6 == '1' && (c7 == '0' || c7 == '1' || c7 == '2'))) {
                return false;
            }
            return i2 == 48 ? i3 >= 49 && i3 <= 57 : (i2 == 49 || i2 == 50) ? i3 >= 48 && i3 <= 57 : i2 == 51 && (i3 == 48 || i3 == 49);
        }
    }

    public f(String str) {
        this(str, a.DEFAULT_PARSER_FEATURE);
    }

    public f(String str, int i2) {
        this.r = 10;
        this.s = 19;
        this.t = 23;
        this.f6232c = i2;
        this.u = str;
        this.f6234e = -1;
        f();
        if (this.f6233d == 65279) {
            f();
        }
    }

    public final char b(int i2) {
        if (i2 >= this.u.length()) {
            return 26;
        }
        return this.u.charAt(i2);
    }

    public final char f() {
        int i2 = this.f6234e + 1;
        this.f6234e = i2;
        char b2 = b(i2);
        this.f6233d = b2;
        return b2;
    }

    public f(char[] cArr, int i2, int i3) {
        this(new String(cArr, 0, i2), i3);
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, int i3, char[] cArr) {
        this.u.getChars(i2, i3 + i2, cArr, 0);
    }

    public final int c(int i2) {
        return this.u.indexOf(34, i2);
    }

    public final String a(int i2, int i3, int i4, j jVar) {
        return jVar.a(this.u, i2, i3, i4);
    }

    public final byte[] v() {
        return com.alibaba.a.d.a.a(this.u, this.f6238i + 1, this.f6237h);
    }

    public final String l() {
        if (!this.j) {
            return a(this.f6238i + 1, this.f6237h);
        }
        return new String(this.f6236g, 0, this.f6237h);
    }

    public final String a(int i2, int i3) {
        char[] cArr = new char[i3];
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            cArr[i4 - i2] = this.u.charAt(i4);
        }
        return new String(cArr);
    }

    public final String u() {
        char b2 = b((this.f6238i + this.f6237h) - 1);
        int i2 = this.f6237h;
        if (b2 == 'L' || b2 == 'S' || b2 == 'B' || b2 == 'F' || b2 == 'D') {
            i2--;
        }
        return a(this.f6238i, i2);
    }

    public final boolean z() {
        return b(true);
    }

    public final boolean b(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        char b2;
        int i6;
        int i7;
        int i8;
        char b3;
        char b4;
        int length = this.u.length() - this.f6234e;
        if (!z && length > 13) {
            char b5 = b(this.f6234e);
            char b6 = b(this.f6234e + 1);
            char b7 = b(this.f6234e + 2);
            char b8 = b(this.f6234e + 3);
            char b9 = b(this.f6234e + 4);
            char b10 = b(this.f6234e + 5);
            char b11 = b((this.f6234e + length) - 1);
            char b12 = b((this.f6234e + length) - 2);
            if (b5 == '/' && b6 == 'D' && b7 == 'a' && b8 == 't' && b9 == 'e' && b10 == '(' && b11 == '/' && b12 == ')') {
                int i9 = -1;
                for (int i10 = 6; i10 < length; i10++) {
                    char b13 = b(this.f6234e + i10);
                    if (b13 != '+') {
                        if (b13 < '0' || b13 > '9') {
                            break;
                        }
                    } else {
                        i9 = i10;
                    }
                }
                if (i9 == -1) {
                    return false;
                }
                int i11 = this.f6234e + 6;
                long parseLong = Long.parseLong(a(i11, i9 - i11));
                this.k = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                this.k.setTimeInMillis(parseLong);
                this.f6230a = 5;
                return true;
            }
        }
        if (length == 8 || length == 14 || length == 17) {
            if (z) {
                return false;
            }
            char b14 = b(this.f6234e);
            char b15 = b(this.f6234e + 1);
            char b16 = b(this.f6234e + 2);
            char b17 = b(this.f6234e + 3);
            char b18 = b(this.f6234e + 4);
            char b19 = b(this.f6234e + 5);
            char b20 = b(this.f6234e + 6);
            char b21 = b(this.f6234e + 7);
            if (!a(b14, b15, b16, b17, b18, b19, (int) b20, (int) b21)) {
                return false;
            }
            a(b14, b15, b16, b17, b18, b19, b20, b21);
            if (length != 8) {
                char b22 = b(this.f6234e + 8);
                char b23 = b(this.f6234e + 9);
                char b24 = b(this.f6234e + 10);
                char b25 = b(this.f6234e + 11);
                char b26 = b(this.f6234e + 12);
                char b27 = b(this.f6234e + 13);
                if (!a(b22, b23, b24, b25, b26, b27)) {
                    return false;
                }
                if (length == 17) {
                    char b28 = b(this.f6234e + 14);
                    char b29 = b(this.f6234e + 15);
                    char b30 = b(this.f6234e + 16);
                    if (b28 < '0' || b28 > '9' || b29 < '0' || b29 > '9' || b30 < '0' || b30 > '9') {
                        return false;
                    }
                    i2 = (p[b28] * 100) + (p[b29] * 10) + p[b30];
                } else {
                    i2 = 0;
                }
                i5 = (p[b22] * 10) + p[b23];
                i4 = (p[b24] * 10) + p[b25];
                i3 = (p[b26] * 10) + p[b27];
            } else {
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            }
            this.k.set(11, i5);
            this.k.set(12, i4);
            this.k.set(13, i3);
            this.k.set(14, i2);
            this.f6230a = 5;
            return true;
        } else if (length < this.r || b(this.f6234e + 4) != '-' || b(this.f6234e + 7) != '-') {
            return false;
        } else {
            char b31 = b(this.f6234e);
            char b32 = b(this.f6234e + 1);
            char b33 = b(this.f6234e + 2);
            char b34 = b(this.f6234e + 3);
            char b35 = b(this.f6234e + 5);
            char b36 = b(this.f6234e + 6);
            char b37 = b(this.f6234e + 8);
            char b38 = b(this.f6234e + 9);
            if (!a(b31, b32, b33, b34, b35, b36, (int) b37, (int) b38)) {
                return false;
            }
            a(b31, b32, b33, b34, b35, b36, b37, b38);
            char b39 = b(this.f6234e + 10);
            if (b39 == 'T' || (b39 == ' ' && !z)) {
                if (length < this.s || b(this.f6234e + 13) != ':' || b(this.f6234e + 16) != ':') {
                    return false;
                }
                char b40 = b(this.f6234e + 11);
                char b41 = b(this.f6234e + 12);
                char b42 = b(this.f6234e + 14);
                char b43 = b(this.f6234e + 15);
                char b44 = b(this.f6234e + 17);
                char b45 = b(this.f6234e + 18);
                if (!a(b40, b41, b42, b43, b44, b45)) {
                    return false;
                }
                int i12 = (p[b40] * 10) + p[b41];
                int i13 = (p[b42] * 10) + p[b43];
                int i14 = (p[b44] * 10) + p[b45];
                this.k.set(11, i12);
                this.k.set(12, i13);
                this.k.set(13, i14);
                if (b(this.f6234e + 19) == '.') {
                    if (length >= this.t && (b2 = b(this.f6234e + 20)) >= '0' && b2 <= '9') {
                        int i15 = p[b2];
                        char b46 = b(this.f6234e + 21);
                        if (b46 < '0' || b46 > '9') {
                            i7 = 2;
                            i6 = 1;
                        } else {
                            i15 = (i15 * 10) + p[b46];
                            i7 = 2;
                            i6 = 2;
                        }
                        if (i6 == i7 && (b4 = b(this.f6234e + 22)) >= '0' && b4 <= '9') {
                            i15 = (i15 * 10) + p[b4];
                            i6 = 3;
                        }
                        this.k.set(14, i15);
                        char b47 = b(this.f6234e + 20 + i6);
                        if (b47 == '+' || b47 == '-') {
                            char b48 = b(this.f6234e + 20 + i6 + 1);
                            if (b48 >= '0' && b48 <= '1' && (b3 = b(this.f6234e + 20 + i6 + 2)) >= '0' && b3 <= '9') {
                                char b49 = b(this.f6234e + 20 + i6 + 3);
                                if (b49 == ':') {
                                    if (b(this.f6234e + 20 + i6 + 4) != '0' || b(this.f6234e + 20 + i6 + 5) != '0') {
                                        return false;
                                    }
                                    i8 = 6;
                                } else if (b49 != '0') {
                                    i8 = 3;
                                } else if (b(this.f6234e + 20 + i6 + 4) != '0') {
                                    return false;
                                } else {
                                    i8 = 5;
                                }
                                int i16 = ((p[b48] * 10) + p[b3]) * 3600 * 1000;
                                if (b47 == '-') {
                                    i16 = -i16;
                                }
                                if (this.k.getTimeZone().getRawOffset() != i16) {
                                    String[] availableIDs = TimeZone.getAvailableIDs(i16);
                                    if (availableIDs.length > 0) {
                                        this.k.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                    }
                                }
                            }
                        } else {
                            i8 = 0;
                        }
                        int i17 = i6 + 20 + i8;
                        char b50 = b(this.f6234e + i17);
                        if (b50 != 26 && b50 != '\"') {
                            return false;
                        }
                        int i18 = this.f6234e + i17;
                        this.f6234e = i18;
                        this.f6233d = b(i18);
                        this.f6230a = 5;
                        return true;
                    }
                    return false;
                }
                this.k.set(14, 0);
                int i19 = this.f6234e + 19;
                this.f6234e = i19;
                this.f6233d = b(i19);
                this.f6230a = 5;
                return true;
            } else if (b39 != '\"' && b39 != 26) {
                return false;
            } else {
                this.k.set(11, 0);
                this.k.set(12, 0);
                this.k.set(13, 0);
                this.k.set(14, 0);
                int i20 = this.f6234e + 10;
                this.f6234e = i20;
                this.f6233d = b(i20);
                this.f6230a = 5;
                return true;
            }
        }
    }

    private void a(char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        this.k = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        int i2 = (p[c2] * 1000) + (p[c3] * 100) + (p[c4] * 10) + p[c5];
        int i3 = (p[c8] * 10) + p[c9];
        this.k.set(1, i2);
        this.k.set(2, ((p[c6] * 10) + p[c7]) - 1);
        this.k.set(5, i3);
    }

    public final boolean x() {
        return this.f6234e == this.u.length() || (this.f6233d == 26 && this.f6234e + 1 == this.u.length());
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, char[] cArr, int i3) {
        this.u.getChars(i2, i3 + i2, cArr, 0);
    }
}
