package com.alipay.mobile.nebula.webview;

public class Version {
    private static final int STORE_OFFSET = 16;

    public static int build(int i2, int i3) {
        return (i2 << 16) | i3;
    }

    public static int getMajor(int i2) {
        return i2 >> 16;
    }

    public static int getMinor(int i2) {
        return (i2 << 16) >> 16;
    }

    public static String toString(int i2) {
        return "Version(major: " + getMajor(i2) + ", minor: " + getMinor(i2) + ")";
    }

    public static class Major {
        public int compare(int i2, int i3) {
            int major = Version.getMajor(i2);
            int major2 = Version.getMajor(i3);
            if (major == major2) {
                return 0;
            }
            return major > major2 ? 1 : -1;
        }
    }

    public static class Minor {
        public int compare(int i2, int i3) {
            int minor = Version.getMinor(i2);
            int minor2 = Version.getMinor(i3);
            if (minor == minor2) {
                return 0;
            }
            return minor > minor2 ? 1 : -1;
        }
    }
}
