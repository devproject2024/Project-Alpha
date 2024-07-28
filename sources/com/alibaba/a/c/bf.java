package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;

public final class bf implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final bf f6311a = new bf();

    public final int a() {
        return 4;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        if (obj == null) {
            ahVar.e();
        } else {
            ahVar.a(((URI) obj).toString());
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        String str = (String) bVar.a((Object) null);
        if (str == null) {
            return null;
        }
        return URI.create(str);
    }
}
