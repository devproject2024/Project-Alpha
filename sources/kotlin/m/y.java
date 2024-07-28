package kotlin.m;

import com.paytm.contactsSdk.constant.ContactsConstant;
import java.util.Iterator;
import java.util.Locale;
import kotlin.a.ac;
import kotlin.g.b.k;
import kotlin.l.g;

public class y extends x {
    public static final boolean a(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static final String a(String str, char c2, char c3) {
        k.d(str, "$this$replace");
        String replace = str.replace(c2, c3);
        k.b(replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
        return replace;
    }

    public static final String a(String str, String str2, String str3, boolean z) {
        k.d(str, "$this$replace");
        k.d(str2, "oldValue");
        k.d(str3, "newValue");
        return g.a(p.a((CharSequence) str, new String[]{str2}, z, 4), (CharSequence) str3);
    }

    public static final String b(String str, String str2, String str3, boolean z) {
        k.d(str, "$this$replaceFirst");
        k.d(str2, "oldValue");
        k.d(str3, "newValue");
        CharSequence charSequence = str;
        int a2 = p.a(charSequence, str2, 0, z, 2);
        if (a2 < 0) {
            return str;
        }
        return p.a(charSequence, a2, str2.length() + a2, (CharSequence) str3).toString();
    }

    public static final boolean b(String str, String str2, boolean z) {
        k.d(str, "$this$startsWith");
        k.d(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return p.a(str, 0, str2, 0, str2.length(), z);
    }

    public static final boolean c(String str, String str2, boolean z) {
        k.d(str, "$this$endsWith");
        k.d(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return p.a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static final boolean a(CharSequence charSequence) {
        boolean z;
        k.d(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            Iterator it2 = p.c(charSequence).iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!a.a(charSequence.charAt(((ac) it2).a()))) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static final boolean a(String str, int i2, String str2, int i3, int i4, boolean z) {
        k.d(str, "$this$regionMatches");
        k.d(str2, "other");
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }

    public static final String f(String str) {
        k.d(str, "$this$capitalize");
        Locale locale = Locale.getDefault();
        k.b(locale, "Locale.getDefault()");
        k.d(str, "$this$capitalize");
        k.d(locale, ContactsConstant.LOCALE);
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    k.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        String upperCase = substring.toUpperCase(locale);
                        k.b(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                        sb.append(upperCase);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                String substring2 = str.substring(1);
                k.b(substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                k.b(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }
        return str;
    }
}
