package com.alibaba.a.b.a;

import com.alibaba.a.a;
import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import java.lang.reflect.Type;

public final class e implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final e f6189a = new e();

    public final int a() {
        return 4;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 4) {
            String l = g2.l();
            g2.a(16);
            return l.toCharArray();
        } else if (g2.a() == 2) {
            Number j = g2.j();
            g2.a(16);
            return j.toString().toCharArray();
        } else {
            Object a2 = bVar.a((Object) null);
            if (a2 == null) {
                return null;
            }
            return a.toJSONString(a2).toCharArray();
        }
    }
}
