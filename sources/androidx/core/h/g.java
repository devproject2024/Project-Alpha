package androidx.core.h;

import android.os.Build;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static Field f3107a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3108b;

    private static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f3108b) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f3107a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                StringBuilder sb = new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ");
                sb.append(LayoutInflater.class.getName());
                sb.append("; inflation may have unexpected results.");
            }
            f3108b = true;
        }
        Field field = f3107a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException unused2) {
                StringBuilder sb2 = new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                sb2.append(layoutInflater);
                sb2.append("; inflation may have unexpected results.");
            }
        }
    }

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                b(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                b(layoutInflater, factory2);
            }
        }
    }
}
