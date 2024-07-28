package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class aa implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static aa f6260a = new aa();

    public final int a() {
        return 4;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        if (obj == null) {
            ahVar.f6266a.write("null");
        } else {
            ahVar.a(((InetAddress) obj).getHostAddress());
        }
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        String str = (String) bVar.a((Object) null);
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return InetAddress.getByName(str);
        } catch (UnknownHostException e2) {
            throw new d("deserialize error", e2);
        }
    }
}
