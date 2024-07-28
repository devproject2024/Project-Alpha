package com.google.android.gms.internal.firebase_ml;

import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ap {
    @NonNullDecl
    public static <T> T a(@NonNullDecl T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static int a(int i2, int i3) {
        String str;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            str = aq.a("%s (%s) must not be negative", H5StartParamManager.index, Integer.valueOf(i2));
        } else if (i3 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        } else {
            str = aq.a("%s (%s) must be less than size (%s)", H5StartParamManager.index, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int b(int i2, int i3) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(a(i2, i3, H5StartParamManager.index));
    }

    private static String a(int i2, int i3, @NullableDecl String str) {
        if (i2 < 0) {
            return aq.a("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return aq.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void a(int i2, int i3, int i4) {
        String str;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 < 0 || i2 > i4) {
                str = a(i2, i4, "start index");
            } else if (i3 < 0 || i3 > i4) {
                str = a(i3, i4, "end index");
            } else {
                str = aq.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }
}
