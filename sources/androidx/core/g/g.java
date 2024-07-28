package androidx.core.g;

import java.io.PrintWriter;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2969a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static char[] f2970b = new char[24];

    private static int a(char[] cArr, int i2, char c2, int i3, boolean z) {
        int i4;
        if (!z && i2 <= 0) {
            return i3;
        }
        if (i2 > 99) {
            int i5 = i2 / 100;
            cArr[i3] = (char) (i5 + 48);
            i4 = i3 + 1;
            i2 -= i5 * 100;
        } else {
            i4 = i3;
        }
        if (i2 > 9 || i3 != i4) {
            int i6 = i2 / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i2 -= i6 * 10;
        }
        cArr[i4] = (char) (i2 + 48);
        int i7 = i4 + 1;
        cArr[i7] = c2;
        return i7 + 1;
    }

    private static void b(long j, PrintWriter printWriter) {
        char c2;
        int i2;
        int i3;
        int i4;
        synchronized (f2969a) {
            if (f2970b.length < 0) {
                f2970b = new char[0];
            }
            char[] cArr = f2970b;
            int i5 = 1;
            int i6 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i6 == 0) {
                cArr[0] = '0';
            } else {
                if (i6 > 0) {
                    c2 = '+';
                } else {
                    c2 = '-';
                    j = -j;
                }
                int i7 = (int) (j % 1000);
                int floor = (int) Math.floor((double) (j / 1000));
                if (floor > 86400) {
                    i2 = floor / 86400;
                    floor -= 86400 * i2;
                } else {
                    i2 = 0;
                }
                if (floor > 3600) {
                    i3 = floor / 3600;
                    floor -= i3 * 3600;
                } else {
                    i3 = 0;
                }
                if (floor > 60) {
                    i4 = floor / 60;
                    floor -= i4 * 60;
                } else {
                    i4 = 0;
                }
                cArr[0] = c2;
                int a2 = a(cArr, i2, 'd', 1, false);
                int a3 = a(cArr, i3, 'h', a2, a2 != 1);
                int a4 = a(cArr, i4, 'm', a3, a3 != 1);
                int a5 = a(cArr, i7, 'm', a(cArr, floor, 's', a4, a4 != 1), true);
                cArr[a5] = 's';
                i5 = 1 + a5;
            }
            printWriter.print(new String(f2970b, 0, i5));
        }
    }

    public static void a(long j, PrintWriter printWriter) {
        b(j, printWriter);
    }

    public static void a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            b(j - j2, printWriter);
        }
    }
}
