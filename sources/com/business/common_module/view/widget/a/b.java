package com.business.common_module.view.widget.a;

import android.graphics.Typeface;
import java.util.HashMap;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f7383a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, Typeface> f7384b = new HashMap<>();

    private b() {
    }

    public static Typeface a(Integer num) {
        String str;
        String str2 = "sans-serif-light";
        int i2 = 0;
        if (num != null && num.intValue() == 1) {
            str2 = "sans-serif-thin";
        } else if ((num == null || num.intValue() != 2) && (num == null || num.intValue() != 3)) {
            if (num != null && num.intValue() == 5) {
                str2 = "sans-serif-medium";
            } else if ((num != null && num.intValue() == 7) || ((num != null && num.intValue() == 8) || (num != null && num.intValue() == 6))) {
                str2 = "sans-serif";
                i2 = 1;
            } else {
                str2 = (num != null && num.intValue() == 9) ? "sans-serif-black" : "sans-serif";
            }
        }
        if (i2 != 0) {
            str = str2 + "-bold";
        } else {
            str = str2;
        }
        if (!f7384b.containsKey(str)) {
            Typeface create = Typeface.create(str2, i2);
            k.b(create, "Typeface.create(familyNa…OLD else Typeface.NORMAL)");
            f7384b.put(str, create);
            return create;
        }
        Typeface typeface = f7384b.get(str);
        k.a((Object) typeface);
        return typeface;
    }
}
