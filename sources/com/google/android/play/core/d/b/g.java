package com.google.android.play.core.d.b;

import com.google.android.play.core.d.a;
import com.google.android.play.core.d.d;

final class g implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f37388a;

    g(int i2) {
        this.f37388a = i2;
    }

    public final d a(d dVar) {
        if (dVar != null && this.f37388a == dVar.a() && dVar.b() == 1) {
            return d.a(this.f37388a, 7, dVar.c(), dVar.d(), dVar.e(), dVar.f(), dVar.g());
        }
        throw new a(-3);
    }
}
