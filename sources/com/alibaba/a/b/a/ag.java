package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.d;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public final class ag extends a implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final ag f6184a = new ag();

    public final int a() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public final <T> T b(b bVar, Type type, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        if (obj instanceof Number) {
            return new Timestamp(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            try {
                return new Timestamp(bVar.a().parse(str).getTime());
            } catch (ParseException unused) {
                return new Timestamp(Long.parseLong(str));
            }
        } else {
            throw new d("parse error");
        }
    }
}
