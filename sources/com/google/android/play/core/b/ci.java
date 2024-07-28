package com.google.android.play.core.b;

import com.google.android.play.core.c.a;
import java.util.HashSet;
import java.util.Set;

public final class ci<StateT> {

    /* renamed from: a  reason: collision with root package name */
    protected final Set<a<StateT>> f37301a = new HashSet();

    public final synchronized void a(a<StateT> aVar) {
        this.f37301a.add(aVar);
    }

    public final synchronized void a(StateT statet) {
        for (a<StateT> onStateUpdate : this.f37301a) {
            onStateUpdate.onStateUpdate(statet);
        }
    }
}
