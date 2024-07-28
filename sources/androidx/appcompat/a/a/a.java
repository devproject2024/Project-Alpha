package androidx.appcompat.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.u;
import androidx.core.content.b;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f986a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0020a>> f987b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f988c = new Object();

    public static ColorStateList a(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList d2 = d(context, i2);
        if (d2 != null) {
            return d2;
        }
        ColorStateList c2 = c(context, i2);
        if (c2 == null) {
            return b.b(context, i2);
        }
        synchronized (f988c) {
            SparseArray sparseArray = f987b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f987b.put(context, sparseArray);
            }
            sparseArray.append(i2, new C0020a(c2, context.getResources().getConfiguration()));
        }
        return c2;
    }

    public static Drawable b(Context context, int i2) {
        return u.a().a(context, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList d(android.content.Context r4, int r5) {
        /*
            java.lang.Object r0 = f988c
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<androidx.appcompat.a.a.a$a>> r1 = f987b     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0035 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ all -> 0x0035 }
            if (r2 <= 0) goto L_0x0032
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0035 }
            androidx.appcompat.a.a.a$a r2 = (androidx.appcompat.a.a.a.C0020a) r2     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0032
            android.content.res.Configuration r3 = r2.f990b     // Catch:{ all -> 0x0035 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0035 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0035 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x002f
            android.content.res.ColorStateList r4 = r2.f989a     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x002f:
            r1.remove(r5)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            r4 = 0
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.a.a.a.d(android.content.Context, int):android.content.res.ColorStateList");
    }

    /* renamed from: androidx.appcompat.a.a.a$a  reason: collision with other inner class name */
    static class C0020a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f989a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f990b;

        C0020a(ColorStateList colorStateList, Configuration configuration) {
            this.f989a = colorStateList;
            this.f990b = configuration;
        }
    }

    private static ColorStateList c(Context context, int i2) {
        Resources resources = context.getResources();
        TypedValue typedValue = f986a.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f986a.set(typedValue);
        }
        boolean z = true;
        resources.getValue(i2, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        }
        if (z) {
            return null;
        }
        Resources resources2 = context.getResources();
        try {
            return androidx.core.content.b.a.a(resources2, (XmlPullParser) resources2.getXml(i2), context.getTheme());
        } catch (Exception unused) {
            return null;
        }
    }
}
