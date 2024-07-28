package com.google.android.play.core.d.b;

import com.google.android.play.core.d.a;
import com.google.android.play.core.d.c;
import com.google.android.play.core.d.d;
import java.util.ArrayList;

final class f implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f37387a;

    f(c cVar) {
        this.f37387a = cVar;
    }

    public final d a(d dVar) {
        if (dVar != null) {
            int b2 = dVar.b();
            if (!(b2 == 0 || b2 == 5 || b2 == 6 || b2 == 7)) {
                throw new a(-1);
            }
        }
        return d.a(dVar != null ? 1 + dVar.a() : 1, 1, 0, 0, 0, this.f37387a.f37402a, new ArrayList());
    }
}
