package com.google.a.a.c.a;

public abstract class e extends b {
    /* access modifiers changed from: protected */
    public abstract int a(CharSequence charSequence, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract char[] a(int i2);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: char} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r13, int r14) {
        /*
            r12 = this;
            int r0 = r13.length()
            char[] r1 = com.google.a.a.c.a.d.a()
            r2 = 0
            r4 = r1
            r1 = 0
            r3 = 0
        L_0x000c:
            if (r14 >= r0) goto L_0x00c6
            if (r14 >= r0) goto L_0x00be
            int r5 = r14 + 1
            char r6 = r13.charAt(r14)
            r7 = 55296(0xd800, float:7.7486E-41)
            r8 = 1
            if (r6 < r7) goto L_0x007f
            r7 = 57343(0xdfff, float:8.0355E-41)
            if (r6 <= r7) goto L_0x0022
            goto L_0x007f
        L_0x0022:
            r7 = 56319(0xdbff, float:7.892E-41)
            java.lang.String r9 = " at index "
            java.lang.String r10 = "' with value "
            if (r6 > r7) goto L_0x005e
            if (r5 != r0) goto L_0x002f
            int r6 = -r6
            goto L_0x007f
        L_0x002f:
            char r7 = r13.charAt(r5)
            boolean r11 = java.lang.Character.isLowSurrogate(r7)
            if (r11 == 0) goto L_0x003e
            int r6 = java.lang.Character.toCodePoint(r6, r7)
            goto L_0x007f
        L_0x003e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "Expected low surrogate but got char '"
            r14.<init>(r0)
            r14.append(r7)
            r14.append(r10)
            r14.append(r7)
            r14.append(r9)
            r14.append(r5)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x005e:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "Unexpected low surrogate character '"
            r14.<init>(r0)
            r14.append(r6)
            r14.append(r10)
            r14.append(r6)
            r14.append(r9)
            int r5 = r5 - r8
            r14.append(r5)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x007f:
            if (r6 < 0) goto L_0x00b6
            char[] r5 = r12.a(r6)
            boolean r6 = java.lang.Character.isSupplementaryCodePoint(r6)
            if (r6 == 0) goto L_0x008c
            r8 = 2
        L_0x008c:
            int r8 = r8 + r14
            if (r5 == 0) goto L_0x00b0
            int r6 = r14 - r1
            int r7 = r3 + r6
            int r9 = r5.length
            int r9 = r9 + r7
            int r10 = r4.length
            if (r10 >= r9) goto L_0x00a0
            int r9 = r9 + r0
            int r9 = r9 - r14
            int r9 = r9 + 32
            char[] r4 = a((char[]) r4, (int) r3, (int) r9)
        L_0x00a0:
            if (r6 <= 0) goto L_0x00a6
            r13.getChars(r1, r14, r4, r3)
            r3 = r7
        L_0x00a6:
            int r14 = r5.length
            if (r14 <= 0) goto L_0x00af
            int r14 = r5.length
            java.lang.System.arraycopy(r5, r2, r4, r3, r14)
            int r14 = r5.length
            int r3 = r3 + r14
        L_0x00af:
            r1 = r8
        L_0x00b0:
            int r14 = r12.a((java.lang.CharSequence) r13, (int) r8, (int) r0)
            goto L_0x000c
        L_0x00b6:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Trailing high surrogate at end of input"
            r13.<init>(r14)
            throw r13
        L_0x00be:
            java.lang.IndexOutOfBoundsException r13 = new java.lang.IndexOutOfBoundsException
            java.lang.String r14 = "Index exceeds specified range"
            r13.<init>(r14)
            throw r13
        L_0x00c6:
            int r14 = r0 - r1
            if (r14 <= 0) goto L_0x00d6
            int r14 = r14 + r3
            int r5 = r4.length
            if (r5 >= r14) goto L_0x00d2
            char[] r4 = a((char[]) r4, (int) r3, (int) r14)
        L_0x00d2:
            r13.getChars(r1, r0, r4, r3)
            goto L_0x00d7
        L_0x00d6:
            r14 = r3
        L_0x00d7:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r4, r2, r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.c.a.e.a(java.lang.String, int):java.lang.String");
    }

    private static char[] a(char[] cArr, int i2, int i3) {
        char[] cArr2 = new char[i3];
        if (i2 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i2);
        }
        return cArr2;
    }
}
