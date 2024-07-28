package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.d.g;
import java.io.IOException;
import java.lang.reflect.Type;

public final class k implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final k f6324a = new k();

    public final int a() {
        return 4;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        Character ch = (Character) obj;
        if (ch == null) {
            baVar.b("");
        } else if (ch.charValue() == 0) {
            baVar.b("\u0000");
        } else {
            baVar.b(ch.toString());
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        Object a2 = bVar.a((Object) null);
        if (a2 == null) {
            return null;
        }
        return g.c(a2);
    }
}
