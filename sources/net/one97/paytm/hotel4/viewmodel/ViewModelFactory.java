package net.one97.paytm.hotel4.viewmodel;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;

public final class ViewModelFactory extends al.d {
    private final SharedViewModel shared;

    public final SharedViewModel getShared() {
        return this.shared;
    }

    public ViewModelFactory(SharedViewModel sharedViewModel) {
        k.c(sharedViewModel, "shared");
        this.shared = sharedViewModel;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (k.a((Object) cls, (Object) SRPViewModel.class)) {
            return (ai) new SRPViewModel(this.shared);
        }
        if (k.a((Object) cls, (Object) SRPSortViewModel.class)) {
            return (ai) new SRPSortViewModel(this.shared);
        }
        return (ai) cls.getDeclaredConstructor(new Class[]{SharedViewModel.class}).newInstance(new Object[]{this.shared});
    }
}
