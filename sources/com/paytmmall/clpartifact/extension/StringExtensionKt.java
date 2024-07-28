package com.paytmmall.clpartifact.extension;

import android.text.TextUtils;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;

public final class StringExtensionKt {
    public static final boolean isEmptyOrNull(String str) {
        if (str == null) {
            return true;
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            int length = charSequence.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            }
            if (!(charSequence.subSequence(i2, length + 1).toString().length() == 0)) {
                int length2 = charSequence.length() - 1;
                int i3 = 0;
                boolean z3 = false;
                while (i3 <= length2) {
                    boolean z4 = charSequence.charAt(!z3 ? i3 : length2) <= ' ';
                    if (z3) {
                        if (!z4) {
                            break;
                        }
                        length2--;
                    } else if (!z4) {
                        z3 = true;
                    } else {
                        i3++;
                    }
                }
                if (p.a(charSequence.subSequence(i3, length2 + 1).toString(), "null", true)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public static final String getCleanedPhoneNumber(String str) {
        k.c(str, "receiver$0");
        l lVar = new l("^\\+91");
        String replace = new l("\\D").replace((CharSequence) lVar.replaceFirst(str, ""), "");
        if (replace.length() <= 10) {
            return replace;
        }
        int length = replace.length() - 10;
        if (replace != null) {
            String substring = replace.substring(length);
            k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public static final boolean isValidPhoneNumber(String str) {
        k.c(str, "receiver$0");
        return getCleanedPhoneNumber(str).length() == 10;
    }
}
