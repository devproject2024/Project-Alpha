package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.regex.Pattern;

public final class au implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final au f6294a = new au();

    public final int a() {
        return 4;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        if (obj == null) {
            ahVar.e();
        } else {
            ahVar.a(((Pattern) obj).pattern());
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        Object a2 = bVar.a((Object) null);
        if (a2 == null) {
            return null;
        }
        return Pattern.compile((String) a2);
    }
}
