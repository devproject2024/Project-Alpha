package org.parceler;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public final class b {

    /* renamed from: org.parceler.b$b  reason: collision with other inner class name */
    public static final class C0602b<T> {
    }

    public static <T> T a(Class<?> cls, Object obj, String str) {
        try {
            return AccessController.doPrivileged(new c(cls.getDeclaredField(str), obj, (byte) 0));
        } catch (NoSuchFieldException e2) {
            throw new f("NoSuchFieldException Exception during field injection: " + str + " in " + obj.getClass(), (Exception) e2);
        } catch (PrivilegedActionException e3) {
            throw new f("PrivilegedActionException Exception during field injection", (Exception) e3);
        } catch (Exception e4) {
            throw new f("Exception during field injection", e4);
        }
    }

    static final class c<T> extends a<T, Field> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f35794a;

        /* synthetic */ c(Field field, Object obj, byte b2) {
            this(field, obj);
        }

        public final /* synthetic */ Object a(AccessibleObject accessibleObject) throws Exception {
            return ((Field) accessibleObject).get(this.f35794a);
        }

        private c(Field field, Object obj) {
            super(field);
            this.f35794a = obj;
        }
    }

    public static void a(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            AccessController.doPrivileged(new d(cls.getDeclaredField(str), obj, obj2, (byte) 0));
        } catch (NoSuchFieldException e2) {
            throw new f("NoSuchFieldException Exception during field injection: " + str + " in " + obj.getClass(), (Exception) e2);
        } catch (PrivilegedActionException e3) {
            throw new f("PrivilegedActionException Exception during field injection", (Exception) e3);
        } catch (Exception e4) {
            throw new f("Exception during field injection", e4);
        }
    }

    static final class d extends a<Void, Field> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f35795a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f35796b;

        /* synthetic */ d(Field field, Object obj, Object obj2, byte b2) {
            this(field, obj, obj2);
        }

        public final /* synthetic */ Object a(AccessibleObject accessibleObject) throws Exception {
            ((Field) accessibleObject).set(this.f35795a, this.f35796b);
            return null;
        }

        private d(Field field, Object obj, Object obj2) {
            super(field);
            this.f35795a = obj;
            this.f35796b = obj2;
        }
    }

    static abstract class a<T, E extends AccessibleObject> implements PrivilegedExceptionAction<T> {

        /* renamed from: a  reason: collision with root package name */
        private final E f35793a;

        public abstract T a(E e2) throws Exception;

        protected a(E e2) {
            this.f35793a = e2;
        }

        public T run() throws Exception {
            boolean isAccessible = this.f35793a.isAccessible();
            this.f35793a.setAccessible(true);
            T a2 = a(this.f35793a);
            this.f35793a.setAccessible(isAccessible);
            return a2;
        }
    }
}
