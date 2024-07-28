package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.core.content.b.c;
import androidx.core.e.b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class j {

    /* renamed from: h  reason: collision with root package name */
    ConcurrentHashMap<Long, c.b> f3033h = new ConcurrentHashMap<>();

    interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    j() {
    }

    private static <T> T a(T[] tArr, int i2, a<T> aVar) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.b(t2) - i3) * 2) + (aVar.a(t2) == z ? 0 : 1);
            if (t == null || i4 > abs) {
                t = t2;
                i4 = abs;
            }
        }
        return t;
    }

    static long a(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public b.C0041b a(b.C0041b[] bVarArr, int i2) {
        return (b.C0041b) a((T[]) bVarArr, i2, new a<b.C0041b>() {
            public final /* bridge */ /* synthetic */ boolean a(Object obj) {
                return ((b.C0041b) obj).f2891d;
            }

            public final /* bridge */ /* synthetic */ int b(Object obj) {
                return ((b.C0041b) obj).f2890c;
            }
        });
    }

    /* access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!k.a(a2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, b.C0041b[] bVarArr, int i2) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length <= 0) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(bVarArr, i2).f2888a);
            try {
                Typeface a2 = a(context, inputStream);
                k.a((Closeable) inputStream);
                return a2;
            } catch (IOException unused) {
                k.a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                k.a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            k.a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            k.a((Closeable) inputStream2);
            throw th;
        }
    }

    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!k.a(a2, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        c.C0040c cVar = (c.C0040c) a((T[]) bVar.f2830a, i2, new a<c.C0040c>() {
            public final /* bridge */ /* synthetic */ boolean a(Object obj) {
                return ((c.C0040c) obj).f2833c;
            }

            public final /* bridge */ /* synthetic */ int b(Object obj) {
                return ((c.C0040c) obj).f2832b;
            }
        });
        if (cVar == null) {
            return null;
        }
        Typeface a2 = d.a(context, resources, cVar.f2836f, cVar.f2831a, i2);
        long a3 = a(a2);
        if (a3 != 0) {
            this.f3033h.put(Long.valueOf(a3), bVar);
        }
        return a2;
    }
}
