package androidx.core.graphics;

import android.graphics.Path;
import java.util.ArrayList;

public final class c {
    static float[] a(float[] fArr, int i2) {
        if (i2 >= 0) {
            int length = fArr.length;
            if (length >= 0) {
                int i3 = i2 - 0;
                int min = Math.min(i3, length - 0);
                float[] fArr2 = new float[i3];
                System.arraycopy(fArr, 0, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static Path a(String str) {
        Path path = new Path();
        b[] b2 = b(str);
        if (b2 == null) {
            return null;
        }
        try {
            b.a(b2, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing ".concat(String.valueOf(str)), e2);
        }
    }

    public static b[] b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int a2 = a(str, i2);
            String trim = str.substring(i3, a2).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), c(trim));
            }
            i3 = a2;
            i2 = a2 + 1;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            a(arrayList, str.charAt(i3), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static b[] a(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr2[i2] = new b(bVarArr[i2]);
        }
        return bVarArr2;
    }

    public static boolean a(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            if (bVarArr[i2].f2979a != bVarArr2[i2].f2979a || bVarArr[i2].f2980b.length != bVarArr2[i2].f2980b.length) {
                return false;
            }
        }
        return true;
    }

    private static int a(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    private static void a(ArrayList<b> arrayList, char c2, float[] fArr) {
        arrayList.add(new b(c2, fArr));
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2977a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2978b;

        a() {
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        r8 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005e A[Catch:{ NumberFormatException -> 0x0082 }, LOOP:1: B:8:0x002d->B:28:0x005e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067 A[Catch:{ NumberFormatException -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078 A[Catch:{ NumberFormatException -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a A[Catch:{ NumberFormatException -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0061 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float[] c(java.lang.String r13) {
        /*
            r0 = 0
            char r1 = r13.charAt(r0)
            r2 = 122(0x7a, float:1.71E-43)
            if (r1 == r2) goto L_0x009c
            char r1 = r13.charAt(r0)
            r2 = 90
            if (r1 != r2) goto L_0x0013
            goto L_0x009c
        L_0x0013:
            int r1 = r13.length()     // Catch:{ NumberFormatException -> 0x0082 }
            float[] r1 = new float[r1]     // Catch:{ NumberFormatException -> 0x0082 }
            androidx.core.graphics.c$a r2 = new androidx.core.graphics.c$a     // Catch:{ NumberFormatException -> 0x0082 }
            r2.<init>()     // Catch:{ NumberFormatException -> 0x0082 }
            int r3 = r13.length()     // Catch:{ NumberFormatException -> 0x0082 }
            r4 = 1
            r5 = 1
            r6 = 0
        L_0x0025:
            if (r5 >= r3) goto L_0x007d
            r2.f2978b = r0     // Catch:{ NumberFormatException -> 0x0082 }
            r7 = r5
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x002d:
            int r11 = r13.length()     // Catch:{ NumberFormatException -> 0x0082 }
            if (r7 >= r11) goto L_0x0061
            char r11 = r13.charAt(r7)     // Catch:{ NumberFormatException -> 0x0082 }
            r12 = 32
            if (r11 == r12) goto L_0x005a
            r12 = 69
            if (r11 == r12) goto L_0x0058
            r12 = 101(0x65, float:1.42E-43)
            if (r11 == r12) goto L_0x0058
            switch(r11) {
                case 44: goto L_0x005a;
                case 45: goto L_0x004f;
                case 46: goto L_0x0047;
                default: goto L_0x0046;
            }     // Catch:{ NumberFormatException -> 0x0082 }
        L_0x0046:
            goto L_0x0056
        L_0x0047:
            if (r9 != 0) goto L_0x004c
            r8 = 0
            r9 = 1
            goto L_0x005c
        L_0x004c:
            r2.f2978b = r4     // Catch:{ NumberFormatException -> 0x0082 }
            goto L_0x005a
        L_0x004f:
            if (r7 == r5) goto L_0x0056
            if (r8 != 0) goto L_0x0056
            r2.f2978b = r4     // Catch:{ NumberFormatException -> 0x0082 }
            goto L_0x005a
        L_0x0056:
            r8 = 0
            goto L_0x005c
        L_0x0058:
            r8 = 1
            goto L_0x005c
        L_0x005a:
            r8 = 0
            r10 = 1
        L_0x005c:
            if (r10 != 0) goto L_0x0061
            int r7 = r7 + 1
            goto L_0x002d
        L_0x0061:
            r2.f2977a = r7     // Catch:{ NumberFormatException -> 0x0082 }
            int r7 = r2.f2977a     // Catch:{ NumberFormatException -> 0x0082 }
            if (r5 >= r7) goto L_0x0074
            int r8 = r6 + 1
            java.lang.String r5 = r13.substring(r5, r7)     // Catch:{ NumberFormatException -> 0x0082 }
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ NumberFormatException -> 0x0082 }
            r1[r6] = r5     // Catch:{ NumberFormatException -> 0x0082 }
            r6 = r8
        L_0x0074:
            boolean r5 = r2.f2978b     // Catch:{ NumberFormatException -> 0x0082 }
            if (r5 == 0) goto L_0x007a
            r5 = r7
            goto L_0x0025
        L_0x007a:
            int r5 = r7 + 1
            goto L_0x0025
        L_0x007d:
            float[] r13 = a((float[]) r1, (int) r6)     // Catch:{ NumberFormatException -> 0x0082 }
            return r13
        L_0x0082:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "error in parsing \""
            r2.<init>(r3)
            r2.append(r13)
            java.lang.String r13 = "\""
            r2.append(r13)
            java.lang.String r13 = r2.toString()
            r1.<init>(r13, r0)
            throw r1
        L_0x009c:
            float[] r13 = new float[r0]
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.c.c(java.lang.String):float[]");
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public char f2979a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f2980b;

        b(char c2, float[] fArr) {
            this.f2979a = c2;
            this.f2980b = fArr;
        }

        b(b bVar) {
            this.f2979a = bVar.f2979a;
            float[] fArr = bVar.f2980b;
            this.f2980b = c.a(fArr, fArr.length);
        }

        public static void a(b[] bVarArr, Path path) {
            int i2;
            char c2;
            int i3;
            int i4;
            float[] fArr;
            int i5;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            int i6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            b[] bVarArr2 = bVarArr;
            Path path2 = path;
            float[] fArr2 = new float[6];
            char c3 = 0;
            char c4 = 'm';
            int i7 = 0;
            while (i7 < bVarArr2.length) {
                char c5 = bVarArr2[i7].f2979a;
                float[] fArr3 = bVarArr2[i7].f2980b;
                float f15 = fArr2[c3];
                float f16 = fArr2[1];
                float f17 = fArr2[2];
                float f18 = fArr2[3];
                float f19 = fArr2[4];
                float f20 = fArr2[5];
                switch (c5) {
                    case 'A':
                    case 'a':
                        i2 = 7;
                        break;
                    case 'C':
                    case 'c':
                        i2 = 6;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i2 = 1;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i2 = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path2.moveTo(f19, f20);
                        f15 = f19;
                        f17 = f15;
                        f16 = f20;
                        f18 = f16;
                        break;
                }
                i2 = 2;
                float f21 = f19;
                float f22 = f20;
                int i8 = 0;
                float f23 = f15;
                float f24 = f16;
                while (i8 < fArr3.length) {
                    if (c5 != 'A') {
                        if (c5 == 'C') {
                            i4 = i8;
                            fArr = fArr3;
                            c2 = c5;
                            i3 = i7;
                            int i9 = i4 + 2;
                            int i10 = i4 + 3;
                            int i11 = i4 + 4;
                            int i12 = i4 + 5;
                            path.cubicTo(fArr[i4 + 0], fArr[i4 + 1], fArr[i9], fArr[i10], fArr[i11], fArr[i12]);
                            f23 = fArr[i11];
                            f24 = fArr[i12];
                            float f25 = fArr[i9];
                            f18 = fArr[i10];
                            f17 = f25;
                        } else if (c5 == 'H') {
                            i4 = i8;
                            fArr = fArr3;
                            c2 = c5;
                            i3 = i7;
                            int i13 = i4 + 0;
                            path2.lineTo(fArr[i13], f24);
                            f23 = fArr[i13];
                        } else if (c5 == 'Q') {
                            i4 = i8;
                            fArr = fArr3;
                            c2 = c5;
                            i3 = i7;
                            int i14 = i4 + 0;
                            int i15 = i4 + 1;
                            int i16 = i4 + 2;
                            int i17 = i4 + 3;
                            path2.quadTo(fArr[i14], fArr[i15], fArr[i16], fArr[i17]);
                            float f26 = fArr[i14];
                            float f27 = fArr[i15];
                            f23 = fArr[i16];
                            f24 = fArr[i17];
                            f17 = f26;
                            f18 = f27;
                        } else if (c5 == 'V') {
                            i4 = i8;
                            fArr = fArr3;
                            c2 = c5;
                            i3 = i7;
                            int i18 = i4 + 0;
                            path2.lineTo(f23, fArr[i18]);
                            f24 = fArr[i18];
                        } else if (c5 != 'a') {
                            if (c5 != 'c') {
                                if (c5 == 'h') {
                                    float f28 = f24;
                                    i3 = i7;
                                    int i19 = i8 + 0;
                                    path2.rLineTo(fArr3[i19], 0.0f);
                                    f23 += fArr3[i19];
                                } else if (c5 != 'q') {
                                    if (c5 == 'v') {
                                        f7 = f24;
                                        i3 = i7;
                                        float f29 = f23;
                                        int i20 = i8 + 0;
                                        path2.rLineTo(0.0f, fArr3[i20]);
                                        f8 = fArr3[i20];
                                    } else if (c5 != 'L') {
                                        if (c5 == 'M') {
                                            i3 = i7;
                                            int i21 = i8 + 0;
                                            f23 = fArr3[i21];
                                            int i22 = i8 + 1;
                                            f24 = fArr3[i22];
                                            if (i8 > 0) {
                                                path2.lineTo(fArr3[i21], fArr3[i22]);
                                            } else {
                                                path2.moveTo(fArr3[i21], fArr3[i22]);
                                            }
                                        } else if (c5 == 'S') {
                                            float f30 = f24;
                                            i3 = i7;
                                            float f31 = f23;
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f9 = (f30 * 2.0f) - f18;
                                                f10 = (f31 * 2.0f) - f17;
                                            } else {
                                                f9 = f30;
                                                f10 = f31;
                                            }
                                            int i23 = i8 + 0;
                                            int i24 = i8 + 1;
                                            int i25 = i8 + 2;
                                            int i26 = i8 + 3;
                                            path.cubicTo(f10, f9, fArr3[i23], fArr3[i24], fArr3[i25], fArr3[i26]);
                                            float f32 = fArr3[i23];
                                            float f33 = fArr3[i24];
                                            f23 = fArr3[i25];
                                            f24 = fArr3[i26];
                                            f17 = f32;
                                            f18 = f33;
                                        } else if (c5 == 'T') {
                                            float f34 = f24;
                                            i3 = i7;
                                            float f35 = f23;
                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                f34 = (f34 * 2.0f) - f18;
                                                f35 = (f35 * 2.0f) - f17;
                                            }
                                            int i27 = i8 + 0;
                                            int i28 = i8 + 1;
                                            path2.quadTo(f35, f34, fArr3[i27], fArr3[i28]);
                                            f23 = fArr3[i27];
                                            f24 = fArr3[i28];
                                            f18 = f34;
                                            i4 = i8;
                                            fArr = fArr3;
                                            c2 = c5;
                                            f17 = f35;
                                        } else if (c5 == 'l') {
                                            f7 = f24;
                                            i3 = i7;
                                            int i29 = i8 + 0;
                                            int i30 = i8 + 1;
                                            path2.rLineTo(fArr3[i29], fArr3[i30]);
                                            f23 += fArr3[i29];
                                            f8 = fArr3[i30];
                                        } else if (c5 == 'm') {
                                            i3 = i7;
                                            int i31 = i8 + 0;
                                            f23 += fArr3[i31];
                                            int i32 = i8 + 1;
                                            f24 += fArr3[i32];
                                            if (i8 > 0) {
                                                path2.rLineTo(fArr3[i31], fArr3[i32]);
                                            } else {
                                                path2.rMoveTo(fArr3[i31], fArr3[i32]);
                                            }
                                        } else if (c5 != 's') {
                                            if (c5 == 't') {
                                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                    f13 = f23 - f17;
                                                    f14 = f24 - f18;
                                                } else {
                                                    f14 = 0.0f;
                                                    f13 = 0.0f;
                                                }
                                                int i33 = i8 + 0;
                                                int i34 = i8 + 1;
                                                path2.rQuadTo(f13, f14, fArr3[i33], fArr3[i34]);
                                                float f36 = f13 + f23;
                                                float f37 = f14 + f24;
                                                f23 += fArr3[i33];
                                                f24 += fArr3[i34];
                                                f18 = f37;
                                                f17 = f36;
                                            }
                                            i4 = i8;
                                            fArr = fArr3;
                                            c2 = c5;
                                            i3 = i7;
                                        } else {
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f11 = f24 - f18;
                                                f12 = f23 - f17;
                                            } else {
                                                f12 = 0.0f;
                                                f11 = 0.0f;
                                            }
                                            int i35 = i8 + 0;
                                            int i36 = i8 + 1;
                                            int i37 = i8 + 2;
                                            int i38 = i8 + 3;
                                            f6 = f24;
                                            i6 = i7;
                                            float f38 = f23;
                                            path.rCubicTo(f12, f11, fArr3[i35], fArr3[i36], fArr3[i37], fArr3[i38]);
                                            f2 = f38 + fArr3[i35];
                                            f3 = f6 + fArr3[i36];
                                            f5 = fArr3[i37] + f38;
                                            f4 = fArr3[i38];
                                        }
                                        f22 = f24;
                                        f21 = f23;
                                    } else {
                                        i3 = i7;
                                        int i39 = i8 + 0;
                                        int i40 = i8 + 1;
                                        path2.lineTo(fArr3[i39], fArr3[i40]);
                                        f23 = fArr3[i39];
                                        f24 = fArr3[i40];
                                    }
                                    f24 = f7 + f8;
                                } else {
                                    float f39 = f24;
                                    i3 = i7;
                                    float f40 = f23;
                                    int i41 = i8 + 0;
                                    int i42 = i8 + 1;
                                    int i43 = i8 + 2;
                                    int i44 = i8 + 3;
                                    path2.rQuadTo(fArr3[i41], fArr3[i42], fArr3[i43], fArr3[i44]);
                                    float f41 = f39 + fArr3[i42];
                                    f17 = fArr3[i41] + f40;
                                    f23 = fArr3[i43] + f40;
                                    f18 = f41;
                                    i4 = i8;
                                    fArr = fArr3;
                                    c2 = c5;
                                    f24 = f39 + fArr3[i44];
                                }
                                i4 = i8;
                                fArr = fArr3;
                                c2 = c5;
                            } else {
                                f6 = f24;
                                i6 = i7;
                                float f42 = f23;
                                int i45 = i8 + 2;
                                int i46 = i8 + 3;
                                int i47 = i8 + 4;
                                int i48 = i8 + 5;
                                path.rCubicTo(fArr3[i8 + 0], fArr3[i8 + 1], fArr3[i45], fArr3[i46], fArr3[i47], fArr3[i48]);
                                f2 = f42 + fArr3[i45];
                                f3 = f6 + fArr3[i46];
                                f5 = fArr3[i47] + f42;
                                f4 = fArr3[i48];
                            }
                            f18 = f3;
                            f17 = f2;
                            i4 = i8;
                            fArr = fArr3;
                            c2 = c5;
                            f24 = f6 + f4;
                            f23 = f5;
                        } else {
                            float f43 = f24;
                            i5 = i7;
                            float f44 = f23;
                            int i49 = i8 + 5;
                            float f45 = fArr3[i49] + f44;
                            int i50 = i8 + 6;
                            float f46 = fArr3[i50] + f43;
                            float f47 = fArr3[i8 + 0];
                            float f48 = fArr3[i8 + 1];
                            float f49 = fArr3[i8 + 2];
                            boolean z = fArr3[i8 + 3] != 0.0f;
                            boolean z2 = fArr3[i8 + 4] != 0.0f;
                            i4 = i8;
                            float f50 = f49;
                            fArr = fArr3;
                            c2 = c5;
                            a(path, f44, f43, f45, f46, f47, f48, f50, z, z2);
                            f23 = f44 + fArr[i49];
                            f24 = f43 + fArr[i50];
                        }
                        i8 = i4 + i2;
                        b[] bVarArr3 = bVarArr;
                        fArr3 = fArr;
                        i7 = i3;
                        c4 = c2;
                        c5 = c4;
                    } else {
                        i4 = i8;
                        fArr = fArr3;
                        c2 = c5;
                        i5 = i7;
                        int i51 = i4 + 5;
                        int i52 = i4 + 6;
                        a(path, f23, f24, fArr[i51], fArr[i52], fArr[i4 + 0], fArr[i4 + 1], fArr[i4 + 2], fArr[i4 + 3] != 0.0f, fArr[i4 + 4] != 0.0f);
                        f23 = fArr[i51];
                        f24 = fArr[i52];
                    }
                    f18 = f24;
                    f17 = f23;
                    i8 = i4 + i2;
                    b[] bVarArr32 = bVarArr;
                    fArr3 = fArr;
                    i7 = i3;
                    c4 = c2;
                    c5 = c4;
                }
                int i53 = i7;
                fArr2[0] = f23;
                fArr2[1] = f24;
                fArr2[2] = f17;
                fArr2[3] = f18;
                fArr2[4] = f21;
                fArr2[5] = f22;
                i7 = i53 + 1;
                c4 = bVarArr[i53].f2979a;
                c3 = 0;
                bVarArr2 = bVarArr;
            }
        }

        public final void a(b bVar, b bVar2, float f2) {
            this.f2979a = bVar.f2979a;
            int i2 = 0;
            while (true) {
                float[] fArr = bVar.f2980b;
                if (i2 < fArr.length) {
                    this.f2980b[i2] = (fArr[i2] * (1.0f - f2)) + (bVar2.f2980b[i2] * f2);
                    i2++;
                } else {
                    return;
                }
            }
        }

        private static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            float f9 = f2;
            float f10 = f4;
            boolean z3 = z2;
            float f11 = f6;
            float f12 = f7;
            float f13 = f8;
            while (true) {
                double radians = Math.toRadians((double) f13);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d4 = (double) f9;
                double d5 = d4 * cos;
                double d6 = d4;
                double d7 = (double) f3;
                double d8 = (double) f11;
                double d9 = (d5 + (d7 * sin)) / d8;
                double d10 = (((double) (-f9)) * sin) + (d7 * cos);
                double d11 = d7;
                double d12 = (double) f12;
                float f14 = f11;
                float f15 = f12;
                double d13 = d10 / d12;
                double d14 = (double) f5;
                double d15 = ((((double) f10) * cos) + (d14 * sin)) / d8;
                double d16 = ((((double) (-f10)) * sin) + (d14 * cos)) / d12;
                double d17 = d9 - d15;
                double d18 = d13 - d16;
                double d19 = (d9 + d15) / 2.0d;
                double d20 = (d13 + d16) / 2.0d;
                double d21 = (d17 * d17) + (d18 * d18);
                if (d21 != 0.0d) {
                    double d22 = (1.0d / d21) - 0.25d;
                    if (d22 < 0.0d) {
                        float sqrt = (float) (Math.sqrt(d21) / 1.99999d);
                        f11 = f14 * sqrt;
                        f12 = f15 * sqrt;
                        f9 = f2;
                        f10 = f4;
                        f13 = f8;
                        boolean z4 = z2;
                    } else {
                        double sqrt2 = Math.sqrt(d22);
                        double d23 = d17 * sqrt2;
                        double d24 = sqrt2 * d18;
                        double d25 = d8;
                        boolean z5 = z2;
                        if (z == z5) {
                            d3 = d19 - d24;
                            d2 = d20 + d23;
                        } else {
                            d3 = d19 + d24;
                            d2 = d20 - d23;
                        }
                        double d26 = sin;
                        double atan2 = Math.atan2(d13 - d2, d9 - d3);
                        double atan22 = Math.atan2(d16 - d2, d15 - d3) - atan2;
                        int i2 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
                        if (z5 != (i2 >= 0)) {
                            atan22 = i2 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
                        }
                        double d27 = d3 * d25;
                        double d28 = d2 * d12;
                        a(path, (d27 * cos) - (d28 * d26), (d27 * d26) + (d28 * cos), d25, d12, d6, d11, radians, atan2, atan22);
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        private static void a(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = d10 / ((double) ceil);
            double d20 = d6;
            double d21 = d7;
            double d22 = d18;
            double d23 = d15;
            int i2 = 0;
            double d24 = d9;
            while (i2 < ceil) {
                double d25 = d24 + d19;
                double sin3 = Math.sin(d25);
                double cos3 = Math.cos(d25);
                double d26 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d27 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d28 = (d13 * sin3) - (d14 * cos3);
                double d29 = (sin3 * d16) + (cos3 * d17);
                double d30 = d25 - d24;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                int i3 = ceil;
                double d31 = cos;
                path.rLineTo(0.0f, 0.0f);
                float f2 = (float) (d21 + (d22 * sin4));
                float f3 = (float) (d26 - (sin4 * d28));
                path.cubicTo((float) (d20 + (d23 * sin4)), f2, f3, (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
                i2++;
                d19 = d19;
                ceil = i3;
                sin = sin;
                d21 = d27;
                d16 = d16;
                d24 = d25;
                d22 = d29;
                d23 = d28;
                cos = d31;
                d11 = d4;
                d20 = d26;
            }
        }
    }
}
