package androidx.core.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class h extends g {
    /* access modifiers changed from: protected */
    public final Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f3026a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f3032g.invoke((Object) null, new Object[]{newInstance, "sans-serif", -1, -1});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public final Method a(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
