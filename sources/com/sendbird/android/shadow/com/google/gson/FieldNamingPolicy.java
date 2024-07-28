package com.sendbird.android.shadow.com.google.gson;

import com.business.merchant_payments.common.utility.AppUtility;
import java.lang.reflect.Field;
import java.util.Locale;

public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY {
        public final String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public final String translateName(Field field) {
            return upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public final String translateName(Field field) {
            return upperCaseFirstLetter(separateCamelCase(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public final String translateName(Field field) {
            return separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public final String translateName(Field field) {
            return separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS {
        public final String translateName(Field field) {
            return separateCamelCase(field.getName(), AppUtility.CENTER_DOT).toLowerCase(Locale.ENGLISH);
        }
    };

    static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String upperCaseFirstLetter(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i2 < length - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i2++;
            charAt = str.charAt(i2);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(modifyString(Character.toUpperCase(charAt), str, i2 + 1));
        return sb.toString();
    }

    private static String modifyString(char c2, String str, int i2) {
        if (i2 >= str.length()) {
            return String.valueOf(c2);
        }
        return c2 + str.substring(i2);
    }
}
