package androidx.databinding.a;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> f3260a = new SparseArray<>();

    public static <T> T a(View view, T t, int i2) {
        WeakReference weakReference;
        if (Build.VERSION.SDK_INT >= 14) {
            T tag = view.getTag(i2);
            view.setTag(i2, t);
            return tag;
        }
        synchronized (f3260a) {
            WeakHashMap weakHashMap = f3260a.get(i2);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap();
                f3260a.put(i2, weakHashMap);
            }
            if (t == null) {
                weakReference = (WeakReference) weakHashMap.remove(view);
            } else {
                weakReference = (WeakReference) weakHashMap.put(view, new WeakReference(t));
            }
            if (weakReference == null) {
                return null;
            }
            T t2 = weakReference.get();
            return t2;
        }
    }
}
