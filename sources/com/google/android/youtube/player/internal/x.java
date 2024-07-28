package com.google.android.youtube.player.internal;

import android.os.IBinder;
import com.google.android.youtube.player.internal.w;
import java.lang.reflect.Field;

public final class x<T> extends w.a {

    /* renamed from: a  reason: collision with root package name */
    private final T f37614a;

    private x(T t) {
        this.f37614a = t;
    }

    public static <T> w a(T t) {
        return new x(t);
    }

    public static <T> T a(w wVar) {
        if (wVar instanceof x) {
            return ((x) wVar).f37614a;
        }
        IBinder asBinder = wVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e2) {
                    throw new IllegalArgumentException("Binder object is null.", e2);
                } catch (IllegalArgumentException e3) {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", e3);
                } catch (IllegalAccessException e4) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e4);
                }
            } else {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
        } else {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
    }
}
