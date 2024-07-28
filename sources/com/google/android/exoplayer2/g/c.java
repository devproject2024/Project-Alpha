package com.google.android.exoplayer2.g;

import android.util.Pair;
import com.google.android.exoplayer2.v;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import java.util.ArrayList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f32509a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f32510b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, SafetyNetStatusCodes.SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES, 11025, 8000, 7350};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f32511c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static byte[] a(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))};
    }

    public static Pair<Integer, Integer> a(byte[] bArr) throws v {
        return a(new q(bArr), false);
    }

    public static Pair<Integer, Integer> a(q qVar, boolean z) throws v {
        int a2 = a(qVar);
        int b2 = b(qVar);
        int c2 = qVar.c(4);
        if (a2 == 5 || a2 == 29) {
            b2 = b(qVar);
            a2 = a(qVar);
            if (a2 == 22) {
                c2 = qVar.c(4);
            }
        }
        boolean z2 = true;
        if (z) {
            if (!(a2 == 1 || a2 == 2 || a2 == 3 || a2 == 4 || a2 == 6 || a2 == 7 || a2 == 17)) {
                switch (a2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new v("Unsupported audio object type: ".concat(String.valueOf(a2)));
                }
            }
            a(qVar, a2, c2);
            switch (a2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int c3 = qVar.c(2);
                    if (c3 == 2 || c3 == 3) {
                        throw new v("Unsupported epConfig: ".concat(String.valueOf(c3)));
                    }
            }
        }
        int i2 = f32511c[c2];
        if (i2 == -1) {
            z2 = false;
        }
        a.a(z2);
        return Pair.create(Integer.valueOf(b2), Integer.valueOf(i2));
    }

    public static byte[] a(int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        while (true) {
            int[] iArr = f32510b;
            if (i5 >= iArr.length) {
                break;
            }
            if (i2 == iArr[i5]) {
                i6 = i5;
            }
            i5++;
        }
        int i7 = -1;
        while (true) {
            int[] iArr2 = f32511c;
            if (i4 >= iArr2.length) {
                break;
            }
            if (i3 == iArr2[i4]) {
                i7 = i4;
            }
            i4++;
        }
        if (i2 != -1 && i7 != -1) {
            return a(2, i6, i7);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i2 + ", " + i3);
    }

    public static String b(int i2, int i3, int i4) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = f32509a;
        byte[] bArr3 = new byte[(bArr2.length + i3)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, f32509a.length, i3);
        return bArr3;
    }

    public static byte[][] b(byte[] bArr) {
        if (!b(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        do {
            arrayList.add(Integer.valueOf(i2));
            i2 = a(bArr, i2 + f32509a.length);
        } while (i2 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i3 = 0;
        while (i3 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i3)).intValue();
            byte[] bArr3 = new byte[((i3 < arrayList.size() + -1 ? ((Integer) arrayList.get(i3 + 1)).intValue() : bArr.length) - intValue)];
            System.arraycopy(bArr, intValue, bArr3, 0, bArr3.length);
            bArr2[i3] = bArr3;
            i3++;
        }
        return bArr2;
    }

    private static int a(byte[] bArr, int i2) {
        int length = bArr.length - f32509a.length;
        while (i2 <= length) {
            if (b(bArr, i2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static boolean b(byte[] bArr, int i2) {
        if (bArr.length - i2 <= f32509a.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f32509a;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private static int a(q qVar) {
        int c2 = qVar.c(5);
        return c2 == 31 ? qVar.c(6) + 32 : c2;
    }

    private static int b(q qVar) {
        int c2 = qVar.c(4);
        if (c2 == 15) {
            return qVar.c(24);
        }
        a.a(c2 < 13);
        return f32510b[c2];
    }

    private static void a(q qVar, int i2, int i3) {
        qVar.b(1);
        if (qVar.e()) {
            qVar.b(14);
        }
        boolean e2 = qVar.e();
        if (i3 != 0) {
            if (i2 == 6 || i2 == 20) {
                qVar.b(3);
            }
            if (e2) {
                if (i2 == 22) {
                    qVar.b(16);
                }
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    qVar.b(3);
                }
                qVar.b(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }
}
