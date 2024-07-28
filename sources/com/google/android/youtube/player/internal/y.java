package com.google.android.youtube.player.internal;

import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;

public final class y {

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    private static IBinder a(Class<?> cls, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) throws a {
        try {
            return (IBinder) cls.getConstructor(new Class[]{IBinder.class, IBinder.class, IBinder.class, Boolean.TYPE}).newInstance(new Object[]{iBinder, iBinder2, iBinder3, Boolean.valueOf(z)});
        } catch (NoSuchMethodException e2) {
            String valueOf = String.valueOf(cls.getName());
            throw new a(valueOf.length() != 0 ? "Could not find the right constructor for ".concat(valueOf) : new String("Could not find the right constructor for "), e2);
        } catch (InvocationTargetException e3) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new a(valueOf2.length() != 0 ? "Exception thrown by invoked constructor in ".concat(valueOf2) : new String("Exception thrown by invoked constructor in "), e3);
        } catch (InstantiationException e4) {
            String valueOf3 = String.valueOf(cls.getName());
            throw new a(valueOf3.length() != 0 ? "Unable to instantiate the dynamic class ".concat(valueOf3) : new String("Unable to instantiate the dynamic class "), e4);
        } catch (IllegalAccessException e5) {
            String valueOf4 = String.valueOf(cls.getName());
            throw new a(valueOf4.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf4) : new String("Unable to call the default constructor of "), e5);
        }
    }

    static IBinder a(ClassLoader classLoader, String str, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) throws a {
        try {
            return a(classLoader.loadClass(str), iBinder, iBinder2, iBinder3, z);
        } catch (ClassNotFoundException e2) {
            String valueOf = String.valueOf(str);
            throw new a(valueOf.length() != 0 ? "Unable to find dynamic class ".concat(valueOf) : new String("Unable to find dynamic class "), e2);
        }
    }
}
