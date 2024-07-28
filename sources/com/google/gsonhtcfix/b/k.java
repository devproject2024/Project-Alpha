package com.google.gsonhtcfix.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class k {
    public abstract <T> T a(Class<T> cls) throws Exception;

    public static k a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get((Object) null);
            final Method method = cls.getMethod("allocateInstance", new Class[]{Class.class});
            return new k() {
                public final <T> T a(Class<T> cls) throws Exception {
                    return method.invoke(obj, new Object[]{cls});
                }
            };
        } catch (Exception unused) {
            try {
                final Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                declaredMethod.setAccessible(true);
                return new k() {
                    public final <T> T a(Class<T> cls) throws Exception {
                        return declaredMethod.invoke((Object) null, new Object[]{cls, Object.class});
                    }
                };
            } catch (Exception unused2) {
                try {
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                    declaredMethod2.setAccessible(true);
                    final int intValue = ((Integer) declaredMethod2.invoke((Object) null, new Object[]{Object.class})).intValue();
                    final Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                    declaredMethod3.setAccessible(true);
                    return new k() {
                        public final <T> T a(Class<T> cls) throws Exception {
                            return declaredMethod3.invoke((Object) null, new Object[]{cls, Integer.valueOf(intValue)});
                        }
                    };
                } catch (Exception unused3) {
                    return new k() {
                        public final <T> T a(Class<T> cls) {
                            throw new UnsupportedOperationException("Cannot allocate ".concat(String.valueOf(cls)));
                        }
                    };
                }
            }
        }
    }
}
