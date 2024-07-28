package com.paytm.utility;

import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class v {
    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    private static String a(int i2, char c2) throws IndexOutOfBoundsException {
        if (i2 >= 0) {
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < cArr.length; i3++) {
                cArr[i3] = c2;
            }
            return new String(cArr);
        }
        throw new IndexOutOfBoundsException("Cannot pad a negative amount: ".concat(String.valueOf(i2)));
    }

    public static String a(String str, int i2, char c2) {
        if (str == null) {
            return null;
        }
        int length = i2 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return a(str, i2, String.valueOf(c2));
        }
        return a(length, c2).concat(str);
    }

    private static String a(String str, int i2, String str2) {
        if (str == null) {
            return null;
        }
        if (a(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i2 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return a(str, i2, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i3 = 0; i3 < length2; i3++) {
            cArr[i3] = charArray[i3 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String append : strArr) {
            sb.append(append);
        }
        return sb.toString();
    }

    public static String b(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return "";
        }
        String[] split = str.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (str2.length() > 1) {
                sb.append(str2.substring(0, 1).toUpperCase());
                sb.append(str2.substring(1) + " ");
            } else {
                sb.append(str2 + " ");
            }
        }
        return sb.toString();
    }

    public static String c(String str) {
        char[] charArray = str != null ? str.toCharArray() : null;
        if (charArray == null || charArray.length <= 0) {
            return "";
        }
        int i2 = 25;
        if (25 > charArray.length) {
            i2 = charArray.length;
        }
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(charArray[i3]);
        }
        sb.append(AppConstants.DOTS);
        return sb.toString();
    }
}
