package androidx.fragment.app;

import androidx.a.g;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final g<String, Class<?>> f3413a = new g<>();

    private static Class<?> d(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> cls = f3413a.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        f3413a.put(str, cls2);
        return cls2;
    }

    static boolean a(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(d(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<? extends Fragment> b(ClassLoader classLoader, String str) {
        try {
            return d(classLoader, str);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        } catch (ClassCastException e3) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e3);
        }
    }

    public Fragment c(ClassLoader classLoader, String str) {
        try {
            return (Fragment) b(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e2) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (IllegalAccessException e3) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }
}
