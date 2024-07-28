package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private static Field f1110a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1111b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f1112c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1113d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f1114e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f1115f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f1116g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f1117h;

    static void a(Resources resources) {
        if (Build.VERSION.SDK_INT < 28) {
            if (Build.VERSION.SDK_INT >= 24) {
                d(resources);
            } else if (Build.VERSION.SDK_INT >= 23) {
                c(resources);
            } else if (Build.VERSION.SDK_INT >= 21) {
                b(resources);
            }
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!f1111b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1110a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1111b = true;
        }
        Field field = f1110a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException unused2) {
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!f1111b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1110a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1111b = true;
        }
        Object obj = null;
        Field field = f1110a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException unused2) {
            }
        }
        if (obj != null) {
            a(obj);
        }
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f1117h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f1116g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1117h = true;
        }
        Field field = f1116g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException unused2) {
                obj = null;
            }
            if (obj != null) {
                if (!f1111b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f1110a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    f1111b = true;
                }
                Field field2 = f1110a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException unused4) {
                    }
                }
                if (obj2 != null) {
                    a(obj2);
                }
            }
        }
    }

    private static void a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f1113d) {
            try {
                f1112c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            f1113d = true;
        }
        Class<?> cls = f1112c;
        if (cls != null) {
            if (!f1115f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f1114e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused2) {
                }
                f1115f = true;
            }
            Field field = f1114e;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException unused3) {
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
