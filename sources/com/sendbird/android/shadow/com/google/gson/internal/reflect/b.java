package com.sendbird.android.shadow.com.google.gson.internal.reflect;

import com.sendbird.android.shadow.com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

final class b extends ReflectionAccessor {

    /* renamed from: a  reason: collision with root package name */
    private static Class f44986a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f44987b = a();

    /* renamed from: c  reason: collision with root package name */
    private final Field f44988c = b();

    b() {
    }

    public final void makeAccessible(AccessibleObject accessibleObject) {
        if (!a(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e2) {
                throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
            }
        }
    }

    private boolean a(AccessibleObject accessibleObject) {
        if (!(this.f44987b == null || this.f44988c == null)) {
            try {
                long longValue = ((Long) f44986a.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(this.f44987b, new Object[]{this.f44988c})).longValue();
                f44986a.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE}).invoke(this.f44987b, new Object[]{accessibleObject, Long.valueOf(longValue), Boolean.TRUE});
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Object a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f44986a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
