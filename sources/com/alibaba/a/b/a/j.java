package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.d;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public final class j extends a implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final j f6194a = new j();

    public final int a() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public final <T> T b(b bVar, Type type, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            return new SimpleDateFormat(str);
        }
        throw new d("parse error");
    }
}
