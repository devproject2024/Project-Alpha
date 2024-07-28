package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.a.g;
import androidx.core.content.b.c;
import androidx.core.e.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

final class f extends j {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f3022a;

    /* renamed from: b  reason: collision with root package name */
    private static final Constructor<?> f3023b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f3024c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f3025d;

    f() {
    }

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            e2.getClass().getName();
            cls = null;
            method2 = null;
            method = null;
        }
        f3023b = constructor;
        f3022a = cls;
        f3024c = method;
        f3025d = method2;
    }

    public static boolean a() {
        return f3024c != null;
    }

    private static Object b() {
        try {
            return f3023b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f3024c.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f3022a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f3025d.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final Typeface a(Context context, b.C0041b[] bVarArr, int i2) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        g gVar = new g();
        for (b.C0041b bVar : bVarArr) {
            Uri uri = bVar.f2888a;
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(uri);
            if (byteBuffer == null) {
                byteBuffer = k.a(context, uri);
                gVar.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !a(b2, byteBuffer, bVar.f2889b, bVar.f2890c, bVar.f2891d)) {
                return null;
            }
        }
        Typeface a2 = a(b2);
        if (a2 == null) {
            return null;
        }
        return Typeface.create(a2, i2);
    }

    public final Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (c.C0040c cVar : bVar.f2830a) {
            ByteBuffer a2 = k.a(context, resources, cVar.f2836f);
            if (a2 == null || !a(b2, a2, cVar.f2835e, cVar.f2832b, cVar.f2833c)) {
                return null;
            }
        }
        return a(b2);
    }
}
