package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.k;
import androidx.savedstate.Recreator;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    boolean f4512a = true;

    /* renamed from: b  reason: collision with root package name */
    private androidx.arch.core.b.b<String, b> f4513b = new androidx.arch.core.b.b<>();

    /* renamed from: c  reason: collision with root package name */
    private Bundle f4514c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4515d;

    /* renamed from: e  reason: collision with root package name */
    private Recreator.a f4516e;

    /* renamed from: androidx.savedstate.a$a  reason: collision with other inner class name */
    public interface C0071a {
        void a(c cVar);
    }

    public interface b {
        Bundle a();
    }

    a() {
    }

    public final Bundle a(String str) {
        if (this.f4515d) {
            Bundle bundle = this.f4514c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f4514c.remove(str);
            if (this.f4514c.isEmpty()) {
                this.f4514c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public final void a(String str, b bVar) {
        if (this.f4513b.a(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void a(Class<? extends C0071a> cls) {
        if (this.f4512a) {
            if (this.f4516e == null) {
                this.f4516e = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f4516e.a(cls.getName());
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(k kVar, Bundle bundle) {
        if (!this.f4515d) {
            if (bundle != null) {
                this.f4514c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            kVar.a(new SavedStateRegistry$1(this));
            this.f4515d = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f4514c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        androidx.arch.core.b.b<K, V>.d a2 = this.f4513b.a();
        while (a2.hasNext()) {
            Map.Entry entry = (Map.Entry) a2.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
