package org.apache.xml.security.utils;

public final class ClassLoaderUtils {

    /* renamed from: a  reason: collision with root package name */
    static Class f72758a;

    private ClassLoaderUtils() {
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public static Class a(String str, Class cls) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader.loadClass(str);
            }
        } catch (ClassNotFoundException unused) {
        }
        return b(str, cls);
    }

    private static Class b(String str, Class cls) {
        Class cls2;
        Class cls3;
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            try {
                if (f72758a == null) {
                    cls2 = a("org.apache.xml.security.utils.ClassLoaderUtils");
                    f72758a = cls2;
                } else {
                    cls2 = f72758a;
                }
                if (cls2.getClassLoader() != null) {
                    if (f72758a == null) {
                        cls3 = a("org.apache.xml.security.utils.ClassLoaderUtils");
                        f72758a = cls3;
                    } else {
                        cls3 = f72758a;
                    }
                    return cls3.getClassLoader().loadClass(str);
                }
            } catch (ClassNotFoundException unused) {
                if (!(cls == null || cls.getClassLoader() == null)) {
                    return cls.getClassLoader().loadClass(str);
                }
            }
            throw e2;
        }
    }
}
