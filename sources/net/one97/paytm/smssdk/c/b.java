package net.one97.paytm.smssdk.c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f65074a = new b();

    private b() {
    }

    public static boolean a(String str, String str2) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        k.c(str2, "regex");
        String lowerCase = str2.toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        Pattern compile = Pattern.compile(lowerCase);
        String lowerCase2 = str.toLowerCase();
        k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
        Matcher matcher = compile.matcher(lowerCase2);
        Boolean valueOf = matcher != null ? Boolean.valueOf(matcher.find()) : null;
        if (valueOf == null) {
            k.a();
        }
        return valueOf.booleanValue();
    }
}
