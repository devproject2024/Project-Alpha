package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;

public final class b {
    public static <T> boolean a(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (q.a(tArr[i2], t)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            return true;
        }
        return false;
    }

    public static <T> void a(StringBuilder sb, T[] tArr) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(AppConstants.COMMA);
            }
            sb.append(tArr[i2].toString());
        }
    }

    public static void a(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(AppConstants.COMMA);
            }
            sb.append(Integer.toString(iArr[i2]));
        }
    }

    public static void a(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(AppConstants.COMMA);
            }
            sb.append(Long.toString(jArr[i2]));
        }
    }

    public static void a(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(AppConstants.COMMA);
            }
            sb.append(Float.toString(fArr[i2]));
        }
    }

    public static void a(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(AppConstants.COMMA);
            }
            sb.append(Double.toString(dArr[i2]));
        }
    }

    public static void a(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(AppConstants.COMMA);
            }
            sb.append(Boolean.toString(zArr[i2]));
        }
    }

    public static void a(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(AppConstants.COMMA);
            }
            sb.append("\"");
            sb.append(strArr[i2]);
            sb.append("\"");
        }
    }

    public static <T> T[] a(T[]... tArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            i2 += tArr[i3].length;
        }
        T[] copyOf = Arrays.copyOf(tArr[0], i2);
        int length = tArr[0].length;
        for (int i4 = 1; i4 < 2; i4++) {
            T[] tArr2 = tArr[1];
            System.arraycopy(tArr2, 0, copyOf, length, tArr2.length);
        }
        return copyOf;
    }
}
