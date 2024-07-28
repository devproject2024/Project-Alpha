package com.google.android.gms.internal.firebase_ml;

import net.one97.paytm.nativesdk.Constants.SDKConstants;

final class j extends h {
    j() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r13[r14] > -65) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007e, code lost:
        if (r13[r14] > -65) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r13[r14] > -65) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(int r12, byte[] r13, int r14, int r15) {
        /*
            r11 = this;
            r0 = -19
            r1 = -62
            r2 = -16
            r3 = 0
            r4 = -96
            r5 = -32
            r6 = -1
            r7 = -65
            if (r12 == 0) goto L_0x0081
            if (r14 < r15) goto L_0x0013
            return r12
        L_0x0013:
            byte r8 = (byte) r12
            if (r8 >= r5) goto L_0x001f
            if (r8 < r1) goto L_0x001e
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x0082
        L_0x001e:
            return r6
        L_0x001f:
            if (r8 >= r2) goto L_0x0046
            int r12 = r12 >> 8
            int r12 = ~r12
            byte r12 = (byte) r12
            if (r12 != 0) goto L_0x0035
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 < r15) goto L_0x0032
            int r12 = com.google.android.gms.internal.firebase_ml.g.b(r8, r14)
            return r12
        L_0x0032:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x0035:
            if (r12 > r7) goto L_0x0045
            if (r8 != r5) goto L_0x003b
            if (r12 < r4) goto L_0x0045
        L_0x003b:
            if (r8 != r0) goto L_0x003f
            if (r12 >= r4) goto L_0x0045
        L_0x003f:
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x0082
        L_0x0045:
            return r6
        L_0x0046:
            int r9 = r12 >> 8
            int r9 = ~r9
            byte r9 = (byte) r9
            if (r9 != 0) goto L_0x005a
            int r12 = r14 + 1
            byte r9 = r13[r14]
            if (r12 < r15) goto L_0x0057
            int r12 = com.google.android.gms.internal.firebase_ml.g.b(r8, r9)
            return r12
        L_0x0057:
            r14 = r12
            r12 = 0
            goto L_0x005d
        L_0x005a:
            int r12 = r12 >> 16
            byte r12 = (byte) r12
        L_0x005d:
            if (r12 != 0) goto L_0x006d
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 < r15) goto L_0x006a
            int r12 = com.google.android.gms.internal.firebase_ml.g.b((int) r8, (int) r9, (int) r14)
            return r12
        L_0x006a:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x006d:
            if (r9 > r7) goto L_0x0080
            int r8 = r8 << 28
            int r9 = r9 + 112
            int r8 = r8 + r9
            int r8 = r8 >> 30
            if (r8 != 0) goto L_0x0080
            if (r12 > r7) goto L_0x0080
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x0082
        L_0x0080:
            return r6
        L_0x0081:
            r12 = r14
        L_0x0082:
            if (r12 >= r15) goto L_0x008b
            byte r14 = r13[r12]
            if (r14 < 0) goto L_0x008b
            int r12 = r12 + 1
            goto L_0x0082
        L_0x008b:
            if (r12 < r15) goto L_0x008e
            return r3
        L_0x008e:
            if (r12 < r15) goto L_0x0091
            return r3
        L_0x0091:
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 >= 0) goto L_0x00ea
            if (r12 >= r5) goto L_0x00a5
            if (r14 < r15) goto L_0x009c
            return r12
        L_0x009c:
            if (r12 < r1) goto L_0x00a4
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x008e
        L_0x00a4:
            return r6
        L_0x00a5:
            if (r12 >= r2) goto L_0x00c5
            int r8 = r15 + -1
            if (r14 < r8) goto L_0x00b0
            int r12 = com.google.android.gms.internal.firebase_ml.g.b((byte[]) r13, (int) r14, (int) r15)
            return r12
        L_0x00b0:
            int r8 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r7) goto L_0x00c4
            if (r12 != r5) goto L_0x00ba
            if (r14 < r4) goto L_0x00c4
        L_0x00ba:
            if (r12 != r0) goto L_0x00be
            if (r14 >= r4) goto L_0x00c4
        L_0x00be:
            int r12 = r8 + 1
            byte r14 = r13[r8]
            if (r14 <= r7) goto L_0x008e
        L_0x00c4:
            return r6
        L_0x00c5:
            int r8 = r15 + -2
            if (r14 < r8) goto L_0x00ce
            int r12 = com.google.android.gms.internal.firebase_ml.g.b((byte[]) r13, (int) r14, (int) r15)
            return r12
        L_0x00ce:
            int r8 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r7) goto L_0x00e9
            int r12 = r12 << 28
            int r14 = r14 + 112
            int r12 = r12 + r14
            int r12 = r12 >> 30
            if (r12 != 0) goto L_0x00e9
            int r12 = r8 + 1
            byte r14 = r13[r8]
            if (r14 > r7) goto L_0x00e9
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 <= r7) goto L_0x00ea
        L_0x00e9:
            return r6
        L_0x00ea:
            r12 = r14
            goto L_0x008e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.j.a(int, byte[], int, int):int");
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
                throw new i(i8 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i4 = i8 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i9);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            } else {
                throw new i(i8, length);
            }
            i9 = i5;
            i8++;
        }
        return i9;
    }
}
