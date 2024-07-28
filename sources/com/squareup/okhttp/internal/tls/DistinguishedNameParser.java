package com.squareup.okhttp.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length = this.dn.length();
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        this.dn = x500Principal.getName("RFC2253");
    }

    private String nextAT() {
        int i2;
        while (true) {
            int i3 = this.pos;
            if (i3 >= this.length || this.chars[i3] != ' ') {
                int i4 = this.pos;
            } else {
                this.pos = i3 + 1;
            }
        }
        int i42 = this.pos;
        if (i42 == this.length) {
            return null;
        }
        this.beg = i42;
        this.pos = i42 + 1;
        while (true) {
            int i5 = this.pos;
            if (i5 >= this.length) {
                break;
            }
            char[] cArr = this.chars;
            if (cArr[i5] == '=' || cArr[i5] == ' ') {
                break;
            }
            this.pos = i5 + 1;
        }
        int i6 = this.pos;
        if (i6 < this.length) {
            this.end = i6;
            if (this.chars[i6] == ' ') {
                while (true) {
                    int i7 = this.pos;
                    if (i7 >= this.length) {
                        break;
                    }
                    char[] cArr2 = this.chars;
                    if (cArr2[i7] == '=' || cArr2[i7] != ' ') {
                        break;
                    }
                    this.pos = i7 + 1;
                }
                char[] cArr3 = this.chars;
                int i8 = this.pos;
                if (cArr3[i8] != '=' || i8 == this.length) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.dn);
                }
            }
            do {
                this.pos++;
                i2 = this.pos;
                if (i2 >= this.length || this.chars[i2] != ' ') {
                    int i9 = this.end;
                    int i10 = this.beg;
                }
                this.pos++;
                i2 = this.pos;
                break;
            } while (this.chars[i2] != ' ');
            int i92 = this.end;
            int i102 = this.beg;
            if (i92 - i102 > 4) {
                char[] cArr4 = this.chars;
                if (cArr4[i102 + 3] == '.' && (cArr4[i102] == 'O' || cArr4[i102] == 'o')) {
                    char[] cArr5 = this.chars;
                    int i11 = this.beg;
                    if (cArr5[i11 + 1] == 'I' || cArr5[i11 + 1] == 'i') {
                        char[] cArr6 = this.chars;
                        int i12 = this.beg;
                        if (cArr6[i12 + 2] == 'D' || cArr6[i12 + 2] == 'd') {
                            this.beg += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.chars;
            int i13 = this.beg;
            return new String(cArr7, i13, this.end - i13);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String quotedAV() {
        this.pos++;
        this.beg = this.pos;
        this.end = this.beg;
        while (true) {
            int i2 = this.pos;
            if (i2 != this.length) {
                char[] cArr = this.chars;
                if (cArr[i2] == '\"') {
                    this.pos = i2 + 1;
                    while (true) {
                        int i3 = this.pos;
                        if (i3 >= this.length || this.chars[i3] != ' ') {
                            char[] cArr2 = this.chars;
                            int i4 = this.beg;
                        } else {
                            this.pos = i3 + 1;
                        }
                    }
                    char[] cArr22 = this.chars;
                    int i42 = this.beg;
                    return new String(cArr22, i42, this.end - i42);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.end] = getEscaped();
                } else {
                    cArr[this.end] = cArr[i2];
                }
                this.pos++;
                this.end++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
    }

    private String hexAV() {
        int i2 = this.pos;
        if (i2 + 4 < this.length) {
            this.beg = i2;
            this.pos = i2 + 1;
            while (true) {
                int i3 = this.pos;
                if (i3 == this.length) {
                    break;
                }
                char[] cArr = this.chars;
                if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                    break;
                } else if (cArr[i3] == ' ') {
                    this.end = i3;
                    this.pos = i3 + 1;
                    while (true) {
                        int i4 = this.pos;
                        if (i4 >= this.length || this.chars[i4] != ' ') {
                            break;
                        }
                        this.pos = i4 + 1;
                    }
                } else {
                    if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                        cArr[i3] = (char) (cArr[i3] + ' ');
                    }
                    this.pos++;
                }
            }
            this.end = this.pos;
            int i5 = this.end;
            int i6 = this.beg;
            int i7 = i5 - i6;
            if (i7 < 5 || (i7 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            byte[] bArr = new byte[(i7 / 2)];
            int i8 = i6 + 1;
            for (int i9 = 0; i9 < bArr.length; i9++) {
                bArr[i9] = (byte) getByte(i8);
                i8 += 2;
            }
            return new String(this.chars, this.beg, i7);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r8.chars;
        r2 = r8.beg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.cur - r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String escapedAV() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.beg = r0
            r8.end = r0
        L_0x0006:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.chars
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x0060
            if (r2 == r5) goto L_0x0053
            r5 = 92
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0053
            if (r2 == r3) goto L_0x0053
            int r2 = r8.end
            int r3 = r2 + 1
            r8.end = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.pos = r0
            goto L_0x0006
        L_0x0040:
            int r0 = r8.end
            int r2 = r0 + 1
            r8.end = r2
            char r2 = r8.getEscaped()
            r1[r0] = r2
            int r0 = r8.pos
            int r0 = r0 + 1
            r8.pos = r0
            goto L_0x0006
        L_0x0053:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0060:
            int r2 = r8.end
            r8.cur = r2
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r2 + 1
            r8.end = r0
            r1[r2] = r6
        L_0x006e:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L_0x0087
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 != r6) goto L_0x0087
            int r2 = r8.end
            int r7 = r2 + 1
            r8.end = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L_0x006e
        L_0x0087:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 == r1) goto L_0x009b
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 == r3) goto L_0x009b
            char r2 = r1[r0]
            if (r2 == r4) goto L_0x009b
            char r0 = r1[r0]
            if (r0 != r5) goto L_0x0006
        L_0x009b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.cur
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.tls.DistinguishedNameParser.escapedAV():java.lang.String");
    }

    private char getEscaped() {
        this.pos++;
        int i2 = this.pos;
        if (i2 != this.length) {
            char c2 = this.chars[i2];
            if (!(c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_' || c2 == '\"' || c2 == '#')) {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return getUTF8();
                        }
                }
            }
            return this.chars[this.pos];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private char getUTF8() {
        int i2;
        int i3;
        int i4 = getByte(this.pos);
        this.pos++;
        if (i4 < 128) {
            return (char) i4;
        }
        if (i4 < 192 || i4 > 247) {
            return '?';
        }
        if (i4 <= 223) {
            i3 = i4 & 31;
            i2 = 1;
        } else if (i4 <= 239) {
            i2 = 2;
            i3 = i4 & 15;
        } else {
            i2 = 3;
            i3 = i4 & 7;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            this.pos++;
            int i6 = this.pos;
            if (i6 == this.length || this.chars[i6] != '\\') {
                return '?';
            }
            this.pos = i6 + 1;
            int i7 = getByte(this.pos);
            this.pos++;
            if ((i7 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (i7 & 63);
        }
        return (char) i3;
    }

    private int getByte(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.length) {
            char c2 = this.chars[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            } else {
                i3 = c2 - '7';
            }
            char c3 = this.chars[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            } else {
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }

    public final String findMostSpecific(String str) {
        String str2;
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        do {
            int i2 = this.pos;
            if (i2 == this.length) {
                return null;
            }
            char c2 = this.chars[i2];
            if (c2 != '\"') {
                str2 = c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : escapedAV() : hexAV();
            } else {
                str2 = quotedAV();
            }
            if (str.equalsIgnoreCase(nextAT)) {
                return str2;
            }
            int i3 = this.pos;
            if (i3 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i3] == ',' || cArr[i3] == ';' || cArr[i3] == '+') {
                this.pos++;
                nextAT = nextAT();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
        } while (nextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
