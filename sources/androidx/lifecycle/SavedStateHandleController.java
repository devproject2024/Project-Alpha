package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.k;
import androidx.savedstate.a;
import androidx.savedstate.c;

final class SavedStateHandleController implements o {

    /* renamed from: a  reason: collision with root package name */
    final ad f3597a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3598b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3599c = false;

    private SavedStateHandleController(String str, ad adVar) {
        this.f3598b = str;
        this.f3597a = adVar;
    }

    private void a(androidx.savedstate.a aVar, k kVar) {
        if (!this.f3599c) {
            this.f3599c = true;
            kVar.a(this);
            aVar.a(this.f3598b, this.f3597a.f3617b);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    public final void a(q qVar, k.a aVar) {
        if (aVar == k.a.ON_DESTROY) {
            this.f3599c = false;
            qVar.getLifecycle().b(this);
        }
    }

    static SavedStateHandleController a(androidx.savedstate.a aVar, k kVar, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, ad.a(aVar.a(str), bundle));
        savedStateHandleController.a(aVar, kVar);
        b(aVar, kVar);
        return savedStateHandleController;
    }

    static final class a implements a.C0071a {
        a() {
        }

        public final void a(c cVar) {
            if (cVar instanceof ao) {
                an viewModelStore = ((ao) cVar).getViewModelStore();
                androidx.savedstate.a savedStateRegistry = cVar.getSavedStateRegistry();
                for (String a2 : viewModelStore.a()) {
                    SavedStateHandleController.a(viewModelStore.a(a2), savedStateRegistry, cVar.getLifecycle());
                }
                if (!viewModelStore.a().isEmpty()) {
                    savedStateRegistry.a((Class<? extends a.C0071a>) a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    static void a(ai aiVar, androidx.savedstate.a aVar, k kVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) aiVar.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.f3599c) {
            savedStateHandleController.a(aVar, kVar);
            b(aVar, kVar);
        }
    }

    private static void b(final androidx.savedstate.a aVar, final k kVar) {
        k.b a2 = kVar.a();
        if (a2 == k.b.INITIALIZED || a2.isAtLeast(k.b.STARTED)) {
            aVar.a((Class<? extends a.C0071a>) a.class);
        } else {
            kVar.a(new o() {
                public final void a(q qVar, k.a aVar) {
                    if (aVar == k.a.ON_START) {
                        kVar.b(this);
                        aVar.a((Class<? extends a.C0071a>) a.class);
                    }
                }
            });
        }
    }
}
