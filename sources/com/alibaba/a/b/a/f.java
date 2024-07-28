package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.alibaba.a.d.g;
import java.lang.reflect.Type;

public final class f implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final f f6190a = new f();

    public final int a() {
        return 4;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 8) {
            g2.d();
            return null;
        } else if (g2.a() == 4) {
            String l = g2.l();
            g2.a(16);
            return g.a(l);
        } else {
            throw new com.alibaba.a.d("expect className");
        }
    }
}
