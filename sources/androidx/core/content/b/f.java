package androidx.core.content.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import androidx.core.content.b.c;
import androidx.core.graphics.d;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class f {
    public static Drawable a(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i2, theme);
        }
        return resources.getDrawable(i2);
    }

    public static int b(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColor(i2, theme);
        }
        return resources.getColor(i2);
    }

    public static abstract class a {
        public abstract void a(int i2);

        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public final void run() {
                    a.this.a(typeface);
                }
            });
        }

        public final void a(final int i2, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public final void run() {
                    a.this.a(i2);
                }
            });
        }
    }

    public static void a(Context context, int i2, a aVar) throws Resources.NotFoundException {
        androidx.core.g.f.a(aVar);
        if (context.isRestricted()) {
            aVar.a(-4, (Handler) null);
            return;
        }
        a(context, i2, new TypedValue(), 0, aVar, false);
    }

    public static Typeface a(Context context, int i2, TypedValue typedValue, int i3, a aVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i2, typedValue, i3, aVar, true);
    }

    public static Typeface a(Context context, int i2, TypedValue typedValue, int i3, a aVar, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i2, i3, aVar, z);
        if (a2 != null || aVar != null) {
            return a2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    private static Typeface a(Context context, Resources resources, TypedValue typedValue, int i2, int i3, a aVar, boolean z) {
        Resources resources2 = resources;
        TypedValue typedValue2 = typedValue;
        int i4 = i2;
        int i5 = i3;
        a aVar2 = aVar;
        if (typedValue2.string != null) {
            String charSequence = typedValue2.string.toString();
            if (!charSequence.startsWith("res/")) {
                if (aVar2 != null) {
                    aVar.a(-3, (Handler) null);
                }
                return null;
            }
            Typeface a2 = d.a(resources, i2, i3);
            if (a2 != null) {
                if (aVar2 != null) {
                    aVar.a(a2, (Handler) null);
                }
                return a2;
            }
            try {
                if (charSequence.toLowerCase().endsWith(".xml")) {
                    c.a a3 = c.a((XmlPullParser) resources.getXml(i2), resources);
                    if (a3 != null) {
                        return d.a(context, a3, resources, i2, i3, aVar, z);
                    }
                    if (aVar2 != null) {
                        aVar.a(-3, (Handler) null);
                    }
                    return null;
                }
                Context context2 = context;
                Typeface a4 = d.a(context, resources, i2, charSequence, i3);
                if (aVar2 != null) {
                    if (a4 != null) {
                        aVar.a(a4, (Handler) null);
                    } else {
                        aVar.a(-3, (Handler) null);
                    }
                }
                return a4;
            } catch (IOException | XmlPullParserException unused) {
                if (aVar2 != null) {
                    aVar.a(-3, (Handler) null);
                }
                return null;
            }
        } else {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i2) + "\" (" + Integer.toHexString(i2) + ") is not a Font: " + typedValue);
        }
    }

    public static final class b {

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f2846a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f2847b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f2848c;

            /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|10) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static void a(android.content.res.Resources.Theme r6) {
                /*
                    java.lang.Object r0 = f2846a
                    monitor-enter(r0)
                    boolean r1 = f2848c     // Catch:{ all -> 0x002b }
                    r2 = 0
                    if (r1 != 0) goto L_0x001a
                    r1 = 1
                    java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                    java.lang.String r4 = "rebase"
                    java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0018 }
                    java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x0018 }
                    f2847b = r3     // Catch:{ NoSuchMethodException -> 0x0018 }
                    r3.setAccessible(r1)     // Catch:{ NoSuchMethodException -> 0x0018 }
                L_0x0018:
                    f2848c = r1     // Catch:{ all -> 0x002b }
                L_0x001a:
                    java.lang.reflect.Method r1 = f2847b     // Catch:{ all -> 0x002b }
                    if (r1 == 0) goto L_0x0029
                    java.lang.reflect.Method r1 = f2847b     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0026 }
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0026 }
                    r1.invoke(r6, r2)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0026 }
                    goto L_0x0029
                L_0x0026:
                    r6 = 0
                    f2847b = r6     // Catch:{ all -> 0x002b }
                L_0x0029:
                    monitor-exit(r0)     // Catch:{ all -> 0x002b }
                    return
                L_0x002b:
                    r6 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x002b }
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.b.f.b.a.a(android.content.res.Resources$Theme):void");
            }
        }
    }
}
