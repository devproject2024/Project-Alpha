package com.sendbird.android.shadow.okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f45212a;

    /* renamed from: b  reason: collision with root package name */
    private final String f45213b;

    /* renamed from: c  reason: collision with root package name */
    private final Class[] f45214c;

    d(Class<?> cls, String str, Class... clsArr) {
        this.f45212a = cls;
        this.f45213b = str;
        this.f45214c = clsArr;
    }

    public final boolean a(T t) {
        return a(t.getClass()) != null;
    }

    private Object c(T t, Object... objArr) throws InvocationTargetException {
        Method a2 = a(t.getClass());
        if (a2 == null) {
            return null;
        }
        try {
            return a2.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public final Object a(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Object d(T t, Object... objArr) throws InvocationTargetException {
        Method a2 = a(t.getClass());
        if (a2 != null) {
            try {
                return a2.invoke(t, objArr);
            } catch (IllegalAccessException e2) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(a2)));
                assertionError.initCause(e2);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f45213b + " not supported for object " + t);
        }
    }

    public final Object b(T t, Object... objArr) {
        try {
            return d(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f45213b;
        if (str == null) {
            return null;
        }
        Method a2 = a(cls, str, this.f45214c);
        if (a2 == null || (cls2 = this.f45212a) == null || cls2.isAssignableFrom(a2.getReturnType())) {
            return a2;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) != 0) {
                    return method;
                }
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
        }
        return null;
    }
}
