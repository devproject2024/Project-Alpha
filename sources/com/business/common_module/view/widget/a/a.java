package com.business.common_module.view.widget.a;

import android.graphics.Typeface;
import java.util.HashMap;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7381a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, Typeface> f7382b = new HashMap<>();

    private a() {
    }

    public static Typeface a(Integer num) {
        int intValue = num != null ? num.intValue() * 100 : 400;
        String concat = "font_".concat(String.valueOf(intValue));
        if (!f7382b.containsKey(concat)) {
            Typeface create = Typeface.create(Typeface.DEFAULT, intValue, false);
            k.b(create, "Typeface.create(Typeface.DEFAULT, weight, false)");
            f7382b.put(concat, create);
            return create;
        }
        Typeface typeface = f7382b.get(concat);
        k.a((Object) typeface);
        return typeface;
    }
}
