package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;

public final class bg implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final bg f6312a = new bg();

    public final int a() {
        return 4;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        if (obj == null) {
            ahVar.e();
        } else {
            ahVar.a(obj.toString());
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        String str = (String) bVar.a((Object) null);
        if (str == null) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new d("create url error", e2);
        }
    }
}
