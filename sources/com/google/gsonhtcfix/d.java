package com.google.gsonhtcfix;

import java.lang.reflect.Field;

public enum d implements e {
    IDENTITY {
        public final String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public final String translateName(Field field) {
            return d.upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public final String translateName(Field field) {
            return d.upperCaseFirstLetter(d.separateCamelCase(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public final String translateName(Field field) {
            return d.separateCamelCase(field.getName(), "_").toLowerCase();
        }
    },
    LOWER_CASE_WITH_DASHES {
        public final String translateName(Field field) {
            return d.separateCamelCase(field.getName(), "-").toLowerCase();
        }
    };

    /* access modifiers changed from: private */
    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static String upperCaseFirstLetter(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char charAt = str.charAt(0);
        while (i2 < str.length() - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i2++;
            charAt = str.charAt(i2);
        }
        if (i2 == str.length()) {
            return sb.toString();
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
