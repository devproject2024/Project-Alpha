package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.al;
import androidx.savedstate.a;
import androidx.savedstate.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class ae extends al.c {

    /* renamed from: f  reason: collision with root package name */
    private static final Class<?>[] f3620f = {Application.class, ad.class};

    /* renamed from: g  reason: collision with root package name */
    private static final Class<?>[] f3621g = {ad.class};

    /* renamed from: a  reason: collision with root package name */
    private final Application f3622a;

    /* renamed from: b  reason: collision with root package name */
    private final al.a f3623b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f3624c;

    /* renamed from: d  reason: collision with root package name */
    private final k f3625d;

    /* renamed from: e  reason: collision with root package name */
    private final a f3626e;

    public ae(Application application, c cVar, Bundle bundle) {
        this.f3626e = cVar.getSavedStateRegistry();
        this.f3625d = cVar.getLifecycle();
        this.f3624c = bundle;
        this.f3622a = application;
        this.f3623b = al.a.a(application);
    }

    public final <T extends ai> T a(String str, Class<T> cls) {
        Constructor<T> constructor;
        T t;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        if (isAssignableFrom) {
            constructor = a(cls, f3620f);
        } else {
            constructor = a(cls, f3621g);
        }
        if (constructor == null) {
            return this.f3623b.create(cls);
        }
        SavedStateHandleController a2 = SavedStateHandleController.a(this.f3626e, this.f3625d, str, this.f3624c);
        if (isAssignableFrom) {
            try {
                t = (ai) constructor.newInstance(new Object[]{this.f3622a, a2.f3597a});
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access ".concat(String.valueOf(cls)), e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of ".concat(String.valueOf(cls)), e4.getCause());
            }
        } else {
            t = (ai) constructor.newInstance(new Object[]{a2.f3597a});
        }
        t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", a2);
        return t;
    }

    public final <T extends ai> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    private static <T> Constructor<T> a(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<T> constructor : cls.getConstructors()) {
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(ai aiVar) {
        SavedStateHandleController.a(aiVar, this.f3626e, this.f3625d);
    }
}
