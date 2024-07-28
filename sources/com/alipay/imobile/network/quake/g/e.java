package com.alipay.imobile.network.quake.g;

import com.alipay.imobile.network.quake.e;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class e extends com.alipay.imobile.network.quake.e {
    Method w = null;
    String x = null;
    public boolean y = false;

    public e(String str, e.c cVar, e.b bVar) {
        super(str, cVar, bVar);
    }

    public final String a() {
        return this.x;
    }

    public final Type c() {
        Method method = this.w;
        return method == null ? Void.TYPE : method.getGenericReturnType();
    }
}
