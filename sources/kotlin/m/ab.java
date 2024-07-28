package kotlin.m;

import kotlin.g.b.k;
import kotlin.j.e;

public class ab extends aa {
    public static final String g(String str) {
        k.d(str, "$this$dropLast");
        return p.a(str, e.b(str.length() - 1, 0));
    }

    public static final String a(String str, int i2) {
        k.d(str, "$this$take");
        if (i2 >= 0) {
            String substring = str.substring(0, e.c(i2, str.length()));
            k.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final String h(String str) {
        k.d(str, "$this$takeLast");
        int length = str.length();
        String substring = str.substring(length - e.c(4, length));
        k.b(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final CharSequence h(CharSequence charSequence) {
        k.d(charSequence, "$this$reversed");
        StringBuilder reverse = new StringBuilder(charSequence).reverse();
        k.b(reverse, "StringBuilder(this).reverse()");
        return reverse;
    }
}
