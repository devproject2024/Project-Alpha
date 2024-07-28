package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final androidx.a.a<String, Method> f4930a;

    /* renamed from: b  reason: collision with root package name */
    protected final androidx.a.a<String, Method> f4931b;

    /* renamed from: c  reason: collision with root package name */
    protected final androidx.a.a<String, Class> f4932c;

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void a(int i2);

    /* access modifiers changed from: protected */
    public abstract void a(Parcelable parcelable);

    /* access modifiers changed from: protected */
    public abstract void a(CharSequence charSequence);

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    /* access modifiers changed from: protected */
    public abstract void a(boolean z);

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract a b();

    /* access modifiers changed from: protected */
    public abstract boolean b(int i2);

    /* access modifiers changed from: protected */
    public abstract int c();

    /* access modifiers changed from: protected */
    public abstract void c(int i2);

    /* access modifiers changed from: protected */
    public abstract String d();

    /* access modifiers changed from: protected */
    public abstract byte[] e();

    /* access modifiers changed from: protected */
    public abstract CharSequence f();

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T g();

    /* access modifiers changed from: protected */
    public abstract boolean h();

    public a(androidx.a.a<String, Method> aVar, androidx.a.a<String, Method> aVar2, androidx.a.a<String, Class> aVar3) {
        this.f4930a = aVar;
        this.f4931b = aVar2;
        this.f4932c = aVar3;
    }

    public final void a(boolean z, int i2) {
        c(i2);
        a(z);
    }

    public final void b(byte[] bArr) {
        c(2);
        a(bArr);
    }

    public final void a(CharSequence charSequence, int i2) {
        c(i2);
        a(charSequence);
    }

    public final void a(int i2, int i3) {
        c(i3);
        a(i2);
    }

    public final void b(String str) {
        c(7);
        a(str);
    }

    public final void a(Parcelable parcelable, int i2) {
        c(i2);
        a(parcelable);
    }

    public final boolean b(boolean z, int i2) {
        if (!b(i2)) {
            return z;
        }
        return h();
    }

    public final int b(int i2, int i3) {
        if (!b(i3)) {
            return i2;
        }
        return c();
    }

    public final String c(String str) {
        if (!b(7)) {
            return str;
        }
        return d();
    }

    public final byte[] c(byte[] bArr) {
        if (!b(2)) {
            return bArr;
        }
        return e();
    }

    public final <T extends Parcelable> T b(T t, int i2) {
        if (!b(i2)) {
            return t;
        }
        return g();
    }

    public final CharSequence b(CharSequence charSequence, int i2) {
        if (!b(i2)) {
            return charSequence;
        }
        return f();
    }

    public final void a(c cVar) {
        c(1);
        b(cVar);
    }

    /* access modifiers changed from: protected */
    public final void b(c cVar) {
        if (cVar == null) {
            a((String) null);
            return;
        }
        d(cVar);
        a b2 = b();
        a(cVar, b2);
        b2.a();
    }

    private void d(c cVar) {
        try {
            a(b((Class<? extends c>) cVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    public final <T extends c> T c(T t) {
        if (!b(1)) {
            return t;
        }
        return i();
    }

    /* access modifiers changed from: protected */
    public final <T extends c> T i() {
        String d2 = d();
        if (d2 == null) {
            return null;
        }
        return a(d2, b());
    }

    private <T extends c> void a(T t, a aVar) {
        try {
            a((Class) t.getClass()).invoke((Object) null, new Object[]{t, aVar});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    private Method a(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f4931b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class b2 = b((Class<? extends c>) cls);
        System.currentTimeMillis();
        Method declaredMethod = b2.getDeclaredMethod("write", new Class[]{cls, a.class});
        this.f4931b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private Class b(Class<? extends c> cls) throws ClassNotFoundException {
        Class cls2 = this.f4932c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f4932c.put(cls.getName(), cls3);
        return cls3;
    }

    private <T extends c> T a(String str, a aVar) {
        Class<a> cls = a.class;
        try {
            Method method = this.f4930a.get(str);
            if (method == null) {
                System.currentTimeMillis();
                method = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
                this.f4930a.put(str, method);
            }
            return (c) method.invoke((Object) null, new Object[]{aVar});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }
}
