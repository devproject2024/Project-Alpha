package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public final class al {

    /* renamed from: a  reason: collision with root package name */
    private final b f3643a;

    /* renamed from: b  reason: collision with root package name */
    private final an f3644b;

    public interface b {
        <T extends ai> T create(Class<T> cls);
    }

    static class e {
        /* access modifiers changed from: package-private */
        public void a(ai aiVar) {
        }

        e() {
        }
    }

    static abstract class c extends e implements b {
        public abstract <T extends ai> T a(String str, Class<T> cls);

        c() {
        }

        public <T extends ai> T create(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public al(androidx.lifecycle.ao r3) {
        /*
            r2 = this;
            androidx.lifecycle.an r0 = r3.getViewModelStore()
            boolean r1 = r3 instanceof androidx.lifecycle.j
            if (r1 == 0) goto L_0x000f
            androidx.lifecycle.j r3 = (androidx.lifecycle.j) r3
            androidx.lifecycle.al$b r3 = r3.getDefaultViewModelProviderFactory()
            goto L_0x0013
        L_0x000f:
            androidx.lifecycle.al$d r3 = androidx.lifecycle.al.d.getInstance()
        L_0x0013:
            r2.<init>((androidx.lifecycle.an) r0, (androidx.lifecycle.al.b) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.al.<init>(androidx.lifecycle.ao):void");
    }

    public al(ao aoVar, b bVar) {
        this(aoVar.getViewModelStore(), bVar);
    }

    public al(an anVar, b bVar) {
        this.f3643a = bVar;
        this.f3644b = anVar;
    }

    public final <T extends ai> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(canonicalName)), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final <T extends ai> T a(String str, Class<T> cls) {
        T t;
        T a2 = this.f3644b.a(str);
        if (cls.isInstance(a2)) {
            b bVar = this.f3643a;
            if (bVar instanceof e) {
                ((e) bVar).a(a2);
            }
            return a2;
        }
        b bVar2 = this.f3643a;
        if (bVar2 instanceof c) {
            t = ((c) bVar2).a(str, cls);
        } else {
            t = bVar2.create(cls);
        }
        this.f3644b.a(str, t);
        return t;
    }

    public static class d implements b {
        private static d sInstance;

        static d getInstance() {
            if (sInstance == null) {
                sInstance = new d();
            }
            return sInstance;
        }

        public <T extends ai> T create(Class<T> cls) {
            try {
                return (ai) cls.newInstance();
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
            }
        }
    }

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private static a f3645a;

        /* renamed from: b  reason: collision with root package name */
        private Application f3646b;

        public static a a(Application application) {
            if (f3645a == null) {
                f3645a = new a(application);
            }
            return f3645a;
        }

        public a(Application application) {
            this.f3646b = application;
        }

        public <T extends ai> T create(Class<T> cls) {
            if (!a.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                return (ai) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.f3646b});
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e5);
            }
        }
    }
}
