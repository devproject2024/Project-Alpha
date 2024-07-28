package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import androidx.lifecycle.q;
import androidx.savedstate.a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class Recreator implements i {

    /* renamed from: a  reason: collision with root package name */
    private final c f4509a;

    Recreator(c cVar) {
        this.f4509a = cVar;
    }

    public final void a(q qVar, k.a aVar) {
        if (aVar == k.a.ON_CREATE) {
            qVar.getLifecycle().b(this);
            Bundle a2 = this.f4509a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
            if (a2 != null) {
                ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it2 = stringArrayList.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        try {
                            Class<? extends U> asSubclass = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(a.C0071a.class);
                            try {
                                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    ((a.C0071a) declaredConstructor.newInstance(new Object[0])).a(this.f4509a);
                                } catch (Exception e2) {
                                    throw new RuntimeException("Failed to instantiate ".concat(String.valueOf(next)), e2);
                                }
                            } catch (NoSuchMethodException e3) {
                                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
                            }
                        } catch (ClassNotFoundException e4) {
                            throw new RuntimeException("Class " + next + " wasn't found", e4);
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }

    static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final Set<String> f4510a = new HashSet();

        a(a aVar) {
            aVar.a("androidx.savedstate.Restarter", (a.b) this);
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.f4510a));
            return bundle;
        }

        /* access modifiers changed from: package-private */
        public final void a(String str) {
            this.f4510a.add(str);
        }
    }
}
