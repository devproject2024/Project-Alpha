package com.business.merchant_payments.utility;

import android.content.Context;
import android.text.TextUtils;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.common.utility.AppUtility;

public class StringUtility {
    public static final String EMPTY = "";
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";

    public static String toCapWords(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = str.trim().split(" ");
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].trim().length() > 0) {
                sb.append(Character.toUpperCase(split[i2].trim().charAt(0)));
                sb.append(split[i2].trim().substring(1));
                if (i2 < split.length - 1) {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public static String formatNumber(Context context, String str, String str2) {
        try {
            return AppUtility.formatNumber(String.valueOf(Double.parseDouble(str) / 100.0d), str2);
        } catch (Exception e2) {
            LogUtility.d(context.getClass().getName(), e2.getMessage());
            return "";
        }
    }
}
