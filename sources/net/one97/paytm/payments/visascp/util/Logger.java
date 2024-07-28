package net.one97.paytm.payments.visascp.util;

public class Logger {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f656 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f657 = 1;

    public static void d(String str, String str2) {
        int i2 = (f656 + 82) - 1;
        f657 = i2 % 128;
        int i3 = i2 % 2;
    }

    public static void e(String str, String str2, Throwable th) {
        int i2 = f656;
        int i3 = (i2 ^ 35) + ((i2 & 35) << 1);
        f657 = i3 % 128;
        if (i3 % 2 == 0) {
        }
    }

    public static void e(String str, Throwable th) {
        boolean z = false;
        int i2 = ((f657 + 24) - 0) - 1;
        f656 = i2 % 128;
        if (i2 % 2 == 0) {
            z = true;
        }
        if (!z) {
            Object obj = null;
            super.hashCode();
        }
    }

    public static void i(String str, String str2) {
        int i2 = f656;
        int i3 = (((i2 & -122) | ((~i2) & 121)) - (~((i2 & 121) << 1))) - 1;
        f657 = i3 % 128;
        if (i3 % 2 == 0) {
        }
    }

    public static void v(String str, String str2) {
        int i2 = f657;
        int i3 = i2 & 57;
        int i4 = (i2 ^ 57) | i3;
        int i5 = ((i3 | i4) << 1) - (i4 ^ i3);
        f656 = i5 % 128;
        int i6 = i5 % 2;
    }

    public static void w(String str, String str2) {
        int i2 = f657;
        int i3 = i2 ^ 117;
        int i4 = ((i2 & 117) | i3) << 1;
        int i5 = -i3;
        int i6 = ((i4 | i5) << 1) - (i4 ^ i5);
        f656 = i6 % 128;
        if (i6 % 2 != 0) {
        }
    }
}
