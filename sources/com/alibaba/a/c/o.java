package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Currency;

public final class o implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final o f6328a = new o();

    public final int a() {
        return 4;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj == null) {
            baVar.write("null");
        } else {
            baVar.b(((Currency) obj).getCurrencyCode());
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        String str = (String) bVar.a((Object) null);
        if (str == null || str.length() == 0) {
            return null;
        }
        return Currency.getInstance(str);
    }
}
