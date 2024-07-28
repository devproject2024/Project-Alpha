package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

final class f implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f37504a;

    f(g gVar) {
        this.f37504a = gVar;
    }

    public final void a(l lVar, File file, boolean z) throws IOException {
        this.f37504a.f37506b.add(file);
        if (!z) {
            this.f37504a.f37507c.set(false);
        }
    }
}
