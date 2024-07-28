package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import androidx.a.e;
import androidx.core.content.b.c;
import androidx.core.content.b.f;
import androidx.core.e.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final j f2981a;

    /* renamed from: b  reason: collision with root package name */
    private static final e<String, Typeface> f2982b = new e<>(16);

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f2981a = new i();
        } else if (Build.VERSION.SDK_INT >= 28) {
            f2981a = new h();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f2981a = new g();
        } else if (Build.VERSION.SDK_INT >= 24 && f.a()) {
            f2981a = new f();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f2981a = new e();
        } else {
            f2981a = new j();
        }
    }

    public static Typeface a(Resources resources, int i2, int i3) {
        return f2982b.get(b(resources, i2, i3));
    }

    private static String b(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i2, int i3, f.a aVar2, boolean z) {
        Typeface typeface;
        int i4;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = !z ? aVar2 == null : dVar.f2839c == 0;
            if (z) {
                i4 = dVar.f2838b;
            } else {
                i4 = -1;
            }
            typeface = b.a(context, dVar.f2837a, aVar2, z2, i4, i3);
        } else {
            typeface = f2981a.a(context, (c.b) aVar, resources, i3);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.a(typeface, (Handler) null);
                } else {
                    aVar2.a(-3, (Handler) null);
                }
            }
        }
        if (typeface != null) {
            f2982b.put(b(resources, i2, i3), typeface);
        }
        return typeface;
    }

    public static Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        Typeface a2 = f2981a.a(context, resources, i2, str, i3);
        if (a2 != null) {
            f2982b.put(b(resources, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, b.C0041b[] bVarArr, int i2) {
        return f2981a.a(context, bVarArr, i2);
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        c.b bVar;
        if (context != null) {
            if (Build.VERSION.SDK_INT < 21) {
                j jVar = f2981a;
                long a2 = j.a(typeface);
                Typeface typeface2 = null;
                if (a2 == 0) {
                    bVar = null;
                } else {
                    bVar = jVar.f3033h.get(Long.valueOf(a2));
                }
                if (bVar != null) {
                    typeface2 = f2981a.a(context, bVar, context.getResources(), i2);
                }
                if (typeface2 != null) {
                    return typeface2;
                }
            }
            return Typeface.create(typeface, i2);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
