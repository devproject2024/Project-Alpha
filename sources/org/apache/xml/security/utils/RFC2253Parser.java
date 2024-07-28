package org.apache.xml.security.utils;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.io.StringReader;

public class RFC2253Parser {

    /* renamed from: a  reason: collision with root package name */
    static boolean f72781a = true;

    /* renamed from: b  reason: collision with root package name */
    static int f72782b;

    private static int a(String str, int i2, int i3) {
        int i4 = 0;
        while (i2 < i3) {
            if (str.charAt(i2) == '\"') {
                i4++;
            }
            i2++;
        }
        return i4;
    }

    public static String a(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            String f2 = f(str);
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int indexOf = f2.indexOf(AppConstants.COMMA, i2);
                if (indexOf >= 0) {
                    i4 += a(f2, i2, indexOf);
                    if (!(indexOf <= 0 || f2.charAt(indexOf - 1) == '\\' || i4 % 2 == 1)) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(b(f2.substring(i3, indexOf).trim()));
                        stringBuffer2.append(AppConstants.COMMA);
                        stringBuffer.append(stringBuffer2.toString());
                        i3 = indexOf + 1;
                        i4 = 0;
                    }
                    i2 = indexOf + 1;
                } else {
                    stringBuffer.append(b(g(f2.substring(i3))));
                    return stringBuffer.toString();
                }
            }
        } catch (IOException unused) {
            return str;
        }
    }

    static String a(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i2);
            if (indexOf >= 0) {
                i4 += a(str, i2, indexOf);
                if (!(indexOf <= 0 || str.charAt(indexOf - 1) == '\\' || i4 % 2 == 1)) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(g(str.substring(i3, indexOf)));
                    stringBuffer2.append(str3);
                    stringBuffer.append(stringBuffer2.toString());
                    i3 = indexOf + 1;
                    i4 = 0;
                }
                i2 = indexOf + 1;
            } else {
                stringBuffer.append(g(str.substring(i3)));
                return stringBuffer.toString();
            }
        }
    }

    static String b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int indexOf = str.indexOf("+", i2);
            if (indexOf >= 0) {
                i4 += a(str, i2, indexOf);
                if (!(indexOf <= 0 || str.charAt(indexOf - 1) == '\\' || i4 % 2 == 1)) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(c(g(str.substring(i3, indexOf))));
                    stringBuffer2.append("+");
                    stringBuffer.append(stringBuffer2.toString());
                    i3 = indexOf + 1;
                    i4 = 0;
                }
                i2 = indexOf + 1;
            } else {
                stringBuffer.append(c(g(str.substring(i3))));
                return stringBuffer.toString();
            }
        }
    }

    static String c(String str) {
        int indexOf = str.indexOf("=");
        if (indexOf == -1) {
            return str;
        }
        if (indexOf > 0 && str.charAt(indexOf - 1) == '\\') {
            return str;
        }
        String d2 = d(str.substring(0, indexOf));
        String e2 = (d2.charAt(0) < '0' || d2.charAt(0) > '9') ? e(str.substring(indexOf + 1)) : str.substring(indexOf + 1);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d2);
        stringBuffer.append("=");
        stringBuffer.append(e2);
        return stringBuffer.toString();
    }

    static String d(String str) {
        String trim = str.toUpperCase().trim();
        return trim.startsWith("OID") ? trim.substring(3) : trim;
    }

    static String e(String str) {
        String g2 = g(str);
        if (g2.startsWith("\"")) {
            StringBuffer stringBuffer = new StringBuffer();
            StringReader stringReader = new StringReader(g2.substring(1, g2.length() - 1));
            while (true) {
                int read = stringReader.read();
                if (read < 0) {
                    break;
                }
                char c2 = (char) read;
                if (c2 == ',' || c2 == '=' || c2 == '+' || c2 == '<' || c2 == '>' || c2 == '#' || c2 == ';') {
                    stringBuffer.append('\\');
                }
                stringBuffer.append(c2);
            }
            g2 = g(stringBuffer.toString());
        }
        return f72781a ? g2.startsWith("#") ? "\\".concat(String.valueOf(g2)) : g2 : g2.startsWith("\\#") ? g2.substring(1) : g2;
    }

    static String f(String str) {
        return a(str, ";", AppConstants.COMMA);
    }

    static String g(String str) {
        String trim = str.trim();
        int indexOf = str.indexOf(trim) + trim.length();
        if (str.length() <= indexOf || !trim.endsWith("\\") || trim.endsWith("\\\\") || str.charAt(indexOf) != ' ') {
            return trim;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(trim);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }
}
