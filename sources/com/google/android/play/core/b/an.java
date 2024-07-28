package com.google.android.play.core.b;

import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class an {
    public static <T> am<T> a(Object obj, String str, Class<T> cls) {
        return new am<>(obj, b(obj, str), cls);
    }

    public static <R, P0> R a(Class cls, String str, Class<R> cls2, Class<P0> cls3, P0 p0) {
        try {
            return cls2.cast(a((Class<?>) cls, str, (Class<?>[]) new Class[]{cls3}).invoke((Object) null, new Object[]{p0}));
        } catch (Exception e2) {
            throw new ao(String.format("Failed to invoke static method %s on type %s", new Object[]{str, cls}), e2);
        }
    }

    public static <R, P0, P1> R a(Class cls, String str, Class<R> cls2, Class<P0> cls3, P0 p0, Class<P1> cls4, P1 p1) {
        try {
            return cls2.cast(a((Class<?>) cls, str, (Class<?>[]) new Class[]{cls3, cls4}).invoke((Object) null, new Object[]{p0, p1}));
        } catch (Exception e2) {
            throw new ao(String.format("Failed to invoke static method %s on type %s", new Object[]{str, cls}), e2);
        }
    }

    public static <R, P0> R a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0) {
        try {
            return cls.cast(a(obj, str, (Class<?>[]) new Class[]{cls2}).invoke(obj, new Object[]{p0}));
        } catch (Exception e2) {
            throw new ao(String.format("Failed to invoke method %s on an object of type %s", new Object[]{str, obj.getClass()}), e2);
        }
    }

    public static <R, P0, P1, P2> R a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0, Class<P1> cls3, P1 p1, Class<P2> cls4, P2 p2) {
        try {
            return cls.cast(a(obj, str, (Class<?>[]) new Class[]{cls2, cls3, cls4}).invoke(obj, new Object[]{p0, p1, p2}));
        } catch (Exception e2) {
            throw new ao(String.format("Failed to invoke method %s on an object of type %s", new Object[]{str, obj.getClass()}), e2);
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Class<?> cls2 = cls;
        while (cls2 != null) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls2 = cls2.getSuperclass();
            }
        }
        throw new ao(String.format("Could not find a method named %s with parameters %s in type %s", new Object[]{str, Arrays.asList(clsArr), cls}));
    }

    private static Method a(Object obj, String str, Class<?>... clsArr) {
        return a(obj.getClass(), str, clsArr);
    }

    public static void a(PackageManager packageManager, ComponentName componentName) {
        ComponentInfo componentInfo;
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
        if (componentEnabledSetting != 1) {
            if (componentEnabledSetting != 2) {
                String packageName = componentName.getPackageName();
                String className = componentName.getClassName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 527);
                    ComponentInfo[][] componentInfoArr = {packageInfo.activities, packageInfo.services, packageInfo.providers};
                    int i2 = 0;
                    loop0:
                    while (true) {
                        if (i2 >= 3) {
                            componentInfo = null;
                            break;
                        }
                        ComponentInfo[] componentInfoArr2 = componentInfoArr[i2];
                        if (componentInfoArr2 != null) {
                            int length = componentInfoArr2.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                componentInfo = componentInfoArr2[i3];
                                if (componentInfo.name.equals(className)) {
                                    break loop0;
                                }
                            }
                            continue;
                        }
                        i2++;
                    }
                    if (componentInfo != null && componentInfo.isEnabled()) {
                        return;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    public static <T> void a(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
    }

    public static <T> am b(Object obj, String str, Class<T> cls) {
        return new am(obj, b(obj, str), cls, (byte) 0);
    }

    private static Field b(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new ao(String.format("Failed to find a field named %s on an object of instance %s", new Object[]{str, obj.getClass().getName()}));
    }
}
