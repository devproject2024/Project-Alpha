package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.b.f;
import com.alibaba.a.d;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public final class i extends a implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final i f6193a = new i();

    public final int a() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public final <T> T b(b bVar, Type type, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            f fVar = new f(str);
            try {
                if (fVar.b(false)) {
                    T y = fVar.y();
                    if (type == Calendar.class) {
                        return y;
                    }
                    T time = y.getTime();
                    fVar.close();
                    return time;
                }
                fVar.close();
                try {
                    return bVar.a().parse(str);
                } catch (ParseException unused) {
                    return new Date(Long.parseLong(str));
                }
            } finally {
                fVar.close();
            }
        } else {
            throw new d("parse error");
        }
    }
}
