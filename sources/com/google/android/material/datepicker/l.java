package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class l<S> extends Fragment {
    protected final LinkedHashSet<k<S>> j = new LinkedHashSet<>();

    l() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(k<S> kVar) {
        return this.j.add(kVar);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.j.clear();
    }
}
