package com.google.android.gms.vision.a;

import com.google.android.gms.internal.vision.zzac;
import com.google.android.gms.internal.vision.zzaj;
import java.util.ArrayList;
import java.util.List;

public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private zzac f12535a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f12536b;

    b(zzac zzac) {
        this.f12535a = zzac;
    }

    public final String a() {
        return this.f12535a.f11285c;
    }

    public final List<? extends c> b() {
        if (this.f12535a.f11283a.length == 0) {
            return new ArrayList(0);
        }
        if (this.f12536b == null) {
            this.f12536b = new ArrayList(this.f12535a.f11283a.length);
            for (zzaj aVar : this.f12535a.f11283a) {
                this.f12536b.add(new a(aVar));
            }
        }
        return this.f12536b;
    }
}
