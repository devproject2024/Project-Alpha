package com.google.android.gms.b;

import android.os.IBinder;
import com.google.android.gms.b.b;
import java.lang.reflect.Field;

public final class d<T> extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private final T f8278a;

    private d(T t) {
        this.f8278a = t;
    }

    public static <T> b a(T t) {
        return new d(t);
    }

    public static <T> T a(b bVar) {
        if (bVar instanceof d) {
            return ((d) bVar).f8278a;
        }
        IBinder asBinder = bVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i2 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
        }
        if (i2 != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        } else if (!field.isAccessible()) {
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (NullPointerException e2) {
                throw new IllegalArgumentException("Binder object is null.", e2);
            } catch (IllegalAccessException e3) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
            }
        } else {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
    }
}
