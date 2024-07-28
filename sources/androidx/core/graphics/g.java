package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.b.c;
import androidx.core.e.b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class g extends e {

    /* renamed from: a  reason: collision with root package name */
    protected final Class<?> f3026a;

    /* renamed from: b  reason: collision with root package name */
    protected final Constructor<?> f3027b;

    /* renamed from: c  reason: collision with root package name */
    protected final Method f3028c;

    /* renamed from: d  reason: collision with root package name */
    protected final Method f3029d;

    /* renamed from: e  reason: collision with root package name */
    protected final Method f3030e;

    /* renamed from: f  reason: collision with root package name */
    protected final Method f3031f;

    /* renamed from: g  reason: collision with root package name */
    protected final Method f3032g;

    public g() {
        Method method;
        Method method2;
        Method method3;
        Constructor<?> constructor;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(new Class[0]);
            method3 = cls2.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
            method2 = cls2.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
            method = cls2.getMethod("freeze", new Class[0]);
            method4 = cls2.getMethod("abortCreation", new Class[0]);
            Class<?> cls3 = cls2;
            method5 = a(cls2);
            cls = cls3;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            new StringBuilder("Unable to collect necessary methods for class ").append(e2.getClass().getName());
            method5 = null;
            method4 = null;
            constructor = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f3026a = cls;
        this.f3027b = constructor;
        this.f3028c = method3;
        this.f3029d = method2;
        this.f3030e = method;
        this.f3031f = method4;
        this.f3032g = method5;
    }

    private boolean a() {
        return this.f3028c != null;
    }

    private Object b() {
        try {
            return this.f3027b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean a(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f3028c.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.f3029d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f3026a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f3032g.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean b(Object obj) {
        try {
            return ((Boolean) this.f3030e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void c(Object obj) {
        try {
            this.f3031f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        if (!a()) {
            return super.a(context, bVar, resources, i2);
        }
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (c.C0040c cVar : bVar.f2830a) {
            if (!a(context, b2, cVar.f2831a, cVar.f2835e, cVar.f2832b, cVar.f2833c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.f2834d))) {
                c(b2);
                return null;
            }
        }
        if (!b(b2)) {
            return null;
        }
        return a(b2);
    }

    public final Typeface a(Context context, b.C0041b[] bVarArr, int i2) {
        Typeface a2;
        ParcelFileDescriptor openFileDescriptor;
        if (bVarArr.length <= 0) {
            return null;
        }
        if (!a()) {
            b.C0041b a3 = a(bVarArr, i2);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(a3.f2888a, "r", (CancellationSignal) null);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a3.f2890c).setItalic(a3.f2891d).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            Map<Uri, ByteBuffer> a4 = b.a(context, bVarArr);
            Object b2 = b();
            if (b2 == null) {
                return null;
            }
            boolean z = false;
            for (b.C0041b bVar : bVarArr) {
                ByteBuffer byteBuffer = a4.get(bVar.f2888a);
                if (byteBuffer != null) {
                    if (!a(b2, byteBuffer, bVar.f2889b, bVar.f2890c, bVar.f2891d ? 1 : 0)) {
                        c(b2);
                        return null;
                    }
                    z = true;
                }
            }
            if (!z) {
                c(b2);
                return null;
            } else if (b(b2) && (a2 = a(b2)) != null) {
                return Typeface.create(a2, i2);
            } else {
                return null;
            }
        }
        throw th;
    }

    public final Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        if (!a()) {
            return super.a(context, resources, i2, str, i3);
        }
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        if (!a(context, b2, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            c(b2);
            return null;
        } else if (!b(b2)) {
            return null;
        } else {
            return a(b2);
        }
    }

    /* access modifiers changed from: protected */
    public Method a(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
