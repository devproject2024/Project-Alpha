package com.alipay.imobile.network.quake.g;

import com.alipay.mobile.framework.b.a.b;
import java.lang.reflect.Method;

final class f {
    static String a(Method method) throws IllegalStateException {
        b bVar = (b) method.getAnnotation(b.class);
        if (bVar != null) {
            return bVar.a();
        }
        throw new IllegalStateException("OperationType must be set.");
    }
}
