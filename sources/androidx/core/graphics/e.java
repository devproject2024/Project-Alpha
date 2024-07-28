package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.core.content.b.c;
import androidx.core.e.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class e extends j {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f3017a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Constructor<?> f3018b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Method f3019c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f3020d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f3021e = false;

    e() {
    }

    private static void a() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f3021e) {
            f3021e = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                e2.getClass().getName();
                method2 = null;
                cls = null;
                method = null;
            }
            f3018b = constructor;
            f3017a = cls;
            f3019c = method;
            f3020d = method2;
        }
    }

    private static File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static Object b() {
        a();
        try {
            return f3018b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface a(Object obj) {
        a();
        try {
            Object newInstance = Array.newInstance(f3017a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f3020d.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a(Object obj, String str, int i2, boolean z) {
        a();
        try {
            return ((Boolean) f3019c.invoke(obj, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Typeface a(Context context, b.C0041b[] bVarArr, int i2) {
        FileInputStream fileInputStream;
        if (bVarArr.length <= 0) {
            return null;
        }
        b.C0041b a2 = a(bVarArr, i2);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.f2888a, "r", (CancellationSignal) null);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File a3 = a(openFileDescriptor);
                if (a3 != null) {
                    if (a3.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(a3);
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                        }
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface a4 = super.a(context, (InputStream) fileInputStream);
                fileInputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return a4;
            } catch (Throwable th) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        Object b2 = b();
        c.C0040c[] cVarArr = bVar.f2830a;
        int length = cVarArr.length;
        int i3 = 0;
        while (i3 < length) {
            c.C0040c cVar = cVarArr[i3];
            File a2 = k.a(context);
            if (a2 == null) {
                return null;
            }
            try {
                if (!k.a(a2, resources, cVar.f2836f)) {
                    a2.delete();
                    return null;
                } else if (!a(b2, a2.getPath(), cVar.f2832b, cVar.f2833c)) {
                    return null;
                } else {
                    a2.delete();
                    i3++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                a2.delete();
            }
        }
        return a(b2);
    }
}
