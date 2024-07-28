package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

public final class i implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static final i f6322a = new i();

    public final int a() {
        return 2;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ahVar.c(((Calendar) obj).getTime());
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        T a2 = com.alibaba.a.b.a.i.f6193a.a(bVar, type, obj);
        if (a2 instanceof Calendar) {
            return a2;
        }
        Date date = (Date) a2;
        if (date == null) {
            return null;
        }
        T instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }
}
