package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public final class l implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final l f6325a = new l();

    public final int a() {
        return 4;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        if (obj == null) {
            ahVar.f6266a.write("null");
        } else {
            ahVar.a(((Charset) obj).toString());
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        Object a2 = bVar.a((Object) null);
        if (a2 == null) {
            return null;
        }
        return Charset.forName((String) a2);
    }
}
