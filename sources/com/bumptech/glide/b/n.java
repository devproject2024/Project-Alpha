package com.bumptech.glide.b;

import com.bumptech.glide.e.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final Set<d> f6457a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public final List<d> f6458b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f6459c;

    public final boolean a(d dVar) {
        boolean z = true;
        if (dVar == null) {
            return true;
        }
        boolean remove = this.f6457a.remove(dVar);
        if (!this.f6458b.remove(dVar) && !remove) {
            z = false;
        }
        if (z) {
            dVar.b();
        }
        return z;
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.f6457a.size() + ", isPaused=" + this.f6459c + "}";
    }
}
