package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final a f4517a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final c f4518b;

    private b(c cVar) {
        this.f4518b = cVar;
    }

    public final void a(Bundle bundle) {
        k lifecycle = this.f4518b.getLifecycle();
        if (lifecycle.a() == k.b.INITIALIZED) {
            lifecycle.a(new Recreator(this.f4518b));
            this.f4517a.a(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public final void b(Bundle bundle) {
        this.f4517a.a(bundle);
    }

    public static b a(c cVar) {
        return new b(cVar);
    }
}
