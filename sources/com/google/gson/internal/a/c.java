package com.google.gson.internal.a;

import com.google.gson.m;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private static Class f39487a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f39488b = b();

    /* renamed from: c  reason: collision with root package name */
    private final Field f39489c = c();

    c() {
    }

    public final void a(AccessibleObject accessibleObject) {
        if (!b(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e2) {
                throw new m("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
            }
        }
    }

    private boolean b(AccessibleObject accessibleObject) {
        if (!(this.f39488b == null || this.f39489c == null)) {
            try {
                long longValue = ((Long) f39487a.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(this.f39488b, new Object[]{this.f39489c})).longValue();
                f39487a.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE}).invoke(this.f39488b, new Object[]{accessibleObject, Long.valueOf(longValue), Boolean.TRUE});
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Object b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f39487a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
